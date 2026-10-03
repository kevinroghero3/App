package it.aep_italia.vts.sdk.core;

import android.util.Base64;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.hermes.intl.Constants;
import it.aep_italia.vts.sdk.domain.VtsContract;
import it.aep_italia.vts.sdk.domain.VtsDevice;
import it.aep_italia.vts.sdk.domain.VtsNode;
import it.aep_italia.vts.sdk.domain.VtsOperator;
import it.aep_italia.vts.sdk.domain.VtsPspPaymentRedirect;
import it.aep_italia.vts.sdk.domain.VtsRide;
import it.aep_italia.vts.sdk.domain.VtsSellProposal;
import it.aep_italia.vts.sdk.domain.VtsSellableContract;
import it.aep_italia.vts.sdk.domain.VtsServiceMode;
import it.aep_italia.vts.sdk.domain.VtsShoppingCart;
import it.aep_italia.vts.sdk.domain.VtsStop;
import it.aep_italia.vts.sdk.domain.VtsTransaction;
import it.aep_italia.vts.sdk.domain.VtsVToken;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsReceiptType;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenStatus;
import it.aep_italia.vts.sdk.domain.filters.VtsFilter;
import it.aep_italia.vts.sdk.domain.payments.VtsCreditCardPayment;
import it.aep_italia.vts.sdk.domain.payments.VtsPayment;
import it.aep_italia.vts.sdk.dto.domain.VtsContractDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsCreditCardDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsCryptoWalletDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsDeviceDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsNodeDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsRideDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsSellProposalDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsSellableContractDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsServiceModeDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsStopDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsTransactionDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsUserDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenInfoDTO;
import it.aep_italia.vts.sdk.dto.domain.token.payload.VtsVTokenPayloadContractDTO;
import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerInfoDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapReturnCode;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.AssignDeviceToUserId;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.ChangeVTokenStatusInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.CheckVTokenValidationInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.CreditCardsInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GenerateVTokenInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetClientInfoInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetCryptoWallets;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetDeviceInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetInfoCardInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetMoveTokensInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetNodesInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetOperatorsInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetPspPaymentUrlInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetRidesInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetSellProposalInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetSellableContractsInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetSendMailInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetServerInfoInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetServiceModesInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetStopsInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetVTokenInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetVTokenListInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.PutVTokenInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.SellContractsInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.SetClientInfoInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.ShoppingCartInput;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.ValidateVTokenInput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.CheckVTokenValidationOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.CreditCardsOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetClientInfoOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetCryptoWalletsOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetDeviceOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetInfoCardOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetNodesOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetOperatorsOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetPspPaymentUrlOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetRidesOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetSellProposalOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetSellableContractsOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetServerInfoOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetServiceModesOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetStopsOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetVTokenListOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetVTokenOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.SellContractsOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.ShoppingCartOutput;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.ValidateVTokenOutput;
import it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapRequestFunctionResponse;
import it.aep_italia.vts.sdk.dto.utils.VtsContractListDTO;
import it.aep_italia.vts.sdk.dto.utils.VtsUserDataDTO;
import it.aep_italia.vts.sdk.dto.utils.VtsValidationResultDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsVTokenByteParser;
import it.aep_italia.vts.sdk.utils.ListenableFuture;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VtsConnection {
    private VtsSdk a;
    private boolean b;
    private Integer c;
    private b d;

    class a implements Runnable {
        final /* synthetic */ VtsUserDataDTO a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ ListenableFuture c;

        a(VtsUserDataDTO vtsUserDataDTO, byte[] bArr, ListenableFuture listenableFuture) {
            this.a = vtsUserDataDTO;
            this.b = bArr;
            this.c = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VtsConnection.this.a(this.a, this.b);
                this.c.setResultOnUiThread(null);
            } catch (Exception e) {
                this.c.setResultOnUiThread(e);
            }
        }
    }

    VtsConnection(VtsSdk vtsSdk) {
        ValidationUtils.assertNonNull(vtsSdk, VtsError.INVALID_PARAMETER, "No SDK instance provided", new Object[0]);
        this.a = vtsSdk;
        this.d = new b(this);
    }

    private VtsTransaction a(SellContractsInput sellContractsInput) throws VtsException {
        byte[] bArr;
        VtsVToken token;
        Date lastVTokenUpdateAsDate;
        byte[] bArr2;
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        Date date = null;
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(sellContractsInput, (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        VtsTransactionDTO transaction = ((SellContractsOutput) vtsSoapRequestFunctionResponseA.getXmlAs(SellContractsOutput.class)).getTransaction();
        ValidationUtils.assertNonNull(transaction, VtsError.COULD_NOT_BUY_CONTRACT, "Received null response", new Object[0]);
        if (transaction.getTransactionReasonCode() != 0) {
            VtsLog.w("[%s] Transaction ended with reason code %d, results will NOT be saved to wallet.", this.d.f(), Integer.valueOf(transaction.getTransactionReasonCode()));
        } else {
            if (transaction.getContracts() != null && !transaction.getContracts().isEmpty()) {
                VtsVTokenByteParser vtsVTokenByteParser = new VtsVTokenByteParser();
                e eVarD = getSdk().d();
                HashMap map = new HashMap();
                if (StringUtils.isBlank(vtsSoapRequestFunctionResponseA.getDataOutBin())) {
                    bArr = null;
                    token = null;
                } else {
                    byte[] bArrDecode = Base64.decode(vtsSoapRequestFunctionResponseA.getDataOutBin(), 2);
                    bArr = bArrDecode;
                    token = vtsVTokenByteParser.parseToken(bArrDecode);
                }
                for (VtsContractDTO vtsContractDTO : transaction.getContracts()) {
                    ArrayList arrayList = new ArrayList();
                    long jUnsignedHexStringToSignedLong = StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getVTokenUID());
                    if (token == null || token.getUID() != jUnsignedHexStringToSignedLong) {
                        VtsVTokenInfoDTO vtsVTokenInfoDTOA = a(jUnsignedHexStringToSignedLong);
                        byte[] tokenContents = vtsVTokenInfoDTOA.getTokenContents();
                        lastVTokenUpdateAsDate = vtsVTokenInfoDTOA.getLastVTokenUpdateAsDate();
                        bArr2 = tokenContents;
                    } else {
                        lastVTokenUpdateAsDate = date;
                        bArr2 = bArr;
                    }
                    VtsVToken token2 = vtsVTokenByteParser.parseToken(bArr2);
                    byte[] bArr3 = bArr2;
                    Date date2 = lastVTokenUpdateAsDate;
                    VtsVTokenByteParser vtsVTokenByteParser2 = vtsVTokenByteParser;
                    VtsVTokenDTO vtsVTokenDTOA = a(bArr2, token2.getObjectType(), false, true, false, false);
                    Iterator<VtsVTokenPayloadContractDTO> it2 = vtsVTokenDTOA.getPayload().getContracts().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(VtsContract.fromDto(it2.next(), token2.getUID()));
                    }
                    eVarD.l();
                    try {
                        eVarD.a(bArr3, date2);
                        eVarD.a(new VtsContractListDTO((ArrayList<VtsContract>) arrayList), jUnsignedHexStringToSignedLong);
                        if (token2.getObjectType() == VtsObjectType.CALYPSO_SMARTCARD || token2.getObjectType() == VtsObjectType.MIFARE_1K_SMARTCARD || token2.getObjectType() == VtsObjectType.INNOVATRON_CD97_SMARTCARD) {
                            eVarD.a(vtsVTokenDTOA, jUnsignedHexStringToSignedLong);
                        }
                        eVarD.b();
                    } catch (Exception unused) {
                        eVarD.a();
                    }
                    if (!StringUtils.isBlank(vtsContractDTO.getReceiptVTID())) {
                        map.put(Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getReceiptVTID())), Long.valueOf(StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getContractUID())));
                    }
                    vtsVTokenByteParser = vtsVTokenByteParser2;
                    date = null;
                }
                if (!map.isEmpty()) {
                    VtsLog.i("[%s] Transaction includes one or more receipts, downloading asynchronously...", this.d.f());
                    this.a.getReceiptManager().a(map);
                }
                return VtsTransaction.fromDTO(transaction);
            }
            VtsLog.w("[%s] Transaction contains no contracts, aborting.", this.d.f());
        }
        return VtsTransaction.fromDTO(transaction);
    }

    private VtsSoapRequestFunctionResponse a(VtsSoapFunctionPayload vtsSoapFunctionPayload, byte[] bArr) {
        return a(vtsSoapFunctionPayload, bArr, true);
    }

    private VtsSoapRequestFunctionResponse a(VtsSoapFunctionPayload vtsSoapFunctionPayload, byte[] bArr, boolean z) {
        VtsSoapReturnCode vtsSoapReturnCode = VtsSoapReturnCode.NO_ERROR;
        setLastErrorCode(Integer.valueOf(vtsSoapReturnCode.value()));
        ValidationUtils.assertNonNull(vtsSoapFunctionPayload, VtsError.INVALID_PARAMETER, "Request cannot be null", new Object[0]);
        VtsLog.d("[%s] Starting new %s request with parameters [%s]", this.d.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapFunctionPayload.getStringifiedParameters());
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = this.d.a(vtsSoapFunctionPayload, bArr);
        VtsError vtsError = VtsError.REQUEST_FAILED;
        ValidationUtils.assertNonNull(vtsSoapRequestFunctionResponseA, vtsError, "Received a null response", new Object[0]);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        boolean z2 = vtsSoapRequestFunctionResponseA.getReturnCode() == null || vtsSoapRequestFunctionResponseA.getReturnCode().intValue() != vtsSoapReturnCode.value();
        Object[] objArr = {this.d.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getReturnCode(), VtsSoapReturnCode.parse(vtsSoapRequestFunctionResponseA.getReturnCode())};
        if (z2) {
            VtsLog.w("[%s] VTSS function request %s FAILED ReturnCode: %s (%s)", objArr);
            VtsLog.w("[%s] VTSS function request %s ErrorString: %s", this.d.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getErrorString());
            VtsLog.w("[%s] VTSS function request %s DataOutXml: %s", this.d.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getDataOutXml());
        } else {
            VtsLog.i("[%s] VTSS function request %s SUCCESSFUL ReturnCode: %s (%s)", objArr);
            VtsLog.i("[%s] VTSS function request %s DataOutXml: %s", this.d.f(), vtsSoapFunctionPayload.getFunctionName(), vtsSoapRequestFunctionResponseA.getDataOutXml());
        }
        if (!z2 || !z) {
            return vtsSoapRequestFunctionResponseA;
        }
        throw new VtsException(vtsError, "VTSS Function Call FAILED (" + vtsSoapFunctionPayload.getFunctionName() + "). VTSS error code : " + vtsSoapRequestFunctionResponseA.getReturnCode(), new Object[0]);
    }

    VtsPspPaymentRedirect a(String str, VtsCreditCardPayment.CardPaymentMode cardPaymentMode, int i, String str2, String str3) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getPspPaymentUrl", StringUtils.stringifyParams("pspType", str));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetPspPaymentUrlInput(str, cardPaymentMode, i, str2, str3), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetPspPaymentUrlOutput getPspPaymentUrlOutput = (GetPspPaymentUrlOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetPspPaymentUrlOutput.class);
        ValidationUtils.assertNonNull(getPspPaymentUrlOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        return VtsPspPaymentRedirect.fromDto(getPspPaymentUrlOutput.getPspPaymentRedirect());
    }

    VtsShoppingCart a(ShoppingCartInput shoppingCartInput) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#shoppingCart", StringUtils.stringifyParams("Input", shoppingCartInput == null ? null : shoppingCartInput.getStringifiedParameters()));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(shoppingCartInput, (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        ShoppingCartOutput shoppingCartOutput = (ShoppingCartOutput) vtsSoapRequestFunctionResponseA.getXmlAs(ShoppingCartOutput.class);
        ValidationUtils.assertNonNull(shoppingCartOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        return VtsShoppingCart.fromDto(shoppingCartOutput.getShoppingCart());
    }

    VtsVTokenDTO a(byte[] bArr, VtsObjectType vtsObjectType, boolean z, boolean z2, boolean z3, boolean z4) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getInfoCard", StringUtils.stringifyParams("ObjectType", vtsObjectType, "DumpHeader", Boolean.valueOf(z), "DumpPayload", Boolean.valueOf(z2), "DumpValidation", Boolean.valueOf(z3), "CheckSignature", Boolean.valueOf(z4)));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetInfoCardInput(vtsObjectType.value(), z, z2, z3, z4), bArr);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetInfoCardOutput getInfoCardOutput = (GetInfoCardOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetInfoCardOutput.class);
        ValidationUtils.assertNonNull(getInfoCardOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        return getInfoCardOutput.getToken();
    }

    VtsVTokenInfoDTO a(long j) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getVToken", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        GetVTokenInput getVTokenInput = new GetVTokenInput(Long.valueOf(j));
        byte[] bArrDecode = null;
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(getVTokenInput, (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetVTokenOutput getVTokenOutput = (GetVTokenOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetVTokenOutput.class);
        ValidationUtils.assertNonNull(getVTokenOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        if (!StringUtils.isBlank(vtsSoapRequestFunctionResponseA.getDataOutBin())) {
            try {
                bArrDecode = Base64.decode(vtsSoapRequestFunctionResponseA.getDataOutBin(), 2);
            } catch (Exception unused) {
                throw new VtsException(VtsError.REQUEST_FAILED, "Could not decode binary data", new Object[0]);
            }
        }
        VtsVTokenInfoDTO token = getVTokenOutput.getToken();
        token.setTokenContents(bArrDecode);
        return token;
    }

    VtsServerInfoDTO a(boolean z, boolean z2, boolean z3) throws VtsException {
        VtsServerInfoDTO serverInfo;
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getServerInfo", StringUtils.stringifyParams("RequestUserData", Boolean.valueOf(z), "RequestUserPhoto", Boolean.valueOf(z2)));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetServerInfoInput(z, z2, z3), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        if (z || z2 || vtsSoapRequestFunctionResponseA.getDataOutXml() != null) {
            GetServerInfoOutput getServerInfoOutput = (GetServerInfoOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetServerInfoOutput.class);
            ValidationUtils.assertNonNull(getServerInfoOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
            serverInfo = getServerInfoOutput.getServerInfo();
        } else {
            serverInfo = new VtsServerInfoDTO();
            serverInfo.setSdkParameters(new ArrayList());
        }
        if (!StringUtils.isBlank(vtsSoapRequestFunctionResponseA.getDataOutBin())) {
            serverInfo.setUserPhoto(Base64.decode(vtsSoapRequestFunctionResponseA.getDataOutBin(), 2));
        }
        return serverInfo;
    }

    GetOperatorsOutput a(int i) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetOperatorsInput(i), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return (GetOperatorsOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetOperatorsOutput.class);
    }

    List<VtsVTokenInfoDTO> a(long j, GetVTokenListInput.ListType listType, VtsVTokenStatus vtsVTokenStatus) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getVTokenList", StringUtils.stringifyParams("DeviceUID", Long.valueOf(j), "ListType", listType, "VTokenStatus", vtsVTokenStatus));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetVTokenListInput(j, listType, vtsVTokenStatus), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetVTokenListOutput getVTokenListOutput = (GetVTokenListOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetVTokenListOutput.class);
        VtsError vtsError = VtsError.REQUEST_FAILED;
        ValidationUtils.assertNonNull(getVTokenListOutput, vtsError, "Null response", new Object[0]);
        ValidationUtils.assertNonNull(getVTokenListOutput.getTokens(), vtsError, "Null response", new Object[0]);
        return getVTokenListOutput.getTokens();
    }

    List<VtsCreditCardDTO> a(CreditCardsInput creditCardsInput) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#creditCards", StringUtils.stringifyParams("Input", creditCardsInput == null ? null : creditCardsInput.getStringifiedParameters()));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(creditCardsInput, (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        CreditCardsOutput creditCardsOutput = (CreditCardsOutput) vtsSoapRequestFunctionResponseA.getXmlAs(CreditCardsOutput.class);
        ValidationUtils.assertNonNull(creditCardsOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        return creditCardsOutput.getCreditCards();
    }

    void a(long j, VtsVTokenStatus vtsVTokenStatus) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#changeVTokenStatus", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j), "VTokenStatus", vtsVTokenStatus));
        setLastErrorCode(a(new ChangeVTokenStatusInput(j, vtsVTokenStatus), (byte[]) null).getReturnCode());
    }

    void a(VtsVTokenInfoDTO vtsVTokenInfoDTO) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#putVToken", StringUtils.stringifyParams("VToken", vtsVTokenInfoDTO));
        byte[] bArrA = this.a.a(vtsVTokenInfoDTO.getVTokenUIDAsLong());
        setLastErrorCode(a(new PutVTokenInput(vtsVTokenInfoDTO.getVTokenUID(), new VtsVTokenByteParser().parseToken(bArrA).getSignatureCount()), bArrA).getReturnCode());
    }

    void a(VtsUserDataDTO vtsUserDataDTO, byte[] bArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#setClientInfo", StringUtils.stringifyParams("UserData", vtsUserDataDTO, "UserPhoto", bArr));
        int sessionIdleTimeout = this.a.getSdkConfiguration().getSessionIdleTimeout();
        String userLangType = this.a.getSdkConfiguration().getUserLangType();
        String errorMessageLangType = this.a.getSdkConfiguration().getErrorMessageLangType();
        if (vtsUserDataDTO == null) {
            vtsUserDataDTO = new VtsUserDataDTO();
        }
        setLastErrorCode(a(new SetClientInfoInput(sessionIdleTimeout, userLangType, errorMessageLangType, vtsUserDataDTO), bArr).getReturnCode());
    }

    public int assignUserIdToDevice(int i) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#assignDeviceIDtoUserID", StringUtils.stringifyParams(SDKConstants.PARAM_USER_ID, Integer.valueOf(i)));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new AssignDeviceToUserId("assign", i, getSdk().getDeviceUIDHex()), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return vtsSoapRequestFunctionResponseA.getReturnCode().intValue();
    }

    ListenableFuture<Throwable> b(VtsUserDataDTO vtsUserDataDTO, byte[] bArr) throws VtsException {
        ListenableFuture<Throwable> listenableFuture = new ListenableFuture<>();
        new Thread(new a(vtsUserDataDTO, bArr, listenableFuture)).start();
        return listenableFuture;
    }

    public VtsValidationResultDTO checkValidation(long j) throws Exception {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#checkValidation", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        if (!getSdk().hasVToken(j)) {
            throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find requested VToken", new Object[0]);
        }
        byte[] bArrA = this.a.a(j);
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new CheckVTokenValidationInput(StringUtils.toFullHexString(Long.valueOf(j)), new VtsVTokenByteParser().parseToken(bArrA).getSignatureCount()), bArrA);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        CheckVTokenValidationOutput checkVTokenValidationOutput = (CheckVTokenValidationOutput) vtsSoapRequestFunctionResponseA.getXmlAs(CheckVTokenValidationOutput.class);
        ValidationUtils.assertNonNull(checkVTokenValidationOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        if (checkVTokenValidationOutput.getValidationResult() != 0 || StringUtils.isBlank(vtsSoapRequestFunctionResponseA.getDataOutBin())) {
            return checkVTokenValidationOutput.getResult();
        }
        e eVarD = this.a.d();
        try {
            byte[] bArrDecode = Base64.decode(vtsSoapRequestFunctionResponseA.getDataOutBin(), 2);
            eVarD.l();
            eVarD.a(bArrDecode);
            eVarD.b();
            return checkVTokenValidationOutput.getResult();
        } catch (Exception e) {
            eVarD.a();
            throw e;
        }
    }

    public boolean closeConnection() throws VtsException {
        this.a.a("VtsConnection#closeConnection");
        if (isExpired()) {
            return true;
        }
        this.d.b();
        this.b = true;
        return true;
    }

    public VtsUserDTO downloadUserImage() throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getClientInfo", StringUtils.stringifyParams("Email", ""));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetClientInfoInput("", "true"), (byte[]) null);
        GetClientInfoOutput getClientInfoOutput = (GetClientInfoOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetClientInfoOutput.class);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return getClientInfoOutput.getDevices().get(0);
    }

    public boolean generateVToken(long j) {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#generateVToken", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        VtsVToken vTokenByUID = getSdk().getVTokenByUID(j);
        if (vTokenByUID == null) {
            throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find requested VToken", new Object[0]);
        }
        if (!vTokenByUID.requiresGeneration()) {
            return false;
        }
        byte[] bArrA = this.a.a(j);
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GenerateVTokenInput(StringUtils.toFullHexString(Long.valueOf(j)), new VtsVTokenByteParser().parseToken(bArrA).getSignatureCount()), bArrA);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        if (StringUtils.isBlank(vtsSoapRequestFunctionResponseA.getDataOutBin())) {
            throw new VtsException(VtsError.COULD_NOT_GENERATE_VTOKEN, "Empty response", new Object[0]);
        }
        e eVarD = getSdk().d();
        try {
            eVarD.l();
            eVarD.a(Base64.decode(vtsSoapRequestFunctionResponseA.getDataOutBin(), 2));
            eVarD.b();
            return true;
        } catch (Exception unused) {
            eVarD.a();
            return true;
        }
    }

    public List<VtsCryptoWalletDTO> getCryptoWalletsList(String str, String str2) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getCryptoWallets", StringUtils.stringifyParams("WalletType", str, "WalletAddress", str2));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetCryptoWallets(str, str2), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetCryptoWalletsOutput getCryptoWalletsOutput = (GetCryptoWalletsOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetCryptoWalletsOutput.class);
        VtsError vtsError = VtsError.REQUEST_FAILED;
        ValidationUtils.assertNonNull(getCryptoWalletsOutput, vtsError, "Null response", new Object[0]);
        ValidationUtils.assertNonNull(getCryptoWalletsOutput.getCryptoWallets(), vtsError, "Null response", new Object[0]);
        return getCryptoWalletsOutput.getCryptoWallets().getCryptoWallet();
    }

    public List<VtsDevice> getDevices(VtsFilter... vtsFilterArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getDevices", StringUtils.stringifyParams("Filters", vtsFilterArr));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetDeviceInput(vtsFilterArr), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetDeviceOutput getDeviceOutput = (GetDeviceOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetDeviceOutput.class);
        if (getDeviceOutput == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsDeviceDTO> it2 = getDeviceOutput.getDevices().iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsDevice.fromDto(it2.next()));
        }
        return arrayList;
    }

    public Integer getLastErrorCode() {
        return this.c;
    }

    public List<VtsNode> getNodes(VtsFilter... vtsFilterArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getNodes", StringUtils.stringifyParams("Filters", vtsFilterArr));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetNodesInput(vtsFilterArr), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetNodesOutput getNodesOutput = (GetNodesOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetNodesOutput.class);
        VtsError vtsError = VtsError.REQUEST_FAILED;
        ValidationUtils.assertNonNull(getNodesOutput, vtsError, "Null response", new Object[0]);
        ValidationUtils.assertNonNull(getNodesOutput.getNodes(), vtsError, "Null response", new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator<VtsNodeDTO> it2 = getNodesOutput.getNodes().iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsNode.fromDto(it2.next()));
        }
        return arrayList;
    }

    public List<VtsOperator> getOperatorList() throws VtsException {
        this.a.a("VtsConnection#getOperatorList");
        return getOperatorList(0);
    }

    public List<VtsOperator> getOperatorList(int i) throws VtsException {
        this.a.a("VtsConnection#getOperatorList", StringUtils.stringifyParams("OperatorID", Integer.valueOf(i)));
        if (this.b) {
            throw new VtsException(VtsError.CONNECTION_IS_CLOSED, "Connection is closed.", new Object[0]);
        }
        GetOperatorsOutput getOperatorsOutputA = a(i);
        return getOperatorsOutputA == null ? new ArrayList() : getOperatorsOutputA.buildOperators();
    }

    public List<VtsRide> getRides(VtsFilter... vtsFilterArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getRides", StringUtils.stringifyParams("Filters", vtsFilterArr));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetRidesInput(vtsFilterArr), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetRidesOutput getRidesOutput = (GetRidesOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetRidesOutput.class);
        ValidationUtils.assertNonNull(getRidesOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator<VtsRideDTO> it2 = getRidesOutput.getRides().iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsRide.fromDto(it2.next()));
        }
        return arrayList;
    }

    public VtsSdk getSdk() {
        return this.a;
    }

    public List<VtsSellProposal> getSellProposals(Long l, VtsSellableContract vtsSellableContract) throws VtsException {
        this.a.a("VtsConnection#getSellProposals", StringUtils.stringifyParams("SmartcardUID", l, "SellableContract", vtsSellableContract));
        return getSellProposals(l, vtsSellableContract, null, null);
    }

    public List<VtsSellProposal> getSellProposals(Long l, VtsSellableContract vtsSellableContract, VtsNode vtsNode, VtsNode vtsNode2) {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getSellProposals", StringUtils.stringifyParams("SmartcardUID", l, "SellableContract", vtsSellableContract, "OriginNode", vtsNode, "DestinationNode", vtsNode2));
        ValidationUtils.assertNonNull(vtsSellableContract, VtsError.INVALID_PARAMETER, "Sellable contract cannot be null", new Object[0]);
        GetSellProposalInput getSellProposalInput = new GetSellProposalInput(vtsSellableContract.getProviderID(), vtsSellableContract.getTariffID(), vtsNode, vtsNode2);
        byte[] bArrA = (l == null || l.longValue() == 0) ? null : this.a.a(l.longValue());
        if (bArrA != null && a(l.longValue()).getVTokenStatus().intValue() == VtsVTokenStatus.UNDEMATERIALIZE_PENDING.value()) {
            VtsLog.d("Local vTokes has UNDEMATERIALIZE_PENDING status return empty list ...", new Object[0]);
            return new ArrayList();
        }
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(getSellProposalInput, bArrA);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetSellProposalOutput getSellProposalOutput = (GetSellProposalOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetSellProposalOutput.class);
        if (getSellProposalOutput == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsSellableContractDTO> it2 = getSellProposalOutput.getSellableContracts().iterator();
        while (it2.hasNext()) {
            Iterator<VtsSellProposalDTO> it3 = it2.next().getSellProposals().iterator();
            while (it3.hasNext()) {
                VtsSellProposal vtsSellProposalFromDto = VtsSellProposal.fromDto(vtsSellableContract, it3.next());
                if (vtsNode != null && vtsNode2 != null) {
                    vtsSellProposalFromDto.setOriginNodeID(Integer.valueOf(vtsNode.getID()));
                    vtsSellProposalFromDto.setDestinationNodeID(Integer.valueOf(vtsNode2.getID()));
                }
                arrayList.add(vtsSellProposalFromDto);
            }
        }
        return arrayList;
    }

    public List<VtsSellProposal> getSellProposals(Long l, VtsSellableContract vtsSellableContract, VtsNode vtsNode, VtsNode vtsNode2, List<String> list, int i) {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getSellProposals", StringUtils.stringifyParams("SmartcardUID", l, "SellableContract", vtsSellableContract, "OriginNode", vtsNode, "DestinationNode", vtsNode2, "ContainsNodes", list, "PassengerClass", Integer.valueOf(i)));
        ValidationUtils.assertNonNull(vtsSellableContract, VtsError.INVALID_PARAMETER, "Sellable contract cannot be null", new Object[0]);
        GetSellProposalInput getSellProposalInput = new GetSellProposalInput(vtsSellableContract.getProviderID(), vtsSellableContract.getTariffID(), vtsNode, vtsNode2, list, i);
        byte[] bArrA = (l == null || l.longValue() == 0) ? null : this.a.a(l.longValue());
        if (bArrA != null && a(l.longValue()).getVTokenStatus().intValue() == VtsVTokenStatus.UNDEMATERIALIZE_PENDING.value()) {
            VtsLog.d("Local vTokes has UNDEMATERIALIZE_PENDING status return empty list ...", new Object[0]);
            return new ArrayList();
        }
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(getSellProposalInput, bArrA);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetSellProposalOutput getSellProposalOutput = (GetSellProposalOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetSellProposalOutput.class);
        if (getSellProposalOutput == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsSellableContractDTO> it2 = getSellProposalOutput.getSellableContracts().iterator();
        while (it2.hasNext()) {
            Iterator<VtsSellProposalDTO> it3 = it2.next().getSellProposals().iterator();
            while (it3.hasNext()) {
                VtsSellProposal vtsSellProposalFromDto = VtsSellProposal.fromDto(vtsSellableContract, it3.next());
                if (vtsNode != null && vtsNode2 != null) {
                    vtsSellProposalFromDto.setOriginNodeID(Integer.valueOf(vtsNode.getID()));
                    vtsSellProposalFromDto.setDestinationNodeID(Integer.valueOf(vtsNode2.getID()));
                }
                arrayList.add(vtsSellProposalFromDto);
            }
        }
        return arrayList;
    }

    public List<VtsSellableContract> getSellableContracts(Long l) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getSellableContracts", StringUtils.stringifyParams("SmartcardUID", l));
        GetSellableContractsInput getSellableContractsInput = new GetSellableContractsInput();
        byte[] bArrA = (l == null || l.longValue() == 0) ? null : this.a.a(l.longValue());
        if (bArrA != null && a(l.longValue()).getVTokenStatus().intValue() == VtsVTokenStatus.UNDEMATERIALIZE_PENDING.value()) {
            VtsLog.d("Local vTokes has UNDEMATERIALIZE_PENDING status return empty list ...", new Object[0]);
            return new ArrayList();
        }
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(getSellableContractsInput, bArrA);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetSellableContractsOutput getSellableContractsOutput = (GetSellableContractsOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetSellableContractsOutput.class);
        if (getSellableContractsOutput == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsSellableContractDTO> it2 = getSellableContractsOutput.getSellableContracts().iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsSellableContract.fromDto(it2.next()));
        }
        return arrayList;
    }

    public List<VtsSellableContract> getSellableContracts(Long l, VtsFilter... vtsFilterArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getSellableContracts", StringUtils.stringifyParams("SmartcardUID", l));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetSellableContractsInput(vtsFilterArr), (l == null || l.longValue() == 0) ? null : this.a.a(l.longValue()));
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetSellableContractsOutput getSellableContractsOutput = (GetSellableContractsOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetSellableContractsOutput.class);
        if (getSellableContractsOutput == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsSellableContractDTO> it2 = getSellableContractsOutput.getSellableContracts().iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsSellableContract.fromDto(it2.next()));
        }
        return arrayList;
    }

    public List<VtsServiceMode> getServiceModes(VtsFilter... vtsFilterArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getServiceModes", StringUtils.stringifyParams("Filters", vtsFilterArr));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetServiceModesInput(vtsFilterArr), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetServiceModesOutput getServiceModesOutput = (GetServiceModesOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetServiceModesOutput.class);
        ValidationUtils.assertNonNull(getServiceModesOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator<VtsServiceModeDTO> it2 = getServiceModesOutput.getModes().iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsServiceMode.fromDto(it2.next()));
        }
        return arrayList;
    }

    public String getSessionToken() {
        if (isClosed()) {
            return null;
        }
        return this.d.e();
    }

    public List<VtsStop> getStops(VtsFilter... vtsFilterArr) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getStops", StringUtils.stringifyParams("Filters", vtsFilterArr));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetStopsInput(vtsFilterArr), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        GetStopsOutput getStopsOutput = (GetStopsOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetStopsOutput.class);
        ValidationUtils.assertNonNull(getStopsOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator<VtsStopDTO> it2 = getStopsOutput.getStops().iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsStop.fromDto(it2.next()));
        }
        return arrayList;
    }

    public VtsUserDTO getUserImageInfo() throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getClientInfo", StringUtils.stringifyParams("Email", ""));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetClientInfoInput("", Constants.CASEFIRST_FALSE), (byte[]) null);
        GetClientInfoOutput getClientInfoOutput = (GetClientInfoOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetClientInfoOutput.class);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return getClientInfoOutput.getDevices().get(0);
    }

    public List<VtsUserDTO> getUserInfoByEmail(String str) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getClientInfo", StringUtils.stringifyParams("Email", str));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetClientInfoInput(str, Constants.CASEFIRST_FALSE), (byte[]) null);
        GetClientInfoOutput getClientInfoOutput = (GetClientInfoOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetClientInfoOutput.class);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return getClientInfoOutput.getDevices();
    }

    public List<VtsUserDTO> getUserInfoById(int i) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#getClientInfo", StringUtils.stringifyParams("UserID", Integer.valueOf(i)));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetClientInfoInput(i), (byte[]) null);
        GetClientInfoOutput getClientInfoOutput = (GetClientInfoOutput) vtsSoapRequestFunctionResponseA.getXmlAs(GetClientInfoOutput.class);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        VtsUserDTO vtsUserDTO = getClientInfoOutput.getDevices().get(0);
        VtsUserDataDTO vtsUserDataDTO = new VtsUserDataDTO();
        vtsUserDataDTO.setUserId(String.valueOf(vtsUserDTO.getUserId()));
        vtsUserDataDTO.setEmail(vtsUserDTO.getEmail());
        vtsUserDataDTO.setUserPassword(vtsUserDTO.getUserPassword());
        this.a.setUserData(vtsUserDataDTO, true);
        return getClientInfoOutput.getDevices();
    }

    public String getVersion() {
        return "1.0";
    }

    public boolean isClosed() {
        return this.b;
    }

    public boolean isExpired() {
        return isClosed() || this.d.i();
    }

    public int moveTokens(long j) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#moveTokens", StringUtils.stringifyParams("sourceDeviceUID", Long.valueOf(j)));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetMoveTokensInput(j, getSdk().getDeviceUID()), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return vtsSoapRequestFunctionResponseA.getReturnCode().intValue();
    }

    public void refreshVToken(long j) throws Exception {
        VtsVToken vTokenByUID = getSdk().getVTokenByUID(j);
        byte[] bArrA = getSdk().a(j);
        boolean z = vTokenByUID.getObjectType() == VtsObjectType.CALYPSO_SMARTCARD || vTokenByUID.getObjectType() == VtsObjectType.MIFARE_1K_SMARTCARD || vTokenByUID.getObjectType() == VtsObjectType.INNOVATRON_CD97_SMARTCARD;
        VtsLog.d("Downloading contract(s) of VToken %s...", StringUtils.toFullHexString(Long.valueOf(j)));
        VtsVTokenDTO vtsVTokenDTOA = a(bArrA, vTokenByUID.getObjectType(), false, true, true, false);
        if (vtsVTokenDTOA == null || vtsVTokenDTOA.getPayload() == null) {
            throw new VtsException(VtsError.SYNCHRONIZATION_FAILED, "Null contract list", new Object[0]);
        }
        VtsVTokenDTO vtsVTokenDTO = z ? vtsVTokenDTOA : null;
        ArrayList<VtsVTokenPayloadContractDTO> contracts = vtsVTokenDTOA.getPayload().getContracts();
        if (!z && contracts.isEmpty()) {
            throw new VtsException(VtsError.SYNCHRONIZATION_FAILED, "No contracts found", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsVTokenPayloadContractDTO> it2 = contracts.iterator();
        while (it2.hasNext()) {
            arrayList.add(VtsContract.fromDto(it2.next(), j));
        }
        VtsContractListDTO vtsContractListDTO = new VtsContractListDTO((ArrayList<VtsContract>) arrayList);
        e eVarD = this.a.d();
        try {
            eVarD.l();
            eVarD.a(vtsContractListDTO, j);
            if (vtsVTokenDTO != null) {
                eVarD.a(vtsVTokenDTO, j);
            }
            eVarD.b();
        } catch (Exception e) {
            eVarD.a();
            throw e;
        }
    }

    public VtsTransaction sellContract(VtsSellProposal vtsSellProposal, VtsReceiptType vtsReceiptType, VtsPayment vtsPayment) throws VtsException {
        this.a.a("VtsConnection#sellContract", StringUtils.stringifyParams("SellProposal", vtsSellProposal, "ReceiptType", vtsReceiptType, "Payment", vtsPayment));
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsSellProposal, vtsError, "Sell proposal cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsPayment, vtsError, "Payment cannot be null", new Object[0]);
        return a(new SellContractsInput(vtsSellProposal, vtsPayment, vtsReceiptType));
    }

    public VtsTransaction sellContracts(VtsShoppingCart vtsShoppingCart, VtsReceiptType vtsReceiptType, VtsPayment vtsPayment) throws VtsException {
        this.a.a("VtsConnection#sellContracts", StringUtils.stringifyParams("ShoppingCart", vtsShoppingCart, "ReceiptType", vtsReceiptType, "Payment", vtsPayment));
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsShoppingCart, vtsError, "Shopping cart cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsPayment, vtsError, "Payment cannot be null", new Object[0]);
        return a(new SellContractsInput(vtsShoppingCart, vtsPayment, vtsReceiptType));
    }

    public void setLastErrorCode(Integer num) {
        if (num == null) {
            num = Integer.valueOf(VtsSoapReturnCode.INTERNAL_SERVER_ERROR.value());
        }
        this.c = num;
    }

    public VtsValidationResultDTO validateToken(long j, VtsFilter... vtsFilterArr) throws Exception {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#validateToken", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j), "Filters", vtsFilterArr));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new ValidateVTokenInput(vtsFilterArr), this.a.a(j));
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        ValidateVTokenOutput validateVTokenOutput = (ValidateVTokenOutput) vtsSoapRequestFunctionResponseA.getXmlAs(ValidateVTokenOutput.class);
        ValidationUtils.assertNonNull(validateVTokenOutput, VtsError.REQUEST_FAILED, "Null response", new Object[0]);
        if (validateVTokenOutput.getValidationResult() != 0 || StringUtils.isBlank(vtsSoapRequestFunctionResponseA.getDataOutBin())) {
            return validateVTokenOutput.getResult();
        }
        e eVarD = this.a.d();
        try {
            byte[] bArrDecode = Base64.decode(vtsSoapRequestFunctionResponseA.getDataOutBin(), 2);
            eVarD.l();
            eVarD.a(bArrDecode);
            eVarD.b();
            try {
                VtsVToken token = new VtsVTokenByteParser().parseToken(bArrDecode);
                if (token.getObjectType() == VtsObjectType.CALYPSO_SMARTCARD || token.getObjectType() == VtsObjectType.MIFARE_1K_SMARTCARD || token.getObjectType() == VtsObjectType.INNOVATRON_CD97_SMARTCARD) {
                    VtsVTokenDTO vtsVTokenDTOA = a(bArrDecode, token.getObjectType(), false, true, true, false);
                    eVarD.l();
                    eVarD.a(vtsVTokenDTOA, token.getUID());
                    eVarD.b();
                }
            } catch (Exception e) {
                eVarD.a();
                VtsLog.e(e, "[%s] Could not update VToken information", this.d.f());
            }
            return validateVTokenOutput.getResult();
        } catch (Exception e2) {
            eVarD.a();
            throw e2;
        }
    }

    public int vtsSendMail(String str, String str2, String str3) throws VtsException {
        setLastErrorCode(Integer.valueOf(VtsSoapReturnCode.NO_ERROR.value()));
        this.a.a("VtsConnection#vtsSendMail", StringUtils.stringifyParams("to", str));
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponseA = a(new GetSendMailInput(str, str2, str3), (byte[]) null);
        setLastErrorCode(vtsSoapRequestFunctionResponseA.getReturnCode());
        return vtsSoapRequestFunctionResponseA.getReturnCode().intValue();
    }
}
