package com.facebook.react.views.textinput;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Predicate;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import app.notifee.core.c$$ExternalSyntheticLambda9;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.internal.span.CustomLetterSpacingSpan;
import com.facebook.react.views.text.internal.span.CustomLineHeightSpan;
import com.facebook.react.views.text.internal.span.CustomStyleSpan;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactTextPaintHolderSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import com.google.common.base.Ascii;
import com.google.logging.type.LogSeverity;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ReactEditText extends AppCompatEditText {
    public static final boolean DEBUG_MODE;
    private static final KeyListener sKeyListener;
    private final String TAG;
    private boolean mAutoFocus;
    protected boolean mContainsImages;
    private ContentSizeWatcher mContentSizeWatcher;
    private boolean mContextMenuHidden;
    private final int mDefaultGravityHorizontal;
    private final int mDefaultGravityVertical;
    private boolean mDetectScrollMovement;
    private boolean mDidAttachToWindow;
    private boolean mDisableFullscreen;
    protected boolean mDisableTextDiffing;
    private EventDispatcher mEventDispatcher;
    private String mFontFamily;
    private int mFontStyle;
    private int mFontWeight;
    private final InputMethodManager mInputMethodManager;
    protected boolean mIsSettingTextFromJS;
    protected boolean mIsSettingTextFromState;
    private InternalKeyListener mKeyListener;
    public ArrayList<TextWatcher> mListeners;
    protected int mNativeEventCount;
    private boolean mOnKeyPress;
    private Overflow mOverflow;
    private String mPlaceholder;
    private String mReturnKeyType;
    private ScrollWatcher mScrollWatcher;
    private boolean mSelectTextOnFocus;
    private SelectionWatcher mSelectionWatcher;
    private int mStagedInputType;
    private StateWrapper mStateWrapper;
    private String mSubmitBehavior;
    private TextAttributes mTextAttributes;
    private TextWatcherDelegator mTextWatcherDelegator;
    private boolean mTypefaceDirty;

    @Override // android.view.View
    public boolean isLayoutRequested() {
        return false;
    }

    static {
        boolean z = ReactBuildConfig.DEBUG;
        DEBUG_MODE = false;
        sKeyListener = QwertyKeyListener.getInstanceForFullKeyboard();
    }

    public ReactEditText(Context context) {
        super(context);
        this.TAG = ReactEditText.class.getSimpleName();
        this.mSubmitBehavior = null;
        this.mDetectScrollMovement = false;
        this.mOnKeyPress = false;
        this.mTypefaceDirty = false;
        this.mFontFamily = null;
        this.mFontWeight = -1;
        this.mFontStyle = -1;
        this.mAutoFocus = false;
        this.mContextMenuHidden = false;
        this.mDidAttachToWindow = false;
        this.mSelectTextOnFocus = false;
        this.mPlaceholder = null;
        this.mOverflow = Overflow.VISIBLE;
        this.mStateWrapper = null;
        this.mDisableTextDiffing = false;
        this.mIsSettingTextFromState = false;
        setFocusableInTouchMode(false);
        this.mInputMethodManager = (InputMethodManager) Assertions.assertNotNull(context.getSystemService("input_method"));
        this.mDefaultGravityHorizontal = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        this.mDefaultGravityVertical = getGravity() & 112;
        this.mNativeEventCount = 0;
        this.mIsSettingTextFromJS = false;
        this.mDisableFullscreen = false;
        this.mListeners = null;
        this.mTextWatcherDelegator = null;
        this.mStagedInputType = getInputType();
        if (this.mKeyListener == null) {
            this.mKeyListener = new InternalKeyListener();
        }
        this.mScrollWatcher = null;
        this.mTextAttributes = new TextAttributes();
        applyTextAttributes();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 27) {
            setLayerType(1, null);
        }
        ViewCompat.setAccessibilityDelegate(this, new ReactAccessibilityDelegate(this, isFocusable(), getImportantForAccessibility()) { // from class: com.facebook.react.views.textinput.ReactEditText.1
            @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 == 16) {
                    int length = ReactEditText.this.getText().length();
                    if (length > 0) {
                        ReactEditText.this.setSelection(length);
                    }
                    return ReactEditText.this.requestFocusInternal();
                }
                return super.performAccessibilityAction(view, i2, bundle);
            }
        });
        ActionMode.Callback callback = new ActionMode.Callback() { // from class: com.facebook.react.views.textinput.ReactEditText.2
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                if (ReactEditText.this.mContextMenuHidden) {
                    return false;
                }
                menu.removeItem(R.id.pasteAsPlainText);
                return true;
            }
        };
        setCustomSelectionActionModeCallback(callback);
        setCustomInsertionActionModeCallback(callback);
    }

    protected void finalize() {
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "finalize[" + getId() + "] delete cached spannable");
        }
        TextLayoutManager.deleteCachedSpannableForTag(getId());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onContentSizeChange();
        if (this.mSelectTextOnFocus && isFocused()) {
            selectAll();
            this.mSelectTextOnFocus = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDetectScrollMovement = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.mDetectScrollMovement) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.mDetectScrollMovement = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 66 && !isMultiline()) {
            hideSoftKeyboard();
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        this.mTextAttributes.setLineHeight(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollWatcher scrollWatcher = this.mScrollWatcher;
        if (scrollWatcher != null) {
            scrollWatcher.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && this.mOnKeyPress) {
            inputConnectionOnCreateInputConnection = new ReactEditTextInputConnectionWrapper(inputConnectionOnCreateInputConnection, reactContext, this, this.mEventDispatcher);
        }
        if (isMultiline() && (shouldBlurOnReturn() || shouldSubmitOnReturn())) {
            editorInfo.imeOptions &= -1073741825;
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i == 16908322) {
            i = R.id.pasteAsPlainText;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View
    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        hideSoftKeyboard();
    }

    @Override // android.view.View
    public boolean requestFocus(int i, Rect rect) {
        return isFocused();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestFocusInternal() {
        setFocusableInTouchMode(true);
        boolean zRequestFocus = super.requestFocus(130, null);
        if (getShowSoftInputOnFocus()) {
            showSoftKeyboard();
        }
        return zRequestFocus;
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.mListeners.add(textWatcher);
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        ArrayList<TextWatcher> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(textWatcher);
            if (this.mListeners.isEmpty()) {
                this.mListeners = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public void setContentSizeWatcher(@Nullable ContentSizeWatcher contentSizeWatcher) {
        this.mContentSizeWatcher = contentSizeWatcher;
    }

    public void setScrollWatcher(@Nullable ScrollWatcher scrollWatcher) {
        this.mScrollWatcher = scrollWatcher;
    }

    public void maybeSetSelection(int i, int i2, int i3) {
        if (canUpdateWithEventCount(i)) {
            maybeSetSelection(i2, i3);
        }
    }

    private void maybeSetSelection(int i, int i2) {
        if (i == -1 || i2 == -1) {
            return;
        }
        setSelection(clampToTextLength(i), clampToTextLength(i2));
    }

    private int clampToTextLength(int i) {
        return Math.max(0, Math.min(i, getText() == null ? 0 : getText().length()));
    }

    @Override // android.widget.EditText
    public void setSelection(int i, int i2) {
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "setSelection[" + getId() + "]: " + i + StringUtils.SPACE + i2);
        }
        super.setSelection(i, i2);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "onSelectionChanged[" + getId() + "]: " + i + StringUtils.SPACE + i2);
        }
        super.onSelectionChanged(i, i2);
        if (this.mSelectionWatcher == null || !hasFocus()) {
            return;
        }
        this.mSelectionWatcher.onSelectionChanged(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        SelectionWatcher selectionWatcher;
        super.onFocusChanged(z, i, rect);
        if (!z || (selectionWatcher = this.mSelectionWatcher) == null) {
            return;
        }
        selectionWatcher.onSelectionChanged(getSelectionStart(), getSelectionEnd());
    }

    public void setSelectionWatcher(@Nullable SelectionWatcher selectionWatcher) {
        this.mSelectionWatcher = selectionWatcher;
    }

    public void setOnKeyPress(boolean z) {
        this.mOnKeyPress = z;
    }

    public boolean shouldBlurOnReturn() {
        String submitBehavior = getSubmitBehavior();
        if (submitBehavior == null) {
            return !isMultiline();
        }
        return submitBehavior.equals("blurAndSubmit");
    }

    public boolean shouldSubmitOnReturn() {
        String submitBehavior = getSubmitBehavior();
        return submitBehavior != null ? submitBehavior.equals("submit") || submitBehavior.equals("blurAndSubmit") : !isMultiline();
    }

    public String getSubmitBehavior() {
        return this.mSubmitBehavior;
    }

    public void setSubmitBehavior(@Nullable String str) {
        this.mSubmitBehavior = str;
    }

    public void setDisableFullscreenUI(boolean z) {
        this.mDisableFullscreen = z;
        updateImeOptions();
    }

    public boolean getDisableFullscreenUI() {
        return this.mDisableFullscreen;
    }

    public void setReturnKeyType(String str) {
        this.mReturnKeyType = str;
        updateImeOptions();
    }

    public String getReturnKeyType() {
        return this.mReturnKeyType;
    }

    int getStagedInputType() {
        return this.mStagedInputType;
    }

    void setStagedInputType(int i) {
        this.mStagedInputType = i;
    }

    void commitStagedInputType() {
        if (getInputType() != this.mStagedInputType) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.mStagedInputType);
            maybeSetSelection(selectionStart, selectionEnd);
        }
    }

    @Override // android.widget.TextView
    public void setInputType(int i) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i);
        this.mStagedInputType = i;
        super.setTypeface(typeface);
        if (isMultiline()) {
            setSingleLine(false);
        }
        if (this.mKeyListener == null) {
            this.mKeyListener = new InternalKeyListener();
        }
        this.mKeyListener.setInputType(i);
        setKeyListener(this.mKeyListener);
    }

    public void setPlaceholder(@Nullable String str) {
        if (Objects.equals(str, this.mPlaceholder)) {
            return;
        }
        this.mPlaceholder = str;
        setHint(str);
    }

    public void setFontFamily(String str) {
        this.mFontFamily = str;
        this.mTypefaceDirty = true;
    }

    public void setFontWeight(String str) {
        int fontWeight = ReactTypefaceUtils.parseFontWeight(str);
        if (fontWeight != this.mFontWeight) {
            this.mFontWeight = fontWeight;
            this.mTypefaceDirty = true;
        }
    }

    public void setFontStyle(String str) {
        int fontStyle = ReactTypefaceUtils.parseFontStyle(str);
        if (fontStyle != this.mFontStyle) {
            this.mFontStyle = fontStyle;
            this.mTypefaceDirty = true;
        }
    }

    @Override // android.widget.TextView
    public void setFontFeatureSettings(String str) {
        if (Objects.equals(str, getFontFeatureSettings())) {
            return;
        }
        super.setFontFeatureSettings(str);
        this.mTypefaceDirty = true;
    }

    public void maybeUpdateTypeface() {
        if (this.mTypefaceDirty) {
            this.mTypefaceDirty = false;
            setTypeface(ReactTypefaceUtils.applyStyles(getTypeface(), this.mFontStyle, this.mFontWeight, this.mFontFamily, getContext().getAssets()));
            if (this.mFontStyle != -1 || this.mFontWeight != -1 || this.mFontFamily != null || getFontFeatureSettings() != null) {
                setPaintFlags(getPaintFlags() | 128);
            } else {
                setPaintFlags(getPaintFlags() & (-129));
            }
        }
    }

    public void requestFocusFromJS() {
        requestFocusInternal();
    }

    void clearFocusFromJS() {
        clearFocus();
    }

    public int incrementAndGetEventCounter() {
        int i = this.mNativeEventCount + 1;
        this.mNativeEventCount = i;
        return i;
    }

    public void maybeSetTextFromJS(ReactTextUpdate reactTextUpdate) {
        this.mIsSettingTextFromJS = true;
        maybeSetText(reactTextUpdate);
        this.mIsSettingTextFromJS = false;
    }

    public void maybeSetTextFromState(ReactTextUpdate reactTextUpdate) {
        this.mIsSettingTextFromState = true;
        maybeSetText(reactTextUpdate);
        this.mIsSettingTextFromState = false;
    }

    public boolean canUpdateWithEventCount(int i) {
        return i >= this.mNativeEventCount;
    }

    public void maybeSetText(ReactTextUpdate reactTextUpdate) {
        if (!(isSecureText() && TextUtils.equals(getText(), reactTextUpdate.getText())) && canUpdateWithEventCount(reactTextUpdate.getJsEventCounter())) {
            if (DEBUG_MODE) {
                FLog.e(this.TAG, "maybeSetText[" + getId() + "]: current text: " + ((Object) getText()) + " update: " + ((Object) reactTextUpdate.getText()));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.getText());
            manageSpans(spannableStringBuilder);
            stripStyleEquivalentSpans(spannableStringBuilder);
            this.mContainsImages = reactTextUpdate.containsImages();
            this.mDisableTextDiffing = true;
            if (reactTextUpdate.getText().length() == 0) {
                setText((CharSequence) null);
            } else {
                getText().replace(0, length(), spannableStringBuilder);
            }
            this.mDisableTextDiffing = false;
            if (getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
            }
            updateCachedSpannable();
        }
    }

    private void manageSpans(SpannableStringBuilder spannableStringBuilder) {
        for (Object obj : getText().getSpans(0, length(), Object.class)) {
            int spanFlags = getText().getSpanFlags(obj);
            boolean z = (spanFlags & 33) == 33;
            if (obj instanceof ReactSpan) {
                getText().removeSpan(obj);
            }
            if (z) {
                int spanStart = getText().getSpanStart(obj);
                int spanEnd = getText().getSpanEnd(obj);
                getText().removeSpan(obj);
                if (sameTextForSpan(getText(), spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
        }
    }

    private void stripStyleEquivalentSpans(SpannableStringBuilder spannableStringBuilder) {
        stripSpansOfKind(spannableStringBuilder, ReactAbsoluteSizeSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$stripStyleEquivalentSpans$0((ReactAbsoluteSizeSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactBackgroundColorSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$stripStyleEquivalentSpans$1((ReactBackgroundColorSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactForegroundColorSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$stripStyleEquivalentSpans$2((ReactForegroundColorSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactStrikethroughSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$stripStyleEquivalentSpans$3((ReactStrikethroughSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactUnderlineSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda4
            private static long _BOUNDARY;
            private static char[] _CREATION;
            private static final byte[] $$c = {109, -105, -81, -102};
            private static final int $$d = JfifUtil.MARKER_RST7;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {44, 60, -60, 113, 2, 52, -47, -11, -17, 5, 0, -17, 8, -19, 19, 53, -53, Ascii.CR, 1, Ascii.FF, -11, 8, -22, -1, 3};
            private static final int $$b = RotationOptions.ROTATE_180;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;

            private static String $$e(int i, short s, int i2) {
                int i3 = i2 * 3;
                int i4 = 3 - (s * 2);
                byte[] bArr = $$c;
                int i5 = 106 - i;
                byte[] bArr2 = new byte[1 - i3];
                int i6 = 0 - i3;
                int i7 = -1;
                if (bArr == null) {
                    i5 += i4;
                    i4 = i4;
                    i7 = -1;
                }
                while (true) {
                    int i8 = i4 + 1;
                    int i9 = i7 + 1;
                    bArr2[i9] = (byte) i5;
                    if (i9 == i6) {
                        return new String(bArr2, 0);
                    }
                    i5 += bArr[i8];
                    i4 = i8;
                    i7 = i9;
                }
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0020  */
            /* JADX WARN: Code duplicated, block: B:8:0x0018  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0025). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(int r7, byte r8, byte r9, java.lang.Object[] r10) {
                /*
                    int r8 = r8 + 2
                    int r7 = r7 + 4
                    byte[] r0 = com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda4.$$a
                    int r9 = r9 + 66
                    byte[] r1 = new byte[r8]
                    r2 = 0
                    if (r0 != 0) goto L10
                    r3 = r8
                    r4 = r2
                    goto L25
                L10:
                    r3 = r2
                L11:
                    int r4 = r3 + 1
                    byte r5 = (byte) r9
                    r1[r3] = r5
                    if (r4 != r8) goto L20
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    r10[r2] = r7
                    return
                L20:
                    r3 = r0[r7]
                    r6 = r3
                    r3 = r9
                    r9 = r6
                L25:
                    int r9 = -r9
                    int r3 = r3 + r9
                    int r9 = r3 + (-2)
                    int r7 = r7 + 1
                    r3 = r4
                    goto L11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda4.b(int, byte, byte, java.lang.Object[]):void");
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$stripStyleEquivalentSpans$4((ReactUnderlineSpan) obj);
            }

            private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
                int i3 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                while (_creation.b < i2) {
                    int i4 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            int iIndexOf = 7 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                            char fadingEdgeLength = (char) (9279 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                            int mode = 1977 - View.MeasureSpec.getMode(0);
                            byte b = (byte) ($$d & 10);
                            byte b2 = (byte) (b - 2);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, fadingEdgeLength, mode, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 49363), 685 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            int maximumFlingVelocity = 25 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                            char absoluteGravity = (char) (30068 - Gravity.getAbsoluteGravity(0, 0));
                            int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                            byte b5 = (byte) ($$d & 11);
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, absoluteGravity, maximumFlingVelocity2, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                char[] cArr = new char[i2];
                _creation.b = 0;
                int i5 = $10 + 115;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                while (_creation.b < i2) {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    try {
                        Object[] objArr5 = {_creation, _creation};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame4 == null) {
                            int packedPositionChild = 24 - ExpandableListView.getPackedPositionChild(0L);
                            char cIndexOf = (char) (TextUtils.indexOf("", "", 0) + 30068);
                            int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                            byte b7 = (byte) ($$d & 11);
                            byte b8 = (byte) (b7 - 3);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(packedPositionChild, cIndexOf, keyRepeatDelay, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        int i7 = $11 + 11;
                        $10 = i7 % 128;
                        if (i7 % 2 != 0) {
                            int i8 = 2 % 5;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                objArr[0] = new String(cArr);
            }

            static {
                char[] cArr = new char[1959];
                ByteBuffer.wrap("ÿ$Ûö¶\\\u0092¶m@I\u0091$òÿHÛ§¶\f\u0092\u0098mëHO$\u0091ÿ4Û\u0098¶ÿ\u0091Pm¬H#$\u008cÿÙÚ^¶Ä\u00912m\u0099Hä\u0093Õ·\u0007Ú\u00adþG\u0001±%`H\u0003\u0093¹·VÚýþi\u0001\u001a$¾H`\u0093Ô·dÚ\u001aý¶\u0001g$ÅH~\u0093\u0005¶¿Ú1ýÆö1Òã¿I\u009b£dU@\u0084-çö]Ò²¿\u0019\u009b\u008ddþAZ-\u0084ö3Ò\u0090¿à\u0098T\u0019Ñ=\u0014PµtF\u008bµ¯nÂ\u0007\u0019µ=CPóta\u008bB®µÂT\u0019Ì=mP\bw¾\u008bO®ÍÂU\u0019\u0011<¹P5wÒ\u008bj®\u0006Å¤îEÊ\u0096§,\u0083Â|!Xó5\u009bîkÊÒ§y\u0083ÿ|\u0089Ý<ùï\u0094U°»OXk\u009d\u0006ìÝQùõ\u0094\u0002°\u009bOïjO\u0019Ñ=\u0014P¨tV\u008bû¯qÂ\f\u0019þ=dPÙtI\u008b\u0002®¤Â^\u0019ä=hP\u001aw¶$\u0003\u0000Ñm\u007fI\u0093¶)\u0092þÿ\u0094$`\u0000\u0094m8I¿¶Ñ\u0093fÿ\u0086\u0019\u008c=\bPâtW\u008bõ¯lÂ\u001c\u0019ÿ=DPút`\u008b\u001f®½ÂR\u0019Ä=VP\u0000w²\u008bH®úÂn\u0019\u001d<«PpË7ï³\u0082Y¦ìYN}×\u0010§ËDïÿ\u0082A¦ÛY¤|\u0006\u0010éË\u007fïí\u0082»¥\tYó|A\u0010ÕË¦î\u0010\u0082È\u0004x ½M\u001ciï\u0096G²Ïß¬\u0004W óM_iÏ\u0096ë³\u0017ßû\u0004k ÎM¥jP\u0096æ³c35\u0017§z\u0002^ò¡\\\u0085Ò\u0019¢=&\u001a\u0004>ÁS`w\u0093\u0088;¬³ÁÐ\u001a+>\u0081S#w¿\u0088\u0097\u00adiÁ\u008b\u001a\u0018>©SítO\u0088Ä\u00ad\u001eÁº\u001aË?xS¹t\u0010\u0088µ\u00adÏÆ|\u001aå?\u0011S©\u001e*:ïWNs½\u008c\u0015¨\u009dÅþ\u001e\u0005:¯W\rs\u0091\u008c¹©GÅ¥\u001e6:\u0087WÃpa\u008cê©.Å\u0083\u001eç;S\u0082\u0003¦ÆËgï\u0094\u0010<4´Y×\u0082,¦\u0088Ë$ï´\u0010\u00905lY\u0080\u0082\u0010¦µËÙìh\u0010\u009b5!Y\u0095\u0082Ñ§xËüì\u0004\u0010ó5Õ^`\u0019Ñ=\u0003P©tC\u008bµ¯mÂ\r\u0019¼=CPøtq\u008b\b®¡ÂO\u0019\u008c=\bPâtW\u008bï¯jÂ\u0004\u0019µ=\u0018P÷tk\u008b\u001e®¦\u0019\u0090=\u0002P\u00adtF\u008bÿ¯-Â\u0006\u0019´=B\u0019Ñ=\u0017P¾tZ\u008bù¯,Â\u000e\u0019¸=ZPútw\u008b\u0014®¡ÂO\u0019Å=dP\u001d\u0019\u0090=\u0002P¡t@\u008bé¯eBÂfF\u000b¬/\u000bÐ¦ô\"\u0099BBêf\u001b\u000b¥/dÐNõý\u0099\u001bB\u009bf!\u000bA,úÐ\u0006õ\u009e\u00996BXgä\u0095Ì±WÜ÷ø\u0019\u0019\u008e=\u0002P¾tF\u008bó¯pÂ\u001c\u0019ÿ=EPætw\u008bC®°Â_\u0019\u008e=mP\u000bwµ\u008bI®ÂÂ$\u0019\u0014<¨P4w\u0088\u008bi®\u0015Å¶\u0019'<ôPww\t\u008a«®\u0018ÅÞ\u0019p<\u0014S\u0087w-\u008aÃ®sÅ\r\u0019\u008e=\u0002P¾tF\u008bó¯pÂ\u001c\u0019ÿ=EPætw\u008bC®°Â_\u0019\u008e=mP\u000bwµ\u008bI®ÂÂ$\u0019\u0014<¨P4w\u0088\u008bi®\u0015Å¶\u0019'<ôPww\t\u008a«®\u0018ÅÚ\u0019p<\u0014S\u0087w'\u008aÃ\u0095(±¤Ü\u0018øà\u0007U#ÖNº\u0095Y±ãÜ@øÑ\u0007å\"\u0016Nù\u0095(±ËÜ\u00adû\u0013\u0007ï\"dN\u0082\u0095§°\u0011ÜÉûc\u0007Ø\"»\u0019\u008e=\u0002P¾tF\u008bó¯pÂ\u001c\u0019ÿ=EPætw\u008bC®°Â_\u0019\u008e=mP\u000bwµ\u008bI®ÂÂ$\u0019\u0001<·PowÊ\u008bn®\u0017\u0019\u008e=\u0002P¾tF\u008bó¯pÂ\u001c\u0019ÿ=EPætw\u008bC®°Â_\u0019\u008e=mP\u000bwµ\u008bI®ÂÂ$\u0019\u0001<·PowË\u008bl®\u0017\u0092¬¶ Û\u009cÿd\u0000Ñ$RI>\u0092Ý¶gÛÄÿU\u0000a%\u0092I}\u0092¬¶OÛ)ü\u0097\u0000k%àI\u0006\u0092#·\u0095ÛMüé\u0000C%5ñCÕÎ¸h\u009c\u0086c\"G®~\u0018ZÞ7w\u0013\u0093ì0Èå¥Ì~wZ\u009b7#\u0013¡ìÁÉh]fyë\u0014M0£Ï\u0013ë\u0098\u0086ã]Ly¬ÏÛë`\u0086À¢.]\u0095y\u000e\u0014~ÏÚë;\u0086\u0093³Í\u0097OúáÞ\u001d!³\u00052h@\u0092-¶¿Û\u000eÿê\u0000G$ÚI\u00ad\u0092\f\u0019\u008c=\bPâtE\u008bè¯lÂ\f\u0019¤=UPët*\u008b\t®·ÂM\u0019É=jP\u000b·Ü\u0093Qþ÷Ú\u0019%ö\u0001alL\tR-É@id\u009b\u009b#¿¡ÒÀ¢À\u0086[ëûÏ\t0±\u00143yR¢×\u0086\u0017ëþÏk\u0019\u0099=\u0002P¢tP\u008bè¯jÂ\u000b\u0019\u008e=NP§t2\u008b2®äÂ\u000fûUßÑ²;\u0096\u009ci1Mµ Õû}ß\u008c²2\u0096óiÙLd \u0086û\u001cß¼kèOf\"Â\u0019\u009b=\nP¹tY\u008bû¯wÂ\u0007\u0019£l\bH %\u000b\u0001¢þ\u007fÚÁ·±l\u0012Hè%E\u0001ÖþúÛ\u0003·ãleH\u009e%\u009a\u0002\bþùÛ}·Ðl¡\u0019¿=\tP¨tG\u008bõ¯jÂ\f\u0019ñ=ePÛtO\u008bM®°ÂN\u0019É=eP\u001aw÷\u008bZ®ÊÂx\u0019S< Pyw\u0090|\u000eX¸5\u0019\u0011öîDÊÛ§½|@XÔ5j\u0011þîüË\u0001§ÿ|xXÔ5«\u0012FîëË{§É|âY\u00115È\u0012!îáËó X¡\u0091\u0085\u0015èÿÌ@3æ\u0017lz\u0011¡»\u0085JèðÌ|ÿòÛc¶Ë\u0092:m\u0097I\u0001$pÿÒÒ©ö$\u009b\u0082¿l@\u0083d\u0014\u0019\u008c=\u0006P¢tV\u008bò¯v&\u001b\u0002\u009fouKÒ´\u007f\u0090ûý\u009b&3\u0002Âo|K½´\u0098\u00917ýÍ&Y\u0002ú\u0019\u008c=\bPât^\u008bÿ¯qÂ\u0006\u0019´=ZP±tu\u008b\b®¿ÂN«4ÑÌõH\u0098¢¼\u0006C¿g \n]Ñãõ\u0013Þ¹mÈIL$¦\u0000\u0013ÿ«Û.¶@mñI\\$«\u00002ÿFÚò¶\nm\u0087I9\u0019\u0098=\u0012P tY\u008bÅ¯{ÂP\u0019ç\u0019\u008c=\bPâtW\u008bï¯jÂ\u0004\u0019µ=\u0018Pùtm\u008b\u0003®µÂ^\u0019Ò=yP\u001cw¾\u008bR®Ñ¡e\u0085þè^Ì¬3\u0014\u0017\u0096z÷¡\u0002\u0085¹è\u0007Ì\u00933¾\u0016Iz¢¡2\u0085\u0090èàÏB3£\u0097f³ýÞ]ú¯\u0005\u0017!\u0095Lô\u0097q³±ÞXúÍ\u0005½ ^L \u00974³©Þéù\u0010\u0005õ uL\u0092\u0097é²IÞÛù+\u0005\u0099 èK}\u0097Å²lÞÙ\u0019\u0099=\u0002P¢tP\u008bè¯jÂ\u000b\u0019þ=QPðtk\u008b\n®¾Â^\u0019ÿ=zP\nw¼\u008b\u0013®ÂÂo\u0019\u001d<½P3wÏ\u008blK=o¦\u0002\u0006&ôÙLýÎ\u0090¯KZoä\u0002Y&ÏÙ±üN\u0090©Kto\u0082\u0002¼%\u0011Ù÷üy\u0090\u0096Kán\f\u0019\u0099=\bP£tR\u008bö¯fÂG\u0019¢=RPôt[\u008b\n®¢ÂS\u0019Ï=gP\u000bw\u0088\u008bD®\u009dÂ<\u0019\\<¿P$wÈ\u008bj®\u0006Å´\u0019!<ôPhwA\u008aè\u0019\u008c=\bPâtW\u008bõ¯lÂ\u001c\u0019½=YPþt`\u008b\b® \u0019\u008c=\bPâtW\u008bõ¯lÂ\u001c\u0019¸=[Pþtc\u008b\b®üÂY\u0019Õ=`P\u0002w³\u008b\u0012®ÃÂc\u0019\u001d<¿P$wÔ\u008b\u007f®\u0006Å´\u0019,<ßN\u0081j7\u0007\u0096#yÜËøT\u00952NÂjp\u0007\u0099#\f\u0019\u008c=\bPâtW\u008bï¯jÂ\u0004\u0019µ=\u0018Pûtm\u008b\u001e®¢ÂW\u0019Á=pP@w¾\u008bXLÑhY\u0005ä!\u001aÞì\u0019\u0097=\tP¥tA\u008b´¯pÂ\u001e\u0019²=\u0018Pîta\u008b\u0000®§Â\u0016\u0019Ð={P\u0001w§\u008bO\u0019\u008f=\u0002P¡t@\u008b´¯kÂ\u001f\u0019ÿ=[Pþtm\u008b\u0003®¹Â^\u0019Ù=z}µY84\u009b\u0010zï\u008eËJ¦4}ÅYj4Ä\u0010Uï2Ê·¦b}ûY^41\u0013\u009fïg\u0019\u008f=\u0002P¡t@\u008b´¯pÂ\u000e\u0019ÿ=ZPüt`\u008b2®¶Â^\u0019Î=zP\u0007w£\u008bE\u0019\u008c=\bPât^\u008bÿ¯qÂ\u0006\u0019´=ZP±te\u008b\u0003®¶ÂI\u0019Ï=`P\nwù\u008bM®ÀÂg\u0019\u0006<¼Ê\fî\u0088\u0083b§×Xu|ì\u0011\u009cÊ\u007fîÇ\u0083z§éX\u0098}|\u0011ÚÊVîí\u0083±¤9XÝ}H\u0011ïôÊÐN½¤\u0099\u001cf¸B(/\u0000ôõÐ\u0005½°\u0099.fOCº/\u001bô\u008fÐ!½O\u009aôf\bC\u0093/>ô\\Ñð½sjÖNR#¸\u0007\u001fø²Ü6±VjþN\u000f#±\u0007pøUÝý±\bj\u0096N7#\u001a\u0004ëø\u000fÝ\u0091±7jLOð#k\u0004\u008eø<Ý@¶ó\u0019\u008c=\bPâtF\u008bã¯pÂ\u001c\u0019´=[P±tf\u008b\u0018®»ÂW\u0019Ä='P\bw¾\u008bR®ÂÂo\u0019\u0001<¨P3wÏ\u008ba®\u0000\u0019\u008c=\bPâtF\u008bã¯pÂ\u001c\u0019´=[PÀta\u008b\u0015®¦Â\u0015\u0019Â=|P\u0007w»\u008bX®\u008bÂl\u0019\u001a<¶P&wÃ\u008b}®\u0004Å¯\u0019+<ÅPd\u0019\u008c=\bPâtC\u008bÿ¯mÂ\f\u0019¾=DP±tf\u008b\u0018®»ÂW\u0019Ä='P\bw¾\u008bR®ÂÂo\u0019\u0001<¨P3wÏ\u008ba®\u0000·ñ\u0093uþ\u009fÚ>%\u0082\u0001\u0010lq·Ã\u00939þ½Ú\u001d%|\u0000Äl+·ó\u0093\u0016þfÙÃ%-\u0000¼lY·h\u0092ÌþRÙ¼%\u0017\u0000{kÐ·M\u0092¿þ\u0003Ùp\u0019ÄüdØ¶µ\u001c\u0091ön\u0000JÇ'¸ü\tØöµu\u0091Án±K\u0017'ë¬ø\u0088*å\u0080Áj>\u009c\u001aYw.¬\u009b\u0088tåÓÁY>k\u001b\u0099ws¬ú\u0088Eå%Â\u009f>{\u001bèw|¬=\u0089\u0094å\u0006Âö>B\u0019Ñ=\u0003P©tC\u008bµ¯pÂ\u0007\u0019²=]Pútp\u008bB®µÂ^\u0019Î=pP\n\u0019Ñ=\u0003P©tC\u008bµ¯pÂ\u0007\u0019²=]Pútp\u008bB®£Â^\u0019Í=|P\nO=kø\u0006Y\"ªÝYù\u009e\u0094áOPk¯\u0006,\"\u009cÝóø_\u0094´O)Ù\u0080ýE\u0090ä´\u0017K¿o7\u0002TÙ¯ý\u000b\u0090§´7K\u0013nï\u0002\u0003Ù\u0093ý;\u0090`·ëK\fn\u0098\u00027ÙMüê\u0090O·\u0093K;nG\u0005ùÙtü¥\u00900·MJânc\u0005ÓÙ7üDÃëç9\u008a\u0093®yQ\u008fu[\u0018!Ã\u009fçS\u008aÂ®NQ$%£\u0001qlÛH1·Ç\u0093\u0013þi%×\u0001\u001bl\u0099H\u001f·r\u0092Å\u0013\u00947FZì~\u0006\u0081ð¥5ÈB\u0013÷7\u0018Z¿~5\u0081\u0007¤õÈ\r\u0013\u00917*ZD}þ\u0081\u001d¤\u0085È=\u0013R\u000f\t+ÌFmb\u009e\u009d6¹¾ÔÝ\u000f&+\u0082F.b¾\u009d\u009a¸fÔ\u008a\u000f\u001a+³FÅa{\u009d\u0082¸\u0012Ô¾\u000fÏ*eFëa!\u009d½¸ÂÓl\u000f´*\u0000F§\u0019Ñ=\u0003P©tC\u008bµ¯aÂ\u001b\u0019¥=WPütg\u008b\b\u0019Ñ=\u0003P©tC\u008bµ¯aÂ\u001b\u0019¥=QPætv\u008b\u0002\u0019Ñ=\u0003P©tC\u008bµ¯aÂ\u001b\u0019¥=[Pútc\u008b\u0003\u0019Ñ=\u0003P©tC\u008bµ¯aÂ\u001b\u0019¥=YPítm\u008b\b\u0019Ñ=\u0003P©tC\u008bµ¯aÂ\u001b\u0019¥=@Pòtw\u008b\n\u0019Ñ=\u0003P©tC\u008bµ¯aÂ\u001b\u0019¥=FPøte\u008b\u0004®¢ÂX\u0019Ñ=\u0003P©tC\u008bµ¯aÂ\u001b\u0019¥=iPöti\u008b\b\u0019Ñ=\u0003P\u00adtA\u008bû¯,Â\f\u0019¾=APñth\u008b\u0002®³Â_\u0019Ó=&P@w¯\u008b^®\u008aÂh\u0019\u0000<¬P*Ê\u0095îN\u0083æ§\u0005Xñ|0\u0011EÊûî\u0016\u0083´§7XZ}¹\u0011=Ê\u0097î9\u0083y¤ûX\u0019}\u0093\u0011+ÊSïÚ\u0083j¤\u008eX/}U\u0016ë\u0019Ñ=\u0017P¾tZ\u008bù¯,Â\u0001\u0019¾=FPðtv\u008b\u0019®¡\u0081i¥¦È\rì²\u0013\u0007QÜu\u001a\u0018³<WÃôç!\u008a\u0016Q¹uW\u0018ô<&Ã\ræ¾\u008aFQÞ\u0019\u0099=\u0015P\u00adtY\u008bö¯lÂ\u000b\u0019ÿ=QPðth\u008b\t®´ÂR\u0019Ó=aP@w¤\u008bS\u0019\u0092=\u000eP®tr\u008bÖ¯FÂ;\u0019\u008e=TPìtp\u008bC®¡ÂTÔgð´\u009d\u000e¹àF\u0003bØ\u000f»Ô\u0003ðé\u009dH¹íF¸c\u000b\u000féÔsðÜ\u009d«ºOFòc~\u000fÐohKÿ&M\u0002¤ý\u001dÙ\u0083´ýoFK©&\u0018\u0019Ñ=\u0002P¸tV\u008bµ¯nÂ\u0007\u0019¤=XPëtw\u0019Ñ=\u0003P\u00adtA\u008bû¯,Â\f\u0019¾=APñth\u008b\u0002®³Â_\u0019Ó=&P@w³\u008bL®\u008aÂk\u0019\u0003<¨P2w\u0088\u008bw®\u0019Å±\u0019Ñ=\u0017P¾tZ\u008bù¯,Â\u000b\u0019¡=CPötj\u008b\u000b®½\u0019¹=\bP tQ\u008bü¯jÂ\u001b\u0019¹\u0019Ñ=\u0003P\u00adtA\u008bû¯,Â\u0005\u0019¸=EPüt+\u008b\u001d® ÂT\u0019Æ=`P\u0002w²\u008bO®\u008aÂi\u0019\u0006<ªPnw\u0096\u008b ®\u0017Å²\u0019/<\u0085P}w\u0010\u008a½®5ÅÃ\u0019c<\u0013S\u0091w<\u008a\u009f®{Å\u001a\u0018\u0089<8SÛwv\u008aå".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                _CREATION = cArr;
                _BOUNDARY = 5066294646274866535L;
            }

            /* JADX WARN: Code duplicated, block: B:104:0x0a95  */
            /* JADX WARN: Code duplicated, block: B:131:0x0ec4  */
            /* JADX WARN: Code duplicated, block: B:153:0x10ac  */
            /* JADX WARN: Code duplicated, block: B:292:0x2b74 A[Catch: all -> 0x024e, TryCatch #4 {all -> 0x024e, blocks: (B:6:0x0125, B:8:0x0132, B:9:0x017a, B:30:0x038e, B:32:0x039b, B:33:0x03e0, B:53:0x05b3, B:55:0x05c0, B:57:0x0601, B:83:0x0867, B:85:0x086d, B:86:0x08b5, B:110:0x0c34, B:112:0x0c41, B:113:0x0c88, B:123:0x0e33, B:125:0x0e40, B:126:0x0e7d, B:157:0x1155, B:159:0x1162, B:160:0x11a2, B:177:0x13f4, B:179:0x1401, B:180:0x1447, B:190:0x153a, B:192:0x1547, B:193:0x1596, B:215:0x17af, B:217:0x17b5, B:218:0x17f9, B:224:0x1921, B:226:0x1932, B:227:0x1973, B:235:0x1ae5, B:237:0x1af2, B:239:0x1b3b, B:241:0x1b44, B:243:0x1b5c, B:244:0x1ba9, B:290:0x2b67, B:292:0x2b74, B:293:0x2bb3, B:316:0x313b, B:318:0x3148, B:319:0x3191, B:350:0x36e7, B:352:0x36f4, B:354:0x3757, B:381:0x3a59, B:383:0x3a66, B:384:0x3aaa, B:326:0x3276, B:328:0x3283, B:329:0x32cb, B:298:0x2bcd, B:300:0x2be2, B:301:0x2c26, B:302:0x2c35, B:304:0x2c4b, B:305:0x2c94, B:253:0x279f, B:255:0x27ac, B:257:0x2803, B:264:0x281f, B:266:0x282c, B:267:0x287b, B:62:0x06c6, B:64:0x06d3, B:65:0x0716, B:71:0x075f, B:73:0x076c, B:74:0x07b6, B:36:0x03f1, B:38:0x03fe, B:39:0x043f), top: B:409:0x0125 }] */
            /* JADX WARN: Code duplicated, block: B:295:0x2bbc  */
            /* JADX WARN: Code duplicated, block: B:296:0x2bbf  */
            /* JADX WARN: Code duplicated, block: B:298:0x2bcd A[Catch: all -> 0x024e, TRY_ENTER, TryCatch #4 {all -> 0x024e, blocks: (B:6:0x0125, B:8:0x0132, B:9:0x017a, B:30:0x038e, B:32:0x039b, B:33:0x03e0, B:53:0x05b3, B:55:0x05c0, B:57:0x0601, B:83:0x0867, B:85:0x086d, B:86:0x08b5, B:110:0x0c34, B:112:0x0c41, B:113:0x0c88, B:123:0x0e33, B:125:0x0e40, B:126:0x0e7d, B:157:0x1155, B:159:0x1162, B:160:0x11a2, B:177:0x13f4, B:179:0x1401, B:180:0x1447, B:190:0x153a, B:192:0x1547, B:193:0x1596, B:215:0x17af, B:217:0x17b5, B:218:0x17f9, B:224:0x1921, B:226:0x1932, B:227:0x1973, B:235:0x1ae5, B:237:0x1af2, B:239:0x1b3b, B:241:0x1b44, B:243:0x1b5c, B:244:0x1ba9, B:290:0x2b67, B:292:0x2b74, B:293:0x2bb3, B:316:0x313b, B:318:0x3148, B:319:0x3191, B:350:0x36e7, B:352:0x36f4, B:354:0x3757, B:381:0x3a59, B:383:0x3a66, B:384:0x3aaa, B:326:0x3276, B:328:0x3283, B:329:0x32cb, B:298:0x2bcd, B:300:0x2be2, B:301:0x2c26, B:302:0x2c35, B:304:0x2c4b, B:305:0x2c94, B:253:0x279f, B:255:0x27ac, B:257:0x2803, B:264:0x281f, B:266:0x282c, B:267:0x287b, B:62:0x06c6, B:64:0x06d3, B:65:0x0716, B:71:0x075f, B:73:0x076c, B:74:0x07b6, B:36:0x03f1, B:38:0x03fe, B:39:0x043f), top: B:409:0x0125 }] */
            /* JADX WARN: Code duplicated, block: B:300:0x2be2 A[Catch: all -> 0x024e, TryCatch #4 {all -> 0x024e, blocks: (B:6:0x0125, B:8:0x0132, B:9:0x017a, B:30:0x038e, B:32:0x039b, B:33:0x03e0, B:53:0x05b3, B:55:0x05c0, B:57:0x0601, B:83:0x0867, B:85:0x086d, B:86:0x08b5, B:110:0x0c34, B:112:0x0c41, B:113:0x0c88, B:123:0x0e33, B:125:0x0e40, B:126:0x0e7d, B:157:0x1155, B:159:0x1162, B:160:0x11a2, B:177:0x13f4, B:179:0x1401, B:180:0x1447, B:190:0x153a, B:192:0x1547, B:193:0x1596, B:215:0x17af, B:217:0x17b5, B:218:0x17f9, B:224:0x1921, B:226:0x1932, B:227:0x1973, B:235:0x1ae5, B:237:0x1af2, B:239:0x1b3b, B:241:0x1b44, B:243:0x1b5c, B:244:0x1ba9, B:290:0x2b67, B:292:0x2b74, B:293:0x2bb3, B:316:0x313b, B:318:0x3148, B:319:0x3191, B:350:0x36e7, B:352:0x36f4, B:354:0x3757, B:381:0x3a59, B:383:0x3a66, B:384:0x3aaa, B:326:0x3276, B:328:0x3283, B:329:0x32cb, B:298:0x2bcd, B:300:0x2be2, B:301:0x2c26, B:302:0x2c35, B:304:0x2c4b, B:305:0x2c94, B:253:0x279f, B:255:0x27ac, B:257:0x2803, B:264:0x281f, B:266:0x282c, B:267:0x287b, B:62:0x06c6, B:64:0x06d3, B:65:0x0716, B:71:0x075f, B:73:0x076c, B:74:0x07b6, B:36:0x03f1, B:38:0x03fe, B:39:0x043f), top: B:409:0x0125 }] */
            /* JADX WARN: Code duplicated, block: B:302:0x2c35 A[Catch: all -> 0x024e, TryCatch #4 {all -> 0x024e, blocks: (B:6:0x0125, B:8:0x0132, B:9:0x017a, B:30:0x038e, B:32:0x039b, B:33:0x03e0, B:53:0x05b3, B:55:0x05c0, B:57:0x0601, B:83:0x0867, B:85:0x086d, B:86:0x08b5, B:110:0x0c34, B:112:0x0c41, B:113:0x0c88, B:123:0x0e33, B:125:0x0e40, B:126:0x0e7d, B:157:0x1155, B:159:0x1162, B:160:0x11a2, B:177:0x13f4, B:179:0x1401, B:180:0x1447, B:190:0x153a, B:192:0x1547, B:193:0x1596, B:215:0x17af, B:217:0x17b5, B:218:0x17f9, B:224:0x1921, B:226:0x1932, B:227:0x1973, B:235:0x1ae5, B:237:0x1af2, B:239:0x1b3b, B:241:0x1b44, B:243:0x1b5c, B:244:0x1ba9, B:290:0x2b67, B:292:0x2b74, B:293:0x2bb3, B:316:0x313b, B:318:0x3148, B:319:0x3191, B:350:0x36e7, B:352:0x36f4, B:354:0x3757, B:381:0x3a59, B:383:0x3a66, B:384:0x3aaa, B:326:0x3276, B:328:0x3283, B:329:0x32cb, B:298:0x2bcd, B:300:0x2be2, B:301:0x2c26, B:302:0x2c35, B:304:0x2c4b, B:305:0x2c94, B:253:0x279f, B:255:0x27ac, B:257:0x2803, B:264:0x281f, B:266:0x282c, B:267:0x287b, B:62:0x06c6, B:64:0x06d3, B:65:0x0716, B:71:0x075f, B:73:0x076c, B:74:0x07b6, B:36:0x03f1, B:38:0x03fe, B:39:0x043f), top: B:409:0x0125 }] */
            /* JADX WARN: Code duplicated, block: B:304:0x2c4b A[Catch: all -> 0x024e, TryCatch #4 {all -> 0x024e, blocks: (B:6:0x0125, B:8:0x0132, B:9:0x017a, B:30:0x038e, B:32:0x039b, B:33:0x03e0, B:53:0x05b3, B:55:0x05c0, B:57:0x0601, B:83:0x0867, B:85:0x086d, B:86:0x08b5, B:110:0x0c34, B:112:0x0c41, B:113:0x0c88, B:123:0x0e33, B:125:0x0e40, B:126:0x0e7d, B:157:0x1155, B:159:0x1162, B:160:0x11a2, B:177:0x13f4, B:179:0x1401, B:180:0x1447, B:190:0x153a, B:192:0x1547, B:193:0x1596, B:215:0x17af, B:217:0x17b5, B:218:0x17f9, B:224:0x1921, B:226:0x1932, B:227:0x1973, B:235:0x1ae5, B:237:0x1af2, B:239:0x1b3b, B:241:0x1b44, B:243:0x1b5c, B:244:0x1ba9, B:290:0x2b67, B:292:0x2b74, B:293:0x2bb3, B:316:0x313b, B:318:0x3148, B:319:0x3191, B:350:0x36e7, B:352:0x36f4, B:354:0x3757, B:381:0x3a59, B:383:0x3a66, B:384:0x3aaa, B:326:0x3276, B:328:0x3283, B:329:0x32cb, B:298:0x2bcd, B:300:0x2be2, B:301:0x2c26, B:302:0x2c35, B:304:0x2c4b, B:305:0x2c94, B:253:0x279f, B:255:0x27ac, B:257:0x2803, B:264:0x281f, B:266:0x282c, B:267:0x287b, B:62:0x06c6, B:64:0x06d3, B:65:0x0716, B:71:0x075f, B:73:0x076c, B:74:0x07b6, B:36:0x03f1, B:38:0x03fe, B:39:0x043f), top: B:409:0x0125 }] */
            /* JADX WARN: Code duplicated, block: B:344:0x3450  */
            /* JADX WARN: Code duplicated, block: B:347:0x36ca  */
            /* JADX WARN: Code duplicated, block: B:349:0x36da  */
            /* JADX WARN: Code duplicated, block: B:352:0x36f4 A[Catch: all -> 0x024e, TryCatch #4 {all -> 0x024e, blocks: (B:6:0x0125, B:8:0x0132, B:9:0x017a, B:30:0x038e, B:32:0x039b, B:33:0x03e0, B:53:0x05b3, B:55:0x05c0, B:57:0x0601, B:83:0x0867, B:85:0x086d, B:86:0x08b5, B:110:0x0c34, B:112:0x0c41, B:113:0x0c88, B:123:0x0e33, B:125:0x0e40, B:126:0x0e7d, B:157:0x1155, B:159:0x1162, B:160:0x11a2, B:177:0x13f4, B:179:0x1401, B:180:0x1447, B:190:0x153a, B:192:0x1547, B:193:0x1596, B:215:0x17af, B:217:0x17b5, B:218:0x17f9, B:224:0x1921, B:226:0x1932, B:227:0x1973, B:235:0x1ae5, B:237:0x1af2, B:239:0x1b3b, B:241:0x1b44, B:243:0x1b5c, B:244:0x1ba9, B:290:0x2b67, B:292:0x2b74, B:293:0x2bb3, B:316:0x313b, B:318:0x3148, B:319:0x3191, B:350:0x36e7, B:352:0x36f4, B:354:0x3757, B:381:0x3a59, B:383:0x3a66, B:384:0x3aaa, B:326:0x3276, B:328:0x3283, B:329:0x32cb, B:298:0x2bcd, B:300:0x2be2, B:301:0x2c26, B:302:0x2c35, B:304:0x2c4b, B:305:0x2c94, B:253:0x279f, B:255:0x27ac, B:257:0x2803, B:264:0x281f, B:266:0x282c, B:267:0x287b, B:62:0x06c6, B:64:0x06d3, B:65:0x0716, B:71:0x075f, B:73:0x076c, B:74:0x07b6, B:36:0x03f1, B:38:0x03fe, B:39:0x043f), top: B:409:0x0125 }] */
            /* JADX WARN: Code duplicated, block: B:353:0x374f  */
            /* JADX WARN: Code duplicated, block: B:358:0x3819 A[LOOP:6: B:348:0x36d8->B:358:0x3819, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:362:0x3849  */
            /* JADX WARN: Code duplicated, block: B:363:0x38bd  */
            /* JADX WARN: Code duplicated, block: B:370:0x395c A[Catch: IOException -> 0x3973, Exception -> 0x3977, TryCatch #1 {IOException -> 0x3973, blocks: (B:368:0x3920, B:370:0x395c, B:372:0x3963), top: B:404:0x3920 }] */
            /* JADX WARN: Code duplicated, block: B:371:0x3961  */
            /* JADX WARN: Code duplicated, block: B:374:0x396c  */
            /* JADX WARN: Code duplicated, block: B:379:0x3980  */
            /* JADX WARN: Code duplicated, block: B:380:0x39eb  */
            /* JADX WARN: Code duplicated, block: B:383:0x3a66 A[Catch: all -> 0x024e, TryCatch #4 {all -> 0x024e, blocks: (B:6:0x0125, B:8:0x0132, B:9:0x017a, B:30:0x038e, B:32:0x039b, B:33:0x03e0, B:53:0x05b3, B:55:0x05c0, B:57:0x0601, B:83:0x0867, B:85:0x086d, B:86:0x08b5, B:110:0x0c34, B:112:0x0c41, B:113:0x0c88, B:123:0x0e33, B:125:0x0e40, B:126:0x0e7d, B:157:0x1155, B:159:0x1162, B:160:0x11a2, B:177:0x13f4, B:179:0x1401, B:180:0x1447, B:190:0x153a, B:192:0x1547, B:193:0x1596, B:215:0x17af, B:217:0x17b5, B:218:0x17f9, B:224:0x1921, B:226:0x1932, B:227:0x1973, B:235:0x1ae5, B:237:0x1af2, B:239:0x1b3b, B:241:0x1b44, B:243:0x1b5c, B:244:0x1ba9, B:290:0x2b67, B:292:0x2b74, B:293:0x2bb3, B:316:0x313b, B:318:0x3148, B:319:0x3191, B:350:0x36e7, B:352:0x36f4, B:354:0x3757, B:381:0x3a59, B:383:0x3a66, B:384:0x3aaa, B:326:0x3276, B:328:0x3283, B:329:0x32cb, B:298:0x2bcd, B:300:0x2be2, B:301:0x2c26, B:302:0x2c35, B:304:0x2c4b, B:305:0x2c94, B:253:0x279f, B:255:0x27ac, B:257:0x2803, B:264:0x281f, B:266:0x282c, B:267:0x287b, B:62:0x06c6, B:64:0x06d3, B:65:0x0716, B:71:0x075f, B:73:0x076c, B:74:0x07b6, B:36:0x03f1, B:38:0x03fe, B:39:0x043f), top: B:409:0x0125 }] */
            /* JADX WARN: Code duplicated, block: B:387:0x3b73  */
            /* JADX WARN: Code duplicated, block: B:388:0x3be7  */
            /* JADX WARN: Code duplicated, block: B:390:0x3c50  */
            /* JADX WARN: Code duplicated, block: B:391:0x3c54  */
            /* JADX WARN: Code duplicated, block: B:431:0x3808 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:432:0x3843 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:69:0x0727  */
            public static Object[] CoroutineDebuggingKt(Context context, int i, int i2, int i3) throws Throwable {
                String str;
                String str2;
                int i4;
                int i5;
                String str3;
                int i6;
                String str4;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                String str5;
                int i15;
                String str6;
                int i16;
                long j;
                long j2;
                String str7;
                int i17;
                Object[] objArr;
                int i18;
                int i19;
                char c;
                String str8;
                String str9;
                Object objAccessartificialFrame;
                Object objInvoke;
                int i20;
                Object objAccessartificialFrame2;
                long jLongValue;
                int i21;
                int i22;
                Object objAccessartificialFrame3;
                int i23;
                String str10;
                int i24;
                String str11;
                char c2;
                String[][] strArr;
                int i25;
                int i26;
                int i27;
                int i28;
                String str12;
                int i29;
                int i30;
                int i31;
                int i32;
                int i33;
                Object objAccessartificialFrame4;
                int i34;
                Object[] objArr2;
                int i35;
                int i36;
                int[] iArr;
                Object[] objArr3;
                String str13;
                File file;
                Scanner scannerUseDelimiter;
                String next;
                String str14;
                int i37;
                String[] strArr2;
                int length;
                int i38;
                int i39;
                Object objAccessartificialFrame5;
                int i40;
                int i41;
                int i42;
                int i43;
                int i44;
                int i45;
                int i46;
                int i47;
                int i48;
                long jLongValue2;
                int i49;
                int i50 = i;
                int i51 = 2 % 2;
                String str15 = "";
                int i52 = -Process.getGidForName("");
                int i53 = i52 * (-344);
                int i54 = 1;
                int i55 = (i53 ^ 344) + ((i53 & 344) << 1);
                int i56 = ~i52;
                int i57 = ~i56;
                int i58 = ~((i56 & i50) | (i56 ^ i50));
                int i59 = -(-(((i58 & i57) | (i57 ^ i58)) * 345));
                int i60 = (i55 & i59) + (i59 | i55);
                int i61 = ~i52;
                int i62 = ~i50;
                int i63 = ~((i61 ^ i62) | (i61 & i62));
                int i64 = ~i52;
                int i65 = ((i64 & i63) | (i63 ^ i64)) * 345;
                char c3 = (char) ((i60 & i65) + (i65 | i60) + ((~((i61 ^ i50) | (i61 & i50))) * 345));
                int i66 = -ExpandableListView.getPackedPositionType(0L);
                Object[] objArr4 = new Object[1];
                a(c3, (i66 & 717) + (i66 | 717), 7 - Process.getGidForName(""), objArr4);
                int i67 = 0;
                String str16 = (String) objArr4[0];
                int i68 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                int scrollBarSize = ViewConfiguration.getScrollBarSize() >> 8;
                int i69 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int i70 = ((i69 | 27) << 1) - (i69 ^ 27);
                Object[] objArr5 = new Object[1];
                a((char) (((i68 | 59126) << 1) - (i68 ^ 59126)), scrollBarSize, i70, objArr5);
                String str17 = (String) objArr5[0];
                int i71 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i72 = -TextUtils.indexOf("", "", 0, 0);
                int i73 = ((i72 | 27) << 1) - (i72 ^ 27);
                int i74 = -(-TextUtils.indexOf("", "", 0));
                int i75 = (i74 ^ 25) + ((i74 & 25) << 1);
                Object[] objArr6 = new Object[1];
                a((char) ((i71 & 35332) + (i71 | 35332)), i73, i75, objArr6);
                String str18 = (String) objArr6[0];
                int i76 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
                float f = 0.0f;
                int i77 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int i78 = -(-View.MeasureSpec.getMode(0));
                Object[] objArr7 = new Object[1];
                a((char) ((i76 & 61409) + (i76 | 61409)), (i77 ^ 52) + ((i77 & 52) << 1), (i78 ^ 18) + ((i78 & 18) << 1), objArr7);
                String str19 = (String) objArr7[0];
                Object[] objArr8 = new Object[1];
                a((char) TextUtils.getTrimmedLength(""), (ViewConfiguration.getTapTimeout() >> 16) + 70, 27 - (~(-(-Drawable.resolveOpacity(0, 0)))), objArr8);
                String[] strArr3 = {str17, str18, str19, (String) objArr8[0]};
                int i79 = 0;
                while (true) {
                    if (i79 >= 4) {
                        str = str15;
                        str2 = str16;
                        i4 = i62;
                        i5 = i50;
                        break;
                    }
                    try {
                        Object[] objArr9 = {strArr3[i79]};
                        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(479197382);
                        if (objAccessartificialFrame6 == null) {
                            int threadPriority = 17 - ((Process.getThreadPriority(i67) + 20) >> 6);
                            char c4 = (char) (24344 - (AudioTrack.getMaxVolume() > f ? 1 : (AudioTrack.getMaxVolume() == f ? 0 : -1)));
                            int i80 = (ExpandableListView.getPackedPositionForGroup(i67) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i67) == 0L ? 0 : -1)) + 2014;
                            byte[] bArr = $$a;
                            byte b = bArr[18];
                            byte b2 = bArr[10];
                            Object[] objArr10 = new Object[i54];
                            b(b, b2, (byte) (b2 | 38), objArr10);
                            String str20 = (String) objArr10[i67];
                            Class[] clsArr = new Class[i54];
                            clsArr[i67] = String.class;
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(threadPriority, c4, i80, -2081767730, false, str20, clsArr);
                        }
                        long jLongValue3 = ((Long) ((Method) objAccessartificialFrame6).invoke(null, objArr9)).longValue();
                        long j3 = -1454369821;
                        int i81 = i79;
                        str2 = str16;
                        i4 = i62;
                        long j4 = -1;
                        long j5 = jLongValue3 ^ j4;
                        String[] strArr4 = strArr3;
                        str = str15;
                        long jMyPid = Process.myPid();
                        long j6 = (j3 | jMyPid) ^ j4;
                        long j7 = 407;
                        long j8 = j3 ^ j4;
                        long j9 = (j8 | jLongValue3) ^ j4;
                        long j10 = (((long) (-813)) * j3) + (((long) TSLocationManager.LOCATION_ERROR_TIMEOUT) * jLongValue3) + (((long) (-814)) * (((j5 | j3) ^ j4) | j6)) + ((((j5 | (jMyPid ^ j4)) ^ j4) | j9 | j6) * j7) + (j7 * (((jMyPid | jLongValue3) ^ j4) | j9 | ((j8 | jMyPid) ^ j4))) + ((long) 1950981212);
                        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                        int i82 = ((int) (j10 >> 32)) & ((((~((-667957960) | elapsedCpuTime)) | 2105184370) * 56) + 207506274 + (((~((~elapsedCpuTime) | 2105184370)) | (-667957960)) * 56));
                        int i83 = ((int) j10) & (2133712425 + (((~((-979216216) | i50)) | 458010194) * (-668)) + (((-979216216) | (~(458010194 | i50))) * 1336) + (((-537985286) | i50) * 668));
                        if (((i82 & i83) | (i82 ^ i83)) != 0) {
                            int i84 = (i81 ^ FacebookRequestErrorClassification.EC_INVALID_TOKEN) + ((i81 & FacebookRequestErrorClassification.EC_INVALID_TOKEN) << 1);
                            i5 = (~(i50 & i84)) & (i84 | i50);
                            break;
                        }
                        int i85 = i81 - 1;
                        i79 = ((i85 | 2) << 1) - (i85 ^ 2);
                        str15 = str;
                        i62 = i4;
                        str16 = str2;
                        strArr3 = strArr4;
                        i67 = 0;
                        i54 = 1;
                        f = 0.0f;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
                int i86 = 3;
                if (i5 != i50) {
                    Object[] objArr11 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i50}, new int[]{i5}};
                    int i87 = (((-240511799) + (((~((-30563199) | i50)) | 4196618) * 576)) + (((~((~i50) | (-26366581))) | 570688641) * 576)) - 1877715328;
                    int i88 = -(-(((i87 | 16) << 1) - (i87 ^ 16)));
                    int i89 = (i3 & i88) + (i3 | i88);
                    int i90 = i89 << 13;
                    int i91 = (i90 & (~i89)) | ((~i90) & i89);
                    int i92 = i91 >>> 17;
                    int i93 = ((~i91) & i92) | ((~i92) & i91);
                    int i94 = i93 << 5;
                    return objArr11;
                }
                String[] strArr5 = new String[3];
                char c5 = (char) (63379 - (~(Process.myTid() >> 22)));
                int i95 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                int i96 = (i95 ^ 99) + ((i95 & 99) << 1);
                int i97 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i98 = (i97 ^ 105) + ((i97 & 105) << 1);
                artificialFrame = i98 % 128;
                if (i98 % 2 == 0) {
                    Object[] objArr12 = new Object[1];
                    a(c5, i96, 11 % (AudioTrack.getMaxVolume() > 2.0f ? 1 : (AudioTrack.getMaxVolume() == 2.0f ? 0 : -1)), objArr12);
                    strArr5[0] = (String) objArr12[0];
                } else {
                    int i99 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    Object[] objArr13 = new Object[1];
                    a(c5, i96, (i99 ^ 11) + ((11 & i99) << 1), objArr13);
                    strArr5[0] = (String) objArr13[0];
                }
                int trimmedLength = TextUtils.getTrimmedLength(str);
                Object[] objArr14 = new Object[1];
                a((char) ((50413 & trimmedLength) + (trimmedLength | 50413)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 14, objArr14);
                strArr5[1] = (String) objArr14[0];
                int i100 = -(-Process.getGidForName(str));
                Object[] objArr15 = new Object[1];
                a((char) (((i100 | 1) << 1) - (i100 ^ 1)), 122 - (~(-(ViewConfiguration.getLongPressTimeout() >> 16))), 17 - (~(-Gravity.getAbsoluteGravity(0, 0))), objArr15);
                int i101 = 2;
                strArr5[2] = (String) objArr15[0];
                int i102 = 0;
                while (true) {
                    if (i102 >= i86) {
                        str3 = str;
                        i6 = i50;
                        break;
                    }
                    int i103 = artificialFrame + 51;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i103 % 128;
                    if (i103 % i101 != 0) {
                        Object[] objArr16 = {strArr5[i102]};
                        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(267846469);
                        if (objAccessartificialFrame7 == null) {
                            int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 17;
                            char doubleTapTimeout = (char) (24343 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                            int iIndexOf = TextUtils.indexOf((CharSequence) str, '0') + 2015;
                            byte[] bArr2 = $$a;
                            byte b3 = (byte) (-bArr2[7]);
                            byte b4 = bArr2[10];
                            Object[] objArr17 = new Object[1];
                            b(b3, b4, (byte) (b4 | 38), objArr17);
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(threadPriority2, doubleTapTimeout, iIndexOf, -1869462195, false, (String) objArr17[0], new Class[]{String.class});
                        }
                        jLongValue2 = ((Long) ((Method) objAccessartificialFrame7).invoke(null, objArr16)).longValue();
                        i49 = 1;
                    } else {
                        Object[] objArr18 = {strArr5[i102]};
                        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(267846469);
                        if (objAccessartificialFrame8 == null) {
                            int deadChar = 17 - KeyEvent.getDeadChar(0, 0);
                            char c6 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24342);
                            int iGreen = Color.green(0) + 2014;
                            byte[] bArr3 = $$a;
                            byte b5 = (byte) (-bArr3[7]);
                            byte b6 = bArr3[10];
                            Object[] objArr19 = new Object[1];
                            b(b5, b6, (byte) (b6 | 38), objArr19);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(deadChar, c6, iGreen, -1869462195, false, (String) objArr19[0], new Class[]{String.class});
                        }
                        jLongValue2 = ((Long) ((Method) objAccessartificialFrame8).invoke(null, objArr18)).longValue();
                        i49 = 0;
                    }
                    long j11 = -308884896;
                    long j12 = 399;
                    long j13 = (j12 * j11) + (j12 * jLongValue2);
                    long j14 = 398;
                    String[] strArr6 = strArr5;
                    int i104 = i49;
                    long j15 = -1;
                    long j16 = ((j11 ^ j15) | jLongValue2) ^ j15;
                    long j17 = jLongValue2 ^ j15;
                    long j18 = (j17 | j11) ^ j15;
                    str3 = str;
                    long elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                    long j19 = j13 + ((j16 | j18 | ((j17 | elapsedCpuTime2) ^ j15)) * j14) + (((long) (-1194)) * (jLongValue2 | j11)) + (j14 * ((j15 ^ (j17 | (elapsedCpuTime2 ^ j15))) | j16 | j18)) + ((long) (-1002747080));
                    int iMyUid = Process.myUid();
                    int i105 = ((int) (j19 >> 32)) & (1587634074 + (((~((-2057771926) | iMyUid)) | 715524757 | (~((-799968960) | iMyUid))) * (-744)) + (((~iMyUid) | (-2142216128)) * 744) + ((iMyUid | (-715524758)) * 744));
                    int i106 = (int) j19;
                    int i107 = ((((~(1915910699 | i50)) | (-2126151340)) * (-283)) - 1842634191) + ((~((-210240641) | i50)) * 283);
                    int i108 = artificialFrame + 49;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i108 % 128;
                    if (i108 % 2 != 0) {
                        throw null;
                    }
                    int i109 = i105 | (i106 & i107);
                    if (((i109 | i104) & (~(i109 & i104))) != 0) {
                        int i110 = i102 + RotationOptions.ROTATE_270;
                        i6 = ((~i110) & i50) | ((~i50) & i110);
                        break;
                    }
                    int i111 = i102 - 52;
                    i102 = (i111 & 53) + (i111 | 53);
                    strArr5 = strArr6;
                    str = str3;
                    i86 = 3;
                    i101 = 2;
                }
                if (i6 != i50) {
                    Object[] objArr20 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i50}, new int[]{i6}};
                    int i112 = 1844275351 + (((-746499867) | i50) * 614);
                    int i113 = ~i50;
                    int i114 = i3 + i112 + (((~((-961268756) | i113)) | 285294593 | (~((-355820298) | i113))) * (-1228)) + (((~(i113 | (-70525705))) | (~((-675974163) | i113))) * 614) + 16;
                    int i115 = i114 << 13;
                    int i116 = (i114 | i115) & (~(i114 & i115));
                    int i117 = i116 >>> 17;
                    int i118 = ((~i116) & i117) | ((~i117) & i116);
                    int i119 = i118 << 5;
                    return objArr20;
                }
                char c7 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15826);
                int i120 = -(-ExpandableListView.getPackedPositionChild(0L));
                int i121 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                int i122 = (i121 ^ 15) + ((i121 & 15) << 1);
                Object[] objArr21 = new Object[1];
                a(c7, ((i120 | 142) << 1) - (i120 ^ 142), i122, objArr21);
                Object[] objArr22 = {(String) objArr21[0]};
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-11453480);
                if (objAccessartificialFrame9 == null) {
                    str4 = str3;
                    int iIndexOf2 = 16 - TextUtils.indexOf((CharSequence) str4, '0', 0, 0);
                    char maxKeyCode = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 24343);
                    int iIndexOf3 = TextUtils.indexOf(str4, str4) + 2014;
                    byte b7 = $$a[10];
                    byte b8 = b7;
                    Object[] objArr23 = new Object[1];
                    b(b7, b8, (byte) (b8 | 37), objArr23);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf2, maxKeyCode, iIndexOf3, 1614052816, false, (String) objArr23[0], new Class[]{String.class});
                } else {
                    str4 = str3;
                }
                long jLongValue4 = ((Long) ((Method) objAccessartificialFrame9).invoke(null, objArr22)).longValue();
                long j20 = 1406072176;
                long j21 = (((long) 491) * j20) + (((long) (-489)) * jLongValue4);
                long j22 = -1;
                long j23 = j20 ^ j22;
                long j24 = jLongValue4 ^ j22;
                long j25 = j23 | j24;
                long j26 = i50;
                long j27 = j26 ^ j22;
                long j28 = 490;
                long j29 = j21 + (((long) (-490)) * (j25 | j27)) + ((((j24 | j26) ^ j22) | ((j20 | j24) ^ j22)) * j28) + (j28 * j23) + ((long) 156058861);
                int i123 = (int) Runtime.getRuntime().totalMemory();
                int i124 = ~i123;
                int i125 = ((int) (j29 >> 32)) & ((-1591713398) + ((223003397 | i124) * (-757)) + ((~((-1075122337) | i123)) * 1514) + (((~(i123 | 1298125733)) | (~(i124 | (-1214223014))) | 139100677) * 757));
                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                if ((i125 | (((int) j29) & (436533637 + (((~(521419351 | iUptimeMillis)) | 1958645761) * (-668)) + ((521419351 | (~(1958645761 | iUptimeMillis))) * 1336) + ((iUptimeMillis | 2143205975) * 668)))) != 0) {
                    i7 = (i50 & (-267)) | ((~i50) & 266);
                } else {
                    Object[] objArr24 = new Object[1];
                    a((char) TextUtils.indexOf(str4, str4), (ViewConfiguration.getEdgeSlop() >> 16) + 155, 23 - (~Color.alpha(0)), objArr24);
                    Object[] objArr25 = {(String) objArr24[0]};
                    Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame10 == null) {
                        int iNormalizeMetaState = 23 - KeyEvent.normalizeMetaState(0);
                        char cMyPid = (char) (Process.myPid() >> 22);
                        int trimmedLength2 = TextUtils.getTrimmedLength(str4) + 2441;
                        byte[] bArr4 = $$a;
                        Object[] objArr26 = new Object[1];
                        b(bArr4[4], bArr4[18], bArr4[10], objArr26);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cMyPid, trimmedLength2, 954751276, false, (String) objArr26[0], new Class[]{String.class});
                    }
                    String str21 = (String) ((Method) objAccessartificialFrame10).invoke(null, objArr25);
                    if (str21 == null || str21.length() == 0) {
                        int i126 = -TextUtils.indexOf(str4, str4);
                        int i127 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        Object[] objArr27 = new Object[1];
                        a((char) (((i126 | 53947) << 1) - (i126 ^ 53947)), (i127 ^ 178) + ((i127 & 178) << 1), 22 - (~(-TextUtils.indexOf((CharSequence) str4, '0', 0))), objArr27);
                        Object[] objArr28 = {(String) objArr27[0]};
                        Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame11 == null) {
                            int iRgb = (-16777193) - Color.rgb(0, 0, 0);
                            char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
                            int i128 = 2442 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            byte[] bArr5 = $$a;
                            Object[] objArr29 = new Object[1];
                            b(bArr5[4], bArr5[18], bArr5[10], objArr29);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iRgb, touchSlop, i128, 954751276, false, (String) objArr29[0], new Class[]{String.class});
                        }
                        String str22 = (String) ((Method) objAccessartificialFrame11).invoke(null, objArr28);
                        if (str22 != null) {
                            int i129 = artificialFrame + 27;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i129 % 128;
                            int i130 = i129 % 2;
                            if (str22.length() != 0) {
                                i7 = (~(i50 & 267)) & (i50 | 267);
                            }
                        }
                        i7 = i50;
                    } else {
                        i7 = (~(i50 & 267)) & (i50 | 267);
                    }
                }
                if (i7 != i50) {
                    Object[] objArr30 = {null, new int[1], null, new int[]{i50}, new int[]{i7}};
                    int iMyPid = Process.myPid();
                    int i131 = ~iMyPid;
                    int i132 = 902788353 + (((~((-7295867) | i131)) | 2560266 | (~((-598152592) | i131))) * (-1136)) + (((~((-7295867) | iMyPid)) | (~((-598152592) | iMyPid)) | (~(602888191 | i131))) * (-568)) + (((~(iMyPid | (-2560267))) | (~(i131 | 598152591)) | (~(7295866 | i131))) * 568);
                    int i133 = -(-((i132 & 16) + (i132 | 16)));
                    int i134 = ((i3 | i133) << 1) - (i3 ^ i133);
                    int i135 = i134 << 13;
                    int i136 = (i135 | i134) & (~(i134 & i135));
                    int i137 = i136 >>> 17;
                    int i138 = ((~i136) & i137) | ((~i137) & i136);
                    int i139 = i138 << 5;
                    ((int[]) objArr30[1])[0] = (i138 | i139) & (~(i138 & i139));
                    return objArr30;
                }
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(943212816);
                if (objAccessartificialFrame12 == null) {
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 7;
                    char c8 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int capsMode = 1768 - TextUtils.getCapsMode(str4, 0, 0);
                    byte[] bArr6 = $$a;
                    Object[] objArr31 = new Object[1];
                    b(bArr6[19], bArr6[4], bArr6[24], objArr31);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, c8, capsMode, -1487073512, false, (String) objArr31[0], new Class[0]);
                }
                long jLongValue5 = ((Long) ((Method) objAccessartificialFrame12).invoke(null, null)).longValue();
                long j30 = -438833280;
                long j31 = jLongValue5 ^ j22;
                String str23 = str4;
                long jMyTid = Process.myTid();
                long j32 = jMyTid ^ j22;
                long j33 = (j32 | jLongValue5) ^ j22;
                long j34 = (((long) (-515)) * j30) + (((long) 517) * jLongValue5) + (((long) (-516)) * (((j31 | jMyTid) ^ j22) | ((j32 | j30) ^ j22) | j33));
                long j35 = 516;
                long j36 = j30 ^ j22;
                long j37 = j34 + ((((jMyTid | (j31 | j36)) ^ j22) | (((j36 | j32) | jLongValue5) ^ j22)) * j35) + (j35 * (((jLongValue5 | j36) ^ j22) | j33)) + ((long) 1814725030);
                int iMyPid2 = Process.myPid();
                int i140 = ((int) (j37 >> 32)) & (((1873712332 + ((2054938623 | iMyPid2) * (-381))) + (((~((~iMyPid2) | 2015567226)) | 1515969205) * 381)) - 1247567872);
                int elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
                int i141 = i140 | (((int) j37) & ((-284373515) + (((~(1468743456 | elapsedCpuTime3)) | (-31517047)) * (-964)) + (((~((~elapsedCpuTime3) | 1468743456)) | (-1475084151)) * (-964))));
                if (i141 != 0) {
                    int i142 = -(-(i141 - 1));
                    int i143 = (i142 ^ 200) + ((i142 & 200) << 1);
                    i8 = ((~i143) & i50) | (i143 & (~i50));
                } else {
                    i8 = i50;
                }
                if (i8 != i50) {
                    Object[] objArr32 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i50}, new int[]{i8}};
                    int i144 = ~i50;
                    int i145 = (-1428491755) + (((~(536083711 | i144)) | 69364746) * 220) + (((~(i144 | 531856474)) | 73591983) * (-440)) + ((i50 | 536083711) * 220);
                    int i146 = (i3 - (~(-(-((i145 & 16) + (i145 | 16)))))) - 1;
                    int i147 = i146 ^ (i146 << 13);
                    int i148 = i147 >>> 17;
                    int i149 = (i147 | i148) & (~(i147 & i148));
                    int i150 = i149 << 5;
                    return objArr32;
                }
                char trimmedLength3 = (char) (TextUtils.getTrimmedLength(str23) + 7593);
                int i151 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                int i152 = ((i151 | 204) << 1) - (i151 ^ 204);
                int iLastIndexOf = TextUtils.lastIndexOf(str23, '0', 0);
                int i153 = (iLastIndexOf ^ 21) + ((iLastIndexOf & 21) << 1);
                Object[] objArr33 = new Object[1];
                a(trimmedLength3, i152, i153, objArr33);
                String str24 = (String) objArr33[0];
                char c9 = (char) (10920 - (~(-(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))))));
                int i154 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                int i155 = (i154 ^ 223) + ((i154 & 223) << 1);
                int i156 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                int i157 = (i156 ^ 5) + ((i156 & 5) << 1);
                Object[] objArr34 = new Object[1];
                a(c9, i155, i157, objArr34);
                String str25 = (String) objArr34[0];
                File file2 = new File(str24);
                if (file2.exists() && file2.isFile()) {
                    try {
                        Scanner scanner = new Scanner(new FileInputStream(file2));
                        char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int i158 = -View.resolveSize(0, 0);
                        Object[] objArr35 = new Object[1];
                        a(longPressTimeout, (i158 ^ 229) + ((i158 & 229) << 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1, objArr35);
                        Scanner scannerUseDelimiter2 = scanner.useDelimiter((String) objArr35[0]);
                        String next2 = scannerUseDelimiter2.hasNext() ? scannerUseDelimiter2.next() : str23;
                        scannerUseDelimiter2.close();
                        if (next2.contains(str25)) {
                            i9 = (i50 & (-263)) | ((~i50) & 262);
                        } else {
                            i9 = i50;
                        }
                    } catch (IOException unused) {
                    }
                } else {
                    i9 = i50;
                }
                if (i9 != i50) {
                    Object[] objArr36 = {null, new int[1], null, new int[]{i50}, new int[]{i9}};
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i159 = (~((-218449627) | iElapsedRealtime)) | 83952138;
                    int i160 = ~iElapsedRealtime;
                    int i161 = (-1100230687) + ((i159 | (~(521496319 | i160))) * 886) + (((~(i160 | 218449626)) | 386998831) * (-1772)) + ((~(i160 | 386998831)) * 886);
                    int i162 = (i161 ^ 16) + ((i161 & 16) << 1);
                    int i163 = ((i3 | i162) << 1) - (i3 ^ i162);
                    int i164 = i163 << 13;
                    int i165 = (i164 & (~i163)) | ((~i164) & i163);
                    int i166 = i165 >>> 17;
                    int i167 = (i165 | i166) & (~(i165 & i166));
                    int i168 = artificialFrame + 117;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i168 % 128;
                    int i169 = i168 % 2;
                    ((int[]) objArr36[1])[0] = i167 ^ (i167 << 5);
                    return objArr36;
                }
                char edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 981);
                int iMyPid3 = (Process.myPid() >> 22) + 231;
                int i170 = -TextUtils.getTrimmedLength(str23);
                int iArtificialStackFrames = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                int i171 = ~i170;
                int i172 = (i171 ^ (-32)) | (i171 & (-32));
                int i173 = ~((i172 & iArtificialStackFrames) | (i172 ^ iArtificialStackFrames));
                int i174 = (i170 ^ 31) | (i170 & 31);
                int i175 = ~((i174 & iArtificialStackFrames) | (i174 ^ iArtificialStackFrames));
                int i176 = ((i170 * 70) - 2108) + (((i173 & i175) | (i173 ^ i175)) * 69);
                int i177 = ~(i171 | 31);
                int i178 = ~i170;
                int i179 = ~((i178 & iArtificialStackFrames) | (i178 ^ iArtificialStackFrames));
                int i180 = (i177 & i179) | (i177 ^ i179);
                int i181 = ~((iArtificialStackFrames & 31) | (iArtificialStackFrames ^ 31));
                Object[] objArr37 = new Object[1];
                a(edgeSlop, iMyPid3, i176 + (((i181 & i180) | (i180 ^ i181)) * (-69)) + ((~((i170 & (-32)) | ((-32) ^ i170))) * 69), objArr37);
                int i182 = -Process.getGidForName(str23);
                int i183 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                int i184 = (i183 & 263) + (i183 | 263);
                int i185 = artificialFrame;
                int i186 = (i185 ^ 67) + ((i185 & 67) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i186 % 128;
                int i187 = i186 % 2;
                int iIndexOf4 = TextUtils.indexOf((CharSequence) str23, '0', 0, 0);
                Object[] objArr38 = new Object[1];
                a((char) ((i182 & 2042) + (i182 | 2042)), i184, (iIndexOf4 & 24) + (iIndexOf4 | 24), objArr38);
                char c10 = (char) (39891 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int i188 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                int i189 = ((i188 | 284) << 1) - (i188 ^ 284);
                int i190 = -((byte) KeyEvent.getModifierMetaStateMask());
                int i191 = (i190 ^ 27) + ((i190 & 27) << 1);
                Object[] objArr39 = new Object[1];
                a(c10, i189, i191, objArr39);
                int i192 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                int i193 = 312 - (~(-(Process.myTid() >> 22)));
                int i194 = -ImageFormat.getBitsPerPixel(0);
                int i195 = ((i194 | 13) << 1) - (i194 ^ 13);
                Object[] objArr40 = new Object[1];
                a((char) ((i192 ^ 1) + ((i192 & 1) << 1)), i193, i195, objArr40);
                String[] strArr7 = {(String) objArr37[0], (String) objArr38[0], (String) objArr39[0], (String) objArr40[0]};
                int i196 = 0;
                int i197 = 4;
                while (true) {
                    if (i196 >= i197) {
                        i10 = i50;
                        break;
                    }
                    Object[] objArr41 = {strArr7[i196]};
                    Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(479197382);
                    if (objAccessartificialFrame13 == null) {
                        int iMyPid4 = 17 - (Process.myPid() >> 22);
                        char cRed = (char) (24343 - Color.red(0));
                        int iMyTid = 2014 - (Process.myTid() >> 22);
                        byte[] bArr7 = $$a;
                        byte b9 = bArr7[18];
                        byte b10 = bArr7[10];
                        Object[] objArr42 = new Object[1];
                        b(b9, b10, (byte) (b10 | 38), objArr42);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iMyPid4, cRed, iMyTid, -2081767730, false, (String) objArr42[0], new Class[]{String.class});
                    }
                    long jLongValue6 = ((Long) ((Method) objAccessartificialFrame13).invoke(null, objArr41)).longValue();
                    long j38 = -1598731336;
                    long j39 = 46;
                    long j40 = jLongValue6 ^ j22;
                    long jNextInt = new Random().nextInt();
                    long j41 = jNextInt ^ j22;
                    int i198 = i196;
                    long j42 = (j39 * j38) + (j39 * jLongValue6) + (((long) (-90)) * (j38 | ((j40 | j41) ^ j22))) + (((long) (-45)) * (((j40 | jNextInt) ^ j22) | ((jLongValue6 | j38) ^ j22))) + (((long) 45) * (j40 | (((j38 ^ j22) | jNextInt) ^ j22) | ((j38 | j41) ^ j22))) + ((long) 2095342727);
                    int i199 = ~((~((int) Runtime.getRuntime().freeMemory())) | (-652518827));
                    int i200 = ((int) (j42 >> 32)) & ((((-2129592320) | i199) * (-374)) + 1163943292 + ((i199 | 1477073493) * 374));
                    int iNextInt = new Random().nextInt();
                    int i201 = ~iNextInt;
                    int i202 = ((int) j42) & (424366113 + (((~(2144591869 | i201)) | 713149016) * 220) + (((~(i201 | 1854136280)) | 1003604605) * (-440)) + ((iNextInt | 2144591869) * 220));
                    if (((i202 & i200) | (i200 ^ i202)) != 0) {
                        int i203 = (i198 & 252) + (i198 | 252);
                        i10 = i;
                        i50 = ((~i203) & i10) | (i203 & (~i10));
                        break;
                    }
                    i196 = ((i198 | 1) << 1) - (i198 ^ 1);
                    i50 = i;
                    i197 = 4;
                }
                if (i50 != i10) {
                    objArr3 = new Object[]{null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i10}, new int[]{i50}};
                    int i204 = 1558326695 + (((~i10) | (-334055666)) * 1444) + (((~(167170172 | i10)) | (-469752062) | (~(i10 | 438278285))) * (-1444)) + 670021554;
                    int i205 = (i204 ^ 16) + ((i204 & 16) << 1);
                    int i206 = ((i3 | i205) << 1) - (i3 ^ i205);
                    int i207 = (i206 << 13) ^ i206;
                    int i208 = i207 ^ (i207 >>> 17);
                    int i209 = i208 << 5;
                } else {
                    char cResolveSize = (char) View.resolveSize(0, 0);
                    int i210 = 327 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    int iIndexOf5 = TextUtils.indexOf(str23, str23, 0, 0);
                    int iArtificialStackFrames2 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                    int i211 = (iIndexOf5 * 273) - 3523;
                    int i212 = ~iIndexOf5;
                    int i213 = i212 | (-14);
                    int i214 = ~iArtificialStackFrames2;
                    int i215 = ~((i213 & i214) | (i213 ^ i214));
                    int i216 = (iIndexOf5 ^ 13) | (iIndexOf5 & 13);
                    int i217 = ~((i216 & iArtificialStackFrames2) | (i216 ^ iArtificialStackFrames2));
                    int i218 = -(-(((i215 & i217) | (i215 ^ i217)) * (-272)));
                    int i219 = ((i211 | i218) << 1) - (i211 ^ i218);
                    int i220 = -(-(((~((i212 ^ 13) | (i212 & 13))) | (~((i212 & iArtificialStackFrames2) | (i212 ^ iArtificialStackFrames2)))) * (-272)));
                    int i221 = ~((iArtificialStackFrames2 & iIndexOf5) | (iIndexOf5 ^ iArtificialStackFrames2));
                    Object[] objArr43 = new Object[1];
                    a(cResolveSize, i210, (((i219 ^ i220) + ((i220 & i219) << 1)) - (~(((i221 & 13) | (i221 ^ 13)) * 272))) - 1, objArr43);
                    Object[] objArr44 = {(String) objArr43[0]};
                    Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame14 == null) {
                        int iGreen2 = 23 - Color.green(0);
                        char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                        int iLastIndexOf2 = TextUtils.lastIndexOf(str23, '0', 0, 0) + 2442;
                        byte[] bArr8 = $$a;
                        Object[] objArr45 = new Object[1];
                        b(bArr8[4], bArr8[18], bArr8[10], objArr45);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iGreen2, pressedStateDuration, iLastIndexOf2, 954751276, false, (String) objArr45[0], new Class[]{String.class});
                    }
                    String str26 = (String) ((Method) objAccessartificialFrame14).invoke(null, objArr44);
                    if (str26 != null) {
                        char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                        int i222 = -(-TextUtils.lastIndexOf(str23, '0', 0, 0));
                        int i223 = ((i222 | FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS) << 1) - (i222 ^ FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
                        int i224 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        int i225 = (i224 & 10) + (i224 | 10);
                        Object[] objArr46 = new Object[1];
                        a(edgeSlop2, i223, i225, objArr46);
                        if (str26.contains((String) objArr46[0])) {
                            i11 = (~(i10 & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)) & (i10 | ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                        } else {
                            i11 = i10;
                        }
                    } else {
                        i11 = i10;
                    }
                    if (i11 != i10) {
                        objArr3 = new Object[]{null, new int[1], null, new int[]{i10}, new int[]{i11}};
                        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                        int i226 = ~iMaxMemory;
                        int i227 = -(-(849430404 + ((iMaxMemory | 275366453) * (-859)) + (((~(iMaxMemory | (-271090197))) | (~(275366453 | i226))) * 859) + (((~((-330082005) | i226)) | 58991808) * 859) + 16));
                        int i228 = (i3 & i227) + (i3 | i227);
                        int i229 = i228 << 13;
                        int i230 = (i229 & (~i228)) | ((~i229) & i228);
                        int i231 = i230 >>> 17;
                        int i232 = ((~i230) & i231) | ((~i231) & i230);
                        int i233 = i232 << 5;
                        ((int[]) objArr3[1])[0] = (i232 | i233) & (~(i232 & i233));
                    } else {
                        char c11 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        int iRgb2 = Color.rgb(0, 0, 0);
                        int i234 = ((iRgb2 | 16777565) << 1) - (iRgb2 ^ 16777565);
                        int i235 = -(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        int i236 = (i235 ^ 17) + ((i235 & 17) << 1);
                        Object[] objArr47 = new Object[1];
                        a(c11, i234, i236, objArr47);
                        String str27 = (String) objArr47[0];
                        char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        int i237 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                        artificialFrame = i237 % 128;
                        int i238 = i237 % 2;
                        int i239 = -(-(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int absoluteGravity = Gravity.getAbsoluteGravity(0, 0);
                        Object[] objArr48 = new Object[1];
                        a(keyRepeatTimeout, (365 & i239) + (i239 | 365), (absoluteGravity & 6) + (absoluteGravity | 6), objArr48);
                        String str28 = (String) objArr48[0];
                        File file3 = new File(str27);
                        if (file3.exists() && file3.isFile()) {
                            try {
                                Scanner scanner2 = new Scanner(new FileInputStream(file3));
                                char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) str23, '0', 0, 0));
                                int i240 = -(-TextUtils.indexOf((CharSequence) str23, '0'));
                                Object[] objArr49 = new Object[1];
                                a(cIndexOf, (i240 ^ 230) + ((i240 & 230) << 1), 2 - (Process.myTid() >> 22), objArr49);
                                Scanner scannerUseDelimiter3 = scanner2.useDelimiter((String) objArr49[0]);
                                String next3 = scannerUseDelimiter3.hasNext() ? scannerUseDelimiter3.next() : str23;
                                scannerUseDelimiter3.close();
                                if (!(!next3.contains(str28))) {
                                    int iArtificialStackFrames3 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                    int i241 = ~iArtificialStackFrames3;
                                    int i242 = ~(1996381951 | i241);
                                    int i243 = (i242 & 33821425) | (i242 ^ 33821425);
                                    int i244 = ~(((-649338624) ^ iArtificialStackFrames3) | ((-649338624) & iArtificialStackFrames3));
                                    int i245 = (i241 & 1380864753) | (1380864753 ^ i241);
                                    int i246 = (((-234372666) + (((i243 & i244) | (i243 ^ i244)) * (-68))) - (~((~((i245 & (-649338624)) | (i245 ^ (-649338624)))) * (-68)))) - 1;
                                    int i247 = ~iArtificialStackFrames3;
                                    int i248 = ~((i247 & 649338623) | (649338623 ^ i247));
                                    int i249 = -(-(((i248 & 1380864753) | (1380864753 ^ i248)) * 68));
                                    int i250 = (i246 ^ i249) + ((i249 & i246) << 1);
                                    int i251 = ((~(2078512642 | i10)) | (-1724769755)) * 672;
                                    int i252 = (58077991 ^ i251) + ((i251 & 58077991) << 1);
                                    int i253 = ~i10;
                                    int i254 = -(-(((~(((-1724769755) & i10) | ((-1724769755) ^ i10))) | (~(((-2078512643) & i253) | ((-2078512643) ^ i253)))) * (-672)));
                                    int i255 = (i252 ^ i254) + ((i254 & i252) << 1);
                                    int i256 = ~(i253 | 1724769754);
                                    if (i250 > (i255 - (~(-(-(((i256 & (-2146432987)) | (i256 ^ (-2146432987))) * 672))))) - 1) {
                                        i12 = i10;
                                    } else {
                                        int i257 = artificialFrame + 43;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i257 % 128;
                                        if (i257 % 2 != 0) {
                                            i47 = ~(i10 & 6899);
                                            i48 = i10 | 6899;
                                        } else {
                                            i47 = ~(i10 & 251);
                                            i48 = i10 | 251;
                                        }
                                        i12 = i47 & i48;
                                    }
                                } else {
                                    i12 = i10;
                                }
                            } catch (IOException unused2) {
                            }
                        } else {
                            i12 = i10;
                        }
                        if (i12 != i10) {
                            int i258 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                            artificialFrame = i258 % 128;
                            int i259 = i258 % 2;
                            objArr3 = new Object[]{null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i10}, new int[]{i12}};
                            int i260 = 824145913 + (((~((-676980725) | i10)) | 672694548 | (~(71532266 | i10))) * (-880));
                            int i261 = (~((-676980725) | (~i10))) | (-71532267);
                            int i262 = ~(676980724 | i10);
                            int i263 = i260 + ((i261 | i262) * (-880)) + (i262 * 880);
                            int i264 = (i263 & 16) + (i263 | 16);
                            int i265 = ((i3 | i264) << 1) - (i3 ^ i264);
                            int i266 = (i265 << 13) ^ i265;
                            int i267 = i266 >>> 17;
                            int i268 = ((~i266) & i267) | ((~i267) & i266);
                            int i269 = i268 << 5;
                        } else {
                            int i270 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                            int i271 = 370 - (~(-Process.getGidForName(str23)));
                            int i272 = -Gravity.getAbsoluteGravity(0, 0);
                            int i273 = (i272 ^ 23) + ((i272 & 23) << 1);
                            Object[] objArr50 = new Object[1];
                            a((char) ((i270 ^ 23373) + ((i270 & 23373) << 1)), i271, i273, objArr50);
                            Object[] objArr51 = {(String) objArr50[0]};
                            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                            if (objAccessartificialFrame15 == null) {
                                int i274 = 24 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                int minimumFlingVelocity = 2441 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                byte[] bArr9 = $$a;
                                Object[] objArr52 = new Object[1];
                                b(bArr9[4], bArr9[18], bArr9[10], objArr52);
                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i274, scrollBarFadeDuration, minimumFlingVelocity, 954751276, false, (String) objArr52[0], new Class[]{String.class});
                            }
                            String lowerCase = ((String) ((Method) objAccessartificialFrame15).invoke(null, objArr51)).toLowerCase();
                            int scrollBarSize2 = ViewConfiguration.getScrollBarSize() >> 8;
                            int i275 = 394 - (~(-(-TextUtils.getTrimmedLength(str23))));
                            int keyRepeatTimeout2 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                            int i276 = (keyRepeatTimeout2 * (-183)) - 732;
                            int i277 = ~keyRepeatTimeout2;
                            int i278 = ~(i277 | i4 | 4);
                            int i279 = ~i10;
                            int i280 = ((-5) & i279) | ((-5) ^ i279);
                            int i281 = (i278 | (~((i280 & keyRepeatTimeout2) | (i280 ^ keyRepeatTimeout2)))) * (-184);
                            int i282 = (i276 ^ i281) + ((i276 & i281) << 1);
                            int i283 = ~keyRepeatTimeout2;
                            int i284 = ~((i283 & (-5)) | (i283 ^ (-5)));
                            int i285 = ~((i277 & i4) | (i277 ^ i4));
                            int i286 = (i284 & i285) | (i284 ^ i285);
                            int i287 = ~(((-5) & i4) | ((-5) ^ i4));
                            int i288 = ((i286 & i287) | (i286 ^ i287)) * SyslogConstants.LOG_LOCAL7;
                            int i289 = ((i282 | i288) << 1) - (i288 ^ i282);
                            int i290 = ((keyRepeatTimeout2 & 4) | (keyRepeatTimeout2 ^ 4)) * SyslogConstants.LOG_LOCAL7;
                            int i291 = (i289 & i290) + (i290 | i289);
                            Object[] objArr53 = new Object[1];
                            a((char) ((scrollBarSize2 & 35925) + (scrollBarSize2 | 35925)), i275, i291, objArr53);
                            if (lowerCase.contains((String) objArr53[0])) {
                                i13 = i10 ^ 264;
                                int i292 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i293 = ((i292 | 91) << 1) - (i292 ^ 91);
                                artificialFrame = i293 % 128;
                                if (i293 % 2 == 0) {
                                    int i294 = 2 / 4;
                                }
                            } else {
                                i13 = i10;
                            }
                            if (i13 != i10) {
                                objArr3 = new Object[]{null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i10}, new int[]{i13}};
                                int i295 = ~((-116855906) | i279);
                                int i296 = (i3 - (~(-(-((((((-805272940) | i295) * (-970)) - 869847571) + ((i295 | 688417034) * 970)) + 16))))) - 1;
                                int i297 = i296 ^ (i296 << 13);
                                int i298 = i297 >>> 17;
                                int i299 = (i297 | i298) & (~(i297 & i298));
                                int i300 = i299 << 5;
                            } else {
                                int i301 = 6;
                                String[] strArr8 = new String[6];
                                char c12 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1);
                                int i302 = -TextUtils.lastIndexOf(str23, '0');
                                Object[] objArr54 = new Object[1];
                                a(c12, (i302 & 398) + (i302 | 398), 41 - (~(-(-(ViewConfiguration.getScrollBarSize() >> 8)))), objArr54);
                                strArr8[0] = (String) objArr54[0];
                                char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                int i303 = 440 - (~(-(ViewConfiguration.getEdgeSlop() >> 16)));
                                int i304 = -(KeyEvent.getMaxKeyCode() >> 16);
                                int i305 = ((i304 | 40) << 1) - (i304 ^ 40);
                                Object[] objArr55 = new Object[1];
                                a(keyRepeatDelay, i303, i305, objArr55);
                                strArr8[1] = (String) objArr55[0];
                                int i306 = -(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                                int i307 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                int i308 = (i307 ^ 482) + ((i307 & 482) << 1);
                                byte modifierMetaStateMask = (byte) KeyEvent.getModifierMetaStateMask();
                                int i309 = (modifierMetaStateMask ^ Ascii.FS) + ((modifierMetaStateMask & Ascii.FS) << 1);
                                Object[] objArr56 = new Object[1];
                                a((char) ((i306 & 36006) + (i306 | 36006)), i308, i309, objArr56);
                                strArr8[2] = (String) objArr56[0];
                                int i310 = artificialFrame + 55;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i310 % 128;
                                if (i310 % 2 != 0) {
                                    char c13 = (char) (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                    int i311 = -TextUtils.getOffsetAfter(str23, 1);
                                    Object[] objArr57 = new Object[1];
                                    a(c13, (i311 ^ 2714) + ((i311 & 2714) << 1), 98 / ExpandableListView.getPackedPositionType(1L), objArr57);
                                    i14 = 0;
                                    str5 = (String) objArr57[0];
                                } else {
                                    char c14 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                                    int offsetAfter = TextUtils.getOffsetAfter(str23, 0);
                                    int i312 = (offsetAfter ^ TypedValues.PositionType.TYPE_CURVE_FIT) + ((offsetAfter & TypedValues.PositionType.TYPE_CURVE_FIT) << 1);
                                    int i313 = -(-ExpandableListView.getPackedPositionType(0L));
                                    int i314 = (i313 ^ 27) + ((i313 & 27) << 1);
                                    Object[] objArr58 = new Object[1];
                                    a(c14, i312, i314, objArr58);
                                    i14 = 0;
                                    str5 = (String) objArr58[0];
                                }
                                strArr8[3] = str5;
                                char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                                int iResolveSizeAndState = View.resolveSizeAndState(i14, i14, i14);
                                int i315 = (iResolveSizeAndState & 535) + (iResolveSizeAndState | 535);
                                int i316 = -TextUtils.lastIndexOf(str23, '0', i14);
                                Object[] objArr59 = new Object[1];
                                a(longPressTimeout2, i315, (i316 & 26) + (i316 | 26), objArr59);
                                strArr8[4] = (String) objArr59[i14];
                                char mode = (char) (35618 - View.MeasureSpec.getMode(i14));
                                int i317 = -(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                                Object[] objArr60 = new Object[1];
                                a(mode, (i317 & 561) + (i317 | 561), 26 - (~(-TextUtils.getTrimmedLength(str23))), objArr60);
                                strArr8[5] = (String) objArr60[0];
                                int i318 = 0;
                                while (true) {
                                    if (i318 >= i301) {
                                        i15 = i10;
                                        break;
                                    }
                                    Object[] objArr61 = {strArr8[i318]};
                                    Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                    if (objAccessartificialFrame16 == null) {
                                        int i319 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                                        char cResolveSize2 = (char) View.resolveSize(0, 0);
                                        int modifierMetaStateMask2 = 2440 - ((byte) KeyEvent.getModifierMetaStateMask());
                                        byte[] bArr10 = $$a;
                                        Object[] objArr62 = new Object[1];
                                        b(bArr10[4], bArr10[18], bArr10[10], objArr62);
                                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i319, cResolveSize2, modifierMetaStateMask2, 954751276, false, (String) objArr62[0], new Class[]{String.class});
                                    }
                                    String str29 = (String) ((Method) objAccessartificialFrame16).invoke(null, objArr61);
                                    if (str29 != null && str29.length() != 0) {
                                        i15 = (~(i10 & 265)) & (i10 | 265);
                                        break;
                                    }
                                    i318 = ((i318 & 1) << 1) + (i318 ^ 1);
                                    i301 = 6;
                                }
                                if (i15 != i10) {
                                    int i320 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i321 = (i320 & 67) + (i320 | 67);
                                    artificialFrame = i321 % 128;
                                    int i322 = i321 % 2;
                                    objArr3 = new Object[]{null, new int[1], null, new int[]{i10}, new int[]{i15}};
                                    int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                                    int i323 = (((~((-39862273) | iFreeMemory)) | 293998729) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 844811500 + ((~((~iFreeMemory) | (-39862273))) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
                                    int i324 = ((i323 | 16) << 1) - (i323 ^ 16);
                                    int i325 = ((i3 | i324) << 1) - (i3 ^ i324);
                                    int i326 = i325 << 13;
                                    int i327 = (i326 | i325) & (~(i325 & i326));
                                    int i328 = i327 >>> 17;
                                    int i329 = ((~i327) & i328) | ((~i328) & i327);
                                    int i330 = i329 << 5;
                                    ((int[]) objArr3[1])[0] = (i329 | i330) & (~(i329 & i330));
                                } else {
                                    Object[] objArr63 = new Object[1];
                                    a((char) ((-1) - TextUtils.lastIndexOf(str23, '0')), 348 - (~(-(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))), 16 - (~(ViewConfiguration.getKeyRepeatDelay() >> 16)), objArr63);
                                    String str30 = (String) objArr63[0];
                                    int capsMode2 = TextUtils.getCapsMode(str23, 0, 0);
                                    Object[] objArr64 = new Object[1];
                                    a((char) ((capsMode2 ^ 59595) + ((59595 & capsMode2) << 1)), 587 - (~(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), '6' - AndroidCharacter.getMirror('0'), objArr64);
                                    Object[] objArr65 = {str30, (String) objArr64[0]};
                                    Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                    if (objAccessartificialFrame17 == null) {
                                        int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 31;
                                        char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) str23, '0') + 57023);
                                        int iIndexOf6 = TextUtils.indexOf((CharSequence) str23, '0', 0, 0) + 2312;
                                        byte b11 = (byte) ($$b & 15);
                                        byte b12 = $$a[18];
                                        Object[] objArr66 = new Object[1];
                                        b(b11, b12, (byte) (b12 | Ascii.RS), objArr66);
                                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cIndexOf2, iIndexOf6, 1412547569, false, (String) objArr66[0], new Class[]{String.class, String.class});
                                    }
                                    long jLongValue7 = ((Long) ((Method) objAccessartificialFrame17).invoke(null, objArr65)).longValue();
                                    long j43 = 1183515692;
                                    long j44 = (((long) 450) * j43) + (((long) (-448)) * jLongValue7);
                                    long j45 = 449;
                                    long j46 = ((j43 ^ j22) | jLongValue7) ^ j22;
                                    long j47 = jLongValue7 ^ j22;
                                    long j48 = j44 + ((j46 | (((j47 | j43) | j26) ^ j22)) * j45) + (((long) (-1347)) * j46) + (j45 * (j46 | (((j47 | j27) | j43) ^ j22))) + ((long) (-1338267321));
                                    int i331 = ((int) (j48 >> 32)) & ((((~((-2021919479) | i10)) | 545259586) * (-566)) + 816506774 + ((~((-1476659893) | i10)) * 566));
                                    int i332 = ((int) j48) & (((818885255 + ((816204896 | i279) * 1324)) + (((~(2041531764 | i10)) | (~(816209121 | i10))) * (-1324))) - 579635378);
                                    if (((i331 & i332) | (i331 ^ i332)) != 0) {
                                        i16 = (~(i10 & 260)) & (i10 | 260);
                                        str6 = str23;
                                    } else {
                                        char scrollDefaultDelay = (char) (26569 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                                        int i333 = -(-(KeyEvent.getMaxKeyCode() >> 16));
                                        int i334 = -Color.green(0);
                                        int i335 = (i334 ^ 13) + ((i334 & 13) << 1);
                                        Object[] objArr67 = new Object[1];
                                        a(scrollDefaultDelay, (i333 ^ 595) + ((i333 & 595) << 1), i335, objArr67);
                                        String str31 = (String) objArr67[0];
                                        int i336 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
                                        int scrollBarFadeDuration2 = ViewConfiguration.getScrollBarFadeDuration() >> 16;
                                        int i337 = (scrollBarFadeDuration2 * (-419)) + 255968;
                                        int i338 = (~(i10 | TypedValues.MotionType.TYPE_DRAW_PATH)) * TypedValues.CycleType.TYPE_EASING;
                                        int i339 = ((i337 | i338) << 1) - (i337 ^ i338);
                                        int i340 = ~scrollBarFadeDuration2;
                                        int i341 = (i339 - (~(-(-(((i340 & TypedValues.MotionType.TYPE_DRAW_PATH) | (i340 ^ TypedValues.MotionType.TYPE_DRAW_PATH)) * (-420)))))) - 1;
                                        int i342 = ~scrollBarFadeDuration2;
                                        int i343 = ~((i342 & (-609)) | (i342 ^ (-609)));
                                        int i344 = i4;
                                        int i345 = ~((i344 & TypedValues.MotionType.TYPE_DRAW_PATH) | (i344 ^ TypedValues.MotionType.TYPE_DRAW_PATH));
                                        int i346 = (i341 - (~(-(-(((i343 & i345) | (i343 ^ i345)) * TypedValues.CycleType.TYPE_EASING))))) - 1;
                                        int i347 = -(-AndroidCharacter.getMirror('0'));
                                        int i348 = (i347 ^ (-39)) + ((i347 & (-39)) << 1);
                                        Object[] objArr68 = new Object[1];
                                        a((char) ((i336 & 17646) + (i336 | 17646)), i346, i348, objArr68);
                                        String str32 = (String) objArr68[0];
                                        File file4 = new File(str31);
                                        if (file4.exists() && file4.isFile()) {
                                            try {
                                                Scanner scanner3 = new Scanner(new FileInputStream(file4));
                                                str6 = str23;
                                                try {
                                                    int i349 = -(-TextUtils.lastIndexOf(str6, '0', 0));
                                                    int i350 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                                                    Object[] objArr69 = new Object[1];
                                                    a((char) ((i349 & 1) + (i349 | 1)), (i350 & 229) + (i350 | 229), 1 - (~(-(Process.myTid() >> 22))), objArr69);
                                                    Scanner scannerUseDelimiter4 = scanner3.useDelimiter((String) objArr69[0]);
                                                    String next4 = scannerUseDelimiter4.hasNext() ? scannerUseDelimiter4.next() : str6;
                                                    scannerUseDelimiter4.close();
                                                    i16 = next4.contains(str32) ? (~(i10 & 261)) & (i10 | 261) : i10;
                                                } catch (IOException unused3) {
                                                }
                                            } catch (IOException unused4) {
                                                str6 = str23;
                                            }
                                        } else {
                                            str6 = str23;
                                        }
                                    }
                                    if (i16 == i10) {
                                        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-913150042);
                                        if (objAccessartificialFrame18 == null) {
                                            int scrollBarFadeDuration3 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 28;
                                            char gidForName = (char) ((-1) - Process.getGidForName(str6));
                                            int iArgb = Color.argb(0, 0, 0, 0) + 764;
                                            byte[] bArr11 = $$a;
                                            byte b13 = (byte) (bArr11[14] - 1);
                                            byte b14 = bArr11[4];
                                            Object[] objArr70 = new Object[1];
                                            b(b13, b14, (byte) (b14 | Ascii.GS), objArr70);
                                            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, gidForName, iArgb, 1459038638, false, (String) objArr70[0], new Class[0]);
                                        }
                                        long jLongValue8 = ((Long) ((Method) objAccessartificialFrame18).invoke(null, null)).longValue();
                                        long j49 = 1439944869;
                                        long j50 = jLongValue8 ^ j22;
                                        long jMyPid2 = Process.myPid();
                                        long j51 = TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                                        long j52 = jMyPid2 ^ j22;
                                        long j53 = (((long) 319) * j49) + (((long) (-317)) * jLongValue8) + (((long) (-318)) * (j50 | (((j49 ^ j22) | jMyPid2) ^ j22))) + ((((j50 | jMyPid2) ^ j22) | (((j52 | j49) | jLongValue8) ^ j22)) * j51) + (j51 * ((((j50 | j52) | j49) ^ j22) | (((jLongValue8 | j49) | jMyPid2) ^ j22))) + ((long) 498656783);
                                        int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
                                        int i351 = i;
                                        if (((((int) (j53 >> 32)) & (((((~(701608160 | iMaxMemory2)) | (-1454225004)) * 398) - 514054048) + (((~((~iMaxMemory2) | 701608160)) | (-1454225004)) * 398))) | (((int) j53) & (1437555009 + ((i351 | 1074037760) * 988) + (((~((-198930776) | i279)) | 34672901) * (-1976)) + ((1074037760 | (~(1238295634 | i351)) | (~((-1238295635) | i279))) * 988)))) == 1) {
                                            objArr2 = new Object[]{null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i351}, new int[]{i351}};
                                            int i352 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i353 = (i352 & 125) + (i352 | 125);
                                            artificialFrame = i353 % 128;
                                            int i354 = i353 % 2;
                                            int i355 = 319002477 + (((~((-1573377) | i279)) | (-603875082) | (~(i351 | 557475584))) * (-68)) + ((~((-46399498) | i279)) * (-68)) + (((~((-557475585) | i279)) | (-47972874)) * 68);
                                            int i356 = i3 + ((i355 << 1) - i355);
                                            int i357 = i356 << 13;
                                            int i358 = (i356 | i357) & (~(i356 & i357));
                                            int i359 = i358 >>> 17;
                                            int i360 = ((~i358) & i359) | ((~i359) & i358);
                                            int i361 = i360 << 5;
                                        } else {
                                            Object[] objArr71 = {1};
                                            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1671772348);
                                            if (objAccessartificialFrame19 == null) {
                                                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 19;
                                                char capsMode3 = (char) TextUtils.getCapsMode(str6, 0, 0);
                                                int iMyPid5 = (Process.myPid() >> 22) + 1573;
                                                Object[] objArr72 = new Object[1];
                                                b((byte) 15, $$a[4], (byte) 49, objArr72);
                                                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, capsMode3, iMyPid5, -54493516, false, (String) objArr72[0], new Class[]{Integer.TYPE});
                                            }
                                            long jLongValue9 = ((Long) ((Method) objAccessartificialFrame19).invoke(null, objArr71)).longValue();
                                            long j54 = 144057890;
                                            long j55 = -167;
                                            long j56 = (j55 * j54) + (j55 * jLongValue9);
                                            long j57 = 168;
                                            long j58 = j54 ^ j22;
                                            long j59 = jLongValue9 ^ j22;
                                            long j60 = j58 | j59;
                                            long j61 = j56 + (((j60 ^ j22) | ((j59 | j27) ^ j22)) * j57) + (((j60 | j26) ^ j22) * j57) + (j57 * (((j58 | j27) ^ j22) | ((j58 | jLongValue9) ^ j22) | (((j59 | j54) | j26) ^ j22))) + ((long) 340526827);
                                            int iMaxMemory3 = (int) Runtime.getRuntime().maxMemory();
                                            int i362 = ((int) (j61 >> 32)) & (((((~((-1801018024) | iMaxMemory3)) | (-2130075228)) * 398) - 758396144) + (((~((~iMaxMemory3) | (-1801018024))) | (-2130075228)) * 398));
                                            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                                            int i363 = ~iElapsedRealtime2;
                                            int i364 = ~((-1346991429) | i363);
                                            int i365 = ~((-1510749458) | iElapsedRealtime2);
                                            int i366 = ((int) j61) & (334239082 + ((i364 | i365) * 1150) + (((~(1510749457 | i363)) | i365) * (-575)) + (((~(iElapsedRealtime2 | (-1346991429))) | (~(i363 | 1346991428))) * 575));
                                            int i367 = ((int) ((long) ((i362 & i366) | (i362 ^ i366)))) != 0 ? (~(i351 & 220)) & (i351 | 220) : i351;
                                            if (i367 != i351) {
                                                objArr3 = new Object[]{null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i351}, new int[]{i367}};
                                                int i368 = 499095465 + (((~(i279 | 416741455)) | (-469760256)) * (-160)) + ((416741455 | (~((-188707003) | i279))) * SyslogConstants.LOG_LOCAL4);
                                                int i369 = ((i368 | 16) << 1) - (i368 ^ 16);
                                                int i370 = (i3 ^ i369) + ((i3 & i369) << 1);
                                                int i371 = i370 << 13;
                                                int i372 = (i371 | i370) & (~(i370 & i371));
                                                int i373 = i372 >>> 17;
                                                int i374 = (i372 | i373) & (~(i372 & i373));
                                                int i375 = i374 << 5;
                                            } else {
                                                char cResolveSize3 = (char) (View.resolveSize(0, 0) + 23374);
                                                int capsMode4 = TextUtils.getCapsMode(str6, 0, 0) + 372;
                                                int i376 = -MotionEvent.axisFromString(str6);
                                                int iArtificialStackFrames4 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                int i377 = ~i376;
                                                int i378 = ~((i377 & (-23)) | (i377 ^ (-23)));
                                                int i379 = ~iArtificialStackFrames4;
                                                int i380 = (i379 ^ i376) | (i379 & i376);
                                                int i381 = ~((i380 & 22) | (i380 ^ 22));
                                                int i382 = (((i376 * 829) + 18238) - (~(-(-(((i378 & i381) | (i378 ^ i381)) * (-828)))))) - 1;
                                                int i383 = (i376 & 22) | (i376 ^ 22);
                                                int i384 = ((i379 & i383) | (i383 ^ i379)) * (-828);
                                                int i385 = (i382 & i384) + (i384 | i382);
                                                int i386 = (~i383) * 828;
                                                Object[] objArr73 = new Object[1];
                                                a(cResolveSize3, capsMode4, (i385 & i386) + (i386 | i385), objArr73);
                                                Object[] objArr74 = {(String) objArr73[0]};
                                                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                if (objAccessartificialFrame20 == null) {
                                                    int iIndexOf7 = TextUtils.indexOf(str6, str6, 0) + 23;
                                                    char gidForName2 = (char) (Process.getGidForName(str6) + 1);
                                                    int i387 = 2440 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                                    byte[] bArr12 = $$a;
                                                    Object[] objArr75 = new Object[1];
                                                    b(bArr12[4], bArr12[18], bArr12[10], objArr75);
                                                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iIndexOf7, gidForName2, i387, 954751276, false, (String) objArr75[0], new Class[]{String.class});
                                                }
                                                Object objInvoke2 = ((Method) objAccessartificialFrame20).invoke(null, objArr74);
                                                if (objInvoke2 != null) {
                                                    Object[] objArr76 = {objInvoke2, 42};
                                                    Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-287841710);
                                                    if (objAccessartificialFrame21 == null) {
                                                        int iLastIndexOf3 = TextUtils.lastIndexOf(str6, '0', 0) + 21;
                                                        char cResolveSize4 = (char) View.resolveSize(0, 0);
                                                        int i388 = 2245 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                        byte[] bArr13 = $$a;
                                                        byte b15 = (byte) (bArr13[9] + 1);
                                                        byte b16 = bArr13[18];
                                                        Object[] objArr77 = new Object[1];
                                                        b(b15, b16, (byte) (b16 | 36), objArr77);
                                                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, cResolveSize4, i388, 1907532890, false, (String) objArr77[0], new Class[]{String.class, Integer.TYPE});
                                                    }
                                                    long jLongValue10 = ((Long) ((Method) objAccessartificialFrame21).invoke(null, objArr76)).longValue();
                                                    long j62 = 766567109;
                                                    long j63 = -518;
                                                    long j64 = (j63 * j62) + (j63 * jLongValue10);
                                                    long j65 = 519;
                                                    long j66 = (j62 ^ j22) | j27;
                                                    long j67 = j64 + ((jLongValue10 | (j66 ^ j22)) * j65) + (((long) (-519)) * (((j66 | jLongValue10) ^ j22) | (((j62 | jLongValue10) | j26) ^ j22))) + (j65 * (j62 | ((jLongValue10 | j26) ^ j22))) + ((long) 866518219);
                                                    int iNextInt2 = new Random().nextInt();
                                                    int i389 = ~((-1756004945) | iNextInt2);
                                                    int i390 = ~iNextInt2;
                                                    int i391 = ((int) (j67 >> 32)) & (956367856 + ((i389 | (~((-5246977) | i390))) * 497) + (((~(iNextInt2 | (-5246977))) | (~(324025509 | i390)) | (-2080030454)) * 497));
                                                    int i392 = ((int) j67) & (1852544287 + (((~((-528197458) | i351)) | 354526289 | (~((-1965423868) | i351))) * (-754)) + (((~((-354526290) | i351)) | (~((-1610897579) | i279))) * (-754)) + (((-528197458) | i279) * 754));
                                                    if (((i392 & i391) | (i391 ^ i392)) == 1986687685) {
                                                        int i393 = artificialFrame;
                                                        int i394 = (i393 ^ 7) + ((i393 & 7) << 1);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i394 % 128;
                                                        int i395 = i394 % 2;
                                                        str7 = str6;
                                                        i17 = i279;
                                                        j = j22;
                                                        j2 = j26;
                                                        i19 = 1;
                                                    }
                                                    int i396 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                                    char c15 = (char) ((i396 ^ 58074) + ((i396 & 58074) << i19));
                                                    str9 = str7;
                                                    int iIndexOf8 = TextUtils.indexOf((CharSequence) str9, '0', 0);
                                                    int i397 = ((iIndexOf8 | 699) << i19) - (iIndexOf8 ^ 699);
                                                    int i398 = -MotionEvent.axisFromString(str9);
                                                    Object[] objArr78 = new Object[1];
                                                    a(c15, i397, (i398 & 15) + (i398 | 15), objArr78);
                                                    Object[] objArr79 = {(String) objArr78[0]};
                                                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                    if (objAccessartificialFrame == null) {
                                                        int gidForName3 = Process.getGidForName(str9) + 24;
                                                        char capsMode5 = (char) TextUtils.getCapsMode(str9, 0, 0);
                                                        int i399 = 2442 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                        byte[] bArr14 = $$a;
                                                        Object[] objArr80 = new Object[1];
                                                        b(bArr14[4], bArr14[18], bArr14[10], objArr80);
                                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(gidForName3, capsMode5, i399, 954751276, false, (String) objArr80[0], new Class[]{String.class});
                                                    }
                                                    objInvoke = ((Method) objAccessartificialFrame).invoke(null, objArr79);
                                                    if (objInvoke == null) {
                                                        i22 = 0;
                                                    } else {
                                                        i20 = artificialFrame + 101;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                                                        if (i20 % 2 != 0) {
                                                            Object[] objArr81 = {objInvoke, 42};
                                                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-287841710);
                                                            if (objAccessartificialFrame3 == null) {
                                                                int scrollBarFadeDuration4 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 20;
                                                                char cRgb = (char) (Color.rgb(0, 0, 0) + 16777216);
                                                                int iMakeMeasureSpec = 2245 - View.MeasureSpec.makeMeasureSpec(0, 0);
                                                                byte[] bArr15 = $$a;
                                                                byte b17 = (byte) (bArr15[9] + 1);
                                                                byte b18 = bArr15[18];
                                                                Object[] objArr82 = new Object[1];
                                                                b(b17, b18, (byte) (b18 | 36), objArr82);
                                                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration4, cRgb, iMakeMeasureSpec, 1907532890, false, (String) objArr82[0], new Class[]{String.class, Integer.TYPE});
                                                            }
                                                            jLongValue = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr81)).longValue();
                                                            i21 = 1;
                                                        } else {
                                                            Object[] objArr83 = {objInvoke, 42};
                                                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-287841710);
                                                            if (objAccessartificialFrame2 == null) {
                                                                int iIndexOf9 = 19 - TextUtils.indexOf((CharSequence) str9, '0', 0);
                                                                char c16 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                                                                int maximumFlingVelocity = 2245 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                                byte[] bArr16 = $$a;
                                                                byte b19 = (byte) (bArr16[9] + 1);
                                                                byte b20 = bArr16[18];
                                                                Object[] objArr84 = new Object[1];
                                                                b(b19, b20, (byte) (b20 | 36), objArr84);
                                                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf9, c16, maximumFlingVelocity, 1907532890, false, (String) objArr84[0], new Class[]{String.class, Integer.TYPE});
                                                            }
                                                            jLongValue = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr83)).longValue();
                                                            i21 = 0;
                                                        }
                                                        long j68 = 1017231324;
                                                        long j69 = j68 ^ j;
                                                        int i400 = i21;
                                                        long startUptimeMillis = (int) Process.getStartUptimeMillis();
                                                        long j70 = startUptimeMillis ^ j;
                                                        long j71 = (((long) (-563)) * j68) + (((long) 565) * jLongValue) + (((long) (-564)) * (j69 | (((jLongValue ^ j) | j70) ^ j) | ((jLongValue | startUptimeMillis) ^ j))) + (((long) 1128) * (((j69 | jLongValue) | startUptimeMillis) ^ j)) + (((long) 564) * (((jLongValue | j68) ^ j) | ((j69 | j70) ^ j))) + ((long) 615854004);
                                                        i351 = i;
                                                        int i401 = ((int) (j71 >> 32)) & (1871737038 + (((~(669324799 | i17)) | (~((-2106551211) | i351))) * 1900) + (((~(i17 | 2106551210)) | (~((-669324800) | i351))) * (-950)) + (((~(2106551210 | i351)) | (~(i17 | (-669324800)))) * 950));
                                                        int iMyPid6 = Process.myPid();
                                                        int i402 = ((int) j71) & (((((~(1302484599 | iMyPid6)) | 1168484677) * 262) - 1792104983) + (((~((~iMyPid6) | 1302484599)) | 1168484677) * 262));
                                                        int i403 = (i401 & i402) | (i401 ^ i402);
                                                        i22 = (i403 | i400) & (~(i403 & i400));
                                                    }
                                                    if (i22 != 1986687685 || i22 == -1514516938) {
                                                        i23 = i351;
                                                        str10 = str9;
                                                    } else {
                                                        int i404 = artificialFrame + 101;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i404 % 128;
                                                        int i405 = i404 % 2;
                                                        int i406 = 19;
                                                        int i407 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                        int i408 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1412;
                                                        int i409 = -TextUtils.getCapsMode(str9, 0, 0);
                                                        int i410 = (i409 ^ 14) + ((i409 & 14) << 1);
                                                        Object[] objArr85 = new Object[1];
                                                        a((char) ((i407 ^ 58805) + ((i407 & 58805) << 1)), i408, i410, objArr85);
                                                        int i411 = -(-TextUtils.getCapsMode(str9, 0, 0));
                                                        int i412 = 1425 - (~(-MotionEvent.axisFromString(str9)));
                                                        int i413 = -Gravity.getAbsoluteGravity(0, 0);
                                                        int iArtificialStackFrames5 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                        int i414 = i413 * 980;
                                                        int i415 = (i414 ^ (-25428)) + ((i414 & (-25428)) << 1);
                                                        int i416 = ~iArtificialStackFrames5;
                                                        int i417 = (((i415 - (~((~(((-27) ^ i416) | ((-27) & i416))) * 979))) - 1) - (~((i413 | iArtificialStackFrames5) * (-979)))) - 1;
                                                        int i418 = ~((iArtificialStackFrames5 & (-27)) | ((-27) ^ iArtificialStackFrames5));
                                                        int i419 = ~(i413 | i416);
                                                        int i420 = (i417 - (~(((i419 & i418) | (i418 ^ i419)) * 979))) - 1;
                                                        Object[] objArr86 = new Object[1];
                                                        a((char) ((i411 & 46377) + (i411 | 46377)), i412, i420, objArr86);
                                                        char offsetBefore = (char) TextUtils.getOffsetBefore(str9, 0);
                                                        int i421 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                        Object[] objArr87 = new Object[1];
                                                        a(offsetBefore, (i421 ^ 1453) + ((i421 & 1453) << 1), ExpandableListView.getPackedPositionType(0L) + 17, objArr87);
                                                        char c17 = (char) ((-2) - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                                                        int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 1470;
                                                        int i422 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                        Object[] objArr88 = new Object[1];
                                                        a(c17, windowTouchSlop, (i422 & 17) + (i422 | 17), objArr88);
                                                        int i423 = -(-View.MeasureSpec.getMode(0));
                                                        int i424 = -ExpandableListView.getPackedPositionType(0L);
                                                        Object[] objArr89 = new Object[1];
                                                        a((char) ((i423 ^ 22252) + ((i423 & 22252) << 1)), (i424 & 1487) + (i424 | 1487), 14 - (~(-Color.blue(0))), objArr89);
                                                        char deadChar2 = (char) (KeyEvent.getDeadChar(0, 0) + 49233);
                                                        int i425 = -(-((Process.getThreadPriority(0) + 20) >> 6));
                                                        Object[] objArr90 = new Object[1];
                                                        a(deadChar2, (i425 & 1502) + (i425 | 1502), 37 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr90);
                                                        char c18 = (char) (55865 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))));
                                                        int scrollBarFadeDuration5 = ViewConfiguration.getScrollBarFadeDuration() >> 16;
                                                        int i426 = (scrollBarFadeDuration5 & 1539) + (scrollBarFadeDuration5 | 1539);
                                                        int i427 = -(Process.myTid() >> 22);
                                                        int iArtificialStackFrames6 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                        int i428 = ~i427;
                                                        int i429 = ~iArtificialStackFrames6;
                                                        int i430 = ~((i428 ^ i429) | (i428 & i429));
                                                        int i431 = ~((i428 & 12) | (i428 ^ 12));
                                                        int i432 = (i431 & i430) | (i430 ^ i431);
                                                        int i433 = ~((i429 & 12) | (i429 ^ 12));
                                                        int i434 = ((i427 * 398) - 4752) + (((i432 & i433) | (i432 ^ i433)) * (-397));
                                                        int i435 = ~i427;
                                                        int i436 = i434 + ((~((i435 ^ 12) | (i435 & 12))) * (-397));
                                                        int i437 = ~(i435 | 12);
                                                        int i438 = (iArtificialStackFrames6 & i437) | (iArtificialStackFrames6 ^ i437);
                                                        int i439 = ~((i427 & (-13)) | ((-13) ^ i427));
                                                        int i440 = -(-(((i439 & i438) | (i438 ^ i439)) * 397));
                                                        int i441 = ((i436 | i440) << 1) - (i440 ^ i436);
                                                        Object[] objArr91 = new Object[1];
                                                        a(c18, i426, i441, objArr91);
                                                        int i442 = -View.resolveSize(0, 0);
                                                        Object[] objArr92 = new Object[1];
                                                        a((char) (((i442 | 15474) << 1) - (i442 ^ 15474)), 1551 - (~(-(-TextUtils.indexOf((CharSequence) str9, '0')))), (ViewConfiguration.getTapTimeout() >> 16) + 13, objArr92);
                                                        Object[] objArr93 = new Object[1];
                                                        a((char) (2628 - TextUtils.indexOf((CharSequence) str9, '0')), 1563 - (~(-(ViewConfiguration.getTapTimeout() >> 16))), 21 - (~(-Color.red(0))), objArr93);
                                                        char c19 = (char) (5847 - (~(-(ViewConfiguration.getTapTimeout() >> 16))));
                                                        int capsMode6 = TextUtils.getCapsMode(str9, 0, 0) + 1586;
                                                        int i443 = -(-View.MeasureSpec.getMode(0));
                                                        int i444 = ((i443 | 31) << 1) - (i443 ^ 31);
                                                        Object[] objArr94 = new Object[1];
                                                        a(c19, capsMode6, i444, objArr94);
                                                        Object[] objArr95 = new Object[1];
                                                        a((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 1616 - (~(-(-View.resolveSizeAndState(0, 0, 0)))), 12 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))), objArr95);
                                                        char cMyTid = (char) (Process.myTid() >> 22);
                                                        int iLastIndexOf4 = TextUtils.lastIndexOf(str9, '0', 0, 0);
                                                        int i445 = (iLastIndexOf4 & 1630) + (iLastIndexOf4 | 1630);
                                                        int i446 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                                        int i447 = (i446 ^ 12) + ((i446 & 12) << 1);
                                                        Object[] objArr96 = new Object[1];
                                                        a(cMyTid, i445, i447, objArr96);
                                                        char c20 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                        int i448 = -Color.blue(0);
                                                        int i449 = (i448 & 1641) + (i448 | 1641);
                                                        int i450 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                        int i451 = ((i450 | 12) << 1) - (i450 ^ 12);
                                                        Object[] objArr97 = new Object[1];
                                                        a(c20, i449, i451, objArr97);
                                                        char defaultSize = (char) View.getDefaultSize(0, 0);
                                                        int i452 = -ExpandableListView.getPackedPositionType(0L);
                                                        Object[] objArr98 = new Object[1];
                                                        a(defaultSize, (i452 & 1653) + (i452 | 1653), 12 - (Process.myTid() >> 22), objArr98);
                                                        char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                                                        int i453 = 1664 - (~TextUtils.getCapsMode(str9, 0, 0));
                                                        int i454 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                                                        int i455 = ((i454 | 12) << 1) - (i454 ^ 12);
                                                        Object[] objArr99 = new Object[1];
                                                        a(jumpTapTimeout, i453, i455, objArr99);
                                                        Object[] objArr100 = new Object[1];
                                                        a((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 1677 - ExpandableListView.getPackedPositionGroup(0L), 13 - (~(-Gravity.getAbsoluteGravity(0, 0))), objArr100);
                                                        int i456 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                                        int i457 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                                        artificialFrame = i457 % 128;
                                                        int i458 = i457 % 2;
                                                        char c21 = (char) (0 - (~(-i456)));
                                                        int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 1691;
                                                        int i459 = -KeyEvent.keyCodeFromString(str9);
                                                        int i460 = ((i459 | 12) << 1) - (i459 ^ 12);
                                                        Object[] objArr101 = new Object[1];
                                                        a(c21, absoluteGravity2, i460, objArr101);
                                                        char c22 = (char) ((-2) - ((-TextUtils.indexOf((CharSequence) str9, '0', 0, 0)) ^ (-1)));
                                                        int i461 = -(-Color.alpha(0));
                                                        Object[] objArr102 = new Object[1];
                                                        a(c22, (i461 ^ 1703) + ((i461 & 1703) << 1), 23 - (~(-(ViewConfiguration.getKeyRepeatTimeout() >> 16))), objArr102);
                                                        int i462 = -KeyEvent.normalizeMetaState(0);
                                                        int touchSlop2 = ViewConfiguration.getTouchSlop() >> 8;
                                                        int i463 = ((touchSlop2 | 1727) << 1) - (touchSlop2 ^ 1727);
                                                        int i464 = -ExpandableListView.getPackedPositionType(0L);
                                                        int i465 = ((i464 | 28) << 1) - (i464 ^ 28);
                                                        Object[] objArr103 = new Object[1];
                                                        a((char) (((i462 | 54084) << 1) - (i462 ^ 54084)), i463, i465, objArr103);
                                                        String[] strArr9 = {(String) objArr85[0], (String) objArr86[0], (String) objArr87[0], (String) objArr88[0], (String) objArr89[0], (String) objArr90[0], (String) objArr91[0], (String) objArr92[0], (String) objArr93[0], (String) objArr94[0], (String) objArr95[0], (String) objArr96[0], (String) objArr97[0], (String) objArr98[0], (String) objArr99[0], (String) objArr100[0], (String) objArr101[0], (String) objArr102[0], (String) objArr103[0]};
                                                        int i466 = 0;
                                                        while (true) {
                                                            if (i466 >= i406) {
                                                                i23 = i351;
                                                                str10 = str9;
                                                                i43 = -1;
                                                                break;
                                                            }
                                                            String str33 = strArr9[i466];
                                                            Object[] objArr104 = {str33};
                                                            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(267846469);
                                                            if (objAccessartificialFrame22 == null) {
                                                                int i467 = 18 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                                char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString(str9) + 24343);
                                                                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 2014;
                                                                byte[] bArr17 = $$a;
                                                                byte b21 = (byte) (-bArr17[7]);
                                                                byte b22 = bArr17[10];
                                                                Object[] objArr105 = new Object[1];
                                                                b(b21, b22, (byte) (b22 | 38), objArr105);
                                                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i467, cKeyCodeFromString, iResolveOpacity2, -1869462195, false, (String) objArr105[0], new Class[]{String.class});
                                                            }
                                                            long jLongValue11 = ((Long) ((Method) objAccessartificialFrame22).invoke(null, objArr104)).longValue();
                                                            long j72 = -94836055;
                                                            String[] strArr10 = strArr9;
                                                            int i468 = i466;
                                                            long j73 = jLongValue11 ^ j;
                                                            String str34 = str9;
                                                            long jNextInt2 = new Random().nextInt();
                                                            long j74 = (j72 | jNextInt2) ^ j;
                                                            long j75 = 407;
                                                            long j76 = j72 ^ j;
                                                            long j77 = (j76 | jLongValue11) ^ j;
                                                            long j78 = (((long) (-813)) * j72) + (((long) TSLocationManager.LOCATION_ERROR_TIMEOUT) * jLongValue11) + (((long) (-814)) * (((j73 | j72) ^ j) | j74)) + ((((j73 | (jNextInt2 ^ j)) ^ j) | j77 | j74) * j75) + (j75 * (((jLongValue11 | jNextInt2) ^ j) | j77 | ((j76 | jNextInt2) ^ j))) + ((long) (-1216795921));
                                                            i23 = i;
                                                            int i469 = ((int) (j78 >> 32)) & ((((~(2000521518 | i23)) | 8192) * (-566)) + 1441863082 + ((~(2000529710 | i23)) * 566));
                                                            int elapsedCpuTime4 = (int) Process.getElapsedCpuTime();
                                                            if ((i469 | (((int) j78) & (2005432269 + (((~(1460210608 | elapsedCpuTime4)) | 5682182) * 104) + ((~((~elapsedCpuTime4) | (-1442908593))) * (-104)) + ((elapsedCpuTime4 | 22984198) * 104)))) != 0) {
                                                                str10 = str34;
                                                            } else {
                                                                char c23 = (char) ((-2) - ((-ImageFormat.getBitsPerPixel(0)) ^ (-1)));
                                                                int keyRepeatTimeout3 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                                                                Object[] objArr106 = new Object[1];
                                                                a(c23, (keyRepeatTimeout3 ^ 1677) + ((keyRepeatTimeout3 & 1677) << 1), 12 - (~(-TextUtils.lastIndexOf(str34, '0', 0))), objArr106);
                                                                if (!str33.equals((String) objArr106[0])) {
                                                                    str10 = str34;
                                                                } else {
                                                                    Object[] objArr107 = {str33};
                                                                    Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(479197382);
                                                                    if (objAccessartificialFrame23 == null) {
                                                                        int modifierMetaStateMask3 = 16 - ((byte) KeyEvent.getModifierMetaStateMask());
                                                                        char offsetBefore2 = (char) (24343 - TextUtils.getOffsetBefore(str34, 0));
                                                                        int i470 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2013;
                                                                        byte[] bArr18 = $$a;
                                                                        byte b23 = bArr18[18];
                                                                        byte b24 = bArr18[10];
                                                                        Object[] objArr108 = new Object[1];
                                                                        b(b23, b24, (byte) (b24 | 38), objArr108);
                                                                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask3, offsetBefore2, i470, -2081767730, false, (String) objArr108[0], new Class[]{String.class});
                                                                    }
                                                                    long jLongValue12 = ((Long) ((Method) objAccessartificialFrame23).invoke(null, objArr107)).longValue();
                                                                    long j79 = -1086090387;
                                                                    long j80 = 521;
                                                                    long j81 = j79 ^ j;
                                                                    long j82 = (((long) (-520)) * j79) + (((long) 522) * jLongValue12) + ((((j81 | jLongValue12) | j2) ^ j) * j80);
                                                                    str10 = str34;
                                                                    long j83 = ((jLongValue12 ^ j) | j79) ^ j;
                                                                    long j84 = j82 + (((long) (-1042)) * j83) + (j80 * (((jLongValue12 | (j81 | j27)) ^ j) | j83)) + ((long) 1582701778);
                                                                    int i471 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                    int i472 = (i471 & 77) + (i471 | 77);
                                                                    artificialFrame = i472 % 128;
                                                                    if (i472 % 2 == 0) {
                                                                        i44 = ((int) (j84 >> 68)) & ((((-1771464918) + (((~(403753073 | i23)) | 1705711116) * 576)) + (((~(i17 | 2109464189)) | 135268368) * 576)) - 1057907968);
                                                                        i45 = (int) j84;
                                                                        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                                                                        i46 = (-968458956) + ((~((~startElapsedRealtime) | (-5509122))) * 433) + (((~(385782285 | startElapsedRealtime)) | 1051444124) * (-433)) + (((~(startElapsedRealtime | 1051444124)) | 380273164) * 433);
                                                                    } else {
                                                                        int i473 = ~Process.myUid();
                                                                        i44 = ((int) (j84 >> 32)) & ((-1223942582) + (((~(i473 | (-970667713))) | 811217536) * (-160)) + (((~(i473 | 1887073172)) | (-970667713)) * SyslogConstants.LOG_LOCAL4));
                                                                        i45 = (int) j84;
                                                                        i46 = (((-384374209) + (((~(1129975791 | i17)) | (-1398427648)) * 446)) + (((~((-268451857) | i23)) | 1091177029) * 446)) - 928473088;
                                                                    }
                                                                    if ((i44 | (i45 & i46)) != 0) {
                                                                    }
                                                                }
                                                                int i474 = (i468 & (-112)) + (i468 | (-112));
                                                                i351 = i23;
                                                                strArr9 = strArr10;
                                                                str9 = str10;
                                                                i466 = (i474 | 113) + (i474 & 113);
                                                                i406 = 19;
                                                            }
                                                            i43 = i468;
                                                            break;
                                                        }
                                                        if (i43 >= 0) {
                                                            int i475 = i43 + 130;
                                                            int i476 = (~(i23 & i475)) & (i23 | i475);
                                                            if (i476 != i23) {
                                                                Object[] objArr109 = {null, new int[1], null, new int[]{i23}, new int[]{i476}};
                                                                int iNextInt3 = new Random().nextInt();
                                                                int i477 = (((~((-439553759) | iNextInt3)) | 332420341) * 262) + 1103904081 + (((~((~iNextInt3) | (-439553759))) | 332420341) * 262);
                                                                int i478 = -(-((i477 ^ 16) + ((i477 & 16) << 1)));
                                                                int i479 = ((i3 | i478) << 1) - (i3 ^ i478);
                                                                int i480 = i479 << 13;
                                                                int i481 = (i480 | i479) & (~(i479 & i480));
                                                                int i482 = i481 >>> 17;
                                                                int i483 = (i481 | i482) & (~(i481 & i482));
                                                                int i484 = i483 << 5;
                                                                ((int[]) objArr109[1])[0] = ((~i483) & i484) | ((~i484) & i483);
                                                                return objArr109;
                                                            }
                                                        }
                                                    }
                                                    char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                    int size = View.MeasureSpec.getSize(0);
                                                    int i485 = size * (-559);
                                                    int i486 = (i485 & 984555) + (i485 | 984555) + ((~((i17 ^ size) | (i17 & size))) * (-560));
                                                    int i487 = (-1756) | size;
                                                    int i488 = -(-((~((i487 & i23) | (i487 ^ i23))) * (-560)));
                                                    int i489 = (i486 & i488) + (i488 | i486);
                                                    int i490 = ~size;
                                                    int i491 = ~((i490 & 1755) | (i490 ^ 1755));
                                                    i24 = i17;
                                                    int i492 = ~(i24 | 1755);
                                                    int i493 = -(-(((i491 & i492) | (i491 ^ i492)) * 560));
                                                    int i494 = (i489 & i493) + (i493 | i489);
                                                    str11 = str10;
                                                    int i495 = -TextUtils.indexOf((CharSequence) str11, '0', 0, 0);
                                                    Object[] objArr110 = new Object[1];
                                                    a(maximumFlingVelocity2, i494, (i495 & 12) + (i495 | 12), objArr110);
                                                    String str35 = (String) objArr110[0];
                                                    int i496 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                                                    int i497 = 1766 - (~(-MotionEvent.axisFromString(str11)));
                                                    int i498 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                    int i499 = (i498 ^ 5) + ((i498 & 5) << 1);
                                                    Object[] objArr111 = new Object[1];
                                                    a((char) ((i496 & 39079) + (i496 | 39079)), i497, i499, objArr111);
                                                    String[] strArr11 = {str35, (String) objArr111[0]};
                                                    char maxKeyCode2 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 18445);
                                                    int packedPositionType = ExpandableListView.getPackedPositionType(0L);
                                                    int i500 = ((packedPositionType | 1773) << 1) - (packedPositionType ^ 1773);
                                                    int i501 = -(-TextUtils.lastIndexOf(str11, '0', 0));
                                                    int i502 = ((i501 | 16) << 1) - (i501 ^ 16);
                                                    Object[] objArr112 = new Object[1];
                                                    a(maxKeyCode2, i500, i502, objArr112);
                                                    String str36 = (String) objArr112[0];
                                                    char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                                                    int i503 = 1787 - (~Color.argb(0, 0, 0, 0));
                                                    int jumpTapTimeout2 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                    int i504 = (jumpTapTimeout2 ^ 19) + ((jumpTapTimeout2 & 19) << 1);
                                                    Object[] objArr113 = new Object[1];
                                                    a(tapTimeout, i503, i504, objArr113);
                                                    String str37 = (String) objArr113[0];
                                                    char c24 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                                                    int iLastIndexOf5 = TextUtils.lastIndexOf(str11, '0', 0, 0);
                                                    int i505 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                    Object[] objArr114 = new Object[1];
                                                    a(c24, (iLastIndexOf5 ^ 1808) + ((iLastIndexOf5 & 1808) << 1), (i505 ^ 13) + ((13 & i505) << 1), objArr114);
                                                    String[] strArr12 = {str36, str37, (String) objArr114[0]};
                                                    int i506 = -(-KeyEvent.getDeadChar(0, 0));
                                                    int i507 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                                                    Object[] objArr115 = new Object[1];
                                                    a((char) (((i506 | 52662) << 1) - (i506 ^ 52662)), (i507 & 1821) + (i507 | 1821), 20 - (~(-(ViewConfiguration.getScrollBarSize() >> 8))), objArr115);
                                                    String str38 = (String) objArr115[0];
                                                    int i508 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                    int i509 = -View.getDefaultSize(0, 0);
                                                    int i510 = (i509 ^ 1842) + ((i509 & 1842) << 1);
                                                    int i511 = -View.getDefaultSize(0, 0);
                                                    int i512 = ((i511 | 10) << 1) - (i511 ^ 10);
                                                    Object[] objArr116 = new Object[1];
                                                    a((char) ((i508 ^ 30452) + ((i508 & 30452) << 1)), i510, i512, objArr116);
                                                    String[] strArr13 = {str38, (String) objArr116[0]};
                                                    char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString(str11);
                                                    int i513 = 1852 - (~Process.getGidForName(str11));
                                                    int i514 = -(-TextUtils.indexOf(str11, str11, 0, 0));
                                                    int i515 = ((i514 | 11) << 1) - (i514 ^ 11);
                                                    Object[] objArr117 = new Object[1];
                                                    a(cKeyCodeFromString2, i513, i515, objArr117);
                                                    String str39 = (String) objArr117[0];
                                                    int i516 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                    char c25 = (char) ((i516 ^ 59595) + ((59595 & i516) << 1));
                                                    int iMyTid2 = Process.myTid() >> 22;
                                                    Object[] objArr118 = new Object[1];
                                                    a(c25, ((iMyTid2 | 589) << 1) - (iMyTid2 ^ 589), 6 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr118);
                                                    String[] strArr14 = {str39, (String) objArr118[0]};
                                                    int iIndexOf10 = TextUtils.indexOf((CharSequence) str11, '0', 0, 0);
                                                    int i517 = (iIndexOf10 * (-183)) + 185;
                                                    int i518 = ~iIndexOf10;
                                                    int i519 = -(-(((i518 ^ 1) | (i518 & 1)) * (-368)));
                                                    int i520 = ((i517 | i519) << 1) - (i517 ^ i519);
                                                    int i521 = iIndexOf10 | (-2);
                                                    int i522 = ((i521 & i24) | (i521 ^ i24)) * SyslogConstants.LOG_LOCAL7;
                                                    int i523 = (i520 ^ i522) + ((i522 & i520) << 1);
                                                    int i524 = (~((i518 ^ (-2)) | (i518 & (-2)))) | (~((i24 ^ iIndexOf10) | (i24 & iIndexOf10)));
                                                    int i525 = ~((iIndexOf10 & 1) | (iIndexOf10 ^ 1));
                                                    int i526 = -(-(((i524 & i525) | (i524 ^ i525)) * SyslogConstants.LOG_LOCAL7));
                                                    int i527 = -TextUtils.getTrimmedLength(str11);
                                                    Object[] objArr119 = new Object[1];
                                                    a((char) ((i523 & i526) + (i526 | i523)), (i527 & 1863) + (i527 | 1863), 27 - (~(-(ViewConfiguration.getScrollDefaultDelay() >> 16))), objArr119);
                                                    String str40 = (String) objArr119[0];
                                                    int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                                                    int i528 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                    int i529 = (i528 & 1841) + (i528 | 1841);
                                                    c2 = 0;
                                                    Object[] objArr120 = new Object[1];
                                                    a((char) ((fadingEdgeLength & 30452) + (fadingEdgeLength | 30452)), i529, 10 - KeyEvent.getDeadChar(0, 0), objArr120);
                                                    strArr = new String[][]{strArr11, strArr12, strArr13, strArr14, new String[]{str40, (String) objArr120[0]}};
                                                    i25 = 0;
                                                    i26 = 5;
                                                    i27 = -1;
                                                    loop5: while (true) {
                                                        if (i25 < i26) {
                                                            i28 = i23;
                                                            str12 = str11;
                                                            i29 = i28;
                                                            break;
                                                        }
                                                        String[] strArr15 = strArr[i25];
                                                        str14 = strArr15[c2];
                                                        i37 = 1;
                                                        strArr2 = (String[]) Arrays.copyOfRange(strArr15, 1, strArr15.length);
                                                        length = strArr2.length;
                                                        i38 = 0;
                                                        while (i38 < length) {
                                                            int i530 = ((i27 | 26) << i37) - (i27 ^ 26);
                                                            i39 = (i530 & (-25)) + (i530 | (-25));
                                                            Object[] objArr121 = {str14, strArr2[i38]};
                                                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                                            if (objAccessartificialFrame5 == null) {
                                                                int i531 = 32 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                                char cIndexOf3 = (char) (57021 - TextUtils.indexOf((CharSequence) str11, '0'));
                                                                int iIndexOf11 = TextUtils.indexOf((CharSequence) str11, '0') + 2312;
                                                                byte b25 = (byte) ($$b & 15);
                                                                byte b26 = $$a[18];
                                                                Object[] objArr122 = new Object[1];
                                                                b(b25, b26, (byte) (b26 | Ascii.RS), objArr122);
                                                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i531, cIndexOf3, iIndexOf11, 1412547569, false, (String) objArr122[0], new Class[]{String.class, String.class});
                                                            }
                                                            long jLongValue13 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr121)).longValue();
                                                            long j85 = 1266610653;
                                                            str12 = str11;
                                                            i40 = i25;
                                                            long j86 = j85 ^ j;
                                                            long startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                                            long j87 = (((long) 236) * j85) + (((long) 471) * jLongValue13) + (((long) (-235)) * (jLongValue13 | ((j86 | (startElapsedRealtime2 ^ j)) ^ j))) + (((long) (-470)) * (jLongValue13 | ((j86 | startElapsedRealtime2) ^ j))) + (((long) 235) * (((startElapsedRealtime2 | (j86 | jLongValue13)) ^ j) | (((jLongValue13 ^ j) | j85) ^ j))) + ((long) (-1421362282));
                                                            int iMyUid2 = Process.myUid();
                                                            int i532 = ~(953307446 | (~iMyUid2));
                                                            i41 = ((int) (j87 >> 32)) & (((139460640 | i532 | (~((-953307447) | iMyUid2))) * (-338)) + 1330282474 + (((~(iMyUid2 | (-813846807))) | i532) * 338));
                                                            int iNextInt4 = new Random().nextInt(987821251);
                                                            i42 = ((int) j87) & (((818885255 + (((~iNextInt4) | 845171328) * 1324)) + (((~(iNextInt4 | 2002804609)) | (~(854936276 | iNextInt4))) * (-1324))) - 276485682);
                                                            if (((i41 & i42) | (i41 ^ i42)) != 0) {
                                                                int i533 = (i39 ^ 170) + ((i39 & 170) << 1);
                                                                i28 = i;
                                                                i29 = (i533 | i28) & (~(i28 & i533));
                                                                break loop5;
                                                            }
                                                            i27 = i39;
                                                            i38 = ((i38 | 1) << 1) - (i38 ^ 1);
                                                            i23 = i;
                                                            i25 = i40;
                                                            strArr2 = strArr2;
                                                            strArr = strArr;
                                                            str14 = str14;
                                                            length = length;
                                                            str11 = str12;
                                                            i37 = 1;
                                                        }
                                                        i26 = 5;
                                                        c2 = 0;
                                                        i25++;
                                                        strArr = strArr;
                                                    }
                                                    if (i29 != i28) {
                                                        Object[] objArr123 = {null, new int[1], null, new int[]{i28}, new int[]{i29}};
                                                        int iMaxMemory4 = (int) Runtime.getRuntime().maxMemory();
                                                        int i534 = (-845494969) + (((~((~iMaxMemory4) | (-461662274))) | (~((-1185559) | iMaxMemory4))) * (-302)) + ((~((-461662274) | iMaxMemory4)) * (-604)) + (((~(iMaxMemory4 | (-462847832))) | (-1069481848)) * 302);
                                                        int i535 = (i3 - (~(-(-(((i534 | 16) << 1) - (i534 ^ 16)))))) - 1;
                                                        int i536 = i535 ^ (i535 << 13);
                                                        int i537 = i536 >>> 17;
                                                        int i538 = ((~i536) & i537) | ((~i537) & i536);
                                                        ((int[]) objArr123[1])[0] = i538 ^ (i538 << 5);
                                                        return objArr123;
                                                    }
                                                    try {
                                                        char c26 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                        int i539 = -(-View.resolveSizeAndState(0, 0, 0));
                                                        Object[] objArr124 = new Object[1];
                                                        a(c26, (i539 ^ 1891) + ((i539 & 1891) << 1), 12 - (~View.MeasureSpec.makeMeasureSpec(0, 0)), objArr124);
                                                        String str41 = (String) objArr124[0];
                                                        char c27 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                                                        int i540 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                        int i541 = (i540 & 1905) + (i540 | 1905);
                                                        int i542 = -ExpandableListView.getPackedPositionChild(0L);
                                                        Object[] objArr125 = new Object[1];
                                                        a(c27, i541, (i542 & 7) + (i542 | 7), objArr125);
                                                        str13 = (String) objArr125[0];
                                                        file = new File(str41);
                                                        if (file.exists() && file.isFile()) {
                                                            try {
                                                                Scanner scanner4 = new Scanner(new FileInputStream(file));
                                                                char maximumDrawingCacheSize = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                                int i543 = -View.resolveSizeAndState(0, 0, 0);
                                                                Object[] objArr126 = new Object[1];
                                                                a(maximumDrawingCacheSize, ((i543 | 229) << 1) - (i543 ^ 229), 3 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr126);
                                                                scannerUseDelimiter = scanner4.useDelimiter((String) objArr126[0]);
                                                                if (scannerUseDelimiter.hasNext()) {
                                                                    next = scannerUseDelimiter.next();
                                                                } else {
                                                                    next = str12;
                                                                }
                                                                scannerUseDelimiter.close();
                                                                if (next.contains(str13)) {
                                                                    i31 = i28 & (-151);
                                                                    i30 = i24;
                                                                    i32 = i30 & 150;
                                                                    i33 = i31 | i32;
                                                                }
                                                            } catch (IOException unused5) {
                                                            }
                                                            if (i33 != i28) {
                                                                int i544 = artificialFrame;
                                                                int i545 = (i544 & 97) + (i544 | 97);
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i545 % 128;
                                                                int i546 = i545 % 2;
                                                                Object[] objArr127 = {null, new int[]{i ^ (i << 5)}, null, new int[]{i28}, new int[]{i33}};
                                                                int i547 = ((((~(i28 | 269495339)) | (-607566111)) * 398) - 1974962091) + (((~(269495339 | i30)) | (-607566111)) * 398);
                                                                int i548 = (i547 ^ 16) + ((i547 & 16) << 1);
                                                                int i549 = ((i3 | i548) << 1) - (i3 ^ i548);
                                                                int i550 = i549 << 13;
                                                                int i551 = (i550 & (~i549)) | ((~i550) & i549);
                                                                int i552 = i551 >>> 17;
                                                                int i553 = (i551 | i552) & (~(i551 & i552));
                                                                return objArr127;
                                                            }
                                                            char c28 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                            int i554 = 1910 - (~(-TextUtils.lastIndexOf(str12, '0', 0)));
                                                            int i555 = -ExpandableListView.getPackedPositionType(0L);
                                                            int iArtificialStackFrames7 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                            int i556 = ~i555;
                                                            int i557 = ~((i556 & (-48)) | (i556 ^ (-48)));
                                                            int i558 = ~iArtificialStackFrames7;
                                                            int i559 = i557 | (~((i558 & (-48)) | ((-48) ^ i558)));
                                                            int i560 = (i555 ^ 47) | (i555 & 47);
                                                            int i561 = (i560 ^ iArtificialStackFrames7) | (i560 & iArtificialStackFrames7);
                                                            int i562 = ~i561;
                                                            int i563 = (((i555 * 253) + 11891) - (~(((i559 & i562) | (i559 ^ i562)) * (-252)))) - 1;
                                                            int i564 = i560 * (-252);
                                                            int i565 = ~iArtificialStackFrames7;
                                                            int i566 = (i565 & (-48)) | ((-48) ^ i565);
                                                            int i567 = (((i563 & i564) + (i563 | i564)) - (~(-(-(((~((i555 & i566) | (i566 ^ i555))) | (~i561)) * 252))))) - 1;
                                                            Object[] objArr128 = new Object[1];
                                                            a(c28, i554, i567, objArr128);
                                                            Object[] objArr129 = {(String) objArr128[0]};
                                                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(267846469);
                                                            if (objAccessartificialFrame4 == null) {
                                                                int i568 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 17;
                                                                char bitsPerPixel2 = (char) (ImageFormat.getBitsPerPixel(0) + 24344);
                                                                int i569 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2014;
                                                                byte[] bArr19 = $$a;
                                                                byte b27 = (byte) (-bArr19[7]);
                                                                byte b28 = bArr19[10];
                                                                Object[] objArr130 = new Object[1];
                                                                b(b27, b28, (byte) (b28 | 38), objArr130);
                                                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i568, bitsPerPixel2, i569, -1869462195, false, (String) objArr130[0], new Class[]{String.class});
                                                            }
                                                            long jLongValue14 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr129)).longValue();
                                                            long j88 = 186920542;
                                                            long j89 = (((long) 465) * j88) + (((long) (-463)) * jLongValue14);
                                                            long j90 = 464;
                                                            long j91 = jLongValue14 ^ j;
                                                            long jMyPid3 = Process.myPid();
                                                            long j92 = jMyPid3 ^ j;
                                                            long j93 = (j91 | j88) ^ j;
                                                            long j94 = j89 + ((((j91 | j92) ^ j) | j93 | ((j92 | j88) ^ j)) * j90) + (((long) (-464)) * (jMyPid3 | (j88 ^ j) | j91)) + (j90 * (j93 | ((j88 | jMyPid3) ^ j))) + ((long) (-1498552518));
                                                            int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                                                            int i570 = ((int) (j94 >> 32)) & ((-101607734) + (((~((-1455691853) | (~iElapsedRealtime3))) | (~((-18465442) | iElapsedRealtime3))) * (-272)) + (((~((-2129018191) | iElapsedRealtime3)) | 673326338) * (-272)) + (((~(iElapsedRealtime3 | 2129018190)) | (-691791780)) * 272));
                                                            int elapsedCpuTime5 = (int) Process.getElapsedCpuTime();
                                                            int i571 = ~((-1181388841) | elapsedCpuTime5);
                                                            int i572 = (-2012598375) + ((67141632 | i571) * (-280)) + ((i571 | (~((-1676352046) | elapsedCpuTime5))) * 140);
                                                            int i573 = ~((-1114247209) | elapsedCpuTime5);
                                                            int i574 = ~elapsedCpuTime5;
                                                            int i575 = ((int) j94) & (i572 + (((~(i574 | (-562104838))) | i573 | (~((-67141633) | i574))) * 140));
                                                            int i576 = ((i570 & i575) | (i570 ^ i575)) * 263;
                                                            i34 = (i576 & i30) | ((~i576) & i);
                                                            if (i34 != i) {
                                                                objArr3 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i34}};
                                                                int i577 = (int) Runtime.getRuntime().totalMemory();
                                                                int i578 = 728361708 + ((~((-67246083) | i577)) * (-301)) + (((~(132275923 | i577)) | (~((~i577) | 737724381))) * (-301)) + (((~(i577 | (-737724382))) | 132275923) * 301);
                                                                int i579 = i3 + (i578 & 16) + (i578 | 16);
                                                                int i580 = i579 << 13;
                                                                int i581 = ((~i579) & i580) | ((~i580) & i579);
                                                                int i582 = i581 >>> 17;
                                                                int i583 = ((~i581) & i582) | ((~i582) & i581);
                                                                int i584 = i583 << 5;
                                                                ((int[]) objArr3[1])[0] = (i583 | i584) & (~(i583 & i584));
                                                            } else {
                                                                int[] iArr2 = new int[1];
                                                                objArr2 = new Object[]{null, iArr2, null, new int[]{i}, new int[]{i}};
                                                                int i585 = -(-((-1013288380) + (((~((-9541173) | i30)) | (-595907286)) * (-933)) + (((~(i30 | (-595907286))) | 587481281) * 933) + 1323798898));
                                                                int i586 = ((i3 | i585) << 1) - (i3 ^ i585);
                                                                int i587 = i586 << 13;
                                                                int i588 = (i587 | i586) & (~(i586 & i587));
                                                                int i589 = i588 >>> 17;
                                                                int i590 = (i588 | i589) & (~(i588 & i589));
                                                                int i591 = i590 << 5;
                                                                i35 = ((~i590) & i591) | ((~i591) & i590);
                                                                i36 = artificialFrame + 1;
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i36 % 128;
                                                                iArr = iArr2;
                                                                if (i36 % 2 != 0) {
                                                                    iArr[1] = i35;
                                                                } else {
                                                                    iArr[0] = i35;
                                                                }
                                                            }
                                                        }
                                                        i30 = i24;
                                                        i33 = i28;
                                                    } catch (Exception unused6) {
                                                        i30 = i24;
                                                        i31 = i28 & (-152);
                                                        i32 = i30 & 151;
                                                    }
                                                    if (i33 != i28) {
                                                        int i5410 = artificialFrame;
                                                        int i5411 = (i5410 & 97) + (i5410 | 97);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i5411 % 128;
                                                        int i5412 = i5411 % 2;
                                                        Object[] objArr1210 = {null, new int[]{i553 ^ (i553 << 5)}, null, new int[]{i28}, new int[]{i33}};
                                                        int i5413 = ((((~(i28 | 269495339)) | (-607566111)) * 398) - 1974962091) + (((~(269495339 | i30)) | (-607566111)) * 398);
                                                        int i5414 = (i5413 ^ 16) + ((i5413 & 16) << 1);
                                                        int i5415 = ((i3 | i5414) << 1) - (i3 ^ i5414);
                                                        int i5510 = i5415 << 13;
                                                        int i5511 = (i5510 & (~i5415)) | ((~i5510) & i5415);
                                                        int i5512 = i5511 >>> 17;
                                                        int i5513 = (i5511 | i5512) & (~(i5511 & i5512));
                                                        return objArr1210;
                                                    }
                                                    char c29 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                    int i5514 = 1910 - (~(-TextUtils.lastIndexOf(str12, '0', 0)));
                                                    int i5515 = -ExpandableListView.getPackedPositionType(0L);
                                                    int iArtificialStackFrames8 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                    int i5516 = ~i5515;
                                                    int i5517 = ~((i5516 & (-48)) | (i5516 ^ (-48)));
                                                    int i5518 = ~iArtificialStackFrames8;
                                                    int i5519 = i5517 | (~((i5518 & (-48)) | ((-48) ^ i5518)));
                                                    int i5610 = (i5515 ^ 47) | (i5515 & 47);
                                                    int i5611 = (i5610 ^ iArtificialStackFrames8) | (i5610 & iArtificialStackFrames8);
                                                    int i5612 = ~i5611;
                                                    int i5613 = (((i5515 * 253) + 11891) - (~(((i5519 & i5612) | (i5519 ^ i5612)) * (-252)))) - 1;
                                                    int i5614 = i5610 * (-252);
                                                    int i5615 = ~iArtificialStackFrames8;
                                                    int i5616 = (i5615 & (-48)) | ((-48) ^ i5615);
                                                    int i5617 = (((i5613 & i5614) + (i5613 | i5614)) - (~(-(-(((~((i5515 & i5616) | (i5616 ^ i5515))) | (~i5611)) * 252))))) - 1;
                                                    Object[] objArr1211 = new Object[1];
                                                    a(c29, i5514, i5617, objArr1211);
                                                    Object[] objArr1212 = {(String) objArr1211[0]};
                                                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(267846469);
                                                    if (objAccessartificialFrame4 == null) {
                                                        int i5618 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 17;
                                                        char bitsPerPixel3 = (char) (ImageFormat.getBitsPerPixel(0) + 24344);
                                                        int i5619 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2014;
                                                        byte[] bArr110 = $$a;
                                                        byte b29 = (byte) (-bArr110[7]);
                                                        byte b210 = bArr110[10];
                                                        Object[] objArr131 = new Object[1];
                                                        b(b29, b210, (byte) (b210 | 38), objArr131);
                                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i5618, bitsPerPixel3, i5619, -1869462195, false, (String) objArr131[0], new Class[]{String.class});
                                                    }
                                                    long jLongValue15 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr1212)).longValue();
                                                    long j810 = 186920542;
                                                    long j811 = (((long) 465) * j810) + (((long) (-463)) * jLongValue15);
                                                    long j95 = 464;
                                                    long j96 = jLongValue15 ^ j;
                                                    long jMyPid4 = Process.myPid();
                                                    long j97 = jMyPid4 ^ j;
                                                    long j98 = (j96 | j810) ^ j;
                                                    long j99 = j811 + ((((j96 | j97) ^ j) | j98 | ((j97 | j810) ^ j)) * j95) + (((long) (-464)) * (jMyPid4 | (j810 ^ j) | j96)) + (j95 * (j98 | ((j810 | jMyPid4) ^ j))) + ((long) (-1498552518));
                                                    int iElapsedRealtime4 = (int) SystemClock.elapsedRealtime();
                                                    int i5710 = ((int) (j99 >> 32)) & ((-101607734) + (((~((-1455691853) | (~iElapsedRealtime4))) | (~((-18465442) | iElapsedRealtime4))) * (-272)) + (((~((-2129018191) | iElapsedRealtime4)) | 673326338) * (-272)) + (((~(iElapsedRealtime4 | 2129018190)) | (-691791780)) * 272));
                                                    int elapsedCpuTime6 = (int) Process.getElapsedCpuTime();
                                                    int i5711 = ~((-1181388841) | elapsedCpuTime6);
                                                    int i5712 = (-2012598375) + ((67141632 | i5711) * (-280)) + ((i5711 | (~((-1676352046) | elapsedCpuTime6))) * 140);
                                                    int i5713 = ~((-1114247209) | elapsedCpuTime6);
                                                    int i5714 = ~elapsedCpuTime6;
                                                    int i5715 = ((int) j99) & (i5712 + (((~(i5714 | (-562104838))) | i5713 | (~((-67141633) | i5714))) * 140));
                                                    int i5716 = ((i5710 & i5715) | (i5710 ^ i5715)) * 263;
                                                    i34 = (i5716 & i30) | ((~i5716) & i);
                                                    if (i34 != i) {
                                                        objArr3 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i34}};
                                                        int i5717 = (int) Runtime.getRuntime().totalMemory();
                                                        int i5718 = 728361708 + ((~((-67246083) | i5717)) * (-301)) + (((~(132275923 | i5717)) | (~((~i5717) | 737724381))) * (-301)) + (((~(i5717 | (-737724382))) | 132275923) * 301);
                                                        int i5719 = i3 + (i5718 & 16) + (i5718 | 16);
                                                        int i5810 = i5719 << 13;
                                                        int i5811 = ((~i5719) & i5810) | ((~i5810) & i5719);
                                                        int i5812 = i5811 >>> 17;
                                                        int i5813 = ((~i5811) & i5812) | ((~i5812) & i5811);
                                                        int i5814 = i5813 << 5;
                                                        ((int[]) objArr3[1])[0] = (i5813 | i5814) & (~(i5813 & i5814));
                                                    } else {
                                                        int[] iArr3 = new int[1];
                                                        objArr2 = new Object[]{null, iArr3, null, new int[]{i}, new int[]{i}};
                                                        int i5815 = -(-((-1013288380) + (((~((-9541173) | i30)) | (-595907286)) * (-933)) + (((~(i30 | (-595907286))) | 587481281) * 933) + 1323798898));
                                                        int i5816 = ((i3 | i5815) << 1) - (i3 ^ i5815);
                                                        int i5817 = i5816 << 13;
                                                        int i5818 = (i5817 | i5816) & (~(i5816 & i5817));
                                                        int i5819 = i5818 >>> 17;
                                                        int i592 = (i5818 | i5819) & (~(i5818 & i5819));
                                                        int i593 = i592 << 5;
                                                        i35 = ((~i592) & i593) | ((~i593) & i592);
                                                        i36 = artificialFrame + 1;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i36 % 128;
                                                        iArr = iArr3;
                                                        if (i36 % 2 != 0) {
                                                            iArr[1] = i35;
                                                        } else {
                                                            iArr[0] = i35;
                                                        }
                                                    }
                                                }
                                                int i594 = -Drawable.resolveOpacity(0, 0);
                                                Object[] objArr132 = new Object[1];
                                                a((char) ((i594 ^ 23374) + ((i594 & 23374) << 1)), 372 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) + 23, objArr132);
                                                String str42 = (String) objArr132[0];
                                                Object[] objArr133 = new Object[1];
                                                a((char) (54882 - TextUtils.indexOf(str6, str6, 0, 0)), 616 - (~ExpandableListView.getPackedPositionType(0L)), 10 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0', 0)))), objArr133);
                                                String str43 = (String) objArr133[0];
                                                int i595 = -TextUtils.lastIndexOf(str6, '0', 0, 0);
                                                Object[] objArr134 = new Object[1];
                                                a((char) ((i595 & 43589) + (i595 | 43589)), 627 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), Gravity.getAbsoluteGravity(0, 0) + 7, objArr134);
                                                String str44 = (String) objArr134[0];
                                                char c30 = (char) (35759 - (~(-Drawable.resolveOpacity(0, 0))));
                                                int i596 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                                int iArgb2 = Color.argb(0, 0, 0, 0);
                                                int i597 = (iArgb2 ^ 8) + ((iArgb2 & 8) << 1);
                                                Object[] objArr135 = new Object[1];
                                                a(c30, (i596 & 635) + (i596 | 635), i597, objArr135);
                                                String[] strArr16 = {str42, str43, str44, (String) objArr135[0]};
                                                char keyRepeatTimeout4 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                int i598 = 641 - (~(-(-(ViewConfiguration.getScrollDefaultDelay() >> 16))));
                                                int offsetBefore3 = TextUtils.getOffsetBefore(str6, 0);
                                                int i599 = ((offsetBefore3 | 17) << 1) - (offsetBefore3 ^ 17);
                                                Object[] objArr136 = new Object[1];
                                                a(keyRepeatTimeout4, i598, i599, objArr136);
                                                String str45 = (String) objArr136[0];
                                                char c31 = (char) (44627 - (~(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))));
                                                int iMyTid3 = Process.myTid() >> 22;
                                                int i600 = (iMyTid3 ^ 659) + ((iMyTid3 & 659) << 1);
                                                int i601 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                                int i602 = (i601 ^ 7) + ((i601 & 7) << 1);
                                                Object[] objArr137 = new Object[1];
                                                a(c31, i600, i602, objArr137);
                                                String str46 = (String) objArr137[0];
                                                Object[] objArr138 = new Object[1];
                                                a((char) (4298 - (~(-(KeyEvent.getMaxKeyCode() >> 16)))), 665 - (~(-(-View.resolveSizeAndState(0, 0, 0)))), 7 - TextUtils.getTrimmedLength(str6), objArr138);
                                                String str47 = (String) objArr138[0];
                                                int i603 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                int i604 = -TextUtils.indexOf((CharSequence) str6, '0');
                                                int iArtificialStackFrames9 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                int i605 = (i604 * (-589)) - (-397152);
                                                int i606 = ~iArtificialStackFrames9;
                                                int i607 = ~(((-673) ^ i606) | ((-673) & i606));
                                                int i608 = ~(((-673) ^ i604) | ((-673) & i604));
                                                int i609 = (i607 ^ i608) | (i607 & i608);
                                                int i610 = ~((i606 ^ i604) | (i606 & i604));
                                                int i611 = (i609 & i610) | (i609 ^ i610);
                                                int i612 = ~i604;
                                                int i613 = (i612 & 672) | (i612 ^ 672);
                                                int i614 = ~((i613 & iArtificialStackFrames9) | (i613 ^ iArtificialStackFrames9));
                                                int i615 = -(-(((i611 & i614) | (i611 ^ i614)) * 590));
                                                int i616 = ((i605 | i615) << 1) - (i615 ^ i605);
                                                int i617 = ~(((-673) & i606) | ((-673) ^ i606));
                                                int i618 = (i617 & i608) | (i617 ^ i608);
                                                int i619 = ~iArtificialStackFrames9;
                                                int i620 = ~(i619 | i604);
                                                int i621 = ((i618 & i620) | (i618 ^ i620)) * (-1180);
                                                int i622 = (i616 ^ i621) + ((i621 & i616) << 1);
                                                int i623 = ~i604;
                                                int i624 = ~((i623 & i619) | (i623 ^ i619));
                                                int i625 = ~(i606 | 672);
                                                int i626 = i622 + (((i624 & i625) | (i624 ^ i625)) * 590);
                                                int i627 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                int iArtificialStackFrames10 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                int i628 = ~((~i627) | (-11));
                                                int i629 = ~((-11) | iArtificialStackFrames10);
                                                int i630 = ((i627 * (-103)) - 1030) + (((i628 & i629) | (i628 ^ i629)) * 104);
                                                int i631 = ~iArtificialStackFrames10;
                                                int i632 = (i631 & i627) | (i631 ^ i627);
                                                int i633 = -(-((~((i632 & 10) | (i632 ^ 10))) * (-104)));
                                                int i634 = (i630 & i633) + (i630 | i633);
                                                int i635 = ((i627 & iArtificialStackFrames10) | (i627 ^ iArtificialStackFrames10)) * 104;
                                                Object[] objArr139 = new Object[1];
                                                a((char) ((i603 & 47962) + (i603 | 47962)), i626, (i634 & i635) + (i635 | i634), objArr139);
                                                String str48 = (String) objArr139[0];
                                                Object[] objArr140 = new Object[1];
                                                a((char) View.MeasureSpec.getMode(0), (-16776533) - (~(-Color.rgb(0, 0, 0))), 14 - TextUtils.getCapsMode(str6, 0, 0), objArr140);
                                                String[] strArr17 = {str45, str46, str47, str48, (String) objArr140[0]};
                                                char packedPositionType2 = (char) (ExpandableListView.getPackedPositionType(0L) + 58073);
                                                int i636 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                                                Object[] objArr141 = new Object[1];
                                                a(packedPositionType2, (i636 & 697) + (i636 | 697), 16 - (ViewConfiguration.getTouchSlop() >> 8), objArr141);
                                                String str49 = (String) objArr141[0];
                                                char c32 = (char) (29286 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                                int i637 = 712 - (~(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0)));
                                                int i638 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                                Object[] objArr142 = new Object[1];
                                                a(c32, i637, (i638 & 2) + (i638 | 2), objArr142);
                                                String str50 = (String) objArr142[0];
                                                char cIndexOf4 = (char) (30135 - TextUtils.indexOf(str6, str6));
                                                int i639 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                                                int i640 = (i639 & 724) + (i639 | 724);
                                                int i641 = -View.MeasureSpec.getMode(0);
                                                int i642 = ((i641 | 22) << 1) - (i641 ^ 22);
                                                Object[] objArr143 = new Object[1];
                                                a(cIndexOf4, i640, i642, objArr143);
                                                String str51 = (String) objArr143[0];
                                                int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0);
                                                int i643 = -TextUtils.getOffsetBefore(str6, 0);
                                                int i644 = (i643 * (-830)) - (-621504);
                                                int i645 = (i643 ^ 747) | (i643 & 747);
                                                int i646 = ((~(((-748) ^ i279) | ((-748) & i279))) | (~((i645 & i351) | (i645 ^ i351)))) * (-831);
                                                int i647 = ((i644 | i646) << 1) - (i644 ^ i646);
                                                int i648 = ((-748) ^ i643) | ((-748) & i643);
                                                int i649 = -(-((~((i648 & i351) | (i648 ^ i351))) * (-1662)));
                                                int i650 = ((i647 | i649) << 1) - (i649 ^ i647);
                                                int i651 = ~i643;
                                                int i652 = ~((i651 & i279) | (i651 ^ i279));
                                                int i653 = ~((i643 & i351) | (i643 ^ i351));
                                                int i654 = (i653 & i652) | (i652 ^ i653);
                                                int i655 = ~((i351 ^ 747) | (i351 & 747));
                                                int i656 = -(-(((i654 & i655) | (i654 ^ i655)) * 831));
                                                int i657 = ((i650 | i656) << 1) - (i656 ^ i650);
                                                int i658 = -(-TextUtils.getOffsetAfter(str6, 0));
                                                int i659 = (i658 ^ 25) + ((i658 & 25) << 1);
                                                Object[] objArr144 = new Object[1];
                                                a((char) ((bitsPerPixel4 ^ 1) + ((bitsPerPixel4 & 1) << 1)), i657, i659, objArr144);
                                                String str52 = (String) objArr144[0];
                                                int i660 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                                int iLastIndexOf6 = TextUtils.lastIndexOf(str6, '0', 0, 0);
                                                Object[] objArr145 = new Object[1];
                                                a((char) ((i660 ^ 26034) + ((i660 & 26034) << 1)), (iLastIndexOf6 ^ 773) + ((iLastIndexOf6 & 773) << 1), 28 - TextUtils.indexOf(str6, str6, 0, 0), objArr145);
                                                j = j22;
                                                String[] strArr18 = {str49, str50, str2, str51, str52, (String) objArr145[0]};
                                                Object[] objArr146 = new Object[1];
                                                a((char) (47133 - (Process.myPid() >> 22)), TextUtils.indexOf(str6, str6) + LogSeverity.EMERGENCY_VALUE, 10 - (~ExpandableListView.getPackedPositionType(0L)), objArr146);
                                                String str53 = (String) objArr146[0];
                                                int i661 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                                                int i662 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                                Object[] objArr147 = new Object[1];
                                                a((char) ((i661 ^ 58987) + ((i661 & 58987) << 1)), (i662 & 811) + (i662 | 811), 7 - (~(-(-(ViewConfiguration.getKeyRepeatDelay() >> 16)))), objArr147);
                                                String str54 = (String) objArr147[0];
                                                int i663 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                                                int i664 = -ExpandableListView.getPackedPositionGroup(0L);
                                                Object[] objArr148 = new Object[1];
                                                a((char) ((i663 ^ 52001) + ((i663 & 52001) << 1)), ((i664 | 819) << 1) - (i664 ^ 819), View.combineMeasuredStates(0, 0) + 6, objArr148);
                                                String str55 = (String) objArr148[0];
                                                char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                                                int i665 = -ExpandableListView.getPackedPositionChild(0L);
                                                int i666 = (i665 & 824) + (i665 | 824);
                                                int i667 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0));
                                                j2 = j26;
                                                Object[] objArr149 = new Object[1];
                                                a(cResolveOpacity, i666, (i667 & 7) + (i667 | 7), objArr149);
                                                String[] strArr19 = {str53, str54, str55, (String) objArr149[0]};
                                                Object[] objArr150 = new Object[1];
                                                a((char) (ExpandableListView.getPackedPositionGroup(0L) + 16279), 830 - (~(-(-Color.green(0)))), 15 - (~(ViewConfiguration.getTapTimeout() >> 16)), objArr150);
                                                String str56 = (String) objArr150[0];
                                                int i668 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                Object[] objArr151 = new Object[1];
                                                a((char) (((i668 | 4299) << 1) - (i668 ^ 4299)), (Process.myPid() >> 22) + 666, 7 - (KeyEvent.getMaxKeyCode() >> 16), objArr151);
                                                String str57 = (String) objArr151[0];
                                                int threadPriority3 = Process.getThreadPriority(0);
                                                char c33 = (char) (35759 - (~(-(((threadPriority3 ^ 20) + ((threadPriority3 & 20) << 1)) >> 6))));
                                                int i669 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                int i670 = ((i669 | 635) << 1) - (i669 ^ 635);
                                                int i671 = -TextUtils.indexOf((CharSequence) str6, '0');
                                                int i672 = (i671 & 7) + (i671 | 7);
                                                Object[] objArr152 = new Object[1];
                                                a(c33, i670, i672, objArr152);
                                                String[] strArr20 = {str56, str57, (String) objArr152[0]};
                                                char c34 = (char) (0 - (~(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)))));
                                                int i673 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                Object[] objArr153 = new Object[1];
                                                a(c34, (i673 ^ 847) + ((i673 & 847) << 1), 12 - (~(-((byte) KeyEvent.getModifierMetaStateMask()))), objArr153);
                                                String str58 = (String) objArr153[0];
                                                int i674 = -KeyEvent.normalizeMetaState(0);
                                                Object[] objArr154 = new Object[1];
                                                a((char) ((i674 ^ 45819) + ((i674 & 45819) << 1)), 861 - ((Process.getThreadPriority(0) + 20) >> 6), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr154);
                                                String[] strArr21 = {str58, (String) objArr154[0]};
                                                Object[] objArr155 = new Object[1];
                                                a((char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 51264), TextUtils.indexOf(str6, str6, 0, 0) + 862, 7 - (~(-(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))), objArr155);
                                                String str59 = (String) objArr155[0];
                                                int i675 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                Object[] objArr156 = new Object[1];
                                                a((char) ((i675 ^ 51062) + ((i675 & 51062) << 1)), 870 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))), -TextUtils.indexOf((CharSequence) str6, '0', 0), objArr156);
                                                String[] strArr22 = {str59, (String) objArr156[0]};
                                                Object[] objArr157 = new Object[1];
                                                a((char) (29763 - (~(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))), 871 - (~(-View.MeasureSpec.getSize(0))), 16 - (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr157);
                                                String str60 = (String) objArr157[0];
                                                char c35 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29284);
                                                int i676 = 713 - (~(-View.MeasureSpec.getMode(0)));
                                                int i677 = -(-(Process.myTid() >> 22));
                                                int i678 = (i677 ^ 3) + ((i677 & 3) << 1);
                                                Object[] objArr158 = new Object[1];
                                                a(c35, i676, i678, objArr158);
                                                String str61 = (String) objArr158[0];
                                                int i679 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                int i680 = -KeyEvent.keyCodeFromString(str6);
                                                Object[] objArr159 = new Object[1];
                                                a((char) ((i679 ^ 44628) + ((i679 & 44628) << 1)), (i680 ^ 659) + ((i680 & 659) << 1), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 6, objArr159);
                                                String str62 = (String) objArr159[0];
                                                char c36 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                                                int i681 = -AndroidCharacter.getMirror('0');
                                                int i682 = (i681 ^ 936) + ((i681 & 936) << 1);
                                                int i683 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                int i684 = (i683 ^ 8) + ((i683 & 8) << 1);
                                                Object[] objArr160 = new Object[1];
                                                a(c36, i682, i684, objArr160);
                                                String str63 = (String) objArr160[0];
                                                char c37 = (char) (47960 - (~(-Color.argb(0, 0, 0, 0))));
                                                int i685 = -(-Process.getGidForName(str6));
                                                Object[] objArr161 = new Object[1];
                                                a(c37, ((i685 | 674) << 1) - (i685 ^ 674), (Process.myTid() >> 22) + 11, objArr161);
                                                String str64 = (String) objArr161[0];
                                                char maximumFlingVelocity3 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                int i686 = -Color.alpha(0);
                                                Object[] objArr162 = new Object[1];
                                                a(maximumFlingVelocity3, (i686 ^ 684) + ((i686 & 684) << 1), ExpandableListView.getPackedPositionType(0L) + 14, objArr162);
                                                String[] strArr23 = {str60, str61, str62, str63, str64, (String) objArr162[0]};
                                                char cRed2 = (char) Color.red(0);
                                                int i687 = -(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                                                int i688 = ((i687 | 896) << 1) - (i687 ^ 896);
                                                int i689 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                int i690 = ((i689 | 20) << 1) - (i689 ^ 20);
                                                Object[] objArr163 = new Object[1];
                                                a(cRed2, i688, i690, objArr163);
                                                String str65 = (String) objArr163[0];
                                                char c38 = (char) (47356 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0', 0)))));
                                                int i691 = 914 - (~(-ExpandableListView.getPackedPositionChild(0L)));
                                                int i692 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                                                Object[] objArr164 = new Object[1];
                                                a(c38, i691, (i692 & 19) + (i692 | 19), objArr164);
                                                String str66 = (String) objArr164[0];
                                                char c39 = (char) (36606 - (~(-(Process.myPid() >> 22))));
                                                int i693 = 933 - (~(-TextUtils.indexOf((CharSequence) str6, '0')));
                                                int i694 = -ImageFormat.getBitsPerPixel(0);
                                                int i695 = (i694 ^ 30) + ((i694 & 30) << 1);
                                                Object[] objArr165 = new Object[1];
                                                a(c39, i693, i695, objArr165);
                                                String str67 = (String) objArr165[0];
                                                int gidForName4 = Process.getGidForName(str6);
                                                Object[] objArr166 = new Object[1];
                                                a((char) ((gidForName4 ^ 1) + ((gidForName4 & 1) << 1)), 966 - TextUtils.indexOf(str6, str6, 0), 24 - (~(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), objArr166);
                                                String str68 = (String) objArr166[0];
                                                char scrollBarSize3 = (char) (21156 - (ViewConfiguration.getScrollBarSize() >> 8));
                                                int i696 = -(-Color.blue(0));
                                                Object[] objArr167 = new Object[1];
                                                a(scrollBarSize3, ((i696 | 992) << 1) - (i696 ^ 992), (ViewConfiguration.getEdgeSlop() >> 16) + 23, objArr167);
                                                String str69 = (String) objArr167[0];
                                                char packedPositionType3 = (char) ExpandableListView.getPackedPositionType(0L);
                                                int i697 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                int i698 = (i697 & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) + (i697 | PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);
                                                int deadChar3 = KeyEvent.getDeadChar(0, 0);
                                                Object[] objArr168 = new Object[1];
                                                a(packedPositionType3, i698, (deadChar3 & 33) + (deadChar3 | 33), objArr168);
                                                String[] strArr24 = {str65, str66, str67, str68, str69, (String) objArr168[0], str2};
                                                char gidForName5 = (char) (Process.getGidForName(str6) + 1);
                                                int keyRepeatTimeout5 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                                                int i699 = (keyRepeatTimeout5 ^ 1048) + ((keyRepeatTimeout5 & 1048) << 1);
                                                int i700 = -ExpandableListView.getPackedPositionType(0L);
                                                int i701 = (i700 & 13) + (i700 | 13);
                                                Object[] objArr169 = new Object[1];
                                                a(gidForName5, i699, i701, objArr169);
                                                String str70 = (String) objArr169[0];
                                                int i702 = -(-TextUtils.lastIndexOf(str6, '0'));
                                                Object[] objArr170 = new Object[1];
                                                a((char) (((i702 | 43591) << 1) - (i702 ^ 43591)), 626 - (~(-KeyEvent.normalizeMetaState(0))), 6 - (~(ViewConfiguration.getKeyRepeatTimeout() >> 16)), objArr170);
                                                String[] strArr25 = {str70, (String) objArr170[0]};
                                                Object[] objArr171 = new Object[1];
                                                a((char) TextUtils.getOffsetBefore(str6, 0), Color.green(0) + 1061, 29 - ExpandableListView.getPackedPositionChild(0L), objArr171);
                                                String str71 = (String) objArr171[0];
                                                int i703 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                                                int doubleTapTimeout2 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                                                int i704 = doubleTapTimeout2 * (-575);
                                                int i705 = (i704 ^ (-627325)) + ((i704 & (-627325)) << 1);
                                                int i706 = ~doubleTapTimeout2;
                                                int i707 = ~((i706 & (-1092)) | (i706 ^ (-1092)));
                                                int i708 = ~((-1092) | i351);
                                                int i709 = i705 + (((i707 & i708) | (i707 ^ i708)) * 576);
                                                int i710 = ~doubleTapTimeout2;
                                                int i711 = ((-1092) & i279) | ((-1092) ^ i279);
                                                int i712 = (((i709 - (~(-(-(((~((doubleTapTimeout2 & i711) | (i711 ^ doubleTapTimeout2))) | (~(i710 | 1091))) * 576))))) - 1) - (~((~((i710 & (-1092)) | (i710 ^ (-1092)))) * 576))) - 1;
                                                int i713 = -ExpandableListView.getPackedPositionChild(0L);
                                                int i714 = (i713 ^ 10) + ((i713 & 10) << 1);
                                                Object[] objArr172 = new Object[1];
                                                a((char) ((i703 & 22334) + (i703 | 22334)), i712, i714, objArr172);
                                                String[] strArr26 = {str71, (String) objArr172[0]};
                                                char c40 = (char) ((-(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))) - 1);
                                                int i715 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                                                Object[] objArr173 = new Object[1];
                                                a(c40, (i715 ^ 1102) + ((i715 & 1102) << 1), (Process.myPid() >> 22) + 19, objArr173);
                                                String str72 = (String) objArr173[0];
                                                int i716 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                int i717 = 1120 - (~(ViewConfiguration.getKeyRepeatDelay() >> 16));
                                                int i718 = -(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                                                int i719 = (i718 ^ 4) + ((i718 & 4) << 1);
                                                Object[] objArr174 = new Object[1];
                                                a((char) (((i716 | 21851) << 1) - (i716 ^ 21851)), i717, i719, objArr174);
                                                String[] strArr27 = {str72, (String) objArr174[0]};
                                                char touchSlop3 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                                                int i720 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                                                int i721 = (i720 & 1126) + (i720 | 1126);
                                                int i722 = -ExpandableListView.getPackedPositionGroup(0L);
                                                int i723 = (i722 ^ 19) + ((i722 & 19) << 1);
                                                Object[] objArr175 = new Object[1];
                                                a(touchSlop3, i721, i723, objArr175);
                                                String[] strArr28 = {(String) objArr175[0]};
                                                int i724 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                                                int longPressTimeout3 = ViewConfiguration.getLongPressTimeout() >> 16;
                                                Object[] objArr176 = new Object[1];
                                                a((char) ((i724 ^ 1) + ((i724 & 1) << 1)), ((longPressTimeout3 | 1145) << 1) - (longPressTimeout3 ^ 1145), 15 - (~(-(ViewConfiguration.getMaximumFlingVelocity() >> 16))), objArr176);
                                                String[] strArr29 = {(String) objArr176[0]};
                                                Object[] objArr177 = new Object[1];
                                                a((char) (25659 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1160, 18 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))), objArr177);
                                                String[] strArr30 = {(String) objArr177[0]};
                                                Object[] objArr178 = new Object[1];
                                                a((char) ((-2) - (~(-MotionEvent.axisFromString(str6)))), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1180, ImageFormat.getBitsPerPixel(0) + 20, objArr178);
                                                String[] strArr31 = {(String) objArr178[0]};
                                                int bitsPerPixel5 = ImageFormat.getBitsPerPixel(0);
                                                int iMakeMeasureSpec2 = 1199 - View.MeasureSpec.makeMeasureSpec(0, 0);
                                                int i725 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                                int i726 = (i725 ^ 23) + ((i725 & 23) << 1);
                                                Object[] objArr179 = new Object[1];
                                                a((char) (((bitsPerPixel5 | 1) << 1) - (bitsPerPixel5 ^ 1)), iMakeMeasureSpec2, i726, objArr179);
                                                String[] strArr32 = {(String) objArr179[0]};
                                                char c41 = (char) (54142 - (~(-TextUtils.indexOf((CharSequence) str6, '0', 0))));
                                                int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0);
                                                int i727 = (iNormalizeMetaState2 & 1222) + (iNormalizeMetaState2 | 1222);
                                                int i728 = -(-KeyEvent.normalizeMetaState(0));
                                                Object[] objArr180 = new Object[1];
                                                a(c41, i727, (i728 & 21) + (i728 | 21), objArr180);
                                                String[] strArr33 = {(String) objArr180[0]};
                                                Object[] objArr181 = new Object[1];
                                                a((char) (60741 - MotionEvent.axisFromString(str6)), 1242 - (~TextUtils.indexOf(str6, str6, 0, 0)), Drawable.resolveOpacity(0, 0) + 24, objArr181);
                                                String str73 = str2;
                                                String[] strArr34 = {(String) objArr181[0], str73};
                                                int iIndexOf12 = TextUtils.indexOf(str6, str6, 0, 0);
                                                int iArtificialStackFrames11 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                int i729 = iIndexOf12 * 367;
                                                int i730 = (i729 ^ 10837510) + ((i729 & 10837510) << 1);
                                                int i731 = -(-(((iIndexOf12 ^ 29530) | (iIndexOf12 & 29530)) * (-366)));
                                                int i732 = (i730 ^ i731) + ((i731 & i730) << 1);
                                                int i733 = ~(((-29531) & iArtificialStackFrames11) | ((-29531) ^ iArtificialStackFrames11));
                                                int i734 = i732 + (((i733 & iIndexOf12) | (iIndexOf12 ^ i733)) * (-366));
                                                int i735 = ~iIndexOf12;
                                                int i736 = ~((i735 & 29530) | (i735 ^ 29530));
                                                int i737 = (iIndexOf12 & (-29531)) | ((-29531) ^ iIndexOf12);
                                                int i738 = ~((iArtificialStackFrames11 & i737) | (i737 ^ iArtificialStackFrames11));
                                                int i739 = -(-(((i738 & i736) | (i736 ^ i738)) * 366));
                                                int i740 = -(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                                                int i741 = -TextUtils.indexOf(str6, str6, 0);
                                                int i742 = ((i741 | 28) << 1) - (i741 ^ 28);
                                                Object[] objArr182 = new Object[1];
                                                a((char) (((i734 | i739) << 1) - (i739 ^ i734)), ((i740 | 1267) << 1) - (i740 ^ 1267), i742, objArr182);
                                                String[] strArr35 = {(String) objArr182[0], str73};
                                                char pressedStateDuration2 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                                                int i743 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                                                int i744 = (i743 ^ 1295) + ((i743 & 1295) << 1);
                                                int i745 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                                int i746 = ((i745 | 28) << 1) - (i745 ^ 28);
                                                Object[] objArr183 = new Object[1];
                                                a(pressedStateDuration2, i744, i746, objArr183);
                                                String[] strArr36 = {(String) objArr183[0], str73};
                                                char cAxisFromString = (char) (MotionEvent.axisFromString(str6) + 1);
                                                int i747 = 1321 - (~(ViewConfiguration.getWindowTouchSlop() >> 8));
                                                int i748 = -(-ExpandableListView.getPackedPositionGroup(0L));
                                                int i749 = (i748 ^ 31) + ((i748 & 31) << 1);
                                                Object[] objArr184 = new Object[1];
                                                a(cAxisFromString, i747, i749, objArr184);
                                                String[] strArr37 = {(String) objArr184[0], str73};
                                                char c42 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                int i750 = -ExpandableListView.getPackedPositionType(0L);
                                                int i751 = (i750 ^ 1353) + ((i750 & 1353) << 1);
                                                int iLastIndexOf7 = TextUtils.lastIndexOf(str6, '0', 0, 0);
                                                int i752 = ((iLastIndexOf7 | 28) << 1) - (iLastIndexOf7 ^ 28);
                                                Object[] objArr185 = new Object[1];
                                                a(c42, i751, i752, objArr185);
                                                String[] strArr38 = {(String) objArr185[0], str73};
                                                char cLastIndexOf = (char) (TextUtils.lastIndexOf(str6, '0', 0) + 44670);
                                                int i753 = 1379 - (~View.resolveSize(0, 0));
                                                int size2 = View.MeasureSpec.getSize(0);
                                                Object[] objArr186 = new Object[1];
                                                a(cLastIndexOf, i753, (size2 & 32) + (size2 | 32), objArr186);
                                                String[][] strArr39 = {strArr16, strArr17, strArr18, strArr19, strArr20, strArr21, strArr22, strArr23, strArr24, strArr25, strArr26, strArr27, strArr28, strArr29, strArr30, strArr31, strArr32, strArr33, strArr34, strArr35, strArr36, strArr37, strArr38, new String[]{(String) objArr186[0], str73}};
                                                ArrayList arrayList = new ArrayList();
                                                int i754 = i351;
                                                int i755 = 0;
                                                int i756 = 0;
                                                while (i755 < 24) {
                                                    String[] strArr40 = strArr39[i755];
                                                    Object[] objArr187 = {strArr40[0]};
                                                    Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                    if (objAccessartificialFrame24 == null) {
                                                        int i757 = 23 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                        char cIndexOf5 = (char) TextUtils.indexOf(str6, str6, 0, 0);
                                                        int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0) + 2441;
                                                        byte[] bArr20 = $$a;
                                                        Object[] objArr188 = new Object[1];
                                                        b(bArr20[4], bArr20[18], bArr20[10], objArr188);
                                                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i757, cIndexOf5, absoluteGravity3, 954751276, false, (String) objArr188[0], new Class[]{String.class});
                                                    }
                                                    String str74 = (String) ((Method) objAccessartificialFrame24).invoke(null, objArr187);
                                                    String[] strArr41 = (String[]) Arrays.copyOfRange(strArr40, 1, strArr40.length);
                                                    if (str74 == null || str74.length() == 0) {
                                                        str8 = str6;
                                                    } else {
                                                        if (strArr40.length != 1) {
                                                            Object[] objArr189 = {str74, strArr41};
                                                            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                            if (objAccessartificialFrame25 == null) {
                                                                int iIndexOf13 = TextUtils.indexOf((CharSequence) str6, '0') + 30;
                                                                char c43 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                                                                int iAxisFromString = 510 - MotionEvent.axisFromString(str6);
                                                                byte[] bArr21 = $$a;
                                                                Object[] objArr190 = new Object[1];
                                                                b(bArr21[12], bArr21[4], (byte) 49, objArr190);
                                                                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iIndexOf13, c43, iAxisFromString, -1914043387, false, (String) objArr190[0], new Class[]{String.class, String[].class});
                                                            }
                                                            long jLongValue16 = ((Long) ((Method) objAccessartificialFrame25).invoke(null, objArr189)).longValue();
                                                            long j100 = -2044971893;
                                                            str8 = str6;
                                                            long jMyTid2 = Process.myTid();
                                                            long j101 = j100 ^ j;
                                                            long j102 = 381;
                                                            long j103 = (((long) (-380)) * j100) + (((long) 382) * jLongValue16) + (((long) (-381)) * (jLongValue16 | jMyTid2 | j101)) + ((((j101 | (jLongValue16 ^ j)) ^ j) | (((jMyTid2 ^ j) | jLongValue16) ^ j) | ((j100 | jLongValue16) ^ j)) * j102) + (j102 * ((j101 | jLongValue16) ^ j)) + ((long) 2070245347);
                                                            int i758 = (int) Runtime.getRuntime().totalMemory();
                                                            int i759 = ~((-1706198482) | i758);
                                                            int i760 = ~i758;
                                                            int i761 = ((int) (j103 >> 32)) & (1972359521 + ((i759 | (~(i760 | (-18433)))) * 497) + (((~(i758 | (-18433))) | (~(268990502 | i760)) | (-1975188984)) * 497));
                                                            int iMyUid3 = Process.myUid();
                                                            int i762 = ~iMyUid3;
                                                            if ((i761 | (((int) j103) & (1788176917 + ((287342593 | i762) * (-192)) + (((~((-1285498837) | i762)) | 1284899456) * (-384)) + (((~(iMyUid3 | 1572841429)) | (~(i762 | (-599381))) | (~((-1284899457) | iMyUid3))) * JfifUtil.MARKER_SOFn)))) == 0) {
                                                                i351 = i;
                                                            }
                                                            i755++;
                                                            strArr39 = strArr39;
                                                            i279 = i279;
                                                            str6 = str8;
                                                        } else {
                                                            str8 = str6;
                                                        }
                                                        i756++;
                                                        int i763 = i755 + 10;
                                                        i351 = i;
                                                        i754 = ((~i763) & i351) | (i763 & i279);
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append(str74);
                                                        int i764 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                                        Object[] objArr191 = new Object[1];
                                                        a((char) ((i764 ^ (-1)) + (i764 << 1)), 1413 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 0 - (~(ViewConfiguration.getKeyRepeatDelay() >> 16)), objArr191);
                                                        sb.append((String) objArr191[0]);
                                                        sb.append(str74);
                                                        arrayList = arrayList;
                                                        arrayList.add(sb.toString());
                                                        i755++;
                                                        strArr39 = strArr39;
                                                        i279 = i279;
                                                        str6 = str8;
                                                    }
                                                    arrayList = arrayList;
                                                    i754 = i754;
                                                    i755++;
                                                    strArr39 = strArr39;
                                                    i279 = i279;
                                                    str6 = str8;
                                                }
                                                str7 = str6;
                                                int i765 = i754;
                                                i17 = i279;
                                                if (i756 > 2) {
                                                    objArr = new Object[]{arrayList, new int[1], null, new int[]{i351}, new int[]{i765}};
                                                    int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                                                    int i766 = ~startUptimeMillis2;
                                                    int i767 = (-1) - (~(-(-(((1539417840 + ((((~((-806912325) | i766)) | (~((-62988801) | startUptimeMillis2))) | (~(1071364990 | startUptimeMillis2))) * 765)) + (((~((-869901125) | i766)) | 806912324) * 1530)) + (((~(startUptimeMillis2 | (-869901125))) | (~(i766 | 1071364990))) * 765)))));
                                                    int i768 = (i767 << 13) ^ i767;
                                                    int i769 = i768 >>> 17;
                                                    int i770 = (i768 | i769) & (~(i768 & i769));
                                                    int i771 = i770 << 5;
                                                    int i772 = (i770 | i771) & (~(i770 & i771));
                                                    i19 = 1;
                                                    c = 0;
                                                    ((int[]) objArr[1])[0] = i772;
                                                } else {
                                                    objArr = new Object[5];
                                                    objArr[1] = new int[1];
                                                    objArr[3] = new int[]{i351};
                                                    objArr[4] = new int[]{i351};
                                                    int i773 = artificialFrame;
                                                    int i774 = ((i773 | 51) << 1) - (i773 ^ 51);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i774 % 128;
                                                    if (i774 % 2 != 0) {
                                                        objArr[1] = null;
                                                        objArr[3] = null;
                                                        int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                                                        int i775 = ~iUptimeMillis2;
                                                        i18 = (-1360371592) + (((~(i775 | 358194857)) | 247253600) * (-1042)) + ((358194857 | iUptimeMillis2) * 521) + (((~(iUptimeMillis2 | (-247253601))) | 68717088 | (~(i775 | 536731369))) * 521);
                                                    } else {
                                                        objArr[0] = null;
                                                        objArr[2] = null;
                                                        i18 = 395814211 + (((~((-158099802) | i351)) | 136866064 | (~(i17 | 468582393))) * 886) + (((~(i17 | 158099801)) | 447348656) * (-1772)) + ((~(i17 | 447348656)) * 886);
                                                    }
                                                    int i776 = (i18 << 1) - i18;
                                                    int i777 = i776 << 13;
                                                    int i778 = ((~i776) & i777) | ((~i777) & i776);
                                                    int i779 = i778 >>> 17;
                                                    int i780 = (i778 | i779) & (~(i778 & i779));
                                                    int i781 = i780 << 5;
                                                    int i782 = ((~i780) & i781) | ((~i781) & i780);
                                                    i19 = 1;
                                                    c = 0;
                                                    ((int[]) objArr[1])[0] = i782;
                                                }
                                                int i783 = ((int[]) objArr[4])[c];
                                                if (i783 != i351) {
                                                    Object[] objArr192 = new Object[5];
                                                    objArr192[i19] = new int[i19];
                                                    int[] iArr4 = new int[i19];
                                                    objArr192[3] = iArr4;
                                                    int[] iArr5 = new int[i19];
                                                    objArr192[4] = iArr5;
                                                    List list = (List) objArr[c];
                                                    iArr4[c] = i351;
                                                    iArr5[c] = i783;
                                                    objArr192[c] = list;
                                                    objArr192[2] = null;
                                                    int startElapsedRealtime3 = (int) Process.getStartElapsedRealtime();
                                                    int i784 = (((~((~startElapsedRealtime3) | (-50431633))) * 130) - 70794585) + (((~(startElapsedRealtime3 | (-50431633))) | 549458017) * 130);
                                                    int i785 = i3 + (i784 ^ 16) + ((i784 & 16) << 1);
                                                    int i786 = i785 << 13;
                                                    int i787 = (i785 | i786) & (~(i785 & i786));
                                                    int i788 = i787 ^ (i787 >>> 17);
                                                    int i789 = i788 << 5;
                                                    ((int[]) objArr192[1])[0] = (i788 | i789) & (~(i788 & i789));
                                                    return objArr192;
                                                }
                                                int i3910 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                                char c110 = (char) ((i3910 ^ 58074) + ((i3910 & 58074) << i19));
                                                str9 = str7;
                                                int iIndexOf14 = TextUtils.indexOf((CharSequence) str9, '0', 0);
                                                int i3911 = ((iIndexOf14 | 699) << i19) - (iIndexOf14 ^ 699);
                                                int i3912 = -MotionEvent.axisFromString(str9);
                                                Object[] objArr710 = new Object[1];
                                                a(c110, i3911, (i3912 & 15) + (i3912 | 15), objArr710);
                                                Object[] objArr711 = {(String) objArr710[0]};
                                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                if (objAccessartificialFrame == null) {
                                                    int gidForName6 = Process.getGidForName(str9) + 24;
                                                    char capsMode7 = (char) TextUtils.getCapsMode(str9, 0, 0);
                                                    int i3913 = 2442 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                    byte[] bArr111 = $$a;
                                                    Object[] objArr810 = new Object[1];
                                                    b(bArr111[4], bArr111[18], bArr111[10], objArr810);
                                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(gidForName6, capsMode7, i3913, 954751276, false, (String) objArr810[0], new Class[]{String.class});
                                                }
                                                objInvoke = ((Method) objAccessartificialFrame).invoke(null, objArr711);
                                                if (objInvoke == null) {
                                                    i22 = 0;
                                                } else {
                                                    i20 = artificialFrame + 101;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                                                    if (i20 % 2 != 0) {
                                                        Object[] objArr811 = {objInvoke, 42};
                                                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-287841710);
                                                        if (objAccessartificialFrame3 == null) {
                                                            int scrollBarFadeDuration6 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 20;
                                                            char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16777216);
                                                            int iMakeMeasureSpec3 = 2245 - View.MeasureSpec.makeMeasureSpec(0, 0);
                                                            byte[] bArr112 = $$a;
                                                            byte b110 = (byte) (bArr112[9] + 1);
                                                            byte b111 = bArr112[18];
                                                            Object[] objArr812 = new Object[1];
                                                            b(b110, b111, (byte) (b111 | 36), objArr812);
                                                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration6, cRgb2, iMakeMeasureSpec3, 1907532890, false, (String) objArr812[0], new Class[]{String.class, Integer.TYPE});
                                                        }
                                                        jLongValue = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr811)).longValue();
                                                        i21 = 1;
                                                    } else {
                                                        Object[] objArr813 = {objInvoke, 42};
                                                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-287841710);
                                                        if (objAccessartificialFrame2 == null) {
                                                            int iIndexOf15 = 19 - TextUtils.indexOf((CharSequence) str9, '0', 0);
                                                            char c111 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                                                            int maximumFlingVelocity4 = 2245 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                            byte[] bArr113 = $$a;
                                                            byte b112 = (byte) (bArr113[9] + 1);
                                                            byte b211 = bArr113[18];
                                                            Object[] objArr814 = new Object[1];
                                                            b(b112, b211, (byte) (b211 | 36), objArr814);
                                                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf15, c111, maximumFlingVelocity4, 1907532890, false, (String) objArr814[0], new Class[]{String.class, Integer.TYPE});
                                                        }
                                                        jLongValue = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr813)).longValue();
                                                        i21 = 0;
                                                    }
                                                    long j610 = 1017231324;
                                                    long j611 = j610 ^ j;
                                                    int i4010 = i21;
                                                    long startUptimeMillis3 = (int) Process.getStartUptimeMillis();
                                                    long j710 = startUptimeMillis3 ^ j;
                                                    long j711 = (((long) (-563)) * j610) + (((long) 565) * jLongValue) + (((long) (-564)) * (j611 | (((jLongValue ^ j) | j710) ^ j) | ((jLongValue | startUptimeMillis3) ^ j))) + (((long) 1128) * (((j611 | jLongValue) | startUptimeMillis3) ^ j)) + (((long) 564) * (((jLongValue | j610) ^ j) | ((j611 | j710) ^ j))) + ((long) 615854004);
                                                    i351 = i;
                                                    int i4011 = ((int) (j711 >> 32)) & (1871737038 + (((~(669324799 | i17)) | (~((-2106551211) | i351))) * 1900) + (((~(i17 | 2106551210)) | (~((-669324800) | i351))) * (-950)) + (((~(2106551210 | i351)) | (~(i17 | (-669324800)))) * 950));
                                                    int iMyPid7 = Process.myPid();
                                                    int i4012 = ((int) j711) & (((((~(1302484599 | iMyPid7)) | 1168484677) * 262) - 1792104983) + (((~((~iMyPid7) | 1302484599)) | 1168484677) * 262));
                                                    int i4013 = (i4011 & i4012) | (i4011 ^ i4012);
                                                    i22 = (i4013 | i4010) & (~(i4013 & i4010));
                                                }
                                                if (i22 != 1986687685) {
                                                    i23 = i351;
                                                    str10 = str9;
                                                } else {
                                                    i23 = i351;
                                                    str10 = str9;
                                                }
                                                char maximumFlingVelocity5 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                int size3 = View.MeasureSpec.getSize(0);
                                                int i4810 = size3 * (-559);
                                                int i4811 = (i4810 & 984555) + (i4810 | 984555) + ((~((i17 ^ size3) | (i17 & size3))) * (-560));
                                                int i4812 = (-1756) | size3;
                                                int i4813 = -(-((~((i4812 & i23) | (i4812 ^ i23))) * (-560)));
                                                int i4814 = (i4811 & i4813) + (i4813 | i4811);
                                                int i4910 = ~size3;
                                                int i4911 = ~((i4910 & 1755) | (i4910 ^ 1755));
                                                i24 = i17;
                                                int i4912 = ~(i24 | 1755);
                                                int i4913 = -(-(((i4911 & i4912) | (i4911 ^ i4912)) * 560));
                                                int i4914 = (i4814 & i4913) + (i4913 | i4814);
                                                str11 = str10;
                                                int i4915 = -TextUtils.indexOf((CharSequence) str11, '0', 0, 0);
                                                Object[] objArr1110 = new Object[1];
                                                a(maximumFlingVelocity5, i4914, (i4915 & 12) + (i4915 | 12), objArr1110);
                                                String str310 = (String) objArr1110[0];
                                                int i4916 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                                                int i4917 = 1766 - (~(-MotionEvent.axisFromString(str11)));
                                                int i4918 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                int i4919 = (i4918 ^ 5) + ((i4918 & 5) << 1);
                                                Object[] objArr1111 = new Object[1];
                                                a((char) ((i4916 & 39079) + (i4916 | 39079)), i4917, i4919, objArr1111);
                                                String[] strArr110 = {str310, (String) objArr1111[0]};
                                                char maxKeyCode3 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 18445);
                                                int packedPositionType4 = ExpandableListView.getPackedPositionType(0L);
                                                int i5010 = ((packedPositionType4 | 1773) << 1) - (packedPositionType4 ^ 1773);
                                                int i5011 = -(-TextUtils.lastIndexOf(str11, '0', 0));
                                                int i5012 = ((i5011 | 16) << 1) - (i5011 ^ 16);
                                                Object[] objArr1112 = new Object[1];
                                                a(maxKeyCode3, i5010, i5012, objArr1112);
                                                String str311 = (String) objArr1112[0];
                                                char tapTimeout2 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                                                int i5013 = 1787 - (~Color.argb(0, 0, 0, 0));
                                                int jumpTapTimeout3 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                int i5014 = (jumpTapTimeout3 ^ 19) + ((jumpTapTimeout3 & 19) << 1);
                                                Object[] objArr1113 = new Object[1];
                                                a(tapTimeout2, i5013, i5014, objArr1113);
                                                String str312 = (String) objArr1113[0];
                                                char c210 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                                                int iLastIndexOf8 = TextUtils.lastIndexOf(str11, '0', 0, 0);
                                                int i5015 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                Object[] objArr1114 = new Object[1];
                                                a(c210, (iLastIndexOf8 ^ 1808) + ((iLastIndexOf8 & 1808) << 1), (i5015 ^ 13) + ((13 & i5015) << 1), objArr1114);
                                                String[] strArr111 = {str311, str312, (String) objArr1114[0]};
                                                int i5016 = -(-KeyEvent.getDeadChar(0, 0));
                                                int i5017 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                                                Object[] objArr1115 = new Object[1];
                                                a((char) (((i5016 | 52662) << 1) - (i5016 ^ 52662)), (i5017 & 1821) + (i5017 | 1821), 20 - (~(-(ViewConfiguration.getScrollBarSize() >> 8))), objArr1115);
                                                String str313 = (String) objArr1115[0];
                                                int i5018 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                int i5019 = -View.getDefaultSize(0, 0);
                                                int i5110 = (i5019 ^ 1842) + ((i5019 & 1842) << 1);
                                                int i5111 = -View.getDefaultSize(0, 0);
                                                int i5112 = ((i5111 | 10) << 1) - (i5111 ^ 10);
                                                Object[] objArr1116 = new Object[1];
                                                a((char) ((i5018 ^ 30452) + ((i5018 & 30452) << 1)), i5110, i5112, objArr1116);
                                                String[] strArr112 = {str313, (String) objArr1116[0]};
                                                char cKeyCodeFromString3 = (char) KeyEvent.keyCodeFromString(str11);
                                                int i5113 = 1852 - (~Process.getGidForName(str11));
                                                int i5114 = -(-TextUtils.indexOf(str11, str11, 0, 0));
                                                int i5115 = ((i5114 | 11) << 1) - (i5114 ^ 11);
                                                Object[] objArr1117 = new Object[1];
                                                a(cKeyCodeFromString3, i5113, i5115, objArr1117);
                                                String str314 = (String) objArr1117[0];
                                                int i5116 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                char c211 = (char) ((i5116 ^ 59595) + ((59595 & i5116) << 1));
                                                int iMyTid4 = Process.myTid() >> 22;
                                                Object[] objArr1118 = new Object[1];
                                                a(c211, ((iMyTid4 | 589) << 1) - (iMyTid4 ^ 589), 6 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr1118);
                                                String[] strArr113 = {str314, (String) objArr1118[0]};
                                                int iIndexOf16 = TextUtils.indexOf((CharSequence) str11, '0', 0, 0);
                                                int i5117 = (iIndexOf16 * (-183)) + 185;
                                                int i5118 = ~iIndexOf16;
                                                int i5119 = -(-(((i5118 ^ 1) | (i5118 & 1)) * (-368)));
                                                int i5210 = ((i5117 | i5119) << 1) - (i5117 ^ i5119);
                                                int i5211 = iIndexOf16 | (-2);
                                                int i5212 = ((i5211 & i24) | (i5211 ^ i24)) * SyslogConstants.LOG_LOCAL7;
                                                int i5213 = (i5210 ^ i5212) + ((i5212 & i5210) << 1);
                                                int i5214 = (~((i5118 ^ (-2)) | (i5118 & (-2)))) | (~((i24 ^ iIndexOf16) | (i24 & iIndexOf16)));
                                                int i5215 = ~((iIndexOf16 & 1) | (iIndexOf16 ^ 1));
                                                int i5216 = -(-(((i5214 & i5215) | (i5214 ^ i5215)) * SyslogConstants.LOG_LOCAL7));
                                                int i5217 = -TextUtils.getTrimmedLength(str11);
                                                Object[] objArr1119 = new Object[1];
                                                a((char) ((i5213 & i5216) + (i5216 | i5213)), (i5217 & 1863) + (i5217 | 1863), 27 - (~(-(ViewConfiguration.getScrollDefaultDelay() >> 16))), objArr1119);
                                                String str410 = (String) objArr1119[0];
                                                int fadingEdgeLength2 = ViewConfiguration.getFadingEdgeLength() >> 16;
                                                int i5218 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                int i5219 = (i5218 & 1841) + (i5218 | 1841);
                                                c2 = 0;
                                                Object[] objArr1213 = new Object[1];
                                                a((char) ((fadingEdgeLength2 & 30452) + (fadingEdgeLength2 | 30452)), i5219, 10 - KeyEvent.getDeadChar(0, 0), objArr1213);
                                                strArr = new String[][]{strArr110, strArr111, strArr112, strArr113, new String[]{str410, (String) objArr1213[0]}};
                                                i25 = 0;
                                                i26 = 5;
                                                i27 = -1;
                                                loop5: while (true) {
                                                    if (i25 < i26) {
                                                        i28 = i23;
                                                        str12 = str11;
                                                        i29 = i28;
                                                        break;
                                                    }
                                                    String[] strArr114 = strArr[i25];
                                                    str14 = strArr114[c2];
                                                    i37 = 1;
                                                    strArr2 = (String[]) Arrays.copyOfRange(strArr114, 1, strArr114.length);
                                                    length = strArr2.length;
                                                    i38 = 0;
                                                    while (i38 < length) {
                                                        int i5310 = ((i27 | 26) << i37) - (i27 ^ 26);
                                                        i39 = (i5310 & (-25)) + (i5310 | (-25));
                                                        Object[] objArr1214 = {str14, strArr2[i38]};
                                                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                                        if (objAccessartificialFrame5 == null) {
                                                            int i5311 = 32 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                            char cIndexOf6 = (char) (57021 - TextUtils.indexOf((CharSequence) str11, '0'));
                                                            int iIndexOf17 = TextUtils.indexOf((CharSequence) str11, '0') + 2312;
                                                            byte b212 = (byte) ($$b & 15);
                                                            byte b213 = $$a[18];
                                                            Object[] objArr1215 = new Object[1];
                                                            b(b212, b213, (byte) (b213 | Ascii.RS), objArr1215);
                                                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i5311, cIndexOf6, iIndexOf17, 1412547569, false, (String) objArr1215[0], new Class[]{String.class, String.class});
                                                        }
                                                        long jLongValue17 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr1214)).longValue();
                                                        long j812 = 1266610653;
                                                        str12 = str11;
                                                        i40 = i25;
                                                        long j813 = j812 ^ j;
                                                        long startElapsedRealtime4 = (int) Process.getStartElapsedRealtime();
                                                        long j814 = (((long) 236) * j812) + (((long) 471) * jLongValue17) + (((long) (-235)) * (jLongValue17 | ((j813 | (startElapsedRealtime4 ^ j)) ^ j))) + (((long) (-470)) * (jLongValue17 | ((j813 | startElapsedRealtime4) ^ j))) + (((long) 235) * (((startElapsedRealtime4 | (j813 | jLongValue17)) ^ j) | (((jLongValue17 ^ j) | j812) ^ j))) + ((long) (-1421362282));
                                                        int iMyUid4 = Process.myUid();
                                                        int i5312 = ~(953307446 | (~iMyUid4));
                                                        i41 = ((int) (j814 >> 32)) & (((139460640 | i5312 | (~((-953307447) | iMyUid4))) * (-338)) + 1330282474 + (((~(iMyUid4 | (-813846807))) | i5312) * 338));
                                                        int iNextInt5 = new Random().nextInt(987821251);
                                                        i42 = ((int) j814) & (((818885255 + (((~iNextInt5) | 845171328) * 1324)) + (((~(iNextInt5 | 2002804609)) | (~(854936276 | iNextInt5))) * (-1324))) - 276485682);
                                                        if (((i41 & i42) | (i41 ^ i42)) != 0) {
                                                            int i5313 = (i39 ^ 170) + ((i39 & 170) << 1);
                                                            i28 = i;
                                                            i29 = (i5313 | i28) & (~(i28 & i5313));
                                                            break loop5;
                                                        }
                                                        i27 = i39;
                                                        i38 = ((i38 | 1) << 1) - (i38 ^ 1);
                                                        i23 = i;
                                                        i25 = i40;
                                                        strArr2 = strArr2;
                                                        strArr = strArr;
                                                        str14 = str14;
                                                        length = length;
                                                        str11 = str12;
                                                        i37 = 1;
                                                    }
                                                    i26 = 5;
                                                    c2 = 0;
                                                    i25++;
                                                    strArr = strArr;
                                                }
                                                if (i29 != i28) {
                                                    Object[] objArr1216 = {null, new int[1], null, new int[]{i28}, new int[]{i29}};
                                                    int iMaxMemory5 = (int) Runtime.getRuntime().maxMemory();
                                                    int i5314 = (-845494969) + (((~((~iMaxMemory5) | (-461662274))) | (~((-1185559) | iMaxMemory5))) * (-302)) + ((~((-461662274) | iMaxMemory5)) * (-604)) + (((~(iMaxMemory5 | (-462847832))) | (-1069481848)) * 302);
                                                    int i5315 = (i3 - (~(-(-(((i5314 | 16) << 1) - (i5314 ^ 16)))))) - 1;
                                                    int i5316 = i5315 ^ (i5315 << 13);
                                                    int i5317 = i5316 >>> 17;
                                                    int i5318 = ((~i5316) & i5317) | ((~i5317) & i5316);
                                                    ((int[]) objArr1216[1])[0] = i5318 ^ (i5318 << 5);
                                                    return objArr1216;
                                                }
                                                char c212 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                int i5319 = -(-View.resolveSizeAndState(0, 0, 0));
                                                Object[] objArr1217 = new Object[1];
                                                a(c212, (i5319 ^ 1891) + ((i5319 & 1891) << 1), 12 - (~View.MeasureSpec.makeMeasureSpec(0, 0)), objArr1217);
                                                String str411 = (String) objArr1217[0];
                                                char c213 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                                                int i5416 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                int i5417 = (i5416 & 1905) + (i5416 | 1905);
                                                int i5418 = -ExpandableListView.getPackedPositionChild(0L);
                                                Object[] objArr1218 = new Object[1];
                                                a(c213, i5417, (i5418 & 7) + (i5418 | 7), objArr1218);
                                                str13 = (String) objArr1218[0];
                                                file = new File(str411);
                                                if (file.exists()) {
                                                    Scanner scanner5 = new Scanner(new FileInputStream(file));
                                                    char maximumDrawingCacheSize2 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                    int i5419 = -View.resolveSizeAndState(0, 0, 0);
                                                    Object[] objArr1219 = new Object[1];
                                                    a(maximumDrawingCacheSize2, ((i5419 | 229) << 1) - (i5419 ^ 229), 3 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr1219);
                                                    scannerUseDelimiter = scanner5.useDelimiter((String) objArr1219[0]);
                                                    if (scannerUseDelimiter.hasNext()) {
                                                        next = scannerUseDelimiter.next();
                                                    } else {
                                                        next = str12;
                                                    }
                                                    scannerUseDelimiter.close();
                                                    if (next.contains(str13)) {
                                                        i31 = i28 & (-151);
                                                        i30 = i24;
                                                        i32 = i30 & 150;
                                                        i33 = i31 | i32;
                                                    }
                                                    if (i33 != i28) {
                                                        int i54110 = artificialFrame;
                                                        int i54111 = (i54110 & 97) + (i54110 | 97);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i54111 % 128;
                                                        int i54112 = i54111 % 2;
                                                        Object[] objArr12110 = {null, new int[]{i5513 ^ (i5513 << 5)}, null, new int[]{i28}, new int[]{i33}};
                                                        int i54113 = ((((~(i28 | 269495339)) | (-607566111)) * 398) - 1974962091) + (((~(269495339 | i30)) | (-607566111)) * 398);
                                                        int i54114 = (i54113 ^ 16) + ((i54113 & 16) << 1);
                                                        int i54115 = ((i3 | i54114) << 1) - (i3 ^ i54114);
                                                        int i55110 = i54115 << 13;
                                                        int i55111 = (i55110 & (~i54115)) | ((~i55110) & i54115);
                                                        int i55112 = i55111 >>> 17;
                                                        int i55113 = (i55111 | i55112) & (~(i55111 & i55112));
                                                        return objArr12110;
                                                    }
                                                    char c214 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                    int i55114 = 1910 - (~(-TextUtils.lastIndexOf(str12, '0', 0)));
                                                    int i55115 = -ExpandableListView.getPackedPositionType(0L);
                                                    int iArtificialStackFrames12 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                    int i55116 = ~i55115;
                                                    int i55117 = ~((i55116 & (-48)) | (i55116 ^ (-48)));
                                                    int i55118 = ~iArtificialStackFrames12;
                                                    int i55119 = i55117 | (~((i55118 & (-48)) | ((-48) ^ i55118)));
                                                    int i56110 = (i55115 ^ 47) | (i55115 & 47);
                                                    int i56111 = (i56110 ^ iArtificialStackFrames12) | (i56110 & iArtificialStackFrames12);
                                                    int i56112 = ~i56111;
                                                    int i56113 = (((i55115 * 253) + 11891) - (~(((i55119 & i56112) | (i55119 ^ i56112)) * (-252)))) - 1;
                                                    int i56114 = i56110 * (-252);
                                                    int i56115 = ~iArtificialStackFrames12;
                                                    int i56116 = (i56115 & (-48)) | ((-48) ^ i56115);
                                                    int i56117 = (((i56113 & i56114) + (i56113 | i56114)) - (~(-(-(((~((i55115 & i56116) | (i56116 ^ i55115))) | (~i56111)) * 252))))) - 1;
                                                    Object[] objArr12111 = new Object[1];
                                                    a(c214, i55114, i56117, objArr12111);
                                                    Object[] objArr12112 = {(String) objArr12111[0]};
                                                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(267846469);
                                                    if (objAccessartificialFrame4 == null) {
                                                        int i56118 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 17;
                                                        char bitsPerPixel6 = (char) (ImageFormat.getBitsPerPixel(0) + 24344);
                                                        int i56119 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2014;
                                                        byte[] bArr114 = $$a;
                                                        byte b214 = (byte) (-bArr114[7]);
                                                        byte b215 = bArr114[10];
                                                        Object[] objArr1310 = new Object[1];
                                                        b(b214, b215, (byte) (b215 | 38), objArr1310);
                                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i56118, bitsPerPixel6, i56119, -1869462195, false, (String) objArr1310[0], new Class[]{String.class});
                                                    }
                                                    long jLongValue18 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr12112)).longValue();
                                                    long j815 = 186920542;
                                                    long j816 = (((long) 465) * j815) + (((long) (-463)) * jLongValue18);
                                                    long j910 = 464;
                                                    long j911 = jLongValue18 ^ j;
                                                    long jMyPid5 = Process.myPid();
                                                    long j912 = jMyPid5 ^ j;
                                                    long j913 = (j911 | j815) ^ j;
                                                    long j914 = j816 + ((((j911 | j912) ^ j) | j913 | ((j912 | j815) ^ j)) * j910) + (((long) (-464)) * (jMyPid5 | (j815 ^ j) | j911)) + (j910 * (j913 | ((j815 | jMyPid5) ^ j))) + ((long) (-1498552518));
                                                    int iElapsedRealtime5 = (int) SystemClock.elapsedRealtime();
                                                    int i57110 = ((int) (j914 >> 32)) & ((-101607734) + (((~((-1455691853) | (~iElapsedRealtime5))) | (~((-18465442) | iElapsedRealtime5))) * (-272)) + (((~((-2129018191) | iElapsedRealtime5)) | 673326338) * (-272)) + (((~(iElapsedRealtime5 | 2129018190)) | (-691791780)) * 272));
                                                    int elapsedCpuTime7 = (int) Process.getElapsedCpuTime();
                                                    int i57111 = ~((-1181388841) | elapsedCpuTime7);
                                                    int i57112 = (-2012598375) + ((67141632 | i57111) * (-280)) + ((i57111 | (~((-1676352046) | elapsedCpuTime7))) * 140);
                                                    int i57113 = ~((-1114247209) | elapsedCpuTime7);
                                                    int i57114 = ~elapsedCpuTime7;
                                                    int i57115 = ((int) j914) & (i57112 + (((~(i57114 | (-562104838))) | i57113 | (~((-67141633) | i57114))) * 140));
                                                    int i57116 = ((i57110 & i57115) | (i57110 ^ i57115)) * 263;
                                                    i34 = (i57116 & i30) | ((~i57116) & i);
                                                    if (i34 != i) {
                                                        objArr3 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i34}};
                                                        int i57117 = (int) Runtime.getRuntime().totalMemory();
                                                        int i57118 = 728361708 + ((~((-67246083) | i57117)) * (-301)) + (((~(132275923 | i57117)) | (~((~i57117) | 737724381))) * (-301)) + (((~(i57117 | (-737724382))) | 132275923) * 301);
                                                        int i57119 = i3 + (i57118 & 16) + (i57118 | 16);
                                                        int i58110 = i57119 << 13;
                                                        int i58111 = ((~i57119) & i58110) | ((~i58110) & i57119);
                                                        int i58112 = i58111 >>> 17;
                                                        int i58113 = ((~i58111) & i58112) | ((~i58112) & i58111);
                                                        int i58114 = i58113 << 5;
                                                        ((int[]) objArr3[1])[0] = (i58113 | i58114) & (~(i58113 & i58114));
                                                    } else {
                                                        int[] iArr6 = new int[1];
                                                        objArr2 = new Object[]{null, iArr6, null, new int[]{i}, new int[]{i}};
                                                        int i58115 = -(-((-1013288380) + (((~((-9541173) | i30)) | (-595907286)) * (-933)) + (((~(i30 | (-595907286))) | 587481281) * 933) + 1323798898));
                                                        int i58116 = ((i3 | i58115) << 1) - (i3 ^ i58115);
                                                        int i58117 = i58116 << 13;
                                                        int i58118 = (i58117 | i58116) & (~(i58116 & i58117));
                                                        int i58119 = i58118 >>> 17;
                                                        int i5910 = (i58118 | i58119) & (~(i58118 & i58119));
                                                        int i5911 = i5910 << 5;
                                                        i35 = ((~i5910) & i5911) | ((~i5911) & i5910);
                                                        i36 = artificialFrame + 1;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i36 % 128;
                                                        iArr = iArr6;
                                                        if (i36 % 2 != 0) {
                                                            iArr[1] = i35;
                                                        } else {
                                                            iArr[0] = i35;
                                                        }
                                                    }
                                                }
                                                i30 = i24;
                                                i33 = i28;
                                                if (i33 != i28) {
                                                    int i54116 = artificialFrame;
                                                    int i54117 = (i54116 & 97) + (i54116 | 97);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i54117 % 128;
                                                    int i54118 = i54117 % 2;
                                                    Object[] objArr12113 = {null, new int[]{i55113 ^ (i55113 << 5)}, null, new int[]{i28}, new int[]{i33}};
                                                    int i54119 = ((((~(i28 | 269495339)) | (-607566111)) * 398) - 1974962091) + (((~(269495339 | i30)) | (-607566111)) * 398);
                                                    int i541110 = (i54119 ^ 16) + ((i54119 & 16) << 1);
                                                    int i541111 = ((i3 | i541110) << 1) - (i3 ^ i541110);
                                                    int i551110 = i541111 << 13;
                                                    int i551111 = (i551110 & (~i541111)) | ((~i551110) & i541111);
                                                    int i551112 = i551111 >>> 17;
                                                    int i551113 = (i551111 | i551112) & (~(i551111 & i551112));
                                                    return objArr12113;
                                                }
                                                char c215 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                int i551114 = 1910 - (~(-TextUtils.lastIndexOf(str12, '0', 0)));
                                                int i551115 = -ExpandableListView.getPackedPositionType(0L);
                                                int iArtificialStackFrames13 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                int i551116 = ~i551115;
                                                int i551117 = ~((i551116 & (-48)) | (i551116 ^ (-48)));
                                                int i551118 = ~iArtificialStackFrames13;
                                                int i551119 = i551117 | (~((i551118 & (-48)) | ((-48) ^ i551118)));
                                                int i561110 = (i551115 ^ 47) | (i551115 & 47);
                                                int i561111 = (i561110 ^ iArtificialStackFrames13) | (i561110 & iArtificialStackFrames13);
                                                int i561112 = ~i561111;
                                                int i561113 = (((i551115 * 253) + 11891) - (~(((i551119 & i561112) | (i551119 ^ i561112)) * (-252)))) - 1;
                                                int i561114 = i561110 * (-252);
                                                int i561115 = ~iArtificialStackFrames13;
                                                int i561116 = (i561115 & (-48)) | ((-48) ^ i561115);
                                                int i561117 = (((i561113 & i561114) + (i561113 | i561114)) - (~(-(-(((~((i551115 & i561116) | (i561116 ^ i551115))) | (~i561111)) * 252))))) - 1;
                                                Object[] objArr12114 = new Object[1];
                                                a(c215, i551114, i561117, objArr12114);
                                                Object[] objArr12115 = {(String) objArr12114[0]};
                                                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(267846469);
                                                if (objAccessartificialFrame4 == null) {
                                                    int i561118 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 17;
                                                    char bitsPerPixel7 = (char) (ImageFormat.getBitsPerPixel(0) + 24344);
                                                    int i561119 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2014;
                                                    byte[] bArr115 = $$a;
                                                    byte b216 = (byte) (-bArr115[7]);
                                                    byte b217 = bArr115[10];
                                                    Object[] objArr1311 = new Object[1];
                                                    b(b216, b217, (byte) (b217 | 38), objArr1311);
                                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i561118, bitsPerPixel7, i561119, -1869462195, false, (String) objArr1311[0], new Class[]{String.class});
                                                }
                                                long jLongValue19 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr12115)).longValue();
                                                long j817 = 186920542;
                                                long j818 = (((long) 465) * j817) + (((long) (-463)) * jLongValue19);
                                                long j915 = 464;
                                                long j916 = jLongValue19 ^ j;
                                                long jMyPid6 = Process.myPid();
                                                long j917 = jMyPid6 ^ j;
                                                long j918 = (j916 | j817) ^ j;
                                                long j919 = j818 + ((((j916 | j917) ^ j) | j918 | ((j917 | j817) ^ j)) * j915) + (((long) (-464)) * (jMyPid6 | (j817 ^ j) | j916)) + (j915 * (j918 | ((j817 | jMyPid6) ^ j))) + ((long) (-1498552518));
                                                int iElapsedRealtime6 = (int) SystemClock.elapsedRealtime();
                                                int i571110 = ((int) (j919 >> 32)) & ((-101607734) + (((~((-1455691853) | (~iElapsedRealtime6))) | (~((-18465442) | iElapsedRealtime6))) * (-272)) + (((~((-2129018191) | iElapsedRealtime6)) | 673326338) * (-272)) + (((~(iElapsedRealtime6 | 2129018190)) | (-691791780)) * 272));
                                                int elapsedCpuTime8 = (int) Process.getElapsedCpuTime();
                                                int i571111 = ~((-1181388841) | elapsedCpuTime8);
                                                int i571112 = (-2012598375) + ((67141632 | i571111) * (-280)) + ((i571111 | (~((-1676352046) | elapsedCpuTime8))) * 140);
                                                int i571113 = ~((-1114247209) | elapsedCpuTime8);
                                                int i571114 = ~elapsedCpuTime8;
                                                int i571115 = ((int) j919) & (i571112 + (((~(i571114 | (-562104838))) | i571113 | (~((-67141633) | i571114))) * 140));
                                                int i571116 = ((i571110 & i571115) | (i571110 ^ i571115)) * 263;
                                                i34 = (i571116 & i30) | ((~i571116) & i);
                                                if (i34 != i) {
                                                    objArr3 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i34}};
                                                    int i571117 = (int) Runtime.getRuntime().totalMemory();
                                                    int i571118 = 728361708 + ((~((-67246083) | i571117)) * (-301)) + (((~(132275923 | i571117)) | (~((~i571117) | 737724381))) * (-301)) + (((~(i571117 | (-737724382))) | 132275923) * 301);
                                                    int i571119 = i3 + (i571118 & 16) + (i571118 | 16);
                                                    int i581110 = i571119 << 13;
                                                    int i581111 = ((~i571119) & i581110) | ((~i581110) & i571119);
                                                    int i581112 = i581111 >>> 17;
                                                    int i581113 = ((~i581111) & i581112) | ((~i581112) & i581111);
                                                    int i581114 = i581113 << 5;
                                                    ((int[]) objArr3[1])[0] = (i581113 | i581114) & (~(i581113 & i581114));
                                                } else {
                                                    int[] iArr7 = new int[1];
                                                    objArr2 = new Object[]{null, iArr7, null, new int[]{i}, new int[]{i}};
                                                    int i581115 = -(-((-1013288380) + (((~((-9541173) | i30)) | (-595907286)) * (-933)) + (((~(i30 | (-595907286))) | 587481281) * 933) + 1323798898));
                                                    int i581116 = ((i3 | i581115) << 1) - (i3 ^ i581115);
                                                    int i581117 = i581116 << 13;
                                                    int i581118 = (i581117 | i581116) & (~(i581116 & i581117));
                                                    int i581119 = i581118 >>> 17;
                                                    int i5912 = (i581118 | i581119) & (~(i581118 & i581119));
                                                    int i5913 = i5912 << 5;
                                                    i35 = ((~i5912) & i5913) | ((~i5913) & i5912);
                                                    i36 = artificialFrame + 1;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i36 % 128;
                                                    iArr = iArr7;
                                                    if (i36 % 2 != 0) {
                                                        iArr[1] = i35;
                                                    } else {
                                                        iArr[0] = i35;
                                                    }
                                                }
                                            }
                                        }
                                        return objArr2;
                                    }
                                    objArr3 = new Object[]{null, new int[1], null, new int[]{i10}, new int[]{i16}};
                                    int i790 = (int) Runtime.getRuntime().totalMemory();
                                    int i791 = ~i790;
                                    int i792 = ~((-538660295) | i791);
                                    int i793 = ~((-66788164) | i790);
                                    int i794 = -(-(364936658 + ((i792 | i793) * 1150) + (((~(66788163 | i791)) | i793) * (-575)) + (((~(i790 | (-538660295))) | (~(i791 | 538660294))) * 575) + 16));
                                    int i795 = (i3 ^ i794) + ((i3 & i794) << 1);
                                    int i796 = i795 << 13;
                                    int i797 = (i796 | i795) & (~(i795 & i796));
                                    int i798 = i797 >>> 17;
                                    int i799 = ((~i797) & i798) | ((~i798) & i797);
                                    int i800 = i799 << 5;
                                    ((int[]) objArr3[1])[0] = (i799 | i800) & (~(i799 & i800));
                                }
                            }
                        }
                    }
                }
                return objArr3;
            }
        });
        stripSpansOfKind(spannableStringBuilder, CustomLetterSpacingSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda5
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$stripStyleEquivalentSpans$5((CustomLetterSpacingSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, CustomStyleSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$stripStyleEquivalentSpans$6((CustomStyleSpan) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$stripStyleEquivalentSpans$0(ReactAbsoluteSizeSpan reactAbsoluteSizeSpan) {
        return reactAbsoluteSizeSpan.getSize() == this.mTextAttributes.getEffectiveFontSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$stripStyleEquivalentSpans$1(ReactBackgroundColorSpan reactBackgroundColorSpan) {
        int backgroundColor = reactBackgroundColorSpan.getBackgroundColor();
        return Integer.valueOf(backgroundColor).equals(BackgroundStyleApplicator.getBackgroundColor(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$stripStyleEquivalentSpans$2(ReactForegroundColorSpan reactForegroundColorSpan) {
        return reactForegroundColorSpan.getForegroundColor() == getCurrentTextColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$stripStyleEquivalentSpans$3(ReactStrikethroughSpan reactStrikethroughSpan) {
        return (getPaintFlags() & 16) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$stripStyleEquivalentSpans$4(ReactUnderlineSpan reactUnderlineSpan) {
        return (getPaintFlags() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$stripStyleEquivalentSpans$5(CustomLetterSpacingSpan customLetterSpacingSpan) {
        return customLetterSpacingSpan.getSpacing() == this.mTextAttributes.getEffectiveLetterSpacing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$stripStyleEquivalentSpans$6(CustomStyleSpan customStyleSpan) {
        return customStyleSpan.getStyle() == this.mFontStyle && Objects.equals(customStyleSpan.getFontFamily(), this.mFontFamily) && customStyleSpan.getWeight() == this.mFontWeight && Objects.equals(customStyleSpan.getFontFeatureSettings(), getFontFeatureSettings());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void stripSpansOfKind(SpannableStringBuilder spannableStringBuilder, Class<T> cls, Predicate<T> predicate) {
        for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), cls)) {
            if (predicate.test(obj)) {
                spannableStringBuilder.removeSpan(obj);
            }
        }
    }

    private void addSpansFromStyleAttributes(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.setSpan(new ReactAbsoluteSizeSpan(this.mTextAttributes.getEffectiveFontSize()), 0, spannableStringBuilder.length(), 16711698);
        spannableStringBuilder.setSpan(new ReactForegroundColorSpan(getCurrentTextColor()), 0, spannableStringBuilder.length(), 16711698);
        Integer backgroundColor = BackgroundStyleApplicator.getBackgroundColor(this);
        if (backgroundColor != null && backgroundColor.intValue() != 0) {
            spannableStringBuilder.setSpan(new ReactBackgroundColorSpan(backgroundColor.intValue()), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 16) != 0) {
            spannableStringBuilder.setSpan(new ReactStrikethroughSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 8) != 0) {
            spannableStringBuilder.setSpan(new ReactUnderlineSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        float effectiveLetterSpacing = this.mTextAttributes.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing)) {
            spannableStringBuilder.setSpan(new CustomLetterSpacingSpan(effectiveLetterSpacing), 0, spannableStringBuilder.length(), 16711698);
        }
        if (this.mFontStyle != -1 || this.mFontWeight != -1 || this.mFontFamily != null || getFontFeatureSettings() != null) {
            spannableStringBuilder.setSpan(new CustomStyleSpan(this.mFontStyle, this.mFontWeight, getFontFeatureSettings(), this.mFontFamily, getContext().getAssets()), 0, spannableStringBuilder.length(), 16711698);
        }
        float effectiveLineHeight = this.mTextAttributes.getEffectiveLineHeight();
        if (Float.isNaN(effectiveLineHeight)) {
            return;
        }
        spannableStringBuilder.setSpan(new CustomLineHeightSpan(effectiveLineHeight), 0, spannableStringBuilder.length(), 16711698);
    }

    private static boolean sameTextForSpan(Editable editable, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i > spannableStringBuilder.length() || i2 > spannableStringBuilder.length()) {
            return false;
        }
        while (i < i2) {
            if (editable.charAt(i) != spannableStringBuilder.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    protected boolean showSoftKeyboard() {
        return this.mInputMethodManager.showSoftInput(this, 0);
    }

    protected void hideSoftKeyboard() {
        this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private TextWatcherDelegator getTextWatcherDelegator() {
        if (this.mTextWatcherDelegator == null) {
            this.mTextWatcherDelegator = new TextWatcherDelegator();
        }
        return this.mTextWatcherDelegator;
    }

    boolean isMultiline() {
        return (getInputType() & 131072) != 0;
    }

    private boolean isSecureText() {
        return (getInputType() & SyslogConstants.LOG_LOCAL2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onContentSizeChange() {
        ContentSizeWatcher contentSizeWatcher = this.mContentSizeWatcher;
        if (contentSizeWatcher != null) {
            contentSizeWatcher.onLayout();
        }
        setIntrinsicContentSize();
    }

    private void setIntrinsicContentSize() {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        if (this.mStateWrapper != null || reactContext.isBridgeless()) {
            return;
        }
        ReactTextInputLocalData reactTextInputLocalData = new ReactTextInputLocalData(this);
        UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.setViewLocalData(getId(), reactTextInputLocalData);
        }
    }

    int getGravityHorizontal() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & (-8388616)));
    }

    void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & (-113)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    private void updateImeOptions() {
        byte b;
        String str = this.mReturnKeyType;
        int i = 6;
        if (str != null) {
            str.hashCode();
            switch (str) {
                case "previous":
                    b = 0;
                    break;
                case "search":
                    b = 1;
                    break;
                case "go":
                    b = 2;
                    break;
                case "done":
                    b = 3;
                    break;
                case "next":
                    b = 4;
                    break;
                case "none":
                    b = 5;
                    break;
                case "send":
                    b = 6;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i = 7;
            } else if (b == 1) {
                i = 3;
            } else if (b == 2) {
                i = 2;
            } else if (b == 4) {
                i = 5;
            } else if (b == 5) {
                i = 1;
            } else if (b == 6) {
                i = 4;
            }
        }
        if (this.mDisableFullscreen) {
            setImeOptions(33554432 | i);
        } else {
            setImeOptions(i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onDetachedFromWindow();
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onStartTemporaryDetach();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setTextIsSelectable(true);
        maybeSetSelection(selectionStart, selectionEnd);
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onAttachedToWindow();
            }
        }
        if (this.mAutoFocus && !this.mDidAttachToWindow) {
            requestFocusInternal();
        }
        this.mDidAttachToWindow = true;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.onFinishTemporaryDetach();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(i));
    }

    public void setBorderWidth(int i, float f) {
        BackgroundStyleApplicator.setBorderWidth(this, LogicalEdge.values()[i], Float.valueOf(PixelUtil.toDIPFromPixel(f)));
    }

    public void setBorderColor(int i, @Nullable Integer num) {
        BackgroundStyleApplicator.setBorderColor(this, LogicalEdge.values()[i], num);
    }

    public int getBorderColor(int i) {
        Integer borderColor = BackgroundStyleApplicator.getBorderColor(this, LogicalEdge.values()[i]);
        if (borderColor == null) {
            return 0;
        }
        return borderColor.intValue();
    }

    public void setBorderRadius(float f) {
        setBorderRadius(f, BorderRadiusProp.BORDER_RADIUS.ordinal());
    }

    public void setBorderRadius(float f, int i) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.values()[i], Float.isNaN(f) ? null : new LengthPercentage(PixelUtil.toDIPFromPixel(f), LengthPercentageType.POINT));
    }

    public void setBorderStyle(@Nullable String str) {
        BackgroundStyleApplicator.setBorderStyle(this, str == null ? null : BorderStyle.fromString(str));
    }

    public void setLetterSpacingPt(float f) {
        this.mTextAttributes.setLetterSpacing(f);
        applyTextAttributes();
    }

    public void setAllowFontScaling(boolean z) {
        if (this.mTextAttributes.getAllowFontScaling() != z) {
            this.mTextAttributes.setAllowFontScaling(z);
            applyTextAttributes();
        }
    }

    public void setFontSize(float f) {
        this.mTextAttributes.setFontSize(f);
        applyTextAttributes();
    }

    public void setMaxFontSizeMultiplier(float f) {
        if (f != this.mTextAttributes.getMaxFontSizeMultiplier()) {
            this.mTextAttributes.setMaxFontSizeMultiplier(f);
            applyTextAttributes();
        }
    }

    public void setAutoFocus(boolean z) {
        this.mAutoFocus = z;
    }

    public void setSelectTextOnFocus(boolean z) {
        super.setSelectAllOnFocus(z);
        this.mSelectTextOnFocus = z;
    }

    public void setContextMenuHidden(boolean z) {
        this.mContextMenuHidden = z;
    }

    protected void applyTextAttributes() {
        setTextSize(0, this.mTextAttributes.getEffectiveFontSize());
        float effectiveLetterSpacing = this.mTextAttributes.getEffectiveLetterSpacing();
        if (Float.isNaN(effectiveLetterSpacing)) {
            return;
        }
        setLetterSpacing(effectiveLetterSpacing);
    }

    public StateWrapper getStateWrapper() {
        return this.mStateWrapper;
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCachedSpannable() {
        if (this.mStateWrapper == null || getId() == -1) {
            return;
        }
        Editable text = getText();
        boolean z = text != null && text.length() > 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (z) {
            try {
                spannableStringBuilder.append(text.subSequence(0, text.length()));
            } catch (IndexOutOfBoundsException e) {
                ReactSoftExceptionLogger.logSoftException(this.TAG, e);
            }
        }
        if (!z) {
            if (getHint() != null && getHint().length() > 0) {
                spannableStringBuilder.append(getHint());
            } else if (ViewUtil.getUIManagerType(this) != 2) {
                spannableStringBuilder.append("I");
            }
        }
        addSpansFromStyleAttributes(spannableStringBuilder);
        spannableStringBuilder.setSpan(new ReactTextPaintHolderSpan(new TextPaint(getPaint())), 0, spannableStringBuilder.length(), 18);
        TextLayoutManager.setCachedSpannableForTag(getId(), spannableStringBuilder);
    }

    void setEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        this.mEventDispatcher = eventDispatcher;
    }

    public void setOverflow(@Nullable String str) {
        if (str == null) {
            this.mOverflow = Overflow.VISIBLE;
        } else {
            Overflow overflowFromString = Overflow.fromString(str);
            if (overflowFromString == null) {
                overflowFromString = Overflow.VISIBLE;
            }
            this.mOverflow = overflowFromString;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mOverflow != Overflow.VISIBLE) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        super.onDraw(canvas);
    }

    class TextWatcherDelegator implements TextWatcher {
        private TextWatcherDelegator() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ReactEditText reactEditText = ReactEditText.this;
            if (reactEditText.mIsSettingTextFromJS || reactEditText.mListeners == null) {
                return;
            }
            Iterator it2 = ReactEditText.this.mListeners.iterator();
            while (it2.hasNext()) {
                ((TextWatcher) it2.next()).beforeTextChanged(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (ReactEditText.DEBUG_MODE) {
                FLog.e(ReactEditText.this.TAG, "onTextChanged[" + ReactEditText.this.getId() + "]: " + ((Object) charSequence) + StringUtils.SPACE + i + StringUtils.SPACE + i2 + StringUtils.SPACE + i3);
            }
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.mIsSettingTextFromJS && reactEditText.mListeners != null) {
                Iterator it2 = ReactEditText.this.mListeners.iterator();
                while (it2.hasNext()) {
                    ((TextWatcher) it2.next()).onTextChanged(charSequence, i, i2, i3);
                }
            }
            ReactEditText.this.updateCachedSpannable();
            ReactEditText.this.onContentSizeChange();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ReactEditText reactEditText = ReactEditText.this;
            if (reactEditText.mIsSettingTextFromJS || reactEditText.mListeners == null) {
                return;
            }
            Iterator it2 = ReactEditText.this.mListeners.iterator();
            while (it2.hasNext()) {
                ((TextWatcher) it2.next()).afterTextChanged(editable);
            }
        }
    }

    static class InternalKeyListener implements KeyListener {
        private int mInputType = 0;

        public void setInputType(int i) {
            this.mInputType = i;
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return this.mInputType;
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyDown(view, editable, i, keyEvent);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyUp(view, editable, i, keyEvent);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyOther(view, editable, keyEvent);
        }

        @Override // android.text.method.KeyListener
        public void clearMetaKeyState(View view, Editable editable, int i) {
            ReactEditText.sKeyListener.clearMetaKeyState(view, editable, i);
        }
    }
}
