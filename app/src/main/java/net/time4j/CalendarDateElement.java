package net.time4j;

/* JADX INFO: loaded from: classes3.dex */
public interface CalendarDateElement extends ZonalElement<PlainDate> {
    ElementOperator<PlainDate> firstDayOfNextMonth();

    ElementOperator<PlainDate> firstDayOfNextQuarter();

    ElementOperator<PlainDate> firstDayOfNextYear();

    ElementOperator<PlainDate> lastDayOfPreviousMonth();

    ElementOperator<PlainDate> lastDayOfPreviousQuarter();

    ElementOperator<PlainDate> lastDayOfPreviousYear();
}
