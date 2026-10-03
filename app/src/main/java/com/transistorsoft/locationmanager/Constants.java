package com.transistorsoft.locationmanager;

/* JADX INFO: loaded from: classes6.dex */
public class Constants {

    public static class a {
        public static final String a = "ON";
        public static final String b = "OFF";
        public static final String c = "Location-services disabled";
        public static final String d = "Location timeout";

        static {
            System.loadLibrary("tslocationmanager");
        }
    }
}
