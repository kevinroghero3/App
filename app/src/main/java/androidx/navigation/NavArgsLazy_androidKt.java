package androidx.navigation;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class NavArgsLazy_androidKt {
    private static final Class<Bundle>[] methodSignature = {Bundle.class};
    private static final ArrayMap<KClass<? extends NavArgs>, Method> methodMap = new ArrayMap<>();

    public static final Class<Bundle>[] getMethodSignature() {
        return methodSignature;
    }

    public static final ArrayMap<KClass<? extends NavArgs>, Method> getMethodMap() {
        return methodMap;
    }
}
