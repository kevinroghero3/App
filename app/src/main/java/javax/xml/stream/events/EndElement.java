package javax.xml.stream.events;

import java.util.Iterator;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes6.dex */
public interface EndElement extends XMLEvent {
    QName getName();

    Iterator getNamespaces();
}
