package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.PrefixMap;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.mac.MacKey;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class WrappedChunkedMac {
    private static Bytes getOutputPrefix(Key key) throws GeneralSecurityException {
        if (key instanceof MacKey) {
            return ((MacKey) key).getOutputPrefix();
        }
        if (key instanceof LegacyProtoKey) {
            return ((LegacyProtoKey) key).getOutputPrefix();
        }
        throw new GeneralSecurityException("Cannot get output prefix for key of class " + key.getClass().getName() + " with parameters " + key.getParameters());
    }

    /* JADX INFO: loaded from: classes5.dex */
    static class WrappedChunkedMacVerification implements ChunkedMacVerification {
        private final List<ChunkedMacVerification> verifications;

        private WrappedChunkedMacVerification(List<ChunkedMacVerification> list) {
            this.verifications = list;
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacVerification
        public void update(ByteBuffer byteBuffer) throws GeneralSecurityException {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.mark();
            for (ChunkedMacVerification chunkedMacVerification : this.verifications) {
                byteBufferDuplicate.reset();
                chunkedMacVerification.update(byteBufferDuplicate);
            }
            byteBuffer.position(byteBuffer.limit());
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacVerification
        public void verifyMac() throws GeneralSecurityException {
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("MAC verification failed for all suitable keys in keyset");
            Iterator<ChunkedMacVerification> it2 = this.verifications.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().verifyMac();
                    return;
                } catch (GeneralSecurityException e) {
                    generalSecurityException.addSuppressed(e);
                }
            }
            throw generalSecurityException;
        }
    }

    @Immutable
    static class WrappedChunkedMacImpl implements ChunkedMac {
        private final PrefixMap<ChunkedMac> allChunkedMacs;
        private final ChunkedMac primaryChunkedMac;

        private WrappedChunkedMacImpl(PrefixMap<ChunkedMac> prefixMap, ChunkedMac chunkedMac) {
            this.allChunkedMacs = prefixMap;
            this.primaryChunkedMac = chunkedMac;
        }

        @Override // com.google.crypto.tink.mac.ChunkedMac
        public ChunkedMacComputation createComputation() throws GeneralSecurityException {
            return this.primaryChunkedMac.createComputation();
        }

        @Override // com.google.crypto.tink.mac.ChunkedMac
        public ChunkedMacVerification createVerification(byte[] bArr) throws GeneralSecurityException {
            ArrayList arrayList = new ArrayList();
            Iterator<ChunkedMac> it2 = this.allChunkedMacs.getAllWithMatchingPrefix(bArr).iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().createVerification(bArr));
            }
            return new WrappedChunkedMacVerification(arrayList);
        }
    }

    public static ChunkedMac create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<ChunkedMac> primitiveFactory) throws GeneralSecurityException {
        KeysetHandleInterface.Entry primary = keysetHandleInterface.getPrimary();
        if (primary == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        PrefixMap.Builder builder = new PrefixMap.Builder();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                builder.put(getOutputPrefix(at.getKey()), primitiveFactory.create(at));
            }
        }
        return new WrappedChunkedMacImpl(builder.build(), primitiveFactory.create(primary));
    }

    private WrappedChunkedMac() {
    }
}
