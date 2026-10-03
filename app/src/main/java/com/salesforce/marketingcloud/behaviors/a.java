package com.salesforce.marketingcloud.behaviors;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    BEHAVIOR_DEVICE_SHUTDOWN("com.salesforce.marketingcloud.DEVICE_SHUTDOWN"),
    BEHAVIOR_DEVICE_BOOT_COMPLETE("com.salesforce.marketingcloud.BOOT_COMPLETE"),
    BEHAVIOR_DEVICE_TIME_ZONE_CHANGED("com.salesforce.marketingcloud.TIME_ZONE_CHANGED"),
    BEHAVIOR_APP_PACKAGE_REPLACED("com.salesforce.marketingcloud.PACKAGE_REPLACED"),
    BEHAVIOR_APP_FOREGROUNDED("com.salesforce.marketingcloud.APP_FOREGROUNDED", true),
    BEHAVIOR_APP_BACKGROUNDED("com.salesforce.marketingcloud.APP_BACKGROUNDED", BEHAVIOR_APP_FOREGROUNDED),
    BEHAVIOR_SDK_REGISTRATION_SEND("com.salesforce.marketingcloud.REGISTRATION_SEND"),
    BEHAVIOR_SDK_PUSH_RECEIVED("com.salesforce.marketingcloud.PUSH_RECEIVED"),
    BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED("com.salesforce.marketingcloud.FENCE_MESSAGING_TOGGLED"),
    BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED("com.salesforce.marketingcloud.PROXIMITY_MESSAGING_TOGGLED"),
    BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED("com.salesforce.marketingcloud.PUSH_MESSAGING_TOGGLED"),
    BEHAVIOR_SDK_NOTIFICATION_OPENED("com.salesforce.marketingcloud.NOTIFICATION_OPENED"),
    BEHAVIOR_SDK_TOKEN_REFRESHED("com.salesforce.marketingcloud.TOKEN_REFRESHED");

    public final String b;
    public final boolean c;
    public final a d;

    a(String str) {
        this(str, false);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }

    a(String str, boolean z) {
        this.b = str;
        this.c = z;
        this.d = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:22:0x003a  */
    public static a a(String str) {
        byte b;
        if (str == null) {
            return null;
        }
        switch (str) {
            case "android.intent.action.TIMEZONE_CHANGED":
                b = 0;
                break;
            case "android.intent.action.BOOT_COMPLETED":
                b = 1;
                break;
            case "android.intent.action.MY_PACKAGE_REPLACED":
                b = 2;
                break;
            case "android.intent.action.ACTION_SHUTDOWN":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return BEHAVIOR_DEVICE_TIME_ZONE_CHANGED;
        }
        if (b == 1) {
            return BEHAVIOR_DEVICE_BOOT_COMPLETE;
        }
        if (b == 2) {
            return BEHAVIOR_APP_PACKAGE_REPLACED;
        }
        if (b == 3) {
            return BEHAVIOR_DEVICE_SHUTDOWN;
        }
        for (a aVar : values()) {
            if (str.equals(aVar.b)) {
                return aVar;
            }
        }
        return null;
    }

    a(String str, a aVar) {
        this.b = str;
        this.c = false;
        this.d = aVar;
    }
}
