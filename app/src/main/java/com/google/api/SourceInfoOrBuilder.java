package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface SourceInfoOrBuilder extends MessageLiteOrBuilder {
    Any getSourceFiles(int i);

    int getSourceFilesCount();

    List<Any> getSourceFilesList();
}
