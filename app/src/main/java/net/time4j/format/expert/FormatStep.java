package net.time4j.format.expert;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.internal.DualFormatElement;

/* JADX INFO: loaded from: classes3.dex */
final class FormatStep {
    private final AttributeQuery fullAttrs;
    private final int lastOrBlockIndex;
    private final int level;
    private final boolean orMarker;
    private final int padLeft;
    private final int padRight;
    private final FormatProcessor<?> processor;
    private final int reserved;
    private final int section;
    private final AttributeSet sectionalAttrs;

    FormatStep(FormatProcessor<?> formatProcessor, int i, int i2, AttributeSet attributeSet) {
        this(formatProcessor, i, i2, attributeSet, null, 0, 0, 0, false, -1);
    }

    private FormatStep(FormatProcessor<?> formatProcessor, int i, int i2, AttributeSet attributeSet, AttributeQuery attributeQuery, int i3, int i4, int i5, boolean z, int i6) {
        if (formatProcessor == null) {
            throw new NullPointerException("Missing format processor.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Invalid level: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Invalid section: " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Reserved chars must not be negative: " + i3);
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Invalid pad-width: " + i4);
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Invalid pad-width: " + i5);
        }
        this.processor = formatProcessor;
        this.level = i;
        this.section = i2;
        this.sectionalAttrs = attributeSet;
        this.fullAttrs = attributeQuery;
        this.reserved = i3;
        this.padLeft = i4;
        this.padRight = i5;
        this.orMarker = z;
        this.lastOrBlockIndex = i6;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        StringBuilder sb;
        int length;
        LinkedHashSet linkedHashSet;
        int i;
        int length2;
        if (!isPrinting(chronoDisplay)) {
            return 0;
        }
        AttributeQuery query = z ? this.fullAttrs : getQuery(attributeQuery);
        if (this.padLeft == 0 && this.padRight == 0) {
            return this.processor.print(chronoDisplay, appendable, query, set, z);
        }
        if (appendable instanceof StringBuilder) {
            sb = (StringBuilder) appendable;
            length = sb.length();
        } else {
            sb = new StringBuilder();
            length = -1;
        }
        if (!(appendable instanceof CharSequence) || set == null) {
            linkedHashSet = null;
            i = -1;
        } else {
            if (sb == appendable) {
                FormatProcessor<?> formatProcessor = this.processor;
                if ((formatProcessor instanceof CustomizedProcessor) || (formatProcessor instanceof StyleProcessor)) {
                    length2 = 0;
                } else {
                    length2 = ((CharSequence) appendable).length();
                }
            } else {
                length2 = ((CharSequence) appendable).length();
            }
            linkedHashSet = new LinkedHashSet();
            i = length2;
        }
        LinkedHashSet<ElementPosition> linkedHashSet2 = linkedHashSet;
        boolean zIsStrict = isStrict(query);
        char padChar = getPadChar(query);
        int length3 = sb.length();
        this.processor.print(chronoDisplay, sb, query, linkedHashSet2, z);
        int length4 = sb.length() - length3;
        int i2 = this.padLeft;
        if (i2 <= 0) {
            if (zIsStrict && length4 > this.padRight) {
                throw new IllegalArgumentException(padExceeded());
            }
            if (length == -1) {
                appendable.append(sb);
            }
            while (length4 < this.padRight) {
                appendable.append(padChar);
                length4++;
            }
            if (i != -1) {
                for (ElementPosition elementPosition : linkedHashSet2) {
                    set.add(new ElementPosition(elementPosition.getElement(), elementPosition.getStartIndex() + i, elementPosition.getEndIndex() + i));
                }
            }
            return length4;
        }
        if (zIsStrict && length4 > i2) {
            throw new IllegalArgumentException(padExceeded());
        }
        int i3 = length4;
        int i4 = 0;
        while (i3 < this.padLeft) {
            if (length == -1) {
                appendable.append(padChar);
            } else {
                sb.insert(length, padChar);
            }
            i3++;
            i4++;
        }
        if (length == -1) {
            appendable.append(sb);
        }
        if (i != -1) {
            int i5 = i + i4;
            for (ElementPosition elementPosition2 : linkedHashSet2) {
                set.add(new ElementPosition(elementPosition2.getElement(), elementPosition2.getStartIndex() + i5, elementPosition2.getEndIndex() + i5));
            }
        }
        int i6 = this.padRight;
        if (i6 <= 0) {
            return i3;
        }
        if (zIsStrict && length4 > i6) {
            throw new IllegalArgumentException(padExceeded());
        }
        while (length4 < this.padRight) {
            appendable.append(padChar);
            length4++;
            i3++;
        }
        return i3;
    }

    void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int i;
        int i2;
        AttributeQuery query = z ? this.fullAttrs : getQuery(attributeQuery);
        if (this.padLeft == 0 && this.padRight == 0) {
            doParse(charSequence, parseLog, query, parsedEntity, z);
            return;
        }
        boolean zIsStrict = isStrict(query);
        char padChar = getPadChar(query);
        int position = parseLog.getPosition();
        int length = charSequence.length();
        int i3 = position;
        while (i3 < length && charSequence.charAt(i3) == padChar) {
            i3++;
        }
        int i4 = i3 - position;
        if (zIsStrict && i4 > this.padLeft) {
            parseLog.setError(position, padExceeded());
            return;
        }
        parseLog.setPosition(i3);
        doParse(charSequence, parseLog, query, parsedEntity, z);
        if (parseLog.isError()) {
            return;
        }
        int position2 = parseLog.getPosition();
        int i5 = (position2 - position) - i4;
        if (zIsStrict && (i2 = this.padLeft) > 0 && i4 + i5 != i2) {
            parseLog.setError(position, padMismatched());
            return;
        }
        int i6 = 0;
        while (position2 < length && ((!zIsStrict || i5 + i6 < this.padRight) && charSequence.charAt(position2) == padChar)) {
            position2++;
            i6++;
        }
        if (zIsStrict && (i = this.padRight) > 0 && i5 + i6 != i) {
            parseLog.setError(position2 - i6, padMismatched());
        } else {
            parseLog.setPosition(position2);
        }
    }

    int getLevel() {
        return this.level;
    }

    int getSection() {
        return this.section;
    }

    boolean isDecimal() {
        FormatProcessor<?> formatProcessor = this.processor;
        return (formatProcessor instanceof FractionProcessor) || (formatProcessor instanceof DecimalProcessor);
    }

    boolean isNumerical() {
        return this.processor.isNumerical();
    }

    FormatProcessor<?> getProcessor() {
        return this.processor;
    }

    FormatStep quickPath(ChronoFormatter<?> chronoFormatter) {
        AttributeSet attributes0 = chronoFormatter.getAttributes0();
        if (this.sectionalAttrs != null) {
            attributes0 = attributes0.withAttributes(new Attributes.Builder().setAll(attributes0.getAttributes()).setAll(this.sectionalAttrs.getAttributes()).build());
        }
        AttributeSet attributeSet = attributes0;
        return new FormatStep(this.processor.quickPath(chronoFormatter, attributeSet, this.reserved), this.level, this.section, this.sectionalAttrs, attributeSet, this.reserved, this.padLeft, this.padRight, this.orMarker, this.lastOrBlockIndex);
    }

    FormatStep updateElement(ChronoElement<?> chronoElement) {
        FormatProcessor<?> formatProcessorUpdate = update(this.processor, chronoElement);
        return this.processor == formatProcessorUpdate ? this : new FormatStep(formatProcessorUpdate, this.level, this.section, this.sectionalAttrs, this.fullAttrs, this.reserved, this.padLeft, this.padRight, this.orMarker, this.lastOrBlockIndex);
    }

    FormatStep reserve(int i) {
        return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, null, this.reserved + i, this.padLeft, this.padRight, this.orMarker, this.lastOrBlockIndex);
    }

    FormatStep pad(int i, int i2) {
        return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, null, this.reserved, this.padLeft + i, this.padRight + i2, this.orMarker, this.lastOrBlockIndex);
    }

    FormatStep startNewOrBlock() {
        if (this.orMarker) {
            throw new IllegalStateException("Cannot start or-block twice.");
        }
        return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, null, this.reserved, this.padLeft, this.padRight, true, -1);
    }

    FormatStep markLastOrBlock(int i) {
        if (!this.orMarker) {
            throw new IllegalStateException("This step is not starting an or-block.");
        }
        return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, this.fullAttrs, this.reserved, this.padLeft, this.padRight, true, i);
    }

    boolean isNewOrBlockStarted() {
        return this.orMarker;
    }

    int skipTrailingOrBlocks() {
        return this.lastOrBlockIndex;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatStep)) {
            return false;
        }
        FormatStep formatStep = (FormatStep) obj;
        return this.processor.equals(formatStep.processor) && this.level == formatStep.level && this.section == formatStep.section && isEqual(this.sectionalAttrs, formatStep.sectionalAttrs) && isEqual(this.fullAttrs, formatStep.fullAttrs) && this.reserved == formatStep.reserved && this.padLeft == formatStep.padLeft && this.padRight == formatStep.padRight && this.orMarker == formatStep.orMarker && this.lastOrBlockIndex == formatStep.lastOrBlockIndex;
    }

    public int hashCode() {
        int iHashCode = this.processor.hashCode();
        AttributeSet attributeSet = this.sectionalAttrs;
        return (iHashCode * 7) + ((attributeSet == null ? 0 : attributeSet.hashCode()) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[processor=");
        sb.append(this.processor);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", section=");
        sb.append(this.section);
        if (this.sectionalAttrs != null) {
            sb.append(", attributes=");
            sb.append(this.sectionalAttrs);
        }
        sb.append(", reserved=");
        sb.append(this.reserved);
        sb.append(", pad-left=");
        sb.append(this.padLeft);
        sb.append(", pad-right=");
        sb.append(this.padRight);
        if (this.orMarker) {
            sb.append(", or-block-started");
        }
        sb.append(']');
        return sb.toString();
    }

    private AttributeQuery getQuery(AttributeQuery attributeQuery) {
        AttributeSet attributeSet = this.sectionalAttrs;
        return attributeSet == null ? attributeQuery : new MergedAttributes(attributeSet, attributeQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <V> FormatProcessor<V> update(FormatProcessor<V> formatProcessor, ChronoElement<?> chronoElement) {
        if (formatProcessor.getElement() == null) {
            return formatProcessor;
        }
        if (formatProcessor.getElement().getType() != chronoElement.getType() && !(chronoElement instanceof DualFormatElement)) {
            throw new IllegalArgumentException("Cannot change element value type: " + chronoElement.name());
        }
        return formatProcessor.withElement(chronoElement);
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private void doParse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int position = parseLog.getPosition();
        try {
            this.processor.parse(charSequence, parseLog, attributeQuery, parsedEntity, z);
        } catch (RuntimeException e) {
            parseLog.setError(position, e.getMessage());
        }
    }

    private boolean isStrict(AttributeQuery attributeQuery) {
        return ((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict();
    }

    private char getPadChar(AttributeQuery attributeQuery) {
        return ((Character) attributeQuery.get(Attributes.PAD_CHAR, ' ')).charValue();
    }

    private String padExceeded() {
        return "Pad width exceeded: " + this.processor.getElement().name();
    }

    private String padMismatched() {
        return "Pad width mismatched: " + this.processor.getElement().name();
    }

    private boolean isPrinting(ChronoDisplay chronoDisplay) {
        ChronoCondition<ChronoDisplay> condition;
        AttributeSet attributeSet = this.sectionalAttrs;
        return attributeSet == null || (condition = attributeSet.getCondition()) == null || condition.test(chronoDisplay);
    }
}
