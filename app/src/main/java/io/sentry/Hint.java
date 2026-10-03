package io.sentry;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.util.AutoClosableReentrantLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Hint {
    private static final Map<String, Class<?>> PRIMITIVE_MAPPINGS;
    private final Map<String, Object> internalStorage = new HashMap();
    private final List<Attachment> attachments = new ArrayList();
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private Attachment screenshot = null;
    private Attachment viewHierarchy = null;
    private Attachment threadDump = null;
    private ReplayRecording replayRecording = null;

    static {
        HashMap map = new HashMap();
        PRIMITIVE_MAPPINGS = map;
        map.put(TypedValues.Custom.S_BOOLEAN, Boolean.class);
        map.put("char", Character.class);
        map.put(ProfileMeasurement.UNIT_BYTES, Byte.class);
        map.put("short", Short.class);
        map.put("int", Integer.class);
        map.put("long", Long.class);
        map.put(TypedValues.Custom.S_FLOAT, Float.class);
        map.put("double", Double.class);
    }

    public static Hint withAttachment(@Nullable Attachment attachment) {
        Hint hint = new Hint();
        hint.addAttachment(attachment);
        return hint;
    }

    public static Hint withAttachments(@Nullable List<Attachment> list) {
        Hint hint = new Hint();
        hint.addAttachments(list);
        return hint;
    }

    public void set(@NotNull String str, @Nullable Object obj) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.internalStorage.put(str, obj);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Object get(@NotNull String str) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object obj = this.internalStorage.get(str);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return obj;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public <T> T getAs(@NotNull String str, @NotNull Class<T> cls) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            T t = (T) this.internalStorage.get(str);
            if (cls.isInstance(t)) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return t;
            }
            if (isCastablePrimitive(t, cls)) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return t;
            }
            if (iSentryLifecycleTokenAcquire == null) {
                return null;
            }
            iSentryLifecycleTokenAcquire.close();
            return null;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void remove(@NotNull String str) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.internalStorage.remove(str);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void addAttachment(@Nullable Attachment attachment) {
        if (attachment != null) {
            this.attachments.add(attachment);
        }
    }

    public void addAttachments(@Nullable List<Attachment> list) {
        if (list != null) {
            this.attachments.addAll(list);
        }
    }

    public List<Attachment> getAttachments() {
        return new ArrayList(this.attachments);
    }

    public void replaceAttachments(@Nullable List<Attachment> list) {
        clearAttachments();
        addAttachments(list);
    }

    public void clearAttachments() {
        this.attachments.clear();
    }

    public void clear() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Iterator<Map.Entry<String, Object>> it2 = this.internalStorage.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Object> next = it2.next();
                if (next.getKey() == null || !next.getKey().startsWith("sentry:")) {
                    it2.remove();
                }
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setScreenshot(@Nullable Attachment attachment) {
        this.screenshot = attachment;
    }

    public Attachment getScreenshot() {
        return this.screenshot;
    }

    public void setViewHierarchy(@Nullable Attachment attachment) {
        this.viewHierarchy = attachment;
    }

    public Attachment getViewHierarchy() {
        return this.viewHierarchy;
    }

    public void setThreadDump(@Nullable Attachment attachment) {
        this.threadDump = attachment;
    }

    public Attachment getThreadDump() {
        return this.threadDump;
    }

    public ReplayRecording getReplayRecording() {
        return this.replayRecording;
    }

    public void setReplayRecording(@Nullable ReplayRecording replayRecording) {
        this.replayRecording = replayRecording;
    }

    private boolean isCastablePrimitive(@Nullable Object obj, @NotNull Class<?> cls) {
        Class<?> cls2 = PRIMITIVE_MAPPINGS.get(cls.getCanonicalName());
        return obj != null && cls.isPrimitive() && cls2 != null && cls2.isInstance(obj);
    }
}
