package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AppEventDiskStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();
    private static final String TAG = AppEventDiskStore.class.getName();

    private AppEventDiskStore() {
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0090 A[Catch: all -> 0x0097, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:8:0x002b, B:9:0x002e, B:42:0x0090, B:12:0x0039, B:21:0x004f, B:22:0x0052, B:25:0x005d, B:40:0x0089, B:28:0x0063, B:29:0x0066, B:33:0x0078, B:32:0x0071, B:35:0x007a, B:36:0x007d), top: B:56:0x0003, inners: #0, #5 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    @JvmStatic
    public static final PersistedEvents readAndClearStore() {
        MovedClassObjectInputStream movedClassObjectInputStream;
        PersistedEvents persistedEvents;
        Object obj;
        Object obj2;
        Object obj3;
        synchronized (AppEventDiskStore.class) {
            AppEventUtility.assertIsNotMainThread();
            ?? applicationContext = FacebookSdk.getApplicationContext();
            ?? r2 = 0;
            persistedEvents = null;
            persistedEvents = null;
            persistedEvents = null;
            try {
                try {
                    FileInputStream fileInputStreamOpenFileInput = applicationContext.openFileInput(PERSISTED_EVENTS_FILENAME);
                    Intrinsics.checkNotNullExpressionValue(fileInputStreamOpenFileInput, "context.openFileInput(PERSISTED_EVENTS_FILENAME)");
                    movedClassObjectInputStream = new MovedClassObjectInputStream(new BufferedInputStream(fileInputStreamOpenFileInput));
                    try {
                        Object object = movedClassObjectInputStream.readObject();
                        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents");
                        PersistedEvents persistedEvents2 = (PersistedEvents) object;
                        Utility.closeQuietly(movedClassObjectInputStream);
                        try {
                            File fileStreamPath = applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME);
                            fileStreamPath.delete();
                            obj3 = fileStreamPath;
                            obj2 = movedClassObjectInputStream;
                        } catch (Exception e) {
                            SentryLogcatAdapter.w(TAG, "Got unexpected exception when removing events file: ", e);
                            obj3 = e;
                            obj2 = "Got unexpected exception when removing events file: ";
                        }
                        persistedEvents = persistedEvents2;
                        applicationContext = obj3;
                        obj = obj2;
                    } catch (FileNotFoundException unused) {
                        Utility.closeQuietly(movedClassObjectInputStream);
                        try {
                            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        } catch (Exception e2) {
                            e = e2;
                            SentryLogcatAdapter.w(TAG, "Got unexpected exception when removing events file: ", e);
                        }
                        if (persistedEvents == null) {
                            persistedEvents = new PersistedEvents();
                        }
                        return persistedEvents;
                    } catch (Exception e3) {
                        e = e3;
                        SentryLogcatAdapter.w(TAG, "Got unexpected exception while reading events: ", e);
                        Utility.closeQuietly(movedClassObjectInputStream);
                        try {
                            File fileStreamPath2 = applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME);
                            fileStreamPath2.delete();
                            applicationContext = fileStreamPath2;
                            obj = movedClassObjectInputStream;
                        } catch (Exception e4) {
                            e = e4;
                            SentryLogcatAdapter.w(TAG, "Got unexpected exception when removing events file: ", e);
                        }
                    }
                } catch (FileNotFoundException unused2) {
                    movedClassObjectInputStream = null;
                } catch (Exception e5) {
                    e = e5;
                    movedClassObjectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Utility.closeQuietly(r2);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e6) {
                        SentryLogcatAdapter.w(TAG, "Got unexpected exception when removing events file: ", e6);
                    }
                    throw th;
                }
                if (persistedEvents == null) {
                    persistedEvents = new PersistedEvents();
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = obj;
                Utility.closeQuietly(r2);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                throw th;
            }
        }
        return persistedEvents;
    }

    @JvmStatic
    public static final void saveEventsToDisk$facebook_core_release(@Nullable PersistedEvents persistedEvents) {
        ObjectOutputStream objectOutputStream;
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream.writeObject(persistedEvents);
            } catch (Throwable th) {
                th = th;
                try {
                    SentryLogcatAdapter.w(TAG, "Got unexpected exception while persisting events: ", th);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    Utility.closeQuietly(objectOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
        }
    }

    static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        public static final Companion Companion = new Companion(null);

        public MovedClassObjectInputStream(@Nullable InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual(resultClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(resultClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(resultClassDescriptor, "resultClassDescriptor");
            return resultClassDescriptor;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
