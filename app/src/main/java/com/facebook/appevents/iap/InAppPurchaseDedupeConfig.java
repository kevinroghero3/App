package com.facebook.appevents.iap;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class InAppPurchaseDedupeConfig {
    public static final InAppPurchaseDedupeConfig INSTANCE = new InAppPurchaseDedupeConfig();
    private static final List<String> defaultCurrencyParameterEquivalents = CollectionsKt__CollectionsJVMKt.listOf(AppEventsConstants.EVENT_PARAM_CURRENCY);
    private static final List<String> defaultValueParameterEquivalents = CollectionsKt__CollectionsJVMKt.listOf(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM);
    private static final long defaultDedupeWindow = TimeUnit.MINUTES.toMillis(1);
    private static final List<Pair<String, List<String>>> defaultDedupeParameters = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Constants.IAP_PRODUCT_ID, CollectionsKt__CollectionsJVMKt.listOf(Constants.IAP_PRODUCT_ID)), TuplesKt.to(Constants.IAP_PRODUCT_DESCRIPTION, CollectionsKt__CollectionsJVMKt.listOf(Constants.IAP_PRODUCT_DESCRIPTION)), TuplesKt.to(Constants.IAP_PRODUCT_TITLE, CollectionsKt__CollectionsJVMKt.listOf(Constants.IAP_PRODUCT_TITLE)), TuplesKt.to(Constants.IAP_PURCHASE_TOKEN, CollectionsKt__CollectionsJVMKt.listOf(Constants.IAP_PURCHASE_TOKEN))});

    private InAppPurchaseDedupeConfig() {
    }

    public final List<Pair<String, List<String>>> getDedupeParameters(boolean z) {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getProdDedupeParameters() : null) == null || appSettingsWithoutQuery.getProdDedupeParameters().isEmpty()) {
            return defaultDedupeParameters;
        }
        if (!z) {
            return appSettingsWithoutQuery.getProdDedupeParameters();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, List<String>> pair : appSettingsWithoutQuery.getProdDedupeParameters()) {
            Iterator<String> it2 = pair.getSecond().iterator();
            while (it2.hasNext()) {
                arrayList.add(new Pair(it2.next(), CollectionsKt__CollectionsJVMKt.listOf(pair.getFirst())));
            }
        }
        return arrayList;
    }

    public final List<Pair<String, List<String>>> getTestDedupeParameters(boolean z) {
        List<Pair<String, List<String>>> testDedupeParameters;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null || (testDedupeParameters = appSettingsWithoutQuery.getTestDedupeParameters()) == null || testDedupeParameters.isEmpty()) {
            return null;
        }
        if (!z) {
            return appSettingsWithoutQuery.getTestDedupeParameters();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, List<String>> pair : appSettingsWithoutQuery.getTestDedupeParameters()) {
            Iterator<String> it2 = pair.getSecond().iterator();
            while (it2.hasNext()) {
                arrayList.add(new Pair(it2.next(), CollectionsKt__CollectionsJVMKt.listOf(pair.getFirst())));
            }
        }
        return arrayList;
    }

    public final List<String> getCurrencyParameterEquivalents() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getCurrencyDedupeParameters() : null) == null || appSettingsWithoutQuery.getCurrencyDedupeParameters().isEmpty()) {
            return defaultCurrencyParameterEquivalents;
        }
        return appSettingsWithoutQuery.getCurrencyDedupeParameters();
    }

    public final List<String> getValueParameterEquivalents() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getPurchaseValueDedupeParameters() : null) == null || appSettingsWithoutQuery.getPurchaseValueDedupeParameters().isEmpty()) {
            return defaultValueParameterEquivalents;
        }
        return appSettingsWithoutQuery.getPurchaseValueDedupeParameters();
    }

    public final Currency getCurrencyOfManualEvent(@Nullable Bundle bundle) {
        Iterator<String> it2 = getCurrencyParameterEquivalents().iterator();
        while (true) {
            String string = null;
            if (!it2.hasNext()) {
                return null;
            }
            String next = it2.next();
            if (bundle != null) {
                try {
                    string = bundle.getString(next);
                    if (string != null && string.length() != 0) {
                        return Currency.getInstance(string);
                    }
                } catch (Exception unused) {
                    continue;
                }
            } else {
                if (string != null) {
                    return Currency.getInstance(string);
                }
                continue;
            }
        }
    }

    public final Double getValueOfManualEvent(@Nullable Double d, @Nullable Bundle bundle) {
        if (d != null) {
            return d;
        }
        Iterator<String> it2 = getValueParameterEquivalents().iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (bundle != null) {
                try {
                    return Double.valueOf(bundle.getDouble(next));
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public final long getDedupeWindow() {
        Long dedupeWindow;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getDedupeWindow() : null) == null || ((dedupeWindow = appSettingsWithoutQuery.getDedupeWindow()) != null && dedupeWindow.longValue() == 0)) {
            return defaultDedupeWindow;
        }
        return appSettingsWithoutQuery.getDedupeWindow().longValue();
    }

    public final Pair<Bundle, OperationalData> addDedupeParameters(@Nullable Bundle bundle, @Nullable Bundle bundle2, @Nullable OperationalData operationalData) {
        if (bundle == null) {
            return new Pair<>(bundle2, operationalData);
        }
        try {
            for (String key : bundle.keySet()) {
                String string = bundle.getString(key);
                if (string != null) {
                    OperationalData.Companion companion = OperationalData.Companion;
                    OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    Pair<Bundle, OperationalData> pairAddParameterAndReturn = companion.addParameterAndReturn(operationalDataEnum, key, string, bundle2, operationalData);
                    Bundle bundleComponent1 = pairAddParameterAndReturn.component1();
                    operationalData = pairAddParameterAndReturn.component2();
                    bundle2 = bundleComponent1;
                }
            }
        } catch (Exception unused) {
        }
        return new Pair<>(bundle2, operationalData);
    }
}
