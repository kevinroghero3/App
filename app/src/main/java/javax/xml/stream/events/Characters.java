package javax.xml.stream.events;

/* JADX INFO: loaded from: classes6.dex */
public interface Characters extends XMLEvent {
    String getData();

    boolean isCData();

    boolean isIgnorableWhiteSpace();

    boolean isWhiteSpace();
}
