package com.reactnativecommunity.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.webkit.CookieManager;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.reactnativecommunity.webview.events.SubResourceErrorEvent;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;
import com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.concurrent.atomic.AtomicReference;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes3.dex */
public class RNCWebViewClient extends WebViewClient {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;
    private static String TAG = "RNCWebViewClient";
    protected boolean mLastLoadFailed = false;
    protected RNCWebView.ProgressChangedFilter progressChangedFilter = null;
    protected RNCBasicAuthCredential basicAuthCredential = null;

    public void setBasicAuthCredential(@Nullable RNCBasicAuthCredential rNCBasicAuthCredential) {
        this.basicAuthCredential = rNCBasicAuthCredential;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (CookieManager.getInstance().getCookie(str) != null) {
            CookieManager.getInstance().flush();
        }
        if (this.mLastLoadFailed) {
            return;
        }
        ((RNCWebView) webView).callInjectedJavaScript();
        emitFinishEvent(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingStartEvent(RNCWebViewWrapper.getReactTagFromWebView(webView), createWebViewEvent(webView, str)));
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.mLastLoadFailed = false;
        ((RNCWebView) webView).callInjectedJavaScriptBeforeContentLoaded();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        RNCWebView rNCWebView = (RNCWebView) webView;
        if (rNCWebView.getReactApplicationContext().getJavaScriptContextHolder().get() != 0 && rNCWebView.mMessagingJSModule != null) {
            Pair<Double, AtomicReference<RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState>> newLock = RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock.getNewLock();
            Double d = newLock.first;
            double dDoubleValue = d.doubleValue();
            AtomicReference<RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState> atomicReference = newLock.second;
            WritableMap writableMapCreateWebViewEvent = createWebViewEvent(webView, str);
            writableMapCreateWebViewEvent.putDouble("lockIdentifier", dDoubleValue);
            rNCWebView.dispatchDirectShouldStartLoadWithRequest(writableMapCreateWebViewEvent);
            try {
                synchronized (atomicReference) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    while (atomicReference.get() == RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.UNDECIDED) {
                        if (SystemClock.elapsedRealtime() - jElapsedRealtime > 250) {
                            FLog.w(TAG, "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading.");
                            RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock.removeLock(d);
                            return false;
                        }
                        atomicReference.wait(250L);
                    }
                    boolean z = atomicReference.get() == RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE;
                    RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock.removeLock(d);
                    return z;
                }
            } catch (InterruptedException e) {
                FLog.e(TAG, "shouldOverrideUrlLoading was interrupted while waiting for result.", e);
                RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock.removeLock(d);
                return false;
            }
        }
        FLog.w(TAG, "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load.");
        this.progressChangedFilter.setWaitingForCommandLoadUrl(true);
        int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopShouldStartLoadWithRequestEvent(reactTagFromWebView, createWebViewEvent(webView, str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        RNCBasicAuthCredential rNCBasicAuthCredential = this.basicAuthCredential;
        if (rNCBasicAuthCredential != null) {
            httpAuthHandler.proceed(rNCBasicAuthCredential.username, rNCBasicAuthCredential.password);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str;
        String url = webView.getUrl();
        String url2 = sslError.getUrl();
        sslErrorHandler.cancel();
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            str = "The certificate is not yet valid";
        } else if (primaryError == 1) {
            str = "The certificate has expired";
        } else if (primaryError == 2) {
            str = "Hostname mismatch";
        } else if (primaryError == 3) {
            str = "The certificate authority is not trusted";
        } else if (primaryError == 4) {
            str = "The date of the certificate is invalid";
        } else if (primaryError == 5) {
            str = "A generic error occurred";
        } else {
            str = "Unknown SSL Error";
        }
        String str2 = "SSL error: " + str;
        if (!url.equalsIgnoreCase(url2)) {
            SentryLogcatAdapter.w(TAG, "Resource blocked from loading due to SSL error. Blocked URL: " + url2);
            onReceivedSubResourceSslError(webView, primaryError, str2, url2);
            return;
        }
        onReceivedError(webView, primaryError, str2, url2);
    }

    public void onReceivedSubResourceSslError(WebView webView, int i, String str, String str2) {
        WritableMap writableMapCreateWebViewEvent = createWebViewEvent(webView, str2);
        writableMapCreateWebViewEvent.putDouble(ResponseTypeValues.CODE, i);
        writableMapCreateWebViewEvent.putString("description", str);
        int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new SubResourceErrorEvent(reactTagFromWebView, writableMapCreateWebViewEvent));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.mLastLoadFailed = true;
        emitFinishEvent(webView, str2);
        WritableMap writableMapCreateWebViewEvent = createWebViewEvent(webView, str2);
        writableMapCreateWebViewEvent.putDouble(ResponseTypeValues.CODE, i);
        writableMapCreateWebViewEvent.putString("description", str);
        int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopLoadingErrorEvent(reactTagFromWebView, writableMapCreateWebViewEvent));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            WritableMap writableMapCreateWebViewEvent = createWebViewEvent(webView, webResourceRequest.getUrl().toString());
            writableMapCreateWebViewEvent.putInt("statusCode", webResourceResponse.getStatusCode());
            writableMapCreateWebViewEvent.putString("description", webResourceResponse.getReasonPhrase());
            int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
            UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopHttpErrorEvent(reactTagFromWebView, writableMapCreateWebViewEvent));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        super.onRenderProcessGone(webView, renderProcessGoneDetail);
        if (renderProcessGoneDetail.didCrash()) {
            SentryLogcatAdapter.e(TAG, "The WebView rendering process crashed.");
        } else {
            SentryLogcatAdapter.w(TAG, "The WebView rendering process was killed by the system.");
        }
        if (webView == null) {
            return true;
        }
        WritableMap writableMapCreateWebViewEvent = createWebViewEvent(webView, webView.getUrl());
        writableMapCreateWebViewEvent.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
        int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopRenderProcessGoneEvent(reactTagFromWebView, writableMapCreateWebViewEvent));
        return true;
    }

    protected void emitFinishEvent(WebView webView, String str) {
        int reactTagFromWebView = RNCWebViewWrapper.getReactTagFromWebView(webView);
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), reactTagFromWebView).dispatchEvent(new TopLoadingFinishEvent(reactTagFromWebView, createWebViewEvent(webView, str)));
    }

    protected WritableMap createWebViewEvent(WebView webView, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(TypedValues.AttributesType.S_TARGET, RNCWebViewWrapper.getReactTagFromWebView(webView));
        writableMapCreateMap.putString("url", str);
        writableMapCreateMap.putBoolean("loading", (this.mLastLoadFailed || webView.getProgress() == 100) ? false : true);
        writableMapCreateMap.putString("title", webView.getTitle());
        writableMapCreateMap.putBoolean("canGoBack", webView.canGoBack());
        writableMapCreateMap.putBoolean("canGoForward", webView.canGoForward());
        return writableMapCreateMap;
    }

    public void setProgressChangedFilter(RNCWebView.ProgressChangedFilter progressChangedFilter) {
        this.progressChangedFilter = progressChangedFilter;
    }
}
