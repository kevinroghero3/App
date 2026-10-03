package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public interface ChildHandle extends DisposableHandle {

    public static final class DefaultImpls {
        public static /* synthetic */ void getParent$annotations() {
        }
    }

    boolean childCancelled(@NotNull Throwable th);

    Job getParent();
}
