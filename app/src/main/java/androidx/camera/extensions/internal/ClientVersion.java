package androidx.camera.extensions.internal;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class ClientVersion {
    private static ClientVersion sCurrent = new ClientVersion("1.4.0");
    private final Version mVersion;

    public static ClientVersion getCurrentVersion() {
        return sCurrent;
    }

    public static void setCurrentVersion(@NonNull ClientVersion clientVersion) {
        sCurrent = clientVersion;
    }

    public Version getVersion() {
        return this.mVersion;
    }

    public ClientVersion(@NonNull String str) {
        this.mVersion = Version.parse(str);
    }

    public static boolean isMinimumCompatibleVersion(@NonNull Version version) {
        return getCurrentVersion().mVersion.compareTo(version.getMajor(), version.getMinor()) >= 0;
    }

    public static boolean isMaximumCompatibleVersion(@NonNull Version version) {
        return getCurrentVersion().mVersion.compareTo(version.getMajor(), version.getMinor()) <= 0;
    }

    public String toVersionString() {
        return this.mVersion.toString();
    }
}
