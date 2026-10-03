package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareContentValidation {
    public static final ShareContentValidation INSTANCE = new ShareContentValidation();
    private static final Validator webShareValidator = new WebShareValidator();
    private static final Validator defaultValidator = new Validator();
    private static final Validator apiValidator = new ApiValidator();
    private static final Validator storyValidator = new StoryShareValidator();

    private ShareContentValidation() {
    }

    @JvmStatic
    public static final void validateForMessage(@Nullable ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    @JvmStatic
    public static final void validateForNativeShare(@Nullable ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    @JvmStatic
    public static final void validateForWebShare(@Nullable ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, webShareValidator);
    }

    @JvmStatic
    public static final void validateForApiShare(@Nullable ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, apiValidator);
    }

    @JvmStatic
    public static final void validateForStoryShare(@Nullable ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, storyValidator);
    }

    private final void validate(ShareContent<?, ?> shareContent, Validator validator) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if (shareContent instanceof ShareLinkContent) {
            validator.validate((ShareLinkContent) shareContent);
            return;
        }
        if (shareContent instanceof SharePhotoContent) {
            validator.validate((SharePhotoContent) shareContent);
            return;
        }
        if (shareContent instanceof ShareVideoContent) {
            validator.validate((ShareVideoContent) shareContent);
            return;
        }
        if (shareContent instanceof ShareMediaContent) {
            validator.validate((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            validator.validate((ShareCameraEffectContent) shareContent);
        } else if (shareContent instanceof ShareStoryContent) {
            validator.validate((ShareStoryContent) shareContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateStoryContent(ShareStoryContent shareStoryContent, Validator validator) {
        if (shareStoryContent == null || (shareStoryContent.getBackgroundAsset() == null && shareStoryContent.getStickerAsset() == null)) {
            throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
        }
        if (shareStoryContent.getBackgroundAsset() != null) {
            validator.validate(shareStoryContent.getBackgroundAsset());
        }
        if (shareStoryContent.getStickerAsset() != null) {
            validator.validate(shareStoryContent.getStickerAsset());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateLinkContent(ShareLinkContent shareLinkContent, Validator validator) {
        Uri contentUrl = shareLinkContent.getContentUrl();
        if (contentUrl != null && !Utility.isWebUri(contentUrl)) {
            throw new FacebookException("Content Url must be an http:// or https:// url");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoContent(SharePhotoContent sharePhotoContent, Validator validator) {
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null || photos.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        }
        if (photos.size() > 6) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ROOT, "Cannot add more than %d photos.", Arrays.copyOf(new Object[]{6}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            throw new FacebookException(str);
        }
        Iterator<SharePhoto> it2 = photos.iterator();
        while (it2.hasNext()) {
            validator.validate(it2.next());
        }
    }

    private final void validatePhoto(SharePhoto sharePhoto) {
        if (sharePhoto == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForApi(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && Utility.isWebUri(imageUrl)) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForNativeDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhotoForApi(sharePhoto, validator);
        if (sharePhoto.getBitmap() == null && Utility.isWebUri(sharePhoto.getImageUrl())) {
            return;
        }
        Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForWebDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateVideoContent(ShareVideoContent shareVideoContent, Validator validator) {
        validator.validate(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            validator.validate(previewPhoto);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateVideo(ShareVideo shareVideo, Validator validator) {
        if (shareVideo == null) {
            throw new FacebookException("Cannot share a null ShareVideo");
        }
        Uri localUrl = shareVideo.getLocalUrl();
        if (localUrl == null) {
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        if (!Utility.isContentUri(localUrl) && !Utility.isFileUri(localUrl)) {
            throw new FacebookException("ShareVideo must reference a video that is on the device");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateMediaContent(ShareMediaContent shareMediaContent, Validator validator) {
        List<ShareMedia<?, ?>> media = shareMediaContent.getMedia();
        if (media == null || media.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        }
        if (media.size() > 6) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ROOT, "Cannot add more than %d media.", Arrays.copyOf(new Object[]{6}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            throw new FacebookException(str);
        }
        Iterator<ShareMedia<?, ?>> it2 = media.iterator();
        while (it2.hasNext()) {
            validator.validate(it2.next());
        }
    }

    @JvmStatic
    public static final void validateMedium(@NotNull ShareMedia<?, ?> medium, @NotNull Validator validator) {
        Intrinsics.checkNotNullParameter(medium, "medium");
        Intrinsics.checkNotNullParameter(validator, "validator");
        if (medium instanceof SharePhoto) {
            validator.validate((SharePhoto) medium);
        } else {
            if (medium instanceof ShareVideo) {
                validator.validate((ShareVideo) medium);
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ROOT, "Invalid media type: %s", Arrays.copyOf(new Object[]{medium.getClass().getSimpleName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            throw new FacebookException(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent) {
        if (Utility.isNullOrEmpty(shareCameraEffectContent.getEffectId())) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    private final void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton == null) {
            return;
        }
        if (Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
            throw new FacebookException("Must specify title for ShareMessengerActionButton");
        }
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
        }
    }

    private final void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.getUrl() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    static final class StoryShareValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@Nullable ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }
    }

    static final class WebShareValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@NotNull ShareVideoContent videoContent) {
            Intrinsics.checkNotNullParameter(videoContent, "videoContent");
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@NotNull ShareMediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@NotNull SharePhoto photo) {
            Intrinsics.checkNotNullParameter(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForWebDialog(photo, this);
        }
    }

    static final class ApiValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@NotNull SharePhoto photo) {
            Intrinsics.checkNotNullParameter(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForApi(photo, this);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@NotNull ShareVideoContent videoContent) {
            Intrinsics.checkNotNullParameter(videoContent, "videoContent");
            if (!Utility.isNullOrEmpty(videoContent.getPlaceId())) {
                throw new FacebookException("Cannot share video content with place IDs using the share api");
            }
            if (!Utility.isNullOrEmpty(videoContent.getPeopleIds())) {
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            }
            if (!Utility.isNullOrEmpty(videoContent.getRef())) {
                throw new FacebookException("Cannot share video content with referrer URL using the share api");
            }
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@NotNull ShareMediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@NotNull ShareLinkContent linkContent) {
            Intrinsics.checkNotNullParameter(linkContent, "linkContent");
            if (!Utility.isNullOrEmpty(linkContent.getQuote())) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }
    }

    public static class Validator {
        private static final byte[] $$c = {Ascii.RS, -66, -95, 114};
        private static final int $$d = JfifUtil.MARKER_SOFn;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {68, 66, 84, 89, -11, -2, Ascii.FF};
        private static final int $$b = 173;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] ArtificialStackFrames = {44390, 44700, 44407, 44337, 44699, 44698, 44387, 44697, 44389, 44398, 44399, 44355, 44388, 44358, 44703, 44702, 44405, 44402, 44356, 44383, 44393, 44400, 44404, 44385, 44334, 44696, 44409, 44335, 44690, 44403, 44395, 44391, 44691, 44701, 44386, 44396};
        private static char coroutineCreation = 39068;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r7, short r8, byte r9) {
            /*
                byte[] r0 = com.facebook.share.internal.ShareContentValidation.Validator.$$c
                int r7 = r7 * 4
                int r7 = 1 - r7
                int r9 = 105 - r9
                int r8 = r8 + 4
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L13
                r3 = r9
                r5 = r2
                r9 = r8
                goto L29
            L13:
                r3 = r2
            L14:
                int r8 = r8 + 1
                byte r4 = (byte) r9
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r7) goto L23
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                return r7
            L23:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r6
            L29:
                int r8 = -r8
                int r8 = r8 + r3
                r3 = r5
                r6 = r9
                r9 = r8
                r8 = r6
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareContentValidation.Validator.$$e(short, short, byte):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0029  */
        /* JADX WARN: Code duplicated, block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(short r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.facebook.share.internal.ShareContentValidation.Validator.$$a
                int r7 = r7 * 3
                int r1 = r7 + 4
                int r8 = r8 * 3
                int r8 = r8 + 109
                int r6 = r6 * 4
                int r6 = 4 - r6
                byte[] r1 = new byte[r1]
                int r7 = r7 + 3
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r8
                r4 = r2
                r8 = r6
                goto L2e
            L19:
                r3 = r2
            L1a:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L29
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L29:
                r3 = r0[r6]
                r5 = r8
                r8 = r6
                r6 = r5
            L2e:
                int r3 = -r3
                int r6 = r6 + r3
                int r6 = r6 + (-3)
                int r8 = r8 + 1
                r3 = r4
                r5 = r8
                r8 = r6
                r6 = r5
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareContentValidation.Validator.b(short, int, int, java.lang.Object[]):void");
        }

        private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
            int i2;
            Object obj;
            int i3 = 2;
            int i4 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            long j = 0;
            Object obj2 = null;
            float f = 0.0f;
            if (cArr2 != null) {
                int i5 = $11 + 71;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i7 = 0;
                while (i7 < length) {
                    int i8 = $10 + 39;
                    $11 = i8 % 128;
                    int i9 = i8 % i3;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i7])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                        if (objAccessartificialFrame == null) {
                            int iMyTid = 15 - (Process.myTid() >> 22);
                            char c = (char) ((ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)) + 20488);
                            int i10 = 2148 - (PointF.length(f, f) > f ? 1 : (PointF.length(f, f) == f ? 0 : -1));
                            byte b2 = (byte) 0;
                            byte b3 = (byte) (b2 - 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iMyTid, c, i10, 216710116, false, $$e(b2, b3, (byte) (b3 & 8)), new Class[]{Integer.TYPE});
                        }
                        cArr3[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i7++;
                        i3 = 2;
                        j = 0;
                        f = 0.0f;
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
                byte b5 = (byte) (b4 - 1);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(16 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 20489), 2148 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 216710116, false, $$e(b4, b5, (byte) (b5 & 8)), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                int i11 = $10 + 95;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                int i13 = $11 + 101;
                $10 = i13 % 128;
                int i14 = i13 % 2;
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    int i15 = $10 + 101;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i17 = $10 + 63;
                        $11 = i17 % 128;
                        int i18 = i17 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = (byte) (b6 - 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 46, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 58858), 2464 - (ViewConfiguration.getJumpTapTimeout() >> 16), 276640984, false, $$e(b6, b7, (byte) (b7 + 4)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b8 = (byte) 0;
                                byte b9 = (byte) (b8 - 1);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 24, (char) TextUtils.indexOf("", ""), TextUtils.indexOf("", "", 0, 0) + 792, -834291897, false, $$e(b8, b9, (byte) (b9 + 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i19 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i19];
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i20 = (extracallback.b * cCharValue) + extracallback.j;
                                int i21 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i20];
                                cArr4[extracallback.a + 1] = cArr2[i21];
                                int i22 = $11 + 15;
                                $10 = i22 % 128;
                                int i23 = i22 % 2;
                            } else {
                                int i24 = (extracallback.b * cCharValue) + extracallback.g;
                                int i25 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i24];
                                cArr4[extracallback.a + 1] = cArr2[i25];
                            }
                        }
                    }
                    extracallback.a += 2;
                    obj2 = obj;
                }
            }
            for (int i26 = 0; i26 < i; i26++) {
                cArr4[i26] = (char) (cArr4[i26] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        public void validate(@NotNull ShareLinkContent linkContent) {
            Intrinsics.checkNotNullParameter(linkContent, "linkContent");
            ShareContentValidation.INSTANCE.validateLinkContent(linkContent, this);
        }

        public void validate(@NotNull SharePhotoContent photoContent) {
            Intrinsics.checkNotNullParameter(photoContent, "photoContent");
            ShareContentValidation.INSTANCE.validatePhotoContent(photoContent, this);
        }

        public void validate(@NotNull ShareVideoContent videoContent) {
            Intrinsics.checkNotNullParameter(videoContent, "videoContent");
            ShareContentValidation.INSTANCE.validateVideoContent(videoContent, this);
        }

        public void validate(@NotNull ShareMediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            ShareContentValidation.INSTANCE.validateMediaContent(mediaContent, this);
        }

        public void validate(@NotNull ShareCameraEffectContent cameraEffectContent) {
            Intrinsics.checkNotNullParameter(cameraEffectContent, "cameraEffectContent");
            ShareContentValidation.INSTANCE.validateCameraEffectContent(cameraEffectContent);
        }

        public void validate(@NotNull SharePhoto photo) {
            Intrinsics.checkNotNullParameter(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForNativeDialog(photo, this);
        }

        public void validate(@Nullable ShareVideo shareVideo) {
            ShareContentValidation.INSTANCE.validateVideo(shareVideo, this);
        }

        public void validate(@NotNull ShareMedia<?, ?> medium) {
            Intrinsics.checkNotNullParameter(medium, "medium");
            ShareContentValidation.validateMedium(medium, this);
        }

        public void validate(@Nullable ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] coroutineCreation(int r27, int r28) {
            /*
                Method dump skipped, instruction units count: 3612
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareContentValidation.Validator.coroutineCreation(int, int):java.lang.Object[]");
        }
    }
}
