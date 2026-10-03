package com.salesforce.marketingcloud.push.buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import com.salesforce.marketingcloud.R;
import com.salesforce.marketingcloud.media.q;
import com.salesforce.marketingcloud.push.data.Style;
import com.salesforce.marketingcloud.push.k;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements k<a> {
    private final Context a;
    private final com.salesforce.marketingcloud.push.b b;

    public c(@NotNull Context context, @NotNull com.salesforce.marketingcloud.push.b richButtonIntentProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(richButtonIntentProvider, "richButtonIntentProvider");
        this.a = context;
        this.b = richButtonIntentProvider;
    }

    @Override // com.salesforce.marketingcloud.push.k
    public RemoteViews a(@NotNull RemoteViews remoteViews, @NotNull a template) {
        CharSequence charSequenceN;
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(template, "template");
        if (template.k().isEmpty()) {
            throw new IllegalArgumentException("Rich Buttons template must have at least one item");
        }
        com.salesforce.marketingcloud.push.style.a.b bVar = new com.salesforce.marketingcloud.push.style.a.b(this.a);
        remoteViews.setViewVisibility(R.id.mcsdk_push_custom_buttons, 0);
        remoteViews.setViewVisibility(R.id.mcsdk_push_button_list, 0);
        int i = 0;
        for (Object obj : template.k()) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            a.c cVar = (a.c) obj;
            int identifier = this.a.getResources().getIdentifier("mcsdk_btn_item_" + i, "id", this.a.getPackageName());
            remoteViews.setViewVisibility(identifier, 0);
            com.salesforce.marketingcloud.push.b bVar2 = this.b;
            List<com.salesforce.marketingcloud.push.data.a> listH = cVar.h();
            Unit unit = null;
            com.salesforce.marketingcloud.push.data.a[] aVarArr = listH != null ? (com.salesforce.marketingcloud.push.data.a[]) listH.toArray(new com.salesforce.marketingcloud.push.data.a[0]) : null;
            String strD = cVar.d();
            com.salesforce.marketingcloud.push.data.c cVarP = cVar.p();
            remoteViews.setOnClickPendingIntent(identifier, bVar2.a(aVarArr, com.salesforce.marketingcloud.analytics.stats.b.f40o, strD, cVarP != null ? cVarP.n() : null));
            com.salesforce.marketingcloud.push.data.c cVarP2 = cVar.p();
            if (cVarP2 != null) {
                int identifier2 = this.a.getResources().getIdentifier("mcsdk_btn_title_" + i, "id", this.a.getPackageName());
                remoteViews.setViewVisibility(identifier2, 0);
                Style.b bVarA = ((com.salesforce.marketingcloud.push.data.c) com.salesforce.marketingcloud.push.style.a.a(bVar, cVarP2, null, 2, null)).a();
                if (bVarA == null || (charSequenceN = bVarA.o()) == null) {
                    charSequenceN = cVarP2.n();
                }
                remoteViews.setTextViewText(identifier2, charSequenceN);
            }
            int identifier3 = this.a.getResources().getIdentifier("mcsdk_btn_img_" + i, "id", this.a.getPackageName());
            String strO = cVar.o();
            if (strO != null) {
                remoteViews.setViewVisibility(identifier3, 0);
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.a.getResources(), q.a.a(this.a, strO));
                if (bitmapDecodeResource != null) {
                    remoteViews.setImageViewBitmap(identifier3, bitmapDecodeResource);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    remoteViews.setViewVisibility(identifier3, 8);
                }
            }
            i++;
        }
        return remoteViews;
    }
}
