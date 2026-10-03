package org.xmlpull.v1.sax2;

import ch.qos.logback.core.CoreConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes.dex */
public class Driver implements Locator, XMLReader, Attributes {
    protected static final String APACHE_DYNAMIC_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/dynamic";
    protected static final String APACHE_SCHEMA_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/schema";
    protected static final String DECLARATION_HANDLER_PROPERTY = "http://xml.org/sax/properties/declaration-handler";
    protected static final String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
    protected static final String NAMESPACES_FEATURE = "http://xml.org/sax/features/namespaces";
    protected static final String NAMESPACE_PREFIXES_FEATURE = "http://xml.org/sax/features/namespace-prefixes";
    protected static final String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";
    protected ContentHandler contentHandler = new DefaultHandler();
    protected ErrorHandler errorHandler = new DefaultHandler();
    protected XmlPullParser pp;
    protected String systemId;

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return null;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return null;
    }

    @Override // org.xml.sax.Locator
    public String getPublicId() {
        return null;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
    }

    public Driver() throws XmlPullParserException {
        XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
        xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        this.pp = xmlPullParserFactoryNewInstance.newPullParser();
    }

    public Driver(XmlPullParser xmlPullParser) throws XmlPullParserException {
        this.pp = xmlPullParser;
    }

    @Override // org.xml.sax.Attributes
    public int getLength() {
        return this.pp.getAttributeCount();
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i) {
        return this.pp.getAttributeNamespace(i);
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i) {
        return this.pp.getAttributeName(i);
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i) {
        String attributePrefix = this.pp.getAttributePrefix(i);
        if (attributePrefix != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(attributePrefix);
            stringBuffer.append(CoreConstants.COLON_CHAR);
            stringBuffer.append(this.pp.getAttributeName(i));
            return stringBuffer.toString();
        }
        return this.pp.getAttributeName(i);
    }

    @Override // org.xml.sax.Attributes
    public String getType(int i) {
        return this.pp.getAttributeType(i);
    }

    @Override // org.xml.sax.Attributes
    public String getValue(int i) {
        return this.pp.getAttributeValue(i);
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        for (int i = 0; i < this.pp.getAttributeCount(); i++) {
            if (this.pp.getAttributeNamespace(i).equals(str) && this.pp.getAttributeName(i).equals(str2)) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        for (int i = 0; i < this.pp.getAttributeCount(); i++) {
            if (this.pp.getAttributeName(i).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        for (int i = 0; i < this.pp.getAttributeCount(); i++) {
            if (this.pp.getAttributeNamespace(i).equals(str) && this.pp.getAttributeName(i).equals(str2)) {
                return this.pp.getAttributeType(i);
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str) {
        for (int i = 0; i < this.pp.getAttributeCount(); i++) {
            if (this.pp.getAttributeName(i).equals(str)) {
                return this.pp.getAttributeType(i);
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        return this.pp.getAttributeValue(str, str2);
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str) {
        return this.pp.getAttributeValue(null, str);
    }

    @Override // org.xml.sax.Locator
    public String getSystemId() {
        return this.systemId;
    }

    @Override // org.xml.sax.Locator
    public int getLineNumber() {
        return this.pp.getLineNumber();
    }

    @Override // org.xml.sax.Locator
    public int getColumnNumber() {
        return this.pp.getColumnNumber();
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (NAMESPACES_FEATURE.equals(str)) {
            return this.pp.getFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces");
        }
        if (NAMESPACE_PREFIXES_FEATURE.equals(str)) {
            return this.pp.getFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES);
        }
        if (VALIDATION_FEATURE.equals(str)) {
            return this.pp.getFeature(XmlPullParser.FEATURE_VALIDATION);
        }
        return this.pp.getFeature(str);
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        try {
            if (NAMESPACES_FEATURE.equals(str)) {
                this.pp.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", z);
                return;
            }
            if (NAMESPACE_PREFIXES_FEATURE.equals(str)) {
                if (this.pp.getFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES) != z) {
                    this.pp.setFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES, z);
                }
            } else if (VALIDATION_FEATURE.equals(str)) {
                this.pp.setFeature(XmlPullParser.FEATURE_VALIDATION, z);
            } else {
                this.pp.setFeature(str, z);
            }
        } catch (XmlPullParserException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("problem with setting feature ");
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(e);
            throw new SAXNotSupportedException(stringBuffer.toString());
        }
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (DECLARATION_HANDLER_PROPERTY.equals(str) || LEXICAL_HANDLER_PROPERTY.equals(str)) {
            return null;
        }
        return this.pp.getProperty(str);
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (DECLARATION_HANDLER_PROPERTY.equals(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("not supported setting property ");
            stringBuffer.append(str);
            throw new SAXNotSupportedException(stringBuffer.toString());
        }
        if (LEXICAL_HANDLER_PROPERTY.equals(str)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("not supported setting property ");
            stringBuffer2.append(str);
            throw new SAXNotSupportedException(stringBuffer2.toString());
        }
        try {
            this.pp.setProperty(str, obj);
        } catch (XmlPullParserException e) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("not supported set property ");
            stringBuffer3.append(str);
            stringBuffer3.append(": ");
            stringBuffer3.append(e);
            throw new SAXNotSupportedException(stringBuffer3.toString());
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws SAXException, IOException {
        this.systemId = inputSource.getSystemId();
        this.contentHandler.setDocumentLocator(this);
        Reader characterStream = inputSource.getCharacterStream();
        try {
            if (characterStream == null) {
                InputStream byteStream = inputSource.getByteStream();
                String encoding = inputSource.getEncoding();
                if (byteStream == null) {
                    String systemId = inputSource.getSystemId();
                    this.systemId = systemId;
                    if (systemId == null) {
                        this.errorHandler.fatalError(new SAXParseException("null source systemId", this));
                        return;
                    }
                    try {
                        try {
                            byteStream = FirebasePerfUrlConnection.openStream(new URL(this.systemId));
                        } catch (MalformedURLException unused) {
                            String str = this.systemId;
                            byteStream = SentryFileInputStream.Factory.create(new FileInputStream(str), str);
                        }
                    } catch (FileNotFoundException e) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("could not open file with systemId ");
                        stringBuffer.append(this.systemId);
                        this.errorHandler.fatalError(new SAXParseException(stringBuffer.toString(), this, e));
                        return;
                    }
                }
                this.pp.setInput(byteStream, encoding);
            } else {
                this.pp.setInput(characterStream);
            }
            try {
                this.contentHandler.startDocument();
                this.pp.next();
                if (this.pp.getEventType() != 2) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("expected start tag not");
                    stringBuffer2.append(this.pp.getPositionDescription());
                    this.errorHandler.fatalError(new SAXParseException(stringBuffer2.toString(), this));
                    return;
                }
                parseSubTree(this.pp);
                this.contentHandler.endDocument();
            } catch (XmlPullParserException e2) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("parsing initialization error: ");
                stringBuffer3.append(e2);
                this.errorHandler.fatalError(new SAXParseException(stringBuffer3.toString(), this, e2));
            }
        } catch (XmlPullParserException e3) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("parsing initialization error: ");
            stringBuffer4.append(e3);
            this.errorHandler.fatalError(new SAXParseException(stringBuffer4.toString(), this, e3));
        }
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws SAXException, IOException {
        parse(new InputSource(str));
    }

    public void parseSubTree(XmlPullParser xmlPullParser) throws SAXException, IOException {
        this.pp = xmlPullParser;
        boolean feature = xmlPullParser.getFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces");
        try {
            if (xmlPullParser.getEventType() != 2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("start tag must be read before skiping subtree");
                stringBuffer.append(xmlPullParser.getPositionDescription());
                throw new SAXException(stringBuffer.toString());
            }
            int[] iArr = new int[2];
            StringBuffer stringBuffer2 = new StringBuffer(16);
            int depth = xmlPullParser.getDepth() - 1;
            int next = 2;
            while (next != 1) {
                if (next != 2) {
                    if (next != 3) {
                        if (next == 4) {
                            this.contentHandler.characters(xmlPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                        }
                    } else if (feature) {
                        String name = xmlPullParser.getName();
                        String prefix = xmlPullParser.getPrefix();
                        if (prefix != null) {
                            stringBuffer2.setLength(0);
                            stringBuffer2.append(prefix);
                            stringBuffer2.append(CoreConstants.COLON_CHAR);
                            stringBuffer2.append(name);
                        }
                        this.contentHandler.endElement(xmlPullParser.getNamespace(), name, prefix != null ? name : stringBuffer2.toString());
                        int namespaceCount = depth > xmlPullParser.getDepth() ? xmlPullParser.getNamespaceCount(xmlPullParser.getDepth()) : 0;
                        for (int namespaceCount2 = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth() - 1) - 1; namespaceCount2 >= namespaceCount; namespaceCount2--) {
                            this.contentHandler.endPrefixMapping(xmlPullParser.getNamespacePrefix(namespaceCount2));
                        }
                    } else {
                        this.contentHandler.endElement(xmlPullParser.getNamespace(), xmlPullParser.getName(), xmlPullParser.getName());
                    }
                } else if (feature) {
                    int depth2 = xmlPullParser.getDepth();
                    int i = depth2 - 1;
                    int namespaceCount3 = xmlPullParser.getNamespaceCount(depth2);
                    for (int namespaceCount4 = depth > i ? xmlPullParser.getNamespaceCount(i) : 0; namespaceCount4 < namespaceCount3; namespaceCount4++) {
                        this.contentHandler.startPrefixMapping(xmlPullParser.getNamespacePrefix(namespaceCount4), xmlPullParser.getNamespaceUri(namespaceCount4));
                    }
                    String name2 = xmlPullParser.getName();
                    String prefix2 = xmlPullParser.getPrefix();
                    if (prefix2 != null) {
                        stringBuffer2.setLength(0);
                        stringBuffer2.append(prefix2);
                        stringBuffer2.append(CoreConstants.COLON_CHAR);
                        stringBuffer2.append(name2);
                    }
                    startElement(xmlPullParser.getNamespace(), name2, prefix2 != null ? name2 : stringBuffer2.toString());
                } else {
                    startElement(xmlPullParser.getNamespace(), xmlPullParser.getName(), xmlPullParser.getName());
                }
                next = xmlPullParser.next();
                if (xmlPullParser.getDepth() <= depth) {
                    return;
                }
            }
        } catch (XmlPullParserException e) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("parsing error: ");
            stringBuffer3.append(e);
            SAXParseException sAXParseException = new SAXParseException(stringBuffer3.toString(), this, e);
            e.printStackTrace();
            this.errorHandler.fatalError(sAXParseException);
        }
    }

    protected void startElement(String str, String str2, String str3) throws SAXException {
        this.contentHandler.startElement(str, str2, str3, this);
    }
}
