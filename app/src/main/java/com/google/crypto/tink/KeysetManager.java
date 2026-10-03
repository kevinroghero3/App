package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyStatusTypeProtoConverter;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class KeysetManager {
    private final Keyset.Builder keysetBuilder;

    private KeysetManager(Keyset.Builder builder) {
        this.keysetBuilder = builder;
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        return new KeysetManager(keysetHandle.getKeyset().toBuilder());
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        KeysetHandle keysetHandleFromKeyset;
        synchronized (this) {
            keysetHandleFromKeyset = KeysetHandle.fromKeyset(this.keysetBuilder.build());
        }
        return keysetHandleFromKeyset;
    }

    public KeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            addNewKey(keyTemplate, true);
        }
        return this;
    }

    public KeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            addNewKey(keyTemplate, false);
        }
        return this;
    }

    public KeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            addNewKey(keyTemplate.getProtoMaybeThrow(), false);
        }
        return this;
    }

    @Deprecated
    public KeysetManager add(KeyHandle keyHandle) throws GeneralSecurityException {
        synchronized (this) {
            try {
                try {
                    ProtoKey protoKey = (ProtoKey) keyHandle.getKey(com.google.crypto.tink.tinkkey.SecretKeyAccess.insecureSecretAccess());
                    if (keyIdExists(keyHandle.getId())) {
                        throw new GeneralSecurityException("Trying to add a key with an ID already contained in the keyset.");
                    }
                    this.keysetBuilder.addKey(Keyset.Key.newBuilder().setKeyData(protoKey.getProtoKey()).setKeyId(keyHandle.getId()).setStatus(KeyStatusTypeProtoConverter.toProto(keyHandle.getStatus())).setOutputPrefixType(KeyTemplate.toProto(protoKey.getOutputPrefixType())).build());
                } catch (ClassCastException e) {
                    throw new UnsupportedOperationException("KeyHandles which contain TinkKeys that are not ProtoKeys are not yet supported.", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    @Deprecated
    public KeysetManager add(KeyHandle keyHandle, KeyAccess keyAccess) throws GeneralSecurityException {
        KeysetManager keysetManagerAdd;
        synchronized (this) {
            keysetManagerAdd = add(keyHandle);
        }
        return keysetManagerAdd;
    }

    public int addNewKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, boolean z) throws GeneralSecurityException {
        int keyId;
        synchronized (this) {
            Keyset.Key keyNewKey = newKey(keyTemplate);
            this.keysetBuilder.addKey(keyNewKey);
            if (z) {
                this.keysetBuilder.setPrimaryKeyId(keyNewKey.getKeyId());
            }
            keyId = keyNewKey.getKeyId();
        }
        return keyId;
    }

    public KeysetManager setPrimary(int i) throws GeneralSecurityException {
        synchronized (this) {
            for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
                Keyset.Key key = this.keysetBuilder.getKey(i2);
                if (key.getKeyId() == i) {
                    if (!key.getStatus().equals(KeyStatusType.ENABLED)) {
                        throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                    }
                    this.keysetBuilder.setPrimaryKeyId(i);
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        }
        return this;
    }

    public KeysetManager promote(int i) throws GeneralSecurityException {
        KeysetManager primary;
        synchronized (this) {
            primary = setPrimary(i);
        }
        return primary;
    }

    public KeysetManager enable(int i) throws GeneralSecurityException {
        synchronized (this) {
            for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
                Keyset.Key key = this.keysetBuilder.getKey(i2);
                if (key.getKeyId() == i) {
                    KeyStatusType status = key.getStatus();
                    KeyStatusType keyStatusType = KeyStatusType.ENABLED;
                    if (status != keyStatusType && key.getStatus() != KeyStatusType.DISABLED) {
                        throw new GeneralSecurityException("cannot enable key with id " + i);
                    }
                    this.keysetBuilder.setKey(i2, key.toBuilder().setStatus(keyStatusType).build());
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        }
        return this;
    }

    public KeysetManager disable(int i) throws GeneralSecurityException {
        synchronized (this) {
            if (i == this.keysetBuilder.getPrimaryKeyId()) {
                throw new GeneralSecurityException("cannot disable the primary key");
            }
            for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
                Keyset.Key key = this.keysetBuilder.getKey(i2);
                if (key.getKeyId() == i) {
                    if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED) {
                        throw new GeneralSecurityException("cannot disable key with id " + i);
                    }
                    this.keysetBuilder.setKey(i2, key.toBuilder().setStatus(KeyStatusType.DISABLED).build());
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        }
        return this;
    }

    public KeysetManager delete(int i) throws GeneralSecurityException {
        synchronized (this) {
            if (i == this.keysetBuilder.getPrimaryKeyId()) {
                throw new GeneralSecurityException("cannot delete the primary key");
            }
            for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
                if (this.keysetBuilder.getKey(i2).getKeyId() == i) {
                    this.keysetBuilder.removeKey(i2);
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        }
        return this;
    }

    public KeysetManager destroy(int i) throws GeneralSecurityException {
        synchronized (this) {
            if (i == this.keysetBuilder.getPrimaryKeyId()) {
                throw new GeneralSecurityException("cannot destroy the primary key");
            }
            for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
                Keyset.Key key = this.keysetBuilder.getKey(i2);
                if (key.getKeyId() == i) {
                    if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED && key.getStatus() != KeyStatusType.DESTROYED) {
                        throw new GeneralSecurityException("cannot destroy key with id " + i);
                    }
                    this.keysetBuilder.setKey(i2, key.toBuilder().setStatus(KeyStatusType.DESTROYED).clearKeyData().build());
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        }
        return this;
    }

    private Keyset.Key newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        Keyset.Key keyCreateKeysetKey;
        synchronized (this) {
            keyCreateKeysetKey = createKeysetKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType());
        }
        return keyCreateKeysetKey;
    }

    private Keyset.Key createKeysetKey(KeyData keyData, OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        Keyset.Key keyBuild;
        synchronized (this) {
            int iNewKeyId = newKeyId();
            if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            keyBuild = Keyset.Key.newBuilder().setKeyData(keyData).setKeyId(iNewKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();
        }
        return keyBuild;
    }

    private boolean keyIdExists(int i) {
        synchronized (this) {
            Iterator<Keyset.Key> it2 = this.keysetBuilder.getKeyList().iterator();
            while (it2.hasNext()) {
                if (it2.next().getKeyId() == i) {
                    return true;
                }
            }
            return false;
        }
    }

    private int newKeyId() {
        int iRandKeyId;
        synchronized (this) {
            iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
            while (keyIdExists(iRandKeyId)) {
                iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
            }
        }
        return iRandKeyId;
    }
}
