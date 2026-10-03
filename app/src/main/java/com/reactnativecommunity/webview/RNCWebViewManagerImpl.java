package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.google.common.net.HttpHeaders;
import com.salesforce.marketingcloud.http.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class RNCWebViewManagerImpl {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "RNCWebView";
    private final String BLANK_URL;
    private final int COMMAND_CLEAR_CACHE;
    private final int COMMAND_CLEAR_FORM_DATA;
    private final int COMMAND_CLEAR_HISTORY;
    private final int COMMAND_FOCUS;
    private final int COMMAND_GO_BACK;
    private final int COMMAND_GO_FORWARD;
    private final int COMMAND_INJECT_JAVASCRIPT;
    private final int COMMAND_LOAD_URL;
    private final int COMMAND_POST_MESSAGE;
    private final int COMMAND_RELOAD;
    private final int COMMAND_STOP_LOADING;
    private final String DEFAULT_DOWNLOADING_MESSAGE;
    private final String DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE;
    private final String HTML_ENCODING;
    private final String HTML_MIME_TYPE;
    private final String HTTP_METHOD_POST;
    private final String TAG;
    private boolean mAllowsFullscreenVideo;
    private boolean mAllowsProtectedMedia;
    private String mDownloadingMessage;
    private boolean mHasOnOpenWindowEvent;
    private String mLackPermissionToDownloadMessage;
    private ReadableMap mPendingSource;
    private String mUserAgent;
    private String mUserAgentWithApplicationName;
    private RNCWebViewConfig mWebViewConfig;
    private final boolean newArch;

    public RNCWebViewManagerImpl() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mWebViewConfig$lambda$0(WebView webView) {
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RNCWebViewManagerImpl(boolean z) {
        this.newArch = z;
        this.TAG = "RNCWebViewManagerImpl";
        this.mWebViewConfig = new RNCWebViewConfig() { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl$$ExternalSyntheticLambda0
            @Override // com.reactnativecommunity.webview.RNCWebViewConfig
            public final void configWebView(WebView webView) {
                RNCWebViewManagerImpl.mWebViewConfig$lambda$0(webView);
            }
        };
        this.HTML_ENCODING = CharEncoding.UTF_8;
        this.HTML_MIME_TYPE = "text/html";
        this.HTTP_METHOD_POST = "POST";
        this.BLANK_URL = "about:blank";
        this.DEFAULT_DOWNLOADING_MESSAGE = "Downloading";
        this.DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE = "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.";
        this.COMMAND_GO_BACK = 1;
        this.COMMAND_GO_FORWARD = 2;
        this.COMMAND_RELOAD = 3;
        this.COMMAND_STOP_LOADING = 4;
        this.COMMAND_POST_MESSAGE = 5;
        this.COMMAND_INJECT_JAVASCRIPT = 6;
        this.COMMAND_LOAD_URL = 7;
        this.COMMAND_FOCUS = 8;
        this.COMMAND_CLEAR_FORM_DATA = 1000;
        this.COMMAND_CLEAR_CACHE = 1001;
        this.COMMAND_CLEAR_HISTORY = 1002;
    }

    public /* synthetic */ RNCWebViewManagerImpl(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final RNCWebView createRNCWebViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new RNCWebView(context);
    }

    public final RNCWebViewWrapper createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return createViewInstance(context, createRNCWebViewInstance(context));
    }

    public final RNCWebViewWrapper createViewInstance(@NotNull ThemedReactContext context, @NotNull final RNCWebView webView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        setupWebChromeClient(webView);
        context.addLifecycleEventListener(webView);
        this.mWebViewConfig.configWebView(webView);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(1);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (ReactBuildConfig.DEBUG) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        webView.setDownloadListener(new DownloadListener() { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl$$ExternalSyntheticLambda1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                RNCWebViewManagerImpl.createViewInstance$lambda$1(webView, this, str, str2, str3, str4, j);
            }
        });
        return new RNCWebViewWrapper(context, webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$1(RNCWebView rNCWebView, RNCWebViewManagerImpl rNCWebViewManagerImpl, String str, String str2, String str3, String str4, long j) {
        RNCWebViewModule rNCWebViewModule = (RNCWebViewModule) rNCWebView.getReactApplicationContext().getNativeModule(RNCWebViewModule.class);
        if (rNCWebViewModule == null) {
            return;
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            String strGuessFileName = URLUtil.guessFileName(str, str3, str4);
            Intrinsics.checkNotNull(strGuessFileName);
            String strReplace = RNCWebViewManagerImplKt.getInvalidCharRegex().replace(strGuessFileName, "_");
            String str5 = "Downloading " + strReplace;
            try {
                URL url = new URL(str);
                request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
            } catch (MalformedURLException e) {
                SentryLogcatAdapter.w(rNCWebViewManagerImpl.TAG, "Error getting cookie for DownloadManager", e);
            }
            request.addRequestHeader(HttpHeaders.USER_AGENT, str2);
            request.setTitle(strReplace);
            request.setDescription(str5);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, strReplace);
            rNCWebViewModule.setDownloadRequest(request);
            if (rNCWebViewModule.grantFileDownloaderPermissions(rNCWebViewManagerImpl.getDownloadingMessageOrDefault(), rNCWebViewManagerImpl.getLackPermissionToDownloadMessageOrDefault())) {
                rNCWebViewModule.downloadFile(rNCWebViewManagerImpl.getDownloadingMessageOrDefault());
            }
        } catch (IllegalArgumentException e2) {
            SentryLogcatAdapter.w(rNCWebViewManagerImpl.TAG, "Unsupported URI, aborting download", e2);
        }
    }

    private final void setupWebChromeClient(final RNCWebView rNCWebView) {
        final Activity currentActivity = rNCWebView.getThemedReactContext().getCurrentActivity();
        if (this.mAllowsFullscreenVideo && currentActivity != null) {
            final int requestedOrientation = currentActivity.getRequestedOrientation();
            RNCWebChromeClient rNCWebChromeClient = new RNCWebChromeClient(rNCWebView) { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1
                @Override // android.webkit.WebChromeClient
                public Bitmap getDefaultVideoPoster() {
                    return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
                }

                @Override // android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    if (this.mVideoView != null) {
                        callback.onCustomViewHidden();
                        return;
                    }
                    this.mVideoView = view;
                    this.mCustomViewCallback = callback;
                    currentActivity.setRequestedOrientation(-1);
                    this.mVideoView.setSystemUiVisibility(7942);
                    currentActivity.getWindow().setFlags(512, 512);
                    this.mVideoView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                    ViewGroup rootView = getRootView();
                    rootView.addView(this.mVideoView, RNCWebChromeClient.FULLSCREEN_LAYOUT_PARAMS);
                    if (rootView.getRootView() != this.mWebView.getRootView()) {
                        this.mWebView.getRootView().setVisibility(8);
                    } else {
                        this.mWebView.setVisibility(8);
                    }
                    this.mWebView.getThemedReactContext().addLifecycleEventListener(this);
                }

                @Override // android.webkit.WebChromeClient
                public void onHideCustomView() {
                    if (this.mVideoView == null) {
                        return;
                    }
                    ViewGroup rootView = getRootView();
                    if (rootView.getRootView() != this.mWebView.getRootView()) {
                        this.mWebView.getRootView().setVisibility(0);
                    } else {
                        this.mWebView.setVisibility(0);
                    }
                    currentActivity.getWindow().clearFlags(512);
                    rootView.removeView(this.mVideoView);
                    this.mCustomViewCallback.onCustomViewHidden();
                    this.mVideoView = null;
                    this.mCustomViewCallback = null;
                    currentActivity.setRequestedOrientation(requestedOrientation);
                    this.mWebView.getThemedReactContext().removeLifecycleEventListener(this);
                }
            };
            rNCWebChromeClient.setAllowsProtectedMedia(this.mAllowsProtectedMedia);
            rNCWebChromeClient.setHasOnOpenWindowEvent(this.mHasOnOpenWindowEvent);
            rNCWebView.setWebChromeClient(rNCWebChromeClient);
            return;
        }
        RNCWebChromeClient rNCWebChromeClient2 = (RNCWebChromeClient) rNCWebView.getWebChromeClient();
        if (rNCWebChromeClient2 != null) {
            rNCWebChromeClient2.onHideCustomView();
        }
        RNCWebChromeClient rNCWebChromeClient3 = new RNCWebChromeClient(rNCWebView) { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl.setupWebChromeClient.1
            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
            }
        };
        rNCWebChromeClient3.setAllowsProtectedMedia(this.mAllowsProtectedMedia);
        rNCWebChromeClient3.setHasOnOpenWindowEvent(this.mHasOnOpenWindowEvent);
        rNCWebView.setWebChromeClient(rNCWebChromeClient3);
    }

    public final void setUserAgent(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        this.mUserAgent = str;
        setUserAgentString(viewWrapper);
    }

    public final void setApplicationNameForUserAgent(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        if (str != null) {
            this.mUserAgentWithApplicationName = WebSettings.getDefaultUserAgent(viewWrapper.getWebView().getContext()) + StringUtils.SPACE + str;
        } else {
            this.mUserAgentWithApplicationName = null;
        }
        setUserAgentString(viewWrapper);
    }

    private final void setUserAgentString(RNCWebViewWrapper rNCWebViewWrapper) {
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    public final void setBasicAuthCredential(@NotNull RNCWebViewWrapper viewWrapper, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setBasicAuthCredential((readableMap != null && readableMap.hasKey("username") && readableMap.hasKey("password")) ? new RNCBasicAuthCredential(readableMap.getString("username"), readableMap.getString("password")) : null);
    }

    public final void onAfterUpdateTransaction(@NotNull RNCWebViewWrapper viewWrapper) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        ReadableMap readableMap = this.mPendingSource;
        if (readableMap != null) {
            loadSource(viewWrapper, readableMap);
        }
        this.mPendingSource = null;
    }

    public final void onDropViewInstance(@NotNull RNCWebViewWrapper viewWrapper) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        webView.getThemedReactContext().removeLifecycleEventListener(webView);
        webView.cleanupCallbacksAndDestroy();
        webView.mWebChromeClient = null;
    }

    public final int getCOMMAND_GO_BACK() {
        return this.COMMAND_GO_BACK;
    }

    public final int getCOMMAND_GO_FORWARD() {
        return this.COMMAND_GO_FORWARD;
    }

    public final int getCOMMAND_RELOAD() {
        return this.COMMAND_RELOAD;
    }

    public final int getCOMMAND_STOP_LOADING() {
        return this.COMMAND_STOP_LOADING;
    }

    public final int getCOMMAND_POST_MESSAGE() {
        return this.COMMAND_POST_MESSAGE;
    }

    public final int getCOMMAND_INJECT_JAVASCRIPT() {
        return this.COMMAND_INJECT_JAVASCRIPT;
    }

    public final int getCOMMAND_LOAD_URL() {
        return this.COMMAND_LOAD_URL;
    }

    public final int getCOMMAND_FOCUS() {
        return this.COMMAND_FOCUS;
    }

    public final int getCOMMAND_CLEAR_FORM_DATA() {
        return this.COMMAND_CLEAR_FORM_DATA;
    }

    public final int getCOMMAND_CLEAR_CACHE() {
        return this.COMMAND_CLEAR_CACHE;
    }

    public final int getCOMMAND_CLEAR_HISTORY() {
        return this.COMMAND_CLEAR_HISTORY;
    }

    public final Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("goBack", Integer.valueOf(this.COMMAND_GO_BACK)).put("goForward", Integer.valueOf(this.COMMAND_GO_FORWARD)).put("reload", Integer.valueOf(this.COMMAND_RELOAD)).put("stopLoading", Integer.valueOf(this.COMMAND_STOP_LOADING)).put("postMessage", Integer.valueOf(this.COMMAND_POST_MESSAGE)).put("injectJavaScript", Integer.valueOf(this.COMMAND_INJECT_JAVASCRIPT)).put("loadUrl", Integer.valueOf(this.COMMAND_LOAD_URL)).put("requestFocus", Integer.valueOf(this.COMMAND_FOCUS)).put("clearFormData", Integer.valueOf(this.COMMAND_CLEAR_FORM_DATA)).put("clearCache", Integer.valueOf(this.COMMAND_CLEAR_CACHE)).put("clearHistory", Integer.valueOf(this.COMMAND_CLEAR_HISTORY)).build();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void receiveCommand(@NotNull RNCWebViewWrapper viewWrapper, @NotNull String commandId, @NotNull ReadableArray args) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        Intrinsics.checkNotNullParameter(args, "args");
        RNCWebView webView = viewWrapper.getWebView();
        switch (commandId.hashCode()) {
            case -1241591313:
                if (commandId.equals("goBack")) {
                    webView.goBack();
                    return;
                }
                return;
            case -948122918:
                if (commandId.equals("stopLoading")) {
                    webView.stopLoading();
                    return;
                }
                return;
            case -934641255:
                if (commandId.equals("reload")) {
                    webView.reload();
                    return;
                }
                return;
            case -759238347:
                if (commandId.equals("clearCache")) {
                    webView.clearCache(args.getBoolean(0));
                    return;
                }
                return;
            case -318289731:
                if (commandId.equals("goForward")) {
                    webView.goForward();
                    return;
                }
                return;
            case -265032709:
                if (commandId.equals("clearFormData")) {
                    webView.clearFormData();
                    return;
                }
                return;
            case 336631465:
                if (commandId.equals("loadUrl")) {
                    String string = args.getString(0);
                    if (string == null) {
                        throw new RuntimeException("Arguments for loading an url are null!");
                    }
                    webView.progressChangedFilter.setWaitingForCommandLoadUrl(false);
                    webView.loadUrl(string);
                    return;
                }
                return;
            case 903120263:
                if (commandId.equals("clearHistory")) {
                    webView.clearHistory();
                    return;
                }
                return;
            case 1280029577:
                if (commandId.equals("requestFocus")) {
                    webView.requestFocus();
                    return;
                }
                return;
            case 1490029383:
                if (commandId.equals("postMessage")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", args.getString(0));
                        webView.evaluateJavascriptWithFallback("(function () {var event;var data = " + jSONObject + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                        return;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                return;
            case 2104576510:
                if (commandId.equals("injectJavaScript")) {
                    webView.evaluateJavascriptWithFallback(args.getString(0));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setMixedContentMode(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (str == null || Intrinsics.areEqual(ReactScrollViewHelper.OVER_SCROLL_NEVER, str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if (Intrinsics.areEqual(ReactScrollViewHelper.OVER_SCROLL_ALWAYS, str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if (Intrinsics.areEqual("compatibility", str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    public final void setAllowUniversalAccessFromFileURLs(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    private final String getDownloadingMessageOrDefault() {
        String str = this.mDownloadingMessage;
        return str == null ? this.DEFAULT_DOWNLOADING_MESSAGE : str;
    }

    private final String getLackPermissionToDownloadMessageOrDefault() {
        String str = this.mLackPermissionToDownloadMessage;
        return str == null ? this.DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE : str;
    }

    public final void setSource(@NotNull RNCWebViewWrapper viewWrapper, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        this.mPendingSource = readableMap;
    }

    private final void loadSource(RNCWebViewWrapper rNCWebViewWrapper, ReadableMap readableMap) {
        byte[] bytes;
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                String string = readableMap.getString("html");
                String string2 = readableMap.hasKey("baseUrl") ? readableMap.getString("baseUrl") : "";
                Intrinsics.checkNotNull(string);
                webView.loadDataWithBaseURL(string2, string, this.HTML_MIME_TYPE, this.HTML_ENCODING, null);
                return;
            }
            if (readableMap.hasKey("uri")) {
                String string3 = readableMap.getString("uri");
                String url = webView.getUrl();
                if (url == null || !Intrinsics.areEqual(url, string3)) {
                    if (readableMap.hasKey("method") && StringsKt__StringsJVMKt.equals(readableMap.getString("method"), this.HTTP_METHOD_POST, true)) {
                        if (readableMap.hasKey("body")) {
                            String string4 = readableMap.getString("body");
                            try {
                                Intrinsics.checkNotNull(string4);
                                Charset charsetForName = Charset.forName(CharEncoding.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                                bytes = string4.getBytes(charsetForName);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            } catch (UnsupportedEncodingException unused) {
                                Intrinsics.checkNotNull(string4);
                                bytes = string4.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            }
                        } else {
                            bytes = null;
                        }
                        if (bytes == null) {
                            bytes = new byte[0];
                        }
                        Intrinsics.checkNotNull(string3);
                        webView.postUrl(string3, bytes);
                        return;
                    }
                    HashMap map = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        if (this.newArch) {
                            ReadableArray array = readableMap.getArray("headers");
                            Intrinsics.checkNotNull(array);
                            Iterator<Object> it2 = array.toArrayList().iterator();
                            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                            while (it2.hasNext()) {
                                Object next = it2.next();
                                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                                HashMap map2 = (HashMap) next;
                                String str = (String) map2.get("name");
                                if (str == null) {
                                    str = "";
                                }
                                String str2 = (String) map2.get("value");
                                if (str2 == null) {
                                    str2 = "";
                                }
                                Locale ENGLISH = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                                String lowerCase = str.toLowerCase(ENGLISH);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                if (Intrinsics.areEqual(b.u, lowerCase)) {
                                    webView.getSettings().setUserAgentString(str2);
                                } else {
                                    map.put(str, str2);
                                }
                            }
                        } else {
                            ReadableMap map3 = readableMap.getMap("headers");
                            Intrinsics.checkNotNull(map3);
                            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map3.keySetIterator();
                            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                                Locale ENGLISH2 = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(ENGLISH2, "ENGLISH");
                                String lowerCase2 = strNextKey.toLowerCase(ENGLISH2);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                if (Intrinsics.areEqual(b.u, lowerCase2)) {
                                    webView.getSettings().setUserAgentString(map3.getString(strNextKey));
                                } else {
                                    map.put(strNextKey, map3.getString(strNextKey));
                                }
                            }
                        }
                    }
                    Intrinsics.checkNotNull(string3);
                    webView.loadUrl(string3, map);
                    return;
                }
                return;
            }
        }
        webView.loadUrl(this.BLANK_URL);
    }

    public final void setMessagingModuleName(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().messagingModuleName = str;
    }

    public final void setCacheEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setCacheMode(z ? -1 : 2);
    }

    public final void setIncognito(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (z) {
            CookieManager.getInstance().removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    public final void setInjectedJavaScript(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJS = str;
    }

    public final void setInjectedJavaScriptBeforeContentLoaded(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJSBeforeContentLoaded = str;
    }

    public final void setInjectedJavaScriptForMainFrameOnly(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJavaScriptForMainFrameOnly = z;
    }

    public final void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJavaScriptBeforeContentLoadedForMainFrameOnly = z;
    }

    public final void setInjectedJavaScriptObject(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setInjectedJavaScriptObject(str);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setShowsVerticalScrollIndicator(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setVerticalScrollBarEnabled(z);
    }

    public final void setShowsHorizontalScrollIndicator(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setHorizontalScrollBarEnabled(z);
    }

    public final void setMessagingEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setMessagingEnabled(z);
    }

    public final void setMediaPlaybackRequiresUserAction(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setHasOnScroll(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setHasScrollEvent(z);
    }

    public final void setJavaScriptEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setJavaScriptEnabled(z);
    }

    public final void setAllowFileAccess(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowFileAccess(z);
    }

    public final void setAllowFileAccessFromFileURLs(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowFileAccessFromFileURLs(z);
    }

    public final void setAllowsFullscreenVideo(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        this.mAllowsFullscreenVideo = z;
        setupWebChromeClient(webView);
    }

    public final void setAndroidLayerType(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        int i;
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (Intrinsics.areEqual(str, "hardware")) {
            i = 2;
        } else {
            i = Intrinsics.areEqual(str, "software") ? 1 : 0;
        }
        webView.setLayerType(i, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    public final void setCacheMode(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        int i;
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        WebSettings settings = viewWrapper.getWebView().getSettings();
        if (str != null) {
            switch (str.hashCode()) {
                case -2059164003:
                    if (!str.equals("LOAD_NO_CACHE")) {
                        i = -1;
                    } else {
                        i = 2;
                    }
                    break;
                case -1215135800:
                    str.equals("LOAD_DEFAULT");
                    i = -1;
                    break;
                case -873877826:
                    if (!str.equals("LOAD_CACHE_ELSE_NETWORK")) {
                        i = -1;
                    } else {
                        i = 1;
                    }
                    break;
                case 1548620642:
                    if (!str.equals("LOAD_CACHE_ONLY")) {
                        i = -1;
                    } else {
                        i = 3;
                    }
                    break;
                default:
                    i = -1;
                    break;
            }
        } else {
            i = -1;
        }
        settings.setCacheMode(i);
    }

    public final void setDomStorageEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setDomStorageEnabled(z);
    }

    public final void setDownloadingMessage(@Nullable String str) {
        this.mDownloadingMessage = str;
    }

    public final void setForceDarkOn(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (Build.VERSION.SDK_INT > 28) {
            if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
                WebSettingsCompat.setForceDark(webView.getSettings(), z ? 2 : 0);
            }
            if (z && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(webView.getSettings(), 2);
            }
        }
    }

    public final void setGeolocationEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setGeolocationEnabled(z);
    }

    public final void setLackPermissionToDownloadMessage(@Nullable String str) {
        this.mLackPermissionToDownloadMessage = str;
    }

    public final void setHasOnOpenWindowEvent(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        this.mHasOnOpenWindowEvent = z;
        setupWebChromeClient(webView);
    }

    public final void setMinimumFontSize(@NotNull RNCWebViewWrapper viewWrapper, int i) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setMinimumFontSize(i);
    }

    public final void setAllowsProtectedMedia(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        WebChromeClient webChromeClient;
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        this.mAllowsProtectedMedia = z;
        if (Build.VERSION.SDK_INT < 26 || (webChromeClient = webView.getWebChromeClient()) == null || !(webChromeClient instanceof RNCWebChromeClient)) {
            return;
        }
        ((RNCWebChromeClient) webChromeClient).setAllowsProtectedMedia(z);
    }

    public final void setMenuCustomItems(@NotNull RNCWebViewWrapper viewWrapper, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (readableArray == null) {
            webView.setMenuCustomItems(null);
            return;
        }
        ArrayList<Object> arrayList = readableArray.toArrayList();
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.String>>");
        webView.setMenuCustomItems(arrayList);
    }

    public final void setNestedScrollEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().nestedScrollEnabled = z;
    }

    public final void setOverScrollMode(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String str) {
        int i;
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (str == null) {
            i = 0;
        } else {
            int iHashCode = str.hashCode();
            if (iHashCode == -1414557169) {
                str.equals(ReactScrollViewHelper.OVER_SCROLL_ALWAYS);
            } else if (iHashCode != 104712844) {
                if (iHashCode == 951530617 && str.equals("content")) {
                    i = 1;
                }
            } else if (str.equals(ReactScrollViewHelper.OVER_SCROLL_NEVER)) {
                i = 2;
            }
            i = 0;
        }
        webView.setOverScrollMode(i);
    }

    public final void setSaveFormDataDisabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setSaveFormData(!z);
    }

    public final void setScalesPageToFit(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
    }

    public final void setSetBuiltInZoomControls(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setBuiltInZoomControls(z);
    }

    public final void setSetDisplayZoomControls(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setDisplayZoomControls(z);
    }

    public final void setSetSupportMultipleWindows(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setSupportMultipleWindows(z);
    }

    public final void setTextZoom(@NotNull RNCWebViewWrapper viewWrapper, int i) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setTextZoom(i);
    }

    public final void setThirdPartyCookiesEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        CookieManager.getInstance().setAcceptThirdPartyCookies(viewWrapper.getWebView(), z);
    }

    public final void setWebviewDebuggingEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        WebView.setWebContentsDebuggingEnabled(z);
    }

    public final void setPaymentRequestEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (WebViewFeature.isFeatureSupported("PAYMENT_REQUEST")) {
            WebSettingsCompat.setPaymentRequestEnabled(webView.getSettings(), z);
        }
    }
}
