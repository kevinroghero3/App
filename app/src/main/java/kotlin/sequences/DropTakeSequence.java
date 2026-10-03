package kotlin.sequences;

/* JADX INFO: loaded from: classes.dex */
public interface DropTakeSequence<T> extends Sequence<T> {
    Sequence<T> drop(int i);

    Sequence<T> take(int i);
}
