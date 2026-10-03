package com.salesforce.marketingcloud.sfmcsdk.modules.cdp;

import com.salesforce.marketingcloud.cdp.consent.Consent;
import com.salesforce.marketingcloud.cdp.events.Event;
import com.salesforce.marketingcloud.cdp.location.Coordinates;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CdpModuleInterface implements ModuleInterface {
    public abstract Consent getConsent();

    public abstract void setConsent(@NotNull Consent consent);

    public abstract void setLocation(@Nullable Coordinates coordinates, long j);

    public abstract void track(@Nullable Event event);
}
