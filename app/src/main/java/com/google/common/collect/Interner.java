package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: classes5.dex */
@DoNotMock("Use Interners.new*Interner")
@ElementTypesAreNonnullByDefault
public interface Interner<E> {
    E intern(E e);
}
