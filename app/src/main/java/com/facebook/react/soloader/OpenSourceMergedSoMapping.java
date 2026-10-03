package com.facebook.react.soloader;

import com.facebook.soloader.ExternalSoMapping;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class OpenSourceMergedSoMapping implements ExternalSoMapping {
    public static final OpenSourceMergedSoMapping INSTANCE = new OpenSourceMergedSoMapping();

    public final native int libfabricjni_so();

    public final native int libhermes_executor_so();

    public final native int libhermesinstancejni_so();

    public final native int libhermestooling_so();

    public final native int libjscexecutor_so();

    public final native int libjscinstance_so();

    public final native int libjscruntime_so();

    public final native int libjsctooling_so();

    public final native int libjsijniprofiler_so();

    public final native int libjsinspector_so();

    public final native int libmapbufferjni_so();

    public final native int libreact_devsupportjni_so();

    public final native int libreact_featureflagsjni_so();

    public final native int libreact_newarchdefaults_so();

    public final native int libreactnative_so();

    public final native int libreactnativeblob_so();

    public final native int libreactnativejni_so();

    public final native int librninstance_so();

    public final native int libturbomodulejsijni_so();

    public final native int libuimanagerjni_so();

    public final native int libyoga_so();

    private OpenSourceMergedSoMapping() {
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0067 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x008e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00bd A[ORIG_RETURN, RETURN] */
    @Override // com.facebook.soloader.ExternalSoMapping
    public String mapLibName(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        switch (input) {
            case "mapbufferjni":
            case "rninstance":
            case "reactnativejni":
            case "reactnativeblob":
            case "react_featureflagsjni":
                return "reactnative";
            case "jscinstance":
                return "jsctooling";
            case "react_newarchdefaults":
            case "turbomodulejsijni":
            case "yoga":
                return "reactnative";
            case "hermesinstancejni":
            case "jsijniprofiler":
            case "hermes_executor":
                return "hermestooling";
            case "react_devsupportjni":
            case "uimanagerjni":
                return "reactnative";
            case "jscexecutor":
            case "jscruntime":
                return "jsctooling";
            case "jsinspector":
            case "fabricjni":
                return "reactnative";
            default:
                return input;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.soloader.ExternalSoMapping
    public void invokeJniOnload(@NotNull String libraryName) {
        Intrinsics.checkNotNullParameter(libraryName, "libraryName");
        switch (libraryName.hashCode()) {
            case -1793638007:
                if (libraryName.equals("mapbufferjni")) {
                    libmapbufferjni_so();
                    break;
                }
                break;
            case -1624070447:
                if (libraryName.equals("rninstance")) {
                    librninstance_so();
                    break;
                }
                break;
            case -1570429553:
                if (libraryName.equals("reactnativejni")) {
                    libreactnativejni_so();
                    break;
                }
                break;
            case -1454983728:
                if (libraryName.equals("jsctooling")) {
                    libjsctooling_so();
                    break;
                }
                break;
            case -1438915853:
                if (libraryName.equals("reactnativeblob")) {
                    libreactnativeblob_so();
                    break;
                }
                break;
            case -1382694412:
                if (libraryName.equals("react_featureflagsjni")) {
                    libreact_featureflagsjni_so();
                    break;
                }
                break;
            case -1033318826:
                if (libraryName.equals("reactnative")) {
                    libreactnative_so();
                    break;
                }
                break;
            case -616737073:
                if (libraryName.equals("jscinstance")) {
                    libjscinstance_so();
                    break;
                }
                break;
            case -579037304:
                if (libraryName.equals("react_newarchdefaults")) {
                    libreact_newarchdefaults_so();
                    break;
                }
                break;
            case -49345041:
                if (libraryName.equals("turbomodulejsijni")) {
                    libturbomodulejsijni_so();
                    break;
                }
                break;
            case 3714672:
                if (libraryName.equals("yoga")) {
                    libyoga_so();
                    break;
                }
                break;
            case 65536138:
                if (libraryName.equals("hermesinstancejni")) {
                    libhermesinstancejni_so();
                    break;
                }
                break;
            case 86183502:
                if (libraryName.equals("jsijniprofiler")) {
                    libjsijniprofiler_so();
                    break;
                }
                break;
            case 352552524:
                if (libraryName.equals("hermes_executor")) {
                    libhermes_executor_so();
                    break;
                }
                break;
            case 614482404:
                if (libraryName.equals("hermestooling")) {
                    libhermestooling_so();
                    break;
                }
                break;
            case 688235659:
                if (libraryName.equals("react_devsupportjni")) {
                    libreact_devsupportjni_so();
                    break;
                }
                break;
            case 716617324:
                if (libraryName.equals("uimanagerjni")) {
                    libuimanagerjni_so();
                    break;
                }
                break;
            case 871152397:
                if (libraryName.equals("jscexecutor")) {
                    libjscexecutor_so();
                    break;
                }
                break;
            case 1236065886:
                if (libraryName.equals("jscruntime")) {
                    libjscruntime_so();
                    break;
                }
                break;
            case 1590431694:
                if (libraryName.equals("jsinspector")) {
                    libjsinspector_so();
                    break;
                }
                break;
            case 2016911584:
                if (libraryName.equals("fabricjni")) {
                    libfabricjni_so();
                    break;
                }
                break;
        }
    }
}
