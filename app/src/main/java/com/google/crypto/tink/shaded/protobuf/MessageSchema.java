package com.google.crypto.tink.shaded.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.soloader.Elf64;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int i) {
        return (i & ENFORCE_UTF8_MASK) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int i) {
        return (i & Integer.MIN_VALUE) != 0;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    private static long offset(int i) {
        return i & 1048575;
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0256  */
    /* JADX WARN: Code duplicated, block: B:122:0x0259  */
    /* JADX WARN: Code duplicated, block: B:125:0x0270  */
    /* JADX WARN: Code duplicated, block: B:126:0x0273  */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr2;
        int i19;
        int iObjectFieldOffset;
        int i20;
        int i21;
        java.lang.reflect.Field fieldReflectField;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        Object obj;
        java.lang.reflect.Field fieldReflectField2;
        int i26;
        Object obj2;
        java.lang.reflect.Field fieldReflectField3;
        int i27;
        char cCharAt10;
        int i28;
        char cCharAt11;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char c = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i31 = 1;
            while (true) {
                i = i31 + 1;
                if (stringInfo.charAt(i31) < 55296) {
                    break;
                }
                i31 = i;
            }
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int iCharAt3 = stringInfo.charAt(i);
        if (iCharAt3 >= 55296) {
            int i33 = iCharAt3 & 8191;
            int i34 = 13;
            while (true) {
                i30 = i32 + 1;
                cCharAt13 = stringInfo.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i30;
            }
            iCharAt3 = i33 | (cCharAt13 << i34);
            i32 = i30;
        }
        if (iCharAt3 == 0) {
            i6 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            iArr = EMPTY_INT_ARRAY;
            i2 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt4 = stringInfo.charAt(i32);
            if (iCharAt4 >= 55296) {
                int i36 = iCharAt4 & 8191;
                int i37 = 13;
                while (true) {
                    i14 = i35 + 1;
                    cCharAt8 = stringInfo.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i14;
                }
                iCharAt4 = i36 | (cCharAt8 << i37);
                i35 = i14;
            }
            int i38 = i35 + 1;
            int iCharAt5 = stringInfo.charAt(i35);
            if (iCharAt5 >= 55296) {
                int i39 = iCharAt5 & 8191;
                int i40 = 13;
                while (true) {
                    i13 = i38 + 1;
                    cCharAt7 = stringInfo.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i13;
                }
                iCharAt5 = i39 | (cCharAt7 << i40);
                i38 = i13;
            }
            int i41 = i38 + 1;
            int iCharAt6 = stringInfo.charAt(i38);
            if (iCharAt6 >= 55296) {
                int i42 = iCharAt6 & 8191;
                int i43 = 13;
                while (true) {
                    i12 = i41 + 1;
                    cCharAt6 = stringInfo.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i12;
                }
                iCharAt6 = i42 | (cCharAt6 << i43);
                i41 = i12;
            }
            int i44 = i41 + 1;
            int iCharAt7 = stringInfo.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i11 = i44 + 1;
                    cCharAt5 = stringInfo.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i11;
                }
                iCharAt7 = i45 | (cCharAt5 << i46);
                i44 = i11;
            }
            int i47 = i44 + 1;
            iCharAt = stringInfo.charAt(i44);
            if (iCharAt >= 55296) {
                int i48 = iCharAt & 8191;
                int i49 = 13;
                while (true) {
                    i10 = i47 + 1;
                    cCharAt4 = stringInfo.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i10;
                }
                iCharAt = i48 | (cCharAt4 << i49);
                i47 = i10;
            }
            int i50 = i47 + 1;
            iCharAt2 = stringInfo.charAt(i47);
            if (iCharAt2 >= 55296) {
                int i51 = iCharAt2 & 8191;
                int i52 = 13;
                while (true) {
                    i9 = i50 + 1;
                    cCharAt3 = stringInfo.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i9;
                }
                iCharAt2 = i51 | (cCharAt3 << i52);
                i50 = i9;
            }
            int i53 = i50 + 1;
            int iCharAt8 = stringInfo.charAt(i50);
            if (iCharAt8 >= 55296) {
                int i54 = iCharAt8 & 8191;
                int i55 = 13;
                while (true) {
                    i8 = i53 + 1;
                    cCharAt2 = stringInfo.charAt(i53);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i55;
                    i55 += 13;
                    i53 = i8;
                }
                iCharAt8 = i54 | (cCharAt2 << i55);
                i53 = i8;
            }
            int i56 = i53 + 1;
            int iCharAt9 = stringInfo.charAt(i53);
            if (iCharAt9 >= 55296) {
                int i57 = iCharAt9 & 8191;
                int i58 = 13;
                while (true) {
                    i7 = i56 + 1;
                    cCharAt = stringInfo.charAt(i56);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i57 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i56 = i7;
                }
                iCharAt9 = i57 | (cCharAt << i58);
                i56 = i7;
            }
            int[] iArr3 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            int i59 = (iCharAt4 * 2) + iCharAt5;
            i2 = iCharAt4;
            i3 = iCharAt9;
            i32 = i56;
            i4 = iCharAt7;
            i5 = iCharAt6;
            i6 = i59;
            iArr = iArr3;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr4 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt * 2];
        int i60 = i3 + iCharAt2;
        int i61 = i3;
        int i62 = i60;
        int i63 = 0;
        int i64 = 0;
        while (i32 < length) {
            int i65 = i32 + 1;
            int iCharAt10 = stringInfo.charAt(i32);
            if (iCharAt10 >= c) {
                int i66 = iCharAt10 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i29 = i67 + 1;
                    cCharAt12 = stringInfo.charAt(i67);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i66 |= (cCharAt12 & 8191) << i68;
                    i68 += 13;
                    i67 = i29;
                }
                iCharAt10 = i66 | (cCharAt12 << i68);
                i15 = i29;
            } else {
                i15 = i65;
            }
            int i69 = i15 + 1;
            int iCharAt11 = stringInfo.charAt(i15);
            if (iCharAt11 >= c) {
                int i70 = iCharAt11 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i28 = i71 + 1;
                    cCharAt11 = stringInfo.charAt(i71);
                    i16 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt11 & 8191) << i72;
                    i72 += 13;
                    i71 = i28;
                    length = i16;
                }
                iCharAt11 = i70 | (cCharAt11 << i72);
                i17 = i28;
            } else {
                i16 = length;
                i17 = i69;
            }
            int i73 = iCharAt11 & 255;
            int i74 = i4;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i64] = i63;
                i64++;
            }
            int i75 = i5;
            if (i73 >= 51) {
                int i76 = i17 + 1;
                int iCharAt12 = stringInfo.charAt(i17);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i77 = iCharAt12 & 8191;
                    int i78 = 13;
                    while (true) {
                        i27 = i76 + 1;
                        cCharAt10 = stringInfo.charAt(i76);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i77 |= (cCharAt10 & 8191) << i78;
                        i78 += 13;
                        i76 = i27;
                        c2 = 55296;
                    }
                    iCharAt12 = i77 | (cCharAt10 << i78);
                    i76 = i27;
                }
                int i79 = i73 - 51;
                int i80 = i76;
                if (i79 == 9 || i79 == 17) {
                    i24 = i6 + 1;
                    objArr[((i63 / 3) * 2) + 1] = objects[i6];
                } else {
                    if (i79 == 12 && (rawMessageInfo.getSyntax().equals(ProtoSyntax.PROTO2) || (iCharAt11 & 2048) != 0)) {
                        i24 = i6 + 1;
                        objArr[((i63 / 3) * 2) + 1] = objects[i6];
                    }
                    i25 = iCharAt12 * 2;
                    obj = objects[i25];
                    if (obj instanceof java.lang.reflect.Field) {
                        fieldReflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i25] = fieldReflectField2;
                    }
                    int iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i26 = i25 + 1;
                    obj2 = objects[i26];
                    int i81 = i6;
                    if (obj2 instanceof java.lang.reflect.Field) {
                        fieldReflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i26] = fieldReflectField3;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    stringInfo = stringInfo;
                    i2 = i2;
                    i18 = i81;
                    i21 = iObjectFieldOffset2;
                    iArr2 = iArr4;
                    i20 = 0;
                    i32 = i80;
                }
                i6 = i24;
                i25 = iCharAt12 * 2;
                obj = objects[i25];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i25] = fieldReflectField2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i26 = i25 + 1;
                obj2 = objects[i26];
                int i82 = i6;
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i26] = fieldReflectField3;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField3);
                stringInfo = stringInfo;
                i2 = i2;
                i18 = i82;
                i21 = iObjectFieldOffset3;
                iArr2 = iArr4;
                i20 = 0;
                i32 = i80;
            } else {
                i18 = i6 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i6]);
                if (i73 == 9 || i73 == 17) {
                    iArr2 = iArr4;
                    objArr[((i63 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i73 == 27 || i73 == 49) {
                        iArr2 = iArr4;
                        i23 = i6 + 2;
                        objArr[((i63 / 3) * 2) + 1] = objects[i18];
                    } else if (i73 == 12 || i73 == 30 || i73 == 44) {
                        iArr2 = iArr4;
                        if (rawMessageInfo.getSyntax() == ProtoSyntax.PROTO2 || (iCharAt11 & 2048) != 0) {
                            i23 = i6 + 2;
                            objArr[((i63 / 3) * 2) + 1] = objects[i18];
                        }
                    } else if (i73 == 50) {
                        i61++;
                        iArr[i61] = i63;
                        int i83 = (i63 / 3) * 2;
                        int i84 = i6 + 2;
                        objArr[i83] = objects[i18];
                        if ((iCharAt11 & 2048) != 0) {
                            i18 = i6 + 3;
                            objArr[i83 + 1] = objects[i84];
                        } else {
                            i18 = i84;
                        }
                        iArr2 = iArr4;
                    } else {
                        iArr2 = iArr4;
                    }
                    i18 = i23;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) == 0 || i73 > 17) {
                    i19 = i17;
                    iObjectFieldOffset = 1048575;
                    i20 = 0;
                } else {
                    int i85 = i17 + 1;
                    int iCharAt13 = stringInfo.charAt(i17);
                    if (iCharAt13 >= 55296) {
                        int i86 = iCharAt13 & 8191;
                        int i87 = 13;
                        while (true) {
                            i22 = i85 + 1;
                            cCharAt9 = stringInfo.charAt(i85);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i86 |= (cCharAt9 & 8191) << i87;
                            i87 += 13;
                            i85 = i22;
                        }
                        iCharAt13 = i86 | (cCharAt9 << i87);
                        i85 = i22;
                    }
                    int i88 = (i2 * 2) + (iCharAt13 / 32);
                    Object obj3 = objects[i88];
                    if (obj3 instanceof java.lang.reflect.Field) {
                        fieldReflectField = (java.lang.reflect.Field) obj3;
                    } else {
                        fieldReflectField = reflectField(cls, (String) obj3);
                        objects[i88] = fieldReflectField;
                    }
                    i19 = i85;
                    i20 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField);
                }
                if (i73 >= 18 && i73 <= 49) {
                    iArr[i62] = iObjectFieldOffset4;
                    i62++;
                }
                i21 = iObjectFieldOffset4;
                i32 = i19;
            }
            iArr2[i63] = iCharAt10;
            iArr2[i63 + 1] = ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? ENFORCE_UTF8_MASK : 0) | ((iCharAt11 & 256) != 0 ? REQUIRED_MASK : 0) | (i73 << 20) | i21;
            iArr2[i63 + 2] = (i20 << 20) | iObjectFieldOffset;
            i2 = i2;
            i63 += 3;
            i6 = i18;
            i4 = i74;
            iArr4 = iArr2;
            length = i16;
            stringInfo = stringInfo;
            i5 = i75;
            c = 55296;
        }
        return new MessageSchema<>(iArr4, objArr, i5, i4, rawMessageInfo.getDefaultInstance(), false, iArr, i3, i60, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int[] iArr;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr2 = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i = 0;
        int i2 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i2++;
            }
        }
        int[] iArr3 = i > 0 ? new int[i] : null;
        int[] iArr4 = i2 > 0 ? new int[i2] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < fields.length) {
            FieldInfo fieldInfo2 = fields[i3];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr2, i4, objArr);
            if (i5 < checkInitialized.length && checkInitialized[i5] == fieldNumber3) {
                checkInitialized[i5] = i4;
                i5++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr3[i6] = i4;
                i6++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    iArr4[i7] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i7++;
                }
                i3++;
                i4 += 3;
            }
            i3++;
            i4 += 3;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        if (iArr4 == null) {
            iArr4 = EMPTY_INT_ARRAY;
        }
        int length2 = checkInitialized.length + iArr3.length + iArr4.length;
        if (length2 > 0) {
            iArr = new int[length2];
            System.arraycopy(checkInitialized, 0, iArr, 0, checkInitialized.length);
            System.arraycopy(iArr3, 0, iArr, checkInitialized.length, iArr3.length);
            System.arraycopy(iArr4, 0, iArr, checkInitialized.length + iArr3.length, iArr4.length);
        } else {
            iArr = EMPTY_INT_ARRAY;
        }
        return new MessageSchema<>(iArr2, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), true, iArr, checkInitialized.length, checkInitialized.length + iArr3.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0077  */
    /* JADX WARN: Code duplicated, block: B:22:0x007a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0081  */
    /* JADX WARN: Code duplicated, block: B:28:0x009d  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, Object[] objArr) {
        int iObjectFieldOffset;
        int iId;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        int i2;
        Class<?> messageFieldClass;
        int i3;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof != null) {
            iId = fieldInfo.getType().id() + 51;
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            iId = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fieldInfo.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
            } else if (fieldInfo.getCachedSizeField() == null) {
                iObjectFieldOffset2 = 0;
                iNumberOfTrailingZeros = 0;
            } else {
                jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
            iArr[i] = fieldInfo.getFieldNumber();
            if (fieldInfo.isEnforceUtf8()) {
                i2 = ENFORCE_UTF8_MASK;
            } else {
                i2 = 0;
            }
            iArr[i + 1] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | i2 | (iId << 20) | iObjectFieldOffset;
            iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            i3 = (i / 3) * 2;
            objArr[i3] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i3 + 1] = messageFieldClass;
            } else if (fieldInfo.getEnumVerifier() != null) {
                objArr[i3 + 1] = fieldInfo.getEnumVerifier();
            }
        }
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        if (fieldInfo.isEnforceUtf8()) {
            i2 = ENFORCE_UTF8_MASK;
        } else {
            i2 = 0;
        }
        iArr[i + 1] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | i2 | (iId << 20) | iObjectFieldOffset;
        iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        messageFieldClass = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
            if (messageFieldClass != null) {
                objArr[((i / 3) * 2) + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i3 = (i / 3) * 2;
        objArr[i3] = fieldInfo.getMapDefaultEntry();
        if (messageFieldClass != null) {
            objArr[i3 + 1] = messageFieldClass;
        } else if (fieldInfo.getEnumVerifier() != null) {
            objArr[i3 + 1] = fieldInfo.getEnumVerifier();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t, t2, i) && Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jOffset));
            case 1:
                return arePresentForEquals(t, t2, i) && Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, jOffset));
            case 2:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 3:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 4:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 5:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 6:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 7:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getBoolean(t, jOffset) == UnsafeUtil.getBoolean(t2, jOffset);
            case 8:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 9:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 10:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 11:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 12:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 13:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 14:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 15:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 16:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 17:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 51:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
            case 63:
            case 64:
            case 65:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 68:
                return isOneofCaseEqual(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            default:
                return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x01c0  */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int iHashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)));
                    i2 = i + iHashLong;
                    break;
                case 1:
                    i = i2 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 2:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 3:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 4:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 5:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 6:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 7:
                    i = i2 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 8:
                    i = i2 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object != null) {
                        iHashLong = object.hashCode();
                    } else {
                        iHashLong = 37;
                    }
                    i = i2 * 53;
                    i2 = i + iHashLong;
                    break;
                case 10:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 11:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 12:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 13:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 14:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 15:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 16:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jOffset);
                    if (object2 != null) {
                        iHashLong = object2.hashCode();
                    } else {
                        iHashLong = 37;
                    }
                    i = i2 * 53;
                    i2 = i + iHashLong;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 50:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jOffset)));
                        i2 = i + iHashLong;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
            }
        }
        int iHashCode = (i2 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (iHashCode * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        checkMutable(t);
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, jOffset, UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, jOffset, UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, jOffset, UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                this.listFieldSchema.mergeListsAt(t, t2, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jOffset);
                break;
            case 51:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
            case 59:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
            case 63:
            case 64:
            case 65:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t, T t2, int i) {
        if (isFieldPresent(t2, i)) {
            long jOffset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isFieldPresent(t, i)) {
                if (!isMutable(object)) {
                    unsafe.putObject(t, jOffset, object);
                } else {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jOffset, objNewInstance);
                }
                setFieldPresent(t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t, T t2, int i) {
        int iNumberAt = numberAt(i);
        if (isOneofPresent(t2, iNumberAt, i)) {
            long jOffset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isOneofPresent(t, iNumberAt, i)) {
                if (!isMutable(object)) {
                    unsafe.putObject(t, jOffset, object);
                } else {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jOffset, objNewInstance);
                }
                setOneofPresent(t, iNumberAt, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:184:0x0406 A[PHI: r12
  0x0406: PHI (r12v4 int) = 
  (r12v1 int)
  (r12v6 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
 binds: [B:21:0x0060, B:183:0x0405, B:161:0x0333, B:155:0x0316, B:149:0x02f9, B:143:0x02dc, B:137:0x02be, B:131:0x02a0, B:125:0x0282, B:119:0x0264, B:113:0x0246, B:107:0x0228, B:101:0x020a, B:95:0x01ec, B:89:0x01ce, B:83:0x01b0, B:78:0x017c, B:75:0x016f, B:72:0x015f, B:69:0x014f, B:66:0x013f, B:63:0x0133, B:60:0x0127, B:57:0x011b, B:51:0x00fd, B:48:0x00e9, B:45:0x00d7, B:42:0x00c7, B:39:0x00b7, B:36:0x00ab, B:33:0x009f, B:30:0x008f, B:27:0x007f, B:24:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v205 */
    /* JADX WARN: Type inference failed for: r0v213 */
    /* JADX WARN: Type inference failed for: r0v216 */
    /* JADX WARN: Type inference failed for: r0v217 */
    /* JADX WARN: Type inference failed for: r0v218 */
    /* JADX WARN: Type inference failed for: r0v219 */
    /* JADX WARN: Type inference failed for: r0v220 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int getSerializedSize(T t) {
        ?? r14;
        int i;
        ?? r17;
        ?? r5;
        ?? r15;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeSizeFixed32List;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        int i2;
        ?? r0;
        ?? r1;
        Unsafe unsafe = UNSAFE;
        int i3 = 1048575;
        ?? r10 = 0;
        int i4 = 1048575;
        ?? r2 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i5);
            int i7 = this.buffer[i5 + 2];
            int i8 = i7 & i3;
            if (iType <= 17) {
                if (i8 != i4) {
                    if (i8 == i3) {
                        r1 = r10;
                    } else {
                        r1 = unsafe.getInt(t, i8 == true ? 1L : 0L);
                    }
                    i2 = i8 == true ? 1 : 0;
                    r0 = r1;
                }
                r14 = r0;
                i = i2;
                r17 = 1 << (i7 >>> 20);
            } else {
                r0 = r2;
                i2 = i4;
                r14 = r2;
                i = i4 == true ? 1 : 0;
                r17 = r10;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            if (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) {
                r5 = i8;
                r5 = r10;
            }
            r5 = i8;
            ?? r3 = r5;
            switch (iType) {
                case 0:
                    r15 = r10;
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        r15 = r15;
                        i6 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    r15 = r10;
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        r15 = r15;
                        i6 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    r15 = r10;
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        r15 = r15;
                        i6 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    r15 = r10;
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        r15 = r15;
                        i6 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    r15 = r10;
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        r15 = r15;
                        i6 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    r15 = r10;
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        r15 = r15;
                        i6 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (!isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        r15 = 0;
                    } else {
                        r15 = 0;
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i6 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 8:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        Object object = unsafe.getObject(t, jOffset);
                        if (object instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 9:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 10:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 11:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 12:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 13:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 14:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 15:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 16:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 17:
                    if (isFieldPresent(t, i5, i == true ? 1 : 0, r14 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                    }
                    r15 = 0;
                    break;
                case 18:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeBoolSize;
                    r15 = 0;
                    break;
                case 19:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 20:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 21:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 22:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 23:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 24:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 25:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 26:
                    iComputeBoolSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i6 += iComputeBoolSize;
                    r15 = 0;
                    break;
                case 27:
                    iComputeBoolSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    i6 += iComputeBoolSize;
                    r15 = 0;
                    break;
                case 28:
                    iComputeBoolSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i6 += iComputeBoolSize;
                    r15 = 0;
                    break;
                case 29:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeBoolSize;
                    r15 = 0;
                    break;
                case 30:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 31:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 32:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 33:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 34:
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), r10);
                    i6 += iComputeSizeFixed32List;
                    r15 = r10;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        r15 = r10;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, r3 == true ? 1L : 0L, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBoolSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iComputeBoolSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    i6 += iComputeBoolSize;
                    r15 = 0;
                    break;
                case 50:
                    iComputeBoolSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i5));
                    i6 += iComputeBoolSize;
                    r15 = 0;
                    break;
                case 51:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 52:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 54:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 56:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 57:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeFixed32Size(iNumberAt, r10);
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 59:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        Object object2 = unsafe.getObject(t, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 60:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 63:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 64:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, r10);
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 65:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                case 68:
                    if (!isOneofPresent(t, iNumberAt, i5)) {
                        r15 = r10;
                    } else {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                        r15 = 0;
                    }
                    break;
                default:
                    r15 = r10;
                    break;
            }
            i5 += 3;
            r2 = r14;
            r10 = r15;
            i4 = i;
            i3 = 1048575;
        }
        int unknownFieldsSerializedSize = i6 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else {
            writeFieldsInAscendingOrder(t, writer);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    private void writeFieldsInAscendingOrder(T t, Writer writer) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it2;
        int i;
        int i2;
        int i3;
        Map.Entry<?, ?> entry2;
        Iterator it3;
        int i4;
        boolean z;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                entry = null;
                it2 = null;
            } else {
                Iterator it4 = extensions.iterator();
                entry = (Map.Entry) it4.next();
                it2 = it4;
            }
        } else {
            entry = null;
            it2 = null;
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i5 = 1048575;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i8);
            int iNumberAt = numberAt(i8);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i9 = this.buffer[i8 + 2];
                int i10 = i9 & i5;
                if (i10 != i6) {
                    i7 = i10 == i5 ? 0 : unsafe.getInt(t, i10);
                    i6 = i10;
                }
                int i11 = 1 << (i9 >>> 20);
                i = i6;
                i3 = i11;
                i2 = i7;
            } else {
                i = i6;
                i2 = i7;
                i3 = 0;
            }
            Map.Entry<?, ?> entry3 = entry;
            while (entry3 != null && this.extensionSchema.extensionNumber(entry3) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry3);
                entry3 = it2.hasNext() ? (Map.Entry) it2.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, jOffset));
                    }
                    break;
                case 1:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeFloat(iNumberAt, floatAt(t, jOffset));
                    }
                    break;
                case 2:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 3:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 4:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 5:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 6:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 7:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeBool(iNumberAt, booleanAt(t, jOffset));
                    }
                    break;
                case 8:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 9:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i8));
                    }
                    break;
                case 10:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 11:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 12:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 13:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 14:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 15:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 16:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 17:
                    entry2 = entry3;
                    if (isFieldPresent(t, i8, i, i2, i3)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i8));
                    }
                    it3 = it2;
                    i4 = length;
                    break;
                case 18:
                    z = false;
                    SchemaUtil.writeDoubleList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 19:
                    z = false;
                    SchemaUtil.writeFloatList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 20:
                    z = false;
                    SchemaUtil.writeInt64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 21:
                    z = false;
                    SchemaUtil.writeUInt64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 22:
                    z = false;
                    SchemaUtil.writeInt32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 23:
                    z = false;
                    SchemaUtil.writeFixed64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 24:
                    z = false;
                    SchemaUtil.writeFixed32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 25:
                    z = false;
                    SchemaUtil.writeBoolList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i8));
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 29:
                    z = false;
                    SchemaUtil.writeUInt32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 30:
                    z = false;
                    SchemaUtil.writeEnumList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 31:
                    z = false;
                    SchemaUtil.writeSFixed32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 32:
                    z = false;
                    SchemaUtil.writeSFixed64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 33:
                    z = false;
                    SchemaUtil.writeSInt32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 34:
                    z = false;
                    SchemaUtil.writeSInt64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, false);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, true);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    SchemaUtil.writeGroupList(numberAt(i8), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i8));
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t, jOffset), i8);
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i8));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i8)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i8));
                    }
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
                default:
                    entry2 = entry3;
                    it3 = it2;
                    i4 = length;
                    break;
            }
            i8 += 3;
            i6 = i;
            i7 = i2;
            entry = entry2;
            it2 = it3;
            length = i4;
            i5 = 1048575;
        }
        Iterator it5 = it2;
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it5.hasNext() ? (Map.Entry) it5.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void writeFieldsInDescendingOrder(T t, Writer writer) throws IOException {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        } else {
            itDescendingIterator = null;
            entry = null;
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, length)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        checkMutable(t);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    /* JADX WARN: Code duplicated, block: B:168:0x0650 A[Catch: all -> 0x0643, TRY_LEAVE, TryCatch #0 {all -> 0x0643, blocks: (B:154:0x061d, B:166:0x064a, B:168:0x0650, B:178:0x0678, B:179:0x067d), top: B:203:0x061d }] */
    /* JADX WARN: Code duplicated, block: B:173:0x065d A[LOOP:3: B:171:0x0659->B:173:0x065d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:175:0x0672  */
    /* JADX WARN: Code duplicated, block: B:177:0x0676 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:178:0x0678 A[Catch: all -> 0x0643, TRY_ENTER, TryCatch #0 {all -> 0x0643, blocks: (B:154:0x061d, B:166:0x064a, B:168:0x0650, B:178:0x0678, B:179:0x067d), top: B:203:0x061d }] */
    /* JADX WARN: Code duplicated, block: B:184:0x068a A[LOOP:4: B:182:0x0686->B:184:0x068a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:186:0x069f  */
    /* JADX WARN: Code duplicated, block: B:196:0x06b9 A[LOOP:2: B:194:0x06b5->B:196:0x06b9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:198:0x06ce  */
    /* JADX WARN: Code duplicated, block: B:226:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x0683 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.crypto.tink.shaded.protobuf.Reader] */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        Object obj;
        T t2;
        UnknownFieldSchema unknownFieldSchema2;
        int i;
        Object objFilterMapUnknownEnumValues;
        T t3;
        ExtensionRegistryLite extensionRegistryLite2;
        int i2;
        Object objFilterMapUnknownEnumValues2;
        int i3;
        Object objFilterMapUnknownEnumValues3;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t4 = t;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        Object builderFromMessage = null;
        FieldSet mutableExtensions = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    t2 = t4;
                    try {
                        int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                        try {
                            switch (type(iTypeAndOffsetAt)) {
                                case 0:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putDouble(t2, offset(iTypeAndOffsetAt), reader.readDouble());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 1:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putFloat(t2, offset(iTypeAndOffsetAt), reader.readFloat());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 2:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readInt64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 3:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readUInt64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 4:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readInt32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 5:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readFixed64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 6:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readFixed32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 7:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putBoolean(t2, offset(iTypeAndOffsetAt), reader.readBool());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 8:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readString(t2, iTypeAndOffsetAt, reader);
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 9:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeMessageField(t2, iPositionForFieldNumber, messageLite);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 10:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 11:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readUInt32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 12:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    int i4 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i4)) {
                                        UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), i4);
                                        setFieldPresent(t2, iPositionForFieldNumber);
                                        builderFromMessage = obj;
                                    } else {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i4, obj, unknownFieldSchema2);
                                    }
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 13:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readSFixed32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 14:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readSFixed64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 15:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readSInt32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 16:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readSInt64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 17:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeMessageField(t2, iPositionForFieldNumber, messageLite2);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 18:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 19:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 20:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 21:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 22:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 23:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 24:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 25:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 26:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readStringList(t2, iTypeAndOffsetAt, reader);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 27:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readMessageList(t, iTypeAndOffsetAt, reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 28:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 29:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 30:
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List listMutableListAt = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, (List<Integer>) listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 31:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 32:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 33:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 34:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 35:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 36:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 37:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 38:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 39:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 40:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 41:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 42:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 43:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 44:
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt2);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, (List<Integer>) listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 45:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 46:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 47:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 48:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readGroupList(t, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 50:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    try {
                                        mergeMap(t, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite, reader);
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                for (i2 = this.checkInitializedCount; i2 < this.repeatedFieldOffsetStart; i2++) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            for (i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 51:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Double.valueOf(reader.readDouble()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 52:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Float.valueOf(reader.readFloat()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readInt64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 54:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readUInt64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readInt32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 56:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readFixed64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 57:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readFixed32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Boolean.valueOf(reader.readBool()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 59:
                                    readString(t2, iTypeAndOffsetAt, reader);
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 60:
                                    MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite3, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                    storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite3);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readUInt32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 63:
                                    int i5 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier2 == null || enumFieldVerifier2.isInRange(i5)) {
                                        UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(i5));
                                        setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                        obj = builderFromMessage;
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                    } else {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i5, builderFromMessage, unknownFieldSchema3);
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                    }
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 64:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSFixed32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 65:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSFixed64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSInt32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSInt64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 68:
                                    try {
                                        MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                        reader.mergeGroupField(messageLite4, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                        storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite4);
                                        obj = builderFromMessage;
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                while (i2 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            while (i3 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        while (i < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                default:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    if (obj == null) {
                                        try {
                                            builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                            builderFromMessage = obj;
                                            if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    while (i2 < this.repeatedFieldOffsetStart) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                while (i3 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                    return;
                                                }
                                                return;
                                            }
                                            extensionRegistryLite3 = extensionRegistryLite2;
                                            unknownFieldSchema3 = unknownFieldSchema2;
                                            t4 = t2;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            builderFromMessage = obj;
                                        }
                                    } else {
                                        builderFromMessage = obj;
                                    }
                                    try {
                                        try {
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                Object objFilterMapUnknownEnumValues4 = builderFromMessage;
                                                for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                                    objFilterMapUnknownEnumValues4 = filterMapUnknownEnumValues(t, this.intArray[i6], objFilterMapUnknownEnumValues4, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues4 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues4);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                            if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    while (i2 < this.repeatedFieldOffsetStart) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                while (i3 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                        t4 = t2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                    break;
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                            obj = builderFromMessage;
                            extensionRegistryLite2 = extensionRegistryLite3;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        obj = builderFromMessage;
                    }
                } else {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        Object objFilterMapUnknownEnumValues5 = builderFromMessage;
                        for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                            objFilterMapUnknownEnumValues5 = filterMapUnknownEnumValues(t, this.intArray[i7], objFilterMapUnknownEnumValues5, unknownFieldSchema, t);
                        }
                        if (objFilterMapUnknownEnumValues5 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t4, objFilterMapUnknownEnumValues5);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objFindExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite3, this.defaultInstance, fieldNumber);
                        if (objFindExtensionByNumber != null) {
                            if (mutableExtensions == null) {
                                mutableExtensions = extensionSchema.getMutableExtensions(t);
                            }
                            FieldSet fieldSet = mutableExtensions;
                            t3 = t4;
                            try {
                                mutableExtensions = fieldSet;
                                builderFromMessage = extensionSchema.parseExtension(t, reader, objFindExtensionByNumber, extensionRegistryLite, fieldSet, builderFromMessage, unknownFieldSchema);
                            } catch (Throwable th6) {
                                th = th6;
                                t2 = t3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                objFilterMapUnknownEnumValues = builderFromMessage;
                                while (i < this.repeatedFieldOffsetStart) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                        } else {
                            t3 = t4;
                            if (!unknownFieldSchema3.shouldDiscardUnknownFields(reader)) {
                                if (builderFromMessage == null) {
                                    builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t3);
                                }
                                mutableExtensions = mutableExtensions;
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                }
                            } else if (reader.skipField()) {
                                mutableExtensions = mutableExtensions;
                            }
                        }
                        t4 = t3;
                    } catch (Throwable th7) {
                        th = th7;
                        t2 = t4;
                        obj = builderFromMessage;
                        unknownFieldSchema2 = unknownFieldSchema3;
                        builderFromMessage = obj;
                        objFilterMapUnknownEnumValues = builderFromMessage;
                        while (i < this.repeatedFieldOffsetStart) {
                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                        }
                        if (objFilterMapUnknownEnumValues != null) {
                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                obj = builderFromMessage;
                t2 = t4;
            }
            objFilterMapUnknownEnumValues = builderFromMessage;
            while (i < this.repeatedFieldOffsetStart) {
                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
            }
            if (objFilterMapUnknownEnumValues != null) {
                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
            }
            throw th;
        }
        int i8 = this.checkInitializedCount;
        Object objFilterMapUnknownEnumValues6 = builderFromMessage;
        while (i8 < this.repeatedFieldOffsetStart) {
            objFilterMapUnknownEnumValues6 = filterMapUnknownEnumValues(t, this.intArray[i8], objFilterMapUnknownEnumValues6, unknownFieldSchema, t);
            i8++;
            t3 = t3;
        }
        T t5 = t3;
        if (objFilterMapUnknownEnumValues6 != null) {
            unknownFieldSchema3.setBuilderToMessage(t5, objFilterMapUnknownEnumValues6);
        }
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint65;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint33;
            case 16:
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint66;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32;
        int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint33) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint33 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint33 < i4) {
            int i5 = iDecodeVarint33 + 1;
            int i6 = bArr[iDecodeVarint33];
            if (i6 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i6, bArr, i5, registers);
                i6 = registers.int1;
            } else {
                iDecodeVarint32 = i5;
            }
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i7 == 1) {
                if (i8 == metadata.keyType.getWireType()) {
                    iDecodeVarint33 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    iDecodeVarint33 = ArrayDecoders.skipField(i6, bArr, iDecodeVarint32, i2, registers);
                }
            } else if (i7 == 2 && i8 == metadata.valueType.getWireType()) {
                iDecodeVarint33 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                obj2 = registers.object1;
            } else {
                iDecodeVarint33 = ArrayDecoders.skipField(i6, bArr, iDecodeVarint32, i2, registers);
            }
        }
        if (iDecodeVarint33 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(protobufListMutableCopyWithCapacity2.size() * 2);
            unsafe.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 1 ? ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 5 ? ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 1 ? ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 5 ? ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 26:
                if (i5 != 2) {
                    return i;
                }
                if ((j & 536870912) == 0) {
                    return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
            case 27:
                return i5 == 2 ? ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 28:
                return i5 == 2 ? ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 30:
            case 44:
                if (i5 == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                } else {
                    if (i5 != 0) {
                        return i;
                    }
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) t, i4, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(i6), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return i5 == 3 ? ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            default:
                return i;
        }
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, j, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i9 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i10 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i10;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(registers.long1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint64;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i12;
            case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint65;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i13 = registers.int1;
                if (i13 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint33, iDecodeVarint33 + i13)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t, j, new String(bArr, iDecodeVarint33, i13, Internal.UTF_8));
                    iDecodeVarint33 += i13;
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint33;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t, i4, i8);
                int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i8), bArr, i, i2, registers);
                storeOneofMessageField(t, i4, i8, objMutableOneofMessageFieldForMerge);
                return iMergeMessageField;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t, j, registers.object1);
                unsafe.putInt(t, j2, i4);
                return iDecodeBytes;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint34 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                    unsafe.putObject(t, j, Integer.valueOf(i14));
                    unsafe.putInt(t, j2, i4);
                } else {
                    getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                }
                return iDecodeVarint34;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint35 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint35;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint66;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t, i4, i8);
                int iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                storeOneofMessageField(t, i4, i8, objMutableOneofMessageFieldForMerge2);
                return iMergeGroupField;
            default:
                return i;
        }
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:128:0x03e5 A[PHI: r1 r15 r18 r28
  0x03e5: PHI (r1v19 int) = (r1v16 int), (r1v18 int), (r1v21 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399] A[DONT_GENERATE, DONT_INLINE]
  0x03e5: PHI (r15v7 int) = (r15v6 int), (r15v6 int), (r15v8 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399] A[DONT_GENERATE, DONT_INLINE]
  0x03e5: PHI (r18v2 int) = (r18v1 int), (r18v1 int), (r18v3 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399] A[DONT_GENERATE, DONT_INLINE]
  0x03e5: PHI (r28v6 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:129:0x03f4 A[PHI: r1 r15 r18 r20 r21 r22 r28
  0x03f4: PHI (r1v22 int) = (r1v16 int), (r1v18 int), (r1v21 int), (r1v23 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399, B:125:0x03c9] A[DONT_GENERATE, DONT_INLINE]
  0x03f4: PHI (r15v9 int) = (r15v6 int), (r15v6 int), (r15v8 int), (r15v10 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399, B:125:0x03c9] A[DONT_GENERATE, DONT_INLINE]
  0x03f4: PHI (r18v4 int) = (r18v1 int), (r18v1 int), (r18v3 int), (r18v5 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399, B:125:0x03c9] A[DONT_GENERATE, DONT_INLINE]
  0x03f4: PHI (r20v4 int) = (r20v3 int), (r20v3 int), (r20v3 int), (r20v5 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399, B:125:0x03c9] A[DONT_GENERATE, DONT_INLINE]
  0x03f4: PHI (r21v4 int) = (r21v3 int), (r21v3 int), (r21v3 int), (r21v5 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399, B:125:0x03c9] A[DONT_GENERATE, DONT_INLINE]
  0x03f4: PHI (r22v2 int) = (r22v1 int), (r22v1 int), (r22v1 int), (r22v3 int) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399, B:125:0x03c9] A[DONT_GENERATE, DONT_INLINE]
  0x03f4: PHI (r28v8 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe), (r28v9 sun.misc.Unsafe) binds: [B:127:0x03e3, B:123:0x03c6, B:116:0x0399, B:125:0x03c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:166:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x01b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x021a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x023c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x0262 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x027e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x02b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x02cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x012a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x01a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x020b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x026f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x02bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x024e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:0x024e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x02e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x02e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x024e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x01be  */
    /* JADX WARN: Code duplicated, block: B:61:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:69:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f9  */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0098. Please report as an issue. */
    int parseMessage(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i4;
        MessageSchema<T> messageSchema;
        int i5;
        int i6;
        int i7;
        T t2;
        int i8;
        int iPositionForFieldNumber;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        ArrayDecoders.Registers registers2;
        int i15;
        MessageSchema<T> messageSchema2;
        int i16;
        int i17;
        int i18;
        int i19;
        int oneofField;
        int i20;
        int i21;
        int i22;
        int i23;
        byte b;
        byte[] bArr2;
        int i24;
        byte[] bArr3;
        int i25;
        byte[] bArr4;
        int iDecodeVarint64;
        byte[] bArr5;
        byte[] bArr6;
        int i26;
        boolean z;
        int i27;
        int i28;
        MessageSchema<T> messageSchema3 = this;
        T t3 = t;
        byte[] bArr7 = bArr;
        int i29 = i2;
        int i30 = i3;
        ArrayDecoders.Registers registers3 = registers;
        checkMutable(t);
        Unsafe unsafe2 = UNSAFE;
        int iDecodeUnknownField = i;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = -1;
        int i35 = 1048575;
        while (true) {
            if (iDecodeUnknownField < i29) {
                int i36 = iDecodeUnknownField + 1;
                byte b2 = bArr7[iDecodeUnknownField];
                if (b2 < 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(b2, bArr7, i36, registers3);
                    i8 = registers3.int1;
                    i36 = iDecodeVarint32;
                } else {
                    i8 = b2;
                }
                int i37 = i8 >>> 3;
                int i38 = i8 & 7;
                if (i37 > i34) {
                    iPositionForFieldNumber = messageSchema3.positionForFieldNumber(i37, i32 / 3);
                } else {
                    iPositionForFieldNumber = messageSchema3.positionForFieldNumber(i37);
                }
                int i39 = iPositionForFieldNumber;
                if (i39 == -1) {
                    i9 = i37;
                    i6 = i8;
                    i10 = i35;
                    i11 = i33;
                    unsafe = unsafe2;
                    i12 = i30;
                    i13 = 0;
                    i14 = i36;
                } else {
                    int i40 = messageSchema3.buffer[i39 + 1];
                    int iType = type(i40);
                    long jOffset = offset(i40);
                    int i41 = i36;
                    int i42 = i8;
                    if (iType <= 17) {
                        int i43 = messageSchema3.buffer[i39 + 2];
                        int i44 = 1 << (i43 >>> 20);
                        int i45 = i43 & 1048575;
                        if (i45 != i35) {
                            if (i35 != 1048575) {
                                unsafe2.putInt(t3, i35, i33);
                            }
                            if (i45 == 1048575) {
                                i21 = i45;
                                i11 = 0;
                            } else {
                                i33 = unsafe2.getInt(t3, i45);
                                i21 = i45;
                            }
                            switch (iType) {
                                case 0:
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i24 = i42;
                                    b = -1;
                                    bArr3 = bArr;
                                    if (i38 == 1) {
                                        UnsafeUtil.putDouble(t3, jOffset, ArrayDecoders.decodeDouble(bArr3, i23));
                                        i25 = i23 + 8;
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i35 = i21;
                                        i34 = i9;
                                        int i46 = i24;
                                        bArr7 = bArr3;
                                        iDecodeUnknownField = i25;
                                        i31 = i46;
                                    } else {
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 1:
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i24 = i42;
                                    b = -1;
                                    bArr3 = bArr;
                                    if (i38 == 5) {
                                        UnsafeUtil.putFloat(t3, jOffset, ArrayDecoders.decodeFloat(bArr3, i23));
                                        i25 = i23 + 4;
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i35 = i21;
                                        i34 = i9;
                                        int i47 = i24;
                                        bArr7 = bArr3;
                                        iDecodeUnknownField = i25;
                                        i31 = i47;
                                    } else {
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    bArr4 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i24 = i42;
                                    b = -1;
                                    if (i38 == 0) {
                                        iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr4, i23, registers3);
                                        bArr5 = bArr4;
                                        unsafe2.putLong(t, jOffset, registers3.long1);
                                        i30 = i3;
                                        i32 = i22;
                                        i31 = i24;
                                        i35 = i21;
                                        i34 = i9;
                                        bArr7 = bArr5;
                                        int i48 = iDecodeVarint64;
                                        i33 = i11 | i44;
                                        iDecodeUnknownField = i48;
                                    } else {
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    bArr4 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i24 = i42;
                                    b = -1;
                                    if (i38 == 0) {
                                        int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr4, i23, registers3);
                                        unsafe2.putInt(t3, jOffset, registers3.int1);
                                        i25 = iDecodeVarint33;
                                        bArr3 = bArr4;
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i35 = i21;
                                        i34 = i9;
                                        int i49 = i24;
                                        bArr7 = bArr3;
                                        iDecodeUnknownField = i25;
                                        i31 = i49;
                                    } else {
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i26 = i42;
                                    b = -1;
                                    if (i38 == 1) {
                                        i24 = i26;
                                        unsafe2.putLong(t, jOffset, ArrayDecoders.decodeFixed64(bArr6, i23));
                                        bArr3 = bArr6;
                                        i25 = i23 + 8;
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i35 = i21;
                                        i34 = i9;
                                        int i410 = i24;
                                        bArr7 = bArr3;
                                        iDecodeUnknownField = i25;
                                        i31 = i410;
                                    } else {
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i26 = i42;
                                    b = -1;
                                    if (i38 == 5) {
                                        unsafe2.putInt(t3, jOffset, ArrayDecoders.decodeFixed32(bArr6, i23));
                                        iDecodeUnknownField = i23 + 4;
                                        i11 |= i44;
                                        i25 = iDecodeUnknownField;
                                        i24 = i26;
                                        bArr3 = bArr6;
                                        i33 = i11;
                                        i30 = i3;
                                        i32 = i22;
                                        i35 = i21;
                                        i34 = i9;
                                        int i411 = i24;
                                        bArr7 = bArr3;
                                        iDecodeUnknownField = i25;
                                        i31 = i411;
                                    } else {
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 7:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i26 = i42;
                                    b = -1;
                                    if (i38 == 0) {
                                        iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr6, i23, registers3);
                                        if (registers3.long1 != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        UnsafeUtil.putBoolean(t3, jOffset, z);
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i31 = i26;
                                        bArr7 = bArr6;
                                        i32 = i22;
                                        i35 = i21;
                                        i34 = i9;
                                    } else {
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 8:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i27 = i42;
                                    b = -1;
                                    if (i38 == 2) {
                                        if (isEnforceUtf8(i40)) {
                                            iDecodeUnknownField = ArrayDecoders.decodeStringRequireUtf8(bArr6, i23, registers3);
                                        } else {
                                            iDecodeUnknownField = ArrayDecoders.decodeString(bArr6, i23, registers3);
                                        }
                                        unsafe2.putObject(t3, jOffset, registers3.object1);
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i31 = i27;
                                        i34 = i9;
                                        bArr7 = bArr6;
                                        i35 = i21;
                                    } else {
                                        i26 = i27;
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 9:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i27 = i42;
                                    b = -1;
                                    if (i38 == 2) {
                                        Object objMutableMessageFieldForMerge = messageSchema3.mutableMessageFieldForMerge(t3, i22);
                                        iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema3.getMessageFieldSchema(i22), bArr, i23, i2, registers);
                                        messageSchema3.storeMessageField(t3, i22, objMutableMessageFieldForMerge);
                                        bArr6 = bArr6;
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i31 = i27;
                                        i34 = i9;
                                        bArr7 = bArr6;
                                        i35 = i21;
                                    } else {
                                        i26 = i27;
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 10:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i27 = i42;
                                    b = -1;
                                    if (i38 == 2) {
                                        iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr6, i23, registers3);
                                        unsafe2.putObject(t3, jOffset, registers3.object1);
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i31 = i27;
                                        i34 = i9;
                                        bArr7 = bArr6;
                                        i35 = i21;
                                    } else {
                                        i26 = i27;
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 12:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i27 = i42;
                                    b = -1;
                                    if (i38 == 0) {
                                        iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr6, i23, registers3);
                                        i28 = registers3.int1;
                                        Internal.EnumVerifier enumFieldVerifier = messageSchema3.getEnumFieldVerifier(i22);
                                        if (isLegacyEnumIsClosed(i40) || enumFieldVerifier == null || enumFieldVerifier.isInRange(i28)) {
                                            unsafe2.putInt(t3, jOffset, i28);
                                            i33 = i11 | i44;
                                            i30 = i3;
                                            i32 = i22;
                                            i31 = i27;
                                            i34 = i9;
                                            bArr7 = bArr6;
                                            i35 = i21;
                                        } else {
                                            getMutableUnknownFields(t).storeField(i27, Long.valueOf(i28));
                                            i26 = i27;
                                            i25 = iDecodeUnknownField;
                                            i24 = i26;
                                            bArr3 = bArr6;
                                            i33 = i11;
                                            i30 = i3;
                                            i32 = i22;
                                            i35 = i21;
                                            i34 = i9;
                                            int i412 = i24;
                                            bArr7 = bArr3;
                                            iDecodeUnknownField = i25;
                                            i31 = i412;
                                        }
                                    } else {
                                        i26 = i27;
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 15:
                                    bArr6 = bArr;
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i27 = i42;
                                    b = -1;
                                    if (i38 == 0) {
                                        iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr6, i23, registers3);
                                        unsafe2.putInt(t3, jOffset, CodedInputStream.decodeZigZag32(registers3.int1));
                                        i33 = i11 | i44;
                                        i30 = i3;
                                        i32 = i22;
                                        i31 = i27;
                                        i34 = i9;
                                        bArr7 = bArr6;
                                        i35 = i21;
                                    } else {
                                        i26 = i27;
                                        i24 = i26;
                                        bArr2 = bArr6;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 16:
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i24 = i42;
                                    b = -1;
                                    if (i38 == 0) {
                                        bArr5 = bArr;
                                        iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr5, i23, registers3);
                                        unsafe2.putLong(t, jOffset, CodedInputStream.decodeZigZag64(registers3.long1));
                                        i30 = i3;
                                        i32 = i22;
                                        i31 = i24;
                                        i35 = i21;
                                        i34 = i9;
                                        bArr7 = bArr5;
                                        int i413 = iDecodeVarint64;
                                        i33 = i11 | i44;
                                        iDecodeUnknownField = i413;
                                    } else {
                                        bArr2 = bArr;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                case 17:
                                    if (i38 == 3) {
                                        Object objMutableMessageFieldForMerge2 = messageSchema3.mutableMessageFieldForMerge(t3, i39);
                                        i9 = i37;
                                        i16 = i42;
                                        iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema3.getMessageFieldSchema(i39), bArr, i41, i2, (i37 << 3) | 4, registers);
                                        messageSchema3.storeMessageField(t3, i39, objMutableMessageFieldForMerge2);
                                        i33 = i11 | i44;
                                        i20 = i39;
                                        i35 = i21;
                                        i30 = i3;
                                        i31 = i16;
                                        i32 = i20;
                                        i34 = i9;
                                        bArr7 = bArr;
                                    } else {
                                        i9 = i37;
                                        i22 = i39;
                                        i23 = i41;
                                        b = -1;
                                        bArr2 = bArr;
                                        i24 = i42;
                                        i12 = i3;
                                        i14 = i23;
                                        i13 = i22;
                                        unsafe = unsafe2;
                                        i6 = i24;
                                        i10 = i21;
                                    }
                                    break;
                                default:
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    i24 = i42;
                                    b = -1;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                    break;
                            }
                        } else {
                            i21 = i35;
                        }
                        i11 = i33;
                        switch (iType) {
                            case 0:
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i24 = i42;
                                b = -1;
                                bArr3 = bArr;
                                if (i38 == 1) {
                                    UnsafeUtil.putDouble(t3, jOffset, ArrayDecoders.decodeDouble(bArr3, i23));
                                    i25 = i23 + 8;
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i35 = i21;
                                    i34 = i9;
                                    int i414 = i24;
                                    bArr7 = bArr3;
                                    iDecodeUnknownField = i25;
                                    i31 = i414;
                                } else {
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 1:
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i24 = i42;
                                b = -1;
                                bArr3 = bArr;
                                if (i38 == 5) {
                                    UnsafeUtil.putFloat(t3, jOffset, ArrayDecoders.decodeFloat(bArr3, i23));
                                    i25 = i23 + 4;
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i35 = i21;
                                    i34 = i9;
                                    int i415 = i24;
                                    bArr7 = bArr3;
                                    iDecodeUnknownField = i25;
                                    i31 = i415;
                                } else {
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr4 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i24 = i42;
                                b = -1;
                                if (i38 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr4, i23, registers3);
                                    bArr5 = bArr4;
                                    unsafe2.putLong(t, jOffset, registers3.long1);
                                    i30 = i3;
                                    i32 = i22;
                                    i31 = i24;
                                    i35 = i21;
                                    i34 = i9;
                                    bArr7 = bArr5;
                                    int i416 = iDecodeVarint64;
                                    i33 = i11 | i44;
                                    iDecodeUnknownField = i416;
                                } else {
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr4 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i24 = i42;
                                b = -1;
                                if (i38 == 0) {
                                    int iDecodeVarint34 = ArrayDecoders.decodeVarint32(bArr4, i23, registers3);
                                    unsafe2.putInt(t3, jOffset, registers3.int1);
                                    i25 = iDecodeVarint34;
                                    bArr3 = bArr4;
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i35 = i21;
                                    i34 = i9;
                                    int i417 = i24;
                                    bArr7 = bArr3;
                                    iDecodeUnknownField = i25;
                                    i31 = i417;
                                } else {
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i26 = i42;
                                b = -1;
                                if (i38 == 1) {
                                    i24 = i26;
                                    unsafe2.putLong(t, jOffset, ArrayDecoders.decodeFixed64(bArr6, i23));
                                    bArr3 = bArr6;
                                    i25 = i23 + 8;
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i35 = i21;
                                    i34 = i9;
                                    int i418 = i24;
                                    bArr7 = bArr3;
                                    iDecodeUnknownField = i25;
                                    i31 = i418;
                                } else {
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i26 = i42;
                                b = -1;
                                if (i38 == 5) {
                                    unsafe2.putInt(t3, jOffset, ArrayDecoders.decodeFixed32(bArr6, i23));
                                    iDecodeUnknownField = i23 + 4;
                                    i11 |= i44;
                                    i25 = iDecodeUnknownField;
                                    i24 = i26;
                                    bArr3 = bArr6;
                                    i33 = i11;
                                    i30 = i3;
                                    i32 = i22;
                                    i35 = i21;
                                    i34 = i9;
                                    int i419 = i24;
                                    bArr7 = bArr3;
                                    iDecodeUnknownField = i25;
                                    i31 = i419;
                                } else {
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 7:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i26 = i42;
                                b = -1;
                                if (i38 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr6, i23, registers3);
                                    if (registers3.long1 != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    UnsafeUtil.putBoolean(t3, jOffset, z);
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i31 = i26;
                                    bArr7 = bArr6;
                                    i32 = i22;
                                    i35 = i21;
                                    i34 = i9;
                                } else {
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 8:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i27 = i42;
                                b = -1;
                                if (i38 == 2) {
                                    if (isEnforceUtf8(i40)) {
                                        iDecodeUnknownField = ArrayDecoders.decodeStringRequireUtf8(bArr6, i23, registers3);
                                    } else {
                                        iDecodeUnknownField = ArrayDecoders.decodeString(bArr6, i23, registers3);
                                    }
                                    unsafe2.putObject(t3, jOffset, registers3.object1);
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i31 = i27;
                                    i34 = i9;
                                    bArr7 = bArr6;
                                    i35 = i21;
                                } else {
                                    i26 = i27;
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 9:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i27 = i42;
                                b = -1;
                                if (i38 == 2) {
                                    Object objMutableMessageFieldForMerge3 = messageSchema3.mutableMessageFieldForMerge(t3, i22);
                                    iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge3, messageSchema3.getMessageFieldSchema(i22), bArr, i23, i2, registers);
                                    messageSchema3.storeMessageField(t3, i22, objMutableMessageFieldForMerge3);
                                    bArr6 = bArr6;
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i31 = i27;
                                    i34 = i9;
                                    bArr7 = bArr6;
                                    i35 = i21;
                                } else {
                                    i26 = i27;
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 10:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i27 = i42;
                                b = -1;
                                if (i38 == 2) {
                                    iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr6, i23, registers3);
                                    unsafe2.putObject(t3, jOffset, registers3.object1);
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i31 = i27;
                                    i34 = i9;
                                    bArr7 = bArr6;
                                    i35 = i21;
                                } else {
                                    i26 = i27;
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 12:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i27 = i42;
                                b = -1;
                                if (i38 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr6, i23, registers3);
                                    i28 = registers3.int1;
                                    Internal.EnumVerifier enumFieldVerifier2 = messageSchema3.getEnumFieldVerifier(i22);
                                    if (isLegacyEnumIsClosed(i40)) {
                                    }
                                    unsafe2.putInt(t3, jOffset, i28);
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i31 = i27;
                                    i34 = i9;
                                    bArr7 = bArr6;
                                    i35 = i21;
                                } else {
                                    i26 = i27;
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 15:
                                bArr6 = bArr;
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i27 = i42;
                                b = -1;
                                if (i38 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr6, i23, registers3);
                                    unsafe2.putInt(t3, jOffset, CodedInputStream.decodeZigZag32(registers3.int1));
                                    i33 = i11 | i44;
                                    i30 = i3;
                                    i32 = i22;
                                    i31 = i27;
                                    i34 = i9;
                                    bArr7 = bArr6;
                                    i35 = i21;
                                } else {
                                    i26 = i27;
                                    i24 = i26;
                                    bArr2 = bArr6;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 16:
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i24 = i42;
                                b = -1;
                                if (i38 == 0) {
                                    bArr5 = bArr;
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr5, i23, registers3);
                                    unsafe2.putLong(t, jOffset, CodedInputStream.decodeZigZag64(registers3.long1));
                                    i30 = i3;
                                    i32 = i22;
                                    i31 = i24;
                                    i35 = i21;
                                    i34 = i9;
                                    bArr7 = bArr5;
                                    int i4110 = iDecodeVarint64;
                                    i33 = i11 | i44;
                                    iDecodeUnknownField = i4110;
                                } else {
                                    bArr2 = bArr;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            case 17:
                                if (i38 == 3) {
                                    Object objMutableMessageFieldForMerge4 = messageSchema3.mutableMessageFieldForMerge(t3, i39);
                                    i9 = i37;
                                    i16 = i42;
                                    iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge4, messageSchema3.getMessageFieldSchema(i39), bArr, i41, i2, (i37 << 3) | 4, registers);
                                    messageSchema3.storeMessageField(t3, i39, objMutableMessageFieldForMerge4);
                                    i33 = i11 | i44;
                                    i20 = i39;
                                    i35 = i21;
                                    i30 = i3;
                                    i31 = i16;
                                    i32 = i20;
                                    i34 = i9;
                                    bArr7 = bArr;
                                } else {
                                    i9 = i37;
                                    i22 = i39;
                                    i23 = i41;
                                    b = -1;
                                    bArr2 = bArr;
                                    i24 = i42;
                                    i12 = i3;
                                    i14 = i23;
                                    i13 = i22;
                                    unsafe = unsafe2;
                                    i6 = i24;
                                    i10 = i21;
                                }
                                break;
                            default:
                                i9 = i37;
                                i22 = i39;
                                i23 = i41;
                                i24 = i42;
                                b = -1;
                                i12 = i3;
                                i14 = i23;
                                i13 = i22;
                                unsafe = unsafe2;
                                i6 = i24;
                                i10 = i21;
                                break;
                        }
                    } else {
                        i9 = i37;
                        i16 = i42;
                        if (iType != 27) {
                            i13 = i39;
                            i10 = i35;
                            i17 = i33;
                            if (iType <= 49) {
                                unsafe = unsafe2;
                                i12 = i3;
                                i19 = i16;
                                oneofField = parseRepeatedField(t, bArr, i41, i2, i16, i9, i38, i13, i40, iType, jOffset, registers);
                                if (oneofField != i41) {
                                    messageSchema2 = this;
                                    registers2 = registers;
                                    iDecodeUnknownField = oneofField;
                                    i15 = i12;
                                    i6 = i19;
                                    i32 = i13;
                                    i35 = i10;
                                    i33 = i17;
                                } else {
                                    i14 = oneofField;
                                    i6 = i19;
                                    i11 = i17;
                                }
                                t3 = t;
                                bArr7 = bArr;
                                i29 = i2;
                                i31 = i6;
                                messageSchema3 = messageSchema2;
                                registers3 = registers2;
                                i34 = i9;
                                i30 = i15;
                                unsafe2 = unsafe;
                            } else {
                                i12 = i3;
                                unsafe = unsafe2;
                                i18 = i41;
                                i19 = i16;
                                if (iType == 50) {
                                    if (i38 == 2) {
                                        oneofField = parseMapField(t, bArr, i18, i2, i13, jOffset, registers);
                                        if (oneofField != i18) {
                                            messageSchema2 = this;
                                            registers2 = registers;
                                            iDecodeUnknownField = oneofField;
                                            i15 = i12;
                                            i6 = i19;
                                            i32 = i13;
                                            i35 = i10;
                                            i33 = i17;
                                        }
                                        t3 = t;
                                        bArr7 = bArr;
                                        i29 = i2;
                                        i31 = i6;
                                        messageSchema3 = messageSchema2;
                                        registers3 = registers2;
                                        i34 = i9;
                                        i30 = i15;
                                        unsafe2 = unsafe;
                                    }
                                    i14 = oneofField;
                                    i6 = i19;
                                    i11 = i17;
                                } else {
                                    oneofField = parseOneofField(t, bArr, i18, i2, i19, i9, i38, i40, iType, jOffset, i13, registers);
                                    if (oneofField != i18) {
                                        messageSchema2 = this;
                                        registers2 = registers;
                                        iDecodeUnknownField = oneofField;
                                        i15 = i12;
                                        i6 = i19;
                                        i32 = i13;
                                        i35 = i10;
                                        i33 = i17;
                                    } else {
                                        i14 = oneofField;
                                        i6 = i19;
                                        i11 = i17;
                                    }
                                    t3 = t;
                                    bArr7 = bArr;
                                    i29 = i2;
                                    i31 = i6;
                                    messageSchema3 = messageSchema2;
                                    registers3 = registers2;
                                    i34 = i9;
                                    i30 = i15;
                                    unsafe2 = unsafe;
                                }
                            }
                        } else if (i38 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t3, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t3, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            i20 = i39;
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema3.getMessageFieldSchema(i39), i16, bArr, i41, i2, protobufListMutableCopyWithCapacity2, registers);
                            i35 = i35;
                            i33 = i33;
                            i30 = i3;
                            i31 = i16;
                            i32 = i20;
                            i34 = i9;
                            bArr7 = bArr;
                        } else {
                            i13 = i39;
                            i10 = i35;
                            i17 = i33;
                            i12 = i3;
                            unsafe = unsafe2;
                            i18 = i41;
                            i19 = i16;
                        }
                        oneofField = i18;
                        i14 = oneofField;
                        i6 = i19;
                        i11 = i17;
                    }
                }
                if (i6 != i12 || i12 == 0) {
                    messageSchema2 = this;
                    i15 = i12;
                    registers2 = registers;
                    if (messageSchema2.hasExtensions && registers2.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                        iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i6, bArr, i14, i2, t, messageSchema2.defaultInstance, messageSchema2.unknownFieldSchema, registers);
                    } else {
                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i6, bArr, i14, i2, getMutableUnknownFields(t), registers);
                    }
                    i32 = i13;
                    i35 = i10;
                    i33 = i11;
                    t3 = t;
                    bArr7 = bArr;
                    i29 = i2;
                    i31 = i6;
                    messageSchema3 = messageSchema2;
                    registers3 = registers2;
                    i34 = i9;
                    i30 = i15;
                    unsafe2 = unsafe;
                } else {
                    messageSchema = this;
                    i5 = i14;
                    i4 = i12;
                    i35 = i10;
                    i7 = i11;
                }
            } else {
                int i50 = i33;
                unsafe = unsafe2;
                i4 = i30;
                messageSchema = messageSchema3;
                i5 = iDecodeUnknownField;
                i6 = i31;
                i7 = i50;
            }
        }
        if (i35 != 1048575) {
            t2 = t;
            unsafe.putInt(t2, i35, i7);
        } else {
            t2 = t;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i51 = messageSchema.checkInitializedCount; i51 < messageSchema.repeatedFieldOffsetStart; i51++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(t, messageSchema.intArray[i51], unknownFieldSetLite, messageSchema.unknownFieldSchema, t);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i4 == 0) {
            if (i5 != i2) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i5 > i2 || i6 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t, int i) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long jOffset = offset(typeAndOffsetAt(i));
        if (!isFieldPresent(t, i)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    private void storeMessageField(T t, int i, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i)), obj);
        setFieldPresent(t, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t, int i, int i2) {
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(t, i, i2)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, offset(typeAndOffsetAt(i2)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    private void storeOneofMessageField(T t, int i, int i2, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i2)), obj);
        setOneofPresent(t, i, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(t, bArr, i, i2, 0, registers);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x007c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void makeImmutable(T t) {
        if (isMutable(t)) {
            if (t instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long jOffset = offset(iTypeAndOffsetAt);
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 17:
                                if (isFieldPresent(t, i)) {
                                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.listFieldSchema.makeImmutableListAt(t, jOffset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t, jOffset);
                                if (object != null) {
                                    unsafe.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
                                }
                                break;
                        }
                    } else if (isOneofPresent(t, numberAt(i), i)) {
                        getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                    }
                } else if (isFieldPresent(t, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t);
            }
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab A[SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.checkInitializedCount) {
            int i6 = this.intArray[i5];
            int iNumberAt = numberAt(i6);
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i4 = UNSAFE.getInt(t, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i3;
                i2 = i4;
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t, i6, i, i2, i9)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t, i6, i, i2, i9) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t, iNumberAt, i6) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType == 49) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iType == 50 && !isMapInitialized(t, iTypeAndOffsetAt, i6)) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.crypto.tink.shaded.protobuf.Schema] */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            if (SchemaFor == 0) {
                SchemaFor = SchemaFor;
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            SchemaFor = SchemaFor;
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(t, i);
        }
        return (i3 & i4) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        boolean zEquals;
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j != 1048575) {
            return (UnsafeUtil.getInt(t, j) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t, jOffset);
                if (object instanceof String) {
                    zEquals = ((String) object).isEmpty();
                } else if (object instanceof ByteString) {
                    zEquals = ByteString.EMPTY.equals(object);
                } else {
                    throw new IllegalArgumentException();
                }
                break;
            case 9:
                return UnsafeUtil.getObject(t, jOffset) != null;
            case 10:
                zEquals = ByteString.EMPTY.equals(UnsafeUtil.getObject(t, jOffset));
                break;
            case 11:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    private void setFieldPresent(T t, int i) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t, j, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t, j));
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & 1048575, i);
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (i == iNumberAt) {
                return i4;
            }
            if (i < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
