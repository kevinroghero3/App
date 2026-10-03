package it.aep_italia.vts.sdk.utils.ciphers;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
enum d {
    AES_CBC_PKCS7Padding(new e() { // from class: it.aep_italia.vts.sdk.utils.ciphers.d$$ExternalSyntheticLambda0
        @Override // it.aep_italia.vts.sdk.utils.ciphers.e
        public final StorageCipher a(Context context, KeyCipher keyCipher) {
            return new StorageCipher18Implementation(context, keyCipher);
        }
    }, 1),
    AES_GCM_NoPadding(new e() { // from class: it.aep_italia.vts.sdk.utils.ciphers.d$$ExternalSyntheticLambda1
        @Override // it.aep_italia.vts.sdk.utils.ciphers.e
        public final StorageCipher a(Context context, KeyCipher keyCipher) {
            return new StorageCipherGCMImplementation(context, keyCipher);
        }
    }, 23);

    final e a;
    final int b;

    d(e eVar, int i) {
        this.a = eVar;
        this.b = i;
    }
}
