package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.utils.ResolutionSelectorUtil;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface Config {

    public interface OptionMatcher {
        boolean onOptionMatched(@NonNull Option<?> option);
    }

    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        HIGH_PRIORITY_REQUIRED,
        REQUIRED,
        OPTIONAL
    }

    boolean containsOption(@NonNull Option<?> option);

    void findOptions(@NonNull String str, @NonNull OptionMatcher optionMatcher);

    OptionPriority getOptionPriority(@NonNull Option<?> option);

    Set<OptionPriority> getPriorities(@NonNull Option<?> option);

    Set<Option<?>> listOptions();

    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option);

    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option, @Nullable ValueT valuet);

    <ValueT> ValueT retrieveOptionWithPriority(@NonNull Option<ValueT> option, @NonNull OptionPriority optionPriority);

    public static abstract class Option<T> {
        public abstract String getId();

        public abstract Object getToken();

        public abstract Class<T> getValueClass();

        Option() {
        }

        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls) {
            return create(str, cls, null);
        }

        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls, @Nullable Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }
    }

    static boolean hasConflict(@NonNull OptionPriority optionPriority, @NonNull OptionPriority optionPriority2) {
        OptionPriority optionPriority3 = OptionPriority.REQUIRED;
        return optionPriority == optionPriority3 && optionPriority2 == optionPriority3;
    }

    static Config mergeConfigs(@Nullable Config config, @Nullable Config config2) {
        MutableOptionsBundle mutableOptionsBundleCreate;
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        if (config2 != null) {
            mutableOptionsBundleCreate = MutableOptionsBundle.from(config2);
        } else {
            mutableOptionsBundleCreate = MutableOptionsBundle.create();
        }
        if (config != null) {
            Iterator<Option<?>> it2 = config.listOptions().iterator();
            while (it2.hasNext()) {
                mergeOptionValue(mutableOptionsBundleCreate, config2, config, it2.next());
            }
        }
        return OptionsBundle.from(mutableOptionsBundleCreate);
    }

    static void mergeOptionValue(@NonNull MutableOptionsBundle mutableOptionsBundle, @NonNull Config config, @NonNull Config config2, @NonNull Option<?> option) {
        if (Objects.equals(option, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            ResolutionSelector resolutionSelector = (ResolutionSelector) config2.retrieveOption(option, null);
            mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), ResolutionSelectorUtil.overrideResolutionSelectors((ResolutionSelector) config.retrieveOption(option, null), resolutionSelector));
            return;
        }
        mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), config2.retrieveOption(option));
    }
}
