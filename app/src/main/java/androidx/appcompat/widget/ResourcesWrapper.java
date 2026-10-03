package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class ResourcesWrapper extends Resources {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Resources mResources;

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
    
        if ((r10 instanceof android.text.Spanned) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
    
        r0 = new android.text.SpannableString(r2);
        android.text.TextUtils.copySpansFrom((android.text.SpannedString) r10, 0, r2.length(), java.lang.Object.class, r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006c, code lost:
    
        r10 = androidx.appcompat.widget.ResourcesWrapper.getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
        androidx.appcompat.widget.ResourcesWrapper.artificialFrame = r10 % 128;
        r10 = r10 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0075, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
    
        if ((r10 instanceof android.text.Spanned) != false) goto L12;
     */
    @Override // android.content.res.Resources
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence getText(int r10) throws android.content.res.Resources.NotFoundException {
        /*
            r9 = this;
            r0 = 2
            int r1 = r0 % r0
            android.content.res.Resources r1 = r9.mResources
            java.lang.String r2 = r1.getString(r10)
            java.lang.String r3 = ".,.%"
            boolean r3 = r2.startsWith(r3)
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L14
            goto L75
        L14:
            int r3 = androidx.appcompat.widget.ResourcesWrapper.getARTIFICIAL_FRAME_PACKAGE_NAME
            int r3 = r3 + 63
            int r5 = r3 % 128
            androidx.appcompat.widget.ResourcesWrapper.artificialFrame = r5
            int r3 = r3 % r0
            r5 = 4
            r6 = 0
            java.lang.String r2 = r2.substring(r5)
            if (r3 != 0) goto L3e
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r9.a(r2, r3)
            r2 = r3[r6]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            java.lang.CharSequence r10 = r1.getText(r10)
            boolean r1 = r10 instanceof android.text.Spanned
            r3 = 20
            int r3 = r3 / r6
            if (r1 == 0) goto L6c
            goto L53
        L3e:
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r9.a(r2, r3)
            r2 = r3[r6]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            java.lang.CharSequence r10 = r1.getText(r10)
            boolean r1 = r10 instanceof android.text.Spanned
            if (r1 == 0) goto L6c
        L53:
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r2)
            r3 = r10
            android.text.SpannedString r3 = (android.text.SpannedString) r3
            r4 = 0
            int r5 = r2.length()
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r10 = r0
            android.text.SpannableString r10 = (android.text.SpannableString) r10
            r8 = 0
            r7 = r0
            android.text.TextUtils.copySpansFrom(r3, r4, r5, r6, r7, r8)
            r2 = r0
            goto L75
        L6c:
            int r10 = androidx.appcompat.widget.ResourcesWrapper.getARTIFICIAL_FRAME_PACKAGE_NAME
            int r10 = r10 + 59
            int r1 = r10 % 128
            androidx.appcompat.widget.ResourcesWrapper.artificialFrame = r1
            int r10 = r10 % r0
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourcesWrapper.getText(int):java.lang.CharSequence");
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int i2 = 2 % 2;
        int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
        artificialFrame = i3 % 128;
        int i4 = i3 % 2;
        String string = this.mResources.getString(i);
        if (!string.startsWith(".,.%")) {
            return string;
        }
        Object[] objArr = new Object[1];
        a(string.substring(4), objArr);
        String strIntern = ((String) objArr[0]).intern();
        int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
        artificialFrame = i5 % 128;
        int i6 = i5 % 2;
        return strIntern;
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        Locale locale;
        int i2 = 2 % 2;
        int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
        artificialFrame = i3 % 128;
        int i4 = i3 % 2;
        Resources resources = this.mResources;
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i5 % 128;
            int i6 = i5 % 2;
            LocaleList locales = configuration.getLocales();
            locale = i6 == 0 ? locales.get(1) : locales.get(0);
        } else {
            locale = configuration.locale;
        }
        String string = resources.getString(i);
        if (!(!string.startsWith(".,.%"))) {
            int i7 = artificialFrame + 29;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
            int i8 = i7 % 2;
            String strSubstring = string.substring(4);
            Object[] objArr2 = new Object[1];
            if (i8 != 0) {
                a(strSubstring, objArr2);
                string = ((String) objArr2[0]).intern();
                int i9 = 88 / 0;
            } else {
                a(strSubstring, objArr2);
                string = ((String) objArr2[0]).intern();
            }
        }
        return String.format(locale, string, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        return this.mResources.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        return this.mResources.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        return this.mResources.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        return this.mResources.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        return this.mResources.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        return this.mResources.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i);
    }

    final Drawable getDrawableCanonical(int i) throws Resources.NotFoundException {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawable(this.mResources, i, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i, i2, null);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i, i2, theme);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        return this.mResources.getMovie(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return this.mResources.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.mResources.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        return this.mResources.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        return this.mResources.getLayout(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        return this.mResources.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.mResources.getXml(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.mResources.getValue(i, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.mResources.getValueForDensity(i, i2, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.mResources.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.mResources.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }
}
