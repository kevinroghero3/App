package org.joda.convert;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.GenericDeclaration;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public final class RenameHandler {
    private volatile boolean locked;
    private static final boolean LOG = StringConvert.LOG;
    public static final RenameHandler INSTANCE = createInstance();
    private final ConcurrentHashMap<String, Class<?>> typeRenames = new ConcurrentHashMap<>(16, 0.75f, 2);
    private final ConcurrentHashMap<Class<?>, Map<String, Enum<?>>> enumRenames = new ConcurrentHashMap<>(16, 0.75f, 2);

    private static RenameHandler createInstance() {
        RenameHandler renameHandlerCreate = create(false);
        try {
            renameHandlerCreate.loadFromClasspath();
        } catch (IllegalStateException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } catch (Throwable th) {
            System.err.println("ERROR: Failed to load Renamed.ini files: " + th.getMessage());
            th.printStackTrace();
        }
        return renameHandlerCreate;
    }

    public static RenameHandler create() {
        return new RenameHandler();
    }

    public static RenameHandler create(boolean z) {
        RenameHandler renameHandler = new RenameHandler();
        if (z) {
            renameHandler.loadFromClasspath();
        }
        return renameHandler;
    }

    private RenameHandler() {
    }

    public void renamedType(String str, Class<?> cls) {
        if (str == null) {
            throw new IllegalArgumentException("oldName must not be null");
        }
        if (cls == null) {
            throw new IllegalArgumentException("currentValue must not be null");
        }
        if (str.startsWith("java.") || str.startsWith("javax.") || str.startsWith("org.joda.")) {
            throw new IllegalArgumentException("oldName must not be a java.*, javax.* or org.joda.* type");
        }
        checkNotLocked();
        this.typeRenames.put(str, cls);
    }

    public Map<String, Class<?>> getTypeRenames() {
        return new HashMap(this.typeRenames);
    }

    public Class<?> lookupType(String str) throws ClassNotFoundException {
        if (str == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Class<?> cls = this.typeRenames.get(str);
        return cls == null ? StringConvert.loadType(str) : cls;
    }

    public void renamedEnum(String str, Enum<?> r8) {
        if (str == null) {
            throw new IllegalArgumentException("oldName must not be null");
        }
        if (r8 == null) {
            throw new IllegalArgumentException("currentValue must not be null");
        }
        checkNotLocked();
        GenericDeclaration declaringClass = r8.getDeclaringClass();
        Map<String, Enum<?>> map = this.enumRenames.get(declaringClass);
        if (map == null) {
            this.enumRenames.putIfAbsent((Class<?>) declaringClass, new ConcurrentHashMap(16, 0.75f, 2));
            map = this.enumRenames.get(declaringClass);
        }
        map.put(str, r8);
    }

    public Set<Class<?>> getEnumTypesWithRenames() {
        return new HashSet(this.enumRenames.keySet());
    }

    public Map<String, Enum<?>> getEnumRenames(Class<?> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type must not be null");
        }
        Map<String, Enum<?>> map = this.enumRenames.get(cls);
        if (map == null) {
            return new HashMap();
        }
        return new HashMap(map);
    }

    public <T extends Enum<T>> T lookupEnum(Class<T> cls, String str) {
        if (cls == null) {
            throw new IllegalArgumentException("type must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Enum<?> r0 = getEnumRenames(cls).get(str);
        if (r0 != null) {
            return cls.cast(r0);
        }
        return (T) Enum.valueOf(cls, str);
    }

    public void lock() {
        checkNotLocked();
        this.locked = true;
    }

    private void checkNotLocked() {
        if (this.locked) {
            throw new IllegalStateException("RenameHandler has been locked and it cannot now be changed");
        }
    }

    private void loadFromClasspath() {
        URL urlNextElement;
        Exception e;
        URL url = null;
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = RenameHandler.class.getClassLoader();
            }
            if (LOG) {
                System.err.println("Loading from classpath: " + contextClassLoader);
            }
            Enumeration<URL> resources = contextClassLoader.getResources("META-INF/org/joda/convert/Renamed.ini");
            while (resources.hasMoreElements()) {
                urlNextElement = resources.nextElement();
                try {
                    if (LOG) {
                        System.err.println("Loading file: " + urlNextElement);
                    }
                    parseRenameFile(loadRenameFile(urlNextElement), urlNextElement);
                    url = urlNextElement;
                } catch (Exception e2) {
                    e = e2;
                    if (LOG) {
                        e.printStackTrace(System.err);
                    }
                    throw new IllegalStateException("Unable to load Renamed.ini: " + urlNextElement + ": " + e.getMessage(), e);
                }
            }
        } catch (Exception e3) {
            urlNextElement = url;
            e = e3;
        }
    }

    private List<String> loadRenameFile(URL url) throws IOException {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FirebasePerfUrlConnection.openStream(url), Charset.forName(CharEncoding.UTF_8)));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return arrayList;
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty() && !strTrim.startsWith("#")) {
                    arrayList.add(strTrim);
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    private void parseRenameFile(List<String> list, URL url) {
        boolean z = false;
        boolean z2 = false;
        for (String str : list) {
            try {
                if (str.equals("[types]")) {
                    z2 = false;
                    z = true;
                } else if (str.equals("[enums]")) {
                    z = false;
                    z2 = true;
                } else if (z) {
                    int iIndexOf = str.indexOf(61);
                    if (iIndexOf < 0) {
                        throw new IllegalArgumentException("Renamed.ini type line must be formatted as 'oldClassName = newClassName'");
                    }
                    String strTrim = str.substring(0, iIndexOf).trim();
                    String strTrim2 = str.substring(iIndexOf + 1).trim();
                    try {
                        renamedType(strTrim, StringConvert.loadType(strTrim2));
                    } catch (Throwable th) {
                        if (LOG) {
                            th.printStackTrace(System.err);
                        }
                        throw new IllegalArgumentException("Class.forName(" + strTrim2 + ") failed: " + th.getMessage());
                    }
                } else if (z2) {
                    int iIndexOf2 = str.indexOf(61);
                    int iLastIndexOf = str.lastIndexOf(46);
                    if (iIndexOf2 < 0 || iLastIndexOf < 0 || iLastIndexOf < iIndexOf2) {
                        throw new IllegalArgumentException("Renamed.ini enum line must be formatted as 'oldEnumConstantName = enumClassName.newEnumConstantName'");
                    }
                    renamedEnum(str.substring(0, iIndexOf2).trim(), Enum.valueOf(Class.forName(str.substring(iIndexOf2 + 1, iLastIndexOf).trim()).asSubclass(Enum.class), str.substring(iLastIndexOf + 1).trim()));
                } else {
                    throw new IllegalArgumentException("Renamed.ini must start with [types] or [enums]");
                }
            } catch (Exception e) {
                System.err.println("ERROR: Invalid Renamed.ini: " + url + ": " + e.getMessage());
            }
        }
    }

    public String toString() {
        return "RenamedTypes" + this.typeRenames + ",RenamedEnumConstants" + this.enumRenames;
    }
}
