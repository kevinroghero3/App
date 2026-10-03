package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import ch.qos.logback.core.CoreConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@JvmInline
public final class SavedStateWriter {
    private final Bundle source;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SavedStateWriter m4109boximpl(Bundle bundle) {
        return new SavedStateWriter(bundle);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Bundle m4111constructorimpl(@NotNull Bundle source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return source;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4112equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateWriter) && Intrinsics.areEqual(bundle, ((SavedStateWriter) obj).m4149unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4113equalsimpl0(Bundle bundle, Bundle bundle2) {
        return Intrinsics.areEqual(bundle, bundle2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4114hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4148toStringimpl(Bundle bundle) {
        return "SavedStateWriter(source=" + bundle + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m4112equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m4114hashCodeimpl(this.source);
    }

    public String toString() {
        return m4148toStringimpl(this.source);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Bundle m4149unboximpl() {
        return this.source;
    }

    private /* synthetic */ SavedStateWriter(Bundle bundle) {
        this.source = bundle;
    }

    /* JADX INFO: renamed from: putBinder-impl, reason: not valid java name */
    public static final void m4116putBinderimpl(Bundle bundle, @NotNull String key, @NotNull IBinder value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putBinder(key, value);
    }

    /* JADX INFO: renamed from: putBoolean-impl, reason: not valid java name */
    public static final void m4117putBooleanimpl(Bundle bundle, @NotNull String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putBoolean(key, z);
    }

    /* JADX INFO: renamed from: putChar-impl, reason: not valid java name */
    public static final void m4119putCharimpl(Bundle bundle, @NotNull String key, char c) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putChar(key, c);
    }

    /* JADX INFO: renamed from: putCharSequence-impl, reason: not valid java name */
    public static final void m4121putCharSequenceimpl(Bundle bundle, @NotNull String key, @NotNull CharSequence value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharSequence(key, value);
    }

    /* JADX INFO: renamed from: putDouble-impl, reason: not valid java name */
    public static final void m4124putDoubleimpl(Bundle bundle, @NotNull String key, double d) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putDouble(key, d);
    }

    /* JADX INFO: renamed from: putFloat-impl, reason: not valid java name */
    public static final void m4126putFloatimpl(Bundle bundle, @NotNull String key, float f) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putFloat(key, f);
    }

    /* JADX INFO: renamed from: putInt-impl, reason: not valid java name */
    public static final void m4128putIntimpl(Bundle bundle, @NotNull String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putInt(key, i);
    }

    /* JADX INFO: renamed from: putLong-impl, reason: not valid java name */
    public static final void m4132putLongimpl(Bundle bundle, @NotNull String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putLong(key, j);
    }

    /* JADX INFO: renamed from: putNull-impl, reason: not valid java name */
    public static final void m4134putNullimpl(Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putString(key, null);
    }

    /* JADX INFO: renamed from: putParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m4135putParcelableimpl(Bundle bundle, @NotNull String key, @NotNull T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putParcelable(key, value);
    }

    /* JADX INFO: renamed from: putJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> void m4131putJavaSerializableimpl(Bundle bundle, @NotNull String key, @NotNull T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSerializable(key, value);
    }

    /* JADX INFO: renamed from: putSize-impl, reason: not valid java name */
    public static final void m4141putSizeimpl(Bundle bundle, @NotNull String key, @NotNull Size value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSize(key, value);
    }

    /* JADX INFO: renamed from: putSizeF-impl, reason: not valid java name */
    public static final void m4142putSizeFimpl(Bundle bundle, @NotNull String key, @NotNull SizeF value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSizeF(key, value);
    }

    /* JADX INFO: renamed from: putString-impl, reason: not valid java name */
    public static final void m4144putStringimpl(Bundle bundle, @NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putString(key, value);
    }

    /* JADX INFO: renamed from: putIntList-impl, reason: not valid java name */
    public static final void m4130putIntListimpl(Bundle bundle, @NotNull String key, @NotNull List<Integer> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putIntegerArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: putCharSequenceList-impl, reason: not valid java name */
    public static final void m4123putCharSequenceListimpl(Bundle bundle, @NotNull String key, @NotNull List<? extends CharSequence> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharSequenceArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: putSavedStateList-impl, reason: not valid java name */
    public static final void m4140putSavedStateListimpl(Bundle bundle, @NotNull String key, @NotNull List<Bundle> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        m4137putParcelableListimpl(bundle, key, value);
    }

    /* JADX INFO: renamed from: putStringList-impl, reason: not valid java name */
    public static final void m4146putStringListimpl(Bundle bundle, @NotNull String key, @NotNull List<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putStringArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: putParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m4137putParcelableListimpl(Bundle bundle, @NotNull String key, @NotNull List<? extends T> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putParcelableArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: putBooleanArray-impl, reason: not valid java name */
    public static final void m4118putBooleanArrayimpl(Bundle bundle, @NotNull String key, @NotNull boolean[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putBooleanArray(key, value);
    }

    /* JADX INFO: renamed from: putCharArray-impl, reason: not valid java name */
    public static final void m4120putCharArrayimpl(Bundle bundle, @NotNull String key, @NotNull char[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharArray(key, value);
    }

    /* JADX INFO: renamed from: putCharSequenceArray-impl, reason: not valid java name */
    public static final void m4122putCharSequenceArrayimpl(Bundle bundle, @NotNull String key, @NotNull CharSequence[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putCharSequenceArray(key, value);
    }

    /* JADX INFO: renamed from: putDoubleArray-impl, reason: not valid java name */
    public static final void m4125putDoubleArrayimpl(Bundle bundle, @NotNull String key, @NotNull double[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putDoubleArray(key, value);
    }

    /* JADX INFO: renamed from: putFloatArray-impl, reason: not valid java name */
    public static final void m4127putFloatArrayimpl(Bundle bundle, @NotNull String key, @NotNull float[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putFloatArray(key, value);
    }

    /* JADX INFO: renamed from: putIntArray-impl, reason: not valid java name */
    public static final void m4129putIntArrayimpl(Bundle bundle, @NotNull String key, @NotNull int[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putIntArray(key, value);
    }

    /* JADX INFO: renamed from: putLongArray-impl, reason: not valid java name */
    public static final void m4133putLongArrayimpl(Bundle bundle, @NotNull String key, @NotNull long[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putLongArray(key, value);
    }

    /* JADX INFO: renamed from: putSavedStateArray-impl, reason: not valid java name */
    public static final void m4139putSavedStateArrayimpl(Bundle bundle, @NotNull String key, @NotNull Bundle[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        m4136putParcelableArrayimpl(bundle, key, value);
    }

    /* JADX INFO: renamed from: putStringArray-impl, reason: not valid java name */
    public static final void m4145putStringArrayimpl(Bundle bundle, @NotNull String key, @NotNull String[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putStringArray(key, value);
    }

    /* JADX INFO: renamed from: putParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m4136putParcelableArrayimpl(Bundle bundle, @NotNull String key, @NotNull T[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putParcelableArray(key, value);
    }

    /* JADX INFO: renamed from: putSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m4143putSparseParcelableArrayimpl(Bundle bundle, @NotNull String key, @NotNull SparseArray<T> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putSparseParcelableArray(key, value);
    }

    /* JADX INFO: renamed from: putSavedState-impl, reason: not valid java name */
    public static final void m4138putSavedStateimpl(Bundle bundle, @NotNull String key, @NotNull Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putBundle(key, value);
    }

    /* JADX INFO: renamed from: putAll-impl, reason: not valid java name */
    public static final void m4115putAllimpl(Bundle bundle, @NotNull Bundle from) {
        Intrinsics.checkNotNullParameter(from, "from");
        bundle.putAll(from);
    }

    /* JADX INFO: renamed from: remove-impl, reason: not valid java name */
    public static final void m4147removeimpl(Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.remove(key);
    }

    /* JADX INFO: renamed from: clear-impl, reason: not valid java name */
    public static final void m4110clearimpl(Bundle bundle) {
        bundle.clear();
    }
}
