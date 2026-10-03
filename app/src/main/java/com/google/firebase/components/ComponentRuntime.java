package com.google.firebase.components;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Ascii;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class ComponentRuntime implements ComponentContainer, ComponentLoader {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = new ComponentRuntime$$ExternalSyntheticLambda1();
    private final ComponentRegistrarProcessor componentRegistrarProcessor;
    private final Map<Component<?>, Provider<?>> components;
    private final AtomicReference<Boolean> eagerComponentsInitializedWith;
    private final EventBus eventBus;
    private final Map<Qualified<?>, Provider<?>> lazyInstanceMap;
    private final Map<Qualified<?>, LazySet<?>> lazySetMap;
    private Set<String> processedCoroutineDispatcherInterfaces;
    private final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ComponentRegistrar lambda$toProviders$1(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, toProviders(iterable), Arrays.asList(componentArr), ComponentRegistrarProcessor.NOOP);
    }

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection, ComponentRegistrarProcessor componentRegistrarProcessor) {
        this.components = new HashMap();
        this.lazyInstanceMap = new HashMap();
        this.lazySetMap = new HashMap();
        this.processedCoroutineDispatcherInterfaces = new HashSet();
        this.eagerComponentsInitializedWith = new AtomicReference<>();
        EventBus eventBus = new EventBus(executor);
        this.eventBus = eventBus;
        this.componentRegistrarProcessor = componentRegistrarProcessor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(eventBus, (Class<EventBus>) EventBus.class, (Class<? super EventBus>[]) new Class[]{Subscriber.class, Publisher.class}));
        arrayList.add(Component.of(this, (Class<ComponentRuntime>) ComponentLoader.class, (Class<? super ComponentRuntime>[]) new Class[0]));
        for (Component<?> component : collection) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        this.unprocessedRegistrarProviders = iterableToList(iterable);
        discoverComponents(arrayList);
    }

    private void discoverComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<Provider<ComponentRegistrar>> it2 = this.unprocessedRegistrarProviders.iterator();
            while (it2.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it2.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.componentRegistrarProcessor.processRegistrar(componentRegistrar));
                        it2.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it2.remove();
                    SentryLogcatAdapter.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            Iterator<Component<?>> it3 = list.iterator();
            while (it3.hasNext()) {
                for (Object obj : it3.next().getProvidedInterfaces().toArray()) {
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.processedCoroutineDispatcherInterfaces.contains(obj.toString())) {
                            it3.remove();
                            break;
                        }
                        this.processedCoroutineDispatcherInterfaces.add(obj.toString());
                    }
                }
            }
            if (this.components.isEmpty()) {
                CycleDetector.detect(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.components.keySet());
                arrayList2.addAll(list);
                CycleDetector.detect(arrayList2);
            }
            for (final Component<?> component : list) {
                this.components.put(component, new Lazy(new Provider() { // from class: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda2
                    @Override // com.google.firebase.inject.Provider
                    public final Object get() {
                        return this.f$0.lambda$discoverComponents$0(component);
                    }
                }));
            }
            arrayList.addAll(processInstanceComponents(list));
            arrayList.addAll(processSetComponents());
            processDependencies();
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        maybeInitializeEagerComponents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$discoverComponents$0(Component component) {
        return component.getFactory().create(new RestrictedComponentContainer(component, this));
    }

    private void maybeInitializeEagerComponents() {
        Boolean bool = this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    private static Iterable<Provider<ComponentRegistrar>> toProviders(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        for (final ComponentRegistrar componentRegistrar : iterable) {
            arrayList.add(new Provider() { // from class: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda0
                private static long _BOUNDARY;
                private static char[] _CREATION;
                private static final byte[] $$c = {110, 48, -111, -89};
                private static final int $$d = 166;
                private static int $10 = 0;
                private static int $11 = 1;
                private static final byte[] $$a = {34, -105, 53, -7, 52, 2, -47, -11, -53, Ascii.CR, 1, 53, Ascii.FF, -11, 8, -17, 5, 0, -17, 8, -19, 19, -22, -1, 3};
                private static final int $$b = 183;
                private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                private static int artificialFrame = 1;

                private static String $$e(int i, short s, int i2) {
                    int i3 = 4 - (i * 3);
                    int i4 = i2 + b.i;
                    int i5 = s * 2;
                    byte[] bArr = $$c;
                    byte[] bArr2 = new byte[1 - i5];
                    int i6 = 0 - i5;
                    int i7 = -1;
                    if (bArr == null) {
                        i7 = -1;
                        i4 = i3 + i4;
                        i3++;
                    }
                    while (true) {
                        int i8 = i7 + 1;
                        bArr2[i8] = (byte) i4;
                        if (i8 == i6) {
                            return new String(bArr2, 0);
                        }
                        int i9 = i4;
                        i7 = i8;
                        i4 = bArr[i3] + i9;
                        i3++;
                    }
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0021  */
                /* JADX WARN: Code duplicated, block: B:8:0x0019  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
                    /*
                        int r7 = r7 + 66
                        int r6 = r6 + 4
                        int r0 = r8 + 2
                        byte[] r1 = com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda0.$$a
                        byte[] r0 = new byte[r0]
                        int r8 = r8 + 1
                        r2 = 0
                        if (r1 != 0) goto L13
                        r7 = r6
                        r3 = r8
                        r4 = r2
                        goto L2a
                    L13:
                        r3 = r2
                    L14:
                        byte r4 = (byte) r7
                        r0[r3] = r4
                        if (r3 != r8) goto L21
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r0, r2)
                        r9[r2] = r6
                        return
                    L21:
                        int r3 = r3 + 1
                        r4 = r1[r6]
                        r5 = r7
                        r7 = r6
                        r6 = r4
                        r4 = r3
                        r3 = r5
                    L2a:
                        int r6 = -r6
                        int r3 = r3 + r6
                        int r6 = r3 + (-2)
                        int r7 = r7 + 1
                        r3 = r4
                        r5 = r7
                        r7 = r6
                        r6 = r5
                        goto L14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda0.a(byte, byte, int, java.lang.Object[]):void");
                }

                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return ComponentRuntime.lambda$toProviders$1(componentRegistrar);
                }

                private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
                    int i3 = 2 % 2;
                    _CREATION _creation = new _CREATION();
                    long[] jArr = new long[i2];
                    _creation.b = 0;
                    while (_creation.b < i2) {
                        int i4 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                        int i6 = _creation.b;
                        try {
                            Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) 0;
                                byte b2 = b;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.getDeadChar(0, 0), (char) ((ViewConfiguration.getTouchSlop() >> 8) + 9279), View.resolveSizeAndState(0, 0, 0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                            }
                            Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = b3;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 30, (char) (Color.blue(0) + 49362), View.combineMeasuredStates(0, 0) + 684, -115095555, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                            }
                            jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                            Object[] objArr4 = {_creation, _creation};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 25, (char) (30068 - TextUtils.indexOf("", "", 0)), 817 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            int i7 = $10 + 117;
                            $11 = i7 % 128;
                            int i8 = i7 % 2;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    char[] cArr = new char[i2];
                    _creation.b = 0;
                    while (_creation.b < i2) {
                        int i9 = $11 + 55;
                        $10 = i9 % 128;
                        int i10 = i9 % 2;
                        cArr[_creation.b] = (char) jArr[_creation.b];
                        Object[] objArr5 = {_creation, _creation};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (30068 - (ViewConfiguration.getTouchSlop() >> 8)), 816 - (Process.myPid() >> 22), 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    }
                    objArr[0] = new String(cArr);
                }

                static {
                    char[] cArr = new char[1959];
                    ByteBuffer.wrap("]\u0018\u0014fÏ8\u0086ÞyÌ3Yêf](\u0014ûÏ\u008c\u0081Lx\u00033#êÙ]°\u0017HÎ\u0003\u0081Àxè3«å`\\1\u0017ÊÎ\u0084\u0081®{y20\u0019ÑP¯\u008bñÂ\u0017=\u0005w\u0090®¯\u0019áP2\u008bEÅ\u0085<Êwê®\u0010\u0019hS\u008c\u008aÞÅ\u001e<\u001bwu¡ª\u0018ÕS\u0013\u008aIÅb\u0019ÑP¯\u008bñÂ\u0017=\u0005w\u0090®¯\u0019áP2\u008bEÅ\u0085<Êwê®\u0010\u0019kS\u009c\u008aÀÅ\u0018\u0019ÑP¸\u008bíÂ\u0012=\u0005w\u009a®¯\u0019éP#\u008bOÅ\u0089<\u0096wå® \u0019tS\u0081\u008aÈÅ\u0012<7wy¡\u0085\u0018ÅS\u0011\u008aIÅr?¶vî¡\u0010\u0019ÑP®\u008bàÂ\u0002=\u0005w\u0093®§\u0019£P&\u008bQÅ\u0083<É\u009c*ÕU\u000e\u001bGù¸þò\u007f+R\u009c\u001bÕ\u0083\u000e¨@e¹-ò\t\n\u0016C\u007f\u00987ÑÅ.\u008cdB½c\neCÃ\u0098¢Öf/\u0011d3½í\n\u009b@C\u0099\u001dÖÝ\u0019ÑP¯\u008bõÂ\u0015=KwØ®î\u0019îP&\u008bVÅ\u0085<×wä® \u0019\u008cP¤\u008bºÂ\u0003=Ew\u0098®´\u0019£P$\u008bFÅ\u0088<Ëwí®&\u0019|Sº\u008aÀÅ\u001e<0wN¡¾\u0018ÉS\u0003\u008a\f\u0096_ßw\u0004iMÐ²\u0096øK!g\u0096pß÷\u0004\u0095J[³\u0018ø>!õ\u0096¯Üi\u0005\u0013JÍ³ãø\u009d.m\u0097\u001aÜÐ\u0005ÜÞ\u0087\u0097îL»\u0005Dú\b°ÄiûÞô\u0097lL\u001c\u0002ØûÀ°¸ipÞ,\u0094ÝM\u009a\u0002\u0003ûa°(\u0019\u009cP¢\u008bóÂ\u000f=Ew\u008fü`µH±ñø\u0098#Íj2\u0095~ß²\u0006\u008d±\u0082ø\u0014#jm¢\u0094¶ßÌ\u0006\n±Uû°\"Øm\u0016\u0094Iß_\t\u009f°êû%\"0mE\u0097\u009cÞÒ\t=°`ú°%\u0084\u0019ÑP¸\u008bíÂ\u0012=^w\u0092®\u00ad\u0019¢P4\u008bJÅ\u0082<\u0096wì®*\u0019uS\u0090\u008aøÅ6<iwa¡¨\u0018ÈS\u0000\u0019ÑP¸\u008bíÂ\u0012=^w\u0092®\u00ad\u0019¢P:\u008bJÅ\u008e<\u0096wî®&\u0019zS\u008b\u008aËÅ\u0016<1wG¡\u0097\u0018×S\u0002\u008aRÅv?ývï¡\u0006.Yg'¼yõ\u009f\n\u008d@\u0011\u0099-.hg«¼Ìò\u0011\u000bT@y\u0099³\u0005'L\u000f\u0097\u0011Þ¨!ôk5²\u0007\u0005BLÓ\u0097àÙ( ak]\u0002 K\u009e\u0090ÅÙ\"&\u007fléµ\u009e\u0002ØK\u0012\u0019ÑP»\u008bæÂ\u000e=IwØ®¦\u0019äP:\u008bFÅ\u009f<Àwñ®;\u0019}S\u0088\u008aÝ\u0019\u0090P®\u008bùÂ\u0014=Yw\u0091¨Xáp:nsÅ\u008c\u008cÆL\u001fp¨,áá:\u0083t\u0016\u008d\u0000Æ7\u001fõ¨¹âW;\u001btÌ\u008däÆ°\u0010|©\u0016âÖA!\b\u0016ÓB\u009a \u0019\u008eP®\u008bæÂ\u0012=Cw\u0084®´\u0019£P%\u008bZÅ\u009f<\u0097wà®+\u00196S\u0081\u008aËÅ\u0019<1wv¡ô\u0018ÀS\u0000\u008aHÅ(?µvý¡\u0002\u0018WR \u008d¯Äå?+vt \u0086\u001b¤Rä\u008d3ÄE>\u009fiÓ ñ\u0019\u008eP®\u008bæÂ\u0012=Cw\u0084®´\u0019£P%\u008bZÅ\u009f<\u0097wà®+\u00196S\u0081\u008aËÅ\u0019<1wv¡ô\u0018ÀS\u0000\u008aHÅ(?µvý¡\u0002\u0018WR \u008d¯Äå?+vt \u0082\u001b¤Rä\u008d3ÄO>\u009f¡ýèÝ3\u0095za\u00850Ï÷\u0016Ç¡ÐèV3)}ì\u0084äÏ\u0093\u0016X¡Eëò2¸}j\u0084BÏ\u0005\u0019\u0087 ¦ël2`}\u0016\u0087ÑÎ\u0086\u0005gLG\u0097\u000fÞû!ªkm²]\u0005JLÌ\u0097³Ùv ~k\t²Â\u0005ßOh\u0096\"Ùð Øk\u009f½\u001d\u0004<Oö\u0096úÙ\u0083#[j\u0016\u0001±H\u0091\u0093ÙÚ-%|o»¶\u008b\u0001\u009cH\u001a\u0093eÝ $¨oß¶\u0014\u0001\tK¾\u0092ôÝ&$\u000eoI¹Ë\u0000êK \u0092,ÝT'\u008fnÀyÕ0õë½¢I]\u0018\u0017ßÎïyø0~ë\u0001¥Ä\\Ì\u0017»Îpym3Úê\u0090¥B\\j\u0017-Á¯x\u008e3DêH¥0_æ\u0016¤QE\u0018dÃ6\u008aÔu\u0094?\\\u0019ÑP»\u008bæÂ\u000e=IwØ®\u00ad\u0019âP2\u008bVÅ\u0080<Üwñú+³\nhX!ºÞî\u0094!M\u0006ú]³\u0081¥\tì\u001e7J~¨\u0081÷Ë(\u0012\u0004¥Tì\u00897ý¹\u001dð3+ib\u0099\u009dÓ×\u0016\u000e8$\u001em ¶eÿ\u008d\u0000ÄJ\u001d\u00936$c\u0019\u008cP¤\u008bºÂ\u0011=Xw\u0098®¤\u0019øP5\u008bWÅÂ<Ýwç®9\u0019qS\u0086\u008aË\u0019\u0088P©\u008bûÂ\u0019=\u0012wÁ®°\u0019\u0099P®\u008búÂ\u0004=Xw\u009e®£L{\u0005LÞ\u0018\u0097æhº\"|ûAL0\u0005ÌÞù\u00908Ûw\u0092@I\u0014\u0000êÿ¶µplMÛ<\u0092ÀIõ\u00074þ\bµZl\u0095\u0019\u008cP¤\u008bºÂ\u0011=Xw\u0098®¤\u0019øP5\u008bWÅÂ<Ôwí®+\u0019}S\u0089\u0019\u008dP¯\u008bÿ\u0019\u009bP¦\u008báÂ\r=Kw\u0083®¯\u0019ÿ\u008fPÆT\u001d\u000bT®«\u0097ám8A\u008f\u0016ÆÐ\u001d¡Sfªvá\u000b8Ï\u008f\u0085Å*\u001c\u0002SüªÙá\u00917X\u008e-\u0019¿P¥\u008bðÂ\u0013=Ew\u009e®¤\u0019\u00adP\u0005\u008bgÅ§<\u0099wà®:\u0019qS\u0089\u008aÚÅ[<\"w~¡¨\u0018\u0087S\b\u008a\u0005Å0\u0019¿P¥\u008bðÂ\u0013=Ew\u009e®¤\u0019\u00adP\u0005\u008bgÅ§<\u0099wà®:\u0019qS\u0089\u008aÚÅ[<\"w~¡¨\u0018\u0087S\b\u008a\u0005Å0?\u008cvª¡]¹éðÁ+ßbl\u009d.×à\u000eÁ¹\u009fðR+4eì}\u00104-ïq¦\u008cYÅ\u0013\u0017Ê:}l\u0019\u0088P©\u008bûÂ\u0019=\u0012wÁBG\u000baÐ1\u0099Éf\u0089,I\u0019\u008cP¤\u008bºÂ\u0011=Xw\u0098®¤\u0019øP5\u008bWÅÂ<Ûwð®.\u0019vS\u0081\u0019\u008cP¤\u008bºÂ\n=Ow\u0085®®\u0019èP:\u008b\rÅ\u009d<Üwï®:.@\u008e¸Ç\u0090\u001c\u008eU&ª{à 9\u0081\u008eËÇ\u0007\u0019Î\u0019\u008cP¤\u008bºÂ\u0003=_w\u009e®¬\u0019éPx\u008bSÅ\u009e<Öwæ®:\u0019{S\u0091\u0081~ÈX\u0013\u001eZë¥\u0093ïi6\u001e\u0081]é\u0003 +{52\u008cÍÐ\u0087\u0011^#éf ÷{Ê5\nÌX\u0087j^¥éå£\u001azS5\u009dÌ¥\u0087ê¢eëR0\u0006yø\u0086¤Ìb\u0015_¢^ëÙ0»~{\u0087jÌ\u0019\u0015Ö¢\u008aè|1 ~î\u0087ÛÄÃ\u008dôV \u001f^à\u0002ªÄsùÄ\u0088\u008dtVA\u0018\u0080áÌª«sqÄ)\u008eàW\u008c\u0018\u0019á(ªd|çÅ\u0098\u008eDW\u0002\u0018.âà«¥|lÅ\u0010\u008f\u009dP¤e\u0098,¯÷û¾\u0005AY\u000b\u009fÒ¢e£,0÷M¹\u0082@ß\u000bïÒ+eF/\u0097öË¹\u0011@j\u000bwÝ¾dÈ/\u0014öN¹nC±\u0019\u0099P®\u008búÂ\u0004=Xw\u009e®£\u0019¢P \u008bAÅ\u0083<Áwº®y\u0019hSÊ\u008aØÅ\u0019<+wi¡â\u0018\u0091S\u0000èÛ¡æz¹3DÌ\u0004\u0086Ð_\u00adè¼¡pz\n4ñÍ\u009c\u0086°_eè5¢É{\u00894fÍ~\u0086kP®éÊ¢U{\u001a4*Îô\u0087¬PBé\u0013£â|ò5ïÎ*\u0019\u008cP¤\u008bºÂ\u0003=Ew\u0098®´\u0019áP9\u008bBÅ\u0088<Üwð;Erm©sàÊ\u001f\u008cUQ\u008c};-rò©\u008bçB\u001e\u0015Ue\u008cä;¤qE¨\u000bçÖ\u001e£U¾\u0083z:\u0000qÞ¨\u0091ç½\u001djT'\u0083É:\u0095pBB\u0001\u000b\u001bÐN\u0099\u00adfû, õ\u001aB\u001e\u000b\u0090Ð¥\u009ed\u0019\u008cP¤\u008bºÂ\u0003=_w\u009e®¬\u0019éPx\u008bGÅ\u0085<Êwò®#\u0019yS\u009c\u008a\u0080Å\u0012< \u0019\u008aP®\u008bçÂ\u0015=\u0007\u0019\u0097P¥\u008býÂ\u0015=\u0004w\u0084®¶\u0019îPx\u008bRÅ\u0089<Ôw÷®b\u0019hS\u0097\u008aÁÅ\u000b<7\u0019\u008fP®\u008bùÂ\u0014=\u0004w\u009f®·\u0019£P;\u008bBÅ\u0085<×wé®*\u0019aS\u0096\u0019\u008fP®\u008bùÂ\u0014=\u0004w\u0084®¦\u0019£P0\u008bBÅ\u0087<ÜwÝ®,\u0019yS\u0088\u008aËÅ\t<%áÅ¨äs³:^ÅN\u008fÎVìáé¨ps\n=ÂÄ¬\u008f¬V`á<«Ür\u008d=EÄw\u0019\u008cP¤\u008bºÂ\n=Ow\u0085®®\u0019èP:\u008b\rÅ\u008d<×wæ®=\u0019wS\u008c\u008aÊÅU<5wt¡·\u0018ÒS\u0014\u0019\u008cP¤\u008bºÂ\u0003=Ew\u0098®´\u0019£P'\u008bFÅ\u0081<Ìw¬®.\u0019nS\u0081\u008añÅ\u0015<%w|¡¿Î\u008c\u0087¤\\º\u0015\u000eêN \u009ayîÎï\u0087#\\J\u0012\u0080ëÝ ¬y)Îq\u0084\u008b]É\u0012\u001eë6 av¨ÏÎ\u0084\u001e]I\u0019\u008cP¤\u008bºÂ\u0011=Xw\u0098®¤\u0019øP5\u008bWÅÂ<Ûw÷®&\u0019tS\u0081\u008a\u0080Å\u001d<-w\u007f¡½\u0018ÂS\u0002\u008aMÅt?ºvò¡\u001doã&ËýÕ´}K<\u0001ëØÛo\u0087&Týb³áJ£\u0001\u0084ØLo\u0013%¤ü§³}JE\u0001\u0019×Ðnº%oü ³\u0000IÒ\u0000\u0087ÿ¢¶\u008am\u0094$<Û}\u0091ªH\u009aÿÆ¶\u0015mR#§Úï\u0091ØHOÿTµ¾lé#9Ú\u000e\u0091\u0011G\u0092þàµ0lt#MÙ\u008f\u0090ÂG5þu´¿k\u0092\u0019\u008cP¤\u008bºÂ\u0017=Ow\u0099®¤\u0019âP$\u008b\rÅ\u008e<Ìwë®#\u0019|SË\u008aÈÅ\u0012<*wv¡¿\u0018ÕS\u0000\u008aOÅo?½vèËR\u0082zYd\u0010Éï\u0091¥G|zË<\u0082úY¢\u0017Vî\u000b¥7|üËè\u0081YX\u0005\u0017Ìîö¥«s*Ê\u001f\u0081ÇX\u008d\u0017¿íh¤0sÇÊ\u009e\u0080H_x\u0016?\u0019Ä\u0001nH\u0010\u0093NÚ¨%ºo9¶\u001a\u0001_H\u009c\u0093ÃÝ#$ooM¶\u0095\u0019ÑP¯\u008bñÂ\u0017=\u0005w\u0084®¯\u0019îP=\u008bFÅ\u0098<\u0096wà®.\u0019kS\u0080\u008aÌÅ\u001a<*wu¡\u0085\u0018ÀS\u0015\u008aSÅ\u007f?·\t\u0080@þ\u009b ÒF-TgÕ¾þ\t¿@l\u009b\u0017ÕÉ,Çg´¾{\t'CÍ\u009a\u009bÑÛ\u0098¥Cû\n\u001dõ\u000f¿\u008ef¥Ñä\u00987CL\r\u0092ô\u009c¿ùf Ñ\u007f\u009b\u009aBÀ\u0019ÑP¸\u008bíÂ\u0012=\u0005w\u0086®¥\u0019àP#\u008b|Å\u0098<Ëwã®,\u0019}\u0001ñH\u0098\u0093ÍÚ2%~o²¶\u008d\u0001\u0082H\u001a\u0093jÝ®$¶oÎ¶\u0006\u0001ZK¦\u0092ÑÝ6$\u0005o]¹\u0096\u0000èK3\u0092BÝB'\u0096nÞ¹<\u0000uJ\u0080\u0095\u0099ÜÐ'\u0013n~¸ú\u0003\u0092JÅyt0\nëT¢²] \u00170Î\u0016y\\0¬ëá¥9\\o8bq\u001cªBã¤\u001c¶V&\u008f\u00008Jqºªää6\u001dgVT;Or1©oà\u0089\u001f\u009bU\u001a\u008c1;pr£©Øç\u0006\u001e\bU~\u008c¢;òq\u001d¨_ç\u0089\u001e¾Uê\u00836:]\u0019ÑP¸\u008bíÂ\u0012=^w\u0092®\u00ad\u0019¢P:\u008bJÅ\u008e<\u0096wî®&\u0019zS\u0087\u008aÝÅ\u000f<\"w~¡¶\u0018ÃS\u0015\u008aOÅY?¹vò¡\u0000\u0018\u001cR\u008c\u008d§\u0019ÑP¯\u008bñÂ\u0017=\u0005w\u0095®³\u0019ùP7\u008b@Å\u008f<Ü>4wJ¬\u0014åò\u001aàPp\u0089V>\u001cwÔ¬¿â{\u001b3Ã¶\u008aÈQ\u0096\u0018pçb\u00adòtÔÃ\u009e\u008a\\Q!\u001fìæ°S\u0003\u001a}Á#\u0088Åw×=GäaS+\u001aëÁ\u0083\u008fWv\u000e\u0019ÑP¯\u008bñÂ\u0017=\u0005w\u0095®³\u0019ùP \u008bNÅ\u009f<Þ9©p×«\u0089âo\u001d}Wí\u008eË9\u0081p^«<åõ\u001c¨W\u008a\u008eT|55Kî\u0015§óXá\u0012qËW|\u001d5íî® eY8\u0019ÑP¯\u008bõÂ\u0015=KwØ®¤\u0019âP!\u008bMÅ\u0080<Öwã®+\u0019kSÊ\u008a\u0080Å\u0003<&w>¡¸\u0018ÔS\u0004\u008aV\u0019ÑP¦\u008búÂ\u0015=\u0005w\u0080®©\u0019ãP2\u008bLÅ\u009b<Êw\u00ad®\r\u0019kS\u0091\u008aýÅ\u0013<%wc¡¿\u0018ÃS6\u008aRÅj?·vù¡\u001b]À\u0014ªÏ÷\u0086\u001fyX3Éê¸]ó\u00147Ï]\u0081\u008fxÜ3à\u0019ÎP\u00ad\u008bòÂA=\u0010ü\\µ6nk'\u0083ØÄ\u0092UK>üeµ·nÈ NÙY\u0092nK²üæ\u0019\u0099P¹\u008bõÂ\r=Fw\u0098®£\u0019£P1\u008bLÅ\u0080<Ýwä®&\u0019kS\u008d\u008a\u0080Å\b<+º\u0097ó§(óa#\u009ecÔ·\r\u0096º×ó1(Uf\u009d\u009f\u0092Ôô\r%\u0019ÑP®\u008bàÂ\u0002=\u0005w\u009a®¥\u0019éP?\u008bBÅ³<Úwí®+\u0019}S\u0086\u008aÝÅU<<w|¡¶\u0019\u009cP§\u008báÂ\u0004=Yw\u0083®¡\u0019îP=\u008bP\u0019ÑP®\u008bàÂ\u0002=\u0005w\u009a®¯\u0019øP8\u008bWÅ\u009f\u0019ÑP¯\u008bõÂ\u0015=KwØ®¤\u0019âP!\u008bMÅ\u0080<Öwã®+\u0019kSÊ\u008a\u0080Å\u001f<4w>¡»\u0018×S\u0000\u008aNÅ(?«vñ¡\u0005\t0@Z\u009b\u0007Òï-¨g9¾B\t\u001c@Â\u009b«Õc,>g\f\u0019¹P¤\u008bøÂ\u0005=Lw\u009e®³\u0019å\u0019ÑP¯\u008bõÂ\u0015=KwØ®\u00ad\u0019äP%\u008b@ÅÃ<Éwð® \u0019~S\u008c\u008aÂÅ\u001e<7w>¡¹\u0018ÒS\u0002\u008a\u0012Å6?üvÿ¡\u0006\u0018_RÑ\u008d¥Äü?=vY \u009b\u001b·Rã\u008d%ÄT>ÃiÛ æ\u001b!Rl\u008c\u008bÇÂ>\u001d".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                    _CREATION = cArr;
                    _BOUNDARY = 4162302437762093259L;
                }

                /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                    java.util.NoSuchElementException
                    	at java.base/java.util.TreeMap.key(Unknown Source)
                    	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                    	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                    */
                public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r63, int r64, int r65, int r66) {
                    /*
                        Method dump skipped, instruction units count: 15635
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda0.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
                }
            });
        }
        return arrayList;
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }

    private List<Runnable> processInstanceComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component<?> component : list) {
            if (component.isValue()) {
                final Provider<?> provider = this.components.get(component);
                for (Qualified<? super Object> qualified : component.getProvidedInterfaces()) {
                    if (!this.lazyInstanceMap.containsKey(qualified)) {
                        this.lazyInstanceMap.put(qualified, provider);
                    } else {
                        final OptionalProvider optionalProvider = (OptionalProvider) this.lazyInstanceMap.get(qualified);
                        arrayList.add(new Runnable() { // from class: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                optionalProvider.set(provider);
                            }
                        });
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> processSetComponents() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<Component<?>, Provider<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            if (!key.isValue()) {
                Provider<?> value = entry.getValue();
                for (Qualified<? super Object> qualified : key.getProvidedInterfaces()) {
                    if (!map.containsKey(qualified)) {
                        map.put(qualified, new HashSet());
                    }
                    ((Set) map.get(qualified)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (!this.lazySetMap.containsKey(entry2.getKey())) {
                this.lazySetMap.put((Qualified) entry2.getKey(), LazySet.fromCollection((Collection) entry2.getValue()));
            } else {
                final LazySet<?> lazySet = this.lazySetMap.get(entry2.getKey());
                for (final Provider provider : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            lazySet.add(provider);
                        }
                    });
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Qualified<T> qualified) {
        Provider<T> provider;
        synchronized (this) {
            Preconditions.checkNotNull(qualified, "Null interface requested.");
            provider = (Provider) this.lazyInstanceMap.get(qualified);
        }
        return provider;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return OptionalProvider.empty();
        }
        if (provider instanceof OptionalProvider) {
            return (OptionalProvider) provider;
        }
        return OptionalProvider.of(provider);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        synchronized (this) {
            LazySet<?> lazySet = this.lazySetMap.get(qualified);
            if (lazySet != null) {
                return lazySet;
            }
            return (Provider<Set<T>>) EMPTY_PROVIDER;
        }
    }

    public void initializeEagerComponents(boolean z) {
        HashMap map;
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.eagerComponentsInitializedWith, null, Boolean.valueOf(z))) {
            synchronized (this) {
                map = new HashMap(this.components);
            }
            doInitializeEagerComponents(map, z);
        }
    }

    private void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z) {
        for (Map.Entry<Component<?>, Provider<?>> entry : map.entrySet()) {
            Component<?> key = entry.getKey();
            Provider<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z)) {
                value.get();
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    @Override // com.google.firebase.dynamicloading.ComponentLoader
    public void discoverComponents() {
        synchronized (this) {
            if (this.unprocessedRegistrarProviders.isEmpty()) {
                return;
            }
            discoverComponents(new ArrayList());
        }
    }

    public void initializeAllComponentsForTests() {
        Iterator<Provider<?>> it2 = this.components.values().iterator();
        while (it2.hasNext()) {
            it2.next().get();
        }
    }

    private void processDependencies() {
        for (Component<?> component : this.components.keySet()) {
            for (Dependency dependency : component.getDependencies()) {
                if (dependency.isSet() && !this.lazySetMap.containsKey(dependency.getInterface())) {
                    this.lazySetMap.put(dependency.getInterface(), LazySet.fromCollection(Collections.emptySet()));
                } else if (this.lazyInstanceMap.containsKey(dependency.getInterface())) {
                    continue;
                } else {
                    if (dependency.isRequired()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.getInterface()));
                    }
                    if (!dependency.isSet()) {
                        this.lazyInstanceMap.put(dependency.getInterface(), OptionalProvider.empty());
                    }
                }
            }
        }
    }

    Collection<Component<?>> getAllComponentsForTest() {
        return this.components.keySet();
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {
        private final Executor defaultExecutor;
        private final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();
        private final List<Component<?>> additionalComponents = new ArrayList();
        private ComponentRegistrarProcessor componentRegistrarProcessor = ComponentRegistrarProcessor.NOOP;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        Builder(Executor executor) {
            this.defaultExecutor = executor;
        }

        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.lazyRegistrars.addAll(collection);
            return this;
        }

        public Builder addComponentRegistrar(final ComponentRegistrar componentRegistrar) {
            this.lazyRegistrars.add(new Provider() { // from class: com.google.firebase.components.ComponentRuntime$Builder$$ExternalSyntheticLambda0
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(componentRegistrar);
                }
            });
            return this;
        }

        public Builder addComponent(Component<?> component) {
            this.additionalComponents.add(component);
            return this;
        }

        public Builder setProcessor(ComponentRegistrarProcessor componentRegistrarProcessor) {
            this.componentRegistrarProcessor = componentRegistrarProcessor;
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents, this.componentRegistrarProcessor);
        }
    }
}
