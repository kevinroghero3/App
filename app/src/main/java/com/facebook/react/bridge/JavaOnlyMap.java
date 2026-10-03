package com.facebook.react.bridge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class JavaOnlyMap implements ReadableMap, WritableMap {
    public static final Companion Companion = new Companion(null);
    private final Map<String, Object> backingMap;

    public /* synthetic */ JavaOnlyMap(Object[] objArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(objArr);
    }

    @JvmStatic
    public static final JavaOnlyMap deepClone(@Nullable ReadableMap readableMap) {
        return Companion.deepClone(readableMap);
    }

    @JvmStatic
    public static final JavaOnlyMap from(@NotNull Map<String, ? extends Object> map) {
        return Companion.from(map);
    }

    @JvmStatic
    public static final JavaOnlyMap of(@NotNull Object... objArr) {
        return Companion.of(objArr);
    }

    public static final class Companion {

        /* JADX INFO: loaded from: classes4.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Null.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Boolean.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ReadableType.Number.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ReadableType.Array.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final JavaOnlyMap of(@NotNull Object... keysAndValues) {
            Intrinsics.checkNotNullParameter(keysAndValues, "keysAndValues");
            return new JavaOnlyMap(Arrays.copyOf(keysAndValues, keysAndValues.length), null);
        }

        @JvmStatic
        public final JavaOnlyMap from(@NotNull Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return new JavaOnlyMap(new Object[]{map}, null);
        }

        @JvmStatic
        public final JavaOnlyMap deepClone(@Nullable ReadableMap readableMap) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            if (readableMap == null) {
                return javaOnlyMap;
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                switch (WhenMappings.$EnumSwitchMapping$0[readableMap.getType(strNextKey).ordinal()]) {
                    case 1:
                        javaOnlyMap.putNull(strNextKey);
                        break;
                    case 2:
                        javaOnlyMap.putBoolean(strNextKey, readableMap.getBoolean(strNextKey));
                        break;
                    case 3:
                        javaOnlyMap.putDouble(strNextKey, readableMap.getDouble(strNextKey));
                        break;
                    case 4:
                        javaOnlyMap.putString(strNextKey, readableMap.getString(strNextKey));
                        break;
                    case 5:
                        javaOnlyMap.putMap(strNextKey, deepClone(readableMap.getMap(strNextKey)));
                        break;
                    case 6:
                        javaOnlyMap.putArray(strNextKey, JavaOnlyArray.Companion.deepClone(readableMap.getArray(strNextKey)));
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            return javaOnlyMap;
        }
    }

    public JavaOnlyMap() {
        this.backingMap = new HashMap();
    }

    private JavaOnlyMap(Object... objArr) {
        this();
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("You must provide the same number of keys and values");
        }
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, objArr.length - 1, 2);
        if (progressionLastElement < 0) {
            return;
        }
        while (true) {
            Object objValueOf = objArr[i + 1];
            objValueOf = objValueOf instanceof Number ? Double.valueOf(((Number) objValueOf).doubleValue()) : objValueOf;
            Map<String, Object> map = this.backingMap;
            Object obj = objArr[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            map.put((String) obj, objValueOf);
            if (i == progressionLastElement) {
                return;
            } else {
                i += 2;
            }
        }
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean hasKey(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.containsKey(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean isNull(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.get(name) == null;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean getBoolean(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public double getDouble(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public int getInt(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).intValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public long getLong(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).longValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public String getString(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (String) this.backingMap.get(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableMap getMap(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (ReadableMap) this.backingMap.get(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableArray getArray(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (ReadableArray) this.backingMap.get(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public Dynamic getDynamic(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        DynamicFromMap dynamicFromMapCreate = DynamicFromMap.create(this, name);
        Intrinsics.checkNotNullExpressionValue(dynamicFromMapCreate, "create(...)");
        return dynamicFromMapCreate;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableType getType(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Number) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof Dynamic) {
            return ((Dynamic) obj).getType();
        }
        throw new IllegalArgumentException("Invalid value " + obj + " for key " + name + " contained in JavaOnlyMap");
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public Iterator<Map.Entry<String, Object>> getEntryIterator() {
        return this.backingMap.entrySet().iterator();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableMapKeySetIterator(this) { // from class: com.facebook.react.bridge.JavaOnlyMap.keySetIterator.1
            private final Iterator<Map.Entry<String, Object>> iterator;

            {
                this.iterator = this.backingMap.entrySet().iterator();
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public boolean hasNextKey() {
                return this.iterator.hasNext();
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public String nextKey() {
                return this.iterator.next().getKey();
            }
        };
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putBoolean(@NotNull String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Boolean.valueOf(z));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putDouble(@NotNull String key, double d) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Double.valueOf(d));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putInt(@NotNull String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Double.valueOf(i));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putLong(@NotNull String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Double.valueOf(j));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putString(@NotNull String key, @Nullable String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, str);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putNull(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, null);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putMap(@NotNull String key, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, readableMap);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void merge(@NotNull ReadableMap source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.backingMap.putAll(((JavaOnlyMap) source).backingMap);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public WritableMap copy() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.merge(this);
        return javaOnlyMap;
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putArray(@NotNull String key, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, readableArray);
    }

    public final void remove(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.remove(key);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public HashMap<String, Object> toHashMap() {
        return new HashMap<>(this.backingMap);
    }

    public String toString() {
        return this.backingMap.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(JavaOnlyMap.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.backingMap, ((JavaOnlyMap) obj).backingMap);
    }

    public int hashCode() {
        return this.backingMap.hashCode();
    }
}
