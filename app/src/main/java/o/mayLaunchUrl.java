package o;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.soloader.Elf64;
import com.google.mlkit.common.MlKitException;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.yalantis.ucrop.UCrop;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
public class mayLaunchUrl {
    private int MediaDescriptionCompat1;
    private final Object[] MediaDescriptionCompatApi21;
    public Object MediaDescriptionCompatApi21Builder;
    private final int[] MediaDescriptionCompatBuilder;
    public Object MediaMetadataCompat;
    public float fromParcel;
    private int getMediaUri;
    public int getSubtitle;
    public int getTitle;
    private final long[] setDescription;
    public float setExtras;
    public long setIconBitmap;
    public long setIconUri;
    private final float[] setMediaId;
    public double setMediaUri;
    private final double[] setSubtitle;
    public double setTitle;

    public int _BOUNDARY(int i) {
        switch (i) {
            case 1:
                int i2 = this.MediaDescriptionCompat1 - this.getTitle;
                this.MediaDescriptionCompat1 = i2;
                this.getMediaUri = i2;
                return 0;
            case 2:
                Object[] objArr = this.MediaDescriptionCompatApi21;
                int i3 = this.getMediaUri;
                this.getMediaUri = i3 + 1;
                Object obj = objArr[i3];
                objArr[i3] = null;
                this.MediaMetadataCompat = obj;
                return 0;
            case 3:
                int[] iArr = this.MediaDescriptionCompatBuilder;
                int i4 = this.getMediaUri;
                this.getMediaUri = i4 + 1;
                this.getSubtitle = iArr[i4];
                return 0;
            case 4:
                Object[] objArr2 = this.MediaDescriptionCompatApi21;
                int i5 = this.MediaDescriptionCompat1;
                objArr2[i5] = objArr2[8];
                int[] iArr2 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i5 + 2;
                iArr2[i5 + 1] = 1;
                return 0;
            case 5:
                int[] iArr3 = this.MediaDescriptionCompatBuilder;
                int i6 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i6 + 1;
                iArr3[i6] = 2;
                return 0;
            case 6:
                int i7 = this.MediaDescriptionCompat1;
                int i8 = i7 - 1;
                this.MediaDescriptionCompat1 = i8;
                int[] iArr4 = this.MediaDescriptionCompatBuilder;
                iArr4[i7 - 2] = iArr4[i7 - 2] % iArr4[i8];
                int i9 = i7 - 2;
                this.MediaDescriptionCompat1 = i9;
                this.MediaDescriptionCompatApi21[i9] = null;
                return 0;
            case 8:
                int[] iArr5 = this.MediaDescriptionCompatBuilder;
                int i10 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i10 + 1;
                iArr5[i10] = this.getTitle;
            case 7:
                return 0;
            case 9:
                int[] iArr6 = this.MediaDescriptionCompatBuilder;
                int i11 = this.MediaDescriptionCompat1;
                iArr6[i11] = 101;
                this.MediaDescriptionCompat1 = i11;
                iArr6[i11 - 1] = iArr6[i11 - 1] + iArr6[i11];
                return 0;
            case 10:
                int[] iArr7 = this.MediaDescriptionCompatBuilder;
                int i12 = this.MediaDescriptionCompat1;
                iArr7[i12] = iArr7[i12 - 1];
                this.MediaDescriptionCompat1 = i12 + 2;
                iArr7[i12 + 1] = 128;
                return 0;
            case 11:
                int i13 = this.MediaDescriptionCompat1;
                int i14 = i13 - 1;
                this.MediaDescriptionCompat1 = i14;
                int[] iArr8 = this.MediaDescriptionCompatBuilder;
                iArr8[i13 - 2] = iArr8[i13 - 2] % iArr8[i14];
                return 0;
            case 12:
                int[] iArr9 = this.MediaDescriptionCompatBuilder;
                int i15 = this.MediaDescriptionCompat1;
                iArr9[i15] = 2;
                this.MediaDescriptionCompat1 = i15;
                iArr9[i15 - 1] = iArr9[i15 - 1] % iArr9[i15];
                return 0;
            case 13:
                int i16 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i16;
                this.getSubtitle = this.MediaDescriptionCompatBuilder[i16] == 0 ? 0 : 1;
                return 0;
            case 14:
                int[] iArr10 = this.MediaDescriptionCompatBuilder;
                int i17 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i17 + 1;
                iArr10[i17] = 25;
                return 0;
            case 15:
                int i18 = this.MediaDescriptionCompat1;
                int i19 = i18 - 1;
                int[] iArr11 = this.MediaDescriptionCompatBuilder;
                iArr11[i18 - 2] = iArr11[i18 - 2] + iArr11[i19];
                this.MediaDescriptionCompat1 = i18;
                iArr11[i19] = iArr11[i18 - 2];
                return 0;
            case 16:
                int[] iArr12 = this.MediaDescriptionCompatBuilder;
                int i20 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i20 + 1;
                iArr12[i20] = 128;
                return 0;
            case 17:
                int i21 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i21;
                this.getSubtitle = this.MediaDescriptionCompatBuilder[i21] != 0 ? 0 : 1;
                return 0;
            case 18:
                int[] iArr13 = this.MediaDescriptionCompatBuilder;
                int i22 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i22;
                this.getSubtitle = iArr13[i22];
                return 0;
            case 19:
                int[] iArr14 = this.MediaDescriptionCompatBuilder;
                int i23 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i23 + 1;
                iArr14[i23] = 88;
                return 0;
            case 20:
                int[] iArr15 = this.MediaDescriptionCompatBuilder;
                int i24 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i24 + 1;
                iArr15[i24] = 74;
                return 0;
            case 21:
                Object[] objArr3 = this.MediaDescriptionCompatApi21;
                int i25 = this.MediaDescriptionCompat1;
                Object obj2 = objArr3[i25 - 1];
                objArr3[i25 - 1] = null;
                this.MediaMetadataCompat = obj2;
                return 0;
            case 22:
                for (int i26 = this.MediaDescriptionCompat1 - 1; i26 >= 0; i26--) {
                    this.MediaDescriptionCompatApi21[i26] = null;
                }
                Object[] objArr4 = this.MediaDescriptionCompatApi21;
                this.MediaDescriptionCompat1 = 1;
                objArr4[0] = this.MediaDescriptionCompatApi21Builder;
                return 0;
            case 23:
                int i27 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i27;
                int[] iArr16 = this.MediaDescriptionCompatBuilder;
                iArr16[9] = iArr16[i27];
                return 0;
            case 24:
                Object[] objArr5 = this.MediaDescriptionCompatApi21;
                int i28 = this.MediaDescriptionCompat1;
                objArr5[i28] = objArr5[8];
                int[] iArr17 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i28 + 2;
                iArr17[i28 + 1] = iArr17[9];
                return 0;
            case 25:
                Object[] objArr6 = this.MediaDescriptionCompatApi21;
                int i29 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i29 + 1;
                objArr6[i29] = this.MediaDescriptionCompatApi21Builder;
                return 0;
            case 26:
                int[] iArr18 = this.MediaDescriptionCompatBuilder;
                int i30 = this.MediaDescriptionCompat1;
                iArr18[i30] = 18;
                this.MediaDescriptionCompat1 = i30;
                Object[] objArr7 = this.MediaDescriptionCompatApi21;
                Object obj3 = objArr7[i30 - 1];
                objArr7[i30 - 1] = null;
                iArr18[i30 - 1] = ((byte[]) obj3)[iArr18[i30]];
                return 0;
            case 27:
                int[] iArr19 = this.MediaDescriptionCompatBuilder;
                int i31 = this.MediaDescriptionCompat1;
                iArr19[i31 - 1] = -iArr19[i31 - 1];
                return 0;
            case 28:
                int[] iArr20 = this.MediaDescriptionCompatBuilder;
                int i32 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i32 + 1;
                iArr20[i32] = iArr20[i32 - 1];
                return 0;
            case 29:
                int[] iArr21 = this.MediaDescriptionCompatBuilder;
                int i33 = this.MediaDescriptionCompat1;
                iArr21[i33] = 1;
                this.MediaDescriptionCompat1 = i33;
                iArr21[i33 - 1] = iArr21[i33 - 1] - iArr21[i33];
                return 0;
            case 30:
                int[] iArr22 = this.MediaDescriptionCompatBuilder;
                int i34 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i34 + 1;
                iArr22[i34] = 1;
                return 0;
            case 31:
                Object[] objArr8 = this.MediaDescriptionCompatApi21;
                int i35 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i35 + 1;
                objArr8[i35] = objArr8[i35 - 1];
                return 0;
            case 32:
                int i36 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i36;
                Object[] objArr9 = this.MediaDescriptionCompatApi21;
                Object obj4 = objArr9[i36];
                objArr9[i36] = null;
                objArr9[11] = obj4;
                return 0;
            case 33:
                Object[] objArr10 = this.MediaDescriptionCompatApi21;
                int i37 = this.MediaDescriptionCompat1;
                objArr10[i37] = objArr10[11];
                int[] iArr23 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i37 + 2;
                iArr23[i37 + 1] = 0;
                return 0;
            case 34:
                int i38 = this.MediaDescriptionCompat1;
                int i39 = i38 - 1;
                this.MediaDescriptionCompat1 = i39;
                Object[] objArr11 = this.MediaDescriptionCompatApi21;
                Object obj5 = objArr11[i38 - 2];
                objArr11[i38 - 2] = null;
                objArr11[i38 - 2] = ((Object[]) obj5)[this.MediaDescriptionCompatBuilder[i39]];
                return 0;
            case 35:
                int[] iArr24 = this.MediaDescriptionCompatBuilder;
                int i40 = this.MediaDescriptionCompat1;
                iArr24[i40] = 18;
                this.MediaDescriptionCompat1 = i40;
                Object[] objArr12 = this.MediaDescriptionCompatApi21;
                Object obj6 = objArr12[i40 - 1];
                objArr12[i40 - 1] = null;
                iArr24[i40 - 1] = ((byte[]) obj6)[iArr24[i40]];
                this.MediaDescriptionCompat1 = i40 + 1;
                iArr24[i40] = 1;
                return 0;
            case 36:
                int i41 = this.MediaDescriptionCompat1;
                int i42 = i41 - 1;
                this.MediaDescriptionCompat1 = i42;
                int[] iArr25 = this.MediaDescriptionCompatBuilder;
                iArr25[i41 - 2] = iArr25[i41 - 2] + iArr25[i42];
                return 0;
            case 37:
                int[] iArr26 = this.MediaDescriptionCompatBuilder;
                int i43 = this.MediaDescriptionCompat1;
                iArr26[i43 - 1] = -iArr26[i43 - 1];
                this.MediaDescriptionCompat1 = i43 + 1;
                iArr26[i43] = 1;
                return 0;
            case 38:
                Object[] objArr13 = this.MediaDescriptionCompatApi21;
                int i44 = this.MediaDescriptionCompat1;
                objArr13[i44] = objArr13[11];
                int[] iArr27 = this.MediaDescriptionCompatBuilder;
                iArr27[i44 + 1] = 0;
                int i45 = i44 + 1;
                this.MediaDescriptionCompat1 = i45;
                Object obj7 = objArr13[i44];
                objArr13[i44] = null;
                objArr13[i44] = ((Object[]) obj7)[iArr27[i45]];
                return 0;
            case 39:
                Object[] objArr14 = this.MediaDescriptionCompatApi21;
                int i46 = this.MediaDescriptionCompat1;
                objArr14[i46] = objArr14[i46 - 1];
                int[] iArr28 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i46 + 2;
                iArr28[i46 + 1] = 0;
                return 0;
            case 40:
                int i47 = this.MediaDescriptionCompat1;
                int i48 = i47 - 3;
                this.MediaDescriptionCompat1 = i48;
                Object[] objArr15 = this.MediaDescriptionCompatApi21;
                Object obj8 = objArr15[i48];
                objArr15[i48] = null;
                int i49 = this.MediaDescriptionCompatBuilder[i47 - 2];
                Object obj9 = objArr15[i47 - 1];
                objArr15[i47 - 1] = null;
                ((Object[]) obj8)[i49] = obj9;
                return 0;
            case 41:
                Object[] objArr16 = this.MediaDescriptionCompatApi21;
                int i50 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i50 + 1;
                objArr16[i50] = null;
                return 0;
            case 42:
                long[] jArr = this.setDescription;
                int i51 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i51 + 1;
                jArr[i51] = this.setIconUri;
                return 0;
            case 43:
                long[] jArr2 = this.setDescription;
                int i52 = this.getMediaUri;
                this.getMediaUri = i52 + 1;
                this.setIconBitmap = jArr2[i52];
                return 0;
            case 44:
                int i53 = this.MediaDescriptionCompat1;
                int i54 = i53 - 1;
                Object[] objArr17 = this.MediaDescriptionCompatApi21;
                objArr17[i54] = null;
                this.MediaDescriptionCompat1 = i53;
                objArr17[i54] = objArr17[8];
                return 0;
            case 45:
                Object[] objArr18 = this.MediaDescriptionCompatApi21;
                int i55 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i55 + 1;
                objArr18[i55] = objArr18[8];
                return 0;
            case 46:
                int i56 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i56;
                Object[] objArr19 = this.MediaDescriptionCompatApi21;
                Object obj10 = objArr19[i56];
                objArr19[i56] = null;
                objArr19[10] = obj10;
                return 0;
            case 47:
                int[] iArr29 = this.MediaDescriptionCompatBuilder;
                int i57 = this.MediaDescriptionCompat1;
                iArr29[i57] = 2;
                iArr29[i57 + 1] = 2;
                int i58 = i57 + 1;
                this.MediaDescriptionCompat1 = i58;
                iArr29[i57] = iArr29[i57] % iArr29[i58];
                return 0;
            case 48:
                int i59 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i59;
                this.MediaDescriptionCompatApi21[i59] = null;
                return 0;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                int[] iArr30 = this.MediaDescriptionCompatBuilder;
                int i60 = this.MediaDescriptionCompat1;
                iArr30[i60] = 2;
                this.MediaDescriptionCompat1 = i60;
                iArr30[i60 - 1] = iArr30[i60 - 1] % iArr30[i60];
                int i61 = i60 - 1;
                this.MediaDescriptionCompat1 = i61;
                this.MediaDescriptionCompatApi21[i61] = null;
                return 0;
            case 50:
                int[] iArr31 = this.MediaDescriptionCompatBuilder;
                int i62 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i62 + 1;
                iArr31[i62] = 113;
                return 0;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                int[] iArr32 = this.MediaDescriptionCompatBuilder;
                int i63 = this.MediaDescriptionCompat1;
                iArr32[i63] = 5;
                this.MediaDescriptionCompat1 = i63 + 2;
                iArr32[i63 + 1] = 4;
                return 0;
            case 52:
                int[] iArr33 = this.MediaDescriptionCompatBuilder;
                int i64 = this.MediaDescriptionCompat1;
                iArr33[i64] = 65;
                iArr33[i64 - 1] = iArr33[i64 - 1] + iArr33[i64];
                this.MediaDescriptionCompat1 = i64 + 1;
                iArr33[i64] = iArr33[i64 - 1];
                return 0;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                int[] iArr34 = this.MediaDescriptionCompatBuilder;
                int i65 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i65 + 1;
                iArr34[i65] = 23;
                return 0;
            case 54:
                int[] iArr35 = this.MediaDescriptionCompatBuilder;
                int i66 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i66 + 1;
                iArr35[i66] = 27;
                return 0;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                int[] iArr36 = this.MediaDescriptionCompatBuilder;
                int i67 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i67 + 1;
                iArr36[i67] = 38;
                return 0;
            case 56:
                int[] iArr37 = this.MediaDescriptionCompatBuilder;
                int i68 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i68 + 1;
                iArr37[i68] = 0;
                return 0;
            case 57:
                int[] iArr38 = this.MediaDescriptionCompatBuilder;
                int i69 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i69 + 1;
                iArr38[i69] = iArr38[9];
                return 0;
            case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                int i70 = this.MediaDescriptionCompat1;
                int i71 = i70 - 1;
                int[] iArr39 = this.MediaDescriptionCompatBuilder;
                int i72 = iArr39[i71];
                iArr39[10] = i72;
                this.MediaDescriptionCompat1 = i70;
                iArr39[i71] = i72;
                return 0;
            case 59:
                int i73 = this.MediaDescriptionCompat1;
                int i74 = i73 - 1;
                Object[] objArr20 = this.MediaDescriptionCompatApi21;
                Object obj11 = objArr20[i74];
                objArr20[i74] = null;
                objArr20[11] = obj11;
                objArr20[i74] = obj11;
                int i75 = i73 - 1;
                this.MediaDescriptionCompat1 = i75;
                Object obj12 = objArr20[i75];
                objArr20[i75] = null;
                objArr20[49] = obj12;
                return 0;
            case 60:
                Object[] objArr21 = this.MediaDescriptionCompatApi21;
                int i76 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i76 + 1;
                objArr21[i76] = objArr21[49];
                return 0;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                int[] iArr40 = this.MediaDescriptionCompatBuilder;
                int i77 = this.MediaDescriptionCompat1;
                iArr40[i77] = 1;
                this.MediaDescriptionCompat1 = i77;
                Object[] objArr22 = this.MediaDescriptionCompatApi21;
                Object obj13 = objArr22[i77 - 1];
                objArr22[i77 - 1] = null;
                objArr22[i77 - 1] = ((Object[]) obj13)[iArr40[i77]];
                return 0;
            case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                int[] iArr41 = this.MediaDescriptionCompatBuilder;
                int i78 = this.MediaDescriptionCompat1;
                iArr41[i78] = 0;
                this.MediaDescriptionCompat1 = i78;
                Object[] objArr23 = this.MediaDescriptionCompatApi21;
                Object obj14 = objArr23[i78 - 1];
                objArr23[i78 - 1] = null;
                iArr41[i78 - 1] = ((int[]) obj14)[iArr41[i78]];
                int i79 = i78 - 1;
                this.MediaDescriptionCompat1 = i79;
                iArr41[12] = iArr41[i79];
                return 0;
            case 63:
                int[] iArr42 = this.MediaDescriptionCompatBuilder;
                int i80 = this.MediaDescriptionCompat1;
                iArr42[i80] = iArr42[12];
                long[] jArr3 = this.setDescription;
                jArr3[i80] = iArr42[i80];
                this.MediaDescriptionCompat1 = i80;
                jArr3[13] = jArr3[i80];
                return 0;
            case 64:
                int i81 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i81;
                int[] iArr43 = this.MediaDescriptionCompatBuilder;
                iArr43[15] = iArr43[i81];
                return 0;
            case 65:
                int i82 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i82;
                long[] jArr4 = this.setDescription;
                jArr4[16] = jArr4[i82];
                return 0;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                int i83 = this.MediaDescriptionCompat1;
                int i84 = i83 - 1;
                int[] iArr44 = this.MediaDescriptionCompatBuilder;
                iArr44[15] = iArr44[i84];
                long[] jArr5 = this.setDescription;
                this.MediaDescriptionCompat1 = i83;
                jArr5[i84] = jArr5[13];
                return 0;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                int i85 = this.MediaDescriptionCompat1;
                int i86 = i85 - 1;
                long[] jArr6 = this.setDescription;
                jArr6[18] = jArr6[i86];
                int[] iArr45 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i85;
                iArr45[i86] = 0;
                return 0;
            case 68:
                int i87 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i87;
                int[] iArr46 = this.MediaDescriptionCompatBuilder;
                iArr46[20] = iArr46[i87];
                return 0;
            case UCrop.REQUEST_CROP /* 69 */:
                int[] iArr47 = this.MediaDescriptionCompatBuilder;
                int i88 = this.MediaDescriptionCompat1;
                iArr47[i88] = 0;
                this.MediaDescriptionCompat1 = i88;
                iArr47[21] = iArr47[i88];
                return 0;
            case CoreConstants.OOS_RESET_FREQUENCY /* 70 */:
                int i89 = this.MediaDescriptionCompat1;
                int i90 = i89 - 2;
                this.MediaDescriptionCompat1 = i90;
                int[] iArr48 = this.MediaDescriptionCompatBuilder;
                this.getSubtitle = iArr48[i90] == iArr48[i89 - 1] ? 0 : 1;
                return 0;
            case 71:
                int[] iArr49 = this.MediaDescriptionCompatBuilder;
                int i91 = this.MediaDescriptionCompat1;
                iArr49[i91] = iArr49[21];
                this.MediaDescriptionCompat1 = i91 + 2;
                iArr49[i91 + 1] = 8;
                return 0;
            case SyslogConstants.LOG_CRON /* 72 */:
                long[] jArr7 = this.setDescription;
                int i92 = this.MediaDescriptionCompat1;
                jArr7[i92] = jArr7[18];
                int[] iArr50 = this.MediaDescriptionCompatBuilder;
                iArr50[i92 + 1] = iArr50[21];
                int i93 = i92 + 1;
                this.MediaDescriptionCompat1 = i93;
                jArr7[i92] = jArr7[i92] >> iArr50[i93];
                return 0;
            case 73:
                int[] iArr51 = this.MediaDescriptionCompatBuilder;
                int i94 = this.MediaDescriptionCompat1;
                iArr51[i94 - 1] = (int) this.setDescription[i94 - 1];
                this.MediaDescriptionCompat1 = i94 + 1;
                iArr51[i94] = 255;
                return 0;
            case 74:
                int i95 = this.MediaDescriptionCompat1;
                int i96 = i95 - 1;
                this.MediaDescriptionCompat1 = i96;
                int[] iArr52 = this.MediaDescriptionCompatBuilder;
                iArr52[i95 - 2] = iArr52[i95 - 2] & iArr52[i96];
                return 0;
            case 75:
                int[] iArr53 = this.MediaDescriptionCompatBuilder;
                int i97 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i97 + 1;
                iArr53[i97] = iArr53[15];
                return 0;
            case Base64.mimeLineLength /* 76 */:
                int[] iArr54 = this.MediaDescriptionCompatBuilder;
                int i98 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i98 + 1;
                iArr54[i98] = 6;
                return 0;
            case 77:
                int i99 = this.MediaDescriptionCompat1;
                int i100 = i99 - 1;
                this.MediaDescriptionCompat1 = i100;
                int[] iArr55 = this.MediaDescriptionCompatBuilder;
                iArr55[i99 - 2] = iArr55[i99 - 2] << iArr55[i100];
                return 0;
            case 78:
                int i101 = this.MediaDescriptionCompat1;
                int i102 = i101 - 1;
                int[] iArr56 = this.MediaDescriptionCompatBuilder;
                iArr56[i101 - 2] = iArr56[i101 - 2] + iArr56[i102];
                iArr56[i102] = iArr56[15];
                this.MediaDescriptionCompat1 = i101 + 1;
                iArr56[i101] = 16;
                return 0;
            case 79:
                int i103 = this.MediaDescriptionCompat1;
                int i104 = i103 - 1;
                int[] iArr57 = this.MediaDescriptionCompatBuilder;
                iArr57[i103 - 2] = iArr57[i103 - 2] + iArr57[i104];
                iArr57[i104] = iArr57[15];
                int i105 = i103 - 1;
                this.MediaDescriptionCompat1 = i105;
                iArr57[i103 - 2] = iArr57[i103 - 2] - iArr57[i105];
                return 0;
            case 80:
                int[] iArr58 = this.MediaDescriptionCompatBuilder;
                iArr58[21] = iArr58[21] + 1;
                return 0;
            case 81:
                int[] iArr59 = this.MediaDescriptionCompatBuilder;
                int i106 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i106 + 1;
                iArr59[i106] = iArr59[20];
                return 0;
            case 82:
                long[] jArr8 = this.setDescription;
                int i107 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i107 + 1;
                jArr8[i107] = jArr8[16];
                return 0;
            case 83:
                int i108 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i108;
                long[] jArr9 = this.setDescription;
                jArr9[18] = jArr9[i108];
                int[] iArr60 = this.MediaDescriptionCompatBuilder;
                iArr60[20] = iArr60[20] + 1;
                return 0;
            case 84:
                int[] iArr61 = this.MediaDescriptionCompatBuilder;
                int i109 = this.MediaDescriptionCompat1;
                iArr61[i109] = 16;
                this.MediaDescriptionCompat1 = i109;
                iArr61[i109 - 1] = iArr61[i109 - 1] >> iArr61[i109];
                return 0;
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                int i110 = this.MediaDescriptionCompat1;
                int i111 = i110 - 1;
                int[] iArr62 = this.MediaDescriptionCompatBuilder;
                iArr62[i110 - 2] = iArr62[i110 - 2] + iArr62[i111];
                long[] jArr10 = this.setDescription;
                this.MediaDescriptionCompat1 = i110;
                jArr10[i111] = 0;
                return 0;
            case 86:
                int[] iArr63 = this.MediaDescriptionCompatBuilder;
                int i112 = this.MediaDescriptionCompat1;
                iArr63[i112 - 1] = (byte) iArr63[i112 - 1];
                return 0;
            case 87:
                int[] iArr64 = this.MediaDescriptionCompatBuilder;
                int i113 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i113 + 1;
                iArr64[i113] = -12;
                return 0;
            case SyslogConstants.LOG_FTP /* 88 */:
                long[] jArr11 = this.setDescription;
                int i114 = this.MediaDescriptionCompat1;
                jArr11[i114] = 0;
                int[] iArr65 = this.MediaDescriptionCompatBuilder;
                iArr65[i114 - 1] = (jArr11[i114 - 1] > jArr11[i114] ? 1 : (jArr11[i114 - 1] == jArr11[i114] ? 0 : -1));
                int i115 = i114 - 1;
                this.MediaDescriptionCompat1 = i115;
                iArr65[i114 - 2] = iArr65[i114 - 2] + iArr65[i115];
                return 0;
            case 89:
                int[] iArr66 = this.MediaDescriptionCompatBuilder;
                int i116 = this.MediaDescriptionCompat1;
                iArr66[i116] = 22;
                this.MediaDescriptionCompat1 = i116;
                iArr66[i116 - 1] = iArr66[i116 - 1] >> iArr66[i116];
                iArr66[i116 - 1] = (short) iArr66[i116 - 1];
                return 0;
            case 90:
                int i117 = this.MediaDescriptionCompat1;
                int i118 = i117 - 1;
                this.MediaDescriptionCompat1 = i118;
                int[] iArr67 = this.MediaDescriptionCompatBuilder;
                iArr67[i117 - 2] = iArr67[i117 - 2] - iArr67[i118];
                return 0;
            case 91:
                int[] iArr68 = this.MediaDescriptionCompatBuilder;
                int i119 = this.MediaDescriptionCompat1;
                iArr68[i119] = 24;
                iArr68[i119 - 1] = iArr68[i119 - 1] >> iArr68[i119];
                int i120 = i119 - 1;
                this.MediaDescriptionCompat1 = i120;
                iArr68[i119 - 2] = iArr68[i119 - 2] + iArr68[i120];
                return 0;
            case 92:
                int[] iArr69 = this.MediaDescriptionCompatBuilder;
                int i121 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i121 + 1;
                iArr69[i121] = 16;
                return 0;
            case 93:
                int i122 = this.MediaDescriptionCompat1;
                int i123 = i122 - 1;
                int[] iArr70 = this.MediaDescriptionCompatBuilder;
                iArr70[i122 - 2] = iArr70[i122 - 2] >> iArr70[i123];
                iArr70[i122 - 2] = (byte) iArr70[i122 - 2];
                this.MediaDescriptionCompat1 = i122;
                iArr70[i123] = -11;
                return 0;
            case 94:
                int[] iArr71 = this.MediaDescriptionCompatBuilder;
                int i124 = this.MediaDescriptionCompat1;
                iArr71[i124] = -1;
                long[] jArr12 = this.setDescription;
                this.MediaDescriptionCompat1 = i124 + 2;
                jArr12[i124 + 1] = 0;
                return 0;
            case 95:
                int[] iArr72 = this.MediaDescriptionCompatBuilder;
                int i125 = this.MediaDescriptionCompat1;
                iArr72[i125 - 1] = (short) iArr72[i125 - 1];
                return 0;
            case 96:
                int i126 = this.MediaDescriptionCompat1;
                int[] iArr73 = this.MediaDescriptionCompatBuilder;
                iArr73[i126 - 2] = iArr73[i126 - 2] >> iArr73[i126 - 1];
                int i127 = i126 - 2;
                this.MediaDescriptionCompat1 = i127;
                iArr73[i126 - 3] = iArr73[i126 - 3] - iArr73[i127];
                return 0;
            case TSGeofenceManager.MAX_GEOFENCES /* 97 */:
                Object[] objArr24 = this.MediaDescriptionCompatApi21;
                int i128 = this.MediaDescriptionCompat1;
                objArr24[i128] = null;
                int[] iArr74 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i128 + 2;
                iArr74[i128 + 1] = 0;
                return 0;
            case 98:
                int i129 = this.MediaDescriptionCompat1;
                int i130 = i129 - 1;
                this.MediaDescriptionCompat1 = i130;
                long[] jArr13 = this.setDescription;
                jArr13[i129 - 2] = jArr13[i130] & jArr13[i129 - 2];
                return 0;
            case 99:
                int i131 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i131;
                long[] jArr14 = this.setDescription;
                jArr14[22] = jArr14[i131];
                return 0;
            case 100:
                int i132 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i132;
                int[] iArr75 = this.MediaDescriptionCompatBuilder;
                iArr75[24] = iArr75[i132];
                return 0;
            case 101:
                int i133 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i133;
                long[] jArr15 = this.setDescription;
                jArr15[25] = jArr15[i133];
                return 0;
            case 102:
                int i134 = this.MediaDescriptionCompat1;
                int i135 = i134 - 1;
                int[] iArr76 = this.MediaDescriptionCompatBuilder;
                iArr76[24] = iArr76[i135];
                long[] jArr16 = this.setDescription;
                jArr16[i135] = jArr16[22];
                int i136 = i134 - 1;
                this.MediaDescriptionCompat1 = i136;
                jArr16[27] = jArr16[i136];
                return 0;
            case b.i /* 103 */:
                int i137 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i137;
                int[] iArr77 = this.MediaDescriptionCompatBuilder;
                iArr77[29] = iArr77[i137];
                return 0;
            case 104:
                int[] iArr78 = this.MediaDescriptionCompatBuilder;
                int i138 = this.MediaDescriptionCompat1;
                iArr78[i138] = 0;
                this.MediaDescriptionCompat1 = i138;
                iArr78[30] = iArr78[i138];
                return 0;
            case 105:
                int[] iArr79 = this.MediaDescriptionCompatBuilder;
                int i139 = this.MediaDescriptionCompat1;
                iArr79[i139] = iArr79[30];
                this.MediaDescriptionCompat1 = i139 + 2;
                iArr79[i139 + 1] = 8;
                return 0;
            case b.l /* 106 */:
                long[] jArr17 = this.setDescription;
                int i140 = this.MediaDescriptionCompat1;
                jArr17[i140] = jArr17[27];
                int[] iArr80 = this.MediaDescriptionCompatBuilder;
                iArr80[i140 + 1] = iArr80[30];
                int i141 = i140 + 1;
                this.MediaDescriptionCompat1 = i141;
                jArr17[i140] = jArr17[i140] >> iArr80[i141];
                return 0;
            case 107:
                int[] iArr81 = this.MediaDescriptionCompatBuilder;
                int i142 = this.MediaDescriptionCompat1;
                iArr81[i142 - 1] = (int) this.setDescription[i142 - 1];
                return 0;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                int[] iArr82 = this.MediaDescriptionCompatBuilder;
                int i143 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i143 + 1;
                iArr82[i143] = 255;
                return 0;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                int[] iArr83 = this.MediaDescriptionCompatBuilder;
                int i144 = this.MediaDescriptionCompat1;
                iArr83[i144] = iArr83[24];
                this.MediaDescriptionCompat1 = i144 + 2;
                iArr83[i144 + 1] = 6;
                return 0;
            case b.f39n /* 110 */:
                int i145 = this.MediaDescriptionCompat1;
                int i146 = i145 - 1;
                int[] iArr84 = this.MediaDescriptionCompatBuilder;
                iArr84[i145 - 2] = iArr84[i145 - 2] + iArr84[i146];
                this.MediaDescriptionCompat1 = i145;
                iArr84[i146] = iArr84[24];
                return 0;
            case b.f40o /* 111 */:
                int[] iArr85 = this.MediaDescriptionCompatBuilder;
                int i147 = this.MediaDescriptionCompat1;
                iArr85[i147] = 16;
                this.MediaDescriptionCompat1 = i147;
                iArr85[i147 - 1] = iArr85[i147 - 1] << iArr85[i147];
                return 0;
            case 112:
                int i148 = this.MediaDescriptionCompat1;
                int[] iArr86 = this.MediaDescriptionCompatBuilder;
                iArr86[i148 - 2] = iArr86[i148 - 2] - iArr86[i148 - 1];
                int i149 = i148 - 2;
                this.MediaDescriptionCompat1 = i149;
                iArr86[24] = iArr86[i149];
                return 0;
            case 113:
                int[] iArr87 = this.MediaDescriptionCompatBuilder;
                iArr87[30] = iArr87[30] + 1;
                return 0;
            case 114:
                int[] iArr88 = this.MediaDescriptionCompatBuilder;
                int i150 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i150 + 1;
                iArr88[i150] = iArr88[29];
                return 0;
            case 115:
                long[] jArr18 = this.setDescription;
                int i151 = this.MediaDescriptionCompat1;
                jArr18[i151] = jArr18[25];
                this.MediaDescriptionCompat1 = i151;
                jArr18[27] = jArr18[i151];
                return 0;
            case 116:
                int[] iArr89 = this.MediaDescriptionCompatBuilder;
                iArr89[29] = iArr89[29] + 1;
                return 0;
            case 117:
                int[] iArr90 = this.MediaDescriptionCompatBuilder;
                int i152 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i152 + 1;
                iArr90[i152] = iArr90[24];
                return 0;
            case 118:
                Object[] objArr25 = this.MediaDescriptionCompatApi21;
                int i153 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i153 + 1;
                objArr25[i153] = objArr25[11];
                return 0;
            case 119:
                int i154 = this.MediaDescriptionCompat1;
                int i155 = i154 - 1;
                Object[] objArr26 = this.MediaDescriptionCompatApi21;
                Object obj15 = objArr26[i155];
                objArr26[i155] = null;
                objArr26[49] = obj15;
                this.MediaDescriptionCompat1 = i154;
                objArr26[i155] = obj15;
                return 0;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                int[] iArr91 = this.MediaDescriptionCompatBuilder;
                int i156 = this.MediaDescriptionCompat1;
                iArr91[i156] = 0;
                this.MediaDescriptionCompat1 = i156;
                Object[] objArr27 = this.MediaDescriptionCompatApi21;
                Object obj16 = objArr27[i156 - 1];
                objArr27[i156 - 1] = null;
                iArr91[i156 - 1] = ((int[]) obj16)[iArr91[i156]];
                int i157 = i156 - 1;
                this.MediaDescriptionCompat1 = i157;
                iArr91[32] = iArr91[i157];
                return 0;
            case 121:
                Object[] objArr28 = this.MediaDescriptionCompatApi21;
                int i158 = this.MediaDescriptionCompat1;
                objArr28[i158] = objArr28[11];
                this.MediaDescriptionCompat1 = i158;
                Object obj17 = objArr28[i158];
                objArr28[i158] = null;
                objArr28[49] = obj17;
                return 0;
            case 122:
                int i159 = this.MediaDescriptionCompat1;
                int i160 = i159 - 1;
                this.MediaDescriptionCompat1 = i160;
                int[] iArr92 = this.MediaDescriptionCompatBuilder;
                Object[] objArr29 = this.MediaDescriptionCompatApi21;
                Object obj18 = objArr29[i159 - 2];
                objArr29[i159 - 2] = null;
                iArr92[i159 - 2] = ((int[]) obj18)[iArr92[i160]];
                int i161 = i159 - 2;
                int i162 = iArr92[i161];
                iArr92[31] = i162;
                this.MediaDescriptionCompat1 = i159 - 1;
                iArr92[i161] = i162;
                return 0;
            case 123:
                int i163 = this.MediaDescriptionCompat1;
                int i164 = i163 - 2;
                this.MediaDescriptionCompat1 = i164;
                int[] iArr93 = this.MediaDescriptionCompatBuilder;
                this.getSubtitle = iArr93[i164] != iArr93[i163 - 1] ? 0 : 1;
                return 0;
            case 124:
                int[] iArr94 = this.MediaDescriptionCompatBuilder;
                int i165 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i165 + 1;
                iArr94[i165] = iArr94[32];
                return 0;
            case 125:
                int[] iArr95 = this.MediaDescriptionCompatBuilder;
                int i166 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i166 + 1;
                iArr95[i166] = 4;
                return 0;
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                int[] iArr96 = this.MediaDescriptionCompatBuilder;
                int i167 = this.MediaDescriptionCompat1;
                iArr96[i167] = 0;
                this.MediaDescriptionCompat1 = i167 + 2;
                iArr96[i167 + 1] = 1;
                return 0;
            case 127:
                Object[] objArr30 = this.MediaDescriptionCompatApi21;
                int i168 = this.MediaDescriptionCompat1;
                int[] iArr97 = this.MediaDescriptionCompatBuilder;
                objArr30[i168 - 1] = new int[iArr97[i168 - 1]];
                int i169 = i168 - 3;
                this.MediaDescriptionCompat1 = i169;
                Object obj19 = objArr30[i169];
                objArr30[i169] = null;
                int i170 = iArr97[i168 - 2];
                Object obj20 = objArr30[i168 - 1];
                objArr30[i168 - 1] = null;
                ((Object[]) obj19)[i170] = obj20;
                this.MediaDescriptionCompat1 = i168 - 2;
                objArr30[i169] = objArr30[i168 - 4];
                return 0;
            case 128:
                int[] iArr98 = this.MediaDescriptionCompatBuilder;
                int i171 = this.MediaDescriptionCompat1;
                iArr98[i171] = 1;
                this.MediaDescriptionCompat1 = i171 + 2;
                iArr98[i171 + 1] = 1;
                return 0;
            case 129:
                Object[] objArr31 = this.MediaDescriptionCompatApi21;
                int i172 = this.MediaDescriptionCompat1;
                objArr31[i172 - 1] = new int[this.MediaDescriptionCompatBuilder[i172 - 1]];
                return 0;
            case 130:
                int i173 = this.MediaDescriptionCompat1;
                int i174 = i173 - 3;
                this.MediaDescriptionCompat1 = i174;
                Object[] objArr32 = this.MediaDescriptionCompatApi21;
                Object obj21 = objArr32[i174];
                objArr32[i174] = null;
                int[] iArr99 = this.MediaDescriptionCompatBuilder;
                int i175 = iArr99[i173 - 2];
                Object obj22 = objArr32[i173 - 1];
                objArr32[i173 - 1] = null;
                ((Object[]) obj21)[i175] = obj22;
                objArr32[i174] = objArr32[i173 - 4];
                this.MediaDescriptionCompat1 = i173 - 1;
                iArr99[i173 - 2] = 3;
                return 0;
            case 131:
                int[] iArr100 = this.MediaDescriptionCompatBuilder;
                int i176 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i176 + 1;
                iArr100[i176] = 1;
                Object[] objArr33 = this.MediaDescriptionCompatApi21;
                objArr33[i176] = new int[iArr100[i176]];
                int i177 = i176 - 2;
                this.MediaDescriptionCompat1 = i177;
                Object obj23 = objArr33[i177];
                objArr33[i177] = null;
                int i178 = iArr100[i176 - 1];
                Object obj24 = objArr33[i176];
                objArr33[i176] = null;
                ((Object[]) obj23)[i178] = obj24;
                return 0;
            case 132:
                Object[] objArr34 = this.MediaDescriptionCompatApi21;
                int i179 = this.MediaDescriptionCompat1;
                objArr34[i179] = objArr34[i179 - 1];
                this.MediaDescriptionCompat1 = i179;
                objArr34[i179] = null;
                return 0;
            case 133:
                Object[] objArr35 = this.MediaDescriptionCompatApi21;
                int i180 = this.MediaDescriptionCompat1;
                objArr35[i180] = objArr35[i180 - 1];
                objArr35[i180 + 1] = objArr35[11];
                this.MediaDescriptionCompat1 = i180 + 3;
                objArr35[i180 + 2] = objArr35[11];
                return 0;
            case 134:
                int i181 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i181;
                Object[] objArr36 = this.MediaDescriptionCompatApi21;
                Object obj25 = objArr36[i181];
                objArr36[i181] = null;
                objArr36[49] = obj25;
                return 0;
            case 135:
                Object[] objArr37 = this.MediaDescriptionCompatApi21;
                int i182 = this.MediaDescriptionCompat1;
                objArr37[i182] = objArr37[49];
                int[] iArr101 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i182 + 2;
                iArr101[i182 + 1] = 3;
                return 0;
            case SyslogConstants.LOG_LOCAL1 /* 136 */:
                int[] iArr102 = this.MediaDescriptionCompatBuilder;
                int i183 = this.MediaDescriptionCompat1;
                iArr102[i183] = 0;
                this.MediaDescriptionCompat1 = i183;
                Object[] objArr38 = this.MediaDescriptionCompatApi21;
                Object obj26 = objArr38[i183 - 1];
                objArr38[i183 - 1] = null;
                iArr102[i183 - 1] = ((int[]) obj26)[iArr102[i183]];
                return 0;
            case 137:
                int i184 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i184;
                int[] iArr103 = this.MediaDescriptionCompatBuilder;
                iArr103[39] = iArr103[i184];
                return 0;
            case 138:
                int i185 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i185;
                int[] iArr104 = this.MediaDescriptionCompatBuilder;
                iArr104[38] = iArr104[i185];
                return 0;
            case 139:
                int i186 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i186;
                Object[] objArr39 = this.MediaDescriptionCompatApi21;
                Object obj27 = objArr39[i186];
                objArr39[i186] = null;
                objArr39[37] = obj27;
                return 0;
            case 140:
                int i187 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i187;
                Object[] objArr40 = this.MediaDescriptionCompatApi21;
                Object obj28 = objArr40[i187];
                objArr40[i187] = null;
                objArr40[36] = obj28;
                return 0;
            case 141:
                Object[] objArr41 = this.MediaDescriptionCompatApi21;
                int i188 = this.MediaDescriptionCompat1;
                objArr41[i188] = objArr41[36];
                objArr41[i188 + 1] = objArr41[37];
                int[] iArr105 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i188 + 3;
                iArr105[i188 + 2] = 0;
                return 0;
            case 142:
                int i189 = this.MediaDescriptionCompat1;
                int i190 = i189 - 1;
                this.MediaDescriptionCompat1 = i190;
                int[] iArr106 = this.MediaDescriptionCompatBuilder;
                Object[] objArr42 = this.MediaDescriptionCompatApi21;
                Object obj29 = objArr42[i189 - 2];
                objArr42[i189 - 2] = null;
                iArr106[i189 - 2] = ((int[]) obj29)[iArr106[i190]];
                return 0;
            case 143:
                Object[] objArr43 = this.MediaDescriptionCompatApi21;
                int i191 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i191 + 1;
                objArr43[i191] = objArr43[37];
                return 0;
            case SyslogConstants.LOG_LOCAL2 /* 144 */:
                int i192 = this.MediaDescriptionCompat1;
                int i193 = i192 - 1;
                this.MediaDescriptionCompat1 = i193;
                int[] iArr107 = this.MediaDescriptionCompatBuilder;
                Object[] objArr44 = this.MediaDescriptionCompatApi21;
                Object obj30 = objArr44[i192 - 2];
                objArr44[i192 - 2] = null;
                iArr107[i192 - 2] = ((int[]) obj30)[iArr107[i193]];
                iArr107[i193] = iArr107[38];
                this.MediaDescriptionCompat1 = i192 + 1;
                iArr107[i192] = iArr107[39];
                return 0;
            case 145:
                int i194 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i194;
                Object[] objArr45 = this.MediaDescriptionCompatApi21;
                Object obj31 = objArr45[i194];
                objArr45[i194] = null;
                objArr45[45] = obj31;
                return 0;
            case 146:
                int i195 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i195;
                int[] iArr108 = this.MediaDescriptionCompatBuilder;
                iArr108[44] = iArr108[i195];
                return 0;
            case 147:
                int i196 = this.MediaDescriptionCompat1;
                int[] iArr109 = this.MediaDescriptionCompatBuilder;
                iArr109[43] = iArr109[i196 - 1];
                int i197 = i196 - 2;
                this.MediaDescriptionCompat1 = i197;
                iArr109[42] = iArr109[i197];
                return 0;
            case 148:
                int i198 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i198;
                int[] iArr110 = this.MediaDescriptionCompatBuilder;
                iArr110[41] = iArr110[i198];
                return 0;
            case 149:
                int i199 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i199;
                Object[] objArr46 = this.MediaDescriptionCompatApi21;
                Object obj32 = objArr46[i199];
                objArr46[i199] = null;
                objArr46[40] = obj32;
                return 0;
            case 150:
                Object[] objArr47 = this.MediaDescriptionCompatApi21;
                int i200 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i200 + 1;
                objArr47[i200] = objArr47[40];
                return 0;
            case 151:
                int i201 = this.MediaDescriptionCompat1;
                int i202 = i201 - 1;
                Object[] objArr48 = this.MediaDescriptionCompatApi21;
                objArr48[i202] = null;
                this.MediaDescriptionCompat1 = i201;
                objArr48[i202] = objArr48[40];
                return 0;
            case SyslogConstants.LOG_LOCAL3 /* 152 */:
                int[] iArr111 = this.MediaDescriptionCompatBuilder;
                int i203 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i203 + 1;
                iArr111[i203] = iArr111[41];
                return 0;
            case 153:
                Object[] objArr49 = this.MediaDescriptionCompatApi21;
                int i204 = this.MediaDescriptionCompat1;
                Object obj33 = objArr49[i204 - 2];
                objArr49[i204 - 2] = null;
                objArr49[i204 - 1] = obj33;
                int[] iArr112 = this.MediaDescriptionCompatBuilder;
                iArr112[i204 - 2] = iArr112[i204 - 1];
                this.MediaDescriptionCompat1 = i204 + 1;
                iArr112[i204] = 0;
                return 0;
            case 154:
                int[] iArr113 = this.MediaDescriptionCompatBuilder;
                int i205 = this.MediaDescriptionCompat1;
                iArr113[i205 - 1] = iArr113[i205 - 2];
                Object[] objArr50 = this.MediaDescriptionCompatApi21;
                Object obj34 = objArr50[i205 - 1];
                objArr50[i205 - 1] = null;
                objArr50[i205 - 2] = obj34;
                return 0;
            case 155:
                int[] iArr114 = this.MediaDescriptionCompatBuilder;
                int i206 = this.MediaDescriptionCompat1;
                iArr114[i206] = 0;
                int i207 = iArr114[i206];
                iArr114[i206] = iArr114[i206 - 1];
                iArr114[i206 - 1] = i207;
                int i208 = i206 - 2;
                this.MediaDescriptionCompat1 = i208;
                Object[] objArr51 = this.MediaDescriptionCompatApi21;
                Object obj35 = objArr51[i208];
                objArr51[i208] = null;
                ((int[]) obj35)[iArr114[i206 - 1]] = iArr114[i206];
                return 0;
            case 156:
                int[] iArr115 = this.MediaDescriptionCompatBuilder;
                int i209 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i209 + 1;
                iArr115[i209] = iArr115[42];
                return 0;
            case 157:
                Object[] objArr52 = this.MediaDescriptionCompatApi21;
                int i210 = this.MediaDescriptionCompat1;
                Object obj36 = objArr52[i210 - 2];
                objArr52[i210 - 2] = null;
                objArr52[i210 - 1] = obj36;
                int[] iArr116 = this.MediaDescriptionCompatBuilder;
                iArr116[i210 - 2] = iArr116[i210 - 1];
                iArr116[i210] = 1;
                this.MediaDescriptionCompat1 = i210;
                Object obj37 = objArr52[i210 - 1];
                objArr52[i210 - 1] = null;
                objArr52[i210 - 1] = ((Object[]) obj37)[iArr116[i210]];
                return 0;
            case 158:
                int[] iArr117 = this.MediaDescriptionCompatBuilder;
                int i211 = this.MediaDescriptionCompat1;
                int i212 = iArr117[i211 - 1];
                iArr117[i211 - 1] = iArr117[i211 - 2];
                iArr117[i211 - 2] = i212;
                return 0;
            case 159:
                int i213 = this.MediaDescriptionCompat1;
                int i214 = i213 - 3;
                this.MediaDescriptionCompat1 = i214;
                Object[] objArr53 = this.MediaDescriptionCompatApi21;
                Object obj38 = objArr53[i214];
                objArr53[i214] = null;
                int[] iArr118 = this.MediaDescriptionCompatBuilder;
                ((int[]) obj38)[iArr118[i213 - 2]] = iArr118[i213 - 1];
                this.MediaDescriptionCompat1 = i213 - 2;
                objArr53[i214] = objArr53[40];
                return 0;
            case SyslogConstants.LOG_LOCAL4 /* 160 */:
                Object[] objArr54 = this.MediaDescriptionCompatApi21;
                int i215 = this.MediaDescriptionCompat1;
                objArr54[i215] = objArr54[45];
                int[] iArr119 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i215 + 2;
                iArr119[i215 + 1] = 2;
                return 0;
            case 161:
                Object[] objArr55 = this.MediaDescriptionCompatApi21;
                int i216 = this.MediaDescriptionCompat1;
                Object obj39 = objArr55[i216 - 2];
                objArr55[i216 - 2] = null;
                objArr55[i216 - 1] = obj39;
                int[] iArr120 = this.MediaDescriptionCompatBuilder;
                iArr120[i216 - 2] = iArr120[i216 - 1];
                return 0;
            case 162:
                Object[] objArr56 = this.MediaDescriptionCompatApi21;
                int i217 = this.MediaDescriptionCompat1;
                objArr56[i217] = objArr56[40];
                int[] iArr121 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i217 + 2;
                iArr121[i217 + 1] = iArr121[43];
                return 0;
            case 163:
                int[] iArr122 = this.MediaDescriptionCompatBuilder;
                int i218 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i218 + 1;
                iArr122[i218] = iArr122[44];
                return 0;
            case 164:
                int i219 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i219;
                int[] iArr123 = this.MediaDescriptionCompatBuilder;
                iArr123[48] = iArr123[i219];
                return 0;
            case 165:
                int i220 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i220;
                int[] iArr124 = this.MediaDescriptionCompatBuilder;
                iArr124[47] = iArr124[i220];
                return 0;
            case 166:
                int i221 = this.MediaDescriptionCompat1;
                int i222 = i221 - 1;
                int[] iArr125 = this.MediaDescriptionCompatBuilder;
                int i223 = iArr125[i222];
                iArr125[46] = i223;
                this.MediaDescriptionCompat1 = i221;
                iArr125[i222] = i223;
                return 0;
            case 167:
                int[] iArr126 = this.MediaDescriptionCompatBuilder;
                int i224 = this.MediaDescriptionCompat1;
                iArr126[i224] = iArr126[48];
                this.MediaDescriptionCompat1 = i224 + 2;
                iArr126[i224 + 1] = iArr126[47];
                return 0;
            case 168:
                int i225 = this.MediaDescriptionCompat1;
                int[] iArr127 = this.MediaDescriptionCompatBuilder;
                iArr127[i225 - 2] = iArr127[i225 - 2] + iArr127[i225 - 1];
                int i226 = i225 - 2;
                this.MediaDescriptionCompat1 = i226;
                iArr127[i225 - 3] = iArr127[i225 - 3] + iArr127[i226];
                return 0;
            case 169:
                int[] iArr128 = this.MediaDescriptionCompatBuilder;
                int i227 = this.MediaDescriptionCompat1;
                iArr128[i227] = iArr128[i227 - 1];
                iArr128[i227 + 1] = iArr128[i227];
                int i228 = i227 + 1;
                this.MediaDescriptionCompat1 = i228;
                iArr128[46] = iArr128[i228];
                return 0;
            case 170:
                int[] iArr129 = this.MediaDescriptionCompatBuilder;
                int i229 = this.MediaDescriptionCompat1;
                iArr129[i229] = 13;
                this.MediaDescriptionCompat1 = i229;
                iArr129[i229 - 1] = iArr129[i229 - 1] << iArr129[i229];
                return 0;
            case 171:
                int i230 = this.MediaDescriptionCompat1;
                int i231 = i230 - 1;
                int[] iArr130 = this.MediaDescriptionCompatBuilder;
                iArr130[i230 - 2] = iArr130[i230 - 2] ^ iArr130[i231];
                iArr130[i231] = iArr130[i230 - 2];
                this.MediaDescriptionCompat1 = i230 + 1;
                iArr130[i230] = iArr130[i230 - 1];
                return 0;
            case 172:
                int i232 = this.MediaDescriptionCompat1;
                int i233 = i232 - 1;
                int[] iArr131 = this.MediaDescriptionCompatBuilder;
                iArr131[46] = iArr131[i233];
                this.MediaDescriptionCompat1 = i232;
                iArr131[i233] = 17;
                return 0;
            case 173:
                int i234 = this.MediaDescriptionCompat1;
                int[] iArr132 = this.MediaDescriptionCompatBuilder;
                iArr132[i234 - 2] = iArr132[i234 - 2] >>> iArr132[i234 - 1];
                int i235 = i234 - 2;
                this.MediaDescriptionCompat1 = i235;
                iArr132[i234 - 3] = iArr132[i234 - 3] ^ iArr132[i235];
                return 0;
            case 174:
                int[] iArr133 = this.MediaDescriptionCompatBuilder;
                int i236 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i236 + 1;
                iArr133[i236] = 5;
                return 0;
            case 175:
                int i237 = this.MediaDescriptionCompat1;
                int[] iArr134 = this.MediaDescriptionCompatBuilder;
                iArr134[i237 - 2] = iArr134[i237 - 2] << iArr134[i237 - 1];
                int i238 = i237 - 2;
                this.MediaDescriptionCompat1 = i238;
                iArr134[i237 - 3] = iArr134[i238] ^ iArr134[i237 - 3];
                Object[] objArr57 = this.MediaDescriptionCompatApi21;
                Object obj40 = objArr57[i237 - 4];
                objArr57[i237 - 4] = null;
                objArr57[i237 - 3] = obj40;
                iArr134[i237 - 4] = iArr134[i237 - 3];
                return 0;
            case SyslogConstants.LOG_LOCAL6 /* 176 */:
                int[] iArr135 = this.MediaDescriptionCompatBuilder;
                int i239 = this.MediaDescriptionCompat1;
                iArr135[i239] = 3;
                this.MediaDescriptionCompat1 = i239;
                Object[] objArr58 = this.MediaDescriptionCompatApi21;
                Object obj41 = objArr58[i239 - 1];
                objArr58[i239 - 1] = null;
                objArr58[i239 - 1] = ((Object[]) obj41)[iArr135[i239]];
                return 0;
            case 177:
                int[] iArr136 = this.MediaDescriptionCompatBuilder;
                int i240 = this.MediaDescriptionCompat1;
                iArr136[i240 - 1] = iArr136[i240 - 2];
                Object[] objArr59 = this.MediaDescriptionCompatApi21;
                Object obj42 = objArr59[i240 - 1];
                objArr59[i240 - 1] = null;
                objArr59[i240 - 2] = obj42;
                this.MediaDescriptionCompat1 = i240 + 1;
                iArr136[i240] = 0;
                int i241 = iArr136[i240];
                iArr136[i240] = iArr136[i240 - 1];
                iArr136[i240 - 1] = i241;
                return 0;
            case 178:
                int i242 = this.MediaDescriptionCompat1;
                int i243 = i242 - 3;
                this.MediaDescriptionCompat1 = i243;
                Object[] objArr60 = this.MediaDescriptionCompatApi21;
                Object obj43 = objArr60[i243];
                objArr60[i243] = null;
                int[] iArr137 = this.MediaDescriptionCompatBuilder;
                ((int[]) obj43)[iArr137[i242 - 2]] = iArr137[i242 - 1];
                int i244 = i242 - 4;
                this.MediaDescriptionCompat1 = i244;
                Object obj44 = objArr60[i244];
                objArr60[i244] = null;
                objArr60[11] = obj44;
                return 0;
            case 179:
                int i245 = this.MediaDescriptionCompat1;
                int i246 = i245 - 1;
                Object[] objArr61 = this.MediaDescriptionCompatApi21;
                Object obj45 = objArr61[i246];
                objArr61[i246] = null;
                objArr61[33] = obj45;
                objArr61[i246] = objArr61[11];
                int i247 = i245 - 1;
                this.MediaDescriptionCompat1 = i247;
                Object obj46 = objArr61[i247];
                objArr61[i247] = null;
                objArr61[49] = obj46;
                return 0;
            case RotationOptions.ROTATE_180 /* 180 */:
                Object[] objArr62 = this.MediaDescriptionCompatApi21;
                int i248 = this.MediaDescriptionCompat1;
                objArr62[i248] = objArr62[49];
                int[] iArr138 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i248 + 2;
                iArr138[i248 + 1] = 2;
                return 0;
            case 181:
                int i249 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i249;
                Object[] objArr63 = this.MediaDescriptionCompatApi21;
                Object obj47 = objArr63[i249];
                objArr63[i249] = null;
                objArr63[35] = obj47;
                return 0;
            case 182:
                int i250 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i250;
                Object[] objArr64 = this.MediaDescriptionCompatApi21;
                Object obj48 = objArr64[i250];
                objArr64[i250] = null;
                this.getSubtitle = obj48 == null ? 0 : 1;
                return 0;
            case 183:
                Object[] objArr65 = this.MediaDescriptionCompatApi21;
                int i251 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i251 + 1;
                objArr65[i251] = objArr65[35];
                return 0;
            case SyslogConstants.LOG_LOCAL7 /* 184 */:
                int[] iArr139 = this.MediaDescriptionCompatBuilder;
                int i252 = this.MediaDescriptionCompat1;
                iArr139[i252] = 0;
                this.MediaDescriptionCompat1 = i252;
                iArr139[34] = iArr139[i252];
                return 0;
            case 185:
                int[] iArr140 = this.MediaDescriptionCompatBuilder;
                int i253 = this.MediaDescriptionCompat1;
                iArr140[i253] = iArr140[34];
                Object[] objArr66 = this.MediaDescriptionCompatApi21;
                this.MediaDescriptionCompat1 = i253 + 2;
                objArr66[i253 + 1] = objArr66[35];
                return 0;
            case 186:
                int i254 = this.MediaDescriptionCompat1;
                int i255 = i254 - 2;
                this.MediaDescriptionCompat1 = i255;
                int[] iArr141 = this.MediaDescriptionCompatBuilder;
                this.getSubtitle = iArr141[i255] >= iArr141[i254 - 1] ? 0 : 1;
                return 0;
            case 187:
                int[] iArr142 = this.MediaDescriptionCompatBuilder;
                int i256 = this.MediaDescriptionCompat1;
                Object[] objArr67 = this.MediaDescriptionCompatApi21;
                Object obj49 = objArr67[i256 - 1];
                objArr67[i256 - 1] = null;
                iArr142[i256 - 1] = ((Object[]) obj49).length;
                return 0;
            case 188:
                Object[] objArr68 = this.MediaDescriptionCompatApi21;
                int i257 = this.MediaDescriptionCompat1;
                objArr68[i257] = objArr68[33];
                this.MediaDescriptionCompat1 = i257 + 2;
                objArr68[i257 + 1] = objArr68[35];
                return 0;
            case 189:
                int[] iArr143 = this.MediaDescriptionCompatBuilder;
                int i258 = this.MediaDescriptionCompat1;
                iArr143[i258] = iArr143[34];
                this.MediaDescriptionCompat1 = i258;
                Object[] objArr69 = this.MediaDescriptionCompatApi21;
                Object obj50 = objArr69[i258 - 1];
                objArr69[i258 - 1] = null;
                objArr69[i258 - 1] = ((Object[]) obj50)[iArr143[i258]];
                return 0;
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /* 190 */:
                int[] iArr144 = this.MediaDescriptionCompatBuilder;
                iArr144[34] = iArr144[34] + 1;
                return 0;
            case 191:
                Object[] objArr70 = this.MediaDescriptionCompatApi21;
                int i259 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i259 + 1;
                objArr70[i259] = objArr70[33];
                return 0;
            case JfifUtil.MARKER_SOFn /* 192 */:
                long[] jArr19 = this.setDescription;
                int i260 = this.MediaDescriptionCompat1;
                jArr19[i260 - 1] = this.MediaDescriptionCompatBuilder[i260 - 1];
                return 0;
            case 193:
                int[] iArr145 = this.MediaDescriptionCompatBuilder;
                int i261 = this.MediaDescriptionCompat1;
                iArr145[i261] = 32;
                long[] jArr20 = this.setDescription;
                jArr20[i261 - 1] = jArr20[i261 - 1] << iArr145[i261];
                this.MediaDescriptionCompat1 = i261 + 1;
                iArr145[i261] = iArr145[32];
                return 0;
            case 194:
                int[] iArr146 = this.MediaDescriptionCompatBuilder;
                int i262 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i262 + 1;
                iArr146[i262] = iArr146[31];
                return 0;
            case 195:
                int i263 = this.MediaDescriptionCompat1;
                int i264 = i263 - 1;
                this.MediaDescriptionCompat1 = i264;
                int[] iArr147 = this.MediaDescriptionCompatBuilder;
                iArr147[i263 - 2] = iArr147[i264] ^ iArr147[i263 - 2];
                this.setDescription[i263 - 2] = iArr147[i263 - 2];
                return 0;
            case 196:
                int i265 = this.MediaDescriptionCompat1;
                int i266 = i265 - 1;
                this.MediaDescriptionCompat1 = i266;
                long[] jArr21 = this.setDescription;
                jArr21[i265 - 2] = jArr21[i266] ^ jArr21[i265 - 2];
                return 0;
            case 197:
                Object[] objArr71 = this.MediaDescriptionCompatApi21;
                int i267 = this.MediaDescriptionCompat1;
                Object obj51 = objArr71[i267 - 1];
                objArr71[i267 - 1] = null;
                Object obj52 = objArr71[i267 - 2];
                objArr71[i267 - 2] = null;
                objArr71[i267 - 1] = obj52;
                objArr71[i267 - 2] = obj51;
                return 0;
            case 198:
                Object[] objArr72 = this.MediaDescriptionCompatApi21;
                int i268 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i268 + 1;
                Object obj53 = objArr72[i268 - 1];
                objArr72[i268 - 1] = null;
                objArr72[i268] = obj53;
                long[] jArr22 = this.setDescription;
                jArr22[i268 - 1] = jArr22[i268 - 2];
                objArr72[i268 - 2] = obj53;
                return 0;
            case 199:
                Object[] objArr73 = this.MediaDescriptionCompatApi21;
                int i269 = this.MediaDescriptionCompat1;
                Object obj54 = objArr73[i269 - 1];
                objArr73[i269 - 1] = null;
                Object obj55 = objArr73[i269 - 2];
                objArr73[i269 - 2] = null;
                objArr73[i269 - 1] = obj55;
                objArr73[i269 - 2] = obj54;
                this.MediaDescriptionCompat1 = i269 + 1;
                Object obj56 = objArr73[i269 - 1];
                objArr73[i269 - 1] = null;
                objArr73[i269] = obj56;
                Object obj57 = objArr73[i269 - 2];
                objArr73[i269 - 2] = null;
                objArr73[i269 - 1] = obj57;
                objArr73[i269 - 2] = obj56;
                Object obj58 = objArr73[i269];
                objArr73[i269] = null;
                Object obj59 = objArr73[i269 - 1];
                objArr73[i269 - 1] = null;
                objArr73[i269] = obj59;
                objArr73[i269 - 1] = obj58;
                return 0;
            case 200:
                int[] iArr148 = this.MediaDescriptionCompatBuilder;
                int i270 = this.MediaDescriptionCompat1;
                iArr148[i270] = 1;
                Object[] objArr74 = this.MediaDescriptionCompatApi21;
                Object obj60 = objArr74[i270 - 1];
                objArr74[i270 - 1] = null;
                objArr74[i270] = obj60;
                iArr148[i270 - 1] = iArr148[i270];
                int i271 = i270 - 2;
                this.MediaDescriptionCompat1 = i271;
                Object obj61 = objArr74[i271];
                objArr74[i271] = null;
                int i272 = iArr148[i270 - 1];
                Object obj62 = objArr74[i270];
                objArr74[i270] = null;
                ((Object[]) obj61)[i272] = obj62;
                return 0;
            case 201:
                Object[] objArr75 = this.MediaDescriptionCompatApi21;
                int i273 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i273 + 1;
                Object obj63 = objArr75[i273 - 1];
                objArr75[i273 - 1] = null;
                objArr75[i273] = obj63;
                Object obj64 = objArr75[i273 - 2];
                objArr75[i273 - 2] = null;
                objArr75[i273 - 1] = obj64;
                objArr75[i273 - 2] = obj63;
                Object obj65 = objArr75[i273];
                objArr75[i273] = null;
                Object obj66 = objArr75[i273 - 1];
                objArr75[i273 - 1] = null;
                objArr75[i273] = obj66;
                objArr75[i273 - 1] = obj65;
                return 0;
            case 202:
                int[] iArr149 = this.MediaDescriptionCompatBuilder;
                int i274 = this.MediaDescriptionCompat1;
                iArr149[i274] = 0;
                Object[] objArr76 = this.MediaDescriptionCompatApi21;
                Object obj67 = objArr76[i274 - 1];
                objArr76[i274 - 1] = null;
                objArr76[i274] = obj67;
                iArr149[i274 - 1] = iArr149[i274];
                int i275 = i274 - 2;
                this.MediaDescriptionCompat1 = i275;
                Object obj68 = objArr76[i275];
                objArr76[i275] = null;
                int i276 = iArr149[i274 - 1];
                Object obj69 = objArr76[i274];
                objArr76[i274] = null;
                ((Object[]) obj68)[i276] = obj69;
                return 0;
            case 203:
                int i277 = this.MediaDescriptionCompat1;
                int i278 = i277 - 3;
                this.MediaDescriptionCompat1 = i278;
                Object[] objArr77 = this.MediaDescriptionCompatApi21;
                Object obj70 = objArr77[i278];
                objArr77[i278] = null;
                int i279 = this.MediaDescriptionCompatBuilder[i277 - 2];
                Object obj71 = objArr77[i277 - 1];
                objArr77[i277 - 1] = null;
                ((Object[]) obj70)[i279] = obj71;
                this.MediaDescriptionCompat1 = i277 - 2;
                objArr77[i278] = objArr77[i277 - 4];
                return 0;
            case 204:
                Object[] objArr78 = this.MediaDescriptionCompatApi21;
                int i280 = this.MediaDescriptionCompat1;
                int[] iArr150 = this.MediaDescriptionCompatBuilder;
                objArr78[i280 - 1] = new int[iArr150[i280 - 1]];
                int i281 = i280 - 3;
                this.MediaDescriptionCompat1 = i281;
                Object obj72 = objArr78[i281];
                objArr78[i281] = null;
                int i282 = iArr150[i280 - 2];
                Object obj73 = objArr78[i280 - 1];
                objArr78[i280 - 1] = null;
                ((Object[]) obj72)[i282] = obj73;
                return 0;
            case MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR /* 205 */:
                Object[] objArr79 = this.MediaDescriptionCompatApi21;
                int i283 = this.MediaDescriptionCompat1;
                objArr79[i283] = objArr79[i283 - 1];
                int[] iArr151 = this.MediaDescriptionCompatBuilder;
                iArr151[i283 + 1] = 1;
                this.MediaDescriptionCompat1 = i283 + 3;
                iArr151[i283 + 2] = 1;
                return 0;
            case 206:
                int[] iArr152 = this.MediaDescriptionCompatBuilder;
                int i284 = this.MediaDescriptionCompat1;
                iArr152[i284] = 3;
                this.MediaDescriptionCompat1 = i284 + 2;
                iArr152[i284 + 1] = 1;
                return 0;
            case 207:
                int i285 = this.MediaDescriptionCompat1;
                int i286 = i285 - 3;
                this.MediaDescriptionCompat1 = i286;
                Object[] objArr80 = this.MediaDescriptionCompatApi21;
                Object obj74 = objArr80[i286];
                objArr80[i286] = null;
                int i287 = this.MediaDescriptionCompatBuilder[i285 - 2];
                Object obj75 = objArr80[i285 - 1];
                objArr80[i285 - 1] = null;
                ((Object[]) obj74)[i287] = obj75;
                objArr80[i286] = objArr80[i285 - 4];
                int i288 = i285 - 3;
                this.MediaDescriptionCompat1 = i288;
                objArr80[i288] = null;
                return 0;
            case JfifUtil.MARKER_RST0 /* 208 */:
                Object[] objArr81 = this.MediaDescriptionCompatApi21;
                int i289 = this.MediaDescriptionCompat1;
                objArr81[i289] = objArr81[49];
                int[] iArr153 = this.MediaDescriptionCompatBuilder;
                iArr153[i289 + 1] = 3;
                int i290 = i289 + 1;
                this.MediaDescriptionCompat1 = i290;
                Object obj76 = objArr81[i289];
                objArr81[i289] = null;
                objArr81[i289] = ((Object[]) obj76)[iArr153[i290]];
                return 0;
            case 209:
                int[] iArr154 = this.MediaDescriptionCompatBuilder;
                int i291 = this.MediaDescriptionCompat1;
                iArr154[i291] = 0;
                iArr154[39] = iArr154[i291];
                int i292 = i291 - 1;
                this.MediaDescriptionCompat1 = i292;
                iArr154[38] = iArr154[i292];
                return 0;
            case 210:
                Object[] objArr82 = this.MediaDescriptionCompatApi21;
                int i293 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i293 + 1;
                objArr82[i293] = objArr82[36];
                return 0;
            case 211:
                Object[] objArr83 = this.MediaDescriptionCompatApi21;
                int i294 = this.MediaDescriptionCompat1;
                objArr83[i294] = objArr83[37];
                int[] iArr155 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i294 + 2;
                iArr155[i294 + 1] = 0;
                return 0;
            case 212:
                int i295 = this.MediaDescriptionCompat1;
                int i296 = i295 - 1;
                this.MediaDescriptionCompat1 = i296;
                int[] iArr156 = this.MediaDescriptionCompatBuilder;
                Object[] objArr84 = this.MediaDescriptionCompatApi21;
                Object obj77 = objArr84[i295 - 2];
                objArr84[i295 - 2] = null;
                iArr156[i295 - 2] = ((int[]) obj77)[iArr156[i296]];
                objArr84[i296] = objArr84[37];
                this.MediaDescriptionCompat1 = i295 + 1;
                iArr156[i295] = 1;
                return 0;
            case 213:
                int[] iArr157 = this.MediaDescriptionCompatBuilder;
                int i297 = this.MediaDescriptionCompat1;
                iArr157[i297] = 0;
                this.MediaDescriptionCompat1 = i297;
                Object[] objArr85 = this.MediaDescriptionCompatApi21;
                Object obj78 = objArr85[i297 - 1];
                objArr85[i297 - 1] = null;
                iArr157[i297 - 1] = ((int[]) obj78)[iArr157[i297]];
                this.MediaDescriptionCompat1 = i297 + 1;
                iArr157[i297] = iArr157[38];
                return 0;
            case 214:
                int[] iArr158 = this.MediaDescriptionCompatBuilder;
                int i298 = this.MediaDescriptionCompat1;
                iArr158[i298] = iArr158[39];
                Object[] objArr86 = this.MediaDescriptionCompatApi21;
                this.MediaDescriptionCompat1 = i298 + 2;
                objArr86[i298 + 1] = objArr86[37];
                return 0;
            case JfifUtil.MARKER_RST7 /* 215 */:
                int i299 = this.MediaDescriptionCompat1;
                int[] iArr159 = this.MediaDescriptionCompatBuilder;
                iArr159[44] = iArr159[i299 - 1];
                iArr159[43] = iArr159[i299 - 2];
                int i300 = i299 - 3;
                this.MediaDescriptionCompat1 = i300;
                iArr159[42] = iArr159[i300];
                return 0;
            case JfifUtil.MARKER_SOI /* 216 */:
                int i301 = this.MediaDescriptionCompat1;
                int[] iArr160 = this.MediaDescriptionCompatBuilder;
                iArr160[41] = iArr160[i301 - 1];
                int i302 = i301 - 2;
                Object[] objArr87 = this.MediaDescriptionCompatApi21;
                Object obj79 = objArr87[i302];
                objArr87[i302] = null;
                objArr87[40] = obj79;
                this.MediaDescriptionCompat1 = i301 - 1;
                objArr87[i302] = obj79;
                return 0;
            case JfifUtil.MARKER_EOI /* 217 */:
                int[] iArr161 = this.MediaDescriptionCompatBuilder;
                int i303 = this.MediaDescriptionCompat1;
                iArr161[i303] = iArr161[41];
                Object[] objArr88 = this.MediaDescriptionCompatApi21;
                Object obj80 = objArr88[i303 - 1];
                objArr88[i303 - 1] = null;
                objArr88[i303] = obj80;
                iArr161[i303 - 1] = iArr161[i303];
                this.MediaDescriptionCompat1 = i303 + 2;
                iArr161[i303 + 1] = 0;
                return 0;
            case JfifUtil.MARKER_SOS /* 218 */:
                int[] iArr162 = this.MediaDescriptionCompatBuilder;
                int i304 = this.MediaDescriptionCompat1;
                iArr162[i304 - 1] = iArr162[i304 - 2];
                Object[] objArr89 = this.MediaDescriptionCompatApi21;
                Object obj81 = objArr89[i304 - 1];
                objArr89[i304 - 1] = null;
                objArr89[i304 - 2] = obj81;
                this.MediaDescriptionCompat1 = i304 + 1;
                iArr162[i304] = 0;
                return 0;
            case 219:
                int[] iArr163 = this.MediaDescriptionCompatBuilder;
                int i305 = this.MediaDescriptionCompat1;
                int i306 = iArr163[i305 - 1];
                iArr163[i305 - 1] = iArr163[i305 - 2];
                iArr163[i305 - 2] = i306;
                int i307 = i305 - 3;
                this.MediaDescriptionCompat1 = i307;
                Object[] objArr90 = this.MediaDescriptionCompatApi21;
                Object obj82 = objArr90[i307];
                objArr90[i307] = null;
                ((int[]) obj82)[iArr163[i305 - 2]] = iArr163[i305 - 1];
                return 0;
            case 220:
                Object[] objArr91 = this.MediaDescriptionCompatApi21;
                int i308 = this.MediaDescriptionCompat1;
                Object obj83 = objArr91[i308 - 2];
                objArr91[i308 - 2] = null;
                objArr91[i308 - 1] = obj83;
                int[] iArr164 = this.MediaDescriptionCompatBuilder;
                iArr164[i308 - 2] = iArr164[i308 - 1];
                this.MediaDescriptionCompat1 = i308 + 1;
                iArr164[i308] = 1;
                return 0;
            case 221:
                int i309 = this.MediaDescriptionCompat1;
                int i310 = i309 - 3;
                this.MediaDescriptionCompat1 = i310;
                Object[] objArr92 = this.MediaDescriptionCompatApi21;
                Object obj84 = objArr92[i310];
                objArr92[i310] = null;
                int[] iArr165 = this.MediaDescriptionCompatBuilder;
                ((int[]) obj84)[iArr165[i309 - 2]] = iArr165[i309 - 1];
                return 0;
            case 222:
                Object[] objArr93 = this.MediaDescriptionCompatApi21;
                int i311 = this.MediaDescriptionCompat1;
                objArr93[i311] = objArr93[40];
                objArr93[i311 + 1] = objArr93[45];
                int[] iArr166 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i311 + 3;
                iArr166[i311 + 2] = 2;
                return 0;
            case 223:
                int i312 = this.MediaDescriptionCompat1;
                int i313 = i312 - 3;
                this.MediaDescriptionCompat1 = i313;
                Object[] objArr94 = this.MediaDescriptionCompatApi21;
                Object obj85 = objArr94[i313];
                objArr94[i313] = null;
                int[] iArr167 = this.MediaDescriptionCompatBuilder;
                int i314 = iArr167[i312 - 2];
                Object obj86 = objArr94[i312 - 1];
                objArr94[i312 - 1] = null;
                ((Object[]) obj85)[i314] = obj86;
                objArr94[i313] = objArr94[40];
                this.MediaDescriptionCompat1 = i312 - 1;
                iArr167[i312 - 2] = iArr167[43];
                return 0;
            case 224:
                int i315 = this.MediaDescriptionCompat1;
                int[] iArr168 = this.MediaDescriptionCompatBuilder;
                iArr168[48] = iArr168[i315 - 1];
                int i316 = i315 - 2;
                this.MediaDescriptionCompat1 = i316;
                iArr168[47] = iArr168[i316];
                return 0;
            case JfifUtil.MARKER_APP1 /* 225 */:
                int i317 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i317;
                int[] iArr169 = this.MediaDescriptionCompatBuilder;
                iArr169[46] = iArr169[i317];
                return 0;
            case 226:
                int[] iArr170 = this.MediaDescriptionCompatBuilder;
                int i318 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i318 + 1;
                iArr170[i318] = iArr170[46];
                return 0;
            case 227:
                int[] iArr171 = this.MediaDescriptionCompatBuilder;
                int i319 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i319 + 1;
                iArr171[i319] = iArr171[48];
                return 0;
            case 228:
                int[] iArr172 = this.MediaDescriptionCompatBuilder;
                int i320 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i320 + 1;
                iArr172[i320] = iArr172[47];
                return 0;
            case 229:
                int[] iArr173 = this.MediaDescriptionCompatBuilder;
                int i321 = this.MediaDescriptionCompat1;
                iArr173[i321] = iArr173[i321 - 1];
                this.MediaDescriptionCompat1 = i321;
                iArr173[46] = iArr173[i321];
                return 0;
            case 230:
                int[] iArr174 = this.MediaDescriptionCompatBuilder;
                int i322 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i322 + 1;
                iArr174[i322] = 13;
                return 0;
            case 231:
                int i323 = this.MediaDescriptionCompat1;
                int i324 = i323 - 1;
                this.MediaDescriptionCompat1 = i324;
                int[] iArr175 = this.MediaDescriptionCompatBuilder;
                iArr175[i323 - 2] = iArr175[i323 - 2] ^ iArr175[i324];
                return 0;
            case 232:
                int[] iArr176 = this.MediaDescriptionCompatBuilder;
                int i325 = this.MediaDescriptionCompat1;
                iArr176[i325] = iArr176[i325 - 1];
                iArr176[46] = iArr176[i325];
                this.MediaDescriptionCompat1 = i325 + 1;
                iArr176[i325] = 17;
                return 0;
            case 233:
                int i326 = this.MediaDescriptionCompat1;
                int i327 = i326 - 1;
                this.MediaDescriptionCompat1 = i327;
                int[] iArr177 = this.MediaDescriptionCompatBuilder;
                iArr177[i326 - 2] = iArr177[i326 - 2] >>> iArr177[i327];
                return 0;
            case 234:
                int[] iArr178 = this.MediaDescriptionCompatBuilder;
                int i328 = this.MediaDescriptionCompat1;
                iArr178[i328] = iArr178[i328 - 1];
                this.MediaDescriptionCompat1 = i328 + 2;
                iArr178[i328 + 1] = iArr178[i328];
                return 0;
            case 235:
                int[] iArr179 = this.MediaDescriptionCompatBuilder;
                int i329 = this.MediaDescriptionCompat1;
                iArr179[i329] = 5;
                this.MediaDescriptionCompat1 = i329;
                iArr179[i329 - 1] = iArr179[i329 - 1] << iArr179[i329];
                return 0;
            case 236:
                int i330 = this.MediaDescriptionCompat1;
                int i331 = i330 - 1;
                this.MediaDescriptionCompat1 = i331;
                int[] iArr180 = this.MediaDescriptionCompatBuilder;
                iArr180[i330 - 2] = iArr180[i331] ^ iArr180[i330 - 2];
                Object[] objArr95 = this.MediaDescriptionCompatApi21;
                Object obj87 = objArr95[i330 - 3];
                objArr95[i330 - 3] = null;
                objArr95[i330 - 2] = obj87;
                iArr180[i330 - 3] = iArr180[i330 - 2];
                return 0;
            case 237:
                int[] iArr181 = this.MediaDescriptionCompatBuilder;
                int i332 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i332 + 1;
                iArr181[i332] = 3;
                return 0;
            case 238:
                int[] iArr182 = this.MediaDescriptionCompatBuilder;
                int i333 = this.MediaDescriptionCompat1;
                iArr182[i333] = 2;
                this.MediaDescriptionCompat1 = i333 + 2;
                iArr182[i333 + 1] = 2;
                return 0;
            case 239:
                int[] iArr183 = this.MediaDescriptionCompatBuilder;
                int i334 = this.MediaDescriptionCompat1;
                iArr183[i334] = 39;
                this.MediaDescriptionCompat1 = i334;
                iArr183[i334 - 1] = iArr183[i334 - 1] + iArr183[i334];
                return 0;
            case 240:
                int[] iArr184 = this.MediaDescriptionCompatBuilder;
                int i335 = this.MediaDescriptionCompat1;
                iArr184[i335] = iArr184[i335 - 1];
                iArr184[i335 + 1] = 128;
                int i336 = i335 + 1;
                this.MediaDescriptionCompat1 = i336;
                iArr184[i335] = iArr184[i335] % iArr184[i336];
                return 0;
            case 241:
                long[] jArr23 = this.setDescription;
                int i337 = this.MediaDescriptionCompat1;
                jArr23[i337] = jArr23[18];
                int[] iArr185 = this.MediaDescriptionCompatBuilder;
                this.MediaDescriptionCompat1 = i337 + 2;
                iArr185[i337 + 1] = iArr185[21];
                return 0;
            case 242:
                int i338 = this.MediaDescriptionCompat1;
                int i339 = i338 - 1;
                long[] jArr24 = this.setDescription;
                long j = jArr24[i338 - 2];
                int[] iArr186 = this.MediaDescriptionCompatBuilder;
                jArr24[i338 - 2] = j >> iArr186[i339];
                iArr186[i338 - 2] = (int) jArr24[i338 - 2];
                this.MediaDescriptionCompat1 = i338;
                iArr186[i339] = 24024;
                return 0;
            case 243:
                int i340 = this.MediaDescriptionCompat1;
                int i341 = i340 - 1;
                int[] iArr187 = this.MediaDescriptionCompatBuilder;
                iArr187[i340 - 2] = iArr187[i340 - 2] & iArr187[i341];
                this.MediaDescriptionCompat1 = i340;
                iArr187[i341] = iArr187[15];
                return 0;
            case 244:
                int[] iArr188 = this.MediaDescriptionCompatBuilder;
                int i342 = this.MediaDescriptionCompat1;
                iArr188[i342] = 36;
                iArr188[i342 - 1] = iArr188[i342 - 1] >>> iArr188[i342];
                int i343 = i342 - 1;
                this.MediaDescriptionCompat1 = i343;
                iArr188[i342 - 2] = iArr188[i342 - 2] - iArr188[i343];
                return 0;
            case 245:
                int[] iArr189 = this.MediaDescriptionCompatBuilder;
                int i344 = this.MediaDescriptionCompat1;
                iArr189[i344] = iArr189[15];
                this.MediaDescriptionCompat1 = i344 + 2;
                iArr189[i344 + 1] = 126;
                return 0;
            case 246:
                int i345 = this.MediaDescriptionCompat1;
                int[] iArr190 = this.MediaDescriptionCompatBuilder;
                iArr190[i345 - 2] = iArr190[i345 - 2] * iArr190[i345 - 1];
                int i346 = i345 - 2;
                this.MediaDescriptionCompat1 = i346;
                iArr190[i345 - 3] = iArr190[i345 - 3] * iArr190[i346];
                return 0;
            case 247:
                int[] iArr191 = this.MediaDescriptionCompatBuilder;
                int i347 = this.MediaDescriptionCompat1;
                iArr191[i347] = iArr191[15];
                this.MediaDescriptionCompat1 = i347;
                iArr191[i347 - 1] = iArr191[i347 - 1] << iArr191[i347];
                return 0;
            case 248:
                int i348 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i348;
                int[] iArr192 = this.MediaDescriptionCompatBuilder;
                iArr192[15] = iArr192[i348];
                iArr192[21] = iArr192[21] + 71;
                return 0;
            case 249:
                int[] iArr193 = this.MediaDescriptionCompatBuilder;
                int i349 = this.MediaDescriptionCompat1;
                iArr193[i349] = 93;
                this.MediaDescriptionCompat1 = i349;
                iArr193[i349 - 1] = iArr193[i349 - 1] + iArr193[i349];
                return 0;
            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                int[] iArr194 = this.MediaDescriptionCompatBuilder;
                int i350 = this.MediaDescriptionCompat1;
                iArr194[i350] = 128;
                this.MediaDescriptionCompat1 = i350;
                iArr194[i350 - 1] = iArr194[i350 - 1] % iArr194[i350];
                return 0;
            case 251:
                int[] iArr195 = this.MediaDescriptionCompatBuilder;
                int i351 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i351 + 1;
                iArr195[i351] = 81;
                return 0;
            case 252:
                int[] iArr196 = this.MediaDescriptionCompatBuilder;
                int i352 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i352 + 1;
                iArr196[i352] = 5;
                return 0;
            case 253:
                int i353 = this.MediaDescriptionCompat1;
                int i354 = i353 - 1;
                int[] iArr197 = this.MediaDescriptionCompatBuilder;
                iArr197[i353 - 2] = iArr197[i353 - 2] + iArr197[i354];
                iArr197[i354] = iArr197[i353 - 2];
                this.MediaDescriptionCompat1 = i353 + 1;
                iArr197[i353] = 128;
                return 0;
            case 254:
                int[] iArr198 = this.MediaDescriptionCompatBuilder;
                int i355 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i355 + 1;
                iArr198[i355] = 87;
                return 0;
            case 255:
                int[] iArr199 = this.MediaDescriptionCompatBuilder;
                int i356 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i356 + 1;
                iArr199[i356] = 61;
                return 0;
            case 256:
                int i357 = this.MediaDescriptionCompat1 - 1;
                this.MediaDescriptionCompat1 = i357;
                long[] jArr25 = this.setDescription;
                jArr25[18] = jArr25[i357];
                int[] iArr200 = this.MediaDescriptionCompatBuilder;
                iArr200[20] = iArr200[20] + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                return 0;
            case 257:
                int[] iArr201 = this.MediaDescriptionCompatBuilder;
                int i358 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i358 + 1;
                iArr201[i358] = 15;
                return 0;
            case 258:
                int[] iArr202 = this.MediaDescriptionCompatBuilder;
                int i359 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i359 + 1;
                iArr202[i359] = 36;
                return 0;
            case 259:
                int[] iArr203 = this.MediaDescriptionCompatBuilder;
                int i360 = this.MediaDescriptionCompat1;
                this.MediaDescriptionCompat1 = i360 + 1;
                iArr203[i360] = 85;
                return 0;
            default:
                return i;
        }
    }

    public mayLaunchUrl(Object obj, int i) {
        int[] iArr = new int[50];
        this.MediaDescriptionCompatBuilder = iArr;
        this.setDescription = new long[50];
        this.setMediaId = new float[50];
        this.setSubtitle = new double[50];
        Object[] objArr = new Object[50];
        this.MediaDescriptionCompatApi21 = objArr;
        objArr[8] = obj;
        iArr[9] = i;
        this.MediaDescriptionCompat1 = 0;
        this.getMediaUri = -1;
    }

    public mayLaunchUrl(Object obj) {
        this.MediaDescriptionCompatBuilder = new int[50];
        this.setDescription = new long[50];
        this.setMediaId = new float[50];
        this.setSubtitle = new double[50];
        Object[] objArr = new Object[50];
        this.MediaDescriptionCompatApi21 = objArr;
        objArr[8] = obj;
        this.MediaDescriptionCompat1 = 0;
        this.getMediaUri = -1;
    }
}
