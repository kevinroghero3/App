package com.facebook.bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AppLink {
    private final Uri sourceUrl;
    private final List<Target> targets;
    private final Uri webUrl;

    public AppLink(@NotNull Uri sourceUrl, @Nullable List<Target> list, @NotNull Uri webUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        this.sourceUrl = sourceUrl;
        this.webUrl = webUrl;
        this.targets = list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    public final Uri getWebUrl() {
        return this.webUrl;
    }

    public static final class Target {
        private final String appName;
        private final String className;
        private final String packageName;
        private final Uri url;

        public Target(@NotNull String packageName, @NotNull String className, @NotNull Uri url, @NotNull String appName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(appName, "appName");
            this.packageName = packageName;
            this.className = className;
            this.url = url;
            this.appName = appName;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getClassName() {
            return this.className;
        }

        public final Uri getUrl() {
            return this.url;
        }

        public final String getAppName() {
            return this.appName;
        }
    }

    public final List<Target> getTargets() {
        List<Target> listUnmodifiableList = Collections.unmodifiableList(this.targets);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(field)");
        return listUnmodifiableList;
    }
}
