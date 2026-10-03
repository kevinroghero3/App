package okio.internal;

import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class HashFunctionKt {
    public static final HashFunction newHashFunction(@NotNull String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        return new HashFunction(algorithm) { // from class: okio.internal.HashFunctionKt.newHashFunction.1
            final /* synthetic */ String $algorithm;
            private final MessageDigest digest;

            {
                this.$algorithm = algorithm;
                this.digest = MessageDigest.getInstance(algorithm);
            }

            @Override // okio.internal.HashFunction
            public void update(@NotNull byte[] input, int i, int i2) {
                Intrinsics.checkNotNullParameter(input, "input");
                this.digest.update(input, i, i2);
            }

            @Override // okio.internal.HashFunction
            public byte[] digest() {
                return this.digest.digest();
            }
        };
    }
}
