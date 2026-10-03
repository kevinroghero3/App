package com.salesforce.marketingcloud.events.predicates;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class d extends h<Integer> {

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
                a[com.salesforce.marketingcloud.events.g.a.LT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.salesforce.marketingcloud.events.g.a.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.salesforce.marketingcloud.events.g.a.LTEQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.salesforce.marketingcloud.events.g.a.GTEQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public d(@Nullable Object obj, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    public boolean a(@Nullable Integer num, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable Integer num2) throws UnsupportedOperationException {
        if (num != null && num2 != null) {
            switch (a.a[aVar.ordinal()]) {
                case 1:
                    return num.equals(num2);
                case 2:
                    return true ^ num.equals(num2);
                case 3:
                    if (num.intValue() < num2.intValue()) {
                        return true;
                    }
                    break;
                case 4:
                    if (num.intValue() > num2.intValue()) {
                        return true;
                    }
                    break;
                case 5:
                    if (num.intValue() <= num2.intValue()) {
                        return true;
                    }
                    break;
                case 6:
                    if (num.intValue() >= num2.intValue()) {
                        return true;
                    }
                    break;
                default:
                    throw new UnsupportedOperationException(String.format(Locale.ENGLISH, "Operator %s not supported for Integer data types.", aVar));
            }
        }
        return false;
    }
}
