package com.bea.xml.stream.util;

import java.io.PrintStream;
import java.util.Iterator;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

/* JADX INFO: loaded from: classes4.dex */
public class NamespaceContextImpl implements NamespaceContext {
    SymbolTable prefixTable;
    NamespaceContext rootContext;
    SymbolTable uriTable;

    public NamespaceContextImpl() {
        this.prefixTable = new SymbolTable();
        this.uriTable = new SymbolTable();
        init();
    }

    public NamespaceContextImpl(NamespaceContext namespaceContext) {
        this.prefixTable = new SymbolTable();
        this.uriTable = new SymbolTable();
        this.rootContext = null;
        init();
    }

    public void init() {
        bindNamespace(XMLConstants.XML_NS_PREFIX, XMLConstants.XML_NS_URI);
        bindNamespace(XMLConstants.XMLNS_ATTRIBUTE, XMLConstants.XML_NS_URI);
    }

    public void openScope() {
        this.prefixTable.openScope();
        this.uriTable.openScope();
    }

    public void closeScope() {
        this.prefixTable.closeScope();
        this.uriTable.closeScope();
    }

    public void bindNamespace(String str, String str2) {
        this.prefixTable.put(str, str2);
        this.uriTable.put(str2, str);
    }

    public int getDepth() {
        return this.prefixTable.getDepth();
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        NamespaceContext namespaceContext;
        String str2 = this.prefixTable.get(str);
        return (str2 != null || (namespaceContext = this.rootContext) == null) ? str2 : namespaceContext.getNamespaceURI(str);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        NamespaceContext namespaceContext;
        String str2 = this.uriTable.get(str);
        return (str2 != null || (namespaceContext = this.rootContext) == null) ? str2 : namespaceContext.getPrefix(str);
    }

    public void bindDefaultNameSpace(String str) {
        bindNamespace("", str);
    }

    public void unbindDefaultNameSpace() {
        bindNamespace("", null);
    }

    public void unbindNamespace(String str, String str2) {
        this.prefixTable.put(str, null);
        this.prefixTable.put(str2, null);
    }

    public String getDefaultNameSpace() {
        return getNamespaceURI("");
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator getPrefixes(String str) {
        return this.uriTable.getAll(str).iterator();
    }

    public static void main(String[] strArr) throws Exception {
        NamespaceContextImpl namespaceContextImpl = new NamespaceContextImpl();
        namespaceContextImpl.openScope();
        namespaceContextImpl.bindNamespace("a", "uri");
        namespaceContextImpl.bindNamespace("b", "uri");
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a=");
        stringBuffer.append(namespaceContextImpl.getNamespaceURI("a"));
        printStream.println(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("uri=");
        stringBuffer2.append(namespaceContextImpl.getPrefix("uri"));
        printStream.println(stringBuffer2.toString());
        Iterator prefixes = namespaceContextImpl.getPrefixes("uri");
        while (prefixes.hasNext()) {
            PrintStream printStream2 = System.out;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("1 uri->");
            stringBuffer3.append(prefixes.next());
            printStream2.println(stringBuffer3.toString());
        }
        namespaceContextImpl.openScope();
        namespaceContextImpl.bindNamespace("a", "uri2");
        Iterator prefixes2 = namespaceContextImpl.getPrefixes("uri");
        while (prefixes2.hasNext()) {
            PrintStream printStream3 = System.out;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("2 uri->");
            stringBuffer4.append(prefixes2.next());
            printStream3.println(stringBuffer4.toString());
        }
        namespaceContextImpl.closeScope();
        namespaceContextImpl.closeScope();
    }
}
