package com.google.crypto.tink;

import com.google.crypto.tink.config.GlobalTinkFlags;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.InternalKeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class KeysetHandle implements KeysetHandleInterface {
    private final Map<Class<?>, Annotations> annotationsMap;
    private final List<Entry> entries;

    @Nullable
    private final KeysetHandle unmonitoredHandle;

    /* synthetic */ KeysetHandle(List list, Map map, AnonymousClass1 anonymousClass1) throws GeneralSecurityException {
        this(list, map);
    }

    public static final class Builder {
        private final List<Entry> entries = new ArrayList();

        @Nullable
        private GeneralSecurityException errorToThrow = null;
        private final Map<Class<?>, Annotations> annotationsMap = new HashMap();
        private boolean buildCalled = false;

        static class KeyIdStrategy {
            private static final KeyIdStrategy RANDOM_ID = new KeyIdStrategy();
            private final int fixedId;

            private KeyIdStrategy() {
                this.fixedId = 0;
            }

            private KeyIdStrategy(int i) {
                this.fixedId = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static KeyIdStrategy randomId() {
                return RANDOM_ID;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static KeyIdStrategy fixedId(int i) {
                return new KeyIdStrategy(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int getFixedId() {
                return this.fixedId;
            }
        }

        public static final class Entry {

            @Nullable
            private Builder builder;
            private boolean isPrimary;

            @Nullable
            private final Key key;
            private KeyStatus keyStatus;

            @Nullable
            private final Parameters parameters;
            private KeyIdStrategy strategy;

            /* synthetic */ Entry(Key key, AnonymousClass1 anonymousClass1) {
                this(key);
            }

            /* synthetic */ Entry(Parameters parameters, AnonymousClass1 anonymousClass1) {
                this(parameters);
            }

            private Entry(Key key) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = key;
                this.parameters = null;
            }

            private Entry(Parameters parameters) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = null;
                this.parameters = parameters;
            }

            public Entry makePrimary() {
                Builder builder = this.builder;
                if (builder != null) {
                    builder.clearPrimary();
                }
                this.isPrimary = true;
                return this;
            }

            public boolean isPrimary() {
                return this.isPrimary;
            }

            public Entry setStatus(KeyStatus keyStatus) {
                this.keyStatus = keyStatus;
                return this;
            }

            public KeyStatus getStatus() {
                return this.keyStatus;
            }

            public Entry withFixedId(int i) {
                this.strategy = KeyIdStrategy.fixedId(i);
                return this;
            }

            public Entry withRandomId() {
                this.strategy = KeyIdStrategy.randomId();
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimary() {
            Iterator<Entry> it2 = this.entries.iterator();
            while (it2.hasNext()) {
                it2.next().isPrimary = false;
            }
        }

        public Builder addEntry(Entry entry) {
            if (entry.builder == null) {
                if (entry.isPrimary) {
                    clearPrimary();
                }
                entry.builder = this;
                this.entries.add(entry);
                return this;
            }
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }

        Builder setMonitoringAnnotations(MonitoringAnnotations monitoringAnnotations) {
            addAnnotations(MonitoringAnnotations.class, monitoringAnnotations);
            return this;
        }

        public <T extends Annotations> Builder addAnnotations(Class<T> cls, T t) {
            if (cls == Annotations.class) {
                throw new IllegalArgumentException("Cannot use Annotations.class for addAnnotations");
            }
            if (this.annotationsMap.containsKey(cls)) {
                throw new IllegalArgumentException("Cannot call addAnnotations twice for the same annotations class");
            }
            this.annotationsMap.put(cls, t);
            return this;
        }

        public int size() {
            return this.entries.size();
        }

        public Entry getAt(int i) {
            return this.entries.get(i);
        }

        @Deprecated
        public Entry removeAt(int i) {
            return this.entries.remove(i);
        }

        public Builder deleteAt(int i) {
            this.entries.remove(i);
            return this;
        }

        private static void checkIdAssignments(List<Entry> list) throws GeneralSecurityException {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).strategy == KeyIdStrategy.RANDOM_ID && list.get(i + 1).strategy != KeyIdStrategy.RANDOM_ID) {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorToThrow(GeneralSecurityException generalSecurityException) {
            this.errorToThrow = generalSecurityException;
        }

        private static int randomIdNotInSet(Set<Integer> set) {
            int iRandKeyId = 0;
            while (true) {
                if (iRandKeyId != 0 && !set.contains(Integer.valueOf(iRandKeyId))) {
                    return iRandKeyId;
                }
                iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
            }
        }

        private static int getNextIdFromBuilderEntry(Entry entry, Set<Integer> set) throws GeneralSecurityException {
            if (entry.strategy != null) {
                if (entry.strategy != KeyIdStrategy.RANDOM_ID) {
                    return entry.strategy.getFixedId();
                }
                return randomIdNotInSet(set);
            }
            throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
        }

        public KeysetHandle build() throws GeneralSecurityException {
            Entry entry;
            if (this.errorToThrow != null) {
                throw new GeneralSecurityException("Cannot build keyset due to error in original", this.errorToThrow);
            }
            if (this.buildCalled) {
                throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
            }
            this.buildCalled = true;
            ArrayList arrayList = new ArrayList(this.entries.size());
            checkIdAssignments(this.entries);
            HashSet hashSet = new HashSet();
            AnonymousClass1 anonymousClass1 = null;
            Integer numValueOf = null;
            for (Entry entry2 : this.entries) {
                if (entry2.keyStatus == null) {
                    throw new GeneralSecurityException("Key Status not set.");
                }
                int nextIdFromBuilderEntry = getNextIdFromBuilderEntry(entry2, hashSet);
                if (hashSet.contains(Integer.valueOf(nextIdFromBuilderEntry))) {
                    throw new GeneralSecurityException("Id " + nextIdFromBuilderEntry + " is used twice in the keyset");
                }
                hashSet.add(Integer.valueOf(nextIdFromBuilderEntry));
                if (entry2.key != null) {
                    KeysetHandle.validateKeyId(entry2.key, nextIdFromBuilderEntry);
                    entry = new Entry(entry2.key, KeysetHandle.serializeStatus(entry2.keyStatus), nextIdFromBuilderEntry, entry2.isPrimary, false, Entry.NO_LOGGING, null);
                } else {
                    entry = new Entry(MutableKeyCreationRegistry.globalInstance().createKey(entry2.parameters, entry2.parameters.hasIdRequirement() ? Integer.valueOf(nextIdFromBuilderEntry) : null), KeysetHandle.serializeStatus(entry2.keyStatus), nextIdFromBuilderEntry, entry2.isPrimary, false, Entry.NO_LOGGING, null);
                }
                if (entry2.isPrimary) {
                    if (numValueOf != null) {
                        throw new GeneralSecurityException("Two primaries were set");
                    }
                    numValueOf = Integer.valueOf(nextIdFromBuilderEntry);
                    if (entry2.keyStatus != KeyStatus.ENABLED) {
                        throw new GeneralSecurityException("Primary key is not enabled");
                    }
                }
                arrayList.add(entry);
            }
            if (numValueOf != null) {
                return KeysetHandle.addMonitoringIfNeeded(new KeysetHandle(arrayList, this.annotationsMap, anonymousClass1));
            }
            throw new GeneralSecurityException("No primary was set");
        }
    }

    @Immutable
    public static final class Entry implements KeysetHandleInterface.Entry {
        private static final EntryConsumer NO_LOGGING = new EntryConsumer() { // from class: com.google.crypto.tink.KeysetHandle$Entry$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.KeysetHandle.Entry.EntryConsumer
            public final void accept(KeysetHandle.Entry entry) {
                KeysetHandle.Entry.lambda$static$0(entry);
            }
        };
        private final int id;
        private final boolean isPrimary;
        private final Key key;
        private final EntryConsumer keyExportLogger;
        private final boolean keyParsingFailed;
        private final KeyStatus keyStatus;
        private final KeyStatusType keyStatusType;

        @Immutable
        interface EntryConsumer {
            void accept(Entry entry);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$static$0(Entry entry) {
        }

        /* synthetic */ Entry(Key key, KeyStatusType keyStatusType, int i, boolean z, boolean z2, EntryConsumer entryConsumer, AnonymousClass1 anonymousClass1) {
            this(key, keyStatusType, i, z, z2, entryConsumer);
        }

        private Entry(Key key, KeyStatusType keyStatusType, int i, boolean z, boolean z2, EntryConsumer entryConsumer) {
            this.key = key;
            this.keyStatusType = keyStatusType;
            this.keyStatus = KeysetHandle.parseStatusWithDisabledFallback(keyStatusType);
            this.id = i;
            this.isPrimary = z;
            this.keyParsingFailed = z2;
            this.keyExportLogger = entryConsumer;
        }

        @Override // com.google.crypto.tink.KeysetHandleInterface.Entry
        public Key getKey() {
            this.keyExportLogger.accept(this);
            return this.key;
        }

        @Override // com.google.crypto.tink.KeysetHandleInterface.Entry
        public KeyStatus getStatus() {
            return this.keyStatus;
        }

        @Override // com.google.crypto.tink.KeysetHandleInterface.Entry
        public int getId() {
            return this.id;
        }

        @Override // com.google.crypto.tink.KeysetHandleInterface.Entry
        public boolean isPrimary() {
            return this.isPrimary;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean equalsEntry(Entry entry) {
            return entry.isPrimary == this.isPrimary && entry.keyStatusType.equals(this.keyStatusType) && entry.id == this.id && entry.key.equalsKey(this.key);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.KeysetHandle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        static {
            int[] iArr = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr;
            try {
                iArr[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyStatus parseStatusWithDisabledFallback(KeyStatusType keyStatusType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyStatus.ENABLED;
        }
        if (i == 2) {
            return KeyStatus.DESTROYED;
        }
        return KeyStatus.DISABLED;
    }

    private static boolean isValidKeyStatusType(KeyStatusType keyStatusType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyStatusType serializeStatus(KeyStatus keyStatus) {
        if (KeyStatus.ENABLED.equals(keyStatus)) {
            return KeyStatusType.ENABLED;
        }
        if (KeyStatus.DISABLED.equals(keyStatus)) {
            return KeyStatusType.DISABLED;
        }
        if (KeyStatus.DESTROYED.equals(keyStatus)) {
            return KeyStatusType.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }

    private static List<Entry> getEntriesFromKeyset(Keyset keyset) throws GeneralSecurityException {
        Key legacyProtoKey;
        boolean z;
        ArrayList arrayList = new ArrayList(keyset.getKeyCount());
        for (Keyset.Key key : keyset.getKeyList()) {
            int keyId = key.getKeyId();
            try {
                legacyProtoKey = toKey(key);
                z = false;
            } catch (GeneralSecurityException e) {
                if (GlobalTinkFlags.validateKeysetsOnParsing.getValue()) {
                    throw e;
                }
                legacyProtoKey = new LegacyProtoKey(toProtoKeySerialization(key), InsecureSecretKeyAccess.get());
                z = true;
            }
            if (GlobalTinkFlags.validateKeysetsOnParsing.getValue() && !isValidKeyStatusType(key.getStatus())) {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
            arrayList.add(new Entry(legacyProtoKey, key.getStatus(), keyId, keyId == keyset.getPrimaryKeyId(), z, Entry.NO_LOGGING, null));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Entry entryByIndex(int i) {
        Entry entry = this.entries.get(i);
        if (isValidKeyStatusType(entry.keyStatusType)) {
            if (entry.keyParsingFailed) {
                throw new IllegalStateException("Keyset-Entry at position " + i + " didn't parse correctly");
            }
            return this.entries.get(i);
        }
        throw new IllegalStateException("Keyset-Entry at position " + i + " has wrong status");
    }

    public static Builder.Entry importKey(Key key) {
        Builder.Entry entry = new Builder.Entry(key, (AnonymousClass1) null);
        Integer idRequirementOrNull = key.getIdRequirementOrNull();
        if (idRequirementOrNull != null) {
            entry.withFixedId(idRequirementOrNull.intValue());
        }
        return entry;
    }

    public static Builder.Entry generateEntryFromParametersName(String str) throws GeneralSecurityException {
        return new Builder.Entry(MutableParametersRegistry.globalInstance().get(str), (AnonymousClass1) null);
    }

    public static Builder.Entry generateEntryFromParameters(Parameters parameters) {
        return new Builder.Entry(parameters, (AnonymousClass1) null);
    }

    private KeysetHandle getUnmonitoredHandle() {
        KeysetHandle keysetHandle = this.unmonitoredHandle;
        return keysetHandle == null ? this : keysetHandle;
    }

    private static void validateNoDuplicateIds(List<Entry> list) throws GeneralSecurityException {
        HashSet hashSet = new HashSet();
        boolean z = false;
        for (Entry entry : list) {
            if (hashSet.contains(Integer.valueOf(entry.getId()))) {
                throw new GeneralSecurityException("KeyID " + entry.getId() + " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
            hashSet.add(Integer.valueOf(entry.getId()));
            if (entry.isPrimary()) {
                z = true;
            }
        }
        if (!z) {
            throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
        }
    }

    private KeysetHandle(List<Entry> list, Map<Class<?>, Annotations> map) throws GeneralSecurityException {
        this.entries = list;
        this.annotationsMap = map;
        if (GlobalTinkFlags.validateKeysetsOnParsing.getValue()) {
            validateNoDuplicateIds(list);
        }
        this.unmonitoredHandle = null;
    }

    private KeysetHandle(List<Entry> list, Map<Class<?>, Annotations> map, KeysetHandle keysetHandle) {
        this.entries = list;
        this.annotationsMap = map;
        this.unmonitoredHandle = keysetHandle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeysetHandle addMonitoringIfNeeded(KeysetHandle keysetHandle) {
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandle.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations == null) {
            return keysetHandle;
        }
        KeysetHandle$$ExternalSyntheticLambda0 keysetHandle$$ExternalSyntheticLambda0 = new KeysetHandle$$ExternalSyntheticLambda0(keysetHandle, monitoringAnnotations);
        ArrayList arrayList = new ArrayList(keysetHandle.entries.size());
        for (Entry entry : keysetHandle.entries) {
            arrayList.add(new Entry(entry.key, entry.keyStatusType, entry.id, entry.isPrimary, entry.keyParsingFailed, keysetHandle$$ExternalSyntheticLambda0, null));
        }
        return new KeysetHandle(arrayList, keysetHandle.annotationsMap, keysetHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addMonitoringIfNeeded$0(KeysetHandle keysetHandle, MonitoringAnnotations monitoringAnnotations, Entry entry) {
        MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(keysetHandle, monitoringAnnotations, "keyset_handle", "get_key").logKeyExport(entry.getId());
    }

    static final KeysetHandle fromKeyset(Keyset keyset) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(getEntriesFromKeyset(keyset), new HashMap());
    }

    static final KeysetHandle fromKeysetAndAnnotations(Keyset keyset, MonitoringAnnotations monitoringAnnotations) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset);
        List<Entry> entriesFromKeyset = getEntriesFromKeyset(keyset);
        HashMap map = new HashMap();
        map.put(MonitoringAnnotations.class, monitoringAnnotations);
        return addMonitoringIfNeeded(new KeysetHandle(entriesFromKeyset, map));
    }

    Keyset getKeyset() {
        try {
            Keyset.Builder builderNewBuilder = Keyset.newBuilder();
            for (Entry entry : this.entries) {
                builderNewBuilder.addKey(createKeysetKey(entry.getKey(), entry.keyStatusType, entry.getId()));
                if (entry.isPrimary()) {
                    builderNewBuilder.setPrimaryKeyId(entry.getId());
                }
            }
            return builderNewBuilder.build();
        } catch (GeneralSecurityException e) {
            throw new TinkBugException(e);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(KeysetHandle keysetHandle) {
        Builder builder = new Builder();
        for (int i = 0; i < keysetHandle.size(); i++) {
            try {
                Entry at = keysetHandle.getAt(i);
                Builder.Entry entryWithFixedId = importKey(at.getKey()).withFixedId(at.getId());
                entryWithFixedId.setStatus(at.getStatus());
                if (at.isPrimary()) {
                    entryWithFixedId.makePrimary();
                }
                builder.addEntry(entryWithFixedId);
            } catch (IllegalStateException e) {
                builder.setErrorToThrow(new GeneralSecurityException("Keyset-Entry in original keyset at position " + i + " has wrong status or key parsing failed", e));
            }
        }
        return builder;
    }

    @Override // com.google.crypto.tink.KeysetHandleInterface
    public Entry getPrimary() {
        for (Entry entry : this.entries) {
            if (entry != null && entry.isPrimary()) {
                if (entry.getStatus() == KeyStatus.ENABLED) {
                    return entry;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    @Override // com.google.crypto.tink.KeysetHandleInterface
    public int size() {
        return this.entries.size();
    }

    @Override // com.google.crypto.tink.KeysetHandleInterface
    public Entry getAt(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Invalid index " + i + " for keyset of size " + size());
        }
        return entryByIndex(i);
    }

    @Override // com.google.crypto.tink.KeysetHandleInterface
    @Nullable
    public <T extends Annotations> T getAnnotationsOrNull(Class<T> cls) {
        return (T) this.annotationsMap.get(cls);
    }

    @Deprecated
    public List<KeyHandle> getKeys() {
        ArrayList arrayList = new ArrayList();
        for (Keyset.Key key : getKeyset().getKeyList()) {
            arrayList.add(new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Deprecated
    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(getKeyset());
    }

    public static final KeysetHandle generateNew(Parameters parameters) throws GeneralSecurityException {
        return newBuilder().addEntry(generateEntryFromParameters(parameters).withRandomId().makePrimary()).build();
    }

    @Deprecated
    public static final KeysetHandle generateNew(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        return generateNew(TinkProtoParametersFormat.parse(keyTemplate.toByteArray()));
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return generateNew(keyTemplate.toParameters());
    }

    @Deprecated
    public static final KeysetHandle createFromKey(KeyHandle keyHandle, KeyAccess keyAccess) throws GeneralSecurityException {
        KeysetManager keysetManagerAdd = KeysetManager.withEmptyKeyset().add(keyHandle);
        keysetManagerAdd.setPrimary(keysetManagerAdd.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
        return keysetManagerAdd.getKeysetHandle();
    }

    @Deprecated
    public static final KeysetHandle read(KeysetReader keysetReader, Aead aead) throws GeneralSecurityException, IOException {
        return readWithAssociatedData(keysetReader, aead, new byte[0]);
    }

    @Deprecated
    public static final KeysetHandle readWithAssociatedData(KeysetReader keysetReader, Aead aead, byte[] bArr) throws GeneralSecurityException, IOException {
        EncryptedKeyset encrypted = keysetReader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(encrypted);
        return fromKeyset(decrypt(encrypted, aead, bArr));
    }

    @Deprecated
    public static final KeysetHandle readNoSecret(KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        try {
            return readNoSecret(keysetReader.read().toByteArray());
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    @Deprecated
    public static final KeysetHandle readNoSecret(byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset from = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            assertNoSecretKeyMaterial(from);
            return fromKeyset(from);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    @Deprecated
    public void write(KeysetWriter keysetWriter, Aead aead) throws GeneralSecurityException, IOException {
        writeWithAssociatedData(keysetWriter, aead, new byte[0]);
    }

    @Deprecated
    public void writeWithAssociatedData(KeysetWriter keysetWriter, Aead aead, byte[] bArr) throws GeneralSecurityException, IOException {
        keysetWriter.write(encrypt(getKeyset(), aead, bArr));
    }

    @Deprecated
    public void writeNoSecret(KeysetWriter keysetWriter) throws GeneralSecurityException, IOException {
        Keyset keyset = getKeyset();
        assertNoSecretKeyMaterial(keyset);
        keysetWriter.write(keyset);
    }

    private static EncryptedKeyset encrypt(Keyset keyset, Aead aead, byte[] bArr) throws GeneralSecurityException {
        return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(aead.encrypt(keyset.toByteArray(), bArr))).setKeysetInfo(Util.getKeysetInfo(keyset)).build();
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead aead, byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset from = Keyset.parseFrom(aead.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), bArr), ExtensionRegistryLite.getEmptyRegistry());
            assertEnoughKeyMaterial(from);
            return from;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        Key legacyProtoKey;
        boolean z;
        Entry entry;
        Keyset keyset = getKeyset();
        ArrayList arrayList = new ArrayList(this.entries.size());
        int i = 0;
        for (Entry entry2 : this.entries) {
            if (entry2.getKey() instanceof PrivateKey) {
                Key publicKey = ((PrivateKey) entry2.getKey()).getPublicKey();
                Entry entry3 = new Entry(publicKey, entry2.keyStatusType, entry2.getId(), entry2.isPrimary(), false, Entry.NO_LOGGING, null);
                validateKeyId(publicKey, entry2.getId());
                entry = entry3;
            } else {
                Keyset.Key key = keyset.getKey(i);
                Keyset.Key keyBuild = key.toBuilder().setKeyData(getPublicKeyDataFromRegistry(key.getKeyData())).build();
                try {
                    legacyProtoKey = toKey(keyBuild);
                    z = false;
                } catch (GeneralSecurityException e) {
                    if (GlobalTinkFlags.validateKeysetsOnParsing.getValue()) {
                        throw e;
                    }
                    legacyProtoKey = new LegacyProtoKey(toProtoKeySerialization(keyBuild), InsecureSecretKeyAccess.get());
                    z = true;
                }
                int keyId = keyBuild.getKeyId();
                entry = new Entry(legacyProtoKey, entry2.keyStatusType, keyId, keyId == keyset.getPrimaryKeyId(), z, Entry.NO_LOGGING, null);
            }
            arrayList.add(entry);
            i++;
        }
        return addMonitoringIfNeeded(new KeysetHandle(arrayList, this.annotationsMap));
    }

    private static KeyData getPublicKeyDataFromRegistry(KeyData keyData) throws GeneralSecurityException {
        if (keyData.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            throw new GeneralSecurityException("The keyset contains a non-private key");
        }
        return Registry.getPublicKeyData(keyData.getTypeUrl(), keyData.getValue());
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    private static void assertNoSecretKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", key.getKeyData().getKeyMaterialType().name(), key.getKeyData().getTypeUrl()));
            }
        }
    }

    private static void assertEnoughKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        if (keyset == null || keyset.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset == null || encryptedKeyset.getEncryptedKeyset().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public <P> P getPrimitive(Configuration configuration, Class<P> cls) throws GeneralSecurityException {
        Keyset keyset = getUnmonitoredHandle().getKeyset();
        Util.validateKeyset(keyset);
        for (int i = 0; i < size(); i++) {
            if (this.entries.get(i).keyParsingFailed || !isValidKeyStatusType(this.entries.get(i).keyStatusType)) {
                throw new GeneralSecurityException("Key parsing of key with index " + i + " and type_url " + keyset.getKey(i).getKeyData().getTypeUrl() + " failed, unable to get primitive");
            }
        }
        return (P) configuration.createPrimitive(getUnmonitoredHandle(), cls);
    }

    @Deprecated
    public <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(RegistryConfiguration.get(), cls);
    }

    @Deprecated
    public KeyHandle primaryKey() throws GeneralSecurityException {
        Keyset keyset = getKeyset();
        int primaryKeyId = keyset.getPrimaryKeyId();
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyId() == primaryKeyId) {
                return new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId());
            }
        }
        throw new GeneralSecurityException("No primary key found in keyset.");
    }

    public boolean equalsKeyset(KeysetHandle keysetHandle) {
        if (size() != keysetHandle.size()) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < size(); i++) {
            Entry entry = this.entries.get(i);
            Entry entry2 = keysetHandle.entries.get(i);
            if (entry.keyParsingFailed || entry2.keyParsingFailed || !isValidKeyStatusType(entry.keyStatusType) || !isValidKeyStatusType(entry2.keyStatusType) || !entry.equalsEntry(entry2)) {
                return false;
            }
            z |= entry.isPrimary;
        }
        return z;
    }

    private static ProtoKeySerialization toProtoKeySerialization(Keyset.Key key) throws GeneralSecurityException {
        return ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), key.getOutputPrefixType() == OutputPrefixType.RAW ? null : Integer.valueOf(key.getKeyId()));
    }

    private static Key toKey(Keyset.Key key) throws GeneralSecurityException {
        return MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(toProtoKeySerialization(key), InsecureSecretKeyAccess.get());
    }

    private static Keyset.Key toKeysetKey(int i, KeyStatusType keyStatusType, ProtoKeySerialization protoKeySerialization) {
        return Keyset.Key.newBuilder().setKeyData(KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setStatus(keyStatusType).setKeyId(i).setOutputPrefixType(protoKeySerialization.getOutputPrefixType()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateKeyId(Key key, int i) throws GeneralSecurityException {
        Integer idRequirementOrNull = key.getIdRequirementOrNull();
        if (idRequirementOrNull != null && idRequirementOrNull.intValue() != i) {
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }
    }

    private static Keyset.Key createKeysetKey(Key key, KeyStatusType keyStatusType, int i) throws GeneralSecurityException {
        ProtoKeySerialization protoKeySerialization = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(key, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
        validateKeyId(key, i);
        return toKeysetKey(i, keyStatusType, protoKeySerialization);
    }
}
