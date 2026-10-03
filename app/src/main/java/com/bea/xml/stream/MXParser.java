package com.bea.xml.stream;

import androidx.compose.animation.core.AnimationKt;
import ch.qos.logback.core.CoreConstants;
import com.bea.xml.stream.events.DTDEvent;
import com.bea.xml.stream.reader.XmlReader;
import com.bea.xml.stream.util.ElementTypeNames;
import com.bea.xml.stream.util.EmptyIterator;
import com.wutka.dtd.DTD;
import com.wutka.dtd.DTDAttlist;
import com.wutka.dtd.DTDAttribute;
import com.wutka.dtd.DTDEntity;
import com.wutka.dtd.DTDNotation;
import com.wutka.dtd.DTDParser;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.NotationDeclaration;
import kotlin.text.Typography;
import okio.Utf8;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public class MXParser implements XMLStreamReader, Location {
    protected static final char CHAR_UTF8_BOM = 65279;
    private static final int DOCDECL = 32768;
    protected static final char[] ENCODING;
    static final String EOF_MSG = "Unexpected end of stream";
    protected static final String FEATURE_NAMES_INTERNED = "http://xmlpull.org/v1/doc/features.html#names-interned";
    public static final String FEATURE_PROCESS_DOCDECL = "http://xmlpull.org/v1/doc/features.html#process-docdecl";
    public static final String FEATURE_PROCESS_NAMESPACES = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
    public static final String FEATURE_STAX_ENTITIES = "javax.xml.stream.entities";
    public static final String FEATURE_STAX_NOTATIONS = "javax.xml.stream.notations";
    protected static final String FEATURE_XML_ROUNDTRIP = "http://xmlpull.org/v1/doc/features.html#xml-roundtrip";
    protected static final int LOOKUP_MAX = 1024;
    protected static final char LOOKUP_MAX_CHAR = 1024;
    protected static final int MAX_UNICODE_CHAR = 1114111;
    protected static final char[] NO;
    private static final char[] NO_CHARS;
    private static final int[] NO_INTS;
    private static final String[] NO_STRINGS;
    protected static final int READ_CHUNK_SIZE = 8192;
    protected static final char[] STANDALONE;
    private static final int TEXT = 16384;
    private static final boolean TRACE_SIZING = false;
    protected static final char[] VERSION;
    protected static final char[] YES;
    static /* synthetic */ Class class$com$wutka$dtd$DTDAttlist;
    static /* synthetic */ Class class$com$wutka$dtd$DTDEntity;
    static /* synthetic */ Class class$com$wutka$dtd$DTDNotation;
    protected boolean allStringsInterned;
    protected int attributeCount;
    protected String[] attributeName;
    protected int[] attributeNameHash;
    protected String[] attributePrefix;
    protected String[] attributeUri;
    protected String[] attributeValue;
    protected char[] buf;
    protected int bufAbsoluteStart;
    protected int bufEnd;
    protected int bufLoadFactor;
    protected int bufSoftLimit;
    protected int bufStart;
    protected String charEncodingScheme;
    protected char[] charRefOneCharBuf;
    protected char[] charRefTwoCharBuf;
    protected int columnNumber;
    private ConfigurationContextBase configurationContext;
    protected HashMap defaultAttributes;
    protected int depth;
    protected String[] elName;
    protected int[] elNamespaceCount;
    protected String[] elPrefix;
    protected char[][] elRawName;
    protected int[] elRawNameEnd;
    protected String[] elUri;
    protected boolean emptyElementTag;
    protected int entityEnd;
    protected String[] entityName;
    protected char[][] entityNameBuf;
    protected int[] entityNameHash;
    protected String entityRefName;
    protected String[] entityReplacement;
    protected char[][] entityReplacementBuf;
    protected char[] entityValue;
    protected int eventType;
    protected String inputEncoding;
    protected int lineNumber;
    protected int localNamespaceEnd;
    protected String[] localNamespacePrefix;
    protected int[] localNamespacePrefixHash;
    protected String[] localNamespaceUri;
    protected DTD mDtdIntSubset;
    protected int namespaceEnd;
    protected String[] namespacePrefix;
    protected int[] namespacePrefixHash;
    protected String[] namespaceUri;
    protected boolean pastEndTag;
    protected char[] pc;
    protected int pcEnd;
    protected int pcStart;
    protected String piData;
    protected String piTarget;
    protected int pos;
    protected int posEnd;
    protected int posStart;
    protected boolean reachedEnd;
    protected Reader reader;
    protected boolean seenAmpersand;
    protected boolean seenDocdecl;
    protected boolean seenEndTag;
    protected boolean seenMarkup;
    protected boolean seenRoot;
    protected boolean seenStartTag;
    protected String text;
    protected boolean tokenize;
    protected boolean usePC;
    public static final String[] TYPES = {"[UNKNOWN]", "START_ELEMENT", "END_ELEMENT", "PROCESSING_INSTRUCTION", "CHARACTERS", "COMMENT", "SPACE", "START_DOCUMENT", "END_DOCUMENT", "ENTITY_REFERENCE", "ATTRIBUTE", "DTD", "CDATA", "NAMESPACE", "NOTATION_DECLARATION", "ENTITY_DECLARATION"};
    public static final String NO_NAMESPACE = null;
    protected static boolean[] lookupNameStartChar = new boolean[1024];
    protected static boolean[] lookupNameChar = new boolean[1024];
    private boolean reportCdataEvent = false;
    protected boolean processNamespaces = true;
    protected boolean roundtripSupported = true;
    protected String xmlVersion = null;
    protected boolean standalone = false;
    protected boolean standaloneSet = false;

    private static boolean isElementEvent(int i) {
        return i == 1 || i == 2;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public void close() throws XMLStreamException {
    }

    @Override // javax.xml.stream.XMLStreamReader
    public Location getLocation() {
        return this;
    }

    public String getLocationURI() {
        return null;
    }

    @Override // javax.xml.stream.Location
    public String getPublicId() {
        return null;
    }

    @Override // javax.xml.stream.Location
    public String getSystemId() {
        return null;
    }

    protected boolean isS(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t';
    }

    protected void resetStringCache() {
    }

    static {
        setNameStart(CoreConstants.COLON_CHAR);
        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            setNameStart(c);
        }
        setNameStart('_');
        for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
            setNameStart(c2);
        }
        for (char c3 = 192; c3 <= 767; c3 = (char) (c3 + 1)) {
            setNameStart(c3);
        }
        for (char c4 = 880; c4 <= 893; c4 = (char) (c4 + 1)) {
            setNameStart(c4);
        }
        for (char c5 = 895; c5 < 1024; c5 = (char) (c5 + 1)) {
            setNameStart(c5);
        }
        setName(CoreConstants.DASH_CHAR);
        setName('.');
        for (char c6 = '0'; c6 <= '9'; c6 = (char) (c6 + 1)) {
            setName(c6);
        }
        setName(Typography.middleDot);
        for (char c7 = 768; c7 <= 879; c7 = (char) (c7 + 1)) {
            setName(c7);
        }
        NO_STRINGS = new String[0];
        NO_INTS = new int[0];
        NO_CHARS = new char[0];
        VERSION = new char[]{'v', 'e', 'r', 's', 'i', 'o', 'n'};
        ENCODING = new char[]{'e', 'n', 'c', 'o', 'd', 'i', 'n', 'g'};
        STANDALONE = new char[]{'s', 't', 'a', 'n', 'd', 'a', 'l', 'o', 'n', 'e'};
        YES = new char[]{'y', 'e', 's'};
        NO = new char[]{'n', 'o'};
    }

    protected String newString(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    protected String newStringIntern(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2).intern();
    }

    protected void ensureElementsCapacity() {
        String[] strArr = this.elName;
        int length = strArr != null ? strArr.length : 0;
        int i = this.depth;
        if (i + 1 >= length) {
            int i2 = (i >= 7 ? i * 2 : 8) + 2;
            boolean z = length > 0;
            String[] strArr2 = new String[i2];
            if (z) {
                System.arraycopy(strArr, 0, strArr2, 0, length);
            }
            this.elName = strArr2;
            String[] strArr3 = new String[i2];
            if (z) {
                System.arraycopy(this.elPrefix, 0, strArr3, 0, length);
            }
            this.elPrefix = strArr3;
            String[] strArr4 = new String[i2];
            if (z) {
                System.arraycopy(this.elUri, 0, strArr4, 0, length);
            }
            this.elUri = strArr4;
            int[] iArr = new int[i2];
            if (z) {
                System.arraycopy(this.elNamespaceCount, 0, iArr, 0, length);
            } else {
                iArr[0] = 0;
            }
            this.elNamespaceCount = iArr;
            int[] iArr2 = new int[i2];
            if (z) {
                System.arraycopy(this.elRawNameEnd, 0, iArr2, 0, length);
            }
            this.elRawNameEnd = iArr2;
            char[][] cArr = new char[i2][];
            if (z) {
                System.arraycopy(this.elRawName, 0, cArr, 0, length);
            }
            this.elRawName = cArr;
        }
    }

    private static final void setName(char c) {
        lookupNameChar[c] = true;
    }

    private static final void setNameStart(char c) {
        lookupNameStartChar[c] = true;
        setName(c);
    }

    protected boolean isNameStartChar(char c) {
        return (c < 1024 && lookupNameStartChar[c]) || (c >= 1024 && c <= 8231) || ((c >= 8234 && c <= 8591) || (c >= 10240 && c <= 65519));
    }

    protected boolean isNameChar(char c) {
        return (c < 1024 && lookupNameChar[c]) || (c >= 1024 && c <= 8231) || ((c >= 8234 && c <= 8591) || (c >= 10240 && c <= 65519));
    }

    protected void checkCharValidity(int i, boolean z) throws XMLStreamException {
        if (i < 32) {
            if (isS((char) i)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Illegal white space character (code 0x");
            stringBuffer.append(Integer.toHexString(i));
            stringBuffer.append(")");
            throw new XMLStreamException(stringBuffer.toString());
        }
        if (i >= 55296) {
            if (i <= 57343) {
                if (z) {
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Illegal character (code 0x");
                stringBuffer2.append(Integer.toHexString(i));
                stringBuffer2.append("): surrogate characters are not valid XML characters");
                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
            }
            if (i <= MAX_UNICODE_CHAR) {
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Illegal character (code 0x");
            stringBuffer3.append(Integer.toHexString(i));
            stringBuffer3.append("), past max. Unicode character 0x");
            stringBuffer3.append(Integer.toHexString(MAX_UNICODE_CHAR));
            throw new XMLStreamException(stringBuffer3.toString(), getLocation());
        }
    }

    protected void ensureAttributesCapacity(int i) {
        String[] strArr = this.attributeName;
        int length = strArr != null ? strArr.length : 0;
        if (i >= length) {
            int i2 = i > 7 ? i * 2 : 8;
            boolean z = length > 0;
            String[] strArr2 = new String[i2];
            if (z) {
                System.arraycopy(strArr, 0, strArr2, 0, length);
            }
            this.attributeName = strArr2;
            String[] strArr3 = new String[i2];
            if (z) {
                System.arraycopy(this.attributePrefix, 0, strArr3, 0, length);
            }
            this.attributePrefix = strArr3;
            String[] strArr4 = new String[i2];
            if (z) {
                System.arraycopy(this.attributeUri, 0, strArr4, 0, length);
            }
            this.attributeUri = strArr4;
            String[] strArr5 = new String[i2];
            if (z) {
                System.arraycopy(this.attributeValue, 0, strArr5, 0, length);
            }
            this.attributeValue = strArr5;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            if (z) {
                System.arraycopy(this.attributeNameHash, 0, iArr, 0, length);
            }
            this.attributeNameHash = iArr;
        }
    }

    protected void ensureNamespacesCapacity(int i) {
        String[] strArr = this.namespacePrefix;
        if (i >= (strArr != null ? strArr.length : 0)) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr2 = new String[i2];
            String[] strArr3 = new String[i2];
            if (strArr != null) {
                System.arraycopy(strArr, 0, strArr2, 0, this.namespaceEnd);
                System.arraycopy(this.namespaceUri, 0, strArr3, 0, this.namespaceEnd);
            }
            this.namespacePrefix = strArr2;
            this.namespaceUri = strArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.namespacePrefixHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.namespaceEnd);
            }
            this.namespacePrefixHash = iArr;
        }
    }

    protected void ensureLocalNamespacesCapacity(int i) {
        String[] strArr = this.localNamespacePrefix;
        if (i >= (strArr != null ? strArr.length : 0)) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr2 = new String[i2];
            String[] strArr3 = new String[i2];
            if (strArr != null) {
                System.arraycopy(strArr, 0, strArr2, 0, this.localNamespaceEnd);
                System.arraycopy(this.localNamespaceUri, 0, strArr3, 0, this.localNamespaceEnd);
            }
            this.localNamespacePrefix = strArr2;
            this.localNamespaceUri = strArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.localNamespacePrefixHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.localNamespaceEnd);
            }
            this.localNamespacePrefixHash = iArr;
        }
    }

    public int getLocalNamespaceCount() {
        return this.namespaceEnd - this.elNamespaceCount[this.depth - 1];
    }

    private String getLocalNamespaceURI(int i) {
        return this.namespaceUri[i];
    }

    private String getLocalNamespacePrefix(int i) {
        return this.namespacePrefix[i];
    }

    protected static final int fastHash(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = (cArr[i] << 7) + cArr[(i + i2) - 1];
        if (i2 > 16) {
            i3 = (i3 << 7) + cArr[(i2 / 4) + i];
        }
        return i2 > 8 ? (i3 << 7) + cArr[i + (i2 / 2)] : i3;
    }

    protected void ensureEntityCapacity() {
        char[][] cArr = this.entityReplacementBuf;
        int length = cArr != null ? cArr.length : 0;
        int i = this.entityEnd;
        if (i >= length) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr = new String[i2];
            char[][] cArr2 = new char[i2][];
            String[] strArr2 = new String[i2];
            char[][] cArr3 = new char[i2][];
            String[] strArr3 = this.entityName;
            if (strArr3 != null) {
                System.arraycopy(strArr3, 0, strArr, 0, i);
                System.arraycopy(this.entityNameBuf, 0, cArr2, 0, this.entityEnd);
                System.arraycopy(this.entityReplacement, 0, strArr2, 0, this.entityEnd);
                System.arraycopy(this.entityReplacementBuf, 0, cArr3, 0, this.entityEnd);
            }
            this.entityName = strArr;
            this.entityNameBuf = cArr2;
            this.entityReplacement = strArr2;
            this.entityReplacementBuf = cArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.entityNameHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.entityEnd);
            }
            this.entityNameHash = iArr;
        }
    }

    private void reset() {
        this.lineNumber = 1;
        this.columnNumber = 0;
        this.seenRoot = false;
        this.reachedEnd = false;
        this.eventType = 7;
        this.emptyElementTag = false;
        this.depth = 0;
        this.attributeCount = 0;
        this.namespaceEnd = 0;
        this.localNamespaceEnd = 0;
        this.entityEnd = 0;
        this.reader = null;
        this.inputEncoding = null;
        this.bufAbsoluteStart = 0;
        this.bufStart = 0;
        this.bufEnd = 0;
        this.posEnd = 0;
        this.posStart = 0;
        this.pos = 0;
        this.pcStart = 0;
        this.pcEnd = 0;
        this.usePC = false;
        this.seenStartTag = false;
        this.seenEndTag = false;
        this.pastEndTag = false;
        this.seenAmpersand = false;
        this.seenMarkup = false;
        this.seenDocdecl = false;
        resetStringCache();
    }

    public MXParser() {
        String[] strArr = NO_STRINGS;
        this.namespacePrefix = strArr;
        this.namespaceUri = strArr;
        this.bufLoadFactor = 95;
        int i = Runtime.getRuntime().freeMemory() > AnimationKt.MillisToNanos ? 8192 : 256;
        this.buf = new char[i];
        this.bufSoftLimit = (this.bufLoadFactor * i) / 100;
        this.pc = new char[Runtime.getRuntime().freeMemory() <= AnimationKt.MillisToNanos ? 64 : 8192];
        this.entityValue = null;
        this.charRefOneCharBuf = new char[1];
        this.charRefTwoCharBuf = null;
    }

    public void setFeature(String str, boolean z) throws XMLStreamException {
        if (str == null) {
            throw new IllegalArgumentException("feature name should not be nulll");
        }
        if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(str)) {
            if (this.eventType != 7) {
                throw new XMLStreamException("namespace processing feature can only be changed before parsing", getLocation());
            }
            this.processNamespaces = z;
            return;
        }
        if (FEATURE_NAMES_INTERNED.equals(str)) {
            if (z) {
                throw new XMLStreamException("interning names in this implementation is not supported");
            }
            return;
        }
        if ("http://xmlpull.org/v1/doc/features.html#process-docdecl".equals(str)) {
            if (z) {
                throw new XMLStreamException("processing DOCDECL is not supported");
            }
        } else if (FEATURE_XML_ROUNDTRIP.equals(str)) {
            if (!z) {
                throw new XMLStreamException("roundtrip feature can not be switched off");
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("unknown feature ");
            stringBuffer.append(str);
            throw new XMLStreamException(stringBuffer.toString());
        }
    }

    public boolean getFeature(String str) {
        if (str == null) {
            throw new IllegalArgumentException("feature name should not be null");
        }
        if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(str)) {
            return this.processNamespaces;
        }
        return (FEATURE_NAMES_INTERNED.equals(str) || "http://xmlpull.org/v1/doc/features.html#process-docdecl".equals(str) || !FEATURE_XML_ROUNDTRIP.equals(str)) ? false : true;
    }

    public void setProperty(String str, Object obj) throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported property: '");
        stringBuffer.append(str);
        stringBuffer.append("'");
        throw new XMLStreamException(stringBuffer.toString());
    }

    public boolean checkForXMLDecl() throws XMLStreamException {
        try {
            BufferedReader bufferedReader = new BufferedReader(this.reader, 7);
            this.reader = bufferedReader;
            bufferedReader.mark(7);
            int i = bufferedReader.read();
            if (i == 65279) {
                bufferedReader.mark(7);
                i = bufferedReader.read();
            }
            if (i == 60 && bufferedReader.read() == 63 && bufferedReader.read() == 120 && bufferedReader.read() == 109 && bufferedReader.read() == 108) {
                bufferedReader.reset();
                return true;
            }
            bufferedReader.reset();
            return false;
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    public void setInput(Reader reader) throws XMLStreamException {
        reset();
        this.reader = reader;
        if (checkForXMLDecl()) {
            next();
        }
    }

    public void setInput(InputStream inputStream) throws XMLStreamException {
        try {
            Reader readerCreateReader = XmlReader.createReader(inputStream);
            String encoding = readerCreateReader instanceof XmlReader.BaseReader ? ((XmlReader.BaseReader) readerCreateReader).getEncoding() : null;
            setInput(readerCreateReader);
            if (encoding != null) {
                this.inputEncoding = encoding;
            }
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    public void setInput(InputStream inputStream, String str) throws XMLStreamException {
        String string;
        if (inputStream == null) {
            throw new IllegalArgumentException("input stream can not be null");
        }
        try {
            setInput(str != null ? XmlReader.createReader(inputStream, str) : XmlReader.createReader(inputStream));
            if (str != null) {
                this.inputEncoding = str;
            }
        } catch (IOException e) {
            if (str == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("(for encoding '");
                stringBuffer.append(str);
                stringBuffer.append("')");
                string = stringBuffer.toString();
            } else {
                string = "";
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("could not create reader ");
            stringBuffer2.append(string);
            stringBuffer2.append(": ");
            stringBuffer2.append(e);
            throw new XMLStreamException(stringBuffer2.toString(), getLocation(), e);
        }
    }

    public String getInputEncoding() {
        return this.inputEncoding;
    }

    public void defineEntityReplacementText(String str, String str2) throws XMLStreamException {
        ensureEntityCapacity();
        char[] charArray = str.toCharArray();
        this.entityName[this.entityEnd] = newString(charArray, 0, str.length());
        char[][] cArr = this.entityNameBuf;
        int i = this.entityEnd;
        cArr[i] = charArray;
        this.entityReplacement[i] = str2;
        char[] charArray2 = str2 == null ? NO_CHARS : str2.toCharArray();
        char[][] cArr2 = this.entityReplacementBuf;
        int i2 = this.entityEnd;
        cArr2[i2] = charArray2;
        if (!this.allStringsInterned) {
            int[] iArr = this.entityNameHash;
            char[] cArr3 = this.entityNameBuf[i2];
            iArr[i2] = fastHash(cArr3, 0, cArr3.length);
        }
        this.entityEnd++;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int getNamespaceCount() {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        return getNamespaceCount(this.depth);
    }

    public int getNamespaceCount(int i) {
        if (!this.processNamespaces || i == 0) {
            return 0;
        }
        if (i < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("namespace count may be 0..");
            stringBuffer.append(this.depth);
            stringBuffer.append(" not ");
            stringBuffer.append(i);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        int[] iArr = this.elNamespaceCount;
        return iArr[i] - iArr[i - 1];
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getNamespacePrefix(int i) {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        int i2 = this.depth;
        int namespaceCount = getNamespaceCount(i2);
        int i3 = this.elNamespaceCount[i2 - 1];
        if (i < namespaceCount) {
            return this.namespacePrefix[i3 + i];
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("position ");
        stringBuffer.append(i);
        stringBuffer.append(" exceeded number of available namespaces ");
        stringBuffer.append(namespaceCount);
        throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(int i) {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        int i2 = this.depth;
        int namespaceCount = getNamespaceCount(i2);
        int i3 = this.elNamespaceCount[i2 - 1];
        if (i < namespaceCount) {
            return this.namespaceUri[i3 + i];
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("position ");
        stringBuffer.append(i);
        stringBuffer.append(" exceedded number of available namespaces ");
        stringBuffer.append(namespaceCount);
        throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(String str) {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        if (str != null && str.length() > 0) {
            for (int i = this.namespaceEnd - 1; i >= 0; i--) {
                if (str.equals(this.namespacePrefix[i])) {
                    return this.namespaceUri[i];
                }
            }
            if (XMLConstants.XML_NS_PREFIX.equals(str)) {
                return XMLConstants.XML_NS_URI;
            }
            if (XMLConstants.XMLNS_ATTRIBUTE.equals(str)) {
                return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
            }
            return null;
        }
        for (int i2 = this.namespaceEnd - 1; i2 >= 0; i2--) {
            if (this.namespacePrefix[i2] == null) {
                return this.namespaceUri[i2];
            }
        }
        return null;
    }

    public int getDepth() {
        return this.depth;
    }

    private static int findFragment(int i, char[] cArr, int i2, int i3) {
        if (i2 < i) {
            return i > i3 ? i3 : i;
        }
        if (i3 - i2 > 65) {
            i2 = i3 - 10;
        }
        int i4 = i2 + 1;
        while (true) {
            i4--;
            if (i4 <= i || i3 - i4 > 65 || (cArr[i4] == '<' && i2 - i4 > 10)) {
                break;
            }
        }
        return i4;
    }

    public String getPositionDescription() {
        String string;
        int i = this.posStart;
        int i2 = this.pos;
        String str = null;
        if (i <= i2) {
            int iFindFragment = findFragment(0, this.buf, i, i2);
            int i3 = this.pos;
            str = iFindFragment < i3 ? new String(this.buf, iFindFragment, i3 - iFindFragment) : null;
            if (this.bufAbsoluteStart > 0 || iFindFragment > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("...");
                stringBuffer.append(str);
                str = stringBuffer.toString();
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(StringUtils.SPACE);
        if (str != null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(" seen ");
            stringBuffer3.append(printable(str));
            stringBuffer3.append("...");
            string = stringBuffer3.toString();
        } else {
            string = "";
        }
        stringBuffer2.append(string);
        stringBuffer2.append(" @");
        stringBuffer2.append(getLineNumber());
        stringBuffer2.append(":");
        stringBuffer2.append(getColumnNumber());
        return stringBuffer2.toString();
    }

    @Override // javax.xml.stream.Location
    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // javax.xml.stream.Location
    public int getColumnNumber() {
        return this.columnNumber;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean isWhiteSpace() {
        int i = this.eventType;
        if (i != 4 && i != 12) {
            return i == 6;
        }
        if (this.usePC) {
            for (int i2 = this.pcStart; i2 < this.pcEnd; i2++) {
                if (!isS(this.pc[i2])) {
                    return false;
                }
            }
            return true;
        }
        for (int i3 = this.posStart; i3 < this.posEnd; i3++) {
            if (!isS(this.buf[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getNamespaceURI() {
        int i = this.eventType;
        if (i == 1 || i == 2) {
            return this.processNamespaces ? this.elUri[this.depth] : NO_NAMESPACE;
        }
        return throwIllegalState(new int[]{1, 2});
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getLocalName() {
        int i = this.eventType;
        if (i == 1) {
            return this.elName[this.depth];
        }
        if (i == 2) {
            return this.elName[this.depth];
        }
        if (i == 9) {
            if (this.entityRefName == null) {
                char[] cArr = this.buf;
                int i2 = this.posStart;
                this.entityRefName = newString(cArr, i2, this.posEnd - i2);
            }
            return this.entityRefName;
        }
        return throwIllegalState(new int[]{1, 2, 9});
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getPrefix() {
        int i = this.eventType;
        if (i == 1 || i == 2) {
            return this.elPrefix[this.depth];
        }
        return throwIllegalState(new int[]{1, 2});
    }

    public boolean isEmptyElementTag() throws XMLStreamException {
        if (this.eventType != 1) {
            throw new XMLStreamException("parser must be on XMLStreamConstants.START_ELEMENT to check for empty element", getLocation());
        }
        return this.emptyElementTag;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int getAttributeCount() {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        return this.attributeCount;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getAttributeNamespace(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (!this.processNamespaces) {
            return NO_NAMESPACE;
        }
        if (i < 0 || i >= this.attributeCount) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("attribute position must be 0..");
            stringBuffer.append(this.attributeCount - 1);
            stringBuffer.append(" and not ");
            stringBuffer.append(i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        return this.attributeUri[i];
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getAttributeLocalName(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i < 0 || i >= this.attributeCount) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("attribute position must be 0..");
            stringBuffer.append(this.attributeCount - 1);
            stringBuffer.append(" and not ");
            stringBuffer.append(i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        return this.attributeName[i];
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getAttributePrefix(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (!this.processNamespaces) {
            return null;
        }
        if (i < 0 || i >= this.attributeCount) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("attribute position must be 0..");
            stringBuffer.append(this.attributeCount - 1);
            stringBuffer.append(" and not ");
            stringBuffer.append(i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        return this.attributePrefix[i];
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getAttributeType(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i < 0 || i >= this.attributeCount) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("attribute position must be 0..");
            stringBuffer.append(this.attributeCount - 1);
            stringBuffer.append(" and not ");
            stringBuffer.append(i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        return "CDATA";
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean isAttributeSpecified(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i >= 0 && i < this.attributeCount) {
            return true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("attribute position must be 0..");
        stringBuffer.append(this.attributeCount - 1);
        stringBuffer.append(" and not ");
        stringBuffer.append(i);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getAttributeValue(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i < 0 || i >= this.attributeCount) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("attribute position must be 0..");
            stringBuffer.append(this.attributeCount - 1);
            stringBuffer.append(" and not ");
            stringBuffer.append(i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        return this.attributeValue[i];
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getAttributeValue(String str, String str2) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (str2 == null) {
            throw new IllegalArgumentException("attribute name can not be null");
        }
        int i = 0;
        if (str != null) {
            while (i < this.attributeCount) {
                if (str2.equals(this.attributeName[i]) && str.equals(this.attributeUri[i])) {
                    return this.attributeValue[i];
                }
                i++;
            }
            return null;
        }
        while (i < this.attributeCount) {
            if (str2.equals(this.attributeName[i])) {
                return this.attributeValue[i];
            }
            i++;
        }
        return null;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int getEventType() {
        return this.eventType;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0184 A[ORIG_RETURN, RETURN] */
    @Override // javax.xml.stream.XMLStreamReader
    public void require(int i, String str, String str2) throws XMLStreamException {
        String string;
        String string2;
        String string3;
        String string4;
        int eventType = getEventType();
        boolean zEquals = i == eventType;
        if (zEquals && str2 != null) {
            if (eventType == 1 || eventType == 2 || eventType == 9) {
                zEquals = str2.equals(getLocalName());
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Using non-null local name argument for require(); ");
                stringBuffer.append(ElementTypeNames.getEventTypeString(eventType));
                stringBuffer.append(" event does not have local name");
                throw new XMLStreamException(stringBuffer.toString(), getLocation());
            }
        }
        if (zEquals && str != null && (eventType == 1 || eventType == 1)) {
            String namespaceURI = getNamespaceURI();
            if (str.length() != 0) {
                zEquals = str.equals(namespaceURI);
                if (zEquals) {
                    return;
                }
            } else if (namespaceURI == null) {
                return;
            }
        } else if (zEquals) {
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("expected event ");
        stringBuffer2.append(ElementTypeNames.getEventTypeString(i));
        String string5 = "";
        if (str2 != null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(" with name '");
            stringBuffer3.append(str2);
            stringBuffer3.append("'");
            string = stringBuffer3.toString();
        } else {
            string = "";
        }
        stringBuffer2.append(string);
        stringBuffer2.append((str == null || str2 == null) ? "" : " and");
        if (str != null) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(" with namespace '");
            stringBuffer4.append(str);
            stringBuffer4.append("'");
            string2 = stringBuffer4.toString();
        } else {
            string2 = "";
        }
        stringBuffer2.append(string2);
        stringBuffer2.append(" but got");
        if (i != getEventType()) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append(StringUtils.SPACE);
            stringBuffer5.append(ElementTypeNames.getEventTypeString(getEventType()));
            string3 = stringBuffer5.toString();
        } else {
            string3 = "";
        }
        stringBuffer2.append(string3);
        if (str2 == null || getLocalName() == null || str2.equals(getName())) {
            string4 = "";
        } else {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append(" name '");
            stringBuffer6.append(getLocalName());
            stringBuffer6.append("'");
            string4 = stringBuffer6.toString();
        }
        stringBuffer2.append(string4);
        stringBuffer2.append((str == null || str2 == null || getLocalName() == null || str2.equals(getName()) || getNamespaceURI() == null || str.equals(getNamespaceURI())) ? "" : " and");
        if (str != null && getNamespaceURI() != null && !str.equals(getNamespaceURI())) {
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append(" namespace '");
            stringBuffer7.append(getNamespaceURI());
            stringBuffer7.append("'");
            string5 = stringBuffer7.toString();
        }
        stringBuffer2.append(string5);
        stringBuffer2.append(" (position:");
        stringBuffer2.append(getPositionDescription());
        stringBuffer2.append(")");
        throw new XMLStreamException(stringBuffer2.toString(), getLocation());
    }

    public String nextText() throws XMLStreamException {
        if (getEventType() != 1) {
            throw new XMLStreamException("parser must be on START_ELEMENT to read next text", getLocation());
        }
        int next = next();
        if (next != 4) {
            if (next == 2) {
                return "";
            }
            throw new XMLStreamException("parser must be on START_ELEMENT or TEXT to read text", getLocation());
        }
        String text = getText();
        if (next() == 2) {
            return text;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TEXT must be immediately followed by END_ELEMENT and not ");
        stringBuffer.append(ElementTypeNames.getEventTypeString(getEventType()));
        throw new XMLStreamException(stringBuffer.toString(), getLocation());
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int nextTag() throws XMLStreamException {
        next();
        while (true) {
            int i = this.eventType;
            if (i != 6 && i != 5 && i != 3 && ((i != 4 || !isWhiteSpace()) && (this.eventType != 12 || !isWhiteSpace()))) {
                break;
            }
            next();
        }
        int i2 = this.eventType;
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("expected XMLStreamConstants.START_ELEMENT or XMLStreamConstants.END_ELEMENT not ");
        stringBuffer.append(ElementTypeNames.getEventTypeString(getEventType()));
        throw new XMLStreamException(stringBuffer.toString(), getLocation());
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getElementText() throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        if (getEventType() != 1) {
            throw new XMLStreamException("Precondition for readText is getEventType() == START_ELEMENT");
        }
        while (next() != 8) {
            if (isStartElement()) {
                throw new XMLStreamException("Unexpected Element start");
            }
            if (isCharacters() || getEventType() == 9) {
                stringBuffer.append(getText());
            }
            if (isEndElement()) {
                return stringBuffer.toString();
            }
        }
        throw new XMLStreamException("Unexpected end of Document");
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        this.tokenize = true;
        this.pcStart = 0;
        this.pcEnd = 0;
        this.usePC = false;
        return nextImpl();
    }

    public int nextToken() throws XMLStreamException {
        this.tokenize = true;
        return nextImpl();
    }

    public int nextElement() throws XMLStreamException {
        return nextTag();
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean hasNext() throws XMLStreamException {
        return this.eventType != 8;
    }

    public void skip() throws XMLStreamException {
        nextToken();
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean isStartElement() {
        return this.eventType == 1;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean isEndElement() {
        return this.eventType == 2;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean isCharacters() {
        return this.eventType == 4;
    }

    public boolean isEOF() {
        return this.eventType == 8;
    }

    public boolean moveToStartElement() throws XMLStreamException {
        if (isStartElement()) {
            return true;
        }
        while (hasNext()) {
            if (isStartElement()) {
                return true;
            }
            next();
        }
        return false;
    }

    public boolean moveToStartElement(String str) throws XMLStreamException {
        if (str == null) {
            return false;
        }
        while (moveToStartElement()) {
            if (str.equals(getLocalName())) {
                return true;
            }
            if (!hasNext()) {
                return false;
            }
            next();
        }
        return false;
    }

    public boolean moveToStartElement(String str, String str2) throws XMLStreamException {
        if (str != null && str2 != null) {
            while (moveToStartElement(str)) {
                if (str2.equals(getNamespaceURI())) {
                    return true;
                }
                if (!hasNext()) {
                    return false;
                }
                next();
            }
        }
        return false;
    }

    public boolean moveToEndElement() throws XMLStreamException {
        if (isEndElement()) {
            return true;
        }
        while (hasNext()) {
            if (isEndElement()) {
                return true;
            }
            next();
        }
        return false;
    }

    public boolean moveToEndElement(String str) throws XMLStreamException {
        if (str == null) {
            return false;
        }
        while (moveToEndElement()) {
            if (str.equals(getLocalName())) {
                return true;
            }
            if (!hasNext()) {
                return false;
            }
            next();
        }
        return false;
    }

    public boolean moveToEndElement(String str, String str2) throws XMLStreamException {
        if (str != null && str2 != null) {
            while (moveToEndElement(str)) {
                if (str2.equals(getNamespaceURI())) {
                    return true;
                }
                if (!hasNext()) {
                    return false;
                }
                next();
            }
        }
        return false;
    }

    public boolean hasAttributes() {
        return getAttributeCount() > 0;
    }

    public boolean hasNamespaces() {
        return getNamespaceCount() > 0;
    }

    public Iterator getAttributes() {
        if (!hasAttributes()) {
            return EmptyIterator.emptyIterator;
        }
        int attributeCount = getAttributeCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < attributeCount; i++) {
            arrayList.add(new AttributeBase(getAttributePrefix(i), getAttributeNamespace(i), getAttributeLocalName(i), getAttributeValue(i), getAttributeType(i)));
        }
        return arrayList.iterator();
    }

    public Iterator internalGetNamespaces(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = this.elNamespaceCount[i - 1];
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 + i3;
            String localNamespacePrefix = getLocalNamespacePrefix(i5);
            if (localNamespacePrefix == null) {
                arrayList.add(new NamespaceBase(getLocalNamespaceURI(i5)));
            } else {
                arrayList.add(new NamespaceBase(localNamespacePrefix, getLocalNamespaceURI(i5)));
            }
        }
        return arrayList.iterator();
    }

    public Iterator getNamespaces() {
        if (!hasNamespaces()) {
            return EmptyIterator.emptyIterator;
        }
        return internalGetNamespaces(this.depth, getLocalNamespaceCount());
    }

    public Iterator getOutOfScopeNamespaces() {
        int[] iArr = this.elNamespaceCount;
        int i = this.depth;
        return internalGetNamespaces(i, iArr[i] - iArr[i - 1]);
    }

    public XMLStreamReader subReader() throws XMLStreamException {
        return new SubReader(this);
    }

    public void recycle() throws XMLStreamException {
        reset();
    }

    public Reader getTextStream() {
        throw new UnsupportedOperationException();
    }

    private final void checkTextEvent() {
        if (hasText()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Current state (");
        stringBuffer.append(eventTypeDesc(this.eventType));
        stringBuffer.append(") does not have textual content");
        throw new IllegalStateException(stringBuffer.toString());
    }

    private final void checkTextEventXxx() {
        int i = this.eventType;
        if (i == 4 || i == 12 || i == 5 || i == 6) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("getTextXxx methods cannot be called for ");
        stringBuffer.append(eventTypeDesc(this.eventType));
        throw new IllegalStateException(stringBuffer.toString());
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getText() {
        char[] cArr;
        checkTextEvent();
        if (this.eventType == 9) {
            if (this.text == null && (cArr = this.entityValue) != null) {
                this.text = new String(cArr);
            }
            return this.text;
        }
        if (this.usePC) {
            char[] cArr2 = this.pc;
            int i = this.pcStart;
            this.text = new String(cArr2, i, this.pcEnd - i);
        } else {
            char[] cArr3 = this.buf;
            int i2 = this.posStart;
            this.text = new String(cArr3, i2, this.posEnd - i2);
        }
        return this.text;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int getTextCharacters(int i, char[] cArr, int i2, int i3) throws XMLStreamException {
        checkTextEventXxx();
        int textLength = getTextLength();
        if (i < 0 || i > textLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = textLength - i;
        if (i4 < i3) {
            i3 = i4;
        }
        if (i3 > 0) {
            System.arraycopy(getTextCharacters(), getTextStart() + i, cArr, i2, i3);
        }
        return i3;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public char[] getTextCharacters() {
        checkTextEventXxx();
        if (this.eventType == 4) {
            if (this.usePC) {
                return this.pc;
            }
            return this.buf;
        }
        return this.buf;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int getTextStart() {
        checkTextEventXxx();
        if (this.usePC) {
            return this.pcStart;
        }
        return this.posStart;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public int getTextLength() {
        int i;
        int i2;
        checkTextEventXxx();
        if (this.usePC) {
            i = this.pcEnd;
            i2 = this.pcStart;
        } else {
            i = this.posEnd;
            i2 = this.posStart;
        }
        return i - i2;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean hasText() {
        int i = this.eventType;
        return i == 4 || i == 11 || i == 12 || i == 5 || i == 6 || i == 9;
    }

    public String getValue() {
        return getText();
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getEncoding() {
        return getInputEncoding();
    }

    @Override // javax.xml.stream.Location
    public int getCharacterOffset() {
        return this.posEnd;
    }

    private static final String checkNull(String str) {
        return str != null ? str : "";
    }

    private static String eventTypeDesc(int i) {
        if (i >= 0) {
            String[] strArr = TYPES;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return "[UNKNOWN]";
    }

    @Override // javax.xml.stream.XMLStreamReader
    public QName getAttributeName(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        return new QName(checkNull(getAttributeNamespace(i)), getAttributeLocalName(i), checkNull(getAttributePrefix(i)));
    }

    @Override // javax.xml.stream.XMLStreamReader
    public QName getName() {
        if (!isElementEvent(this.eventType)) {
            throw new IllegalStateException("Current state not START_ELEMENT or END_ELEMENT");
        }
        return new QName(checkNull(getNamespaceURI()), getLocalName(), checkNull(getPrefix()));
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean hasName() {
        return isElementEvent(this.eventType);
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getVersion() {
        return this.xmlVersion;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean isStandalone() {
        return this.standalone;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public boolean standaloneSet() {
        return this.standaloneSet;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getCharacterEncodingScheme() {
        return this.charEncodingScheme;
    }

    protected int nextImpl() throws XMLStreamException {
        char cMore;
        try {
            this.text = null;
            this.bufStart = this.posEnd;
            if (this.pastEndTag) {
                this.pastEndTag = false;
                int i = this.depth - 1;
                this.depth = i;
                this.namespaceEnd = this.elNamespaceCount[i];
            }
            if (this.emptyElementTag) {
                this.emptyElementTag = false;
                this.pastEndTag = true;
                this.eventType = 2;
                return 2;
            }
            if (this.depth > 0) {
                if (this.seenStartTag) {
                    this.seenStartTag = false;
                    int startTag = parseStartTag();
                    this.eventType = startTag;
                    return startTag;
                }
                if (this.seenEndTag) {
                    this.seenEndTag = false;
                    int endTag = parseEndTag();
                    this.eventType = endTag;
                    return endTag;
                }
                if (this.seenMarkup) {
                    this.seenMarkup = false;
                    cMore = '<';
                } else if (this.seenAmpersand) {
                    this.seenAmpersand = false;
                    cMore = '&';
                } else {
                    cMore = more();
                }
                this.posStart = this.pos - 1;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    if (cMore == '<') {
                        if (z && this.tokenize) {
                            this.seenMarkup = true;
                            this.eventType = 4;
                            return 4;
                        }
                        char cMore2 = more();
                        if (cMore2 == '/') {
                            if (!this.tokenize && z) {
                                this.seenEndTag = true;
                                this.eventType = 4;
                                return 4;
                            }
                            int endTag2 = parseEndTag();
                            this.eventType = endTag2;
                            return endTag2;
                        }
                        if (cMore2 == '!') {
                            char cMore3 = more();
                            if (cMore3 == '-') {
                                parseComment();
                                if (this.tokenize) {
                                    this.eventType = 5;
                                    return 5;
                                }
                                if (!this.usePC && z) {
                                    z2 = true;
                                }
                            } else {
                                if (cMore3 != '[') {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("unexpected character in markup ");
                                    stringBuffer.append(printable(cMore3));
                                    throw new XMLStreamException(stringBuffer.toString(), getLocation());
                                }
                                int i2 = this.posStart;
                                int i3 = this.posEnd;
                                parseCDATA();
                                int i4 = this.posStart;
                                int i5 = this.posEnd;
                                this.posStart = i2;
                                this.posEnd = i3;
                                int i6 = i5 - i4;
                                if (i6 > 0) {
                                    if (z) {
                                        if (!this.usePC) {
                                            if (i3 > i2) {
                                                joinPC();
                                            } else {
                                                this.usePC = true;
                                                this.pcEnd = 0;
                                                this.pcStart = 0;
                                            }
                                        }
                                        int i7 = this.pcEnd + i6;
                                        if (i7 >= this.pc.length) {
                                            ensurePC(i7);
                                        }
                                        System.arraycopy(this.buf, i4, this.pc, this.pcEnd, i6);
                                        this.pcEnd += i6;
                                    } else {
                                        this.posStart = i4;
                                        this.posEnd = i5;
                                        z2 = true;
                                    }
                                    z = true;
                                } else if (!this.usePC && z) {
                                    z2 = true;
                                }
                                if (this.reportCdataEvent) {
                                    this.eventType = 12;
                                    return 12;
                                }
                            }
                        } else if (cMore2 == '?') {
                            parsePI();
                            if (this.tokenize) {
                                this.eventType = 3;
                                return 3;
                            }
                            if (!this.usePC && z) {
                                z2 = true;
                            }
                        } else {
                            if (!isNameStartChar(cMore2)) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("unexpected character in markup ");
                                stringBuffer2.append(printable(cMore2));
                                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
                            }
                            if (!this.tokenize && z) {
                                this.seenStartTag = true;
                                this.eventType = 4;
                                return 4;
                            }
                            int startTag2 = parseStartTag();
                            this.eventType = startTag2;
                            return startTag2;
                        }
                    } else if (cMore == '&') {
                        if (this.tokenize && z) {
                            this.seenAmpersand = true;
                            this.eventType = 4;
                            return 4;
                        }
                        int i8 = this.posStart;
                        int i9 = this.posEnd;
                        boolean zIsReplacingEntities = getConfigurationContext().isReplacingEntities();
                        char[] entityRef = parseEntityRef(zIsReplacingEntities);
                        if (!zIsReplacingEntities) {
                            this.eventType = 9;
                            return 9;
                        }
                        this.eventType = 4;
                        if (entityRef == null) {
                            if (this.entityRefName == null) {
                                char[] cArr = this.buf;
                                int i10 = this.posStart;
                                this.entityRefName = newString(cArr, i10, this.posEnd - i10);
                            }
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("could not resolve entity named '");
                            stringBuffer3.append(printable(this.entityRefName));
                            stringBuffer3.append("'");
                            throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                        }
                        this.posStart = i8;
                        this.posEnd = i9;
                        if (!this.usePC) {
                            if (z) {
                                joinPC();
                                z2 = false;
                            } else {
                                this.usePC = true;
                                this.pcEnd = 0;
                                this.pcStart = 0;
                            }
                        }
                        for (char c : entityRef) {
                            int i11 = this.pcEnd;
                            if (i11 >= this.pc.length) {
                                ensurePC(i11);
                            }
                            char[] cArr2 = this.pc;
                            int i12 = this.pcEnd;
                            this.pcEnd = i12 + 1;
                            cArr2[i12] = c;
                        }
                        z = true;
                    } else {
                        if (z2) {
                            joinPC();
                            z2 = false;
                        }
                        boolean z3 = false;
                        do {
                            if (cMore == '\r') {
                                int i13 = this.pos - 1;
                                this.posEnd = i13;
                                if (!this.usePC) {
                                    if (i13 > this.posStart) {
                                        joinPC();
                                    } else {
                                        this.usePC = true;
                                        this.pcEnd = 0;
                                        this.pcStart = 0;
                                    }
                                }
                                int i14 = this.pcEnd;
                                if (i14 >= this.pc.length) {
                                    ensurePC(i14);
                                }
                                char[] cArr3 = this.pc;
                                int i15 = this.pcEnd;
                                this.pcEnd = i15 + 1;
                                cArr3[i15] = '\n';
                                z3 = true;
                            } else {
                                if (cMore == '\n') {
                                    if (!z3 && this.usePC) {
                                        int i16 = this.pcEnd;
                                        if (i16 >= this.pc.length) {
                                            ensurePC(i16);
                                        }
                                        char[] cArr4 = this.pc;
                                        int i17 = this.pcEnd;
                                        this.pcEnd = i17 + 1;
                                        cArr4[i17] = '\n';
                                    }
                                } else if (this.usePC) {
                                    int i18 = this.pcEnd;
                                    if (i18 >= this.pc.length) {
                                        ensurePC(i18);
                                    }
                                    char[] cArr5 = this.pc;
                                    int i19 = this.pcEnd;
                                    this.pcEnd = i19 + 1;
                                    cArr5[i19] = cMore;
                                }
                                z3 = false;
                            }
                            cMore = more();
                            if (cMore == '<') {
                                break;
                            }
                        } while (cMore != '&');
                        this.posEnd = this.pos - 1;
                        z = true;
                    }
                    cMore = more();
                }
            } else {
                if (this.seenRoot) {
                    return parseEpilog();
                }
                return parseProlog();
            }
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected int parseProlog() throws XMLStreamException {
        char cMore;
        try {
            if (this.seenMarkup) {
                cMore = this.buf[this.pos - 1];
            } else {
                cMore = more();
            }
            if (this.eventType == 7) {
                if (cMore == 65534) {
                    throw new XMLStreamException("first character in input was UNICODE noncharacter (0xFFFE)- input requires int swapping", getLocation());
                }
                if (cMore == 65279) {
                    cMore = more();
                }
            }
            boolean z = false;
            this.seenMarkup = false;
            this.posStart = this.pos - 1;
            while (true) {
                if (cMore == '<') {
                    if (z && this.tokenize) {
                        this.posEnd = this.pos - 1;
                        this.seenMarkup = true;
                        this.eventType = 6;
                        return 6;
                    }
                    char cMore2 = more();
                    if (cMore2 == '?') {
                        boolean pi = parsePI();
                        if (this.tokenize) {
                            if (pi) {
                                this.eventType = 7;
                                return 7;
                            }
                            this.eventType = 3;
                            return 3;
                        }
                    } else {
                        if (cMore2 != '!') {
                            if (cMore2 == '/') {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("expected start tag name and not ");
                                stringBuffer.append(printable(cMore2));
                                throw new XMLStreamException(stringBuffer.toString(), getLocation());
                            }
                            if (!isNameStartChar(cMore2)) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("expected start tag name and not ");
                                stringBuffer2.append(printable(cMore2));
                                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
                            }
                            this.seenRoot = true;
                            return parseStartTag();
                        }
                        char cMore3 = more();
                        if (cMore3 == 'D') {
                            if (this.seenDocdecl) {
                                throw new XMLStreamException("only one docdecl allowed in XML document", getLocation());
                            }
                            this.seenDocdecl = true;
                            parseDocdecl();
                            if (this.tokenize) {
                                this.eventType = 11;
                                return 11;
                            }
                        } else if (cMore3 == '-') {
                            parseComment();
                            if (this.tokenize) {
                                this.eventType = 5;
                                return 5;
                            }
                        } else {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("unexpected markup <!");
                            stringBuffer3.append(printable(cMore3));
                            throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                        }
                    }
                } else {
                    if (!isS(cMore)) {
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append("only whitespace content allowed before start tag and not ");
                        stringBuffer4.append(printable(cMore));
                        throw new XMLStreamException(stringBuffer4.toString(), getLocation());
                    }
                    z = true;
                }
                cMore = more();
            }
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected int parseEpilog() throws XMLStreamException {
        char cMore;
        if (this.eventType == 8) {
            throw new XMLStreamException("already reached end document", getLocation());
        }
        if (this.reachedEnd) {
            this.eventType = 8;
            return 8;
        }
        boolean z = false;
        try {
            if (this.seenMarkup) {
                cMore = this.buf[this.pos - 1];
            } else {
                cMore = more();
            }
            this.seenMarkup = false;
            this.posStart = this.pos - 1;
            while (true) {
                if (cMore == '<') {
                    if (z && this.tokenize) {
                        this.posEnd = this.pos - 1;
                        this.seenMarkup = true;
                        this.eventType = 6;
                        return 6;
                    }
                    char cMore2 = more();
                    if (cMore2 == '?') {
                        parsePI();
                        if (this.tokenize) {
                            this.eventType = 3;
                            return 3;
                        }
                    } else {
                        if (cMore2 != '!') {
                            if (cMore2 == '/') {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("end tag not allowed in epilog but got ");
                                stringBuffer.append(printable(cMore2));
                                throw new XMLStreamException(stringBuffer.toString(), getLocation());
                            }
                            if (isNameStartChar(cMore2)) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("start tag not allowed in epilog but got ");
                                stringBuffer2.append(printable(cMore2));
                                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
                            }
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("in epilog expected ignorable content and not ");
                            stringBuffer3.append(printable(cMore2));
                            throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                        }
                        char cMore3 = more();
                        if (cMore3 == 'D') {
                            parseDocdecl();
                            if (this.tokenize) {
                                this.eventType = 11;
                                return 11;
                            }
                        } else if (cMore3 == '-') {
                            parseComment();
                            if (this.tokenize) {
                                this.eventType = 5;
                                return 5;
                            }
                        } else {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append("unexpected markup <!");
                            stringBuffer4.append(printable(cMore3));
                            throw new XMLStreamException(stringBuffer4.toString(), getLocation());
                        }
                    }
                } else {
                    if (!isS(cMore)) {
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("in epilog non whitespace content is not allowed but got ");
                        stringBuffer5.append(printable(cMore));
                        throw new XMLStreamException(stringBuffer5.toString(), getLocation());
                    }
                    z = true;
                }
                cMore = more();
            }
        } catch (EOFException unused) {
            this.reachedEnd = true;
            if (this.tokenize && 0 != 0) {
                this.posEnd = this.pos;
                this.eventType = 6;
                return 6;
            }
            this.eventType = 8;
            return 8;
        }
    }

    public int parseEndTag() throws XMLStreamException {
        char cMore;
        this.eventType = 2;
        try {
            char cMore2 = more();
            if (!isNameStartChar(cMore2)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("expected name start and not ");
                stringBuffer.append(printable(cMore2));
                throw new XMLStreamException(stringBuffer.toString(), getLocation());
            }
            int i = this.pos;
            this.posStart = i - 3;
            int i2 = this.bufAbsoluteStart;
            do {
                cMore = more();
            } while (isNameChar(cMore));
            int i3 = this.pos;
            int i4 = ((i - 1) + i2) - this.bufAbsoluteStart;
            int i5 = (i3 - 1) - i4;
            char[][] cArr = this.elRawName;
            int i6 = this.depth;
            char[] cArr2 = cArr[i6];
            int i7 = this.elRawNameEnd[i6];
            if (i7 != i5) {
                String str = new String(cArr2, 0, i7);
                String str2 = new String(this.buf, i4, i5);
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("end tag name '");
                stringBuffer2.append(str2);
                stringBuffer2.append("' must match start tag name '");
                stringBuffer2.append(str);
                stringBuffer2.append("'");
                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
            }
            int i8 = 0;
            while (i8 < i5) {
                int i9 = i4 + 1;
                if (this.buf[i4] != cArr2[i8]) {
                    String str3 = new String(cArr2, 0, i5);
                    String str4 = new String(this.buf, (i9 - i8) - 1, i5);
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("end tag name '");
                    stringBuffer3.append(str4);
                    stringBuffer3.append("' must be the same as start tag '");
                    stringBuffer3.append(str3);
                    stringBuffer3.append("'");
                    throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                }
                i8++;
                i4 = i9;
            }
            while (isS(cMore)) {
                cMore = more();
            }
            if (cMore != '>') {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("expected > to finsh end tag not ");
                stringBuffer4.append(printable(cMore));
                throw new XMLStreamException(stringBuffer4.toString(), getLocation());
            }
            this.posEnd = this.pos;
            this.pastEndTag = true;
            return 2;
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:161:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x023b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x023b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0188 A[Catch: EOFException -> 0x02e7, TryCatch #0 {EOFException -> 0x02e7, blocks: (B:3:0x0003, B:5:0x0021, B:8:0x0026, B:9:0x0031, B:11:0x0034, B:13:0x003e, B:15:0x0051, B:18:0x005a, B:21:0x006e, B:24:0x00b5, B:26:0x00bb, B:35:0x00d6, B:38:0x00e0, B:41:0x00e8, B:42:0x00eb, B:43:0x0105, B:44:0x0106, B:45:0x010d, B:47:0x0111, B:49:0x0117, B:51:0x011d, B:55:0x0143, B:52:0x0122, B:53:0x013c, B:54:0x013d, B:57:0x0147, B:61:0x014e, B:63:0x0156, B:65:0x015a, B:73:0x017e, B:75:0x0188, B:76:0x019e, B:78:0x01a8, B:79:0x01be, B:80:0x01dc, B:67:0x0166, B:69:0x016a, B:71:0x0172, B:81:0x01dd, B:82:0x01e1, B:103:0x0241, B:106:0x0253, B:107:0x0269, B:84:0x01e6, B:88:0x01ed, B:90:0x01f1, B:99:0x0216, B:100:0x023a, B:92:0x01fd, B:94:0x0201, B:96:0x0209, B:101:0x023b, B:102:0x023e, B:33:0x00ce, B:109:0x026d, B:110:0x028b, B:111:0x028c, B:116:0x0297, B:117:0x02a2, B:118:0x02a3, B:119:0x02ac, B:120:0x02ca, B:22:0x0096, B:23:0x00a8, B:17:0x0054, B:122:0x02cd, B:125:0x02d3, B:126:0x02db, B:127:0x02e6), top: B:131:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01a8 A[Catch: EOFException -> 0x02e7, TryCatch #0 {EOFException -> 0x02e7, blocks: (B:3:0x0003, B:5:0x0021, B:8:0x0026, B:9:0x0031, B:11:0x0034, B:13:0x003e, B:15:0x0051, B:18:0x005a, B:21:0x006e, B:24:0x00b5, B:26:0x00bb, B:35:0x00d6, B:38:0x00e0, B:41:0x00e8, B:42:0x00eb, B:43:0x0105, B:44:0x0106, B:45:0x010d, B:47:0x0111, B:49:0x0117, B:51:0x011d, B:55:0x0143, B:52:0x0122, B:53:0x013c, B:54:0x013d, B:57:0x0147, B:61:0x014e, B:63:0x0156, B:65:0x015a, B:73:0x017e, B:75:0x0188, B:76:0x019e, B:78:0x01a8, B:79:0x01be, B:80:0x01dc, B:67:0x0166, B:69:0x016a, B:71:0x0172, B:81:0x01dd, B:82:0x01e1, B:103:0x0241, B:106:0x0253, B:107:0x0269, B:84:0x01e6, B:88:0x01ed, B:90:0x01f1, B:99:0x0216, B:100:0x023a, B:92:0x01fd, B:94:0x0201, B:96:0x0209, B:101:0x023b, B:102:0x023e, B:33:0x00ce, B:109:0x026d, B:110:0x028b, B:111:0x028c, B:116:0x0297, B:117:0x02a2, B:118:0x02a3, B:119:0x02ac, B:120:0x02ca, B:22:0x0096, B:23:0x00a8, B:17:0x0054, B:122:0x02cd, B:125:0x02d3, B:126:0x02db, B:127:0x02e6), top: B:131:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01fd A[Catch: EOFException -> 0x02e7, TryCatch #0 {EOFException -> 0x02e7, blocks: (B:3:0x0003, B:5:0x0021, B:8:0x0026, B:9:0x0031, B:11:0x0034, B:13:0x003e, B:15:0x0051, B:18:0x005a, B:21:0x006e, B:24:0x00b5, B:26:0x00bb, B:35:0x00d6, B:38:0x00e0, B:41:0x00e8, B:42:0x00eb, B:43:0x0105, B:44:0x0106, B:45:0x010d, B:47:0x0111, B:49:0x0117, B:51:0x011d, B:55:0x0143, B:52:0x0122, B:53:0x013c, B:54:0x013d, B:57:0x0147, B:61:0x014e, B:63:0x0156, B:65:0x015a, B:73:0x017e, B:75:0x0188, B:76:0x019e, B:78:0x01a8, B:79:0x01be, B:80:0x01dc, B:67:0x0166, B:69:0x016a, B:71:0x0172, B:81:0x01dd, B:82:0x01e1, B:103:0x0241, B:106:0x0253, B:107:0x0269, B:84:0x01e6, B:88:0x01ed, B:90:0x01f1, B:99:0x0216, B:100:0x023a, B:92:0x01fd, B:94:0x0201, B:96:0x0209, B:101:0x023b, B:102:0x023e, B:33:0x00ce, B:109:0x026d, B:110:0x028b, B:111:0x028c, B:116:0x0297, B:117:0x02a2, B:118:0x02a3, B:119:0x02ac, B:120:0x02ca, B:22:0x0096, B:23:0x00a8, B:17:0x0054, B:122:0x02cd, B:125:0x02d3, B:126:0x02db, B:127:0x02e6), top: B:131:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0201 A[Catch: EOFException -> 0x02e7, TryCatch #0 {EOFException -> 0x02e7, blocks: (B:3:0x0003, B:5:0x0021, B:8:0x0026, B:9:0x0031, B:11:0x0034, B:13:0x003e, B:15:0x0051, B:18:0x005a, B:21:0x006e, B:24:0x00b5, B:26:0x00bb, B:35:0x00d6, B:38:0x00e0, B:41:0x00e8, B:42:0x00eb, B:43:0x0105, B:44:0x0106, B:45:0x010d, B:47:0x0111, B:49:0x0117, B:51:0x011d, B:55:0x0143, B:52:0x0122, B:53:0x013c, B:54:0x013d, B:57:0x0147, B:61:0x014e, B:63:0x0156, B:65:0x015a, B:73:0x017e, B:75:0x0188, B:76:0x019e, B:78:0x01a8, B:79:0x01be, B:80:0x01dc, B:67:0x0166, B:69:0x016a, B:71:0x0172, B:81:0x01dd, B:82:0x01e1, B:103:0x0241, B:106:0x0253, B:107:0x0269, B:84:0x01e6, B:88:0x01ed, B:90:0x01f1, B:99:0x0216, B:100:0x023a, B:92:0x01fd, B:94:0x0201, B:96:0x0209, B:101:0x023b, B:102:0x023e, B:33:0x00ce, B:109:0x026d, B:110:0x028b, B:111:0x028c, B:116:0x0297, B:117:0x02a2, B:118:0x02a3, B:119:0x02ac, B:120:0x02ca, B:22:0x0096, B:23:0x00a8, B:17:0x0054, B:122:0x02cd, B:125:0x02d3, B:126:0x02db, B:127:0x02e6), top: B:131:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0209 A[Catch: EOFException -> 0x02e7, TryCatch #0 {EOFException -> 0x02e7, blocks: (B:3:0x0003, B:5:0x0021, B:8:0x0026, B:9:0x0031, B:11:0x0034, B:13:0x003e, B:15:0x0051, B:18:0x005a, B:21:0x006e, B:24:0x00b5, B:26:0x00bb, B:35:0x00d6, B:38:0x00e0, B:41:0x00e8, B:42:0x00eb, B:43:0x0105, B:44:0x0106, B:45:0x010d, B:47:0x0111, B:49:0x0117, B:51:0x011d, B:55:0x0143, B:52:0x0122, B:53:0x013c, B:54:0x013d, B:57:0x0147, B:61:0x014e, B:63:0x0156, B:65:0x015a, B:73:0x017e, B:75:0x0188, B:76:0x019e, B:78:0x01a8, B:79:0x01be, B:80:0x01dc, B:67:0x0166, B:69:0x016a, B:71:0x0172, B:81:0x01dd, B:82:0x01e1, B:103:0x0241, B:106:0x0253, B:107:0x0269, B:84:0x01e6, B:88:0x01ed, B:90:0x01f1, B:99:0x0216, B:100:0x023a, B:92:0x01fd, B:94:0x0201, B:96:0x0209, B:101:0x023b, B:102:0x023e, B:33:0x00ce, B:109:0x026d, B:110:0x028b, B:111:0x028c, B:116:0x0297, B:117:0x02a2, B:118:0x02a3, B:119:0x02ac, B:120:0x02ca, B:22:0x0096, B:23:0x00a8, B:17:0x0054, B:122:0x02cd, B:125:0x02d3, B:126:0x02db, B:127:0x02e6), top: B:131:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0215  */
    public int parseStartTag() throws XMLStreamException {
        String strNewString;
        int[] iArr;
        Object[] objArr;
        String string;
        String string2;
        this.eventType = 1;
        try {
            this.depth++;
            int i = this.pos;
            this.posStart = i - 2;
            this.emptyElementTag = false;
            this.attributeCount = 0;
            this.localNamespaceEnd = 0;
            int i2 = i - 1;
            int i3 = this.bufAbsoluteStart + i2;
            if (this.buf[i2] == ':' && this.processNamespaces) {
                throw new XMLStreamException("when namespaces processing enabled colon can not be at element name start", getLocation());
            }
            int i4 = -1;
            while (true) {
                char cMore = more();
                if (isNameChar(cMore)) {
                    if (cMore == ':' && this.processNamespaces) {
                        if (i4 != -1) {
                            throw new XMLStreamException("only one colon is allowed in name of element when namespaces are enabled", getLocation());
                        }
                        i4 = (this.pos - 1) + this.bufAbsoluteStart;
                    }
                } else {
                    ensureElementsCapacity();
                    int i5 = this.pos;
                    int i6 = i3 - this.bufAbsoluteStart;
                    int i7 = (i5 - 1) - i6;
                    char[][] cArr = this.elRawName;
                    int i8 = this.depth;
                    char[] cArr2 = cArr[i8];
                    if (cArr2 == null || cArr2.length < i7) {
                        cArr[i8] = new char[i7 * 2];
                    }
                    System.arraycopy(this.buf, i6, cArr[i8], 0, i7);
                    int[] iArr2 = this.elRawNameEnd;
                    int i9 = this.depth;
                    iArr2[i9] = i7;
                    String strNewString2 = null;
                    if (!this.processNamespaces) {
                        String[] strArr = this.elName;
                        strNewString = newString(this.buf, i3 - this.bufAbsoluteStart, i7);
                        strArr[i9] = strNewString;
                    } else if (i4 != -1) {
                        String[] strArr2 = this.elPrefix;
                        strNewString2 = newString(this.buf, i3 - this.bufAbsoluteStart, i4 - i3);
                        strArr2[i9] = strNewString2;
                        String[] strArr3 = this.elName;
                        int i10 = this.depth;
                        char[] cArr3 = this.buf;
                        int i11 = this.bufAbsoluteStart;
                        strNewString = newString(cArr3, (i4 + 1) - i11, (this.pos - 2) - (i4 - i11));
                        strArr3[i10] = strNewString;
                    } else {
                        this.elPrefix[i9] = null;
                        String[] strArr4 = this.elName;
                        strNewString = newString(this.buf, i3 - this.bufAbsoluteStart, i7);
                        strArr4[i9] = strNewString;
                    }
                    while (true) {
                        boolean zIsS = isS(cMore);
                        if (zIsS) {
                            do {
                                cMore = more();
                            } while (isS(cMore));
                        }
                        if (cMore == '>') {
                            break;
                        }
                        if (cMore == '/') {
                            this.emptyElementTag = true;
                            char cMore2 = more();
                            if (cMore2 == '>') {
                                break;
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("expected > to end empty tag not ");
                            stringBuffer.append(printable(cMore2));
                            throw new XMLStreamException(stringBuffer.toString(), getLocation());
                        }
                        if (isNameStartChar(cMore)) {
                            if (!zIsS && cMore != '>') {
                                throw new XMLStreamException("expected a white space between attributes", getLocation());
                            }
                            parseAttribute();
                            cMore = more();
                        } else {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("start tag unexpected character ");
                            stringBuffer2.append(printable(cMore));
                            throw new XMLStreamException(stringBuffer2.toString(), getLocation());
                        }
                    }
                    if (this.processNamespaces) {
                        String namespaceURI = getNamespaceURI(strNewString2);
                        if (namespaceURI == null) {
                            if (strNewString2 == null) {
                                namespaceURI = NO_NAMESPACE;
                            } else {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("could not determine namespace bound to element prefix ");
                                stringBuffer3.append(strNewString2);
                                throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                            }
                        }
                        this.elUri[this.depth] = namespaceURI;
                        for (int i12 = 0; i12 < this.attributeCount; i12++) {
                            String str = this.attributePrefix[i12];
                            if (str != null) {
                                String namespaceURI2 = getNamespaceURI(str);
                                if (namespaceURI2 == null) {
                                    StringBuffer stringBuffer4 = new StringBuffer();
                                    stringBuffer4.append("could not determine namespace bound to attribute prefix ");
                                    stringBuffer4.append(str);
                                    throw new XMLStreamException(stringBuffer4.toString(), getLocation());
                                }
                                this.attributeUri[i12] = namespaceURI2;
                            } else {
                                this.attributeUri[i12] = NO_NAMESPACE;
                            }
                        }
                        int i13 = 1;
                        while (true) {
                            if (i13 < this.attributeCount) {
                                int i14 = 0;
                                while (true) {
                                    if (i14 < i13) {
                                        String[] strArr5 = this.attributeUri;
                                        if (strArr5[i14] == strArr5[i13]) {
                                            if (this.allStringsInterned) {
                                                Object[] objArr2 = this.attributeName;
                                                if (!objArr2[i14].equals(objArr2[i13])) {
                                                }
                                                string = this.attributeName[i14];
                                                if (this.attributeUri[i14] != null) {
                                                    StringBuffer stringBuffer5 = new StringBuffer();
                                                    stringBuffer5.append(this.attributeUri[i14]);
                                                    stringBuffer5.append(":");
                                                    stringBuffer5.append(string);
                                                    string = stringBuffer5.toString();
                                                }
                                                string2 = this.attributeName[i13];
                                                if (this.attributeUri[i13] != null) {
                                                    StringBuffer stringBuffer6 = new StringBuffer();
                                                    stringBuffer6.append(this.attributeUri[i13]);
                                                    stringBuffer6.append(":");
                                                    stringBuffer6.append(string2);
                                                    string2 = stringBuffer6.toString();
                                                }
                                                StringBuffer stringBuffer7 = new StringBuffer();
                                                stringBuffer7.append("duplicated attributes ");
                                                stringBuffer7.append(string);
                                                stringBuffer7.append(" and ");
                                                stringBuffer7.append(string2);
                                                throw new XMLStreamException(stringBuffer7.toString(), getLocation());
                                            }
                                            if (this.allStringsInterned) {
                                                continue;
                                            } else {
                                                int[] iArr3 = this.attributeNameHash;
                                                if (iArr3[i14] == iArr3[i13]) {
                                                    Object[] objArr3 = this.attributeName;
                                                    if (objArr3[i14].equals(objArr3[i13])) {
                                                        string = this.attributeName[i14];
                                                        if (this.attributeUri[i14] != null) {
                                                            StringBuffer stringBuffer8 = new StringBuffer();
                                                            stringBuffer8.append(this.attributeUri[i14]);
                                                            stringBuffer8.append(":");
                                                            stringBuffer8.append(string);
                                                            string = stringBuffer8.toString();
                                                        }
                                                        string2 = this.attributeName[i13];
                                                        if (this.attributeUri[i13] != null) {
                                                            StringBuffer stringBuffer9 = new StringBuffer();
                                                            stringBuffer9.append(this.attributeUri[i13]);
                                                            stringBuffer9.append(":");
                                                            stringBuffer9.append(string2);
                                                            string2 = stringBuffer9.toString();
                                                        }
                                                        StringBuffer stringBuffer10 = new StringBuffer();
                                                        stringBuffer10.append("duplicated attributes ");
                                                        stringBuffer10.append(string);
                                                        stringBuffer10.append(" and ");
                                                        stringBuffer10.append(string2);
                                                        throw new XMLStreamException(stringBuffer10.toString(), getLocation());
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            }
                                        }
                                        i14++;
                                    } else {
                                        i13++;
                                    }
                                }
                            }
                        }
                    } else {
                        for (int i15 = 1; i15 < this.attributeCount; i15++) {
                            for (int i16 = 0; i16 < i15; i16++) {
                                if (this.allStringsInterned) {
                                    Object[] objArr4 = this.attributeName;
                                    if (!objArr4[i16].equals(objArr4[i15])) {
                                        if (!this.allStringsInterned) {
                                            iArr = this.attributeNameHash;
                                            if (iArr[i16] == iArr[i15]) {
                                                objArr = this.attributeName;
                                                if (!objArr[i16].equals(objArr[i15])) {
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                } else {
                                    if (!this.allStringsInterned) {
                                        iArr = this.attributeNameHash;
                                        if (iArr[i16] == iArr[i15]) {
                                            objArr = this.attributeName;
                                            if (!objArr[i16].equals(objArr[i15])) {
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                                String[] strArr6 = this.attributeName;
                                String str2 = strArr6[i16];
                                String str3 = strArr6[i15];
                                StringBuffer stringBuffer11 = new StringBuffer();
                                stringBuffer11.append("duplicated attributes ");
                                stringBuffer11.append(str2);
                                stringBuffer11.append(" and ");
                                stringBuffer11.append(str3);
                                throw new XMLStreamException(stringBuffer11.toString(), getLocation());
                            }
                        }
                    }
                    this.elNamespaceCount[this.depth] = this.namespaceEnd;
                    this.posEnd = this.pos;
                    if (this.defaultAttributes != null) {
                        if (strNewString2 != null) {
                            StringBuffer stringBuffer12 = new StringBuffer();
                            stringBuffer12.append(strNewString2);
                            stringBuffer12.append(":");
                            stringBuffer12.append(strNewString);
                            addDefaultAttributes(stringBuffer12.toString());
                        } else {
                            addDefaultAttributes(strNewString);
                        }
                    }
                    return 1;
                }
            }
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected void addDefaultAttributes(String str) throws XMLStreamException {
        HashMap map = this.defaultAttributes;
        if (map == null) {
            return;
        }
        DTDAttlist dTDAttlist = (DTDAttlist) map.get(str);
        if (str == null || dTDAttlist == null) {
            return;
        }
        for (DTDAttribute dTDAttribute : dTDAttlist.getAttribute()) {
            if (dTDAttribute.getDefaultValue() != null) {
                int i = this.attributeCount;
                int i2 = 0;
                while (true) {
                    if (i2 < i) {
                        if (this.attributeName[i2].equals(dTDAttribute.getName())) {
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        int i3 = this.attributeCount + 1;
                        this.attributeCount = i3;
                        ensureAttributesCapacity(i3);
                        String[] strArr = this.attributePrefix;
                        int i4 = this.attributeCount - 1;
                        strArr[i4] = null;
                        this.attributeUri[i4] = NO_NAMESPACE;
                        this.attributeName[i4] = dTDAttribute.getName();
                        this.attributeValue[this.attributeCount - 1] = dTDAttribute.getDefaultValue();
                        break;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0251 A[Catch: EOFException -> 0x03ee, TryCatch #0 {EOFException -> 0x03ee, blocks: (B:3:0x0004, B:5:0x0016, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:16:0x0032, B:17:0x0039, B:19:0x0041, B:24:0x004a, B:45:0x006f, B:46:0x007a, B:49:0x007f, B:50:0x0086, B:51:0x0091, B:52:0x0092, B:53:0x0097, B:59:0x00a8, B:74:0x0143, B:76:0x0149, B:79:0x0152, B:80:0x0156, B:82:0x015c, B:88:0x016a, B:89:0x0188, B:90:0x0189, B:91:0x0195, B:94:0x019d, B:97:0x01a3, B:99:0x01a7, B:101:0x01bf, B:104:0x01cc, B:113:0x01e7, B:115:0x01ed, B:117:0x01f3, B:120:0x01fa, B:121:0x0205, B:122:0x0206, B:124:0x0210, B:134:0x0240, B:136:0x0251, B:143:0x0261, B:145:0x0267, B:152:0x028c, B:153:0x02ab, B:151:0x027a, B:139:0x0257, B:154:0x02ac, B:162:0x02e9, B:125:0x021a, B:126:0x0225, B:127:0x0226, B:129:0x0232, B:130:0x0234, B:132:0x0238, B:107:0x01d4, B:108:0x01db, B:109:0x01dc, B:155:0x02b2, B:156:0x02b9, B:100:0x01b4, B:157:0x02ba, B:159:0x02be, B:161:0x02e4, B:160:0x02d2, B:168:0x02fb, B:170:0x0304, B:172:0x0308, B:173:0x030c, B:174:0x0313, B:176:0x0321, B:178:0x0325, B:179:0x0332, B:180:0x0355, B:182:0x0357, B:184:0x035a, B:186:0x0361, B:187:0x0364, B:193:0x0380, B:195:0x0384, B:197:0x038b, B:198:0x038e, B:200:0x039a, B:202:0x039e, B:204:0x03a7, B:205:0x03ab, B:207:0x03b4, B:209:0x03bb, B:212:0x03c2, B:217:0x03d6, B:218:0x03e1, B:219:0x03e2, B:220:0x03ed, B:62:0x00c2, B:63:0x00cd, B:66:0x00d2, B:68:0x0113, B:70:0x0117, B:67:0x00fc, B:71:0x0122, B:73:0x0139), top: B:224:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0277  */
    /* JADX WARN: Code duplicated, block: B:151:0x027a A[Catch: EOFException -> 0x03ee, TRY_ENTER, TryCatch #0 {EOFException -> 0x03ee, blocks: (B:3:0x0004, B:5:0x0016, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:16:0x0032, B:17:0x0039, B:19:0x0041, B:24:0x004a, B:45:0x006f, B:46:0x007a, B:49:0x007f, B:50:0x0086, B:51:0x0091, B:52:0x0092, B:53:0x0097, B:59:0x00a8, B:74:0x0143, B:76:0x0149, B:79:0x0152, B:80:0x0156, B:82:0x015c, B:88:0x016a, B:89:0x0188, B:90:0x0189, B:91:0x0195, B:94:0x019d, B:97:0x01a3, B:99:0x01a7, B:101:0x01bf, B:104:0x01cc, B:113:0x01e7, B:115:0x01ed, B:117:0x01f3, B:120:0x01fa, B:121:0x0205, B:122:0x0206, B:124:0x0210, B:134:0x0240, B:136:0x0251, B:143:0x0261, B:145:0x0267, B:152:0x028c, B:153:0x02ab, B:151:0x027a, B:139:0x0257, B:154:0x02ac, B:162:0x02e9, B:125:0x021a, B:126:0x0225, B:127:0x0226, B:129:0x0232, B:130:0x0234, B:132:0x0238, B:107:0x01d4, B:108:0x01db, B:109:0x01dc, B:155:0x02b2, B:156:0x02b9, B:100:0x01b4, B:157:0x02ba, B:159:0x02be, B:161:0x02e4, B:160:0x02d2, B:168:0x02fb, B:170:0x0304, B:172:0x0308, B:173:0x030c, B:174:0x0313, B:176:0x0321, B:178:0x0325, B:179:0x0332, B:180:0x0355, B:182:0x0357, B:184:0x035a, B:186:0x0361, B:187:0x0364, B:193:0x0380, B:195:0x0384, B:197:0x038b, B:198:0x038e, B:200:0x039a, B:202:0x039e, B:204:0x03a7, B:205:0x03ab, B:207:0x03b4, B:209:0x03bb, B:212:0x03c2, B:217:0x03d6, B:218:0x03e1, B:219:0x03e2, B:220:0x03ed, B:62:0x00c2, B:63:0x00cd, B:66:0x00d2, B:68:0x0113, B:70:0x0117, B:67:0x00fc, B:71:0x0122, B:73:0x0139), top: B:224:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:215:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:242:0x02ac A[SYNTHETIC] */
    protected char parseAttribute() throws XMLStreamException {
        String strNewString;
        String strNewStringIntern;
        int i;
        int i2;
        int i3;
        boolean z;
        String string;
        boolean z2;
        try {
            int i4 = this.posStart;
            int i5 = this.bufAbsoluteStart;
            int i6 = this.pos - 1;
            int i7 = i6 + i5;
            char c = this.buf[i6];
            if (c == ':' && this.processNamespaces) {
                throw new XMLStreamException("when namespaces processing enabled colon can not be at attribute name start", getLocation());
            }
            boolean z3 = this.processNamespaces && c == 'x';
            char cMore = more();
            int i8 = -1;
            int i9 = 0;
            while (isNameChar(cMore)) {
                if (this.processNamespaces) {
                    if (z3 && i9 < 5) {
                        i9++;
                        if (i9 == 1) {
                            if (cMore != 'm') {
                                z3 = false;
                            }
                        } else if (i9 == 2) {
                            if (cMore != 'l') {
                                z3 = false;
                            }
                        } else if (i9 == 3) {
                            if (cMore != 'n') {
                                z3 = false;
                            }
                        } else if (i9 == 4) {
                            if (cMore != 's') {
                                z3 = false;
                            }
                        } else if (i9 == 5 && cMore != ':') {
                            throw new XMLStreamException("after xmlns in attribute name must be colonwhen namespaces are enabled", getLocation());
                        }
                    }
                    if (cMore != ':') {
                        continue;
                    } else {
                        if (i8 != -1) {
                            throw new XMLStreamException("only one colon is allowed in attribute name when namespaces are enabled", getLocation());
                        }
                        i8 = this.bufAbsoluteStart + (this.pos - 1);
                    }
                }
                cMore = more();
            }
            ensureAttributesCapacity(this.attributeCount);
            String str = null;
            if (this.processNamespaces) {
                if (i9 < 4) {
                    z3 = false;
                }
                if (!z3) {
                    if (i8 != -1) {
                        this.attributePrefix[this.attributeCount] = newString(this.buf, i7 - this.bufAbsoluteStart, i8 - i7);
                        String[] strArr = this.attributeName;
                        int i10 = this.attributeCount;
                        char[] cArr = this.buf;
                        int i11 = i8 - this.bufAbsoluteStart;
                        String strNewString2 = newString(cArr, i11 + 1, (this.pos - 2) - i11);
                        strArr[i10] = strNewString2;
                        strNewString = strNewString2;
                    } else {
                        String[] strArr2 = this.attributePrefix;
                        int i12 = this.attributeCount;
                        strArr2[i12] = null;
                        String[] strArr3 = this.attributeName;
                        char[] cArr2 = this.buf;
                        int i13 = i7 - this.bufAbsoluteStart;
                        strNewString = newString(cArr2, i13, (this.pos - 1) - i13);
                        strArr3[i12] = strNewString;
                    }
                    if (!this.allStringsInterned) {
                        this.attributeNameHash[this.attributeCount] = strNewString.hashCode();
                    }
                } else if (i8 != -1) {
                    char[] cArr3 = this.buf;
                    int i14 = i8 - this.bufAbsoluteStart;
                    strNewString = newString(cArr3, i14 + 1, (this.pos - 2) - i14);
                    if (strNewString.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                        throw new XMLStreamException("trying to bind reserved NS prefix 'xmlns'", getLocation());
                    }
                } else {
                    strNewString = null;
                }
            } else {
                String[] strArr4 = this.attributeName;
                int i15 = this.attributeCount;
                char[] cArr4 = this.buf;
                int i16 = i7 - this.bufAbsoluteStart;
                strNewString = newString(cArr4, i16, (this.pos - 1) - i16);
                strArr4[i15] = strNewString;
                if (!this.allStringsInterned) {
                    this.attributeNameHash[this.attributeCount] = strNewString.hashCode();
                }
            }
            while (isS(cMore)) {
                cMore = more();
            }
            if (cMore != '=') {
                throw new XMLStreamException("expected = after attribute name", getLocation());
            }
            char cMore2 = more();
            while (isS(cMore2)) {
                cMore2 = more();
            }
            if (cMore2 != '\"' && cMore2 != '\'') {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("attribute value must start with quotation or apostrophe not ");
                stringBuffer.append(printable(cMore2));
                throw new XMLStreamException(stringBuffer.toString(), getLocation());
            }
            this.usePC = false;
            this.pcStart = this.pcEnd;
            this.posStart = this.pos;
            boolean z4 = false;
            while (true) {
                char cMore3 = more();
                if (cMore3 == cMore2) {
                    if (this.processNamespaces && z3) {
                        if (!this.usePC) {
                            char[] cArr5 = this.buf;
                            int i17 = this.posStart;
                            strNewStringIntern = newStringIntern(cArr5, i17, (this.pos - 1) - i17);
                        } else {
                            char[] cArr6 = this.pc;
                            int i18 = this.pcStart;
                            strNewStringIntern = newStringIntern(cArr6, i18, this.pcEnd - i18);
                        }
                        ensureNamespacesCapacity(this.namespaceEnd);
                        if (strNewStringIntern.equals(XMLConstants.XML_NS_URI)) {
                            if (!XMLConstants.XML_NS_PREFIX.equals(strNewString)) {
                                throw new XMLStreamException("trying to bind reserved NS URI  'http://www.w3.org/XML/1998/namespace' to prefix other than 'xml'");
                            }
                        } else if (strNewStringIntern.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                            throw new XMLStreamException("trying to bind reserved NS URI  'http://www.w3.org/2000/xmlns/'");
                        }
                        if (i8 != -1) {
                            if (strNewStringIntern.length() == 0) {
                                throw new XMLStreamException("non-default namespace can not be declared to be empty string (in xml 1.0)", getLocation());
                            }
                            if (strNewString.equals(XMLConstants.XML_NS_PREFIX) && !strNewStringIntern.equals(XMLConstants.XML_NS_URI)) {
                                throw new XMLStreamException("trying to bind reserved NS prefix 'xml' to URI other than its standard value (http://www.w3.org/XML/1998/namespace)", getLocation());
                            }
                            String[] strArr5 = this.namespacePrefix;
                            int i19 = this.namespaceEnd;
                            strArr5[i19] = strNewString;
                            if (!this.allStringsInterned) {
                                int[] iArr = this.namespacePrefixHash;
                                int iHashCode = strNewString.hashCode();
                                iArr[i19] = iHashCode;
                                i = iHashCode;
                            }
                            String[] strArr6 = this.namespaceUri;
                            int i20 = this.namespaceEnd;
                            strArr6[i20] = strNewStringIntern;
                            i2 = this.elNamespaceCount[this.depth - 1];
                            i3 = i20 - 1;
                            while (true) {
                                if (i3 < i2) {
                                    z = this.allStringsInterned;
                                    if (((!!z || strNewString == null) && this.namespacePrefix[i3] == strNewString) || (!z && strNewString != null && this.namespacePrefixHash[i3] == i && strNewString.equals(this.namespacePrefix[i3]))) {
                                        break;
                                    }
                                    i3--;
                                } else {
                                    this.namespaceEnd++;
                                }
                            }
                            if (strNewString == null) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("'");
                                stringBuffer2.append(strNewString);
                                stringBuffer2.append("'");
                                string = stringBuffer2.toString();
                            } else {
                                string = "default";
                            }
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("duplicated namespace declaration for ");
                            stringBuffer3.append(string);
                            stringBuffer3.append(" prefix");
                            throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                        }
                        this.namespacePrefix[this.namespaceEnd] = str;
                        if (strNewStringIntern.length() == 0) {
                            strNewStringIntern = NO_NAMESPACE;
                        }
                        if (!this.allStringsInterned) {
                            this.namespacePrefixHash[this.namespaceEnd] = -1;
                        }
                        i = -1;
                        String[] strArr7 = this.namespaceUri;
                        int i21 = this.namespaceEnd;
                        strArr7[i21] = strNewStringIntern;
                        i2 = this.elNamespaceCount[this.depth - 1];
                        i3 = i21 - 1;
                        while (true) {
                            if (i3 < i2) {
                                z = this.allStringsInterned;
                                if (!z) {
                                    break;
                                    break;
                                }
                                break;
                            }
                            this.namespaceEnd++;
                            i3--;
                        }
                        if (strNewString == null) {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append("'");
                            stringBuffer4.append(strNewString);
                            stringBuffer4.append("'");
                            string = stringBuffer4.toString();
                        } else {
                            string = "default";
                        }
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("duplicated namespace declaration for ");
                        stringBuffer5.append(string);
                        stringBuffer5.append(" prefix");
                        throw new XMLStreamException(stringBuffer5.toString(), getLocation());
                    }
                    if (!this.usePC) {
                        String[] strArr8 = this.attributeValue;
                        int i22 = this.attributeCount;
                        char[] cArr7 = this.buf;
                        int i23 = this.posStart;
                        strArr8[i22] = new String(cArr7, i23, (this.pos - 1) - i23);
                    } else {
                        String[] strArr9 = this.attributeValue;
                        int i24 = this.attributeCount;
                        char[] cArr8 = this.pc;
                        int i25 = this.pcStart;
                        strArr9[i24] = new String(cArr8, i25, this.pcEnd - i25);
                    }
                    this.attributeCount++;
                    this.posStart = (i4 + i5) - this.bufAbsoluteStart;
                    return cMore3;
                }
                if (cMore3 == '<') {
                    throw new XMLStreamException("markup not allowed inside attribute value - illegal < ", getLocation());
                }
                if (cMore3 == '&') {
                    int i26 = this.pos - 1;
                    this.posEnd = i26;
                    if (!this.usePC) {
                        if (i26 > this.posStart) {
                            joinPC();
                        } else {
                            this.usePC = true;
                            this.pcEnd = 0;
                            this.pcStart = 0;
                        }
                    }
                    char[] entityRef = parseEntityRef(getConfigurationContext().isReplacingEntities());
                    if (entityRef == null) {
                        if (this.entityRefName == null) {
                            char[] cArr9 = this.buf;
                            int i27 = this.posStart;
                            this.entityRefName = newString(cArr9, i27, this.posEnd - i27);
                        }
                        StringBuffer stringBuffer6 = new StringBuffer();
                        stringBuffer6.append("could not resolve entity named '");
                        stringBuffer6.append(printable(this.entityRefName));
                        stringBuffer6.append("'");
                        throw new XMLStreamException(stringBuffer6.toString(), getLocation());
                    }
                    for (char c2 : entityRef) {
                        int i28 = this.pcEnd;
                        if (i28 >= this.pc.length) {
                            ensurePC(i28);
                        }
                        char[] cArr10 = this.pc;
                        int i29 = this.pcEnd;
                        this.pcEnd = i29 + 1;
                        cArr10[i29] = c2;
                    }
                } else {
                    if (cMore3 == '\t' || cMore3 == '\n' || cMore3 == '\r') {
                        if (this.usePC) {
                            z2 = false;
                        } else {
                            int i30 = this.pos - 1;
                            this.posEnd = i30;
                            if (i30 > this.posStart) {
                                joinPC();
                                z2 = false;
                            } else {
                                this.usePC = true;
                                z2 = false;
                                this.pcStart = 0;
                                this.pcEnd = 0;
                            }
                        }
                        int i31 = this.pcEnd;
                        if (i31 >= this.pc.length) {
                            ensurePC(i31);
                        }
                        if (cMore3 != '\n' || !z4) {
                            char[] cArr11 = this.pc;
                            int i32 = this.pcEnd;
                            this.pcEnd = i32 + 1;
                            cArr11[i32] = ' ';
                        }
                    } else if (this.usePC) {
                        int i33 = this.pcEnd;
                        if (i33 >= this.pc.length) {
                            ensurePC(i33);
                        }
                        char[] cArr12 = this.pc;
                        int i34 = this.pcEnd;
                        this.pcEnd = i34 + 1;
                        cArr12[i34] = cMore3;
                    }
                    if (cMore3 == '\r') {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    str = null;
                }
                z2 = false;
                if (cMore3 == '\r') {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                str = null;
            }
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected char[] parseEntityRef(boolean z) throws XMLStreamException {
        int i;
        int i2;
        try {
            this.entityRefName = null;
            this.posStart = this.pos;
            if (more() == '#') {
                char cMore = more();
                if (cMore == 'x') {
                    i = 0;
                    do {
                        char cMore2 = more();
                        if (cMore2 == ';') {
                            break;
                        }
                        if (cMore2 >= '0' && cMore2 <= '9') {
                            i2 = cMore2 - 48;
                        } else if (cMore2 >= 'a' && cMore2 <= 'f') {
                            i2 = cMore2 - 87;
                        } else {
                            if (cMore2 < 'A' || cMore2 > 'F') {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("character reference (with hex value) may not contain ");
                                stringBuffer.append(printable(cMore2));
                                throw new XMLStreamException(stringBuffer.toString(), getLocation());
                            }
                            i2 = cMore2 - 55;
                        }
                        i = (i << 4) + i2;
                    } while (i <= MAX_UNICODE_CHAR);
                } else {
                    int i3 = 0;
                    do {
                        if (cMore < '0' || cMore > '9') {
                            if (cMore == ';') {
                                break;
                            }
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("character reference (with decimal value) may not contain ");
                            stringBuffer2.append(printable(cMore));
                            throw new XMLStreamException(stringBuffer2.toString(), getLocation());
                        }
                        i3 = (i3 * 10) + (cMore - '0');
                        cMore = more();
                    } while (i3 <= MAX_UNICODE_CHAR);
                    i = i3;
                }
                this.posEnd = this.pos - 1;
                checkCharValidity(i, false);
                if (i > 65535) {
                    if (this.charRefTwoCharBuf == null) {
                        this.charRefTwoCharBuf = new char[2];
                    }
                    int i4 = i - 65536;
                    char[] cArr = this.charRefTwoCharBuf;
                    cArr[0] = (char) ((i4 >> 10) + 55296);
                    cArr[1] = (char) ((i4 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                    this.entityValue = cArr;
                    return cArr;
                }
                char[] cArr2 = this.charRefOneCharBuf;
                cArr2[0] = (char) i;
                this.entityValue = cArr2;
                return cArr2;
            }
            while (more() != ';') {
            }
            int i5 = this.pos - 1;
            this.posEnd = i5;
            int i6 = this.posStart;
            int i7 = i5 - i6;
            if (i7 == 2) {
                char[] cArr3 = this.buf;
                char c = cArr3[i6];
                if (c == 'l' && cArr3[i6 + 1] == 't') {
                    if (!z) {
                        this.text = "<";
                    }
                    char[] cArr4 = this.charRefOneCharBuf;
                    cArr4[0] = Typography.less;
                    this.entityValue = cArr4;
                    return cArr4;
                }
                if (c == 'g' && cArr3[i6 + 1] == 't') {
                    if (!z) {
                        this.text = ">";
                    }
                    char[] cArr5 = this.charRefOneCharBuf;
                    cArr5[0] = Typography.greater;
                    this.entityValue = cArr5;
                    return cArr5;
                }
            } else if (i7 == 3) {
                char[] cArr6 = this.buf;
                if (cArr6[i6] == 'a' && cArr6[i6 + 1] == 'm' && cArr6[i6 + 2] == 'p') {
                    if (!z) {
                        this.text = "&";
                    }
                    char[] cArr7 = this.charRefOneCharBuf;
                    cArr7[0] = Typography.amp;
                    this.entityValue = cArr7;
                    return cArr7;
                }
            } else if (i7 == 4) {
                char[] cArr8 = this.buf;
                char c2 = cArr8[i6];
                if (c2 == 'a' && cArr8[i6 + 1] == 'p' && cArr8[i6 + 2] == 'o' && cArr8[i6 + 3] == 's') {
                    if (!z) {
                        this.text = "'";
                    }
                    char[] cArr9 = this.charRefOneCharBuf;
                    cArr9[0] = CoreConstants.SINGLE_QUOTE_CHAR;
                    this.entityValue = cArr9;
                    return cArr9;
                }
                if (c2 == 'q' && cArr8[i6 + 1] == 'u' && cArr8[i6 + 2] == 'o' && cArr8[i6 + 3] == 't') {
                    if (!z) {
                        this.text = "\"";
                    }
                    char[] cArr10 = this.charRefOneCharBuf;
                    cArr10[0] = '\"';
                    this.entityValue = cArr10;
                    return cArr10;
                }
            }
            char[] cArrLookupEntityReplacement = lookupEntityReplacement(i7);
            this.entityValue = cArrLookupEntityReplacement;
            return cArrLookupEntityReplacement;
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected char[] lookupEntityReplacement(int i) throws XMLStreamException {
        if (!this.allStringsInterned) {
            char[] cArr = this.buf;
            int i2 = this.posStart;
            int iFastHash = fastHash(cArr, i2, this.posEnd - i2);
            for (int i3 = this.entityEnd - 1; i3 >= 0; i3--) {
                if (iFastHash == this.entityNameHash[i3]) {
                    char[] cArr2 = this.entityNameBuf[i3];
                    if (i == cArr2.length) {
                        int i4 = 0;
                        while (true) {
                            if (i4 < i) {
                                if (this.buf[this.posStart + i4] != cArr2[i4]) {
                                    break;
                                }
                                i4++;
                            } else {
                                if (this.tokenize) {
                                    this.text = this.entityReplacement[i3];
                                }
                                this.entityRefName = this.entityName[i3];
                                return this.entityReplacementBuf[i3];
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
        char[] cArr3 = this.buf;
        int i5 = this.posStart;
        this.entityRefName = newString(cArr3, i5, this.posEnd - i5);
        for (int i6 = this.entityEnd - 1; i6 >= 0; i6--) {
            if (this.entityRefName == this.entityName[i6]) {
                if (this.tokenize) {
                    this.text = this.entityReplacement[i6];
                }
                return this.entityReplacementBuf[i6];
            }
        }
        return null;
    }

    protected void parseComment() throws XMLStreamException {
        try {
            if (more() != '-') {
                throw new XMLStreamException("expected <!-- for COMMENT start", getLocation());
            }
            this.posStart = this.pos;
            int i = this.lineNumber;
            int i2 = this.columnNumber;
            int i3 = -2;
            int i4 = -1;
            boolean z = false;
            int i5 = -2;
            while (true) {
                try {
                    char cMore = more();
                    i4++;
                    if (cMore == '-') {
                        if (i3 >= i4) {
                            break;
                        } else {
                            i3 = i4 + 2;
                        }
                    } else if (cMore == '\r') {
                        this.columnNumber = 1;
                        i5 = i4 + 2;
                        if (z) {
                            cMore = '\n';
                        } else {
                            this.buf[this.pos - 1] = '\n';
                        }
                    } else if (cMore == '\n' && i5 == i4) {
                        if (!z) {
                            this.posEnd = this.pos - 1;
                            z = true;
                        }
                    }
                    if (z) {
                        char[] cArr = this.buf;
                        int i6 = this.posEnd;
                        cArr[i6] = cMore;
                        this.posEnd = i6 + 1;
                    }
                } catch (EOFException e) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("COMMENT started on line ");
                    stringBuffer.append(i);
                    stringBuffer.append(" and column ");
                    stringBuffer.append(i2);
                    stringBuffer.append(" was not closed");
                    throw new XMLStreamException(stringBuffer.toString(), getLocation(), e);
                }
            }
            char cMore2 = more();
            if (cMore2 != '>') {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("in COMMENT after two dashes (--) next character must be '>' not ");
                stringBuffer2.append(printable(cMore2));
                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
            }
            if (z) {
                this.posEnd--;
            } else {
                this.posEnd = this.pos - 3;
            }
        } catch (EOFException e2) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e2);
        }
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getPITarget() {
        if (this.eventType != 3) {
            throwIllegalState(3);
        }
        return this.piTarget;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public String getPIData() {
        if (this.eventType != 3) {
            throwIllegalState(3);
        }
        return this.piData;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public NamespaceContext getNamespaceContext() {
        return new ReadOnlyNamespaceContextBase(this.namespacePrefix, this.namespaceUri, this.namespaceEnd);
    }

    protected boolean parsePI() throws XMLStreamException {
        char cMore;
        int i = this.lineNumber;
        int i2 = this.columnNumber;
        try {
            this.piTarget = null;
            this.piData = null;
            this.posStart = this.pos;
            while (true) {
                cMore = more();
                if (cMore == '?') {
                    break;
                }
                if (!isNameChar(cMore)) {
                    if (isS(cMore)) {
                        break;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("unexpected character ");
                    stringBuffer.append(printable(cMore));
                    stringBuffer.append(" after processing instruction name; expected a white space or '?>'");
                    throw new XMLStreamException(stringBuffer.toString(), getLocation());
                }
            }
            int i3 = this.pos;
            int i4 = this.posStart;
            boolean z = true;
            int i5 = (i3 - i4) - 1;
            if (i5 == 0) {
                throw new XMLStreamException("processing instruction must have PITarget name", getLocation());
            }
            this.piTarget = new String(this.buf, i4, i5);
            if (cMore != '?') {
                cMore = skipS(cMore);
            }
            boolean zEqualsIgnoreCase = this.piTarget.equalsIgnoreCase(XMLConstants.XML_NS_PREFIX);
            if (zEqualsIgnoreCase) {
                if (this.posStart + this.bufAbsoluteStart <= 2) {
                    if (!XMLConstants.XML_NS_PREFIX.equals(this.piTarget)) {
                        throw new XMLStreamException("XMLDecl must have xml name in lowercase", getLocation());
                    }
                    this.posStart = this.pos - 1;
                    parseXmlDecl(cMore);
                    this.posEnd = this.pos - 2;
                } else {
                    throw new XMLStreamException("processing instruction can not have PITarget with reserved name 'xml'", getLocation());
                }
            } else {
                this.posStart = this.pos - 1;
                int i6 = -2;
                int i7 = -1;
                boolean z2 = false;
                char cMore2 = cMore;
                int i8 = -2;
                while (true) {
                    int i9 = i7 + 1;
                    if (cMore2 == '?') {
                        i8 = i7 + 2;
                    } else if (cMore2 != '>') {
                        if (cMore2 == '\r') {
                            this.columnNumber = 1;
                            i6 = i7 + 2;
                            if (z2) {
                                cMore2 = '\n';
                            } else {
                                this.buf[this.pos - 1] = '\n';
                            }
                        } else if (cMore2 == '\n' && i6 == i9) {
                            if (!z2) {
                                this.posEnd = this.pos - 1;
                                z2 = true;
                            }
                        }
                        cMore2 = more();
                        i7 = i9;
                    } else if (i9 == i8) {
                        break;
                    }
                    if (z2) {
                        char[] cArr = this.buf;
                        int i10 = this.posEnd;
                        cArr[i10] = cMore2;
                        this.posEnd = i10 + 1;
                    }
                    cMore2 = more();
                    i7 = i9;
                }
                if (z2) {
                    this.posEnd--;
                } else {
                    this.posEnd = this.pos - 2;
                }
                z = zEqualsIgnoreCase;
            }
            char[] cArr2 = this.buf;
            int i11 = this.posStart;
            this.piData = new String(cArr2, i11, this.posEnd - i11);
            return z;
        } catch (EOFException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("processing instruction started on line ");
            stringBuffer2.append(i);
            stringBuffer2.append(" and column ");
            stringBuffer2.append(i2);
            stringBuffer2.append(" was not closed");
            throw new XMLStreamException(stringBuffer2.toString(), getLocation(), e);
        }
    }

    protected char requireInput(char c, char[] cArr) throws XMLStreamException {
        for (int i = 0; i < cArr.length; i++) {
            if (c != cArr[i]) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("expected ");
                stringBuffer.append(printable(cArr[i]));
                stringBuffer.append(" in ");
                stringBuffer.append(new String(cArr));
                stringBuffer.append(" and not ");
                stringBuffer.append(printable(c));
                throw new XMLStreamException(stringBuffer.toString(), getLocation());
            }
            try {
                c = more();
            } catch (EOFException e) {
                throw new XMLStreamException(EOF_MSG, getLocation(), e);
            }
        }
        return c;
    }

    protected char requireNextS() throws XMLStreamException {
        try {
            char cMore = more();
            if (!isS(cMore)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("white space is required and not ");
                stringBuffer.append(printable(cMore));
                throw new XMLStreamException(stringBuffer.toString(), getLocation());
            }
            return skipS(cMore);
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected char skipS(char c) throws XMLStreamException {
        while (isS(c)) {
            try {
                c = more();
            } catch (EOFException e) {
                throw new XMLStreamException(EOF_MSG, getLocation(), e);
            }
        }
        return c;
    }

    protected void parseXmlDecl(char c) throws XMLStreamException {
        try {
            char cSkipS = skipS(requireInput(skipS(c), VERSION));
            if (cSkipS != '=') {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("expected equals sign (=) after version and not ");
                stringBuffer.append(printable(cSkipS));
                throw new XMLStreamException(stringBuffer.toString(), getLocation());
            }
            char cSkipS2 = skipS(more());
            if (cSkipS2 != '\'' && cSkipS2 != '\"') {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("expected apostrophe (') or quotation mark (\") after version and not ");
                stringBuffer2.append(printable(cSkipS2));
                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
            }
            int i = this.pos;
            char cMore = more();
            while (cMore != cSkipS2) {
                if ((cMore < 'a' || cMore > 'z') && ((cMore < 'A' || cMore > 'Z') && ((cMore < '0' || cMore > '9') && cMore != '_' && cMore != '.' && cMore != ':' && cMore != '-'))) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("<?xml version value expected to be in ([a-zA-Z0-9_.:] | '-') not ");
                    stringBuffer3.append(printable(cMore));
                    throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                }
                cMore = more();
            }
            parseXmlDeclWithVersion(i, this.pos - 1);
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected void parseXmlDeclWithVersion(int i, int i2) throws XMLStreamException {
        char cRequireInput;
        int i3 = i2 - i;
        if (i3 == 3) {
            try {
                char[] cArr = this.buf;
                if (cArr[i] == '1' && cArr[i + 1] == '.' && cArr[i + 2] == '0') {
                    this.xmlVersion = new String(cArr, i, i3);
                    char cSkipS = skipS(more());
                    if (cSkipS != '?') {
                        cSkipS = skipS(cSkipS);
                        char[] cArr2 = ENCODING;
                        if (cSkipS == cArr2[0]) {
                            char cSkipS2 = skipS(requireInput(cSkipS, cArr2));
                            if (cSkipS2 != '=') {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("expected equals sign (=) after encoding and not ");
                                stringBuffer.append(printable(cSkipS2));
                                throw new XMLStreamException(stringBuffer.toString(), getLocation());
                            }
                            char cSkipS3 = skipS(more());
                            if (cSkipS3 != '\'' && cSkipS3 != '\"') {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("expected apostrophe (') or quotation mark (\") after encoding and not ");
                                stringBuffer2.append(printable(cSkipS3));
                                throw new XMLStreamException(stringBuffer2.toString(), getLocation());
                            }
                            int i4 = this.pos;
                            char cMore = more();
                            char c = 'a';
                            if ((cMore < 'a' || cMore > 'z') && (cMore < 'A' || cMore > 'Z')) {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("<?xml encoding name expected to start with [A-Za-z] not ");
                                stringBuffer3.append(printable(cMore));
                                throw new XMLStreamException(stringBuffer3.toString(), getLocation());
                            }
                            char cMore2 = more();
                            while (cMore2 != cSkipS3) {
                                if ((cMore2 < c || cMore2 > 'z') && ((cMore2 < 'A' || cMore2 > 'Z') && ((cMore2 < '0' || cMore2 > '9') && cMore2 != '.' && cMore2 != '_' && cMore2 != '-'))) {
                                    StringBuffer stringBuffer4 = new StringBuffer();
                                    stringBuffer4.append("<?xml encoding value expected to be in ([A-Za-z0-9._] | '-') not ");
                                    stringBuffer4.append(printable(cMore2));
                                    throw new XMLStreamException(stringBuffer4.toString(), getLocation());
                                }
                                cMore2 = more();
                                c = 'a';
                            }
                            this.charEncodingScheme = newString(this.buf, i4, (this.pos - 1) - i4);
                            cSkipS = skipS(more());
                        }
                        if (cSkipS != '?') {
                            char cSkipS4 = skipS(requireInput(skipS(cSkipS), STANDALONE));
                            if (cSkipS4 != '=') {
                                StringBuffer stringBuffer5 = new StringBuffer();
                                stringBuffer5.append("expected equals sign (=) after standalone and not ");
                                stringBuffer5.append(printable(cSkipS4));
                                throw new XMLStreamException(stringBuffer5.toString(), getLocation());
                            }
                            char cSkipS5 = skipS(more());
                            if (cSkipS5 != '\'' && cSkipS5 != '\"') {
                                StringBuffer stringBuffer6 = new StringBuffer();
                                stringBuffer6.append("expected apostrophe (') or quotation mark (\") after encoding and not ");
                                stringBuffer6.append(printable(cSkipS5));
                                throw new XMLStreamException(stringBuffer6.toString(), getLocation());
                            }
                            char cMore3 = more();
                            if (cMore3 == 'y') {
                                cRequireInput = requireInput(cMore3, YES);
                                this.standalone = true;
                            } else if (cMore3 == 'n') {
                                cRequireInput = requireInput(cMore3, NO);
                                this.standalone = false;
                            } else {
                                StringBuffer stringBuffer7 = new StringBuffer();
                                stringBuffer7.append("expected 'yes' or 'no' after standalone and not ");
                                stringBuffer7.append(printable(cMore3));
                                throw new XMLStreamException(stringBuffer7.toString(), getLocation());
                            }
                            this.standaloneSet = true;
                            if (cRequireInput != cSkipS5) {
                                StringBuffer stringBuffer8 = new StringBuffer();
                                stringBuffer8.append("expected ");
                                stringBuffer8.append(cSkipS5);
                                stringBuffer8.append(" after standalone value not ");
                                stringBuffer8.append(printable(cRequireInput));
                                throw new XMLStreamException(stringBuffer8.toString(), getLocation());
                            }
                            cSkipS = more();
                        }
                    }
                    char cSkipS6 = skipS(cSkipS);
                    if (cSkipS6 != '?') {
                        StringBuffer stringBuffer9 = new StringBuffer();
                        stringBuffer9.append("expected ?> as last part of <?xml not ");
                        stringBuffer9.append(printable(cSkipS6));
                        throw new XMLStreamException(stringBuffer9.toString(), getLocation());
                    }
                    char cMore4 = more();
                    if (cMore4 == '>') {
                        return;
                    }
                    StringBuffer stringBuffer10 = new StringBuffer();
                    stringBuffer10.append("expected ?> as last part of <?xml not ");
                    stringBuffer10.append(printable(cMore4));
                    throw new XMLStreamException(stringBuffer10.toString(), getLocation());
                }
            } catch (EOFException e) {
                throw new XMLStreamException(EOF_MSG, getLocation(), e);
            }
        }
        StringBuffer stringBuffer11 = new StringBuffer();
        stringBuffer11.append("only 1.0 is supported as <?xml version not '");
        stringBuffer11.append(printable(new String(this.buf, i, i2)));
        stringBuffer11.append("'");
        throw new XMLStreamException(stringBuffer11.toString(), getLocation());
    }

    protected void parseDocdecl() throws XMLStreamException {
        char cMore;
        this.posStart = this.pos - 3;
        try {
            if (more() != 'O' || more() != 'C' || more() != 'T' || more() != 'Y' || more() != 'P' || more() != 'E') {
                throw new XMLStreamException("expected <!DOCTYPE", getLocation());
            }
            char cRequireNextS = requireNextS();
            if (!isNameStartChar(cRequireNextS)) {
                throwNotNameStart(cRequireNextS);
            }
            do {
                cMore = more();
            } while (isNameChar(cMore));
            char cSkipS = skipS(cMore);
            if (cSkipS == 'S' || cSkipS == 'P') {
                if (cSkipS == 'S') {
                    if (more() != 'Y' || more() != 'S' || more() != 'T' || more() != 'E' || more() != 'M') {
                        throw new XMLStreamException("expected keyword SYSTEM", getLocation());
                    }
                } else {
                    if (more() != 'U' || more() != 'B' || more() != 'L' || more() != 'I' || more() != 'C') {
                        throw new XMLStreamException("expected keyword PUBLIC", getLocation());
                    }
                    char cRequireNextS2 = requireNextS();
                    if (cRequireNextS2 != '\"' && cRequireNextS2 != '\'') {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Public identifier has to be enclosed in quotes, not ");
                        stringBuffer.append(printable(cSkipS));
                        throw new XMLStreamException(stringBuffer.toString(), getLocation());
                    }
                    do {
                        cSkipS = more();
                    } while (cSkipS != cRequireNextS2);
                }
                char cRequireNextS3 = requireNextS();
                if (cRequireNextS3 != '\"' && cRequireNextS3 != '\'') {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("System identifier has to be enclosed in quotes, not ");
                    stringBuffer2.append(printable(cSkipS));
                    throw new XMLStreamException(stringBuffer2.toString(), getLocation());
                }
                while (more() != cRequireNextS3) {
                }
                cSkipS = skipS(more());
            }
            if (cSkipS == '[') {
                this.posStart = this.pos;
                int i = 1;
                while (true) {
                    char cMore2 = more();
                    if (cMore2 == '\"' || cMore2 == '\'') {
                        while (more() != cMore2) {
                        }
                    } else if (cMore2 != '>') {
                        if (cMore2 == '[') {
                            i++;
                        } else if (cMore2 == ']') {
                            i--;
                        }
                    } else if (i <= 0) {
                        this.posEnd = this.pos - 2;
                        processDTD();
                        return;
                    }
                }
            } else {
                int i2 = this.pos;
                this.posEnd = i2;
                this.posStart = i2;
                char cSkipS2 = skipS(cSkipS);
                if (cSkipS2 == '>') {
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Expected closing '>' after internal DTD subset, not '");
                stringBuffer3.append(printable(cSkipS2));
                stringBuffer3.append("'");
                throw new XMLStreamException(stringBuffer3.toString(), getLocation());
            }
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected void processDTD() throws XMLStreamException {
        try {
            char[] cArr = this.buf;
            int i = this.posStart;
            DTD dtd = new DTDParser(new StringReader(new String(cArr, i, this.posEnd - i))).parse();
            this.mDtdIntSubset = dtd;
            Class clsClass$ = class$com$wutka$dtd$DTDEntity;
            if (clsClass$ == null) {
                clsClass$ = class$("com.wutka.dtd.DTDEntity");
                class$com$wutka$dtd$DTDEntity = clsClass$;
            }
            Enumeration enumerationElements = dtd.getItemsByType(clsClass$).elements();
            while (enumerationElements.hasMoreElements()) {
                DTDEntity dTDEntity = (DTDEntity) enumerationElements.nextElement();
                if (!dTDEntity.isParsed()) {
                    defineEntityReplacementText(dTDEntity.getName(), dTDEntity.getValue());
                }
            }
            DTD dtd2 = this.mDtdIntSubset;
            Class clsClass$2 = class$com$wutka$dtd$DTDAttlist;
            if (clsClass$2 == null) {
                clsClass$2 = class$("com.wutka.dtd.DTDAttlist");
                class$com$wutka$dtd$DTDAttlist = clsClass$2;
            }
            Enumeration enumerationElements2 = dtd2.getItemsByType(clsClass$2).elements();
            while (enumerationElements2.hasMoreElements()) {
                DTDAttlist dTDAttlist = (DTDAttlist) enumerationElements2.nextElement();
                for (DTDAttribute dTDAttribute : dTDAttlist.getAttribute()) {
                    if (dTDAttribute.getDefaultValue() != null) {
                        if (this.defaultAttributes == null) {
                            this.defaultAttributes = new HashMap();
                        }
                        this.defaultAttributes.put(dTDAttlist.getName(), dTDAttlist);
                    }
                }
            }
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected void parseCDATA() throws XMLStreamException {
        try {
            if (more() != 'C' || more() != 'D' || more() != 'A' || more() != 'T' || more() != 'A' || more() != '[') {
                throw new XMLStreamException("expected <[CDATA[ for CDATA start", getLocation());
            }
            this.posStart = this.pos;
            int i = this.lineNumber;
            int i2 = this.columnNumber;
            int i3 = -2;
            int i4 = -1;
            int i5 = 0;
            boolean z = false;
            while (true) {
                i4++;
                try {
                    char cMore = more();
                    if (cMore == ']') {
                        i5++;
                    } else {
                        if (cMore == '>') {
                            if (i5 >= 2) {
                                break;
                            }
                        } else if (cMore == '\r') {
                            this.columnNumber = 1;
                            i3 = i4 + 2;
                            if (z) {
                                i5 = 0;
                                cMore = '\n';
                            } else {
                                this.buf[this.pos - 1] = '\n';
                                i5 = 0;
                            }
                        } else if (cMore == '\n' && i3 == i4) {
                            this.posEnd = this.pos - 1;
                            i5 = 0;
                            z = true;
                        }
                        i5 = 0;
                    }
                    if (z) {
                        char[] cArr = this.buf;
                        int i6 = this.posEnd;
                        cArr[i6] = cMore;
                        this.posEnd = i6 + 1;
                    }
                } catch (EOFException e) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("CDATA section on line ");
                    stringBuffer.append(i);
                    stringBuffer.append(" and column ");
                    stringBuffer.append(i2);
                    stringBuffer.append(" was not closed");
                    throw new XMLStreamException(stringBuffer.toString(), getLocation(), e);
                }
            }
            if (z) {
                this.posEnd -= 2;
            } else {
                this.posEnd = this.pos - 3;
            }
        } catch (EOFException e2) {
            throw new XMLStreamException("Unexpected EOF in directive", getLocation(), e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0022  */
    /* JADX WARN: Code duplicated, block: B:18:0x0029 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x005f  */
    protected void fillBuf() throws XMLStreamException, EOFException {
        int length;
        int i;
        if (this.reader == null) {
            throw new XMLStreamException("reader must be set before parsing is started");
        }
        int i2 = this.bufEnd;
        int i3 = this.bufSoftLimit;
        if (i2 > i3) {
            int i4 = this.bufStart;
            boolean z = true;
            boolean z2 = i4 > i3;
            if (z2) {
                z = z2;
            } else {
                if (i4 >= this.buf.length / 2) {
                }
                if (z2) {
                    char[] cArr = this.buf;
                    System.arraycopy(cArr, i4, cArr, 0, i2 - i4);
                } else if (z) {
                    char[] cArr2 = this.buf;
                    length = cArr2.length * 2;
                    char[] cArr3 = new char[length];
                    System.arraycopy(cArr2, i4, cArr3, 0, i2 - i4);
                    this.buf = cArr3;
                    i = this.bufLoadFactor;
                    if (i > 0) {
                        this.bufSoftLimit = (i * length) / 100;
                    }
                } else {
                    throw new XMLStreamException("internal error in fillBuffer()");
                }
                int i5 = this.bufEnd;
                int i6 = this.bufStart;
                this.bufEnd = i5 - i6;
                this.pos -= i6;
                this.posStart -= i6;
                this.posEnd -= i6;
                this.bufAbsoluteStart += i6;
                this.bufStart = 0;
            }
            z2 = z;
            z = false;
            if (z2) {
                char[] cArr4 = this.buf;
                System.arraycopy(cArr4, i4, cArr4, 0, i2 - i4);
            } else if (z) {
                char[] cArr5 = this.buf;
                length = cArr5.length * 2;
                char[] cArr6 = new char[length];
                System.arraycopy(cArr5, i4, cArr6, 0, i2 - i4);
                this.buf = cArr6;
                i = this.bufLoadFactor;
                if (i > 0) {
                    this.bufSoftLimit = (i * length) / 100;
                }
            } else {
                throw new XMLStreamException("internal error in fillBuffer()");
            }
            int i7 = this.bufEnd;
            int i8 = this.bufStart;
            this.bufEnd = i7 - i8;
            this.pos -= i8;
            this.posStart -= i8;
            this.posEnd -= i8;
            this.bufAbsoluteStart += i8;
            this.bufStart = 0;
        }
        char[] cArr7 = this.buf;
        int length2 = cArr7.length;
        int i9 = this.bufEnd;
        int i10 = length2 - i9;
        if (i10 > 8192) {
            i10 = 8192;
        }
        try {
            int i11 = this.reader.read(cArr7, i9, i10);
            if (i11 > 0) {
                this.bufEnd += i11;
            } else {
                if (i11 == -1) {
                    throw new EOFException("no more data available");
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("error reading input, returned ");
                stringBuffer.append(i11);
                throw new XMLStreamException(stringBuffer.toString());
            }
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    protected char more() throws XMLStreamException, EOFException {
        if (this.pos >= this.bufEnd) {
            fillBuf();
        }
        char[] cArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        char c = cArr[i];
        if (c == '\n') {
            this.lineNumber++;
            this.columnNumber = 1;
        } else {
            this.columnNumber++;
        }
        return c;
    }

    protected String printable(char c) {
        if (c == '\n') {
            return "\\n";
        }
        if (c == '\r') {
            return "\\r";
        }
        if (c == '\t') {
            return "\\t";
        }
        if (c == '\'') {
            return "\\'";
        }
        if (c > 127 || c < ' ') {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\\u");
            stringBuffer.append(Integer.toHexString(c));
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("");
        stringBuffer2.append(c);
        return stringBuffer2.toString();
    }

    protected String printable(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(printable(str.charAt(i)));
        }
        return stringBuffer.toString();
    }

    protected void ensurePC(int i) {
        char[] cArr = new char[i > 8192 ? i * 2 : 16384];
        System.arraycopy(this.pc, 0, cArr, 0, this.pcEnd);
        this.pc = cArr;
    }

    protected void joinPC() {
        int i = this.posEnd - this.posStart;
        int i2 = this.pcEnd + i + 1;
        if (i2 >= this.pc.length) {
            ensurePC(i2);
        }
        System.arraycopy(this.buf, this.posStart, this.pc, this.pcEnd, i);
        this.pcEnd += i;
        this.usePC = true;
    }

    public void setConfigurationContext(ConfigurationContextBase configurationContextBase) {
        this.configurationContext = configurationContextBase;
        Boolean bool = Boolean.TRUE;
        bool.equals(configurationContextBase.getProperty(XMLInputFactory.IS_COALESCING));
        this.reportCdataEvent = bool.equals(configurationContextBase.getProperty("http://java.sun.com/xml/stream/properties/report-cdata-event"));
    }

    public ConfigurationContextBase getConfigurationContext() {
        return this.configurationContext;
    }

    @Override // javax.xml.stream.XMLStreamReader
    public Object getProperty(String str) {
        ArrayList arrayList = null;
        if (str.equals("javax.xml.stream.entities")) {
            DTD dtd = this.mDtdIntSubset;
            if (dtd != null) {
                Class clsClass$ = class$com$wutka$dtd$DTDEntity;
                if (clsClass$ == null) {
                    clsClass$ = class$("com.wutka.dtd.DTDEntity");
                    class$com$wutka$dtd$DTDEntity = clsClass$;
                }
                Vector itemsByType = dtd.getItemsByType(clsClass$);
                Enumeration enumerationElements = itemsByType.elements();
                arrayList = new ArrayList(itemsByType.size());
                while (enumerationElements.hasMoreElements()) {
                    EntityDeclaration entityDeclarationCreateEntityDeclaration = DTDEvent.createEntityDeclaration((DTDEntity) enumerationElements.nextElement());
                    if (entityDeclarationCreateEntityDeclaration != null) {
                        arrayList.add(entityDeclarationCreateEntityDeclaration);
                    }
                }
            }
            return arrayList;
        }
        if (str.equals("javax.xml.stream.notations")) {
            DTD dtd2 = this.mDtdIntSubset;
            if (dtd2 != null) {
                Class clsClass$2 = class$com$wutka$dtd$DTDNotation;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("com.wutka.dtd.DTDNotation");
                    class$com$wutka$dtd$DTDNotation = clsClass$2;
                }
                Vector itemsByType2 = dtd2.getItemsByType(clsClass$2);
                Enumeration enumerationElements2 = itemsByType2.elements();
                arrayList = new ArrayList(itemsByType2.size());
                while (enumerationElements2.hasMoreElements()) {
                    NotationDeclaration notationDeclarationCreateNotationDeclaration = DTDEvent.createNotationDeclaration((DTDNotation) enumerationElements2.nextElement());
                    if (notationDeclarationCreateNotationDeclaration != null) {
                        arrayList.add(notationDeclarationCreateNotationDeclaration);
                    }
                }
            }
            return arrayList;
        }
        return this.configurationContext.getProperty(str);
    }

    private String throwIllegalState(int i) throws IllegalStateException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Current state (");
        stringBuffer.append(eventTypeDesc(this.eventType));
        stringBuffer.append(") not ");
        stringBuffer.append(eventTypeDesc(i));
        throw new IllegalStateException(stringBuffer.toString());
    }

    private String throwIllegalState(int[] iArr) throws IllegalStateException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(eventTypeDesc(iArr[0]));
        int length = iArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(", ");
            stringBuffer.append(eventTypeDesc(iArr[i]));
        }
        stringBuffer.append(" or ");
        stringBuffer.append(eventTypeDesc(iArr[length]));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Current state (");
        stringBuffer2.append(eventTypeDesc(this.eventType));
        stringBuffer2.append(") not ");
        stringBuffer2.append(stringBuffer.toString());
        throw new IllegalStateException(stringBuffer2.toString());
    }

    private void throwNotNameStart(char c) throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("expected name start character and not ");
        stringBuffer.append(printable(c));
        throw new XMLStreamException(stringBuffer.toString(), getLocation());
    }
}
