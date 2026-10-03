package androidx.compose.ui.text.font;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FontVariation {
    public static final int $stable = 0;
    public static final FontVariation INSTANCE = new FontVariation();

    public interface Setting {
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(@Nullable Density density);
    }

    private FontVariation() {
    }

    public static final class Settings {
        public static final int $stable = 0;
        private final boolean needsDensity;
        private final List<Setting> settings;

        public Settings(@NotNull Setting... settingArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z = false;
            for (Setting setting : settingArr) {
                String axisName = setting.getAxisName();
                Object arrayList = linkedHashMap.get(axisName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(axisName, arrayList);
                }
                ((List) arrayList).add(setting);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (list.size() != 1) {
                    throw new IllegalArgumentException((CoreConstants.SINGLE_QUOTE_CHAR + str + "' must be unique. Actual [ [" + CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null) + ']').toString());
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, list);
            }
            ArrayList arrayList3 = new ArrayList(arrayList2);
            this.settings = arrayList3;
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                if (((Setting) arrayList3.get(i)).getNeedsDensity()) {
                    z = true;
                    break;
                }
            }
            this.needsDensity = z;
        }

        public final List<Setting> getSettings() {
            return this.settings;
        }

        public final boolean getNeedsDensity$ui_text_release() {
            return this.needsDensity;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Settings) && Intrinsics.areEqual(this.settings, ((Settings) obj).settings);
        }

        public int hashCode() {
            return this.settings.hashCode();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    static final class SettingFloat implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public SettingFloat(@NotNull String str, float f) {
            this.axisName = str;
            this.value = f;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        public final float getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingFloat)) {
                return false;
            }
            SettingFloat settingFloat = (SettingFloat) obj;
            return Intrinsics.areEqual(getAxisName(), settingFloat.getAxisName()) && this.value == settingFloat.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + Float.hashCode(this.value);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    static final class SettingTextUnit implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final long value;

        public /* synthetic */ SettingTextUnit(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j);
        }

        private SettingTextUnit(String str, long j) {
            this.axisName = str;
            this.value = j;
            this.needsDensity = true;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        /* JADX INFO: renamed from: getValue-XSAIIZE, reason: not valid java name */
        public final long m3269getValueXSAIIZE() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            if (density == null) {
                throw new IllegalArgumentException("density must not be null");
            }
            return TextUnit.m3843getValueimpl(this.value) * density.getFontScale();
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingTextUnit)) {
                return false;
            }
            SettingTextUnit settingTextUnit = (SettingTextUnit) obj;
            return Intrinsics.areEqual(getAxisName(), settingTextUnit.getAxisName()) && TextUnit.m3840equalsimpl0(this.value, settingTextUnit.value);
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + TextUnit.m3844hashCodeimpl(this.value);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + ((Object) TextUnit.m3850toStringimpl(this.value)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    static final class SettingInt implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public SettingInt(@NotNull String str, int i) {
            this.axisName = str;
            this.value = i;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        public final int getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingInt)) {
                return false;
            }
            SettingInt settingInt = (SettingInt) obj;
            return Intrinsics.areEqual(getAxisName(), settingInt.getAxisName()) && this.value == settingInt.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + this.value;
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public final Setting Setting(@NotNull String str, float f) {
        if (str.length() != 4) {
            throw new IllegalArgumentException(("Name must be exactly four characters. Actual: '" + str + CoreConstants.SINGLE_QUOTE_CHAR).toString());
        }
        return new SettingFloat(str, f);
    }

    public final Setting italic(float f) {
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("'ital' must be in 0.0f..1.0f. Actual: " + f).toString());
        }
        return new SettingFloat("ital", f);
    }

    /* JADX INFO: renamed from: opticalSizing--R2X_6o, reason: not valid java name */
    public final Setting m3268opticalSizingR2X_6o(long j) {
        if (!TextUnit.m3846isSpimpl(j)) {
            throw new IllegalArgumentException("'opsz' must be provided in sp units");
        }
        return new SettingTextUnit("opsz", j, null);
    }

    public final Setting slant(float f) {
        if (-90.0f > f || f > 90.0f) {
            throw new IllegalArgumentException(("'slnt' must be in -90f..90f. Actual: " + f).toString());
        }
        return new SettingFloat("slnt", f);
    }

    public final Setting width(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException(("'wdth' must be strictly > 0.0f. Actual: " + f).toString());
        }
        return new SettingFloat("wdth", f);
    }

    public final Setting weight(int i) {
        if (1 > i || i >= 1001) {
            throw new IllegalArgumentException(("'wght' value must be in [1, 1000]. Actual: " + i).toString());
        }
        return new SettingInt("wght", i);
    }

    public final Setting grade(int i) {
        if (-1000 > i || i >= 1001) {
            throw new IllegalArgumentException("'GRAD' must be in -1000..1000");
        }
        return new SettingInt("GRAD", i);
    }

    /* JADX INFO: renamed from: Settings-6EWAqTQ, reason: not valid java name */
    public final Settings m3267Settings6EWAqTQ(@NotNull FontWeight fontWeight, int i, @NotNull Setting... settingArr) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(weight(fontWeight.getWeight()));
        spreadBuilder.add(italic(i));
        spreadBuilder.addSpread(settingArr);
        return new Settings((Setting[]) spreadBuilder.toArray(new Setting[spreadBuilder.size()]));
    }
}
