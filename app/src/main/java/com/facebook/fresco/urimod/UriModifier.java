package com.facebook.fresco.urimod;

/* JADX INFO: loaded from: classes4.dex */
public final class UriModifier {
    public static final UriModifier INSTANCE = new UriModifier();

    /* JADX INFO: renamed from: INSTANCE, reason: collision with other field name */
    public static UriModifierInterface f8INSTANCE = NopUriModifier.INSTANCE;

    private UriModifier() {
    }
}
