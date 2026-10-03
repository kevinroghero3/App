package org.simpleframework.xml.transform;

import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
class DateTransform<T extends Date> implements Transform<T> {
    private final DateFactory<T> factory;

    public DateTransform(Class<T> cls) throws Exception {
        this.factory = new DateFactory<>(cls);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public T read(String str) throws Exception {
        T t;
        synchronized (this) {
            t = (T) this.factory.getInstance(Long.valueOf(DateType.getDate(str).getTime()));
        }
        return t;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(T t) throws Exception {
        String text;
        synchronized (this) {
            text = DateType.getText(t);
        }
        return text;
    }
}
