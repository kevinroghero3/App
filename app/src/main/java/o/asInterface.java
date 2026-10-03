package o;

/* JADX INFO: loaded from: classes.dex */
public class asInterface {
    public static int ArtificialStackFrames(byte[] bArr) {
        int i = -2128831035;
        for (byte b : bArr) {
            i = (i ^ b) * 16777619;
        }
        return i;
    }

    public static String[] CoroutineDebuggingKt(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        switch (i) {
            case -2000798030:
                return new String[]{"c++_shared", "jsi"};
            case -1852789703:
            case -1738030044:
            case -1641501674:
            case -1390953364:
            case -1147611478:
            case -896116470:
            case -860837030:
            case -735906211:
            case -418439650:
            case -392195250:
            case 7639277:
            case 461678816:
            case 607375770:
            case 814581990:
            case 1203739388:
            case 1239792829:
            case 1994870249:
                return new String[0];
            case -1632449844:
            case -1060436007:
                return new String[]{"c++_shared"};
            case -1614716351:
                str = "pdfium";
                return new String[]{str};
            case -1582747198:
                str2 = "c++_shared";
                str3 = "jsi";
                str4 = "fbjni";
                str5 = "hermes";
                str6 = "reactnative";
                str7 = "rnworklets";
                return new String[]{str2, str3, str4, str5, str6, str7};
            case -1522252711:
                str2 = "c++_shared";
                str3 = "fbjni";
                str4 = "jsi";
                str5 = "hermes";
                str6 = "reactnative";
                str7 = "worklets";
                return new String[]{str2, str3, str4, str5, str6, str7};
            case -1462161069:
            case -511702942:
            case -417183306:
                return new String[]{"c++_shared", "jsi", "fbjni", "hermes", "reactnative"};
            case -1457477257:
                return new String[]{"c++_shared", "jsi", "fbjni"};
            case -946462525:
                return new String[]{"c++_shared", "fbjni", "jsi"};
            case -596409012:
                str = "sentry";
                return new String[]{str};
            case 1802910545:
                return new String[]{"c++_shared", "jsi", "fbjni", "reactnative"};
            default:
                return null;
        }
    }
}
