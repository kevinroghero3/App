package it.aep_italia.vts.sdk.dto.domain;

import java.io.Serializable;
import java.util.List;
import org.simpleframework.xml.ElementList;

/* JADX INFO: loaded from: classes6.dex */
public class VtsCryptoWalletsDTO implements Serializable {
    private static final long serialVersionUID = 7949547935705423375L;

    @ElementList(entry = "CryptoWallet", name = "CryptoWallets", required = false)
    private List<VtsCryptoWalletDTO> cryptoWallet;

    public List<VtsCryptoWalletDTO> getCryptoWallet() {
        return this.cryptoWallet;
    }

    public void setCryptoWallet(List<VtsCryptoWalletDTO> list) {
        this.cryptoWallet = list;
    }
}
