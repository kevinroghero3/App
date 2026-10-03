package com.salesforce.marketingcloud.sfmcsdk.components.behaviors;

import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class BehaviorTypeKt {
    private static final String INTENT_FILTER_APPLICATION_BACKGROUNDED = "com.salesforce.marketingcloud.sfmcsdk.sdk.APPLICATION_BACKGROUNDED";
    private static final String INTENT_FILTER_APPLICATION_FOREGROUNDED = "com.salesforce.marketingcloud.sfmcsdk.sdk.APPLICATION_FOREGROUNDED";
    private static final String INTENT_FILTER_APP_VERSION_CHANGED = "com.salesforce.marketingcloud.sfmcsdk.sdk.APP_VERSION_CHANGED";
    private static final String INTENT_FILTER_SCREEN_ENTRY = "com.salesforce.marketingcloud.sfmcsdk.sdk.SCREEN_ENTRY";

    public static final Event toEvent(@NotNull Behavior behavior) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(behavior, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String appVersion = behavior.getAppVersion();
        if (appVersion != null) {
            linkedHashMap.put(BehaviorManagerImpl.BUNDLE_KEY_CURRENT_VERSION, appVersion);
        }
        String appName = behavior.getAppName();
        if (appName != null) {
            linkedHashMap.put(BehaviorManagerImpl.BUNDLE_KEY_APP_NAME, appName);
        }
        if (behavior instanceof Behavior.AppVersionChanged) {
            String previousVersion = behavior.getPreviousVersion();
            if (previousVersion != null) {
                linkedHashMap.put(BehaviorManagerImpl.BUNDLE_KEY_PREVIOUS_VERSION, previousVersion);
            }
            strValueOf = String.valueOf(Reflection.getOrCreateKotlinClass(behavior.getClass()).getSimpleName());
        } else if (behavior instanceof Behavior.ScreenEntry) {
            linkedHashMap.put("screen_name", ((Behavior.ScreenEntry) behavior).getName());
            strValueOf = String.valueOf(Reflection.getOrCreateKotlinClass(behavior.getClass()).getSimpleName());
        } else {
            strValueOf = String.valueOf(Reflection.getOrCreateKotlinClass(behavior.getClass()).getSimpleName());
        }
        return EventManager.Companion.customEvent(strValueOf, linkedHashMap, Event.Producer.SFMC_SDK, Event.Category.SYSTEM);
    }
}
