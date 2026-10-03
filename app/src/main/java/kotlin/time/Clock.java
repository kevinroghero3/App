package kotlin.time;

/* JADX INFO: loaded from: classes6.dex */
public interface Clock {
    public static final Companion Companion = Companion.$$INSTANCE;

    Instant now();

    public static final class System implements Clock {
        public static final System INSTANCE = new System();

        private System() {
        }

        @Override // kotlin.time.Clock
        public Instant now() {
            return InstantJvmKt.systemClockNow();
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
