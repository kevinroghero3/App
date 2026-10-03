package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.ClientPriority;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class MultiFlavorDetectorCreator {
    private final Map zza = new HashMap();

    public interface DetectorCreator<DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> {
        DetectorT create(@NonNull OptionsT optionst);
    }

    public interface DetectorOptions<DetectorT> {
    }

    public interface MultiFlavorDetector {
    }

    public static class Registration {
        private final Class zza;
        private final Provider zzb;
        private final int zzc;

        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> Registration(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider) {
            this(cls, provider, 100);
        }

        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> Registration(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider, @ClientPriority int i) {
            this.zza = cls;
            this.zzb = provider;
            this.zzc = i;
        }

        final int zza() {
            return this.zzc;
        }

        final Provider zzb() {
            return this.zzb;
        }

        final Class zzc() {
            return this.zza;
        }
    }

    MultiFlavorDetectorCreator(Set set) {
        HashMap map = new HashMap();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            Registration registration = (Registration) it2.next();
            Class clsZzc = registration.zzc();
            if (!this.zza.containsKey(clsZzc) || registration.zza() >= ((Integer) Preconditions.checkNotNull((Integer) map.get(clsZzc))).intValue()) {
                this.zza.put(clsZzc, registration.zzb());
                map.put(clsZzc, Integer.valueOf(registration.zza()));
            }
        }
    }

    public static MultiFlavorDetectorCreator getInstance() {
        MultiFlavorDetectorCreator multiFlavorDetectorCreator;
        synchronized (MultiFlavorDetectorCreator.class) {
            multiFlavorDetectorCreator = (MultiFlavorDetectorCreator) MlKitContext.getInstance().get(MultiFlavorDetectorCreator.class);
        }
        return multiFlavorDetectorCreator;
    }

    public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> DetectorT create(@NonNull OptionsT optionst) {
        return (DetectorT) ((DetectorCreator) ((Provider) Preconditions.checkNotNull((Provider) this.zza.get(optionst.getClass()))).get()).create(optionst);
    }
}
