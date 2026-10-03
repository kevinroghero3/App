package com.alpha0010.fs;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import android.widget.ExpandableListView;
import androidx.documentfile.provider.DocumentFile;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeMap;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import io.sentry.protocol.DebugMeta;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import o.ArtificialStackFrames;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class FileAccessModule extends FileAccessSpec {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "FileAccess";
    private final Map<Integer, WeakReference<Call>> fetchCalls;
    private final CoroutineScope ioScope;

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void addListener(@NotNull String eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void removeListeners(double d) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAccessModule(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fetchCalls = new LinkedHashMap();
        this.ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    protected Map<String, String> getTypedExportedConstants() {
        String str;
        try {
            str = System.getenv("SECONDARY_STORAGE");
            if (str == null) {
                str = System.getenv("EXTERNAL_STORAGE");
            }
        } catch (Throwable unused) {
            str = null;
        }
        return MapsKt__MapsKt.hashMapOf(TuplesKt.to("CacheDir", getReactApplicationContext().getCacheDir().getAbsolutePath()), TuplesKt.to("DatabaseDir", getReactApplicationContext().getDatabasePath("FileAccessProbe").getParent()), TuplesKt.to("DocumentDir", getReactApplicationContext().getFilesDir().getAbsolutePath()), TuplesKt.to("MainBundleDir", getReactApplicationContext().getApplicationInfo().dataDir), TuplesKt.to("SDCardDir", str));
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$appendFile$1, reason: invalid class name */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$appendFile$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        final /* synthetic */ String $encoding;
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$encoding = str;
            this.$path = str2;
            this.$data = str3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$encoding, this.$path, this.$data, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (Intrinsics.areEqual(this.$encoding, ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
                    File pathToFile = UtilKt.parsePathToFile(this.$path);
                    byte[] bArrDecode = Base64.decode(this.$data, 0);
                    Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                    FilesKt__FileReadWriteKt.appendBytes(pathToFile, bArrDecode);
                } else {
                    FilesKt__FileReadWriteKt.appendText$default(UtilKt.parsePathToFile(this.$path), this.$data, null, 2, null);
                }
                this.$promise.resolve(null);
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void appendFile(@NotNull String path, @NotNull String data, @NotNull String encoding, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new AnonymousClass1(encoding, path, data, promise, null), 3, null);
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void cancelFetch(double d, @NotNull Promise promise) {
        Call call;
        Intrinsics.checkNotNullParameter(promise, "promise");
        WeakReference<Call> weakReferenceRemove = this.fetchCalls.remove(Integer.valueOf((int) d));
        if (weakReferenceRemove != null && (call = weakReferenceRemove.get()) != null) {
            call.cancel();
        }
        promise.resolve(null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$concatFiles$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$concatFiles$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $source;
        final /* synthetic */ String $target;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02891(String str, Promise promise, String str2, Continuation<? super C02891> continuation) {
            super(2, continuation);
            this.$source = str;
            this.$promise = promise;
            this.$target = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileAccessModule.this.new C02891(this.$source, this.$promise, this.$target, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    InputStream inputStreamOpenForReading = FileAccessModule.this.openForReading(this.$source);
                    String str = this.$target;
                    Promise promise = this.$promise;
                    try {
                        File pathToFile = UtilKt.parsePathToFile(str);
                        FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(pathToFile, true), pathToFile, true);
                        try {
                            promise.resolve(Boxing.boxInt((int) ByteStreamsKt.copyTo$default(inputStreamOpenForReading, fileOutputStreamCreate, 0, 2, null)));
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStreamCreate, null);
                            CloseableKt.closeFinally(inputStreamOpenForReading, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(fileOutputStreamCreate, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(inputStreamOpenForReading, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    this.$promise.reject(th5);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void concatFiles(@NotNull String source, @NotNull String target, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02891(source, promise, target, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$cp$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$cp$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $source;
        final /* synthetic */ String $target;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02901(String str, Promise promise, String str2, Continuation<? super C02901> continuation) {
            super(2, continuation);
            this.$source = str;
            this.$promise = promise;
            this.$target = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileAccessModule.this.new C02901(this.$source, this.$promise, this.$target, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    InputStream inputStreamOpenForReading = FileAccessModule.this.openForReading(this.$source);
                    try {
                        OutputStream outputStreamOpenForWriting = FileAccessModule.this.openForWriting(this.$target);
                        try {
                            ByteStreamsKt.copyTo$default(inputStreamOpenForReading, outputStreamOpenForWriting, 0, 2, null);
                            CloseableKt.closeFinally(outputStreamOpenForWriting, null);
                            CloseableKt.closeFinally(inputStreamOpenForReading, null);
                            this.$promise.resolve(null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(outputStreamOpenForWriting, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(inputStreamOpenForReading, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    this.$promise.reject(th5);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void cp(@NotNull String source, @NotNull String target, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02901(source, promise, target, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$cpAsset$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$cpAsset$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private static int artificialFrame = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
        final /* synthetic */ String $asset;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $target;
        final /* synthetic */ String $type;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02911(String str, FileAccessModule fileAccessModule, String str2, Promise promise, String str3, Continuation<? super C02911> continuation) {
            super(2, continuation);
            this.$type = str;
            this.this$0 = fileAccessModule;
            this.$asset = str2;
            this.$promise = promise;
            this.$target = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02911(this.$type, this.this$0, this.$asset, this.$promise, this.$target, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x003d A[Catch: all -> 0x0032, TryCatch #1 {all -> 0x0032, blocks: (B:6:0x0026, B:14:0x0066, B:19:0x00b9, B:23:0x00ca, B:33:0x00dd, B:34:0x00e0, B:36:0x00e2, B:38:0x00e8, B:39:0x00e9, B:13:0x003d, B:11:0x0035, B:15:0x0072, B:17:0x007f, B:18:0x00b1, B:20:0x00bd, B:22:0x00c7, B:28:0x00d6, B:29:0x00d9, B:31:0x00db), top: B:47:0x0024, inners: #0, #4, #5 }] */
        /* JADX WARN: Code duplicated, block: B:17:0x007f A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:15:0x0072, B:17:0x007f, B:18:0x00b1), top: B:45:0x0072, outer: #1 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InputStream inputStreamOpenRawResource;
            Object objAccessartificialFrame;
            int i = 2 % 2;
            int i2 = artificialFrame + 17;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = artificialFrame + 5;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
            ResultKt.throwOnFailure(obj);
            try {
                if (i5 != 0) {
                    int i6 = 53 / 0;
                    if (!Intrinsics.areEqual(this.$type, "resource")) {
                        try {
                            Object[] objArr = {this.this$0.getReactApplicationContext().getAssets(), this.$asset};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                            if (objAccessartificialFrame == null) {
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 7116), TextUtils.indexOf((CharSequence) "", '0') + 38, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                            }
                            inputStreamOpenRawResource = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    } else {
                        inputStreamOpenRawResource = this.this$0.getReactApplicationContext().getResources().openRawResource(this.this$0.getReactApplicationContext().getResources().getIdentifier(this.$asset, null, this.this$0.getReactApplicationContext().getPackageName()));
                    }
                } else if (Intrinsics.areEqual(this.$type, "resource")) {
                    inputStreamOpenRawResource = this.this$0.getReactApplicationContext().getResources().openRawResource(this.this$0.getReactApplicationContext().getResources().getIdentifier(this.$asset, null, this.this$0.getReactApplicationContext().getPackageName()));
                } else {
                    Object[] objArr2 = {this.this$0.getReactApplicationContext().getAssets(), this.$asset};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 7116), TextUtils.indexOf((CharSequence) "", '0') + 38, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                    }
                    inputStreamOpenRawResource = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr2);
                }
                try {
                    OutputStream outputStreamOpenForWriting = this.this$0.openForWriting(this.$target);
                    try {
                        Intrinsics.checkNotNull(inputStreamOpenRawResource);
                        ByteStreamsKt.copyTo$default(inputStreamOpenRawResource, outputStreamOpenForWriting, 0, 2, null);
                        CloseableKt.closeFinally(outputStreamOpenForWriting, null);
                        CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                        this.$promise.resolve(null);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(outputStreamOpenForWriting, th2);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        CloseableKt.closeFinally(inputStreamOpenRawResource, th4);
                        throw th5;
                    }
                }
            } catch (Throwable th6) {
                this.$promise.reject(th6);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void cpAsset(@NotNull String asset, @NotNull String target, @NotNull String type, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02911(type, this, asset, promise, target, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$cpExternal$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$cpExternal$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $dir;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $source;
        final /* synthetic */ String $targetName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02921(String str, Promise promise, String str2, String str3, Continuation<? super C02921> continuation) {
            super(2, continuation);
            this.$source = str;
            this.$promise = promise;
            this.$dir = str2;
            this.$targetName = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileAccessModule.this.new C02921(this.$source, this.$promise, this.$dir, this.$targetName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x010d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Uri uriInsert;
            OutputStream outputStreamOpenOutputStream;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    InputStream inputStreamOpenForReading = FileAccessModule.this.openForReading(this.$source);
                    String str = this.$dir;
                    FileAccessModule fileAccessModule = FileAccessModule.this;
                    String str2 = this.$targetName;
                    Promise promise = this.$promise;
                    try {
                        if (Intrinsics.areEqual(str, "downloads")) {
                            if (Build.VERSION.SDK_INT >= 29) {
                                ContentResolver contentResolver = fileAccessModule.getReactApplicationContext().getContentResolver();
                                Uri uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("_display_name", str2);
                                Unit unit = Unit.INSTANCE;
                                Uri uriInsert2 = contentResolver.insert(uri, contentValues);
                                if (uriInsert2 != null) {
                                    outputStreamOpenOutputStream = fileAccessModule.getReactApplicationContext().getContentResolver().openOutputStream(uriInsert2);
                                } else {
                                    outputStreamOpenOutputStream = null;
                                }
                            } else {
                                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), str2);
                                outputStreamOpenOutputStream = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
                            }
                        } else {
                            int iHashCode = str.hashCode();
                            if (iHashCode != -1185250696) {
                                if (iHashCode != 93166550) {
                                    if (iHashCode == 112202875 && str.equals("video")) {
                                        ContentResolver contentResolver2 = fileAccessModule.getReactApplicationContext().getContentResolver();
                                        Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                                        ContentValues contentValues2 = new ContentValues();
                                        contentValues2.put("_display_name", str2);
                                        Unit unit2 = Unit.INSTANCE;
                                        uriInsert = contentResolver2.insert(uri2, contentValues2);
                                    } else {
                                        uriInsert = null;
                                    }
                                } else if (str.equals("audio")) {
                                    ContentResolver contentResolver3 = fileAccessModule.getReactApplicationContext().getContentResolver();
                                    Uri uri3 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                                    ContentValues contentValues3 = new ContentValues();
                                    contentValues3.put("_display_name", str2);
                                    if (Build.VERSION.SDK_INT < 29) {
                                        contentValues3.put("_data", new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), str2).getAbsolutePath());
                                    }
                                    Unit unit3 = Unit.INSTANCE;
                                    uriInsert = contentResolver3.insert(uri3, contentValues3);
                                } else {
                                    uriInsert = null;
                                }
                            } else if (str.equals(DebugMeta.JsonKeys.IMAGES)) {
                                ContentResolver contentResolver4 = fileAccessModule.getReactApplicationContext().getContentResolver();
                                Uri uri4 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                                ContentValues contentValues4 = new ContentValues();
                                contentValues4.put("_display_name", str2);
                                Unit unit4 = Unit.INSTANCE;
                                uriInsert = contentResolver4.insert(uri4, contentValues4);
                            } else {
                                uriInsert = null;
                            }
                            if (uriInsert != null) {
                                outputStreamOpenOutputStream = fileAccessModule.getReactApplicationContext().getContentResolver().openOutputStream(uriInsert);
                            } else {
                                outputStreamOpenOutputStream = null;
                            }
                        }
                        if (outputStreamOpenOutputStream != null) {
                            try {
                                try {
                                    ByteStreamsKt.copyTo$default(inputStreamOpenForReading, outputStreamOpenOutputStream, 0, 2, null);
                                    promise.resolve(null);
                                } catch (Throwable th) {
                                    promise.reject(th);
                                }
                                Unit unit5 = Unit.INSTANCE;
                                CloseableKt.closeFinally(outputStreamOpenOutputStream, null);
                                CloseableKt.closeFinally(inputStreamOpenForReading, null);
                                return unit5;
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    CloseableKt.closeFinally(outputStreamOpenOutputStream, th2);
                                    throw th3;
                                }
                            }
                        }
                        promise.reject("ERR", "Failed to copy to '" + str2 + "' ('" + str + "')");
                        Unit unit6 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStreamOpenForReading, null);
                        return Unit.INSTANCE;
                        return Unit.INSTANCE;
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(inputStreamOpenForReading, th4);
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    this.$promise.reject(th6);
                }
                this.$promise.reject(th6);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void cpExternal(@NotNull String source, @NotNull String targetName, @NotNull String dir, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(targetName, "targetName");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02921(source, promise, dir, targetName, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$df$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$df$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02931(Promise promise, Continuation<? super C02931> continuation) {
            super(2, continuation);
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileAccessModule.this.new C02931(this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                StatFs statFs = new StatFs(FileAccessModule.this.getReactApplicationContext().getFilesDir().getAbsolutePath());
                Map mapMutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("internal_free", Boxing.boxLong(statFs.getAvailableBytes())), TuplesKt.to("internal_total", Boxing.boxLong(statFs.getTotalBytes())));
                File externalFilesDir = FileAccessModule.this.getReactApplicationContext().getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    StatFs statFs2 = new StatFs(externalFilesDir.getAbsolutePath());
                    mapMutableMapOf.put("external_free", Boxing.boxLong(statFs2.getAvailableBytes()));
                    mapMutableMapOf.put("external_total", Boxing.boxLong(statFs2.getTotalBytes()));
                }
                this.$promise.resolve(Arguments.makeNativeMap((Map<String, Object>) mapMutableMapOf));
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void df(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02931(promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$exists$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$exists$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02941(Promise promise, String str, FileAccessModule fileAccessModule, Continuation<? super C02941> continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.$path = str;
            this.this$0 = fileAccessModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02941(this.$promise, this.$path, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Promise promise = this.$promise;
                String str = this.$path;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                promise.resolve(Boxing.boxBoolean(UtilKt.asDocumentFile(str, reactApplicationContext).exists()));
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void exists(@NotNull String path, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02941(promise, path, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$fetch$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$fetch$1", f = "FileAccessModule.kt", i = {0}, l = {269}, m = "invokeSuspend", n = {"reqId"}, s = {"I$0"})
    static final class C02951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $init;
        final /* synthetic */ double $requestId;
        final /* synthetic */ String $resource;
        int I$0;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02951(double d, FileAccessModule fileAccessModule, String str, ReadableMap readableMap, Continuation<? super C02951> continuation) {
            super(2, continuation);
            this.$requestId = d;
            this.this$0 = fileAccessModule;
            this.$resource = str;
            this.$init = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02951(this.$requestId, this.this$0, this.$resource, this.$init, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                final int i3 = (int) this.$requestId;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                NetworkHandler networkHandler = new NetworkHandler(reactApplicationContext);
                String str = this.$resource;
                ReadableMap readableMap = this.$init;
                final FileAccessModule fileAccessModule = this.this$0;
                Function0<Unit> function0 = new Function0() { // from class: com.alpha0010.fs.FileAccessModule$fetch$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileAccessModule.C02951.invokeSuspend$lambda$0(fileAccessModule, i3);
                    }
                };
                this.I$0 = i3;
                this.label = 1;
                Object objFetch = networkHandler.fetch(i3, str, readableMap, function0, this);
                if (objFetch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i3;
                obj = objFetch;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
            }
            Call call = (Call) obj;
            if (call != null) {
                FileAccessModule fileAccessModule2 = this.this$0;
                fileAccessModule2.fetchCalls.put(Boxing.boxInt(i), new WeakReference(call));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(FileAccessModule fileAccessModule, int i) {
            fileAccessModule.fetchCalls.remove(Integer.valueOf(i));
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void fetch(double d, @NotNull String resource, @NotNull ReadableMap init) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(init, "init");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C02951(d, this, resource, init, null), 3, null);
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void getAppGroupDir(@NotNull String groupName, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.reject("ERR", "App group unavailable on Android.");
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$hardlink$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$hardlink$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $source;
        final /* synthetic */ String $target;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02961(String str, String str2, Promise promise, Continuation<? super C02961> continuation) {
            super(2, continuation);
            this.$source = str;
            this.$target = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02961(this.$source, this.$target, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (!UtilKt.isContentUri(this.$source) && !UtilKt.isContentUri(this.$target)) {
                    File pathToFile = UtilKt.parsePathToFile(this.$source);
                    File pathToFile2 = UtilKt.parsePathToFile(this.$target);
                    if (!pathToFile.exists()) {
                        this.$promise.reject("ENOENT", "Source file '" + this.$source + "' does not exist");
                        return Unit.INSTANCE;
                    }
                    if (pathToFile2.exists()) {
                        this.$promise.reject("EEXIST", "Target file '" + this.$target + "' already exists");
                        return Unit.INSTANCE;
                    }
                    try {
                        Files.createLink(pathToFile2.toPath(), pathToFile.toPath());
                        this.$promise.resolve(null);
                    } catch (IOException e) {
                        this.$promise.reject("ERR", "Failed to create hard link: " + e.getMessage());
                    }
                    return Unit.INSTANCE;
                }
                this.$promise.reject("ERR", "Hard links are not supported for content URIs");
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void hardlink(@NotNull String source, @NotNull String target, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02961(source, target, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$hash$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$hash$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $algorithm;
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02971(String str, FileAccessModule fileAccessModule, String str2, Promise promise, Continuation<? super C02971> continuation) {
            super(2, continuation);
            this.$algorithm = str;
            this.this$0 = fileAccessModule;
            this.$path = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02971(this.$algorithm, this.this$0, this.$path, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(this.$algorithm);
                InputStream inputStreamOpenForReading = this.this$0.openForReading(this.$path);
                try {
                    byte[] bArr = new byte[8192];
                    for (int i = inputStreamOpenForReading.read(bArr); i >= 0; i = inputStreamOpenForReading.read(bArr)) {
                        messageDigest.update(bArr, 0, i);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStreamOpenForReading, null);
                    Promise promise = this.$promise;
                    byte[] bArrDigest = messageDigest.digest();
                    Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                    promise.resolve(ArraysKt___ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.alpha0010.fs.FileAccessModule$hash$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return FileAccessModule.C02971.invokeSuspend$lambda$1(((Byte) obj2).byteValue());
                        }
                    }, 30, (Object) null));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpenForReading, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                this.$promise.reject(th3);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$1(byte b) {
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void hash(@NotNull String path, @NotNull String algorithm, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02971(algorithm, this, path, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$isDir$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$isDir$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02981(Promise promise, String str, FileAccessModule fileAccessModule, Continuation<? super C02981> continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.$path = str;
            this.this$0 = fileAccessModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02981(this.$promise, this.$path, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Promise promise = this.$promise;
                String str = this.$path;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                promise.resolve(Boxing.boxBoolean(UtilKt.asDocumentFile(str, reactApplicationContext).isDirectory()));
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void isDir(@NotNull String path, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02981(promise, path, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$ls$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$ls$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02991(String str, FileAccessModule fileAccessModule, Promise promise, Continuation<? super C02991> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = fileAccessModule;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02991(this.$path, this.this$0, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                String str = this.$path;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                DocumentFile[] documentFileArrListFiles = UtilKt.asDocumentFile(str, reactApplicationContext).listFiles();
                Intrinsics.checkNotNullExpressionValue(documentFileArrListFiles, "listFiles(...)");
                for (DocumentFile documentFile : documentFileArrListFiles) {
                    writableArrayCreateArray.pushString(documentFile.getName());
                }
                this.$promise.resolve(writableArrayCreateArray);
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void ls(@NotNull String path, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C02991(path, this, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$mkdir$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$mkdir$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03001(String str, FileAccessModule fileAccessModule, Promise promise, Continuation<? super C03001> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = fileAccessModule;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03001(this.$path, this.this$0, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DocumentFile documentFileCreateDirectory;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (UtilKt.isContentUri(this.$path)) {
                    Pair<Uri, String> scopedPath = UtilKt.parseScopedPath(this.$path);
                    Uri uriComponent1 = scopedPath.component1();
                    String strComponent2 = scopedPath.component2();
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.this$0.getReactApplicationContext(), uriComponent1);
                    if (documentFileFromTreeUri == null || (documentFileCreateDirectory = documentFileFromTreeUri.createDirectory(strComponent2)) == null) {
                        throw new IOException("Failed to create directory '" + this.$path + "'.");
                    }
                    this.$promise.resolve(documentFileCreateDirectory.getUri().toString());
                    return Unit.INSTANCE;
                }
                File pathToFile = UtilKt.parsePathToFile(this.$path);
                if (pathToFile.exists()) {
                    this.$promise.reject("EEXIST", "'" + this.$path + "' already exists.");
                } else if (pathToFile.mkdirs()) {
                    this.$promise.resolve(pathToFile.getCanonicalPath());
                } else {
                    this.$promise.reject("EPERM", "Failed to create directory '" + this.$path + "'.");
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void mkdir(@NotNull String path, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03001(path, this, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$mv$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$mv$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $source;
        final /* synthetic */ String $target;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03011(String str, FileAccessModule fileAccessModule, String str2, Promise promise, Continuation<? super C03011> continuation) {
            super(2, continuation);
            this.$source = str;
            this.this$0 = fileAccessModule;
            this.$target = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03011(this.$source, this.this$0, this.$target, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (UtilKt.isContentUri(this.$source)) {
                    String str = this.$source;
                    ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                    if (!UtilKt.asDocumentFile(str, reactApplicationContext).renameTo(this.$target)) {
                        this.$promise.reject("ERR", "Failed to rename '" + this.$source + "' to '" + this.$target + "'.");
                        return Unit.INSTANCE;
                    }
                } else if (!UtilKt.parsePathToFile(this.$source).renameTo(UtilKt.parsePathToFile(this.$target))) {
                    File pathToFile = UtilKt.parsePathToFile(this.$source);
                    FilesKt__UtilsKt.copyTo$default(pathToFile, UtilKt.parsePathToFile(this.$target), true, 0, 4, null);
                    pathToFile.delete();
                }
                this.$promise.resolve(null);
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void mv(@NotNull String source, @NotNull String target, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03011(source, this, target, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$readFile$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$readFile$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $encoding;
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03021(String str, String str2, Promise promise, Continuation<? super C03021> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$encoding = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileAccessModule.this.new C03021(this.$path, this.$encoding, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    InputStream inputStreamOpenForReading = FileAccessModule.this.openForReading(this.$path);
                    try {
                        byte[] bytes = ByteStreamsKt.readBytes(inputStreamOpenForReading);
                        CloseableKt.closeFinally(inputStreamOpenForReading, null);
                        if (Intrinsics.areEqual(this.$encoding, ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
                            this.$promise.resolve(Base64.encodeToString(bytes, 2));
                        } else {
                            this.$promise.resolve(StringsKt__StringsJVMKt.decodeToString(bytes));
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamOpenForReading, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    this.$promise.reject(th3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void readFile(@NotNull String path, @NotNull String encoding, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03021(path, encoding, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$readFileChunk$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$readFileChunk$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $encoding;
        final /* synthetic */ double $length;
        final /* synthetic */ double $offset;
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03031(String str, String str2, Promise promise, double d, double d2, Continuation<? super C03031> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$encoding = str2;
            this.$promise = promise;
            this.$offset = d;
            this.$length = d2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileAccessModule.this.new C03031(this.$path, this.$encoding, this.$promise, this.$offset, this.$length, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String strDecodeToString;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    InputStream inputStreamOpenForReading = FileAccessModule.this.openForReading(this.$path);
                    double d = this.$offset;
                    double d2 = this.$length;
                    try {
                        inputStreamOpenForReading.skip((long) d);
                        byte[] bArr = new byte[(int) d2];
                        inputStreamOpenForReading.read(bArr);
                        CloseableKt.closeFinally(inputStreamOpenForReading, null);
                        if (Intrinsics.areEqual(this.$encoding, ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
                            strDecodeToString = Base64.encodeToString(bArr, 2);
                        } else {
                            strDecodeToString = StringsKt__StringsJVMKt.decodeToString(bArr);
                        }
                        this.$promise.resolve(strDecodeToString);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamOpenForReading, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    this.$promise.reject(th3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void readFileChunk(@NotNull String path, double d, double d2, @NotNull String encoding, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03031(path, encoding, promise, d, d2, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$stat$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$stat$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03041(String str, FileAccessModule fileAccessModule, Promise promise, Continuation<? super C03041> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = fileAccessModule;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03041(this.$path, this.this$0, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                String str = this.$path;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                DocumentFile documentFileAsDocumentFile = UtilKt.asDocumentFile(str, reactApplicationContext);
                if (documentFileAsDocumentFile.exists()) {
                    this.$promise.resolve(this.this$0.statFile(documentFileAsDocumentFile));
                } else {
                    this.$promise.reject("ENOENT", "'" + this.$path + "' does not exist.");
                }
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void stat(@NotNull String path, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03041(path, this, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$statDir$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$statDir$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03051(String str, FileAccessModule fileAccessModule, Promise promise, Continuation<? super C03051> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = fileAccessModule;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03051(this.$path, this.this$0, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                String str = this.$path;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                DocumentFile[] documentFileArrListFiles = UtilKt.asDocumentFile(str, reactApplicationContext).listFiles();
                Intrinsics.checkNotNullExpressionValue(documentFileArrListFiles, "listFiles(...)");
                FileAccessModule fileAccessModule = this.this$0;
                for (DocumentFile documentFile : documentFileArrListFiles) {
                    Intrinsics.checkNotNull(documentFile);
                    writableArrayCreateArray.pushMap(fileAccessModule.statFile(documentFile));
                }
                this.$promise.resolve(writableArrayCreateArray);
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void statDir(@NotNull String path, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03051(path, this, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$symlink$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$symlink$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $source;
        final /* synthetic */ String $target;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03061(String str, String str2, Promise promise, Continuation<? super C03061> continuation) {
            super(2, continuation);
            this.$source = str;
            this.$target = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03061(this.$source, this.$target, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (!UtilKt.isContentUri(this.$source) && !UtilKt.isContentUri(this.$target)) {
                    File pathToFile = UtilKt.parsePathToFile(this.$source);
                    File pathToFile2 = UtilKt.parsePathToFile(this.$target);
                    if (!pathToFile.exists()) {
                        this.$promise.reject("ENOENT", "Source file '" + this.$source + "' does not exist");
                        return Unit.INSTANCE;
                    }
                    if (pathToFile2.exists()) {
                        this.$promise.reject("EEXIST", "Target file '" + this.$target + "' already exists");
                        return Unit.INSTANCE;
                    }
                    try {
                        Files.createSymbolicLink(pathToFile2.toPath(), pathToFile.toPath(), new FileAttribute[0]);
                        this.$promise.resolve(null);
                    } catch (IOException e) {
                        this.$promise.reject("ERR", "Failed to create symbolic link: " + e.getMessage());
                    }
                    return Unit.INSTANCE;
                }
                this.$promise.reject("ERR", "Symbolic links are not supported for content URIs");
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void symlink(@NotNull String source, @NotNull String target, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03061(source, target, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$unlink$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$unlink$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03071(String str, FileAccessModule fileAccessModule, Promise promise, Continuation<? super C03071> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = fileAccessModule;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03071(this.$path, this.this$0, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                String str = this.$path;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                if (UtilKt.asDocumentFile(str, reactApplicationContext).delete()) {
                    this.$promise.resolve(null);
                } else {
                    this.$promise.reject("ERR", "Failed to unlink '" + this.$path + "'.");
                }
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void unlink(@NotNull String path, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03071(path, this, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$unzip$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$unzip$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $source;
        final /* synthetic */ String $target;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03081(String str, FileAccessModule fileAccessModule, String str2, Promise promise, Continuation<? super C03081> continuation) {
            super(2, continuation);
            this.$target = str;
            this.this$0 = fileAccessModule;
            this.$source = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03081(this.$target, this.this$0, this.$source, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                File pathToFile = UtilKt.parsePathToFile(this.$target);
                pathToFile.mkdirs();
                InputStream inputStreamOpenForReading = this.this$0.openForReading(this.$source);
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(inputStreamOpenForReading);
                    try {
                        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                            File file = new File(pathToFile, nextEntry.getName());
                            String canonicalPath = file.getCanonicalPath();
                            Intrinsics.checkNotNullExpressionValue(canonicalPath, "getCanonicalPath(...)");
                            String canonicalPath2 = pathToFile.getCanonicalPath();
                            Intrinsics.checkNotNullExpressionValue(canonicalPath2, "getCanonicalPath(...)");
                            if (!StringsKt__StringsJVMKt.startsWith$default(canonicalPath, canonicalPath2, false, 2, null)) {
                                throw new SecurityException("Failed to extract invalid filename '" + nextEntry.getName() + "'.");
                            }
                            if (nextEntry.isDirectory()) {
                                Boxing.boxBoolean(file.mkdirs());
                            } else {
                                if (file.exists()) {
                                    throw new IOException("Could not extract '" + file.getAbsolutePath() + "' because a file with the same name already exists.");
                                }
                                FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
                                try {
                                    Boxing.boxLong(ByteStreamsKt.copyTo$default(zipInputStream, fileOutputStreamCreate, 0, 2, null));
                                    CloseableKt.closeFinally(fileOutputStreamCreate, null);
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        CloseableKt.closeFinally(fileOutputStreamCreate, th);
                                        throw th2;
                                    }
                                }
                            }
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                CloseableKt.closeFinally(inputStreamOpenForReading, th);
                                throw th3;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(zipInputStream, null);
                        CloseableKt.closeFinally(inputStreamOpenForReading, null);
                        this.$promise.resolve(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(zipInputStream, th4);
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    throw th6;
                }
            } catch (Throwable th7) {
                this.$promise.reject(th7);
            }
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void unzip(@NotNull String source, @NotNull String target, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03081(target, this, source, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.FileAccessModule$writeFile$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.FileAccessModule$writeFile$1", f = "FileAccessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        final /* synthetic */ String $encoding;
        final /* synthetic */ String $path;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ FileAccessModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03091(String str, FileAccessModule fileAccessModule, String str2, Promise promise, String str3, Continuation<? super C03091> continuation) {
            super(2, continuation);
            this.$encoding = str;
            this.this$0 = fileAccessModule;
            this.$path = str2;
            this.$promise = promise;
            this.$data = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03091(this.$encoding, this.this$0, this.$path, this.$promise, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (Intrinsics.areEqual(this.$encoding, ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
                    OutputStream outputStreamOpenForWriting = this.this$0.openForWriting(this.$path);
                    try {
                        outputStreamOpenForWriting.write(Base64.decode(this.$data, 0));
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStreamOpenForWriting, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(outputStreamOpenForWriting, th);
                            throw th2;
                        }
                    }
                } else {
                    OutputStream outputStreamOpenForWriting2 = this.this$0.openForWriting(this.$path);
                    try {
                        byte[] bytes = this.$data.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        outputStreamOpenForWriting2.write(bytes);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStreamOpenForWriting2, null);
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(outputStreamOpenForWriting2, th3);
                            throw th4;
                        }
                    }
                }
                this.$promise.resolve(null);
            } catch (Throwable th5) {
                this.$promise.reject(th5);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.alpha0010.fs.FileAccessSpec
    @ReactMethod
    public void writeFile(@NotNull String path, @NotNull String data, @NotNull String encoding, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C03091(encoding, this, path, promise, data, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream openForReading(String str) throws FileNotFoundException {
        if (UtilKt.isContentUri(str)) {
            InputStream inputStreamOpenInputStream = getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(str));
            Intrinsics.checkNotNull(inputStreamOpenInputStream);
            return inputStreamOpenInputStream;
        }
        File pathToFile = UtilKt.parsePathToFile(str);
        return SentryFileInputStream.Factory.create(new FileInputStream(pathToFile), pathToFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutputStream openForWriting(String str) throws Exception {
        DocumentFile documentFileCreateFile;
        if (UtilKt.isContentUri(str)) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            DocumentFile documentFileAsDocumentFile = UtilKt.asDocumentFile(str, reactApplicationContext);
            if (documentFileAsDocumentFile.isFile()) {
                OutputStream outputStreamOpenOutputStream = getReactApplicationContext().getContentResolver().openOutputStream(documentFileAsDocumentFile.getUri());
                Intrinsics.checkNotNull(outputStreamOpenOutputStream);
                return outputStreamOpenOutputStream;
            }
            Pair<Uri, String> scopedPath = UtilKt.parseScopedPath(str);
            Uri uriComponent1 = scopedPath.component1();
            String strComponent2 = scopedPath.component2();
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(getReactApplicationContext(), uriComponent1);
            if (documentFileFromTreeUri == null || (documentFileCreateFile = documentFileFromTreeUri.createFile(guessMimeType(strComponent2), strComponent2)) == null) {
                throw new IOException("Failed to open '" + str + "' for writing.");
            }
            OutputStream outputStreamOpenOutputStream2 = getReactApplicationContext().getContentResolver().openOutputStream(documentFileCreateFile.getUri());
            Intrinsics.checkNotNull(outputStreamOpenOutputStream2);
            return outputStreamOpenOutputStream2;
        }
        File pathToFile = UtilKt.parsePathToFile(str);
        return SentryFileOutputStream.Factory.create(new FileOutputStream(pathToFile), pathToFile);
    }

    private final String guessMimeType(String str) {
        String strSubstringAfterLast = StringsKt__StringsKt.substringAfterLast(str, ".", "");
        if (strSubstringAfterLast.length() > 0) {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String lowerCase = strSubstringAfterLast.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableMap statFile(DocumentFile documentFile) {
        WritableNativeMap writableNativeMapMakeNativeMap = Arguments.makeNativeMap((Map<String, Object>) MapsKt__MapsKt.mapOf(TuplesKt.to("filename", documentFile.getName()), TuplesKt.to("lastModified", Long.valueOf(documentFile.lastModified())), TuplesKt.to("path", Intrinsics.areEqual(documentFile.getUri().getScheme(), "file") ? documentFile.getUri().getPath() : documentFile.getUri().toString()), TuplesKt.to(RRWebVideoEvent.JsonKeys.SIZE, Long.valueOf(documentFile.length())), TuplesKt.to("type", documentFile.isDirectory() ? "directory" : "file")));
        Intrinsics.checkNotNullExpressionValue(writableNativeMapMakeNativeMap, "makeNativeMap(...)");
        return writableNativeMapMakeNativeMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
