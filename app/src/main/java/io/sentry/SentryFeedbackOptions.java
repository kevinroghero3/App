package io.sentry;

import ch.qos.logback.core.CoreConstants;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryFeedbackOptions {
    private CharSequence cancelButtonLabel;
    private CharSequence emailLabel;
    private CharSequence emailPlaceholder;
    private CharSequence formTitle;
    private IDialogHandler iDialogHandler;
    private boolean isEmailRequired;
    private boolean isNameRequired;
    private CharSequence isRequiredLabel;
    private CharSequence messageLabel;
    private CharSequence messagePlaceholder;
    private CharSequence nameLabel;
    private CharSequence namePlaceholder;
    private Runnable onFormClose;
    private Runnable onFormOpen;
    private SentryFeedbackCallback onSubmitError;
    private SentryFeedbackCallback onSubmitSuccess;
    private boolean showBranding;
    private boolean showEmail;
    private boolean showName;
    private CharSequence submitButtonLabel;
    private CharSequence successMessageText;
    private boolean useSentryUser;

    public interface IDialogHandler {
        void showDialog(@Nullable SentryId sentryId, @Nullable OptionsConfigurator optionsConfigurator);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface OptionsConfigurator {
        void configure(@NotNull SentryFeedbackOptions sentryFeedbackOptions);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface SentryFeedbackCallback {
        void call(@NotNull Feedback feedback);
    }

    public SentryFeedbackOptions(@NotNull IDialogHandler iDialogHandler) {
        this.isNameRequired = false;
        this.showName = true;
        this.isEmailRequired = false;
        this.showEmail = true;
        this.useSentryUser = true;
        this.showBranding = true;
        this.formTitle = "Report a Bug";
        this.submitButtonLabel = "Send Bug Report";
        this.cancelButtonLabel = "Cancel";
        this.nameLabel = "Name";
        this.namePlaceholder = "Your Name";
        this.emailLabel = "Email";
        this.emailPlaceholder = "your.email@example.org";
        this.isRequiredLabel = " (Required)";
        this.messageLabel = "Description";
        this.messagePlaceholder = "What's the bug? What did you expect?";
        this.successMessageText = "Thank you for your report!";
        this.iDialogHandler = iDialogHandler;
    }

    public SentryFeedbackOptions(@NotNull SentryFeedbackOptions sentryFeedbackOptions) {
        this.isNameRequired = false;
        this.showName = true;
        this.isEmailRequired = false;
        this.showEmail = true;
        this.useSentryUser = true;
        this.showBranding = true;
        this.formTitle = "Report a Bug";
        this.submitButtonLabel = "Send Bug Report";
        this.cancelButtonLabel = "Cancel";
        this.nameLabel = "Name";
        this.namePlaceholder = "Your Name";
        this.emailLabel = "Email";
        this.emailPlaceholder = "your.email@example.org";
        this.isRequiredLabel = " (Required)";
        this.messageLabel = "Description";
        this.messagePlaceholder = "What's the bug? What did you expect?";
        this.successMessageText = "Thank you for your report!";
        this.isNameRequired = sentryFeedbackOptions.isNameRequired;
        this.showName = sentryFeedbackOptions.showName;
        this.isEmailRequired = sentryFeedbackOptions.isEmailRequired;
        this.showEmail = sentryFeedbackOptions.showEmail;
        this.useSentryUser = sentryFeedbackOptions.useSentryUser;
        this.showBranding = sentryFeedbackOptions.showBranding;
        this.formTitle = sentryFeedbackOptions.formTitle;
        this.submitButtonLabel = sentryFeedbackOptions.submitButtonLabel;
        this.cancelButtonLabel = sentryFeedbackOptions.cancelButtonLabel;
        this.nameLabel = sentryFeedbackOptions.nameLabel;
        this.namePlaceholder = sentryFeedbackOptions.namePlaceholder;
        this.emailLabel = sentryFeedbackOptions.emailLabel;
        this.emailPlaceholder = sentryFeedbackOptions.emailPlaceholder;
        this.isRequiredLabel = sentryFeedbackOptions.isRequiredLabel;
        this.messageLabel = sentryFeedbackOptions.messageLabel;
        this.messagePlaceholder = sentryFeedbackOptions.messagePlaceholder;
        this.successMessageText = sentryFeedbackOptions.successMessageText;
        this.onFormOpen = sentryFeedbackOptions.onFormOpen;
        this.onFormClose = sentryFeedbackOptions.onFormClose;
        this.onSubmitSuccess = sentryFeedbackOptions.onSubmitSuccess;
        this.onSubmitError = sentryFeedbackOptions.onSubmitError;
        this.iDialogHandler = sentryFeedbackOptions.iDialogHandler;
    }

    public boolean isNameRequired() {
        return this.isNameRequired;
    }

    public void setNameRequired(boolean z) {
        this.isNameRequired = z;
    }

    public boolean isShowName() {
        return this.showName;
    }

    public void setShowName(boolean z) {
        this.showName = z;
    }

    public boolean isEmailRequired() {
        return this.isEmailRequired;
    }

    public void setEmailRequired(boolean z) {
        this.isEmailRequired = z;
    }

    public boolean isShowEmail() {
        return this.showEmail;
    }

    public void setShowEmail(boolean z) {
        this.showEmail = z;
    }

    public boolean isUseSentryUser() {
        return this.useSentryUser;
    }

    public void setUseSentryUser(boolean z) {
        this.useSentryUser = z;
    }

    public boolean isShowBranding() {
        return this.showBranding;
    }

    public void setShowBranding(boolean z) {
        this.showBranding = z;
    }

    public CharSequence getFormTitle() {
        return this.formTitle;
    }

    public void setFormTitle(@NotNull CharSequence charSequence) {
        this.formTitle = charSequence;
    }

    public CharSequence getSubmitButtonLabel() {
        return this.submitButtonLabel;
    }

    public void setSubmitButtonLabel(@NotNull CharSequence charSequence) {
        this.submitButtonLabel = charSequence;
    }

    public CharSequence getCancelButtonLabel() {
        return this.cancelButtonLabel;
    }

    public void setCancelButtonLabel(@NotNull CharSequence charSequence) {
        this.cancelButtonLabel = charSequence;
    }

    public CharSequence getNameLabel() {
        return this.nameLabel;
    }

    public void setNameLabel(@NotNull CharSequence charSequence) {
        this.nameLabel = charSequence;
    }

    public CharSequence getNamePlaceholder() {
        return this.namePlaceholder;
    }

    public void setNamePlaceholder(@NotNull CharSequence charSequence) {
        this.namePlaceholder = charSequence;
    }

    public CharSequence getEmailLabel() {
        return this.emailLabel;
    }

    public void setEmailLabel(@NotNull CharSequence charSequence) {
        this.emailLabel = charSequence;
    }

    public CharSequence getEmailPlaceholder() {
        return this.emailPlaceholder;
    }

    public void setEmailPlaceholder(@NotNull CharSequence charSequence) {
        this.emailPlaceholder = charSequence;
    }

    public CharSequence getIsRequiredLabel() {
        return this.isRequiredLabel;
    }

    public void setIsRequiredLabel(@NotNull CharSequence charSequence) {
        this.isRequiredLabel = charSequence;
    }

    public CharSequence getMessageLabel() {
        return this.messageLabel;
    }

    public void setMessageLabel(@NotNull CharSequence charSequence) {
        this.messageLabel = charSequence;
    }

    public CharSequence getMessagePlaceholder() {
        return this.messagePlaceholder;
    }

    public void setMessagePlaceholder(@NotNull CharSequence charSequence) {
        this.messagePlaceholder = charSequence;
    }

    public CharSequence getSuccessMessageText() {
        return this.successMessageText;
    }

    public void setSuccessMessageText(@NotNull CharSequence charSequence) {
        this.successMessageText = charSequence;
    }

    public Runnable getOnFormOpen() {
        return this.onFormOpen;
    }

    public void setOnFormOpen(@Nullable Runnable runnable) {
        this.onFormOpen = runnable;
    }

    public Runnable getOnFormClose() {
        return this.onFormClose;
    }

    public void setOnFormClose(@Nullable Runnable runnable) {
        this.onFormClose = runnable;
    }

    public SentryFeedbackCallback getOnSubmitSuccess() {
        return this.onSubmitSuccess;
    }

    public void setOnSubmitSuccess(@Nullable SentryFeedbackCallback sentryFeedbackCallback) {
        this.onSubmitSuccess = sentryFeedbackCallback;
    }

    public SentryFeedbackCallback getOnSubmitError() {
        return this.onSubmitError;
    }

    public void setOnSubmitError(@Nullable SentryFeedbackCallback sentryFeedbackCallback) {
        this.onSubmitError = sentryFeedbackCallback;
    }

    public void setDialogHandler(@NotNull IDialogHandler iDialogHandler) {
        this.iDialogHandler = iDialogHandler;
    }

    public IDialogHandler getDialogHandler() {
        return this.iDialogHandler;
    }

    public String toString() {
        return "SentryFeedbackOptions{isNameRequired=" + this.isNameRequired + ", showName=" + this.showName + ", isEmailRequired=" + this.isEmailRequired + ", showEmail=" + this.showEmail + ", useSentryUser=" + this.useSentryUser + ", showBranding=" + this.showBranding + ", formTitle='" + ((Object) this.formTitle) + CoreConstants.SINGLE_QUOTE_CHAR + ", submitButtonLabel='" + ((Object) this.submitButtonLabel) + CoreConstants.SINGLE_QUOTE_CHAR + ", cancelButtonLabel='" + ((Object) this.cancelButtonLabel) + CoreConstants.SINGLE_QUOTE_CHAR + ", nameLabel='" + ((Object) this.nameLabel) + CoreConstants.SINGLE_QUOTE_CHAR + ", namePlaceholder='" + ((Object) this.namePlaceholder) + CoreConstants.SINGLE_QUOTE_CHAR + ", emailLabel='" + ((Object) this.emailLabel) + CoreConstants.SINGLE_QUOTE_CHAR + ", emailPlaceholder='" + ((Object) this.emailPlaceholder) + CoreConstants.SINGLE_QUOTE_CHAR + ", isRequiredLabel='" + ((Object) this.isRequiredLabel) + CoreConstants.SINGLE_QUOTE_CHAR + ", messageLabel='" + ((Object) this.messageLabel) + CoreConstants.SINGLE_QUOTE_CHAR + ", messagePlaceholder='" + ((Object) this.messagePlaceholder) + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
    }
}
