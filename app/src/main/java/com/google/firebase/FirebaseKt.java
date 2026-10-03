package com.google.firebase;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class FirebaseKt {
    public static final FirebaseApp getApp(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseApp, "getInstance()");
        return firebaseApp;
    }

    public static final FirebaseApp app(@NotNull Firebase firebase2, @NotNull String name) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        Intrinsics.checkNotNullExpressionValue(firebaseApp, "getInstance(name)");
        return firebaseApp;
    }

    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context, @NotNull FirebaseOptions options) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options);
        Intrinsics.checkNotNullExpressionValue(firebaseAppInitializeApp, "initializeApp(context, options)");
        return firebaseAppInitializeApp;
    }

    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context, @NotNull FirebaseOptions options, @NotNull String name) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(name, "name");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options, name);
        Intrinsics.checkNotNullExpressionValue(firebaseAppInitializeApp, "initializeApp(context, options, name)");
        return firebaseAppInitializeApp;
    }

    public static final FirebaseOptions getOptions(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "Firebase.app.options");
        return options;
    }

    private static final /* synthetic */ <T extends Annotation> Component<CoroutineDispatcher> coroutineDispatcher() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Component.Builder builder = Component.builder(Qualified.qualified(Annotation.class, CoroutineDispatcher.class));
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Component.Builder builderAdd = builder.add(Dependency.required((Qualified<?>) Qualified.qualified(Annotation.class, Executor.class)));
        Intrinsics.needClassReification();
        Component<CoroutineDispatcher> componentBuild = builderAdd.factory(new ComponentFactory() { // from class: com.google.firebase.FirebaseKt.coroutineDispatcher.1
            @Override // com.google.firebase.components.ComponentFactory
            public final CoroutineDispatcher create(ComponentContainer componentContainer) {
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                Object obj = componentContainer.get(Qualified.qualified(Annotation.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.from((Executor) obj);
            }
        }).build();
        Intrinsics.checkNotNullExpressionValue(componentBuild, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return componentBuild;
    }
}
