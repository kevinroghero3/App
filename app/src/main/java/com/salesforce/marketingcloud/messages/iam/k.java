package com.salesforce.marketingcloud.messages.iam;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.media.o;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();
    private static final String h = com.salesforce.marketingcloud.g.a("MessageHandler");
    private final InAppMessage b;
    private i c;
    private long d;
    private long e;
    private long f;
    private boolean g;

    class a implements Parcelable.Creator<k> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    }

    k(@NonNull InAppMessage inAppMessage) {
        MarketingCloudSdk marketingCloudSdk;
        this.d = -1L;
        this.g = true;
        this.b = inAppMessage;
        if ((MarketingCloudSdk.isInitializing() || MarketingCloudSdk.isReady()) && (marketingCloudSdk = MarketingCloudSdk.getInstance()) != null) {
            this.c = (i) marketingCloudSdk.getInAppMessageManager();
        }
    }

    private void p() {
        if (this.g) {
            this.e += SystemClock.elapsedRealtime() - this.f;
        }
    }

    void a(@NonNull j jVar) {
        i iVar = this.c;
        if (iVar != null) {
            InAppMessage inAppMessage = this.b;
            if (jVar == null) {
                jVar = j.m();
            }
            iVar.handleMessageFinished(inAppMessage, jVar);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    boolean h() {
        i iVar;
        InAppMessage inAppMessage = this.b;
        return (inAppMessage == null || (iVar = this.c) == null || !iVar.canDisplay(inAppMessage)) ? false : true;
    }

    public long j() {
        return this.e;
    }

    Date k() {
        return new Date(this.d);
    }

    public InAppMessage l() {
        return this.b;
    }

    public o m() {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.imageHandler();
        }
        return null;
    }

    void n() {
        p();
    }

    void o() {
        if (this.d == -1) {
            this.d = System.currentTimeMillis();
        }
        this.f = SystemClock.elapsedRealtime();
    }

    int q() {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.getStatusBarColor();
        }
        return 0;
    }

    void r() {
        p();
        this.g = false;
    }

    public Typeface s() {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.getTypeface();
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.g ? 1 : 0);
    }

    PendingIntent a(@NonNull Context context, @NonNull InAppMessage.Button button) {
        UrlHandler urlHandler;
        String strAction = button.action();
        if (button.actionType() == InAppMessage.Button.ActionType.url && strAction != null && (urlHandler = this.c.urlHandler()) != null) {
            try {
                return urlHandler.handleUrl(context, strAction, "action");
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(h, e, "Exception thrown by %s while handling url", urlHandler.getClass().getName());
            }
        }
        return null;
    }

    protected k(Parcel parcel) {
        this((InAppMessage) parcel.readParcelable(InAppMessage.class.getClassLoader()));
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.g = parcel.readInt() == 1;
    }
}
