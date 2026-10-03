package com.facebook.fresco.middleware;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface HasExtraData {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String KEY_BITMAP_CONFIG = "bitmap_config";
    public static final String KEY_COLOR_SPACE = "image_color_space";
    public static final String KEY_ENCODED_HEIGHT = "encoded_height";
    public static final String KEY_ENCODED_SIZE = "encoded_size";
    public static final String KEY_ENCODED_WIDTH = "encoded_width";
    public static final String KEY_ID = "id";
    public static final String KEY_IMAGE_FORMAT = "image_format";
    public static final String KEY_IMAGE_SOURCE_EXTRAS = "image_source_extras";
    public static final String KEY_IMAGE_SOURCE_TYPE = "image_source_type";
    public static final String KEY_IS_ROUNDED = "is_rounded";
    public static final String KEY_LAST_SCAN_NUMBER = "last_scan_num";
    public static final String KEY_MODIFIED_URL = "modified_url";
    public static final String KEY_MULTIPLEX_BITMAP_COUNT = "multiplex_bmp_cnt";
    public static final String KEY_MULTIPLEX_ENCODED_COUNT = "multiplex_enc_cnt";
    public static final String KEY_NON_FATAL_DECODE_ERROR = "non_fatal_decode_error";
    public static final String KEY_ORIGIN = "origin";
    public static final String KEY_ORIGINAL_URL = "original_url";
    public static final String KEY_ORIGIN_SUBCATEGORY = "origin_sub";
    public static final String KEY_URI_SOURCE = "uri_source";

    <E> E getExtra(@NotNull String str);

    <E> E getExtra(@NotNull String str, @Nullable E e);

    Map<String, Object> getExtras();

    <E> void putExtra(@NotNull String str, @Nullable E e);

    void putExtras(@NotNull Map<String, ? extends Object> map);

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getExtra$default(HasExtraData hasExtraData, String str, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getExtra");
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            return hasExtraData.getExtra(str, obj);
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String KEY_BITMAP_CONFIG = "bitmap_config";
        public static final String KEY_COLOR_SPACE = "image_color_space";
        public static final String KEY_ENCODED_HEIGHT = "encoded_height";
        public static final String KEY_ENCODED_SIZE = "encoded_size";
        public static final String KEY_ENCODED_WIDTH = "encoded_width";
        public static final String KEY_ID = "id";
        public static final String KEY_IMAGE_FORMAT = "image_format";
        public static final String KEY_IMAGE_SOURCE_EXTRAS = "image_source_extras";
        public static final String KEY_IMAGE_SOURCE_TYPE = "image_source_type";
        public static final String KEY_IS_ROUNDED = "is_rounded";
        public static final String KEY_LAST_SCAN_NUMBER = "last_scan_num";
        public static final String KEY_MODIFIED_URL = "modified_url";
        public static final String KEY_MULTIPLEX_BITMAP_COUNT = "multiplex_bmp_cnt";
        public static final String KEY_MULTIPLEX_ENCODED_COUNT = "multiplex_enc_cnt";
        public static final String KEY_NON_FATAL_DECODE_ERROR = "non_fatal_decode_error";
        public static final String KEY_ORIGIN = "origin";
        public static final String KEY_ORIGINAL_URL = "original_url";
        public static final String KEY_ORIGIN_SUBCATEGORY = "origin_sub";
        public static final String KEY_URI_SOURCE = "uri_source";

        private Companion() {
        }
    }
}
