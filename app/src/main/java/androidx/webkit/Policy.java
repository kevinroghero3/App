package androidx.webkit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.support_lib_boundary.WebViewBuilderBoundaryInterface;

/* JADX INFO: loaded from: classes4.dex */
public final class Policy {
    private final List<ConfigRunnable> mBehaviors;

    interface ConfigRunnable {
        void configure(WebViewBuilderBoundaryInterface.Config config) throws WebViewBuilderException;
    }

    private Policy(List<ConfigRunnable> list) {
        this.mBehaviors = list;
    }

    void configure(WebViewBuilderBoundaryInterface.Config config) throws WebViewBuilderException {
        Iterator<ConfigRunnable> it2 = this.mBehaviors.iterator();
        while (it2.hasNext()) {
            it2.next().configure(config);
        }
    }

    public static final class Builder {
        final List<ConfigRunnable> mBehaviors = new ArrayList();

        public Policy build() {
            return new Policy(this.mBehaviors);
        }
    }
}
