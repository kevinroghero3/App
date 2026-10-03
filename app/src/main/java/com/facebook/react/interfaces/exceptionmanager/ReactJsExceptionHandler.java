package com.facebook.react.interfaces.exceptionmanager;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@UnstableReactNativeAPI
public interface ReactJsExceptionHandler {

    /* JADX INFO: loaded from: classes4.dex */
    public interface ProcessedError {

        public interface StackFrame {
            Integer getColumn();

            String getFile();

            Integer getLineNumber();

            String getMethodName();
        }

        String getComponentStack();

        ReadableMap getExtraData();

        int getId();

        String getMessage();

        String getName();

        String getOriginalMessage();

        List<StackFrame> getStack();

        boolean isFatal();
    }

    void reportJsException(@NotNull ProcessedError processedError);

    /* JADX INFO: loaded from: classes4.dex */
    static final class ProcessedErrorStackFrameImpl implements ProcessedError.StackFrame {
        private final Integer column;
        private final String file;
        private final Integer lineNumber;
        private final String methodName;

        public static /* synthetic */ ProcessedErrorStackFrameImpl copy$default(ProcessedErrorStackFrameImpl processedErrorStackFrameImpl, String str, String str2, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = processedErrorStackFrameImpl.file;
            }
            if ((i & 2) != 0) {
                str2 = processedErrorStackFrameImpl.methodName;
            }
            if ((i & 4) != 0) {
                num = processedErrorStackFrameImpl.lineNumber;
            }
            if ((i & 8) != 0) {
                num2 = processedErrorStackFrameImpl.column;
            }
            return processedErrorStackFrameImpl.copy(str, str2, num, num2);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.methodName;
        }

        public final Integer component3() {
            return this.lineNumber;
        }

        public final Integer component4() {
            return this.column;
        }

        public final ProcessedErrorStackFrameImpl copy(@Nullable String str, @NotNull String methodName, @Nullable Integer num, @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            return new ProcessedErrorStackFrameImpl(str, methodName, num, num2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProcessedErrorStackFrameImpl)) {
                return false;
            }
            ProcessedErrorStackFrameImpl processedErrorStackFrameImpl = (ProcessedErrorStackFrameImpl) obj;
            return Intrinsics.areEqual(this.file, processedErrorStackFrameImpl.file) && Intrinsics.areEqual(this.methodName, processedErrorStackFrameImpl.methodName) && Intrinsics.areEqual(this.lineNumber, processedErrorStackFrameImpl.lineNumber) && Intrinsics.areEqual(this.column, processedErrorStackFrameImpl.column);
        }

        public int hashCode() {
            String str = this.file;
            int iHashCode = str == null ? 0 : str.hashCode();
            int iHashCode2 = this.methodName.hashCode();
            Integer num = this.lineNumber;
            int iHashCode3 = num == null ? 0 : num.hashCode();
            Integer num2 = this.column;
            return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "ProcessedErrorStackFrameImpl(file=" + this.file + ", methodName=" + this.methodName + ", lineNumber=" + this.lineNumber + ", column=" + this.column + ")";
        }

        public ProcessedErrorStackFrameImpl(@Nullable String str, @NotNull String methodName, @Nullable Integer num, @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            this.file = str;
            this.methodName = methodName;
            this.lineNumber = num;
            this.column = num2;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        public String getFile() {
            return this.file;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        public String getMethodName() {
            return this.methodName;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        public Integer getLineNumber() {
            return this.lineNumber;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        public Integer getColumn() {
            return this.column;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    static final class ProcessedErrorImpl implements ProcessedError {
        private final String componentStack;
        private final ReadableNativeMap extraData;
        private final int id;
        private final boolean isFatal;
        private final String message;
        private final String name;
        private final String originalMessage;
        private final ArrayList<ProcessedErrorStackFrameImpl> stack;

        public final String component1() {
            return this.message;
        }

        public final String component2() {
            return this.originalMessage;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.componentStack;
        }

        public final ArrayList<ProcessedErrorStackFrameImpl> component5() {
            return this.stack;
        }

        public final int component6() {
            return this.id;
        }

        public final boolean component7() {
            return this.isFatal;
        }

        public final ReadableNativeMap component8() {
            return this.extraData;
        }

        public final ProcessedErrorImpl copy(@NotNull String message, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ArrayList<ProcessedErrorStackFrameImpl> stack, int i, boolean z, @NotNull ReadableNativeMap extraData) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            return new ProcessedErrorImpl(message, str, str2, str3, stack, i, z, extraData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProcessedErrorImpl)) {
                return false;
            }
            ProcessedErrorImpl processedErrorImpl = (ProcessedErrorImpl) obj;
            return Intrinsics.areEqual(this.message, processedErrorImpl.message) && Intrinsics.areEqual(this.originalMessage, processedErrorImpl.originalMessage) && Intrinsics.areEqual(this.name, processedErrorImpl.name) && Intrinsics.areEqual(this.componentStack, processedErrorImpl.componentStack) && Intrinsics.areEqual(this.stack, processedErrorImpl.stack) && this.id == processedErrorImpl.id && this.isFatal == processedErrorImpl.isFatal && Intrinsics.areEqual(this.extraData, processedErrorImpl.extraData);
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode();
            String str = this.originalMessage;
            int iHashCode2 = str == null ? 0 : str.hashCode();
            String str2 = this.name;
            int iHashCode3 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.componentStack;
            return (((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + this.stack.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + Boolean.hashCode(this.isFatal)) * 31) + this.extraData.hashCode();
        }

        public String toString() {
            return "ProcessedErrorImpl(message=" + this.message + ", originalMessage=" + this.originalMessage + ", name=" + this.name + ", componentStack=" + this.componentStack + ", stack=" + this.stack + ", id=" + this.id + ", isFatal=" + this.isFatal + ", extraData=" + this.extraData + ")";
        }

        public ProcessedErrorImpl(@NotNull String message, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ArrayList<ProcessedErrorStackFrameImpl> stack, int i, boolean z, @NotNull ReadableNativeMap extraData) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            this.message = message;
            this.originalMessage = str;
            this.name = str2;
            this.componentStack = str3;
            this.stack = stack;
            this.id = i;
            this.isFatal = z;
            this.extraData = extraData;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public String getMessage() {
            return this.message;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public String getOriginalMessage() {
            return this.originalMessage;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public String getName() {
            return this.name;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public String getComponentStack() {
            return this.componentStack;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public ArrayList<ProcessedErrorStackFrameImpl> getStack() {
            return this.stack;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public int getId() {
            return this.id;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public boolean isFatal() {
            return this.isFatal;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public ReadableNativeMap getExtraData() {
            return this.extraData;
        }
    }
}
