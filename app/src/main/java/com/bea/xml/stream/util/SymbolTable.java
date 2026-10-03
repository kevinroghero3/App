package com.bea.xml.stream.util;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SymbolTable {
    private int depth = 0;
    private Stack table = new Stack();
    private Map values = new HashMap();

    public void clear() {
        this.depth = 0;
        this.table.clear();
        this.values.clear();
    }

    public int getDepth() {
        return this.depth;
    }

    public boolean withinElement() {
        return this.depth > 0;
    }

    public void put(String str, String str2) {
        this.table.push(new Symbol(str, str2, this.depth));
        if (!this.values.containsKey(str)) {
            Stack stack = new Stack();
            stack.push(str2);
            this.values.put(str, stack);
            return;
        }
        ((Stack) this.values.get(str)).push(str2);
    }

    public String get(String str) {
        Stack stack = (Stack) this.values.get(str);
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return (String) stack.peek();
    }

    public Set getAll(String str) {
        HashSet hashSet = new HashSet();
        for (Symbol symbol : this.table) {
            if (str.equals(symbol.getName())) {
                hashSet.add(symbol.getValue());
            }
        }
        return hashSet;
    }

    public void openScope() {
        this.depth++;
    }

    public void closeScope() {
        int i = ((Symbol) this.table.peek()).depth;
        while (i == this.depth && !this.table.isEmpty()) {
            ((Stack) this.values.get(((Symbol) this.table.pop()).name)).pop();
            if (this.table.isEmpty()) {
                break;
            } else {
                i = ((Symbol) this.table.peek()).depth;
            }
        }
        this.depth--;
    }

    public String toString() {
        String string = "";
        for (Symbol symbol : this.table) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(string);
            stringBuffer.append(symbol);
            stringBuffer.append("\n");
            string = stringBuffer.toString();
        }
        return string;
    }

    public static void main(String[] strArr) throws Exception {
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.openScope();
        symbolTable.put("x", "foo");
        symbolTable.put("y", "bar");
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1 x:");
        stringBuffer.append(symbolTable.get("x"));
        printStream.println(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("1 y:");
        stringBuffer2.append(symbolTable.get("y"));
        printStream.println(stringBuffer2.toString());
        symbolTable.openScope();
        symbolTable.put("x", "bar");
        symbolTable.put("y", "foo");
        symbolTable.openScope();
        symbolTable.put("x", "barbie");
        symbolTable.openScope();
        symbolTable.closeScope();
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("3 x:");
        stringBuffer3.append(symbolTable.get("x"));
        printStream.println(stringBuffer3.toString());
        symbolTable.closeScope();
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("2 x:");
        stringBuffer4.append(symbolTable.get("x"));
        printStream.println(stringBuffer4.toString());
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("2 y:");
        stringBuffer5.append(symbolTable.get("y"));
        printStream.println(stringBuffer5.toString());
        printStream.print(symbolTable);
        symbolTable.closeScope();
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("1 x:");
        stringBuffer6.append(symbolTable.get("x"));
        printStream.println(stringBuffer6.toString());
        StringBuffer stringBuffer7 = new StringBuffer();
        stringBuffer7.append("1 y:");
        stringBuffer7.append(symbolTable.get("y"));
        printStream.println(stringBuffer7.toString());
        symbolTable.closeScope();
        printStream.print(symbolTable);
    }
}
