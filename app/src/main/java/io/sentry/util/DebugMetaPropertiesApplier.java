package io.sentry.util;

import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class DebugMetaPropertiesApplier {
    public static String DEBUG_META_PROPERTIES_FILENAME = "sentry-debug-meta.properties";

    public static void apply(@NotNull SentryOptions sentryOptions, @Nullable List<Properties> list) {
        if (list != null) {
            applyToOptions(sentryOptions, list);
            applyBuildTool(sentryOptions, list);
        }
    }

    public static void applyToOptions(@NotNull SentryOptions sentryOptions, @Nullable List<Properties> list) {
        if (list != null) {
            applyBundleIds(sentryOptions, list);
            applyProguardUuid(sentryOptions, list);
        }
    }

    private static void applyBundleIds(@NotNull SentryOptions sentryOptions, @NotNull List<Properties> list) {
        if (sentryOptions.getBundleIds().isEmpty()) {
            Iterator<Properties> it2 = list.iterator();
            while (it2.hasNext()) {
                String property = it2.next().getProperty("io.sentry.bundle-ids");
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Bundle IDs found: %s", property);
                if (property != null) {
                    for (String str : property.split(",", -1)) {
                        sentryOptions.addBundleId(str);
                    }
                }
            }
        }
    }

    private static void applyProguardUuid(@NotNull SentryOptions sentryOptions, @NotNull List<Properties> list) {
        if (sentryOptions.getProguardUuid() == null) {
            Iterator<Properties> it2 = list.iterator();
            while (it2.hasNext()) {
                String proguardUuid = getProguardUuid(it2.next());
                if (proguardUuid != null) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Proguard UUID found: %s", proguardUuid);
                    sentryOptions.setProguardUuid(proguardUuid);
                    return;
                }
            }
        }
    }

    private static void applyBuildTool(@NotNull SentryOptions sentryOptions, @NotNull List<Properties> list) {
        for (Properties properties : list) {
            String buildTool = getBuildTool(properties);
            if (buildTool != null) {
                String buildToolVersion = getBuildToolVersion(properties);
                if (buildToolVersion == null) {
                    buildToolVersion = "unknown";
                }
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Build tool found: %s, version %s", buildTool, buildToolVersion);
                SentryIntegrationPackageStorage.getInstance().addPackage(buildTool, buildToolVersion);
                return;
            }
        }
    }

    public static String getProguardUuid(@NotNull Properties properties) {
        return properties.getProperty("io.sentry.ProguardUuids");
    }

    public static String getBuildTool(@NotNull Properties properties) {
        return properties.getProperty("io.sentry.build-tool");
    }

    public static String getBuildToolVersion(@NotNull Properties properties) {
        return properties.getProperty("io.sentry.build-tool-version");
    }
}
