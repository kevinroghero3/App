package org.xmlpull.mxp1;

import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class MXParserCachingStrings extends MXParser {
    private static final int CACHE_LOAD = 77;
    private static final boolean CACHE_STATISTICS = false;
    private static final int INITIAL_CAPACITY = 13;
    private static final boolean TRACE_SIZING = false;
    private static int globalCacheEntriesCount;
    private static int globalCacheEntriesThreshold;
    private static char[][] globalKeys;
    private static String[] globalValues;
    private int cacheEntriesCount;
    private int cacheEntriesThreshold;
    private int cacheStatCalls;
    private int cacheStatRehash;
    private int cacheStatResets;
    private int cacheStatWalks;
    private boolean global;
    private char[][] keys;
    private String[] values;

    public void finalize() {
    }

    public MXParserCachingStrings() {
        this.allStringsInterned = true;
    }

    @Override // org.xmlpull.mxp1.MXParser, org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) throws XmlPullParserException {
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            if (this.eventType != 0) {
                throw new XmlPullParserException("interning names feature can only be changed before parsing", this, null);
            }
            this.allStringsInterned = z;
            if (z || this.keys == null) {
                return;
            }
            resetStringCache();
            return;
        }
        super.setFeature(str, z);
    }

    @Override // org.xmlpull.mxp1.MXParser, org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            return this.allStringsInterned;
        }
        return super.getFeature(str);
    }

    @Override // org.xmlpull.mxp1.MXParser
    protected String newString(char[] cArr, int i, int i2) {
        if (this.allStringsInterned) {
            return newStringIntern(cArr, i, i2);
        }
        return super.newString(cArr, i, i2);
    }

    @Override // org.xmlpull.mxp1.MXParser
    protected String newStringIntern(char[] cArr, int i, int i2) {
        int i3;
        char[] cArr2;
        if (this.cacheEntriesCount >= this.cacheEntriesThreshold) {
            rehash();
        }
        int iFastHash = MXParser.fastHash(cArr, i, i2);
        int length = this.keys.length;
        while (true) {
            i3 = iFastHash % length;
            cArr2 = this.keys[i3];
            if (cArr2 == null || keysAreEqual(cArr2, 0, cArr2.length, cArr, i, i2)) {
                break;
            }
            iFastHash = i3 + 1;
            length = this.keys.length;
        }
        if (cArr2 != null) {
            return this.values[i3];
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        String strIntern = new String(cArr3).intern();
        this.keys[i3] = cArr3;
        this.values[i3] = strIntern;
        this.cacheEntriesCount++;
        return strIntern;
    }

    protected void initStringCache() {
        if (this.keys == null) {
            this.cacheEntriesThreshold = 10;
            this.keys = new char[13][];
            this.values = new String[13];
            this.cacheEntriesCount = 0;
        }
    }

    @Override // org.xmlpull.mxp1.MXParser
    protected void resetStringCache() {
        initStringCache();
    }

    private void rehash() {
        int length = (this.keys.length * 2) + 1;
        int i = (length * CACHE_LOAD) / 100;
        this.cacheEntriesThreshold = i;
        if (i >= length) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("internal error: threshold must be less than capacity: ");
            stringBuffer.append(length);
            throw new RuntimeException(stringBuffer.toString());
        }
        char[][] cArr = new char[length][];
        String[] strArr = new String[length];
        int i2 = 0;
        while (true) {
            char[][] cArr2 = this.keys;
            if (i2 < cArr2.length) {
                char[] cArr3 = cArr2[i2];
                cArr2[i2] = null;
                String[] strArr2 = this.values;
                String str = strArr2[i2];
                strArr2[i2] = null;
                if (cArr3 != null) {
                    int iFastHash = MXParser.fastHash(cArr3, 0, cArr3.length);
                    while (true) {
                        int i3 = iFastHash % length;
                        char[] cArr4 = cArr[i3];
                        if (cArr4 != null) {
                            if (keysAreEqual(cArr4, 0, cArr4.length, cArr3, 0, cArr3.length)) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("internal cache error: duplicated keys: ");
                                stringBuffer2.append(new String(cArr4));
                                stringBuffer2.append(" and ");
                                stringBuffer2.append(new String(cArr3));
                                throw new RuntimeException(stringBuffer2.toString());
                            }
                            iFastHash = i3 + 1;
                        } else {
                            cArr[i3] = cArr3;
                            strArr[i3] = str;
                            break;
                        }
                    }
                }
                i2++;
            } else {
                this.keys = cArr;
                this.values = strArr;
                return;
            }
        }
    }

    private static final boolean keysAreEqual(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
        if (i2 != i4) {
            return false;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            if (cArr[i + i5] != cArr2[i3 + i5]) {
                return false;
            }
        }
        return true;
    }
}
