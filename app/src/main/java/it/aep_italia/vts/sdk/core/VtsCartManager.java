package it.aep_italia.vts.sdk.core;

import it.aep_italia.vts.sdk.domain.VtsSellProposal;
import it.aep_italia.vts.sdk.domain.VtsShoppingCart;
import it.aep_italia.vts.sdk.domain.VtsShoppingItem;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.ShoppingCartInput;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsCartManager {
    private VtsSdk a;
    private VtsShoppingCart b;

    VtsCartManager(VtsSdk vtsSdk) {
        this.a = vtsSdk;
    }

    private VtsShoppingCart a(ShoppingCartInput shoppingCartInput) throws VtsException {
        VtsShoppingCart vtsShoppingCartA = this.a.openConnection().a(shoppingCartInput);
        this.b = vtsShoppingCartA;
        return vtsShoppingCartA;
    }

    private void a() {
        a(false);
    }

    private void a(boolean z) {
        if (z || this.b == null) {
            a(this.a.openConnection());
        }
    }

    void a(VtsConnection vtsConnection) {
        try {
            VtsLog.d("(Re-)Initializing shopping cart manager...", new Object[0]);
            VtsShoppingCart vtsShoppingCartA = vtsConnection.a(ShoppingCartInput.forContentOperation());
            this.b = vtsShoppingCartA;
            VtsLog.d("Shopping cart successfully downloaded, %d item(s) found.", Integer.valueOf(vtsShoppingCartA.getCount()));
        } catch (Exception e) {
            VtsLog.e(e, "Could not initialize shopping cart manager", new Object[0]);
            throw new VtsException(VtsError.COULD_NOT_INITIALIZE_CART, e);
        }
    }

    public VtsShoppingCart addItem(VtsSellProposal vtsSellProposal, int i) throws VtsException {
        this.a.a("VtsCartManager#addItem", StringUtils.stringifyParams("SellProposal", vtsSellProposal, "Quantity", Integer.valueOf(i)));
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsSellProposal, vtsError, "Sell proposal cannot be null", new Object[0]);
        ValidationUtils.assertTrue(i > 0, vtsError, "Quantity must be positive", new Object[0]);
        a();
        VtsShoppingItem itemForProposal = this.b.getItemForProposal(vtsSellProposal);
        if (itemForProposal == null) {
            return a(ShoppingCartInput.forAddOperation(vtsSellProposal.getProposalID(), i, vtsSellProposal.getContractDescription(), vtsSellProposal.getContractTypeDescription(), vtsSellProposal.getContractDurationDescription()));
        }
        changeItem(itemForProposal, itemForProposal.getQuantity() + i);
        return this.b;
    }

    public VtsShoppingCart changeItem(VtsSellProposal vtsSellProposal, int i) throws VtsException {
        this.a.a("VtsCartManager#changeItem", StringUtils.stringifyParams("SellProposal", vtsSellProposal, "Quantity", Integer.valueOf(i)));
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsSellProposal, vtsError, "Sell proposal cannot be null", new Object[0]);
        ValidationUtils.assertTrue(i > 0, vtsError, "Quantity must be positive", new Object[0]);
        a();
        return changeItem(this.b.getItemForProposal(vtsSellProposal), i);
    }

    public VtsShoppingCart changeItem(VtsShoppingItem vtsShoppingItem, int i) throws VtsException {
        this.a.a("VtsCartManager#changeItem", StringUtils.stringifyParams("ShoppingItem", vtsShoppingItem, "Quantity", Integer.valueOf(i)));
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsShoppingItem, vtsError, "Shopping item cannot be null", new Object[0]);
        ValidationUtils.assertTrue(i > 0, vtsError, "Quantity must be positive", new Object[0]);
        ValidationUtils.assertTrue(this.b.containsItem(vtsShoppingItem), vtsError, "Shopping cart does not contain the given item", new Object[0]);
        a();
        return a(ShoppingCartInput.forModifyOperation(vtsShoppingItem.getSellProposalID(), i, vtsShoppingItem.getDescription(), vtsShoppingItem.getSubDescription1(), vtsShoppingItem.getSubDescription2()));
    }

    public VtsShoppingCart clearCart() throws VtsException {
        this.a.a("VtsCartManager#clearCart");
        VtsLog.d("Emptying shopping cart...", new Object[0]);
        return a(ShoppingCartInput.forEmptyOperation());
    }

    public VtsShoppingCart getCart() throws VtsException {
        return getCart(false);
    }

    public VtsShoppingCart getCart(boolean z) throws VtsException {
        this.a.a("VtsCartManager#getCart");
        a(z);
        return this.b;
    }

    public VtsShoppingCart removeItem(VtsSellProposal vtsSellProposal) throws VtsException {
        this.a.a("VtsCartManager#removeItem", StringUtils.stringifyParams("SellProposal", vtsSellProposal));
        ValidationUtils.assertNonNull(vtsSellProposal, VtsError.INVALID_PARAMETER, "Sell proposal cannot be null", new Object[0]);
        a();
        return removeItem(this.b.getItemForProposal(vtsSellProposal));
    }

    public VtsShoppingCart removeItem(VtsShoppingItem vtsShoppingItem) throws VtsException {
        this.a.a("VtsCartManager#removeItem", StringUtils.stringifyParams("ShoppingItem", vtsShoppingItem));
        ValidationUtils.assertNonNull(vtsShoppingItem, VtsError.INVALID_PARAMETER, "Shopping item cannot be null", new Object[0]);
        a();
        return a(ShoppingCartInput.forRemoveOperation(vtsShoppingItem.getSellProposalID()));
    }
}
