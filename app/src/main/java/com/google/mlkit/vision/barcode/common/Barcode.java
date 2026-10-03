package com.google.mlkit.vision.barcode.common;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.onPostMessage;

/* JADX INFO: loaded from: classes.dex */
public class Barcode {
    public static final int FORMAT_ALL_FORMATS = 0;
    public static final int FORMAT_AZTEC = 4096;
    public static final int FORMAT_CODABAR = 8;
    public static final int FORMAT_CODE_128 = 1;
    public static final int FORMAT_CODE_39 = 2;
    public static final int FORMAT_CODE_93 = 4;
    public static final int FORMAT_DATA_MATRIX = 16;
    public static final int FORMAT_EAN_13 = 32;
    public static final int FORMAT_EAN_8 = 64;
    public static final int FORMAT_ITF = 128;
    public static final int FORMAT_PDF417 = 2048;
    public static final int FORMAT_QR_CODE = 256;
    public static final int FORMAT_UNKNOWN = -1;
    public static final int FORMAT_UPC_A = 512;
    public static final int FORMAT_UPC_E = 1024;
    public static final int TYPE_CALENDAR_EVENT = 11;
    public static final int TYPE_CONTACT_INFO = 1;
    public static final int TYPE_DRIVER_LICENSE = 12;
    public static final int TYPE_EMAIL = 2;
    public static final int TYPE_GEO = 10;
    public static final int TYPE_ISBN = 3;
    public static final int TYPE_PHONE = 4;
    public static final int TYPE_PRODUCT = 5;
    public static final int TYPE_SMS = 6;
    public static final int TYPE_TEXT = 7;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 8;
    public static final int TYPE_WIFI = 9;
    private final BarcodeSource zza;
    private final Rect zzb;
    private final Point[] zzc;

    /* JADX INFO: loaded from: classes5.dex */
    public static class Address {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final int zza;
        private final String[] zzb;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.CLASS)
        public @interface AddressType {
        }

        public Address(int i, @NonNull String[] strArr) {
            this.zza = i;
            this.zzb = strArr;
        }

        public String[] getAddressLines() {
            return this.zzb;
        }

        public int getType() {
            return this.zza;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BarcodeFormat {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BarcodeValueType {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class CalendarDateTime {
        private final int zza;
        private final int zzb;
        private final int zzc;
        private final int zzd;
        private final int zze;
        private final int zzf;
        private final boolean zzg;
        private final String zzh;

        public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, boolean z, @Nullable String str) {
            this.zza = i;
            this.zzb = i2;
            this.zzc = i3;
            this.zzd = i4;
            this.zze = i5;
            this.zzf = i6;
            this.zzg = z;
            this.zzh = str;
        }

        public int getDay() {
            return this.zzc;
        }

        public int getHours() {
            return this.zzd;
        }

        public int getMinutes() {
            return this.zze;
        }

        public int getMonth() {
            return this.zzb;
        }

        public String getRawValue() {
            return this.zzh;
        }

        public int getSeconds() {
            return this.zzf;
        }

        public int getYear() {
            return this.zza;
        }

        public boolean isUtc() {
            return this.zzg;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class CalendarEvent {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final CalendarDateTime zzf;
        private final CalendarDateTime zzg;

        public CalendarEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable CalendarDateTime calendarDateTime, @Nullable CalendarDateTime calendarDateTime2) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = calendarDateTime;
            this.zzg = calendarDateTime2;
        }

        public String getDescription() {
            return this.zzb;
        }

        public CalendarDateTime getEnd() {
            return this.zzg;
        }

        public String getLocation() {
            return this.zzc;
        }

        public String getOrganizer() {
            return this.zzd;
        }

        public CalendarDateTime getStart() {
            return this.zzf;
        }

        public String getStatus() {
            return this.zze;
        }

        public String getSummary() {
            return this.zza;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class ContactInfo {
        private final PersonName zza;
        private final String zzb;
        private final String zzc;
        private final List zzd;
        private final List zze;
        private final List zzf;
        private final List zzg;

        public ContactInfo(@Nullable PersonName personName, @Nullable String str, @Nullable String str2, @NonNull List<Phone> list, @NonNull List<Email> list2, @NonNull List<String> list3, @NonNull List<Address> list4) {
            this.zza = personName;
            this.zzb = str;
            this.zzc = str2;
            this.zzd = list;
            this.zze = list2;
            this.zzf = list3;
            this.zzg = list4;
        }

        public List<Address> getAddresses() {
            return this.zzg;
        }

        public List<Email> getEmails() {
            return this.zze;
        }

        public PersonName getName() {
            return this.zza;
        }

        public String getOrganization() {
            return this.zzb;
        }

        public List<Phone> getPhones() {
            return this.zzd;
        }

        public String getTitle() {
            return this.zzc;
        }

        public List<String> getUrls() {
            return this.zzf;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class DriverLicense {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final String zzf;
        private final String zzg;
        private final String zzh;
        private final String zzi;
        private final String zzj;
        private final String zzk;
        private final String zzl;
        private final String zzm;
        private final String zzn;

        public DriverLicense(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = str6;
            this.zzg = str7;
            this.zzh = str8;
            this.zzi = str9;
            this.zzj = str10;
            this.zzk = str11;
            this.zzl = str12;
            this.zzm = str13;
            this.zzn = str14;
        }

        public String getAddressCity() {
            return this.zzg;
        }

        public String getAddressState() {
            return this.zzh;
        }

        public String getAddressStreet() {
            return this.zzf;
        }

        public String getAddressZip() {
            return this.zzi;
        }

        public String getBirthDate() {
            return this.zzm;
        }

        public String getDocumentType() {
            return this.zza;
        }

        public String getExpiryDate() {
            return this.zzl;
        }

        public String getFirstName() {
            return this.zzb;
        }

        public String getGender() {
            return this.zze;
        }

        public String getIssueDate() {
            return this.zzk;
        }

        public String getIssuingCountry() {
            return this.zzn;
        }

        public String getLastName() {
            return this.zzd;
        }

        public String getLicenseNumber() {
            return this.zzj;
        }

        public String getMiddleName() {
            return this.zzc;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class Email {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final int zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.CLASS)
        public @interface FormatType {
        }

        public Email(int i, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.zza = i;
            this.zzb = str;
            this.zzc = str2;
            this.zzd = str3;
        }

        public String getAddress() {
            return this.zzb;
        }

        public String getBody() {
            return this.zzd;
        }

        public String getSubject() {
            return this.zzc;
        }

        public int getType() {
            return this.zza;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class GeoPoint {
        private final double zza;
        private final double zzb;

        public GeoPoint(double d, double d2) {
            this.zza = d;
            this.zzb = d2;
        }

        public double getLat() {
            return this.zza;
        }

        public double getLng() {
            return this.zzb;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class PersonName {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final String zzf;
        private final String zzg;

        public PersonName(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = str6;
            this.zzg = str7;
        }

        public String getFirst() {
            return this.zzd;
        }

        public String getFormattedName() {
            return this.zza;
        }

        public String getLast() {
            return this.zzf;
        }

        public String getMiddle() {
            return this.zze;
        }

        public String getPrefix() {
            return this.zzc;
        }

        public String getPronunciation() {
            return this.zzb;
        }

        public String getSuffix() {
            return this.zzg;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class Phone {
        public static final int TYPE_FAX = 3;
        public static final int TYPE_HOME = 2;
        public static final int TYPE_MOBILE = 4;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final String zza;
        private final int zzb;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.CLASS)
        public @interface FormatType {
        }

        public Phone(@Nullable String str, int i) {
            this.zza = str;
            this.zzb = i;
        }

        public String getNumber() {
            return this.zza;
        }

        public int getType() {
            return this.zzb;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class Sms {
        private final String zza;
        private final String zzb;

        public Sms(@Nullable String str, @Nullable String str2) {
            this.zza = str;
            this.zzb = str2;
        }

        public String getMessage() {
            return this.zza;
        }

        public String getPhoneNumber() {
            return this.zzb;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class WiFi {
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_WEP = 3;
        public static final int TYPE_WPA = 2;
        private final String zza;
        private final String zzb;
        private final int zzc;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.CLASS)
        public @interface EncryptionType {
        }

        public WiFi(@Nullable String str, @Nullable String str2, int i) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = i;
        }

        public int getEncryptionType() {
            return this.zzc;
        }

        public String getPassword() {
            return this.zzb;
        }

        public String getSsid() {
            return this.zza;
        }
    }

    public Barcode(@NonNull BarcodeSource barcodeSource) {
        this(barcodeSource, null);
    }

    public Rect getBoundingBox() {
        return this.zzb;
    }

    public CalendarEvent getCalendarEvent() {
        return this.zza.getCalendarEvent();
    }

    public ContactInfo getContactInfo() {
        return this.zza.getContactInfo();
    }

    public Point[] getCornerPoints() {
        return this.zzc;
    }

    public String getDisplayValue() {
        return this.zza.getDisplayValue();
    }

    public DriverLicense getDriverLicense() {
        return this.zza.getDriverLicense();
    }

    public Email getEmail() {
        return this.zza.getEmail();
    }

    public int getFormat() {
        int format = this.zza.getFormat();
        if (format > 4096 || format == 0) {
            return -1;
        }
        return format;
    }

    public GeoPoint getGeoPoint() {
        return this.zza.getGeoPoint();
    }

    public Phone getPhone() {
        return this.zza.getPhone();
    }

    public byte[] getRawBytes() {
        byte[] rawBytes = this.zza.getRawBytes();
        if (rawBytes != null) {
            return Arrays.copyOf(rawBytes, rawBytes.length);
        }
        return null;
    }

    public String getRawValue() {
        return this.zza.getRawValue();
    }

    public Sms getSms() {
        return this.zza.getSms();
    }

    public UrlBookmark getUrl() {
        return this.zza.getUrl();
    }

    public int getValueType() {
        return this.zza.getValueType();
    }

    public WiFi getWifi() {
        return this.zza.getWifi();
    }

    public Barcode(@NonNull BarcodeSource barcodeSource, @Nullable Matrix matrix) {
        this.zza = (BarcodeSource) Preconditions.checkNotNull(barcodeSource);
        Rect boundingBox = barcodeSource.getBoundingBox();
        if (boundingBox != null && matrix != null) {
            CommonConvertUtils.transformRect(boundingBox, matrix);
        }
        this.zzb = boundingBox;
        Point[] cornerPoints = barcodeSource.getCornerPoints();
        if (cornerPoints != null && matrix != null) {
            CommonConvertUtils.transformPointArray(cornerPoints, matrix);
        }
        this.zzc = cornerPoints;
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class UrlBookmark {
        private final String zza;
        private final String zzb;
        private static final byte[] $$c = {53, -94, -28, -114};
        private static final int $$d = 237;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {4, Ascii.VT, 101, -73, Ascii.FF, 6, -27, Ascii.SYN, Ascii.SUB, -4, Ascii.FF, 0, 8, 2, 8};
        private static final int $$b = 122;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] IPostMessageService = {38365, 38271, 38265, 38265, 38173, 38166, 38265, 38264, 38166, 38183, 38151, 38262, 38266, 38160, 38153, 38263, 38270, 38271, 38265, 38307, 38285, 38278, 38386, 38379, 38287, 38359, 38354, 38359, 38285, 38358, 38356, 38369, 38363, 38355, 38361, 38278, 38355, 38363, 38358, 38382, 38284, 38282, 38379, 38382, 38287, 38356, 38356, 38392, 38383, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38383, 38350, 38357, 38363, 38391, 38278, 38395, 38394, 38377, 38358, 38368, 38375, 38358, 38358, 38360, 38358, 38355, 38355, 38356, 38365, 38366, 38357, 38363, 38361, 38308, 38282, 38284, 38288, 38280, 38395, 38386, 38277, 38348, 38354, 38353, 38345, 38380, 38275, 38375, 38352, 38363, 38375, 38362, 38354, 38371, 38377, 38358, 38358, 38356, 38358, 38357, 38350, 38351, 38353, 38362, 38356, 38356, 38392, 38383, 38355, 38363, 38200, 38059, 38051, 38056, 38063, 38063, 38064, 38068, 38060, 38058, 38209, 38211, 38068, 38059, 38053, 38054, 38049, 38053, 38065, 38059, 38059, 38223, 38214, 38058, 38066, 38058, 38051, 38057, 38056, 38048, 38211, 38222, 38066, 38059, 38051, 38213, 38238, 38285, 38355, 38357, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38279, 38382, 38348, 38356, 38363, 38391, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356, 38356, 38362, 38342, 38224, 38229, 38229, 38229, 38228, 38228, 38225, 38223, 38227, 38227, 38227, 38229, 38229, 38229, 38227, 38227, 38229, 38229, 38226, 38226, 38228, 38228, 38229, 38273, 38340, 38206, 38350, 38348, 38196, 38206, 38337, 38202, 38204, 38206, 38204, 38344, 38351, 38340, 38202, 38205, 38278, 38356, 38362, 38361, 38354, 38372, 38380, 38355, 38345, 38370, 38279, 38385, 38355, 38356, 38385, 38392, 38356, 38356, 38362, 38282, 38362, 38356, 38356, 38392, 38385, 38356, 38355, 38385, 38279, 38372, 38354, 38361, 38362, 38356, 38281, 38357, 38356, 38356, 38353, 38282, 38359, 38357, 38353, 38370, 38274, 38389, 38357, 38360, 38361, 38386, 38392, 38356, 38356, 38277, 38345, 38353, 38355, 38350, 38353, 38374, 38279, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38297, 38376, 38360, 38360, 38363, 38361, 38356, 38355, 38361, 38355, 38365, 38375, 38365, 38360, 38361, 38363, 38361, 38345, 38233, 38238, 38240, 38237, 38237, 38253, 38251, 38238, 38240, 38238, 38237, 38242, 38252, 38149, 38263, 38230, 38261, 38259, 38227, 38235, 38232, 38227, 38230, 38235, 38268, 38267, 38238, 38232, 38228, 38233, 38235, 38237, 38284, 38361, 38355, 38365, 38375, 38365, 38360, 38361, 38363, 38361, 38376, 38372, 38357, 38357, 38297, 38391, 38275, 38285, 38361, 38355, 38351, 38356, 38358, 38360, 38359, 38357, 38357, 38372, 38376, 38361, 38363, 38361, 38360, 38365, 38375, 38272, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38201, 38071, 38065, 38065, 38229, 38220, 38064, 38072, 38064, 38057, 38063, 38062, 38054, 38217, 38239, 38211, 38064, 38057, 38066, 38072, 38070, 38216, 38214, 38068, 38070, 38064, 38057};
        private static int[] ICustomTabsCallbackStub = {-2051107009, -970576296, -438721791, -622660022, 987737987, 987557517, 70154605, 188477393, -353926155, -970049891, -2036334690, 340591184, 2087474256, 640968982, -440456741, -650193513, 1211923545, 716554789};

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r5, int r6, short r7) {
            /*
                int r7 = r7 + 65
                byte[] r0 = com.google.mlkit.vision.barcode.common.Barcode.UrlBookmark.$$c
                int r5 = r5 * 3
                int r1 = r5 + 1
                int r6 = r6 * 3
                int r6 = r6 + 4
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r4 = r7
                r3 = r2
                r7 = r5
                goto L25
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r5) goto L21
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                return r5
            L21:
                int r3 = r3 + 1
                r4 = r0[r6]
            L25:
                int r6 = r6 + 1
                int r7 = r7 + r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.barcode.common.Barcode.UrlBookmark.$$e(byte, int, short):java.lang.String");
        }

        public UrlBookmark(@Nullable String str, @Nullable String str2) {
            this.zza = str;
            this.zzb = str2;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0028  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void c(int r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 8
                int r7 = 11 - r7
                byte[] r0 = com.google.mlkit.vision.barcode.common.Barcode.UrlBookmark.$$a
                int r8 = r8 * 5
                int r1 = 9 - r8
                int r6 = r6 * 3
                int r6 = r6 + 112
                byte[] r1 = new byte[r1]
                int r8 = 8 - r8
                r2 = 0
                if (r0 != 0) goto L18
                r3 = r7
                r4 = r2
                goto L30
            L18:
                r3 = r2
            L19:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r7 = r7 + 1
                if (r3 != r8) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L28:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r3
                r3 = r7
                r7 = r4
                r4 = r5
            L30:
                int r6 = r6 + r7
                int r6 = r6 + (-7)
                r7 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.barcode.common.Barcode.UrlBookmark.c(int, int, int, java.lang.Object[]):void");
        }

        public String getTitle() {
            return this.zza;
        }

        public String getUrl() {
            return this.zzb;
        }

        private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
            int length;
            int[] iArr2;
            int i2 = 2 % 2;
            artificialFrame artificialframe = new artificialFrame();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr3 = ICustomTabsCallbackStub;
            int i3 = -1780896814;
            int i4 = 16;
            int i5 = 1;
            int i6 = 0;
            if (iArr3 != null) {
                int length2 = iArr3.length;
                int[] iArr4 = new int[length2];
                int i7 = 0;
                while (i7 < length2) {
                    int i8 = $11 + 125;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr3[i7])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> i4) + 11, (char) View.MeasureSpec.getMode(0), 1562 - View.combineMeasuredStates(0, 0), 180153818, false, $$e(b, b2, (byte) (b2 | 44)), new Class[]{Integer.TYPE});
                        }
                        iArr4[i7] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        i7++;
                        i3 = -1780896814;
                        i4 = 16;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                iArr3 = iArr4;
            }
            int length3 = iArr3.length;
            int[] iArr5 = new int[length3];
            int[] iArr6 = ICustomTabsCallbackStub;
            if (iArr6 != null) {
                int i10 = $10 + 71;
                $11 = i10 % 128;
                if (i10 % 2 == 0) {
                    length = iArr6.length;
                    iArr2 = new int[length];
                } else {
                    length = iArr6.length;
                    iArr2 = new int[length];
                }
                int i11 = 0;
                while (i11 < length) {
                    int i12 = $11 + 19;
                    $10 = i12 % 128;
                    if (i12 % 2 != 0) {
                        Object[] objArr3 = new Object[i5];
                        objArr3[i6] = Integer.valueOf(iArr6[i11]);
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame2 == null) {
                            int iNormalizeMetaState = KeyEvent.normalizeMetaState(i6) + 11;
                            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', i6, i6) + i5);
                            int iIndexOf = TextUtils.indexOf("", "", i6) + 1562;
                            byte b3 = (byte) i6;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cLastIndexOf, iIndexOf, 180153818, false, $$e(b3, b4, (byte) (b4 | 44)), new Class[]{Integer.TYPE});
                        }
                        iArr2[i11] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    } else {
                        length = length;
                        Object[] objArr4 = {Integer.valueOf(iArr6[i11])};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777227, (char) ((-1) - TextUtils.lastIndexOf("", '0')), 1562 - TextUtils.getOffsetBefore("", 0), 180153818, false, $$e(b5, b6, (byte) (b6 | 44)), new Class[]{Integer.TYPE});
                        }
                        iArr2[i11] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                        i11++;
                    }
                    length = length;
                    i5 = 1;
                    i6 = 0;
                }
                iArr6 = iArr2;
            }
            int i13 = i6;
            System.arraycopy(iArr6, i13, iArr5, i13, length3);
            artificialframe.e = i13;
            while (artificialframe.e < iArr.length) {
                cArr[i13] = (char) (iArr[artificialframe.e] >> 16);
                cArr[1] = (char) iArr[artificialframe.e];
                cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                cArr[3] = (char) iArr[artificialframe.e + 1];
                artificialframe.c = (cArr[0] << 16) + cArr[1];
                artificialframe.b = (cArr[2] << 16) + cArr[3];
                artificialFrame.coroutineBoundary(iArr5);
                int i14 = 0;
                for (int i15 = 16; i14 < i15; i15 = 16) {
                    artificialframe.c ^= iArr5[i14];
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getTouchSlop() >> 8), (char) Color.blue(0), 1040 - Process.getGidForName(""), 995482881, false, $$e(b7, b8, (byte) (b8 | 50)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i14++;
                }
                int i16 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i16;
                artificialframe.b ^= iArr5[16];
                artificialframe.c ^= iArr5[17];
                int i17 = artificialframe.c;
                int i18 = artificialframe.b;
                cArr[0] = (char) (artificialframe.c >>> 16);
                cArr[1] = (char) artificialframe.c;
                cArr[2] = (char) (artificialframe.b >>> 16);
                cArr[3] = (char) artificialframe.b;
                artificialFrame.coroutineBoundary(iArr5);
                cArr2[artificialframe.e * 2] = cArr[0];
                cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                Object[] objArr6 = {artificialframe, artificialframe};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 37, (char) (28011 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), TextUtils.getOffsetAfter("", 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                i13 = 0;
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        private static void b(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
            int i;
            int i2 = 2 % 2;
            onPostMessage onpostmessage = new onPostMessage();
            int i3 = 0;
            int i4 = iArr[0];
            int i5 = iArr[1];
            int i6 = iArr[2];
            int i7 = iArr[3];
            char[] cArr = IPostMessageService;
            long j = 0;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                int i8 = 0;
                while (i8 < length) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i3] = Integer.valueOf(cArr[i8]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i3;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1)) + 10, (char) Color.blue(i3), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1562, 178318710, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr2[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i8++;
                        i3 = 0;
                        j = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i5];
            System.arraycopy(cArr, i4, cArr3, 0, i5);
            if (bArr != null) {
                int i9 = $10 + 59;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                char[] cArr4 = new char[i5];
                onpostmessage.a = 0;
                char c = 0;
                while (onpostmessage.a < i5) {
                    if (bArr[onpostmessage.a] == 1) {
                        int i11 = $10 + 15;
                        $11 = i11 % 128;
                        if (i11 % 2 == 0) {
                            int i12 = onpostmessage.a;
                            Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = b3;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - Color.red(0), (char) Gravity.getAbsoluteGravity(0, 0), 2442 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), -850656813, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i12] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                            int i13 = 57 / 0;
                        } else {
                            int i14 = onpostmessage.a;
                            Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.alpha(0) + 23, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), 2441 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), -850656813, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i14] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                        }
                    } else {
                        int i15 = onpostmessage.a;
                        Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (KeyEvent.getMaxKeyCode() >> 16), 1561 - ExpandableListView.getPackedPositionChild(0L), 1918398056, false, $$e(b7, b8, (byte) (b8 | 57)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i15] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                    }
                    c = cArr4[onpostmessage.a];
                    Object[] objArr6 = {onpostmessage, onpostmessage};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 21, (char) (29363 - ((Process.getThreadPriority(0) + 20) >> 6)), 215 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    int i16 = $11 + 77;
                    $10 = i16 % 128;
                    int i17 = i16 % 2;
                }
                cArr3 = cArr4;
            }
            if (i7 > 0) {
                char[] cArr5 = new char[i5];
                i = 0;
                System.arraycopy(cArr3, 0, cArr5, 0, i5);
                int i18 = i5 - i7;
                System.arraycopy(cArr5, 0, cArr3, i18, i7);
                System.arraycopy(cArr5, i7, cArr3, 0, i18);
            } else {
                i = 0;
            }
            if (z) {
                char[] cArr6 = new char[i5];
                onpostmessage.a = i;
                while (onpostmessage.a < i5) {
                    cArr6[onpostmessage.a] = cArr3[(i5 - onpostmessage.a) - 1];
                    onpostmessage.a++;
                    int i19 = $10 + 55;
                    $11 = i19 % 128;
                    if (i19 % 2 == 0) {
                        int i20 = 3 % 2;
                    }
                }
                cArr3 = cArr6;
            }
            if (i6 > 0) {
                int i21 = $11 + 37;
                $10 = i21 % 128;
                int i22 = i21 % 2;
                int i23 = 0;
                while (true) {
                    onpostmessage.a = i23;
                    if (onpostmessage.a >= i5) {
                        break;
                    }
                    cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                    i23 = onpostmessage.a + 1;
                }
            }
            objArr[0] = new String(cArr3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 36, insn: 0x0cd2: MOVE (r11 I:??[OBJECT, ARRAY]) = (r36 I:??[OBJECT, ARRAY]), block:B:231:0x0cd2 */
        /* JADX WARN: Type inference failed for: r10v164 */
        /* JADX WARN: Type inference failed for: r10v165 */
        /* JADX WARN: Type inference failed for: r10v166 */
        /* JADX WARN: Type inference failed for: r10v167 */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r10v30 */
        /* JADX WARN: Type inference failed for: r10v31 */
        /* JADX WARN: Type inference failed for: r10v32, types: [java.security.KeyStore] */
        /* JADX WARN: Type inference failed for: r10v34, types: [java.security.KeyStore] */
        /* JADX WARN: Type inference failed for: r10v35 */
        /* JADX WARN: Type inference failed for: r10v60 */
        /* JADX WARN: Type inference failed for: r10v61 */
        /* JADX WARN: Type inference failed for: r10v62 */
        /* JADX WARN: Type inference failed for: r10v63 */
        /* JADX WARN: Type inference failed for: r10v90, types: [java.lang.Object, java.security.KeyStore] */
        /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v22 */
        /* JADX WARN: Type inference failed for: r11v23 */
        /* JADX WARN: Type inference failed for: r11v24, types: [java.lang.CharSequence, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v25 */
        /* JADX WARN: Type inference failed for: r11v27 */
        /* JADX WARN: Type inference failed for: r11v30 */
        /* JADX WARN: Type inference failed for: r11v31 */
        /* JADX WARN: Type inference failed for: r11v32 */
        /* JADX WARN: Type inference failed for: r11v33 */
        /* JADX WARN: Type inference failed for: r11v34 */
        /* JADX WARN: Type inference failed for: r11v51 */
        /* JADX WARN: Type inference failed for: r11v55 */
        /* JADX WARN: Type inference failed for: r11v56, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v66 */
        /* JADX WARN: Type inference failed for: r11v67 */
        /* JADX WARN: Type inference failed for: r11v68 */
        /* JADX WARN: Type inference failed for: r11v69 */
        /* JADX WARN: Type inference failed for: r11v70 */
        /* JADX WARN: Type inference failed for: r11v71 */
        /* JADX WARN: Type inference failed for: r11v72 */
        /* JADX WARN: Type inference failed for: r11v73 */
        /* JADX WARN: Type inference failed for: r11v74 */
        /* JADX WARN: Type inference failed for: r11v75 */
        /* JADX WARN: Type inference failed for: r11v76 */
        /* JADX WARN: Type inference failed for: r1v305 */
        /* JADX WARN: Type inference failed for: r1v306, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v323 */
        /* JADX WARN: Type inference failed for: r1v347, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r1v351, types: [java.lang.Object, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v578 */
        /* JADX WARN: Type inference failed for: r21v10 */
        /* JADX WARN: Type inference failed for: r21v11 */
        /* JADX WARN: Type inference failed for: r21v14 */
        /* JADX WARN: Type inference failed for: r25v0 */
        /* JADX WARN: Type inference failed for: r25v1 */
        /* JADX WARN: Type inference failed for: r25v14 */
        /* JADX WARN: Type inference failed for: r25v15 */
        /* JADX WARN: Type inference failed for: r25v2 */
        /* JADX WARN: Type inference failed for: r25v3 */
        /* JADX WARN: Type inference failed for: r25v35 */
        /* JADX WARN: Type inference failed for: r25v36 */
        /* JADX WARN: Type inference failed for: r25v4 */
        /* JADX WARN: Type inference failed for: r25v44 */
        /* JADX WARN: Type inference failed for: r25v45 */
        /* JADX WARN: Type inference failed for: r25v46 */
        /* JADX WARN: Type inference failed for: r25v47 */
        /* JADX WARN: Type inference failed for: r25v48 */
        /* JADX WARN: Type inference failed for: r25v50 */
        /* JADX WARN: Type inference failed for: r25v51 */
        /* JADX WARN: Type inference failed for: r25v52 */
        /* JADX WARN: Type inference failed for: r25v53 */
        /* JADX WARN: Type inference failed for: r25v54 */
        /* JADX WARN: Type inference failed for: r25v55 */
        /* JADX WARN: Type inference failed for: r25v56 */
        /* JADX WARN: Type inference failed for: r25v57 */
        /* JADX WARN: Type inference failed for: r25v58 */
        /* JADX WARN: Type inference failed for: r25v59 */
        /* JADX WARN: Type inference failed for: r25v6 */
        /* JADX WARN: Type inference failed for: r25v60 */
        /* JADX WARN: Type inference failed for: r25v61 */
        /* JADX WARN: Type inference failed for: r25v62 */
        /* JADX WARN: Type inference failed for: r25v63 */
        /* JADX WARN: Type inference failed for: r25v7 */
        /* JADX WARN: Type inference failed for: r25v8 */
        /* JADX WARN: Type inference failed for: r25v9 */
        /* JADX WARN: Type inference failed for: r27v10 */
        /* JADX WARN: Type inference failed for: r27v15 */
        /* JADX WARN: Type inference failed for: r27v16 */
        /* JADX WARN: Type inference failed for: r27v2 */
        /* JADX WARN: Type inference failed for: r27v21 */
        /* JADX WARN: Type inference failed for: r27v22 */
        /* JADX WARN: Type inference failed for: r27v23 */
        /* JADX WARN: Type inference failed for: r27v26, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r27v27 */
        /* JADX WARN: Type inference failed for: r27v28 */
        /* JADX WARN: Type inference failed for: r27v29 */
        /* JADX WARN: Type inference failed for: r27v3 */
        /* JADX WARN: Type inference failed for: r27v30 */
        /* JADX WARN: Type inference failed for: r27v31 */
        /* JADX WARN: Type inference failed for: r27v32 */
        /* JADX WARN: Type inference failed for: r27v6 */
        /* JADX WARN: Type inference failed for: r27v7 */
        /* JADX WARN: Type inference failed for: r27v8 */
        /* JADX WARN: Type inference failed for: r2v202, types: [java.nio.LongBuffer[]] */
        /* JADX WARN: Type inference failed for: r2v203 */
        /* JADX WARN: Type inference failed for: r2v206 */
        /* JADX WARN: Type inference failed for: r2v207 */
        /* JADX WARN: Type inference failed for: r2v215 */
        /* JADX WARN: Type inference failed for: r2v298, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r2v504 */
        /* JADX WARN: Type inference failed for: r2v505 */
        /* JADX WARN: Type inference failed for: r3v102 */
        /* JADX WARN: Type inference failed for: r3v104 */
        /* JADX WARN: Type inference failed for: r3v158 */
        /* JADX WARN: Type inference failed for: r3v301 */
        /* JADX WARN: Type inference failed for: r3v302, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v537 */
        /* JADX WARN: Type inference failed for: r3v538 */
        /* JADX WARN: Type inference failed for: r3v539 */
        /* JADX WARN: Type inference failed for: r3v64 */
        /* JADX WARN: Type inference failed for: r3v65 */
        /* JADX WARN: Type inference failed for: r4v122 */
        /* JADX WARN: Type inference failed for: r4v123, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v514 */
        /* JADX WARN: Type inference failed for: r4v515 */
        /* JADX WARN: Type inference failed for: r4v92 */
        /* JADX WARN: Type inference failed for: r4v93, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v102 */
        /* JADX WARN: Type inference failed for: r5v103 */
        /* JADX WARN: Type inference failed for: r5v104 */
        /* JADX WARN: Type inference failed for: r5v107 */
        /* JADX WARN: Type inference failed for: r5v23 */
        /* JADX WARN: Type inference failed for: r5v24 */
        /* JADX WARN: Type inference failed for: r5v25, types: [int] */
        /* JADX WARN: Type inference failed for: r5v26 */
        /* JADX WARN: Type inference failed for: r5v27 */
        /* JADX WARN: Type inference failed for: r5v28 */
        /* JADX WARN: Type inference failed for: r5v37 */
        /* JADX WARN: Type inference failed for: r5v393 */
        /* JADX WARN: Type inference failed for: r5v394 */
        /* JADX WARN: Type inference failed for: r5v395 */
        /* JADX WARN: Type inference failed for: r5v396 */
        /* JADX WARN: Type inference failed for: r5v397 */
        /* JADX WARN: Type inference failed for: r5v398 */
        /* JADX WARN: Type inference failed for: r5v399 */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.nio.LongBuffer[]] */
        /* JADX WARN: Type inference failed for: r6v167, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r6v188, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r7v149, types: [java.lang.Object, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r7v50, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r8v133, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r8v175 */
        /* JADX WARN: Type inference failed for: r8v176, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v193 */
        /* JADX WARN: Type inference failed for: r8v194, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v202, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r8v30, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r8v43, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v480 */
        /* JADX WARN: Type inference failed for: r8v481 */
        /* JADX WARN: Type inference failed for: r8v482 */
        /* JADX WARN: Type inference failed for: r8v88, types: [java.lang.Object, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r9v126, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r9v205, types: [java.nio.LongBuffer] */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame(android.content.Context r41, java.lang.String[] r42, int r43, int r44, int r45) {
            /*
                Method dump skipped, instruction units count: 14858
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.barcode.common.Barcode.UrlBookmark.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
        }
    }
}
