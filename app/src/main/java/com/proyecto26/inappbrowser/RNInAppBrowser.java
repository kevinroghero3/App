package com.proyecto26.inappbrowser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes.dex */
public class RNInAppBrowser {
    private static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    private static final String CHROME_PACKAGE_BETA = "com.chrome.beta";
    private static final String CHROME_PACKAGE_DEV = "com.chrome.dev";
    private static final String CHROME_PACKAGE_STABLE = "com.android.chrome";
    private static final String ERROR_CODE = "InAppBrowser";
    private static final String KEY_ANIMATIONS = "animations";
    private static final String KEY_ANIMATION_END_ENTER = "endEnter";
    private static final String KEY_ANIMATION_END_EXIT = "endExit";
    private static final String KEY_ANIMATION_START_ENTER = "startEnter";
    private static final String KEY_ANIMATION_START_EXIT = "startExit";
    private static final String KEY_BROWSER_PACKAGE = "browserPackage";
    private static final String KEY_DEFAULT_SHARE_MENU_ITEM = "enableDefaultShare";
    private static final String KEY_ENABLE_URL_BAR_HIDING = "enableUrlBarHiding";
    private static final String KEY_FORCE_CLOSE_ON_REDIRECTION = "forceCloseOnRedirection";
    private static final String KEY_HAS_BACK_BUTTON = "hasBackButton";
    private static final String KEY_HEADERS = "headers";
    private static final String KEY_INCLUDE_REFERRER = "includeReferrer";
    private static final String KEY_NAVIGATION_BAR_COLOR = "navigationBarColor";
    private static final String KEY_NAVIGATION_BAR_DIVIDER_COLOR = "navigationBarDividerColor";
    private static final String KEY_SECONDARY_TOOLBAR_COLOR = "secondaryToolbarColor";
    private static final String KEY_SHOW_IN_RECENTS = "showInRecents";
    private static final String KEY_SHOW_PAGE_TITLE = "showTitle";
    private static final String KEY_TOOLBAR_COLOR = "toolbarColor";
    private static final String LOCAL_PACKAGE = "com.google.android.apps.chrome";
    private static RNInAppBrowser _inAppBrowser;
    private static final Pattern animationIdentifierPattern = Pattern.compile("^.+:.+/");
    private Activity currentActivity;
    private CustomTabsClient customTabsClient;
    private Boolean isLightTheme;
    private Promise mOpenBrowserPromise;

    public static RNInAppBrowser getInstance() {
        if (_inAppBrowser == null) {
            _inAppBrowser = new RNInAppBrowser();
        }
        return _inAppBrowser;
    }

    public Integer setColor(CustomTabsIntent.Builder builder, ReadableMap readableMap, String str, String str2, String str3) {
        String string;
        Integer numValueOf = null;
        try {
            try {
                if (!readableMap.hasKey(str)) {
                    return null;
                }
                string = readableMap.getString(str);
                try {
                    numValueOf = Integer.valueOf(Color.parseColor(string));
                    builder.getClass().getDeclaredMethod(str2, Integer.TYPE).invoke(builder, numValueOf);
                    return numValueOf;
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable unused) {
                return numValueOf;
            }
        } catch (Exception e2) {
            e = e2;
            string = null;
        }
        if (!(e instanceof IllegalArgumentException)) {
            return numValueOf;
        }
        throw new JSApplicationIllegalArgumentException("Invalid " + str3 + " color '" + string + "': " + e.getMessage());
    }

    public void open(Context context, ReadableMap readableMap, Promise promise, Activity activity) {
        ReadableMap map;
        String string = readableMap.getString("url");
        this.currentActivity = activity;
        if (this.mOpenBrowserPromise != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", "cancel");
            this.mOpenBrowserPromise.resolve(writableMapCreateMap);
            this.mOpenBrowserPromise = null;
            return;
        }
        this.mOpenBrowserPromise = promise;
        if (activity == null) {
            promise.reject(ERROR_CODE, "No activity");
            this.mOpenBrowserPromise = null;
            return;
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        this.isLightTheme = Boolean.FALSE;
        Integer color = setColor(builder, readableMap, KEY_TOOLBAR_COLOR, "setToolbarColor", "toolbar");
        if (color != null) {
            this.isLightTheme = toolbarIsLight(color.intValue());
        }
        setColor(builder, readableMap, KEY_SECONDARY_TOOLBAR_COLOR, "setSecondaryToolbarColor", "secondary toolbar");
        setColor(builder, readableMap, KEY_NAVIGATION_BAR_COLOR, "setNavigationBarColor", "navigation bar");
        setColor(builder, readableMap, KEY_NAVIGATION_BAR_DIVIDER_COLOR, "setNavigationBarDividerColor", "navigation bar divider");
        if (readableMap.hasKey(KEY_DEFAULT_SHARE_MENU_ITEM) && readableMap.getBoolean(KEY_DEFAULT_SHARE_MENU_ITEM)) {
            builder.addDefaultShareMenuItem();
        }
        if (readableMap.hasKey(KEY_ANIMATIONS)) {
            applyAnimation(context, builder, readableMap.getMap(KEY_ANIMATIONS));
        }
        if (readableMap.hasKey(KEY_HAS_BACK_BUTTON) && readableMap.getBoolean(KEY_HAS_BACK_BUTTON)) {
            builder.setCloseButtonIcon(BitmapFactory.decodeResource(context.getResources(), this.isLightTheme.booleanValue() ? R.drawable.ic_arrow_back_black : R.drawable.ic_arrow_back_white));
        }
        CustomTabsIntent customTabsIntentBuild = builder.build();
        Intent intent = customTabsIntentBuild.intent;
        if (readableMap.hasKey("headers") && (map = readableMap.getMap("headers")) != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            if (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                Bundle bundle = new Bundle();
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    if (AnonymousClass2.$SwitchMap$com$facebook$react$bridge$ReadableType[map.getType(strNextKey).ordinal()] == 1) {
                        bundle.putString(strNextKey, map.getString(strNextKey));
                    }
                }
                intent.putExtra("com.android.browser.headers", bundle);
            }
        }
        if (readableMap.hasKey(KEY_FORCE_CLOSE_ON_REDIRECTION) && readableMap.getBoolean(KEY_FORCE_CLOSE_ON_REDIRECTION)) {
            intent.addFlags(268435456);
        }
        if (!readableMap.hasKey(KEY_SHOW_IN_RECENTS) || !readableMap.getBoolean(KEY_SHOW_IN_RECENTS)) {
            intent.addFlags(8388608);
            intent.addFlags(1073741824);
        }
        intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, readableMap.hasKey(KEY_ENABLE_URL_BAR_HIDING) && readableMap.getBoolean(KEY_ENABLE_URL_BAR_HIDING));
        try {
            if (readableMap.hasKey(KEY_BROWSER_PACKAGE)) {
                String string2 = readableMap.getString(KEY_BROWSER_PACKAGE);
                if (!TextUtils.isEmpty(string2)) {
                    intent.setPackage(string2);
                }
            } else {
                intent.setPackage(getDefaultBrowser(this.currentActivity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerEventBus();
        intent.setData(Uri.parse(string));
        if (readableMap.hasKey(KEY_SHOW_PAGE_TITLE)) {
            builder.setShowTitle(readableMap.getBoolean(KEY_SHOW_PAGE_TITLE));
        } else {
            intent.putExtra(CustomTabsIntent.EXTRA_TITLE_VISIBILITY_STATE, 0);
        }
        if (readableMap.hasKey(KEY_INCLUDE_REFERRER) && readableMap.getBoolean(KEY_INCLUDE_REFERRER)) {
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + context.getApplicationContext().getPackageName()));
        }
        Activity activity2 = this.currentActivity;
        activity2.startActivity(ChromeTabsManagerActivity.createStartIntent(activity2, intent), customTabsIntentBuild.startAnimationBundle);
    }

    /* JADX INFO: renamed from: com.proyecto26.inappbrowser.RNInAppBrowser$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void close() {
        Promise promise = this.mOpenBrowserPromise;
        if (promise == null) {
            return;
        }
        if (this.currentActivity == null) {
            promise.reject(ERROR_CODE, "No activity");
            this.mOpenBrowserPromise = null;
            return;
        }
        unRegisterEventBus();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "dismiss");
        this.mOpenBrowserPromise.resolve(writableMapCreateMap);
        this.mOpenBrowserPromise = null;
        Activity activity = this.currentActivity;
        activity.startActivity(ChromeTabsManagerActivity.createDismissIntent(activity));
    }

    public void isAvailable(Context context, Promise promise) {
        List<ResolveInfo> preferredPackages = getPreferredPackages(context);
        promise.resolve(Boolean.valueOf((preferredPackages == null || preferredPackages.isEmpty()) ? false : true));
    }

    @Subscribe
    public void onEvent(ChromeTabsDismissedEvent chromeTabsDismissedEvent) {
        unRegisterEventBus();
        if (this.mOpenBrowserPromise == null) {
            return;
        }
        if (chromeTabsDismissedEvent.isError.booleanValue()) {
            this.mOpenBrowserPromise.reject(ERROR_CODE, chromeTabsDismissedEvent.message);
        } else {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", chromeTabsDismissedEvent.resultType);
            writableMapCreateMap.putString("message", chromeTabsDismissedEvent.message);
            this.mOpenBrowserPromise.resolve(writableMapCreateMap);
        }
        this.mOpenBrowserPromise = null;
    }

    void applyAnimation(Context context, CustomTabsIntent.Builder builder, ReadableMap readableMap) {
        int iResolveAnimationIdentifierIfNeeded = readableMap.hasKey(KEY_ANIMATION_START_ENTER) ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString(KEY_ANIMATION_START_ENTER)) : -1;
        int iResolveAnimationIdentifierIfNeeded2 = readableMap.hasKey(KEY_ANIMATION_START_EXIT) ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString(KEY_ANIMATION_START_EXIT)) : -1;
        int iResolveAnimationIdentifierIfNeeded3 = readableMap.hasKey(KEY_ANIMATION_END_ENTER) ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString(KEY_ANIMATION_END_ENTER)) : -1;
        int iResolveAnimationIdentifierIfNeeded4 = readableMap.hasKey(KEY_ANIMATION_END_EXIT) ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString(KEY_ANIMATION_END_EXIT)) : -1;
        if (iResolveAnimationIdentifierIfNeeded != -1 && iResolveAnimationIdentifierIfNeeded2 != -1) {
            builder.setStartAnimations(context, iResolveAnimationIdentifierIfNeeded, iResolveAnimationIdentifierIfNeeded2);
        }
        if (iResolveAnimationIdentifierIfNeeded3 == -1 || iResolveAnimationIdentifierIfNeeded4 == -1) {
            return;
        }
        builder.setExitAnimations(context, iResolveAnimationIdentifierIfNeeded3, iResolveAnimationIdentifierIfNeeded4);
    }

    private int resolveAnimationIdentifierIfNeeded(Context context, String str) {
        if (animationIdentifierPattern.matcher(str).find()) {
            return context.getResources().getIdentifier(str, null, null);
        }
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    private void registerEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    private void unRegisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    private Boolean toolbarIsLight(int i) {
        return Boolean.valueOf(ColorUtils.calculateLuminance(i) > 0.5d);
    }

    private List<ResolveInfo> getPreferredPackages(Context context) {
        return context.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
    }

    private String getDefaultBrowser(Context context) {
        List<ResolveInfo> preferredPackages = getPreferredPackages(context);
        String packageName = CustomTabsClient.getPackageName(context, Arrays.asList("com.android.chrome", CHROME_PACKAGE_BETA, CHROME_PACKAGE_DEV, LOCAL_PACKAGE));
        return (packageName != null || preferredPackages == null || preferredPackages.size() <= 0) ? packageName : preferredPackages.get(0).serviceInfo.packageName;
    }

    public void onStart(Activity activity) {
        final Context applicationContext = activity.getApplicationContext();
        CustomTabsServiceConnection customTabsServiceConnection = new CustomTabsServiceConnection() { // from class: com.proyecto26.inappbrowser.RNInAppBrowser.1
            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient) {
                RNInAppBrowser.this.customTabsClient = customTabsClient;
                if (!RNInAppBrowser.this.customTabsClient.warmup(0L)) {
                    System.err.println("Couldn't warmup custom tabs client");
                }
                applicationContext.unbindService(this);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                RNInAppBrowser.this.customTabsClient = null;
            }
        };
        String defaultBrowser = getDefaultBrowser(applicationContext);
        if (defaultBrowser != null) {
            CustomTabsClient.bindCustomTabsService(applicationContext, defaultBrowser, customTabsServiceConnection);
        } else {
            System.err.println("No browser supported to bind custom tab service");
        }
    }

    public void warmup(Promise promise) {
        CustomTabsClient customTabsClient = this.customTabsClient;
        if (customTabsClient != null) {
            promise.resolve(Boolean.valueOf(customTabsClient.warmup(0L)));
        }
        promise.resolve(Boolean.FALSE);
    }

    public void mayLaunchUrl(String str, ReadableArray readableArray) {
        CustomTabsSession customTabsSessionNewSession;
        CustomTabsClient customTabsClient = this.customTabsClient;
        if (customTabsClient == null || (customTabsSessionNewSession = customTabsClient.newSession(new CustomTabsCallback())) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsService.KEY_URL, Uri.parse(string));
                arrayList.add(bundle);
            }
        }
        customTabsSessionNewSession.mayLaunchUrl(Uri.parse(str), null, arrayList);
    }
}
