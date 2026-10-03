package com.alpha0010.fs;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class UtilKt {
    public static final DocumentFile asDocumentFile(@NotNull String str, @NotNull Context context) {
        DocumentFile documentFileFromSingleUri;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isContentUri(str)) {
            try {
                Uri uri = Uri.parse(str);
                Intrinsics.checkNotNull(uri);
                if (isTreeUri(uri)) {
                    documentFileFromSingleUri = DocumentFile.fromTreeUri(context, uri);
                } else {
                    documentFileFromSingleUri = DocumentFile.fromSingleUri(context, uri);
                }
                if (documentFileFromSingleUri != null) {
                    return documentFileFromSingleUri;
                }
            } catch (Throwable unused) {
            }
        }
        DocumentFile documentFileFromFile = DocumentFile.fromFile(parsePathToFile(str));
        Intrinsics.checkNotNullExpressionValue(documentFileFromFile, "fromFile(...)");
        return documentFileFromFile;
    }

    public static final boolean isContentUri(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt__StringsJVMKt.startsWith$default(str, ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT, false, 2, null);
    }

    public static final boolean isTreeUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        return Intrinsics.areEqual(CollectionsKt___CollectionsKt.firstOrNull((List) pathSegments), "tree");
    }

    public static final Pair<Uri, String> parseScopedPath(@NotNull String path) throws Exception {
        String strTrimEnd;
        Intrinsics.checkNotNullParameter(path, "path");
        Uri uri = Uri.parse(path);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || (strTrimEnd = StringsKt__StringsKt.trimEnd(lastPathSegment, '/')) == null) {
            throw new Exception("Failed to parse '" + path + "'.");
        }
        int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) strTrimEnd, '/', 0, false, 6, (Object) null);
        if (iLastIndexOf$default < 1) {
            throw new Exception("Failed to parse '" + path + "'.");
        }
        String strSubstring = strTrimEnd.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = strTrimEnd.substring(iLastIndexOf$default + 1, strTrimEnd.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        Uri.Builder builderPath = uri.buildUpon().path("");
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        Iterator it2 = CollectionsKt___CollectionsKt.dropLast(pathSegments, 1).iterator();
        while (it2.hasNext()) {
            builderPath.appendPath((String) it2.next());
        }
        builderPath.appendPath(strSubstring);
        return new Pair<>(builderPath.build(), Uri.decode(strSubstring2));
    }

    public static final File parsePathToFile(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (StringsKt__StringsKt.contains$default((CharSequence) path, (CharSequence) "://", false, 2, (Object) null)) {
            try {
                String path2 = Uri.parse(path).getPath();
                Intrinsics.checkNotNull(path2);
                return new File(path2);
            } catch (Throwable unused) {
                return new File(path);
            }
        }
        return new File(path);
    }
}
