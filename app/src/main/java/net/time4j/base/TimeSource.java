package net.time4j.base;

import net.time4j.base.UnixTime;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeSource<T extends UnixTime> {
    T currentTime();
}
