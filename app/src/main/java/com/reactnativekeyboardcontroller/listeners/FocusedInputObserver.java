package com.reactnativekeyboardcontroller.listeners;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEventData;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEventData;
import com.reactnativekeyboardcontroller.events.FocusedInputTextChangedEvent;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator;
import io.sentry.protocol.SentryThread;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.asBinder;
import o.build;
import o.extraCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class FocusedInputObserver {
    private final ThemedReactContext context;
    private final ReactViewGroup eventPropagationView;
    private final ViewTreeObserver.OnGlobalFocusChangeListener focusListener;
    private FocusedInputLayoutChangedEventData lastEventDispatched;
    private EditText lastFocusedInput;
    private final View.OnLayoutChangeListener layoutListener;
    private final Function6<Integer, Integer, Double, Double, Double, Double, Unit> selectionListener;
    private Function0<Unit> selectionSubscription;
    private final int surfaceId;
    private final Function1<String, Unit> textListener;
    private TextWatcher textWatcher;
    private final View view;
    private static final byte[] $$c = {125, 126, -45, -128};
    private static final int $$d = 36;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {5, Ascii.ESC, -76, Ascii.CR, 50, Ascii.SO, 3, Ascii.DC4, -50, Ascii.SYN, -3, 8, -5, Ascii.SYN, -16, 32, 8, 6, 36, 8, 3, 10, Ascii.DC2, 8, 5, Ascii.DLE, 5, 1, Ascii.ESC, Ascii.SYN, -16, Ascii.US, 5, Ascii.DLE, 10, 2, 5, 0, -8, Ascii.DC4, -9, Ascii.SO, -5, 1, -6, Ascii.GS, 10, 4, -9, 5, Ascii.VT, -2, Ascii.DC2, 3};
    private static final int $$b = 206;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char TopicBuilder = 57056;
    private static char ICustomTabsCallback = 48771;
    private static char extraCallbackWithResult = 55584;
    private static char onMessageChannelReady = CoreConstants.SINGLE_QUOTE_CHAR;
    private static long extraCommand = -5396315674384523409L;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, int r7, int r8) {
        /*
            int r8 = r8 * 2
            int r8 = 118 - r8
            byte[] r0 = com.reactnativekeyboardcontroller.listeners.FocusedInputObserver.$$c
            int r6 = r6 * 3
            int r6 = 1 - r6
            int r7 = r7 * 2
            int r7 = 4 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r6
            r8 = r7
            r4 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            r3 = r0[r7]
        L27:
            int r7 = r7 + 1
            int r3 = -r3
            int r8 = r8 + r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver.$$e(int, int, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 4 - r8
            int r6 = 115 - r6
            byte[] r0 = com.reactnativekeyboardcontroller.listeners.FocusedInputObserver.$$a
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r8
            r4 = r2
            goto L24
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r8) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            int r7 = r7 + 1
            r3 = r0[r7]
        L24:
            int r6 = r6 + r3
            int r6 = r6 + (-5)
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver.b(int, short, short, java.lang.Object[]):void");
    }

    public FocusedInputObserver(@NotNull View view, @NotNull ReactViewGroup eventPropagationView, @Nullable ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventPropagationView, "eventPropagationView");
        this.view = view;
        this.eventPropagationView = eventPropagationView;
        this.context = themedReactContext;
        this.surfaceId = UIManagerHelper.getSurfaceId(view);
        this.lastEventDispatched = FocusedInputObserverKt.getNoFocusedInputEvent();
        this.layoutListener = new View.OnLayoutChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.syncUpLayout();
            }
        };
        this.textListener = new Function1() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FocusedInputObserver.textListener$lambda$1(this.f$0, (String) obj);
            }
        };
        this.selectionListener = new Function6() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2
            private static final byte[] $$c = {SignedBytes.MAX_POWER_OF_TWO, -32, 40, -103};
            private static final int $$d = 78;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {123, -109, -37, -17, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, -50, -14, 50};
            private static final int $$b = 114;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] ArtificialStackFrames = {44398, 44353, 44355, 44384, 44385, 44388, 44397, 44333, 44395, 44402, 44697, 44696, 44701, 44334, 44404, 44361, 44690, 44700, 44699, 44400, 44405, 44698, 44337, 44386, 44396, 44702, 44389, 44403, 44390, 44399, 44408, 44703, 44335, 44387, 44393, 44391};
            private static char coroutineCreation = 39068;

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r6, byte r7, short r8) {
                /*
                    int r7 = r7 * 2
                    int r0 = r7 + 1
                    int r8 = r8 + 97
                    int r6 = r6 * 3
                    int r6 = 3 - r6
                    byte[] r1 = com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2.$$c
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    if (r1 != 0) goto L15
                    r8 = r6
                    r4 = r7
                    r3 = r2
                    goto L2a
                L15:
                    r3 = r2
                L16:
                    byte r4 = (byte) r8
                    int r6 = r6 + 1
                    r0[r3] = r4
                    if (r3 != r7) goto L23
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    return r6
                L23:
                    r4 = r1[r6]
                    int r3 = r3 + 1
                    r5 = r8
                    r8 = r6
                    r6 = r5
                L2a:
                    int r4 = -r4
                    int r6 = r6 + r4
                    r5 = r8
                    r8 = r6
                    r6 = r5
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2.$$e(int, byte, short):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0022  */
            /* JADX WARN: Code duplicated, block: B:8:0x001a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void a(short r5, byte r6, int r7, java.lang.Object[] r8) {
                /*
                    int r6 = r6 + 66
                    int r5 = r5 + 4
                    int r0 = 28 - r7
                    byte[] r1 = com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2.$$a
                    byte[] r0 = new byte[r0]
                    int r7 = 27 - r7
                    r2 = 0
                    if (r1 != 0) goto L12
                    r3 = r7
                    r4 = r2
                    goto L26
                L12:
                    r3 = r2
                L13:
                    byte r4 = (byte) r6
                    r0[r3] = r4
                    int r4 = r3 + 1
                    if (r3 != r7) goto L22
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0, r2)
                    r8[r2] = r5
                    return
                L22:
                    int r5 = r5 + 1
                    r3 = r1[r5]
                L26:
                    int r3 = -r3
                    int r6 = r6 + r3
                    int r6 = r6 + (-5)
                    r3 = r4
                    goto L13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2.a(short, byte, int, java.lang.Object[]):void");
            }

            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return FocusedInputObserver.selectionListener$lambda$2(this.f$0, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Double) obj3).doubleValue(), ((Double) obj4).doubleValue(), ((Double) obj5).doubleValue(), ((Double) obj6).doubleValue());
            }

            private static void b(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
                int i2;
                Object obj;
                int length;
                char[] cArr2;
                char c = 2;
                int i3 = 2 % 2;
                extraCallback extracallback = new extraCallback();
                char[] cArr3 = ArtificialStackFrames;
                char c2 = '0';
                int i4 = -1819279892;
                Object obj2 = null;
                if (cArr3 != null) {
                    int i5 = $11 + 3;
                    $10 = i5 % 128;
                    if (i5 % 2 != 0) {
                        length = cArr3.length;
                        cArr2 = new char[length];
                    } else {
                        length = cArr3.length;
                        cArr2 = new char[length];
                    }
                    int i6 = 0;
                    while (i6 < length) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr3[i6])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) 0;
                                byte b3 = b2;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 15, (char) (20536 - AndroidCharacter.getMirror(c2)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2148, 216710116, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE});
                            }
                            cArr2[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i6++;
                            c2 = '0';
                            i4 = -1819279892;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    int i7 = $10 + 59;
                    $11 = i7 % 128;
                    if (i7 % 2 == 0) {
                        int i8 = 2 / 4;
                    }
                    cArr3 = cArr2;
                }
                Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                if (objAccessartificialFrame2 == null) {
                    byte b4 = (byte) 0;
                    byte b5 = b4;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(16 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionType(0L) + 20488), 2148 - KeyEvent.keyCodeFromString(""), 216710116, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
                }
                char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                char[] cArr4 = new char[i];
                if (i % 2 != 0) {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                } else {
                    i2 = i;
                }
                if (i2 > 1) {
                    int i9 = $11 + 33;
                    $10 = i9 % 128;
                    if (i9 % 2 != 0) {
                        extracallback.a = 1;
                    } else {
                        extracallback.a = 0;
                    }
                    while (extracallback.a < i2) {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a + 1];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            obj = obj2;
                        } else {
                            Object[] objArr4 = new Object[13];
                            objArr4[12] = extracallback;
                            objArr4[11] = Integer.valueOf(cCharValue);
                            objArr4[10] = extracallback;
                            objArr4[9] = extracallback;
                            objArr4[8] = Integer.valueOf(cCharValue);
                            objArr4[7] = extracallback;
                            objArr4[6] = extracallback;
                            objArr4[5] = Integer.valueOf(cCharValue);
                            objArr4[4] = extracallback;
                            objArr4[3] = extracallback;
                            objArr4[c] = Integer.valueOf(cCharValue);
                            objArr4[1] = extracallback;
                            objArr4[0] = extracallback;
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame3 == null) {
                                byte b6 = (byte) 0;
                                byte b7 = b6;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(46 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (58859 - Color.red(0)), KeyEvent.getDeadChar(0, 0) + 2464, 276640984, false, $$e(b6, b7, (byte) (b7 + 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                int i10 = $10 + 21;
                                $11 = i10 % 128;
                                int i11 = i10 % 2;
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    byte b8 = (byte) 0;
                                    byte b9 = b8;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 25, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (KeyEvent.getMaxKeyCode() >> 16) + 792, -834291897, false, $$e(b8, b9, (byte) (b9 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i12 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr3[iIntValue];
                                cArr4[extracallback.a + 1] = cArr3[i12];
                                int i13 = $10 + 21;
                                $11 = i13 % 128;
                                if (i13 % 2 == 0) {
                                    int i14 = 3 % 5;
                                }
                            } else {
                                obj = null;
                                if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i15 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i16 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr3[i15];
                                    cArr4[extracallback.a + 1] = cArr3[i16];
                                } else {
                                    int i17 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i18 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr3[i17];
                                    cArr4[extracallback.a + 1] = cArr3[i18];
                                }
                            }
                        }
                        extracallback.a += 2;
                        c = 2;
                        obj2 = obj;
                    }
                }
                for (int i19 = 0; i19 < i; i19++) {
                    cArr4[i19] = (char) (cArr4[i19] ^ 13722);
                }
                objArr[0] = new String(cArr4);
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r33, int r34, int r35, int r36) {
                /*
                    Method dump skipped, instruction units count: 2921
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        };
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                FocusedInputObserver.focusListener$lambda$6(this.f$0, view2, view3);
            }
        };
        this.focusListener = onGlobalFocusChangeListener;
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    public final View getView() {
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textListener$lambda$1(FocusedInputObserver focusedInputObserver, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        focusedInputObserver.syncUpLayout();
        ThemedReactContextKt.dispatchEvent(focusedInputObserver.context, focusedInputObserver.eventPropagationView.getId(), new FocusedInputTextChangedEvent(focusedInputObserver.surfaceId, focusedInputObserver.eventPropagationView.getId(), text));
        return Unit.INSTANCE;
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i4 = $11 + 27;
        $10 = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 3 / 5;
        }
        while (asbinder.d < cArr.length) {
            int i6 = $11 + 9;
            $10 = i6 % 128;
            if (i6 % i2 != 0) {
                int i7 = asbinder.d;
                char c = cArr[asbinder.d];
                try {
                    Object[] objArr2 = new Object[3];
                    objArr2[i2] = asbinder;
                    objArr2[1] = asbinder;
                    objArr2[0] = Integer.valueOf(c);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        int iCombineMeasuredStates = 11 - View.combineMeasuredStates(0, 0);
                        char mode = (char) View.MeasureSpec.getMode(0);
                        int iNormalizeMetaState = 1407 - KeyEvent.normalizeMetaState(0);
                        byte b = (byte) 0;
                        byte b2 = b;
                        String str$$e = $$e(b, b2, b2);
                        Class[] clsArr = new Class[3];
                        clsArr[0] = Integer.TYPE;
                        clsArr[1] = Object.class;
                        clsArr[i2] = Object.class;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, mode, iNormalizeMetaState, 1035473698, false, str$$e, clsArr);
                    }
                    jArr[i7] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() - (extraCommand - (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        int doubleTapTimeout = 8 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                        int i8 = 250 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        Class[] clsArr2 = new Class[i2];
                        clsArr2[0] = Object.class;
                        clsArr2[1] = Object.class;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, cCombineMeasuredStates, i8, 378009232, false, "w", clsArr2);
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i9 = asbinder.d;
                char c2 = cArr[asbinder.d];
                Object[] objArr4 = new Object[3];
                objArr4[i2] = asbinder;
                objArr4[1] = asbinder;
                objArr4[0] = Integer.valueOf(c2);
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame3 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 11, (char) View.MeasureSpec.makeMeasureSpec(0, 0), (Process.myPid() >> 22) + 1407, 1035473698, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i9] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 8, (char) (ViewConfiguration.getEdgeSlop() >> 16), 249 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                i2 = 2;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        int i10 = $10 + 45;
        $11 = i10 % 128;
        int i11 = i10 % 2;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            try {
                Object[] objArr6 = {asbinder, asbinder};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getTrimmedLength(""), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), TextUtils.indexOf((CharSequence) "", '0') + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectionListener$lambda$2(FocusedInputObserver focusedInputObserver, int i, int i2, double d, double d2, double d3, double d4) {
        EditText editText = focusedInputObserver.lastFocusedInput;
        if (editText == null) {
            return Unit.INSTANCE;
        }
        focusedInputObserver.syncUpLayout();
        ThemedReactContextKt.dispatchEvent(focusedInputObserver.context, focusedInputObserver.eventPropagationView.getId(), new FocusedInputSelectionChangedEvent(focusedInputObserver.surfaceId, focusedInputObserver.eventPropagationView.getId(), new FocusedInputSelectionChangedEventData(editText.getId(), d, d2, d3, d4, i, i2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void focusListener$lambda$6(FocusedInputObserver focusedInputObserver, View view, View view2) {
        if (view2 == null || view != null) {
            EditText editText = focusedInputObserver.lastFocusedInput;
            if (editText != null) {
                editText.removeOnLayoutChangeListener(focusedInputObserver.layoutListener);
            }
            final EditText editText2 = focusedInputObserver.lastFocusedInput;
            if (editText2 != null) {
                final TextWatcher textWatcher = focusedInputObserver.textWatcher;
                editText2.post(new Runnable() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        editText2.removeTextChangedListener(textWatcher);
                    }
                });
            }
            Function0<Unit> function0 = focusedInputObserver.selectionSubscription;
            if (function0 != null) {
                function0.invoke();
            }
            focusedInputObserver.lastFocusedInput = null;
        }
        if (view2 instanceof EditText) {
            EditText editText3 = (EditText) view2;
            focusedInputObserver.lastFocusedInput = editText3;
            editText3.addOnLayoutChangeListener(focusedInputObserver.layoutListener);
            focusedInputObserver.syncUpLayout();
            focusedInputObserver.textWatcher = EditTextKt.addOnTextChangedListener(editText3, focusedInputObserver.textListener);
            focusedInputObserver.selectionSubscription = EditTextKt.addOnSelectionChangedListener(editText3, focusedInputObserver.selectionListener);
            FocusedInputHolder.INSTANCE.set(editText3);
            ViewHierarchyNavigator viewHierarchyNavigator = ViewHierarchyNavigator.INSTANCE;
            ThemedReactContext themedReactContext = focusedInputObserver.context;
            List<EditText> allInputFields = viewHierarchyNavigator.getAllInputFields(themedReactContext != null ? ReactContextKt.getRootView(themedReactContext) : null);
            int iIndexOf = allInputFields.indexOf(view2);
            ThemedReactContext themedReactContext2 = focusedInputObserver.context;
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt(SentryThread.JsonKeys.CURRENT, iIndexOf);
            writableMapCreateMap.putInt("count", allInputFields.size());
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            ThemedReactContextKt.emitEvent(themedReactContext2, "KeyboardController::focusDidSet", writableMapCreateMap);
        }
        if (view2 == null) {
            focusedInputObserver.dispatchEventToJS(FocusedInputObserverKt.getNoFocusedInputEvent());
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            int i5 = $11 + 89;
            $10 = i5 % 128;
            int i6 = i5 % i3;
            cArr3[0] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i7 = 58224;
            int i8 = 0;
            while (i8 < 16) {
                int i9 = $11 + 57;
                $10 = i9 % 128;
                int i10 = i9 % i3;
                char c = cArr3[1];
                char c2 = cArr3[0];
                int i11 = (c2 + i7) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                int i12 = c2 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(onMessageChannelReady);
                    objArr2[i3] = Integer.valueOf(i12);
                    objArr2[1] = Integer.valueOf(i11);
                    objArr2[0] = Integer.valueOf(c);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 28, (char) (17262 - TextUtils.lastIndexOf("", '0')), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1066, 1042277788, false, $$e(b, b2, (byte) (b2 + 5)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(28 - TextUtils.getOffsetAfter("", 0), (char) (17262 - Process.getGidForName("")), 1067 - View.resolveSizeAndState(0, 0, 0), 1042277788, false, $$e(b3, b4, (byte) (b4 + 5)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i7 -= 40503;
                    i8++;
                    i3 = 2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                i2 = 2;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 25, (char) (63929 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), View.MeasureSpec.getSize(0) + 486, 1554985764, false, $$e(b5, b5, (byte) $$c.length), new Class[]{Object.class, Object.class});
            } else {
                i2 = 2;
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            i3 = i2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    public final void syncUpLayout() {
        EditText editText = this.lastFocusedInput;
        if (editText == null) {
            return;
        }
        int[] screenLocation = ViewKt.getScreenLocation(editText);
        dispatchEventToJS(new FocusedInputLayoutChangedEventData(FloatKt.getDp(editText.getX()), FloatKt.getDp(editText.getY()), FloatKt.getDp(editText.getWidth()), FloatKt.getDp(editText.getHeight()), FloatKt.getDp(screenLocation[0]), FloatKt.getDp(screenLocation[1]), editText.getId(), EditTextKt.getParentScrollViewTarget(editText)));
    }

    public final void destroy() {
        this.view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.focusListener);
    }

    private final void dispatchEventToJS(FocusedInputLayoutChangedEventData focusedInputLayoutChangedEventData) {
        if (Intrinsics.areEqual(focusedInputLayoutChangedEventData, this.lastEventDispatched)) {
            return;
        }
        this.lastEventDispatched = focusedInputLayoutChangedEventData;
        ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new FocusedInputLayoutChangedEvent(this.surfaceId, this.eventPropagationView.getId(), focusedInputLayoutChangedEventData));
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 188401. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.lang.Object[] accessartificialFrame$78cbbd35(int r76, int r77, java.lang.Object r78, int r79, boolean r80) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 18840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
