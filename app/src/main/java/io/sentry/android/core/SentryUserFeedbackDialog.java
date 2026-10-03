package io.sentry.android.core;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import io.sentry.IScopes;
import io.sentry.Sentry;
import io.sentry.SentryFeedbackOptions;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryUserFeedbackDialog extends AlertDialog {
    private final SentryId associatedEventId;
    private final OptionsConfiguration configuration;
    private final SentryFeedbackOptions.OptionsConfigurator configurator;
    private SentryId currentReplayId;
    private DialogInterface.OnDismissListener delegate;
    private boolean isCancelable;

    public interface OptionsConfiguration {
        void configure(@NotNull Context context, @NotNull SentryFeedbackOptions sentryFeedbackOptions);
    }

    SentryUserFeedbackDialog(@NotNull Context context, int i, @Nullable SentryId sentryId, @Nullable OptionsConfiguration optionsConfiguration, @Nullable SentryFeedbackOptions.OptionsConfigurator optionsConfigurator) {
        super(context, i);
        this.isCancelable = false;
        this.associatedEventId = sentryId;
        this.configuration = optionsConfiguration;
        this.configurator = optionsConfigurator;
        SentryIntegrationPackageStorage.getInstance().addIntegration("UserFeedbackWidget");
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.isCancelable = z;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        User user;
        super.onCreate(bundle);
        setContentView(R.layout.sentry_dialog_user_feedback);
        setCancelable(this.isCancelable);
        final SentryFeedbackOptions sentryFeedbackOptions = new SentryFeedbackOptions(Sentry.getCurrentScopes().getOptions().getFeedbackOptions());
        OptionsConfiguration optionsConfiguration = this.configuration;
        if (optionsConfiguration != null) {
            optionsConfiguration.configure(getContext(), sentryFeedbackOptions);
        }
        SentryFeedbackOptions.OptionsConfigurator optionsConfigurator = this.configurator;
        if (optionsConfigurator != null) {
            optionsConfigurator.configure(sentryFeedbackOptions);
        }
        TextView textView = (TextView) findViewById(R.id.sentry_dialog_user_feedback_title);
        ImageView imageView = (ImageView) findViewById(R.id.sentry_dialog_user_feedback_logo);
        final TextView textView2 = (TextView) findViewById(R.id.sentry_dialog_user_feedback_txt_name);
        final EditText editText = (EditText) findViewById(R.id.sentry_dialog_user_feedback_edt_name);
        final TextView textView3 = (TextView) findViewById(R.id.sentry_dialog_user_feedback_txt_email);
        final EditText editText2 = (EditText) findViewById(R.id.sentry_dialog_user_feedback_edt_email);
        final TextView textView4 = (TextView) findViewById(R.id.sentry_dialog_user_feedback_txt_description);
        final EditText editText3 = (EditText) findViewById(R.id.sentry_dialog_user_feedback_edt_description);
        Button button = (Button) findViewById(R.id.sentry_dialog_user_feedback_btn_send);
        Button button2 = (Button) findViewById(R.id.sentry_dialog_user_feedback_btn_cancel);
        if (sentryFeedbackOptions.isShowBranding()) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (!sentryFeedbackOptions.isShowName() && !sentryFeedbackOptions.isNameRequired()) {
            textView2.setVisibility(8);
            editText.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            editText.setVisibility(0);
            textView2.setText(sentryFeedbackOptions.getNameLabel());
            editText.setHint(sentryFeedbackOptions.getNamePlaceholder());
            if (sentryFeedbackOptions.isNameRequired()) {
                textView2.append(sentryFeedbackOptions.getIsRequiredLabel());
            }
        }
        if (!sentryFeedbackOptions.isShowEmail() && !sentryFeedbackOptions.isEmailRequired()) {
            textView3.setVisibility(8);
            editText2.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            editText2.setVisibility(0);
            textView3.setText(sentryFeedbackOptions.getEmailLabel());
            editText2.setHint(sentryFeedbackOptions.getEmailPlaceholder());
            if (sentryFeedbackOptions.isEmailRequired()) {
                textView3.append(sentryFeedbackOptions.getIsRequiredLabel());
            }
        }
        if (sentryFeedbackOptions.isUseSentryUser() && (user = Sentry.getCurrentScopes().getScope().getUser()) != null) {
            editText.setText(user.getUsername());
            editText2.setText(user.getEmail());
        }
        textView4.setText(sentryFeedbackOptions.getMessageLabel());
        textView4.append(sentryFeedbackOptions.getIsRequiredLabel());
        editText3.setHint(sentryFeedbackOptions.getMessagePlaceholder());
        textView.setText(sentryFeedbackOptions.getFormTitle());
        button.setText(sentryFeedbackOptions.getSubmitButtonLabel());
        button.setOnClickListener(new View.OnClickListener() { // from class: io.sentry.android.core.SentryUserFeedbackDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(editText, editText2, editText3, sentryFeedbackOptions, textView2, textView3, textView4, view);
            }
        });
        button2.setText(sentryFeedbackOptions.getCancelButtonLabel());
        button2.setOnClickListener(new View.OnClickListener() { // from class: io.sentry.android.core.SentryUserFeedbackDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        setOnDismissListener(this.delegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(EditText editText, EditText editText2, EditText editText3, SentryFeedbackOptions sentryFeedbackOptions, TextView textView, TextView textView2, TextView textView3, View view) {
        String strTrim = editText.getText().toString().trim();
        String strTrim2 = editText2.getText().toString().trim();
        String strTrim3 = editText3.getText().toString().trim();
        if (strTrim.isEmpty() && sentryFeedbackOptions.isNameRequired()) {
            editText.setError(textView.getText());
            return;
        }
        if (strTrim2.isEmpty() && sentryFeedbackOptions.isEmailRequired()) {
            editText2.setError(textView2.getText());
            return;
        }
        if (strTrim3.isEmpty()) {
            editText3.setError(textView3.getText());
            return;
        }
        Feedback feedback = new Feedback(strTrim3);
        feedback.setName(strTrim);
        feedback.setContactEmail(strTrim2);
        SentryId sentryId = this.associatedEventId;
        if (sentryId != null) {
            feedback.setAssociatedEventId(sentryId);
        }
        SentryId sentryId2 = this.currentReplayId;
        if (sentryId2 != null) {
            feedback.setReplayId(sentryId2);
        }
        if (!Sentry.captureFeedback(feedback).equals(SentryId.EMPTY_ID)) {
            Toast.makeText(getContext(), sentryFeedbackOptions.getSuccessMessageText(), 0).show();
            SentryFeedbackOptions.SentryFeedbackCallback onSubmitSuccess = sentryFeedbackOptions.getOnSubmitSuccess();
            if (onSubmitSuccess != null) {
                onSubmitSuccess.call(feedback);
            }
        } else {
            SentryFeedbackOptions.SentryFeedbackCallback onSubmitError = sentryFeedbackOptions.getOnSubmitError();
            if (onSubmitError != null) {
                onSubmitError.call(feedback);
            }
        }
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        cancel();
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.delegate = onDismissListener;
        final Runnable onFormClose = Sentry.getCurrentScopes().getOptions().getFeedbackOptions().getOnFormClose();
        if (onFormClose != null) {
            super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: io.sentry.android.core.SentryUserFeedbackDialog$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$setOnDismissListener$2(onFormClose, dialogInterface);
                }
            });
        } else {
            super.setOnDismissListener(this.delegate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnDismissListener$2(Runnable runnable, DialogInterface dialogInterface) {
        runnable.run();
        this.currentReplayId = null;
        DialogInterface.OnDismissListener onDismissListener = this.delegate;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        SentryOptions options = Sentry.getCurrentScopes().getOptions();
        Runnable onFormOpen = options.getFeedbackOptions().getOnFormOpen();
        if (onFormOpen != null) {
            onFormOpen.run();
        }
        options.getReplayController().captureReplay(Boolean.FALSE);
        this.currentReplayId = options.getReplayController().getReplayId();
    }

    @Override // android.app.Dialog
    public void show() {
        IScopes currentScopes = Sentry.getCurrentScopes();
        SentryOptions options = currentScopes.getOptions();
        if (!currentScopes.isEnabled() || !options.isEnabled()) {
            options.getLogger().log(SentryLevel.WARNING, "Sentry is disabled. Feedback dialog won't be shown.", new Object[0]);
        } else {
            super.show();
        }
    }

    public static class Builder {
        SentryId associatedEventId;
        OptionsConfiguration configuration;
        SentryFeedbackOptions.OptionsConfigurator configurator;
        final Context context;
        final int themeResId;

        public Builder(@NotNull Context context) {
            this(context, 0);
        }

        public Builder(Context context, int i) {
            this(context, i, null);
        }

        public Builder(@NotNull Context context, @Nullable OptionsConfiguration optionsConfiguration) {
            this(context, 0, optionsConfiguration);
        }

        public Builder(@NotNull Context context, int i, @Nullable OptionsConfiguration optionsConfiguration) {
            this.context = context;
            this.themeResId = i;
            this.configuration = optionsConfiguration;
        }

        public Builder configurator(@Nullable SentryFeedbackOptions.OptionsConfigurator optionsConfigurator) {
            this.configurator = optionsConfigurator;
            return this;
        }

        public Builder associatedEventId(@Nullable SentryId sentryId) {
            this.associatedEventId = sentryId;
            return this;
        }

        public SentryUserFeedbackDialog create() {
            return new SentryUserFeedbackDialog(this.context, this.themeResId, this.associatedEventId, this.configuration, this.configurator);
        }
    }
}
