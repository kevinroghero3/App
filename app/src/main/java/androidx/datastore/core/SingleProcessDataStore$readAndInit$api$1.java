package androidx.datastore.core;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes4.dex */
public final class SingleProcessDataStore$readAndInit$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ Ref.ObjectRef<T> $initData;
    final /* synthetic */ Ref.BooleanRef $initializationComplete;
    final /* synthetic */ Mutex $updateLock;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    SingleProcessDataStore$readAndInit$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef<T> objectRef, SingleProcessDataStore<T> singleProcessDataStore) {
        this.$updateLock = mutex;
        this.$initializationComplete = booleanRef;
        this.$initData = objectRef;
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b9 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #1 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b1, B:38:0x00b9), top: B:55:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.InitializerApi
    public Object updateData(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) throws Throwable {
        SingleProcessDataStore$readAndInit$api$1$updateData$1 singleProcessDataStore$readAndInit$api$1$updateData$1;
        Mutex mutex;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef<T> objectRef;
        Function2<? super T, ? super Continuation<? super T>, ? extends Object> function3;
        SingleProcessDataStore singleProcessDataStore;
        Mutex mutex2;
        SingleProcessDataStore singleProcessDataStore2;
        Mutex mutex3;
        T t;
        Ref.ObjectRef<T> objectRef2;
        if (continuation instanceof SingleProcessDataStore$readAndInit$api$1$updateData$1) {
            singleProcessDataStore$readAndInit$api$1$updateData$1 = (SingleProcessDataStore$readAndInit$api$1$updateData$1) continuation;
            int i = singleProcessDataStore$readAndInit$api$1$updateData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                singleProcessDataStore$readAndInit$api$1$updateData$1.label = i - Integer.MIN_VALUE;
            } else {
                singleProcessDataStore$readAndInit$api$1$updateData$1 = new SingleProcessDataStore$readAndInit$api$1$updateData$1(this, continuation);
            }
        } else {
            singleProcessDataStore$readAndInit$api$1$updateData$1 = new SingleProcessDataStore$readAndInit$api$1$updateData$1(this, continuation);
        }
        Object obj = singleProcessDataStore$readAndInit$api$1$updateData$1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = singleProcessDataStore$readAndInit$api$1$updateData$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.$updateLock;
                Ref.BooleanRef booleanRef2 = this.$initializationComplete;
                Ref.ObjectRef<T> objectRef3 = this.$initData;
                SingleProcessDataStore singleProcessDataStore3 = this.this$0;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = function2;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = mutex;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = booleanRef2;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$3 = objectRef3;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$4 = singleProcessDataStore3;
                singleProcessDataStore$readAndInit$api$1$updateData$1.label = 1;
                if (mutex.lock(null, singleProcessDataStore$readAndInit$api$1$updateData$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
                objectRef = objectRef3;
                function3 = function2;
                singleProcessDataStore = singleProcessDataStore3;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        t = (T) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                        objectRef2 = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                        mutex3 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            objectRef2.element = t;
                            objectRef = objectRef2;
                            T t2 = objectRef.element;
                            mutex3.unlock(null);
                            return t2;
                        } catch (Throwable th) {
                            th = th;
                            mutex = mutex3;
                            mutex.unlock(null);
                            throw th;
                        }
                    }
                    SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                    objectRef = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                    mutex2 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        singleProcessDataStore2 = singleProcessDataStore4;
                        if (Intrinsics.areEqual(obj, objectRef.element)) {
                            mutex3 = mutex2;
                        } else {
                            singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex2;
                            singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef;
                            singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = obj;
                            singleProcessDataStore$readAndInit$api$1$updateData$1.label = 3;
                            if (singleProcessDataStore2.writeData$datastore_core(obj, singleProcessDataStore$readAndInit$api$1$updateData$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            t = (T) obj;
                            objectRef2 = objectRef;
                            mutex3 = mutex2;
                            objectRef2.element = t;
                            objectRef = objectRef2;
                        }
                        T t3 = objectRef.element;
                        mutex3.unlock(null);
                        return t3;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex = mutex2;
                        mutex.unlock(null);
                        throw th;
                    }
                }
                SingleProcessDataStore singleProcessDataStore5 = (SingleProcessDataStore) singleProcessDataStore$readAndInit$api$1$updateData$1.L$4;
                objectRef = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$3;
                booleanRef = (Ref.BooleanRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                Mutex mutex4 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                function3 = (Function2) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex4;
                singleProcessDataStore = singleProcessDataStore5;
            }
            if (booleanRef.element) {
                throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
            }
            T t4 = objectRef.element;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = singleProcessDataStore;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$3 = null;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$4 = null;
            singleProcessDataStore$readAndInit$api$1$updateData$1.label = 2;
            Object objInvoke = function3.invoke(t4, singleProcessDataStore$readAndInit$api$1$updateData$1);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            obj = objInvoke;
            singleProcessDataStore2 = singleProcessDataStore;
            if (Intrinsics.areEqual(obj, objectRef.element)) {
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex2;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = obj;
                singleProcessDataStore$readAndInit$api$1$updateData$1.label = 3;
                if (singleProcessDataStore2.writeData$datastore_core(obj, singleProcessDataStore$readAndInit$api$1$updateData$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t = (T) obj;
                objectRef2 = objectRef;
                mutex3 = mutex2;
                objectRef2.element = t;
                objectRef = objectRef2;
            } else {
                mutex3 = mutex2;
            }
            T t5 = objectRef.element;
            mutex3.unlock(null);
            return t5;
        } catch (Throwable th3) {
            th = th3;
            mutex.unlock(null);
            throw th;
        }
    }
}
