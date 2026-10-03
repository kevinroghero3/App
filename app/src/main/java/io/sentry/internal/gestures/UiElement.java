package io.sentry.internal.gestures;

import io.sentry.util.Objects;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class UiElement {
    final String className;
    final String origin;
    final String resourceName;
    final String tag;
    final WeakReference<Object> viewRef;

    public enum Type {
        CLICKABLE,
        SCROLLABLE
    }

    public UiElement(@Nullable Object obj, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
        this.viewRef = new WeakReference<>(obj);
        this.className = str;
        this.resourceName = str2;
        this.tag = str3;
        this.origin = str4;
    }

    public String getClassName() {
        return this.className;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public String getTag() {
        return this.tag;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getIdentifier() {
        String str = this.resourceName;
        return str != null ? str : (String) Objects.requireNonNull(this.tag, "UiElement.tag can't be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UiElement.class != obj.getClass()) {
            return false;
        }
        UiElement uiElement = (UiElement) obj;
        return Objects.equals(this.className, uiElement.className) && Objects.equals(this.resourceName, uiElement.resourceName) && Objects.equals(this.tag, uiElement.tag);
    }

    public Object getView() {
        return this.viewRef.get();
    }

    public int hashCode() {
        return Objects.hash(this.viewRef, this.resourceName, this.tag);
    }
}
