package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import androidx.annotation.IdRes;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.savedstate.SavedStateReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.SerializersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class NavDestination {
    public static final Companion Companion;
    private static int artificialFrame = 1;
    private static final Map<String, Class<?>> classes;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final SparseArrayCompat<NavAction> actions;
    private final NavDestinationImpl impl;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ClassType {
        Class<?> value();
    }

    @JvmStatic
    public static final String getDisplayName(@NotNull NavContext navContext, int i) {
        return Companion.getDisplayName(navContext, i);
    }

    public static final Sequence<NavDestination> getHierarchy(@NotNull NavDestination navDestination) {
        return Companion.getHierarchy(navDestination);
    }

    @JvmStatic
    public static final <T> boolean hasRoute(@NotNull NavDestination navDestination, @NotNull KClass<T> kClass) {
        return Companion.hasRoute(navDestination, kClass);
    }

    @JvmStatic
    protected static final <C> Class<? extends C> parseClassFromName(@NotNull Context context, @NotNull String str, @NotNull Class<? extends C> cls) {
        return Companion.parseClassFromName(context, str, cls);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromNameInternal(@NotNull Context context, @NotNull String str, @NotNull Class<? extends C> cls) {
        return Companion.parseClassFromNameInternal(context, str, cls);
    }

    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    public boolean supportsActions() {
        return true;
    }

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    public NavDestination(@NotNull String navigatorName) {
        Intrinsics.checkNotNullParameter(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.impl = new NavDestinationImpl(this);
        this.actions = new SparseArrayCompat<>(0, 1, null);
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(@NotNull NavDestination destination, @Nullable Bundle bundle, boolean z, int i, boolean z2, int i2) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
            this.mimeTypeMatchLevel = i2;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull DeepLinkMatch other) {
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z = this.isExactDeepLink;
            if (z && !other.isExactDeepLink) {
                return 1;
            }
            if (!z && other.isExactDeepLink) {
                return -1;
            }
            int i = this.matchingPathSegments - other.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && other.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && other.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int iM4105sizeimpl = SavedStateReader.m4105sizeimpl(SavedStateReader.m4025constructorimpl(bundle));
                Bundle bundle2 = other.matchingArgs;
                Intrinsics.checkNotNull(bundle2);
                int iM4105sizeimpl2 = iM4105sizeimpl - SavedStateReader.m4105sizeimpl(SavedStateReader.m4025constructorimpl(bundle2));
                if (iM4105sizeimpl2 > 0) {
                    return 1;
                }
                if (iM4105sizeimpl2 < 0) {
                    return -1;
                }
            }
            boolean z2 = this.hasMatchingAction;
            if (z2 && !other.hasMatchingAction) {
                return 1;
            }
            if (z2 || !other.hasMatchingAction) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }

        public final boolean hasMatchingArgs(@Nullable Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || (bundle2 = this.matchingArgs) == null) {
                return false;
            }
            Set<String> setKeySet = bundle2.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            for (String str : setKeySet) {
                Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
                Intrinsics.checkNotNull(str);
                if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, str)) {
                    return false;
                }
                NavArgument navArgument = this.destination.getArguments().get(str);
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                Object obj = type != null ? type.get(this.matchingArgs, str) : null;
                Object obj2 = type != null ? type.get(bundle, str) : null;
                if (type != null && !type.valueEquals(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final void setParent(@Nullable NavGraph navGraph) {
        this.parent = navGraph;
    }

    private final String getIdName() {
        return this.impl.getIdName$navigation_common_release();
    }

    private final void setIdName(String str) {
        this.impl.setIdName$navigation_common_release(str);
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(@Nullable CharSequence charSequence) {
        this.label = charSequence;
    }

    private final List<NavDeepLink> getDeepLinks() {
        return this.impl.getDeepLinks$navigation_common_release();
    }

    public final Map<String, NavArgument> getArguments() {
        return MapsKt__MapsKt.toMap(this.impl.getArguments$navigation_common_release());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(@NotNull Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public void onInflate(@NotNull Context context, @NotNull AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
        setRoute(typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.Navigator_route));
        if (typedArrayObtainAttributes.hasValue(androidx.navigation.common.R.styleable.Navigator_android_id)) {
            setId(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
            setIdName(Companion.getDisplayName(new NavContext(context), getId()));
        }
        this.label = typedArrayObtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        Unit unit = Unit.INSTANCE;
        typedArrayObtainAttributes.recycle();
    }

    public final int getId() {
        return this.impl.getId$navigation_common_release();
    }

    public final void setId(@IdRes int i) {
        this.impl.setId$navigation_common_release(i);
    }

    public final String getRoute() {
        return this.impl.getRoute$navigation_common_release();
    }

    public final void setRoute(@Nullable String str) {
        this.impl.setRoute$navigation_common_release(str);
    }

    public String getDisplayName() {
        String idName = getIdName();
        return idName == null ? String.valueOf(getId()) : idName;
    }

    public boolean hasDeepLink(@NotNull Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    public boolean hasDeepLink(@NotNull NavDeepLinkRequest deepLinkRequest) {
        Intrinsics.checkNotNullParameter(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    public final void addDeepLink(@NotNull String uriPattern) {
        Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(uriPattern).build());
    }

    public final void addDeepLink(@NotNull NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.impl.addDeepLink$navigation_common_release(navDeepLink);
    }

    public final DeepLinkMatch matchRoute(@NotNull String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.matchRoute$navigation_common_release(route);
    }

    public DeepLinkMatch matchDeepLink(@NotNull NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return this.impl.matchDeepLink$navigation_common_release(navDeepLinkRequest);
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.buildDeepLinkIds(navDestination2);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    public final int[] buildDeepLinkIds(@Nullable NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination2 = this;
        while (true) {
            Intrinsics.checkNotNull(navDestination2);
            NavGraph navGraph = navDestination2.parent;
            if ((navDestination != null ? navDestination.parent : null) != null) {
                NavGraph navGraph2 = navDestination.parent;
                Intrinsics.checkNotNull(navGraph2);
                if (navGraph2.findNode(navDestination2.getId()) == navDestination2) {
                    arrayDeque.addFirst(navDestination2);
                    break;
                }
                if (navGraph != null || navGraph.getStartDestinationId() != navDestination2.getId()) {
                    arrayDeque.addFirst(navDestination2);
                }
                if (!Intrinsics.areEqual(navGraph, navDestination) || navGraph == null) {
                    break;
                }
                navDestination2 = navGraph;
            } else {
                if (navGraph != null) {
                    arrayDeque.addFirst(navDestination2);
                } else {
                    arrayDeque.addFirst(navDestination2);
                }
                if (!Intrinsics.areEqual(navGraph, navDestination)) {
                    break;
                }
                navDestination2 = navGraph;
            }
        }
        List list = CollectionsKt___CollectionsKt.toList(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it2.next()).getId()));
        }
        return CollectionsKt___CollectionsKt.toIntArray(arrayList);
    }

    public final boolean hasRoute(@NotNull String route, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.impl.hasRoute$navigation_common_release(route, bundle);
    }

    public final NavAction getAction(@IdRes int i) {
        NavAction navAction = this.actions.getIsEmpty() ? null : this.actions.get(i);
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(i);
        }
        return null;
    }

    public final void putAction(@IdRes int i, @IdRes int i2) {
        putAction(i, new NavAction(i2, null, null, 6, null));
    }

    public final void putAction(@IdRes int i, @NotNull NavAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (supportsActions()) {
            if (i == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            this.actions.put(i, action);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    public final void removeAction(@IdRes int i) {
        this.actions.remove(i);
    }

    public final void addArgument(@NotNull String argumentName, @NotNull NavArgument argument) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.impl.addArgument$navigation_common_release(argumentName, argument);
    }

    public final void removeArgument(@NotNull String argumentName) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        this.impl.removeArgument$navigation_common_release(argumentName);
    }

    public final Bundle addInDefaultArgs(@Nullable Bundle bundle) {
        return this.impl.addInDefaultArgs$navigation_common_release(bundle);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067 A[PHI: r6
  0x0067: PHI (r6v9 java.lang.String) = (r6v7 java.lang.String), (r6v25 java.lang.String) binds: [B:18:0x0065, B:15:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x006d  */
    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0083  */
    /* JADX WARN: Code duplicated, block: B:27:0x008c  */
    /* JADX WARN: Code duplicated, block: B:29:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:33:0x00de  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x003b  */
    public final String fillInLabel(@NotNull Context context, @Nullable Bundle bundle) {
        Map<String, Object> mapEmptyMap;
        String strGroup;
        NavArgument navArgument;
        NavType<Object> type;
        NavType<Integer> navType;
        String strValueOf;
        int i;
        int i2 = 2 % 2;
        int i3 = artificialFrame + 89;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        if (bundle != null) {
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i5 % 128;
            int i6 = i5 % 2;
            mapEmptyMap = SavedStateReader.m4106toMapimpl(SavedStateReader.m4025constructorimpl(bundle));
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt__MapsKt.emptyMap();
                int i7 = artificialFrame + 125;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                int i8 = i7 % 2;
            }
        } else {
            mapEmptyMap = MapsKt__MapsKt.emptyMap();
            int i9 = artificialFrame + 125;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
            int i10 = i9 % 2;
        }
        while (matcher.find()) {
            int i11 = artificialFrame + 23;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i11 % 128;
            if (i11 % 2 != 0) {
                strGroup = matcher.group(1);
                if (strGroup != null) {
                    if (mapEmptyMap.containsKey(strGroup)) {
                        matcher.appendReplacement(stringBuffer, "");
                        navArgument = getArguments().get(strGroup);
                        if (navArgument != null) {
                            type = navArgument.getType();
                        } else {
                            type = null;
                        }
                        navType = NavType.ReferenceType;
                        if (Intrinsics.areEqual(type, navType)) {
                            Intrinsics.checkNotNull(bundle);
                            Integer num = navType.get(bundle, strGroup);
                            Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
                            strValueOf = context.getString(num.intValue());
                            if (strValueOf.startsWith(".,.%")) {
                                i = artificialFrame + 51;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i % 128;
                                if (i % 2 != 0) {
                                    Object[] objArr = new Object[1];
                                    a(strValueOf.substring(4), objArr);
                                    strValueOf = ((String) objArr[0]).intern();
                                    int i12 = 40 / 0;
                                } else {
                                    Object[] objArr2 = new Object[1];
                                    a(strValueOf.substring(4), objArr2);
                                    strValueOf = ((String) objArr2[0]).intern();
                                }
                            }
                        } else {
                            Intrinsics.checkNotNull(type);
                            Intrinsics.checkNotNull(bundle);
                            strValueOf = String.valueOf(type.get(bundle, strGroup));
                        }
                        Intrinsics.checkNotNull(strValueOf);
                        stringBuffer.append(strValueOf);
                    }
                }
            } else {
                strGroup = matcher.group(1);
                if (strGroup != null) {
                    if (mapEmptyMap.containsKey(strGroup)) {
                        matcher.appendReplacement(stringBuffer, "");
                        navArgument = getArguments().get(strGroup);
                        if (navArgument != null) {
                            type = navArgument.getType();
                        } else {
                            type = null;
                        }
                        navType = NavType.ReferenceType;
                        if (Intrinsics.areEqual(type, navType)) {
                            Intrinsics.checkNotNull(bundle);
                            Integer num2 = navType.get(bundle, strGroup);
                            Intrinsics.checkNotNull(num2, "null cannot be cast to non-null type kotlin.Int");
                            strValueOf = context.getString(num2.intValue());
                            if (strValueOf.startsWith(".,.%")) {
                                i = artificialFrame + 51;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i % 128;
                                if (i % 2 != 0) {
                                    Object[] objArr3 = new Object[1];
                                    a(strValueOf.substring(4), objArr3);
                                    strValueOf = ((String) objArr3[0]).intern();
                                    int i13 = 40 / 0;
                                } else {
                                    Object[] objArr4 = new Object[1];
                                    a(strValueOf.substring(4), objArr4);
                                    strValueOf = ((String) objArr4[0]).intern();
                                }
                            }
                        } else {
                            Intrinsics.checkNotNull(type);
                            Intrinsics.checkNotNull(bundle);
                            strValueOf = String.valueOf(type.get(bundle, strGroup));
                        }
                        Intrinsics.checkNotNull(strValueOf);
                        stringBuffer.append(strValueOf);
                    }
                }
            }
            throw new IllegalArgumentException(("Could not find \"" + strGroup + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"').toString());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        if (getIdName() == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(getId()));
        } else {
            sb.append(getIdName());
        }
        sb.append(")");
        String route = getRoute();
        if (route != null && !StringsKt__StringsKt.isBlank(route)) {
            sb.append(" route=");
            sb.append(getRoute());
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavDestination)) {
            return false;
        }
        NavDestination navDestination = (NavDestination) obj;
        boolean zAreEqual = Intrinsics.areEqual(getDeepLinks(), navDestination.getDeepLinks());
        if (this.actions.size() != navDestination.actions.size()) {
            z = false;
            break;
        }
        Iterator it2 = SequencesKt__SequencesKt.asSequence(SparseArrayKt.keyIterator(this.actions)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            int iIntValue = ((Number) it2.next()).intValue();
            if (!Intrinsics.areEqual(this.actions.get(iIntValue), navDestination.actions.get(iIntValue))) {
                z = false;
                break;
            }
        }
        if (getArguments().size() != navDestination.getArguments().size()) {
            z2 = false;
            break;
        }
        Iterator it3 = MapsKt___MapsKt.asSequence(getArguments()).iterator();
        while (true) {
            if (!it3.hasNext()) {
                z2 = true;
                break;
            }
            Map.Entry entry = (Map.Entry) it3.next();
            if (!navDestination.getArguments().containsKey(entry.getKey()) || !Intrinsics.areEqual(navDestination.getArguments().get(entry.getKey()), entry.getValue())) {
                z2 = false;
                break;
            }
        }
        return getId() == navDestination.getId() && Intrinsics.areEqual(getRoute(), navDestination.getRoute()) && zAreEqual && z && z2;
    }

    public int hashCode() {
        int id = getId();
        String route = getRoute();
        int iHashCode = (id * 31) + (route != null ? route.hashCode() : 0);
        for (NavDeepLink navDeepLink : getDeepLinks()) {
            String uriPattern = navDeepLink.getUriPattern();
            int iHashCode2 = uriPattern != null ? uriPattern.hashCode() : 0;
            String action = navDeepLink.getAction();
            int iHashCode3 = action != null ? action.hashCode() : 0;
            String mimeType = navDeepLink.getMimeType();
            iHashCode = (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator itValueIterator = SparseArrayKt.valueIterator(this.actions);
        while (itValueIterator.hasNext()) {
            NavAction navAction = (NavAction) itValueIterator.next();
            int destinationId = navAction.getDestinationId();
            NavOptions navOptions = navAction.getNavOptions();
            iHashCode = (((iHashCode * 31) + destinationId) * 31) + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (defaultArguments != null) {
                iHashCode = (iHashCode * 31) + SavedStateReader.m4028contentDeepHashCodeimpl(SavedStateReader.m4025constructorimpl(defaultArguments));
            }
        }
        for (String str : getArguments().keySet()) {
            int iHashCode4 = str.hashCode();
            NavArgument navArgument = getArguments().get(str);
            iHashCode = (((iHashCode * 31) + iHashCode4) * 31) + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }

        private Companion() {
        }

        @JvmStatic
        protected final <C> Class<? extends C> parseClassFromName(@NotNull Context context, @NotNull String name, @NotNull Class<? extends C> expectedClassType) {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            if (name.charAt(0) == '.') {
                str = context.getPackageName() + name;
            } else {
                str = name;
            }
            Class<? extends C> cls = (Class) NavDestination.classes.get(str);
            if (cls == null) {
                try {
                    cls = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                    NavDestination.classes.put(name, cls);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            Intrinsics.checkNotNull(cls);
            if (expectedClassType.isAssignableFrom(cls)) {
                return cls;
            }
            throw new IllegalArgumentException((str + " must be a subclass of " + expectedClassType).toString());
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromNameInternal(@NotNull Context context, @NotNull String name, @NotNull Class<? extends C> expectedClassType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            return NavDestination.parseClassFromName(context, name, expectedClassType);
        }

        @JvmStatic
        public final String getDisplayName(@NotNull NavContext context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            return context.getResourceName(i);
        }

        public final String createRoute(@Nullable String str) {
            if (str == null) {
                return "";
            }
            return "android-app://androidx.navigation/" + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final NavDestination _get_hierarchy_$lambda$1(NavDestination it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            return it2.getParent();
        }

        public final Sequence<NavDestination> getHierarchy(@NotNull NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt__SequencesKt.generateSequence(navDestination, (Function1<? super NavDestination, ? extends NavDestination>) ((Function1<? super Object, ? extends Object>) new Function1() { // from class: androidx.navigation.NavDestination$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavDestination.Companion._get_hierarchy_$lambda$1((NavDestination) obj);
                }
            }));
        }

        @JvmStatic
        public final /* synthetic */ <T> boolean hasRoute(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return hasRoute(navDestination, Reflection.getOrCreateKotlinClass(Object.class));
        }

        @JvmStatic
        public final <T> boolean hasRoute(@NotNull NavDestination navDestination, @NotNull KClass<T> route) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.checkNotNullParameter(route, "route");
            return RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)) == navDestination.getId();
        }
    }

    static {
        accessartificialFrame();
        Companion = new Companion(null);
        classes = new LinkedHashMap();
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
