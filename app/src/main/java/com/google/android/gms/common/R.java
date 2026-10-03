package com.google.android.gms.common;

import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public final class R {

    public static final class string {
        public static int common_google_play_services_unknown_issue = 0x7f1100b3;

        private string() {
        }
    }

    private R() {
    }

    public static final class integer {
        public static int RemoteActionCompatParcelizer = 0x00000000;
        public static int google_play_services_version = 0x7f09000a;
        public static int readTypedObject;

        private integer() {
        }

        public static int mayLaunchUrl() {
            int i = RemoteActionCompatParcelizer;
            int i2 = i % 6096306;
            RemoteActionCompatParcelizer = i + 1;
            if (i2 != 0) {
                return readTypedObject;
            }
            int iMyTid = Process.myTid();
            readTypedObject = iMyTid;
            return iMyTid;
        }
    }
}
