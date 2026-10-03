package com.bea.xml.stream.reader;

import androidx.recyclerview.widget.ItemTouchHelper;

/* JADX INFO: loaded from: classes4.dex */
public class XmlChars {
    public static boolean isChar(int i) {
        return (i >= 32 && i <= 55295) || i == 10 || i == 9 || i == 13 || (i >= 57344 && i <= 65533) || (i >= 65536 && i <= 1114111);
    }

    private static boolean isCompatibilityChar(char c) {
        int i = (c >> '\b') & 255;
        if (i == 0) {
            return c == 170 || c == 181 || c == 186;
        }
        if (i == 1) {
            if (c >= 306 && c <= 307) {
                return true;
            }
            if ((c >= 319 && c <= 320) || c == 329 || c == 383) {
                return true;
            }
            if (c < 452 || c > 460) {
                return c >= 497 && c <= 499;
            }
            return true;
        }
        if (i == 2) {
            if (c < 688 || c > 696) {
                return c >= 736 && c <= 740;
            }
            return true;
        }
        if (i == 3) {
            return c == 890;
        }
        if (i == 5) {
            return c == 1415;
        }
        if (i == 14) {
            return c >= 3804 && c <= 3805;
        }
        if (i != 17) {
            if (i == 32) {
                return c == 8319;
            }
            if (i != 33) {
                if (i == 48) {
                    return c >= 12443 && c <= 12444;
                }
                if (i == 49) {
                    return c >= 12593 && c <= 12686;
                }
                switch (i) {
                    case 249:
                    case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                    case 251:
                    case 252:
                    case 253:
                    case 254:
                    case 255:
                        return true;
                    default:
                        return false;
                }
            }
            if (c == 8450 || c == 8455) {
                return true;
            }
            if ((c >= 8458 && c <= 8467) || c == 8469) {
                return true;
            }
            if ((c >= 8472 && c <= 8477) || c == 8484 || c == 8488) {
                return true;
            }
            if (c >= 8492 && c <= 8493) {
                return true;
            }
            if (c < 8495 || c > 8504) {
                return c >= 8544 && c <= 8575;
            }
            return true;
        }
        if (c == 4353 || c == 4356 || c == 4360 || c == 4362 || c == 4365) {
            return true;
        }
        if ((c >= 4371 && c <= 4411) || c == 4413 || c == 4415) {
            return true;
        }
        if ((c >= 4417 && c <= 4427) || c == 4429 || c == 4431) {
            return true;
        }
        if (c >= 4433 && c <= 4435) {
            return true;
        }
        if ((c >= 4438 && c <= 4440) || c == 4450 || c == 4452 || c == 4454 || c == 4456) {
            return true;
        }
        if (c >= 4458 && c <= 4460) {
            return true;
        }
        if ((c >= 4463 && c <= 4465) || c == 4468) {
            return true;
        }
        if (c >= 4470 && c <= 4509) {
            return true;
        }
        if (c >= 4511 && c <= 4514) {
            return true;
        }
        if (c >= 4521 && c <= 4522) {
            return true;
        }
        if (c >= 4524 && c <= 4525) {
            return true;
        }
        if ((c >= 4528 && c <= 4534) || c == 4537 || c == 4539) {
            return true;
        }
        if (c >= 4547 && c <= 4586) {
            return true;
        }
        if (c < 4588 || c > 4591) {
            return c >= 4593 && c <= 4600;
        }
        return true;
    }

    private static boolean isExtender(char c) {
        return c == 183 || c == 720 || c == 721 || c == 903 || c == 1600 || c == 3654 || c == 3782 || c == 12293 || (c >= 12337 && c <= 12341) || ((c >= 12445 && c <= 12446) || (c >= 12540 && c <= 12542));
    }

    public static boolean isSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    private XmlChars() {
    }

    public static boolean isNameChar(char c) {
        if (isLetter2(c)) {
            return true;
        }
        if (c == '>') {
            return false;
        }
        return c == '.' || c == '-' || c == '_' || c == ':' || isExtender(c);
    }

    public static boolean isNCNameChar(char c) {
        return c != ':' && isNameChar(c);
    }

    public static boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c == '/') {
            return false;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        int type = Character.getType(c);
        if (type == 1 || type == 2 || type == 3 || type == 5 || type == 10) {
            return !isCompatibilityChar(c) && (c < 8413 || c > 8416);
        }
        return (c >= 699 && c <= 705) || c == 1369 || c == 1765 || c == 1766;
    }

    private static boolean isLetter2(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c == '>') {
            return false;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        switch (Character.getType(c)) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return !isCompatibilityChar(c) && (c < 8413 || c > 8416);
            default:
                return c == 903;
        }
    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c) && (c < 65296 || c > 65305);
    }
}
