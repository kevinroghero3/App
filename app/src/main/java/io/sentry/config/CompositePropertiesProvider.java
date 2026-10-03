package io.sentry.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
final class CompositePropertiesProvider implements PropertiesProvider {
    private final List<PropertiesProvider> providers;

    public CompositePropertiesProvider(@NotNull List<PropertiesProvider> list) {
        this.providers = list;
    }

    @Override // io.sentry.config.PropertiesProvider
    public String getProperty(@NotNull String str) {
        Iterator<PropertiesProvider> it2 = this.providers.iterator();
        while (it2.hasNext()) {
            String property = it2.next().getProperty(str);
            if (property != null) {
                return property;
            }
        }
        return null;
    }

    @Override // io.sentry.config.PropertiesProvider
    public Map<String, String> getMap(@NotNull String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator<PropertiesProvider> it2 = this.providers.iterator();
        while (it2.hasNext()) {
            concurrentHashMap.putAll(it2.next().getMap(str));
        }
        return concurrentHashMap;
    }
}
