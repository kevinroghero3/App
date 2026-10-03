package org.xmlpull.v1.builder;

/* JADX INFO: loaded from: classes6.dex */
public interface XmlUnparsedEntity extends XmlContainer {
    String getDeclarationBaseUri();

    String getName();

    XmlNotation getNotation();

    String getNotationName();

    String getPublicIdentifier();

    String getSystemIdentifier();
}
