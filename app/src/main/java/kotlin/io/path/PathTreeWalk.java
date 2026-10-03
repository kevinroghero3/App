package kotlin.io.path;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.devsupport.StackTraceHelper;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    public PathTreeWalk(@NotNull Path start, @NotNull PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        this.start = start;
        this.options = options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFollowLinks() {
        return ArraysKt___ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getIncludeDirectories() {
        return ArraysKt___ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final boolean isBFS() {
        return ArraysKt___ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        return isBFS() ? bfsIterator() : dfsIterator();
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> sequenceScope, PathNode pathNode, DirectoryEntriesReader directoryEntriesReader, Function1<? super List<PathNode>, Unit> function1, Continuation<? super Unit> continuation) throws IllegalFileNameException, FileSystemLoopException {
        Path path = pathNode.getPath();
        if (pathNode.getParent() != null) {
            PathsKt__PathRecursiveFunctionsKt.checkFileName(path);
        }
        LinkOption[] linkOptions = getLinkOptions();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (!PathTreeWalkKt.createsCycle(pathNode)) {
                if (getIncludeDirectories()) {
                    InlineMarker.mark(0);
                    sequenceScope.yield(path, continuation);
                    InlineMarker.mark(1);
                }
                LinkOption[] linkOptions2 = getLinkOptions();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    function1.invoke(directoryEntriesReader.readEntries(pathNode));
                }
            } else {
                PathTreeWalk$$ExternalSyntheticApiModelOutline2.m();
                throw PathTreeWalk$$ExternalSyntheticApiModelOutline1.m(path.toString());
            }
        } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            InlineMarker.mark(0);
            sequenceScope.yield(path, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {191, 197, 210, JfifUtil.MARKER_SOI}, m = "invokeSuspend", n = {"$this$iterator", StackTraceHelper.STACK_KEY, "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", StackTraceHelper.STACK_KEY, "entriesReader", "$this$iterator", StackTraceHelper.STACK_KEY, "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", StackTraceHelper.STACK_KEY, "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class C04321 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        C04321(Continuation<? super C04321> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04321 c04321 = PathTreeWalk.this.new C04321(continuation);
            c04321.L$0 = obj;
            return c04321;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C04321) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0105  */
        /* JADX WARN: Code duplicated, block: B:40:0x0149  */
        /* JADX WARN: Code duplicated, block: B:44:0x016f  */
        /* JADX WARN: Code duplicated, block: B:49:0x0190  */
        /* JADX WARN: Code duplicated, block: B:51:0x0196  */
        /* JADX WARN: Code duplicated, block: B:53:0x01aa A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:57:0x01d3  */
        /* JADX WARN: Code duplicated, block: B:59:0x01df  */
        /* JADX WARN: Code duplicated, block: B:68:0x0208 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:69:0x01f3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:70:0x018a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:71:0x0207 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x015c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:75:0x0143 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:76:0x0143 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01c1 -> B:38:0x0143). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01c3 -> B:38:0x0143). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 528
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk.C04321.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt__SequenceBuilderKt.iterator(new C04321(null));
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {191, 197}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = PathTreeWalk.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0082  */
        /* JADX WARN: Code duplicated, block: B:15:0x0094  */
        /* JADX WARN: Code duplicated, block: B:20:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:22:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:24:0x00cf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:27:0x00de A[PHI: r1 r5 r6 r7 r8 r13
  0x00de: PHI (r1v2 kotlin.io.path.DirectoryEntriesReader) = (r1v4 kotlin.io.path.DirectoryEntriesReader), (r1v5 kotlin.io.path.DirectoryEntriesReader) binds: [B:26:0x00d7, B:21:0x00b9] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r5v1 kotlin.collections.ArrayDeque) = (r5v3 kotlin.collections.ArrayDeque), (r5v4 kotlin.collections.ArrayDeque) binds: [B:26:0x00d7, B:21:0x00b9] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r6v2 kotlin.sequences.SequenceScope) = (r6v4 kotlin.sequences.SequenceScope), (r6v5 kotlin.sequences.SequenceScope) binds: [B:26:0x00d7, B:21:0x00b9] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r7v2 kotlin.io.path.PathTreeWalk) = (r7v10 kotlin.io.path.PathTreeWalk), (r7v11 kotlin.io.path.PathTreeWalk) binds: [B:26:0x00d7, B:21:0x00b9] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r8v3 java.nio.file.Path) = (r8v5 java.nio.file.Path), (r8v6 java.nio.file.Path) binds: [B:26:0x00d7, B:21:0x00b9] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r13v5 kotlin.io.path.PathNode) = (r13v8 kotlin.io.path.PathNode), (r13v12 kotlin.io.path.PathNode) binds: [B:26:0x00d7, B:21:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:29:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:30:0x0101  */
        /* JADX WARN: Code duplicated, block: B:32:0x010d  */
        /* JADX WARN: Code duplicated, block: B:39:0x0121 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:40:0x00af A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:42:0x0135 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:44:0x007c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:45:0x007c A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f4 -> B:11:0x007c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f6 -> B:11:0x007c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:32:0x010d
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 313
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt__SequenceBuilderKt.iterator(new AnonymousClass1(null));
    }
}
