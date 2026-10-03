package com.salesforce.marketingcloud.internal;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Iterator;
import java.util.zip.Inflater;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface a {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.a$a, reason: collision with other inner class name */
    public static final class C0078a implements a {
        public static final C0078a a = new C0078a();
        private static final String b = com.salesforce.marketingcloud.g.a("Deflate");

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.a$a$a, reason: collision with other inner class name */
        static final class C0079a extends Lambda implements Function0<String> {
            final /* synthetic */ boolean b;
            final /* synthetic */ String c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0079a(boolean z, String str) {
                super(0);
                this.b = z;
                this.c = str;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "Successful decompression with nowrap=" + this.b + ", " + this.c;
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.a$a$b */
        static final class b extends Lambda implements Function0<String> {
            final /* synthetic */ boolean b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(boolean z) {
                super(0);
                this.b = z;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "Error decompressing data with nowrap=" + this.b;
            }
        }

        private C0078a() {
        }

        @Override // com.salesforce.marketingcloud.internal.a
        public String a(@NotNull String input) throws com.salesforce.marketingcloud.push.c {
            Intrinsics.checkNotNullParameter(input, "input");
            byte[] bArrDecode = Build.VERSION.SDK_INT >= 26 ? Base64.getDecoder().decode(input) : android.util.Base64.decode(input, 0);
            Iterator it2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Boolean[]{Boolean.FALSE, Boolean.TRUE}).iterator();
            while (it2.hasNext()) {
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                try {
                    Inflater inflater = new Inflater(zBooleanValue);
                    try {
                        inflater.setInput(bArrDecode);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (!inflater.finished()) {
                                byteArrayOutputStream.write(bArr, 0, inflater.inflate(bArr));
                            }
                            String string = byteArrayOutputStream.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            com.salesforce.marketingcloud.g.a.d(b, (Throwable) null, new C0079a(zBooleanValue, string));
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            inflater.end();
                            return string;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(byteArrayOutputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        inflater.end();
                        throw th3;
                    }
                } catch (Exception e) {
                    com.salesforce.marketingcloud.g.a.b(b, e, new b(zBooleanValue));
                }
            }
            throw new com.salesforce.marketingcloud.push.c(input);
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || (obj instanceof C0078a);
        }

        public int hashCode() {
            return 2019606530;
        }

        public String toString() {
            return "Deflate";
        }
    }

    String a(@NotNull String str);
}
