package com.swmansion.rnscreens;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchViewFormatter {
    private Integer defaultTextColor;
    private Drawable defaultTintBackground;
    private SearchView searchView;

    public SearchViewFormatter(@NotNull SearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "searchView");
        this.searchView = searchView;
    }

    public final SearchView getSearchView() {
        return this.searchView;
    }

    public final void setSearchView(@NotNull SearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "<set-?>");
        this.searchView = searchView;
    }

    private final EditText getSearchEditText() {
        View viewFindViewById = this.searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        if (viewFindViewById instanceof EditText) {
            return (EditText) viewFindViewById;
        }
        return null;
    }

    private final View getSearchTextPlate() {
        return this.searchView.findViewById(androidx.appcompat.R.id.search_plate);
    }

    private final ImageView getSearchIcon() {
        return (ImageView) this.searchView.findViewById(androidx.appcompat.R.id.search_button);
    }

    private final ImageView getSearchCloseIcon() {
        return (ImageView) this.searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
    }

    public final void setTextColor(@Nullable Integer num) {
        EditText searchEditText;
        ColorStateList textColors;
        Integer num2 = this.defaultTextColor;
        if (num == null) {
            if (num2 == null || (searchEditText = getSearchEditText()) == null) {
                return;
            }
            searchEditText.setTextColor(num2.intValue());
            return;
        }
        if (num2 == null) {
            EditText searchEditText2 = getSearchEditText();
            this.defaultTextColor = (searchEditText2 == null || (textColors = searchEditText2.getTextColors()) == null) ? null : Integer.valueOf(textColors.getDefaultColor());
        }
        EditText searchEditText3 = getSearchEditText();
        if (searchEditText3 != null) {
            searchEditText3.setTextColor(num.intValue());
        }
    }

    public final void setTintColor(@Nullable Integer num) {
        Drawable drawable = this.defaultTintBackground;
        if (num != null) {
            if (drawable == null) {
                this.defaultTintBackground = getSearchTextPlate().getBackground();
            }
            getSearchTextPlate().setBackgroundColor(num.intValue());
        } else if (drawable != null) {
            getSearchTextPlate().setBackground(drawable);
        }
    }

    public final void setHeaderIconColor(@Nullable Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            getSearchIcon().setColorFilter(iIntValue);
            getSearchCloseIcon().setColorFilter(iIntValue);
        }
    }

    public final void setHintTextColor(@Nullable Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            EditText searchEditText = getSearchEditText();
            if (searchEditText != null) {
                searchEditText.setHintTextColor(iIntValue);
            }
        }
    }

    public final void setPlaceholder(@NotNull String placeholder, boolean z) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        if (z) {
            this.searchView.setQueryHint(placeholder);
            return;
        }
        EditText searchEditText = getSearchEditText();
        if (searchEditText != null) {
            searchEditText.setHint(placeholder);
        }
    }
}
