package com.swmansion.rnscreens;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSSearchBarManagerDelegate;
import com.facebook.react.viewmanagers.RNSSearchBarManagerInterface;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.henninghall.date_picker.props.TextColorProp;
import com.swmansion.rnscreens.events.SearchBarBlurEvent;
import com.swmansion.rnscreens.events.SearchBarChangeTextEvent;
import com.swmansion.rnscreens.events.SearchBarCloseEvent;
import com.swmansion.rnscreens.events.SearchBarFocusEvent;
import com.swmansion.rnscreens.events.SearchBarOpenEvent;
import com.swmansion.rnscreens.events.SearchBarSearchButtonPressEvent;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = SearchBarManager.REACT_CLASS)
public final class SearchBarManager extends ViewGroupManager<SearchBarView> implements RNSSearchBarManagerInterface<SearchBarView> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSSearchBar";
    private final ViewManagerDelegate<SearchBarView> delegate = new RNSSearchBarManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<SearchBarView> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public SearchBarView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SearchBarView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull SearchBarView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.onUpdate();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r3.equals("none") != false) goto L21;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @com.facebook.react.uimanager.annotations.ReactProp(name = "autoCapitalize")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setAutoCapitalize(@org.jetbrains.annotations.NotNull com.swmansion.rnscreens.SearchBarView r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L41
            int r0 = r3.hashCode()
            switch(r0) {
                case 3387192: goto L30;
                case 113318569: goto L25;
                case 490141296: goto L1a;
                case 1245424234: goto Lf;
                default: goto Le;
            }
        Le:
            goto L39
        Lf:
            java.lang.String r0 = "characters"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.CHARACTERS
            goto L43
        L1a:
            java.lang.String r0 = "sentences"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.SENTENCES
            goto L43
        L25:
            java.lang.String r0 = "words"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.WORDS
            goto L43
        L30:
            java.lang.String r0 = "none"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            goto L41
        L39:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden auto capitalize value passed"
            r2.<init>(r3)
            throw r2
        L41:
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.NONE
        L43:
            r2.setAutoCapitalize(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setAutoCapitalize(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    @ReactProp(name = "autoFocus")
    public final void setAutoFocus(@NotNull SearchBarView view, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAutoFocus(bool != null ? bool.booleanValue() : false);
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @ReactProp(customType = "Color", name = "barTintColor")
    public void setBarTintColor(@NotNull SearchBarView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTintColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @ReactProp(name = "disableBackButtonOverride")
    public void setDisableBackButtonOverride(@NotNull SearchBarView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setShouldOverrideBackButton(!z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r3.equals("text") != false) goto L21;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @com.facebook.react.uimanager.annotations.ReactProp(name = "inputType")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setInputType(@org.jetbrains.annotations.NotNull com.swmansion.rnscreens.SearchBarView r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L41
            int r0 = r3.hashCode()
            switch(r0) {
                case -1034364087: goto L2e;
                case 3556653: goto L25;
                case 96619420: goto L1a;
                case 106642798: goto Lf;
                default: goto Le;
            }
        Le:
            goto L39
        Lf:
            java.lang.String r0 = "phone"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.PHONE
            goto L43
        L1a:
            java.lang.String r0 = "email"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.EMAIL
            goto L43
        L25:
            java.lang.String r0 = "text"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            goto L41
        L2e:
            java.lang.String r0 = "number"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L39
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.NUMBER
            goto L43
        L39:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden input type value"
            r2.<init>(r3)
            throw r2
        L41:
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.TEXT
        L43:
            r2.setInputType(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setInputType(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @ReactProp(name = ReactTextInputShadowNode.PROP_PLACEHOLDER)
    public void setPlaceholder(@NotNull SearchBarView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setPlaceholder(str);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @ReactProp(customType = "Color", name = TextColorProp.name)
    public void setTextColor(@NotNull SearchBarView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTextColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @ReactProp(customType = "Color", name = "headerIconColor")
    public void setHeaderIconColor(@NotNull SearchBarView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHeaderIconColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @ReactProp(customType = "Color", name = "hintTextColor")
    public void setHintTextColor(@NotNull SearchBarView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHintTextColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    @ReactProp(name = "shouldShowHintSearchIcon")
    public void setShouldShowHintSearchIcon(@NotNull SearchBarView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setShouldShowHintSearchIcon(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt__MapsKt.hashMapOf(TuplesKt.to(SearchBarBlurEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onSearchBlur"))), TuplesKt.to(SearchBarChangeTextEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onChangeText"))), TuplesKt.to(SearchBarCloseEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onClose"))), TuplesKt.to(SearchBarFocusEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onSearchFocus"))), TuplesKt.to(SearchBarOpenEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onOpen"))), TuplesKt.to(SearchBarSearchButtonPressEvent.EVENT_NAME, MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", "onSearchButtonPress"))));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void logNotAvailable(String str) {
        SentryLogcatAdapter.w("[RNScreens]", str + " prop is not available on Android");
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void blur(@Nullable SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleBlurJsRequest();
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void focus(@Nullable SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleFocusJsRequest();
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void clearText(@Nullable SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleClearTextJsRequest();
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void toggleCancelButton(@Nullable SearchBarView searchBarView, boolean z) {
        if (searchBarView != null) {
            searchBarView.handleToggleCancelButtonJsRequest(z);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void setText(@Nullable SearchBarView searchBarView, @Nullable String str) {
        if (searchBarView != null) {
            searchBarView.handleSetTextJsRequest(str);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void cancelSearch(@Nullable SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleFocusJsRequest();
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void setPlacement(@NotNull SearchBarView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        logNotAvailable("setPlacement");
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void setHideWhenScrolling(@Nullable SearchBarView searchBarView, boolean z) {
        logNotAvailable("hideWhenScrolling");
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void setObscureBackground(@Nullable SearchBarView searchBarView, boolean z) {
        logNotAvailable("hideNavigationBar");
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void setHideNavigationBar(@Nullable SearchBarView searchBarView, boolean z) {
        logNotAvailable("hideNavigationBar");
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void setCancelButtonText(@Nullable SearchBarView searchBarView, @Nullable String str) {
        logNotAvailable("cancelButtonText");
    }

    @Override // com.facebook.react.viewmanagers.RNSSearchBarManagerInterface
    public void setTintColor(@Nullable SearchBarView searchBarView, @Nullable Integer num) {
        logNotAvailable("tintColor");
    }
}
