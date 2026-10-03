package com.reactnativecommunity.webview;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNCWebViewWrapper extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private final RNCWebView webView;

    @JvmStatic
    public static final int getReactTagFromWebView(@NotNull WebView webView) {
        return Companion.getReactTagFromWebView(webView);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNCWebViewWrapper(@NotNull Context context, @NotNull RNCWebView webView) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        webView.setBackgroundColor(0);
        addView(webView);
        View childAt = getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.reactnativecommunity.webview.RNCWebView");
        this.webView = (RNCWebView) childAt;
    }

    public final RNCWebView getWebView() {
        return this.webView;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int getReactTagFromWebView(@NotNull WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Object parent = webView.getParent();
            View view = parent instanceof View ? (View) parent : null;
            if (view != null) {
                return view.getId();
            }
            return -1;
        }
    }
}
