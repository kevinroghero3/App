package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public interface HpkeKdf {
    byte[] extractAndExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) throws GeneralSecurityException;

    byte[] getKdfId() throws GeneralSecurityException;

    byte[] labeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) throws GeneralSecurityException;

    byte[] labeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException;
}
