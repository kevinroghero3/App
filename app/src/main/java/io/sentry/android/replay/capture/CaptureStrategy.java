package io.sentry.android.replay.capture;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import ch.qos.logback.core.CoreConstants;
import io.sentry.Breadcrumb;
import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.IScope;
import io.sentry.IScopes;
import io.sentry.ReplayRecording;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.GeneratedVideo;
import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.protocol.SentryId;
import io.sentry.rrweb.RRWebBreadcrumbEvent;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.rrweb.RRWebMetaEvent;
import io.sentry.rrweb.RRWebOptionsEvent;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface CaptureStrategy {
    public static final Companion Companion = Companion.$$INSTANCE;

    void captureReplay(boolean z, @NotNull Function1<? super Date, Unit> function1);

    CaptureStrategy convert();

    SentryId getCurrentReplayId();

    int getCurrentSegment();

    File getReplayCacheDir();

    SentryReplayEvent.ReplayType getReplayType();

    Date getSegmentTimestamp();

    void onConfigurationChanged(@NotNull ScreenshotRecorderConfig screenshotRecorderConfig);

    void onScreenChanged(@Nullable String str);

    void onScreenshotRecorded(@Nullable Bitmap bitmap, @NotNull Function2<? super ReplayCache, ? super Long, Unit> function2);

    void onTouchEvent(@NotNull MotionEvent motionEvent);

    void pause();

    void resume();

    void setCurrentReplayId(@NotNull SentryId sentryId);

    void setCurrentSegment(int i);

    void setReplayType(@NotNull SentryReplayEvent.ReplayType replayType);

    void setSegmentTimestamp(@Nullable Date date);

    void start(int i, @NotNull SentryId sentryId, @Nullable SentryReplayEvent.ReplayType replayType);

    void stop();

    public static final class DefaultImpls {
        public static void onScreenChanged(@NotNull CaptureStrategy captureStrategy, @Nullable String str) {
        }

        public static /* synthetic */ void start$default(CaptureStrategy captureStrategy, int i, SentryId sentryId, SentryReplayEvent.ReplayType replayType, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i2 & 1) != 0) {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                sentryId = new SentryId();
            }
            if ((i2 & 4) != 0) {
                replayType = null;
            }
            captureStrategy.start(i, sentryId, replayType);
        }

        public static /* synthetic */ void onScreenshotRecorded$default(CaptureStrategy captureStrategy, Bitmap bitmap, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onScreenshotRecorded");
            }
            if ((i & 1) != 0) {
                bitmap = null;
            }
            captureStrategy.onScreenshotRecorded(bitmap, function2);
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final long MAX_SEGMENT_DURATION = 300000;
        private static final long NETWORK_BREADCRUMB_START_OFFSET = 5000;

        private Companion() {
        }

        private final boolean isNetworkAvailable(Breadcrumb breadcrumb) {
            if (breadcrumb != null && Intrinsics.areEqual(breadcrumb.getCategory(), "network.event")) {
                Map<String, Object> data = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data, "data");
                Object obj = data.get("action");
                if (obj == null) {
                    obj = null;
                }
                if (Intrinsics.areEqual(obj, "NETWORK_AVAILABLE")) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isNetworkConnectivity(Breadcrumb breadcrumb) {
            return Intrinsics.areEqual(breadcrumb.getCategory(), "network.event") && breadcrumb.getData().containsKey("network_type");
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.util.List] */
        public final ReplaySegment createSegment(@Nullable IScopes iScopes, @NotNull SentryOptions options, long j, @NotNull Date currentSegmentTimestamp, @NotNull SentryId replayId, int i, int i2, int i3, @NotNull SentryReplayEvent.ReplayType replayType, @Nullable ReplayCache replayCache, int i4, int i5, @Nullable String str, @Nullable List<Breadcrumb> list, @NotNull Deque<RRWebEvent> events) {
            GeneratedVideo generatedVideoCreateVideoOf$default;
            List<Breadcrumb> list2;
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(currentSegmentTimestamp, "currentSegmentTimestamp");
            Intrinsics.checkNotNullParameter(replayId, "replayId");
            Intrinsics.checkNotNullParameter(replayType, "replayType");
            Intrinsics.checkNotNullParameter(events, "events");
            if (replayCache == null || (generatedVideoCreateVideoOf$default = ReplayCache.createVideoOf$default(replayCache, Math.min(j, 300000L), currentSegmentTimestamp.getTime(), i, i2, i3, i4, i5, null, 128, null)) == null) {
                return ReplaySegment.Failed.INSTANCE;
            }
            File fileComponent1 = generatedVideoCreateVideoOf$default.component1();
            int iComponent2 = generatedVideoCreateVideoOf$default.component2();
            long jComponent3 = generatedVideoCreateVideoOf$default.component3();
            if (list == null) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = CollectionsKt__CollectionsKt.emptyList();
                if (iScopes != null) {
                    iScopes.configureScope(new ScopeCallback() { // from class: io.sentry.android.replay.capture.CaptureStrategy$Companion$$ExternalSyntheticLambda0
                        @Override // io.sentry.ScopeCallback
                        public final void run(IScope iScope) {
                            CaptureStrategy.Companion.createSegment$lambda$1(objectRef, iScope);
                        }
                    });
                }
                list2 = (List) objectRef.element;
            } else {
                list2 = list;
            }
            return buildReplay(options, fileComponent1, replayId, currentSegmentTimestamp, i, i2, i3, iComponent2, i4, jComponent3, replayType, str, list2, events);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.ArrayList] */
        public static final void createSegment$lambda$1(Ref.ObjectRef crumbs, IScope scope) {
            Intrinsics.checkNotNullParameter(crumbs, "$crumbs");
            Intrinsics.checkNotNullParameter(scope, "scope");
            crumbs.element = new ArrayList(scope.getBreadcrumbs());
        }

        /* JADX WARN: Code duplicated, block: B:14:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:35:0x012a  */
        private final ReplaySegment buildReplay(SentryOptions sentryOptions, File file, SentryId sentryId, final Date date, int i, int i2, int i3, int i4, int i5, long j, SentryReplayEvent.ReplayType replayType, String str, List<Breadcrumb> list, Deque<RRWebEvent> deque) {
            boolean z;
            RRWebEvent rRWebEventConvert;
            Object obj;
            Date dateTime = DateUtils.getDateTime(date.getTime() + j);
            Intrinsics.checkNotNullExpressionValue(dateTime, "getDateTime(segmentTimestamp.time + videoDuration)");
            SentryReplayEvent sentryReplayEvent = new SentryReplayEvent();
            sentryReplayEvent.setEventId(sentryId);
            sentryReplayEvent.setReplayId(sentryId);
            sentryReplayEvent.setSegmentId(i);
            sentryReplayEvent.setTimestamp(dateTime);
            sentryReplayEvent.setReplayStartTimestamp(date);
            sentryReplayEvent.setReplayType(replayType);
            sentryReplayEvent.setVideoFile(file);
            final ArrayList arrayList = new ArrayList();
            RRWebMetaEvent rRWebMetaEvent = new RRWebMetaEvent();
            rRWebMetaEvent.setTimestamp(date.getTime());
            rRWebMetaEvent.setHeight(i2);
            rRWebMetaEvent.setWidth(i3);
            arrayList.add(rRWebMetaEvent);
            RRWebVideoEvent rRWebVideoEvent = new RRWebVideoEvent();
            rRWebVideoEvent.setTimestamp(date.getTime());
            rRWebVideoEvent.setSegmentId(i);
            rRWebVideoEvent.setDurationMs(j);
            rRWebVideoEvent.setFrameCount(i4);
            rRWebVideoEvent.setSize(file.length());
            rRWebVideoEvent.setFrameRate(i5);
            rRWebVideoEvent.setHeight(i2);
            rRWebVideoEvent.setWidth(i3);
            rRWebVideoEvent.setLeft(0);
            rRWebVideoEvent.setTop(0);
            arrayList.add(rRWebVideoEvent);
            LinkedList linkedList = new LinkedList();
            Breadcrumb breadcrumb = null;
            for (Breadcrumb breadcrumb2 : list) {
                if (breadcrumb != null) {
                    Companion companion = $$INSTANCE;
                    z = companion.isNetworkAvailable(breadcrumb) && companion.isNetworkConnectivity(breadcrumb2) && breadcrumb2.getTimestamp().getTime() + 5000 >= date.getTime();
                }
                if ((breadcrumb2.getTimestamp().getTime() >= date.getTime() || z) && breadcrumb2.getTimestamp().getTime() < dateTime.getTime() && (rRWebEventConvert = sentryOptions.getReplayController().getBreadcrumbConverter().convert(breadcrumb2)) != null) {
                    arrayList.add(rRWebEventConvert);
                    RRWebBreadcrumbEvent rRWebBreadcrumbEvent = rRWebEventConvert instanceof RRWebBreadcrumbEvent ? (RRWebBreadcrumbEvent) rRWebEventConvert : null;
                    if (Intrinsics.areEqual(rRWebBreadcrumbEvent != null ? rRWebBreadcrumbEvent.getCategory() : null, "navigation")) {
                        RRWebBreadcrumbEvent rRWebBreadcrumbEvent2 = (RRWebBreadcrumbEvent) rRWebEventConvert;
                        Map<String, Object> data = rRWebBreadcrumbEvent2.getData();
                        if (data != null) {
                            Intrinsics.checkNotNullExpressionValue(data, "data");
                            obj = data.get("to");
                            if (obj == null) {
                                obj = null;
                            }
                        } else {
                            obj = null;
                        }
                        if (obj instanceof String) {
                            Map<String, Object> data2 = rRWebBreadcrumbEvent2.getData();
                            Intrinsics.checkNotNull(data2);
                            Object obj2 = data2.get("to");
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                            linkedList.add((String) obj2);
                        }
                    }
                }
                breadcrumb = breadcrumb2;
            }
            if (str != null && !Intrinsics.areEqual(CollectionsKt___CollectionsKt.firstOrNull((List) linkedList), str)) {
                linkedList.addFirst(str);
            }
            rotateEvents$sentry_android_replay_release(deque, dateTime.getTime(), new Function1<RRWebEvent, Unit>() { // from class: io.sentry.android.replay.capture.CaptureStrategy$Companion$buildReplay$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RRWebEvent rRWebEvent) {
                    invoke2(rRWebEvent);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull RRWebEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event.getTimestamp() >= date.getTime()) {
                        arrayList.add(event);
                    }
                }
            });
            if (i == 0) {
                arrayList.add(new RRWebOptionsEvent(sentryOptions));
            }
            ReplayRecording replayRecording = new ReplayRecording();
            replayRecording.setSegmentId(Integer.valueOf(i));
            replayRecording.setPayload(CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: io.sentry.android.replay.capture.CaptureStrategy$Companion$buildReplay$lambda$8$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((RRWebEvent) t).getTimestamp()), Long.valueOf(((RRWebEvent) t2).getTimestamp()));
                }
            }));
            sentryReplayEvent.setUrls(linkedList);
            return new ReplaySegment.Created(sentryReplayEvent, replayRecording);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void rotateEvents$sentry_android_replay_release$default(Companion companion, Deque deque, long j, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            companion.rotateEvents$sentry_android_replay_release(deque, j, function1);
        }

        public final void rotateEvents$sentry_android_replay_release(@NotNull Deque<RRWebEvent> events, long j, @Nullable Function1<? super RRWebEvent, Unit> function1) {
            Intrinsics.checkNotNullParameter(events, "events");
            Iterator<RRWebEvent> it2 = events.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "events.iterator()");
            while (it2.hasNext()) {
                RRWebEvent event = it2.next();
                if (event.getTimestamp() < j) {
                    if (function1 != null) {
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        function1.invoke(event);
                    }
                    it2.remove();
                }
            }
        }
    }

    public static abstract class ReplaySegment {
        public static final int $stable = 0;

        public /* synthetic */ ReplaySegment(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final class Failed extends ReplaySegment {
            public static final int $stable = 0;
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        private ReplaySegment() {
        }

        public static final class Created extends ReplaySegment {
            public static final int $stable = 8;
            private final ReplayRecording recording;
            private final SentryReplayEvent replay;

            public static /* synthetic */ Created copy$default(Created created, SentryReplayEvent sentryReplayEvent, ReplayRecording replayRecording, int i, Object obj) {
                if ((i & 1) != 0) {
                    sentryReplayEvent = created.replay;
                }
                if ((i & 2) != 0) {
                    replayRecording = created.recording;
                }
                return created.copy(sentryReplayEvent, replayRecording);
            }

            public final SentryReplayEvent component1() {
                return this.replay;
            }

            public final ReplayRecording component2() {
                return this.recording;
            }

            public final Created copy(@NotNull SentryReplayEvent replay, @NotNull ReplayRecording recording) {
                Intrinsics.checkNotNullParameter(replay, "replay");
                Intrinsics.checkNotNullParameter(recording, "recording");
                return new Created(replay, recording);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Created)) {
                    return false;
                }
                Created created = (Created) obj;
                return Intrinsics.areEqual(this.replay, created.replay) && Intrinsics.areEqual(this.recording, created.recording);
            }

            public int hashCode() {
                return (this.replay.hashCode() * 31) + this.recording.hashCode();
            }

            public String toString() {
                return "Created(replay=" + this.replay + ", recording=" + this.recording + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public final ReplayRecording getRecording() {
                return this.recording;
            }

            public final SentryReplayEvent getReplay() {
                return this.replay;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Created(@NotNull SentryReplayEvent replay, @NotNull ReplayRecording recording) {
                super(null);
                Intrinsics.checkNotNullParameter(replay, "replay");
                Intrinsics.checkNotNullParameter(recording, "recording");
                this.replay = replay;
                this.recording = recording;
            }

            public static /* synthetic */ void capture$default(Created created, IScopes iScopes, Hint hint, int i, Object obj) {
                if ((i & 2) != 0) {
                    hint = new Hint();
                }
                created.capture(iScopes, hint);
            }

            public final void capture(@Nullable IScopes iScopes, @NotNull Hint hint) {
                Intrinsics.checkNotNullParameter(hint, "hint");
                if (iScopes != null) {
                    SentryReplayEvent sentryReplayEvent = this.replay;
                    hint.setReplayRecording(this.recording);
                    Unit unit = Unit.INSTANCE;
                    iScopes.captureReplay(sentryReplayEvent, hint);
                }
            }

            public final void setSegmentId(int i) {
                this.replay.setSegmentId(i);
                List<? extends RRWebEvent> payload = this.recording.getPayload();
                if (payload != null) {
                    for (RRWebEvent rRWebEvent : payload) {
                        if (rRWebEvent instanceof RRWebVideoEvent) {
                            ((RRWebVideoEvent) rRWebEvent).setSegmentId(i);
                        }
                    }
                }
            }
        }
    }
}
