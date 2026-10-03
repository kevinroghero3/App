package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzju;
import com.google.android.gms.internal.measurement.zzju.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzju<MessageType extends zzju<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzhy<MessageType, BuilderType> {
    private static Map<Object, zzju<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmx zzb = zzmx.zzc();

    public static class zza<MessageType extends zzju<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzia<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        @Override // com.google.android.gms.internal.measurement.zzia
        /* JADX INFO: renamed from: zzae */
        public final /* synthetic */ zzia clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzia
        /* JADX INFO: renamed from: zza */
        public final /* synthetic */ zzia zzb(zziv zzivVar, zzjh zzjhVar) throws IOException {
            return (zza) zzb(zzivVar, zzjhVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzia
        public final /* synthetic */ zzia zza(byte[] bArr, int i, int i2) throws zzkc {
            return zzb(bArr, 0, i2, zzjh.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzia
        public final /* synthetic */ zzia zza(byte[] bArr, int i, int i2, zzjh zzjhVar) throws zzkc {
            return zzb(bArr, 0, i2, zzjhVar);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzcj()) {
                zzal();
            }
            zza(this.zza, messagetype);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzia
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final BuilderType zzb(zziv zzivVar, zzjh zzjhVar) throws IOException {
            if (!this.zza.zzcj()) {
                zzal();
            }
            try {
                zzlv.zza().zza(this.zza).zza(this.zza, zziz.zza(zzivVar), zzjhVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzjh zzjhVar) throws zzkc {
            if (!this.zza.zzcj()) {
                zzal();
            }
            try {
                zzlv.zza().zza(this.zza).zza(this.zza, bArr, 0, i2, new zzig(zzjhVar));
                return this;
            } catch (zzkc e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzkc.zzh();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzlg
        /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public final MessageType zzah() {
            MessageType messagetype = (MessageType) zzai();
            if (messagetype.i_()) {
                return messagetype;
            }
            throw new zzmv(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzlg
        /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
        public MessageType zzai() {
            if (!this.zza.zzcj()) {
                return this.zza;
            }
            this.zza.zzch();
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzlj
        public final /* synthetic */ zzlh zzaj() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.measurement.zzia
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, null, null);
            zzaVar.zza = (MessageType) zzai();
            return zzaVar;
        }

        protected zza(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzcj()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzcb();
        }

        protected final void zzak() {
            if (this.zza.zzcj()) {
                return;
            }
            zzal();
        }

        protected void zzal() {
            MessageType messagetype = (MessageType) this.zzb.zzcb();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzlv.zza().zza(messagetype).zza(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.measurement.zzlj
        public final boolean i_() {
            return zzju.zza(this.zza, false);
        }
    }

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzju<MessageType, BuilderType> implements zzlj {
        protected zzjk<zze> zzc = zzjk.zzb();

        final zzjk<zze> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzjk) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    protected static final class zzc<T extends zzju<T, ?>> extends zzic<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    public static final class zzd<ContainingType extends zzlh, Type> extends zzjf<ContainingType, Type> {
    }

    static final class zze implements zzjm<zze> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjm
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjm
        public final zzlg zza(zzlg zzlgVar, zzlh zzlhVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjm
        public final zzlm zza(zzlm zzlmVar, zzlm zzlmVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjm
        public final zznh zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjm
        public final zznr zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjm
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjm
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    private final int zza() {
        return zzlv.zza().zza(this).zzb(this);
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    private final int zzb(zzlz<?> zzlzVar) {
        if (zzlzVar == null) {
            return zzlv.zza().zza(this).zza(this);
        }
        return zzlzVar.zza(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzhy
    final int zzbv() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final int zzby() {
        return zza((zzlz) null);
    }

    public static final enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhy
    final int zza(zzlz zzlzVar) {
        if (zzcj()) {
            int iZzb = zzb(zzlzVar);
            if (iZzb >= 0) {
                return iZzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
        }
        if (zzbv() != Integer.MAX_VALUE) {
            return zzbv();
        }
        int iZzb2 = zzb(zzlzVar);
        zzc(iZzb2);
        return iZzb2;
    }

    public int hashCode() {
        if (zzcj()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    protected final <MessageType extends zzju<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbz() {
        return (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzca() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    static <T extends zzju<?, ?>> T zza(Class<T> cls) {
        zzju<?, ?> zzjuVar = zzc.get(cls);
        if (zzjuVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzjuVar = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzjuVar == null) {
            zzjuVar = (T) ((zzju) zzna.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (zzjuVar == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzjuVar);
        }
        return (T) zzjuVar;
    }

    final MessageType zzcb() {
        return (MessageType) zza(zzf.zzd, (Object) null, (Object) null);
    }

    protected static zzkb zzcc() {
        return zzjv.zzd();
    }

    protected static zzka zzcd() {
        return zzks.zzd();
    }

    protected static zzka zza(zzka zzkaVar) {
        int size = zzkaVar.size();
        return zzkaVar.zza(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzkd<E> zzce() {
        return zzlu.zzd();
    }

    protected static <E> zzkd<E> zza(zzkd<E> zzkdVar) {
        int size = zzkdVar.size();
        return zzkdVar.zza(size == 0 ? 10 : size << 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final /* synthetic */ zzlg zzcf() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final /* synthetic */ zzlg zzcg() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final /* synthetic */ zzlh zzaj() {
        return (zzju) zza(zzf.zzf, (Object) null, (Object) null);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zza(zzlh zzlhVar, String str, Object[] objArr) {
        return new zzlx(zzlhVar, str, objArr);
    }

    public String toString() {
        return zzli.zza(this, super.toString());
    }

    protected final void zzch() {
        zzlv.zza().zza(this).zzc(this);
        zzci();
    }

    final void zzci() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected static <T extends zzju<?, ?>> void zza(Class<T> cls, T t) {
        t.zzci();
        zzc.put(cls, t);
    }

    @Override // com.google.android.gms.internal.measurement.zzhy
    final void zzc(int i) {
        if (i < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
        this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final void zza(zzjb zzjbVar) throws IOException {
        zzlv.zza().zza(this).zza(this, zzjd.zza(zzjbVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlv.zza().zza(this).zzb(this, (zzju) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean i_() {
        return zza(this, true);
    }

    protected static final <T extends zzju<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzlv.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zZzd ? t : null, null);
        }
        return zZzd;
    }

    final boolean zzcj() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
