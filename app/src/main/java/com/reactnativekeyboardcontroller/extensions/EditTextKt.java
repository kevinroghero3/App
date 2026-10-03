package com.reactnativekeyboardcontroller.extensions;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.textinput.ReactEditText;
import com.reactnativekeyboardcontroller.log.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class EditTextKt {
    public static final TextWatcher addOnTextChangedListener(@NotNull EditText editText, @NotNull final Function1<? super String, Unit> action) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TextWatcher textWatcher = new TextWatcher() { // from class: com.reactnativekeyboardcontroller.extensions.EditTextKt$addOnTextChangedListener$listener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.lang.String] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ?? ValueOf = String.valueOf(charSequence);
                if (Intrinsics.areEqual((Object) ValueOf, objectRef.element)) {
                    return;
                }
                objectRef.element = ValueOf;
                action.invoke(ValueOf);
            }
        };
        try {
            Field declaredField = ReactEditText.class.getDeclaredField("mListeners");
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(editText);
            ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
            if (arrayList == null) {
                Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because `fieldValue` does not belong to `ArrayList<TextWatcher>`", null, 4, null);
            } else {
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (!(it2.next() instanceof TextWatcher)) {
                            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because `fieldValue` does not belong to `ArrayList<TextWatcher>`", null, 4, null);
                        }
                    }
                }
                arrayList.add(0, textWatcher);
            }
        } catch (ClassCastException e) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because casting failed: " + e.getMessage(), null, 4, null);
        } catch (IllegalArgumentException e2) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener to be the first in the list: " + e2.getMessage() + ". Attaching to the end...", null, 4, null);
            editText.addTextChangedListener(textWatcher);
        } catch (NoSuchFieldException e3) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because field `mListeners` not found: " + e3.getMessage(), null, 4, null);
        }
        return textWatcher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.EditText, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static final int getParentScrollViewTarget(@NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        while (editText != 0) {
            Object parent = editText.getParent();
            editText = parent instanceof View ? (View) parent : 0;
            if (editText instanceof ReactScrollView) {
                ReactScrollView reactScrollView = (ReactScrollView) editText;
                if (reactScrollView.getScrollEnabled()) {
                    return reactScrollView.getId();
                }
            }
        }
        return -1;
    }

    public static final void focus(@Nullable EditText editText) {
        if (editText instanceof ReactEditText) {
            ((ReactEditText) editText).requestFocusFromJS();
        } else if (editText != null) {
            editText.requestFocus();
        }
    }

    public static final String getKeyboardType(@Nullable EditText editText) {
        if (editText == null) {
            return "default";
        }
        int inputType = editText.getInputType() & 15;
        int inputType2 = editText.getInputType() & 4080;
        if (inputType2 == 32) {
            return "email-address";
        }
        if (inputType2 == 16) {
            return "url";
        }
        if (inputType2 == 144) {
            return "visible-password";
        }
        if (inputType != 2) {
            if (inputType != 3) {
                return "default";
            }
            return "phone-pad";
        }
        if ((editText.getInputType() & 8192) == 0 || (editText.getInputType() & 4096) != 0) {
            return (editText.getInputType() & 4096) != 0 ? Constants.COLLATION_OPTION_NUMERIC : "number-pad";
        }
        return "decimal-pad";
    }

    public static final Function0<Unit> addOnSelectionChangedListener(@NotNull EditText editText, @NotNull Function6<? super Integer, ? super Integer, ? super Double, ? super Double, ? super Double, ? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final KeyboardControllerSelectionWatcher keyboardControllerSelectionWatcher = new KeyboardControllerSelectionWatcher(editText, action);
        keyboardControllerSelectionWatcher.setup();
        return new Function0() { // from class: com.reactnativekeyboardcontroller.extensions.EditTextKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditTextKt.addOnSelectionChangedListener$lambda$1(keyboardControllerSelectionWatcher);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addOnSelectionChangedListener$lambda$1(KeyboardControllerSelectionWatcher keyboardControllerSelectionWatcher) {
        keyboardControllerSelectionWatcher.destroy();
        return Unit.INSTANCE;
    }
}
