package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

/* JADX INFO: loaded from: classes3.dex */
public class IdProp extends Prop<String> {
    public static final String name = "id";

    @Override // com.henninghall.date_picker.props.Prop
    public String toValue(Dynamic dynamic) {
        return dynamic.asString();
    }
}
