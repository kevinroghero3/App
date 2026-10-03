package io.sentry.internal.modules;

import io.sentry.ILogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CompositeModulesLoader extends ModulesLoader {
    private final List<IModulesLoader> loaders;

    public CompositeModulesLoader(@NotNull List<IModulesLoader> list, @NotNull ILogger iLogger) {
        super(iLogger);
        this.loaders = list;
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    protected Map<String, String> loadModules() {
        TreeMap treeMap = new TreeMap();
        Iterator<IModulesLoader> it2 = this.loaders.iterator();
        while (it2.hasNext()) {
            Map<String, String> orLoadModules = it2.next().getOrLoadModules();
            if (orLoadModules != null) {
                treeMap.putAll(orLoadModules);
            }
        }
        return treeMap;
    }
}
