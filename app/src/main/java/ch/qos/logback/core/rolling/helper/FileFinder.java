package ch.qos.logback.core.rolling.helper;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class FileFinder {
    private static final String REGEX_MARKER_END = "(?:\uffff)?";
    private static final String REGEX_MARKER_START = "(?:\ufffe)?";
    private FileProvider fileProvider;

    FileFinder(FileProvider fileProvider) {
        this.fileProvider = fileProvider;
    }

    private void findDirs(List<File> list, List<PathPart> list2, int i, List<File> list3) {
        if (i >= list2.size() - 1) {
            return;
        }
        PathPart pathPart = list2.get(i);
        for (File file : list) {
            if (this.fileProvider.isDirectory(file) && pathPart.matches(file)) {
                list3.add(file);
                findDirs(Arrays.asList(this.fileProvider.listFiles(file, null)), list2, i + 1, list3);
            }
        }
    }

    private List<File> findFiles(List<File> list, List<PathPart> list2, int i) {
        ArrayList arrayList = new ArrayList();
        PathPart pathPart = list2.get(i);
        int size = list2.size();
        Iterator<File> it2 = list.iterator();
        if (i >= size - 1) {
            while (it2.hasNext()) {
                File next = it2.next();
                if (pathPart.matches(next)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        while (it2.hasNext()) {
            File next2 = it2.next();
            if (this.fileProvider.isDirectory(next2) && pathPart.matches(next2)) {
                arrayList.addAll(findFiles(Arrays.asList(this.fileProvider.listFiles(next2, null)), list2, i + 1));
            }
        }
        return arrayList;
    }

    static String regexEscapePath(String str) {
        String str2 = File.separator;
        if (!str.contains(str2)) {
            return REGEX_MARKER_START + str + REGEX_MARKER_END;
        }
        String[] strArrSplit = str.split(str2);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].length() > 0) {
                strArrSplit[i] = REGEX_MARKER_START + strArrSplit[i] + REGEX_MARKER_END;
            }
        }
        return TextUtils.join(File.separator, strArrSplit);
    }

    private List<String> toAbsolutePaths(List<File> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<File> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getAbsolutePath());
        }
        return arrayList;
    }

    static String unescapePath(String str) {
        return str.replace(REGEX_MARKER_START, "").replace(REGEX_MARKER_END, "");
    }

    List<String> findDirs(String str) {
        List<PathPart> listSplitPath = splitPath(str);
        PathPart pathPart = listSplitPath.get(0);
        ArrayList arrayList = new ArrayList();
        findDirs(pathPart.listFiles(this.fileProvider), listSplitPath, 1, arrayList);
        return toAbsolutePaths(arrayList);
    }

    List<String> findFiles(String str) {
        List<PathPart> listSplitPath = splitPath(str);
        return toAbsolutePaths(findFiles(listSplitPath.get(0).listFiles(this.fileProvider), listSplitPath, 1));
    }

    List<PathPart> splitPath(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : str.split(File.separator)) {
            boolean z = str2.contains(REGEX_MARKER_START) && str2.contains(REGEX_MARKER_END);
            String strReplace = str2.replace(REGEX_MARKER_START, "").replace(REGEX_MARKER_END, "");
            if (z) {
                if (!arrayList2.isEmpty()) {
                    arrayList.add(new LiteralPathPart(TextUtils.join(File.separator, arrayList2)));
                    arrayList2.clear();
                }
                arrayList.add(new RegexPathPart(strReplace));
            } else {
                arrayList2.add(strReplace);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(new LiteralPathPart(TextUtils.join(File.separator, arrayList2)));
        }
        return arrayList;
    }
}
