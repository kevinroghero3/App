package com.salesforce.marketingcloud.events.predicates;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.hermes.intl.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class b extends h<Boolean> {

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
        }
    }

    public b(Object obj, com.salesforce.marketingcloud.events.g.a aVar, Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if (Constants.CASEFIRST_FALSE.equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    public boolean a(@Nullable Boolean bool, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable Boolean bool2) throws UnsupportedOperationException {
        if (bool != null && bool2 != null) {
            int i = a.a[aVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new UnsupportedOperationException(String.format(Locale.ENGLISH, "Operator %s not supported for Boolean data types.", aVar));
                }
                if (bool != bool2) {
                    return true;
                }
            } else if (bool == bool2) {
                return true;
            }
        }
        return false;
    }
}
