package io.sentry.android.core.internal.threaddump;

import io.sentry.SentryLevel;
import io.sentry.SentryLockReason;
import io.sentry.SentryOptions;
import io.sentry.SentryStackTraceFactory;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class ThreadDumpParser {
    private final boolean isBackground;
    private final SentryOptions options;
    private final SentryStackTraceFactory stackTraceFactory;
    private static final Pattern BEGIN_MANAGED_THREAD_RE = Pattern.compile("\"(.*)\" (.*) ?prio=(\\d+)\\s+tid=(\\d+)\\s*(.*)");
    private static final Pattern BEGIN_UNMANAGED_NATIVE_THREAD_RE = Pattern.compile("\"(.*)\" (.*) ?sysTid=(\\d+)");
    private static final Pattern NATIVE_RE = Pattern.compile(" *(?:native: )?#(\\d+) \\S+ ([0-9a-fA-F]+)\\s+((.*?)(?:\\s+\\(deleted\\))?(?:\\s+\\(offset (.*?)\\))?)(?:\\s+\\((?:\\?\\?\\?|(.*?)(?:\\+(\\d+))?)\\))?(?:\\s+\\(BuildId: (.*?)\\))?");
    private static final Pattern JAVA_RE = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\((.*):([\\d-]+)\\)");
    private static final Pattern JNI_RE = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\(Native method\\)");
    private static final Pattern LOCKED_RE = Pattern.compile(" *- locked \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern SLEEPING_ON_RE = Pattern.compile(" *- sleeping on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern WAITING_ON_RE = Pattern.compile(" *- waiting on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern WAITING_TO_LOCK_RE = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern WAITING_TO_LOCK_HELD_RE = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)(?: held by thread (\\d+))");
    private static final Pattern WAITING_TO_LOCK_UNKNOWN_RE = Pattern.compile(" *- waiting to lock an unknown object");
    private static final Pattern BLANK_RE = Pattern.compile("\\s+");
    private final Map<String, DebugImage> debugImages = new HashMap();
    private final List<SentryThread> threads = new ArrayList();

    public ThreadDumpParser(@NotNull SentryOptions sentryOptions, boolean z) {
        this.options = sentryOptions;
        this.isBackground = z;
        this.stackTraceFactory = new SentryStackTraceFactory(sentryOptions);
    }

    public List<DebugImage> getDebugImages() {
        return new ArrayList(this.debugImages.values());
    }

    public List<SentryThread> getThreads() {
        return this.threads;
    }

    private static String buildIdToDebugId(@NotNull String str) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new BigInteger("10" + str, 16).toByteArray());
            byteBufferWrap.get();
            return String.format("%08x-%04x-%04x-%04x-%04x%08x", Integer.valueOf(byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN).getInt()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.order(ByteOrder.BIG_ENDIAN).getShort()), Short.valueOf(byteBufferWrap.getShort()), Integer.valueOf(byteBufferWrap.getInt()));
        } catch (NumberFormatException | BufferUnderflowException unused) {
            return null;
        }
    }

    public void parse(@NotNull Lines lines) {
        Matcher matcher = BEGIN_MANAGED_THREAD_RE.matcher("");
        Matcher matcher2 = BEGIN_UNMANAGED_NATIVE_THREAD_RE.matcher("");
        while (lines.hasNext()) {
            Line next = lines.next();
            if (next == null) {
                this.options.getLogger().log(SentryLevel.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                return;
            }
            String str = next.text;
            if (matches(matcher, str) || matches(matcher2, str)) {
                lines.rewind();
                SentryThread thread = parseThread(lines);
                if (thread != null) {
                    this.threads.add(thread);
                }
            }
        }
    }

    private SentryThread parseThread(@NotNull Lines lines) {
        SentryThread sentryThread = new SentryThread();
        Matcher matcher = BEGIN_MANAGED_THREAD_RE.matcher("");
        Matcher matcher2 = BEGIN_UNMANAGED_NATIVE_THREAD_RE.matcher("");
        if (!lines.hasNext()) {
            return null;
        }
        Line next = lines.next();
        boolean z = false;
        if (next == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "Internal error while parsing thread dump.", new Object[0]);
            return null;
        }
        if (matches(matcher, next.text)) {
            Long l = getLong(matcher, 4, null);
            if (l == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            sentryThread.setId(l);
            sentryThread.setName(matcher.group(1));
            String strGroup = matcher.group(5);
            if (strGroup != null) {
                if (strGroup.contains(StringUtils.SPACE)) {
                    sentryThread.setState(strGroup.substring(0, strGroup.indexOf(32)));
                } else {
                    sentryThread.setState(strGroup);
                }
            }
        } else if (matches(matcher2, next.text)) {
            Long l2 = getLong(matcher2, 3, null);
            if (l2 == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            sentryThread.setId(l2);
            sentryThread.setName(matcher2.group(1));
        }
        String name = sentryThread.getName();
        if (name != null) {
            boolean zEquals = name.equals(SentryThread.JsonKeys.MAIN);
            sentryThread.setMain(Boolean.valueOf(zEquals));
            sentryThread.setCrashed(Boolean.valueOf(zEquals));
            if (zEquals && !this.isBackground) {
                z = true;
            }
            sentryThread.setCurrent(Boolean.valueOf(z));
        }
        sentryThread.setStacktrace(parseStacktrace(lines, sentryThread));
        return sentryThread;
    }

    private SentryStackTrace parseStacktrace(@NotNull Lines lines, @NotNull SentryThread sentryThread) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = NATIVE_RE.matcher("");
        Matcher matcher2 = JAVA_RE.matcher("");
        Matcher matcher3 = JNI_RE.matcher("");
        Matcher matcher4 = LOCKED_RE.matcher("");
        Matcher matcher5 = WAITING_ON_RE.matcher("");
        Matcher matcher6 = SLEEPING_ON_RE.matcher("");
        Matcher matcher7 = WAITING_TO_LOCK_HELD_RE.matcher("");
        Matcher matcher8 = WAITING_TO_LOCK_RE.matcher("");
        Matcher matcher9 = WAITING_TO_LOCK_UNKNOWN_RE.matcher("");
        Matcher matcher10 = BLANK_RE.matcher("");
        SentryStackFrame sentryStackFrame = null;
        while (lines.hasNext()) {
            Line next = lines.next();
            if (next == null) {
                this.options.getLogger().log(SentryLevel.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                break;
            }
            String str = next.text;
            Matcher matcher11 = matcher10;
            if (matches(matcher2, str)) {
                sentryStackFrame = new SentryStackFrame();
                String str2 = String.format("%s.%s", matcher2.group(1), matcher2.group(2));
                sentryStackFrame.setModule(str2);
                sentryStackFrame.setFunction(matcher2.group(3));
                sentryStackFrame.setFilename(matcher2.group(4));
                sentryStackFrame.setLineno(getUInteger(matcher2, 5, null));
                sentryStackFrame.setInApp(this.stackTraceFactory.isInApp(str2));
                arrayList.add(sentryStackFrame);
                matcher2 = matcher2;
            } else {
                if (matches(matcher, str)) {
                    SentryStackFrame sentryStackFrame2 = new SentryStackFrame();
                    sentryStackFrame2.setPackage(matcher.group(3));
                    sentryStackFrame2.setFunction(matcher.group(6));
                    sentryStackFrame2.setLineno(getInteger(matcher, 7, null));
                    sentryStackFrame2.setInstructionAddr("0x" + matcher.group(2));
                    sentryStackFrame2.setPlatform("native");
                    String strGroup = matcher.group(8);
                    String strBuildIdToDebugId = strGroup == null ? null : buildIdToDebugId(strGroup);
                    if (strBuildIdToDebugId != null) {
                        if (!this.debugImages.containsKey(strBuildIdToDebugId)) {
                            DebugImage debugImage = new DebugImage();
                            debugImage.setDebugId(strBuildIdToDebugId);
                            debugImage.setType("elf");
                            debugImage.setCodeFile(matcher.group(4));
                            debugImage.setCodeId(strGroup);
                            this.debugImages.put(strBuildIdToDebugId, debugImage);
                        }
                        sentryStackFrame2.setAddrMode("rel:" + strBuildIdToDebugId);
                    } else {
                        matcher2 = matcher2;
                    }
                    arrayList.add(sentryStackFrame2);
                    matcher10 = matcher11;
                    sentryStackFrame = null;
                } else {
                    matcher2 = matcher2;
                    if (matches(matcher3, str)) {
                        sentryStackFrame = new SentryStackFrame();
                        String str3 = String.format("%s.%s", matcher3.group(1), matcher3.group(2));
                        sentryStackFrame.setModule(str3);
                        sentryStackFrame.setFunction(matcher3.group(3));
                        sentryStackFrame.setInApp(this.stackTraceFactory.isInApp(str3));
                        sentryStackFrame.setNative(Boolean.TRUE);
                        arrayList.add(sentryStackFrame);
                    } else if (matches(matcher4, str)) {
                        if (sentryStackFrame != null) {
                            SentryLockReason sentryLockReason = new SentryLockReason();
                            sentryLockReason.setType(1);
                            sentryLockReason.setAddress(matcher4.group(1));
                            sentryLockReason.setPackageName(matcher4.group(2));
                            sentryLockReason.setClassName(matcher4.group(3));
                            sentryStackFrame.setLock(sentryLockReason);
                            combineThreadLocks(sentryThread, sentryLockReason);
                        }
                    } else if (matches(matcher5, str)) {
                        if (sentryStackFrame != null) {
                            SentryLockReason sentryLockReason2 = new SentryLockReason();
                            sentryLockReason2.setType(2);
                            sentryLockReason2.setAddress(matcher5.group(1));
                            sentryLockReason2.setPackageName(matcher5.group(2));
                            sentryLockReason2.setClassName(matcher5.group(3));
                            sentryStackFrame.setLock(sentryLockReason2);
                            combineThreadLocks(sentryThread, sentryLockReason2);
                        }
                    } else if (!matches(matcher6, str)) {
                        if (!matches(matcher7, str)) {
                            if (!matches(matcher8, str)) {
                                if (!matches(matcher9, str)) {
                                    if (str.length() == 0) {
                                        break;
                                    }
                                    matcher10 = matcher11;
                                    if (matches(matcher10, str)) {
                                        break;
                                    }
                                } else if (sentryStackFrame != null) {
                                    SentryLockReason sentryLockReason3 = new SentryLockReason();
                                    sentryLockReason3.setType(8);
                                    sentryStackFrame.setLock(sentryLockReason3);
                                    combineThreadLocks(sentryThread, sentryLockReason3);
                                }
                            } else if (sentryStackFrame != null) {
                                SentryLockReason sentryLockReason4 = new SentryLockReason();
                                sentryLockReason4.setType(8);
                                sentryLockReason4.setAddress(matcher8.group(1));
                                sentryLockReason4.setPackageName(matcher8.group(2));
                                sentryLockReason4.setClassName(matcher8.group(3));
                                sentryStackFrame.setLock(sentryLockReason4);
                                combineThreadLocks(sentryThread, sentryLockReason4);
                            }
                        } else if (sentryStackFrame != null) {
                            SentryLockReason sentryLockReason5 = new SentryLockReason();
                            sentryLockReason5.setType(8);
                            sentryLockReason5.setAddress(matcher7.group(1));
                            sentryLockReason5.setPackageName(matcher7.group(2));
                            sentryLockReason5.setClassName(matcher7.group(3));
                            sentryLockReason5.setThreadId(getLong(matcher7, 4, null));
                            sentryStackFrame.setLock(sentryLockReason5);
                            combineThreadLocks(sentryThread, sentryLockReason5);
                        }
                        matcher10 = matcher11;
                    } else if (sentryStackFrame != null) {
                        SentryLockReason sentryLockReason6 = new SentryLockReason();
                        sentryLockReason6.setType(4);
                        sentryLockReason6.setAddress(matcher6.group(1));
                        sentryLockReason6.setPackageName(matcher6.group(2));
                        sentryLockReason6.setClassName(matcher6.group(3));
                        sentryStackFrame.setLock(sentryLockReason6);
                        combineThreadLocks(sentryThread, sentryLockReason6);
                    }
                }
                matcher2 = matcher2;
            }
            matcher10 = matcher11;
            matcher2 = matcher2;
        }
        Collections.reverse(arrayList);
        SentryStackTrace sentryStackTrace = new SentryStackTrace(arrayList);
        sentryStackTrace.setSnapshot(Boolean.TRUE);
        return sentryStackTrace;
    }

    private boolean matches(@NotNull Matcher matcher, @NotNull String str) {
        matcher.reset(str);
        return matcher.matches();
    }

    private void combineThreadLocks(@NotNull SentryThread sentryThread, @NotNull SentryLockReason sentryLockReason) {
        Map<String, SentryLockReason> heldLocks = sentryThread.getHeldLocks();
        if (heldLocks == null) {
            heldLocks = new HashMap<>();
        }
        SentryLockReason sentryLockReason2 = heldLocks.get(sentryLockReason.getAddress());
        if (sentryLockReason2 != null) {
            sentryLockReason2.setType(Math.max(sentryLockReason2.getType(), sentryLockReason.getType()));
        } else {
            heldLocks.put(sentryLockReason.getAddress(), new SentryLockReason(sentryLockReason));
        }
        sentryThread.setHeldLocks(heldLocks);
    }

    private Long getLong(@NotNull Matcher matcher, int i, @Nullable Long l) {
        String strGroup = matcher.group(i);
        return (strGroup == null || strGroup.length() == 0) ? l : Long.valueOf(Long.parseLong(strGroup));
    }

    private Integer getInteger(@NotNull Matcher matcher, int i, @Nullable Integer num) {
        String strGroup = matcher.group(i);
        return (strGroup == null || strGroup.length() == 0) ? num : Integer.valueOf(Integer.parseInt(strGroup));
    }

    private Integer getUInteger(@NotNull Matcher matcher, int i, @Nullable Integer num) {
        int i2;
        String strGroup = matcher.group(i);
        return (strGroup == null || strGroup.length() == 0 || (i2 = Integer.parseInt(strGroup)) < 0) ? num : Integer.valueOf(i2);
    }
}
