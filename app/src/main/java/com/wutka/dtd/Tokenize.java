package com.wutka.dtd;

import ch.qos.logback.classic.spi.CallerData;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.Enumeration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
class Tokenize {
    Tokenize() {
    }

    public static void main(String[] strArr) {
        DTDParser dTDParser;
        try {
            if (strArr[0].indexOf("://") > 0) {
                dTDParser = new DTDParser(new URL(strArr[0]), true);
            } else {
                dTDParser = new DTDParser(new File(strArr[0]), true);
            }
            DTD dtd = dTDParser.parse(true);
            if (dtd.rootElement != null) {
                PrintStream printStream = System.out;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Root element is probably: ");
                stringBuffer.append(dtd.rootElement.name);
                printStream.println(stringBuffer.toString());
            }
            Enumeration enumerationElements = dtd.elements.elements();
            while (enumerationElements.hasMoreElements()) {
                DTDElement dTDElement = (DTDElement) enumerationElements.nextElement();
                PrintStream printStream2 = System.out;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Element: ");
                stringBuffer2.append(dTDElement.name);
                printStream2.println(stringBuffer2.toString());
                printStream2.print("   Content: ");
                dumpDTDItem(dTDElement.content);
                printStream2.println();
                if (dTDElement.attributes.size() > 0) {
                    printStream2.println("   Attributes: ");
                    Enumeration enumerationElements2 = dTDElement.attributes.elements();
                    while (enumerationElements2.hasMoreElements()) {
                        System.out.print("        ");
                        dumpAttribute((DTDAttribute) enumerationElements2.nextElement());
                    }
                    System.out.println();
                }
            }
            Enumeration enumerationElements3 = dtd.entities.elements();
            while (enumerationElements3.hasMoreElements()) {
                DTDEntity dTDEntity = (DTDEntity) enumerationElements3.nextElement();
                if (dTDEntity.isParsed) {
                    System.out.print("Parsed ");
                }
                PrintStream printStream3 = System.out;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Entity: ");
                stringBuffer3.append(dTDEntity.name);
                printStream3.println(stringBuffer3.toString());
                if (dTDEntity.value != null) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("    Value: ");
                    stringBuffer4.append(dTDEntity.value);
                    printStream3.println(stringBuffer4.toString());
                }
                DTDExternalID dTDExternalID = dTDEntity.externalID;
                if (dTDExternalID != null) {
                    if (dTDExternalID instanceof DTDSystem) {
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("    System: ");
                        stringBuffer5.append(dTDEntity.externalID.system);
                        printStream3.println(stringBuffer5.toString());
                    } else {
                        DTDPublic dTDPublic = (DTDPublic) dTDExternalID;
                        StringBuffer stringBuffer6 = new StringBuffer();
                        stringBuffer6.append("    Public: ");
                        stringBuffer6.append(dTDPublic.pub);
                        stringBuffer6.append(StringUtils.SPACE);
                        stringBuffer6.append(dTDPublic.system);
                        printStream3.println(stringBuffer6.toString());
                    }
                }
                if (dTDEntity.ndata != null) {
                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append("    NDATA ");
                    stringBuffer7.append(dTDEntity.ndata);
                    printStream3.println(stringBuffer7.toString());
                }
            }
            Enumeration enumerationElements4 = dtd.notations.elements();
            while (enumerationElements4.hasMoreElements()) {
                DTDNotation dTDNotation = (DTDNotation) enumerationElements4.nextElement();
                PrintStream printStream4 = System.out;
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append("Notation: ");
                stringBuffer8.append(dTDNotation.name);
                printStream4.println(stringBuffer8.toString());
                DTDExternalID dTDExternalID2 = dTDNotation.externalID;
                if (dTDExternalID2 != null) {
                    if (dTDExternalID2 instanceof DTDSystem) {
                        StringBuffer stringBuffer9 = new StringBuffer();
                        stringBuffer9.append("    System: ");
                        stringBuffer9.append(dTDNotation.externalID.system);
                        printStream4.println(stringBuffer9.toString());
                    } else {
                        DTDPublic dTDPublic2 = (DTDPublic) dTDExternalID2;
                        StringBuffer stringBuffer10 = new StringBuffer();
                        stringBuffer10.append("    Public: ");
                        stringBuffer10.append(dTDPublic2.pub);
                        stringBuffer10.append(StringUtils.SPACE);
                        printStream4.print(stringBuffer10.toString());
                        String str = dTDPublic2.system;
                        if (str != null) {
                            printStream4.println(str);
                        } else {
                            printStream4.println();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void dumpDTDItem(DTDItem dTDItem) {
        if (dTDItem == null) {
            return;
        }
        if (dTDItem instanceof DTDAny) {
            System.out.print(LocationAuthorization.AUTHORIZATION_REQUEST_ANY);
        } else if (dTDItem instanceof DTDEmpty) {
            System.out.print("Empty");
        } else if (dTDItem instanceof DTDName) {
            System.out.print(((DTDName) dTDItem).value);
        } else {
            int i = 0;
            if (dTDItem instanceof DTDChoice) {
                System.out.print("(");
                DTDItem[] items = ((DTDChoice) dTDItem).getItems();
                while (i < items.length) {
                    if (i > 0) {
                        System.out.print("|");
                    }
                    dumpDTDItem(items[i]);
                    i++;
                }
                System.out.print(")");
            } else if (dTDItem instanceof DTDSequence) {
                System.out.print("(");
                DTDItem[] items2 = ((DTDSequence) dTDItem).getItems();
                while (i < items2.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    dumpDTDItem(items2[i]);
                    i++;
                }
                System.out.print(")");
            } else if (dTDItem instanceof DTDMixed) {
                System.out.print("(");
                DTDItem[] items3 = ((DTDMixed) dTDItem).getItems();
                while (i < items3.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    dumpDTDItem(items3[i]);
                    i++;
                }
                System.out.print(")");
            } else if (dTDItem instanceof DTDPCData) {
                System.out.print("#PCDATA");
            }
        }
        DTDCardinal dTDCardinal = dTDItem.cardinal;
        if (dTDCardinal == DTDCardinal.OPTIONAL) {
            System.out.print(CallerData.NA);
        } else if (dTDCardinal == DTDCardinal.ZEROMANY) {
            System.out.print("*");
        } else if (dTDCardinal == DTDCardinal.ONEMANY) {
            System.out.print(Marker.ANY_NON_NULL_MARKER);
        }
    }

    public static void dumpAttribute(DTDAttribute dTDAttribute) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(dTDAttribute.name);
        stringBuffer.append(StringUtils.SPACE);
        printStream.print(stringBuffer.toString());
        Object obj = dTDAttribute.type;
        if (obj instanceof String) {
            printStream.print(obj);
        } else {
            int i = 0;
            if (obj instanceof DTDEnumeration) {
                printStream.print("(");
                String[] items = ((DTDEnumeration) dTDAttribute.type).getItems();
                while (i < items.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    System.out.print(items[i]);
                    i++;
                }
                System.out.print(")");
            } else if (obj instanceof DTDNotationList) {
                printStream.print("Notation (");
                String[] items2 = ((DTDNotationList) dTDAttribute.type).getItems();
                while (i < items2.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    System.out.print(items2[i]);
                    i++;
                }
                System.out.print(")");
            }
        }
        if (dTDAttribute.decl != null) {
            PrintStream printStream2 = System.out;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(StringUtils.SPACE);
            stringBuffer2.append(dTDAttribute.decl.name);
            printStream2.print(stringBuffer2.toString());
        }
        if (dTDAttribute.defaultValue != null) {
            PrintStream printStream3 = System.out;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(StringUtils.SPACE);
            stringBuffer3.append(dTDAttribute.defaultValue);
            printStream3.print(stringBuffer3.toString());
        }
        System.out.println();
    }
}
