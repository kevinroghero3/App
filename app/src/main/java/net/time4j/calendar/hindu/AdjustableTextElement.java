package net.time4j.calendar.hindu;

import net.time4j.calendar.hindu.HinduPrimitive;
import net.time4j.engine.ChronoOperator;
import net.time4j.format.TextElement;

/* JADX INFO: loaded from: classes6.dex */
public interface AdjustableTextElement<V extends HinduPrimitive> extends TextElement<V> {
    ChronoOperator<HinduCalendar> maximized();

    ChronoOperator<HinduCalendar> minimized();
}
