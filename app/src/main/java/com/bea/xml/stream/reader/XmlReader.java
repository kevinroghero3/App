package com.bea.xml.stream.reader;

import com.google.common.base.Ascii;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.util.Hashtable;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public final class XmlReader extends Reader {
    private static final int MAXPUSHBACK = 512;
    private static final Hashtable charsets;
    private String assignedEncoding;
    private boolean closed;
    private Reader in;

    public static Reader createReader(InputStream inputStream) throws IOException {
        return new XmlReader(inputStream);
    }

    public static Reader createReader(InputStream inputStream, String str) throws IOException {
        if (str == null) {
            return new XmlReader(inputStream);
        }
        if (CharEncoding.UTF_8.equalsIgnoreCase(str) || "UTF8".equalsIgnoreCase(str)) {
            return new Utf8Reader(inputStream);
        }
        if (CharEncoding.US_ASCII.equalsIgnoreCase(str) || "ASCII".equalsIgnoreCase(str)) {
            return new AsciiReader(inputStream);
        }
        if (CharEncoding.ISO_8859_1.equalsIgnoreCase(str)) {
            return new Iso8859_1Reader(inputStream);
        }
        return new InputStreamReader(inputStream, std2java(str));
    }

    static {
        Hashtable hashtable = new Hashtable(31);
        charsets = hashtable;
        hashtable.put(CharEncoding.UTF_16, "Unicode");
        hashtable.put("ISO-10646-UCS-2", "Unicode");
        hashtable.put("EBCDIC-CP-US", "cp037");
        hashtable.put("EBCDIC-CP-CA", "cp037");
        hashtable.put("EBCDIC-CP-NL", "cp037");
        hashtable.put("EBCDIC-CP-WT", "cp037");
        hashtable.put("EBCDIC-CP-DK", "cp277");
        hashtable.put("EBCDIC-CP-NO", "cp277");
        hashtable.put("EBCDIC-CP-FI", "cp278");
        hashtable.put("EBCDIC-CP-SE", "cp278");
        hashtable.put("EBCDIC-CP-IT", "cp280");
        hashtable.put("EBCDIC-CP-ES", "cp284");
        hashtable.put("EBCDIC-CP-GB", "cp285");
        hashtable.put("EBCDIC-CP-FR", "cp297");
        hashtable.put("EBCDIC-CP-AR1", "cp420");
        hashtable.put("EBCDIC-CP-HE", "cp424");
        hashtable.put("EBCDIC-CP-BE", "cp500");
        hashtable.put("EBCDIC-CP-CH", "cp500");
        hashtable.put("EBCDIC-CP-ROECE", "cp870");
        hashtable.put("EBCDIC-CP-YU", "cp870");
        hashtable.put("EBCDIC-CP-IS", "cp871");
        hashtable.put("EBCDIC-CP-AR2", "cp918");
    }

    private static String std2java(String str) {
        String str2 = (String) charsets.get(str.toUpperCase());
        return str2 != null ? str2 : str;
    }

    public String getEncoding() {
        return this.assignedEncoding;
    }

    private XmlReader(InputStream inputStream) throws IOException {
        super(inputStream);
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 512);
        byte[] bArr = new byte[4];
        int i = pushbackInputStream.read(bArr);
        if (i > 0) {
            pushbackInputStream.unread(bArr, 0, i);
        }
        if (i == 4) {
            int i2 = bArr[0] & 255;
            if (i2 != 0) {
                if (i2 == 60) {
                    int i3 = bArr[1] & 255;
                    if (i3 == 0) {
                        if (bArr[2] == 63 && bArr[3] == 0) {
                            setEncoding(pushbackInputStream, "UnicodeLittle");
                            return;
                        }
                    } else if (i3 == 63 && bArr[2] == 120 && bArr[3] == 109) {
                        useEncodingDecl(pushbackInputStream, "UTF8");
                        return;
                    }
                } else if (i2 != 76) {
                    if (i2 == 254) {
                        if ((bArr[1] & 255) == 255) {
                            setEncoding(pushbackInputStream, CharEncoding.UTF_16);
                            return;
                        }
                    } else if (i2 == 255 && (bArr[1] & 255) == 254) {
                        setEncoding(pushbackInputStream, CharEncoding.UTF_16);
                        return;
                    }
                } else if (bArr[1] == 111 && (bArr[2] & 255) == 167 && (bArr[3] & 255) == 148) {
                    useEncodingDecl(pushbackInputStream, "CP037");
                    return;
                }
            } else if (bArr[1] == 60 && bArr[2] == 0 && bArr[3] == 63) {
                setEncoding(pushbackInputStream, "UnicodeBig");
                return;
            }
        }
        setEncoding(pushbackInputStream, CharEncoding.UTF_8);
    }

    /* JADX WARN: Code duplicated, block: B:75:0x00db  */
    private void useEncodingDecl(PushbackInputStream pushbackInputStream, String str) throws IOException {
        int i;
        byte[] bArr = new byte[512];
        int i2 = pushbackInputStream.read(bArr, 0, 512);
        pushbackInputStream.unread(bArr, 0, i2);
        InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bArr, 4, i2), str);
        if (inputStreamReader.read() != 108) {
            setEncoding(pushbackInputStream, CharEncoding.UTF_8);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        boolean z2 = false;
        char c = 0;
        String string = null;
        StringBuffer stringBuffer2 = null;
        for (int i3 = 0; i3 < 507 && (i = inputStreamReader.read()) != -1; i3++) {
            if (i != 32 && i != 9 && i != 10 && i != 13) {
                if (i3 == 0) {
                    break;
                }
                if (i == 63) {
                    z = true;
                } else if (z) {
                    if (i == 62) {
                        break;
                    } else {
                        z = false;
                    }
                }
                if (string != null && z2) {
                    char c2 = (char) i;
                    if (Character.isWhitespace(c2)) {
                        continue;
                    } else if (i != 34 && i != 39) {
                        stringBuffer.append(c2);
                    } else if (c == 0) {
                        stringBuffer.setLength(0);
                        c = c2;
                    } else if (i == c) {
                        if (RRWebVideoEvent.JsonKeys.ENCODING.equals(string)) {
                            this.assignedEncoding = stringBuffer.toString();
                            for (int i4 = 0; i4 < this.assignedEncoding.length(); i4++) {
                                char cCharAt = this.assignedEncoding.charAt(i4);
                                if ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && (i4 == 0 || i4 <= 0 || !(cCharAt == '-' || ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '.' || cCharAt == '_'))))) {
                                    break;
                                }
                            }
                            setEncoding(pushbackInputStream, this.assignedEncoding);
                            return;
                        }
                        string = null;
                    } else {
                        stringBuffer.append(c2);
                    }
                } else if (stringBuffer2 == null) {
                    char c3 = (char) i;
                    if (!Character.isWhitespace(c3)) {
                        stringBuffer.setLength(0);
                        stringBuffer.append(c3);
                        stringBuffer2 = stringBuffer;
                        z2 = false;
                    }
                } else {
                    char c4 = (char) i;
                    if (Character.isWhitespace(c4)) {
                        string = stringBuffer2.toString();
                    } else if (i == 61) {
                        if (string == null) {
                            string = stringBuffer2.toString();
                        }
                        c = 0;
                        z2 = true;
                        stringBuffer2 = null;
                    } else {
                        stringBuffer2.append(c4);
                    }
                }
            }
        }
        setEncoding(pushbackInputStream, CharEncoding.UTF_8);
    }

    private void setEncoding(InputStream inputStream, String str) throws IOException {
        this.assignedEncoding = str;
        this.in = createReader(inputStream, str);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        if (this.closed) {
            return -1;
        }
        int i3 = this.in.read(cArr, i, i2);
        if (i3 == -1) {
            close();
        }
        return i3;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
        int i = this.in.read();
        if (i == -1) {
            close();
        }
        return i;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        Reader reader = this.in;
        if (reader == null) {
            return false;
        }
        return reader.markSupported();
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        Reader reader = this.in;
        if (reader != null) {
            reader.mark(i);
        }
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        Reader reader = this.in;
        if (reader != null) {
            reader.reset();
        }
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        Reader reader = this.in;
        if (reader == null) {
            return 0L;
        }
        return reader.skip(j);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.in;
        if (reader == null) {
            return false;
        }
        return reader.ready();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.in.close();
        this.in = null;
        this.closed = true;
    }

    public static abstract class BaseReader extends Reader {
        protected byte[] buffer;
        protected int finish;
        protected InputStream instream;
        protected int start;

        public abstract String getEncoding();

        BaseReader(InputStream inputStream) {
            super(inputStream);
            this.instream = inputStream;
            this.buffer = new byte[8192];
        }

        @Override // java.io.Reader
        public boolean ready() throws IOException {
            InputStream inputStream = this.instream;
            return inputStream == null || this.finish - this.start > 0 || inputStream.available() != 0;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.instream;
            if (inputStream != null) {
                inputStream.close();
                this.finish = 0;
                this.start = 0;
                this.buffer = null;
                this.instream = null;
            }
        }
    }

    static final class Utf8Reader extends BaseReader {
        private char nextChar;

        Utf8Reader(InputStream inputStream) {
            super(inputStream);
        }

        @Override // com.bea.xml.stream.reader.XmlReader.BaseReader
        public String getEncoding() {
            return CharEncoding.UTF_8;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            byte b;
            if (i2 <= 0) {
                return 0;
            }
            if (i + i2 > cArr.length || i < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            char c = this.nextChar;
            if (c != 0) {
                cArr[i] = c;
                this.nextChar = (char) 0;
                i4 = 0;
                i3 = 1;
            } else {
                i3 = 0;
                i4 = 0;
            }
            while (i3 < i2) {
                if (this.finish <= this.start) {
                    InputStream inputStream = this.instream;
                    if (inputStream != null) {
                        this.start = 0;
                        byte[] bArr = this.buffer;
                        int i10 = inputStream.read(bArr, 0, bArr.length);
                        this.finish = i10;
                        if (i10 <= 0) {
                            close();
                        }
                    }
                    i4 = -1;
                    break;
                }
                byte[] bArr2 = this.buffer;
                int i11 = this.start;
                byte b2 = bArr2[i11];
                int i12 = b2 & 255;
                if ((b2 & 128) == 0) {
                    this.start = i11 + 1;
                    cArr[i3 + i] = (char) i12;
                    i3++;
                    i4 = i12;
                } else {
                    if ((b2 & 224) == 192) {
                        i8 = (b2 & Ascii.US) << 6;
                        i7 = i11 + 2;
                        try {
                            b = bArr2[i11 + 1];
                            i6 = i8 + (b & Utf8.REPLACEMENT_BYTE);
                            i4 = i6;
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            i9 = i7;
                            i5 = i9;
                            i4 = 0;
                            i7 = i5;
                        }
                    } else {
                        if ((b2 & 240) == 224) {
                            int i13 = i11 + 2;
                            try {
                                i8 = ((b2 & Ascii.SI) << 12) + ((bArr2[i11 + 1] & Utf8.REPLACEMENT_BYTE) << 6);
                                i9 = i11 + 3;
                                try {
                                    b = bArr2[i13];
                                    i7 = i9;
                                    i6 = i8 + (b & Utf8.REPLACEMENT_BYTE);
                                    i4 = i6;
                                } catch (ArrayIndexOutOfBoundsException unused2) {
                                    i5 = i9;
                                    i4 = 0;
                                    i7 = i5;
                                }
                            } catch (ArrayIndexOutOfBoundsException unused3) {
                                i5 = i13;
                                i4 = 0;
                                i7 = i5;
                            }
                        } else if ((b2 & 248) == 240) {
                            int i14 = i11 + 2;
                            byte b3 = bArr2[i11 + 1];
                            i5 = i11 + 3;
                            try {
                                int i15 = i11 + 4;
                                i6 = ((b2 & 7) << 18) + ((b3 & Utf8.REPLACEMENT_BYTE) << 12) + ((bArr2[i14] & Utf8.REPLACEMENT_BYTE) << 6) + (bArr2[i5] & Utf8.REPLACEMENT_BYTE);
                                if (i6 > 1114111) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("UTF-8 encoding of character 0x00");
                                    stringBuffer.append(Integer.toHexString(i6));
                                    stringBuffer.append(" can't be converted to Unicode.");
                                    throw new CharConversionException(stringBuffer.toString());
                                }
                                if (i6 > 65535) {
                                    int i16 = i6 - 65536;
                                    this.nextChar = (char) ((i16 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                    i6 = 55296 + (i16 >> 10);
                                }
                                i7 = i15;
                                i4 = i6;
                            } catch (ArrayIndexOutOfBoundsException unused4) {
                                i4 = 0;
                                i7 = i5;
                            }
                        } else {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Unconvertible UTF-8 character beginning with 0x");
                            stringBuffer2.append(Integer.toHexString(this.buffer[this.start] & 255));
                            throw new CharConversionException(stringBuffer2.toString());
                        }
                        i4 = 0;
                        i7 = i5;
                    }
                    int i17 = this.finish;
                    if (i7 > i17) {
                        byte[] bArr3 = this.buffer;
                        int i18 = this.start;
                        System.arraycopy(bArr3, i18, bArr3, 0, i17 - i18);
                        int i19 = this.finish - this.start;
                        this.finish = i19;
                        this.start = 0;
                        InputStream inputStream2 = this.instream;
                        byte[] bArr4 = this.buffer;
                        int i20 = inputStream2.read(bArr4, i19, bArr4.length - i19);
                        if (i20 < 0) {
                            close();
                            throw new CharConversionException("Partial UTF-8 char");
                        }
                        this.finish += i20;
                    } else {
                        int i21 = this.start + 1;
                        while (true) {
                            this.start = i21;
                            int i22 = this.start;
                            if (i22 < i7) {
                                if ((this.buffer[i22] & 192) != 128) {
                                    close();
                                    throw new CharConversionException("Malformed UTF-8 char -- is an XML encoding declaration missing?");
                                }
                                i21 = i22 + 1;
                            } else {
                                int i23 = i3 + 1;
                                cArr[i + i3] = (char) i4;
                                char c2 = this.nextChar;
                                if (c2 != 0 && i23 < i2) {
                                    i3 += 2;
                                    cArr[i23 + i] = c2;
                                    this.nextChar = (char) 0;
                                    break;
                                }
                                i3 = i23;
                                break;
                            }
                        }
                    }
                }
            }
            if (i3 > 0) {
                return i3;
            }
            return i4 == -1 ? -1 : 0;
        }
    }

    static final class AsciiReader extends BaseReader {
        AsciiReader(InputStream inputStream) {
            super(inputStream);
        }

        @Override // com.bea.xml.stream.reader.XmlReader.BaseReader
        public String getEncoding() {
            return CharEncoding.US_ASCII;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            InputStream inputStream = this.instream;
            if (inputStream == null) {
                return -1;
            }
            if (i + i2 > cArr.length || i < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.finish - this.start;
            if (i3 < 1) {
                this.start = 0;
                byte[] bArr = this.buffer;
                int i4 = inputStream.read(bArr, 0, bArr.length);
                this.finish = i4;
                if (i4 <= 0) {
                    close();
                    return -1;
                }
                if (i2 > i4) {
                    i2 = i4;
                }
            } else if (i2 > i3) {
                i2 = i3;
            }
            for (int i5 = 0; i5 < i2; i5++) {
                byte[] bArr2 = this.buffer;
                int i6 = this.start;
                this.start = i6 + 1;
                byte b = bArr2[i6];
                if (b < 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Illegal ASCII character, 0x");
                    stringBuffer.append(Integer.toHexString(b & 255));
                    throw new CharConversionException(stringBuffer.toString());
                }
                cArr[i + i5] = (char) b;
            }
            return i2;
        }
    }

    static final class Iso8859_1Reader extends BaseReader {
        Iso8859_1Reader(InputStream inputStream) {
            super(inputStream);
        }

        @Override // com.bea.xml.stream.reader.XmlReader.BaseReader
        public String getEncoding() {
            return CharEncoding.ISO_8859_1;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            InputStream inputStream = this.instream;
            if (inputStream == null) {
                return -1;
            }
            if (i + i2 > cArr.length || i < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.finish - this.start;
            if (i3 < 1) {
                this.start = 0;
                byte[] bArr = this.buffer;
                int i4 = inputStream.read(bArr, 0, bArr.length);
                this.finish = i4;
                if (i4 <= 0) {
                    close();
                    return -1;
                }
                if (i2 > i4) {
                    i2 = i4;
                }
            } else if (i2 > i3) {
                i2 = i3;
            }
            for (int i5 = 0; i5 < i2; i5++) {
                byte[] bArr2 = this.buffer;
                int i6 = this.start;
                this.start = i6 + 1;
                cArr[i + i5] = (char) (bArr2[i6] & 255);
            }
            return i2;
        }
    }
}
