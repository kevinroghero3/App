package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda131;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.swmansion.reanimated.Utils;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStack;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SharedTransitionManager {
    private final AnimationsManager mAnimationsManager;
    private NativeMethodsHolder mNativeMethodsHolder;
    private View mTransitionContainer;
    private final List<View> mAddedSharedViews = new ArrayList();
    private final Map<Integer, View> mSharedTransitionParent = new HashMap();
    private final Map<Integer, Integer> mSharedTransitionInParentIndex = new HashMap();
    private final Map<Integer, Snapshot> mSnapshotRegistry = new HashMap();
    private final Map<Integer, View> mCurrentSharedTransitionViews = new HashMap();
    private final Map<Integer, SortedSet<Integer>> mSharedViewChildrenIndices = new HashMap();
    private final List<View> mRemovedSharedViews = new ArrayList();
    private final Set<Integer> mViewTagsToHide = new HashSet();
    private final Map<Integer, Integer> mDisableCleaningForViewTag = new HashMap();
    private List<SharedElement> mSharedElements = new ArrayList();
    private final Map<Integer, SharedElement> mSharedElementsLookup = new HashMap();
    private final List<SharedElement> mSharedElementsWithProgress = new ArrayList();
    private final List<SharedElement> mSharedElementsWithAnimation = new ArrayList();
    private final Set<View> mReattachedViews = new HashSet();
    private boolean mIsTransitionPrepared = false;
    private final Set<Integer> mTagsToCleanup = new HashSet();

    interface TreeVisitor {
        void run(View view);
    }

    protected void viewDidLayout(View view) {
    }

    class TopWillAppearListener implements EventDispatcherListener {
        private final EventDispatcher mEventDispatcher;

        public TopWillAppearListener(EventDispatcher eventDispatcher) {
            this.mEventDispatcher = eventDispatcher;
        }

        @Override // com.facebook.react.uimanager.events.EventDispatcherListener
        public void onEventDispatch(Event event) {
            if (event.getEventName().equals("topWillAppear")) {
                SharedTransitionManager sharedTransitionManager = SharedTransitionManager.this;
                sharedTransitionManager.tryStartSharedTransitionForViews(sharedTransitionManager.mAddedSharedViews, true);
                SharedTransitionManager.this.mAddedSharedViews.clear();
                this.mEventDispatcher.removeListener(this);
            }
        }
    }

    public SharedTransitionManager(AnimationsManager animationsManager) {
        this.mAnimationsManager = animationsManager;
    }

    protected void notifyAboutNewView(View view) {
        this.mAddedSharedViews.add(view);
    }

    protected void notifyAboutRemovedView(View view) {
        this.mRemovedSharedViews.add(view);
    }

    @Nullable
    protected View getTransitioningView(int i) {
        return this.mCurrentSharedTransitionViews.get(Integer.valueOf(i));
    }

    protected void screenDidLayout(View view) {
        EventDispatcher eventDispatcherForReactTag;
        if (this.mAddedSharedViews.isEmpty() || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) view.getContext(), view.getId())) == null) {
            return;
        }
        eventDispatcherForReactTag.addListener(new TopWillAppearListener(eventDispatcherForReactTag));
    }

    protected void onViewsRemoval(int[] iArr) {
        if (iArr == null) {
            return;
        }
        visitTreeForTags(iArr, new SnapshotTreeVisitor());
        if (this.mRemovedSharedViews.size() > 0) {
            boolean zPrepareSharedTransition = prepareSharedTransition(this.mRemovedSharedViews, false);
            this.mIsTransitionPrepared = zPrepareSharedTransition;
            if (!zPrepareSharedTransition) {
                this.mRemovedSharedViews.clear();
            }
            visitTreeForTags(iArr, new PrepareConfigCleanupTreeVisitor());
        }
    }

    protected void doSnapshotForTopScreenViews(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                visitNativeTreeAndMakeSnapshot(((ViewGroup) childAt).getChildAt(0));
            } else {
                SentryLogcatAdapter.e("[Reanimated]", "Unable to recognize screen on stack.");
            }
        }
    }

    public class SnapshotTreeVisitor implements TreeVisitor {
        private static final byte[] $$c = {Ascii.EM, -12, SignedBytes.MAX_POWER_OF_TWO, 107};
        private static final int $$d = 213;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {32, -58, -29, Ascii.ETB, -11, -2, Ascii.FF};
        private static final int $$b = JfifUtil.MARKER_SOI;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int setDefaultImpl = -260894087;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r6, short r7, short r8) {
            /*
                byte[] r0 = com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.SnapshotTreeVisitor.$$c
                int r6 = r6 * 2
                int r6 = 116 - r6
                int r8 = r8 * 2
                int r1 = r8 + 1
                int r7 = r7 * 2
                int r7 = r7 + 4
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L17
                r6 = r7
                r4 = r8
                r3 = r2
                goto L2a
            L17:
                r3 = r2
            L18:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r8) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L23:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r5
            L2a:
                int r4 = -r4
                int r7 = r7 + r4
                int r6 = r6 + 1
                r5 = r7
                r7 = r6
                r6 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.SnapshotTreeVisitor.$$e(short, short, short):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(short r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 2
                int r8 = r8 + 109
                int r7 = r7 + 4
                byte[] r0 = com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.SnapshotTreeVisitor.$$a
                int r9 = r9 * 2
                int r9 = 4 - r9
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r8
                r4 = r2
                r8 = r7
                goto L2d
            L15:
                r3 = r2
            L16:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                int r7 = r7 + 1
                if (r4 != r9) goto L27
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L27:
                r3 = r0[r7]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r6
            L2d:
                int r7 = -r7
                int r3 = r3 + r7
                int r7 = r3 + (-3)
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.SnapshotTreeVisitor.b(short, byte, short, java.lang.Object[]):void");
        }

        private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
            int i4 = 2 % 2;
            onNavigationEvent onnavigationevent = new onNavigationEvent();
            char[] cArr2 = new char[i3];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i3) {
                onnavigationevent.c = cArr[onnavigationevent.d];
                cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
                int i5 = onnavigationevent.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                    if (objAccessartificialFrame == null) {
                        int iResolveOpacity = 22 - Drawable.resolveOpacity(0, 0);
                        char cResolveSize = (char) View.resolveSize(0, 0);
                        int iBlue = Color.blue(0) + 1775;
                        byte b = (byte) ($$d & 3);
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cResolveSize, iBlue, -2069783171, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - TextUtils.getOffsetAfter("", 0), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 56277), Process.getGidForName("") + 1260, 711931141, false, $$e(b3, b4, b4), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (i > 0) {
                int i6 = $10 + 125;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                onnavigationevent.b = i;
                char[] cArr3 = new char[i3];
                System.arraycopy(cArr2, 0, cArr3, 0, i3);
                System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
                System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
            }
            if (z) {
                char[] cArr4 = new char[i3];
                onnavigationevent.d = 0;
                while (onnavigationevent.d < i3) {
                    int i8 = $11 + 51;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                    Object[] objArr4 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(36 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 56277), 1259 - TextUtils.indexOf("", ""), 711931141, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }

        SnapshotTreeVisitor() {
        }

        @Override // com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.TreeVisitor
        public void run(View view) {
            if (SharedTransitionManager.this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                SharedTransitionManager.this.mRemovedSharedViews.add(view);
                SharedTransitionManager.this.makeSnapshot(view);
            }
        }

        /* JADX WARN: Code duplicated, block: B:103:0x0a90  */
        /* JADX WARN: Code duplicated, block: B:104:0x0a92 A[Catch: Exception -> 0x0bf8, TRY_LEAVE, TryCatch #6 {Exception -> 0x0bf8, blocks: (B:101:0x0a1b, B:104:0x0a92, B:112:0x0be9, B:114:0x0bf1, B:115:0x0bf7, B:105:0x0a9c, B:109:0x0b20, B:111:0x0b53, B:110:0x0b34), top: B:146:0x0a1b, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:108:0x0b1f  */
        /* JADX WARN: Code duplicated, block: B:110:0x0b34 A[Catch: all -> 0x0bf0, TryCatch #0 {all -> 0x0bf0, blocks: (B:105:0x0a9c, B:109:0x0b20, B:111:0x0b53, B:110:0x0b34), top: B:136:0x0a9c, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x0c84  */
        /* JADX WARN: Code duplicated, block: B:122:0x0c95  */
        /* JADX WARN: Code duplicated, block: B:146:0x0a1b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:96:0x094a  */
        /* JADX WARN: Code duplicated, block: B:97:0x094c A[Catch: Exception -> 0x0cae, TRY_LEAVE, TryCatch #1 {Exception -> 0x0cae, blocks: (B:94:0x08ff, B:97:0x094c, B:99:0x0a13, B:124:0x0ca7, B:125:0x0cad, B:98:0x0956), top: B:138:0x08ff, inners: #3 }] */
        public static Object[] coroutineCreation(int i, int i2) throws Throwable {
            Object[] objArr;
            Object[] objArr2;
            String line;
            File file;
            FileReader fileReader;
            BufferedReader bufferedReader;
            boolean zEquals;
            boolean zEquals2;
            Object[] objArr3;
            int i3;
            int i4;
            File file2;
            FileReader fileReader2;
            BufferedReader bufferedReader2;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int iGreen;
            int i10;
            int i11;
            int i12;
            int i13;
            char c;
            int i14;
            Object[] objArr4;
            int i15;
            int i16;
            int i17 = 2;
            int i18 = 2 % 2;
            try {
                int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() >> 16;
                int i19 = (doubleTapTimeout * (-501)) + 2012;
                int i20 = -(-(((~((-5) | i)) | (~(doubleTapTimeout | 4))) * (-502)));
                int i21 = ((i19 | i20) << 1) - (i20 ^ i19);
                int i22 = ~i;
                int i23 = ((-5) ^ i22) | ((-5) & i22);
                int i24 = i21 + ((~((i23 ^ doubleTapTimeout) | (i23 & doubleTapTimeout))) * (-502));
                int i25 = ~((~doubleTapTimeout) | i);
                int i26 = -(-(((i25 & (-5)) | ((-5) ^ i25)) * TypedValues.PositionType.TYPE_DRAWPATH));
                int i27 = ((i24 | i26) << 1) - (i24 ^ i26);
                int i28 = 241 - (~(ViewConfiguration.getPressedStateDuration() >> 16));
                int offsetAfter = TextUtils.getOffsetAfter("", 0);
                Object[] objArr5 = new Object[1];
                a(false, i27, i28, ((offsetAfter | 19) << 1) - (offsetAfter ^ 19), new char[]{65533, 14, 65535, 65534, 3, CharUtils.CR, 65502, 65535, 65532, 15, 1, 1, 65535, '\f', 65501, '\t', '\b', '\b', 65535}, objArr5);
                int i29 = 16 - (~(-View.MeasureSpec.getMode(0)));
                int i30 = -TextUtils.indexOf("", "");
                int iICustomTabsServiceDefault = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                int i31 = i30 * JfifUtil.MARKER_EOI;
                int i32 = (i31 & (-52245)) + (i31 | (-52245)) + ((~((i30 ^ iICustomTabsServiceDefault) | (i30 & iICustomTabsServiceDefault))) * JfifUtil.MARKER_SOI);
                int i33 = (i30 ^ (-244)) | (i30 & (-244));
                int i34 = ~iICustomTabsServiceDefault;
                int i35 = i32 + (((i33 & i34) | (i33 ^ i34)) * (-216));
                int i36 = -(-(((~(i30 | i34)) | 243) * JfifUtil.MARKER_SOI));
                int i37 = ((i35 | i36) << 1) - (i35 ^ i36);
                char mirror = AndroidCharacter.getMirror('0');
                int iICustomTabsServiceDefault2 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                int i38 = mirror * 450;
                int i39 = ((i38 | 13440) << 1) - (i38 ^ 13440);
                int i40 = ~mirror;
                int i41 = ~((i40 ^ (-30)) | (i40 & (-30)));
                int i42 = (29 ^ mirror) | (29 & mirror);
                int i43 = ~((i42 ^ iICustomTabsServiceDefault2) | (i42 & iICustomTabsServiceDefault2));
                int i44 = (i39 - (~(((i41 ^ i43) | (i43 & i41)) * 449))) - 1;
                int i45 = ~mirror;
                int i46 = i44 + ((~(i45 | (-30))) * (-1347));
                int i47 = ~((i45 & (-30)) | (i45 ^ (-30)));
                int i48 = ~iICustomTabsServiceDefault2;
                int i49 = (29 ^ i48) | (i48 & 29);
                int i50 = ~((mirror & i49) | (i49 ^ mirror));
                int i51 = -(-(((i50 & i47) | (i47 ^ i50)) * 449));
                Object[] objArr6 = new Object[1];
                a(true, i29, i37, (i46 ^ i51) + ((i51 & i46) << 1), new char[]{65534, 0, 0, 14, 65531, 65534, 65501, 11, '\b', 65503, 0, 7, 2, CharUtils.CR, 2, 65530, 16, 11}, objArr6);
                String[] strArr = {(String) objArr5[0], (String) objArr6[0]};
                int i52 = 0;
                while (true) {
                    if (i52 >= i17) {
                        objArr = new Object[4];
                        objArr[0] = new int[]{i};
                        objArr[1] = new int[]{i};
                        objArr[2] = new int[1];
                        int i53 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
                        artificialFrame = i53 % 128;
                        int i54 = i53 % 2;
                        objArr[3] = null;
                        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                        int i55 = ~elapsedCpuTime;
                        int i56 = (((((~((-276047483) | i55)) | (~((-702576293) | elapsedCpuTime))) | (~(i55 | 702576292))) * 959) - 769274115) + (((~(elapsedCpuTime | 702576292)) | (~(i55 | (-702576293))) | (~((-276047483) | elapsedCpuTime))) * 959);
                        int i57 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i58 = (i57 ^ 43) + ((i57 & 43) << 1);
                        artificialFrame = i58 % 128;
                        int i59 = i58 % 2 == 0 ? ((-419) >>> i56) * (421 >> i2) : (i56 * (-419)) + (i2 * 421);
                        int i60 = TypedValues.CycleType.TYPE_EASING * (~((i2 ^ i) | (i2 & i)));
                        int i61 = (i59 & i60) + (i59 | i60);
                        int i62 = ~i56;
                        int i63 = (i61 - (~(-(-(((i2 ^ i62) | (i2 & i62)) * (-420)))))) - 1;
                        int i64 = ~i2;
                        int i65 = ~((i62 & i64) | (i62 ^ i64));
                        int i66 = ~((i22 & i2) | (i22 ^ i2));
                        int i67 = -(-(((i65 & i66) | (i65 ^ i66)) * TypedValues.CycleType.TYPE_EASING));
                        int i68 = ((i63 | i67) << 1) - (i67 ^ i63);
                        int i69 = (i68 << 13) ^ i68;
                        int i70 = (i57 & 1) + (i57 | 1);
                        artificialFrame = i70 % 128;
                        if (i70 % 2 != 0) {
                            int i71 = (i69 >>> 17) ^ i69;
                            ((int[]) objArr[2])[0] = i71 ^ (i71 << 5);
                            break;
                        }
                        int i72 = i69 * 17;
                        int i73 = (i72 & (~i69)) | ((~i72) & i69);
                        int i74 = ((i73 | (-4)) << 1) - (i73 ^ (-4));
                        ((int[]) objArr[5])[0] = ((~i73) & i74) | ((~i74) & i73);
                        break;
                    }
                    String str = strArr[i52];
                    int i75 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int i76 = i75 * (-830);
                    int i77 = (i76 ^ 13312) + ((i76 & 13312) << 1);
                    int i78 = ~i;
                    int i79 = ~(((-17) & i78) | ((-17) ^ i78));
                    int i80 = ~((i75 ^ 16) | (i75 & 16) | i);
                    int i81 = ((i79 ^ i80) | (i79 & i80)) * (-831);
                    int i82 = (i77 ^ i81) + ((i77 & i81) << 1);
                    int i83 = ((-17) & i75) | ((-17) ^ i75);
                    int i84 = -(-((~((i83 & i) | (i83 ^ i))) * (-1662)));
                    int i85 = ((i82 | i84) << 1) - (i84 ^ i82);
                    int i86 = ~i75;
                    int i87 = ~((i78 & i86) | (i86 ^ i78));
                    int i88 = ~((i75 & i) | (i75 ^ i));
                    int i89 = (i88 & i87) | (i87 ^ i88);
                    int i90 = ~((i ^ 16) | (i & 16));
                    int i91 = (i85 - (~(-(-(((i89 & i90) | (i89 ^ i90)) * 831))))) - 1;
                    int i92 = -Drawable.resolveOpacity(0, 0);
                    int iICustomTabsServiceDefault3 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                    int i93 = (i92 * (-518)) - 122248;
                    int i94 = ~i92;
                    int i95 = ~iICustomTabsServiceDefault3;
                    int i96 = ~(i94 | i95);
                    int i97 = ((i96 ^ 236) | (i96 & 236)) * 519;
                    int i98 = ((i93 | i97) << 1) - (i97 ^ i93);
                    int i99 = ~i92;
                    int i100 = (i95 & i99) | (i99 ^ i95);
                    int i101 = ~((i100 & 236) | (i100 ^ 236));
                    int i102 = ~(i92 | 236 | iICustomTabsServiceDefault3);
                    int i103 = -(-(((i101 & i102) | (i101 ^ i102)) * (-519)));
                    int i104 = (i98 & i103) + (i103 | i98);
                    int i105 = ~((iICustomTabsServiceDefault3 ^ 236) | (iICustomTabsServiceDefault3 & 236));
                    int i106 = -(-(((i105 & i92) | (i92 ^ i105)) * 519));
                    Object[] objArr7 = new Object[1];
                    a(true, i91, (i104 & i106) + (i106 | i104), View.MeasureSpec.getSize(0) + 16, new char[]{21, 2, 5, 65508, 65486, 19, 15, 65486, 4, '\t', 15, 18, 4, 14, 1, 7}, objArr7);
                    Class<?> cls = Class.forName((String) objArr7[0]);
                    if (((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, null)).booleanValue()) {
                        int i107 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i108 = (i107 ^ 91) + ((i107 & 91) << 1);
                        artificialFrame = i108 % 128;
                        int i109 = i108 % 2;
                        objArr = new Object[]{new int[]{i}, new int[]{i ^ 1}, new int[1], null};
                        int i110 = 1550061646 + (((~((-66979893) | i)) | 38928400) * (-140)) + ((~((-28051493) | i)) * 70) + (((~(1045603667 | i)) | (-1034726760)) * 70);
                        int i111 = (i110 ^ 16) + ((i110 & 16) << 1);
                        int iICustomTabsServiceDefault4 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                        int i112 = (i111 * (-496)) + (i2 * (-496));
                        int i113 = ~i111;
                        int i114 = ~i2;
                        int i115 = (~(i113 | i114)) * 497;
                        int i116 = ((i112 | i115) << 1) - (i112 ^ i115);
                        int i117 = ~i111;
                        int i118 = ~i2;
                        int i119 = (i117 ^ i118) | (i117 & i118);
                        int i120 = ~((i119 & iICustomTabsServiceDefault4) | (i119 ^ iICustomTabsServiceDefault4));
                        int i121 = ~iICustomTabsServiceDefault4;
                        int i122 = ~((i121 & i114) | (i114 ^ i121) | i111);
                        int i123 = -(-(((i120 & i122) | (i120 ^ i122)) * 497));
                        int i124 = (i116 ^ i123) + ((i116 & i123) << 1);
                        int i125 = artificialFrame;
                        int i126 = ((i125 | 17) << 1) - (i125 ^ 17);
                        int i127 = i126 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i127;
                        if (i126 % 2 != 0) {
                            int i128 = ~iICustomTabsServiceDefault4;
                            int i129 = ~((i117 & i128) | (i117 ^ i128));
                            int i130 = ~(i113 | i2);
                            int i131 = (i129 & i130) | (i129 ^ i130);
                            int i132 = (i111 & i114) | (i114 ^ i111);
                            int i133 = ~((i132 & iICustomTabsServiceDefault4) | (i132 ^ iICustomTabsServiceDefault4));
                            int i134 = -((i133 & i131) | (i131 ^ i133));
                            i15 = i124 / (((i134 | 497) << 1) - (i134 ^ 497));
                            i16 = 65;
                        } else {
                            int i135 = ~iICustomTabsServiceDefault4;
                            int i136 = ~((i117 & i135) | (i117 ^ i135));
                            int i137 = ~(i113 | i2);
                            int i138 = (i136 & i137) | (i136 ^ i137);
                            int i139 = i111 | i118;
                            int i140 = ~((i139 & iICustomTabsServiceDefault4) | (i139 ^ iICustomTabsServiceDefault4));
                            int i141 = ((i140 & i138) | (i138 ^ i140)) * 497;
                            i15 = (i124 & i141) + (i141 | i124);
                            i16 = 13;
                        }
                        int i142 = i127 + 119;
                        artificialFrame = i142 % 128;
                        if (i142 % 2 != 0) {
                            int i143 = i15 << i16;
                            int i144 = (i143 | i15) & (~(i15 & i143));
                            int i145 = i144 >>> 17;
                            int i146 = (i144 | i145) & (~(i144 & i145));
                            int i147 = i146 << 5;
                            ((int[]) objArr[2])[0] = ((~i146) & i147) | ((~i147) & i146);
                            break;
                        }
                        int i148 = ((i15 - (~(-i16))) - 1) ^ i15;
                        int i149 = i148 ^ (i148 >>> AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
                        ((int[]) objArr[2])[0] = i149 ^ (i149 >>> 2);
                        break;
                    }
                    i52 = ((i52 & 117) + (i52 | 117)) - 116;
                    int i150 = artificialFrame + 57;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i150 % 128;
                    int i151 = i150 % 2;
                    i17 = 2;
                }
            } catch (Exception unused) {
                objArr = new Object[]{new int[]{i}, new int[]{i ^ 2}, new int[1], null};
                int iMyUid = Process.myUid();
                int i152 = (((-1695882534) + (((~((~iMyUid) | (-877801615))) | 67248256) * 446)) + (((~(iMyUid | (-810553359))) | 33573904) * 446)) - 72048896;
                int iICustomTabsServiceDefault5 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                int i153 = ~i152;
                int i154 = (iICustomTabsServiceDefault5 ^ 16) | (iICustomTabsServiceDefault5 & 16);
                int i155 = ~i154;
                int i156 = (-21360) + (i152 * (-667)) + (((i153 & i155) | (i153 ^ i155)) * (-668));
                int i157 = ~i152;
                int i158 = ~((iICustomTabsServiceDefault5 & i157) | (i157 ^ iICustomTabsServiceDefault5));
                int i159 = ((i158 & 16) | (i158 ^ 16)) * 1336;
                int i160 = ((((i156 | i159) << 1) - (i159 ^ i156)) - (~(((i154 ^ i157) | (i157 & i154)) * 668))) - 1;
                int i161 = ((i2 | i160) << 1) - (i2 ^ i160);
                int i162 = i161 << 13;
                int i163 = (i161 | i162) & (~(i161 & i162));
                int i164 = i163 >>> 17;
                int i165 = (i163 | i164) & (~(i163 & i164));
                int i166 = i165 << 5;
                ((int[]) objArr[2])[0] = ((~i165) & i166) | ((~i166) & i165);
            }
            if (i != ((int[]) objArr[1])[0]) {
                return objArr;
            }
            try {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                if (objAccessartificialFrame == null) {
                    int mirror2 = '9' - AndroidCharacter.getMirror('0');
                    char jumpTapTimeout = (char) (64610 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                    int windowTouchSlop = 1806 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    byte b = (byte) ($$a[5] + 1);
                    byte b2 = (byte) (b + 1);
                    Object[] objArr8 = new Object[1];
                    b(b, b2, b2, objArr8);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(mirror2, jumpTapTimeout, windowTouchSlop, -1135716921, false, (String) objArr8[0], new Class[0]);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                long j = -1758673661;
                int iMyTid = Process.myTid();
                long j2 = (((long) (-419)) * j) + (((long) 421) * jLongValue);
                long j3 = TypedValues.CycleType.TYPE_EASING;
                long j4 = iMyTid;
                long j5 = -1;
                long j6 = j ^ j5;
                long j7 = j2 + (((jLongValue | j4) ^ j5) * j3) + (((long) (-420)) * (jLongValue | j6)) + (j3 * ((((j4 ^ j5) | jLongValue) ^ j5) | ((j6 | (jLongValue ^ j5)) ^ j5))) + ((long) 2098881695);
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i167 = ((int) (j7 >> 32)) & ((-818884594) + (((~iMaxMemory) | 705431059) * 1324) + (((~(iMaxMemory | 722208275)) | (~(715018135 | iMaxMemory))) * (-1324)) + 273292120);
                int i168 = ~i;
                int i169 = ((int) j7) & (1153123995 + ((2121707114 | i168) * 1444) + (((~(350649445 | i)) | 1779466762 | (~((-1787875856) | i))) * (-1444)) + 1430787642);
                int i170 = (i167 & i169) | (i167 ^ i169);
                int i171 = artificialFrame;
                int i172 = (i171 ^ 85) + ((i171 & 85) << 1);
                int i173 = i172 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i173;
                int i174 = i172 % 2;
                if (i170 == 1) {
                    int i175 = i173 + 53;
                    artificialFrame = i175 % 128;
                    if (i175 % 2 == 0) {
                        i14 = (i & (-126)) | (i168 & 125);
                        objArr4 = new Object[4];
                        i13 = 1;
                        objArr4[1] = new int[1];
                        c = 0;
                        objArr4[0] = new int[0];
                    } else {
                        i13 = 1;
                        c = 0;
                        i14 = (i & (-11)) | (i168 & 10);
                        objArr4 = new Object[4];
                        objArr4[0] = new int[1];
                        objArr4[1] = new int[1];
                    }
                    objArr4[2] = new int[i13];
                    ((int[]) objArr4[c])[c] = i;
                    ((int[]) objArr4[i13])[c] = i14;
                    objArr4[3] = null;
                    int i176 = ~(((int) Runtime.getRuntime().totalMemory()) | 319824938);
                    int i177 = ((269485066 | i176) * (-196)) + 981408838 + ((i176 | 50339872) * 196);
                    int i178 = ((i177 | 16) << 1) - (i177 ^ 16);
                    int i179 = i178 * 221;
                    int i180 = i2 * (-219);
                    int i181 = (i179 & i180) + (i179 | i180);
                    int i182 = ~i178;
                    int i183 = ~i2;
                    int i184 = ~((i182 & i183) | (i182 ^ i183));
                    int i185 = i168 | i178;
                    int i186 = ~((i185 & i2) | (i185 ^ i2));
                    int i187 = ((i184 & i186) | (i184 ^ i186)) * 220;
                    int i188 = ((i181 | i187) << 1) - (i187 ^ i181);
                    int i189 = ~((i168 ^ i2) | (i168 & i2));
                    int i190 = i188 + (((i189 & i178) | (i178 ^ i189)) * (-440));
                    int i191 = (i178 & i2) | (i178 ^ i2);
                    int i192 = i190 + (((i191 & i) | (i191 ^ i)) * 220);
                    int i193 = i192 << 13;
                    int i194 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                    artificialFrame = i194 % 128;
                    if (i194 % 2 == 0) {
                        int i195 = (i193 | i192) & (~(i192 & i193));
                        int i196 = (i195 ^ 46) + ((i195 & 46) << 1);
                        int i197 = (i195 | i196) & (~(i195 & i196));
                        int i198 = i197 >>> 5;
                        ((int[]) objArr4[4])[0] = (i197 | i198) & (~(i197 & i198));
                    } else {
                        int i199 = (i193 | i192) & (~(i192 & i193));
                        int i200 = i199 >>> 17;
                        int i201 = (i199 | i200) & (~(i199 & i200));
                        ((int[]) objArr4[2])[0] = i201 ^ (i201 << 5);
                    }
                    objArr2 = objArr4;
                } else {
                    objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int i202 = ~((-206397458) | i);
                    int i203 = (-928005298) + ((4734992 | i202) * (-280)) + ((i202 | (~((-772226318) | i))) * 140) + (((~((-201662466) | i)) | (~((-4734993) | i168)) | (~((-570563853) | i168))) * 140);
                    int iICustomTabsServiceDefault6 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                    int i204 = i203 * 46;
                    int i205 = ~i203;
                    int i206 = ~iICustomTabsServiceDefault6;
                    int i207 = -(-((~((i205 & i206) | (i205 ^ i206))) * (-90)));
                    int i208 = (i204 ^ i207) + ((i204 & i207) << 1);
                    int i209 = ~i203;
                    int i210 = ~(i209 | iICustomTabsServiceDefault6);
                    int i211 = ~i203;
                    int i212 = (i208 - (~(((i211 & i210) | (i210 ^ i211)) * (-45)))) - 1;
                    int i213 = i209 | (~(((-1) ^ iICustomTabsServiceDefault6) | iICustomTabsServiceDefault6));
                    int i214 = ~(~iICustomTabsServiceDefault6);
                    int i215 = ((i214 & i213) | (i213 ^ i214)) * 45;
                    int i216 = -(-((i212 & i215) + (i215 | i212)));
                    int i217 = (i2 ^ i216) + ((i216 & i2) << 1);
                    int i218 = (i217 << 13) ^ i217;
                    int i219 = i218 >>> 17;
                    int i220 = ((~i218) & i219) | ((~i219) & i218);
                    int i221 = i220 << 5;
                    ((int[]) objArr2[2])[0] = (i220 | i221) & (~(i220 & i221));
                }
                int[] iArr = (int[]) objArr2[1];
                int i222 = artificialFrame;
                int i223 = (i222 ^ 107) + ((i222 & 107) << 1);
                int i224 = i223 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i224;
                if (i223 % 2 == 0 ? i != iArr[0] : i != iArr[1]) {
                    int i225 = (i224 ^ 101) + ((i224 & 101) << 1);
                    artificialFrame = i225 % 128;
                    if (i225 % 2 != 0) {
                        return objArr2;
                    }
                    throw null;
                }
                try {
                    int i226 = -Color.red(0);
                    int iICustomTabsServiceDefault7 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                    int i227 = i226 * (-109);
                    int i228 = (i227 ^ 4218) + ((i227 & 4218) << 1);
                    int i229 = ~i226;
                    int i230 = ((~((iICustomTabsServiceDefault7 ^ 38) | (iICustomTabsServiceDefault7 & 38))) | i229) * (-220);
                    int i231 = (i228 ^ i230) + ((i228 & i230) << 1);
                    int i232 = ~((i226 ^ 38) | (i226 & 38));
                    int i233 = ~(iICustomTabsServiceDefault7 | 38);
                    int i234 = i231 + (((i233 & i232) | (i232 ^ i233)) * 220);
                    int i235 = ~((i229 ^ 38) | (i229 & 38));
                    int i236 = ~((i226 & (-39)) | ((-39) ^ i226));
                    int i237 = (i234 - (~(((i236 & i235) | (i235 ^ i236)) * b.f39n))) - 1;
                    int i238 = -View.resolveSizeAndState(0, 0, 0);
                    int i239 = -ImageFormat.getBitsPerPixel(0);
                    Object[] objArr9 = new Object[1];
                    a(false, i237, (i238 & 239) + (i238 | 239), (i239 & 39) + (i239 | 39), new char[]{22, 16, 65484, '\b', 2, 15, 11, 2, '\t', 65484, 1, 2, 65535, 18, 4, 65484, 17, 15, 65534, 0, 6, 11, 4, 65484, 0, 18, 15, 15, 2, 11, 17, 65532, 17, 15, 65534, 0, 2, 15, 65484, 16}, objArr9);
                    File file3 = new File((String) objArr9[0]);
                    try {
                        if (file3.canRead()) {
                            FileReader fileReader3 = new FileReader(file3);
                            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                            try {
                                line = bufferedReader3.readLine();
                                int threadPriority = Process.getThreadPriority(0);
                                int i240 = -((((threadPriority | 20) << 1) - (threadPriority ^ 20)) >> 6);
                                int i241 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                                artificialFrame = i241 % 128;
                                int i242 = i241 % 2 == 0 ? (784 % i240) << (-982) : (i240 * 784) + 785;
                                int i243 = ~i240;
                                int i244 = ~i;
                                int i245 = (i243 & i244) | (i243 ^ i244);
                                int i246 = i242 + ((-783) * (~((i245 & 2) | (i245 ^ 2))));
                                int i247 = ~i240;
                                int i248 = ~((i244 ^ 2) | (i244 & 2));
                                int i249 = i246 + (((i247 & i248) | (i247 ^ i248)) * 783);
                                int i250 = 250 - (~(-ExpandableListView.getPackedPositionGroup(0L)));
                                int i251 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                int iICustomTabsServiceDefault8 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                                int i252 = (i251 * (-501)) + 1509;
                                int i253 = ~(((-4) ^ iICustomTabsServiceDefault8) | ((-4) & iICustomTabsServiceDefault8));
                                int i254 = (i251 ^ 3) | (i251 & 3);
                                int i255 = artificialFrame;
                                int i256 = (i255 & 33) + (i255 | 33);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i256 % 128;
                                if (i256 % 2 != 0) {
                                    int i257 = ~i254;
                                    int i258 = i252 * ((-502) >> ((i257 & i253) | (i253 ^ i257)));
                                    int i259 = ~iICustomTabsServiceDefault8;
                                    int i260 = (i259 & (-4)) | ((-4) ^ i259);
                                    int i261 = -(-((~((i260 & i251) | (i260 ^ i251))) * (-502)));
                                    i12 = (i258 & i261) + (i261 | i258);
                                } else {
                                    int i262 = ((~i254) | i253) * (-502);
                                    i12 = ((~((-4) | (~iICustomTabsServiceDefault8) | i251)) * (-502)) + (i252 ^ i262) + ((i262 & i252) << 1);
                                }
                                int i263 = ~((~i251) | iICustomTabsServiceDefault8);
                                int i264 = TypedValues.PositionType.TYPE_DRAWPATH * ((i263 & (-4)) | ((-4) ^ i263));
                                int i265 = (i12 ^ i264) + ((i12 & i264) << 1);
                                Object[] objArr10 = new Object[1];
                                a(false, i249, i250, i265, new char[]{0, 1, 65535}, objArr10);
                                if (line.equals((String) objArr10[0])) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                } else {
                                    int i266 = artificialFrame + 93;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i266 % 128;
                                    int i267 = i266 % 2;
                                    fileReader3.close();
                                    bufferedReader3.close();
                                }
                                int i268 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                int i269 = (i268 & 28) + (i268 | 28);
                                int i270 = 237 - (~(-Color.blue(0)));
                                int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                                Object[] objArr11 = new Object[1];
                                a(true, i269, i270, ((fadingEdgeLength | 31) << 1) - (fadingEdgeLength ^ 31), new char[]{65535, '\f', 3, 65533, 3, 1, 65535, 16, 18, 4, 65485, '\n', 3, '\f', 16, 3, '\t', 65485, 17, 23, 17, 65485, 1, CharUtils.CR, 16, 14, 65485, 2, 3, '\n', 0}, objArr11);
                                file = new File((String) objArr11[0]);
                                if (!file.canRead()) {
                                    fileReader = new FileReader(file);
                                    bufferedReader = new BufferedReader(fileReader);
                                    try {
                                        String line2 = bufferedReader.readLine();
                                        int i271 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                                        int i272 = (i271 & 1) + (i271 | 1);
                                        int i273 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                                        int i274 = ((i273 | 189) << 1) - (i273 ^ 189);
                                        int threadPriority2 = Process.getThreadPriority(0);
                                        int iICustomTabsServiceDefault9 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                                        int i275 = threadPriority2 * (-755);
                                        int i276 = ((-15100) ^ i275) + ((i275 & (-15100)) << 1);
                                        int i277 = ~threadPriority2;
                                        int i278 = (i276 - (~((~((i277 & (-21)) | ((-21) ^ i277))) * 1512))) - 1;
                                        int i279 = ~((~threadPriority2) | (-21));
                                        int i280 = threadPriority2 | 20;
                                        int i281 = ~((i280 & iICustomTabsServiceDefault9) | (i280 ^ iICustomTabsServiceDefault9));
                                        int i282 = -(((((i278 - (~(((i279 & i281) | (i279 ^ i281)) * (-756)))) - 1) - (~(-(-(((~iICustomTabsServiceDefault9) | ((threadPriority2 & 20) | (threadPriority2 ^ 20))) * 756))))) - 1) >> 6);
                                        int i283 = i282 * (-963);
                                        int i284 = ((i283 | (-964)) << 1) - (i283 ^ (-964));
                                        int i285 = ((i284 | 965) << 1) - (i284 ^ 965);
                                        int i286 = ~i282;
                                        int i287 = ~(((-2) ^ i) | ((-2) & i));
                                        int i288 = ((i286 & i287) | (i286 ^ i287)) * (-964);
                                        int i289 = (i285 & i288) + (i288 | i285);
                                        int i290 = ~i;
                                        int i291 = ~((i290 & (-2)) | ((-2) ^ i290));
                                        int i292 = ~((i282 & (-2)) | ((-2) ^ i282));
                                        int i293 = -(-(((i291 & i292) | (i291 ^ i292)) * (-964)));
                                        Object[] objArr12 = new Object[1];
                                        a(false, i272, i274, ((i289 | i293) << 1) - (i293 ^ i289), new char[]{0}, objArr12);
                                        zEquals = line2.equals((String) objArr12[0]);
                                        fileReader.close();
                                        bufferedReader.close();
                                        if (zEquals) {
                                            try {
                                                int threadPriority3 = Process.getThreadPriority(0);
                                                int i294 = ((threadPriority3 & 20) + (threadPriority3 | 20)) >> 6;
                                                int i295 = ~((~i294) | 27);
                                                int i296 = ~i;
                                                int i297 = ~((i296 & 27) | (i296 ^ 27));
                                                int i298 = (i294 * (-183)) + 4995 + (((i295 & i297) | (i295 ^ i297)) * SyslogConstants.LOG_LOCAL7);
                                                int i299 = ((~((-28) | i294)) | i) * (-184);
                                                int i300 = (i298 & i299) + (i298 | i299);
                                                int i301 = ~i294;
                                                int i302 = (~((i301 & i168) | (i301 ^ i168))) * SyslogConstants.LOG_LOCAL7;
                                                int i303 = (i300 & i302) + (i302 | i300);
                                                int i304 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                                                Object[] objArr13 = new Object[1];
                                                a(true, i303, (i304 ^ 238) + ((i304 & 238) << 1), 36 - View.MeasureSpec.getMode(0), new char[]{18, 65485, 5, '\f', 7, 1, 65535, 16, 18, 65485, 5, 19, 0, 3, 2, 65485, '\n', 3, '\f', 16, 3, '\t', 65485, 17, 23, 17, 65485, '\f', CharUtils.CR, 65533, 5, '\f', 7, 1, 65535, 16}, objArr13);
                                                file2 = new File((String) objArr13[0]);
                                                if (file2.canRead()) {
                                                    fileReader2 = new FileReader(file2);
                                                    bufferedReader2 = new BufferedReader(fileReader2);
                                                    try {
                                                        String line3 = bufferedReader2.readLine();
                                                        int i305 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                        int iICustomTabsServiceDefault10 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                                                        int i306 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                                                        int i307 = i306 % 128;
                                                        artificialFrame = i307;
                                                        int i308 = i306 % 2;
                                                        int i309 = i305 * 881;
                                                        int i310 = (i309 ^ 881) + ((i309 & 881) << 1);
                                                        int i311 = ~i305;
                                                        int i312 = ~((i311 & (-2)) | (i311 ^ (-2)));
                                                        int i313 = ~i305;
                                                        int i314 = ~((i313 ^ iICustomTabsServiceDefault10) | (i313 & iICustomTabsServiceDefault10));
                                                        int i315 = -(-(((i312 ^ i314) | (i314 & i312) | (~(((-2) ^ iICustomTabsServiceDefault10) | ((-2) & iICustomTabsServiceDefault10)))) * (-880)));
                                                        int i316 = ((i315 & i310) << 1) + (i310 ^ i315);
                                                        int i317 = ~iICustomTabsServiceDefault10;
                                                        int i318 = ~((i313 ^ i317) | (i317 & i313));
                                                        int i319 = (i318 ^ 1) | (i318 & 1);
                                                        int i320 = ~((i305 ^ iICustomTabsServiceDefault10) | (i305 & iICustomTabsServiceDefault10));
                                                        int i321 = ((i319 ^ i320) | (i319 & i320)) * (-880);
                                                        i5 = (i316 & i321) + (i316 | i321);
                                                        i6 = (~(i305 | iICustomTabsServiceDefault10)) * 880;
                                                        i7 = (i307 ^ 49) + ((i307 & 49) << 1);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                                                        if (i7 % 2 != 0) {
                                                            int i322 = i5 + i6;
                                                            iGreen = Color.green(1);
                                                            i9 = ((-711) / iGreen) % 0;
                                                            i10 = ((-21919) & iGreen) | ((-21919) ^ iGreen);
                                                            i11 = 21918;
                                                            i8 = i322;
                                                        } else {
                                                            int i323 = -(-i6);
                                                            int iGreen2 = Color.green(0);
                                                            i8 = (i5 & i323) + (i323 | i5);
                                                            i9 = (iGreen2 * (-711)) + 134757;
                                                            iGreen = iGreen2;
                                                            i10 = ((-190) & iGreen2) | ((-190) ^ iGreen2);
                                                            i11 = 189;
                                                        }
                                                        int i324 = ~i10;
                                                        int i325 = ~(i168 | iGreen);
                                                        int i326 = (-712) * ((i324 & i325) | (i324 ^ i325));
                                                        int i327 = ((i9 | i326) << 1) - (i9 ^ i326);
                                                        int i328 = ~i11;
                                                        int i329 = (i328 & i168) | (i328 ^ i168);
                                                        int i330 = -(-(((~((i329 & iGreen) | (i329 ^ iGreen))) | (~((iGreen ^ i11) | (iGreen & i11) | i))) * (-712)));
                                                        int i331 = (i327 & i330) + (i330 | i327);
                                                        int i332 = ~i11;
                                                        int i333 = ~((i168 & iGreen) | (i168 ^ iGreen));
                                                        int i334 = (i331 - (~(((i333 & i332) | (i332 ^ i333)) * 712))) - 1;
                                                        int i335 = -Drawable.resolveOpacity(0, 0);
                                                        int iICustomTabsServiceDefault11 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                                                        int i336 = i335 * (-129);
                                                        int i337 = (i336 ^ 131) + ((i336 & 131) << 1);
                                                        int i338 = ~iICustomTabsServiceDefault11;
                                                        int i339 = -(-((~((i338 & (-2)) | ((-2) ^ i338) | i335)) * 130));
                                                        int i340 = (i337 ^ i339) + ((i339 & i337) << 1);
                                                        int i341 = (-2) | i335;
                                                        int i342 = (~i341) * (-260);
                                                        int i343 = (i340 & i342) + (i342 | i340);
                                                        int i344 = ~i335;
                                                        int i345 = ~((i344 & 1) | (i344 ^ 1));
                                                        int i346 = ~(iICustomTabsServiceDefault11 | i341);
                                                        int i347 = ((i345 & i346) | (i345 ^ i346)) * 130;
                                                        Object[] objArr14 = new Object[1];
                                                        a(false, i8, i334, (i343 ^ i347) + ((i347 & i343) << 1), new char[]{0}, objArr14);
                                                        zEquals2 = line3.equals((String) objArr14[0]);
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                    } catch (Throwable th) {
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                        throw th;
                                                    }
                                                } else {
                                                    zEquals2 = false;
                                                }
                                            } catch (Exception unused2) {
                                                zEquals2 = false;
                                            }
                                            if (zEquals2 && line != null) {
                                                int i348 = (~(i & 20)) & (i | 20);
                                                int i349 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i350 = (i349 ^ 89) + ((i349 & 89) << 1);
                                                int i351 = i350 % 128;
                                                artificialFrame = i351;
                                                int i352 = i350 % 2;
                                                int i353 = i351 + 107;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i353 % 128;
                                                int i354 = i353 % 2;
                                                objArr3 = new Object[]{new int[]{i}, new int[]{i348}, new int[1], line};
                                                int i355 = ~((int) Runtime.getRuntime().totalMemory());
                                                int i356 = 2019818377 + ((~((-557850821) | i355)) * (-783)) + (((~(i355 | 412311098)) | (-566312677)) * 783);
                                                int i357 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i358 = (i357 ^ 59) + ((i357 & 59) << 1);
                                                int i359 = i358 % 128;
                                                artificialFrame = i359;
                                                int i360 = i358 % 2;
                                                int i361 = (i2 - (~((i356 ^ 16) + ((i356 & 16) << 1)))) - 1;
                                                int i362 = i361 << 13;
                                                int i363 = (i361 | i362) & (~(i361 & i362));
                                                i3 = i363 ^ (i363 >>> 17);
                                                i4 = i359 + 43;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                                                if (i4 % 2 != 0) {
                                                    int i364 = i3 + 4;
                                                    ((int[]) objArr3[4])[1] = (i364 & (~i3)) | ((~i364) & i3);
                                                    return objArr3;
                                                }
                                                int i365 = i3 << 5;
                                                ((int[]) objArr3[2])[0] = (i365 | i3) & (~(i3 & i365));
                                                return objArr3;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        fileReader.close();
                                        bufferedReader.close();
                                        throw th2;
                                    }
                                }
                                int i366 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                                int i367 = i366 % 128;
                                artificialFrame = i367;
                                int i368 = i366 % 2;
                                int i369 = (i367 & 33) + (i367 | 33);
                                int i370 = i369 % 128;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i370;
                                int i371 = i369 % 2;
                                int i372 = i370 + 113;
                                artificialFrame = i372 % 128;
                                int i373 = i372 % 2;
                                Object[] objArr15 = {new int[]{i}, new int[]{i}, new int[1], null};
                                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                                int i374 = -(-(857507826 + (((-69550401) | (~startElapsedRealtime)) * (-490)) + (((~(startElapsedRealtime | (-103764943))) | 34214542) * 490) + 815901430));
                                int i375 = (i2 ^ i374) + ((i374 & i2) << 1);
                                int i376 = i375 << 13;
                                int i377 = (i376 | i375) & (~(i375 & i376));
                                int i378 = i377 ^ (i377 >>> 17);
                                int i379 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i380 = ((i379 | 71) << 1) - (i379 ^ 71);
                                artificialFrame = i380 % 128;
                                int i381 = i380 % 2;
                                int i382 = i378 << 5;
                                ((int[]) objArr15[2])[0] = ((~i378) & i382) | ((~i382) & i378);
                                return objArr15;
                            } catch (Throwable th3) {
                                fileReader3.close();
                                bufferedReader3.close();
                                throw th3;
                            }
                        }
                        int i2610 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        int i2611 = (i2610 & 28) + (i2610 | 28);
                        int i2710 = 237 - (~(-Color.blue(0)));
                        int fadingEdgeLength2 = ViewConfiguration.getFadingEdgeLength() >> 16;
                        Object[] objArr16 = new Object[1];
                        a(true, i2611, i2710, ((fadingEdgeLength2 | 31) << 1) - (fadingEdgeLength2 ^ 31), new char[]{65535, '\f', 3, 65533, 3, 1, 65535, 16, 18, 4, 65485, '\n', 3, '\f', 16, 3, '\t', 65485, 17, 23, 17, 65485, 1, CharUtils.CR, 16, 14, 65485, 2, 3, '\n', 0}, objArr16);
                        file = new File((String) objArr16[0]);
                        if (!file.canRead()) {
                            fileReader = new FileReader(file);
                            bufferedReader = new BufferedReader(fileReader);
                            String line4 = bufferedReader.readLine();
                            int i2711 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                            int i2712 = (i2711 & 1) + (i2711 | 1);
                            int i2713 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                            int i2714 = ((i2713 | 189) << 1) - (i2713 ^ 189);
                            int threadPriority4 = Process.getThreadPriority(0);
                            int iICustomTabsServiceDefault12 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                            int i2715 = threadPriority4 * (-755);
                            int i2716 = ((-15100) ^ i2715) + ((i2715 & (-15100)) << 1);
                            int i2717 = ~threadPriority4;
                            int i2718 = (i2716 - (~((~((i2717 & (-21)) | ((-21) ^ i2717))) * 1512))) - 1;
                            int i2719 = ~((~threadPriority4) | (-21));
                            int i2810 = threadPriority4 | 20;
                            int i2811 = ~((i2810 & iICustomTabsServiceDefault12) | (i2810 ^ iICustomTabsServiceDefault12));
                            int i2812 = -(((((i2718 - (~(((i2719 & i2811) | (i2719 ^ i2811)) * (-756)))) - 1) - (~(-(-(((~iICustomTabsServiceDefault12) | ((threadPriority4 & 20) | (threadPriority4 ^ 20))) * 756))))) - 1) >> 6);
                            int i2813 = i2812 * (-963);
                            int i2814 = ((i2813 | (-964)) << 1) - (i2813 ^ (-964));
                            int i2815 = ((i2814 | 965) << 1) - (i2814 ^ 965);
                            int i2816 = ~i2812;
                            int i2817 = ~(((-2) ^ i) | ((-2) & i));
                            int i2818 = ((i2816 & i2817) | (i2816 ^ i2817)) * (-964);
                            int i2819 = (i2815 & i2818) + (i2818 | i2815);
                            int i2910 = ~i;
                            int i2911 = ~((i2910 & (-2)) | ((-2) ^ i2910));
                            int i2912 = ~((i2812 & (-2)) | ((-2) ^ i2812));
                            int i2913 = -(-(((i2911 & i2912) | (i2911 ^ i2912)) * (-964)));
                            Object[] objArr17 = new Object[1];
                            a(false, i2712, i2714, ((i2819 | i2913) << 1) - (i2913 ^ i2819), new char[]{0}, objArr17);
                            zEquals = line4.equals((String) objArr17[0]);
                            fileReader.close();
                            bufferedReader.close();
                            if (zEquals) {
                                int threadPriority5 = Process.getThreadPriority(0);
                                int i2914 = ((threadPriority5 & 20) + (threadPriority5 | 20)) >> 6;
                                int i2915 = ~((~i2914) | 27);
                                int i2916 = ~i;
                                int i2917 = ~((i2916 & 27) | (i2916 ^ 27));
                                int i2918 = (i2914 * (-183)) + 4995 + (((i2915 & i2917) | (i2915 ^ i2917)) * SyslogConstants.LOG_LOCAL7);
                                int i2919 = ((~((-28) | i2914)) | i) * (-184);
                                int i3010 = (i2918 & i2919) + (i2918 | i2919);
                                int i3011 = ~i2914;
                                int i3012 = (~((i3011 & i168) | (i3011 ^ i168))) * SyslogConstants.LOG_LOCAL7;
                                int i3013 = (i3010 & i3012) + (i3012 | i3010);
                                int i3014 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                                Object[] objArr18 = new Object[1];
                                a(true, i3013, (i3014 ^ 238) + ((i3014 & 238) << 1), 36 - View.MeasureSpec.getMode(0), new char[]{18, 65485, 5, '\f', 7, 1, 65535, 16, 18, 65485, 5, 19, 0, 3, 2, 65485, '\n', 3, '\f', 16, 3, '\t', 65485, 17, 23, 17, 65485, '\f', CharUtils.CR, 65533, 5, '\f', 7, 1, 65535, 16}, objArr18);
                                file2 = new File((String) objArr18[0]);
                                if (file2.canRead()) {
                                    zEquals2 = false;
                                } else {
                                    fileReader2 = new FileReader(file2);
                                    bufferedReader2 = new BufferedReader(fileReader2);
                                    String line5 = bufferedReader2.readLine();
                                    int i3015 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    int iICustomTabsServiceDefault13 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                                    int i3016 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                                    int i3017 = i3016 % 128;
                                    artificialFrame = i3017;
                                    int i3018 = i3016 % 2;
                                    int i3019 = i3015 * 881;
                                    int i3110 = (i3019 ^ 881) + ((i3019 & 881) << 1);
                                    int i3111 = ~i3015;
                                    int i3112 = ~((i3111 & (-2)) | (i3111 ^ (-2)));
                                    int i3113 = ~i3015;
                                    int i3114 = ~((i3113 ^ iICustomTabsServiceDefault13) | (i3113 & iICustomTabsServiceDefault13));
                                    int i3115 = -(-(((i3112 ^ i3114) | (i3114 & i3112) | (~(((-2) ^ iICustomTabsServiceDefault13) | ((-2) & iICustomTabsServiceDefault13)))) * (-880)));
                                    int i3116 = ((i3115 & i3110) << 1) + (i3110 ^ i3115);
                                    int i3117 = ~iICustomTabsServiceDefault13;
                                    int i3118 = ~((i3113 ^ i3117) | (i3117 & i3113));
                                    int i3119 = (i3118 ^ 1) | (i3118 & 1);
                                    int i3210 = ~((i3015 ^ iICustomTabsServiceDefault13) | (i3015 & iICustomTabsServiceDefault13));
                                    int i3211 = ((i3119 ^ i3210) | (i3119 & i3210)) * (-880);
                                    i5 = (i3116 & i3211) + (i3116 | i3211);
                                    i6 = (~(i3015 | iICustomTabsServiceDefault13)) * 880;
                                    i7 = (i3017 ^ 49) + ((i3017 & 49) << 1);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                                    if (i7 % 2 != 0) {
                                        int i3212 = i5 + i6;
                                        iGreen = Color.green(1);
                                        i9 = ((-711) / iGreen) % 0;
                                        i10 = ((-21919) & iGreen) | ((-21919) ^ iGreen);
                                        i11 = 21918;
                                        i8 = i3212;
                                    } else {
                                        int i3213 = -(-i6);
                                        int iGreen3 = Color.green(0);
                                        i8 = (i5 & i3213) + (i3213 | i5);
                                        i9 = (iGreen3 * (-711)) + 134757;
                                        iGreen = iGreen3;
                                        i10 = ((-190) & iGreen3) | ((-190) ^ iGreen3);
                                        i11 = 189;
                                    }
                                    int i3214 = ~i10;
                                    int i3215 = ~(i168 | iGreen);
                                    int i3216 = (-712) * ((i3214 & i3215) | (i3214 ^ i3215));
                                    int i3217 = ((i9 | i3216) << 1) - (i9 ^ i3216);
                                    int i3218 = ~i11;
                                    int i3219 = (i3218 & i168) | (i3218 ^ i168);
                                    int i3310 = -(-(((~((i3219 & iGreen) | (i3219 ^ iGreen))) | (~((iGreen ^ i11) | (iGreen & i11) | i))) * (-712)));
                                    int i3311 = (i3217 & i3310) + (i3310 | i3217);
                                    int i3312 = ~i11;
                                    int i3313 = ~((i168 & iGreen) | (i168 ^ iGreen));
                                    int i3314 = (i3311 - (~(((i3313 & i3312) | (i3312 ^ i3313)) * 712))) - 1;
                                    int i3315 = -Drawable.resolveOpacity(0, 0);
                                    int iICustomTabsServiceDefault14 = MaterialDynamicColors$$ExternalSyntheticLambda131.ICustomTabsServiceDefault();
                                    int i3316 = i3315 * (-129);
                                    int i3317 = (i3316 ^ 131) + ((i3316 & 131) << 1);
                                    int i3318 = ~iICustomTabsServiceDefault14;
                                    int i3319 = -(-((~((i3318 & (-2)) | ((-2) ^ i3318) | i3315)) * 130));
                                    int i3410 = (i3317 ^ i3319) + ((i3319 & i3317) << 1);
                                    int i3411 = (-2) | i3315;
                                    int i3412 = (~i3411) * (-260);
                                    int i3413 = (i3410 & i3412) + (i3412 | i3410);
                                    int i3414 = ~i3315;
                                    int i3415 = ~((i3414 & 1) | (i3414 ^ 1));
                                    int i3416 = ~(iICustomTabsServiceDefault14 | i3411);
                                    int i3417 = ((i3415 & i3416) | (i3415 ^ i3416)) * 130;
                                    Object[] objArr19 = new Object[1];
                                    a(false, i8, i3314, (i3413 ^ i3417) + ((i3417 & i3413) << 1), new char[]{0}, objArr19);
                                    zEquals2 = line5.equals((String) objArr19[0]);
                                    fileReader2.close();
                                    bufferedReader2.close();
                                }
                                if (zEquals2) {
                                    int i3418 = (~(i & 20)) & (i | 20);
                                    int i3419 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i3510 = (i3419 ^ 89) + ((i3419 & 89) << 1);
                                    int i3511 = i3510 % 128;
                                    artificialFrame = i3511;
                                    int i3512 = i3510 % 2;
                                    int i3513 = i3511 + 107;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3513 % 128;
                                    int i3514 = i3513 % 2;
                                    objArr3 = new Object[]{new int[]{i}, new int[]{i3418}, new int[1], line};
                                    int i3515 = ~((int) Runtime.getRuntime().totalMemory());
                                    int i3516 = 2019818377 + ((~((-557850821) | i3515)) * (-783)) + (((~(i3515 | 412311098)) | (-566312677)) * 783);
                                    int i3517 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i3518 = (i3517 ^ 59) + ((i3517 & 59) << 1);
                                    int i3519 = i3518 % 128;
                                    artificialFrame = i3519;
                                    int i3610 = i3518 % 2;
                                    int i3611 = (i2 - (~((i3516 ^ 16) + ((i3516 & 16) << 1)))) - 1;
                                    int i3612 = i3611 << 13;
                                    int i3613 = (i3611 | i3612) & (~(i3611 & i3612));
                                    i3 = i3613 ^ (i3613 >>> 17);
                                    i4 = i3519 + 43;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                                    if (i4 % 2 != 0) {
                                        int i3614 = i3 + 4;
                                        ((int[]) objArr3[4])[1] = (i3614 & (~i3)) | ((~i3614) & i3);
                                        return objArr3;
                                    }
                                    int i3615 = i3 << 5;
                                    ((int[]) objArr3[2])[0] = (i3615 | i3) & (~(i3 & i3615));
                                    return objArr3;
                                }
                            }
                        }
                    } catch (Exception unused3) {
                    }
                } catch (Exception unused4) {
                }
                line = null;
                int i3616 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                int i3617 = i3616 % 128;
                artificialFrame = i3617;
                int i3618 = i3616 % 2;
                int i3619 = (i3617 & 33) + (i3617 | 33);
                int i3710 = i3619 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3710;
                int i3711 = i3619 % 2;
                int i3712 = i3710 + 113;
                artificialFrame = i3712 % 128;
                int i3713 = i3712 % 2;
                Object[] objArr110 = {new int[]{i}, new int[]{i}, new int[1], null};
                int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                int i3714 = -(-(857507826 + (((-69550401) | (~startElapsedRealtime2)) * (-490)) + (((~(startElapsedRealtime2 | (-103764943))) | 34214542) * 490) + 815901430));
                int i3715 = (i2 ^ i3714) + ((i3714 & i2) << 1);
                int i3716 = i3715 << 13;
                int i3717 = (i3716 | i3715) & (~(i3715 & i3716));
                int i3718 = i3717 ^ (i3717 >>> 17);
                int i3719 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i383 = ((i3719 | 71) << 1) - (i3719 ^ 71);
                artificialFrame = i383 % 128;
                int i384 = i383 % 2;
                int i385 = i3718 << 5;
                ((int[]) objArr110[2])[0] = ((~i3718) & i385) | ((~i385) & i3718);
                return objArr110;
            } catch (Throwable th4) {
                Throwable cause = th4.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th4;
            }
        }
    }

    protected void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
    }

    private void maybeRestartAnimationWithNewLayout(View view) {
        View view2 = this.mCurrentSharedTransitionViews.get(Integer.valueOf(view.getId()));
        if (view2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SharedElement sharedElement : this.mSharedElements) {
            if (sharedElement.targetView == view2) {
                arrayList.add(sharedElement);
                View view3 = sharedElement.sourceView;
                View view4 = sharedElement.targetView;
                Snapshot snapshot = new Snapshot(view3);
                Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(view4.getId()));
                Snapshot snapshot3 = new Snapshot(view4);
                int i = (snapshot2.originX - snapshot2.originXByParent) + snapshot3.originX;
                int i2 = (snapshot2.originY - snapshot2.originYByParent) + snapshot3.originY;
                snapshot2.originX = i;
                snapshot2.originY = i2;
                snapshot2.globalOriginX = i;
                snapshot2.globalOriginY = i2;
                snapshot2.originXByParent = snapshot3.originXByParent;
                snapshot2.originYByParent = snapshot3.originYByParent;
                snapshot2.height = snapshot3.height;
                snapshot2.width = snapshot3.width;
                sharedElement.sourceViewSnapshot = snapshot;
                sharedElement.targetViewSnapshot = snapshot2;
                disableCleaningForViewTag(view3.getId());
                disableCleaningForViewTag(view4.getId());
            }
        }
        startSharedTransition(arrayList, 4);
    }

    protected boolean prepareSharedTransition(List<View> list, boolean z) {
        if (list.isEmpty()) {
            return false;
        }
        sortViewsByTags(list);
        List<SharedElement> sharedElementsForCurrentTransition = getSharedElementsForCurrentTransition(list, z);
        if (sharedElementsForCurrentTransition.isEmpty()) {
            return false;
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(sharedElementsForCurrentTransition);
        orderByAnimationTypes(sharedElementsForCurrentTransition);
        return true;
    }

    protected void onScreenWillDisappear() {
        Iterator<Integer> it2 = this.mTagsToCleanup.iterator();
        while (it2.hasNext()) {
            this.mNativeMethodsHolder.clearAnimationConfig(it2.next().intValue());
        }
        this.mTagsToCleanup.clear();
        if (this.mIsTransitionPrepared) {
            this.mIsTransitionPrepared = false;
            for (SharedElement sharedElement : this.mSharedElementsWithAnimation) {
                sharedElement.targetViewSnapshot = new Snapshot(sharedElement.targetView);
            }
            for (SharedElement sharedElement2 : this.mSharedElementsWithProgress) {
                sharedElement2.targetViewSnapshot = new Snapshot(sharedElement2.targetView);
            }
            startPreparedTransitions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryStartSharedTransitionForViews(List<View> list, boolean z) {
        if (!prepareSharedTransition(list, z)) {
            return false;
        }
        startPreparedTransitions();
        return true;
    }

    private void startPreparedTransitions() {
        startSharedTransition(this.mSharedElementsWithAnimation, 4);
        startSharedTransition(this.mSharedElementsWithProgress, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortViewsByTags$0(View view, View view2) {
        return Integer.compare(view2.getId(), view.getId());
    }

    private void sortViewsByTags(List<View> list) {
        Collections.sort(list, new Comparator() { // from class: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SharedTransitionManager.lambda$sortViewsByTags$0((View) obj, (View) obj2);
            }
        });
    }

    private List<SharedElement> getSharedElementsForCurrentTransition(List<View> list, boolean z) {
        boolean z2;
        ViewGroup viewGroup;
        boolean z3 = this.mReattachedViews.size() > 0;
        ArrayList<View> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (!z) {
            Iterator<View> it2 = list.iterator();
            while (it2.hasNext()) {
                hashSet.add(Integer.valueOf(it2.next().getId()));
            }
        }
        ArrayList<SharedElement> arrayList2 = new ArrayList();
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        HashSet hashSet2 = new HashSet();
        Iterator<View> it3 = this.mRemovedSharedViews.iterator();
        while (it3.hasNext()) {
            hashSet2.add(Integer.valueOf(it3.next().getId()));
        }
        for (View view : list) {
            int iFindPrecedingViewTagForTransition = this.mNativeMethodsHolder.findPrecedingViewTagForTransition(view.getId());
            if (z3) {
                while (hashSet2.contains(Integer.valueOf(iFindPrecedingViewTagForTransition))) {
                    this.mNativeMethodsHolder.clearAnimationConfig(iFindPrecedingViewTagForTransition);
                    iFindPrecedingViewTagForTransition = this.mNativeMethodsHolder.findPrecedingViewTagForTransition(view.getId());
                }
            }
            boolean z4 = !z && hashSet.contains(Integer.valueOf(iFindPrecedingViewTagForTransition));
            if (iFindPrecedingViewTagForTransition >= 0) {
                View viewMaybeOverrideSiblingForTabNavigator = maybeOverrideSiblingForTabNavigator(view, reanimatedNativeHierarchyManager.resolveView(iFindPrecedingViewTagForTransition));
                if (z) {
                    viewMaybeOverrideSiblingForTabNavigator = view;
                    view = viewMaybeOverrideSiblingForTabNavigator;
                }
                if (z4) {
                    clearAllSharedConfigsForView(view);
                    clearAllSharedConfigsForView(viewMaybeOverrideSiblingForTabNavigator);
                } else {
                    boolean zContainsKey = this.mCurrentSharedTransitionViews.containsKey(Integer.valueOf(view.getId()));
                    if (zContainsKey) {
                        z2 = z3;
                    } else {
                        View viewFindScreen = findScreen(view);
                        View viewFindScreen2 = findScreen(viewMaybeOverrideSiblingForTabNavigator);
                        if (viewFindScreen != null && viewFindScreen2 != null && (viewGroup = (ViewGroup) findStack(viewFindScreen)) != null) {
                            ViewGroupManager viewGroupManager = (ViewGroupManager) reanimatedNativeHierarchyManager.resolveViewManager(viewGroup.getId());
                            z2 = z3;
                            boolean z5 = false;
                            for (int i = 0; i < viewGroupManager.getChildCount(viewGroup); i++) {
                                if (viewGroupManager.getChildAt(viewGroup, i) == viewFindScreen2) {
                                    z5 = true;
                                }
                            }
                            if (z5) {
                                ViewGroupManager viewGroupManager2 = (ViewGroupManager) reanimatedNativeHierarchyManager.resolveViewManager(viewGroup.getId());
                                int childCount = viewGroupManager2.getChildCount(viewGroup);
                                if (childCount >= 2) {
                                    View childAt = viewGroupManager2.getChildAt(viewGroup, childCount - 1);
                                    View childAt2 = viewGroupManager2.getChildAt(viewGroup, childCount - 2);
                                    if (!z ? !(childAt.getId() != viewFindScreen.getId() || childAt2.getId() != viewFindScreen2.getId()) : !(childAt2.getId() != viewFindScreen.getId() || childAt.getId() != viewFindScreen2.getId())) {
                                    }
                                }
                            }
                            z3 = z2;
                        }
                    }
                    Snapshot snapshot = null;
                    if (z) {
                        this.mViewTagsToHide.add(Integer.valueOf(view.getId()));
                        if (zContainsKey) {
                            snapshot = new Snapshot(view);
                        } else {
                            makeSnapshot(view);
                        }
                        makeSnapshot(viewMaybeOverrideSiblingForTabNavigator);
                    } else if (zContainsKey) {
                        makeSnapshot(view);
                    }
                    if (snapshot == null) {
                        snapshot = this.mSnapshotRegistry.get(Integer.valueOf(view.getId()));
                    }
                    Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(viewMaybeOverrideSiblingForTabNavigator.getId()));
                    if (snapshot2 == null) {
                        makeSnapshot(viewMaybeOverrideSiblingForTabNavigator);
                    }
                    arrayList.add(view);
                    arrayList.add(viewMaybeOverrideSiblingForTabNavigator);
                    arrayList2.add(new SharedElement(view, snapshot, viewMaybeOverrideSiblingForTabNavigator, snapshot2));
                    z3 = z2;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ArrayList<View> arrayList3 = new ArrayList();
            Iterator<SharedElement> it4 = this.mSharedElements.iterator();
            while (it4.hasNext()) {
                arrayList3.add(it4.next().sourceView);
            }
            HashSet hashSet3 = new HashSet();
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                hashSet3.add(((SharedElement) it5.next()).sourceView);
            }
            for (View view2 : arrayList3) {
                if (!hashSet3.contains(view2)) {
                    this.mViewTagsToHide.remove(Integer.valueOf(view2.getId()));
                    view2.setVisibility(0);
                }
            }
            this.mCurrentSharedTransitionViews.clear();
            for (View view3 : arrayList) {
                this.mCurrentSharedTransitionViews.put(Integer.valueOf(view3.getId()), view3);
            }
        }
        this.mSharedElements = arrayList2;
        for (SharedElement sharedElement : arrayList2) {
            this.mSharedElementsLookup.put(Integer.valueOf(sharedElement.sourceView.getId()), sharedElement);
        }
        return arrayList2;
    }

    private View maybeOverrideSiblingForTabNavigator(View view, View view2) {
        View tabNavigator = ScreensHelper.getTabNavigator(view);
        if (tabNavigator == null) {
            return view2;
        }
        int id = view2.getId();
        int[] sharedGroup = this.mNativeMethodsHolder.getSharedGroup(view.getId());
        int i = -1;
        for (int i2 = 0; i2 < sharedGroup.length; i2++) {
            if (sharedGroup[i2] == id) {
                i = i2;
            }
        }
        while (i >= 0) {
            View viewResolveView = this.mAnimationsManager.resolveView(sharedGroup[i]);
            if (tabNavigator == ScreensHelper.getTabNavigator(viewResolveView)) {
                return viewResolveView;
            }
            i--;
        }
        return view2;
    }

    private void setupTransitionContainer() {
        Activity currentActivity;
        if (this.mTransitionContainer == null) {
            this.mTransitionContainer = new ReactViewGroup(this.mAnimationsManager.getContext());
        }
        if (this.mTransitionContainer.getParent() != null || (currentActivity = this.mAnimationsManager.getContext().getCurrentActivity()) == null) {
            return;
        }
        ((ViewGroup) currentActivity.getWindow().getDecorView().getRootView()).addView(this.mTransitionContainer);
        this.mTransitionContainer.bringToFront();
    }

    private void reparentSharedViewsForCurrentTransition(List<SharedElement> list) {
        Iterator<SharedElement> it2 = list.iterator();
        while (it2.hasNext()) {
            View view = it2.next().sourceView;
            if (!this.mSharedTransitionParent.containsKey(Integer.valueOf(view.getId()))) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int id = viewGroup.getId();
                int iIndexOfChild = viewGroup.indexOfChild(view);
                this.mSharedTransitionParent.put(Integer.valueOf(view.getId()), (View) view.getParent());
                this.mSharedTransitionInParentIndex.put(Integer.valueOf(view.getId()), Integer.valueOf(iIndexOfChild));
                SortedSet<Integer> sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id));
                if (sortedSet == null) {
                    this.mSharedViewChildrenIndices.put(Integer.valueOf(id), new TreeSet(Collections.singleton(Integer.valueOf(iIndexOfChild))));
                } else {
                    sortedSet.add(Integer.valueOf(iIndexOfChild));
                }
            }
        }
        Iterator<SharedElement> it3 = list.iterator();
        while (it3.hasNext()) {
            View view2 = it3.next().sourceView;
            ((ViewGroup) view2.getParent()).removeView(view2);
            ((ViewGroup) this.mTransitionContainer).addView(view2);
            this.mReattachedViews.add(view2);
        }
    }

    private void startSharedTransition(List<SharedElement> list, int i) {
        for (SharedElement sharedElement : list) {
            View view = sharedElement.sourceView;
            view.setVisibility(0);
            startSharedAnimationForView(view, sharedElement.sourceViewSnapshot, sharedElement.targetViewSnapshot, i);
            sharedElement.targetView.setVisibility(4);
        }
    }

    private void startSharedAnimationForView(View view, Snapshot snapshot, Snapshot snapshot2, int i) {
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        HashMap<String, Object> mapPrepareDataForAnimationWorklet = this.mAnimationsManager.prepareDataForAnimationWorklet(snapshot.toCurrentMap(), false, true);
        HashMap<String, Object> map = new HashMap<>(this.mAnimationsManager.prepareDataForAnimationWorklet(targetMap, true, true));
        map.putAll(mapPrepareDataForAnimationWorklet);
        this.mNativeMethodsHolder.startAnimation(view.getId(), i, map);
    }

    protected void finishSharedAnimation(int i) {
        final ViewParent parent;
        if (this.mDisableCleaningForViewTag.containsKey(Integer.valueOf(i))) {
            enableCleaningForViewTag(i);
            return;
        }
        SharedElement sharedElement = this.mSharedElementsLookup.get(Integer.valueOf(i));
        if (sharedElement == null) {
            return;
        }
        this.mSharedElementsLookup.remove(Integer.valueOf(i));
        View view = sharedElement.sourceView;
        if (this.mReattachedViews.contains(view)) {
            this.mReattachedViews.remove(view);
            int id = view.getId();
            ((ViewGroup) this.mTransitionContainer).removeView(view);
            View view2 = this.mSharedTransitionParent.get(Integer.valueOf(id));
            Integer num = this.mSharedTransitionInParentIndex.get(Integer.valueOf(id));
            int iIntValue = num.intValue();
            ViewGroup viewGroup = (ViewGroup) view2;
            int id2 = viewGroup.getId();
            SortedSet<Integer> sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id2));
            int size = sortedSet.headSet(num).size();
            sortedSet.remove(num);
            if (sortedSet.isEmpty()) {
                this.mSharedViewChildrenIndices.remove(Integer.valueOf(id2));
            }
            int i2 = iIntValue - size;
            if (i2 <= viewGroup.getChildCount()) {
                viewGroup.addView(view, i2);
            } else {
                viewGroup.addView(view);
            }
            Snapshot snapshot = this.mSnapshotRegistry.get(Integer.valueOf(id));
            if (snapshot != null) {
                int i3 = snapshot.originX;
                int i4 = snapshot.originY;
                if (findStack(view) == null) {
                    snapshot.originX = snapshot.originXByParent;
                    snapshot.originY = snapshot.originYByParent;
                }
                HashMap<String, Object> basicMap = snapshot.toBasicMap();
                HashMap map = new HashMap();
                for (String str : basicMap.keySet()) {
                    Object obj = basicMap.get(str);
                    if (str.equals(Snapshot.TRANSFORM_MATRIX)) {
                        map.put(str, obj);
                    } else {
                        map.put(str, Double.valueOf(PixelUtil.toDIPFromPixel(Utils.convertToFloat(obj))));
                    }
                }
                this.mAnimationsManager.progressLayoutAnimation(id, map, true);
                snapshot.originX = i3;
                snapshot.originY = i4;
            }
            if (this.mViewTagsToHide.contains(Integer.valueOf(i))) {
                view.setVisibility(4);
            }
            this.mCurrentSharedTransitionViews.remove(Integer.valueOf(sharedElement.targetView.getId()));
            this.mCurrentSharedTransitionViews.remove(Integer.valueOf(id));
            this.mSharedTransitionParent.remove(Integer.valueOf(id));
            this.mSharedTransitionInParentIndex.remove(Integer.valueOf(id));
        }
        sharedElement.targetView.setVisibility(0);
        if (this.mRemovedSharedViews.contains(view)) {
            this.mRemovedSharedViews.remove(view);
            this.mSnapshotRegistry.remove(Integer.valueOf(view.getId()));
            this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        }
        if (this.mReattachedViews.isEmpty()) {
            View view3 = this.mTransitionContainer;
            if (view3 != null && (parent = view3.getParent()) != null) {
                this.mTransitionContainer.post(new Runnable() { // from class: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$finishSharedAnimation$1(parent);
                    }
                });
            }
            this.mSharedElements.clear();
            this.mSharedElementsWithProgress.clear();
            this.mSharedElementsWithAnimation.clear();
            this.mViewTagsToHide.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finishSharedAnimation$1(ViewParent viewParent) {
        if (this.mReattachedViews.size() > 0) {
            return;
        }
        ((ViewGroup) viewParent).removeView(this.mTransitionContainer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private View findScreen(View view) {
        for (ViewParent parent = view.getParent(); parent != 0; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals(Screen.TAG)) {
                return (View) parent;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private View findStack(View view) {
        for (ViewParent parent = view.getParent(); parent != 0; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals(ScreenStack.TAG)) {
                return (View) parent;
            }
        }
        return null;
    }

    protected void makeSnapshot(View view) {
        this.mSnapshotRegistry.put(Integer.valueOf(view.getId()), new Snapshot(view));
    }

    class PrepareConfigCleanupTreeVisitor implements TreeVisitor {
        PrepareConfigCleanupTreeVisitor() {
        }

        @Override // com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.TreeVisitor
        public void run(View view) {
            SharedTransitionManager.this.mTagsToCleanup.add(Integer.valueOf(view.getId()));
        }
    }

    protected void visitTreeForTags(int[] iArr, TreeVisitor treeVisitor) {
        if (iArr == null) {
            return;
        }
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        for (int i : iArr) {
            visitTree(reanimatedNativeHierarchyManager.resolveView(i), treeVisitor);
        }
    }

    private void visitTree(View view, TreeVisitor treeVisitor) {
        int id = view.getId();
        if (id == -1) {
            return;
        }
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        try {
            treeVisitor.run(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                ViewManager viewManagerResolveViewManager = reanimatedNativeHierarchyManager.resolveViewManager(id);
                ViewGroupManager viewGroupManager = viewManagerResolveViewManager instanceof ViewGroupManager ? (ViewGroupManager) viewManagerResolveViewManager : null;
                if (viewGroupManager == null) {
                    return;
                }
                for (int i = 0; i < viewGroupManager.getChildCount(viewGroup); i++) {
                    visitTree(viewGroupManager.getChildAt(viewGroup, i), treeVisitor);
                }
            }
        } catch (IllegalViewOperationException unused) {
        }
    }

    void visitNativeTreeAndMakeSnapshot(View view) {
        View topScreenForStack = ScreensHelper.getTopScreenForStack(view);
        if (topScreenForStack instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) topScreenForStack;
            if (this.mAnimationsManager.hasAnimationForTag(topScreenForStack.getId(), 4)) {
                makeSnapshot(topScreenForStack);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                visitNativeTreeAndMakeSnapshot(viewGroup.getChildAt(i));
            }
        }
    }

    private void clearAllSharedConfigsForView(View view) {
        int id = view.getId();
        this.mSnapshotRegistry.remove(Integer.valueOf(id));
        this.mNativeMethodsHolder.clearAnimationConfig(id);
    }

    private void disableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num != null) {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), 1);
        }
    }

    private void enableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num == null) {
            return;
        }
        if (num.intValue() == 1) {
            this.mDisableCleaningForViewTag.remove(Integer.valueOf(i));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    void orderByAnimationTypes(List<SharedElement> list) {
        this.mSharedElementsWithProgress.clear();
        this.mSharedElementsWithAnimation.clear();
        for (SharedElement sharedElement : list) {
            if (this.mAnimationsManager.hasAnimationForTag(sharedElement.sourceView.getId(), 5)) {
                this.mSharedElementsWithProgress.add(sharedElement);
            } else {
                this.mSharedElementsWithAnimation.add(sharedElement);
            }
        }
    }

    public void navigationTabChanged(View view, View view2) {
        Snapshot snapshot;
        this.mAddedSharedViews.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        findSharedViewsForScreen(view, arrayList2);
        sortViewsByTags(arrayList2);
        for (View view3 : arrayList2) {
            int[] sharedGroup = this.mNativeMethodsHolder.getSharedGroup(view3.getId());
            for (int length = sharedGroup.length - 1; length >= 0; length--) {
                View viewResolveView = this.mAnimationsManager.resolveView(sharedGroup[length]);
                if (ScreensHelper.isViewChildOfScreen(viewResolveView, view2) && (snapshot = this.mSnapshotRegistry.get(Integer.valueOf(view3.getId()))) != null) {
                    arrayList.add(new SharedElement(view3, snapshot, viewResolveView, new Snapshot(viewResolveView)));
                    break;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.mSharedElements = arrayList;
        this.mSharedElementsWithAnimation.clear();
        for (SharedElement sharedElement : arrayList) {
            this.mSharedElementsLookup.put(Integer.valueOf(sharedElement.sourceView.getId()), sharedElement);
            this.mSharedElementsWithAnimation.add(sharedElement);
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(arrayList);
        startSharedTransition(this.mSharedElementsWithAnimation, 4);
    }

    private void findSharedViewsForScreen(View view, List<View> list) {
        View topScreenForStack = ScreensHelper.getTopScreenForStack(view);
        if (topScreenForStack instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) topScreenForStack;
            if (this.mAnimationsManager.hasAnimationForTag(topScreenForStack.getId(), 4)) {
                list.add(topScreenForStack);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                findSharedViewsForScreen(viewGroup.getChildAt(i), list);
            }
        }
    }
}
