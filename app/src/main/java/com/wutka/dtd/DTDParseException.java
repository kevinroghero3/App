package com.wutka.dtd;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class DTDParseException extends IOException {
    public int column;
    public int lineNumber;
    public String uriID;

    public DTDParseException() {
        this.uriID = "";
        this.lineNumber = -1;
        this.column = -1;
    }

    public DTDParseException(String str) {
        super(str);
        this.uriID = "";
        this.lineNumber = -1;
        this.column = -1;
    }

    public DTDParseException(String str, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("At line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(": ");
        stringBuffer.append(str);
        super(stringBuffer.toString());
        this.uriID = "";
        this.lineNumber = i;
        this.column = i2;
    }

    public DTDParseException(String str, String str2, int i, int i2) {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null || str.length() <= 0) {
            string = "At ";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("URI ");
            stringBuffer2.append(str);
            stringBuffer2.append(" at ");
            string = stringBuffer2.toString();
        }
        stringBuffer.append(string);
        stringBuffer.append("line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(": ");
        stringBuffer.append(str2);
        super(stringBuffer.toString());
        this.uriID = "";
        if (str != null) {
            this.uriID = str;
        }
        this.lineNumber = i;
        this.column = i2;
    }

    public String getId() {
        return this.uriID;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumn() {
        return this.column;
    }
}
