package it.aep_italia.vts.sdk.internal;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class Version implements Serializable, Comparable<Version> {
    private int major;
    private int minor;
    private int patch;

    private Version(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
    }

    public static Version of(int i, int i2, int i3) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException("Major version cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Minor version cannot be negative");
        }
        if (i3 >= 0) {
            return new Version(i, i2, i3);
        }
        throw new IllegalArgumentException("Patch version cannot be negative");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Version version) {
        int i = this.major;
        int i2 = version.major;
        if (i != i2) {
            return i - i2;
        }
        int i3 = this.minor;
        int i4 = version.minor;
        return i3 != i4 ? i3 - i4 : this.patch - version.patch;
    }

    public String getFullString() {
        return String.format(Locale.ITALY, "%d.%d.%d", Integer.valueOf(this.major), Integer.valueOf(this.minor), Integer.valueOf(this.patch));
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getPatch() {
        return this.patch;
    }

    public String getShortString() {
        return String.format(Locale.ITALY, "%d%d", Integer.valueOf(this.major), Integer.valueOf(this.minor));
    }

    public void init() {
    }
}
