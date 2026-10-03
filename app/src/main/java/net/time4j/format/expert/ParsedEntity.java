package net.time4j.format.expert;

import ch.qos.logback.core.CoreConstants;
import java.util.Set;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.Chronology;
import net.time4j.format.expert.ParsedEntity;
import net.time4j.tz.TZID;

/* JADX INFO: loaded from: classes3.dex */
abstract class ParsedEntity<T extends ParsedEntity<T>> extends ChronoEntity<T> {
    abstract <E> E getResult();

    abstract void put(ChronoElement<?> chronoElement, int i);

    abstract void put(ChronoElement<?> chronoElement, Object obj);

    abstract void setResult(Object obj);

    ParsedEntity() {
    }

    @Override // net.time4j.engine.ChronoEntity
    public /* bridge */ /* synthetic */ ChronoEntity with(ChronoElement chronoElement, int i) {
        return with((ChronoElement<Integer>) chronoElement, i);
    }

    @Override // net.time4j.engine.ChronoEntity
    public /* bridge */ /* synthetic */ ChronoEntity with(ChronoElement chronoElement, Object obj) {
        return with((ChronoElement<Object>) chronoElement, obj);
    }

    @Override // net.time4j.engine.ChronoEntity
    public <V> boolean isValid(ChronoElement<V> chronoElement, V v) {
        if (chronoElement != null) {
            return true;
        }
        throw new NullPointerException("Missing chronological element.");
    }

    @Override // net.time4j.engine.ChronoEntity
    public <V> T with(ChronoElement<V> chronoElement, V v) {
        put((ChronoElement<?>) chronoElement, (Object) v);
        return this;
    }

    @Override // net.time4j.engine.ChronoEntity
    public T with(ChronoElement<Integer> chronoElement, int i) {
        put(chronoElement, i);
        return this;
    }

    @Override // net.time4j.engine.ChronoEntity, net.time4j.engine.ChronoDisplay
    public <V> V getMinimum(ChronoElement<V> chronoElement) {
        return chronoElement.getDefaultMinimum();
    }

    @Override // net.time4j.engine.ChronoEntity, net.time4j.engine.ChronoDisplay
    public <V> V getMaximum(ChronoElement<V> chronoElement) {
        return chronoElement.getDefaultMaximum();
    }

    @Override // net.time4j.engine.ChronoEntity, net.time4j.engine.ChronoDisplay
    public final boolean hasTimezone() {
        return contains(TimezoneElement.TIMEZONE_ID) || contains(TimezoneElement.TIMEZONE_OFFSET);
    }

    @Override // net.time4j.engine.ChronoEntity, net.time4j.engine.ChronoDisplay
    public final TZID getTimezone() {
        Object obj;
        TimezoneElement timezoneElement = TimezoneElement.TIMEZONE_ID;
        if (contains(timezoneElement)) {
            obj = get(timezoneElement);
        } else {
            TimezoneElement timezoneElement2 = TimezoneElement.TIMEZONE_OFFSET;
            obj = contains(timezoneElement2) ? get(timezoneElement2) : null;
        }
        if (obj instanceof TZID) {
            return (TZID) TZID.class.cast(obj);
        }
        return super.getTimezone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParsedEntity)) {
            return false;
        }
        ParsedEntity parsedEntity = (ParsedEntity) obj;
        Set<ChronoElement<?>> registeredElements = getRegisteredElements();
        Set<ChronoElement<?>> registeredElements2 = parsedEntity.getRegisteredElements();
        if (registeredElements.size() != registeredElements2.size()) {
            return false;
        }
        for (ChronoElement<?> chronoElement : registeredElements) {
            if (!registeredElements2.contains(chronoElement) || !get(chronoElement).equals(parsedEntity.get(chronoElement))) {
                return false;
            }
        }
        Object result = getResult();
        Object result2 = parsedEntity.getResult();
        if (result == null) {
            return result2 == null;
        }
        return result.equals(result2);
    }

    public final int hashCode() {
        int iHashCode = getRegisteredElements().hashCode();
        Object result = getResult();
        return result != null ? iHashCode + (result.hashCode() * 31) : iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(CoreConstants.CURLY_LEFT);
        boolean z = true;
        for (ChronoElement<?> chronoElement : getRegisteredElements()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(chronoElement.name());
            sb.append('=');
            sb.append(get(chronoElement));
        }
        sb.append(CoreConstants.CURLY_RIGHT);
        Object result = getResult();
        if (result != null) {
            sb.append(">>>result=");
            sb.append(result);
        }
        return sb.toString();
    }

    @Override // net.time4j.engine.ChronoEntity
    public final Chronology<T> getChronology() {
        throw new UnsupportedOperationException("Parsed values do not have any chronology.");
    }
}
