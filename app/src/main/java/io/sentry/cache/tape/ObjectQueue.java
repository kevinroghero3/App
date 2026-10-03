package io.sentry.cache.tape;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ObjectQueue<T> implements Iterable<T>, Closeable {

    public interface Converter<T> {
        T from(byte[] bArr) throws IOException;

        void toStream(T t, OutputStream outputStream) throws IOException;
    }

    public abstract void add(T t) throws IOException;

    public abstract QueueFile file();

    public abstract T peek() throws IOException;

    public abstract void remove(int i) throws IOException;

    public abstract int size();

    public static <T> ObjectQueue<T> create(QueueFile queueFile, Converter<T> converter) {
        return new FileObjectQueue(queueFile, converter);
    }

    public static <T> ObjectQueue<T> createEmpty() {
        return new EmptyObjectQueue();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public List<T> peek(int i) throws IOException {
        int iMin = Math.min(i, size());
        ArrayList arrayList = new ArrayList(iMin);
        Iterator<T> it2 = iterator();
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(it2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<T> asList() throws IOException {
        return peek(size());
    }

    public void remove() throws IOException {
        remove(1);
    }

    public void clear() throws IOException {
        remove(size());
    }
}
