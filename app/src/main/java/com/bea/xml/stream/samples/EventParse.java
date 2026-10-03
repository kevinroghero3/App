package com.bea.xml.stream.samples;

import com.bea.xml.stream.XMLEventAllocatorBase;
import com.bea.xml.stream.util.ElementTypeNames;
import io.sentry.instrumentation.file.SentryFileReader;
import java.io.PrintStream;
import java.util.Iterator;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Namespace;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public class EventParse {
    private static String filename;

    private static void printUsage() {
        System.out.println("usage: java com.bea.xml.stream.samples.EventParse <xmlfile>");
    }

    public static void main(String[] strArr) throws Exception {
        try {
            filename = strArr[0];
        } catch (ArrayIndexOutOfBoundsException unused) {
            printUsage();
            System.exit(0);
        }
        System.setProperty("javax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
        XMLInputFactory xMLInputFactoryNewInstance = XMLInputFactory.newInstance();
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FACTORY: ");
        stringBuffer.append(xMLInputFactoryNewInstance);
        printStream.println(stringBuffer.toString());
        xMLInputFactoryNewInstance.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.FALSE);
        XMLStreamReader xMLStreamReaderCreateXMLStreamReader = xMLInputFactoryNewInstance.createXMLStreamReader(new SentryFileReader(filename));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("READER:  ");
        stringBuffer2.append(xMLStreamReaderCreateXMLStreamReader);
        stringBuffer2.append("\n");
        printStream.println(stringBuffer2.toString());
        while (xMLStreamReaderCreateXMLStreamReader.hasNext()) {
            printEvent(xMLStreamReaderCreateXMLStreamReader);
            xMLStreamReaderCreateXMLStreamReader.next();
        }
    }

    public static final String getEventTypeString(int i) {
        return ElementTypeNames.getEventTypeString(i);
    }

    private static void printEvent(XMLStreamReader xMLStreamReader) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EVENT:[");
        stringBuffer.append(xMLStreamReader.getLocation().getLineNumber());
        stringBuffer.append("][");
        stringBuffer.append(xMLStreamReader.getLocation().getColumnNumber());
        stringBuffer.append("] ");
        printStream.print(stringBuffer.toString());
        printStream.print(getEventTypeString(xMLStreamReader.getEventType()));
        printStream.print(" [");
        int eventType = xMLStreamReader.getEventType();
        if (eventType == 9) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(xMLStreamReader.getLocalName());
            stringBuffer2.append("=");
            printStream.print(stringBuffer2.toString());
            if (xMLStreamReader.hasText()) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[");
                stringBuffer3.append(xMLStreamReader.getText());
                stringBuffer3.append("]");
                printStream.print(stringBuffer3.toString());
            }
        } else if (eventType != 12) {
            switch (eventType) {
                case 1:
                    printStream.print("<");
                    printName(xMLStreamReader);
                    printNamespaces(XMLEventAllocatorBase.getNamespaces(xMLStreamReader));
                    printAttributes(xMLStreamReader);
                    printStream.print(">");
                    break;
                case 2:
                    printStream.print("</");
                    printName(xMLStreamReader);
                    printNamespaces(XMLEventAllocatorBase.getNamespaces(xMLStreamReader));
                    printStream.print(">");
                    break;
                case 3:
                    printStream.print("<?");
                    if (xMLStreamReader.hasText()) {
                        printStream.print(xMLStreamReader.getText());
                    }
                    printStream.print("?>");
                    break;
                case 4:
                case 6:
                    printStream.print(new String(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength()));
                    break;
                case 5:
                    printStream.print("<!--");
                    if (xMLStreamReader.hasText()) {
                        printStream.print(xMLStreamReader.getText());
                    }
                    printStream.print("-->");
                    break;
                case 7:
                    printStream.print("<?xml");
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(" version='");
                    stringBuffer4.append(xMLStreamReader.getVersion());
                    stringBuffer4.append("'");
                    printStream.print(stringBuffer4.toString());
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(" encoding='");
                    stringBuffer5.append(xMLStreamReader.getCharacterEncodingScheme());
                    stringBuffer5.append("'");
                    printStream.print(stringBuffer5.toString());
                    if (xMLStreamReader.isStandalone()) {
                        printStream.print(" standalone='yes'");
                    } else {
                        printStream.print(" standalone='no'");
                    }
                    printStream.print("?>");
                    break;
            }
        } else {
            printStream.print("<![CDATA[");
            if (xMLStreamReader.hasText()) {
                printStream.print(xMLStreamReader.getText());
            }
            printStream.print("]]>");
        }
        printStream.println("]");
    }

    private static void printEventType(int i) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EVENT TYPE(");
        stringBuffer.append(i);
        stringBuffer.append("):");
        printStream.print(stringBuffer.toString());
        printStream.println(getEventTypeString(i));
    }

    private static void printName(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.hasName()) {
            printName(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName());
        }
    }

    private static void printName(String str, String str2, String str3) {
        if (str2 != null && !"".equals(str2)) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("['");
            stringBuffer.append(str2);
            stringBuffer.append("']:");
            printStream.print(stringBuffer.toString());
        }
        if (str != null) {
            PrintStream printStream2 = System.out;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append(":");
            printStream2.print(stringBuffer2.toString());
        }
        if (str3 != null) {
            System.out.print(str3);
        }
    }

    private static void printValue(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.hasText()) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("HAS VALUE: ");
            stringBuffer.append(xMLStreamReader.getText());
            printStream.println(stringBuffer.toString());
            return;
        }
        System.out.println("HAS NO VALUE");
    }

    private static void printAttributes(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.getAttributeCount() > 0) {
            Iterator attributes = XMLEventAllocatorBase.getAttributes(xMLStreamReader);
            while (attributes.hasNext()) {
                System.out.print(StringUtils.SPACE);
                printAttribute((Attribute) attributes.next());
            }
        }
    }

    private static void printAttribute(Attribute attribute) {
        printName(attribute.getName().getPrefix(), attribute.getName().getNamespaceURI(), attribute.getName().getLocalPart());
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("='");
        stringBuffer.append(attribute.getValue());
        stringBuffer.append("'");
        printStream.print(stringBuffer.toString());
    }

    private static void printNamespaces(Iterator it2) {
        while (it2.hasNext()) {
            System.out.print(StringUtils.SPACE);
            printNamespace((Namespace) it2.next());
        }
    }

    private static void printNamespace(Namespace namespace) {
        if (namespace.isDefaultNamespaceDeclaration()) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("xmlns='");
            stringBuffer.append(namespace.getNamespaceURI());
            stringBuffer.append("'");
            printStream.print(stringBuffer.toString());
            return;
        }
        PrintStream printStream2 = System.out;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("xmlns:");
        stringBuffer2.append(namespace.getPrefix());
        stringBuffer2.append("='");
        stringBuffer2.append(namespace.getNamespaceURI());
        stringBuffer2.append("'");
        printStream2.print(stringBuffer2.toString());
    }
}
