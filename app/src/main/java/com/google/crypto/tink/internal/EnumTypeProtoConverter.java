package com.google.crypto.tink.internal;

import com.google.errorprone.annotations.Immutable;
import java.lang.Enum;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class EnumTypeProtoConverter<E extends Enum<E>, O> {
    private final Map<E, O> fromProtoEnumMap;
    private final Map<O, E> toProtoEnumMap;

    private EnumTypeProtoConverter(Map<E, O> map, Map<O, E> map2) {
        this.fromProtoEnumMap = map;
        this.toProtoEnumMap = map2;
    }

    public static final class Builder<E extends Enum<E>, O> {
        Map<E, O> fromProtoEnumMap;
        Map<O, E> toProtoEnumMap;

        private Builder() {
            this.fromProtoEnumMap = new HashMap();
            this.toProtoEnumMap = new HashMap();
        }

        public Builder<E, O> add(E e, O o2) {
            this.fromProtoEnumMap.put(e, o2);
            this.toProtoEnumMap.put(o2, e);
            return this;
        }

        public EnumTypeProtoConverter<E, O> build() {
            return new EnumTypeProtoConverter<>(Collections.unmodifiableMap(this.fromProtoEnumMap), Collections.unmodifiableMap(this.toProtoEnumMap));
        }
    }

    public static <E extends Enum<E>, O> Builder<E, O> builder() {
        return new Builder<>();
    }

    public E toProtoEnum(O o2) throws GeneralSecurityException {
        E e = this.toProtoEnumMap.get(o2);
        if (e != null) {
            return e;
        }
        throw new GeneralSecurityException("Unable to convert object enum: " + o2);
    }

    public O fromProtoEnum(E e) throws GeneralSecurityException {
        O o2 = this.fromProtoEnumMap.get(e);
        if (o2 != null) {
            return o2;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: " + e);
    }
}
