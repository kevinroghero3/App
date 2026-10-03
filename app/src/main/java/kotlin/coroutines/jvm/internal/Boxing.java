package kotlin.coroutines.jvm.internal;

/* JADX INFO: loaded from: classes.dex */
public final class Boxing {
    public static final Boolean boxBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    public static final Byte boxByte(byte b) {
        return Byte.valueOf(b);
    }

    public static final Short boxShort(short s) {
        return new Short(s);
    }

    public static final Integer boxInt(int i) {
        return new Integer(i);
    }

    public static final Long boxLong(long j) {
        return new Long(j);
    }

    public static final Float boxFloat(float f) {
        return new Float(f);
    }

    public static final Double boxDouble(double d) {
        return new Double(d);
    }

    public static final Character boxChar(char c) {
        return new Character(c);
    }
}
