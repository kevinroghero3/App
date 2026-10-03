package kotlin.collections;

/* JADX INFO: loaded from: classes6.dex */
final class State {
    public static final int DONE = 2;
    public static final int FAILED = 3;
    public static final State INSTANCE = new State();
    public static final int NOT_READY = 0;
    public static final int READY = 1;

    private State() {
    }
}
