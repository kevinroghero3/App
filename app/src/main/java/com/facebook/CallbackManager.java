package com.facebook;

import android.content.Intent;
import ch.qos.logback.core.CoreConstants;
import com.facebook.internal.CallbackManagerImpl;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface CallbackManager {
    boolean onActivityResult(int i, int i2, @Nullable Intent intent);

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Factory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @JvmStatic
        public static final CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }

    public static final class ActivityResultParameters {
        private final Intent data;
        private final int requestCode;
        private final int resultCode;

        public static /* synthetic */ ActivityResultParameters copy$default(ActivityResultParameters activityResultParameters, int i, int i2, Intent intent, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = activityResultParameters.requestCode;
            }
            if ((i3 & 2) != 0) {
                i2 = activityResultParameters.resultCode;
            }
            if ((i3 & 4) != 0) {
                intent = activityResultParameters.data;
            }
            return activityResultParameters.copy(i, i2, intent);
        }

        public final int component1() {
            return this.requestCode;
        }

        public final int component2() {
            return this.resultCode;
        }

        public final Intent component3() {
            return this.data;
        }

        public final ActivityResultParameters copy(int i, int i2, @Nullable Intent intent) {
            return new ActivityResultParameters(i, i2, intent);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityResultParameters)) {
                return false;
            }
            ActivityResultParameters activityResultParameters = (ActivityResultParameters) obj;
            return this.requestCode == activityResultParameters.requestCode && this.resultCode == activityResultParameters.resultCode && Intrinsics.areEqual(this.data, activityResultParameters.data);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.requestCode);
            int iHashCode2 = Integer.hashCode(this.resultCode);
            Intent intent = this.data;
            return (((iHashCode * 31) + iHashCode2) * 31) + (intent == null ? 0 : intent.hashCode());
        }

        public String toString() {
            return "ActivityResultParameters(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ActivityResultParameters(int i, int i2, @Nullable Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent;
        }

        public final Intent getData() {
            return this.data;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public final int getResultCode() {
            return this.resultCode;
        }
    }
}
