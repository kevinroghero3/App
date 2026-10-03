package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CatalogEvent extends EngagementEvent {
    public static final Companion Companion = new Companion(null);
    private final CatalogObject catalogObject;

    public /* synthetic */ CatalogEvent(String str, CatalogObject catalogObject, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, catalogObject);
    }

    @JvmStatic
    public static final CommentCatalogEvent comment(@NotNull CatalogObject catalogObject) {
        return Companion.comment(catalogObject);
    }

    @JvmStatic
    public static final FavoriteCatalogEvent favorite(@NotNull CatalogObject catalogObject) {
        return Companion.favorite(catalogObject);
    }

    @JvmStatic
    public static final QuickViewCatalogEvent quickView(@NotNull CatalogObject catalogObject) {
        return Companion.quickView(catalogObject);
    }

    @JvmStatic
    public static final ReviewCatalogEvent review(@NotNull CatalogObject catalogObject) {
        return Companion.review(catalogObject);
    }

    @JvmStatic
    public static final ShareCatalogEvent share(@NotNull CatalogObject catalogObject) {
        return Companion.share(catalogObject);
    }

    @JvmStatic
    public static final ViewCatalogEvent view(@NotNull CatalogObject catalogObject) {
        return Companion.view(catalogObject);
    }

    @JvmStatic
    public static final ViewCatalogDetailEvent viewDetail(@NotNull CatalogObject catalogObject) {
        return Companion.viewDetail(catalogObject);
    }

    public final CatalogObject getCatalogObject() {
        return this.catalogObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewCatalogEvent view(@NotNull CatalogObject catalogObject) {
            Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
            try {
                return new ViewCatalogEvent(catalogObject);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final ViewCatalogDetailEvent viewDetail(@NotNull CatalogObject catalogObject) {
            Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
            try {
                return new ViewCatalogDetailEvent(catalogObject);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final QuickViewCatalogEvent quickView(@NotNull CatalogObject catalogObject) {
            Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
            try {
                return new QuickViewCatalogEvent(catalogObject);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final ShareCatalogEvent share(@NotNull CatalogObject catalogObject) {
            Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
            try {
                return new ShareCatalogEvent(catalogObject);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final ReviewCatalogEvent review(@NotNull CatalogObject catalogObject) {
            Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
            try {
                return new ReviewCatalogEvent(catalogObject);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final CommentCatalogEvent comment(@NotNull CatalogObject catalogObject) {
            Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
            try {
                return new CommentCatalogEvent(catalogObject);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final FavoriteCatalogEvent favorite(@NotNull CatalogObject catalogObject) {
            Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
            try {
                return new FavoriteCatalogEvent(catalogObject);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private CatalogEvent(String str, CatalogObject catalogObject) {
        super(str, null);
        this.catalogObject = catalogObject;
    }
}
