package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class KmsClients {
    private static List<KmsClient> autoClients;
    private static final CopyOnWriteArrayList<KmsClient> clients = new CopyOnWriteArrayList<>();

    public static void add(KmsClient kmsClient) {
        clients.add(kmsClient);
    }

    public static KmsClient get(String str) throws GeneralSecurityException {
        for (KmsClient kmsClient : clients) {
            if (kmsClient.doesSupport(str)) {
                return kmsClient;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }

    @Deprecated
    public static KmsClient getAutoLoaded(String str) throws GeneralSecurityException {
        KmsClient next;
        synchronized (KmsClients.class) {
            if (autoClients == null) {
                autoClients = loadAutoKmsClients();
            }
            Iterator<KmsClient> it2 = autoClients.iterator();
            while (it2.hasNext()) {
                next = it2.next();
                if (next.doesSupport(str)) {
                }
            }
            throw new GeneralSecurityException("No KMS client does support: " + str);
        }
        return next;
    }

    static void reset() {
        clients.clear();
    }

    private static List<KmsClient> loadAutoKmsClients() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ServiceLoader.load(KmsClient.class).iterator();
        while (it2.hasNext()) {
            arrayList.add((KmsClient) it2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private KmsClients() {
    }
}
