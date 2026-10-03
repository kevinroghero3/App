package com.ReactNativeBlobUtil.Utils;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes4.dex */
public class FileDescription {
    public String mimeType;
    public String name;
    public String partentFolder;

    public FileDescription(String str, String str2, String str3) {
        this.name = str;
        this.partentFolder = str3 == null ? "" : str3;
        this.mimeType = str2;
    }

    public String getFullPath() {
        return this.partentFolder + RemoteSettings.FORWARD_SLASH_STRING + MimeType.getFullFileName(this.name, this.mimeType);
    }
}
