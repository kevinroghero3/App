package com.google.maps.android.ui;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ExpandableListView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o._CREATION;
import o.extraCallback;

/* JADX INFO: loaded from: classes3.dex */
public class AnimationUtil {
    public static void animateMarkerTo(final Marker marker, final LatLng latLng) {
        final LatLngInterpolator.Linear linear = new LatLngInterpolator.Linear();
        final LatLng position = marker.getPosition();
        final Handler handler = new Handler();
        final long jUptimeMillis = SystemClock.uptimeMillis();
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        handler.post(new Runnable() { // from class: com.google.maps.android.ui.AnimationUtil.1
            long elapsed;
            float t;
            float v;

            @Override // java.lang.Runnable
            public void run() {
                long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
                this.elapsed = jUptimeMillis2;
                float f = jUptimeMillis2 / 2000.0f;
                this.t = f;
                float interpolation = accelerateDecelerateInterpolator.getInterpolation(f);
                this.v = interpolation;
                marker.setPosition(linear.interpolate(interpolation, position, latLng));
                if (this.t < 1.0f) {
                    handler.postDelayed(this, 16L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface LatLngInterpolator {
        LatLng interpolate(float f, LatLng latLng, LatLng latLng2);

        public static class Linear implements LatLngInterpolator {
            private static final byte[] $$c = {102, -25, -78, -11};
            private static final int $$d = 98;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {103, 5, 74, Ascii.SYN, 50, -50, -14, -3, -20, -1, -22, 3, -8, -1, 6, -29, -36, -8, -3, 0, 8, -20, 9, -14, 5, -8, -5, 2, -18, -3, -16, -5, -10, -2, -5, -27, -22, Ascii.DLE, -31, -5, -16, -32, -8, -6, 9, -5, -11, -10, -4, -10, -18};
            private static final int $$b = 156;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] _CREATION = {6540, 64550, 53950, 43187, 36675, 25887, 31696, 20872, 13351, 2787, 57533, 6540, 64550, 53950, 43179, 36688, 25858, 31696, 20874, 13349, 2789, 57590, 51022, 56587, 46043, 35209, 27681, 17135, 22714, 16212, 5406, 60352, 49560, 42038, 6607, 7988, 64144, 54347, 44569, 35303, 25505, 6554, 64548, 53989, 43176, 36679, 25887, 31696, 61768, 5372, 14883, 16505, 26518, 36302, 37651, 47435, 56549, 27003, 36043, 41493, 55363, 65507, 5605, 2877, 8561, 17631, 31258, 36890, 47037, 44517, 24211, 47906, 38368, 61360, 51286, 6542, 64571, 54015, 43192, 36688, 25868, 31706, 20884, 6542, 64571, 54015, 43197, 36673, 25858, 31704, 20883, 13347, 2802, 57516, 51008, 56606, 46041, 49581, 9229, 2780, 28821, 22390, 48418, 41953, 37944, 29069, 24393, 9479, 739, 59581, 63026, 6541, 64552, 54014, 43186, 36694, 25860, 31694, 20890, 13364, 2748, 57515, 51031, 56587, 46017, 35209, 27700, 63429, 4724, 15550, 18167, 24840, 35666, 38298, 49092, 55905, 6538, 64571, 54001, 43192, 36679, 25885, 31701, 20875, 13358, 2727, 6609, 64570, 53993, 43176, 36621, 25867, 31687, 20944, 13365, 2804, 57524, 51018, 56580, 46016, 35204, 27752, 17131, 22711, 16198, 5380, 60352, 49566, 42017, 49548, 9328, 2728, 28912, 52880, 11131, 1448, 32745, 22551, 45641, 44184, 34449, 58213, 56761, 14327, 47058, 21049, 31978, 1707, 8533, 51979, 54746, 65491, 39478, 42224, 20146, 26958, 6609, 64570, 53993, 43176, 36694, 25864, 31705, 20944, 13374, 2803, 57521, 51021, 17779, 41112, 36432, 62480, 54254, 46293, 20863, 32743, 1504, 8718, 51293, 54913, 64706, 39217, 42912, 19950, 27145, 28743, 6609, 64557, 54001, 43183, 36675, 25922, 31704, 20880, 13349, 2800, 57524, 50956, 6609, 64557, 54001, 43183, 36675, 25922, 31704, 20880, 13349, 2800, 57524, 50956, 56584, 46044, 35218, 27752, 6609, 64557, 54001, 43183, 36675, 25922, 31704, 20880, 13349, 2800, 57524, 50956, 56594, 46039, 35221, 27689, 17057, 6609, 64570, 53993, 43176, 36694, 25864, 31705, 20944, 13348, 2808, 57526, 50956, 56644, 46032, 35204, 27699, 17057, 34391, 25532, 19823, 14126, 4304, 64142, 58463, 52822, 43938, 38270, 32560, 22666, 17034, 11346, 5651, 62381, 56699, 51006, 41152, 35464, 29723, 6609, 64572, 53987, 43177, 36621, 25871, 31709, 20881, 13417, 6609, 64570, 53989, 43252, 36672, 25860, 31706, 20944, 65201, 7021, 13737, 20470, 26731, 33362, 18122, 41791, 36324, 63413, 53335, 14850, 9436, 6609, 64570, 53993, 43176, 36621, 25867, 31687, 20944, 13365, 2804, 57524, 51018, 56580, 46016, 35204, 27752, 17150, 22710, 16204, 5378, 60369, 49540, 6540, 64572, 54014};
            private static long _BOUNDARY = -2942325397293368247L;
            private static char[] ArtificialStackFrames = {44408, 44388, 44335, 44415, 44395, 44414, 44410, 44389, 44334, 44404, 44390, 44400, 44392, 44407, 44383, 44339, 44386, 44391, 44398, 44402, 44409, 44396, 44387, 44412, 44405, 44333, 44393, 44397, 44403, 44385, 44372, 44342, 44394, 44399, 44413, 44406};
            private static char coroutineCreation = 39068;

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(short r6, int r7, byte r8) {
                /*
                    int r6 = 106 - r6
                    int r7 = r7 * 3
                    int r7 = 3 - r7
                    int r8 = r8 * 2
                    int r0 = r8 + 1
                    byte[] r1 = com.google.maps.android.ui.AnimationUtil.LatLngInterpolator.Linear.$$c
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    if (r1 != 0) goto L15
                    r3 = r7
                    r7 = r8
                    r4 = r2
                    goto L2b
                L15:
                    r3 = r2
                L16:
                    byte r4 = (byte) r6
                    r0[r3] = r4
                    int r4 = r3 + 1
                    if (r3 != r8) goto L23
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    return r6
                L23:
                    int r7 = r7 + 1
                    r3 = r1[r7]
                    r5 = r7
                    r7 = r6
                    r6 = r3
                    r3 = r5
                L2b:
                    int r6 = -r6
                    int r6 = r6 + r7
                    r7 = r3
                    r3 = r4
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.ui.AnimationUtil.LatLngInterpolator.Linear.$$e(short, int, byte):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0020  */
            /* JADX WARN: Code duplicated, block: B:8:0x0018  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0028). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(int r6, byte r7, short r8, java.lang.Object[] r9) {
                /*
                    int r6 = r6 + 4
                    byte[] r0 = com.google.maps.android.ui.AnimationUtil.LatLngInterpolator.Linear.$$a
                    int r7 = r7 + 2
                    int r8 = r8 + 66
                    byte[] r1 = new byte[r7]
                    r2 = 0
                    if (r0 != 0) goto L10
                    r3 = r7
                    r4 = r2
                    goto L28
                L10:
                    r3 = r2
                L11:
                    byte r4 = (byte) r8
                    r1[r3] = r4
                    int r3 = r3 + 1
                    if (r3 != r7) goto L20
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L20:
                    int r6 = r6 + 1
                    r4 = r0[r6]
                    r5 = r3
                    r3 = r8
                    r8 = r4
                    r4 = r5
                L28:
                    int r8 = -r8
                    int r3 = r3 + r8
                    int r8 = r3 + (-5)
                    r3 = r4
                    goto L11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.ui.AnimationUtil.LatLngInterpolator.Linear.b(int, byte, short, java.lang.Object[]):void");
            }

            @Override // com.google.maps.android.ui.AnimationUtil.LatLngInterpolator
            public LatLng interpolate(float f, LatLng latLng, LatLng latLng2) {
                double d = latLng2.latitude;
                double d2 = latLng.latitude;
                double d3 = f;
                double dSignum = latLng2.longitude - latLng.longitude;
                if (Math.abs(dSignum) > 180.0d) {
                    dSignum -= Math.signum(dSignum) * 360.0d;
                }
                return new LatLng(((d - d2) * d3) + d2, (dSignum * d3) + latLng.longitude);
            }

            /* JADX WARN: Code duplicated, block: B:43:0x0219  */
            /* JADX WARN: Code duplicated, block: B:44:0x021a  */
            private static void c(char c, int i, int i2, Object[] objArr) throws Throwable {
                int i3;
                Throwable cause;
                int i4 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                int i5 = $11 + 15;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                while (true) {
                    i3 = 3;
                    if (_creation.b >= i2) {
                        break;
                    }
                    int i7 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i7])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            int i8 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 7;
                            char mode = (char) (View.MeasureSpec.getMode(0) + 9279);
                            int iLastIndexOf = 1976 - TextUtils.lastIndexOf("", '0');
                            byte b = (byte) ($$d & 15);
                            byte b2 = (byte) (b - 2);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i8, mode, iLastIndexOf, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 30, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49363), ExpandableListView.getPackedPositionGroup(0L) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 3;
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (View.resolveSize(0, 0) + 30068), View.MeasureSpec.getMode(0) + 816, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } catch (Throwable th) {
                        cause = th.getCause();
                        if (cause != null) {
                            throw th;
                        }
                        throw cause;
                    }
                    cause = th.getCause();
                    if (cause != null) {
                        throw th;
                    }
                    throw cause;
                }
                char[] cArr = new char[i2];
                _creation.b = 0;
                while (_creation.b < i2) {
                    int i9 = $10 + b.i;
                    $11 = i9 % 128;
                    if (i9 % 2 == 0) {
                        cArr[_creation.b] = (char) jArr[_creation.b];
                        Object[] objArr5 = {_creation, _creation};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) i3;
                            byte b8 = (byte) (b7 - 3);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 25, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30067), 816 - TextUtils.indexOf("", "", 0), 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        int i10 = 16 / 0;
                    } else {
                        cArr[_creation.b] = (char) jArr[_creation.b];
                        Object[] objArr6 = {_creation, _creation};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame5 == null) {
                            byte b9 = (byte) i3;
                            byte b10 = (byte) (b9 - 3);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(25 - View.combineMeasuredStates(0, 0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 30067), 816 - View.MeasureSpec.makeMeasureSpec(0, 0), 1897803493, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    }
                    i3 = 3;
                }
                objArr[0] = new String(cArr);
            }

            private static void a(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
                int i2;
                Object obj;
                int i3 = 2 % 2;
                extraCallback extracallback = new extraCallback();
                char[] cArr2 = ArtificialStackFrames;
                int i4 = -1819279892;
                Object obj2 = null;
                int i5 = 9;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i6 = 0;
                    while (i6 < length) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) i5;
                                byte b3 = (byte) 0;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(15 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 20488), KeyEvent.normalizeMetaState(0) + 2148, 216710116, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE});
                            }
                            cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i6++;
                            i4 = -1819279892;
                            i5 = 9;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr2 = cArr3;
                }
                Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                if (objAccessartificialFrame2 == null) {
                    byte b4 = (byte) 0;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.lastIndexOf("", '0'), (char) (View.resolveSizeAndState(0, 0, 0) + 20488), Color.rgb(0, 0, 0) + 16779364, 216710116, false, $$e((byte) 9, b4, b4), new Class[]{Integer.TYPE});
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
                    extracallback.a = 0;
                    while (extracallback.a < i2) {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a + 1];
                        if (extracallback.createBrowser == extracallback.c) {
                            int i7 = $11 + 23;
                            $10 = i7 % 128;
                            int i8 = i7 % 2;
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            obj = obj2;
                        } else {
                            Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame3 == null) {
                                int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 46;
                                char minimumFlingVelocity = (char) (58859 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                                int i9 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2464;
                                byte length2 = (byte) $$c.length;
                                byte b5 = (byte) (length2 - 4);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, minimumFlingVelocity, i9, 276640984, false, $$e(length2, b5, b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                int i10 = $10 + 25;
                                $11 = i10 % 128;
                                int i11 = i10 % 2;
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    byte b6 = (byte) 1;
                                    byte b7 = (byte) (b6 - 1);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24, (char) (ViewConfiguration.getPressedStateDuration() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 792, -834291897, false, $$e(b6, b7, b7), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i12 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i12];
                            } else {
                                obj = null;
                                if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i13 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i14 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[i13];
                                    cArr4[extracallback.a + 1] = cArr2[i14];
                                } else {
                                    int i15 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i16 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr2[i15];
                                    cArr4[extracallback.a + 1] = cArr2[i16];
                                }
                            }
                        }
                        extracallback.a += 2;
                        int i17 = $10 + 77;
                        $11 = i17 % 128;
                        int i18 = i17 % 2;
                        obj2 = obj;
                    }
                }
                int i19 = 0;
                while (i19 < i) {
                    cArr4[i19] = (char) (cArr4[i19] ^ 13722);
                    i19++;
                    int i20 = $11 + 13;
                    $10 = i20 % 128;
                    int i21 = i20 % 2;
                }
                objArr[0] = new String(cArr4);
            }

            /* JADX WARN: Multi-variable search skipped. Vars limit reached: 7346 (expected less than 5000) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v1070 */
            /* JADX WARN: Type inference failed for: r2v1115 */
            /* JADX WARN: Type inference failed for: r2v1116 */
            /* JADX WARN: Type inference failed for: r2v1139 */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame$78cbbd35(int r63, int r64, java.lang.Object r65, int r66, boolean r67) {
                /*
                    Method dump skipped, instruction units count: 18675
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.ui.AnimationUtil.LatLngInterpolator.Linear.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
            }
        }
    }
}
