package kotlin.reflect;

/* JADX INFO: loaded from: classes.dex */
public interface KProperty<V> extends KCallable<V> {

    /* JADX INFO: loaded from: classes3.dex */
    public interface Accessor<V> {
        KProperty<V> getProperty();
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isConst$annotations() {
        }

        public static /* synthetic */ void isLateinit$annotations() {
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }

    Getter<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}
