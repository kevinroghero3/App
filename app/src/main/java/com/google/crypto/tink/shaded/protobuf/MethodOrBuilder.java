package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface MethodOrBuilder extends MessageLiteOrBuilder {
    @Deprecated
    String getEdition();

    @Deprecated
    ByteString getEditionBytes();

    String getName();

    ByteString getNameBytes();

    Option getOptions(int i);

    int getOptionsCount();

    List<Option> getOptionsList();

    boolean getRequestStreaming();

    String getRequestTypeUrl();

    ByteString getRequestTypeUrlBytes();

    boolean getResponseStreaming();

    String getResponseTypeUrl();

    ByteString getResponseTypeUrlBytes();

    @Deprecated
    Syntax getSyntax();

    @Deprecated
    int getSyntaxValue();
}
