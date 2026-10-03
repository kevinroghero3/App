package com.salesforce.marketingcloud.events.predicates;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class g extends h<String> {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.salesforce.marketingcloud.events.g.a.values().length];
            a = iArr;
            try {
                iArr[com.salesforce.marketingcloud.events.g.a.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.salesforce.marketingcloud.events.g.a.NEQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.salesforce.marketingcloud.events.g.a.REGEX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(@Nullable Object obj, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    public boolean a(@Nullable String str, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable String str2) throws UnsupportedOperationException {
        if (str == null || str2 == null) {
            return false;
        }
        int i = a.a[aVar.ordinal()];
        if (i == 1) {
            return str.equalsIgnoreCase(str2);
        }
        if (i == 2) {
            return !str.equalsIgnoreCase(str2);
        }
        if (i == 3) {
            return str.matches(str2);
        }
        throw new UnsupportedOperationException(String.format(Locale.ENGLISH, "Operator %s not supported for String data types.", aVar));
    }
}
