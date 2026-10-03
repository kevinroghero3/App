package net.time4j.calendar.bahai;

import com.salesforce.marketingcloud.push.g;

/* JADX INFO: loaded from: classes6.dex */
public enum FormattedContent {
    TRANSCRIPTION { // from class: net.time4j.calendar.bahai.FormattedContent.1
        @Override // net.time4j.calendar.bahai.FormattedContent
        String variant() {
            return g.g;
        }
    },
    MEANING { // from class: net.time4j.calendar.bahai.FormattedContent.2
        @Override // net.time4j.calendar.bahai.FormattedContent
        String variant() {
            return "m";
        }
    },
    HTML { // from class: net.time4j.calendar.bahai.FormattedContent.3
        @Override // net.time4j.calendar.bahai.FormattedContent
        String variant() {
            return "h";
        }
    };

    abstract String variant();
}
