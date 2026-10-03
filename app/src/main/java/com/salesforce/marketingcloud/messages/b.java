package com.salesforce.marketingcloud.messages;

import android.text.TextUtils;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.storage.i;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String a = d.B;

    private b() {
    }

    static void a(Message message, h hVar) throws Exception {
        long millis;
        Date date = new Date();
        com.salesforce.marketingcloud.internal.h.a(message, date);
        com.salesforce.marketingcloud.internal.h.c(message, com.salesforce.marketingcloud.internal.h.e(message) + 1);
        int iB = b(message);
        if (iB > -1 && message.numberOfPeriods() > -1 && message.periodType() != 0) {
            com.salesforce.marketingcloud.internal.h.b(message, com.salesforce.marketingcloud.internal.h.d(message) + 1);
            if (com.salesforce.marketingcloud.internal.h.d(message) >= message.messagesPerPeriod()) {
                int iPeriodType = message.periodType();
                if (iPeriodType == 1) {
                    millis = TimeUnit.DAYS.toMillis(Calendar.getInstance().getActualMaximum(6));
                } else if (iPeriodType == 2) {
                    millis = TimeUnit.DAYS.toMillis(Calendar.getInstance().getActualMaximum(5));
                } else if (iPeriodType == 3) {
                    millis = TimeUnit.DAYS.toMillis(7L);
                } else if (iPeriodType != 4) {
                    millis = iPeriodType != 5 ? 0L : TimeUnit.HOURS.toMillis(1L);
                } else {
                    millis = TimeUnit.DAYS.toMillis(1L);
                }
                com.salesforce.marketingcloud.internal.h.b(message, new Date(date.getTime() + (((long) message.numberOfPeriods()) * millis)));
                if (!message.isRollingPeriod()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(com.salesforce.marketingcloud.internal.h.b(message).getTime());
                    calendar.set(14, 0);
                    calendar.set(13, 0);
                    int iPeriodType2 = message.periodType();
                    if (iPeriodType2 == 1) {
                        calendar.set(2, 0);
                        calendar.set(5, 1);
                        calendar.set(10, 0);
                        calendar.set(12, 0);
                    } else if (iPeriodType2 == 2) {
                        calendar.set(5, 1);
                        calendar.set(10, 0);
                        calendar.set(12, 0);
                    } else if (iPeriodType2 == 3) {
                        calendar.set(7, 1);
                        calendar.set(10, 0);
                        calendar.set(12, 0);
                    } else if (iPeriodType2 == 4) {
                        calendar.set(10, 0);
                        calendar.set(12, 0);
                    } else if (iPeriodType2 == 5) {
                        calendar.set(12, 0);
                    }
                    com.salesforce.marketingcloud.internal.h.b(message, calendar.getTime());
                }
            }
        }
        if (com.salesforce.marketingcloud.internal.h.d(message) > -1 && iB > -1 && com.salesforce.marketingcloud.internal.h.d(message) > iB) {
            com.salesforce.marketingcloud.internal.h.b(message, 0);
        }
        hVar.n().a(message, hVar.b());
    }

    private static int b(Message message) {
        int iMessagesPerPeriod = message.messagesPerPeriod();
        if (iMessagesPerPeriod > 0 || message.numberOfPeriods() <= 0 || message.periodType() == 0) {
            return iMessagesPerPeriod;
        }
        return 1;
    }

    static boolean c(Message message) {
        try {
            if (TextUtils.isEmpty(message.alert().trim())) {
                g.a(a, "Message (%s) was tripped, but does not have an alert message", message.id());
                return false;
            }
            Date date = new Date();
            if (message.endDateUtc() != null && message.endDateUtc().before(date)) {
                g.a(a, "Message (%s) was tripped, but has expired.", message.id());
                return false;
            }
            if (message.startDateUtc() != null && message.startDateUtc().after(date)) {
                g.a(a, "Message (%s) was tripped, but has not started", message.id());
                return false;
            }
            if (message.messageLimit() > -1 && com.salesforce.marketingcloud.internal.h.e(message) >= message.messageLimit()) {
                g.a(a, "Message (%s) was tripped, but has met its message limit.", message.id());
                return false;
            }
            int iB = b(message);
            if (iB > -1 && com.salesforce.marketingcloud.internal.h.d(message) >= iB && com.salesforce.marketingcloud.internal.h.b(message) != null && date.before(com.salesforce.marketingcloud.internal.h.b(message))) {
                g.a(a, "Message (%s) was tripped, but has met its message per period limit", message.id());
                return false;
            }
            if (com.salesforce.marketingcloud.internal.h.b(message) == null || !date.before(com.salesforce.marketingcloud.internal.h.b(message))) {
                return true;
            }
            g.a(a, "Message (%s) was tripped, but was before its next allowed show time.", message.id());
            return false;
        } catch (Exception e) {
            g.b(a, e, "Failed to determine is message should be shown.", new Object[0]);
            return false;
        }
    }

    public static void a(Message message, i iVar, Crypto crypto) {
        Message messageA = iVar.a(message.id(), crypto);
        if (messageA != null) {
            com.salesforce.marketingcloud.internal.h.a(message, com.salesforce.marketingcloud.internal.h.a(messageA));
            com.salesforce.marketingcloud.internal.h.c(message, com.salesforce.marketingcloud.internal.h.e(messageA));
            if (message.periodType() == messageA.periodType()) {
                com.salesforce.marketingcloud.internal.h.b(message, com.salesforce.marketingcloud.internal.h.d(messageA));
                com.salesforce.marketingcloud.internal.h.b(message, com.salesforce.marketingcloud.internal.h.b(messageA));
            }
        }
    }

    public static boolean a(Message message) {
        Date dateEndDateUtc = message.endDateUtc();
        return dateEndDateUtc == null || dateEndDateUtc.getTime() >= System.currentTimeMillis();
    }
}
