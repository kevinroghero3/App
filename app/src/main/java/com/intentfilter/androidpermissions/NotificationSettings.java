package com.intentfilter.androidpermissions;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationSettings {
    private int messageResId;
    private int smallIconResId;
    private int titleResId;

    private NotificationSettings(@StringRes int i, @StringRes int i2, @DrawableRes int i3) {
        this.titleResId = i;
        this.messageResId = i2;
        this.smallIconResId = i3;
    }

    static NotificationSettings getDefault() {
        return new NotificationSettings(R.string.title_permission_required, R.string.message_permission_required, android.R.mipmap.sym_def_app_icon);
    }

    public int getTitleResId() {
        return this.titleResId;
    }

    public int getMessageResId() {
        return this.messageResId;
    }

    public int getSmallIconResId() {
        return this.smallIconResId;
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class Builder {
        private final NotificationSettings notificationSettings = NotificationSettings.getDefault();

        public Builder withTitle(@StringRes int i) {
            this.notificationSettings.titleResId = i;
            return this;
        }

        public Builder withMessage(@StringRes int i) {
            this.notificationSettings.messageResId = i;
            return this;
        }

        public Builder withSmallIcon(@DrawableRes int i) {
            this.notificationSettings.smallIconResId = i;
            return this;
        }

        public NotificationSettings build() {
            return this.notificationSettings;
        }
    }
}
