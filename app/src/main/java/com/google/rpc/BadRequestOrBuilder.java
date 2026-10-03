package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface BadRequestOrBuilder extends MessageLiteOrBuilder {
    BadRequest.FieldViolation getFieldViolations(int i);

    int getFieldViolationsCount();

    List<BadRequest.FieldViolation> getFieldViolationsList();
}
