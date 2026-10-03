package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class EditProcessor {
    public static final int $stable = 8;
    private EditingBuffer mBuffer;
    private TextFieldValue mBufferState;

    public EditProcessor() {
        TextFieldValue textFieldValue = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m3140getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);
        this.mBufferState = textFieldValue;
        this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), this.mBufferState.m3382getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
    }

    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    public final void reset(@NotNull TextFieldValue textFieldValue, @Nullable TextInputSession textInputSession) {
        boolean zAreEqual = Intrinsics.areEqual(textFieldValue.m3381getCompositionMzsxiRA(), this.mBuffer.m3294getCompositionMzsxiRA$ui_text_release());
        boolean z = true;
        boolean z2 = false;
        if (!Intrinsics.areEqual(this.mBufferState.getAnnotatedString(), textFieldValue.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m3382getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (TextRange.m3128equalsimpl0(this.mBufferState.m3382getSelectiond9O1mEE(), textFieldValue.m3382getSelectiond9O1mEE())) {
            z = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m3133getMinimpl(textFieldValue.m3382getSelectiond9O1mEE()), TextRange.m3132getMaximpl(textFieldValue.m3382getSelectiond9O1mEE()));
            z2 = true;
            z = false;
        }
        if (textFieldValue.m3381getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m3129getCollapsedimpl(textFieldValue.m3381getCompositionMzsxiRA().m3139unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m3133getMinimpl(textFieldValue.m3381getCompositionMzsxiRA().m3139unboximpl()), TextRange.m3132getMaximpl(textFieldValue.m3381getCompositionMzsxiRA().m3139unboximpl()));
        }
        if (z || (!z2 && !zAreEqual)) {
            this.mBuffer.commitComposition$ui_text_release();
            textFieldValue = TextFieldValue.m3377copy3r_uNRQ$default(textFieldValue, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue2 = this.mBufferState;
        this.mBufferState = textFieldValue;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue2, textFieldValue);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }

    private final String generateBatchErrorMessage(List<? extends EditCommand> list, final EditCommand editCommand) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m3294getCompositionMzsxiRA$ui_text_release() + ", selection=" + ((Object) TextRange.m3138toStringimpl(this.mBuffer.m3295getSelectiond9O1mEE$ui_text_release())) + "):");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        CollectionsKt___CollectionsKt.joinTo$default(list, sb, "\n", null, null, 0, null, new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(@NotNull EditCommand editCommand2) {
                return (editCommand == editCommand2 ? " > " : "   ") + this.toStringForLog(editCommand2);
            }
        }, 60, null);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.getText().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.getNewCursorPosition());
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            return sb.toString();
        }
        if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.getNewCursorPosition());
            sb2.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            return sb2.toString();
        }
        if (!(editCommand instanceof SetComposingRegionCommand) && !(editCommand instanceof DeleteSurroundingTextCommand) && !(editCommand instanceof DeleteSurroundingTextInCodePointsCommand) && !(editCommand instanceof SetSelectionCommand) && !(editCommand instanceof FinishComposingTextCommand) && !(editCommand instanceof BackspaceCommand) && !(editCommand instanceof MoveCursorCommand) && !(editCommand instanceof DeleteAllCommand)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown EditCommand: ");
            String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "{anonymous EditCommand}";
            }
            sb3.append(simpleName);
            return sb3.toString();
        }
        return editCommand.toString();
    }

    public final TextFieldValue apply(@NotNull List<? extends EditCommand> list) {
        EditCommand editCommand = null;
        try {
            int size = list.size();
            int i = 0;
            EditCommand editCommand2 = null;
            while (i < size) {
                try {
                    EditCommand editCommand3 = list.get(i);
                    try {
                        editCommand3.applyTo(this.mBuffer);
                        i++;
                        editCommand2 = editCommand3;
                    } catch (Exception e) {
                        e = e;
                        editCommand = editCommand3;
                        throw new RuntimeException(generateBatchErrorMessage(list, editCommand), e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    editCommand = editCommand2;
                }
            }
            AnnotatedString annotatedString$ui_text_release = this.mBuffer.toAnnotatedString$ui_text_release();
            long jM3295getSelectiond9O1mEE$ui_text_release = this.mBuffer.m3295getSelectiond9O1mEE$ui_text_release();
            TextRange textRangeM3123boximpl = TextRange.m3123boximpl(jM3295getSelectiond9O1mEE$ui_text_release);
            textRangeM3123boximpl.m3139unboximpl();
            TextRange textRange = TextRange.m3134getReversedimpl(this.mBufferState.m3382getSelectiond9O1mEE()) ? null : textRangeM3123boximpl;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString$ui_text_release, textRange != null ? textRange.m3139unboximpl() : TextRangeKt.TextRange(TextRange.m3132getMaximpl(jM3295getSelectiond9O1mEE$ui_text_release), TextRange.m3133getMinimpl(jM3295getSelectiond9O1mEE$ui_text_release)), this.mBuffer.m3294getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e3) {
            e = e3;
        }
    }
}
