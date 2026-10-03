package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import androidx.activity.BackEventCompat;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda14;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private final DrawerLayout.DrawerListener backDrawerListener;
    private final MaterialBackOrchestrator backOrchestrator;
    private boolean bottomInsetScrimEnabled;
    private int drawerLayoutCornerSize;
    private final boolean drawerLayoutCornerSizeBackAnimationEnabled;
    private final int drawerLayoutCornerSizeBackAnimationMax;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final ShapeableDelegate shapeableDelegate;
    private final MaterialSideContainerBackHelper sideContainerBackHelper;
    private final int[] tmpLocation;
    private boolean topInsetScrimEnabled;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_NavigationView;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        ColorStateList colorStateListCreateDefaultColorStateList;
        int i2;
        int i3;
        int i4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i4), attributeSet, i);
        NavigationMenuPresenter navigationMenuPresenter = new NavigationMenuPresenter();
        this.presenter = navigationMenuPresenter;
        this.tmpLocation = new int[2];
        this.topInsetScrimEnabled = true;
        this.bottomInsetScrimEnabled = true;
        this.drawerLayoutCornerSize = 0;
        this.shapeableDelegate = ShapeableDelegate.create(this);
        this.sideContainerBackHelper = new MaterialSideContainerBackHelper(this);
        this.backOrchestrator = new MaterialBackOrchestrator(this);
        this.backDrawerListener = new DrawerLayout.SimpleDrawerListener() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(@NonNull View view) {
                NavigationView navigationView = NavigationView.this;
                if (view == navigationView) {
                    final MaterialBackOrchestrator materialBackOrchestrator = navigationView.backOrchestrator;
                    Objects.requireNonNull(materialBackOrchestrator);
                    view.post(new Runnable() { // from class: com.google.android.material.navigation.NavigationView$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            materialBackOrchestrator.startListeningForBackCallbacksWithPriorityOverlay();
                        }
                    });
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(@NonNull View view) {
                NavigationView navigationView = NavigationView.this;
                if (view == navigationView) {
                    navigationView.backOrchestrator.stopListeningForBackCallbacks();
                    NavigationView.this.maybeClearCornerSizeAnimationForDrawerLayout();
                }
            }
        };
        Context context2 = getContext();
        NavigationMenu navigationMenu = new NavigationMenu(context2);
        this.menu = navigationMenu;
        TintTypedArray tintTypedArrayObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.NavigationView, i, i4, new int[0]);
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_android_background)) {
            ViewCompat.setBackground(this, tintTypedArrayObtainTintedStyledAttributes.getDrawable(com.google.android.material.R.styleable.NavigationView_android_background));
        }
        int dimensionPixelSize = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.drawerLayoutCornerSize = dimensionPixelSize;
        this.drawerLayoutCornerSizeBackAnimationEnabled = dimensionPixelSize == 0;
        this.drawerLayoutCornerSizeBackAnimationMax = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList colorStateListOrNull = DrawableUtils.getColorStateListOrNull(background);
        if (background == null || colorStateListOrNull != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet, i, i4).build());
            if (colorStateListOrNull != null) {
                materialShapeDrawable.setFillColor(colorStateListOrNull);
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(tintTypedArrayObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateList = tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_subheaderColor) ? tintTypedArrayObtainTintedStyledAttributes.getColorStateList(com.google.android.material.R.styleable.NavigationView_subheaderColor) : null;
        int resourceId = tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance) ? tintTypedArrayObtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance, 0) : 0;
        if (resourceId == 0 && colorStateList == null) {
            colorStateList = createDefaultColorStateList(R.attr.textColorSecondary);
        }
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconTint)) {
            colorStateListCreateDefaultColorStateList = tintTypedArrayObtainTintedStyledAttributes.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemIconTint);
        } else {
            colorStateListCreateDefaultColorStateList = createDefaultColorStateList(R.attr.textColorSecondary);
        }
        int resourceId2 = tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextAppearance) ? tintTypedArrayObtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.NavigationView_itemTextAppearance, 0) : 0;
        boolean z = tintTypedArrayObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconSize)) {
            setItemIconSize(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateList2 = tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextColor) ? tintTypedArrayObtainTintedStyledAttributes.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemTextColor) : null;
        if (resourceId2 == 0 && colorStateList2 == null) {
            colorStateList2 = createDefaultColorStateList(R.attr.textColorPrimary);
        }
        Drawable drawable = tintTypedArrayObtainTintedStyledAttributes.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (drawable == null && hasShapeAppearance(tintTypedArrayObtainTintedStyledAttributes)) {
            drawable = createDefaultItemBackground(tintTypedArrayObtainTintedStyledAttributes);
            ColorStateList colorStateList3 = MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, com.google.android.material.R.styleable.NavigationView_itemRippleColor);
            if (colorStateList3 != null) {
                navigationMenuPresenter.setItemForeground(new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList3), null, createDefaultItemDrawable(tintTypedArrayObtainTintedStyledAttributes, null)));
            }
        }
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding)) {
            i2 = 0;
            setItemHorizontalPadding(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding, 0));
        } else {
            i2 = 0;
        }
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemVerticalPadding)) {
            setItemVerticalPadding(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemVerticalPadding, i2));
        }
        setDividerInsetStart(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetStart, i2));
        setDividerInsetEnd(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetEnd, i2));
        setSubheaderInsetStart(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetStart, i2));
        setSubheaderInsetEnd(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd, i2));
        setTopInsetScrimEnabled(tintTypedArrayObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled, this.topInsetScrimEnabled));
        setBottomInsetScrimEnabled(tintTypedArrayObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled, this.bottomInsetScrimEnabled));
        int dimensionPixelSize2 = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, i2);
        setItemMaxLines(tintTypedArrayObtainTintedStyledAttributes.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        navigationMenu.setCallback(new MenuBuilder.Callback() { // from class: com.google.android.material.navigation.NavigationView.2
            private static long _BOUNDARY;
            private static char[] _CREATION;
            private static final byte[] $$c = {125, -90, -45, 56};
            private static final int $$d = 68;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {88, 106, -42, -33, 52, -53, Ascii.CR, 1, 53, -47, -11, 0, -17, 2, Ascii.FF, -11, 8, -17, 5, -22, -1, 3};
            private static final int $$b = 93;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(short r5, int r6, int r7) {
                /*
                    int r7 = r7 * 2
                    int r0 = 1 - r7
                    byte[] r1 = com.google.android.material.navigation.NavigationView.AnonymousClass2.$$c
                    int r6 = r6 + 103
                    int r5 = r5 * 4
                    int r5 = r5 + 4
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    int r7 = 0 - r7
                    if (r1 != 0) goto L17
                    r4 = r6
                    r6 = r7
                    r3 = r2
                    goto L27
                L17:
                    r3 = r2
                L18:
                    byte r4 = (byte) r6
                    r0[r3] = r4
                    if (r3 != r7) goto L23
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0, r2)
                    return r5
                L23:
                    int r3 = r3 + 1
                    r4 = r1[r5]
                L27:
                    int r6 = r6 + r4
                    int r5 = r5 + 1
                    goto L18
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.AnonymousClass2.$$e(short, int, int):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(short r7, int r8, int r9, java.lang.Object[] r10) {
                /*
                    int r9 = r9 + 2
                    byte[] r0 = com.google.android.material.navigation.NavigationView.AnonymousClass2.$$a
                    int r8 = 18 - r8
                    int r7 = r7 + 66
                    byte[] r1 = new byte[r9]
                    r2 = 0
                    if (r0 != 0) goto L11
                    r3 = r8
                    r8 = r9
                    r4 = r2
                    goto L29
                L11:
                    r3 = r2
                L12:
                    int r8 = r8 + 1
                    int r4 = r3 + 1
                    byte r5 = (byte) r7
                    r1[r3] = r5
                    if (r4 != r9) goto L23
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    r10[r2] = r7
                    return
                L23:
                    r3 = r0[r8]
                    r6 = r8
                    r8 = r7
                    r7 = r3
                    r3 = r6
                L29:
                    int r7 = -r7
                    int r8 = r8 + r7
                    int r7 = r8 + (-2)
                    r8 = r3
                    r3 = r4
                    goto L12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.AnonymousClass2.b(short, int, int, java.lang.Object[]):void");
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }

            private static void a(char c, int i5, int i6, Object[] objArr) throws Throwable {
                int i7 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i6];
                _creation.b = 0;
                while (_creation.b < i6) {
                    int i8 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i5 + i8])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = (byte) (b + 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - TextUtils.indexOf("", "", 0, 0), (char) (9278 - TextUtils.lastIndexOf("", '0', 0, 0)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i8), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = (byte) (b3 + 3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (49362 - View.resolveSize(0, 0)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 685, -115095555, false, $$e(b3, b4, (byte) (b4 - 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i8] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.keyCodeFromString(""), (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16)), 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        int i9 = $10 + 71;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                char[] cArr = new char[i6];
                _creation.b = 0;
                int i11 = $10 + 71;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                while (_creation.b < i6) {
                    int i13 = $10 + 107;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    try {
                        Object[] objArr5 = {_creation, _creation};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 25, (char) (Process.getGidForName("") + 30069), (ViewConfiguration.getScrollBarSize() >> 8) + 816, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
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

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                OnNavigationItemSelectedListener onNavigationItemSelectedListener = NavigationView.this.listener;
                return onNavigationItemSelectedListener != null && onNavigationItemSelectedListener.onNavigationItemSelected(menuItem);
            }

            static {
                char[] cArr = new char[1959];
                ByteBuffer.wrap("\u0003\b\u001aË0ROÉe(|è\u009ax±óÏ\u0003æ\u0089ü\u001e\u001b\u008c1/H\u0090f6}»\u009bÃ±]ÈÒæLýô\u001bP2äHog\u0086}\f\u0094\u0092½ú¤9\u008e ñ;ÛÚÂ\u001a$\u008a\u000f\u0001qñX{Bì¥~\u008fÝöbØÕÃD%%\u000f¸v\u001aX©C\u0005¥\u008f\u008c\u0006ö\u0099Ùq\u0010\u0091\tR#Ë\\Pv±oq\u0089á¢jÜ\u009aõ\u0010ï\u0087\b\u0015\"¶[\tu½n?\u0088P¢Õ3Ù*\r\u0000\u009f\u007f\u001dUùL3ª©\u0081*ÿÃÖRÌÃ+\u0001\u0001ñxqVêMj«\u0010\u0081\u0097ø\u0015Ö\u0086Í\t+¼\u0002'xºWBMÛ¤T\u0082×\u0019Ñ\u0000\u0013*\u009aU\u0005\u007fñf2\u0080©«hÕÎüDæÁ\u0001V\u0019Ñ\u0000\u0013*\u009aU\u0005\u007fñf%\u0080§«+Õ\u0090üFæÜ\u0001I+î²H«\u009c\u0081\u0013þ\u009cÔ&Í½+3\u0000ð~uWéMzªÐ\u0080qùê×SÌþ*\u0093\u0000\u000e\u0019Ñ\u0000\u0012*\u008fU\u0012\u007f¿fy\u0080à«%ÕÎüCæÇ\u0001H+øRy\u0019\u008c\u0000\u0019*ÀU\u0004\u007f±f9\u0080º«hÕÌüSæÊ\u0001T+ñR\u007f|êgY\u0081\u0010«\u0093Ò\u001aü¹ç:\u0001¸(=R÷BF[Óq\n\u000eÎ${=óÛpð¢\u008e\u0006§\u0099½\u0000Z\u009ep;\tµ' <\u0093ÚÚðY\u0089Ð§s¼ðZrs÷\t>¿D¦\u0090\u008c\u0002ó\u0080Ù?À¦&6\rüsGZÊ@Y§\u009c\u008dgôêÚyÁý'\u0089\rMt\u0088Z\u001c\u0019\u009c\u0000\u001f*\u0089U\b\u007f±f.sÅjPá\tøÝÒO\u00adÍ\u0087r\u009eëx{S±-\u0004\u0004\u0087\u001e\u0018ùÑÓ(ª«\u0084;\u009f«yðSc*\u009b\u0004P\u001fãùcÐãª3\u0085\u0085\u009f\u0001v\u0098P\n+´\u0005!\u001cº#m:¹\u0010+o©E\u0016\\\u008fº\u001f\u0091Õï`ÆãÜ|;µ\u0011LhÏF_]Ï»\u0094\u0091\u0007èÿÆ*Ý\u0090;\u0005\u0012\u0082´Ü\u00ad\b\u0087\u009aø\u0018Ò§Ë>-®\u0006dxßQRKÁ¬\u0004\u0086ÿÿrÑáÊe,\u0016\u0006\u0096\u007f\u0016Q½J\u001e¬«\u00851ÿ¤ÐCÊ\u0095#P\u0005Ä\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf8\u0080««+ÕËüQæÛ\u0001C+íRbO\u008cV\u0019|À\u0003\u0004)«0?Ö¢ý\"\u0083\u0090ª^°ÁWU}ê¿ä¦g\u008cûóaÙÏÀ\f&Ô\rWs¾\u0018L\u0001\u009b+\u0001T\u0094~ gä\u00815ª²ÔOýÎç@\u0000Â*pSÿ}vfö\u0080\u0090\u0019\u0090\u0000\u0013*\u0083U\u0013\u007f\u00adf0\u0019\u008c\u0000\u0019*ÀU\u0016\u007f¬f9\u0080ª«3ÕÝüBæ\u0080\u0001K+ÿRx|ûg`\u0081\u001f«\u0095Ò\u001aü\u0093ç,\u0001³(<\u0019\u0099\u0000\u0013*\u0080U\u001f\u0019\u008e\u0000\u0013*\u009cU\u0015\u007f·f%\u0080º«hÕÍüOæÝ\u0001\b+üRr| gb\u0081\u001b«\u0094Ò\u001bü\u0081çp\u0001±(>R³}\u0010gÐ\u008eO¨ÍÓ{ýÉäi\u000eö(\u008bS)}\u009cd\u0003\u008e°©2Ó«ú4äÛ\u000fD\u0019\u008e\u0000\u0013*\u009cU\u0015\u007f·f%\u0080º«hÕÍüOæÝ\u0001\b+üRr| gb\u0081\u001b«\u0094Ò\u001bü\u0081çp\u0001±(>R³}\u0010gÐ\u008eO¨ÍÓ{ýÉäi\u000eö(\u008bS)}\u0098d\u0003\u008e°©2Ó¡ú4\u0019\u008e\u0000\u0013*\u009cU\u0015\u007f·f%\u0080º«hÕÍüOæÝ\u0001\b+üRr| gb\u0081\u001b«\u0094Ò\u001bü\u0081çp\u0001¤(!Rè}]gÇ\u008eG\u0002\u009b\u001b\u00061\u0089N\u0000d¢}0\u009b¯°}ÎØçZýÈ\u001a\u001d0éIggµ|w\u009a\u000e°\u0081É\u000eç\u0094üe\u001a±34IýfG|Â\u0095X\u0019\u008e\u0000\u0013*\u009cU\u0015\u007f·f%\u0080º«hÕÍüOæÝ\u0001\b+üRr| gb\u0081\u001b«\u0094Ò\u001bü\u0081çp\u0001¤(!Rè}SgÕ\u008eM\u0017Ð\u000eM$Â[Kqéh{\u008eä¥6Û\u0093ò\u0011è\u0083\u000fV%¢\\,rþi<\u008fE¥ÊÜEòßé.\u000fú&\u007f\\¶s\ri\u0086\u0080\u0013\u0019\u0088\u0000\u0014*\u0081U\u001e\u007f\u00adf0\u0019Ñ\u0000\u0006*\u009cU\t\u007f½fy\u0080£«)ÕÚüCæÂ\u0001C+í\u0019\u0088\u0000\u0014*\u0081U\u001e\u007f¹f#\u0080««5ÕÊ\u0019¹\u0000\u0013*\u0080U\u001f\u007f³f9\u0080º«/ÕÑüX\u0019\u008b\u0000\u0018*\u0085U\b\u007f±f!\u0080 \u0019\u009d\u0000\u001e*\u009cU\t\u007f³f?\u0080»«+\u0019\u008c\u0000\u0019*ÀU\u0016\u007f¬f9\u0080ª«3ÕÝüBæ\u0080\u0001B+ûR`|çge\u0081\u001b\u0019\u0088\u0000\u0014*\u0081U\u001e\u007fæf`\u0080¾\u0019\u0099\u0000\u0013*\u0080U\u0003\u007f¬f?\u0080\u00ad\u0019\u0099\u0000\u0013*\u0080U\u0003\u007f¬f?\u0080\u00ad«\u0019ÕÆü\u000eæ\u0098¹þ t\u008açõdßËÆX Ê\u000b~u¡\\iFÿ¡\u001e\u008bÏòE\u0019\u008c\u0000\u0019*ÀU\u0016\u007f¬f9\u0080ª«3ÕÝüBæ\u0080\u0001K+ñRr|ëgj\u0015\u000e\f\u0091&\u0006\u0019\u009b\u0000\u001b*\u009bU\n\u007f¿f\"\u0080¡«4»÷¢N\u0088Ö÷\u000eÝÄÄk\"è\tzw\u009f^\u0013D\u0083£N\u0089°ð1Þ´Ån#u\tÖpT^ÁE{£û\u0019¿\u0000\u0018*\u008aU\u0014\u007f±f?\u0080ª«fÕíüræå\u0001\u0006+üRc|çgj\u0081\n«ÖÒ\bü\u0089ç,\u0001ö(6Rþ}\b\u0019¿\u0000\u0018*\u008aU\u0014\u007f±f?\u0080ª«fÕíüræå\u0001\u0006+üRc|çgj\u0081\n«ÖÒ\bü\u0089ç,\u0001ö(6Rþ}\bgé\u008e\u0018¨\u0092\u0019\u008c\u0000\u0019*ÀU\u000e\u007f¿f$\u0080ª«1ÕßüDæË\u0019\u0099\u0000\u0019*\u0082U\u0002\u007f¸f?\u0080½«.\u0019\u0088\u0000\u0014*\u0081U\u001e\u007fæf`\u001a?\u0003¤)3V¶|\u0005e\u0090Ä«Ý>÷ç\u00881¢\u008b»\u001e]\u008dv\u0014\bú!e;§ÜcöË\u008fP¡ÇºE\u0019\u008c\u0000\u0019*ÀU\r\u007f»f$\u0080 «#ÕÒü\u0018æß\u0001C+óRc\u0019Ï\u0019\u008c\u0000\u0019*ÀU\u0015\u007f»f5\u0080»«4ÕÛ.K\u00993\u0080¦ª\u007fÕ»ÿ\u0014æ\u0080\u0000\u001d+\u009dU/|ùfc\u0081ö«EÒÜüRçÍ\u0011ö\bm\"ì]dwïn@\u0088\u0098£\u001e\u0014´\r!'øX<r\u0093k\u0007\u008d\u009a¦\u001aØ¨ñhëÿ\fp&Á_KqÄjN\u008c4¦§ß8ñª¯ñ¶{\u009cèãkÉÄÐW6Å\u001d\u0001c¥J:P\u00ad·a\u009d\u0091ä\u001bÊ\u0088Ñ\u000b7d\u001d÷de\u0019\u0099\u0000\u0013*\u0080U\u0003\u007f¬f?\u0080\u00ad«\u0019ÕÆü\u000eæ\u0098\u0001\t+íRr|ågY\u0081\u0006«ÎÒXüÉç9\u0001³( R£}Lgß\u008eM¨ùÓfý®ä8\u0019\u0099\u0000\u0013*\u0080U\u0003\u007f¬f?\u0080\u00ad«iÕÙüYæÁ\u0001A+òRs|Ñgu\u0081\u001a«\u009dÒAü\u0081ç;\u0001¸(+R´}WgÕpciéCz<ù\u0016V\u000fÅéWÂ\u0093¼2\u0095®\u008f;h¤B\\;Ú\u0015\u0004\u000eÓèòÂn»û\u0095d\u008e\u009ch\u001aAÄV\u0006O\u0086e\u001e\u001a\u009e0-)¬Ï~äª\u009aE³Â©nNÞdq\u001dá3~(÷Î\u0084ä6\u009d\u0089³A¨÷Nfg¶\u001d<2Ï(LÁÃçP\u009câ²V«éA!gW&\t?\u009c\u0015Ej\u0081@4Y¼¿?\u0094¯êTÃÒÙO>Æ\u0014i\u0019\u008c\u0000\u0019*ÀU\u0004\u007f±f9\u0080º«/ÕÓüWæÉ\u0001C+°Rt|ûgo\u0081\u0012«\u0092Ò@ü\u0080ç7\u0001¸()R£}LgÆ\u008e\\¨ÏÓpýâÓ!Ê\u0086à\u0014\u009f\u008aµ/¬¡J4aõ\u001fX6\u0090,\u0006\u0019\u008c\u0000\u0019*ÀU\u0004\u007f«f?\u0080¢«\"Õ\u0090üRæÇ\u0001U+îRz|ïg\u007f\u0081P«\u009fÒ\nÞªÇ3í½\u00922¸Ó\u0019\u0097\u0000\u0018*\u0087U\u0012\u007fðf%\u0080¸«%Õ\u0090üGæË\u0001K+ëR;|þgt\u0081\u0011«\u0086Ò\u001dâ±û-Ñ½®-\u0084Î\u009d\u0000{\u0087PV.í\u0007i\u001dùúvÐË©M\u0087É\u009cK\u0097¸\u008e$¤´Û$ñÇè\u0012\u000e\u009f%_[ïr`hò\u008ft¥öÜBòØé\\\u000f,%³\\8\u0019\u008f\u0000\u0013*\u0083U\u0013\u007fðf%\u0080¨«hÕÒüUæÊ\u0001y+úRs|àgu\u0081\u0017«\u0082Ò\u0017\u0019\u008c\u0000\u0019*ÀU\r\u007f»f$\u0080 «#ÕÒü\u0018æÏ\u0001H+úRd|ágo\u0081\u001a«ØÒ\u001fü\u0083ç3\u0001£(*\u0019\u008c\u0000\u0019*ÀU\u0004\u007f±f9\u0080º«hÕÏüSæÃ\u0001S+°Rw|øgb\u0081!«\u0098Ò\u000fü\u008bç;\u0019\u008c\u0000\u0019*ÀU\t\u007fºf;\u0080à«$ÕËü_æÂ\u0001B+°Rp|çgh\u0081\u0019«\u0093Ò\u001cü\u0096ç,\u0001¿( R²\u0019\u008c\u0000\u0019*ÀU\u0016\u007f¬f9\u0080ª«3ÕÝüBæ\u0080\u0001D+ëR\u007f|âgb\u0081P«\u0090Ò\u0007ü\u0088ç9\u0001³(<R¶}Lgß\u008e@¨Ò\u0019\u008c\u0000\u0019*ÀU\u0015\u007f§f%\u0080º«#ÕÓü\u0018æÌ\u0001S+÷Rz|êg(\u0081\u0018«\u009fÒ\u0000ü\u0081ç;\u0001¤(>R´}WgØ\u008eZbµ{ Qù.,\u0004\u009e\u001d\u001cû\u0083Ð\u001a®ê\u0087P\u009dòzgPÓ)\u0001\u0007Õ\u001cJú.Ð£©3\u0087ñ\u009c\u0001z\u0086S\u0019)\u0098\u0006b\u001cýõgÓí¨N\u0086Á\u009fC\u0019\u008c\u0000\u0019*ÀU\u0010\u007f»f8\u0080ª«)ÕÌü\u0018æÌ\u0001S+÷Rz|êg(\u0081\u0018«\u009fÒ\u0000ü\u0081ç;\u0001¤(>R´}WgØ\u008eZ&\u0011?\u0084\u0015]j\u008d@&Y¥¿7\u0094´êQÃôÙW>×\u0014hmæC=Xù¾\u0096\u0094\u0002í\u009fÃ\u001fØí>-\u0017ºm5BÄXN±Á\u0097KìñÂbÛý1o\u0019Ä\u0001È\u0018\u000b2\u0092M\tgè~>\u0098²³2ÍÒäpþÇ\u0019V3÷Jj\u000bm\u0012®87G¬mMt\u0099\u0092\u001d¹\u0099Çiîïôf\u0013µ9@@ËnAuß\u0093 ¹+À¼î>õ½\u0013\r:\u0097@\u0014oûun\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf%\u0080¡«%ÕÕüSæÚ\u0001\t+ùRs|àg\u007f\u0081\u001a\nY\u0013\u009a9\u0003F\u0098lyu\u00ad\u0093)¸\u00adÆ]ïÛõR\u0012\u00818gAûoktû\u0092\u0092\u0019Ñ\u0000\u0005*\u0097U\u0015\u007fñf'\u0080««+ÕËüiæÚ\u0001T+ÿRu|ë\u0019Ñ\u0000\u0005*\u0097U\u0015\u007fªf3\u0080£«iÕÒü_æÌ\u0001\t+òR\u007f|ìge\u0081!«\u009bÒ\u000fü\u008aç2\u0001¹(-R\u0099}ZgÓ\u008eL¨ÓÓyýÉä\u007f\u000eã(\u0093S\u0003}Àd\u0015\u008e±\u000fg\u0016¤<=C¦iGp\u0082\u0096\u000b½\u0084ÃWêçðh\u0017ã\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf4\u0080½«2ÕáüBæÇ\u0001K+û\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf%\u0080¡«%ÕÕüSæÚ\u0001\t+üRe|úg`\u0081\u0011«\u009aÒ\nü\u0083ç,\u0001²\u0019Ñ\u0000\u0005*\u0097U\u0015\u007fªf3\u0080£«iÕÒü_æÌ\u0001\t+òR\u007f|ìgd\u0081\r«\u0082Ò\bü\u0089ç2\u0001²(+R´}agÜ\u008e@¨ÏÓ0ýåäa\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf4\u0080½«2ÕßüUæÍ\u0001C\fø\u0015;?¢@9jØs\u001d\u0095\u0094¾\u001bÀðéfóõ\u0014`\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf4\u0080½«2ÕÓüSæÉ\u0001H\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf4\u0080½«2ÕÑüDæÇ\u0001C\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf4\u0080½«2ÕÈü[æÝ\u0001AK²Rqxè\u0007s-\u00924WÒÞùQ\u0087\u00ad®2´¬S,y\u008d\u0000\u0016\u0019Ñ\u0000\u0012*\u008bU\u0010\u007fñf4\u0080½«2Õáü_æÃ\u0001CR±Kraï\u001er4ß-\u0019ËÊàI\u009e©·8\u00ad¢J)`\u009f\u0019\u00127\u009d,IÊ0àî\u0099l·©¬\\JÅcZ\u0019Í\u0019Ñ\u0000\u001b*\u0080U\u0012\u007fñf!\u0080§«(ÕÚüYæÙ\u0001U+±RT|ýgr\u0081-«\u009eÒ\u000fü\u0094ç;\u0001²(\bR©}RgÒ\u008eK¨Ô\u0019Ñ\u0000\u0006*\u009cU\t\u007f½fy\u0080§«)ÕÎüYæÜ\u0001R+í\u0019Î\u0000\u0010*\u0088UF\u007fä\u0019Ñ\u0000\u0006*\u009cU\t\u007f½fy\u0080½«#ÕÒüPæ\u0081\u0001K+ÿRf|ý\u0088\f\u0091\u0091»\u001aÄ\u009fî'÷¬\u00118:ýDLmÌwW\u0090×ºmÃêíhöû\u0010Å:\u0010C\u0094XpAýkn\u0014Ã>p'ñÁ\u007fêû\u0094>½§§8@êj\u000f\u0013\u009b\u0019Ñ\u0000\u0013*\u009aU\u0005\u007fñf;\u0080««\"Õ×üWæñ\u0001E+ñRr|ëge\u0081\r«ØÒ\u0016ü\u008bç2\\/E©o(\u0010°:\u001e#\u0091Å\u001cî\u0096\u0090f¹ö\u0019Ñ\u0000\u0013*\u009aU\u0005\u007fñf;\u0080¡«3ÕÐüBæÝF6_õuh\nõ X9\u009eßMôÎ\u008a.£¿¹%^®t\u0018\r\u0095#\u001a8ÎÞ·ôu\u008dù£.¸Ø^AwÙ\rR\"÷8)Ñ¤÷-\u0019Ñ\u0000\u0006*\u009cU\t\u007f½fy\u0080\u00ad«6ÕËü_æÀ\u0001@+ñ)\u008b0+\u001a°e0O\u008aV\r°\u008f\u009b\u001c\u001aä\u0003')ºV'|\u008aeL\u0083\u0096¨\u001aÖøÿ`å´\u0002c(ÙQL\u007fÝdZ\u0082'¨¦Ñ(ÿüä\b\u0002\u0096+\tQÜ~;d¬\u008dx«üÐFþ\u008dçV\rÚ+¨P1~´g%\u008d\u0082ª\u0011Ð\u008fù]çæ\ff*öSfyÂfN\u008cÞ".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                _CREATION = cArr;
                _BOUNDARY = -6032541140003913610L;
            }

            /* JADX WARN: Code duplicated, block: B:124:0x0f67  */
            /* JADX WARN: Code duplicated, block: B:148:0x10c6  */
            /* JADX WARN: Code duplicated, block: B:201:0x15b1  */
            /* JADX WARN: Code duplicated, block: B:203:0x15fc  */
            /* JADX WARN: Code duplicated, block: B:204:0x1616  */
            /* JADX WARN: Code duplicated, block: B:207:0x1640 A[Catch: all -> 0x0208, TRY_ENTER, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:209:0x164d A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:212:0x16a0 A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:214:0x16ad A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:219:0x176d  */
            /* JADX WARN: Code duplicated, block: B:220:0x1774  */
            /* JADX WARN: Code duplicated, block: B:260:0x1c73  */
            /* JADX WARN: Code duplicated, block: B:263:0x26d9  */
            /* JADX WARN: Code duplicated, block: B:266:0x26eb A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:267:0x272d  */
            /* JADX WARN: Code duplicated, block: B:289:0x27ce  */
            /* JADX WARN: Code duplicated, block: B:290:0x2834  */
            /* JADX WARN: Code duplicated, block: B:293:0x28f3  */
            /* JADX WARN: Code duplicated, block: B:294:0x2962  */
            /* JADX WARN: Code duplicated, block: B:298:0x2997 A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:301:0x29da  */
            /* JADX WARN: Code duplicated, block: B:302:0x29dd A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:304:0x29f5 A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:340:0x3126  */
            /* JADX WARN: Code duplicated, block: B:343:0x33cb  */
            /* JADX WARN: Code duplicated, block: B:345:0x33da  */
            /* JADX WARN: Code duplicated, block: B:368:0x3559  */
            /* JADX WARN: Code duplicated, block: B:369:0x35b5  */
            /* JADX WARN: Code duplicated, block: B:373:0x3616 A[Catch: all -> 0x370e, TryCatch #7 {all -> 0x370e, blocks: (B:371:0x3609, B:373:0x3616, B:374:0x365b), top: B:419:0x3609, outer: #4 }] */
            /* JADX WARN: Code duplicated, block: B:378:0x3706 A[Catch: Exception -> 0x3717, TryCatch #4 {Exception -> 0x3717, blocks: (B:370:0x35b6, B:376:0x366c, B:378:0x3706, B:381:0x370f, B:383:0x3715, B:384:0x3716, B:371:0x3609, B:373:0x3616, B:374:0x365b), top: B:414:0x35b6, inners: #7 }] */
            /* JADX WARN: Code duplicated, block: B:379:0x370c  */
            /* JADX WARN: Code duplicated, block: B:388:0x371f  */
            /* JADX WARN: Code duplicated, block: B:389:0x3793  */
            /* JADX WARN: Code duplicated, block: B:392:0x37c1 A[Catch: all -> 0x0208, TryCatch #6 {all -> 0x0208, blocks: (B:6:0x00f1, B:8:0x00fe, B:9:0x0140, B:23:0x03a5, B:25:0x03b2, B:26:0x03f9, B:35:0x0592, B:37:0x059f, B:38:0x05dc, B:66:0x087c, B:68:0x0882, B:69:0x08c0, B:103:0x0cbc, B:105:0x0cc9, B:107:0x0d14, B:116:0x0e83, B:118:0x0e90, B:119:0x0ecd, B:160:0x11c8, B:162:0x11d5, B:163:0x1219, B:174:0x13cd, B:176:0x13da, B:177:0x141f, B:224:0x17e5, B:226:0x17eb, B:227:0x1823, B:236:0x1974, B:238:0x1985, B:239:0x19c9, B:247:0x1b05, B:249:0x1b12, B:250:0x1b56, B:253:0x1b6c, B:255:0x1b83, B:256:0x1bce, B:296:0x298a, B:298:0x2997, B:299:0x29d1, B:316:0x2e54, B:318:0x2e61, B:319:0x2ea6, B:390:0x37b4, B:392:0x37c1, B:393:0x37ff, B:326:0x2f8b, B:328:0x2f98, B:329:0x2fd4, B:302:0x29dd, B:304:0x29f5, B:305:0x2a36, B:264:0x26de, B:266:0x26eb, B:268:0x272f, B:207:0x1640, B:209:0x164d, B:210:0x1692, B:211:0x169b, B:212:0x16a0, B:214:0x16ad, B:215:0x16fc, B:43:0x06fc, B:45:0x0709, B:47:0x074a, B:53:0x079c, B:55:0x07a9, B:56:0x07e4), top: B:417:0x00f1 }] */
            /* JADX WARN: Code duplicated, block: B:396:0x389f  */
            /* JADX WARN: Code duplicated, block: B:397:0x390c  */
            /* JADX WARN: Code duplicated, block: B:438:0x3556 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:92:0x0af5  */
            /* JADX WARN: Instruction removed from duplicated block: B:343:0x33cb, please report this as an issue */
            /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6352 (expected less than 5000) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v192 */
            public static Object[] CoroutineDebuggingKt(Context context3, int i5, int i6, int i7) throws Throwable {
                String str;
                int i8;
                String str2;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                String str3;
                int i14;
                int i15;
                int i16;
                int i17;
                char c;
                int i18;
                int iIndexOf;
                int i19;
                int i20;
                int i21;
                char packedPositionType;
                int keyRepeatTimeout;
                int i22;
                int i23;
                char c2;
                int i24;
                String str4;
                int i25;
                int i26;
                int i27;
                Object obj;
                int i28;
                int i29;
                int i30;
                int maximumFlingVelocity;
                int i31;
                int i32;
                String str5;
                char cIndexOf;
                int keyRepeatTimeout2;
                int i33;
                Object obj2;
                String str6;
                int i34;
                Object objAccessartificialFrame;
                Long l;
                long j;
                int i35;
                Object objAccessartificialFrame2;
                long j2;
                String[][] strArr;
                ArrayList arrayList;
                int i36;
                int i37;
                int i38;
                Object[] objArr;
                int i39;
                char c3;
                char c4;
                int i40;
                int i41;
                Object[] objArr2;
                Object objAccessartificialFrame3;
                String str7;
                Object objAccessartificialFrame4;
                Object objInvoke;
                Object objAccessartificialFrame5;
                int i42;
                String str8;
                int i43;
                String str9;
                int i44;
                char c5;
                String[][] strArr2;
                int i45;
                int i46;
                int i47;
                int i48;
                int i49;
                int i50;
                int i51;
                Object objAccessartificialFrame6;
                int i52;
                Object[] objArr3;
                Object objAccessartificialFrame7;
                int i53;
                int i54;
                String str10;
                int i55;
                File file;
                String next;
                int i56;
                Object[] objArr4;
                int i57;
                int i58 = i5;
                int i59 = 2 % 2;
                int i60 = 0;
                char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                String str11 = "";
                int offsetAfter = TextUtils.getOffsetAfter("", 0);
                int i61 = 1;
                Object[] objArr5 = new Object[1];
                a(threadPriority, (offsetAfter ^ 717) + ((offsetAfter & 717) << 1), ImageFormat.getBitsPerPixel(0) + 9, objArr5);
                String str12 = (String) objArr5[0];
                char cResolveSize = (char) (6873 - View.resolveSize(0, 0));
                int iRgb = Color.rgb(0, 0, 0) + 16777216;
                int i62 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                int i63 = ((i62 | 28) << 1) - (i62 ^ 28);
                Object[] objArr6 = new Object[1];
                a(cResolveSize, iRgb, i63, objArr6);
                String str13 = (String) objArr6[0];
                int i64 = -ImageFormat.getBitsPerPixel(0);
                int i65 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                Object[] objArr7 = new Object[1];
                a((char) (((i64 | 42026) << 1) - (i64 ^ 42026)), (i65 & 27) + (i65 | 27), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 24, objArr7);
                String str14 = (String) objArr7[0];
                int i66 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                int i67 = -(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                int i68 = (i67 ^ 52) + ((i67 & 52) << 1);
                int i69 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                int i70 = (i69 & 19) + (i69 | 19);
                Object[] objArr8 = new Object[1];
                a((char) (((i66 | 2368) << 1) - (i66 ^ 2368)), i68, i70, objArr8);
                String str15 = (String) objArr8[0];
                int iMyTid = Process.myTid() >> 22;
                int i71 = 71 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                int i72 = -Color.red(0);
                int i73 = (i72 ^ 28) + ((i72 & 28) << 1);
                Object[] objArr9 = new Object[1];
                a((char) ((iMyTid ^ 10760) + ((iMyTid & 10760) << 1)), i71, i73, objArr9);
                String[] strArr3 = {str13, str14, str15, (String) objArr9[0]};
                int i74 = 0;
                while (true) {
                    if (i74 >= 4) {
                        str = str12;
                        i8 = i58;
                        str2 = str11;
                        i9 = i8;
                        break;
                    }
                    try {
                        Object[] objArr10 = {strArr3[i74]};
                        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(479197382);
                        if (objAccessartificialFrame8 == null) {
                            int iMyPid = 17 - (Process.myPid() >> 22);
                            char cIndexOf2 = (char) (24342 - TextUtils.indexOf((CharSequence) str11, '0', i60));
                            int i75 = 2015 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            Object[] objArr11 = new Object[i61];
                            b((byte) 38, (byte) 15, $$a[11], objArr11);
                            String str16 = (String) objArr11[i60];
                            Class[] clsArr = new Class[i61];
                            clsArr[i60] = String.class;
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMyPid, cIndexOf2, i75, -2081767730, false, str16, clsArr);
                        }
                        long jLongValue = ((Long) ((Method) objAccessartificialFrame8).invoke(null, objArr10)).longValue();
                        long j3 = -218332405;
                        long j4 = TypedValues.CycleType.TYPE_EASING;
                        String str17 = str11;
                        String[] strArr4 = strArr3;
                        long j5 = i58;
                        str2 = str17;
                        long j6 = -1;
                        long j7 = (((long) (-419)) * j3) + (((long) 421) * jLongValue) + (((jLongValue | j5) ^ j6) * j4);
                        str = str12;
                        long j8 = j3 ^ j6;
                        long j9 = j7 + (((long) (-420)) * (jLongValue | j8)) + (j4 * ((((jLongValue ^ j6) | j8) ^ j6) | (j6 ^ ((j5 ^ j6) | jLongValue)))) + ((long) 714943796);
                        int i76 = artificialFrame;
                        int i77 = ((i76 | 27) << 1) - (i76 ^ 27);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i77 % 128;
                        int i78 = i77 % 2;
                        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                        int i79 = ~elapsedCpuTime;
                        int i80 = ((int) (j9 >> 32)) & ((-492464762) + (((~(605749372 | i79)) | (-2042975784)) * (-865)) + ((~(elapsedCpuTime | (-605749373))) * 865) + (((~((-2042975784) | i79)) | (~(i79 | (-605749373)))) * 865));
                        i8 = i5;
                        int i81 = ((int) j9) & (((((~(1475084286 | i8)) | 25186888) * 449) - 1692334076) + ((25186888 | (~((~i8) | 1475084286))) * 449));
                        if (((i80 & i81) | (i80 ^ i81)) != 0) {
                            int i82 = i74 + FacebookRequestErrorClassification.EC_INVALID_TOKEN;
                            i9 = (~(i8 & i82)) & (i8 | i82);
                            break;
                        }
                        i74 = (((i74 | 14) << 1) - (i74 ^ 14)) - 13;
                        i58 = i8;
                        strArr3 = strArr4;
                        str12 = str;
                        str11 = str2;
                        i60 = 0;
                        i61 = 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
                int i83 = 3;
                if (i9 != i8) {
                    Object[] objArr12 = {null, new int[]{i ^ (i << 5)}, null, new int[]{i8}, new int[]{i9}};
                    int i84 = (((~((-688682312) | i8)) | 263173) * (-283)) + 679926416 + ((~((-688419139) | i8)) * 283);
                    int i85 = i84 * 367;
                    int i86 = (5872 ^ i85) + ((i85 & 5872) << 1) + (((i84 ^ 16) | (i84 & 16)) * (-366));
                    int i87 = ~i84;
                    int i88 = -(-(((~(i87 | i8)) | 16) * (-366)));
                    int i89 = (i86 ^ i88) + ((i88 & i86) << 1);
                    int i90 = ~((i84 & (-17)) | ((-17) ^ i84));
                    int i91 = i87 | 16;
                    int i92 = ~((i91 & i8) | (i91 ^ i8));
                    int i93 = -(-(((i90 & i92) | (i90 ^ i92)) * 366));
                    int i94 = ((i89 | i93) << 1) - (i93 ^ i89);
                    int i95 = (i7 & i94) + (i94 | i7);
                    int i96 = i95 << 13;
                    int i97 = (i95 | i96) & (~(i95 & i96));
                    int i98 = i97 >>> 17;
                    int i99 = ((~i97) & i98) | ((~i98) & i97);
                    return objArr12;
                }
                int i100 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int i101 = i100 * (-51);
                int i102 = ((i101 | 53) << 1) - (i101 ^ 53);
                int i103 = ~i8;
                int i104 = (i103 ^ i100) | (i103 & i100);
                int i105 = (~((i104 & 1) | (i104 ^ 1))) * 52;
                int i106 = ((i102 | i105) << 1) - (i102 ^ i105);
                int i107 = ~i8;
                int i108 = ~(((-2) ^ i107) | ((-2) & i107));
                int i109 = ~(((-2) & i100) | ((-2) ^ i100));
                int i110 = (i108 & i109) | (i108 ^ i109);
                int i111 = ~((i103 ^ i100) | (i103 & i100));
                int i112 = i106 + (((i110 & i111) | (i110 ^ i111)) * (-52));
                int i113 = ~i100;
                int i114 = ~((i113 ^ i103) | (i113 & i103));
                int i115 = ~((i113 & 1) | (i113 ^ 1));
                Object[] objArr13 = new Object[1];
                a((char) ((i112 - (~(-(-(((i115 & i114) | (i114 ^ i115)) * 52))))) - 1), 96 - (~(-(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))), 12 - (ViewConfiguration.getTapTimeout() >> 16), objArr13);
                String str18 = (String) objArr13[0];
                char c6 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int iArgb = Color.argb(0, 0, 0, 0);
                Object[] objArr14 = new Object[1];
                a(c6, ((iArgb | b.f39n) << 1) - (iArgb ^ b.f39n), 13 - View.MeasureSpec.getSize(0), objArr14);
                String str19 = (String) objArr14[0];
                char c7 = (char) (43927 - (~(-(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))));
                int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                int i116 = (((fadingEdgeLength * 960) - 235791) + (((~((-124) | i103)) | (~((fadingEdgeLength ^ i8) | (fadingEdgeLength & i8)))) * 959)) - (-118916);
                int i117 = ~((-124) | i8);
                int i118 = ~((fadingEdgeLength & i103) | (i103 ^ fadingEdgeLength));
                int i119 = -(-(((i118 & i117) | (i117 ^ i118)) * 959));
                Object[] objArr15 = new Object[1];
                a(c7, (i116 & i119) + (i119 | i116), 16 - (~(-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))), objArr15);
                String[] strArr5 = {str18, str19, (String) objArr15[0]};
                int i120 = 0;
                while (true) {
                    if (i120 >= i83) {
                        i10 = i103;
                        i11 = i107;
                        i12 = i8;
                        break;
                    }
                    Object[] objArr16 = {strArr5[i120]};
                    Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(479197382);
                    if (objAccessartificialFrame9 == null) {
                        int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 17;
                        char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 24344);
                        int iMyPid2 = (Process.myPid() >> 22) + 2014;
                        Object[] objArr17 = new Object[1];
                        b((byte) 38, (byte) 15, $$a[11], objArr17);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority2, bitsPerPixel, iMyPid2, -2081767730, false, (String) objArr17[0], new Class[]{String.class});
                    }
                    long jLongValue2 = ((Long) ((Method) objAccessartificialFrame9).invoke(null, objArr16)).longValue();
                    long j10 = -1279881582;
                    long j11 = 672;
                    i11 = i107;
                    long jMyTid = Process.myTid();
                    i10 = i103;
                    long j12 = -1;
                    String[] strArr6 = strArr5;
                    long j13 = jMyTid ^ j12;
                    long j14 = jLongValue2 ^ j12;
                    long j15 = (((long) 673) * j10) + (((long) (-1343)) * jLongValue2) + ((jLongValue2 | ((j10 | jMyTid) ^ j12)) * j11) + (((long) (-672)) * ((((j10 ^ j12) | j13) ^ j12) | ((jMyTid | jLongValue2) ^ j12))) + (j11 * (((j14 | j10) ^ j12) | ((j14 | j13) ^ j12))) + ((long) 1776492973);
                    int iMyPid3 = Process.myPid();
                    int i121 = ~iMyPid3;
                    int i122 = ((int) (j15 >> 32)) & (740665418 + (((~(377326654 | i121)) | 687882560) * (-108)) + (((~(i121 | 1059899756)) | (~((-1059899757) | iMyPid3)) | 5309458) * 54) + ((iMyPid3 | 5309458) * 54));
                    int iMyTid2 = Process.myTid();
                    int i123 = ~iMyTid2;
                    int i124 = ((int) j15) & (302638427 + (((~(5397731 | i123)) | (~((-1431828679) | iMyTid2))) * 333) + (((~(iMyTid2 | 5397731)) | (~(i123 | (-1431828679)))) * 333));
                    if (((i122 & i124) | (i122 ^ i124)) != 0) {
                        int i125 = i120 + RotationOptions.ROTATE_270;
                        i12 = (~(i8 & i125)) & (i8 | i125);
                        break;
                    }
                    i120++;
                    i107 = i11;
                    strArr5 = strArr6;
                    i103 = i10;
                    i83 = 3;
                }
                if (i12 != i8) {
                    Object[] objArr18 = {null, new int[1], null, new int[]{i8}, new int[]{i12}};
                    int iMyPid4 = Process.myPid();
                    int i126 = (((-1489452481) + (((-268472589) | (~iMyPid4)) * (-490))) + (((~(iMyPid4 | (-269800926))) | 1328337) * 490)) - 1258533922;
                    int i127 = (i126 ^ 16) + ((i126 & 16) << 1);
                    int iJ_ = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                    int i128 = i127 * 784;
                    int i129 = i7 * (-782);
                    int i130 = (i128 ^ i129) + ((i128 & i129) << 1);
                    int i131 = (~i7) * (-783);
                    int i132 = ((i130 | i131) << 1) - (i130 ^ i131);
                    int i133 = ~i127;
                    int i134 = ~iJ_;
                    int i135 = (i134 & i133) | (i133 ^ i134);
                    int i136 = (~((i135 & i7) | (i135 ^ i7))) * (-783);
                    int i137 = ~iJ_;
                    int i138 = ~((i137 & i7) | (i137 ^ i7));
                    int i139 = (i132 & i136) + (i136 | i132) + (((i133 & i138) | (i133 ^ i138)) * 783);
                    int i140 = i139 << 13;
                    int i141 = (i140 | i139) & (~(i139 & i140));
                    int i142 = i141 ^ (i141 >>> 17);
                    int i143 = i142 << 5;
                    ((int[]) objArr18[1])[0] = ((~i142) & i143) | ((~i143) & i142);
                    return objArr18;
                }
                char c8 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int i144 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                int i145 = ((i144 | 141) << 1) - (i144 ^ 141);
                int i146 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                int i147 = ((i146 | 14) << 1) - (i146 ^ 14);
                Object[] objArr19 = new Object[1];
                a(c8, i145, i147, objArr19);
                Object[] objArr20 = {(String) objArr19[0]};
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-11453480);
                if (objAccessartificialFrame10 == null) {
                    int iBlue = Color.blue(0) + 17;
                    char cMyTid = (char) ((Process.myTid() >> 22) + 24343);
                    int iMakeMeasureSpec = 2014 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    byte[] bArr = $$a;
                    Object[] objArr21 = new Object[1];
                    b((byte) 37, (byte) (bArr[18] + 1), bArr[11], objArr21);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iBlue, cMyTid, iMakeMeasureSpec, 1614052816, false, (String) objArr21[0], new Class[]{String.class});
                }
                long jLongValue3 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr20)).longValue();
                long j16 = 1517052464;
                long j17 = 881;
                long j18 = (j17 * j16) + (j17 * jLongValue3);
                long j19 = -880;
                long j20 = -1;
                long j21 = j16 ^ j20;
                long j22 = jLongValue3 ^ j20;
                long jMyTid2 = Process.myTid();
                long j23 = j18 + ((((j21 | j22) ^ j20) | ((j21 | jMyTid2) ^ j20) | ((j22 | jMyTid2) ^ j20)) * j19);
                long j24 = jLongValue3 | ((j21 | (jMyTid2 ^ j20)) ^ j20);
                long j25 = (jMyTid2 | j16) ^ j20;
                long j26 = j23 + (j19 * (j24 | j25)) + (((long) 880) * j25) + ((long) 45078573);
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i148 = ((int) (j26 >> 32)) & ((-861971582) + (((~((-810942466) | iMaxMemory)) | (-2046798420)) * (-756)) + (((~iMaxMemory) | (-810942466)) * 756));
                int startUptimeMillis = (int) Process.getStartUptimeMillis();
                int i149 = ((int) j26) & ((((-1024484349) + (((-1117377177) | (~startUptimeMillis)) * (-490))) + (((~(startUptimeMillis | (-1656345502))) | 538968325) * 490)) - 273219098);
                if (((i148 & i149) | (i148 ^ i149)) != 0) {
                    i13 = i10;
                    i14 = (i8 & (-267)) | (i13 & 266);
                    str3 = str2;
                } else {
                    i13 = i10;
                    char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int i150 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                    int i151 = (i150 ^ 155) + ((i150 & 155) << 1);
                    int i152 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    int iJ_2 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                    int i153 = i152 * (-167);
                    int i154 = ((i153 | (-4175)) << 1) - (i153 ^ (-4175));
                    int i155 = ~i152;
                    int i156 = (i155 & (-26)) | (i155 ^ (-26));
                    int i157 = ~i156;
                    int i158 = ~iJ_2;
                    int i159 = ~(((-26) & i158) | ((-26) ^ i158));
                    int i160 = -(-(((i157 & i159) | (i157 ^ i159)) * 168));
                    int i161 = (((i154 & i160) + (i154 | i160)) - (~((~((i156 & iJ_2) | (i156 ^ iJ_2))) * 168))) - 1;
                    int i162 = ~i152;
                    int i163 = ~iJ_2;
                    int i164 = (~(i162 | 25)) | (~((i163 & i162) | (i162 ^ i163)));
                    int i165 = i152 | (-26);
                    int i166 = ~((i165 & iJ_2) | (i165 ^ iJ_2));
                    int i167 = ((i166 & i164) | (i164 ^ i166)) * 168;
                    Object[] objArr22 = new Object[1];
                    a(scrollBarFadeDuration, i151, (i161 & i167) + (i167 | i161), objArr22);
                    Object[] objArr23 = {(String) objArr22[0]};
                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame11 == null) {
                        int iRgb2 = Color.rgb(0, 0, 0) + 16777239;
                        char cArgb = (char) Color.argb(0, 0, 0, 0);
                        str3 = str2;
                        int iLastIndexOf = TextUtils.lastIndexOf(str3, '0', 0, 0) + 2442;
                        byte[] bArr2 = $$a;
                        byte b = bArr2[11];
                        Object[] objArr24 = new Object[1];
                        b(b, (byte) (b | 10), bArr2[7], objArr24);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iRgb2, cArgb, iLastIndexOf, 954751276, false, (String) objArr24[0], new Class[]{String.class});
                    } else {
                        str3 = str2;
                    }
                    String str20 = (String) ((Method) objAccessartificialFrame11).invoke(null, objArr23);
                    if (str20 == null || str20.length() == 0) {
                        int i168 = -(ViewConfiguration.getScrollBarSize() >> 8);
                        int i169 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
                        artificialFrame = i169 % 128;
                        int i170 = i169 % 2;
                        int i171 = -Process.getGidForName(str3);
                        int i172 = -View.MeasureSpec.getSize(0);
                        int i173 = ((i172 | 24) << 1) - (i172 ^ 24);
                        Object[] objArr25 = new Object[1];
                        a((char) ((i168 ^ 23498) + ((i168 & 23498) << 1)), (178 & i171) + (i171 | 178), i173, objArr25);
                        Object[] objArr26 = {(String) objArr25[0]};
                        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame12 == null) {
                            int iLastIndexOf2 = TextUtils.lastIndexOf(str3, '0', 0) + 24;
                            char cGreen = (char) Color.green(0);
                            int i174 = 2442 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            byte[] bArr3 = $$a;
                            byte b2 = bArr3[11];
                            Object[] objArr27 = new Object[1];
                            b(b2, (byte) (b2 | 10), bArr3[7], objArr27);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cGreen, i174, 954751276, false, (String) objArr27[0], new Class[]{String.class});
                        }
                        String str21 = (String) ((Method) objAccessartificialFrame12).invoke(null, objArr26);
                        int i175 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                        artificialFrame = i175 % 128;
                        int i176 = i175 % 2;
                        if (str21 == null || str21.length() == 0) {
                            i14 = i8;
                        } else {
                            int i177 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i178 = (i177 & 85) + (i177 | 85);
                            artificialFrame = i178 % 128;
                            int i179 = i178 % 2;
                            i14 = (~(i8 & 267)) & (i8 | 267);
                        }
                    } else {
                        i14 = (i8 & (-268)) | (i13 & 267);
                    }
                }
                if (i14 != i8) {
                    Object[] objArr28 = {null, new int[1], null, new int[]{i8}, new int[]{i14}};
                    int i180 = artificialFrame + 45;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i180 % 128;
                    int i181 = i180 % 2;
                    int i182 = ~(Process.myTid() | 462764273);
                    int i183 = ((320080097 | i182) * (-196)) + 1015310605 + ((i182 | 142684176) * 196);
                    int i184 = i7 + (i183 & 16) + (i183 | 16);
                    int i185 = i184 << 13;
                    int i186 = (i184 | i185) & (~(i184 & i185));
                    int i187 = i186 ^ (i186 >>> 17);
                    ((int[]) objArr28[1])[0] = i187 ^ (i187 << 5);
                    return objArr28;
                }
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(943212816);
                if (objAccessartificialFrame13 == null) {
                    int mirror = AndroidCharacter.getMirror('0') - ')';
                    char cIndexOf3 = (char) (49361 - TextUtils.indexOf((CharSequence) str3, '0', 0, 0));
                    int iMyPid5 = 1768 - (Process.myPid() >> 22);
                    byte[] bArr4 = $$a;
                    Object[] objArr29 = new Object[1];
                    b(bArr4[21], (byte) (bArr4[6] + 1), bArr4[13], objArr29);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(mirror, cIndexOf3, iMyPid5, -1487073512, false, (String) objArr29[0], new Class[0]);
                }
                long jLongValue4 = ((Long) ((Method) objAccessartificialFrame13).invoke(null, null)).longValue();
                long j27 = 923886012;
                long j28 = 672;
                long j29 = i8;
                int i188 = i13;
                long j30 = j29 ^ j20;
                long j31 = (((long) 673) * j27) + (((long) (-1343)) * jLongValue4) + ((jLongValue4 | ((j27 | j29) ^ j20)) * j28) + (((long) (-672)) * ((((j27 ^ j20) | j30) ^ j20) | ((jLongValue4 | j29) ^ j20)));
                long j32 = jLongValue4 ^ j20;
                long j33 = j31 + (j28 * (((j32 | j27) ^ j20) | ((j32 | j30) ^ j20))) + ((long) 452005738);
                int iNextInt = new Random().nextInt();
                int i189 = ((int) (j33 >> 32)) & ((((~(1657877150 | iNextInt)) | 626345256) * 262) + 798577988 + (((~((~iNextInt) | 1657877150)) | 626345256) * 262));
                int i190 = ~((~((int) Runtime.getRuntime().freeMemory())) | 931658757);
                int i191 = ((int) j33) & (((84037637 | i190) * (-970)) + 916137287 + ((i190 | 847621120) * 970));
                int i192 = (i189 & i191) | (i189 ^ i191);
                if (i192 != 0) {
                    int i193 = (i192 ^ (-1)) + (i192 << 1);
                    int i194 = (i193 * 398) - 79200;
                    int i195 = ~i193;
                    int i196 = ~(i195 | i188);
                    int i197 = ~((i195 ^ 200) | (i195 & 200));
                    i16 = i11;
                    int i198 = ((i196 & i197) | (i196 ^ i197) | (~((i16 ^ 200) | (i16 & 200)))) * (-397);
                    int i199 = (((i194 ^ i198) + ((i194 & i198) << 1)) - (~((~(i195 | 200)) * (-397)))) - 1;
                    i15 = i5;
                    int i200 = (i15 ^ i197) | (i15 & i197);
                    int i201 = ~(i193 | (-201));
                    int i202 = i199 + (((i200 & i201) | (i200 ^ i201)) * 397);
                    i17 = (~(i15 & i202)) & (i15 | i202);
                } else {
                    i15 = i5;
                    i16 = i11;
                    i17 = i15;
                }
                if (i17 != i15) {
                    objArr3 = new Object[]{null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i15}, new int[]{i17}};
                    int i203 = (i7 - (~((((370958951 + ((((~((-855104313) | i15)) | 48321064) | (~((-249655855) | i15))) * (-754))) + (((~(i15 | (-48321065))) | (~(i188 | (-201334791)))) * (-754))) + (((-855104313) | i188) * 754)) + 16))) - 1;
                    int i204 = i203 << 13;
                    int i205 = ((~i203) & i204) | ((~i204) & i203);
                    int i206 = i205 >>> 17;
                    int i207 = ((~i205) & i206) | ((~i206) & i205);
                    int i208 = i207 << 5;
                } else {
                    char c9 = (char) (42644 - (~(-(-(ViewConfiguration.getTapTimeout() >> 16)))));
                    int i209 = -(-TextUtils.indexOf((CharSequence) str3, '0', 0));
                    Object[] objArr30 = new Object[1];
                    a(c9, (i209 ^ 204) + ((i209 & 204) << 1), 20 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr30);
                    String str22 = (String) objArr30[0];
                    char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
                    int i210 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i210 % 128;
                    if (i210 % 2 == 0) {
                        c = 0;
                        iIndexOf = TextUtils.indexOf(str3, str3, 0) * 223;
                        i18 = 1;
                        i19 = (CdmaCellLocation.convertQuartSecToDecDegrees(1) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(1) == 0.0d ? 0 : -1));
                        i20 = 11;
                    } else {
                        c = 0;
                        i18 = 1;
                        iIndexOf = 223 - TextUtils.indexOf(str3, str3, 0);
                        i19 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        i20 = 6;
                    }
                    int i211 = i20 + i19;
                    Object[] objArr31 = new Object[i18];
                    a(touchSlop, iIndexOf, i211, objArr31);
                    String str23 = (String) objArr31[c];
                    File file2 = new File(str22);
                    if (file2.exists() && file2.isFile()) {
                        try {
                            Scanner scanner = new Scanner(new FileInputStream(file2));
                            int i212 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                            int i213 = 227 - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                            int i214 = (iResolveOpacity ^ 2) + ((iResolveOpacity & 2) << 1);
                            Object[] objArr32 = new Object[1];
                            a((char) (((i212 | 27239) << 1) - (i212 ^ 27239)), i213, i214, objArr32);
                            Scanner scannerUseDelimiter = scanner.useDelimiter((String) objArr32[0]);
                            String next2 = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : str3;
                            scannerUseDelimiter.close();
                            if (next2.contains(str23)) {
                                i21 = i15 ^ 262;
                            } else {
                                i21 = i15;
                            }
                        } catch (IOException unused) {
                        }
                    } else {
                        i21 = i15;
                    }
                    if (i21 != i15) {
                        int i215 = artificialFrame + 41;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i215 % 128;
                        int i216 = i215 % 2;
                        objArr3 = new Object[]{null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i15}, new int[]{i21}};
                        int i217 = (-990376678) + (((~(i15 | 460179638)) | (-145268820)) * (-465)) + ((460179638 | (~((-145268820) | i15))) * 930) + (((-8396866) | i15) * 465);
                        int i218 = -(-(((i217 | 16) << 1) - (i217 ^ 16)));
                        int i219 = (i7 & i218) + (i7 | i218);
                        int i220 = i219 << 13;
                        int i221 = (i220 & (~i219)) | ((~i220) & i219);
                        int i222 = i221 >>> 17;
                        int i223 = ((~i221) & i222) | ((~i222) & i221);
                        int i224 = i223 << 5;
                    } else {
                        String[] strArr7 = new String[4];
                        int i225 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char c10 = (char) ((i225 ^ 63704) + ((i225 & 63704) << 1));
                        int edgeSlop = ViewConfiguration.getEdgeSlop() >> 16;
                        int i226 = getARTIFICIAL_FRAME_PACKAGE_NAME + 115;
                        artificialFrame = i226 % 128;
                        if (i226 % 2 == 0) {
                            Object[] objArr33 = new Object[1];
                            a(c10, (edgeSlop & 231) + (edgeSlop | 231), 101 - (~(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))), objArr33);
                            strArr7[0] = (String) objArr33[0];
                            packedPositionType = (char) (16653 << ExpandableListView.getPackedPositionType(1L));
                            keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout();
                            i22 = 15598;
                            i23 = 17;
                            c2 = 0;
                        } else {
                            Object[] objArr34 = new Object[1];
                            a(c10, (edgeSlop & 231) + (edgeSlop | 231), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 31, objArr34);
                            strArr7[0] = (String) objArr34[0];
                            int i227 = -(-ExpandableListView.getPackedPositionType(0L));
                            packedPositionType = (char) ((i227 & 15036) + (i227 | 15036));
                            keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout();
                            i22 = 262;
                            i23 = 16;
                            c2 = 1;
                        }
                        int i228 = -(-(keyRepeatTimeout >> i23));
                        int i229 = (i22 ^ i228) + ((i228 & i22) << 1);
                        int i230 = -ExpandableListView.getPackedPositionType(0L);
                        int i231 = ((i230 | 23) << 1) - (i230 ^ 23);
                        Object[] objArr35 = new Object[1];
                        a(packedPositionType, i229, i231, objArr35);
                        strArr7[c2] = (String) objArr35[0];
                        int i232 = -KeyEvent.normalizeMetaState(0);
                        int iNormalizeMetaState = 285 - KeyEvent.normalizeMetaState(0);
                        int i233 = -View.MeasureSpec.getMode(0);
                        int iJ_3 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                        int i234 = i233 * (-519);
                        int i235 = ((i234 | 14588) << 1) - (i234 ^ 14588);
                        int i236 = (~i233) | (-29);
                        int i237 = ~iJ_3;
                        int i238 = ~((i236 ^ i237) | (i236 & i237));
                        int i239 = ~((iJ_3 ^ 28) | (iJ_3 & 28));
                        int i240 = (i235 - (~(-(-(((i238 ^ i239) | (i238 & i239)) * 520))))) - 1;
                        int i241 = ~((~iJ_3) | (-29));
                        int i242 = (iJ_3 & i233) | (i233 ^ iJ_3);
                        int i243 = ~i242;
                        int i244 = i240 + (((i241 ^ i243) | (i241 & i243)) * (-1040));
                        int i245 = ~i233;
                        int i246 = ~((i245 & i237) | (i245 ^ i237));
                        int i247 = ~((i233 & (-29)) | ((-29) ^ i233));
                        int i248 = ((i247 & i246) | (i246 ^ i247) | (~i242)) * 520;
                        int i249 = (i244 ^ i248) + ((i248 & i244) << 1);
                        Object[] objArr36 = new Object[1];
                        a((char) ((i232 & 44301) + (i232 | 44301)), iNormalizeMetaState, i249, objArr36);
                        strArr7[2] = (String) objArr36[0];
                        Object[] objArr37 = new Object[1];
                        a((char) (ExpandableListView.getPackedPositionChild(0L) + 1), 314 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), TextUtils.lastIndexOf(str3, '0') + 15, objArr37);
                        strArr7[3] = (String) objArr37[0];
                        int i250 = 0;
                        while (true) {
                            if (i250 >= 4) {
                                i24 = i16;
                                str4 = str3;
                                i25 = i15;
                                break;
                            }
                            Object[] objArr38 = {strArr7[i250]};
                            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(267846469);
                            if (objAccessartificialFrame14 == null) {
                                int gidForName = 16 - Process.getGidForName(str3);
                                char cArgb2 = (char) (Color.argb(0, 0, 0, 0) + 24343);
                                int i251 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 2014;
                                byte[] bArr5 = $$a;
                                Object[] objArr39 = new Object[1];
                                b((byte) 38, (byte) (-bArr5[10]), bArr5[11], objArr39);
                                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(gidForName, cArgb2, i251, -1869462195, false, (String) objArr39[0], new Class[]{String.class});
                            }
                            long jLongValue5 = ((Long) ((Method) objAccessartificialFrame14).invoke(null, objArr38)).longValue();
                            long j34 = -1056183431;
                            i24 = i16;
                            str4 = str3;
                            long j35 = 130;
                            long j36 = jLongValue5 ^ j20;
                            long j37 = (((long) (-129)) * j34) + (((long) 131) * jLongValue5) + ((((j36 | j30) | j34) ^ j20) * j35);
                            int i252 = i250;
                            long j38 = j36 | j34;
                            long j39 = j37 + (((long) (-260)) * (j38 ^ j20)) + (j35 * ((((j34 ^ j20) | jLongValue5) ^ j20) | ((j38 | j29) ^ j20))) + ((long) (-255448545));
                            int i253 = ((int) (j39 >> 32)) & ((-1134385704) + (((~((-1123936598) | i15)) | 44853333 | (~(i188 | 1392373077))) * 886) + (((~(i188 | 1123936597)) | 313289813) * (-1772)) + ((~(i188 | 313289813)) * 886));
                            int iNextInt2 = new Random().nextInt();
                            int i254 = ((int) j39) & (484646344 + (((~((-1489617499) | iNextInt2)) | 1351205466) * 345) + (((~((-1489617499) | (~iNextInt2))) | 16917921) * 345) + ((~(iNextInt2 | (-1351205467))) * 345));
                            if (((i253 & i254) | (i253 ^ i254)) != 0) {
                                int i255 = i252 + 252;
                                i25 = (~(i15 & i255)) & (i255 | i15);
                                break;
                            }
                            i250 = ((i252 | 1) << 1) - (i252 ^ 1);
                            strArr7 = strArr7;
                            str3 = str4;
                            i16 = i24;
                        }
                        if (i25 == i15) {
                            int i256 = -(-View.combineMeasuredStates(0, 0));
                            int iRed = Color.red(0);
                            int i257 = (iRed ^ 327) + ((iRed & 327) << 1);
                            int i258 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int i259 = ((i258 | 13) << 1) - (i258 ^ 13);
                            Object[] objArr40 = new Object[1];
                            a((char) (((i256 | 22016) << 1) - (i256 ^ 22016)), i257, i259, objArr40);
                            Object[] objArr41 = {(String) objArr40[0]};
                            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                            if (objAccessartificialFrame15 == null) {
                                int defaultSize = View.getDefaultSize(0, 0) + 23;
                                char c11 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                int i260 = 2442 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                byte[] bArr6 = $$a;
                                byte b3 = bArr6[11];
                                Object[] objArr42 = new Object[1];
                                b(b3, (byte) (b3 | 10), bArr6[7], objArr42);
                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(defaultSize, c11, i260, 954751276, false, (String) objArr42[0], new Class[]{String.class});
                            }
                            String str24 = (String) ((Method) objAccessartificialFrame15).invoke(null, objArr41);
                            if (str24 != null) {
                                int deadChar = KeyEvent.getDeadChar(0, 0);
                                int iJ_4 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                                int i261 = deadChar * 141;
                                int i262 = (i261 ^ (-5923068)) + ((i261 & (-5923068)) << 1);
                                int i263 = ~deadChar;
                                int i264 = ~(i263 | 42612);
                                int i265 = ~deadChar;
                                int i266 = (i262 - (~(-(-((i264 | (~((i265 ^ iJ_4) | (i265 & iJ_4)))) * (-280)))))) - 1;
                                int i267 = -(-(((~((i263 & iJ_4) | (i263 ^ iJ_4))) | (~(((-42613) ^ iJ_4) | ((-42613) & iJ_4)))) * 140));
                                int i268 = (i266 & i267) + (i267 | i266);
                                int i269 = i265 | (-42613);
                                int i270 = ~((i269 & iJ_4) | (i269 ^ iJ_4));
                                int i271 = ~iJ_4;
                                int i272 = ~(42612 | (i265 ^ i271) | (i265 & i271));
                                int i273 = (i270 & i272) | (i270 ^ i272);
                                int i274 = ~(i271 | (-42613) | deadChar);
                                char c12 = (char) (i268 + (((i274 & i273) | (i273 ^ i274)) * 140));
                                int i275 = -Color.red(0);
                                int i276 = (i275 & 340) + (i275 | 340);
                                int iRed2 = Color.red(0);
                                Object[] objArr43 = new Object[1];
                                a(c12, i276, (iRed2 & 9) + (iRed2 | 9), objArr43);
                                if (str24.contains((String) objArr43[0])) {
                                    i26 = i188;
                                    i27 = (i15 & (-251)) | (i26 & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                                } else {
                                    i26 = i188;
                                    i27 = i15;
                                }
                            } else {
                                i26 = i188;
                                i27 = i15;
                            }
                            if (i27 == i15) {
                                String str25 = str4;
                                int i277 = -TextUtils.getCapsMode(str25, 0, 0);
                                int i278 = -KeyEvent.keyCodeFromString(str25);
                                int mode = View.MeasureSpec.getMode(0);
                                Object[] objArr44 = new Object[1];
                                a((char) ((i277 & 413) + (i277 | 413)), (i278 & 349) + (i278 | 349), (mode & 17) + (mode | 17), objArr44);
                                String str26 = (String) objArr44[0];
                                char cMyPid = (char) (Process.myPid() >> 22);
                                int i279 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                int i280 = ((i279 | 366) << 1) - (i279 ^ 366);
                                int i281 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i282 = ((i281 | 57) << 1) - (i281 ^ 57);
                                artificialFrame = i282 % 128;
                                if (i282 % 2 == 0) {
                                    Object[] objArr45 = new Object[1];
                                    a(cMyPid, i280, 6 << (ViewConfiguration.getMaximumFlingVelocity() >>> 87), objArr45);
                                    obj = objArr45[0];
                                } else {
                                    int i283 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                    int i284 = ((i283 | 6) << 1) - (i283 ^ 6);
                                    Object[] objArr46 = new Object[1];
                                    a(cMyPid, i280, i284, objArr46);
                                    obj = objArr46[0];
                                }
                                String str27 = (String) obj;
                                File file3 = new File(str26);
                                if (file3.exists() && file3.isFile()) {
                                    try {
                                        Scanner scanner2 = new Scanner(new FileInputStream(file3));
                                        Object[] objArr47 = new Object[1];
                                        a((char) (27240 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 228 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0))), 0 - (~(-ExpandableListView.getPackedPositionChild(0L))), objArr47);
                                        Scanner scannerUseDelimiter2 = scanner2.useDelimiter((String) objArr47[0]);
                                        String next3 = scannerUseDelimiter2.hasNext() ? scannerUseDelimiter2.next() : str25;
                                        scannerUseDelimiter2.close();
                                        if (!next3.contains(str27)) {
                                            i28 = i15;
                                        } else {
                                            int i285 = artificialFrame;
                                            int i286 = ((i285 | 37) << 1) - (i285 ^ 37);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i286 % 128;
                                            i28 = i286 % 2 != 0 ? i15 ^ 13276 : (i15 & (-252)) | (i26 & 251);
                                        }
                                    } catch (IOException unused2) {
                                    }
                                } else {
                                    i28 = i15;
                                }
                                if (i28 != i15) {
                                    int[] iArr = new int[1];
                                    objArr2 = new Object[]{null, iArr, null, new int[]{i15}, new int[]{i28}};
                                    int i287 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
                                    int i288 = i287 % 128;
                                    artificialFrame = i288;
                                    if (i287 % 2 == 0) {
                                        Object obj3 = null;
                                        obj3.hashCode();
                                        throw null;
                                    }
                                    int i289 = (i7 - (~(-(-(((((-1639082684) + ((((~((-673360161) | i26)) | (~((-290525249) | i15))) | (~(1031797110 | i15))) * 765)) + (((~((-963885409) | i26)) | 673360160) * 1530)) + (((~(i26 | 1031797110)) | (~(i15 | (-963885409)))) * 765)) + 16))))) - 1;
                                    int i290 = i289 << 13;
                                    int i291 = (i289 | i290) & (~(i289 & i290));
                                    int i292 = i291 >>> 17;
                                    int i293 = (i291 | i292) & (~(i291 & i292));
                                    int i294 = (i288 & 21) + (i288 | 21);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i294 % 128;
                                    if (i294 % 2 != 0) {
                                        ?? r2 = 0;
                                        r2[1] = i293 ^ (i293 + 2);
                                    } else {
                                        iArr[0] = i293 ^ (i293 << 5);
                                    }
                                } else {
                                    int iLastIndexOf3 = TextUtils.lastIndexOf(str25, '0', 0);
                                    int i295 = iLastIndexOf3 * (-520);
                                    int i296 = ((i295 | 522) << 1) - (i295 ^ 522);
                                    int i297 = ~iLastIndexOf3;
                                    int i298 = i297 | 1;
                                    int i299 = (~((i298 & i15) | (i298 ^ i15))) * 521;
                                    int i300 = ((i296 | i299) << 1) - (i296 ^ i299);
                                    int i301 = ~(((-2) & iLastIndexOf3) | ((-2) ^ iLastIndexOf3));
                                    int i302 = -(-(i301 * (-1042)));
                                    int i303 = ((i300 | i302) << 1) - (i302 ^ i300);
                                    int i304 = ~(i297 | i26 | 1);
                                    int i305 = -(-(((i304 & i301) | (i301 ^ i304)) * 521));
                                    char c13 = (char) (((i303 | i305) << 1) - (i305 ^ i303));
                                    int i306 = -TextUtils.indexOf(str25, str25, 0, 0);
                                    int i307 = (i306 ^ 372) + ((i306 & 372) << 1);
                                    int i308 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                    int i309 = (i308 ^ 24) + ((i308 & 24) << 1);
                                    Object[] objArr48 = new Object[1];
                                    a(c13, i307, i309, objArr48);
                                    Object[] objArr49 = {(String) objArr48[0]};
                                    Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                    if (objAccessartificialFrame16 == null) {
                                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 23;
                                        char c14 = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                                        int iResolveSizeAndState = 2441 - View.resolveSizeAndState(0, 0, 0);
                                        byte[] bArr7 = $$a;
                                        byte b4 = bArr7[11];
                                        Object[] objArr50 = new Object[1];
                                        b(b4, (byte) (b4 | 10), bArr7[7], objArr50);
                                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, c14, iResolveSizeAndState, 954751276, false, (String) objArr50[0], new Class[]{String.class});
                                    }
                                    String lowerCase = ((String) ((Method) objAccessartificialFrame16).invoke(null, objArr49)).toLowerCase();
                                    char cIndexOf4 = (char) TextUtils.indexOf(str25, str25, 0);
                                    int i310 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                    int i311 = ((i310 | 394) << 1) - (i310 ^ 394);
                                    int i312 = -(-TextUtils.indexOf(str25, str25));
                                    int i313 = ((i312 | 4) << 1) - (i312 ^ 4);
                                    Object[] objArr51 = new Object[1];
                                    a(cIndexOf4, i311, i313, objArr51);
                                    int i314 = lowerCase.contains((String) objArr51[0]) ? (i15 & (-265)) | (i26 & 264) : i15;
                                    if (i314 != i15) {
                                        objArr2 = new Object[]{null, new int[1], null, new int[]{i15}, new int[]{i314}};
                                        int iMyTid3 = Process.myTid();
                                        int i315 = (~((-324106755) | iMyTid3)) | 272656898;
                                        int i316 = ~((~iMyTid3) | 332791559);
                                        int i317 = (-94828363) + ((i315 | i316) * (-470)) + (((~(iMyTid3 | (-51449857))) | i316) * 470);
                                        int i318 = -(-((i317 & 16) + (i317 | 16)));
                                        int i319 = (i7 & i318) + (i7 | i318);
                                        int i320 = (i319 << 13) ^ i319;
                                        int i321 = i320 ^ (i320 >>> 17);
                                        int i322 = i321 << 5;
                                        ((int[]) objArr2[1])[0] = (i321 | i322) & (~(i321 & i322));
                                    } else {
                                        int i323 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                        char c15 = (char) ((i323 ^ 1) + ((i323 & 1) << 1));
                                        int i324 = -Color.green(0);
                                        int i325 = (i324 & 399) + (i324 | 399);
                                        int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay() >> 16;
                                        int i326 = ((keyRepeatDelay | 42) << 1) - (keyRepeatDelay ^ 42);
                                        Object[] objArr52 = new Object[1];
                                        a(c15, i325, i326, objArr52);
                                        String str28 = (String) objArr52[0];
                                        char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                        int i327 = -TextUtils.indexOf(str25, str25, 0, 0);
                                        int i328 = (i327 & 441) + (i327 | 441);
                                        int i329 = -Process.getGidForName(str25);
                                        Object[] objArr53 = new Object[1];
                                        a(scrollDefaultDelay, i328, (i329 & 39) + (i329 | 39), objArr53);
                                        String str29 = (String) objArr53[0];
                                        char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                                        int iCombineMeasuredStates = 481 - View.combineMeasuredStates(0, 0);
                                        byte modifierMetaStateMask = (byte) KeyEvent.getModifierMetaStateMask();
                                        Object[] objArr54 = new Object[1];
                                        a(windowTouchSlop, iCombineMeasuredStates, (modifierMetaStateMask & Ascii.FS) + (modifierMetaStateMask | Ascii.FS), objArr54);
                                        String str30 = (String) objArr54[0];
                                        char c16 = (char) (6932 - (~(-(ViewConfiguration.getKeyRepeatDelay() >> 16))));
                                        int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + TypedValues.PositionType.TYPE_CURVE_FIT;
                                        int i330 = -View.MeasureSpec.getSize(0);
                                        int i331 = (i330 ^ 27) + ((i330 & 27) << 1);
                                        Object[] objArr55 = new Object[1];
                                        a(c16, longPressTimeout, i331, objArr55);
                                        String str31 = (String) objArr55[0];
                                        char fadingEdgeLength2 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                        int i332 = -KeyEvent.getDeadChar(0, 0);
                                        Object[] objArr56 = new Object[1];
                                        a(fadingEdgeLength2, (i332 & 535) + (i332 | 535), 27 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr56);
                                        String str32 = (String) objArr56[0];
                                        char c17 = (char) (3678 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))));
                                        int i333 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                                        int i334 = ((i333 | 562) << 1) - (i333 ^ 562);
                                        int i335 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                        int i336 = (i335 & 27) + (i335 | 27);
                                        Object[] objArr57 = new Object[1];
                                        a(c17, i334, i336, objArr57);
                                        String[] strArr8 = {str28, str29, str30, str31, str32, (String) objArr57[0]};
                                        int i337 = 0;
                                        while (true) {
                                            if (i337 >= 6) {
                                                i29 = i15;
                                                break;
                                            }
                                            Object[] objArr58 = {strArr8[i337]};
                                            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                            if (objAccessartificialFrame17 == null) {
                                                int iIndexOf2 = TextUtils.indexOf(str25, str25, 0, 0) + 23;
                                                char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf(str25, '0', 0, 0));
                                                int offsetAfter2 = TextUtils.getOffsetAfter(str25, 0) + 2441;
                                                byte[] bArr8 = $$a;
                                                byte b5 = bArr8[11];
                                                Object[] objArr59 = new Object[1];
                                                b(b5, (byte) (b5 | 10), bArr8[7], objArr59);
                                                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cLastIndexOf, offsetAfter2, 954751276, false, (String) objArr59[0], new Class[]{String.class});
                                            }
                                            String str33 = (String) ((Method) objAccessartificialFrame17).invoke(null, objArr58);
                                            if (str33 != null && str33.length() != 0) {
                                                i29 = (i15 & (-266)) | (i26 & 265);
                                                break;
                                            }
                                            i337 = (i337 | 1) + (i337 & 1);
                                        }
                                        if (i29 != i15) {
                                            objArr2 = new Object[]{null, new int[1], null, new int[]{i15}, new int[]{i29}};
                                            int i338 = ~((int) Process.getElapsedCpuTime());
                                            int i339 = (-216735247) + (((-58721002) | i338) * SyslogConstants.LOG_LOCAL7) + (((~(i338 | 276782352)) | (-65558250)) * SyslogConstants.LOG_LOCAL7);
                                            int i340 = ((i339 | 16) << 1) - (i339 ^ 16);
                                            int i341 = (i7 & i340) + (i7 | i340);
                                            int i342 = i341 << 13;
                                            int i343 = (i342 & (~i341)) | ((~i342) & i341);
                                            int i344 = i343 >>> 17;
                                            int i345 = ((~i343) & i344) | ((~i344) & i343);
                                            int i346 = i345 << 5;
                                            ((int[]) objArr2[1])[0] = (i345 | i346) & (~(i345 & i346));
                                        } else {
                                            Object[] objArr60 = new Object[1];
                                            a((char) (412 - (~(-View.combineMeasuredStates(0, 0)))), 348 - (~(-(-(Process.myPid() >> 22)))), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 16, objArr60);
                                            String str34 = (String) objArr60[0];
                                            char cBlue = (char) Color.blue(0);
                                            int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize();
                                            int i347 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                                            artificialFrame = i347 % 128;
                                            if (i347 % 2 == 0) {
                                                i30 = 589 >> (maximumDrawingCacheSize >>> 46);
                                                maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
                                                i32 = 29;
                                                i31 = 118;
                                            } else {
                                                i30 = 589 - (maximumDrawingCacheSize >> 24);
                                                maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
                                                i31 = 16;
                                                i32 = 6;
                                            }
                                            int i348 = (i32 - (~(-(maximumFlingVelocity >> i31)))) - 1;
                                            Object[] objArr61 = new Object[1];
                                            a(cBlue, i30, i348, objArr61);
                                            String str35 = (String) objArr61[0];
                                            File file4 = new File(str34);
                                            if (file4.exists() && file4.isFile()) {
                                                try {
                                                    Scanner scanner3 = new Scanner(new FileInputStream(file4));
                                                    char c18 = (char) (27239 - (~(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))));
                                                    int iKeyCodeFromString = KeyEvent.keyCodeFromString(str25);
                                                    int iJ_5 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                                                    int i349 = (iKeyCodeFromString * (-112)) - 25648;
                                                    int i350 = ~iJ_5;
                                                    int i351 = -(-(((~(((-230) & i350) | ((-230) ^ i350))) | iKeyCodeFromString) * 226));
                                                    int i352 = (i349 & i351) + (i349 | i351);
                                                    int i353 = ~iKeyCodeFromString;
                                                    int i354 = ~(i353 | 229);
                                                    int i355 = ~(i353 | iJ_5);
                                                    int i356 = (i355 & i354) | (i354 ^ i355);
                                                    int i357 = i350 | (-230);
                                                    int i358 = ~((iKeyCodeFromString & i357) | (i357 ^ iKeyCodeFromString));
                                                    int i359 = (((i352 - (~(-(-(((i358 & i356) | (i356 ^ i358)) * (-113)))))) - 1) - (~(-(-((~(((-230) & iJ_5) | ((-230) ^ iJ_5))) * 113))))) - 1;
                                                    int i360 = -View.resolveSizeAndState(0, 0, 0);
                                                    int i361 = (i360 & 2) + (i360 | 2);
                                                    Object[] objArr62 = new Object[1];
                                                    a(c18, i359, i361, objArr62);
                                                    Scanner scannerUseDelimiter3 = scanner3.useDelimiter((String) objArr62[0]);
                                                    String next4 = scannerUseDelimiter3.hasNext() ? scannerUseDelimiter3.next() : str25;
                                                    scannerUseDelimiter3.close();
                                                    if (next4.contains(str35)) {
                                                        i35 = i15 ^ 260;
                                                    } else {
                                                        char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                                                        int scrollBarSize = ViewConfiguration.getScrollBarSize();
                                                        int i362 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i363 = (i362 & 1) + (i362 | 1);
                                                        artificialFrame = i363 % 128;
                                                        int i364 = i363 % 2;
                                                        int i365 = -(scrollBarSize >> 8);
                                                        Object[] objArr63 = new Object[1];
                                                        a(windowTouchSlop2, ((595 | i365) << 1) - (i365 ^ 595), 13 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr63);
                                                        str5 = (String) objArr63[0];
                                                        cIndexOf = (char) TextUtils.indexOf(str25, str25);
                                                        keyRepeatTimeout2 = ViewConfiguration.getKeyRepeatTimeout();
                                                        i33 = artificialFrame + 113;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                                                        if (i33 % 2 != 0) {
                                                            Object[] objArr64 = new Object[1];
                                                            a(cIndexOf, TypedValues.MotionType.TYPE_DRAW_PATH >> ((keyRepeatTimeout2 ^ (-42)) + ((keyRepeatTimeout2 & (-42)) << 1)), (ViewConfiguration.getMaximumFlingVelocity() >>> 82) * 39, objArr64);
                                                            obj2 = objArr64[0];
                                                        } else {
                                                            int i366 = -(keyRepeatTimeout2 >> 16);
                                                            Object[] objArr65 = new Object[1];
                                                            a(cIndexOf, ((i366 | TypedValues.MotionType.TYPE_DRAW_PATH) << 1) - (i366 ^ TypedValues.MotionType.TYPE_DRAW_PATH), 9 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr65);
                                                            obj2 = objArr65[0];
                                                        }
                                                        str6 = (String) obj2;
                                                        int i367 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        i34 = (i367 & 99) + (i367 | 99);
                                                        artificialFrame = i34 % 128;
                                                        if (i34 % 2 == 0) {
                                                            Object[] objArr66 = {str5, str6};
                                                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                                            if (objAccessartificialFrame2 == null) {
                                                                int iIndexOf3 = TextUtils.indexOf(str25, str25) + 31;
                                                                char c19 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 57021);
                                                                int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 2311;
                                                                byte[] bArr9 = $$a;
                                                                Object[] objArr67 = new Object[1];
                                                                b((byte) 31, bArr9[13], bArr9[7], objArr67);
                                                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf3, c19, pressedStateDuration, 1412547569, false, (String) objArr67[0], new Class[]{String.class, String.class});
                                                            }
                                                            l = (Long) ((Method) objAccessartificialFrame2).invoke(null, objArr66);
                                                        } else {
                                                            Object[] objArr68 = {str5, str6};
                                                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-883653127);
                                                            if (objAccessartificialFrame == null) {
                                                                int iRed3 = 31 - Color.red(0);
                                                                char c20 = (char) (57022 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                                                                int keyRepeatTimeout3 = 2311 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                                byte[] bArr10 = $$a;
                                                                Object[] objArr69 = new Object[1];
                                                                b((byte) 31, bArr10[13], bArr10[7], objArr69);
                                                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRed3, c20, keyRepeatTimeout3, 1412547569, false, (String) objArr69[0], new Class[]{String.class, String.class});
                                                            }
                                                            l = (Long) ((Method) objAccessartificialFrame).invoke(null, objArr68);
                                                        }
                                                        long jLongValue6 = l.longValue();
                                                        long j40 = 1662912054;
                                                        long j41 = -55;
                                                        long j42 = (j41 * j40) + (j41 * jLongValue6);
                                                        long j43 = 56;
                                                        j = j42 + ((((j40 | j29) ^ j20) | jLongValue6) * j43) + (((long) (-56)) * ((j40 | jLongValue6) ^ j20)) + (j43 * (((j30 | jLongValue6) ^ j20) | j40)) + ((long) (-1817663683));
                                                        if (((((int) (j >> 32)) & ((((-785636134) + (((-163599794) | i26) * (-490))) + (((~((-199349690) | i15)) | 35749896) * 490)) - 969205044)) | (((int) j) & ((-806704871) + ((~(1542979422 | i26)) * (-783)) + (((~(53962074 | i26)) | 1491188484) * 783)))) != 0) {
                                                            i35 = (~(i15 & 261)) & (i15 | 261);
                                                        } else {
                                                            i35 = i15;
                                                        }
                                                    }
                                                } catch (IOException unused3) {
                                                }
                                            } else {
                                                char windowTouchSlop3 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                                                int scrollBarSize2 = ViewConfiguration.getScrollBarSize();
                                                int i368 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i369 = (i368 & 1) + (i368 | 1);
                                                artificialFrame = i369 % 128;
                                                int i3610 = i369 % 2;
                                                int i3611 = -(scrollBarSize2 >> 8);
                                                Object[] objArr610 = new Object[1];
                                                a(windowTouchSlop3, ((595 | i3611) << 1) - (i3611 ^ 595), 13 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr610);
                                                str5 = (String) objArr610[0];
                                                cIndexOf = (char) TextUtils.indexOf(str25, str25);
                                                keyRepeatTimeout2 = ViewConfiguration.getKeyRepeatTimeout();
                                                i33 = artificialFrame + 113;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                                                if (i33 % 2 != 0) {
                                                    Object[] objArr611 = new Object[1];
                                                    a(cIndexOf, TypedValues.MotionType.TYPE_DRAW_PATH >> ((keyRepeatTimeout2 ^ (-42)) + ((keyRepeatTimeout2 & (-42)) << 1)), (ViewConfiguration.getMaximumFlingVelocity() >>> 82) * 39, objArr611);
                                                    obj2 = objArr611[0];
                                                } else {
                                                    int i3612 = -(keyRepeatTimeout2 >> 16);
                                                    Object[] objArr612 = new Object[1];
                                                    a(cIndexOf, ((i3612 | TypedValues.MotionType.TYPE_DRAW_PATH) << 1) - (i3612 ^ TypedValues.MotionType.TYPE_DRAW_PATH), 9 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr612);
                                                    obj2 = objArr612[0];
                                                }
                                                str6 = (String) obj2;
                                                int i3613 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                i34 = (i3613 & 99) + (i3613 | 99);
                                                artificialFrame = i34 % 128;
                                                if (i34 % 2 == 0) {
                                                    Object[] objArr613 = {str5, str6};
                                                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                                    if (objAccessartificialFrame2 == null) {
                                                        int iIndexOf4 = TextUtils.indexOf(str25, str25) + 31;
                                                        char c110 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 57021);
                                                        int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 2311;
                                                        byte[] bArr11 = $$a;
                                                        Object[] objArr614 = new Object[1];
                                                        b((byte) 31, bArr11[13], bArr11[7], objArr614);
                                                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c110, pressedStateDuration2, 1412547569, false, (String) objArr614[0], new Class[]{String.class, String.class});
                                                    }
                                                    l = (Long) ((Method) objAccessartificialFrame2).invoke(null, objArr613);
                                                } else {
                                                    Object[] objArr615 = {str5, str6};
                                                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-883653127);
                                                    if (objAccessartificialFrame == null) {
                                                        int iRed4 = 31 - Color.red(0);
                                                        char c21 = (char) (57022 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                                                        int keyRepeatTimeout4 = 2311 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                        byte[] bArr12 = $$a;
                                                        Object[] objArr616 = new Object[1];
                                                        b((byte) 31, bArr12[13], bArr12[7], objArr616);
                                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRed4, c21, keyRepeatTimeout4, 1412547569, false, (String) objArr616[0], new Class[]{String.class, String.class});
                                                    }
                                                    l = (Long) ((Method) objAccessartificialFrame).invoke(null, objArr615);
                                                }
                                                long jLongValue7 = l.longValue();
                                                long j44 = 1662912054;
                                                long j45 = -55;
                                                long j46 = (j45 * j44) + (j45 * jLongValue7);
                                                long j47 = 56;
                                                j = j46 + ((((j44 | j29) ^ j20) | jLongValue7) * j47) + (((long) (-56)) * ((j44 | jLongValue7) ^ j20)) + (j47 * (((j30 | jLongValue7) ^ j20) | j44)) + ((long) (-1817663683));
                                                if (((((int) (j >> 32)) & ((((-785636134) + (((-163599794) | i26) * (-490))) + (((~((-199349690) | i15)) | 35749896) * 490)) - 969205044)) | (((int) j) & ((-806704871) + ((~(1542979422 | i26)) * (-783)) + (((~(53962074 | i26)) | 1491188484) * 783)))) != 0) {
                                                    i35 = (~(i15 & 261)) & (i15 | 261);
                                                } else {
                                                    i35 = i15;
                                                }
                                            }
                                            if (i35 != i15) {
                                                objArr2 = new Object[]{null, new int[1], null, new int[]{i15}, new int[]{i35}};
                                                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                                                int i370 = ~startElapsedRealtime;
                                                int i371 = 125758388 + (((~((-436509515) | i370)) | (-168938944)) * (-865)) + ((~(startElapsedRealtime | 436509514)) * 865) + (((~((-168938944) | i370)) | (~(i370 | 436509514))) * 865);
                                                int i372 = (i371 ^ 16) + ((i371 & 16) << 1);
                                                int i373 = (i7 ^ i372) + ((i7 & i372) << 1);
                                                int i374 = (i373 << 13) ^ i373;
                                                int i375 = i374 ^ (i374 >>> 17);
                                                int i376 = i375 << 5;
                                                ((int[]) objArr2[1])[0] = ((~i375) & i376) | ((~i376) & i375);
                                            } else {
                                                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-913150042);
                                                if (objAccessartificialFrame18 == null) {
                                                    int i377 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 27;
                                                    char scrollBarSize3 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                                                    int absoluteGravity = 764 - Gravity.getAbsoluteGravity(0, 0);
                                                    byte[] bArr13 = $$a;
                                                    Object[] objArr70 = new Object[1];
                                                    b((byte) 31, bArr13[11], bArr13[13], objArr70);
                                                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i377, scrollBarSize3, absoluteGravity, 1459038638, false, (String) objArr70[0], new Class[0]);
                                                }
                                                long jLongValue8 = ((Long) ((Method) objAccessartificialFrame18).invoke(null, null)).longValue();
                                                long j48 = 170412223;
                                                long j49 = -755;
                                                long j50 = ((j48 ^ j20) | (jLongValue8 ^ j20)) ^ j20;
                                                long j51 = (j49 * j48) + (j49 * jLongValue8) + (((long) 1512) * j50);
                                                long j52 = jLongValue8 | j48;
                                                long j53 = j51 + (((long) (-756)) * (((j52 | j29) ^ j20) | j50)) + (((long) 756) * (j52 | j30)) + ((long) 1768189429);
                                                int i378 = ((int) (j53 >> 32)) & (993094654 + (((-1626446271) | i15) * 140) + (((~((-1626446271) | i26)) | 546408744) * (-280)) + (((~((-1231294615) | i26)) | 151257088 | (~((-546408745) | i15))) * 140));
                                                int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                                int i379 = ~startElapsedRealtime2;
                                                int i380 = ((int) j53) & ((((~(1439792830 | i379)) | (~((-2566421) | startElapsedRealtime2)) | (~(i379 | 2566420))) * 959) + 469233428 + (((~(startElapsedRealtime2 | 2566420)) | (~(i379 | (-2566421))) | (~(1439792830 | startElapsedRealtime2))) * 959));
                                                if (((i378 & i380) | (i378 ^ i380)) == 1) {
                                                    objArr2 = new Object[5];
                                                    objArr2[1] = new int[1];
                                                    objArr2[3] = new int[]{i15};
                                                    objArr2[4] = new int[]{i15};
                                                    int i381 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i382 = (i381 ^ 77) + ((i381 & 77) << 1);
                                                    artificialFrame = i382 % 128;
                                                    if (i382 % 2 == 0) {
                                                        objArr2[1] = null;
                                                        objArr2[2] = null;
                                                        int i383 = (-76488707) + (((~((-395891866) | i26)) | 68719632 | (~((-209556593) | i26)) | (~(536728825 | i15))) * (-84));
                                                        int i384 = (~(i15 | (-209556593))) | 395891865;
                                                        int i385 = ~(i26 | 209556592);
                                                        i57 = i383 + ((i384 | i385) * (-84)) + ((i385 | (-536728826)) * 84);
                                                    } else {
                                                        objArr2[0] = null;
                                                        objArr2[2] = null;
                                                        i57 = (-332987654) + (((~((-672694539) | i15)) | (~(794483547 | i26))) * 497) + (((~(i26 | (-727237468))) | 54542929 | (~(i15 | 794483547))) * 497);
                                                    }
                                                    int i386 = -(-i57);
                                                    int i387 = (i7 & i386) + (i7 | i386);
                                                    int i388 = i387 << 13;
                                                    int i389 = (i388 | i387) & (~(i387 & i388));
                                                    int i390 = i389 >>> 17;
                                                    int i391 = ((~i389) & i390) | ((~i390) & i389);
                                                    int i392 = i391 << 5;
                                                    ((int[]) objArr2[1])[0] = (i391 | i392) & (~(i391 & i392));
                                                } else {
                                                    Object[] objArr71 = {1};
                                                    Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1671772348);
                                                    if (objAccessartificialFrame19 == null) {
                                                        int iIndexOf5 = TextUtils.indexOf(str25, str25) + 18;
                                                        char mirror2 = (char) (AndroidCharacter.getMirror('0') - '0');
                                                        int iLastIndexOf4 = 1572 - TextUtils.lastIndexOf(str25, '0');
                                                        byte[] bArr14 = $$a;
                                                        Object[] objArr72 = new Object[1];
                                                        b((byte) 49, bArr14[18], bArr14[13], objArr72);
                                                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf5, mirror2, iLastIndexOf4, -54493516, false, (String) objArr72[0], new Class[]{Integer.TYPE});
                                                    }
                                                    long jLongValue9 = ((Long) ((Method) objAccessartificialFrame19).invoke(null, objArr71)).longValue();
                                                    long j54 = -803961381;
                                                    long j55 = j54 ^ j20;
                                                    long j56 = (((long) 303) * j54) + (((long) (-301)) * jLongValue9) + (((long) (-302)) * ((((j55 | j30) | jLongValue9) ^ j20) | (((j54 | jLongValue9) | j29) ^ j20))) + (((long) (-604)) * (((j55 | jLongValue9) | j29) ^ j20)) + (((long) 302) * (((jLongValue9 | j29) ^ j20) | ((j54 | (jLongValue9 ^ j20)) ^ j20))) + ((long) 1288546098);
                                                    int i393 = ((int) (j56 >> 32)) & (635053406 + (((~(1403059324 | i26)) | (~(1454681560 | i15))) * (-370)) + (((~(1403059324 | i15)) | (~(1454681560 | i26)) | 1386261592) * (-370)) + 1815680816);
                                                    int i394 = ((int) j56) & ((-501357939) + (((~((-2138666654) | i15)) | 710423192) * 336) + (((~(719074232 | i15)) | (-2147317694)) * (-168)) + (((-2138666654) | (~(719074232 | i26))) * 168));
                                                    int i395 = ((int) ((long) ((i393 & i394) | (i393 ^ i394)))) != 0 ? (i15 & (-221)) | (i26 & 220) : i15;
                                                    if (i395 != i15) {
                                                        objArr2 = new Object[]{null, new int[]{i ^ (i << 5)}, null, new int[]{i15}, new int[]{i395}};
                                                        int i396 = (-794383287) + (((~(i15 | 161768519)) | (-443679939)) * (-668)) + ((161768519 | (~((-443679939) | i15))) * 1336) + (((-307363969) | i15) * 668);
                                                        int i397 = -(-((i396 ^ 16) + ((i396 & 16) << 1)));
                                                        int i398 = (i7 & i397) + (i7 | i397);
                                                        int i399 = i398 << 13;
                                                        int i400 = (i399 & (~i398)) | ((~i399) & i398);
                                                        int i401 = i400 >>> 17;
                                                        int i402 = ((~i400) & i401) | ((~i401) & i400);
                                                    } else {
                                                        char windowTouchSlop4 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                                                        int i403 = -(-TextUtils.indexOf(str25, str25, 0));
                                                        int i404 = (i403 ^ 372) + ((i403 & 372) << 1);
                                                        int i405 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                        int i406 = (i405 ^ 22) + ((i405 & 22) << 1);
                                                        Object[] objArr73 = new Object[1];
                                                        a(windowTouchSlop4, i404, i406, objArr73);
                                                        Object[] objArr74 = {(String) objArr73[0]};
                                                        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                        if (objAccessartificialFrame20 == null) {
                                                            int size = 23 - View.MeasureSpec.getSize(0);
                                                            char c22 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                                                            int iArgb2 = 2441 - Color.argb(0, 0, 0, 0);
                                                            byte[] bArr15 = $$a;
                                                            byte b6 = bArr15[11];
                                                            Object[] objArr75 = new Object[1];
                                                            b(b6, (byte) (b6 | 10), bArr15[7], objArr75);
                                                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(size, c22, iArgb2, 954751276, false, (String) objArr75[0], new Class[]{String.class});
                                                        }
                                                        Object objInvoke2 = ((Method) objAccessartificialFrame20).invoke(null, objArr74);
                                                        if (objInvoke2 != null) {
                                                            int i407 = artificialFrame;
                                                            int i408 = (i407 & 81) + (i407 | 81);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i408 % 128;
                                                            int i409 = i408 % 2;
                                                            Object[] objArr76 = {objInvoke2, 42};
                                                            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-287841710);
                                                            if (objAccessartificialFrame21 == null) {
                                                                int i410 = 21 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                                char touchSlop2 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                                                                int scrollDefaultDelay2 = 2245 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                                                byte[] bArr16 = $$a;
                                                                Object[] objArr77 = new Object[1];
                                                                b((byte) 37, bArr16[16], bArr16[7], objArr77);
                                                                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i410, touchSlop2, scrollDefaultDelay2, 1907532890, false, (String) objArr77[0], new Class[]{String.class, Integer.TYPE});
                                                            }
                                                            long jLongValue10 = ((Long) ((Method) objAccessartificialFrame21).invoke(null, objArr76)).longValue();
                                                            long j57 = 887668380;
                                                            long j58 = -55;
                                                            long j59 = (j58 * j57) + (j58 * jLongValue10);
                                                            long j60 = 56;
                                                            long j61 = j59 + ((jLongValue10 | ((j57 | j29) ^ j20)) * j60) + (((long) (-56)) * ((j57 | jLongValue10) ^ j20)) + (j60 * (((j30 | jLongValue10) ^ j20) | j57)) + ((long) 745416948);
                                                            int iNextInt3 = new Random().nextInt();
                                                            int i411 = ~iNextInt3;
                                                            int i412 = ((int) (j61 >> 32)) & (1007585522 + (((~(iNextInt3 | (-573033988))) | (~((-1439703469) | i411)) | 2477057) * (-68)) + ((~((-570556931) | i411)) * (-68)) + (((~(573033987 | i411)) | (-2010260399)) * 68));
                                                            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                                                            int i413 = ((int) j61) & (((((~(1884224856 | iElapsedRealtime)) | (-1793743607)) * 262) - 1572526587) + (((~((~iElapsedRealtime) | 1884224856)) | (-1793743607)) * 262));
                                                            if (((i412 & i413) | (i412 ^ i413)) == 1986687685) {
                                                                j2 = j29;
                                                                i41 = 1;
                                                            } else {
                                                                int i414 = artificialFrame + b.i;
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i414 % 128;
                                                                int i415 = i414 % 2;
                                                                Object[] objArr78 = new Object[1];
                                                                a((char) ((-2) - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 371, (ViewConfiguration.getTouchSlop() >> 8) + 23, objArr78);
                                                                String str36 = (String) objArr78[0];
                                                                char c23 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                                                                int i416 = -View.resolveSizeAndState(0, 0, 0);
                                                                int i417 = (i416 & 617) + (i416 | 617);
                                                                int i418 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                                int i419 = (i418 ^ 10) + ((i418 & 10) << 1);
                                                                Object[] objArr79 = new Object[1];
                                                                a(c23, i417, i419, objArr79);
                                                                String str37 = (String) objArr79[0];
                                                                char c24 = (char) (0 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))));
                                                                int iAlpha = Color.alpha(0) + 627;
                                                                int i420 = -KeyEvent.normalizeMetaState(0);
                                                                int i421 = ((i420 | 7) << 1) - (i420 ^ 7);
                                                                Object[] objArr80 = new Object[1];
                                                                a(c24, iAlpha, i421, objArr80);
                                                                String str38 = (String) objArr80[0];
                                                                char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                                                                int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 634;
                                                                int i422 = -(-TextUtils.getOffsetBefore(str25, 0));
                                                                int i423 = (i422 ^ 8) + ((i422 & 8) << 1);
                                                                Object[] objArr81 = new Object[1];
                                                                a(tapTimeout, maxKeyCode, i423, objArr81);
                                                                String[] strArr9 = {str36, str37, str38, (String) objArr81[0]};
                                                                char pressedStateDuration3 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                                                                int i424 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                                Object[] objArr82 = new Object[1];
                                                                a(pressedStateDuration3, (i424 ^ 642) + ((i424 & 642) << 1), 15 - (~(-(-(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))), objArr82);
                                                                String str39 = (String) objArr82[0];
                                                                char scrollBarSize4 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                                                                int i425 = -View.resolveSizeAndState(0, 0, 0);
                                                                Object[] objArr83 = new Object[1];
                                                                a(scrollBarSize4, ((i425 | 659) << 1) - (i425 ^ 659), 6 - (~(ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr83);
                                                                String str40 = (String) objArr83[0];
                                                                Object[] objArr84 = new Object[1];
                                                                a((char) (Process.myTid() >> 22), 666 - View.MeasureSpec.getSize(0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 7, objArr84);
                                                                String str41 = (String) objArr84[0];
                                                                char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                                                                int i426 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                                                                Object[] objArr85 = new Object[1];
                                                                a(cNormalizeMetaState, ((i426 | 673) << 1) - (i426 ^ 673), 16777226 - (~(-(-Color.rgb(0, 0, 0)))), objArr85);
                                                                String str42 = (String) objArr85[0];
                                                                int i427 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                                                int i428 = 684 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                                                                int i429 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                                                                int i430 = ((i429 | 13) << 1) - (i429 ^ 13);
                                                                Object[] objArr86 = new Object[1];
                                                                a((char) (((i427 | 41063) << 1) - (i427 ^ 41063)), i428, i430, objArr86);
                                                                String[] strArr10 = {str39, str40, str41, str42, (String) objArr86[0]};
                                                                char pressedStateDuration4 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                                                                int threadPriority3 = Process.getThreadPriority(0);
                                                                int i431 = -(((threadPriority3 ^ 20) + ((threadPriority3 & 20) << 1)) >> 6);
                                                                int i432 = -(-Color.argb(0, 0, 0, 0));
                                                                int i433 = ((i432 | 16) << 1) - (i432 ^ 16);
                                                                Object[] objArr87 = new Object[1];
                                                                a(pressedStateDuration4, ((i431 | 698) << 1) - (i431 ^ 698), i433, objArr87);
                                                                String str43 = (String) objArr87[0];
                                                                int i434 = -Color.red(0);
                                                                int i435 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                                int i436 = (i435 ^ 714) + ((i435 & 714) << 1);
                                                                int i437 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                                int i438 = ((i437 | 3) << 1) - (i437 ^ 3);
                                                                Object[] objArr88 = new Object[1];
                                                                a((char) ((i434 ^ 3203) + ((i434 & 3203) << 1)), i436, i438, objArr88);
                                                                String str44 = (String) objArr88[0];
                                                                char mirror3 = (char) (AndroidCharacter.getMirror('0') + 41496);
                                                                int i439 = 724 - (~(-Color.alpha(0)));
                                                                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0);
                                                                int i440 = (bitsPerPixel2 ^ 23) + ((bitsPerPixel2 & 23) << 1);
                                                                Object[] objArr89 = new Object[1];
                                                                a(mirror3, i439, i440, objArr89);
                                                                String str45 = (String) objArr89[0];
                                                                char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                                                                int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                                                                int i441 = ((minimumFlingVelocity | 747) << 1) - (minimumFlingVelocity ^ 747);
                                                                int i442 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                                int i443 = ((i442 | 25) << 1) - (i442 ^ 25);
                                                                Object[] objArr90 = new Object[1];
                                                                a(cResolveOpacity, i441, i443, objArr90);
                                                                String str46 = (String) objArr90[0];
                                                                int i444 = -(-TextUtils.indexOf((CharSequence) str25, '0', 0, 0));
                                                                int i445 = 771 - (~(-(ViewConfiguration.getTouchSlop() >> 8)));
                                                                int i446 = -(-Gravity.getAbsoluteGravity(0, 0));
                                                                Object[] objArr91 = new Object[1];
                                                                a((char) ((i444 & 1) + (i444 | 1)), i445, ((i446 | 28) << 1) - (i446 ^ 28), objArr91);
                                                                String[] strArr11 = {str43, str44, str, str45, str46, (String) objArr91[0]};
                                                                Object[] objArr92 = new Object[1];
                                                                a((char) (ViewConfiguration.getJumpTapTimeout() >> 16), 800 - (~TextUtils.indexOf((CharSequence) str25, '0', 0)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 11, objArr92);
                                                                String str47 = (String) objArr92[0];
                                                                char cLastIndexOf2 = (char) ((-1) - TextUtils.lastIndexOf(str25, '0', 0));
                                                                int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() >> 16;
                                                                Object[] objArr93 = new Object[1];
                                                                a(cLastIndexOf2, (doubleTapTimeout & 811) + (doubleTapTimeout | 811), 6 - (~(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), objArr93);
                                                                String str48 = (String) objArr93[0];
                                                                char cGreen2 = (char) Color.green(0);
                                                                int i447 = -KeyEvent.getDeadChar(0, 0);
                                                                int i448 = (i447 ^ 819) + ((i447 & 819) << 1);
                                                                int i449 = -(-TextUtils.indexOf((CharSequence) str25, '0', 0));
                                                                Object[] objArr94 = new Object[1];
                                                                a(cGreen2, i448, (i449 & 7) + (i449 | 7), objArr94);
                                                                String str49 = (String) objArr94[0];
                                                                char cIndexOf5 = (char) (947 - TextUtils.indexOf(str25, str25));
                                                                int i450 = 824 - (~(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                                                                int doubleTapTimeout2 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                                                                int i451 = ((doubleTapTimeout2 | 6) << 1) - (doubleTapTimeout2 ^ 6);
                                                                Object[] objArr95 = new Object[1];
                                                                a(cIndexOf5, i450, i451, objArr95);
                                                                String[] strArr12 = {str47, str48, str49, (String) objArr95[0]};
                                                                char c25 = (char) (56613 - (~(-(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))));
                                                                int i452 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                Object[] objArr96 = new Object[1];
                                                                a(c25, ((i452 | 831) << 1) - (i452 ^ 831), 16 - (~(-(-MotionEvent.axisFromString(str25)))), objArr96);
                                                                String str50 = (String) objArr96[0];
                                                                char cRed = (char) Color.red(0);
                                                                int i453 = -(-(Process.myTid() >> 22));
                                                                Object[] objArr97 = new Object[1];
                                                                a(cRed, (i453 & 666) + (i453 | 666), 6 - (~KeyEvent.normalizeMetaState(0)), objArr97);
                                                                String str51 = (String) objArr97[0];
                                                                char windowTouchSlop5 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                                                                int i454 = -(-View.combineMeasuredStates(0, 0));
                                                                int i455 = (i454 ^ 634) + ((i454 & 634) << 1);
                                                                int i456 = -Process.getGidForName(str25);
                                                                int i457 = (i456 ^ 7) + ((i456 & 7) << 1);
                                                                Object[] objArr98 = new Object[1];
                                                                a(windowTouchSlop5, i455, i457, objArr98);
                                                                String[] strArr13 = {str50, str51, (String) objArr98[0]};
                                                                int i458 = -(-TextUtils.lastIndexOf(str25, '0', 0, 0));
                                                                Object[] objArr99 = new Object[1];
                                                                a((char) ((i458 & 1) + (i458 | 1)), 846 - TextUtils.indexOf((CharSequence) str25, '0'), KeyEvent.keyCodeFromString(str25) + 14, objArr99);
                                                                String str52 = (String) objArr99[0];
                                                                char tapTimeout2 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                                                                int i459 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                Object[] objArr100 = new Object[1];
                                                                a(tapTimeout2, (i459 & 861) + (i459 | 861), (-16777215) - Color.rgb(0, 0, 0), objArr100);
                                                                String[] strArr14 = {str52, (String) objArr100[0]};
                                                                char c26 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                int scrollDefaultDelay3 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                                                                int i460 = (scrollDefaultDelay3 ^ 862) + ((scrollDefaultDelay3 & 862) << 1);
                                                                int i461 = -(-ExpandableListView.getPackedPositionChild(0L));
                                                                int i462 = ((i461 | 10) << 1) - (i461 ^ 10);
                                                                Object[] objArr101 = new Object[1];
                                                                a(c26, i460, i462, objArr101);
                                                                String str53 = (String) objArr101[0];
                                                                int i463 = -View.MeasureSpec.getMode(0);
                                                                int i464 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                                                                int i465 = -View.combineMeasuredStates(0, 0);
                                                                int i466 = ((i465 | 1) << 1) - (i465 ^ 1);
                                                                Object[] objArr102 = new Object[1];
                                                                a((char) ((i463 & 14213) + (i463 | 14213)), (i464 ^ 870) + ((i464 & 870) << 1), i466, objArr102);
                                                                String[] strArr15 = {str53, (String) objArr102[0]};
                                                                char c27 = (char) (32958 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
                                                                int i467 = 872 - (~(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))));
                                                                int i468 = -(ViewConfiguration.getTapTimeout() >> 16);
                                                                int i469 = ((i468 | 16) << 1) - (i468 ^ 16);
                                                                Object[] objArr103 = new Object[1];
                                                                a(c27, i467, i469, objArr103);
                                                                String str54 = (String) objArr103[0];
                                                                int packedPositionType2 = ExpandableListView.getPackedPositionType(0L);
                                                                int i470 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                                int i471 = -(-TextUtils.getOffsetBefore(str25, 0));
                                                                int i472 = ((i471 | 3) << 1) - (i471 ^ 3);
                                                                Object[] objArr104 = new Object[1];
                                                                a((char) ((packedPositionType2 & 3203) + (packedPositionType2 | 3203)), (i470 ^ 715) + ((i470 & 715) << 1), i472, objArr104);
                                                                String str55 = (String) objArr104[0];
                                                                char size2 = (char) View.MeasureSpec.getSize(0);
                                                                int minimumFlingVelocity2 = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                                                                Object[] objArr105 = new Object[1];
                                                                a(size2, (minimumFlingVelocity2 & 659) + (minimumFlingVelocity2 | 659), TextUtils.lastIndexOf(str25, '0', 0, 0) + 8, objArr105);
                                                                String str56 = (String) objArr105[0];
                                                                Object[] objArr106 = new Object[1];
                                                                a((char) (2157 - (~Gravity.getAbsoluteGravity(0, 0))), ((Process.getThreadPriority(0) + 20) >> 6) + com.salesforce.marketingcloud.analytics.b.q, MotionEvent.axisFromString(str25) + 9, objArr106);
                                                                String str57 = (String) objArr106[0];
                                                                char capsMode = (char) TextUtils.getCapsMode(str25, 0, 0);
                                                                int i473 = -Drawable.resolveOpacity(0, 0);
                                                                int i474 = ((i473 | 673) << 1) - (i473 ^ 673);
                                                                int i475 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                                int i476 = ((i475 | 10) << 1) - (i475 ^ 10);
                                                                Object[] objArr107 = new Object[1];
                                                                a(capsMode, i474, i476, objArr107);
                                                                String str58 = (String) objArr107[0];
                                                                int i477 = -(-Color.blue(0));
                                                                int i478 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                                int i479 = (i478 ^ 683) + ((i478 & 683) << 1);
                                                                int iIndexOf6 = TextUtils.indexOf(str25, str25);
                                                                int iJ_6 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                                                                int i480 = (iIndexOf6 * 677) - 9450;
                                                                int i481 = (iIndexOf6 ^ iJ_6) | (iIndexOf6 & iJ_6);
                                                                int i482 = ((i481 ^ (-15)) | (i481 & (-15))) * (-676);
                                                                int i483 = ((i480 | i482) << 1) - (i480 ^ i482);
                                                                int i484 = ~(((-15) & iIndexOf6) | ((-15) ^ iIndexOf6));
                                                                int i485 = ~iJ_6;
                                                                int i486 = ~((i485 ^ iIndexOf6) | (i485 & iIndexOf6));
                                                                int i487 = ((i484 ^ i486) | (i484 & i486)) * 676;
                                                                int i488 = (i483 & i487) + (i483 | i487);
                                                                int i489 = ~iIndexOf6;
                                                                int i490 = ~((i489 ^ (-15)) | (i489 & (-15)));
                                                                j2 = j29;
                                                                int i491 = ~iJ_6;
                                                                int i492 = ~(((-15) & i491) | ((-15) ^ i491));
                                                                int i493 = iIndexOf6 | 14;
                                                                int i494 = -(-(((~((i493 & iJ_6) | (i493 ^ iJ_6))) | (i492 & i490) | (i490 ^ i492)) * 676));
                                                                Object[] objArr108 = new Object[1];
                                                                a((char) ((i477 & 41063) + (i477 | 41063)), i479, (i488 & i494) + (i494 | i488), objArr108);
                                                                String[] strArr16 = {str54, str55, str56, str57, str58, (String) objArr108[0]};
                                                                int i495 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                                int i496 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                                                int i497 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                                                int i498 = (i497 ^ 20) + ((i497 & 20) << 1);
                                                                Object[] objArr109 = new Object[1];
                                                                a((char) ((i495 & 3384) + (i495 | 3384)), (i496 & 896) + (i496 | 896), i498, objArr109);
                                                                String str59 = (String) objArr109[0];
                                                                int i499 = -(-Drawable.resolveOpacity(0, 0));
                                                                int longPressTimeout2 = ViewConfiguration.getLongPressTimeout() >> 16;
                                                                int size3 = View.MeasureSpec.getSize(0);
                                                                int i500 = (size3 ^ 19) + ((size3 & 19) << 1);
                                                                Object[] objArr110 = new Object[1];
                                                                a((char) ((i499 ^ 46696) + ((i499 & 46696) << 1)), (longPressTimeout2 & 916) + (longPressTimeout2 | 916), i500, objArr110);
                                                                String str60 = (String) objArr110[0];
                                                                char fadingEdgeLength3 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                                                int i501 = -TextUtils.indexOf(str25, str25);
                                                                int i502 = (i501 ^ 935) + ((i501 & 935) << 1);
                                                                int i503 = -MotionEvent.axisFromString(str25);
                                                                int i504 = ((i503 | 30) << 1) - (i503 ^ 30);
                                                                Object[] objArr111 = new Object[1];
                                                                a(fadingEdgeLength3, i502, i504, objArr111);
                                                                String str61 = (String) objArr111[0];
                                                                char cGreen3 = (char) Color.green(0);
                                                                int i505 = 965 - (~(-Color.argb(0, 0, 0, 0)));
                                                                int i506 = -TextUtils.indexOf(str25, str25, 0);
                                                                int i507 = (i506 ^ 26) + ((i506 & 26) << 1);
                                                                Object[] objArr112 = new Object[1];
                                                                a(cGreen3, i505, i507, objArr112);
                                                                String str62 = (String) objArr112[0];
                                                                int i508 = -Color.red(0);
                                                                int i509 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                                int i510 = ((i509 | 992) << 1) - (i509 ^ 992);
                                                                int i511 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                                int iJ_7 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                                                                int i512 = (~iJ_7) | (-24);
                                                                int i513 = ~((i512 & i511) | (i512 ^ i511));
                                                                int i514 = (i511 ^ 23) | (i511 & 23);
                                                                int i515 = ~((i514 & iJ_7) | (i514 ^ iJ_7));
                                                                int i516 = ((((i511 * 989) - 22701) - (~(-(-(((i513 & i515) | (i513 ^ i515)) * 988))))) - 1) + (((i511 ^ (-24)) | (i511 & (-24))) * (-988));
                                                                int i517 = ~((~i511) | (-24));
                                                                int i518 = ~((-24) | iJ_7);
                                                                int i519 = ~iJ_7;
                                                                int i520 = (i511 & i519) | (i519 ^ i511);
                                                                int i521 = -(-(((~((i520 & 23) | (i520 ^ 23))) | (i517 & i518) | (i517 ^ i518)) * 988));
                                                                int i522 = ((i516 | i521) << 1) - (i521 ^ i516);
                                                                Object[] objArr113 = new Object[1];
                                                                a((char) ((i508 & 27130) + (i508 | 27130)), i510, i522, objArr113);
                                                                String str63 = (String) objArr113[0];
                                                                int i523 = -Drawable.resolveOpacity(0, 0);
                                                                int i524 = -(-View.combineMeasuredStates(0, 0));
                                                                int i525 = (i524 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) + ((i524 & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) << 1);
                                                                int i526 = -(-Color.rgb(0, 0, 0));
                                                                int i527 = (i526 & 16777249) + (i526 | 16777249);
                                                                Object[] objArr114 = new Object[1];
                                                                a((char) ((i523 ^ 20383) + ((i523 & 20383) << 1)), i525, i527, objArr114);
                                                                String[] strArr17 = {str59, str60, str61, str62, str63, (String) objArr114[0], str};
                                                                char c28 = (char) (16262 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                                                int i528 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                                int i529 = ((i528 | 1047) << 1) - (i528 ^ 1047);
                                                                int threadPriority4 = Process.getThreadPriority(0);
                                                                int i530 = -((((threadPriority4 | 20) << 1) - (threadPriority4 ^ 20)) >> 6);
                                                                int i531 = (i530 ^ 13) + ((i530 & 13) << 1);
                                                                Object[] objArr115 = new Object[1];
                                                                a(c28, i529, i531, objArr115);
                                                                String str64 = (String) objArr115[0];
                                                                int i532 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                                                                int i533 = -Color.argb(0, 0, 0, 0);
                                                                int i534 = ((i533 | 627) << 1) - (i533 ^ 627);
                                                                int i535 = -(-TextUtils.getOffsetBefore(str25, 0));
                                                                int i536 = ((i535 | 7) << 1) - (i535 ^ 7);
                                                                Object[] objArr116 = new Object[1];
                                                                a((char) ((i532 ^ (-1)) + (i532 << 1)), i534, i536, objArr116);
                                                                String[] strArr18 = {str64, (String) objArr116[0]};
                                                                char cGreen4 = (char) Color.green(0);
                                                                int i537 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                                                                int i538 = -View.MeasureSpec.getSize(0);
                                                                int i539 = (i538 & 30) + (i538 | 30);
                                                                Object[] objArr117 = new Object[1];
                                                                a(cGreen4, (i537 ^ 1060) + ((i537 & 1060) << 1), i539, objArr117);
                                                                String str65 = (String) objArr117[0];
                                                                int i540 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                                Object[] objArr118 = new Object[1];
                                                                a((char) ((i540 ^ 51870) + ((i540 & 51870) << 1)), 1090 - (~(-(ViewConfiguration.getMinimumFlingVelocity() >> 16))), ExpandableListView.getPackedPositionType(0L) + 11, objArr118);
                                                                String[] strArr19 = {str65, (String) objArr118[0]};
                                                                char capsMode2 = (char) TextUtils.getCapsMode(str25, 0, 0);
                                                                int threadPriority5 = Process.getThreadPriority(0);
                                                                int i541 = ((((threadPriority5 | 20) << 1) - (threadPriority5 ^ 20)) >> 6) + 1102;
                                                                int i542 = -(ViewConfiguration.getTapTimeout() >> 16);
                                                                Object[] objArr119 = new Object[1];
                                                                a(capsMode2, i541, (i542 & 19) + (i542 | 19), objArr119);
                                                                String str66 = (String) objArr119[0];
                                                                int i543 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                                char c29 = (char) ((i543 ^ 50976) + ((i543 & 50976) << 1));
                                                                int i544 = -(-View.resolveSizeAndState(0, 0, 0));
                                                                Object[] objArr120 = new Object[1];
                                                                a(c29, (i544 & 1121) + (i544 | 1121), 5 - (~(-(-ImageFormat.getBitsPerPixel(0)))), objArr120);
                                                                String[] strArr20 = {str66, (String) objArr120[0]};
                                                                char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                                                                int tapTimeout3 = ViewConfiguration.getTapTimeout() >> 16;
                                                                int i545 = (tapTimeout3 & 1126) + (tapTimeout3 | 1126);
                                                                int offsetBefore = TextUtils.getOffsetBefore(str25, 0);
                                                                int i546 = (offsetBefore ^ 19) + ((offsetBefore & 19) << 1);
                                                                Object[] objArr121 = new Object[1];
                                                                a(deadChar2, i545, i546, objArr121);
                                                                String[] strArr21 = {(String) objArr121[0]};
                                                                int i547 = -View.MeasureSpec.getSize(0);
                                                                int iGreen = Color.green(0);
                                                                int i548 = ((iGreen | 1145) << 1) - (iGreen ^ 1145);
                                                                int i549 = -(Process.myTid() >> 22);
                                                                int i550 = ((i549 | 16) << 1) - (i549 ^ 16);
                                                                Object[] objArr122 = new Object[1];
                                                                a((char) ((i547 ^ 64318) + ((i547 & 64318) << 1)), i548, i550, objArr122);
                                                                String[] strArr22 = {(String) objArr122[0]};
                                                                Object[] objArr123 = new Object[1];
                                                                a((char) (36406 - (~(-TextUtils.indexOf(str25, str25, 0, 0)))), TextUtils.indexOf(str25, str25, 0, 0) + 1161, 18 - (~(-(-Color.blue(0)))), objArr123);
                                                                String[] strArr23 = {(String) objArr123[0]};
                                                                int i551 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                                int i552 = -Color.rgb(0, 0, 0);
                                                                Object[] objArr124 = new Object[1];
                                                                a((char) ((i551 ^ 1) + ((i551 & 1) << 1)), (i552 ^ (-16776036)) + ((i552 & (-16776036)) << 1), 18 - (~(-KeyEvent.getDeadChar(0, 0))), objArr124);
                                                                String[] strArr24 = {(String) objArr124[0]};
                                                                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                                                                int i553 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                                int i554 = -TextUtils.indexOf(str25, str25, 0, 0);
                                                                int i555 = (i554 ^ 23) + ((i554 & 23) << 1);
                                                                Object[] objArr125 = new Object[1];
                                                                a((char) ((packedPositionChild & 1) + (packedPositionChild | 1)), (i553 & 1200) + (i553 | 1200), i555, objArr125);
                                                                String[] strArr25 = {(String) objArr125[0]};
                                                                char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                                                                int size4 = View.MeasureSpec.getSize(0);
                                                                Object[] objArr126 = new Object[1];
                                                                a(jumpTapTimeout, (size4 ^ 1222) + ((size4 & 1222) << 1), 19 - (~(-TextUtils.indexOf((CharSequence) str25, '0'))), objArr126);
                                                                String[] strArr26 = {(String) objArr126[0]};
                                                                int i556 = -(-AndroidCharacter.getMirror('0'));
                                                                int i557 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                int i558 = (i557 & 1243) + (i557 | 1243);
                                                                int i559 = -Process.getGidForName(str25);
                                                                int i560 = ((i559 | 23) << 1) - (i559 ^ 23);
                                                                Object[] objArr127 = new Object[1];
                                                                a((char) ((i556 ^ (-48)) + ((i556 & (-48)) << 1)), i558, i560, objArr127);
                                                                String str67 = str;
                                                                String[] strArr27 = {(String) objArr127[0], str67};
                                                                char mode2 = (char) View.MeasureSpec.getMode(0);
                                                                int i561 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                                                Object[] objArr128 = new Object[1];
                                                                a(mode2, ((i561 | 1268) << 1) - (i561 ^ 1268), 28 - (~(-(-TextUtils.indexOf((CharSequence) str25, '0', 0, 0)))), objArr128);
                                                                String[] strArr28 = {(String) objArr128[0], str67};
                                                                int i562 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                                int i563 = 1294 - (~(-(-(KeyEvent.getMaxKeyCode() >> 16))));
                                                                int iResolveSize = View.resolveSize(0, 0);
                                                                int i564 = (iResolveSize * (-464)) - 25083;
                                                                int i565 = ~iResolveSize;
                                                                int i566 = (i15 ^ 27) | (i15 & 27);
                                                                int i567 = ~i566;
                                                                int i568 = -(-(((i567 & i565) | (i565 ^ i567)) * (-465)));
                                                                int i569 = (i564 ^ i568) + ((i564 & i568) << 1);
                                                                int i570 = ~((i565 ^ i15) | (i565 & i15));
                                                                int i571 = -(-(((i570 & 27) | (i570 ^ 27)) * 930));
                                                                int i572 = (i569 & i571) + (i571 | i569);
                                                                int i573 = ~iResolveSize;
                                                                Object[] objArr129 = new Object[1];
                                                                a((char) ((i562 ^ (-1)) + (i562 << 1)), i563, i572 + (((i573 & i566) | (i566 ^ i573)) * 465), objArr129);
                                                                String[] strArr29 = {(String) objArr129[0], str67};
                                                                int i574 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                                Object[] objArr130 = new Object[1];
                                                                a((char) ((i574 & 31545) + (i574 | 31545)), 1322 - (ViewConfiguration.getWindowTouchSlop() >> 8), 31 - View.MeasureSpec.getSize(0), objArr130);
                                                                String[] strArr30 = {(String) objArr130[0], str67};
                                                                Object[] objArr131 = new Object[1];
                                                                a((char) Drawable.resolveOpacity(0, 0), 1352 - (~(-(ViewConfiguration.getScrollBarSize() >> 8))), 27 - TextUtils.getTrimmedLength(str25), objArr131);
                                                                String[] strArr31 = {(String) objArr131[0], str67};
                                                                int i575 = -(-Color.green(0));
                                                                int tapTimeout4 = (ViewConfiguration.getTapTimeout() >> 16) + 1380;
                                                                int i576 = -MotionEvent.axisFromString(str25);
                                                                Object[] objArr132 = new Object[1];
                                                                a((char) ((i575 & 16285) + (i575 | 16285)), tapTimeout4, (i576 & 31) + (i576 | 31), objArr132);
                                                                strArr = new String[][]{strArr9, strArr10, strArr11, strArr12, strArr13, strArr14, strArr15, strArr16, strArr17, strArr18, strArr19, strArr20, strArr21, strArr22, strArr23, strArr24, strArr25, strArr26, strArr27, strArr28, strArr29, strArr30, strArr31, new String[]{(String) objArr132[0], str67}};
                                                                arrayList = new ArrayList();
                                                                i36 = i15;
                                                                i37 = 0;
                                                                i38 = 0;
                                                                while (i37 < 24) {
                                                                    String[] strArr32 = strArr[i37];
                                                                    Object[] objArr133 = {strArr32[0]};
                                                                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                                    if (objAccessartificialFrame3 == null) {
                                                                        int iResolveSize2 = 23 - View.resolveSize(0, 0);
                                                                        char defaultSize2 = (char) View.getDefaultSize(0, 0);
                                                                        int offsetBefore2 = TextUtils.getOffsetBefore(str25, 0) + 2441;
                                                                        byte[] bArr17 = $$a;
                                                                        byte b7 = bArr17[11];
                                                                        Object[] objArr134 = new Object[1];
                                                                        b(b7, (byte) (b7 | 10), bArr17[7], objArr134);
                                                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveSize2, defaultSize2, offsetBefore2, 954751276, false, (String) objArr134[0], new Class[]{String.class});
                                                                    }
                                                                    str7 = (String) ((Method) objAccessartificialFrame3).invoke(null, objArr133);
                                                                    int i577 = 1;
                                                                    String[] strArr33 = (String[]) Arrays.copyOfRange(strArr32, 1, strArr32.length);
                                                                    if (str7 == null && str7.length() != 0) {
                                                                        if (strArr32.length == 1) {
                                                                            int i578 = (i38 & 1) + (i38 | 1);
                                                                            int i579 = ((i37 | 10) << 1) - (i37 ^ 10);
                                                                            i36 = (~(i15 & i579)) & (i579 | i15);
                                                                            StringBuilder sb = new StringBuilder();
                                                                            sb.append(str7);
                                                                            char c30 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                            int iIndexOf7 = TextUtils.indexOf(str25, str25, 0, 0);
                                                                            Object[] objArr135 = new Object[1];
                                                                            a(c30, (iIndexOf7 ^ 1412) + ((iIndexOf7 & 1412) << 1), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr135);
                                                                            sb.append((String) objArr135[0]);
                                                                            sb.append(str7);
                                                                            arrayList.add(sb.toString());
                                                                            i38 = i578;
                                                                            break;
                                                                            break;
                                                                        }
                                                                        int length = strArr33.length;
                                                                        int i580 = 0;
                                                                        while (i580 < length) {
                                                                            int i581 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                            int i582 = (i581 ^ 81) + ((i581 & 81) << i577);
                                                                            artificialFrame = i582 % 128;
                                                                            if (i582 % 2 == 0) {
                                                                                str7.contains(strArr33[i580]);
                                                                                Object obj4 = null;
                                                                                obj4.hashCode();
                                                                                throw null;
                                                                            }
                                                                            if (str7.contains(strArr33[i580])) {
                                                                                int i5710 = (i38 & 1) + (i38 | 1);
                                                                                int i5711 = ((i37 | 10) << 1) - (i37 ^ 10);
                                                                                i36 = (~(i15 & i5711)) & (i5711 | i15);
                                                                                StringBuilder sb2 = new StringBuilder();
                                                                                sb2.append(str7);
                                                                                char c31 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                                int iIndexOf8 = TextUtils.indexOf(str25, str25, 0, 0);
                                                                                Object[] objArr136 = new Object[1];
                                                                                a(c31, (iIndexOf8 ^ 1412) + ((iIndexOf8 & 1412) << 1), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr136);
                                                                                sb2.append((String) objArr136[0]);
                                                                                sb2.append(str7);
                                                                                arrayList.add(sb2.toString());
                                                                                i38 = i5710;
                                                                                break;
                                                                            }
                                                                            i580++;
                                                                            i577 = 1;
                                                                        }
                                                                    }
                                                                    i37 = ((i37 & 1) << 1) + (i37 ^ 1);
                                                                    strArr = strArr;
                                                                }
                                                                if (i38 > 2) {
                                                                    objArr = new Object[]{arrayList, new int[]{i ^ (i << 5)}, null, new int[]{i15}, new int[]{i36}};
                                                                    int i583 = 1467176331 + (((~((-377836631) | i15)) | (~(529880311 | i26))) * (-406)) + ((~((-302268485) | i26)) * (-406)) + (((~((-227611828) | i15)) | (~(377836630 | i26))) * 406);
                                                                    int i584 = (i583 << 1) - i583;
                                                                    int i585 = i584 << 13;
                                                                    int i586 = ((~i584) & i585) | ((~i585) & i584);
                                                                    int i587 = i586 >>> 17;
                                                                    int i588 = ((~i586) & i587) | ((~i587) & i586);
                                                                    c3 = 0;
                                                                    c4 = 4;
                                                                    i39 = 1;
                                                                } else {
                                                                    objArr = new Object[]{null, new int[1], null, new int[]{i15}, new int[]{i15}};
                                                                    int iMyUid = Process.myUid();
                                                                    int i589 = ~((-657012320) | iMyUid);
                                                                    int i590 = ~iMyUid;
                                                                    int i591 = 1208188977 + ((i589 | (~((-51563862) | i590))) * (-1808)) + (((~((-606679563) | iMyUid)) | (~(i590 | (-1231105)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iMyUid | 51563861)) | 50332757 | (~(657012319 | i590))) * TypedValues.Custom.TYPE_BOOLEAN);
                                                                    int iJ_8 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                                                                    int i592 = artificialFrame + 21;
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i592 % 128;
                                                                    int i593 = i592 % 2;
                                                                    int i594 = ~iJ_8;
                                                                    int i595 = ~i591;
                                                                    int i596 = i594 | (~(i595 | (i595 ^ (-1))));
                                                                    int i597 = ~i591;
                                                                    int i598 = ((i591 * (-721)) - (~(((i596 & i597) | (i596 ^ i597)) * 1444))) - 1;
                                                                    int i599 = (~i591) | (~(i591 | iJ_8));
                                                                    int i600 = ~iJ_8;
                                                                    int i601 = (i598 - (~(((i600 & i599) | (i599 ^ i600)) * (-1444)))) - 1;
                                                                    int i602 = ~(~i591);
                                                                    int i603 = ~(((-1) ^ i591) | i591);
                                                                    int i604 = ((i602 & i603) | (i602 ^ i603)) * 722;
                                                                    int i605 = (i601 ^ i604) + ((i604 & i601) << 1);
                                                                    int i606 = (i605 << 13) ^ i605;
                                                                    int i607 = i606 >>> 17;
                                                                    int i608 = (i606 | i607) & (~(i606 & i607));
                                                                    int i609 = i608 << 5;
                                                                    int i610 = ((~i608) & i609) | ((~i609) & i608);
                                                                    i39 = 1;
                                                                    c3 = 0;
                                                                    ((int[]) objArr[1])[0] = i610;
                                                                    c4 = 4;
                                                                }
                                                                i40 = ((int[]) objArr[c4])[c3];
                                                                if (i40 != i15) {
                                                                    objArr2 = new Object[5];
                                                                    objArr2[i39] = new int[i39];
                                                                    int[] iArr2 = new int[i39];
                                                                    objArr2[3] = iArr2;
                                                                    int[] iArr3 = new int[i39];
                                                                    objArr2[4] = iArr3;
                                                                    List list = (List) objArr[c3];
                                                                    iArr2[c3] = i15;
                                                                    iArr3[c3] = i40;
                                                                    objArr2[c3] = list;
                                                                    objArr2[2] = null;
                                                                    int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                                                                    int i611 = (((~((~iFreeMemory) | 938213339)) * 130) - 480198497) + (((~(iFreeMemory | 938213339)) | 318838481) * 130);
                                                                    int i612 = (i7 - (~(-(-((i611 & 16) + (i611 | 16)))))) - 1;
                                                                    int i613 = i612 << 13;
                                                                    int i614 = (i612 | i613) & (~(i612 & i613));
                                                                    int i615 = i614 >>> 17;
                                                                    int i616 = (i614 | i615) & (~(i614 & i615));
                                                                    int i617 = i616 << 5;
                                                                    ((int[]) objArr2[1])[0] = ((~i616) & i617) | ((~i617) & i616);
                                                                } else {
                                                                    i41 = i39;
                                                                }
                                                            }
                                                            int i618 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                            Object[] objArr137 = new Object[1];
                                                            a((char) ((i618 & 1) + (i618 | i41)), 698 - (~(-(-((byte) KeyEvent.getModifierMetaStateMask())))), Process.getGidForName(str25) + 17, objArr137);
                                                            Object[] objArr138 = {(String) objArr137[0]};
                                                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                                            if (objAccessartificialFrame4 == null) {
                                                                int size5 = 23 - View.MeasureSpec.getSize(0);
                                                                char cMyTid2 = (char) (Process.myTid() >> 22);
                                                                int iKeyCodeFromString2 = 2441 - KeyEvent.keyCodeFromString(str25);
                                                                byte[] bArr18 = $$a;
                                                                byte b8 = bArr18[11];
                                                                Object[] objArr139 = new Object[1];
                                                                b(b8, (byte) (b8 | 10), bArr18[7], objArr139);
                                                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(size5, cMyTid2, iKeyCodeFromString2, 954751276, false, (String) objArr139[0], new Class[]{String.class});
                                                            }
                                                            objInvoke = ((Method) objAccessartificialFrame4).invoke(null, objArr138);
                                                            if (objInvoke == null) {
                                                                i42 = 0;
                                                            } else {
                                                                Object[] objArr140 = {objInvoke, 42};
                                                                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-287841710);
                                                                if (objAccessartificialFrame5 == null) {
                                                                    int trimmedLength = TextUtils.getTrimmedLength(str25) + 20;
                                                                    char keyRepeatDelay2 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                                    int i619 = 2246 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                                                    byte[] bArr19 = $$a;
                                                                    Object[] objArr141 = new Object[1];
                                                                    b((byte) 37, bArr19[16], bArr19[7], objArr141);
                                                                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(trimmedLength, keyRepeatDelay2, i619, 1907532890, false, (String) objArr141[0], new Class[]{String.class, Integer.TYPE});
                                                                }
                                                                long jLongValue11 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr140)).longValue();
                                                                long j62 = 1366014650;
                                                                long j63 = j62 ^ 
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x2a53: ARITH (r11v151 'j63' long) = (r5v343 'j62' long) ^ (r32v6 long) A[DECLARE_VAR] in method: com.google.android.material.navigation.NavigationView.2.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[], file: classes5.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                                                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                                                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r32v6 long
                                                                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                                    */
                                                                /*
                                                                    Method dump skipped, instruction units count: 14729
                                                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.AnonymousClass2.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
                                                            }
                                                        });
                                                        navigationMenuPresenter.setId(1);
                                                        navigationMenuPresenter.initForMenu(context2, navigationMenu);
                                                        if (resourceId != 0) {
                                                            navigationMenuPresenter.setSubheaderTextAppearance(resourceId);
                                                        }
                                                        navigationMenuPresenter.setSubheaderColor(colorStateList);
                                                        navigationMenuPresenter.setItemIconTintList(colorStateListCreateDefaultColorStateList);
                                                        navigationMenuPresenter.setOverScrollMode(getOverScrollMode());
                                                        if (resourceId2 != 0) {
                                                            navigationMenuPresenter.setItemTextAppearance(resourceId2);
                                                        }
                                                        navigationMenuPresenter.setItemTextAppearanceActiveBoldEnabled(z);
                                                        navigationMenuPresenter.setItemTextColor(colorStateList2);
                                                        navigationMenuPresenter.setItemBackground(drawable);
                                                        navigationMenuPresenter.setItemIconPadding(dimensionPixelSize2);
                                                        navigationMenu.addMenuPresenter(navigationMenuPresenter);
                                                        addView((View) navigationMenuPresenter.getMenuView(this));
                                                        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_menu)) {
                                                            i3 = 0;
                                                            inflateMenu(tintTypedArrayObtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.NavigationView_menu, 0));
                                                        } else {
                                                            i3 = 0;
                                                        }
                                                        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_headerLayout)) {
                                                            inflateHeaderView(tintTypedArrayObtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.NavigationView_headerLayout, i3));
                                                        }
                                                        tintTypedArrayObtainTintedStyledAttributes.recycle();
                                                        setupInsetScrimsListener();
                                                    }

                                                    @Override // android.view.View
                                                    public void setOverScrollMode(int i) {
                                                        super.setOverScrollMode(i);
                                                        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
                                                        if (navigationMenuPresenter != null) {
                                                            navigationMenuPresenter.setOverScrollMode(i);
                                                        }
                                                    }

                                                    public void setForceCompatClippingEnabled(boolean z) {
                                                        this.shapeableDelegate.setForceCompatClippingEnabled(this, z);
                                                    }

                                                    private void maybeUpdateCornerSizeForDrawerLayout(@Px int i, @Px int i2) {
                                                        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams)) {
                                                            if ((this.drawerLayoutCornerSize > 0 || this.drawerLayoutCornerSizeBackAnimationEnabled) && (getBackground() instanceof MaterialShapeDrawable)) {
                                                                boolean z = GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams) getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this)) == 3;
                                                                MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
                                                                ShapeAppearanceModel.Builder allCornerSizes = materialShapeDrawable.getShapeAppearanceModel().toBuilder().setAllCornerSizes(this.drawerLayoutCornerSize);
                                                                if (z) {
                                                                    allCornerSizes.setTopLeftCornerSize(0.0f);
                                                                    allCornerSizes.setBottomLeftCornerSize(0.0f);
                                                                } else {
                                                                    allCornerSizes.setTopRightCornerSize(0.0f);
                                                                    allCornerSizes.setBottomRightCornerSize(0.0f);
                                                                }
                                                                ShapeAppearanceModel shapeAppearanceModelBuild = allCornerSizes.build();
                                                                materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelBuild);
                                                                this.shapeableDelegate.onShapeAppearanceChanged(this, shapeAppearanceModelBuild);
                                                                this.shapeableDelegate.onMaskChanged(this, new RectF(0.0f, 0.0f, i, i2));
                                                                this.shapeableDelegate.setOffsetZeroCornerEdgeBoundsEnabled(this, true);
                                                            }
                                                        }
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: private */
                                                    public void maybeClearCornerSizeAnimationForDrawerLayout() {
                                                        if (!this.drawerLayoutCornerSizeBackAnimationEnabled || this.drawerLayoutCornerSize == 0) {
                                                            return;
                                                        }
                                                        this.drawerLayoutCornerSize = 0;
                                                        maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
                                                    }

                                                    private boolean hasShapeAppearance(@NonNull TintTypedArray tintTypedArray) {
                                                        return tintTypedArray.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay);
                                                    }

                                                    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
                                                    public void onAttachedToWindow() {
                                                        super.onAttachedToWindow();
                                                        MaterialShapeUtils.setParentAbsoluteElevation(this);
                                                        ViewParent parent = getParent();
                                                        if ((parent instanceof DrawerLayout) && this.backOrchestrator.shouldListenForBackCallbacks()) {
                                                            DrawerLayout drawerLayout = (DrawerLayout) parent;
                                                            drawerLayout.removeDrawerListener(this.backDrawerListener);
                                                            drawerLayout.addDrawerListener(this.backDrawerListener);
                                                            if (drawerLayout.isDrawerOpen(this)) {
                                                                this.backOrchestrator.startListeningForBackCallbacksWithPriorityOverlay();
                                                            }
                                                        }
                                                    }

                                                    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
                                                    public void onDetachedFromWindow() {
                                                        super.onDetachedFromWindow();
                                                        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
                                                        ViewParent parent = getParent();
                                                        if (parent instanceof DrawerLayout) {
                                                            ((DrawerLayout) parent).removeDrawerListener(this.backDrawerListener);
                                                        }
                                                    }

                                                    @Override // android.view.View
                                                    protected void onSizeChanged(int i, int i2, int i3, int i4) {
                                                        super.onSizeChanged(i, i2, i3, i4);
                                                        maybeUpdateCornerSizeForDrawerLayout(i, i2);
                                                    }

                                                    @Override // android.view.View
                                                    public void setElevation(float f) {
                                                        super.setElevation(f);
                                                        MaterialShapeUtils.setElevation(this, f);
                                                    }

                                                    private Drawable createDefaultItemBackground(@NonNull TintTypedArray tintTypedArray) {
                                                        return createDefaultItemDrawable(tintTypedArray, MaterialResources.getColorStateList(getContext(), tintTypedArray, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
                                                    }

                                                    private Drawable createDefaultItemDrawable(@NonNull TintTypedArray tintTypedArray, @Nullable ColorStateList colorStateList) {
                                                        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
                                                        materialShapeDrawable.setFillColor(colorStateList);
                                                        return new InsetDrawable((Drawable) materialShapeDrawable, tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
                                                    }

                                                    @Override // android.view.View
                                                    protected Parcelable onSaveInstanceState() {
                                                        SavedState savedState = new SavedState(super.onSaveInstanceState());
                                                        Bundle bundle = new Bundle();
                                                        savedState.menuState = bundle;
                                                        this.menu.savePresenterStates(bundle);
                                                        return savedState;
                                                    }

                                                    @Override // android.view.View
                                                    protected void onRestoreInstanceState(Parcelable parcelable) {
                                                        if (!(parcelable instanceof SavedState)) {
                                                            super.onRestoreInstanceState(parcelable);
                                                            return;
                                                        }
                                                        SavedState savedState = (SavedState) parcelable;
                                                        super.onRestoreInstanceState(savedState.getSuperState());
                                                        this.menu.restorePresenterStates(savedState.menuState);
                                                    }

                                                    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
                                                        this.listener = onNavigationItemSelectedListener;
                                                    }

                                                    @Override // android.widget.FrameLayout, android.view.View
                                                    protected void onMeasure(int i, int i2) {
                                                        int mode = View.MeasureSpec.getMode(i);
                                                        if (mode == Integer.MIN_VALUE) {
                                                            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.maxWidth), 1073741824);
                                                        } else if (mode == 0) {
                                                            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
                                                        }
                                                        super.onMeasure(i, i2);
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: private */
                                                    public /* synthetic */ void lambda$dispatchDraw$0(Canvas canvas) {
                                                        super.dispatchDraw(canvas);
                                                    }

                                                    @Override // android.view.ViewGroup, android.view.View
                                                    protected void dispatchDraw(@NonNull Canvas canvas) {
                                                        this.shapeableDelegate.maybeClip(canvas, new NavigationView$$ExternalSyntheticLambda0(this));
                                                    }

                                                    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
                                                    public void onInsetsChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
                                                        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
                                                    }

                                                    public void inflateMenu(int i) {
                                                        this.presenter.setUpdateSuspended(true);
                                                        getMenuInflater().inflate(i, this.menu);
                                                        this.presenter.setUpdateSuspended(false);
                                                        this.presenter.updateMenuView(false);
                                                    }

                                                    public Menu getMenu() {
                                                        return this.menu;
                                                    }

                                                    public View inflateHeaderView(@LayoutRes int i) {
                                                        return this.presenter.inflateHeaderView(i);
                                                    }

                                                    public void addHeaderView(@NonNull View view) {
                                                        this.presenter.addHeaderView(view);
                                                    }

                                                    public void removeHeaderView(@NonNull View view) {
                                                        this.presenter.removeHeaderView(view);
                                                    }

                                                    public int getHeaderCount() {
                                                        return this.presenter.getHeaderCount();
                                                    }

                                                    public View getHeaderView(int i) {
                                                        return this.presenter.getHeaderView(i);
                                                    }

                                                    public ColorStateList getItemIconTintList() {
                                                        return this.presenter.getItemTintList();
                                                    }

                                                    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
                                                        this.presenter.setItemIconTintList(colorStateList);
                                                    }

                                                    public ColorStateList getItemTextColor() {
                                                        return this.presenter.getItemTextColor();
                                                    }

                                                    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
                                                        this.presenter.setItemTextColor(colorStateList);
                                                    }

                                                    public Drawable getItemBackground() {
                                                        return this.presenter.getItemBackground();
                                                    }

                                                    public void setItemBackgroundResource(@DrawableRes int i) {
                                                        setItemBackground(ContextCompat.getDrawable(getContext(), i));
                                                    }

                                                    public void setItemBackground(@Nullable Drawable drawable) {
                                                        this.presenter.setItemBackground(drawable);
                                                    }

                                                    public int getItemHorizontalPadding() {
                                                        return this.presenter.getItemHorizontalPadding();
                                                    }

                                                    public void setItemHorizontalPadding(@Dimension int i) {
                                                        this.presenter.setItemHorizontalPadding(i);
                                                    }

                                                    public void setItemHorizontalPaddingResource(@DimenRes int i) {
                                                        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
                                                    }

                                                    public int getItemVerticalPadding() {
                                                        return this.presenter.getItemVerticalPadding();
                                                    }

                                                    public void setItemVerticalPadding(@Px int i) {
                                                        this.presenter.setItemVerticalPadding(i);
                                                    }

                                                    public void setItemVerticalPaddingResource(@DimenRes int i) {
                                                        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(i));
                                                    }

                                                    public int getItemIconPadding() {
                                                        return this.presenter.getItemIconPadding();
                                                    }

                                                    public void setItemIconPadding(@Dimension int i) {
                                                        this.presenter.setItemIconPadding(i);
                                                    }

                                                    public void setItemIconPaddingResource(int i) {
                                                        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
                                                    }

                                                    public void setCheckedItem(@IdRes int i) {
                                                        MenuItem menuItemFindItem = this.menu.findItem(i);
                                                        if (menuItemFindItem != null) {
                                                            this.presenter.setCheckedItem((MenuItemImpl) menuItemFindItem);
                                                        }
                                                    }

                                                    public void setCheckedItem(@NonNull MenuItem menuItem) {
                                                        MenuItem menuItemFindItem = this.menu.findItem(menuItem.getItemId());
                                                        if (menuItemFindItem != null) {
                                                            this.presenter.setCheckedItem((MenuItemImpl) menuItemFindItem);
                                                            return;
                                                        }
                                                        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
                                                    }

                                                    public MenuItem getCheckedItem() {
                                                        return this.presenter.getCheckedItem();
                                                    }

                                                    public void setItemTextAppearance(@StyleRes int i) {
                                                        this.presenter.setItemTextAppearance(i);
                                                    }

                                                    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
                                                        this.presenter.setItemTextAppearanceActiveBoldEnabled(z);
                                                    }

                                                    public void setItemIconSize(@Dimension int i) {
                                                        this.presenter.setItemIconSize(i);
                                                    }

                                                    public void setItemMaxLines(int i) {
                                                        this.presenter.setItemMaxLines(i);
                                                    }

                                                    public int getItemMaxLines() {
                                                        return this.presenter.getItemMaxLines();
                                                    }

                                                    public boolean isTopInsetScrimEnabled() {
                                                        return this.topInsetScrimEnabled;
                                                    }

                                                    public void setTopInsetScrimEnabled(boolean z) {
                                                        this.topInsetScrimEnabled = z;
                                                    }

                                                    public boolean isBottomInsetScrimEnabled() {
                                                        return this.bottomInsetScrimEnabled;
                                                    }

                                                    public void setBottomInsetScrimEnabled(boolean z) {
                                                        this.bottomInsetScrimEnabled = z;
                                                    }

                                                    public int getDividerInsetStart() {
                                                        return this.presenter.getDividerInsetStart();
                                                    }

                                                    public void setDividerInsetStart(@Px int i) {
                                                        this.presenter.setDividerInsetStart(i);
                                                    }

                                                    public int getDividerInsetEnd() {
                                                        return this.presenter.getDividerInsetEnd();
                                                    }

                                                    public void setDividerInsetEnd(@Px int i) {
                                                        this.presenter.setDividerInsetEnd(i);
                                                    }

                                                    public int getSubheaderInsetStart() {
                                                        return this.presenter.getSubheaderInsetStart();
                                                    }

                                                    public void setSubheaderInsetStart(@Px int i) {
                                                        this.presenter.setSubheaderInsetStart(i);
                                                    }

                                                    public int getSubheaderInsetEnd() {
                                                        return this.presenter.getSubheaderInsetEnd();
                                                    }

                                                    public void setSubheaderInsetEnd(@Px int i) {
                                                        this.presenter.setSubheaderInsetEnd(i);
                                                    }

                                                    @Override // com.google.android.material.motion.MaterialBackHandler
                                                    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
                                                        requireDrawerLayoutParent();
                                                        this.sideContainerBackHelper.startBackProgress(backEventCompat);
                                                    }

                                                    @Override // com.google.android.material.motion.MaterialBackHandler
                                                    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
                                                        this.sideContainerBackHelper.updateBackProgress(backEventCompat, ((DrawerLayout.LayoutParams) requireDrawerLayoutParent().second).gravity);
                                                        if (this.drawerLayoutCornerSizeBackAnimationEnabled) {
                                                            this.drawerLayoutCornerSize = AnimationUtils.lerp(0, this.drawerLayoutCornerSizeBackAnimationMax, this.sideContainerBackHelper.interpolateProgress(backEventCompat.getProgress()));
                                                            maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
                                                        }
                                                    }

                                                    @Override // com.google.android.material.motion.MaterialBackHandler
                                                    public void handleBackInvoked() {
                                                        Pair<DrawerLayout, DrawerLayout.LayoutParams> pairRequireDrawerLayoutParent = requireDrawerLayoutParent();
                                                        DrawerLayout drawerLayout = (DrawerLayout) pairRequireDrawerLayoutParent.first;
                                                        BackEventCompat backEventCompatOnHandleBackInvoked = this.sideContainerBackHelper.onHandleBackInvoked();
                                                        if (backEventCompatOnHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
                                                            drawerLayout.closeDrawer(this);
                                                            return;
                                                        }
                                                        this.sideContainerBackHelper.finishBackProgress(backEventCompatOnHandleBackInvoked, ((DrawerLayout.LayoutParams) pairRequireDrawerLayoutParent.second).gravity, DrawerLayoutUtils.getScrimCloseAnimatorListener(drawerLayout, this), DrawerLayoutUtils.getScrimCloseAnimatorUpdateListener(drawerLayout));
                                                    }

                                                    @Override // com.google.android.material.motion.MaterialBackHandler
                                                    public void cancelBackProgress() {
                                                        requireDrawerLayoutParent();
                                                        this.sideContainerBackHelper.cancelBackProgress();
                                                        maybeClearCornerSizeAnimationForDrawerLayout();
                                                    }

                                                    private Pair<DrawerLayout, DrawerLayout.LayoutParams> requireDrawerLayoutParent() {
                                                        ViewParent parent = getParent();
                                                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                                                        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
                                                            return new Pair<>((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
                                                        }
                                                        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
                                                    }

                                                    MaterialSideContainerBackHelper getBackHelper() {
                                                        return this.sideContainerBackHelper;
                                                    }

                                                    private MenuInflater getMenuInflater() {
                                                        if (this.menuInflater == null) {
                                                            this.menuInflater = new SupportMenuInflater(getContext());
                                                        }
                                                        return this.menuInflater;
                                                    }

                                                    private ColorStateList createDefaultColorStateList(int i) {
                                                        TypedValue typedValue = new TypedValue();
                                                        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
                                                            return null;
                                                        }
                                                        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
                                                        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
                                                            return null;
                                                        }
                                                        int i2 = typedValue.data;
                                                        int defaultColor = colorStateList.getDefaultColor();
                                                        int[] iArr = DISABLED_STATE_SET;
                                                        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
                                                    }

                                                    private void setupInsetScrimsListener() {
                                                        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.3
                                                            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                                                            public void onGlobalLayout() {
                                                                NavigationView navigationView = NavigationView.this;
                                                                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                                                                boolean z = true;
                                                                boolean z2 = NavigationView.this.tmpLocation[1] == 0;
                                                                NavigationView.this.presenter.setBehindStatusBar(z2);
                                                                NavigationView navigationView2 = NavigationView.this;
                                                                navigationView2.setDrawTopInsetForeground(z2 && navigationView2.isTopInsetScrimEnabled());
                                                                NavigationView.this.setDrawLeftInsetForeground(NavigationView.this.tmpLocation[0] == 0 || NavigationView.this.tmpLocation[0] + NavigationView.this.getWidth() == 0);
                                                                Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
                                                                if (activity != null) {
                                                                    Rect currentWindowBounds = WindowUtils.getCurrentWindowBounds(activity);
                                                                    boolean z3 = currentWindowBounds.height() - NavigationView.this.getHeight() == NavigationView.this.tmpLocation[1];
                                                                    boolean z4 = Color.alpha(activity.getWindow().getNavigationBarColor()) != 0;
                                                                    NavigationView navigationView3 = NavigationView.this;
                                                                    navigationView3.setDrawBottomInsetForeground(z3 && z4 && navigationView3.isBottomInsetScrimEnabled());
                                                                    if (currentWindowBounds.width() != NavigationView.this.tmpLocation[0] && currentWindowBounds.width() - NavigationView.this.getWidth() != NavigationView.this.tmpLocation[0]) {
                                                                        z = false;
                                                                    }
                                                                    NavigationView.this.setDrawRightInsetForeground(z);
                                                                }
                                                            }
                                                        };
                                                        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
                                                    }

                                                    public static class SavedState extends AbsSavedState {
                                                        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // android.os.Parcelable.ClassLoaderCreator
                                                            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                                                                return new SavedState(parcel, classLoader);
                                                            }

                                                            @Override // android.os.Parcelable.Creator
                                                            public SavedState createFromParcel(@NonNull Parcel parcel) {
                                                                return new SavedState(parcel, null);
                                                            }

                                                            @Override // android.os.Parcelable.Creator
                                                            public SavedState[] newArray(int i) {
                                                                return new SavedState[i];
                                                            }
                                                        };
                                                        public Bundle menuState;

                                                        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
                                                            super(parcel, classLoader);
                                                            this.menuState = parcel.readBundle(classLoader);
                                                        }

                                                        public SavedState(Parcelable parcelable) {
                                                            super(parcelable);
                                                        }

                                                        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
                                                        public void writeToParcel(@NonNull Parcel parcel, int i) {
                                                            super.writeToParcel(parcel, i);
                                                            parcel.writeBundle(this.menuState);
                                                        }
                                                    }
                                                }
