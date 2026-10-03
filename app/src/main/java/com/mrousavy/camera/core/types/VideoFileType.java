package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public enum VideoFileType implements JSUnionValue {
    MOV("mov"),
    MP4(RRWebVideoEvent.REPLAY_CONTAINER);

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoFileType.values().length];
            try {
                iArr[VideoFileType.MOV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoFileType.MP4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<VideoFileType> getEntries() {
        return $ENTRIES;
    }

    VideoFileType(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final String toExtension() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ".mov";
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return ".mp4";
    }

    public static final class Companion implements JSUnionValue.Companion<VideoFileType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public VideoFileType fromUnionValue(@Nullable String str) throws InvalidTypeScriptUnionError {
            if (Intrinsics.areEqual(str, "mov")) {
                return VideoFileType.MOV;
            }
            if (Intrinsics.areEqual(str, RRWebVideoEvent.REPLAY_CONTAINER)) {
                return VideoFileType.MP4;
            }
            if (str == null) {
                str = "(null)";
            }
            throw new InvalidTypeScriptUnionError("fileType", str);
        }
    }
}
