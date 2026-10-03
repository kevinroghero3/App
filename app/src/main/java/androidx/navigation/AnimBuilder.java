package androidx.navigation;

/* JADX INFO: loaded from: classes.dex */
@NavOptionsDsl
public final class AnimBuilder {
    private int enter = -1;
    private int exit = -1;
    private int popEnter = -1;
    private int popExit = -1;

    public final int getEnter() {
        return this.enter;
    }

    public final void setEnter(int i) {
        this.enter = i;
    }

    public final int getExit() {
        return this.exit;
    }

    public final void setExit(int i) {
        this.exit = i;
    }

    public final int getPopEnter() {
        return this.popEnter;
    }

    public final void setPopEnter(int i) {
        this.popEnter = i;
    }

    public final int getPopExit() {
        return this.popExit;
    }

    public final void setPopExit(int i) {
        this.popExit = i;
    }
}
