package com.mrousavy.camera.core.types;

import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public enum VideoCodec implements JSUnionValue {
    H264(RRWebVideoEvent.REPLAY_ENCODING),
    H265("h265");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoCodec.values().length];
            try {
                iArr[VideoCodec.H264.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoCodec.H265.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<VideoCodec> getEntries() {
        return $ENTRIES;
    }

    VideoCodec(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toVideoEncoder() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class Companion implements JSUnionValue.Companion<VideoCodec> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public VideoCodec fromUnionValue(@Nullable String str) {
            if (Intrinsics.areEqual(str, RRWebVideoEvent.REPLAY_ENCODING)) {
                return VideoCodec.H264;
            }
            return Intrinsics.areEqual(str, "h265") ? VideoCodec.H265 : VideoCodec.H264;
        }
    }
}
