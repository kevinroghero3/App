package it.aep_italia.vts.sdk.dto.domain;

import java.io.Serializable;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsCryptoWalletDTO implements Serializable {

    @Attribute(name = "Address")
    private String address;

    @Attribute(name = "BalanceCrypto")
    private String balanceCrypto;

    @Attribute(name = "BalanceLocalCurrency")
    private String balanceLocalCurrency;

    @Attribute(name = "BalanceLocalCurrencyCents")
    private String balanceLocalCurrencyCents;

    @Attribute(name = "CurrencyCrypto")
    private String currencyCrypto;

    @Attribute(name = "Description")
    private String description;

    @Attribute(name = "DeviceUid")
    private String deviceUid;

    @Attribute(name = "LastUpdateDateTime")
    private String lastUpdateDateTime;

    @Attribute(name = "LocalCurrency")
    private String localCurrency;

    @Attribute(name = "MinBalanceCrypto")
    private String minBalanceCrypto;

    @Attribute(name = "WalletType")
    private String walletType;

    public String getAddress() {
        return this.address;
    }

    public String getBalanceCrypto() {
        return this.balanceCrypto;
    }

    public String getBalanceLocalCurrency() {
        return this.balanceLocalCurrency;
    }

    public String getBalanceLocalCurrencyCents() {
        return this.balanceLocalCurrencyCents;
    }

    public String getCurrencyCrypto() {
        return this.currencyCrypto;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceUid() {
        return this.deviceUid;
    }

    public String getLastUpdateDateTime() {
        return this.lastUpdateDateTime;
    }

    public String getLocalCurrency() {
        return this.localCurrency;
    }

    public String getMinBalanceCrypto() {
        return this.minBalanceCrypto;
    }

    public String getWalletType() {
        return this.walletType;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBalanceCrypto(String str) {
        this.balanceCrypto = str;
    }

    public void setBalanceLocalCurrency(String str) {
        this.balanceLocalCurrency = str;
    }

    public void setBalanceLocalCurrencyCents(String str) {
        this.balanceLocalCurrencyCents = str;
    }

    public void setCurrencyCrypto(String str) {
        this.currencyCrypto = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDeviceUid(String str) {
        this.deviceUid = str;
    }

    public void setLastUpdateDateTime(String str) {
        this.lastUpdateDateTime = str;
    }

    public void setLocalCurrency(String str) {
        this.localCurrency = str;
    }

    public void setMinBalanceCrypto(String str) {
        this.minBalanceCrypto = str;
    }

    public void setWalletType(String str) {
        this.walletType = str;
    }
}
