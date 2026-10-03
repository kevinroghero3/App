package org.xmlpull.v1;

import java.io.PrintStream;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class XmlPullParserException extends Exception {
    protected int column;
    protected Throwable detail;
    protected int row;

    public XmlPullParserException(String str) {
        super(str);
        this.row = -1;
        this.column = -1;
    }

    public XmlPullParserException(String str, XmlPullParser xmlPullParser, Throwable th) {
        String string;
        String string2;
        StringBuffer stringBuffer = new StringBuffer();
        String string3 = "";
        if (str == null) {
            string = "";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append(StringUtils.SPACE);
            string = stringBuffer2.toString();
        }
        stringBuffer.append(string);
        if (xmlPullParser == null) {
            string2 = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("(position:");
            stringBuffer3.append(xmlPullParser.getPositionDescription());
            stringBuffer3.append(") ");
            string2 = stringBuffer3.toString();
        }
        stringBuffer.append(string2);
        if (th != null) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("caused by: ");
            stringBuffer4.append(th);
            string3 = stringBuffer4.toString();
        }
        stringBuffer.append(string3);
        super(stringBuffer.toString());
        this.row = -1;
        this.column = -1;
        if (xmlPullParser != null) {
            this.row = xmlPullParser.getLineNumber();
            this.column = xmlPullParser.getColumnNumber();
        }
        this.detail = th;
    }

    public Throwable getDetail() {
        return this.detail;
    }

    public int getLineNumber() {
        return this.row;
    }

    public int getColumnNumber() {
        return this.column;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        PrintStream printStream = System.err;
        synchronized (printStream) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.getMessage());
            stringBuffer.append("; nested exception is:");
            printStream.println(stringBuffer.toString());
            this.detail.printStackTrace();
        }
    }
}
