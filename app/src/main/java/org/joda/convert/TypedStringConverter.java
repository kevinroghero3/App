package org.joda.convert;

/* JADX INFO: loaded from: classes6.dex */
public interface TypedStringConverter<T> extends StringConverter<T>, TypedFromStringConverter<T> {
    Class<?> getEffectiveType();
}
