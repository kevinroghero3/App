package kotlin.time;

/* JADX INFO: loaded from: classes6.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.time.AbstractLongTimeSource
    public long read() {
        return this.reading;
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m6943plusAssignLRDsOJo(long j) {
        long jM6870toLongimpl = Duration.m6870toLongimpl(j, getUnit());
        if (((jM6870toLongimpl - 1) | 1) != Long.MAX_VALUE) {
            long j2 = this.reading;
            long j3 = j2 + jM6870toLongimpl;
            if ((jM6870toLongimpl ^ j2) >= 0 && (j2 ^ j3) < 0) {
                m6942overflowLRDsOJo(j);
            }
            this.reading = j3;
            return;
        }
        long jM6834divUwyO8pc = Duration.m6834divUwyO8pc(j, 2);
        if ((1 | (Duration.m6870toLongimpl(jM6834divUwyO8pc, getUnit()) - 1)) != Long.MAX_VALUE) {
            long j4 = this.reading;
            try {
                m6943plusAssignLRDsOJo(jM6834divUwyO8pc);
                m6943plusAssignLRDsOJo(Duration.m6859minusLRDsOJo(j, jM6834divUwyO8pc));
                return;
            } catch (IllegalStateException e) {
                this.reading = j4;
                throw e;
            }
        }
        m6942overflowLRDsOJo(j);
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m6942overflowLRDsOJo(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt__DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m6871toStringimpl(j)) + '.');
    }
}
