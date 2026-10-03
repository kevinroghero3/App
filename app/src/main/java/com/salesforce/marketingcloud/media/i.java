package com.salesforce.marketingcloud.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class i extends v {
    private static final String c = "drawable";
    private final Context a;
    private int b;

    i(Context context) {
        this.a = context;
    }

    @Override // com.salesforce.marketingcloud.media.v
    public boolean a(t tVar) {
        if (c.equalsIgnoreCase(tVar.a.getScheme())) {
            this.b = this.a.getResources().getIdentifier(tVar.a.getHost(), c, this.a.getPackageName());
        }
        return this.b > 0;
    }

    @Override // com.salesforce.marketingcloud.media.v
    public void a(o oVar, t tVar, v.a aVar) throws IOException {
        Drawable drawable = ContextCompat.getDrawable(this.a, this.b);
        if (drawable == null) {
            aVar.a(new IllegalStateException("Invalid res id for drawable"));
        } else {
            aVar.a(new v.b(drawable, o.b.MEMORY));
        }
    }
}
