package com.salesforce.marketingcloud.events.predicates;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class c extends h<Double> {

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

    public c(@Nullable Object obj, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:25:0x0046 A[RETURN, SYNTHETIC] */
    @Override // com.salesforce.marketingcloud.events.predicates.h
    public boolean a(@Nullable Double d, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable Double d2) throws UnsupportedOperationException {
        if (d != null && d2 != null) {
            double dDoubleValue = d.doubleValue();
            double dDoubleValue2 = d2.doubleValue();
            switch (a.a[aVar.ordinal()]) {
                case 1:
                    if (dDoubleValue == dDoubleValue2) {
                        return true;
                    }
                    break;
                case 2:
                    if (dDoubleValue != dDoubleValue2) {
                        return true;
                    }
                    break;
                case 3:
                    if (dDoubleValue < dDoubleValue2) {
                        return true;
                    }
                    break;
                case 4:
                    if (dDoubleValue > dDoubleValue2) {
                        return true;
                    }
                    break;
                case 5:
                    if (dDoubleValue <= dDoubleValue2) {
                        return true;
                    }
                    break;
                case 6:
                    if (dDoubleValue >= dDoubleValue2) {
                        return true;
                    }
                    break;
                default:
                    throw new UnsupportedOperationException(String.format(Locale.ENGLISH, "Operator %s not supported for Double data types.", aVar));
            }
        }
        return false;
    }
}
