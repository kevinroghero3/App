package n.o.t.i.f.e.e;

import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    public interface a<T> {
        void a(T t);
    }

    public static int a(@Nullable Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj instanceof Double ? (int) ((Double) obj).doubleValue() : ((Integer) obj).intValue();
    }

    public static long b(Object obj) {
        return obj instanceof Double ? (long) ((Double) obj).doubleValue() : ((Long) obj).longValue();
    }

    public static byte[] a(@NonNull Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static Bundle a(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(l.class.getClassLoader());
        parcelObtain.recycle();
        Objects.requireNonNull(bundle);
        return bundle;
    }
}
