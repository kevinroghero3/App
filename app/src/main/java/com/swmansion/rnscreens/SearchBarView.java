package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.SearchView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.rnscreens.events.SearchBarBlurEvent;
import com.swmansion.rnscreens.events.SearchBarChangeTextEvent;
import com.swmansion.rnscreens.events.SearchBarCloseEvent;
import com.swmansion.rnscreens.events.SearchBarFocusEvent;
import com.swmansion.rnscreens.events.SearchBarOpenEvent;
import com.swmansion.rnscreens.events.SearchBarSearchButtonPressEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchBarView extends ReactViewGroup {
    private boolean areListenersSet;
    private SearchBarAutoCapitalize autoCapitalize;
    private boolean autoFocus;
    private Integer headerIconColor;
    private Integer hintTextColor;
    private SearchBarInputTypes inputType;
    private String placeholder;
    private SearchViewFormatter searchViewFormatter;
    private boolean shouldOverrideBackButton;
    private boolean shouldShowHintSearchIcon;
    private final int surfaceId;
    private Integer textColor;
    private Integer tintColor;

    public enum SearchBarAutoCapitalize {
        NONE,
        WORDS,
        SENTENCES,
        CHARACTERS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<SearchBarAutoCapitalize> getEntries() {
            return $ENTRIES;
        }
    }

    public final void handleToggleCancelButtonJsRequest(boolean z) {
    }

    public SearchBarView(@Nullable ReactContext reactContext) {
        super(reactContext);
        this.inputType = SearchBarInputTypes.TEXT;
        this.autoCapitalize = SearchBarAutoCapitalize.NONE;
        this.placeholder = "";
        this.shouldOverrideBackButton = true;
        this.shouldShowHintSearchIcon = true;
        this.surfaceId = UIManagerHelper.getSurfaceId(this);
    }

    public final SearchBarInputTypes getInputType() {
        return this.inputType;
    }

    public final void setInputType(@NotNull SearchBarInputTypes searchBarInputTypes) {
        Intrinsics.checkNotNullParameter(searchBarInputTypes, "<set-?>");
        this.inputType = searchBarInputTypes;
    }

    public final SearchBarAutoCapitalize getAutoCapitalize() {
        return this.autoCapitalize;
    }

    public final void setAutoCapitalize(@NotNull SearchBarAutoCapitalize searchBarAutoCapitalize) {
        Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "<set-?>");
        this.autoCapitalize = searchBarAutoCapitalize;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(@Nullable Integer num) {
        this.textColor = num;
    }

    public final Integer getTintColor() {
        return this.tintColor;
    }

    public final void setTintColor(@Nullable Integer num) {
        this.tintColor = num;
    }

    public final Integer getHeaderIconColor() {
        return this.headerIconColor;
    }

    public final void setHeaderIconColor(@Nullable Integer num) {
        this.headerIconColor = num;
    }

    public final Integer getHintTextColor() {
        return this.hintTextColor;
    }

    public final void setHintTextColor(@Nullable Integer num) {
        this.hintTextColor = num;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.placeholder = str;
    }

    public final boolean getShouldOverrideBackButton() {
        return this.shouldOverrideBackButton;
    }

    public final void setShouldOverrideBackButton(boolean z) {
        this.shouldOverrideBackButton = z;
    }

    public final boolean getAutoFocus() {
        return this.autoFocus;
    }

    public final void setAutoFocus(boolean z) {
        this.autoFocus = z;
    }

    public final boolean getShouldShowHintSearchIcon() {
        return this.shouldShowHintSearchIcon;
    }

    public final void setShouldShowHintSearchIcon(boolean z) {
        this.shouldShowHintSearchIcon = z;
    }

    private final ScreenStackHeaderConfig getHeaderConfig() {
        ViewParent parent = getParent();
        if (parent instanceof ScreenStackHeaderSubview) {
            return ((ScreenStackHeaderSubview) parent).getConfig();
        }
        return null;
    }

    private final ScreenStackFragment getScreenStackFragment() {
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig != null) {
            return headerConfig.getScreenFragment();
        }
        return null;
    }

    public final void onUpdate() {
        setSearchViewProps();
    }

    private final void setSearchViewProps() {
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        CustomSearchView searchView = screenStackFragment != null ? screenStackFragment.getSearchView() : null;
        if (searchView != null) {
            if (!this.areListenersSet) {
                setSearchViewListeners(searchView);
                this.areListenersSet = true;
            }
            searchView.setInputType(this.inputType.toAndroidInputType(this.autoCapitalize));
            SearchViewFormatter searchViewFormatter = this.searchViewFormatter;
            if (searchViewFormatter != null) {
                searchViewFormatter.setTextColor(this.textColor);
            }
            SearchViewFormatter searchViewFormatter2 = this.searchViewFormatter;
            if (searchViewFormatter2 != null) {
                searchViewFormatter2.setTintColor(this.tintColor);
            }
            SearchViewFormatter searchViewFormatter3 = this.searchViewFormatter;
            if (searchViewFormatter3 != null) {
                searchViewFormatter3.setHeaderIconColor(this.headerIconColor);
            }
            SearchViewFormatter searchViewFormatter4 = this.searchViewFormatter;
            if (searchViewFormatter4 != null) {
                searchViewFormatter4.setHintTextColor(this.hintTextColor);
            }
            SearchViewFormatter searchViewFormatter5 = this.searchViewFormatter;
            if (searchViewFormatter5 != null) {
                searchViewFormatter5.setPlaceholder(this.placeholder, this.shouldShowHintSearchIcon);
            }
            searchView.setOverrideBackAction(this.shouldOverrideBackButton);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null) {
            screenStackFragment.setOnSearchViewCreate(new Function1() { // from class: com.swmansion.rnscreens.SearchBarView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchBarView.onAttachedToWindow$lambda$0(this.f$0, (CustomSearchView) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachedToWindow$lambda$0(SearchBarView searchBarView, CustomSearchView newSearchView) {
        ScreenStackFragment screenStackFragment;
        CustomSearchView searchView;
        Intrinsics.checkNotNullParameter(newSearchView, "newSearchView");
        if (searchBarView.searchViewFormatter == null) {
            searchBarView.searchViewFormatter = new SearchViewFormatter(newSearchView);
        }
        searchBarView.setSearchViewProps();
        if (searchBarView.autoFocus && (screenStackFragment = searchBarView.getScreenStackFragment()) != null && (searchView = screenStackFragment.getSearchView()) != null) {
            searchView.focus();
        }
        return Unit.INSTANCE;
    }

    private final void setSearchViewListeners(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.swmansion.rnscreens.SearchBarView.setSearchViewListeners.1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                SearchBarView.this.handleTextChange(str);
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                SearchBarView.this.handleTextSubmit(str);
                return true;
            }
        });
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.swmansion.rnscreens.SearchBarView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.handleFocusChange(z);
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.swmansion.rnscreens.SearchBarView$$ExternalSyntheticLambda2
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return SearchBarView.setSearchViewListeners$lambda$2(this.f$0);
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() { // from class: com.swmansion.rnscreens.SearchBarView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.handleOpen();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setSearchViewListeners$lambda$2(SearchBarView searchBarView) {
        searchBarView.handleClose();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleTextChange(String str) {
        sendEvent(new SearchBarChangeTextEvent(this.surfaceId, getId(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFocusChange(boolean z) {
        sendEvent(z ? new SearchBarFocusEvent(this.surfaceId, getId()) : new SearchBarBlurEvent(this.surfaceId, getId()));
    }

    private final void handleClose() {
        sendEvent(new SearchBarCloseEvent(this.surfaceId, getId()));
        setToolbarElementsVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleOpen() {
        sendEvent(new SearchBarOpenEvent(this.surfaceId, getId()));
        setToolbarElementsVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleTextSubmit(String str) {
        sendEvent(new SearchBarSearchButtonPressEvent(this.surfaceId, getId(), str));
    }

    private final void sendEvent(Event<?> event) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(event);
        }
    }

    public final void handleClearTextJsRequest() {
        CustomSearchView searchView;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment == null || (searchView = screenStackFragment.getSearchView()) == null) {
            return;
        }
        searchView.clearText();
    }

    public final void handleFocusJsRequest() {
        CustomSearchView searchView;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment == null || (searchView = screenStackFragment.getSearchView()) == null) {
            return;
        }
        searchView.focus();
    }

    public final void handleBlurJsRequest() {
        CustomSearchView searchView;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment == null || (searchView = screenStackFragment.getSearchView()) == null) {
            return;
        }
        searchView.clearFocus();
    }

    public final void handleSetTextJsRequest(@Nullable String str) {
        ScreenStackFragment screenStackFragment;
        CustomSearchView searchView;
        if (str == null || (screenStackFragment = getScreenStackFragment()) == null || (searchView = screenStackFragment.getSearchView()) == null) {
            return;
        }
        searchView.setText(str);
    }

    public final void handleCancelSearchJsRequest() {
        CustomSearchView searchView;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment == null || (searchView = screenStackFragment.getSearchView()) == null) {
            return;
        }
        searchView.cancelSearch();
    }

    private final void setToolbarElementsVisibility(int i) {
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        int i2 = 0;
        int configSubviewsCount = headerConfig != null ? headerConfig.getConfigSubviewsCount() - 1 : 0;
        if (configSubviewsCount < 0) {
            return;
        }
        while (true) {
            ScreenStackHeaderConfig headerConfig2 = getHeaderConfig();
            ScreenStackHeaderSubview configSubview = headerConfig2 != null ? headerConfig2.getConfigSubview(i2) : null;
            if ((configSubview != null ? configSubview.getType() : null) != ScreenStackHeaderSubview.Type.SEARCH_BAR && configSubview != null) {
                configSubview.setVisibility(i);
            }
            if (i2 == configSubviewsCount) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final abstract class SearchBarInputTypes {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SearchBarInputTypes[] $VALUES;
        public static final SearchBarInputTypes TEXT = new TEXT("TEXT", 0);
        public static final SearchBarInputTypes PHONE = new PHONE("PHONE", 1);
        public static final SearchBarInputTypes NUMBER = new NUMBER("NUMBER", 2);
        public static final SearchBarInputTypes EMAIL = new EMAIL("EMAIL", 3);

        private static final /* synthetic */ SearchBarInputTypes[] $values() {
            return new SearchBarInputTypes[]{TEXT, PHONE, NUMBER, EMAIL};
        }

        public /* synthetic */ SearchBarInputTypes(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static EnumEntries<SearchBarInputTypes> getEntries() {
            return $ENTRIES;
        }

        public abstract int toAndroidInputType(@NotNull SearchBarAutoCapitalize searchBarAutoCapitalize);

        static final class TEXT extends SearchBarInputTypes {

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SearchBarAutoCapitalize.values().length];
                    try {
                        iArr[SearchBarAutoCapitalize.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SearchBarAutoCapitalize.WORDS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SearchBarAutoCapitalize.SENTENCES.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[SearchBarAutoCapitalize.CHARACTERS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            TEXT(String str, int i) {
                super(str, i, null);
            }

            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public int toAndroidInputType(@NotNull SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                int i = WhenMappings.$EnumSwitchMapping$0[capitalize.ordinal()];
                if (i == 1) {
                    return 1;
                }
                if (i == 2) {
                    return 8192;
                }
                if (i == 3) {
                    return 16384;
                }
                if (i == 4) {
                    return 4096;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        private SearchBarInputTypes(String str, int i) {
            super(str, i);
        }

        static {
            SearchBarInputTypes[] searchBarInputTypesArr$values = $values();
            $VALUES = searchBarInputTypesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(searchBarInputTypesArr$values);
        }

        static final class PHONE extends SearchBarInputTypes {
            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public int toAndroidInputType(@NotNull SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                return 3;
            }

            PHONE(String str, int i) {
                super(str, i, null);
            }
        }

        static final class NUMBER extends SearchBarInputTypes {
            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public int toAndroidInputType(@NotNull SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                return 2;
            }

            NUMBER(String str, int i) {
                super(str, i, null);
            }
        }

        static final class EMAIL extends SearchBarInputTypes {
            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public int toAndroidInputType(@NotNull SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                return 32;
            }

            EMAIL(String str, int i) {
                super(str, i, null);
            }
        }

        public static SearchBarInputTypes valueOf(String str) {
            return (SearchBarInputTypes) Enum.valueOf(SearchBarInputTypes.class, str);
        }

        public static SearchBarInputTypes[] values() {
            return (SearchBarInputTypes[]) $VALUES.clone();
        }
    }
}
