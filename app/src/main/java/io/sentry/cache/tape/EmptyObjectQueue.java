package io.sentry.cache.tape;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
final class EmptyObjectQueue<T> extends ObjectQueue<T> {
    @Override // io.sentry.cache.tape.ObjectQueue
    public void add(T t) throws IOException {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public QueueFile file() {
        return null;
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public T peek() throws IOException {
        return null;
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public void remove(int i) throws IOException {
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public int size() {
        return 0;
    }

    EmptyObjectQueue() {
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new EmptyIterator();
    }

    static final class EmptyIterator<T> implements Iterator<T> {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException("No elements in EmptyIterator!");
        }
    }
}
