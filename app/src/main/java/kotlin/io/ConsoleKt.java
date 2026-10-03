package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ConsoleKt {
    private static final void print(Object obj) {
        System.out.print(obj);
    }

    private static final void print(int i) {
        System.out.print(i);
    }

    private static final void print(long j) {
        System.out.print(j);
    }

    private static final void print(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    private static final void print(short s) {
        System.out.print(Short.valueOf(s));
    }

    private static final void print(char c) {
        System.out.print(c);
    }

    private static final void print(boolean z) {
        System.out.print(z);
    }

    private static final void print(float f) {
        System.out.print(f);
    }

    private static final void print(double d) {
        System.out.print(d);
    }

    private static final void print(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.print(message);
    }

    private static final void println(Object obj) {
        System.out.println(obj);
    }

    private static final void println(int i) {
        System.out.println(i);
    }

    private static final void println(long j) {
        System.out.println(j);
    }

    private static final void println(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    private static final void println(short s) {
        System.out.println(Short.valueOf(s));
    }

    private static final void println(char c) {
        System.out.println(c);
    }

    private static final void println(boolean z) {
        System.out.println(z);
    }

    private static final void println(float f) {
        System.out.println(f);
    }

    private static final void println(double d) {
        System.out.println(d);
    }

    private static final void println(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.println(message);
    }

    private static final void println() {
        System.out.println();
    }

    public static final String readln() {
        String str = readlnOrNull();
        if (str != null) {
            return str;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    public static final String readlnOrNull() {
        return readLine();
    }

    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream in = System.in;
        Intrinsics.checkNotNullExpressionValue(in, "in");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        return lineReader.readLine(in, charsetDefaultCharset);
    }
}
