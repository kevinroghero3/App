package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableParametersRegistry {
    private static final MutableParametersRegistry globalInstance = new MutableParametersRegistry();
    private final Map<String, Parameters> parametersMap = new HashMap();

    MutableParametersRegistry() {
    }

    public static MutableParametersRegistry globalInstance() {
        return globalInstance;
    }

    public void put(String str, Parameters parameters) throws GeneralSecurityException {
        synchronized (this) {
            if (this.parametersMap.containsKey(str)) {
                if (this.parametersMap.get(str).equals(parameters)) {
                    return;
                }
                throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + this.parametersMap.get(str) + "), cannot insert " + parameters);
            }
            this.parametersMap.put(str, parameters);
        }
    }

    public Parameters get(String str) throws GeneralSecurityException {
        Parameters parameters;
        synchronized (this) {
            if (this.parametersMap.containsKey(str)) {
                parameters = this.parametersMap.get(str);
            } else {
                throw new GeneralSecurityException("Name " + str + " does not exist");
            }
        }
        return parameters;
    }

    public void putAll(Map<String, Parameters> map) throws GeneralSecurityException {
        synchronized (this) {
            for (Map.Entry<String, Parameters> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public List<String> getNames() {
        List<String> listUnmodifiableList;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.parametersMap.keySet());
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return listUnmodifiableList;
    }
}
