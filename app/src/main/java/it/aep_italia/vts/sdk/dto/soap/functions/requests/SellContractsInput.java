package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import android.os.SystemClock;
import it.aep_italia.vts.sdk.domain.VtsSellProposal;
import it.aep_italia.vts.sdk.domain.VtsShoppingCart;
import it.aep_italia.vts.sdk.domain.VtsShoppingItem;
import it.aep_italia.vts.sdk.domain.enums.VtsReceiptType;
import it.aep_italia.vts.sdk.domain.payments.VtsPayment;
import it.aep_italia.vts.sdk.dto.domain.VtsSellContractsProposalDTO;
import it.aep_italia.vts.sdk.dto.domain.payments.VtsSellContractsPaymentDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class SellContractsInput implements VtsSoapFunctionPayload {
    public static int setPlaybackState;
    public static int setPlaybackToRemote;

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Element(name = "Parameters")
    @Namespace(reference = VtsSoapEnvelope.NAMESPACE_AEP)
    @Path("vts:Body")
    private Parameters b;

    @Order(elements = {"SellProposals", "Payments"})
    public static class Parameters {

        @Element(name = "SellProposals")
        @Namespace(reference = VtsSoapEnvelope.NAMESPACE_AEP)
        private SellProposalList a;

        @Element(name = "Payments")
        @Namespace(reference = VtsSoapEnvelope.NAMESPACE_AEP)
        private PaymentList b;

        private Parameters() {
        }
    }

    public static class PaymentList {

        @ElementList(entry = "vts:Payment", inline = true)
        private ArrayList<VtsSellContractsPaymentDTO> a;

        private PaymentList(ArrayList<VtsSellContractsPaymentDTO> arrayList) {
            this.a = arrayList;
        }
    }

    public static class SellProposalList {

        @ElementList(entry = "vts:SellProposal", inline = true)
        private ArrayList<VtsSellContractsProposalDTO> a;

        private SellProposalList(ArrayList<VtsSellContractsProposalDTO> arrayList) {
            this.a = arrayList;
        }
    }

    public SellContractsInput(VtsSellProposal vtsSellProposal, VtsPayment vtsPayment, VtsReceiptType vtsReceiptType) {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsSellProposal, vtsError, "Sell proposal cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsPayment, vtsError, "Payment cannot be null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(VtsSellContractsProposalDTO.fromProposal(vtsSellProposal, vtsPayment, vtsReceiptType));
        arrayList2.add(VtsSellContractsPaymentDTO.fromPayment(vtsPayment));
        Parameters parameters = new Parameters();
        this.b = parameters;
        parameters.a = new SellProposalList(arrayList);
        this.b.b = new PaymentList(arrayList2);
    }

    public SellContractsInput(VtsShoppingCart vtsShoppingCart, VtsPayment vtsPayment, VtsReceiptType vtsReceiptType) {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsShoppingCart, vtsError, "Shopping cart cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsPayment, vtsError, "Payment list cannot be null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (VtsShoppingItem vtsShoppingItem : vtsShoppingCart.getShoppingItems()) {
            for (int i = 0; i < vtsShoppingItem.getQuantity(); i++) {
                arrayList.add(VtsSellContractsProposalDTO.fromCartItem(vtsShoppingItem, vtsPayment, vtsReceiptType));
            }
        }
        arrayList2.add(VtsSellContractsPaymentDTO.fromPayment(vtsPayment));
        Parameters parameters = new Parameters();
        this.b = parameters;
        parameters.a = new SellProposalList(arrayList);
        this.b.b = new PaymentList(arrayList2);
    }

    private String a(VtsSellContractsProposalDTO vtsSellContractsProposalDTO) {
        if (vtsSellContractsProposalDTO == null) {
            return null;
        }
        Locale locale = Locale.getDefault();
        long sellProposalID = vtsSellContractsProposalDTO.getSellProposalID();
        int amountEuroCent = vtsSellContractsProposalDTO.getAmountEuroCent();
        int paymentType = vtsSellContractsProposalDTO.getPaymentType();
        return String.format(locale, "ProposalID=%d, Amount=%d, PaymentType=%d, ReceiptType=%s", Long.valueOf(sellProposalID), Integer.valueOf(amountEuroCent), Integer.valueOf(paymentType), vtsSellContractsProposalDTO.getReceiptType());
    }

    private String a(VtsSellContractsPaymentDTO vtsSellContractsPaymentDTO) {
        if (vtsSellContractsPaymentDTO == null) {
            return null;
        }
        return String.format(Locale.getDefault(), "PaymentType=%d, Amount=%d", Integer.valueOf(vtsSellContractsPaymentDTO.getPaymentType()), Integer.valueOf(vtsSellContractsPaymentDTO.getAmountEuroCent()));
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncSellContracts";
    }

    public ArrayList<VtsSellContractsPaymentDTO> getPayments() {
        return this.b.b.a;
    }

    public ArrayList<VtsSellContractsProposalDTO> getSellProposals() {
        return this.b.a.a;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = this.b.a.a.iterator();
        while (it2.hasNext()) {
            arrayList.add(a((VtsSellContractsProposalDTO) it2.next()));
        }
        Iterator it3 = this.b.b.a.iterator();
        while (it3.hasNext()) {
            arrayList2.add(a((VtsSellContractsPaymentDTO) it3.next()));
        }
        return String.format(Locale.ITALY, "SellProposals: [%s], Payments: [%s]", StringUtils.join(arrayList, ", ", true), StringUtils.join(arrayList2, ", ", true));
    }

    public void setPayments(ArrayList<VtsSellContractsPaymentDTO> arrayList) {
        this.b.b = new PaymentList(arrayList);
    }

    public void setSellProposals(ArrayList<VtsSellContractsProposalDTO> arrayList) {
        this.b.a = new SellProposalList(arrayList);
    }

    public static int MediaBrowserCompatMediaBrowserImplApi26() {
        int i = setPlaybackState;
        int i2 = i % 7570354;
        setPlaybackState = i + 1;
        if (i2 != 0) {
            return setPlaybackToRemote;
        }
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        setPlaybackToRemote = iElapsedRealtime;
        return iElapsedRealtime;
    }
}
