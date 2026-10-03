package com.bea.xml.stream;

import io.sentry.instrumentation.file.SentryFileReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

/* JADX INFO: loaded from: classes4.dex */
public class ReadOnlyNamespaceContextBase implements NamespaceContext {
    private String[] prefixes;
    private String[] uris;

    public ReadOnlyNamespaceContextBase(String[] strArr, String[] strArr2, int i) {
        String[] strArr3 = new String[i];
        this.prefixes = strArr3;
        this.uris = new String[i];
        System.arraycopy(strArr, 0, strArr3, 0, i);
        String[] strArr4 = this.uris;
        System.arraycopy(strArr2, 0, strArr4, 0, strArr4.length);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix may not be null.");
        }
        if (str.length() > 0) {
            for (int length = this.uris.length - 1; length >= 0; length--) {
                if (str.equals(this.prefixes[length])) {
                    return this.uris[length];
                }
            }
            if (XMLConstants.XML_NS_PREFIX.equals(str)) {
                return XMLConstants.XML_NS_URI;
            }
            if (XMLConstants.XMLNS_ATTRIBUTE.equals(str)) {
                return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
            }
            return null;
        }
        for (int length2 = this.uris.length - 1; length2 >= 0; length2--) {
            if (this.prefixes[length2] == null) {
                return this.uris[length2];
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("uri may not be null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("uri may not be empty string");
        }
        for (int length = this.uris.length - 1; length >= 0; length--) {
            if (str.equals(this.uris[length])) {
                String str2 = this.prefixes[length];
                if (str2 == null) {
                    for (int length2 = this.uris.length - 1; length2 > length; length2--) {
                        if (this.prefixes[length2] != null) {
                        }
                    }
                    return "";
                }
                for (int length3 = this.uris.length - 1; length3 > length; length3--) {
                    if (!str2.equals(this.prefixes[length3])) {
                    }
                }
                return str2;
            }
        }
        if (XMLConstants.XML_NS_URI.equals(str)) {
            return XMLConstants.XML_NS_PREFIX;
        }
        if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(str)) {
            return XMLConstants.XMLNS_ATTRIBUTE;
        }
        return null;
    }

    public String getDefaultNameSpace() {
        for (int length = this.uris.length - 1; length >= 0; length--) {
            if (this.prefixes[length] == null) {
                return this.uris[length];
            }
        }
        return null;
    }

    private String checkNull(String str) {
        return str == null ? "" : str;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator getPrefixes(String str) {
        if (str == null) {
            throw new IllegalArgumentException("uri may not be null");
        }
        if ("".equals(str)) {
            throw new IllegalArgumentException("uri may not be empty string");
        }
        HashSet hashSet = new HashSet();
        for (int length = this.uris.length - 1; length >= 0; length--) {
            String strCheckNull = checkNull(this.prefixes[length]);
            if (str.equals(this.uris[length]) && !hashSet.contains(strCheckNull)) {
                if (strCheckNull.length() == 0) {
                    int length2 = this.uris.length - 1;
                    while (true) {
                        if (length2 > length) {
                            if (this.prefixes[length2] == null) {
                                break;
                            }
                            length2--;
                        } else {
                            hashSet.add(strCheckNull);
                            break;
                        }
                    }
                } else {
                    int length3 = this.uris.length - 1;
                    while (true) {
                        if (length3 > length) {
                            if (strCheckNull.equals(this.prefixes[length3])) {
                                break;
                            }
                            length3--;
                        } else {
                            hashSet.add(strCheckNull);
                            break;
                            break;
                        }
                    }
                }
            }
        }
        return hashSet.iterator();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.uris.length; i++) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("[");
            stringBuffer2.append(checkNull(this.prefixes[i]));
            stringBuffer2.append("<->");
            stringBuffer2.append(this.uris[i]);
            stringBuffer2.append("]");
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] strArr) throws Exception {
        MXParser mXParser = new MXParser();
        mXParser.setInput(new SentryFileReader(strArr[0]));
        while (mXParser.hasNext()) {
            if (mXParser.isStartElement()) {
                PrintStream printStream = System.out;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("context[");
                stringBuffer.append(mXParser.getNamespaceContext());
                stringBuffer.append("]");
                printStream.println(stringBuffer.toString());
                Iterator prefixes = mXParser.getNamespaceContext().getPrefixes("a");
                while (prefixes.hasNext()) {
                    PrintStream printStream2 = System.out;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Found prefix:");
                    stringBuffer2.append(prefixes.next());
                    printStream2.println(stringBuffer2.toString());
                }
            }
            mXParser.next();
        }
    }
}
