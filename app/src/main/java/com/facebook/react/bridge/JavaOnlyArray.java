package com.facebook.react.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class JavaOnlyArray implements ReadableArray, WritableArray {
    public static final Companion Companion = new Companion(null);
    private final List<Object> backingList;

    public /* synthetic */ JavaOnlyArray(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<?>) list);
    }

    public /* synthetic */ JavaOnlyArray(Object[] objArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(objArr);
    }

    @JvmStatic
    public static final JavaOnlyArray deepClone(@Nullable ReadableArray readableArray) {
        return Companion.deepClone(readableArray);
    }

    @JvmStatic
    public static final JavaOnlyArray from(@NotNull List<?> list) {
        return Companion.from(list);
    }

    @JvmStatic
    public static final JavaOnlyArray of(@NotNull Object... objArr) {
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
        public final JavaOnlyArray from(@NotNull List<?> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            return new JavaOnlyArray(list, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final JavaOnlyArray of(@NotNull Object... values) {
            Intrinsics.checkNotNullParameter(values, "values");
            return new JavaOnlyArray(Arrays.copyOf(values, values.length), (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final JavaOnlyArray deepClone(@Nullable ReadableArray readableArray) {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            if (readableArray == null) {
                return javaOnlyArray;
            }
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                switch (WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()]) {
                    case 1:
                        javaOnlyArray.pushNull();
                        break;
                    case 2:
                        javaOnlyArray.pushBoolean(readableArray.getBoolean(i));
                        break;
                    case 3:
                        javaOnlyArray.pushDouble(readableArray.getDouble(i));
                        break;
                    case 4:
                        javaOnlyArray.pushString(readableArray.getString(i));
                        break;
                    case 5:
                        javaOnlyArray.pushMap(JavaOnlyMap.Companion.deepClone(readableArray.getMap(i)));
                        break;
                    case 6:
                        javaOnlyArray.pushArray(JavaOnlyArray.Companion.deepClone(readableArray.getArray(i)));
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            return javaOnlyArray;
        }
    }

    private JavaOnlyArray(Object... objArr) {
        this.backingList = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(objArr, objArr.length));
    }

    private JavaOnlyArray(List<?> list) {
        this.backingList = new ArrayList(list);
    }

    public JavaOnlyArray() {
        this.backingList = new ArrayList();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int size() {
        return this.backingList.size();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean isNull(int i) {
        return this.backingList.get(i) == null;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public double getDouble(int i) {
        Object obj = this.backingList.get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int getInt(int i) {
        Object obj = this.backingList.get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).intValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public long getLong(int i) {
        Object obj = this.backingList.get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).longValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public String getString(int i) {
        return (String) this.backingList.get(i);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ReadableArray getArray(int i) {
        return (ReadableArray) this.backingList.get(i);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean getBoolean(int i) {
        Object obj = this.backingList.get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ReadableMap getMap(int i) {
        return (ReadableMap) this.backingList.get(i);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public Dynamic getDynamic(int i) {
        DynamicFromArray dynamicFromArrayCreate = DynamicFromArray.create(this, i);
        Intrinsics.checkNotNullExpressionValue(dynamicFromArrayCreate, "create(...)");
        return dynamicFromArrayCreate;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ReadableType getType(int i) {
        Object obj = this.backingList.get(i);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        throw new IllegalStateException("Invalid type " + obj.getClass() + ")");
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushBoolean(boolean z) {
        this.backingList.add(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushDouble(double d) {
        this.backingList.add(Double.valueOf(d));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushInt(int i) {
        this.backingList.add(Double.valueOf(i));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushLong(long j) {
        this.backingList.add(Double.valueOf(j));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushString(@Nullable String str) {
        this.backingList.add(str);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushArray(@Nullable ReadableArray readableArray) {
        this.backingList.add(readableArray);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushMap(@Nullable ReadableMap readableMap) {
        this.backingList.add(readableMap);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushNull() {
        this.backingList.add(null);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ArrayList<Object> toArrayList() {
        return new ArrayList<>(this.backingList);
    }

    public String toString() {
        return this.backingList.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(JavaOnlyArray.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.backingList, ((JavaOnlyArray) obj).backingList);
    }

    public int hashCode() {
        return this.backingList.hashCode();
    }
}
