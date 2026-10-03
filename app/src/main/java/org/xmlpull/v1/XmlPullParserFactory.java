package org.xmlpull.v1;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    static final Class referenceContextClass;
    protected String classNamesLocation;
    protected Hashtable features = new Hashtable();
    protected Vector parserClasses;
    protected Vector serializerClasses;

    static {
        new XmlPullParserFactory();
        referenceContextClass = XmlPullParserFactory.class;
    }

    protected XmlPullParserFactory() {
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        this.features.put(str, new Boolean(z));
    }

    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void setNamespaceAware(boolean z) {
        this.features.put("http://xmlpull.org/v1/doc/features.html#process-namespaces", new Boolean(z));
    }

    public boolean isNamespaceAware() {
        return getFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces");
    }

    public void setValidating(boolean z) {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, new Boolean(z));
    }

    public boolean isValidating() {
        return getFeature(XmlPullParser.FEATURE_VALIDATION);
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        Vector vector = this.parserClasses;
        if (vector == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Factory initialization was incomplete - has not tried ");
            stringBuffer.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer.toString());
        }
        if (vector.size() == 0) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No valid parser classes found in ");
            stringBuffer2.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer2.toString());
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i = 0; i < this.parserClasses.size(); i++) {
            Class cls = (Class) this.parserClasses.elementAt(i);
            try {
                XmlPullParser xmlPullParser = (XmlPullParser) cls.newInstance();
                Enumeration enumerationKeys = this.features.keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str = (String) enumerationKeys.nextElement();
                    Boolean bool = (Boolean) this.features.get(str);
                    if (bool != null && bool.booleanValue()) {
                        xmlPullParser.setFeature(str, true);
                    }
                }
                return xmlPullParser;
            } catch (Exception e) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(cls.getName());
                stringBuffer4.append(": ");
                stringBuffer4.append(e.toString());
                stringBuffer4.append("; ");
                stringBuffer3.append(stringBuffer4.toString());
            }
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("could not create parser: ");
        stringBuffer5.append((Object) stringBuffer3);
        throw new XmlPullParserException(stringBuffer5.toString());
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        Vector vector = this.serializerClasses;
        if (vector == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Factory initialization incomplete - has not tried ");
            stringBuffer.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer.toString());
        }
        if (vector.size() == 0) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No valid serializer classes found in ");
            stringBuffer2.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer2.toString());
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i = 0; i < this.serializerClasses.size(); i++) {
            Class cls = (Class) this.serializerClasses.elementAt(i);
            try {
                return (XmlSerializer) cls.newInstance();
            } catch (Exception e) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(cls.getName());
                stringBuffer4.append(": ");
                stringBuffer4.append(e.toString());
                stringBuffer4.append("; ");
                stringBuffer3.append(stringBuffer4.toString());
            }
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("could not create serializer: ");
        stringBuffer5.append((Object) stringBuffer3);
        throw new XmlPullParserException(stringBuffer5.toString());
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    public static XmlPullParserFactory newInstance(String str, Class cls) throws XmlPullParserException {
        String string;
        Class<?> cls2;
        Object objNewInstance;
        boolean z;
        if (cls == null) {
            cls = referenceContextClass;
        }
        if (str == null || str.length() == 0 || "DEFAULT".equals(str)) {
            try {
                InputStream resourceAsStream = cls.getResourceAsStream(RESOURCE_NAME);
                if (resourceAsStream == null) {
                    throw new XmlPullParserException("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i = resourceAsStream.read();
                    if (i < 0) {
                        break;
                    }
                    if (i > 32) {
                        stringBuffer.append((char) i);
                    }
                }
                resourceAsStream.close();
                str = stringBuffer.toString();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '");
                stringBuffer2.append(str);
                stringBuffer2.append("'");
                string = stringBuffer2.toString();
            } catch (Exception e) {
                throw new XmlPullParserException(null, null, e);
            }
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("parameter classNames to newInstance() that contained '");
            stringBuffer3.append(str);
            stringBuffer3.append("'");
            string = stringBuffer3.toString();
        }
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        XmlPullParserFactory xmlPullParserFactory = null;
        int i2 = 0;
        while (i2 < str.length()) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            String strSubstring = str.substring(i2, iIndexOf);
            try {
                cls2 = Class.forName(strSubstring);
                try {
                    objNewInstance = cls2.newInstance();
                } catch (Exception unused) {
                    objNewInstance = null;
                }
            } catch (Exception unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                boolean z2 = true;
                if (objNewInstance instanceof XmlPullParser) {
                    vector.addElement(cls2);
                    z = true;
                } else {
                    z = false;
                }
                if (objNewInstance instanceof XmlSerializer) {
                    vector2.addElement(cls2);
                    z = true;
                }
                if (!(objNewInstance instanceof XmlPullParserFactory)) {
                    z2 = z;
                } else if (xmlPullParserFactory == null) {
                    xmlPullParserFactory = (XmlPullParserFactory) objNewInstance;
                }
                if (!z2) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("incompatible class: ");
                    stringBuffer4.append(strSubstring);
                    throw new XmlPullParserException(stringBuffer4.toString());
                }
            }
            i2 = iIndexOf + 1;
        }
        if (xmlPullParserFactory == null) {
            xmlPullParserFactory = new XmlPullParserFactory();
        }
        xmlPullParserFactory.parserClasses = vector;
        xmlPullParserFactory.serializerClasses = vector2;
        xmlPullParserFactory.classNamesLocation = string;
        return xmlPullParserFactory;
    }
}
