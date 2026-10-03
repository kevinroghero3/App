package com.facebook.imagepipeline.producers;

import android.os.Looper;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ThreadHandoffProducer<T> implements Producer<T> {
    public static final Companion Companion = new Companion(null);
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    private final Producer<T> inputProducer;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;

    public ThreadHandoffProducer(@NotNull Producer<T> inputProducer, @NotNull ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        this.inputProducer = inputProducer;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    public final Producer<T> getInputProducer() {
        return this.inputProducer;
    }

    public final ThreadHandoffProducerQueue getThreadHandoffProducerQueue() {
        return this.threadHandoffProducerQueue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(@NotNull final Consumer<T> consumer, @NotNull final ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            final ProducerListener2 producerListener = context.getProducerListener();
            Companion companion = Companion;
            if (companion.shouldRunImmediately(context)) {
                producerListener.onProducerStart(context, PRODUCER_NAME);
                producerListener.onProducerFinishWithSuccess(context, PRODUCER_NAME, null);
                this.inputProducer.produceResults(consumer, context);
                return;
            } else {
                final StatefulProducerRunnable<T> statefulProducerRunnable = new StatefulProducerRunnable<T>(consumer, producerListener, context, this) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1
                    final /* synthetic */ Consumer<T> $consumer;
                    final /* synthetic */ ProducerContext $context;
                    final /* synthetic */ ProducerListener2 $producerListener;
                    final /* synthetic */ ThreadHandoffProducer<T> this$0;

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    public void disposeResult(T t) {
                    }

                    @Override // com.facebook.common.executors.StatefulRunnable
                    public T getResult() throws Exception {
                        return null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(consumer, producerListener, context, ThreadHandoffProducer.PRODUCER_NAME);
                        this.$consumer = consumer;
                        this.$producerListener = producerListener;
                        this.$context = context;
                        this.this$0 = this;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    public void onSuccess(T t) {
                        this.$producerListener.onProducerFinishWithSuccess(this.$context, ThreadHandoffProducer.PRODUCER_NAME, null);
                        this.this$0.getInputProducer().produceResults(this.$consumer, this.$context);
                    }
                };
                context.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$1
                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        statefulProducerRunnable.cancel();
                        this.getThreadHandoffProducerQueue().remove(statefulProducerRunnable);
                    }
                });
                this.threadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(statefulProducerRunnable, companion.getInstrumentationTag(context)));
                return;
            }
        }
        FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
        try {
            final ProducerListener2 producerListener2 = context.getProducerListener();
            Companion companion2 = Companion;
            if (companion2.shouldRunImmediately(context)) {
                producerListener2.onProducerStart(context, PRODUCER_NAME);
                producerListener2.onProducerFinishWithSuccess(context, PRODUCER_NAME, null);
                this.inputProducer.produceResults(consumer, context);
            } else {
                final StatefulProducerRunnable<T> statefulProducerRunnable2 = new StatefulProducerRunnable<T>(consumer, producerListener2, context, this) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1
                    final /* synthetic */ Consumer<T> $consumer;
                    final /* synthetic */ ProducerContext $context;
                    final /* synthetic */ ProducerListener2 $producerListener;
                    final /* synthetic */ ThreadHandoffProducer<T> this$0;

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    public void disposeResult(T t) {
                    }

                    @Override // com.facebook.common.executors.StatefulRunnable
                    public T getResult() throws Exception {
                        return null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(consumer, producerListener2, context, ThreadHandoffProducer.PRODUCER_NAME);
                        this.$consumer = consumer;
                        this.$producerListener = producerListener2;
                        this.$context = context;
                        this.this$0 = this;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    public void onSuccess(T t) {
                        this.$producerListener.onProducerFinishWithSuccess(this.$context, ThreadHandoffProducer.PRODUCER_NAME, null);
                        this.this$0.getInputProducer().produceResults(this.$consumer, this.$context);
                    }
                };
                context.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$1
                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        statefulProducerRunnable2.cancel();
                        this.getThreadHandoffProducerQueue().remove(statefulProducerRunnable2);
                    }
                });
                this.threadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(statefulProducerRunnable2, companion2.getInstrumentationTag(context)));
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getInstrumentationTag(ProducerContext producerContext) {
            if (!FrescoInstrumenter.isTracing()) {
                return null;
            }
            return "ThreadHandoffProducer_produceResults_" + producerContext.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldRunImmediately(ProducerContext producerContext) {
            return producerContext.getImagePipelineConfig().getExperiments().getHandOffOnUiThreadOnly() && Looper.getMainLooper().getThread() != Thread.currentThread();
        }
    }
}
