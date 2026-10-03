package org.parceler;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface Repository<T> {
    Map<Class, T> get();
}
