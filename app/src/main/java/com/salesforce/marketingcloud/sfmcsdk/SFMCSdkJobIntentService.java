package com.salesforce.marketingcloud.sfmcsdk;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.JobIntentService;
import com.facebook.fresco.urimod.UriModifierInterface;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.internal.b;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.build;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SFMCSdkJobIntentService extends JobIntentService {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static final String ACTION_SYSTEM_BEHAVIOR = "com.salesforce.marketingcloud.sfmcsdk.SYSTEM_BEHAVIOR";
    public static final Companion Companion;
    private static final String EXTRA_BEHAVIOR = "behavior";
    private static final String EXTRA_DATA = "data";
    private static char ICustomTabsCallback = 0;
    private static final int JOB_ID = 331122;
    private static char TopicBuilder;
    private static int artificialFrame;
    private static char extraCallbackWithResult;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static char onMessageChannelReady;
    private static final byte[] $$c = {70, -123, Ascii.CR, 112};
    private static final int $$f = 42;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r7, byte r8, int r9) {
        /*
            int r9 = r9 + 4
            byte[] r0 = com.salesforce.marketingcloud.sfmcsdk.SFMCSdkJobIntentService.$$c
            int r8 = r8 * 3
            int r8 = r8 + 1
            int r7 = r7 * 2
            int r7 = 110 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r7 = r9
            r4 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r6
        L2a:
            int r3 = -r3
            int r9 = r9 + r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkJobIntentService.$$g(byte, byte, int):java.lang.String");
    }

    static {
        byte[] bArr = new byte[708];
        System.arraycopy("Co\u0019\u0013\fÍJ\u0005\u000bÂE\nÿ\u0002\u0006\t\u000fÊ<\u0013\núÐL\u0004\u0000Ì\u001c=ñ\u0010\u0004\u0001æ:ø\u0007\u0006\u0014é%ö\t\u000f\u0001\u0014\u0007D\u0013\u0005È@\u000f\u0007ÿ\f\u0000Ð<\u0016\u000eþ\u000b\u0002ÆMü\f\u0004Ê:\u000b\u0003\nÑ\u001a+\u0015Ù#\u001eÚ!\u001b²\u0014\nüÎC\fü\u0004ÔMü\u000bÿÐ\u001d$\u001aøö\u001c\u000bÿ÷&ü\n\u000e¸2\u001e\u0007\u0014ù\u0016à#\n\u0007\u0004\u0011ä)\u0004\u000eú\u0002\b\u00143\n\u0004\r\u0006ü\fþæ(\u0004\u001aù\u0007\t\f\u0000ë0\u0013\u0005ÈM\u0005ö\u0014\fý\u0011\b\u0002\n\b\u0003þ\u0015ÁE\nû\u0005\u001aü\r\u0006\u0006û\u0014ú\r\u0005\u0014ÃE\nÿ\u0007\u0005\u0014Ã-\u0006\u0007\u0005\u0002$\u0012øã6\u0007ü\u0010ý\b\u0014¹F\u0003\u0004\u0013\u0007\u0003Ê\u0002B\f\rø\u0014\u0003ú\u0012ÉI\u0003ü\u001aù\u0010\n\u0002È:\u0014ý\u0015\u0004\u0001\u0002Ñ\u001d(\b\u0006\u0014\u0007ú\u0006ö#û\u000f\u0001\u0016Ô*\u0004\u0016\u000bø\u0014\u0013\u0005È@\u000f\u0007ÿ\f\u0000Ð:\u0014ý\u0015\u0004\u0001\u0002ÑFû\u001aø\u0014þÿ\u0012É<\u0013\u0004\n\nÃN\u0006ü\n\u0004\u0012ü\u0003\u0015Â\u001d<üú\u0013\u0003\u0001ç3\u0004\n\n¹\u0007(:\u0003ø\u0014\u0003ú\u0012î-ü\rû\u0004\u0016ü\u0001ð\u001c\u0013ü\t\u0004Ö\u0013\u0005È@\u000f\u0007ÿ\f\u0000Ð<\u0016\u000eþ\u000b\u0002ÆMü\f\u0004ÊI\t\u0004\f\u0002Æ\u001e%\b\u0016õù\u001d\u0005\u000eú\u001a\b\u0004úç0ü\u0013ü\f\f\u0000Ä\u0014\u0013\u0005È?\u0002\t\t\u0004\u0014\u0007\u0003ÊKú\u0003\t\u0018ÁNû\u000bû\u0014ú\r\u0005\u0014Ã2\u001dÿ\u0001ô(ü\bò&\u0007\u0004¿\u0007(:\u0003ø\u0014\u0003ú\u0012î-ü\rû\u0004\u0016ü\u0001ð\u001c\u0013ü\t\u0004Ö\u0013\u0005È@\u000f\u0007ÿ\f\u0000Ð<\u0013\u0005\u0007\t\u0006Ç<\u0013\u0004\u0007\u0000\u0005\u0018Á&/þ\u000fü\u000bû\u0016Ù:û\nÿ\b\u0014¹\u0017\t\u0007\t\u0015\u0007õ\u0018\tü\u0004\n\u0001\rÿ\u0012á3ö\u0013ÿ\u0013\u0005È@\u000f\u0007ÿ\f\u0000Ð:\u0016\u0000Ì*+\u0001\fôö)\u0004\f\u0002\u0013\u0005ÈLü\u000e\b\u0000\u0004\u001a¼Kú\u0003\t\u0018\u0001ú\u001aü\u0014öÐLÿ\u0005ÿÔ/\u001a\u0003\u0019ã\u0017\u0016ú\u0007\u0010\fü\u000e\fæ\u0019\u0014\u000bú\u0001\t\u0013\u0005ÈA\b\u0012ô\t\f\bÿ\u0016\u0007Å>\u001aò\t\u0012\u000bü\r\u0006\fÂ&3Ñ-\u0001\t\u0014\u0004Ý:ò\t\u0012\u000bü\r\u0006\u0013\u0005ÈE\u0000\u0003\u0018\u0003\u0002\u0013ÿÈ+\u0003ý(\u0018ú\u0001\të,ÿ\u0010Æ+\u0003\u0002,\f\bô\u0012\u0007í\u001a\b\u0006\u0014\u0007ú\u0014Ø0\u0004\u0003\u0010\rÀ#ÿ\u0013\n\u0004\r\u0006ü\fþå6ú\u0003\u001aü\r\u0006".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 708);
        $$d = bArr;
        $$e = 167;
        $$a = new byte[]{0, -128, -114, 48, -33, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC};
        $$b = 167;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        Companion = new Companion(null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r0 = r7 + 8
            int r6 = 112 - r6
            int r8 = 112 - r8
            byte[] r1 = com.salesforce.marketingcloud.sfmcsdk.SFMCSdkJobIntentService.$$a
            byte[] r0 = new byte[r0]
            int r7 = r7 + 7
            r2 = 0
            if (r1 != 0) goto L13
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2b
        L13:
            r3 = r2
        L14:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2b:
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkJobIntentService.a(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 692 - r8
            byte[] r0 = com.salesforce.marketingcloud.sfmcsdk.SFMCSdkJobIntentService.$$d
            int r1 = 82 - r7
            int r6 = 111 - r6
            byte[] r1 = new byte[r1]
            int r7 = 81 - r7
            r2 = 0
            if (r0 != 0) goto L13
            r6 = r7
            r3 = r8
            r4 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L28:
            int r6 = r6 + r8
            int r8 = r3 + 1
            int r6 = r6 + (-7)
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkJobIntentService.c(byte, byte, int, java.lang.Object[]):void");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void enqueueSystemBehavior(@NotNull Context context, @NotNull BehaviorType behaviorType, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(behaviorType, "behaviorType");
            Bundle bundle2 = new Bundle();
            bundle2.putString(SFMCSdkJobIntentService.EXTRA_BEHAVIOR, behaviorType.getIntentFilter$sfmcsdk_release());
            bundle2.putBundle("data", bundle);
            JobIntentService.enqueueWork(context, (Class<?>) SFMCSdkJobIntentService.class, SFMCSdkJobIntentService.JOB_ID, new Intent(SFMCSdkJobIntentService.ACTION_SYSTEM_BEHAVIOR).putExtras(bundle2));
        }
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Bundle bundleExtra;
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        Context applicationContext = getApplicationContext();
        if (!Intrinsics.areEqual(action, ACTION_SYSTEM_BEHAVIOR) || (bundleExtra = intent.getBundleExtra("data")) == null) {
            return;
        }
        Intrinsics.checkNotNull(applicationContext);
        handleSystemBehavior(applicationContext, BehaviorType.Companion.fromString(intent.getStringExtra(EXTRA_BEHAVIOR)), bundleExtra);
    }

    private final void handleSystemBehavior(Context context, BehaviorType behaviorType, Bundle bundle) {
        if (behaviorType != null) {
            BehaviorManagerImpl.Companion.notifyBehavior$sfmcsdk_release(context, behaviorType, bundle);
        }
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i5 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[i5] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i6 = 58224;
            int i7 = i5;
            while (i7 < 16) {
                int i8 = $10 + 81;
                $11 = i8 % 128;
                int i9 = i8 % i3;
                char c = cArr3[1];
                char c2 = cArr3[i5];
                int i10 = (c2 + i6) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                int i11 = c2 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(onMessageChannelReady);
                    objArr2[i3] = Integer.valueOf(i11);
                    objArr2[1] = Integer.valueOf(i10);
                    objArr2[i5] = Integer.valueOf(c);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 28;
                        char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 17264);
                        int iGreen = Color.green(i5) + 1067;
                        byte b = (byte) 1;
                        byte b2 = (byte) (b - 1);
                        String str$$g = $$g(b, b2, (byte) (b2 - 1));
                        Class[] clsArr = new Class[4];
                        clsArr[i5] = Integer.TYPE;
                        clsArr[1] = Integer.TYPE;
                        clsArr[2] = Integer.TYPE;
                        clsArr[3] = Integer.TYPE;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, modifierMetaStateMask, iGreen, 1042277788, false, str$$g, clsArr);
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    char[] cArr4 = cArr3;
                    Object[] objArr3 = {Integer.valueOf(cArr3[i5]), Integer.valueOf((cCharValue + i6) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 1;
                        byte b4 = (byte) (b3 - 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(28 - (ViewConfiguration.getTouchSlop() >> 8), (char) (17263 - (Process.myTid() >> 22)), TextUtils.indexOf("", "") + 1067, 1042277788, false, $$g(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i6 -= 40503;
                    i7++;
                    int i12 = $10 + 21;
                    $11 = i12 % 128;
                    if (i12 % 2 == 0) {
                        int i13 = 3 / 2;
                    }
                    cArr3 = cArr4;
                    i3 = 2;
                    i5 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr5 = cArr3;
            cArr2[buildVar.c] = cArr5[0];
            cArr2[buildVar.c + 1] = cArr5[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 26;
                char cGreen = (char) (Color.green(0) + 63928);
                int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 486;
                byte b5 = (byte) 0;
                byte b6 = b5;
                String str$$g2 = $$g(b5, b6, (byte) (b6 - 1));
                i2 = 2;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionChild, cGreen, threadPriority, 1554985764, false, str$$g2, new Class[]{Object.class, Object.class});
            } else {
                i2 = 2;
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            i3 = i2;
            cArr3 = cArr5;
            i5 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x018a  */
    /* JADX WARN: Code duplicated, block: B:16:0x020c A[Catch: all -> 0x09dd, TryCatch #2 {all -> 0x09dd, blocks: (B:51:0x06c0, B:53:0x06e0, B:54:0x0732, B:14:0x01f8, B:16:0x020c, B:17:0x023c), top: B:95:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0252  */
    /* JADX WARN: Code duplicated, block: B:25:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:50:0x065b  */
    /* JADX WARN: Code duplicated, block: B:53:0x06e0 A[Catch: all -> 0x09dd, TryCatch #2 {all -> 0x09dd, blocks: (B:51:0x06c0, B:53:0x06e0, B:54:0x0732, B:14:0x01f8, B:16:0x020c, B:17:0x023c), top: B:95:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0743  */
    /* JADX WARN: Code duplicated, block: B:62:0x0817  */
    @Override // androidx.core.app.JobIntentService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrCoroutineCreation$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int capsMode = 26 - TextUtils.getCapsMode("", 0, 0);
            char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
            int mode = 1041 - View.MeasureSpec.getMode(0);
            byte[] bArr = $$a;
            Object[] objArr2 = new Object[1];
            a(bArr[0], bArr[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(capsMode, cKeyCodeFromString, mode, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
            artificialFrame = i2 % 128;
            int i3 = i2 % 2;
            long j2 = j + 4611686018427387780L;
            Object[] objArr3 = new Object[1];
            b(Color.rgb(0, 0, 0) + 16777238, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 63723, 59300, 59457, 5588, 39470, 6317, 45689, 51976, 18322, 45279, 48186, 62113, 35945, 13036}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{43966, 38028, 47352, 63238, 54055, 52968, 35760, 48971, 45744, 20713, 40830, 7668, 25090, 31124, 42625, 49402}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                artificialFrame = i4 % 128;
                int i5 = i4 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int i6 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25;
                    char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int i7 = 1041 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    byte[] bArr2 = $$a;
                    Object[] objArr5 = new Object[1];
                    a(bArr2[0], bArr2[22], (byte) 100, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i6, cIndexOf, i7, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrCoroutineCreation$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i8 = ((int[]) objArr6[3])[0];
                int i9 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i10 = (((-1100914803) + (((~(iIdentityHashCode | (-222632041))) | 300735847) * 191)) + (((~((~iIdentityHashCode) | (-222632041))) | 21239904) * 191)) - 1305888973;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArrCoroutineCreation$78cbbd35[1])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(15 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{53232, 21571, 43095, 63672, 41918, 50461, 11981, 6218, 53990, 933, 35940, 56182, 57296, 41005, 12717, 14246}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{52291, 27654, 63399, 25952, 55538, 11500, 54569, 47137, 7857, 40573, 54717, 12844, 44514, 18458, 43192, 668}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-1271257757};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 22250), 1033 - Color.green(0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrCoroutineCreation$78cbbd35 = b.coroutineCreation$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -1305888973, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                        char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                        int mirror = 1089 - AndroidCharacter.getMirror('0');
                        byte[] bArr3 = $$a;
                        Object[] objArr10 = new Object[1];
                        a(bArr3[0], bArr3[22], (byte) 100, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cIndexOf2, mirror, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrCoroutineCreation$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 22, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 63723, 59300, 59457, 5588, 39470, 6317, 45689, 51976, 18322, 45279, 48186, 62113, 35945, 13036}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{43966, 38028, 47352, 63238, 54055, 52968, 35760, 48971, 45744, 20713, 40830, 7668, 25090, 31124, 42625, 49402}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int keyRepeatTimeout = 26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                            char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                            int iRed = Color.red(0) + 1041;
                            byte[] bArr4 = $$a;
                            Object[] objArr13 = new Object[1];
                            a(bArr4[0], bArr4[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, fadingEdgeLength, iRed, 2061780482, false, (String) objArr13[0], null);
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
            Object[] objArr14 = new Object[1];
            b(15 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{53232, 21571, 43095, 63672, 41918, 50461, 11981, 6218, 53990, 933, 35940, 56182, 57296, 41005, 12717, 14246}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{52291, 27654, 63399, 25952, 55538, 11500, 54569, 47137, 7857, 40573, 54717, 12844, 44514, 18458, 43192, 668}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-1271257757};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 22250), 1033 - Color.green(0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrCoroutineCreation$78cbbd35 = b.coroutineCreation$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -1305888973, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                char cIndexOf3 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int mirror2 = 1089 - AndroidCharacter.getMirror('0');
                byte[] bArr5 = $$a;
                Object[] objArr17 = new Object[1];
                a(bArr5[0], bArr5[22], (byte) 100, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, cIndexOf3, mirror2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrCoroutineCreation$78cbbd35);
            Object[] objArr18 = new Object[1];
            b((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 22, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 63723, 59300, 59457, 5588, 39470, 6317, 45689, 51976, 18322, 45279, 48186, 62113, 35945, 13036}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{43966, 38028, 47352, 63238, 54055, 52968, 35760, 48971, 45744, 20713, 40830, 7668, 25090, 31124, 42625, 49402}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int keyRepeatTimeout2 = 26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                char fadingEdgeLength2 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                int iRed2 = Color.red(0) + 1041;
                byte[] bArr6 = $$a;
                Object[] objArr110 = new Object[1];
                a(bArr6[0], bArr6[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, fadingEdgeLength2, iRed2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
        int i14 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
        if (i14 == i13) {
            int i15 = artificialFrame + 73;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
            int i16 = i15 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i17 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
            int i18 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
            int i19 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            int iNextInt = new Random().nextInt(105863150);
            int i20 = ~(520899537 | iNextInt);
            int i21 = i17 + 1438406907 + (((-527224788) | i20) * (-814)) + ((i20 | (~((~iNextInt) | 442795730)) | 436470480) * 407) + (((~(iNextInt | (-442795731))) | (~((-520899538) | iNextInt)) | 436470480) * 407);
            int i22 = (i21 << 13) ^ i21;
            int i23 = i22 ^ (i22 >>> 17);
            ((int[]) objArr20[1])[0] = i23 ^ (i23 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 1270622201) << 32) ^ ((long) (i13 ^ i14))), Long.valueOf(1270622203)};
                byte[] bArr7 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr7[4], (byte) (-bArr7[78]), (short) 688, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b = bArr7[410];
                Object[] objArr23 = new Object[1];
                c(b, (byte) (b + 4), (short) 646, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i24 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
                int i25 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
                int i26 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrCoroutineCreation$78cbbd35[0];
                int iNextInt2 = new Random().nextInt(824681438);
                int i27 = i24 + (-1097905488) + (((~((-974955645) | iNextInt2)) | 168304640) * 345) + (((~((-974955645) | (~iNextInt2))) | (-1065156478)) * 345) + ((~(iNextInt2 | (-168304641))) * 345);
                int i28 = (i27 << 13) ^ i27;
                int i29 = i28 ^ (i28 >>> 17);
                ((int[]) objArr24[1])[0] = i29 ^ (i29 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 25;
            char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0', 0, 0));
            int fadingEdgeLength3 = 816 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            byte[] bArr8 = $$a;
            Object[] objArr25 = new Object[1];
            a(bArr8[0], bArr8[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, cLastIndexOf, fadingEdgeLength3, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i30 = artificialFrame + 57;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
            int i31 = i30 % 2;
            long j4 = j3 + 2050;
            Object[] objArr26 = new Object[1];
            b((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 22, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 63723, 59300, 59457, 5588, 39470, 6317, 45689, 51976, 18322, 45279, 48186, 62113, 35945, 13036}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{43966, 38028, 47352, 63238, 54055, 52968, 35760, 48971, 45744, 20713, 40830, 7668, 25090, 31124, 42625, 49402}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int i32 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    char windowTouchSlop = (char) (30068 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 817;
                    byte[] bArr9 = $$a;
                    Object[] objArr28 = new Object[1];
                    a(bArr9[0], bArr9[22], (byte) 100, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i32, windowTouchSlop, iLastIndexOf, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i33 = ((int[]) objArr29[0])[0];
                int i34 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) + 958386318;
                int i35 = (-1503805571) + (((~((-2081539) | iCodePointAt)) | 1049346 | (~((-196090828) | iCodePointAt))) * (-880));
                int i36 = (~((-2081539) | (~iCodePointAt))) | 196090827;
                int i37 = ~(iCodePointAt | 2081538);
                int i38 = ((i35 + ((i36 | i37) * (-880))) + (i37 * 880)) - 1153800692;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArr[3])[0] = i40 ^ (i40 << 5);
                int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                artificialFrame = i41 % 128;
                int i42 = i41 % 2;
            } else {
                Object[] objArr30 = new Object[1];
                b(ImageFormat.getBitsPerPixel(0) + 17, new char[]{53232, 21571, 43095, 63672, 41918, 50461, 11981, 6218, 53990, 933, 35940, 56182, 57296, 41005, 12717, 14246}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 92, new char[]{52291, 27654, 63399, 25952, 55538, 11500, 54569, 47137, 7857, 40573, 54717, 12844, 44514, 18458, 43192, 668}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1153800692};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                    char c = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    int iResolveSize = View.resolveSize(0, 0) + 816;
                    byte[] bArr10 = $$a;
                    byte b2 = (byte) (bArr10[77] - 1);
                    byte b3 = bArr10[36];
                    Object[] objArr33 = new Object[1];
                    a(b2, b3, (byte) (b3 | 88), objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, c, iResolveSize, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr34 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i43 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24;
                    char cRgb = (char) ((-16747148) - Color.rgb(0, 0, 0));
                    int trimmedLength = 816 - TextUtils.getTrimmedLength("");
                    byte[] bArr11 = $$a;
                    Object[] objArr35 = new Object[1];
                    a(bArr11[0], bArr11[22], (byte) 100, objArr35);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i43, cRgb, trimmedLength, 891606461, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr34);
                try {
                    Object[] objArr36 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 63723, 59300, 59457, 5588, 39470, 6317, 45689, 51976, 18322, 45279, 48186, 62113, 35945, 13036}, objArr36);
                    Class<?> cls9 = Class.forName((String) objArr36[0]);
                    Object[] objArr37 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 34, new char[]{43966, 38028, 47352, 63238, 54055, 52968, 35760, 48971, 45744, 20713, 40830, 7668, 25090, 31124, 42625, 49402}, objArr37);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr37[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 25;
                        char jumpTapTimeout = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                        int i44 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        byte[] bArr12 = $$a;
                        Object[] objArr38 = new Object[1];
                        a(bArr12[0], bArr12[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr38);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf, jumpTapTimeout, i44, 721586079, false, (String) objArr38[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr = objArr34;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr39 = new Object[1];
            b(ImageFormat.getBitsPerPixel(0) + 17, new char[]{53232, 21571, 43095, 63672, 41918, 50461, 11981, 6218, 53990, 933, 35940, 56182, 57296, 41005, 12717, 14246}, objArr39);
            Class<?> cls10 = Class.forName((String) objArr39[0]);
            Object[] objArr310 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 92, new char[]{52291, 27654, 63399, 25952, 55538, 11500, 54569, 47137, 7857, 40573, 54717, 12844, 44514, 18458, 43192, 668}, objArr310);
            Object[] objArr311 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr310[0], Object.class).invoke(null, this)).intValue()), 0, -1153800692};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                char c2 = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int iResolveSize2 = View.resolveSize(0, 0) + 816;
                byte[] bArr13 = $$a;
                byte b4 = (byte) (bArr13[77] - 1);
                byte b5 = bArr13[36];
                Object[] objArr312 = new Object[1];
                a(b4, b5, (byte) (b5 | 88), objArr312);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, c2, iResolveSize2, -797394565, false, (String) objArr312[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr313 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr311);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i45 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24;
                char cRgb2 = (char) ((-16747148) - Color.rgb(0, 0, 0));
                int trimmedLength2 = 816 - TextUtils.getTrimmedLength("");
                byte[] bArr14 = $$a;
                Object[] objArr314 = new Object[1];
                a(bArr14[0], bArr14[22], (byte) 100, objArr314);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i45, cRgb2, trimmedLength2, 891606461, false, (String) objArr314[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr313);
            Object[] objArr315 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 63723, 59300, 59457, 5588, 39470, 6317, 45689, 51976, 18322, 45279, 48186, 62113, 35945, 13036}, objArr315);
            Class<?> cls11 = Class.forName((String) objArr315[0]);
            Object[] objArr316 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 34, new char[]{43966, 38028, 47352, 63238, 54055, 52968, 35760, 48971, 45744, 20713, 40830, 7668, 25090, 31124, 42625, 49402}, objArr316);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr316[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iIndexOf2 = TextUtils.indexOf("", "", 0, 0) + 25;
                char jumpTapTimeout2 = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                int i46 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr15 = $$a;
                Object[] objArr317 = new Object[1];
                a(bArr15[0], bArr15[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr317);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf2, jumpTapTimeout2, i46, 721586079, false, (String) objArr317[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr = objArr313;
        }
        int i47 = ((int[]) objArr[1])[0];
        int i48 = ((int[]) objArr[0])[0];
        if (i48 == i47) {
            int i49 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
            artificialFrame = i49 % 128;
            int i50 = i49 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i51 = ((int[]) objArr[3])[0];
            int i52 = ((int[]) objArr[0])[0];
            int i53 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i54 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i55 = i51 + (-2142914385) + (((~i54) | 202383374) * 1324) + (((~(i54 | (-290049521))) | (~(488221886 | i54))) * (-1324)) + 673471926;
            int i56 = (i55 << 13) ^ i55;
            int i57 = i56 ^ (i56 >>> 17);
            ((int[]) objArr40[3])[0] = i57 ^ (i57 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i47 ^ i48)) ^ (((long) 1460851049) << 32)), Long.valueOf(1460851048)};
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr16[4], bArr16[76], (short) 644, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b6 = bArr16[410];
        Object[] objArr43 = new Object[1];
        c(b6, (byte) (b6 + 4), (short) 646, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i58 = ((int[]) objArr[3])[0];
        int i59 = ((int[]) objArr[0])[0];
        int i60 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i61 = (int) Runtime.getRuntime().totalMemory();
        int i62 = i58 + 1952139404 + (((~((~i61) | 499174408)) | 3154226) * 529) + (((~(i61 | 499174408)) | 301002042) * 529);
        int i63 = (i62 << 13) ^ i62;
        int i64 = i63 ^ (i63 >>> 17);
        ((int[]) objArr44[3])[0] = i64 ^ (i64 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0abd  */
    /* JADX WARN: Code duplicated, block: B:106:0x0afe A[Catch: all -> 0x24fd, TryCatch #8 {all -> 0x24fd, blocks: (B:231:0x189c, B:233:0x18a2, B:234:0x18ce, B:236:0x18f9, B:237:0x1997, B:104:0x0adb, B:106:0x0afe, B:107:0x0b56, B:65:0x06df, B:67:0x06f4, B:68:0x0726, B:40:0x03eb, B:42:0x03f8, B:43:0x042b, B:45:0x0435, B:47:0x0442, B:48:0x0478), top: B:380:0x03eb }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0b69  */
    /* JADX WARN: Code duplicated, block: B:115:0x0bcf  */
    /* JADX WARN: Code duplicated, block: B:116:0x0c16  */
    /* JADX WARN: Code duplicated, block: B:214:0x1604  */
    /* JADX WARN: Code duplicated, block: B:215:0x1695  */
    /* JADX WARN: Code duplicated, block: B:220:0x1770  */
    /* JADX WARN: Code duplicated, block: B:230:0x1898  */
    /* JADX WARN: Code duplicated, block: B:233:0x18a2 A[Catch: all -> 0x24fd, TryCatch #8 {all -> 0x24fd, blocks: (B:231:0x189c, B:233:0x18a2, B:234:0x18ce, B:236:0x18f9, B:237:0x1997, B:104:0x0adb, B:106:0x0afe, B:107:0x0b56, B:65:0x06df, B:67:0x06f4, B:68:0x0726, B:40:0x03eb, B:42:0x03f8, B:43:0x042b, B:45:0x0435, B:47:0x0442, B:48:0x0478), top: B:380:0x03eb }] */
    /* JADX WARN: Code duplicated, block: B:236:0x18f9 A[Catch: all -> 0x24fd, TryCatch #8 {all -> 0x24fd, blocks: (B:231:0x189c, B:233:0x18a2, B:234:0x18ce, B:236:0x18f9, B:237:0x1997, B:104:0x0adb, B:106:0x0afe, B:107:0x0b56, B:65:0x06df, B:67:0x06f4, B:68:0x0726, B:40:0x03eb, B:42:0x03f8, B:43:0x042b, B:45:0x0435, B:47:0x0442, B:48:0x0478), top: B:380:0x03eb }] */
    /* JADX WARN: Code duplicated, block: B:240:0x19aa  */
    /* JADX WARN: Code duplicated, block: B:245:0x1a11  */
    /* JADX WARN: Code duplicated, block: B:246:0x1a57  */
    /* JADX WARN: Code duplicated, block: B:250:0x1a75  */
    /* JADX WARN: Code duplicated, block: B:251:0x1ae7  */
    /* JADX WARN: Code duplicated, block: B:256:0x1bc7  */
    /* JADX WARN: Code duplicated, block: B:259:0x1c12  */
    /* JADX WARN: Code duplicated, block: B:261:0x1c30  */
    /* JADX WARN: Code duplicated, block: B:263:0x1c39  */
    /* JADX WARN: Code duplicated, block: B:265:0x1cec  */
    /* JADX WARN: Code duplicated, block: B:266:0x1cee  */
    /* JADX WARN: Code duplicated, block: B:269:0x1cf5  */
    /* JADX WARN: Code duplicated, block: B:271:0x1d73  */
    /* JADX WARN: Code duplicated, block: B:277:0x1d8d  */
    /* JADX WARN: Code duplicated, block: B:282:0x1eb9  */
    /* JADX WARN: Code duplicated, block: B:284:0x1ec2  */
    /* JADX WARN: Code duplicated, block: B:289:0x1f2b  */
    /* JADX WARN: Code duplicated, block: B:290:0x1f70  */
    /* JADX WARN: Code duplicated, block: B:294:0x1f7f  */
    /* JADX WARN: Code duplicated, block: B:298:0x1f93  */
    /* JADX WARN: Code duplicated, block: B:299:0x201d  */
    /* JADX WARN: Code duplicated, block: B:301:0x2029  */
    /* JADX WARN: Code duplicated, block: B:304:0x202d A[LOOP:0: B:302:0x202a->B:304:0x202d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:310:0x210e  */
    /* JADX WARN: Code duplicated, block: B:313:0x2164  */
    /* JADX WARN: Code duplicated, block: B:320:0x2244  */
    /* JADX WARN: Code duplicated, block: B:324:0x22ce  */
    /* JADX WARN: Code duplicated, block: B:329:0x2338  */
    /* JADX WARN: Code duplicated, block: B:333:0x2390  */
    /* JADX WARN: Code duplicated, block: B:334:0x2407  */
    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        int i;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object[] objArr3;
        Object[] objArr4;
        int i2;
        int i3;
        Object[] objArr5;
        int i4;
        int i5;
        Object objAccessartificialFrame4;
        long j;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        Object objAccessartificialFrame8;
        Object[] objArr6;
        Object obj;
        int i6;
        Object obj2;
        int i7;
        Object objAccessartificialFrame9;
        long j2;
        int i8;
        Context baseContext;
        Object[] objArr7;
        Object[] objArr8;
        int i9;
        Object objAccessartificialFrame10;
        Object objAccessartificialFrame11;
        int i10;
        int i11;
        ArrayList arrayList;
        String[] strArr;
        int i12;
        Object objAccessartificialFrame12;
        long j3;
        Object[] objArr9;
        Object objAccessartificialFrame13;
        Object objAccessartificialFrame14;
        int i13;
        int i14;
        Object objAccessartificialFrame15;
        int i15 = 2 % 2;
        int i16 = artificialFrame + 17;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
        int i17 = i16 % 2;
        Object[] objArr10 = new Object[1];
        b(22 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 63723, 59300, 59457, 5588, 39470, 6317, 45689, 51976, 18322, 45279, 48186, 62113, 35945, 13036}, objArr10);
        String str = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(15 - KeyEvent.keyCodeFromString(""), new char[]{43966, 38028, 47352, 63238, 54055, 52968, 35760, 48971, 45744, 20713, 40830, 7668, 25090, 31124, 42625, 49402}, objArr11);
        String str2 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new char[]{53232, 21571, 43095, 63672, 41918, 50461, 11981, 6218, 53990, 933, 35940, 56182, 57296, 41005, 12717, 14246}, objArr12);
        String str3 = (String) objArr12[0];
        Object[] objArr13 = new Object[1];
        b(16 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{52291, 27654, 63399, 25952, 55538, 11500, 54569, 47137, 7857, 40573, 54717, 12844, 44514, 18458, 43192, 668}, objArr13);
        String str4 = (String) objArr13[0];
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame16 == null) {
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 18;
            char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
            int mirror = AndroidCharacter.getMirror('0') + 699;
            byte[] bArr = $$a;
            Object[] objArr14 = new Object[1];
            a(bArr[0], bArr[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr14);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iIndexOf, cCombineMeasuredStates, mirror, -144068856, false, (String) objArr14[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j4 == -1 || j4 + 4611686018427387877L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr15 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 47352, 63238, 20190, 30508, 31185, 20210, 55538, 11500, 13132, 42978, 54569, 47137, 21478, 61515, 14564, 4743, 36081, 53335}, objArr15);
                Class<?> cls = Class.forName((String) objArr15[0]);
                Object[] objArr16 = new Object[1];
                b(18 - KeyEvent.normalizeMetaState(0), new char[]{45077, 16454, 51019, 774, 63399, 25952, 15996, 4606, 49194, 17505, 28951, 41441, 6549, 14158, 55538, 11500, 19877, 655}, objArr16);
                baseContext2 = (Context) cls.getMethod((String) objArr16[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            try {
                Object[] objArr17 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1968615613};
                byte[] bArr2 = $$d;
                byte b = bArr2[25];
                Object[] objArr18 = new Object[1];
                c(b, (byte) (b | 34), (short) TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, objArr18);
                Class<?> cls2 = Class.forName((String) objArr18[0]);
                Object[] objArr19 = new Object[1];
                c(bArr2[662], bArr2[613], (short) 559, objArr19);
                objArr = (Object[]) cls2.getMethod((String) objArr19[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr17);
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame17 == null) {
                    int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 17;
                    char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int mode = 747 - View.MeasureSpec.getMode(0);
                    byte[] bArr3 = $$a;
                    Object[] objArr20 = new Object[1];
                    a(bArr3[0], bArr3[22], (byte) 100, objArr20);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, doubleTapTimeout, mode, -1031537386, false, (String) objArr20[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame18 == null) {
                        int mirror2 = 'A' - AndroidCharacter.getMirror('0');
                        char modifierMetaStateMask = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                        int i18 = 748 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        byte[] bArr4 = $$a;
                        Object[] objArr21 = new Object[1];
                        a(bArr4[0], bArr4[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr21);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(mirror2, modifierMetaStateMask, i18, -144068856, false, (String) objArr21[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf);
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
        } else {
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame19 == null) {
                int iMyPid = 17 - (Process.myPid() >> 22);
                char c = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 747;
                byte[] bArr5 = $$a;
                Object[] objArr22 = new Object[1];
                a(bArr5[0], bArr5[22], (byte) 100, objArr22);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iMyPid, c, iResolveOpacity, -1031537386, false, (String) objArr22[0], null);
            }
            Object[] objArr23 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i19 = ((int[]) objArr23[3])[0];
            int i20 = ((int[]) objArr23[4])[0];
            List list = (List) objArr23[0];
            List list2 = (List) objArr23[2];
            int iMyTid = Process.myTid();
            int i21 = ~iMyTid;
            int i22 = ((((-1324744198) + ((~((-529645488) | i21)) * 979)) + ((iMyTid | 75802970) * (-979))) + (((~(iMyTid | (-529645488))) | (~(i21 | 75802970))) * 979)) - 1968615613;
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr[1])[0] = i24 ^ (i24 << 5);
        }
        int i25 = ((int[]) objArr[4])[0];
        int i26 = ((int[]) objArr[3])[0];
        if (i26 == i25) {
            Object[] objArr24 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i27 = ((int[]) objArr[1])[0];
            int i28 = ((int[]) objArr[3])[0];
            int i29 = ((int[]) objArr[4])[0];
            List list3 = (List) objArr[0];
            List list4 = (List) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i30 = i27 + 574742169 + (((~((-539179883) | iIdentityHashCode)) | 2304266) * 1504) + ((~(iIdentityHashCode | (-536875617))) * (-1504)) + 860057520;
            int i31 = i30 ^ (i30 << 13);
            int i32 = i31 ^ (i31 >>> 17);
            ((int[]) objArr24[1])[0] = i32 ^ (i32 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            try {
                Object[] objArr25 = {objArr};
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame20 == null) {
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (TextUtils.indexOf("", "") + 12468), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 3641, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList2.add(((Method) objAccessartificialFrame20).invoke(null, objArr25));
                Object[] objArr26 = {objArr};
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame21 == null) {
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 42, (char) (12468 - ExpandableListView.getPackedPositionGroup(0L)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 3641, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList2.add(((Method) objAccessartificialFrame21).invoke(null, objArr26));
                try {
                    Object[] objArr27 = {Long.valueOf(((long) (i25 ^ i26)) ^ (((long) 1877262564) << 32)), Long.valueOf(1877262572)};
                    byte[] bArr6 = $$d;
                    Object[] objArr28 = new Object[1];
                    c(bArr6[4], bArr6[59], (short) 540, objArr28);
                    Class<?> cls3 = Class.forName((String) objArr28[0]);
                    byte b2 = bArr6[410];
                    Object[] objArr29 = new Object[1];
                    c(b2, (byte) (b2 + 4), (short) 646, objArr29);
                    cls3.getMethod((String) objArr29[0], Long.TYPE, Long.TYPE).invoke(null, objArr27);
                    Object[] objArr30 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i33 = ((int[]) objArr[1])[0];
                    int i34 = ((int[]) objArr[3])[0];
                    int i35 = ((int[]) objArr[4])[0];
                    List list5 = (List) objArr[0];
                    List list6 = (List) objArr[2];
                    int iIdentityHashCode2 = System.identityHashCode(this);
                    int i36 = ~iIdentityHashCode2;
                    int i37 = ~((-627257076) | i36);
                    int i38 = ~(21808617 | iIdentityHashCode2);
                    int i39 = i33 + 364936658 + ((i37 | i38) * 1150) + (((~((-21808618) | i36)) | i38) * (-575)) + (((~(iIdentityHashCode2 | (-627257076))) | (~(i36 | 627257075))) * 575);
                    int i40 = (i39 << 13) ^ i39;
                    int i41 = i40 ^ (i40 >>> 17);
                    ((int[]) objArr30[1])[0] = i41 ^ (i41 << 5);
                    int i42 = getARTIFICIAL_FRAME_PACKAGE_NAME + 79;
                    artificialFrame = i42 % 128;
                    int i43 = i42 % 2;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame22 == null) {
            int i44 = 26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
            char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
            int iResolveSize = 1041 - View.resolveSize(0, 0);
            byte[] bArr7 = $$a;
            Object[] objArr31 = new Object[1];
            a(bArr7[0], bArr7[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr31);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i44, offsetAfter, iResolveSize, 2061780482, false, (String) objArr31[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j5 == -1 || j5 + 4611686018427387878L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr32 = {-613693983};
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame23 == null) {
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 8, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 22252), View.combineMeasuredStates(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame23).newInstance(objArr32), 1501540710, false);
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame24 == null) {
                int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 26;
                char cRed = (char) Color.red(0);
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 1041;
                byte[] bArr8 = $$a;
                Object[] objArr33 = new Object[1];
                a(bArr8[0], bArr8[22], (byte) 100, objArr33);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(edgeSlop, cRed, iResolveOpacity2, 1145017376, false, (String) objArr33[0], null);
            }
            ((Field) objAccessartificialFrame24).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame25 == null) {
                    int iIndexOf2 = 26 - TextUtils.indexOf("", "", 0, 0);
                    char maximumDrawingCacheSize = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    int iIndexOf3 = 1041 - TextUtils.indexOf("", "", 0);
                    byte[] bArr9 = $$a;
                    Object[] objArr34 = new Object[1];
                    a(bArr9[0], bArr9[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr34);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iIndexOf2, maximumDrawingCacheSize, iIndexOf3, 2061780482, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, lValueOf2);
                objArr2 = objArrAccessartificialFrame$78cbbd35;
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame26 == null) {
                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 26;
                char c2 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 1042;
                byte[] bArr10 = $$a;
                Object[] objArr35 = new Object[1];
                a(bArr10[0], bArr10[22], (byte) 100, objArr35);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(absoluteGravity, c2, bitsPerPixel, 1145017376, false, (String) objArr35[0], null);
            }
            Object[] objArr36 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
            objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i45 = ((int[]) objArr36[3])[0];
            int i46 = ((int[]) objArr36[2])[0];
            String[] strArr2 = (String[]) objArr36[0];
            int i47 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i48 = ~i47;
            int i49 = (~(827431195 | i48)) | (-905568028) | (~(905535002 | i48));
            int i50 = (-169736566) + (((~(i47 | (-827398171))) | i49) * 590) + (i49 * (-1180)) + (((~((-905535003) | i48)) | (~(i48 | (-827431196)))) * 590) + 1501540710;
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr2[1])[0] = i52 ^ (i52 << 5);
        }
        int i53 = ((int[]) objArr2[2])[0];
        int i54 = ((int[]) objArr2[3])[0];
        if (i54 == i53) {
            int i55 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i55 % 128;
            int i56 = i55 % 2;
            Object[] objArr37 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i57 = ((int[]) objArr2[1])[0];
            int i58 = ((int[]) objArr2[3])[0];
            int i59 = ((int[]) objArr2[2])[0];
            String[] strArr3 = (String[]) objArr2[0];
            int iMyUid = Process.myUid();
            int i60 = ~iMyUid;
            int i61 = i57 + (((~(637369065 | i60)) | (~(iMyUid | 715472872))) * 959) + 373399915 + (((~(iMyUid | 637369065)) | (~(i60 | 715472872))) * 959);
            int i62 = (i61 << 13) ^ i61;
            int i63 = i62 ^ (i62 >>> 17);
            ((int[]) objArr37[1])[0] = i63 ^ (i63 << 5);
            i = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr4 = (String[]) objArr2[0];
            if (strArr4 != null) {
                for (String str5 : strArr4) {
                    arrayList3.add(str5);
                }
            }
            Object[] objArr38 = {Long.valueOf(((long) (i53 ^ i54)) ^ (((long) 1584444995) << 32)), Long.valueOf(1584444993)};
            byte[] bArr11 = $$d;
            Object[] objArr39 = new Object[1];
            c(bArr11[25], bArr11[83], (short) 481, objArr39);
            Class<?> cls4 = Class.forName((String) objArr39[0]);
            byte b3 = bArr11[410];
            Object[] objArr40 = new Object[1];
            c(b3, (byte) (b3 + 4), (short) 646, objArr40);
            cls4.getMethod((String) objArr40[0], Long.TYPE, Long.TYPE).invoke(null, objArr38);
            Object[] objArr41 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i64 = ((int[]) objArr2[1])[0];
            int i65 = ((int[]) objArr2[3])[0];
            int i66 = ((int[]) objArr2[2])[0];
            String[] strArr5 = (String[]) objArr2[0];
            int i67 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
            int i68 = ~i67;
            int i69 = i64 + (-158433714) + (((~((-54490164) | i68)) | 19419139) * 168) + ((~((-19419140) | i67)) * 168) + (((~(i67 | (-35071025))) | (~(i68 | (-23613644))) | 4194504) * 168);
            int i70 = (i69 << 13) ^ i69;
            int i71 = i70 ^ (i70 >>> 17);
            i = 0;
            ((int[]) objArr41[1])[0] = i71 ^ (i71 << 5);
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame27 == null) {
            int jumpTapTimeout = 25 - (ViewConfiguration.getJumpTapTimeout() >> 16);
            char c3 = (char) (30068 - (TypedValue.complexToFloat(i) > 0.0f ? 1 : (TypedValue.complexToFloat(i) == 0.0f ? 0 : -1)));
            int iGreen = 816 - Color.green(i);
            byte[] bArr12 = $$a;
            Object[] objArr42 = new Object[1];
            a(bArr12[i], bArr12[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr42);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, c3, iGreen, 721586079, false, (String) objArr42[i], null);
        }
        long j6 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j6 != -1) {
            int i72 = artificialFrame + 77;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i72 % 128;
            int i73 = i72 % 2;
            if (j6 + 1965 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i74 = artificialFrame + 87;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i74 % 128;
                int i75 = i74 % 2;
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame28 == null) {
                    int iMyPid2 = 25 - (Process.myPid() >> 22);
                    char cIndexOf = (char) (30068 - TextUtils.indexOf("", "", 0));
                    int maximumDrawingCacheSize2 = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    byte[] bArr13 = $$a;
                    Object[] objArr43 = new Object[1];
                    a(bArr13[0], bArr13[22], (byte) 100, objArr43);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iMyPid2, cIndexOf, maximumDrawingCacheSize2, 891606461, false, (String) objArr43[0], null);
                }
                Object[] objArr44 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
                objArr3 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i76 = ((int[]) objArr44[0])[0];
                int i77 = ((int[]) objArr44[1])[0];
                String[] strArr6 = (String[]) objArr44[2];
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i78 = 1509740031 + (((~(startElapsedRealtime | (-853166835))) | 1051339200) * 191) + (((~((~startElapsedRealtime) | (-853166835))) | 847907008) * 191) + 347876509;
                int i79 = (i78 << 13) ^ i78;
                int i80 = i79 ^ (i79 >>> 17);
                ((int[]) objArr3[3])[0] = i80 ^ (i80 << 5);
            } else {
                Object[] objArr45 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 347876509};
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 26;
                    char modifierMetaStateMask2 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int scrollDefaultDelay = 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    byte[] bArr14 = $$a;
                    byte b4 = (byte) (bArr14[77] - 1);
                    byte b5 = bArr14[36];
                    Object[] objArr46 = new Object[1];
                    a(b4, b5, (byte) (b5 | 88), objArr46);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf, modifierMetaStateMask2, scrollDefaultDelay, -797394565, false, (String) objArr46[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr47 = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr45);
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame2 == null) {
                    int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 25;
                    char cMakeMeasureSpec = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
                    int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 816;
                    byte[] bArr15 = $$a;
                    Object[] objArr48 = new Object[1];
                    a(bArr15[0], bArr15[22], (byte) 100, objArr48);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cMakeMeasureSpec, offsetAfter2, 891606461, false, (String) objArr48[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, objArr47);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame3 == null) {
                        int i81 = 26 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        char offsetAfter3 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                        int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
                        byte[] bArr16 = $$a;
                        Object[] objArr49 = new Object[1];
                        a(bArr16[0], bArr16[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr49);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i81, offsetAfter3, scrollBarSize, 721586079, false, (String) objArr49[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, lValueOf3);
                    objArr3 = objArr47;
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr410 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 347876509};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 26;
                char modifierMetaStateMask3 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                int scrollDefaultDelay2 = 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                byte[] bArr17 = $$a;
                byte b6 = (byte) (bArr17[77] - 1);
                byte b7 = bArr17[36];
                Object[] objArr411 = new Object[1];
                a(b6, b7, (byte) (b7 | 88), objArr411);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, modifierMetaStateMask3, scrollDefaultDelay2, -797394565, false, (String) objArr411[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr412 = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr410);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 25;
                char cMakeMeasureSpec2 = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
                int offsetAfter4 = TextUtils.getOffsetAfter("", 0) + 816;
                byte[] bArr18 = $$a;
                Object[] objArr413 = new Object[1];
                a(bArr18[0], bArr18[22], (byte) 100, objArr413);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, cMakeMeasureSpec2, offsetAfter4, 891606461, false, (String) objArr413[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr412);
            Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int i82 = 26 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                char offsetAfter5 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
                byte[] bArr19 = $$a;
                Object[] objArr414 = new Object[1];
                a(bArr19[0], bArr19[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr414);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i82, offsetAfter5, scrollBarSize2, 721586079, false, (String) objArr414[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf4);
            objArr3 = objArr412;
        }
        int i83 = ((int[]) objArr3[1])[0];
        int i84 = ((int[]) objArr3[0])[0];
        if (i84 == i83) {
            Object[] objArr50 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i85 = ((int[]) objArr3[3])[0];
            int i86 = ((int[]) objArr3[0])[0];
            int i87 = ((int[]) objArr3[1])[0];
            String[] strArr7 = (String[]) objArr3[2];
            int i88 = ~((~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1752774450)) | 16829105);
            int i89 = i85 + (((16829089 | i88) * (-374)) - 2097688925) + ((i88 | 16) * 374);
            int i90 = (i89 << 13) ^ i89;
            int i91 = i90 ^ (i90 >>> 17);
            ((int[]) objArr50[3])[0] = i91 ^ (i91 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr8 = (String[]) objArr3[2];
            if (strArr8 != null) {
                for (String str6 : strArr8) {
                    arrayList4.add(str6);
                }
            }
            Object[] objArr51 = {Long.valueOf(((long) (i83 ^ i84)) ^ (((long) (-2081814119)) << 32)), Long.valueOf(-2081814120)};
            byte[] bArr20 = $$d;
            byte b8 = bArr20[4];
            byte b9 = bArr20[25];
            Object[] objArr52 = new Object[1];
            c(b8, b9, (short) (b9 | 427), objArr52);
            Class<?> cls5 = Class.forName((String) objArr52[0]);
            byte b10 = bArr20[410];
            Object[] objArr53 = new Object[1];
            c(b10, (byte) (b10 + 4), (short) 646, objArr53);
            cls5.getMethod((String) objArr53[0], Long.TYPE, Long.TYPE).invoke(null, objArr51);
            Object[] objArr54 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i92 = ((int[]) objArr3[3])[0];
            int i93 = ((int[]) objArr3[0])[0];
            int i94 = ((int[]) objArr3[1])[0];
            String[] strArr9 = (String[]) objArr3[2];
            int i95 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i96 = i92 + (-169314864) + ((~(1044162559 | i95)) * 623) + (((~i95) | 168593069) * (-623)) + (((~(i95 | 705463997)) | (~(507291631 | i95)) | (-1044162560)) * 623);
            int i97 = (i96 << 13) ^ i96;
            int i98 = i97 ^ (i97 >>> 17);
            ((int[]) objArr54[3])[0] = i98 ^ (i98 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame29 == null) {
            int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
            char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
            int iResolveOpacity3 = Drawable.resolveOpacity(0, 0) + 684;
            byte[] bArr21 = $$a;
            Object[] objArr55 = new Object[1];
            a(bArr21[53], bArr21[94], (byte) 81, objArr55);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, maximumFlingVelocity, iResolveOpacity3, 752929587, false, (String) objArr55[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j7 == -1 || j7 + 2030 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr56 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 47352, 63238, 20190, 30508, 31185, 20210, 55538, 11500, 13132, 42978, 54569, 47137, 21478, 61515, 14564, 4743, 36081, 53335}, objArr56);
                Class<?> cls6 = Class.forName((String) objArr56[0]);
                Object[] objArr57 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 31, new char[]{45077, 16454, 51019, 774, 63399, 25952, 15996, 4606, 49194, 17505, 28951, 41441, 6549, 14158, 55538, 11500, 19877, 655}, objArr57);
                baseContext3 = (Context) cls6.getMethod((String) objArr57[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr58 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1790367242};
            byte[] bArr22 = $$d;
            Object[] objArr59 = new Object[1];
            c(bArr22[4], bArr22[99], (short) 346, objArr59);
            Class<?> cls7 = Class.forName((String) objArr59[0]);
            Object[] objArr60 = new Object[1];
            c(bArr22[662], bArr22[613], (short) 559, objArr60);
            objArr4 = (Object[]) cls7.getMethod((String) objArr60[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr58);
            if (baseContext3 != null) {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame30 == null) {
                    int i99 = 31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0, 0) + 49362);
                    int maximumFlingVelocity2 = 684 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    byte[] bArr23 = $$a;
                    Object[] objArr61 = new Object[1];
                    a(bArr23[54], bArr23[94], (byte) 66, objArr61);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i99, cIndexOf2, maximumFlingVelocity2, 1944867703, false, (String) objArr61[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr4);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame31 == null) {
                        int scrollBarSize3 = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char cIndexOf3 = (char) (TextUtils.indexOf("", "") + 49362);
                        int mirror3 = AndroidCharacter.getMirror('0') + 636;
                        byte[] bArr24 = $$a;
                        Object[] objArr62 = new Object[1];
                        a(bArr24[53], bArr24[94], (byte) 81, objArr62);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, cIndexOf3, mirror3, 752929587, false, (String) objArr62[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf5);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame32 == null) {
                int i100 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 29;
                char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 684;
                byte[] bArr25 = $$a;
                Object[] objArr63 = new Object[1];
                a(bArr25[54], bArr25[94], (byte) 66, objArr63);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i100, cKeyCodeFromString, iMakeMeasureSpec, 1944867703, false, (String) objArr63[0], null);
            }
            Object[] objArr64 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr64[0])[0]}, new int[]{((int[]) objArr64[1])[0]}, new int[1], (String) objArr64[3]};
            int i101 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i102 = ~(993144279 | i101);
            int i103 = (((244136698 + ((i102 | (-14520505)) * 764)) + (((~(i101 | (-14520505))) | 1048720) * (-1528))) + (((-1005567344) | i102) * 764)) - 1790367242;
            int i104 = (i103 << 13) ^ i103;
            int i105 = i104 ^ (i104 >>> 17);
            ((int[]) objArr4[2])[0] = i105 ^ (i105 << 5);
        }
        int i106 = ((int[]) objArr4[1])[0];
        int i107 = ((int[]) objArr4[0])[0];
        if (i107 == i106) {
            int i108 = ((int[]) objArr4[2])[0];
            Object[] objArr65 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 862085913;
            int i109 = ~length;
            int i110 = (~((-324324787) | i109)) | 285212818;
            int i111 = ~(length | (-615187021));
            int i112 = i108 + 1930219028 + ((i110 | i111) * (-713)) + (i111 * 1426) + ((~((-654298989) | i109)) * 713);
            int i113 = (i112 << 13) ^ i112;
            int i114 = i113 ^ (i113 >>> 17);
            i2 = 0;
            ((int[]) objArr65[2])[0] = i114 ^ (i114 << 5);
        } else {
            Object[] objArr66 = {Long.valueOf(((long) (i106 ^ i107)) ^ (((long) 1958580237) << 32)), Long.valueOf(1958580233)};
            byte[] bArr26 = $$d;
            Object[] objArr67 = new Object[1];
            c(bArr26[4], bArr26[16], (short) 294, objArr67);
            Class<?> cls8 = Class.forName((String) objArr67[0]);
            byte b11 = bArr26[410];
            Object[] objArr68 = new Object[1];
            c(b11, (byte) (b11 + 4), (short) 646, objArr68);
            cls8.getMethod((String) objArr68[0], Long.TYPE, Long.TYPE).invoke(null, objArr66);
            int i115 = ((int[]) objArr4[2])[0];
            Object[] objArr69 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1161192647;
            int i116 = ~length2;
            int i117 = i115 + (-221413010) + (((~((-520328170) | i116)) | 453050657) * 168) + ((~((-453050658) | length2)) * 168) + (((~(length2 | (-67277513))) | (~(i116 | (-458295606))) | 5244948) * 168);
            int i118 = (i117 << 13) ^ i117;
            int i119 = i118 ^ (i118 >>> 17);
            i2 = 0;
            ((int[]) objArr69[2])[0] = i119 ^ (i119 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame33 == null) {
            int iAlpha = 30 - Color.alpha(i2);
            char cMyPid = (char) (49362 - (Process.myPid() >> 22));
            int maxKeyCode = 684 - (KeyEvent.getMaxKeyCode() >> 16);
            byte[] bArr27 = $$a;
            Object[] objArr70 = new Object[1];
            a(bArr27[53], bArr27[5], bArr27[26], objArr70);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iAlpha, cMyPid, maxKeyCode, 508509282, false, (String) objArr70[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j8 != -1) {
            if (j8 + 1913 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame34 == null) {
                    int iNormalizeMetaState3 = KeyEvent.normalizeMetaState(0) + 30;
                    char c4 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49361);
                    int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 684;
                    byte[] bArr28 = $$a;
                    Object[] objArr71 = new Object[1];
                    a(bArr28[94], bArr28[0], bArr28[16], objArr71);
                    objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState3, c4, windowTouchSlop, -1321816393, false, (String) objArr71[0], null);
                }
                Object[] objArr72 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                objArr5 = new Object[]{new int[]{((int[]) objArr72[0])[0]}, new int[]{((int[]) objArr72[1])[0]}, new int[1], (String) objArr72[3]};
                int i120 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 2104742360);
                int i121 = ((((-183794770) + ((~(938638589 | i120)) * 52)) + (((~(376595701 | i120)) | ((~((-602028074) | i120)) | 562042888)) * (-52))) + (((~(i120 | (-376595702))) | 336610516) * 52)) - 444202442;
                int i122 = (i121 << 13) ^ i121;
                int i123 = i122 ^ (i122 >>> 17);
                ((int[]) objArr5[2])[0] = i123 ^ (i123 << 5);
            } else {
                i3 = 0;
            }
            i4 = ((int[]) objArr5[1])[0];
            i5 = ((int[]) objArr5[0])[0];
            if (i5 == i4) {
                int i124 = artificialFrame + 59;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i124 % 128;
                int i125 = i124 % 2;
                int i126 = ((int[]) objArr5[2])[0];
                Object[] objArr73 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int i127 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                int i128 = ~i127;
                int i129 = i126 + (((~((-700582367) | i128)) | (~((-278041409) | i127)) | (~(i128 | 278041408))) * 959) + 1397879325 + (((~(i127 | 278041408)) | (~(i128 | (-278041409))) | (~((-700582367) | i127))) * 959);
                int i130 = (i129 << 13) ^ i129;
                int i131 = i130 ^ (i130 >>> 17);
                ((int[]) objArr73[2])[0] = i131 ^ (i131 << 5);
            } else {
                long j9 = ((long) (i4 ^ i5)) ^ (((long) (-539402873)) << 32);
                long j10 = -539402361;
                int i132 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
                artificialFrame = i132 % 128;
                int i133 = i132 % 2;
                Object[] objArr74 = {Long.valueOf(j9), Long.valueOf(j10)};
                byte[] bArr29 = $$d;
                Object[] objArr75 = new Object[1];
                c(bArr29[4], (byte) (-bArr29[480]), (short) ($$e - 1), objArr75);
                Class<?> cls9 = Class.forName((String) objArr75[0]);
                byte b12 = bArr29[410];
                Object[] objArr76 = new Object[1];
                c(b12, (byte) (b12 + 4), (short) 646, objArr76);
                cls9.getMethod((String) objArr76[0], Long.TYPE, Long.TYPE).invoke(null, objArr74);
                int i134 = ((int[]) objArr5[2])[0];
                Object[] objArr77 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int i135 = ~((~((int) SystemClock.elapsedRealtime())) | 595311390);
                int i136 = i134 + ((555948318 | i135) * (-374)) + 907977458 + ((i135 | 39363072) * 374);
                int i137 = (i136 << 13) ^ i136;
                int i138 = i137 ^ (i137 >>> 17);
                ((int[]) objArr77[2])[0] = i138 ^ (i138 << 5);
            }
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame4 == null) {
                int maximumDrawingCacheSize3 = 36 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 541;
                byte[] bArr30 = $$a;
                Object[] objArr78 = new Object[1];
                a(bArr30[0], bArr30[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr78);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize3, keyRepeatTimeout, bitsPerPixel2, 624296913, false, (String) objArr78[0], null);
            }
            j = ((Field) objAccessartificialFrame4).getLong(null);
            if (j != -1 || j + 2041 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 20, (char) (39517 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 982 - View.resolveSizeAndState(0, 0, 0), 117222168, false, null, new Class[0]);
                }
                Object[] objArr79 = {null, ((Constructor) objAccessartificialFrame5).newInstance(null), -1352251920, 0};
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame6 == null) {
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 36;
                    char c5 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                    int threadPriority = 540 - ((Process.getThreadPriority(0) + 20) >> 6);
                    byte[] bArr31 = $$a;
                    Object[] objArr80 = new Object[1];
                    a((byte) (bArr31[3] - 1), bArr31[31], (byte) (-bArr31[68]), objArr80);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(capsMode, c5, threadPriority, 2101703389, false, (String) objArr80[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (833 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 575), (Class) ArtificialStackFrames.coroutineCreation(54 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) Color.red(0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 629), Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr81 = (Object[]) ((Method) objAccessartificialFrame6).invoke(null, objArr79);
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame7 == null) {
                    int scrollDefaultDelay3 = 36 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    char cBlue = (char) Color.blue(0);
                    int bitsPerPixel3 = 539 - ImageFormat.getBitsPerPixel(0);
                    byte[] bArr32 = $$a;
                    Object[] objArr82 = new Object[1];
                    a(bArr32[0], bArr32[22], (byte) 100, objArr82);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay3, cBlue, bitsPerPixel3, 793268735, false, (String) objArr82[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, objArr81);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame8 == null) {
                        int i139 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 35;
                        char gidForName = (char) ((-1) - Process.getGidForName(""));
                        int keyRepeatTimeout2 = 540 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        byte[] bArr33 = $$a;
                        Object[] objArr83 = new Object[1];
                        a(bArr33[0], bArr33[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr83);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i139, gidForName, keyRepeatTimeout2, 624296913, false, (String) objArr83[0], null);
                    }
                    ((Field) objAccessartificialFrame8).set(null, lValueOf6);
                    objArr6 = objArr81;
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame35 == null) {
                    int maxKeyCode2 = 36 - (KeyEvent.getMaxKeyCode() >> 16);
                    char cBlue2 = (char) Color.blue(0);
                    int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0, 0) + 541;
                    byte[] bArr34 = $$a;
                    Object[] objArr84 = new Object[1];
                    a(bArr34[0], bArr34[22], (byte) 100, objArr84);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, cBlue2, iLastIndexOf3, 793268735, false, (String) objArr84[0], null);
                }
                Object[] objArr85 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                objArr6 = new Object[]{new int[1], new int[1], new int[1]};
                int i140 = ((int[]) objArr85[2])[0];
                int i141 = ((int[]) objArr85[1])[0];
                ((int[]) objArr6[2])[0] = i140;
                ((int[]) objArr6[1])[0] = i141;
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i142 = ~((-454636709) | iIdentityHashCode3);
                int i143 = (-447602727) + ((168366116 | i142) * (-280)) + ((i142 | (~((-896985042) | iIdentityHashCode3))) * 140);
                int i144 = ~((-286270593) | iIdentityHashCode3);
                int i145 = ~iIdentityHashCode3;
                int i146 = (i143 + (((~(i145 | (-610714450))) | (i144 | (~((-168366117) | i145)))) * 140)) - 1352251920;
                int i147 = (i146 << 13) ^ i146;
                int i148 = i147 ^ (i147 >>> 17);
                ((int[]) objArr6[0])[0] = i148 ^ (i148 << 5);
            }
            obj = objArr6[1];
            i6 = ((int[]) obj)[0];
            obj2 = objArr6[2];
            i7 = ((int[]) obj2)[0];
            if (i7 == i6) {
                Object[] objArr86 = {new int[1], new int[1], new int[1]};
                int i149 = ((int[]) objArr6[0])[0];
                int i150 = ((int[]) obj2)[0];
                int i151 = ((int[]) obj)[0];
                ((int[]) objArr86[2])[0] = i150;
                ((int[]) objArr86[1])[0] = i151;
                int iIdentityHashCode4 = System.identityHashCode(this);
                int i152 = ~iIdentityHashCode4;
                int i153 = i149 + 681606324 + (((~((-854408948) | i152)) | (~((-497212803) | i152))) * (-867)) + (((~((-854408948) | iIdentityHashCode4)) | 278928514 | (~((-497212803) | iIdentityHashCode4))) * (-1734)) + (((~(iIdentityHashCode4 | (-218284289))) | (~(i152 | (-278928515))) | (~((-575480434) | iIdentityHashCode4))) * 867);
                int i154 = (i153 << 13) ^ i153;
                int i155 = i154 ^ (i154 >>> 17);
                ((int[]) objArr86[0])[0] = i155 ^ (i155 << 5);
            } else {
                Object[] objArr87 = {Long.valueOf((((long) 22578807) << 32) ^ ((long) (i6 ^ i7))), Long.valueOf(22582903)};
                byte[] bArr35 = $$d;
                Object[] objArr88 = new Object[1];
                c(bArr35[4], bArr35[16], (short) 294, objArr88);
                Class<?> cls10 = Class.forName((String) objArr88[0]);
                byte b13 = bArr35[410];
                Object[] objArr89 = new Object[1];
                c(b13, (byte) (b13 + 4), (short) 646, objArr89);
                cls10.getMethod((String) objArr89[0], Long.TYPE, Long.TYPE).invoke(null, objArr87);
                Object[] objArr90 = {new int[1], new int[1], new int[1]};
                int i156 = ((int[]) objArr6[0])[0];
                int i157 = ((int[]) objArr6[2])[0];
                int i158 = ((int[]) objArr6[1])[0];
                ((int[]) objArr90[2])[0] = i157;
                ((int[]) objArr90[1])[0] = i158;
                int iNextInt = new Random().nextInt();
                int i159 = ~iNextInt;
                int i160 = (-420963) + (((~((-12591369) | i159)) | (~(1137045773 | iNextInt))) * 520);
                int i161 = ~((-1137045774) | i159);
                int i162 = ~(iNextInt | 214575976);
                int i163 = i156 + i160 + ((i161 | i162) * (-1040)) + ((i162 | (~(i159 | (-214575977))) | 1124454405) * 520);
                int i164 = (i163 << 13) ^ i163;
                int i165 = i164 ^ (i164 >>> 17);
                ((int[]) objArr90[0])[0] = i165 ^ (i165 << 5);
            }
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1313006081);
            if (objAccessartificialFrame9 == null) {
                int maximumDrawingCacheSize4 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 21;
                char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 465;
                byte[] bArr36 = $$a;
                Object[] objArr91 = new Object[1];
                a(bArr36[0], bArr36[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr91);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize4, windowTouchSlop2, iResolveSizeAndState, -785931255, false, (String) objArr91[0], null);
            }
            j2 = ((Field) objAccessartificialFrame9).getLong(null);
            if (j2 != -1) {
                if (j2 + 2009 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame15 == null) {
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 21;
                        char size = (char) View.MeasureSpec.getSize(0);
                        int i166 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 464;
                        byte[] bArr37 = $$a;
                        Object[] objArr92 = new Object[1];
                        a(bArr37[0], bArr37[22], (byte) 100, objArr92);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, size, i166, -612765161, false, (String) objArr92[0], null);
                    }
                    Object[] objArr93 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
                    objArr8 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                    int i167 = ((int[]) objArr93[3])[0];
                    int i168 = ((int[]) objArr93[0])[0];
                    String[] strArr10 = (String[]) objArr93[1];
                    int iIdentityHashCode5 = System.identityHashCode(this);
                    int i169 = ~iIdentityHashCode5;
                    int i170 = (-1048342124) + ((iIdentityHashCode5 | 536967833) * (-859)) + (((~(iIdentityHashCode5 | (-536953473))) | (~(536967833 | i169))) * 859) + (((~(376618107 | i169)) | (-913571580)) * 859) + 1276181085;
                    int i171 = (i170 << 13) ^ i170;
                    int i172 = i171 ^ (i171 >>> 17);
                    ((int[]) objArr8[2])[0] = i172 ^ (i172 << 5);
                    i9 = 0;
                } else {
                    i8 = 0;
                }
                i10 = ((int[]) objArr8[i9])[i9];
                i11 = ((int[]) objArr8[3])[i9];
                if (i11 == i10) {
                    Object[] objArr94 = new Object[4];
                    int[] iArr = new int[1];
                    objArr94[i9] = iArr;
                    objArr94[2] = new int[1];
                    int[] iArr2 = new int[1];
                    objArr94[3] = iArr2;
                    int i173 = ((int[]) objArr8[2])[i9];
                    int i174 = ((int[]) objArr8[3])[i9];
                    int i175 = ((int[]) objArr8[i9])[i9];
                    String[] strArr11 = (String[]) objArr8[1];
                    iArr2[i9] = i174;
                    iArr[i9] = i175;
                    int i176 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i9]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                    int i177 = (-1697572305) + ((i176 | 276344007) * (-50));
                    int i178 = ~((-269484103) | i176);
                    int i179 = ~i176;
                    int i180 = i173 + i177 + ((i178 | (~(385478383 | i179))) * 50) + (((~(i179 | 276344007)) | (~(115994281 | i179)) | (-385478384)) * 50);
                    int i181 = (i180 << 13) ^ i180;
                    int i182 = i181 ^ (i181 >>> 17);
                    ((int[]) objArr94[2])[0] = i182 ^ (i182 << 5);
                    objArr94[1] = strArr11;
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr8[1];
                    if (strArr != null) {
                        for (String str7 : strArr) {
                            arrayList.add(str7);
                        }
                    }
                    Object[] objArr95 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) (-1305994032)) << 32)), Long.valueOf(-1305994096)};
                    byte[] bArr38 = $$d;
                    Object[] objArr96 = new Object[1];
                    c(bArr38[4], (byte) (-bArr38[78]), (short) 93, objArr96);
                    Class<?> cls11 = Class.forName((String) objArr96[0]);
                    byte b14 = bArr38[410];
                    Object[] objArr97 = new Object[1];
                    c(b14, (byte) (b14 + 4), (short) 646, objArr97);
                    cls11.getMethod((String) objArr97[0], Long.TYPE, Long.TYPE).invoke(null, objArr95);
                    Object[] objArr98 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                    int i183 = ((int[]) objArr8[2])[0];
                    int i184 = ((int[]) objArr8[3])[0];
                    int i185 = ((int[]) objArr8[0])[0];
                    String[] strArr12 = (String[]) objArr8[1];
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i186 = i183 + 98116089 + (((~((-21244809) | iIdentityHashCode6)) | (-139104918)) * (-948)) + ((~((~iIdentityHashCode6) | (-4194945))) * (-948)) + 1016597164;
                    int i187 = (i186 << 13) ^ i186;
                    int i188 = i187 ^ (i187 >>> 17);
                    ((int[]) objArr98[2])[0] = i188 ^ (i188 << 5);
                }
                super.onCreate();
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame12 == null) {
                    int longPressTimeout = 30 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char windowTouchSlop3 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                    int packedPositionGroup = 684 - ExpandableListView.getPackedPositionGroup(0L);
                    byte[] bArr39 = $$a;
                    Object[] objArr99 = new Object[1];
                    a(bArr39[54], bArr39[5], bArr39[98], objArr99);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(longPressTimeout, windowTouchSlop3, packedPositionGroup, -1583976536, false, (String) objArr99[0], null);
                }
                j3 = ((Field) objAccessartificialFrame12).getLong(null);
                if (j3 != -1 || j3 + 2031 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object[] objArr100 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1145758013};
                    byte[] bArr40 = $$d;
                    Object[] objArr101 = new Object[1];
                    c(bArr40[4], bArr40[80], bArr40[133], objArr101);
                    Class<?> cls12 = Class.forName((String) objArr101[0]);
                    Object[] objArr102 = new Object[1];
                    c(bArr40[4], bArr40[602], bArr40[25], objArr102);
                    objArr9 = (Object[]) cls12.getMethod((String) objArr102[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr100);
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame13 == null) {
                        int i189 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char scrollBarFadeDuration = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                        int capsMode2 = 684 - TextUtils.getCapsMode("", 0, 0);
                        byte[] bArr41 = $$a;
                        Object[] objArr103 = new Object[1];
                        a((byte) (-bArr41[12]), bArr41[22], bArr41[0], objArr103);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i189, scrollBarFadeDuration, capsMode2, -1456483158, false, (String) objArr103[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, objArr9);
                    try {
                        Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
                        if (objAccessartificialFrame14 == null) {
                            int iCombineMeasuredStates = 30 - View.combineMeasuredStates(0, 0);
                            char c6 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                            int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                            byte[] bArr42 = $$a;
                            Object[] objArr104 = new Object[1];
                            a(bArr42[54], bArr42[5], bArr42[98], objArr104);
                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, c6, iLastIndexOf4, -1583976536, false, (String) objArr104[0], null);
                        }
                        ((Field) objAccessartificialFrame14).set(null, lValueOf7);
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame36 == null) {
                        int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 30;
                        char defaultSize = (char) (49362 - View.getDefaultSize(0, 0));
                        int iResolveOpacity4 = Drawable.resolveOpacity(0, 0) + 684;
                        byte[] bArr43 = $$a;
                        Object[] objArr105 = new Object[1];
                        a((byte) (-bArr43[12]), bArr43[22], bArr43[0], objArr105);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(packedPositionType, defaultSize, iResolveOpacity4, -1456483158, false, (String) objArr105[0], null);
                    }
                    Object[] objArr106 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr9 = new Object[]{new int[]{((int[]) objArr106[0])[0]}, new int[]{((int[]) objArr106[1])[0]}, new int[1], (String) objArr106[3]};
                    int i190 = ~((int) Process.getElapsedCpuTime());
                    int i191 = (((80470062 + ((~(910950397 | i190)) * 52)) + (((~(374054693 | i190)) | ((~((-604569082) | i190)) | 536895704)) * (-52))) + (((~(i190 | (-374054694))) | 306381316) * 52)) - 1145758013;
                    int i192 = (i191 << 13) ^ i191;
                    int i193 = i192 ^ (i192 >>> 17);
                    ((int[]) objArr9[2])[0] = i193 ^ (i193 << 5);
                }
                i13 = ((int[]) objArr9[1])[0];
                i14 = ((int[]) objArr9[0])[0];
                if (i14 == i13) {
                    int i194 = artificialFrame + 49;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i194 % 128;
                    int i195 = i194 % 2;
                    int i196 = ((int[]) objArr9[2])[0];
                    Object[] objArr107 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
                    int iNextInt2 = new Random().nextInt(31145471);
                    int i197 = ~((-623001739) | iNextInt2);
                    int i198 = i196 + (-6993738) + ((269032532 | i197) * (-476)) + (i197 * 952) + ((~((~iNextInt2) | (-623001739))) * 476);
                    int i199 = i198 ^ (i198 << 13);
                    int i200 = i199 ^ (i199 >>> 17);
                    ((int[]) objArr107[2])[0] = i200 ^ (i200 << 5);
                    return;
                }
                new ArrayList().add((String) objArr9[3]);
                Object[] objArr108 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) 381811016) << 32)), Long.valueOf(381811032)};
                byte[] bArr44 = $$d;
                Object[] objArr109 = new Object[1];
                c(bArr44[4], bArr44[16], (short) 294, objArr109);
                Class<?> cls13 = Class.forName((String) objArr109[0]);
                byte b15 = bArr44[410];
                Object[] objArr110 = new Object[1];
                c(b15, (byte) (b15 + 4), (short) 646, objArr110);
                cls13.getMethod((String) objArr110[0], Long.TYPE, Long.TYPE).invoke(null, objArr108);
                int i201 = ((int[]) objArr9[2])[0];
                Object[] objArr111 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
                int iMyTid2 = Process.myTid();
                int i202 = i201 + (((~(iMyTid2 | 148389915)) | 830233859) * 56) + 654744750 + (((~((~iMyTid2) | 830233859)) | 148389915) * 56);
                int i203 = (i202 << 13) ^ i202;
                int i204 = i203 ^ (i203 >>> 17);
                ((int[]) objArr111[2])[0] = i204 ^ (i204 << 5);
            }
            i8 = 0;
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr112 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i8]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i8, 4).codePointAt(i8) - 11, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 47352, 63238, 20190, 30508, 31185, 20210, 55538, 11500, 13132, 42978, 54569, 47137, 21478, 61515, 14564, 4743, 36081, 53335}, objArr112);
                Class<?> cls14 = Class.forName((String) objArr112[i8]);
                Object[] objArr113 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i8]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{45077, 16454, 51019, 774, 63399, 25952, 15996, 4606, 49194, 17505, 28951, 41441, 6549, 14158, 55538, 11500, 19877, 655}, objArr113);
                baseContext = (Context) cls14.getMethod((String) objArr113[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                int i205 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                artificialFrame = i205 % 128;
                int i206 = i205 % 2;
                if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = null;
                }
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr114 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 60, new char[]{40003, 37416, 28698, 10363, 25955, 42139, 61426, 13541, 61950, 58909, 27719, 26432, 23236, 53483, 27825, 18013, 29273, 55404, 62043, 37978, 41661, 26260, 27825, 18013, 26958, 58733, 59997, 21351, 45717, 53347, 16078, 2165, 17973, 43881, 42239, 21034, 27825, 18013, 38868, 45190, 5773, 64939, 17973, 43881, 13276, 54778, 29977, 24110, 40385, 18504, 37526, 5750, 47965, 49055, 11539, 34296, 5773, 64939, 42833, 53729, 2060, 60774, 32707, 34154}, objArr114);
            String str8 = (String) objArr114[0];
            Object[] objArr115 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 28, new char[]{63449, 12948, 65036, 37294, 16078, 2165, 39254, 42174, 1513, 48330, 28483, 55329, 7406, 47053, 38132, 10290, 37563, 4792, 38383, 35380, 43928, 36457, 27719, 26432, 47965, 49055, 64081, 480, 32578, 26364, 20905, 27320, 57212, 53235, 28086, 49334, 27719, 26432, 5912, 6802, 21581, 18157, 15408, 55283, 59997, 21351, 28698, 10363, 52910, 21683, 43928, 36457, 27566, 49587, 8867, 2093, 15560, 46689, 7881, 55565, 31476, 57876, 51419, 13856}, objArr115);
            Object[] objArr116 = {baseContext, new String[]{str8, (String) objArr115[0]}, Integer.valueOf(iIntValue2), 1, 1276181085};
            byte[] bArr45 = $$d;
            Object[] objArr117 = new Object[1];
            c(bArr45[4], (byte) (-bArr45[119]), (short) 142, objArr117);
            Class<?> cls15 = Class.forName((String) objArr117[0]);
            Object[] objArr118 = new Object[1];
            c(bArr45[60], bArr45[28], (short) 186, objArr118);
            objArr7 = (Object[]) cls15.getMethod((String) objArr118[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr116);
            int i207 = ((int[]) objArr7[0])[0];
            int i208 = ((int[]) objArr7[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame10 == null) {
                    int i209 = 21 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0) + 465;
                    byte[] bArr46 = $$a;
                    Object[] objArr119 = new Object[1];
                    a(bArr46[0], bArr46[22], (byte) 100, objArr119);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i209, fadingEdgeLength, iMakeMeasureSpec3, -612765161, false, (String) objArr119[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, objArr7);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame11 == null) {
                        int offsetBefore = 21 - TextUtils.getOffsetBefore("", 0);
                        char c7 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                        int iLastIndexOf5 = TextUtils.lastIndexOf("", '0') + 466;
                        byte[] bArr47 = $$a;
                        Object[] objArr120 = new Object[1];
                        a(bArr47[0], bArr47[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr120);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(offsetBefore, c7, iLastIndexOf5, -785931255, false, (String) objArr120[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, lValueOf8);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            } else {
                objArr7 = objArr7;
            }
            objArr8 = objArr7;
            i9 = 0;
            i10 = ((int[]) objArr8[i9])[i9];
            i11 = ((int[]) objArr8[3])[i9];
            if (i11 == i10) {
                Object[] objArr910 = new Object[4];
                int[] iArr3 = new int[1];
                objArr910[i9] = iArr3;
                objArr910[2] = new int[1];
                int[] iArr4 = new int[1];
                objArr910[3] = iArr4;
                int i1710 = ((int[]) objArr8[2])[i9];
                int i1711 = ((int[]) objArr8[3])[i9];
                int i1712 = ((int[]) objArr8[i9])[i9];
                String[] strArr13 = (String[]) objArr8[1];
                iArr4[i9] = i1711;
                iArr3[i9] = i1712;
                int i1713 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i9]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                int i1714 = (-1697572305) + ((i1713 | 276344007) * (-50));
                int i1715 = ~((-269484103) | i1713);
                int i1716 = ~i1713;
                int i1810 = i1710 + i1714 + ((i1715 | (~(385478383 | i1716))) * 50) + (((~(i1716 | 276344007)) | (~(115994281 | i1716)) | (-385478384)) * 50);
                int i1811 = (i1810 << 13) ^ i1810;
                int i1812 = i1811 ^ (i1811 >>> 17);
                ((int[]) objArr910[2])[0] = i1812 ^ (i1812 << 5);
                objArr910[1] = strArr13;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr8[1];
                if (strArr != null) {
                    while (i12 < strArr.length) {
                        arrayList.add(str7);
                    }
                }
                Object[] objArr911 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) (-1305994032)) << 32)), Long.valueOf(-1305994096)};
                byte[] bArr310 = $$d;
                Object[] objArr912 = new Object[1];
                c(bArr310[4], (byte) (-bArr310[78]), (short) 93, objArr912);
                Class<?> cls16 = Class.forName((String) objArr912[0]);
                byte b16 = bArr310[410];
                Object[] objArr913 = new Object[1];
                c(b16, (byte) (b16 + 4), (short) 646, objArr913);
                cls16.getMethod((String) objArr913[0], Long.TYPE, Long.TYPE).invoke(null, objArr911);
                Object[] objArr914 = {new int[]{i185}, strArr12, new int[1], new int[]{i184}};
                int i1813 = ((int[]) objArr8[2])[0];
                int i1814 = ((int[]) objArr8[3])[0];
                int i1815 = ((int[]) objArr8[0])[0];
                String[] strArr14 = (String[]) objArr8[1];
                int iIdentityHashCode7 = System.identityHashCode(this);
                int i1816 = i1813 + 98116089 + (((~((-21244809) | iIdentityHashCode7)) | (-139104918)) * (-948)) + ((~((~iIdentityHashCode7) | (-4194945))) * (-948)) + 1016597164;
                int i1817 = (i1816 << 13) ^ i1816;
                int i1818 = i1817 ^ (i1817 >>> 17);
                ((int[]) objArr914[2])[0] = i1818 ^ (i1818 << 5);
            }
            super.onCreate();
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame12 == null) {
                int longPressTimeout2 = 30 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char windowTouchSlop4 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                int packedPositionGroup2 = 684 - ExpandableListView.getPackedPositionGroup(0L);
                byte[] bArr311 = $$a;
                Object[] objArr915 = new Object[1];
                a(bArr311[54], bArr311[5], bArr311[98], objArr915);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, windowTouchSlop4, packedPositionGroup2, -1583976536, false, (String) objArr915[0], null);
            }
            j3 = ((Field) objAccessartificialFrame12).getLong(null);
            if (j3 != -1) {
                Object[] objArr1010 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1145758013};
                byte[] bArr48 = $$d;
                Object[] objArr1011 = new Object[1];
                c(bArr48[4], bArr48[80], bArr48[133], objArr1011);
                Class<?> cls17 = Class.forName((String) objArr1011[0]);
                Object[] objArr1012 = new Object[1];
                c(bArr48[4], bArr48[602], bArr48[25], objArr1012);
                objArr9 = (Object[]) cls17.getMethod((String) objArr1012[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr1010);
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame13 == null) {
                    int i1819 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char scrollBarFadeDuration2 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                    int capsMode3 = 684 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr49 = $$a;
                    Object[] objArr1013 = new Object[1];
                    a((byte) (-bArr49[12]), bArr49[22], bArr49[0], objArr1013);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i1819, scrollBarFadeDuration2, capsMode3, -1456483158, false, (String) objArr1013[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, objArr9);
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame14 == null) {
                    int iCombineMeasuredStates2 = 30 - View.combineMeasuredStates(0, 0);
                    char c8 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                    int iLastIndexOf6 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                    byte[] bArr410 = $$a;
                    Object[] objArr1014 = new Object[1];
                    a(bArr410[54], bArr410[5], bArr410[98], objArr1014);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, c8, iLastIndexOf6, -1583976536, false, (String) objArr1014[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, lValueOf9);
            } else {
                Object[] objArr1015 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1145758013};
                byte[] bArr411 = $$d;
                Object[] objArr1016 = new Object[1];
                c(bArr411[4], bArr411[80], bArr411[133], objArr1016);
                Class<?> cls18 = Class.forName((String) objArr1016[0]);
                Object[] objArr1017 = new Object[1];
                c(bArr411[4], bArr411[602], bArr411[25], objArr1017);
                objArr9 = (Object[]) cls18.getMethod((String) objArr1017[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr1015);
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame13 == null) {
                    int i18110 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char scrollBarFadeDuration3 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                    int capsMode4 = 684 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr412 = $$a;
                    Object[] objArr1018 = new Object[1];
                    a((byte) (-bArr412[12]), bArr412[22], bArr412[0], objArr1018);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i18110, scrollBarFadeDuration3, capsMode4, -1456483158, false, (String) objArr1018[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, objArr9);
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame14 == null) {
                    int iCombineMeasuredStates3 = 30 - View.combineMeasuredStates(0, 0);
                    char c9 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                    int iLastIndexOf7 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                    byte[] bArr413 = $$a;
                    Object[] objArr1019 = new Object[1];
                    a(bArr413[54], bArr413[5], bArr413[98], objArr1019);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, c9, iLastIndexOf7, -1583976536, false, (String) objArr1019[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, lValueOf10);
            }
            i13 = ((int[]) objArr9[1])[0];
            i14 = ((int[]) objArr9[0])[0];
            if (i14 == i13) {
                int i1910 = artificialFrame + 49;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1910 % 128;
                int i1911 = i1910 % 2;
                int i1912 = ((int[]) objArr9[2])[0];
                Object[] objArr1020 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
                int iNextInt3 = new Random().nextInt(31145471);
                int i1913 = ~((-623001739) | iNextInt3);
                int i1914 = i1912 + (-6993738) + ((269032532 | i1913) * (-476)) + (i1913 * 952) + ((~((~iNextInt3) | (-623001739))) * 476);
                int i1915 = i1914 ^ (i1914 << 13);
                int i2010 = i1915 ^ (i1915 >>> 17);
                ((int[]) objArr1020[2])[0] = i2010 ^ (i2010 << 5);
                return;
            }
            new ArrayList().add((String) objArr9[3]);
            Object[] objArr1021 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) 381811016) << 32)), Long.valueOf(381811032)};
            byte[] bArr414 = $$d;
            Object[] objArr1022 = new Object[1];
            c(bArr414[4], bArr414[16], (short) 294, objArr1022);
            Class<?> cls19 = Class.forName((String) objArr1022[0]);
            byte b17 = bArr414[410];
            Object[] objArr1110 = new Object[1];
            c(b17, (byte) (b17 + 4), (short) 646, objArr1110);
            cls19.getMethod((String) objArr1110[0], Long.TYPE, Long.TYPE).invoke(null, objArr1021);
            int i2011 = ((int[]) objArr9[2])[0];
            Object[] objArr1111 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
            int iMyTid3 = Process.myTid();
            int i2012 = i2011 + (((~(iMyTid3 | 148389915)) | 830233859) * 56) + 654744750 + (((~((~iMyTid3) | 830233859)) | 148389915) * 56);
            int i2013 = (i2012 << 13) ^ i2012;
            int i2014 = i2013 ^ (i2013 >>> 17);
            ((int[]) objArr1111[2])[0] = i2014 ^ (i2014 << 5);
        }
        i3 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr121 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i3]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 47352, 63238, 20190, 30508, 31185, 20210, 55538, 11500, 13132, 42978, 54569, 47137, 21478, 61515, 14564, 4743, 36081, 53335}, objArr121);
            Class<?> cls20 = Class.forName((String) objArr121[0]);
            Object[] objArr122 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 19, new char[]{45077, 16454, 51019, 774, 63399, 25952, 15996, 4606, 49194, 17505, 28951, 41441, 6549, 14158, 55538, 11500, 19877, 655}, objArr122);
            baseContext4 = (Context) cls20.getMethod((String) objArr122[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            int i210 = getARTIFICIAL_FRAME_PACKAGE_NAME + com.salesforce.marketingcloud.analytics.stats.b.i;
            artificialFrame = i210 % 128;
            int i211 = i210 % 2;
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        Object[] objArr123 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -444202442};
        byte[] bArr50 = $$d;
        Object[] objArr124 = new Object[1];
        c(bArr50[4], (byte) (-bArr50[78]), (short) 228, objArr124);
        Class<?> cls21 = Class.forName((String) objArr124[0]);
        Object[] objArr125 = new Object[1];
        c(bArr50[60], bArr50[28], (short) 186, objArr125);
        objArr5 = (Object[]) cls21.getMethod((String) objArr125[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr123);
        if (baseContext4 != null) {
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame37 == null) {
                int fadingEdgeLength2 = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                char keyRepeatTimeout3 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 49362);
                int iCombineMeasuredStates4 = 684 - View.combineMeasuredStates(0, 0);
                byte[] bArr51 = $$a;
                Object[] objArr126 = new Object[1];
                a(bArr51[94], bArr51[0], bArr51[16], objArr126);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, keyRepeatTimeout3, iCombineMeasuredStates4, -1321816393, false, (String) objArr126[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, objArr5);
            try {
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame38 == null) {
                    int i212 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 31;
                    char minimumFlingVelocity2 = (char) (49362 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 684;
                    byte[] bArr52 = $$a;
                    Object[] objArr127 = new Object[1];
                    a(bArr52[53], bArr52[5], bArr52[26], objArr127);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i212, minimumFlingVelocity2, pressedStateDuration, 508509282, false, (String) objArr127[0], null);
                }
                ((Field) objAccessartificialFrame38).set(null, lValueOf11);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        i4 = ((int[]) objArr5[1])[0];
        i5 = ((int[]) objArr5[0])[0];
        if (i5 == i4) {
            int i1210 = artificialFrame + 59;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i1210 % 128;
            int i1211 = i1210 % 2;
            int i1212 = ((int[]) objArr5[2])[0];
            Object[] objArr710 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i1213 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i1214 = ~i1213;
            int i1215 = i1212 + (((~((-700582367) | i1214)) | (~((-278041409) | i1213)) | (~(i1214 | 278041408))) * 959) + 1397879325 + (((~(i1213 | 278041408)) | (~(i1214 | (-278041409))) | (~((-700582367) | i1213))) * 959);
            int i1310 = (i1215 << 13) ^ i1215;
            int i1311 = i1310 ^ (i1310 >>> 17);
            ((int[]) objArr710[2])[0] = i1311 ^ (i1311 << 5);
        } else {
            long j11 = ((long) (i4 ^ i5)) ^ (((long) (-539402873)) << 32);
            long j12 = -539402361;
            int i1312 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
            artificialFrame = i1312 % 128;
            int i1313 = i1312 % 2;
            Object[] objArr711 = {Long.valueOf(j11), Long.valueOf(j12)};
            byte[] bArr210 = $$d;
            Object[] objArr712 = new Object[1];
            c(bArr210[4], (byte) (-bArr210[480]), (short) ($$e - 1), objArr712);
            Class<?> cls22 = Class.forName((String) objArr712[0]);
            byte b18 = bArr210[410];
            Object[] objArr713 = new Object[1];
            c(b18, (byte) (b18 + 4), (short) 646, objArr713);
            cls22.getMethod((String) objArr713[0], Long.TYPE, Long.TYPE).invoke(null, objArr711);
            int i1314 = ((int[]) objArr5[2])[0];
            Object[] objArr714 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i1315 = ~((~((int) SystemClock.elapsedRealtime())) | 595311390);
            int i1316 = i1314 + ((555948318 | i1315) * (-374)) + 907977458 + ((i1315 | 39363072) * 374);
            int i1317 = (i1316 << 13) ^ i1316;
            int i1318 = i1317 ^ (i1317 >>> 17);
            ((int[]) objArr714[2])[0] = i1318 ^ (i1318 << 5);
        }
        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame4 == null) {
            int maximumDrawingCacheSize5 = 36 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
            char keyRepeatTimeout4 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0) + 541;
            byte[] bArr312 = $$a;
            Object[] objArr715 = new Object[1];
            a(bArr312[0], bArr312[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr715);
            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize5, keyRepeatTimeout4, bitsPerPixel4, 624296913, false, (String) objArr715[0], null);
        }
        j = ((Field) objAccessartificialFrame4).getLong(null);
        if (j != -1) {
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 20, (char) (39517 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 982 - View.resolveSizeAndState(0, 0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr716 = {null, ((Constructor) objAccessartificialFrame5).newInstance(null), -1352251920, 0};
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame6 == null) {
                int capsMode5 = TextUtils.getCapsMode("", 0, 0) + 36;
                char c10 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                int threadPriority2 = 540 - ((Process.getThreadPriority(0) + 20) >> 6);
                byte[] bArr313 = $$a;
                Object[] objArr810 = new Object[1];
                a((byte) (bArr313[3] - 1), bArr313[31], (byte) (-bArr313[68]), objArr810);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(capsMode5, c10, threadPriority2, 2101703389, false, (String) objArr810[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (833 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 575), (Class) ArtificialStackFrames.coroutineCreation(54 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) Color.red(0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 629), Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr811 = (Object[]) ((Method) objAccessartificialFrame6).invoke(null, objArr716);
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame7 == null) {
                int scrollDefaultDelay4 = 36 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                char cBlue3 = (char) Color.blue(0);
                int bitsPerPixel5 = 539 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr314 = $$a;
                Object[] objArr812 = new Object[1];
                a(bArr314[0], bArr314[22], (byte) 100, objArr812);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay4, cBlue3, bitsPerPixel5, 793268735, false, (String) objArr812[0], null);
            }
            ((Field) objAccessartificialFrame7).set(null, objArr811);
            Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame8 == null) {
                int i1319 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 35;
                char gidForName2 = (char) ((-1) - Process.getGidForName(""));
                int keyRepeatTimeout5 = 540 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte[] bArr315 = $$a;
                Object[] objArr813 = new Object[1];
                a(bArr315[0], bArr315[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr813);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i1319, gidForName2, keyRepeatTimeout5, 624296913, false, (String) objArr813[0], null);
            }
            ((Field) objAccessartificialFrame8).set(null, lValueOf12);
            objArr6 = objArr811;
        } else {
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 20, (char) (39517 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 982 - View.resolveSizeAndState(0, 0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr717 = {null, ((Constructor) objAccessartificialFrame5).newInstance(null), -1352251920, 0};
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame6 == null) {
                int capsMode6 = TextUtils.getCapsMode("", 0, 0) + 36;
                char c11 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                int threadPriority3 = 540 - ((Process.getThreadPriority(0) + 20) >> 6);
                byte[] bArr316 = $$a;
                Object[] objArr814 = new Object[1];
                a((byte) (bArr316[3] - 1), bArr316[31], (byte) (-bArr316[68]), objArr814);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(capsMode6, c11, threadPriority3, 2101703389, false, (String) objArr814[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (833 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 575), (Class) ArtificialStackFrames.coroutineCreation(54 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) Color.red(0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 629), Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr815 = (Object[]) ((Method) objAccessartificialFrame6).invoke(null, objArr717);
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame7 == null) {
                int scrollDefaultDelay5 = 36 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                char cBlue4 = (char) Color.blue(0);
                int bitsPerPixel6 = 539 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr317 = $$a;
                Object[] objArr816 = new Object[1];
                a(bArr317[0], bArr317[22], (byte) 100, objArr816);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay5, cBlue4, bitsPerPixel6, 793268735, false, (String) objArr816[0], null);
            }
            ((Field) objAccessartificialFrame7).set(null, objArr815);
            Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame8 == null) {
                int i13110 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 35;
                char gidForName3 = (char) ((-1) - Process.getGidForName(""));
                int keyRepeatTimeout6 = 540 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte[] bArr318 = $$a;
                Object[] objArr817 = new Object[1];
                a(bArr318[0], bArr318[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr817);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i13110, gidForName3, keyRepeatTimeout6, 624296913, false, (String) objArr817[0], null);
            }
            ((Field) objAccessartificialFrame8).set(null, lValueOf13);
            objArr6 = objArr815;
        }
        obj = objArr6[1];
        i6 = ((int[]) obj)[0];
        obj2 = objArr6[2];
        i7 = ((int[]) obj2)[0];
        if (i7 == i6) {
            Object[] objArr818 = {new int[1], new int[1], new int[1]};
            int i1410 = ((int[]) objArr6[0])[0];
            int i1510 = ((int[]) obj2)[0];
            int i1511 = ((int[]) obj)[0];
            ((int[]) objArr818[2])[0] = i1510;
            ((int[]) objArr818[1])[0] = i1511;
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i1512 = ~iIdentityHashCode8;
            int i1513 = i1410 + 681606324 + (((~((-854408948) | i1512)) | (~((-497212803) | i1512))) * (-867)) + (((~((-854408948) | iIdentityHashCode8)) | 278928514 | (~((-497212803) | iIdentityHashCode8))) * (-1734)) + (((~(iIdentityHashCode8 | (-218284289))) | (~(i1512 | (-278928515))) | (~((-575480434) | iIdentityHashCode8))) * 867);
            int i1514 = (i1513 << 13) ^ i1513;
            int i1515 = i1514 ^ (i1514 >>> 17);
            ((int[]) objArr818[0])[0] = i1515 ^ (i1515 << 5);
        } else {
            Object[] objArr819 = {Long.valueOf((((long) 22578807) << 32) ^ ((long) (i6 ^ i7))), Long.valueOf(22582903)};
            byte[] bArr319 = $$d;
            Object[] objArr820 = new Object[1];
            c(bArr319[4], bArr319[16], (short) 294, objArr820);
            Class<?> cls110 = Class.forName((String) objArr820[0]);
            byte b19 = bArr319[410];
            Object[] objArr821 = new Object[1];
            c(b19, (byte) (b19 + 4), (short) 646, objArr821);
            cls110.getMethod((String) objArr821[0], Long.TYPE, Long.TYPE).invoke(null, objArr819);
            Object[] objArr916 = {new int[1], new int[1], new int[1]};
            int i1516 = ((int[]) objArr6[0])[0];
            int i1517 = ((int[]) objArr6[2])[0];
            int i1518 = ((int[]) objArr6[1])[0];
            ((int[]) objArr916[2])[0] = i1517;
            ((int[]) objArr916[1])[0] = i1518;
            int iNextInt4 = new Random().nextInt();
            int i1519 = ~iNextInt4;
            int i1610 = (-420963) + (((~((-12591369) | i1519)) | (~(1137045773 | iNextInt4))) * 520);
            int i1611 = ~((-1137045774) | i1519);
            int i1612 = ~(iNextInt4 | 214575976);
            int i1613 = i1516 + i1610 + ((i1611 | i1612) * (-1040)) + ((i1612 | (~(i1519 | (-214575977))) | 1124454405) * 520);
            int i1614 = (i1613 << 13) ^ i1613;
            int i1615 = i1614 ^ (i1614 >>> 17);
            ((int[]) objArr916[0])[0] = i1615 ^ (i1615 << 5);
        }
        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame9 == null) {
            int maximumDrawingCacheSize6 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 21;
            char windowTouchSlop5 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
            int iResolveSizeAndState2 = View.resolveSizeAndState(0, 0, 0) + 465;
            byte[] bArr320 = $$a;
            Object[] objArr917 = new Object[1];
            a(bArr320[0], bArr320[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr917);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize6, windowTouchSlop5, iResolveSizeAndState2, -785931255, false, (String) objArr917[0], null);
        }
        j2 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j2 != -1) {
            if (j2 + 2009 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame15 == null) {
                    int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(0, 0) + 21;
                    char size2 = (char) View.MeasureSpec.getSize(0);
                    int i1616 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 464;
                    byte[] bArr321 = $$a;
                    Object[] objArr918 = new Object[1];
                    a(bArr321[0], bArr321[22], (byte) 100, objArr918);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec4, size2, i1616, -612765161, false, (String) objArr918[0], null);
                }
                Object[] objArr919 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
                objArr8 = new Object[]{new int[]{i168}, strArr10, new int[1], new int[]{i167}};
                int i1617 = ((int[]) objArr919[3])[0];
                int i1618 = ((int[]) objArr919[0])[0];
                String[] strArr15 = (String[]) objArr919[1];
                int iIdentityHashCode9 = System.identityHashCode(this);
                int i1619 = ~iIdentityHashCode9;
                int i1717 = (-1048342124) + ((iIdentityHashCode9 | 536967833) * (-859)) + (((~(iIdentityHashCode9 | (-536953473))) | (~(536967833 | i1619))) * 859) + (((~(376618107 | i1619)) | (-913571580)) * 859) + 1276181085;
                int i1718 = (i1717 << 13) ^ i1717;
                int i1719 = i1718 ^ (i1718 >>> 17);
                ((int[]) objArr8[2])[0] = i1719 ^ (i1719 << 5);
                i9 = 0;
            } else {
                i8 = 0;
            }
            i10 = ((int[]) objArr8[i9])[i9];
            i11 = ((int[]) objArr8[3])[i9];
            if (i11 == i10) {
                Object[] objArr9110 = new Object[4];
                int[] iArr5 = new int[1];
                objArr9110[i9] = iArr5;
                objArr9110[2] = new int[1];
                int[] iArr6 = new int[1];
                objArr9110[3] = iArr6;
                int i17110 = ((int[]) objArr8[2])[i9];
                int i17111 = ((int[]) objArr8[3])[i9];
                int i17112 = ((int[]) objArr8[i9])[i9];
                String[] strArr16 = (String[]) objArr8[1];
                iArr6[i9] = i17111;
                iArr5[i9] = i17112;
                int i17113 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i9]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                int i17114 = (-1697572305) + ((i17113 | 276344007) * (-50));
                int i17115 = ~((-269484103) | i17113);
                int i17116 = ~i17113;
                int i18111 = i17110 + i17114 + ((i17115 | (~(385478383 | i17116))) * 50) + (((~(i17116 | 276344007)) | (~(115994281 | i17116)) | (-385478384)) * 50);
                int i18112 = (i18111 << 13) ^ i18111;
                int i18113 = i18112 ^ (i18112 >>> 17);
                ((int[]) objArr9110[2])[0] = i18113 ^ (i18113 << 5);
                objArr9110[1] = strArr16;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr8[1];
                if (strArr != null) {
                    while (i12 < strArr.length) {
                        arrayList.add(str7);
                    }
                }
                Object[] objArr9111 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) (-1305994032)) << 32)), Long.valueOf(-1305994096)};
                byte[] bArr3110 = $$d;
                Object[] objArr9112 = new Object[1];
                c(bArr3110[4], (byte) (-bArr3110[78]), (short) 93, objArr9112);
                Class<?> cls111 = Class.forName((String) objArr9112[0]);
                byte b110 = bArr3110[410];
                Object[] objArr9113 = new Object[1];
                c(b110, (byte) (b110 + 4), (short) 646, objArr9113);
                cls111.getMethod((String) objArr9113[0], Long.TYPE, Long.TYPE).invoke(null, objArr9111);
                Object[] objArr9114 = {new int[]{i1815}, strArr14, new int[1], new int[]{i1814}};
                int i18114 = ((int[]) objArr8[2])[0];
                int i18115 = ((int[]) objArr8[3])[0];
                int i18116 = ((int[]) objArr8[0])[0];
                String[] strArr17 = (String[]) objArr8[1];
                int iIdentityHashCode10 = System.identityHashCode(this);
                int i18117 = i18114 + 98116089 + (((~((-21244809) | iIdentityHashCode10)) | (-139104918)) * (-948)) + ((~((~iIdentityHashCode10) | (-4194945))) * (-948)) + 1016597164;
                int i18118 = (i18117 << 13) ^ i18117;
                int i18119 = i18118 ^ (i18118 >>> 17);
                ((int[]) objArr9114[2])[0] = i18119 ^ (i18119 << 5);
            }
            super.onCreate();
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame12 == null) {
                int longPressTimeout3 = 30 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char windowTouchSlop6 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                int packedPositionGroup3 = 684 - ExpandableListView.getPackedPositionGroup(0L);
                byte[] bArr3111 = $$a;
                Object[] objArr9115 = new Object[1];
                a(bArr3111[54], bArr3111[5], bArr3111[98], objArr9115);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(longPressTimeout3, windowTouchSlop6, packedPositionGroup3, -1583976536, false, (String) objArr9115[0], null);
            }
            j3 = ((Field) objAccessartificialFrame12).getLong(null);
            if (j3 != -1) {
                Object[] objArr10110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1145758013};
                byte[] bArr415 = $$d;
                Object[] objArr10111 = new Object[1];
                c(bArr415[4], bArr415[80], bArr415[133], objArr10111);
                Class<?> cls112 = Class.forName((String) objArr10111[0]);
                Object[] objArr10112 = new Object[1];
                c(bArr415[4], bArr415[602], bArr415[25], objArr10112);
                objArr9 = (Object[]) cls112.getMethod((String) objArr10112[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr10110);
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame13 == null) {
                    int i181110 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char scrollBarFadeDuration4 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                    int capsMode7 = 684 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr416 = $$a;
                    Object[] objArr10113 = new Object[1];
                    a((byte) (-bArr416[12]), bArr416[22], bArr416[0], objArr10113);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i181110, scrollBarFadeDuration4, capsMode7, -1456483158, false, (String) objArr10113[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, objArr9);
                Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame14 == null) {
                    int iCombineMeasuredStates5 = 30 - View.combineMeasuredStates(0, 0);
                    char c12 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                    int iLastIndexOf8 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                    byte[] bArr417 = $$a;
                    Object[] objArr10114 = new Object[1];
                    a(bArr417[54], bArr417[5], bArr417[98], objArr10114);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates5, c12, iLastIndexOf8, -1583976536, false, (String) objArr10114[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, lValueOf14);
            } else {
                Object[] objArr10115 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1145758013};
                byte[] bArr418 = $$d;
                Object[] objArr10116 = new Object[1];
                c(bArr418[4], bArr418[80], bArr418[133], objArr10116);
                Class<?> cls113 = Class.forName((String) objArr10116[0]);
                Object[] objArr10117 = new Object[1];
                c(bArr418[4], bArr418[602], bArr418[25], objArr10117);
                objArr9 = (Object[]) cls113.getMethod((String) objArr10117[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr10115);
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame13 == null) {
                    int i181111 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char scrollBarFadeDuration5 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                    int capsMode8 = 684 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr419 = $$a;
                    Object[] objArr10118 = new Object[1];
                    a((byte) (-bArr419[12]), bArr419[22], bArr419[0], objArr10118);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i181111, scrollBarFadeDuration5, capsMode8, -1456483158, false, (String) objArr10118[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, objArr9);
                Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame14 == null) {
                    int iCombineMeasuredStates6 = 30 - View.combineMeasuredStates(0, 0);
                    char c13 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                    int iLastIndexOf9 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                    byte[] bArr4110 = $$a;
                    Object[] objArr10119 = new Object[1];
                    a(bArr4110[54], bArr4110[5], bArr4110[98], objArr10119);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates6, c13, iLastIndexOf9, -1583976536, false, (String) objArr10119[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, lValueOf15);
            }
            i13 = ((int[]) objArr9[1])[0];
            i14 = ((int[]) objArr9[0])[0];
            if (i14 == i13) {
                int i1916 = artificialFrame + 49;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1916 % 128;
                int i1917 = i1916 % 2;
                int i1918 = ((int[]) objArr9[2])[0];
                Object[] objArr1023 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
                int iNextInt5 = new Random().nextInt(31145471);
                int i1919 = ~((-623001739) | iNextInt5);
                int i19110 = i1918 + (-6993738) + ((269032532 | i1919) * (-476)) + (i1919 * 952) + ((~((~iNextInt5) | (-623001739))) * 476);
                int i19111 = i19110 ^ (i19110 << 13);
                int i2015 = i19111 ^ (i19111 >>> 17);
                ((int[]) objArr1023[2])[0] = i2015 ^ (i2015 << 5);
                return;
            }
            new ArrayList().add((String) objArr9[3]);
            Object[] objArr1024 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) 381811016) << 32)), Long.valueOf(381811032)};
            byte[] bArr4111 = $$d;
            Object[] objArr1025 = new Object[1];
            c(bArr4111[4], bArr4111[16], (short) 294, objArr1025);
            Class<?> cls114 = Class.forName((String) objArr1025[0]);
            byte b111 = bArr4111[410];
            Object[] objArr1112 = new Object[1];
            c(b111, (byte) (b111 + 4), (short) 646, objArr1112);
            cls114.getMethod((String) objArr1112[0], Long.TYPE, Long.TYPE).invoke(null, objArr1024);
            int i2016 = ((int[]) objArr9[2])[0];
            Object[] objArr1113 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
            int iMyTid4 = Process.myTid();
            int i2017 = i2016 + (((~(iMyTid4 | 148389915)) | 830233859) * 56) + 654744750 + (((~((~iMyTid4) | 830233859)) | 148389915) * 56);
            int i2018 = (i2017 << 13) ^ i2017;
            int i2019 = i2018 ^ (i2018 >>> 17);
            ((int[]) objArr1113[2])[0] = i2019 ^ (i2019 << 5);
        }
        i8 = 0;
        baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr1114 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i8]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i8, 4).codePointAt(i8) - 11, new char[]{11981, 6218, 14632, 28543, 33227, 36174, 29271, 22836, 47352, 63238, 20190, 30508, 31185, 20210, 55538, 11500, 13132, 42978, 54569, 47137, 21478, 61515, 14564, 4743, 36081, 53335}, objArr1114);
            Class<?> cls115 = Class.forName((String) objArr1114[i8]);
            Object[] objArr1115 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i8]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{45077, 16454, 51019, 774, 63399, 25952, 15996, 4606, 49194, 17505, 28951, 41441, 6549, 14158, 55538, 11500, 19877, 655}, objArr1115);
            baseContext = (Context) cls115.getMethod((String) objArr1115[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            int i2020 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
            artificialFrame = i2020 % 128;
            int i2021 = i2020 % 2;
            if (baseContext instanceof ContextWrapper) {
                baseContext = baseContext.getApplicationContext();
            } else {
                baseContext = baseContext.getApplicationContext();
            }
        }
        int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
        Object[] objArr1116 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 60, new char[]{40003, 37416, 28698, 10363, 25955, 42139, 61426, 13541, 61950, 58909, 27719, 26432, 23236, 53483, 27825, 18013, 29273, 55404, 62043, 37978, 41661, 26260, 27825, 18013, 26958, 58733, 59997, 21351, 45717, 53347, 16078, 2165, 17973, 43881, 42239, 21034, 27825, 18013, 38868, 45190, 5773, 64939, 17973, 43881, 13276, 54778, 29977, 24110, 40385, 18504, 37526, 5750, 47965, 49055, 11539, 34296, 5773, 64939, 42833, 53729, 2060, 60774, 32707, 34154}, objArr1116);
        String str9 = (String) objArr1116[0];
        Object[] objArr1117 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 28, new char[]{63449, 12948, 65036, 37294, 16078, 2165, 39254, 42174, 1513, 48330, 28483, 55329, 7406, 47053, 38132, 10290, 37563, 4792, 38383, 35380, 43928, 36457, 27719, 26432, 47965, 49055, 64081, 480, 32578, 26364, 20905, 27320, 57212, 53235, 28086, 49334, 27719, 26432, 5912, 6802, 21581, 18157, 15408, 55283, 59997, 21351, 28698, 10363, 52910, 21683, 43928, 36457, 27566, 49587, 8867, 2093, 15560, 46689, 7881, 55565, 31476, 57876, 51419, 13856}, objArr1117);
        Object[] objArr1118 = {baseContext, new String[]{str9, (String) objArr1117[0]}, Integer.valueOf(iIntValue3), 1, 1276181085};
        byte[] bArr420 = $$d;
        Object[] objArr1119 = new Object[1];
        c(bArr420[4], (byte) (-bArr420[119]), (short) 142, objArr1119);
        Class<?> cls116 = Class.forName((String) objArr1119[0]);
        Object[] objArr1120 = new Object[1];
        c(bArr420[60], bArr420[28], (short) 186, objArr1120);
        objArr7 = (Object[]) cls116.getMethod((String) objArr1120[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1118);
        int i2022 = ((int[]) objArr7[0])[0];
        int i2023 = ((int[]) objArr7[3])[0];
        if (baseContext != null) {
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame10 == null) {
                int i2024 = 21 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char fadingEdgeLength3 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                int iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(0, 0) + 465;
                byte[] bArr421 = $$a;
                Object[] objArr1121 = new Object[1];
                a(bArr421[0], bArr421[22], (byte) 100, objArr1121);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i2024, fadingEdgeLength3, iMakeMeasureSpec5, -612765161, false, (String) objArr1121[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, objArr7);
            Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1313006081);
            if (objAccessartificialFrame11 == null) {
                int offsetBefore2 = 21 - TextUtils.getOffsetBefore("", 0);
                char c14 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int iLastIndexOf10 = TextUtils.lastIndexOf("", '0') + 466;
                byte[] bArr422 = $$a;
                Object[] objArr128 = new Object[1];
                a(bArr422[0], bArr422[22], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr128);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(offsetBefore2, c14, iLastIndexOf10, -785931255, false, (String) objArr128[0], null);
            }
            ((Field) objAccessartificialFrame11).set(null, lValueOf16);
        } else {
            objArr7 = objArr7;
        }
        objArr8 = objArr7;
        i9 = 0;
        i10 = ((int[]) objArr8[i9])[i9];
        i11 = ((int[]) objArr8[3])[i9];
        if (i11 == i10) {
            Object[] objArr9116 = new Object[4];
            int[] iArr7 = new int[1];
            objArr9116[i9] = iArr7;
            objArr9116[2] = new int[1];
            int[] iArr8 = new int[1];
            objArr9116[3] = iArr8;
            int i17117 = ((int[]) objArr8[2])[i9];
            int i17118 = ((int[]) objArr8[3])[i9];
            int i17119 = ((int[]) objArr8[i9])[i9];
            String[] strArr18 = (String[]) objArr8[1];
            iArr8[i9] = i17118;
            iArr7[i9] = i17119;
            int i171110 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i9]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i171111 = (-1697572305) + ((i171110 | 276344007) * (-50));
            int i171112 = ~((-269484103) | i171110);
            int i171113 = ~i171110;
            int i181112 = i17117 + i171111 + ((i171112 | (~(385478383 | i171113))) * 50) + (((~(i171113 | 276344007)) | (~(115994281 | i171113)) | (-385478384)) * 50);
            int i181113 = (i181112 << 13) ^ i181112;
            int i181114 = i181113 ^ (i181113 >>> 17);
            ((int[]) objArr9116[2])[0] = i181114 ^ (i181114 << 5);
            objArr9116[1] = strArr18;
        } else {
            arrayList = new ArrayList();
            strArr = (String[]) objArr8[1];
            if (strArr != null) {
                while (i12 < strArr.length) {
                    arrayList.add(str7);
                }
            }
            Object[] objArr9117 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) (-1305994032)) << 32)), Long.valueOf(-1305994096)};
            byte[] bArr3112 = $$d;
            Object[] objArr9118 = new Object[1];
            c(bArr3112[4], (byte) (-bArr3112[78]), (short) 93, objArr9118);
            Class<?> cls117 = Class.forName((String) objArr9118[0]);
            byte b112 = bArr3112[410];
            Object[] objArr9119 = new Object[1];
            c(b112, (byte) (b112 + 4), (short) 646, objArr9119);
            cls117.getMethod((String) objArr9119[0], Long.TYPE, Long.TYPE).invoke(null, objArr9117);
            Object[] objArr91110 = {new int[]{i18116}, strArr17, new int[1], new int[]{i18115}};
            int i181115 = ((int[]) objArr8[2])[0];
            int i181116 = ((int[]) objArr8[3])[0];
            int i181117 = ((int[]) objArr8[0])[0];
            String[] strArr19 = (String[]) objArr8[1];
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i181118 = i181115 + 98116089 + (((~((-21244809) | iIdentityHashCode11)) | (-139104918)) * (-948)) + ((~((~iIdentityHashCode11) | (-4194945))) * (-948)) + 1016597164;
            int i181119 = (i181118 << 13) ^ i181118;
            int i181120 = i181119 ^ (i181119 >>> 17);
            ((int[]) objArr91110[2])[0] = i181120 ^ (i181120 << 5);
        }
        super.onCreate();
        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame12 == null) {
            int longPressTimeout4 = 30 - (ViewConfiguration.getLongPressTimeout() >> 16);
            char windowTouchSlop7 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
            int packedPositionGroup4 = 684 - ExpandableListView.getPackedPositionGroup(0L);
            byte[] bArr3113 = $$a;
            Object[] objArr91111 = new Object[1];
            a(bArr3113[54], bArr3113[5], bArr3113[98], objArr91111);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(longPressTimeout4, windowTouchSlop7, packedPositionGroup4, -1583976536, false, (String) objArr91111[0], null);
        }
        j3 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j3 != -1) {
            Object[] objArr101110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1145758013};
            byte[] bArr4112 = $$d;
            Object[] objArr101111 = new Object[1];
            c(bArr4112[4], bArr4112[80], bArr4112[133], objArr101111);
            Class<?> cls118 = Class.forName((String) objArr101111[0]);
            Object[] objArr101112 = new Object[1];
            c(bArr4112[4], bArr4112[602], bArr4112[25], objArr101112);
            objArr9 = (Object[]) cls118.getMethod((String) objArr101112[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr101110);
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame13 == null) {
                int i1811110 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char scrollBarFadeDuration6 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                int capsMode9 = 684 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr4113 = $$a;
                Object[] objArr101113 = new Object[1];
                a((byte) (-bArr4113[12]), bArr4113[22], bArr4113[0], objArr101113);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i1811110, scrollBarFadeDuration6, capsMode9, -1456483158, false, (String) objArr101113[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, objArr9);
            Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame14 == null) {
                int iCombineMeasuredStates7 = 30 - View.combineMeasuredStates(0, 0);
                char c15 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                int iLastIndexOf11 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                byte[] bArr4114 = $$a;
                Object[] objArr101114 = new Object[1];
                a(bArr4114[54], bArr4114[5], bArr4114[98], objArr101114);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates7, c15, iLastIndexOf11, -1583976536, false, (String) objArr101114[0], null);
            }
            ((Field) objAccessartificialFrame14).set(null, lValueOf17);
        } else {
            Object[] objArr101115 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1145758013};
            byte[] bArr4115 = $$d;
            Object[] objArr101116 = new Object[1];
            c(bArr4115[4], bArr4115[80], bArr4115[133], objArr101116);
            Class<?> cls119 = Class.forName((String) objArr101116[0]);
            Object[] objArr101117 = new Object[1];
            c(bArr4115[4], bArr4115[602], bArr4115[25], objArr101117);
            objArr9 = (Object[]) cls119.getMethod((String) objArr101117[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr101115);
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame13 == null) {
                int i1811111 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char scrollBarFadeDuration7 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                int capsMode10 = 684 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr4116 = $$a;
                Object[] objArr101118 = new Object[1];
                a((byte) (-bArr4116[12]), bArr4116[22], bArr4116[0], objArr101118);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i1811111, scrollBarFadeDuration7, capsMode10, -1456483158, false, (String) objArr101118[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, objArr9);
            Long lValueOf18 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame14 == null) {
                int iCombineMeasuredStates8 = 30 - View.combineMeasuredStates(0, 0);
                char c16 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                int iLastIndexOf12 = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                byte[] bArr4117 = $$a;
                Object[] objArr101119 = new Object[1];
                a(bArr4117[54], bArr4117[5], bArr4117[98], objArr101119);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates8, c16, iLastIndexOf12, -1583976536, false, (String) objArr101119[0], null);
            }
            ((Field) objAccessartificialFrame14).set(null, lValueOf18);
        }
        i13 = ((int[]) objArr9[1])[0];
        i14 = ((int[]) objArr9[0])[0];
        if (i14 == i13) {
            int i19112 = artificialFrame + 49;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i19112 % 128;
            int i19113 = i19112 % 2;
            int i19114 = ((int[]) objArr9[2])[0];
            Object[] objArr1026 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
            int iNextInt6 = new Random().nextInt(31145471);
            int i19115 = ~((-623001739) | iNextInt6);
            int i19116 = i19114 + (-6993738) + ((269032532 | i19115) * (-476)) + (i19115 * 952) + ((~((~iNextInt6) | (-623001739))) * 476);
            int i19117 = i19116 ^ (i19116 << 13);
            int i20110 = i19117 ^ (i19117 >>> 17);
            ((int[]) objArr1026[2])[0] = i20110 ^ (i20110 << 5);
            return;
        }
        new ArrayList().add((String) objArr9[3]);
        Object[] objArr1027 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) 381811016) << 32)), Long.valueOf(381811032)};
        byte[] bArr4118 = $$d;
        Object[] objArr1028 = new Object[1];
        c(bArr4118[4], bArr4118[16], (short) 294, objArr1028);
        Class<?> cls1110 = Class.forName((String) objArr1028[0]);
        byte b113 = bArr4118[410];
        Object[] objArr11110 = new Object[1];
        c(b113, (byte) (b113 + 4), (short) 646, objArr11110);
        cls1110.getMethod((String) objArr11110[0], Long.TYPE, Long.TYPE).invoke(null, objArr1027);
        int i20111 = ((int[]) objArr9[2])[0];
        Object[] objArr11111 = {new int[]{((int[]) objArr9[0])[0]}, new int[]{((int[]) objArr9[1])[0]}, new int[1], (String) objArr9[3]};
        int iMyTid5 = Process.myTid();
        int i20112 = i20111 + (((~(iMyTid5 | 148389915)) | 830233859) * 56) + 654744750 + (((~((~iMyTid5) | 830233859)) | 148389915) * 56);
        int i20113 = (i20112 << 13) ^ i20112;
        int i20114 = i20113 ^ (i20113 >>> 17);
        ((int[]) objArr11111[2])[0] = i20114 ^ (i20114 << 5);
    }

    static void accessartificialFrame() {
        TopicBuilder = (char) 16448;
        ICustomTabsCallback = (char) 40721;
        extraCallbackWithResult = (char) 22628;
        onMessageChannelReady = (char) 38552;
    }
}
