package io.invertase.notifee;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import app.notifee.core.Logger;
import app.notifee.core.Notifee;
import app.notifee.core.interfaces.MethodCallResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.common.base.Ascii;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes.dex */
public class NotifeeApiModule extends ReactContextBaseJavaModule implements PermissionListener {
    private static final int NOTIFICATION_TYPE_ALL = 0;
    private static final int NOTIFICATION_TYPE_DISPLAYED = 1;
    private static final int NOTIFICATION_TYPE_TRIGGER = 2;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public NotifeeApiModule(@NonNull ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static String getMainComponent(@NonNull String str) {
        return Notifee.getInstance().getMainComponent(str);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        NotifeeReactUtils.clearRunningHeadlessTasks();
    }

    @ReactMethod
    public void cancelAllNotifications(final Promise promise) {
        Notifee.getInstance().cancelAllNotifications(0, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda21
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void cancelDisplayedNotifications(final Promise promise) {
        Notifee.getInstance().cancelAllNotifications(1, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda9
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void cancelTriggerNotifications(final Promise promise) {
        Notifee.getInstance().cancelAllNotifications(2, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda28
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void cancelAllNotificationsWithIds(ReadableArray readableArray, int i, String str, final Promise promise) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(readableArray.getString(i2));
        }
        Notifee.getInstance().cancelAllNotificationsWithIds(i, arrayList, str, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda8
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void getDisplayedNotifications(final Promise promise) {
        Notifee.getInstance().getDisplayedNotifications(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda6
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (List<Bundle>) obj);
            }
        });
    }

    @ReactMethod
    public void getTriggerNotifications(final Promise promise) {
        Notifee.getInstance().getTriggerNotifications(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda30
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (List<Bundle>) obj);
            }
        });
    }

    @ReactMethod
    public void getTriggerNotificationIds(final Promise promise) {
        Notifee.getInstance().getTriggerNotificationIds(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda18
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseStringListResolver(promise, exc, (List) obj);
            }
        });
    }

    @ReactMethod
    public void createChannel(ReadableMap readableMap, final Promise promise) {
        Notifee.getInstance().createChannel(Arguments.toBundle(readableMap), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda14
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void createChannels(ReadableArray readableArray, final Promise promise) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(Arguments.toBundle(readableArray.getMap(i)));
        }
        Notifee.getInstance().createChannels(arrayList, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda11
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void createChannelGroup(ReadableMap readableMap, final Promise promise) {
        Notifee.getInstance().createChannelGroup(Arguments.toBundle(readableMap), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda10
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void createChannelGroups(ReadableArray readableArray, final Promise promise) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(Arguments.toBundle(readableArray.getMap(i)));
        }
        Notifee.getInstance().createChannelGroups(arrayList, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda0
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void deleteChannel(String str, final Promise promise) {
        Notifee.getInstance().deleteChannel(str, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda31
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void deleteChannelGroup(String str, final Promise promise) {
        Notifee.getInstance().deleteChannelGroup(str, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda15
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void displayNotification(ReadableMap readableMap, final Promise promise) {
        Notifee.getInstance().displayNotification(Arguments.toBundle(readableMap), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda5
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void openAlarmPermissionSettings(final Promise promise) {
        Notifee.getInstance().openAlarmPermissionSettings(getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda17
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void createTriggerNotification(ReadableMap readableMap, ReadableMap readableMap2, final Promise promise) {
        Notifee.getInstance().createTriggerNotification(Arguments.toBundle(readableMap), Arguments.toBundle(readableMap2), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda26
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void getChannels(final Promise promise) {
        Notifee.getInstance().getChannels(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda19
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (List<Bundle>) obj);
            }
        });
    }

    @ReactMethod
    public void getChannel(String str, final Promise promise) {
        Notifee.getInstance().getChannel(str, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda3
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
            }
        });
    }

    @ReactMethod
    public void getChannelGroups(final Promise promise) {
        Notifee.getInstance().getChannelGroups(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda13
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (List<Bundle>) obj);
            }
        });
    }

    @ReactMethod
    public void getChannelGroup(String str, final Promise promise) {
        Notifee.getInstance().getChannel(str, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda32
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
            }
        });
    }

    @ReactMethod
    public void isChannelCreated(String str, final Promise promise) {
        Notifee.getInstance().isChannelCreated(str, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda22
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseBooleanResolver(promise, exc, (Boolean) obj);
            }
        });
    }

    @ReactMethod
    public void isChannelBlocked(String str, final Promise promise) {
        Notifee.getInstance().isChannelBlocked(str, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda2
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseBooleanResolver(promise, exc, (Boolean) obj);
            }
        });
    }

    @ReactMethod
    public void getInitialNotification(final Promise promise) {
        Notifee.getInstance().getInitialNotification(getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda12
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
            }
        });
    }

    @ReactMethod
    public void getNotificationSettings(final Promise promise) {
        Notifee.getInstance().getNotificationSettings(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda7
            private static final byte[] $$c = {70, -123, Ascii.CR, 112};
            private static final int $$d = 196;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {66, -107, -4, -33, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -50};
            private static final int $$b = 197;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] IPostMessageService = {38285, 38358, 38350, 38382, 38279, 38374, 38353, 38350, 38355, 38353, 38345, 38357, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38380, 38174, 38174, 38189, 38189, 38170, 38172, 38170, 38174, 38182, 38178, 38174, 38170, 38168, 38192, 38190, 38172, 38178, 38287, 38365, 38361, 38357, 38353, 38351, 38375, 38280, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38359, 38357, 38357, 38372, 38372, 38353, 38355, 38353, 38187, 38044, 38053, 38051, 38048, 38282, 38360, 38391, 38391, 38363, 38364, 38356, 38353, 38360, 38363, 38366, 38360, 38359, 38390, 38383, 38357, 38390, 38389, 38355, 38356, 38390, 38387, 38356, 38356, 38353, 38382, 38386, 38355, 38273, 38336, 38337, 38343, 38340, 38337, 38202, 38205, 38341, 38340, 38367, 38362, 38200, 38368};

            /* JADX WARN: Code duplicated, block: B:10:0x0024  */
            /* JADX WARN: Code duplicated, block: B:8:0x001e  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r6, byte r7, short r8) {
                /*
                    int r8 = r8 * 3
                    int r8 = 122 - r8
                    int r7 = r7 * 3
                    int r7 = 1 - r7
                    int r6 = r6 * 3
                    int r6 = 4 - r6
                    byte[] r0 = io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda7.$$c
                    byte[] r1 = new byte[r7]
                    r2 = 0
                    if (r0 != 0) goto L16
                    r3 = r7
                    r4 = r2
                    goto L26
                L16:
                    r3 = r2
                L17:
                    int r4 = r3 + 1
                    byte r5 = (byte) r8
                    r1[r3] = r5
                    if (r4 != r7) goto L24
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    return r6
                L24:
                    r3 = r0[r6]
                L26:
                    int r8 = r8 + r3
                    int r6 = r6 + 1
                    r3 = r4
                    goto L17
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda7.$$e(int, byte, short):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0020  */
            /* JADX WARN: Code duplicated, block: B:8:0x0018  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0022). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(byte r6, int r7, int r8, java.lang.Object[] r9) {
                /*
                    byte[] r0 = io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda7.$$a
                    int r7 = r7 + 66
                    int r6 = 71 - r6
                    int r8 = 28 - r8
                    byte[] r1 = new byte[r8]
                    r2 = 0
                    if (r0 != 0) goto L10
                    r3 = r6
                    r4 = r2
                    goto L22
                L10:
                    r3 = r2
                L11:
                    int r4 = r3 + 1
                    byte r5 = (byte) r7
                    r1[r3] = r5
                    if (r4 != r8) goto L20
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L20:
                    r3 = r0[r6]
                L22:
                    int r6 = r6 + 1
                    int r7 = r7 + r3
                    int r7 = r7 + (-5)
                    r3 = r4
                    goto L11
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda7.b(byte, int, int, java.lang.Object[]):void");
            }

            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
            }

            private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
                int i;
                char[] cArr;
                int i2;
                int i3 = 2;
                int i4 = 2 % 2;
                onPostMessage onpostmessage = new onPostMessage();
                int i5 = 0;
                int i6 = iArr[0];
                int i7 = 1;
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr2 = IPostMessageService;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i11 = 0;
                    while (i11 < length) {
                        int i12 = $11 + 65;
                        $10 = i12 % 128;
                        if (i12 % i3 != 0) {
                            try {
                                Object[] objArr2 = new Object[i7];
                                objArr2[i5] = Integer.valueOf(cArr2[i11]);
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                                if (objAccessartificialFrame == null) {
                                    int capsMode = 11 - TextUtils.getCapsMode("", i5, i5);
                                    char c = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(i5, i5) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i5, i5) == 0L ? 0 : -1)));
                                    int iResolveSize = View.resolveSize(i5, i5) + 1562;
                                    byte b = (byte) i5;
                                    byte b2 = b;
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(capsMode, c, iResolveSize, 178318710, false, $$e(b, b2, (byte) (b2 | 19)), new Class[]{Integer.TYPE});
                                }
                                cArr3[i11] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                                i11--;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } else {
                            try {
                                Object[] objArr3 = {Integer.valueOf(cArr2[i11])};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                                if (objAccessartificialFrame2 == null) {
                                    byte b3 = (byte) 0;
                                    byte b4 = b3;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - (KeyEvent.getMaxKeyCode() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), 1562 - ExpandableListView.getPackedPositionType(0L), 178318710, false, $$e(b3, b4, (byte) (b4 | 19)), new Class[]{Integer.TYPE});
                                }
                                cArr3[i11] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                                i11++;
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        }
                        i3 = 2;
                        i5 = 0;
                        i7 = 1;
                    }
                    cArr2 = cArr3;
                }
                char[] cArr4 = new char[i8];
                System.arraycopy(cArr2, i6, cArr4, 0, i8);
                if (bArr != null) {
                    char[] cArr5 = new char[i8];
                    onpostmessage.a = 0;
                    int i13 = $10 + 31;
                    $11 = i13 % 128;
                    if (i13 % 2 == 0) {
                        int i14 = 4 / 4;
                    }
                    char c2 = 0;
                    while (onpostmessage.a < i8) {
                        int i15 = $11 + 19;
                        $10 = i15 % 128;
                        int i16 = i15 % 2;
                        if (bArr[onpostmessage.a] == 1) {
                            int i17 = onpostmessage.a;
                            Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c2)};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 2441, -850656813, false, $$e(b5, b6, (byte) (b6 | Ascii.DC2)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr5[i17] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                        } else {
                            int i18 = onpostmessage.a;
                            Object[] objArr5 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c2)};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                            if (objAccessartificialFrame4 == null) {
                                byte b7 = (byte) 0;
                                byte b8 = b7;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - TextUtils.indexOf("", ""), (char) (TextUtils.lastIndexOf("", '0') + 1), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1561, 1918398056, false, $$e(b7, b8, b8), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr5[i18] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                        }
                        c2 = cArr5[onpostmessage.a];
                        Object[] objArr6 = {onpostmessage, onpostmessage};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                        if (objAccessartificialFrame5 == null) {
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(22 - KeyEvent.normalizeMetaState(0), (char) (29363 - KeyEvent.normalizeMetaState(0)), 215 - (ViewConfiguration.getScrollBarSize() >> 8), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    }
                    cArr4 = cArr5;
                }
                if (i10 > 0) {
                    char[] cArr6 = new char[i8];
                    System.arraycopy(cArr4, 0, cArr6, 0, i8);
                    int i19 = i8 - i10;
                    System.arraycopy(cArr6, 0, cArr4, i19, i10);
                    System.arraycopy(cArr6, i10, cArr4, 0, i19);
                }
                if (z) {
                    int i20 = $10 + 47;
                    $11 = i20 % 128;
                    if (i20 % 2 == 0) {
                        cArr = new char[i8];
                        i = 0;
                    } else {
                        i = 0;
                        cArr = new char[i8];
                    }
                    onpostmessage.a = i;
                    int i21 = $11 + 51;
                    $10 = i21 % 128;
                    int i22 = 2;
                    if (i21 % 2 != 0) {
                        int i23 = 2 / 2;
                    }
                    while (onpostmessage.a < i8) {
                        int i24 = $10 + 123;
                        $11 = i24 % 128;
                        if (i24 % i22 == 0) {
                            cArr[onpostmessage.a] = cArr4[(i8 % onpostmessage.a) / 0];
                            i2 = onpostmessage.a;
                        } else {
                            cArr[onpostmessage.a] = cArr4[(i8 - onpostmessage.a) - 1];
                            i2 = onpostmessage.a + 1;
                        }
                        onpostmessage.a = i2;
                        i22 = 2;
                    }
                    cArr4 = cArr;
                }
                if (i9 > 0) {
                    int i25 = 0;
                    while (true) {
                        onpostmessage.a = i25;
                        if (onpostmessage.a >= i8) {
                            break;
                        }
                        cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[2]);
                        i25 = onpostmessage.a + 1;
                    }
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
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r30, int r31, int r32, int r33) {
                /*
                    Method dump skipped, instruction units count: 2705
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda7.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        });
    }

    @ReactMethod
    public void requestPermission(final Promise promise) {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            Notifee.getInstance().getNotificationSettings(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda23
                @Override // app.notifee.core.interfaces.MethodCallResult
                public final void onComplete(Exception exc, Object obj) {
                    NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
                }
            });
            return;
        }
        PermissionAwareActivity permissionAwareActivity = (PermissionAwareActivity) getCurrentActivity();
        if (permissionAwareActivity == null) {
            Logger.d(BackgroundGeolocation.ACTION_REQUEST_PERMISSION, "Unable to get permissionAwareActivity for " + i);
            Notifee.getInstance().getNotificationSettings(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda24
                @Override // app.notifee.core.interfaces.MethodCallResult
                public final void onComplete(Exception exc, Object obj) {
                    NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
                }
            });
            return;
        }
        Notifee.getInstance().setRequestPermissionCallback(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda25
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
            }
        });
        permissionAwareActivity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, Notifee.REQUEST_CODE_NOTIFICATION_PERMISSION, this);
    }

    @ReactMethod
    public void openNotificationSettings(String str, final Promise promise) {
        Notifee.getInstance().openNotificationSettings(str, getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda29
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void openBatteryOptimizationSettings(final Promise promise) {
        Notifee.getInstance().openBatteryOptimizationSettings(getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda16
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void isBatteryOptimizationEnabled(final Promise promise) {
        Notifee.getInstance().isBatteryOptimizationEnabled(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda20
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseBooleanResolver(promise, exc, (Boolean) obj);
            }
        });
    }

    @ReactMethod
    public void getPowerManagerInfo(final Promise promise) {
        Notifee.getInstance().getPowerManagerInfo(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda4
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc, (Bundle) obj);
            }
        });
    }

    @ReactMethod
    public void openPowerManagerSettings(final Promise promise) {
        Notifee.getInstance().openPowerManagerSettings(getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda27
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void stopForegroundService(final Promise promise) {
        Notifee.getInstance().stopForegroundService(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda1
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeReactUtils.promiseResolver(promise, exc);
            }
        });
    }

    @ReactMethod
    public void hideNotificationDrawer() {
        NotifeeReactUtils.hideNotificationDrawer();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "NotifeeApiModule";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("ANDROID_API_LEVEL", Integer.valueOf(Build.VERSION.SDK_INT));
        return map;
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        return Notifee.getInstance().onRequestPermissionsResult(i, strArr, iArr);
    }
}
