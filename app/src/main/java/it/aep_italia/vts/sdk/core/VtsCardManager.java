package it.aep_italia.vts.sdk.core;

import it.aep_italia.vts.sdk.domain.VtsCreditCard;
import it.aep_italia.vts.sdk.dto.domain.VtsCreditCardDTO;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.CreditCardsInput;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsWellKnownStrings;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsCardManager {
    private VtsSdk a;

    VtsCardManager(VtsSdk vtsSdk) {
        this.a = vtsSdk;
    }

    private List<VtsCreditCardDTO> a(CreditCardsInput creditCardsInput) throws VtsException {
        return this.a.openConnection().a(creditCardsInput);
    }

    public void addCreditCard(VtsCreditCard vtsCreditCard) throws VtsException {
        this.a.a("VtsCardManager#addCreditCard", StringUtils.stringifyParams("CreditCard", vtsCreditCard));
        ValidationUtils.assertNonNull(vtsCreditCard, VtsError.INVALID_PARAMETER, "Credit card cannot be null", new Object[0]);
        a(CreditCardsInput.forAddOperation(vtsCreditCard));
    }

    public VtsCreditCard getActiveCard() {
        this.a.a("VtsCardManager#getActiveCard");
        e eVarD = this.a.d();
        if (!eVarD.c(VtsWellKnownStrings.FILE_ACTIVE_CARD)) {
            return null;
        }
        try {
            return VtsCreditCard.fromDto((VtsCreditCardDTO) SerializationUtils.deserializeFromXml(eVarD.b(VtsWellKnownStrings.FILE_ACTIVE_CARD), VtsCreditCardDTO.class));
        } catch (Exception e) {
            VtsLog.e(e, "Could not load credit card from wallet", new Object[0]);
            throw new VtsException(VtsError.COULD_NOT_SAVE_CARD, e);
        }
    }

    public List<VtsCreditCard> getCreditCards() throws VtsException {
        this.a.a("VtsCardManager#getCreditCards");
        ArrayList arrayList = new ArrayList();
        List<VtsCreditCardDTO> listA = a(CreditCardsInput.forContentOperation());
        if (listA != null) {
            Iterator<VtsCreditCardDTO> it2 = listA.iterator();
            while (it2.hasNext()) {
                arrayList.add(VtsCreditCard.fromDto(it2.next()));
            }
        }
        return arrayList;
    }

    public void removeAllCreditCards() {
        this.a.a("VtsCardManager#removeAllCreditCards");
        a(CreditCardsInput.forEmptyOperation());
        setActiveCard(null);
    }

    public void removeCreditCard(VtsCreditCard vtsCreditCard) throws VtsException {
        this.a.a("VtsCardManager#removeCreditCard", StringUtils.stringifyParams("CreditCard", vtsCreditCard));
        ValidationUtils.assertNonNull(vtsCreditCard, VtsError.INVALID_PARAMETER, "Credit card cannot be null", new Object[0]);
        removeCreditCard(vtsCreditCard.getCardSerialNumber());
    }

    public void removeCreditCard(String str) throws VtsException {
        this.a.a("VtsCardManager#removeCreditCard", StringUtils.stringifyParams("CardSerialNumber", str));
        ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "Serial card number cannot be null or empty", new Object[0]);
        a(CreditCardsInput.forRemoveOperation(str));
        VtsCreditCard activeCard = getActiveCard();
        if (activeCard == null || !activeCard.getCardSerialNumber().equalsIgnoreCase(str)) {
            return;
        }
        setActiveCard(null);
    }

    public void setActiveCard(String str) throws VtsException {
        VtsCreditCard next;
        this.a.a("VtsCardManager#creditCardNumber", StringUtils.stringifyParams("CardSerialNumber", str));
        if (StringUtils.isBlank(str)) {
            this.a.d().d(VtsWellKnownStrings.FILE_ACTIVE_CARD);
            return;
        }
        Iterator<VtsCreditCard> it2 = getCreditCards().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!next.getCardSerialNumber().equalsIgnoreCase(str));
        if (next == null) {
            throw new VtsException(VtsError.INVALID_PARAMETER, "No credit card with serial number \"%s\" found", str);
        }
        try {
            this.a.d().a(VtsWellKnownStrings.FILE_ACTIVE_CARD, SerializationUtils.serializeToXmlBytes(VtsCreditCardDTO.fromDo(next)));
        } catch (Exception e) {
            VtsLog.e(e, "Could not save credit card to wallet", new Object[0]);
            throw new VtsException(VtsError.COULD_NOT_SAVE_CARD, e);
        }
    }
}
