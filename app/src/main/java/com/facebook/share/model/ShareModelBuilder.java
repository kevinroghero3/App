package com.facebook.share.model;

import com.facebook.share.ShareBuilder;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ShareModelBuilder<M extends ShareModel, B extends ShareModelBuilder<M, B>> extends ShareBuilder<M, B> {
    B readFrom(@Nullable M m);
}
