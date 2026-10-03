package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.R;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class GenericDraweeHierarchyInflater {
    public static GenericDraweeHierarchy inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context context, @Nullable AttributeSet attributeSet) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilderUpdateBuilder = updateBuilder(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return genericDraweeHierarchyBuilderUpdateBuilder;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x01e3 A[PHI: r1 r3 r6
  0x01e3: PHI (r1v17 boolean) = (r1v13 boolean), (r1v19 boolean) binds: [B:129:0x01e1, B:114:0x01c7] A[DONT_GENERATE, DONT_INLINE]
  0x01e3: PHI (r3v10 boolean) = (r3v6 boolean), (r3v12 boolean) binds: [B:129:0x01e1, B:114:0x01c7] A[DONT_GENERATE, DONT_INLINE]
  0x01e3: PHI (r6v9 boolean) = (r6v5 boolean), (r6v11 boolean) binds: [B:129:0x01e1, B:114:0x01c7] A[DONT_GENERATE, DONT_INLINE]] */
    public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, @Nullable AttributeSet attributeSet) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        boolean z5;
        boolean z6;
        boolean z7;
        Context context2 = context;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.GenericDraweeHierarchy);
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                boolean z8 = true;
                int i3 = 0;
                boolean z9 = true;
                boolean z10 = true;
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                boolean z14 = true;
                boolean z15 = true;
                int integer = 0;
                int dimensionPixelSize = 0;
                while (i3 < indexCount) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i3);
                    if (index == R.styleable.GenericDraweeHierarchy_actualImageScaleType) {
                        genericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_placeholderImage) {
                        genericDraweeHierarchyBuilder.setPlaceholderImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage) {
                        genericDraweeHierarchyBuilder.setPressedStateOverlay(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_progressBarImage) {
                        genericDraweeHierarchyBuilder.setProgressBarImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_fadeDuration) {
                        genericDraweeHierarchyBuilder.setFadeDuration(typedArrayObtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.GenericDraweeHierarchy_viewAspectRatio) {
                        genericDraweeHierarchyBuilder.setDesiredAspectRatio(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == R.styleable.GenericDraweeHierarchy_placeholderImageScaleType) {
                        genericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_retryImage) {
                        genericDraweeHierarchyBuilder.setRetryImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_retryImageScaleType) {
                        genericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_failureImage) {
                        genericDraweeHierarchyBuilder.setFailureImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_failureImageScaleType) {
                        genericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_progressBarImageScaleType) {
                        genericDraweeHierarchyBuilder.setProgressBarImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                        integer = typedArrayObtainStyledAttributes.getInteger(index, integer);
                    } else if (index == R.styleable.GenericDraweeHierarchy_backgroundImage) {
                        genericDraweeHierarchyBuilder.setBackground(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_overlayImage) {
                        genericDraweeHierarchyBuilder.setOverlay(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundAsCircle) {
                        getRoundingParams(genericDraweeHierarchyBuilder).setRoundAsCircle(typedArrayObtainStyledAttributes.getBoolean(index, false));
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundedCornerRadius) {
                        dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                    } else {
                        int i4 = dimensionPixelSize;
                        if (index == R.styleable.GenericDraweeHierarchy_roundTopLeft) {
                            z9 = typedArrayObtainStyledAttributes.getBoolean(index, z9);
                        } else if (index == R.styleable.GenericDraweeHierarchy_roundTopRight) {
                            z12 = typedArrayObtainStyledAttributes.getBoolean(index, z12);
                        } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomLeft) {
                            z8 = typedArrayObtainStyledAttributes.getBoolean(index, z8);
                        } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomRight) {
                            z13 = typedArrayObtainStyledAttributes.getBoolean(index, z13);
                        } else if (index == R.styleable.GenericDraweeHierarchy_roundTopStart) {
                            z10 = typedArrayObtainStyledAttributes.getBoolean(index, z10);
                        } else if (index == R.styleable.GenericDraweeHierarchy_roundTopEnd) {
                            z11 = typedArrayObtainStyledAttributes.getBoolean(index, z11);
                        } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomStart) {
                            z15 = typedArrayObtainStyledAttributes.getBoolean(index, z15);
                        } else {
                            if (index == R.styleable.GenericDraweeHierarchy_roundBottomEnd) {
                                z14 = typedArrayObtainStyledAttributes.getBoolean(index, z14);
                            } else if (index == R.styleable.GenericDraweeHierarchy_roundWithOverlayColor) {
                                dimensionPixelSize = i4;
                                getRoundingParams(genericDraweeHierarchyBuilder).setOverlayColor(typedArrayObtainStyledAttributes.getColor(index, 0));
                            } else {
                                dimensionPixelSize = i4;
                                if (index == R.styleable.GenericDraweeHierarchy_roundingBorderWidth) {
                                    getRoundingParams(genericDraweeHierarchyBuilder).setBorderWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundingBorderColor) {
                                    getRoundingParams(genericDraweeHierarchyBuilder).setBorderColor(typedArrayObtainStyledAttributes.getColor(index, 0));
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundingBorderPadding) {
                                    getRoundingParams(genericDraweeHierarchyBuilder).setPadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                                }
                            }
                            i3++;
                            context2 = context;
                        }
                        dimensionPixelSize = i4;
                    }
                    i3++;
                    context2 = context;
                }
                boolean z16 = false;
                typedArrayObtainStyledAttributes.recycle();
                if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                    z5 = z9 && z11;
                    z6 = z12 && z10;
                    z7 = z13 && z15;
                    if (z8 && z14) {
                        z16 = true;
                    }
                } else {
                    z5 = z9 && z10;
                    z6 = z12 && z11;
                    z7 = z13 && z14;
                    if (z8 && z15) {
                        z16 = true;
                    }
                }
                boolean z17 = z7;
                z = z6;
                z4 = z16;
                z2 = z17;
                i = integer;
                z3 = z5;
                i2 = dimensionPixelSize;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                context.getResources().getConfiguration().getLayoutDirection();
                throw th;
            }
        } else {
            z = true;
            i = 0;
            z2 = true;
            z3 = true;
            z4 = true;
            i2 = 0;
        }
        if (genericDraweeHierarchyBuilder.getProgressBarImage() != null && i > 0) {
            genericDraweeHierarchyBuilder.setProgressBarImage(new AutoRotateDrawable(genericDraweeHierarchyBuilder.getProgressBarImage(), i));
        }
        if (i2 > 0) {
            getRoundingParams(genericDraweeHierarchyBuilder).setCornersRadii(z3 ? i2 : 0.0f, z ? i2 : 0.0f, z2 ? i2 : 0.0f, z4 ? i2 : 0.0f);
        }
        return genericDraweeHierarchyBuilder;
    }

    private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
            genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
        }
        return genericDraweeHierarchyBuilder.getRoundingParams();
    }

    @Nullable
    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getDrawable(resourceId);
    }

    @Nullable
    public static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils.ScaleType.FIT_XY;
            case 1:
                return ScalingUtils.ScaleType.FIT_START;
            case 2:
                return ScalingUtils.ScaleType.FIT_CENTER;
            case 3:
                return ScalingUtils.ScaleType.FIT_END;
            case 4:
                return ScalingUtils.ScaleType.CENTER;
            case 5:
                return ScalingUtils.ScaleType.CENTER_INSIDE;
            case 6:
                return ScalingUtils.ScaleType.CENTER_CROP;
            case 7:
                return ScalingUtils.ScaleType.FOCUS_CROP;
            case 8:
                return ScalingUtils.ScaleType.FIT_BOTTOM_START;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
