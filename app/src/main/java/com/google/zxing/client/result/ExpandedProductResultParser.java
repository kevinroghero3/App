package com.google.zxing.client.result;

import ch.qos.logback.core.CoreConstants;
import com.google.common.base.Ascii;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class ExpandedProductResultParser extends ResultParser {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:167:0x024c  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v5 int, still in use, count: 10, list:
  (r3v5 int) from 0x0051: IF  (r3v5 int) != (1536 int)  -> B:13:0x0053 A[HIDDEN]
  (r3v5 int) from 0x0055: IF  (r3v5 int) != (1537 int)  -> B:15:0x0057 A[HIDDEN]
  (r3v5 int) from 0x0059: IF  (r3v5 int) != (1567 int)  -> B:17:0x005b A[HIDDEN]
  (r3v5 int) from 0x005d: IF  (r3v5 int) != (1568 int)  -> B:19:0x005f A[HIDDEN]
  (r3v5 int) from 0x0061: IF  (r3v5 int) != (1570 int)  -> B:21:0x0063 A[HIDDEN]
  (r3v5 int) from 0x0065: IF  (r3v5 int) != (1572 int)  -> B:23:0x0067 A[HIDDEN]
  (r3v5 int) from 0x0069: IF  (r3v5 int) != (1574 int)  -> B:25:0x006b A[HIDDEN]
  (r3v5 int) from 0x006e: SWITCH (r3v5 int)
 case 1568927: goto B:98:0x0167
 case 1568928: goto B:94:0x0159
 case 1568929: goto B:90:0x014b
 case 1568930: goto B:86:0x013d
 case 1568931: goto B:82:0x012f
 case 1568932: goto B:78:0x0121
 case 1568933: goto B:74:0x0113
 case 1568934: goto B:70:0x0105
 case 1568935: goto B:66:0x00f7
 case 1568936: goto B:62:0x00e9
 default: goto B:27:0x0071 A[RegionRef:SW:26]
  (r3v5 int) from 0x0071: SWITCH (r3v5 int)
 case 1575716: goto B:58:0x00db
 case 1575717: goto B:54:0x00cd
 case 1575718: goto B:50:0x00bf
 case 1575719: goto B:46:0x00b1
 default: goto B:28:0x0074 A[RegionRef:SW:27]
  (r3v5 int) from 0x0074: SWITCH (r3v5 int)
 case 1575747: goto B:42:0x00a3
 case 1575748: goto B:38:0x0095
 case 1575749: goto B:34:0x0087
 case 1575750: goto B:30:0x0079
 default: goto B:167:0x024c A[RegionRef:SW:28]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.zxing.client.result.ResultParser
    public ExpandedProductParsedResult parse(Result result) {
        String strSubstring;
        String str;
        ExpandedProductParsedResult expandedProductParsedResult = null;
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = ResultParser.getMassagedText(result);
        HashMap map = new HashMap();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String strSubstring2 = null;
        String strSubstring3 = null;
        String strSubstring4 = null;
        int i = 0;
        while (i < massagedText.length()) {
            String strFindAIvalue = findAIvalue(i, massagedText);
            if (strFindAIvalue == null) {
                return expandedProductParsedResult;
            }
            byte b = 2;
            int length = i + strFindAIvalue.length() + 2;
            String strFindValue = findValue(length, massagedText);
            int length2 = length + strFindValue.length();
            String str12 = strSubstring2;
            String str13 = str11;
            if (iHashCode != 1536) {
                if (iHashCode != 1537) {
                    if (iHashCode != 1567) {
                        if (iHashCode != 1568) {
                            if (iHashCode != 1570) {
                                if (iHashCode != 1572) {
                                    if (iHashCode != 1574) {
                                        switch (strFindAIvalue) {
                                            case "3100":
                                                b = 7;
                                                break;
                                            case "3101":
                                                b = 8;
                                                break;
                                            case "3102":
                                                b = 9;
                                                break;
                                            case "3103":
                                                b = 10;
                                                break;
                                            case "3104":
                                                b = Ascii.VT;
                                                break;
                                            case "3105":
                                                b = Ascii.FF;
                                                break;
                                            case "3106":
                                                b = Ascii.CR;
                                                break;
                                            case "3107":
                                                b = Ascii.SO;
                                                break;
                                            case "3108":
                                                b = Ascii.SI;
                                                break;
                                            case "3109":
                                                b = Ascii.DLE;
                                                break;
                                            default:
                                                switch (strFindAIvalue) {
                                                    case 1568927:
                                                        if (!strFindAIvalue.equals("3200")) {
                                                            b = -1;
                                                        } else {
                                                            b = 17;
                                                        }
                                                        break;
                                                    case 1568928:
                                                        if (!strFindAIvalue.equals("3201")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.DC2;
                                                        }
                                                        break;
                                                    case 1568929:
                                                        if (!strFindAIvalue.equals("3202")) {
                                                            b = -1;
                                                        } else {
                                                            b = 19;
                                                        }
                                                        break;
                                                    case 1568930:
                                                        if (!strFindAIvalue.equals("3203")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.DC4;
                                                        }
                                                        break;
                                                    case 1568931:
                                                        if (!strFindAIvalue.equals("3204")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.NAK;
                                                        }
                                                        break;
                                                    case 1568932:
                                                        if (!strFindAIvalue.equals("3205")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.SYN;
                                                        }
                                                        break;
                                                    case 1568933:
                                                        if (!strFindAIvalue.equals("3206")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.ETB;
                                                        }
                                                        break;
                                                    case 1568934:
                                                        if (!strFindAIvalue.equals("3207")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.CAN;
                                                        }
                                                        break;
                                                    case 1568935:
                                                        if (!strFindAIvalue.equals("3208")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.EM;
                                                        }
                                                        break;
                                                    case 1568936:
                                                        if (!strFindAIvalue.equals("3209")) {
                                                            b = -1;
                                                        } else {
                                                            b = Ascii.SUB;
                                                        }
                                                        break;
                                                    default:
                                                        switch (strFindAIvalue) {
                                                            case 1575716:
                                                                if (!strFindAIvalue.equals("3920")) {
                                                                    b = -1;
                                                                } else {
                                                                    b = Ascii.ESC;
                                                                }
                                                                break;
                                                            case 1575717:
                                                                if (!strFindAIvalue.equals("3921")) {
                                                                    b = -1;
                                                                } else {
                                                                    b = Ascii.FS;
                                                                }
                                                                break;
                                                            case 1575718:
                                                                if (!strFindAIvalue.equals("3922")) {
                                                                    b = -1;
                                                                } else {
                                                                    b = Ascii.GS;
                                                                }
                                                                break;
                                                            case 1575719:
                                                                if (!strFindAIvalue.equals("3923")) {
                                                                    b = -1;
                                                                } else {
                                                                    b = Ascii.RS;
                                                                }
                                                                break;
                                                            default:
                                                                switch (strFindAIvalue) {
                                                                    case 1575747:
                                                                        if (!strFindAIvalue.equals("3930")) {
                                                                            b = -1;
                                                                        } else {
                                                                            b = Ascii.US;
                                                                        }
                                                                        break;
                                                                    case 1575748:
                                                                        if (!strFindAIvalue.equals("3931")) {
                                                                            b = -1;
                                                                        } else {
                                                                            b = 32;
                                                                        }
                                                                        break;
                                                                    case 1575749:
                                                                        if (!strFindAIvalue.equals("3932")) {
                                                                            b = -1;
                                                                        } else {
                                                                            b = 33;
                                                                        }
                                                                        break;
                                                                    case 1575750:
                                                                        if (!strFindAIvalue.equals("3933")) {
                                                                            b = -1;
                                                                        } else {
                                                                            b = 34;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        b = -1;
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                        }
                                    } else if (strFindAIvalue.equals("17")) {
                                        b = 6;
                                    } else {
                                        b = -1;
                                    }
                                } else if (strFindAIvalue.equals("15")) {
                                    b = 5;
                                } else {
                                    b = -1;
                                }
                            } else if (strFindAIvalue.equals("13")) {
                                b = 4;
                            } else {
                                b = -1;
                            }
                        } else if (strFindAIvalue.equals("11")) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                    } else if (!strFindAIvalue.equals("10")) {
                        b = -1;
                    }
                } else if (strFindAIvalue.equals("01")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (strFindAIvalue.equals("00")) {
                b = 0;
            } else {
                b = -1;
            }
            switch (b) {
                case 0:
                    str3 = strFindValue;
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 1:
                    str2 = strFindValue;
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 2:
                    str4 = strFindValue;
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 3:
                    str5 = strFindValue;
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 4:
                    str6 = strFindValue;
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 5:
                    str7 = strFindValue;
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 6:
                    str8 = strFindValue;
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    strSubstring = strFindAIvalue.substring(3);
                    str = ExpandedProductParsedResult.KILOGRAM;
                    str11 = strSubstring;
                    str10 = str;
                    str9 = strFindValue;
                    strSubstring2 = str12;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    strSubstring = strFindAIvalue.substring(3);
                    str = ExpandedProductParsedResult.POUND;
                    str11 = strSubstring;
                    str10 = str;
                    str9 = strFindValue;
                    strSubstring2 = str12;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    strSubstring3 = strFindAIvalue.substring(3);
                    strSubstring2 = strFindValue;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    if (strFindValue.length() < 4) {
                        return null;
                    }
                    strSubstring2 = strFindValue.substring(3);
                    strSubstring4 = strFindValue.substring(0, 3);
                    strSubstring3 = strFindAIvalue.substring(3);
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
                default:
                    map.put(strFindAIvalue, strFindValue);
                    strSubstring2 = str12;
                    str11 = str13;
                    i = length2;
                    expandedProductParsedResult = null;
                    break;
            }
        }
        return new ExpandedProductParsedResult(massagedText, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, strSubstring2, strSubstring3, strSubstring4, map);
    }

    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String strSubstring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i);
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == '(') {
                if (findAIvalue(i2, strSubstring) != null) {
                    break;
                }
                sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
