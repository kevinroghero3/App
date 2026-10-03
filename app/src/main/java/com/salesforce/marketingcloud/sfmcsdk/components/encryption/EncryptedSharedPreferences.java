package com.salesforce.marketingcloud.sfmcsdk.components.encryption;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import androidx.collection.ArraySet;
import io.sentry.android.core.SentryLogcatAdapter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class EncryptedSharedPreferences implements SharedPreferences {
    private static final int BYTE_BYTES = 1;
    public static final Companion Companion = new Companion(null);
    private static final int FLOAT_BYTES = 4;
    private static final int INTEGER_BYTES = 4;
    private static final String KEY_IV = "__iv__";
    private static final int LONG_BYTES = 8;
    private static final String NULL_VALUE = "__NULL__";
    private static final String TAG = "EncryptedSharedPrefs";
    private final byte[] iv;
    private final String mEncryptionKey;
    private final List<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    private final SharedPreferences mSharedPreferences;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EncryptedType.values().length];
            try {
                iArr[EncryptedType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EncryptedType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EncryptedType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EncryptedType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EncryptedType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EncryptedType.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ EncryptedSharedPreferences(SharedPreferences sharedPreferences, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, str);
    }

    private EncryptedSharedPreferences(SharedPreferences sharedPreferences, String str) {
        this.mSharedPreferences = sharedPreferences;
        this.mEncryptionKey = str;
        this.mListeners = new ArrayList();
        this.iv = generateKeyIv();
    }

    public final List<SharedPreferences.OnSharedPreferenceChangeListener> getMListeners() {
        return this.mListeners;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap map = new HashMap();
        Map<String, ?> all = this.mSharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            String key = it2.next().getKey();
            if (!isReservedKey(key)) {
                String strDecryptKey = decryptKey(key);
                map.put(strDecryptKey, getDecryptedObject(strDecryptKey));
            }
        }
        return map;
    }

    public final Set<String> getAllKeys() {
        HashSet hashSet = new HashSet();
        Map<String, ?> all = this.mSharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            String key = it2.next().getKey();
            if (!isReservedKey(key)) {
                Intrinsics.checkNotNull(key);
                hashSet.add(key);
            }
        }
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public String getString(@Nullable String str, @Nullable String str2) {
        Object decryptedObject = getDecryptedObject(str);
        String str3 = decryptedObject instanceof String ? (String) decryptedObject : null;
        return str3 == null ? str2 : str3;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(@Nullable String str, @Nullable Set<String> set) {
        Object decryptedObject = getDecryptedObject(str);
        if (!(decryptedObject instanceof Set) || ((Collection) decryptedObject).isEmpty()) {
            return set;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) decryptedObject) {
            if (obj instanceof String) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }

    @Override // android.content.SharedPreferences
    public int getInt(@Nullable String str, int i) {
        Object decryptedObject = getDecryptedObject(str);
        Integer num = decryptedObject instanceof Integer ? (Integer) decryptedObject : null;
        return num != null ? num.intValue() : i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(@Nullable String str, long j) {
        Object decryptedObject = getDecryptedObject(str);
        Long l = decryptedObject instanceof Long ? (Long) decryptedObject : null;
        return l != null ? l.longValue() : j;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(@Nullable String str, float f) {
        Object decryptedObject = getDecryptedObject(str);
        Float f2 = decryptedObject instanceof Float ? (Float) decryptedObject : null;
        return f2 != null ? f2.floatValue() : f;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(@Nullable String str, boolean z) {
        Object decryptedObject = getDecryptedObject(str);
        Boolean bool = decryptedObject instanceof Boolean ? (Boolean) decryptedObject : null;
        return bool != null ? bool.booleanValue() : z;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(@Nullable String str) {
        if (isReservedKey(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        return this.mSharedPreferences.contains(encryptKey(str));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
        return new Editor(this, editorEdit);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.add(listener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.remove(listener);
    }

    private final Object getDecryptedObject(String str) {
        if (str == null) {
            str = NULL_VALUE;
        }
        if (isReservedKey(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        String string = this.mSharedPreferences.getString(encryptKey(str), null);
        if (string == null) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(decryptValue(string));
        byteBufferWrap.position(0);
        Intrinsics.checkNotNull(byteBufferWrap);
        return decryptBuffer(byteBufferWrap);
    }

    private final Object decryptBuffer(ByteBuffer byteBuffer) {
        EncryptedType encryptedTypeFromId = EncryptedType.Companion.fromId(byteBuffer.getInt());
        switch (encryptedTypeFromId == null ? -1 : WhenMappings.$EnumSwitchMapping$0[encryptedTypeFromId.ordinal()]) {
            case 1:
                return decryptString(byteBuffer);
            case 2:
                return Integer.valueOf(byteBuffer.getInt());
            case 3:
                return Long.valueOf(byteBuffer.getLong());
            case 4:
                return Float.valueOf(byteBuffer.getFloat());
            case 5:
                return Boolean.valueOf(byteBuffer.get() != 0);
            case 6:
                return decryptStringSet(byteBuffer);
            default:
                throw new IllegalArgumentException("Unsupported type: " + encryptedTypeFromId);
        }
    }

    private final String decryptString(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBuffer.limit(i);
        String string = StandardCharsets.UTF_8.decode(byteBufferSlice).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (Intrinsics.areEqual(string, NULL_VALUE)) {
            return null;
        }
        return string;
    }

    private final Set<String> decryptStringSet(ByteBuffer byteBuffer) {
        ArraySet arraySet = new ArraySet();
        while (byteBuffer.hasRemaining()) {
            int i = byteBuffer.getInt();
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.limit(i);
            byteBuffer.position(byteBuffer.position() + i);
            arraySet.add(StandardCharsets.UTF_8.decode(byteBufferSlice).toString());
        }
        if (arraySet.size() == 1 && Intrinsics.areEqual(NULL_VALUE, arraySet.valueAt(0))) {
            return null;
        }
        return arraySet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String encryptKey(String str) {
        if (str == null) {
            str = NULL_VALUE;
        }
        String strEncrypt = Encryptor.encrypt(str, this.mEncryptionKey, this.iv);
        Intrinsics.checkNotNullExpressionValue(strEncrypt, "encrypt(...)");
        return strEncrypt;
    }

    private final String decryptKey(String str) {
        String strDecrypt = Encryptor.decrypt(str, this.mEncryptionKey);
        if (Intrinsics.areEqual(strDecrypt, NULL_VALUE)) {
            return null;
        }
        return strDecrypt;
    }

    private final String encryptValue(byte[] bArr) {
        String strEncrypt = Encryptor.encrypt(Base64.encodeToString(bArr, 2), this.mEncryptionKey);
        Intrinsics.checkNotNullExpressionValue(strEncrypt, "encrypt(...)");
        return strEncrypt;
    }

    private final byte[] decryptValue(String str) {
        byte[] bArrDecode = Base64.decode(Encryptor.decrypt(str, this.mEncryptionKey), 2);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return bArrDecode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, String> encryptKeyValuePair(String str, byte[] bArr) {
        return new Pair<>(encryptKey(str), encryptValue(bArr));
    }

    private final byte[] generateKeyIv() throws NoSuchAlgorithmException {
        String string = this.mSharedPreferences.getString(KEY_IV, null);
        if (string != null) {
            byte[] bArrDecode = Base64.decode(string, 2);
            Intrinsics.checkNotNull(bArrDecode);
            return bArrDecode;
        }
        byte[] bArrGenerateInitVector = Encryptor.generateInitVector();
        this.mSharedPreferences.edit().putString(KEY_IV, Base64.encodeToString(bArrGenerateInitVector, 2)).apply();
        Intrinsics.checkNotNull(bArrGenerateInitVector);
        return bArrGenerateInitVector;
    }

    public final boolean isReservedKey(@Nullable String str) {
        return Intrinsics.areEqual(KEY_IV, str);
    }

    public final boolean verifyEncryption() {
        try {
            return getAllKeys().isEmpty() || !(getAllKeys().isEmpty() || this.mSharedPreferences.getString(encryptKey("registrationId"), null) == null);
        } catch (Exception e) {
            SentryLogcatAdapter.e(TAG, "Exception while encrypting registrationId", e);
        }
    }

    public final void clearInstallationPrefs() {
        SharedPreferences.Editor editorEdit = edit();
        Intrinsics.checkNotNull(editorEdit, "null cannot be cast to non-null type com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptedSharedPreferences.Editor");
        Editor editor = (Editor) editorEdit;
        Iterator<T> it2 = getAllKeys().iterator();
        while (it2.hasNext()) {
            editor.remove((String) it2.next(), false);
        }
        editor.apply();
    }

    enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);

        private final int id;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final Companion Companion = new Companion(null);

        public static EnumEntries<EncryptedType> getEntries() {
            return $ENTRIES;
        }

        EncryptedType(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final EncryptedType fromId(int i) {
                if (i == 0) {
                    return EncryptedType.STRING;
                }
                if (i == 1) {
                    return EncryptedType.STRING_SET;
                }
                if (i == 2) {
                    return EncryptedType.INT;
                }
                if (i == 3) {
                    return EncryptedType.LONG;
                }
                if (i == 4) {
                    return EncryptedType.FLOAT;
                }
                if (i != 5) {
                    return null;
                }
                return EncryptedType.BOOLEAN;
            }
        }
    }

    static final class Editor implements SharedPreferences.Editor {
        private final AtomicBoolean mClearRequested;
        private final SharedPreferences.Editor mEditor;
        private final EncryptedSharedPreferences mEncryptedSharedPreferences;
        private final List<String> mKeysChanged;

        public Editor(@NotNull EncryptedSharedPreferences mEncryptedSharedPreferences, @NotNull SharedPreferences.Editor mEditor) {
            Intrinsics.checkNotNullParameter(mEncryptedSharedPreferences, "mEncryptedSharedPreferences");
            Intrinsics.checkNotNullParameter(mEditor, "mEditor");
            this.mEncryptedSharedPreferences = mEncryptedSharedPreferences;
            this.mEditor = mEditor;
            this.mClearRequested = new AtomicBoolean(false);
            this.mKeysChanged = new CopyOnWriteArrayList();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(@Nullable String str, @Nullable String str2) {
            if (str2 == null) {
                str2 = EncryptedSharedPreferences.NULL_VALUE;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str2.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 8);
            byteBufferAllocate.putInt(EncryptedType.STRING.getId());
            byteBufferAllocate.putInt(bytes.length);
            byteBufferAllocate.put(bytes);
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            putEncryptedObject(str, bArrArray);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(@Nullable String str, @Nullable Set<String> set) {
            List listListOf;
            if (set == null) {
                byte[] bytes = EncryptedSharedPreferences.NULL_VALUE.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                listListOf = CollectionsKt__CollectionsJVMKt.listOf(bytes);
            } else {
                Set<String> set2 = set;
                listListOf = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(set2, 10));
                for (String str2 : set2) {
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    byte[] bytes2 = str2.getBytes(UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    listListOf.add(bytes2);
                }
            }
            List<byte[]> list = listListOf;
            Iterator it2 = list.iterator();
            int length = 0;
            while (it2.hasNext()) {
                length += ((byte[]) it2.next()).length;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + ((listListOf.size() + 1) * 4));
            byteBufferAllocate.putInt(EncryptedType.STRING_SET.getId());
            for (byte[] bArr : list) {
                byteBufferAllocate.putInt(bArr.length);
                byteBufferAllocate.put(bArr);
            }
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            putEncryptedObject(str, bArrArray);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(@Nullable String str, int i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(EncryptedType.INT.getId());
            byteBufferAllocate.putInt(i);
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            putEncryptedObject(str, bArrArray);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(@Nullable String str, long j) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
            byteBufferAllocate.putInt(EncryptedType.LONG.getId());
            byteBufferAllocate.putLong(j);
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            putEncryptedObject(str, bArrArray);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(@Nullable String str, float f) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(EncryptedType.FLOAT.getId());
            byteBufferAllocate.putFloat(f);
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            putEncryptedObject(str, bArrArray);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(@Nullable String str, boolean z) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
            byteBufferAllocate.putInt(EncryptedType.BOOLEAN.getId());
            byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            putEncryptedObject(str, bArrArray);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(@Nullable String str) {
            return remove(str, true);
        }

        public final SharedPreferences.Editor remove(@Nullable String str, boolean z) {
            if (this.mEncryptedSharedPreferences.isReservedKey(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.mEditor.remove(z ? this.mEncryptedSharedPreferences.encryptKey(str) : str);
            this.mKeysChanged.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            clearKeysIfNeeded();
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                this.mKeysChanged.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            clearKeysIfNeeded();
            this.mEditor.apply();
            notifyListeners();
            this.mKeysChanged.clear();
        }

        private final void clearKeysIfNeeded() {
            if (this.mClearRequested.getAndSet(false)) {
                for (String str : this.mEncryptedSharedPreferences.getAllKeys()) {
                    if (!this.mKeysChanged.contains(str) && !this.mEncryptedSharedPreferences.isReservedKey(str)) {
                        remove(str, false);
                    }
                }
            }
        }

        private final void putEncryptedObject(String str, byte[] bArr) {
            if (this.mEncryptedSharedPreferences.isReservedKey(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.mKeysChanged.add(str);
            if (str == null) {
                str = EncryptedSharedPreferences.NULL_VALUE;
            }
            Pair pairEncryptKeyValuePair = this.mEncryptedSharedPreferences.encryptKeyValuePair(str, bArr);
            this.mEditor.putString((String) pairEncryptKeyValuePair.first, (String) pairEncryptKeyValuePair.second);
        }

        private final void notifyListeners() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.mEncryptedSharedPreferences.getMListeners()) {
                Iterator<String> it2 = this.mKeysChanged.iterator();
                while (it2.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.mEncryptedSharedPreferences, it2.next());
                }
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedPreferences create(@NotNull Context context, @NotNull String fileName, @NotNull String encryptionKey) throws NoSuchAlgorithmException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(encryptionKey, "encryptionKey");
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return new EncryptedSharedPreferences(sharedPreferences, encryptionKey, null);
        }
    }
}
