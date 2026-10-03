package net.time4j.history;

import com.salesforce.marketingcloud.messages.inbox.b;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayElement;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.history.internal.HistoricAttribute;

/* JADX INFO: loaded from: classes3.dex */
final class HistoricEraElement extends DisplayElement<HistoricEra> implements TextElement<HistoricEra> {
    private static final Locale LATIN = new Locale("la");
    private static final long serialVersionUID = 5200533417265981438L;
    private final ChronoHistory history;

    @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
    public char getSymbol() {
        return 'G';
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    HistoricEraElement(ChronoHistory chronoHistory) {
        super("ERA");
        this.history = chronoHistory;
    }

    @Override // net.time4j.engine.ChronoElement
    public Class<HistoricEra> getType() {
        return HistoricEra.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public HistoricEra getDefaultMinimum() {
        return HistoricEra.BC;
    }

    @Override // net.time4j.engine.ChronoElement
    public HistoricEra getDefaultMaximum() {
        return HistoricEra.AD;
    }

    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(accessor(attributeQuery).print((Enum) chronoDisplay.get(this)));
    }

    @Override // net.time4j.format.TextElement
    public HistoricEra parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        return (HistoricEra) accessor(attributeQuery).parse(charSequence, parsePosition, getType(), attributeQuery);
    }

    @Override // net.time4j.engine.BasicElement
    public <T extends ChronoEntity<T>> ElementRule<T, HistoricEra> derive(Chronology<T> chronology) {
        if (chronology.isRegistered(PlainDate.COMPONENT)) {
            return new Rule(this.history);
        }
        return null;
    }

    @Override // net.time4j.engine.BasicElement
    public boolean doEquals(BasicElement<?> basicElement) {
        return this.history.equals(((HistoricEraElement) basicElement).history);
    }

    private TextAccessor accessor(AttributeQuery attributeQuery) {
        AttributeKey<TextWidth> attributeKey = Attributes.TEXT_WIDTH;
        TextWidth textWidth = TextWidth.WIDE;
        TextWidth textWidth2 = (TextWidth) attributeQuery.get(attributeKey, textWidth);
        AttributeKey<Boolean> attributeKey2 = HistoricAttribute.LATIN_ERA;
        Boolean bool = Boolean.FALSE;
        if (((Boolean) attributeQuery.get(attributeKey2, bool)).booleanValue()) {
            return CalendarText.getInstance("historic", LATIN).getTextForms(this, textWidth2 != textWidth ? "a" : "w");
        }
        CalendarText isoInstance = CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
        if (((Boolean) attributeQuery.get(HistoricAttribute.COMMON_ERA, bool)).booleanValue()) {
            return isoInstance.getTextForms(this, textWidth2 != textWidth ? "a" : "w", b.l);
        }
        return isoInstance.getEras(textWidth2);
    }

    private Object readResolve() throws ObjectStreamException {
        return this.history.era();
    }

    static class Rule<C extends ChronoEntity<C>> implements ElementRule<C, HistoricEra> {
        private final ChronoHistory history;

        Rule(ChronoHistory chronoHistory) {
            this.history = chronoHistory;
        }

        @Override // net.time4j.engine.ElementRule
        public HistoricEra getValue(C c) {
            try {
                return this.history.convert((PlainDate) c.get(PlainDate.COMPONENT)).getEra();
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public HistoricEra getMinimum(C c) {
            HistoricEra value = getValue((ChronoEntity) c);
            return value == HistoricEra.AD ? HistoricEra.BC : value;
        }

        @Override // net.time4j.engine.ElementRule
        public HistoricEra getMaximum(C c) {
            HistoricEra value = getValue((ChronoEntity) c);
            return value == HistoricEra.BC ? HistoricEra.AD : value;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(C c, HistoricEra historicEra) {
            if (historicEra == null) {
                return false;
            }
            try {
                return this.history.convert((PlainDate) c.get(PlainDate.COMPONENT)).getEra() == historicEra;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public C withValue2(C c, HistoricEra historicEra, boolean z) {
            if (historicEra == null) {
                throw new IllegalArgumentException("Missing era value.");
            }
            if (this.history.convert((PlainDate) c.get(PlainDate.COMPONENT)).getEra() == historicEra) {
                return c;
            }
            throw new IllegalArgumentException(historicEra.name());
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(C c) {
            throw new UnsupportedOperationException("Never called.");
        }
    }
}
