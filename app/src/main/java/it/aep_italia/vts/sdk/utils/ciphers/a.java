package it.aep_italia.vts.sdk.utils.ciphers;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
enum a {
    RSA_ECB_PKCS1Padding(new b() { // from class: it.aep_italia.vts.sdk.utils.ciphers.a$$ExternalSyntheticLambda0
        @Override // it.aep_italia.vts.sdk.utils.ciphers.b
        public final KeyCipher a(Context context) {
            return new c(context);
        }
    }, 1),
    RSA_ECB_OAEPwithSHA_256andMGF1Padding(new b() { // from class: it.aep_italia.vts.sdk.utils.ciphers.a$$ExternalSyntheticLambda1
        @Override // it.aep_italia.vts.sdk.utils.ciphers.b
        public final KeyCipher a(Context context) {
            return new RSACipherOAEPImplementation(context);
        }
    }, 23);

    final b a;
    final int b;

    a(b bVar, int i) {
        this.a = bVar;
        this.b = i;
    }
}
