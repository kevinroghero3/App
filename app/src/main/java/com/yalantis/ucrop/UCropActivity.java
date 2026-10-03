package com.yalantis.ucrop;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.dynamite.zza;
import com.google.common.base.Ascii;
import com.reactnativekeyboardcontroller.listeners.FocusedInputObserver;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity extends AppCompatActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    private static char CoroutineDebuggingKt = 0;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private static int accessartificialFrame;
    private static int artificialFrame;
    private static long coroutineBoundary;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private int mActiveControlsWidgetColor;
    private View mBlockingView;
    private Transition mControlsTransition;
    private GestureCropImageView mGestureCropImageView;
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    private boolean mShowBottomControls;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;
    private static final byte[] $$c = {123, -106, -53, 126};
    private static final int $$f = 22;
    private static int $10 = 0;
    private static int $11 = 1;
    private boolean mShowLoader = true;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private int[] mAllowedGestures = {1, 2, 3};
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() { // from class: com.yalantis.ucrop.UCropActivity.1
        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onRotate(float f) {
            UCropActivity.this.setAngleText(f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onScale(float f) {
            UCropActivity.this.setScaleText(f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.mBlockingView.setClickable(false);
            UCropActivity.this.mShowLoader = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(@NonNull Exception exc) {
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.finish();
        }
    };
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.setWidgetState(view.getId());
        }
    };

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    private static String $$g(short s, short s2, byte b) {
        int i = 101 - b;
        int i2 = s + 4;
        byte[] bArr = $$c;
        int i3 = s2 * 3;
        byte[] bArr2 = new byte[1 - i3];
        int i4 = 0 - i3;
        int i5 = -1;
        if (bArr == null) {
            i5 = -1;
            i = (-i2) + i;
            i2 = i2;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i;
            int i7 = i2 + 1;
            if (i6 == i4) {
                return new String(bArr2, 0);
            }
            i5 = i6;
            i = (-bArr[i7]) + i;
            i2 = i7;
        }
    }

    private static void b(int i, byte b, short s, Object[] objArr) {
        int i2 = b + 65;
        byte[] bArr = $$a;
        int i3 = i + 4;
        byte[] bArr2 = new byte[21 - s];
        int i4 = 20 - s;
        int i5 = -1;
        if (bArr == null) {
            i2 = (-i2) + i4;
            i3++;
            i5 = -1;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i2;
            if (i6 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = (-bArr[i3]) + i2;
            i3++;
            i5 = i6;
        }
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
    private static void c(short r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r0 = 82 - r7
            int r5 = 111 - r5
            int r6 = r6 + 4
            byte[] r1 = com.yalantis.ucrop.UCropActivity.$$d
            byte[] r0 = new byte[r0]
            int r7 = 81 - r7
            r2 = 0
            if (r1 != 0) goto L12
            r4 = r6
            r3 = r2
            goto L24
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L20
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L20:
            int r3 = r3 + 1
            r4 = r1[r6]
        L24:
            int r6 = r6 + 1
            int r4 = -r4
            int r5 = r5 + r4
            int r5 = r5 + (-4)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.UCropActivity.c(short, int, byte, java.lang.Object[]):void");
    }

    static {
        byte[] bArr = new byte[699];
        System.arraycopy("*úú>ø÷\u0004ÿ÷<¶\u000bé\u0000B×Ûþ\u0005÷\u0003ð$Ó\u0011ü\bÛþ\u0005÷\u0003\u0015Õ\u0004\u0007ùï+Ðýô\rïû\u0006öý÷$Óúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Âûñ\u000fú÷û\u0004íü>Åé\u0011úñø\u0007öý÷AÝÐ2Ö\u0002úïÿ&É\u0011úñø\u0007öýü¿ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQï\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bïðþ;Ä\u0001úúÿïü\u00009Á÷ö\u000bï\u0000\tñ:Ã\u0002é\u000bö\u0002üñ\u0007ï@ãâé\u000b\u0016âüñ\u0007ïÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;Ãôü\u0004÷\u00033Çðþüúý<Åë\róö\u000eéþA×Ú\u000fë\fí\u0005\u0003ùïðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012½\bé\u000bï\u0005\u0004ñ:Á÷ö\u000bï\u0000\tñ:åÉ\u0004\u000bï\u0006\u001dÐÿü\u0007íù\n Ï\u0001ø\bé\u0007öý\"ßõø\u0007ïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÇðþüúý<Éí\u00037Á÷ö\u000bï\u0000\tñ:°\u0015úéðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012½\bé\u000bï\u0005\u0004ñ:Çðÿùù@µý\u0007ùÿñ\u0007\u0000îAæÇ\u0007\tð\u0000\u0002\u001cÐÿùùJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 699);
        $$d = bArr;
        $$e = 233;
        $$a = new byte[]{114, 98, 44, 76, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14};
        $$b = 84;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        setupSystemBars(intent);
        setContentView(R.layout.ucrop_activity_photobox);
        setupViews(intent);
        setImageData(intent);
        setInitialState();
        addBlockingView();
    }

    private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        int i3 = $10 + 7;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (iCustomTabsCallbackDefault.a < length3) {
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) (-1);
                    byte b2 = (byte) (b + 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 33, (char) (ViewConfiguration.getEdgeSlop() >> 16), 1483 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 1614432829, false, $$g(b, b2, (byte) (b2 + 2)), new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) (-1);
                    byte b4 = (byte) (b3 + 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 32, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 49167), View.MeasureSpec.makeMeasureSpec(0, 0) + 899, 214239564, false, $$g(b3, b4, b4), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) (-1);
                    byte b6 = (byte) (b5 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 23, (char) (Color.rgb(0, 0, 0) + 16777216), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 2442, -1003383455, false, $$g(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) (-1);
                    byte b8 = (byte) (b7 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 29755), ImageFormat.getBitsPerPixel(0) + 1749, 1479752515, false, $$g(b7, b8, (byte) (b8 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
                int i5 = $10 + 97;
                $11 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr6);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e) {
                Log.i(TAG, String.format("%s - %s", e.getMessage(), getString(R.string.ucrop_mutate_exception_hint)));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable == null) {
            return true;
        }
        drawable.mutate();
        drawable.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
        menuItemFindItem2.setIcon(drawable);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            cropAndSaveImage();
            return true;
        }
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    private void setImageData(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri != null && uri2 != null) {
            try {
                this.mGestureCropImageView.setImageUri(uri, uri2);
                return;
            } catch (Exception e) {
                setResultError(e);
                finish();
                return;
            }
        }
        setResultError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
        finish();
    }

    private void processOptions(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = compressFormatValueOf;
        this.mCompressQuality = intent.getIntExtra(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.mAllowedGestures = intArrayExtra;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.mOverlayView.setDimmedColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridCornerColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_CORNER_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, -1.0f);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, -1.0f);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (floatExtra >= 0.0f && floatExtra2 >= 0.0f) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            float f = floatExtra / floatExtra2;
            this.mGestureCropImageView.setTargetAspectRatio(Float.isNaN(f) ? 0.0f : f);
        } else if (parcelableArrayListExtra != null && intExtra < parcelableArrayListExtra.size()) {
            float aspectRatioX = ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY();
            this.mGestureCropImageView.setTargetAspectRatio(Float.isNaN(aspectRatioX) ? 0.0f : aspectRatioX);
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        }
        int intExtra2 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.mGestureCropImageView.setMaxResultImageSizeX(intExtra2);
        this.mGestureCropImageView.setMaxResultImageSizeY(intExtra3);
    }

    private void setupSystemBars(@NonNull Intent intent) {
        SystemBarStyle systemBarStyleDark;
        SystemBarStyle systemBarStyleDark2;
        boolean booleanExtra = intent.getBooleanExtra(UCrop.Options.EXTRA_STATUS_BAR_LIGHT, true);
        boolean booleanExtra2 = intent.getBooleanExtra(UCrop.Options.EXTRA_NAVIGATION_BAR_LIGHT, false);
        if (booleanExtra) {
            systemBarStyleDark = SystemBarStyle.light(0, 0);
        } else {
            systemBarStyleDark = SystemBarStyle.dark(0);
        }
        if (booleanExtra2) {
            systemBarStyleDark2 = SystemBarStyle.light(0, 0);
        } else {
            systemBarStyleDark2 = SystemBarStyle.dark(0);
        }
        EdgeToEdge.enable(this, systemBarStyleDark, systemBarStyleDark2);
    }

    private void setupViews(@NonNull Intent intent) {
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.mActiveControlsWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitle = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = stringExtra;
        this.mLogoColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.mControlsTransition = autoTransition;
            autoTransition.setDuration(CONTROLS_ANIMATION_DURATION);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            View viewFindViewById = findViewById(R.id.controls_wrapper);
            final int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ucrop_height_wrapper_states);
            ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById.findViewById(R.id.wrapper_states), new OnApplyWindowInsetsListener() { // from class: com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return UCropActivity.lambda$setupViews$0(dimensionPixelSize, view, windowInsetsCompat);
                }
            });
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat lambda$setupViews$0(int i, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPaddingRelative(insets.left, 0, insets.right, insets.bottom);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = i + insets.bottom;
        if (layoutParams.height != i2) {
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
        return windowInsetsCompat;
    }

    private void setupAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ViewCompat.setOnApplyWindowInsetsListener(toolbar, new OnApplyWindowInsetsListener() { // from class: com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return UCropActivity.lambda$setupAppBar$1(view, windowInsetsCompat);
            }
        });
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        Drawable drawableMutate = ContextCompat.getDrawable(this, this.mToolbarCancelDrawable).mutate();
        drawableMutate.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(drawableMutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat lambda$setupAppBar$1(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPaddingRelative(insets.left, insets.top, insets.right, 0);
        return windowInsetsCompat;
    }

    private void initiateRootViews() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
        if (this.mShowBottomControls) {
            return;
        }
        ((RelativeLayout.LayoutParams) findViewById(R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
        findViewById(R.id.ucrop_frame).requestLayout();
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    private void setupAspectRatioWidget(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList<AspectRatio> parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        for (AspectRatio aspectRatio : parcelableArrayListExtra) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(intExtra).setSelected(true);
        Iterator<ViewGroup> it2 = this.mCropAspectRatioViews.iterator();
        while (it2.hasNext()) {
            it2.next().setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (view.isSelected()) {
                        return;
                    }
                    for (ViewGroup viewGroup : UCropActivity.this.mCropAspectRatioViews) {
                        viewGroup.setSelected(viewGroup == view);
                    }
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView) findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropActivity.3
            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f, float f2) {
                UCropActivity.this.mGestureCropImageView.postRotate(f / 42.0f);
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UCropActivity.this.resetRotation();
            }
        });
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UCropActivity.this.rotateByAngle(90);
            }
        });
        setAngleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView) findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropActivity.6
            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f, float f2) {
                if (f > 0.0f) {
                    UCropActivity.this.mGestureCropImageView.zoomInImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropActivity.this.mGestureCropImageView.zoomOutImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        setScaleTextColor(this.mActiveControlsWidgetColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngleText(float f) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f)));
        }
    }

    private void setAngleTextColor(int i) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleText(float f) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
        }
    }

    private void setScaleTextColor(int i) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateByAngle(int i) {
        this.mGestureCropImageView.postRotate(i);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setInitialState() {
        if (this.mShowBottomControls) {
            if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
                setWidgetState(R.id.state_aspect_ratio);
                return;
            } else {
                setWidgetState(R.id.state_scale);
                return;
            }
        }
        setAllowedGestures(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetState(@IdRes int i) {
        if (this.mShowBottomControls) {
            this.mWrapperStateAspectRatio.setSelected(i == R.id.state_aspect_ratio);
            this.mWrapperStateRotate.setSelected(i == R.id.state_rotate);
            this.mWrapperStateScale.setSelected(i == R.id.state_scale);
            this.mLayoutAspectRatio.setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.mLayoutRotate.setVisibility(i == R.id.state_rotate ? 0 : 8);
            this.mLayoutScale.setVisibility(i == R.id.state_scale ? 0 : 8);
            changeSelectedTab(i);
            if (i == R.id.state_scale) {
                setAllowedGestures(0);
            } else if (i == R.id.state_rotate) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void changeSelectedTab(int i) {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        this.mWrapperStateScale.findViewById(R.id.text_view_scale).setVisibility(i == R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop).setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
        this.mWrapperStateRotate.findViewById(R.id.text_view_rotate).setVisibility(i != R.id.state_rotate ? 8 : 0);
    }

    private void setAllowedGestures(int i) {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        int i2 = this.mAllowedGestures[i];
        boolean z = true;
        gestureCropImageView.setScaleEnabled(i2 == 3 || i2 == 1);
        GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
        int i3 = this.mAllowedGestures[i];
        if (i3 != 3 && i3 != 2) {
            z = false;
        }
        gestureCropImageView2.setRotateEnabled(z);
    }

    private void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams(layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    protected void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() { // from class: com.yalantis.ucrop.UCropActivity.8
            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public void onBitmapCropped(@NonNull Uri uri, int i, int i2, int i3, int i4) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.mGestureCropImageView.getTargetAspectRatio(), i, i2, i3, i4);
                UCropActivity.this.finish();
            }

            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public void onCropFailure(@NonNull Throwable th) {
                UCropActivity.this.setResultError(th);
                UCropActivity.this.finish();
            }
        });
    }

    protected void setResultUri(Uri uri, float f, int i, int i2, int i3, int i4) {
        setResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i3).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i4).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i2));
    }

    protected void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    /* JADX WARN: Code duplicated, block: B:150:0x120b  */
    /* JADX WARN: Code duplicated, block: B:217:0x1a39  */
    /* JADX WARN: Code duplicated, block: B:219:0x1a3f  */
    /* JADX WARN: Code duplicated, block: B:221:0x1b29  */
    /* JADX WARN: Code duplicated, block: B:223:0x1b2d  */
    /* JADX WARN: Code duplicated, block: B:226:0x1b41  */
    /* JADX WARN: Code duplicated, block: B:227:0x1b43  */
    /* JADX WARN: Code duplicated, block: B:231:0x1bd3  */
    /* JADX WARN: Code duplicated, block: B:233:0x1bdc  */
    /* JADX WARN: Code duplicated, block: B:238:0x1c4c  */
    /* JADX WARN: Code duplicated, block: B:286:0x21e7  */
    /* JADX WARN: Code duplicated, block: B:287:0x2277  */
    /* JADX WARN: Code duplicated, block: B:290:0x228a A[Catch: all -> 0x284d, TryCatch #7 {all -> 0x284d, blocks: (B:313:0x2521, B:315:0x2527, B:316:0x2557, B:318:0x2582, B:319:0x2610, B:288:0x227d, B:290:0x228a, B:291:0x22be, B:293:0x22c8, B:295:0x22d5, B:296:0x2305, B:103:0x0d1a, B:105:0x0d2f, B:106:0x0d5f, B:65:0x08b2, B:67:0x08d5, B:68:0x092d), top: B:375:0x08b2 }] */
    /* JADX WARN: Code duplicated, block: B:295:0x22d5 A[Catch: all -> 0x284d, TryCatch #7 {all -> 0x284d, blocks: (B:313:0x2521, B:315:0x2527, B:316:0x2557, B:318:0x2582, B:319:0x2610, B:288:0x227d, B:290:0x228a, B:291:0x22be, B:293:0x22c8, B:295:0x22d5, B:296:0x2305, B:103:0x0d1a, B:105:0x0d2f, B:106:0x0d5f, B:65:0x08b2, B:67:0x08d5, B:68:0x092d), top: B:375:0x08b2 }] */
    /* JADX WARN: Code duplicated, block: B:302:0x23fe  */
    /* JADX WARN: Code duplicated, block: B:312:0x251d  */
    /* JADX WARN: Code duplicated, block: B:315:0x2527 A[Catch: all -> 0x284d, TryCatch #7 {all -> 0x284d, blocks: (B:313:0x2521, B:315:0x2527, B:316:0x2557, B:318:0x2582, B:319:0x2610, B:288:0x227d, B:290:0x228a, B:291:0x22be, B:293:0x22c8, B:295:0x22d5, B:296:0x2305, B:103:0x0d1a, B:105:0x0d2f, B:106:0x0d5f, B:65:0x08b2, B:67:0x08d5, B:68:0x092d), top: B:375:0x08b2 }] */
    /* JADX WARN: Code duplicated, block: B:318:0x2582 A[Catch: all -> 0x284d, TryCatch #7 {all -> 0x284d, blocks: (B:313:0x2521, B:315:0x2527, B:316:0x2557, B:318:0x2582, B:319:0x2610, B:288:0x227d, B:290:0x228a, B:291:0x22be, B:293:0x22c8, B:295:0x22d5, B:296:0x2305, B:103:0x0d1a, B:105:0x0d2f, B:106:0x0d5f, B:65:0x08b2, B:67:0x08d5, B:68:0x092d), top: B:375:0x08b2 }] */
    /* JADX WARN: Code duplicated, block: B:322:0x2622  */
    /* JADX WARN: Code duplicated, block: B:327:0x268c  */
    /* JADX WARN: Code duplicated, block: B:331:0x26e9  */
    /* JADX WARN: Code duplicated, block: B:332:0x2746  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        char c;
        int i;
        Object[] objArr2;
        int i2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr3;
        int i3;
        Object[] objArr4;
        Context baseContext;
        Object[] objArr5;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i4;
        Object[] objArr6;
        int i5;
        int i6;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        long j;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        Object objAccessartificialFrame8;
        Object objAccessartificialFrame9;
        Object[] objArr7;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        int i9 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{46937, 54443, 57309, 13082}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{12004, 11934, 50943, 37809, 7768, 44934, 65042, 35559, 40594, 51930, 11824, 27667, 35350, 31059, 40565, 29292, 40838, 26751, 53089, 16484, 35670, 7879}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 2015450413, new char[]{37020, 8533, 14456, 55804}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 64532), new char[]{38150, 11787, 7718, 49182, 3814, 46151, 41338, 57655, 2294, 31186, 4384, 64702, 61827, 29634, 20675}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(new char[]{21689, 60471, 28181, 21659}, ViewConfiguration.getEdgeSlop() >> 16, new char[]{60466, 30812, 56988, 25130}, (char) (10974 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), new char[]{41887, 49144, 821, 15981, 44242, 11355, 1943, 65203, 45415, 46220, 7507, 27365, 11111, 58769, 49010, 40981}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{22884, 15616, 19184, 44392}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 26663), new char[]{49014, 57307, 53194, 55674, 5992, 11286, 13460, 60472, 47275, 21669, 11513, 10324, 37078, 60637, 14515, 6534}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame10 == null) {
            int iArgb = Color.argb(0, 0, 0, 0) + 21;
            char defaultSize = (char) View.getDefaultSize(0, 0);
            int pressedStateDuration = 465 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte[] bArr = $$a;
            byte b = (byte) (bArr[5] - 1);
            Object[] objArr12 = new Object[1];
            b(b, (byte) (b | 47), bArr[18], objArr12);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iArgb, defaultSize, pressedStateDuration, -785931255, false, (String) objArr12[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j2 == -1 || j2 + 1984 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr13 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 118, new char[]{12318, 47999, 58962, 8743}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 10179), new char[]{40772, 6925, 54834, 43522, 22160, 49287, 14099, 33859, 1180, 57459, 48174, 63498, 8927, 52192, 11632, 20341, 55448, 25609, 9180, 52505, 20259, 38142, 35844, 36810, 63306, 62829}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 105, new char[]{62945, 45546, 3591, 8908}, (char) (52238 - (ViewConfiguration.getLongPressTimeout() >> 16)), new char[]{61065, 65201, 45637, 34154, 56168, 40116, 6302, 64840, 32148, 20842, 49335, 62023, 59755, 14158, 6320, 18662, 17729, 16557}, objArr14);
                baseContext2 = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr15 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 115, new char[]{45730, 8878, 23590, 46454}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49), new char[]{46912, 61796, 54093, 55662, 19509, 58760, 13868, 44637, 43052, 16074, 3078, 4988, 47964, 2821, 3661, 6281, 65118, 48613, 14733, 24988, 22807, 5544, 25932, 16430, 54714, 45380, 51043, 18876, 61504, 29270, 6144, 41347, 24356, 8473, 62822, 393, 27289, 58307, 61028, 7162, 38402, 44831, 55660, 27588, 44091, 11877, 5600, 31262, 3963, 35761, 61432, 15558, 12489, 43622, 4358, 11747, 15847, 5340, 55964, 60161, 36830, 59066, 53832, 35433}, objArr15);
            String str5 = (String) objArr15[0];
            Object[] objArr16 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{19736, 55960, 65086, 63444}, (char) Drawable.resolveOpacity(0, 0), new char[]{53614, 25506, 43410, 56584, 34621, 7374, 8315, 21185, 33279, 39013, 47306, 10093, 45114, 61009, 21081, 59465, 52418, 31528, 2255, 50667, 62388, 41190, 55047, 39510, 56266, 12438, 56799, 55370, 57102, 61178, 11862, 61358, 27868, 18425, 63936, 3367, 20002, 19747, 58941, 31062, 62006, 41510, 31684, 18551, 45258, 31308, 46313, 41349, 55257, 55639, 57388, 56899, 55514, 4253, 11521, 40069, 50767, 36864, 10108, 45182, 1917, 3956, 18483, 43765}, objArr16);
            String[] strArr = {str5, (String) objArr16[0]};
            int i10 = artificialFrame + 67;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
            int i11 = i10 % 2;
            try {
                Object[] objArr17 = {baseContext2, strArr, Integer.valueOf(iIntValue), 1, 340873877};
                byte[] bArr2 = $$d;
                Object[] objArr18 = new Object[1];
                c(bArr2[6], bArr2[13], bArr2[66], objArr18);
                Class<?> cls2 = Class.forName((String) objArr18[0]);
                Object[] objArr19 = new Object[1];
                c(bArr2[56], bArr2[200], bArr2[131], objArr19);
                objArr = (Object[]) cls2.getMethod((String) objArr19[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr17);
                int i12 = ((int[]) objArr[0])[0];
                int i13 = ((int[]) objArr[3])[0];
                if (baseContext2 != null) {
                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame11 == null) {
                        int iBlue = Color.blue(0) + 21;
                        char gidForName = (char) (Process.getGidForName("") + 1);
                        int size = 465 - View.MeasureSpec.getSize(0);
                        byte[] bArr3 = $$a;
                        byte b2 = bArr3[28];
                        Object[] objArr20 = new Object[1];
                        b(b2, (byte) (b2 | 39), bArr3[18], objArr20);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iBlue, gidForName, size, -612765161, false, (String) objArr20[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, objArr);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame12 == null) {
                            int fadingEdgeLength = 21 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                            char cRed = (char) Color.red(0);
                            int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 465;
                            byte[] bArr4 = $$a;
                            byte b3 = (byte) (bArr4[5] - 1);
                            Object[] objArr21 = new Object[1];
                            b(b3, (byte) (b3 | 47), bArr4[18], objArr21);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, cRed, edgeSlop, -785931255, false, (String) objArr21[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                }
                c = 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame13 == null) {
                int i14 = 22 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
                int iMakeMeasureSpec = 465 - View.MeasureSpec.makeMeasureSpec(0, 0);
                byte[] bArr5 = $$a;
                byte b4 = bArr5[28];
                Object[] objArr22 = new Object[1];
                b(b4, (byte) (b4 | 39), bArr5[18], objArr22);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i14, offsetAfter, iMakeMeasureSpec, -612765161, false, (String) objArr22[0], null);
            }
            Object[] objArr23 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i15 = ((int[]) objArr23[3])[0];
            int i16 = ((int[]) objArr23[0])[0];
            String[] strArr2 = (String[]) objArr23[1];
            int i17 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i18 = 663847509 + (((~(892056305 | i17)) | 177225998) * 104) + ((~((~i17) | (-16876273))) * (-104)) + ((i17 | 1052406031) * 104) + 340873877;
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr[2])[0] = i20 ^ (i20 << 5);
            c = 0;
        }
        int i21 = ((int[]) objArr[c])[c];
        int i22 = ((int[]) objArr[3])[c];
        if (i22 == i21) {
            Object[] objArr24 = new Object[4];
            int[] iArr = new int[1];
            objArr24[c] = iArr;
            objArr24[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr24[3] = iArr2;
            int i23 = ((int[]) objArr[2])[c];
            int i24 = ((int[]) objArr[3])[c];
            int i25 = ((int[]) objArr[c])[c];
            String[] strArr3 = (String[]) objArr[1];
            iArr2[c] = i24;
            iArr[c] = i25;
            int i26 = (int) Runtime.getRuntime().totalMemory();
            int i27 = ~i26;
            int i28 = i23 + 628177714 + (((~((-690139058) | i27)) | (-529789332)) * (-602)) + (((~(i26 | (-690139058))) | 538971680 | (~((-378621955) | i27))) * (-301)) + ((~(i27 | (-529789332))) * 301);
            int i29 = (i28 << 13) ^ i28;
            int i30 = i29 ^ (i29 >>> 17);
            ((int[]) objArr24[2])[0] = i30 ^ (i30 << 5);
            objArr24[1] = strArr3;
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr4 = (String[]) objArr[1];
            if (strArr4 != null) {
                for (String str6 : strArr4) {
                    arrayList.add(str6);
                }
            }
            try {
                Object[] objArr25 = {Long.valueOf(((long) (i21 ^ i22)) ^ (((long) 61436394) << 32)), Long.valueOf(61436330)};
                byte[] bArr6 = $$d;
                Object[] objArr26 = new Object[1];
                c(bArr6[364], (short) (-bArr6[438]), (byte) (-bArr6[201]), objArr26);
                Class<?> cls3 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                c((byte) (-bArr6[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr27);
                cls3.getMethod((String) objArr27[0], Long.TYPE, Long.TYPE).invoke(null, objArr25);
                Object[] objArr28 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i31 = ((int[]) objArr[2])[0];
                int i32 = ((int[]) objArr[3])[0];
                int i33 = ((int[]) objArr[0])[0];
                String[] strArr5 = (String[]) objArr[1];
                int i34 = (int) Runtime.getRuntime().totalMemory();
                int i35 = ~i34;
                int i36 = i31 + 763743565 + (((~(i34 | (-383239930))) | (~((-543589656) | i35))) * 333) + (((~(i34 | (-543589656))) | (~(i35 | (-383239930)))) * 333);
                int i37 = (i36 << 13) ^ i36;
                int i38 = i37 ^ (i37 >>> 17);
                i = 0;
                ((int[]) objArr28[2])[0] = i38 ^ (i38 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame14 == null) {
            int iResolveOpacity = 25 - Drawable.resolveOpacity(i, i);
            char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
            int i39 = (TypedValue.complexToFloat(i) > 0.0f ? 1 : (TypedValue.complexToFloat(i) == 0.0f ? 0 : -1)) + 816;
            byte[] bArr7 = $$a;
            byte b5 = (byte) (bArr7[5] - 1);
            Object[] objArr29 = new Object[1];
            b(b5, (byte) (b5 | 47), bArr7[18], objArr29);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, keyRepeatTimeout, i39, 721586079, false, (String) objArr29[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j3 == -1 || j3 + 1971 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr30 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1227472440};
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame15 == null) {
                    int i40 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char threadPriority = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 30068);
                    int iKeyCodeFromString = 816 - KeyEvent.keyCodeFromString("");
                    byte b6 = (byte) ($$b & 56);
                    byte[] bArr8 = $$a;
                    Object[] objArr31 = new Object[1];
                    b(b6, bArr8[65], bArr8[9], objArr31);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i40, threadPriority, iKeyCodeFromString, -797394565, false, (String) objArr31[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr2 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr30);
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame16 == null) {
                    int i41 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 24;
                    char pressedStateDuration2 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
                    byte[] bArr9 = $$a;
                    byte b7 = bArr9[28];
                    Object[] objArr32 = new Object[1];
                    b(b7, (byte) (b7 | 39), bArr9[18], objArr32);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i41, pressedStateDuration2, scrollBarSize, 891606461, false, (String) objArr32[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame17 == null) {
                        int iLastIndexOf = 24 - TextUtils.lastIndexOf("", '0', 0, 0);
                        char cMakeMeasureSpec = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
                        int iRgb = Color.rgb(0, 0, 0) + 16778032;
                        byte[] bArr10 = $$a;
                        byte b8 = (byte) (bArr10[5] - 1);
                        Object[] objArr33 = new Object[1];
                        b(b8, (byte) (b8 | 47), bArr10[18], objArr33);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cMakeMeasureSpec, iRgb, 721586079, false, (String) objArr33[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, lValueOf2);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } else {
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame18 == null) {
                int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 25;
                char size2 = (char) (View.MeasureSpec.getSize(0) + 30068);
                int defaultSize2 = View.getDefaultSize(0, 0) + 816;
                byte[] bArr11 = $$a;
                byte b9 = bArr11[28];
                Object[] objArr34 = new Object[1];
                b(b9, (byte) (b9 | 39), bArr11[18], objArr34);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, size2, defaultSize2, 891606461, false, (String) objArr34[0], null);
            }
            Object[] objArr35 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i42 = ((int[]) objArr35[0])[0];
            int i43 = ((int[]) objArr35[1])[0];
            String[] strArr6 = (String[]) objArr35[2];
            int i44 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi | (-319086469));
            int i45 = (((-1605497749) + (((-517258835) | i44) * (-220))) + ((i44 | 16793988) * 220)) - 951306394;
            int i46 = (i45 << 13) ^ i45;
            int i47 = i46 ^ (i46 >>> 17);
            ((int[]) objArr2[3])[0] = i47 ^ (i47 << 5);
        }
        int i48 = ((int[]) objArr2[1])[0];
        int i49 = ((int[]) objArr2[0])[0];
        if (i49 == i48) {
            Object[] objArr36 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i50 = ((int[]) objArr2[3])[0];
            int i51 = ((int[]) objArr2[0])[0];
            int i52 = ((int[]) objArr2[1])[0];
            String[] strArr7 = (String[]) objArr2[2];
            int i53 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i54 = i50 + 1067379021 + (((~(i53 | (-865568218))) | 1063740583) * 191) + (((~((~i53) | (-865568218))) | 856097921) * 191);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            i2 = 0;
            ((int[]) objArr36[3])[0] = i56 ^ (i56 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr8 = (String[]) objArr2[2];
            if (strArr8 != null) {
                for (String str7 : strArr8) {
                    int i57 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    artificialFrame = i57 % 128;
                    int i58 = i57 % 2;
                    arrayList2.add(str7);
                }
            }
            Object[] objArr37 = {Long.valueOf(((long) (i48 ^ i49)) ^ (((long) (-97859429)) << 32)), Long.valueOf(-97859430)};
            byte[] bArr12 = $$d;
            byte b10 = bArr12[364];
            Object[] objArr38 = new Object[1];
            c(b10, (short) (b10 | 99), bArr12[38], objArr38);
            Class<?> cls4 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c((byte) (-bArr12[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr39);
            cls4.getMethod((String) objArr39[0], Long.TYPE, Long.TYPE).invoke(null, objArr37);
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i59 = ((int[]) objArr2[3])[0];
            int i60 = ((int[]) objArr2[0])[0];
            int i61 = ((int[]) objArr2[1])[0];
            String[] strArr9 = (String[]) objArr2[2];
            int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
            int i62 = ~(392319175 | ringerMode);
            int i63 = ~ringerMode;
            int i64 = i62 | (~(590491541 | i63));
            int i65 = ~((-392319176) | i63);
            int i66 = i59 + (-126016679) + ((i64 | i65) * (-516)) + (((~(ringerMode | (-537931537))) | (~((-52560006) | i63))) * 516) + ((52560005 | i65) * 516);
            int i67 = (i66 << 13) ^ i66;
            int i68 = i67 ^ (i67 >>> 17);
            i2 = 0;
            ((int[]) objArr40[3])[0] = i68 ^ (i68 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame19 == null) {
            int iResolveSizeAndState = View.resolveSizeAndState(i2, i2, i2) + 26;
            char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            int i69 = 1040 - (ExpandableListView.getPackedPositionForChild(i2, i2) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i2, i2) == 0L ? 0 : -1));
            byte[] bArr13 = $$a;
            byte b11 = (byte) (bArr13[5] - 1);
            Object[] objArr41 = new Object[1];
            b(b11, (byte) (b11 | 47), bArr13[18], objArr41);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, minimumFlingVelocity, i69, 2061780482, false, (String) objArr41[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j4 == -1 || j4 + 4611686018427387813L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr42 = {313276177};
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame20 == null) {
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 7, (char) (View.combineMeasuredStates(0, 0) + 22251), 1033 - View.combineMeasuredStates(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame20).newInstance(objArr42), -2011631218, false);
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame21 == null) {
                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 26;
                char c2 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                int absoluteGravity2 = 1041 - Gravity.getAbsoluteGravity(0, 0);
                byte[] bArr14 = $$a;
                byte b12 = bArr14[28];
                Object[] objArr43 = new Object[1];
                b(b12, (byte) (b12 | 39), bArr14[18], objArr43);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(absoluteGravity, c2, absoluteGravity2, 1145017376, false, (String) objArr43[0], null);
            }
            ((Field) objAccessartificialFrame21).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame22 == null) {
                    int iResolveSizeAndState2 = 26 - View.resolveSizeAndState(0, 0, 0);
                    char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int iMakeMeasureSpec2 = 1041 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    byte[] bArr15 = $$a;
                    byte b13 = (byte) (bArr15[5] - 1);
                    Object[] objArr44 = new Object[1];
                    b(b13, (byte) (b13 | 47), bArr15[18], objArr44);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState2, minimumFlingVelocity2, iMakeMeasureSpec2, 2061780482, false, (String) objArr44[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame23 == null) {
                int i70 = 27 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 1041;
                byte[] bArr16 = $$a;
                byte b14 = bArr16[28];
                Object[] objArr45 = new Object[1];
                b(b14, (byte) (b14 | 39), bArr16[18], objArr45);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i70, cLastIndexOf, iResolveOpacity2, 1145017376, false, (String) objArr45[0], null);
            }
            Object[] objArr46 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i71 = ((int[]) objArr46[3])[0];
            int i72 = ((int[]) objArr46[2])[0];
            String[] strArr10 = (String[]) objArr46[0];
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i73 = ((((-1447917290) + (((~((-281019650) | streamMaxVolume)) | (~((~streamMaxVolume) | (-202915843)))) * (-318))) + (((~(818057029 | streamMaxVolume)) | (-1020972872)) * (-318))) + (((~(streamMaxVolume | (-818057030))) | 739953222) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)) - 2011631218;
            int i74 = (i73 << 13) ^ i73;
            int i75 = i74 ^ (i74 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i75 ^ (i75 << 5);
        }
        int i76 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i77 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i77 == i76) {
            Object[] objArr47 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i78 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i79 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i80 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i81 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i82 = ~i81;
            int i83 = i78 + (-2105834626) + ((143798362 | i82) * (-192)) + (((~(166883675 | i82)) | 101189120) * (-384)) + (((~(i81 | (-23085314))) | (~(i82 | 268072795)) | (~((-101189121) | i81))) * JfifUtil.MARKER_SOFn);
            int i84 = (i83 << 13) ^ i83;
            int i85 = i84 ^ (i84 >>> 17);
            ((int[]) objArr47[1])[0] = i85 ^ (i85 << 5);
            int i86 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
            artificialFrame = i86 % 128;
            int i87 = i86 % 2;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr12 != null) {
                int i88 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                artificialFrame = i88 % 128;
                int i89 = 2;
                int i90 = i88 % 2;
                int i91 = 0;
                while (i91 < strArr12.length) {
                    int i92 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                    artificialFrame = i92 % 128;
                    int i93 = i92 % i89;
                    arrayList3.add(strArr12[i91]);
                    i91++;
                    i89 = 2;
                }
            }
            Object[] objArr48 = {Long.valueOf(((long) (i76 ^ i77)) ^ (((long) 509392208) << 32)), Long.valueOf(509392210)};
            byte[] bArr17 = $$d;
            byte b15 = bArr17[13];
            Object[] objArr49 = new Object[1];
            c(b15, (short) (b15 | 149), (byte) (-bArr17[147]), objArr49);
            Class<?> cls5 = Class.forName((String) objArr49[0]);
            Object[] objArr50 = new Object[1];
            c((byte) (-bArr17[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr50);
            cls5.getMethod((String) objArr50[0], Long.TYPE, Long.TYPE).invoke(null, objArr48);
            Object[] objArr51 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i94 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i95 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i96 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i97 = ~((-541725611) | (~iElapsedRealtime));
            int i98 = i94 + (((((-1005215660) | i97) | (~(541725610 | iElapsedRealtime))) * (-338)) - 382372890) + (((~(iElapsedRealtime | (-463490050))) | i97) * 338);
            int i99 = (i98 << 13) ^ i98;
            int i100 = i99 ^ (i99 >>> 17);
            ((int[]) objArr51[1])[0] = i100 ^ (i100 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame24 == null) {
            int scrollBarSize2 = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
            char packedPositionType = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
            int threadPriority2 = 684 - ((Process.getThreadPriority(0) + 20) >> 6);
            byte[] bArr18 = $$a;
            Object[] objArr52 = new Object[1];
            b((byte) (-bArr18[20]), (byte) (bArr18[2] + 1), (byte) (-bArr18[4]), objArr52);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, packedPositionType, threadPriority2, 752929587, false, (String) objArr52[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j5 == -1 || j5 + 1851 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr53 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{12318, 47999, 58962, 8743}, (char) (10214 - Color.red(0)), new char[]{40772, 6925, 54834, 43522, 22160, 49287, 14099, 33859, 1180, 57459, 48174, 63498, 8927, 52192, 11632, 20341, 55448, 25609, 9180, 52505, 20259, 38142, 35844, 36810, 63306, 62829}, objArr53);
                Class<?> cls6 = Class.forName((String) objArr53[0]);
                Object[] objArr54 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{62945, 45546, 3591, 8908}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 52203), new char[]{61065, 65201, 45637, 34154, 56168, 40116, 6302, 64840, 32148, 20842, 49335, 62023, 59755, 14158, 6320, 18662, 17729, 16557}, objArr54);
                baseContext3 = (Context) cls6.getMethod((String) objArr54[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                if (baseContext3 instanceof ContextWrapper) {
                    int i101 = artificialFrame + 45;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i101 % 128;
                    int i102 = i101 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                } else {
                    baseContext3 = baseContext3.getApplicationContext();
                }
            }
            Object[] objArr55 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1985596697};
            byte[] bArr19 = $$d;
            Object[] objArr56 = new Object[1];
            c(bArr19[364], (short) 203, (byte) (-bArr19[201]), objArr56);
            Class<?> cls7 = Class.forName((String) objArr56[0]);
            Object[] objArr57 = new Object[1];
            c((byte) (bArr19[333] - 1), (short) 245, bArr19[3], objArr57);
            objArr3 = (Object[]) cls7.getMethod((String) objArr57[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr55);
            if (baseContext3 != null) {
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame25 == null) {
                    int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                    char c3 = (char) (49363 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int iRed = 684 - Color.red(0);
                    byte b16 = (byte) ($$b >>> 1);
                    Object[] objArr58 = new Object[1];
                    b(b16, (byte) (b16 - 4), (byte) (-$$a[4]), objArr58);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, c3, iRed, 1944867703, false, (String) objArr58[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame26 == null) {
                        int i103 = 30 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        char scrollBarFadeDuration = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                        int iGreen = Color.green(0) + 684;
                        byte[] bArr20 = $$a;
                        Object[] objArr59 = new Object[1];
                        b((byte) (-bArr20[20]), (byte) (bArr20[2] + 1), (byte) (-bArr20[4]), objArr59);
                        objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i103, scrollBarFadeDuration, iGreen, 752929587, false, (String) objArr59[0], null);
                    }
                    ((Field) objAccessartificialFrame26).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame27 == null) {
                int i104 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char absoluteGravity3 = (char) (Gravity.getAbsoluteGravity(0, 0) + 49362);
                int iIndexOf = 683 - TextUtils.indexOf((CharSequence) "", '0');
                byte b17 = (byte) ($$b >>> 1);
                Object[] objArr60 = new Object[1];
                b(b17, (byte) (b17 - 4), (byte) (-$$a[4]), objArr60);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i104, absoluteGravity3, iIndexOf, 1944867703, false, (String) objArr60[0], null);
            }
            Object[] objArr61 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr61[0])[0]}, new int[]{((int[]) objArr61[1])[0]}, new int[1], (String) objArr61[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i105 = ~((-475537698) | iIdentityHashCode);
            int i106 = ~iIdentityHashCode;
            int i107 = (-1707083442) + ((i105 | (~((-27269253) | i106))) * 920) + (((~((-475816826) | i106)) | 475537697) * 920) + (((~(iIdentityHashCode | (-27269253))) | (~((-475537698) | i106)) | (~((-279129) | iIdentityHashCode))) * 920) + 1985596697;
            int i108 = (i107 << 13) ^ i107;
            int i109 = i108 ^ (i108 >>> 17);
            ((int[]) objArr3[2])[0] = i109 ^ (i109 << 5);
        }
        int i110 = ((int[]) objArr3[1])[0];
        int i111 = ((int[]) objArr3[0])[0];
        if (i111 == i110) {
            int i112 = ((int[]) objArr3[2])[0];
            Object[] objArr62 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i113 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i114 = i112 + (((1300475790 + (((~(i113 | (-25167873))) | (~((-805966977) | i113))) * (-184))) + (((73744463 | (~((-879711440) | i113))) | (~((-98912336) | i113))) * SyslogConstants.LOG_LOCAL7)) - 1005931320);
            int i115 = (i114 << 13) ^ i114;
            int i116 = i115 ^ (i115 >>> 17);
            i3 = 0;
            ((int[]) objArr62[2])[0] = i116 ^ (i116 << 5);
        } else {
            Object[] objArr63 = {Long.valueOf(((long) (i110 ^ i111)) ^ (((long) (-272396220)) << 32)), Long.valueOf(-272396224)};
            byte[] bArr21 = $$d;
            Object[] objArr64 = new Object[1];
            c(bArr21[364], (short) 264, bArr21[77], objArr64);
            Class<?> cls8 = Class.forName((String) objArr64[0]);
            Object[] objArr65 = new Object[1];
            c((byte) (-bArr21[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr65);
            cls8.getMethod((String) objArr65[0], Long.TYPE, Long.TYPE).invoke(null, objArr63);
            int i117 = ((int[]) objArr3[2])[0];
            Object[] objArr66 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i118 = ~(System.identityHashCode(this) | 956127188);
            int i119 = i117 + (((598774890 + (((-22496587) | i118) * (-220))) + ((i118 | (-973035487)) * 220)) - 954990620);
            int i120 = (i119 << 13) ^ i119;
            int i121 = i120 ^ (i120 >>> 17);
            i3 = 0;
            ((int[]) objArr66[2])[0] = i121 ^ (i121 << 5);
        }
        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame28 == null) {
            int iResolveSize = 30 - View.resolveSize(i3, i3);
            char cIndexOf = (char) (TextUtils.indexOf("", "") + 49362);
            int maximumFlingVelocity = 684 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            byte[] bArr22 = $$a;
            Object[] objArr67 = new Object[1];
            b((byte) 57, (byte) (bArr22[114] + 1), bArr22[28], objArr67);
            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iResolveSize, cIndexOf, maximumFlingVelocity, -1583976536, false, (String) objArr67[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame28).getLong(null);
        if (j6 == -1 || j6 + 1947 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i122 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
            artificialFrame = i122 % 128;
            int i123 = i122 % 2;
            Object[] objArr68 = {Integer.valueOf(iIntValue3), -1439175467};
            byte[] bArr23 = $$d;
            Object[] objArr69 = new Object[1];
            c(bArr23[364], (short) 330, bArr23[333], objArr69);
            Class<?> cls9 = Class.forName((String) objArr69[0]);
            byte b18 = bArr23[364];
            Object[] objArr70 = new Object[1];
            c(b18, (short) (b18 | 354), bArr23[95], objArr70);
            objArr4 = (Object[]) cls9.getMethod((String) objArr70[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr68);
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame29 == null) {
                int iArgb2 = 30 - Color.argb(0, 0, 0, 0);
                char gidForName2 = (char) (49361 - Process.getGidForName(""));
                int bitsPerPixel = 683 - ImageFormat.getBitsPerPixel(0);
                Object[] objArr71 = new Object[1];
                b((byte) 69, (byte) 40, $$a[18], objArr71);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iArgb2, gidForName2, bitsPerPixel, -1456483158, false, (String) objArr71[0], null);
            }
            ((Field) objAccessartificialFrame29).set(null, objArr4);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame30 == null) {
                    int offsetBefore = 30 - TextUtils.getOffsetBefore("", 0);
                    char c4 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                    int i124 = 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte[] bArr24 = $$a;
                    Object[] objArr72 = new Object[1];
                    b((byte) 57, (byte) (bArr24[114] + 1), bArr24[28], objArr72);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(offsetBefore, c4, i124, -1583976536, false, (String) objArr72[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame31 == null) {
                int threadPriority3 = 30 - ((Process.getThreadPriority(0) + 20) >> 6);
                char longPressTimeout = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 49362);
                int defaultSize3 = 684 - View.getDefaultSize(0, 0);
                Object[] objArr73 = new Object[1];
                b((byte) 69, (byte) 40, $$a[18], objArr73);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(threadPriority3, longPressTimeout, defaultSize3, -1456483158, false, (String) objArr73[0], null);
            }
            Object[] objArr74 = (Object[]) ((Field) objAccessartificialFrame31).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr74[0])[0]}, new int[]{((int[]) objArr74[1])[0]}, new int[1], (String) objArr74[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i125 = (((58690128 + ((~((-419565849) | iIdentityHashCode2)) * 623)) + (((~iIdentityHashCode2) | 542181382) * (-623))) + (((~(iIdentityHashCode2 | 550619654)) | ((~((-428004121) | iIdentityHashCode2)) | 419565848)) * 623)) - 1439175467;
            int i126 = (i125 << 13) ^ i125;
            int i127 = i126 ^ (i126 >>> 17);
            ((int[]) objArr4[2])[0] = i127 ^ (i127 << 5);
        }
        int i128 = ((int[]) objArr4[1])[0];
        int i129 = ((int[]) objArr4[0])[0];
        if (i129 == i128) {
            int i130 = ((int[]) objArr4[2])[0];
            Object[] objArr75 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int i131 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i132 = i130 + ((~((-352358529) | i131)) * 521) + 316243262 + (((~((~i131) | (-352358529))) | 539232352) * 521);
            int i133 = (i132 << 13) ^ i132;
            int i134 = i133 ^ (i133 >>> 17);
            ((int[]) objArr75[2])[0] = i134 ^ (i134 << 5);
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr76 = {Long.valueOf(((long) (i128 ^ i129)) ^ (((long) (-384633668)) << 32)), Long.valueOf(-384633684)};
            byte[] bArr25 = $$d;
            byte b19 = bArr25[364];
            Object[] objArr77 = new Object[1];
            c(b19, (short) (b19 | 370), bArr25[200], objArr77);
            Class<?> cls10 = Class.forName((String) objArr77[0]);
            Object[] objArr78 = new Object[1];
            c((byte) (-bArr25[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr78);
            cls10.getMethod((String) objArr78[0], Long.TYPE, Long.TYPE).invoke(null, objArr76);
            int i135 = ((int[]) objArr4[2])[0];
            Object[] objArr79 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i136 = ~iIdentityHashCode3;
            int i137 = i135 + 1052644892 + (((~((-320535151) | i136)) | (-658088625)) * (-865)) + ((~(iIdentityHashCode3 | 320535150)) * 865) + (((~((-658088625) | i136)) | (~(i136 | 320535150))) * 865);
            int i138 = (i137 << 13) ^ i137;
            int i139 = i138 ^ (i138 >>> 17);
            ((int[]) objArr79[2])[0] = i139 ^ (i139 << 5);
        }
        Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame32 == null) {
            int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30;
            char scrollBarSize3 = (char) (49362 - (ViewConfiguration.getScrollBarSize() >> 8));
            int iBlue2 = Color.blue(0) + 684;
            byte[] bArr26 = $$a;
            Object[] objArr80 = new Object[1];
            b((byte) (bArr26[3] + 1), (byte) (bArr26[2] + 1), bArr26[28], objArr80);
            objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, scrollBarSize3, iBlue2, 508509282, false, (String) objArr80[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame32).getLong(null);
        if (j7 != -1) {
            int i140 = artificialFrame + 75;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i140 % 128;
            if (i140 % 2 == 0 ? j7 + 1897 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j7 * 1897 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    int i141 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                    artificialFrame = i141 % 128;
                    int i142 = i141 % 2;
                    Object[] objArr81 = new Object[1];
                    a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{12318, 47999, 58962, 8743}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 10210), new char[]{40772, 6925, 54834, 43522, 22160, 49287, 14099, 33859, 1180, 57459, 48174, 63498, 8927, 52192, 11632, 20341, 55448, 25609, 9180, 52505, 20259, 38142, 35844, 36810, 63306, 62829}, objArr81);
                    Class<?> cls11 = Class.forName((String) objArr81[0]);
                    Object[] objArr82 = new Object[1];
                    a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{62945, 45546, 3591, 8908}, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 52238), new char[]{61065, 65201, 45637, 34154, 56168, 40116, 6302, 64840, 32148, 20842, 49335, 62023, 59755, 14158, 6320, 18662, 17729, 16557}, objArr82);
                    baseContext = (Context) cls11.getMethod((String) objArr82[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if (baseContext instanceof ContextWrapper) {
                        int i143 = artificialFrame + 5;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i143 % 128;
                        int i144 = i143 % 2;
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = baseContext.getApplicationContext();
                        } else {
                            baseContext = null;
                        }
                    } else {
                        baseContext = baseContext.getApplicationContext();
                    }
                }
                Object[] objArr83 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1675942317};
                byte[] bArr27 = $$d;
                Object[] objArr84 = new Object[1];
                c(bArr27[364], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, (byte) (-bArr27[21]), objArr84);
                Class<?> cls12 = Class.forName((String) objArr84[0]);
                Object[] objArr85 = new Object[1];
                c(bArr27[56], bArr27[200], bArr27[131], objArr85);
                objArr5 = (Object[]) cls12.getMethod((String) objArr85[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr83);
                if (baseContext != null) {
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame == null) {
                        int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30;
                        char bitsPerPixel2 = (char) (49361 - ImageFormat.getBitsPerPixel(0));
                        int iIndexOf2 = 684 - TextUtils.indexOf("", "", 0);
                        byte b20 = (byte) ($$b + 5);
                        byte[] bArr28 = $$a;
                        Object[] objArr86 = new Object[1];
                        b(b20, (byte) (-bArr28[15]), bArr28[79], objArr86);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, bitsPerPixel2, iIndexOf2, -1321816393, false, (String) objArr86[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr5);
                    try {
                        Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame2 == null) {
                            int iResolveSizeAndState3 = 30 - View.resolveSizeAndState(0, 0, 0);
                            char absoluteGravity4 = (char) (49362 - Gravity.getAbsoluteGravity(0, 0));
                            int i145 = 684 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            byte[] bArr29 = $$a;
                            Object[] objArr87 = new Object[1];
                            b((byte) (bArr29[3] + 1), (byte) (bArr29[2] + 1), bArr29[28], objArr87);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState3, absoluteGravity4, i145, 508509282, false, (String) objArr87[0], null);
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf6);
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                }
            } else {
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame33 == null) {
                    int scrollBarFadeDuration2 = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char c5 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                    int size3 = 684 - View.MeasureSpec.getSize(0);
                    byte b21 = (byte) ($$b + 5);
                    byte[] bArr30 = $$a;
                    Object[] objArr88 = new Object[1];
                    b(b21, (byte) (-bArr30[15]), bArr30[79], objArr88);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, c5, size3, -1321816393, false, (String) objArr88[0], null);
                }
                Object[] objArr89 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                objArr5 = new Object[]{new int[]{((int[]) objArr89[0])[0]}, new int[]{((int[]) objArr89[1])[0]}, new int[1], (String) objArr89[3]};
                int iIdentityHashCode4 = System.identityHashCode(this);
                int i146 = ~iIdentityHashCode4;
                int i147 = (((1647982104 + (((~((-340740397) | i146)) | (-637883379)) * (-865))) + ((~(iIdentityHashCode4 | 340740396)) * 865)) + (((~((-637883379) | i146)) | (~(i146 | 340740396))) * 865)) - 1675942317;
                int i148 = (i147 << 13) ^ i147;
                int i149 = i148 ^ (i148 >>> 17);
                ((int[]) objArr5[2])[0] = i149 ^ (i149 << 5);
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                int i1410 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                artificialFrame = i1410 % 128;
                int i1411 = i1410 % 2;
                Object[] objArr810 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{12318, 47999, 58962, 8743}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 10210), new char[]{40772, 6925, 54834, 43522, 22160, 49287, 14099, 33859, 1180, 57459, 48174, 63498, 8927, 52192, 11632, 20341, 55448, 25609, 9180, 52505, 20259, 38142, 35844, 36810, 63306, 62829}, objArr810);
                Class<?> cls13 = Class.forName((String) objArr810[0]);
                Object[] objArr811 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{62945, 45546, 3591, 8908}, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 52238), new char[]{61065, 65201, 45637, 34154, 56168, 40116, 6302, 64840, 32148, 20842, 49335, 62023, 59755, 14158, 6320, 18662, 17729, 16557}, objArr811);
                baseContext = (Context) cls13.getMethod((String) objArr811[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    int i1412 = artificialFrame + 5;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1412 % 128;
                    int i1413 = i1412 % 2;
                    if (((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            Object[] objArr812 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1675942317};
            byte[] bArr210 = $$d;
            Object[] objArr813 = new Object[1];
            c(bArr210[364], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, (byte) (-bArr210[21]), objArr813);
            Class<?> cls14 = Class.forName((String) objArr813[0]);
            Object[] objArr814 = new Object[1];
            c(bArr210[56], bArr210[200], bArr210[131], objArr814);
            objArr5 = (Object[]) cls14.getMethod((String) objArr814[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr812);
            if (baseContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame == null) {
                    int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30;
                    char bitsPerPixel3 = (char) (49361 - ImageFormat.getBitsPerPixel(0));
                    int iIndexOf3 = 684 - TextUtils.indexOf("", "", 0);
                    byte b22 = (byte) ($$b + 5);
                    byte[] bArr211 = $$a;
                    Object[] objArr815 = new Object[1];
                    b(b22, (byte) (-bArr211[15]), bArr211[79], objArr815);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, bitsPerPixel3, iIndexOf3, -1321816393, false, (String) objArr815[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr5);
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame2 == null) {
                    int iResolveSizeAndState4 = 30 - View.resolveSizeAndState(0, 0, 0);
                    char absoluteGravity5 = (char) (49362 - Gravity.getAbsoluteGravity(0, 0));
                    int i1414 = 684 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    byte[] bArr212 = $$a;
                    Object[] objArr816 = new Object[1];
                    b((byte) (bArr212[3] + 1), (byte) (bArr212[2] + 1), bArr212[28], objArr816);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState4, absoluteGravity5, i1414, 508509282, false, (String) objArr816[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf7);
            }
        }
        int i150 = ((int[]) objArr5[1])[0];
        int i151 = ((int[]) objArr5[0])[0];
        if (i151 == i150) {
            int i152 = ((int[]) objArr5[2])[0];
            Object[] objArr90 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 2080464355;
            int i153 = ~iCodePointAt;
            int i154 = i152 + (-2097372688) + (((~((-417687271) | i153)) | (~(971994878 | iCodePointAt))) * (-831)) + ((~((-411058375) | iCodePointAt)) * (-1662)) + (((~(iCodePointAt | 417687270)) | (~(i153 | (-560936505))) | (~(560936504 | iCodePointAt))) * 831);
            int i155 = (i154 << 13) ^ i154;
            int i156 = i155 ^ (i155 >>> 17);
            ((int[]) objArr90[2])[0] = i156 ^ (i156 << 5);
        } else {
            Object[] objArr91 = {Long.valueOf(((long) (i150 ^ i151)) ^ (((long) 1081024406) << 32)), Long.valueOf(1081023894)};
            byte[] bArr31 = $$d;
            byte b23 = bArr31[364];
            Object[] objArr92 = new Object[1];
            c(b23, (short) (b23 | 370), bArr31[200], objArr92);
            Class<?> cls15 = Class.forName((String) objArr92[0]);
            Object[] objArr93 = new Object[1];
            c((byte) (-bArr31[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr93);
            cls15.getMethod((String) objArr93[0], Long.TYPE, Long.TYPE).invoke(null, objArr91);
            int i157 = ((int[]) objArr5[2])[0];
            Object[] objArr94 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int streamMaxVolume2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i158 = i157 + (-872584314) + ((~((~streamMaxVolume2) | 801938327)) * (-116)) + ((265034647 | streamMaxVolume2) * 116) + (((~(streamMaxVolume2 | (-713589128))) | 176685447) * 116);
            int i159 = (i158 << 13) ^ i158;
            int i160 = i159 ^ (i159 >>> 17);
            ((int[]) objArr94[2])[0] = i160 ^ (i160 << 5);
        }
        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame34 == null) {
            int i161 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 16;
            char pressedStateDuration3 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
            int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 748;
            byte[] bArr32 = $$a;
            byte b24 = (byte) (bArr32[5] - 1);
            Object[] objArr95 = new Object[1];
            b(b24, (byte) (b24 | 47), bArr32[18], objArr95);
            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i161, pressedStateDuration3, iLastIndexOf2, -144068856, false, (String) objArr95[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame34).getLong(null);
        try {
            if (j8 != -1) {
                if (j8 + 4611686018427387817L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame35 == null) {
                        int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0) + 18;
                        char doubleTapTimeout2 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i162 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 746;
                        byte[] bArr33 = $$a;
                        byte b25 = bArr33[28];
                        Object[] objArr96 = new Object[1];
                        b(b25, (byte) (b25 | 39), bArr33[18], objArr96);
                        objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iIndexOf4, doubleTapTimeout2, i162, -1031537386, false, (String) objArr96[0], null);
                    }
                    Object[] objArr97 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                    objArr6 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i163 = ((int[]) objArr97[3])[0];
                    int i164 = ((int[]) objArr97[4])[0];
                    List list = (List) objArr97[0];
                    List list2 = (List) objArr97[2];
                    int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) - 219341731;
                    int i165 = 574742169 + (((~((-461468583) | iCodePointAt2)) | 142635298) * 1504) + ((~(iCodePointAt2 | (-318833285))) * (-1504)) + 1440995453;
                    int i166 = (i165 << 13) ^ i165;
                    int i167 = i166 ^ (i166 >>> 17);
                    ((int[]) objArr6[1])[0] = i167 ^ (i167 << 5);
                } else {
                    i4 = 0;
                }
                i5 = ((int[]) objArr6[4])[0];
                i6 = ((int[]) objArr6[3])[0];
                if (i6 == i5) {
                    Object[] objArr98 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i168 = ((int[]) objArr6[1])[0];
                    int i169 = ((int[]) objArr6[3])[0];
                    int i170 = ((int[]) objArr6[4])[0];
                    List list3 = (List) objArr6[0];
                    List list4 = (List) objArr6[2];
                    int i171 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                    int i172 = ~i171;
                    int i173 = i168 + 1590821989 + (((-135349378) | i171) * (-676)) + (((~(386048580 | i172)) | 135349377) * 676) + (((~(i171 | 521397957)) | (~(i172 | (-219399878))) | 84050500) * 676);
                    int i174 = (i173 << 13) ^ i173;
                    int i175 = i174 ^ (i174 >>> 17);
                    ((int[]) objArr98[1])[0] = i175 ^ (i175 << 5);
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Object[] objArr99 = {objArr6};
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(41 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (12468 - (ViewConfiguration.getPressedStateDuration() >> 16)), 3642 - (ViewConfiguration.getTapTimeout() >> 16), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame3).invoke(null, objArr99));
                    Object[] objArr100 = {objArr6};
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - TextUtils.indexOf("", "", 0, 0), (char) (12468 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), 3642 - TextUtils.getCapsMode("", 0, 0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame4).invoke(null, objArr100));
                    Object[] objArr101 = {Long.valueOf(((long) (i5 ^ i6)) ^ (((long) (-1031748652)) << 32)), Long.valueOf(-1031748644)};
                    byte[] bArr34 = $$d;
                    byte b26 = bArr34[364];
                    Object[] objArr102 = new Object[1];
                    c(b26, (short) (b26 | Ascii.ETX), (byte) (-bArr34[54]), objArr102);
                    Class<?> cls16 = Class.forName((String) objArr102[0]);
                    Object[] objArr103 = new Object[1];
                    c((byte) (-bArr34[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr103);
                    cls16.getMethod((String) objArr103[0], Long.TYPE, Long.TYPE).invoke(null, objArr101);
                    Object[] objArr104 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i176 = ((int[]) objArr6[1])[0];
                    int i177 = ((int[]) objArr6[3])[0];
                    int i178 = ((int[]) objArr6[4])[0];
                    List list5 = (List) objArr6[0];
                    List list6 = (List) objArr6[2];
                    int iMyTid = Process.myTid();
                    int i179 = ~iMyTid;
                    int i180 = i176 + 955031971 + (((~((-296842292) | i179)) | (~((-308606167) | iMyTid))) * 1900) + (((~(i179 | 308606166)) | (~(iMyTid | 296842291))) * (-950)) + (((~(iMyTid | 308606166)) | (~(i179 | 296842291))) * 950);
                    int i181 = (i180 << 13) ^ i180;
                    int i182 = i181 ^ (i181 >>> 17);
                    ((int[]) objArr104[1])[0] = i182 ^ (i182 << 5);
                }
                super.onStart();
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame5 == null) {
                    int i183 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 35;
                    char bitsPerPixel4 = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                    int iLastIndexOf3 = 539 - TextUtils.lastIndexOf("", '0', 0, 0);
                    byte[] bArr35 = $$a;
                    byte b27 = (byte) (bArr35[5] - 1);
                    Object[] objArr105 = new Object[1];
                    b(b27, (byte) (b27 | 47), bArr35[18], objArr105);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i183, bitsPerPixel4, iLastIndexOf3, 624296913, false, (String) objArr105[0], null);
                }
                j = ((Field) objAccessartificialFrame5).getLong(null);
                if (j != -1 || j + 1893 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                    if (objAccessartificialFrame6 == null) {
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - KeyEvent.getDeadChar(0, 0), (char) (39517 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 982 - (ViewConfiguration.getPressedStateDuration() >> 16), 117222168, false, null, new Class[0]);
                    }
                    Object[] objArr106 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 2014824001, 0};
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
                    if (objAccessartificialFrame7 == null) {
                        int scrollBarFadeDuration3 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
                        int i184 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 540;
                        byte b28 = (byte) ($$a[5] - 1);
                        Object[] objArr107 = new Object[1];
                        b((byte) 96, b28, b28, objArr107);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, packedPositionChild, i184, 2101703389, false, (String) objArr107[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 54, (char) (Color.rgb(0, 0, 0) + 16778049), View.combineMeasuredStates(0, 0) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) Color.green(0), 630 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), Integer.TYPE, Integer.TYPE});
                    }
                    Object[] objArr108 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr106);
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame8 == null) {
                        int iResolveSizeAndState5 = View.resolveSizeAndState(0, 0, 0) + 36;
                        char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int iResolveSize2 = View.resolveSize(0, 0) + 540;
                        byte[] bArr36 = $$a;
                        byte b29 = bArr36[28];
                        Object[] objArr109 = new Object[1];
                        b(b29, (byte) (b29 | 39), bArr36[18], objArr109);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState5, scrollDefaultDelay, iResolveSize2, 793268735, false, (String) objArr109[0], null);
                    }
                    ((Field) objAccessartificialFrame8).set(null, objArr108);
                    try {
                        Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                        if (objAccessartificialFrame9 == null) {
                            int pressedStateDuration4 = (ViewConfiguration.getPressedStateDuration() >> 16) + 36;
                            char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                            int maximumDrawingCacheSize3 = 540 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                            byte[] bArr37 = $$a;
                            byte b30 = (byte) (bArr37[5] - 1);
                            Object[] objArr110 = new Object[1];
                            b(b30, (byte) (b30 | 47), bArr37[18], objArr110);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(pressedStateDuration4, cResolveOpacity, maximumDrawingCacheSize3, 624296913, false, (String) objArr110[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, lValueOf8);
                        objArr7 = objArr108;
                    } catch (Exception unused7) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame36 == null) {
                        int iMyPid = (Process.myPid() >> 22) + 36;
                        char maximumDrawingCacheSize4 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0, 0) + 541;
                        byte[] bArr38 = $$a;
                        byte b31 = bArr38[28];
                        Object[] objArr111 = new Object[1];
                        b(b31, (byte) (b31 | 39), bArr38[18], objArr111);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iMyPid, maximumDrawingCacheSize4, iLastIndexOf4, 793268735, false, (String) objArr111[0], null);
                    }
                    Object[] objArr112 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr7 = new Object[]{new int[1], new int[1], new int[1]};
                    int i185 = ((int[]) objArr112[2])[0];
                    int i186 = ((int[]) objArr112[1])[0];
                    ((int[]) objArr7[2])[0] = i185;
                    ((int[]) objArr7[1])[0] = i186;
                    int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                    int i187 = (-900010404) + (((~((~elapsedCpuTime) | 1021486716)) | (-1072691198)) * 529) + (((~(elapsedCpuTime | 1021486716)) | (-330135034)) * 529) + 2014824001;
                    int i188 = (i187 << 13) ^ i187;
                    int i189 = i188 ^ (i188 >>> 17);
                    ((int[]) objArr7[0])[0] = i189 ^ (i189 << 5);
                }
                obj = objArr7[1];
                i7 = ((int[]) obj)[0];
                obj2 = objArr7[2];
                i8 = ((int[]) obj2)[0];
                if (i8 == i7) {
                    Object[] objArr113 = {new int[1], new int[1], new int[1]};
                    int i190 = ((int[]) objArr7[0])[0];
                    int i191 = ((int[]) obj2)[0];
                    int i192 = ((int[]) obj)[0];
                    ((int[]) objArr113[2])[0] = i191;
                    ((int[]) objArr113[1])[0] = i192;
                    int iIdentityHashCode5 = System.identityHashCode(this);
                    int i193 = ~iIdentityHashCode5;
                    int i194 = i190 + (-257054997) + (((~((-567630714) | i193)) | (~((-783991037) | iIdentityHashCode5))) * 210) + (((~(iIdentityHashCode5 | (-21306114))) | (~(i193 | (-237666437)))) * 210);
                    int i195 = (i194 << 13) ^ i194;
                    int i196 = i195 ^ (i195 >>> 17);
                    ((int[]) objArr113[0])[0] = i196 ^ (i196 << 5);
                    return;
                }
                Object[] objArr114 = {Long.valueOf((((long) 910299194) << 32) ^ ((long) (i7 ^ i8))), Long.valueOf(910295098)};
                byte[] bArr39 = $$d;
                byte b32 = bArr39[364];
                Object[] objArr115 = new Object[1];
                c(b32, (short) (b32 | 578), bArr39[136], objArr115);
                Class<?> cls17 = Class.forName((String) objArr115[0]);
                Object[] objArr116 = new Object[1];
                c((byte) (-bArr39[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr116);
                cls17.getMethod((String) objArr116[0], Long.TYPE, Long.TYPE).invoke(null, objArr114);
                Object[] objArr117 = {new int[1], new int[1], new int[1]};
                int i197 = ((int[]) objArr7[0])[0];
                int i198 = ((int[]) objArr7[2])[0];
                int i199 = ((int[]) objArr7[1])[0];
                ((int[]) objArr117[2])[0] = i198;
                ((int[]) objArr117[1])[0] = i199;
                int i200 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
                int i201 = ~i200;
                int i202 = i197 + 557881881 + (((~(i200 | 965872974)) | (~((-278007047) | i201)) | (-1073614704)) * (-68)) + ((~((-107741730) | i201)) * (-68)) + (((~((-965872975) | i201)) | (-385748776)) * 68);
                int i203 = (i202 << 13) ^ i202;
                int i204 = i203 ^ (i203 >>> 17);
                ((int[]) objArr117[0])[0] = i204 ^ (i204 << 5);
                return;
            }
            i4 = 0;
            Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame37 == null) {
                int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0', 0) + 18;
                char cAlpha = (char) Color.alpha(0);
                int trimmedLength = 747 - TextUtils.getTrimmedLength("");
                byte[] bArr40 = $$a;
                byte b33 = (byte) (bArr40[5] - 1);
                Object[] objArr118 = new Object[1];
                b(b33, (byte) (b33 | 47), bArr40[18], objArr118);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iIndexOf5, cAlpha, trimmedLength, -144068856, false, (String) objArr118[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, lValueOf9);
            i5 = ((int[]) objArr6[4])[0];
            i6 = ((int[]) objArr6[3])[0];
            if (i6 == i5) {
                Object[] objArr910 = {list3, new int[1], list4, new int[]{i169}, new int[]{i170}};
                int i1610 = ((int[]) objArr6[1])[0];
                int i1611 = ((int[]) objArr6[3])[0];
                int i1710 = ((int[]) objArr6[4])[0];
                List list7 = (List) objArr6[0];
                List list8 = (List) objArr6[2];
                int i1711 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                int i1712 = ~i1711;
                int i1713 = i1610 + 1590821989 + (((-135349378) | i1711) * (-676)) + (((~(386048580 | i1712)) | 135349377) * 676) + (((~(i1711 | 521397957)) | (~(i1712 | (-219399878))) | 84050500) * 676);
                int i1714 = (i1713 << 13) ^ i1713;
                int i1715 = i1714 ^ (i1714 >>> 17);
                ((int[]) objArr910[1])[0] = i1715 ^ (i1715 << 5);
            } else {
                ArrayList arrayList5 = new ArrayList();
                Object[] objArr911 = {objArr6};
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(41 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (12468 - (ViewConfiguration.getPressedStateDuration() >> 16)), 3642 - (ViewConfiguration.getTapTimeout() >> 16), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame3).invoke(null, objArr911));
                Object[] objArr1010 = {objArr6};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - TextUtils.indexOf("", "", 0, 0), (char) (12468 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), 3642 - TextUtils.getCapsMode("", 0, 0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame4).invoke(null, objArr1010));
                Object[] objArr1011 = {Long.valueOf(((long) (i5 ^ i6)) ^ (((long) (-1031748652)) << 32)), Long.valueOf(-1031748644)};
                byte[] bArr310 = $$d;
                byte b210 = bArr310[364];
                Object[] objArr1012 = new Object[1];
                c(b210, (short) (b210 | Ascii.ETX), (byte) (-bArr310[54]), objArr1012);
                Class<?> cls18 = Class.forName((String) objArr1012[0]);
                Object[] objArr1013 = new Object[1];
                c((byte) (-bArr310[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr1013);
                cls18.getMethod((String) objArr1013[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
                Object[] objArr1014 = {list5, new int[1], list6, new int[]{i177}, new int[]{i178}};
                int i1716 = ((int[]) objArr6[1])[0];
                int i1717 = ((int[]) objArr6[3])[0];
                int i1718 = ((int[]) objArr6[4])[0];
                List list9 = (List) objArr6[0];
                List list10 = (List) objArr6[2];
                int iMyTid2 = Process.myTid();
                int i1719 = ~iMyTid2;
                int i1810 = i1716 + 955031971 + (((~((-296842292) | i1719)) | (~((-308606167) | iMyTid2))) * 1900) + (((~(i1719 | 308606166)) | (~(iMyTid2 | 296842291))) * (-950)) + (((~(iMyTid2 | 308606166)) | (~(i1719 | 296842291))) * 950);
                int i1811 = (i1810 << 13) ^ i1810;
                int i1812 = i1811 ^ (i1811 >>> 17);
                ((int[]) objArr1014[1])[0] = i1812 ^ (i1812 << 5);
            }
            super.onStart();
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame5 == null) {
                int i1813 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 35;
                char bitsPerPixel5 = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                int iLastIndexOf5 = 539 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte[] bArr311 = $$a;
                byte b211 = (byte) (bArr311[5] - 1);
                Object[] objArr1015 = new Object[1];
                b(b211, (byte) (b211 | 47), bArr311[18], objArr1015);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i1813, bitsPerPixel5, iLastIndexOf5, 624296913, false, (String) objArr1015[0], null);
            }
            j = ((Field) objAccessartificialFrame5).getLong(null);
            if (j != -1) {
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - KeyEvent.getDeadChar(0, 0), (char) (39517 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 982 - (ViewConfiguration.getPressedStateDuration() >> 16), 117222168, false, null, new Class[0]);
                }
                Object[] objArr1016 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 2014824001, 0};
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame7 == null) {
                    int scrollBarFadeDuration4 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char packedPositionChild2 = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
                    int i1814 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 540;
                    byte b212 = (byte) ($$a[5] - 1);
                    Object[] objArr1017 = new Object[1];
                    b((byte) 96, b212, b212, objArr1017);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration4, packedPositionChild2, i1814, 2101703389, false, (String) objArr1017[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 54, (char) (Color.rgb(0, 0, 0) + 16778049), View.combineMeasuredStates(0, 0) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) Color.green(0), 630 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr1018 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr1016);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame8 == null) {
                    int iResolveSizeAndState6 = View.resolveSizeAndState(0, 0, 0) + 36;
                    char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int iResolveSize3 = View.resolveSize(0, 0) + 540;
                    byte[] bArr312 = $$a;
                    byte b213 = bArr312[28];
                    Object[] objArr1019 = new Object[1];
                    b(b213, (byte) (b213 | 39), bArr312[18], objArr1019);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState6, scrollDefaultDelay2, iResolveSize3, 793268735, false, (String) objArr1019[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr1018);
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame9 == null) {
                    int pressedStateDuration5 = (ViewConfiguration.getPressedStateDuration() >> 16) + 36;
                    char cResolveOpacity2 = (char) Drawable.resolveOpacity(0, 0);
                    int maximumDrawingCacheSize5 = 540 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    byte[] bArr313 = $$a;
                    byte b34 = (byte) (bArr313[5] - 1);
                    Object[] objArr119 = new Object[1];
                    b(b34, (byte) (b34 | 47), bArr313[18], objArr119);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(pressedStateDuration5, cResolveOpacity2, maximumDrawingCacheSize5, 624296913, false, (String) objArr119[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf10);
                objArr7 = objArr1018;
            } else {
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - KeyEvent.getDeadChar(0, 0), (char) (39517 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 982 - (ViewConfiguration.getPressedStateDuration() >> 16), 117222168, false, null, new Class[0]);
                }
                Object[] objArr10110 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 2014824001, 0};
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame7 == null) {
                    int scrollBarFadeDuration5 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char packedPositionChild3 = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
                    int i1815 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 540;
                    byte b214 = (byte) ($$a[5] - 1);
                    Object[] objArr10111 = new Object[1];
                    b((byte) 96, b214, b214, objArr10111);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration5, packedPositionChild3, i1815, 2101703389, false, (String) objArr10111[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 54, (char) (Color.rgb(0, 0, 0) + 16778049), View.combineMeasuredStates(0, 0) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) Color.green(0), 630 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr10112 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr10110);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame8 == null) {
                    int iResolveSizeAndState7 = View.resolveSizeAndState(0, 0, 0) + 36;
                    char scrollDefaultDelay3 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int iResolveSize4 = View.resolveSize(0, 0) + 540;
                    byte[] bArr314 = $$a;
                    byte b215 = bArr314[28];
                    Object[] objArr10113 = new Object[1];
                    b(b215, (byte) (b215 | 39), bArr314[18], objArr10113);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState7, scrollDefaultDelay3, iResolveSize4, 793268735, false, (String) objArr10113[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr10112);
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame9 == null) {
                    int pressedStateDuration6 = (ViewConfiguration.getPressedStateDuration() >> 16) + 36;
                    char cResolveOpacity3 = (char) Drawable.resolveOpacity(0, 0);
                    int maximumDrawingCacheSize6 = 540 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    byte[] bArr315 = $$a;
                    byte b35 = (byte) (bArr315[5] - 1);
                    Object[] objArr1110 = new Object[1];
                    b(b35, (byte) (b35 | 47), bArr315[18], objArr1110);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(pressedStateDuration6, cResolveOpacity3, maximumDrawingCacheSize6, 624296913, false, (String) objArr1110[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf11);
                objArr7 = objArr10112;
            }
            obj = objArr7[1];
            i7 = ((int[]) obj)[0];
            obj2 = objArr7[2];
            i8 = ((int[]) obj2)[0];
            if (i8 == i7) {
                Object[] objArr1111 = {new int[1], new int[1], new int[1]};
                int i1910 = ((int[]) objArr7[0])[0];
                int i1911 = ((int[]) obj2)[0];
                int i1912 = ((int[]) obj)[0];
                ((int[]) objArr1111[2])[0] = i1911;
                ((int[]) objArr1111[1])[0] = i1912;
                int iIdentityHashCode6 = System.identityHashCode(this);
                int i1913 = ~iIdentityHashCode6;
                int i1914 = i1910 + (-257054997) + (((~((-567630714) | i1913)) | (~((-783991037) | iIdentityHashCode6))) * 210) + (((~(iIdentityHashCode6 | (-21306114))) | (~(i1913 | (-237666437)))) * 210);
                int i1915 = (i1914 << 13) ^ i1914;
                int i1916 = i1915 ^ (i1915 >>> 17);
                ((int[]) objArr1111[0])[0] = i1916 ^ (i1916 << 5);
                return;
            }
            Object[] objArr1112 = {Long.valueOf((((long) 910299194) << 32) ^ ((long) (i7 ^ i8))), Long.valueOf(910295098)};
            byte[] bArr316 = $$d;
            byte b36 = bArr316[364];
            Object[] objArr1113 = new Object[1];
            c(b36, (short) (b36 | 578), bArr316[136], objArr1113);
            Class<?> cls19 = Class.forName((String) objArr1113[0]);
            Object[] objArr1114 = new Object[1];
            c((byte) (-bArr316[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr1114);
            cls19.getMethod((String) objArr1114[0], Long.TYPE, Long.TYPE).invoke(null, objArr1112);
            Object[] objArr1115 = {new int[1], new int[1], new int[1]};
            int i1917 = ((int[]) objArr7[0])[0];
            int i1918 = ((int[]) objArr7[2])[0];
            int i1919 = ((int[]) objArr7[1])[0];
            ((int[]) objArr1115[2])[0] = i1918;
            ((int[]) objArr1115[1])[0] = i1919;
            int i205 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i206 = ~i205;
            int i207 = i1917 + 557881881 + (((~(i205 | 965872974)) | (~((-278007047) | i206)) | (-1073614704)) * (-68)) + ((~((-107741730) | i206)) * (-68)) + (((~((-965872975) | i206)) | (-385748776)) * 68);
            int i208 = (i207 << 13) ^ i207;
            int i209 = i208 ^ (i208 >>> 17);
            ((int[]) objArr1115[0])[0] = i209 ^ (i209 << 5);
            return;
        } catch (Exception unused8) {
            throw new RuntimeException();
        }
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr120 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i4]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{12318, 47999, 58962, 8743}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 10177), new char[]{40772, 6925, 54834, 43522, 22160, 49287, 14099, 33859, 1180, 57459, 48174, 63498, 8927, 52192, 11632, 20341, 55448, 25609, 9180, 52505, 20259, 38142, 35844, 36810, 63306, 62829}, objArr120);
            Class<?> cls20 = Class.forName((String) objArr120[0]);
            Object[] objArr121 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ViewConfiguration.getEdgeSlop() >> 16, new char[]{62945, 45546, 3591, 8908}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 52203), new char[]{61065, 65201, 45637, 34154, 56168, 40116, 6302, 64840, 32148, 20842, 49335, 62023, 59755, 14158, 6320, 18662, 17729, 16557}, objArr121);
            baseContext4 = (Context) cls20.getMethod((String) objArr121[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = (((baseContext4 instanceof ContextWrapper) ^ true) || ((ContextWrapper) baseContext4).getBaseContext() != null) ? baseContext4.getApplicationContext() : null;
        }
        Object[] objArr122 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1185412557};
        byte[] bArr41 = $$d;
        Object[] objArr123 = new Object[1];
        c(bArr41[364], (short) 481, bArr41[414], objArr123);
        Class<?> cls21 = Class.forName((String) objArr123[0]);
        Object[] objArr124 = new Object[1];
        c((byte) (bArr41[333] - 1), (short) 245, bArr41[3], objArr124);
        objArr6 = (Object[]) cls21.getMethod((String) objArr124[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr122);
        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1575402270);
        if (objAccessartificialFrame38 == null) {
            int size4 = 17 - View.MeasureSpec.getSize(0);
            char cResolveOpacity4 = (char) Drawable.resolveOpacity(0, 0);
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 747;
            byte[] bArr42 = $$a;
            byte b37 = bArr42[28];
            Object[] objArr125 = new Object[1];
            b(b37, (byte) (b37 | 39), bArr42[18], objArr125);
            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(size4, cResolveOpacity4, packedPositionGroup, -1031537386, false, (String) objArr125[0], null);
        }
        ((Field) objAccessartificialFrame38).set(null, objArr6);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
        artificialFrame = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(29 - TextUtils.lastIndexOf("", '0', 0), (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 49993), AndroidCharacter.getMirror('0') + 26, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int offsetBefore = TextUtils.getOffsetBefore("", 0) + 30;
                    char defaultSize = (char) (49993 - View.getDefaultSize(0, 0));
                    int i3 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 74;
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c(bArr[42], (short) 614, bArr[151], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, defaultSize, i3, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onResume();
                obj.hashCode();
                throw null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame3 == null) {
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - (Process.myPid() >> 22), (char) (49992 - Process.getGidForName("")), Gravity.getAbsoluteGravity(0, 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj3 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int packedPositionChild = 29 - ExpandableListView.getPackedPositionChild(0L);
                char c = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49992);
                int iResolveOpacity = 74 - Drawable.resolveOpacity(0, 0);
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c(bArr2[42], (short) 614, bArr2[151], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(packedPositionChild, c, iResolveOpacity, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj3, null);
            super.onResume();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 117;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(29 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (49993 - Color.green(0)), Color.blue(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int iBlue = Color.blue(0) + 30;
                    char longPressTimeout = (char) (49993 - (ViewConfiguration.getLongPressTimeout() >> 16));
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 75;
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c(bArr[364], (short) 614, bArr[151], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iBlue, longPressTimeout, iLastIndexOf, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onPause();
                throw null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame3 == null) {
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (49993 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), TextUtils.lastIndexOf("", '0', 0) + 75, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj2 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 31;
                char cMyPid = (char) (49993 - (Process.myPid() >> 22));
                int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 74;
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c(bArr2[364], (short) 614, bArr2[151], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf, cMyPid, edgeSlop, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onPause();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x022d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0311 A[Catch: all -> 0x0ccd, TryCatch #2 {all -> 0x0ccd, blocks: (B:52:0x0954, B:54:0x0968, B:55:0x0997, B:14:0x02f0, B:16:0x0311, B:17:0x0363), top: B:96:0x02f0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0375  */
    /* JADX WARN: Code duplicated, block: B:25:0x047f  */
    /* JADX WARN: Code duplicated, block: B:51:0x086c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0968 A[Catch: all -> 0x0ccd, TryCatch #2 {all -> 0x0ccd, blocks: (B:52:0x0954, B:54:0x0968, B:55:0x0997, B:14:0x02f0, B:16:0x0311, B:17:0x0363), top: B:96:0x02f0 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x09ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x0ac8  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iRgb = Color.rgb(0, 0, 0) + 16777241;
            char minimumFlingVelocity = (char) (30068 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
            int mirror = AndroidCharacter.getMirror('0') + 768;
            byte[] bArr = $$a;
            byte b = (byte) (bArr[5] - 1);
            Object[] objArr2 = new Object[1];
            b(b, (byte) (b | 47), bArr[18], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iRgb, minimumFlingVelocity, mirror, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1895;
            Object[] objArr3 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{46937, 54443, 57309, 13082}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36), new char[]{12004, 11934, 50943, 37809, 7768, 44934, 65042, 35559, 40594, 51930, 11824, 27667, 35350, 31059, 40565, 29292, 40838, 26751, 53089, 16484, 35670, 7879}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, 2015450513 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{37020, 8533, 14456, 55804}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 64519), new char[]{38150, 11787, 7718, 49182, 3814, 46151, 41338, 57655, 2294, 31186, 4384, 64702, 61827, 29634, 20675}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 25;
                    char c = (char) (30068 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int i2 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                    byte[] bArr2 = $$a;
                    byte b2 = bArr2[28];
                    Object[] objArr5 = new Object[1];
                    b(b2, (byte) (b2 | 39), bArr2[18], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, c, i2, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i3 = ((int[]) objArr6[0])[0];
                int i4 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int i5 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1296469206;
                int i6 = ~i5;
                int i7 = 309331018 + (((-5276739) | i6) * (-369)) + (((~((-505635642) | i6)) | (-307463276)) * (-369)) + (((~(i5 | 505635641)) | (-510912380) | (~(i6 | (-302186538)))) * 369) + 1986535877;
                int i8 = (i7 << 13) ^ i7;
                int i9 = i8 ^ (i8 >>> 17);
                ((int[]) objArr[3])[0] = i9 ^ (i9 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, TextUtils.getOffsetAfter("", 0), new char[]{60466, 30812, 56988, 25130}, (char) (10974 - Color.green(0)), new char[]{41887, 49144, 821, 15981, 44242, 11355, 1943, 65203, 45415, 46220, 7507, 27365, 11111, 58769, 49010, 40981}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 36, new char[]{22884, 15616, 19184, 44392}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 26694), new char[]{49014, 57307, 53194, 55674, 5992, 11286, 13460, 60472, 47275, 21669, 11513, 10324, 37078, 60637, 14515, 6534}, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, 1986535877};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                        char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 30069);
                        int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                        byte b3 = (byte) ($$b & 56);
                        byte[] bArr3 = $$a;
                        Object[] objArr10 = new Object[1];
                        b(b3, bArr3[65], bArr3[9], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(pressedStateDuration, cIndexOf, maximumFlingVelocity, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int trimmedLength = TextUtils.getTrimmedLength("") + 25;
                        char trimmedLength2 = (char) (30068 - TextUtils.getTrimmedLength(""));
                        int capsMode = 816 - TextUtils.getCapsMode("", 0, 0);
                        byte[] bArr4 = $$a;
                        byte b4 = bArr4[28];
                        Object[] objArr11 = new Object[1];
                        b(b4, (byte) (b4 | 39), bArr4[18], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(trimmedLength, trimmedLength2, capsMode, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        a(new char[]{21689, 60471, 28181, 21659}, ExpandableListView.getPackedPositionGroup(0L), new char[]{46937, 54443, 57309, 13082}, (char) Color.green(0), new char[]{12004, 11934, 50943, 37809, 7768, 44934, 65042, 35559, 40594, 51930, 11824, 27667, 35350, 31059, 40565, 29292, 40838, 26751, 53089, 16484, 35670, 7879}, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) + 2015450411, new char[]{37020, 8533, 14456, 55804}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 64519), new char[]{38150, 11787, 7718, 49182, 3814, 46151, 41338, 57655, 2294, 31186, 4384, 64702, 61827, 29634, 20675}, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 25;
                            char c2 = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                            int mirror2 = 864 - AndroidCharacter.getMirror('0');
                            byte[] bArr5 = $$a;
                            byte b5 = (byte) (bArr5[5] - 1);
                            Object[] objArr14 = new Object[1];
                            b(b5, (byte) (b5 | 47), bArr5[18], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, c2, mirror2, 721586079, false, (String) objArr14[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr15 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, TextUtils.getOffsetAfter("", 0), new char[]{60466, 30812, 56988, 25130}, (char) (10974 - Color.green(0)), new char[]{41887, 49144, 821, 15981, 44242, 11355, 1943, 65203, 45415, 46220, 7507, 27365, 11111, 58769, 49010, 40981}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 36, new char[]{22884, 15616, 19184, 44392}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 26694), new char[]{49014, 57307, 53194, 55674, 5992, 11286, 13460, 60472, 47275, 21669, 11513, 10324, 37078, 60637, 14515, 6534}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, 1986535877};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 30069);
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                byte b6 = (byte) ($$b & 56);
                byte[] bArr6 = $$a;
                Object[] objArr18 = new Object[1];
                b(b6, bArr6[65], bArr6[9], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, cIndexOf2, maximumFlingVelocity2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int trimmedLength3 = TextUtils.getTrimmedLength("") + 25;
                char trimmedLength4 = (char) (30068 - TextUtils.getTrimmedLength(""));
                int capsMode2 = 816 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr7 = $$a;
                byte b7 = bArr7[28];
                Object[] objArr19 = new Object[1];
                b(b7, (byte) (b7 | 39), bArr7[18], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(trimmedLength3, trimmedLength4, capsMode2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ExpandableListView.getPackedPositionGroup(0L), new char[]{46937, 54443, 57309, 13082}, (char) Color.green(0), new char[]{12004, 11934, 50943, 37809, 7768, 44934, 65042, 35559, 40594, 51930, 11824, 27667, 35350, 31059, 40565, 29292, 40838, 26751, 53089, 16484, 35670, 7879}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) + 2015450411, new char[]{37020, 8533, 14456, 55804}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 64519), new char[]{38150, 11787, 7718, 49182, 3814, 46151, 41338, 57655, 2294, 31186, 4384, 64702, 61827, 29634, 20675}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int windowTouchSlop2 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 25;
                char c3 = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int mirror3 = 864 - AndroidCharacter.getMirror('0');
                byte[] bArr8 = $$a;
                byte b8 = (byte) (bArr8[5] - 1);
                Object[] objArr112 = new Object[1];
                b(b8, (byte) (b8 | 47), bArr8[18], objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, c3, mirror3, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i10 = ((int[]) objArr[1])[0];
        int i11 = ((int[]) objArr[0])[0];
        if (i11 == i10) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i12 = ((int[]) objArr[3])[0];
            int i13 = ((int[]) objArr[0])[0];
            int i14 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i15 = ~layoutDirection;
            int i16 = ~((-211037900) | i15);
            int i17 = ~(12865533 | layoutDirection);
            int i18 = i12 + (-2081787814) + ((i16 | i17) * 1150) + (((~((-12865534) | i15)) | i17) * (-575)) + (((~(layoutDirection | (-211037900))) | (~(i15 | 211037899))) * 575);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr20[3])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i21 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
                artificialFrame = i21 % 128;
                int i22 = i21 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) (-562786497)) << 32) ^ ((long) (i10 ^ i11))), Long.valueOf(-562786498)};
                byte[] bArr9 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr9[364], (short) 614, bArr9[13], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((byte) (-bArr9[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i23 = ((int[]) objArr[3])[0];
                int i24 = ((int[]) objArr[0])[0];
                int i25 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i26 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
                int i27 = 1617638363 + ((i26 | 628676918) * (-50));
                int i28 = ~((-609222935) | i26);
                int i29 = ~i26;
                int i30 = i23 + i27 + ((i28 | (~(1039727486 | i29))) * 50) + (((~(i29 | 628676918)) | (~(430504552 | i29)) | (-1039727487)) * 50);
                int i31 = (i30 << 13) ^ i30;
                int i32 = i31 ^ (i31 >>> 17);
                ((int[]) objArr24[3])[0] = i32 ^ (i32 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int trimmedLength5 = TextUtils.getTrimmedLength("") + 26;
            char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            int keyRepeatTimeout = 1041 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            byte[] bArr10 = $$a;
            byte b9 = (byte) (bArr10[5] - 1);
            Object[] objArr25 = new Object[1];
            b(b9, (byte) (b9 | 47), bArr10[18], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(trimmedLength5, scrollBarFadeDuration, keyRepeatTimeout, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i33 = artificialFrame + 55;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
            int i34 = i33 % 2;
            long j4 = j3 + 4611686018427387858L;
            Object[] objArr26 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 99, new char[]{46937, 54443, 57309, 13082}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 99), new char[]{12004, 11934, 50943, 37809, 7768, 44934, 65042, 35559, 40594, 51930, 11824, 27667, 35350, 31059, 40565, 29292, 40838, 26751, 53089, 16484, 35670, 7879}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) + 2015450395, new char[]{37020, 8533, 14456, 55804}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 64533), new char[]{38150, 11787, 7718, 49182, 3814, 46151, 41338, 57655, 2294, 31186, 4384, 64702, 61827, 29634, 20675}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i35 = artificialFrame + 69;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
                int i36 = i35 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iMyPid = (Process.myPid() >> 22) + 26;
                    char c4 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1);
                    int i37 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1040;
                    byte[] bArr11 = $$a;
                    byte b10 = bArr11[28];
                    Object[] objArr28 = new Object[1];
                    b(b10, (byte) (b10 | 39), bArr11[18], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iMyPid, c4, i37, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i38 = ((int[]) objArr29[3])[0];
                int i39 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i40 = (-185913626) + (((~((-541698) | startElapsedRealtime)) | 78645504) * (-756)) + (((~startElapsedRealtime) | (-541698)) * 756) + 1378525723;
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i42 ^ (i42 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{60466, 30812, 56988, 25130}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 10970), new char[]{41887, 49144, 821, 15981, 44242, 11355, 1943, 65203, 45415, 46220, 7507, 27365, 11111, 58769, 49010, 40981}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{22884, 15616, 19184, 44392}, (char) (26698 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), new char[]{49014, 57307, 53194, 55674, 5992, 11286, 13460, 60472, 47275, 21669, 11513, 10324, 37078, 60637, 14515, 6534}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1626924680};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (22251 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), 1033 - View.combineMeasuredStates(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1378525723, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int iLastIndexOf = 25 - TextUtils.lastIndexOf("", '0');
                    char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                    byte[] bArr12 = $$a;
                    byte b11 = bArr12[28];
                    Object[] objArr33 = new Object[1];
                    b(b11, (byte) (b11 | 39), bArr12[18], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, doubleTapTimeout, iIndexOf, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{46937, 54443, 57309, 13082}, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), new char[]{12004, 11934, 50943, 37809, 7768, 44934, 65042, 35559, 40594, 51930, 11824, 27667, 35350, 31059, 40565, 29292, 40838, 26751, 53089, 16484, 35670, 7879}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 2015450477, new char[]{37020, 8533, 14456, 55804}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 64532), new char[]{38150, 11787, 7718, 49182, 3814, 46151, 41338, 57655, 2294, 31186, 4384, 64702, 61827, 29634, 20675}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 26;
                        char c5 = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        int size = 1041 - View.MeasureSpec.getSize(0);
                        byte[] bArr13 = $$a;
                        byte b12 = (byte) (bArr13[5] - 1);
                        Object[] objArr36 = new Object[1];
                        b(b12, (byte) (b12 | 47), bArr13[18], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, c5, size, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{60466, 30812, 56988, 25130}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 10970), new char[]{41887, 49144, 821, 15981, 44242, 11355, 1943, 65203, 45415, 46220, 7507, 27365, 11111, 58769, 49010, 40981}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{22884, 15616, 19184, 44392}, (char) (26698 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), new char[]{49014, 57307, 53194, 55674, 5992, 11286, 13460, 60472, 47275, 21669, 11513, 10324, 37078, 60637, 14515, 6534}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1626924680};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (22251 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), 1033 - View.combineMeasuredStates(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1378525723, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iLastIndexOf2 = 25 - TextUtils.lastIndexOf("", '0');
                char doubleTapTimeout2 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                byte[] bArr14 = $$a;
                byte b13 = bArr14[28];
                Object[] objArr310 = new Object[1];
                b(b13, (byte) (b13 | 39), bArr14[18], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, doubleTapTimeout2, iIndexOf2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{46937, 54443, 57309, 13082}, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), new char[]{12004, 11934, 50943, 37809, 7768, 44934, 65042, 35559, 40594, 51930, 11824, 27667, 35350, 31059, 40565, 29292, 40838, 26751, 53089, 16484, 35670, 7879}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(new char[]{21689, 60471, 28181, 21659}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 2015450477, new char[]{37020, 8533, 14456, 55804}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 64532), new char[]{38150, 11787, 7718, 49182, 3814, 46151, 41338, 57655, 2294, 31186, 4384, 64702, 61827, 29634, 20675}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 26;
                char c6 = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                int size2 = 1041 - View.MeasureSpec.getSize(0);
                byte[] bArr15 = $$a;
                byte b14 = (byte) (bArr15[5] - 1);
                Object[] objArr313 = new Object[1];
                b(b14, (byte) (b14 | 47), bArr15[18], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, c6, size2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i44 == i43) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 917309203;
            int i48 = ~((-530764701) | iCodePointAt);
            int i49 = ~iCodePointAt;
            int i50 = i45 + 36610510 + ((i48 | (~((-452660894) | i49))) * (-1808)) + (((~((-83939585) | iCodePointAt)) | (~(i49 | (-5835778)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iCodePointAt | 452660893)) | 446825116 | (~(530764700 | i49))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[1])[0] = i52 ^ (i52 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i53 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i53 % 128;
            int i54 = i53 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) 1677627206) << 32) ^ ((long) (i43 ^ i44))), Long.valueOf(1677627204)};
        byte[] bArr16 = $$d;
        byte b15 = bArr16[13];
        Object[] objArr42 = new Object[1];
        c(b15, (short) (b15 | 149), (byte) (-bArr16[147]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((byte) (-bArr16[286]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 79, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i56 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i57 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i58 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1023991224;
        int i59 = i55 + 1045751966 + (((~((-203037957) | i58)) | 281141763) * (-756)) + (((~i58) | (-203037957)) * 756);
        int i60 = (i59 << 13) ^ i59;
        int i61 = i60 ^ (i60 >>> 17);
        ((int[]) objArr44[1])[0] = i61 ^ (i61 << 5);
    }

    static void accessartificialFrame() {
        coroutineBoundary = -6405923624366736907L;
        accessartificialFrame = -1151259316;
        CoroutineDebuggingKt = (char) 11596;
    }
}
