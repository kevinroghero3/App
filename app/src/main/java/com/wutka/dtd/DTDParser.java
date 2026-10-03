package com.wutka.dtd;

import com.facebook.infer.annotation.ThreadConfined;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.sentry.instrumentation.file.SentryFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes6.dex */
public class DTDParser implements EntityExpansion {
    protected Object defaultLocation;
    protected DTD dtd;
    protected Scanner scanner;

    public DTDParser(Reader reader) {
        this.scanner = new Scanner(reader, false, this);
        this.dtd = new DTD();
    }

    public DTDParser(Reader reader, boolean z) {
        this.scanner = new Scanner(reader, z, this);
        this.dtd = new DTD();
    }

    public DTDParser(File file) throws IOException {
        this.defaultLocation = file.getParentFile();
        this.scanner = new Scanner(new BufferedReader(new SentryFileReader(file)), false, this);
        this.dtd = new DTD();
    }

    public DTDParser(File file, boolean z) throws IOException {
        this.defaultLocation = file.getParentFile();
        this.scanner = new Scanner(new BufferedReader(new SentryFileReader(file)), z, this);
        this.dtd = new DTD();
    }

    public DTDParser(URL url) throws IOException {
        String file = url.getFile();
        this.defaultLocation = new URL(url.getProtocol(), url.getHost(), url.getPort(), file.substring(0, file.lastIndexOf(47) + 1));
        this.scanner = new Scanner(new BufferedReader(new InputStreamReader(FirebasePerfUrlConnection.openStream(url))), false, this);
        this.dtd = new DTD();
    }

    public DTDParser(URL url, boolean z) throws IOException {
        String file = url.getFile();
        this.defaultLocation = new URL(url.getProtocol(), url.getHost(), url.getPort(), file.substring(0, file.lastIndexOf(47) + 1));
        this.scanner = new Scanner(new BufferedReader(new InputStreamReader(FirebasePerfUrlConnection.openStream(url))), z, this);
        this.dtd = new DTD();
    }

    public DTD parse() throws IOException {
        return parse(false);
    }

    public DTD parse(boolean z) throws IOException {
        while (this.scanner.peek().type != Scanner.EOF) {
            parseTopLevelElement();
        }
        if (z) {
            Hashtable hashtable = new Hashtable();
            Enumeration enumerationElements = this.dtd.elements.elements();
            while (enumerationElements.hasMoreElements()) {
                DTDElement dTDElement = (DTDElement) enumerationElements.nextElement();
                hashtable.put(dTDElement.name, dTDElement);
            }
            Enumeration enumerationElements2 = this.dtd.elements.elements();
            while (enumerationElements2.hasMoreElements()) {
                DTDItem dTDItem = ((DTDElement) enumerationElements2.nextElement()).content;
                if (dTDItem instanceof DTDContainer) {
                    Enumeration enumerationElements3 = ((DTDContainer) dTDItem).getItemsVec().elements();
                    while (enumerationElements3.hasMoreElements()) {
                        removeElements(hashtable, this.dtd, (DTDItem) enumerationElements3.nextElement());
                    }
                }
            }
            if (hashtable.size() == 1) {
                Enumeration enumerationElements4 = hashtable.elements();
                this.dtd.rootElement = (DTDElement) enumerationElements4.nextElement();
            } else {
                this.dtd.rootElement = null;
            }
        } else {
            this.dtd.rootElement = null;
        }
        return this.dtd;
    }

    protected void removeElements(Hashtable hashtable, DTD dtd, DTDItem dTDItem) {
        if (dTDItem instanceof DTDName) {
            hashtable.remove(((DTDName) dTDItem).value);
        } else if (dTDItem instanceof DTDContainer) {
            Enumeration enumerationElements = ((DTDContainer) dTDItem).getItemsVec().elements();
            while (enumerationElements.hasMoreElements()) {
                removeElements(hashtable, dtd, (DTDItem) enumerationElements.nextElement());
            }
        }
    }

    protected void parseTopLevelElement() throws IOException {
        Token token = this.scanner.get();
        TokenType tokenType = token.type;
        if (tokenType == Scanner.LTQUES) {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                stringBuffer.append(this.scanner.getUntil('?'));
                if (this.scanner.peek().type == Scanner.GT) {
                    this.scanner.get();
                    this.dtd.items.addElement(new DTDProcessingInstruction(stringBuffer.toString()));
                    return;
                }
                stringBuffer.append('?');
            }
        } else {
            if (tokenType == Scanner.CONDITIONAL) {
                Token tokenExpect = expect(Scanner.IDENTIFIER);
                if (tokenExpect.value.equals("IGNORE")) {
                    this.scanner.skipConditional();
                    return;
                }
                if (tokenExpect.value.equals("INCLUDE")) {
                    this.scanner.skipUntil('[');
                    return;
                }
                String uriId = this.scanner.getUriId();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid token in conditional: ");
                stringBuffer2.append(tokenExpect.value);
                throw new DTDParseException(uriId, stringBuffer2.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            if (tokenType == Scanner.ENDCONDITIONAL) {
                return;
            }
            if (tokenType == Scanner.COMMENT) {
                this.dtd.items.addElement(new DTDComment(token.value));
                return;
            }
            if (tokenType == Scanner.LTBANG) {
                Token tokenExpect2 = expect(Scanner.IDENTIFIER);
                if (tokenExpect2.value.equals("ELEMENT")) {
                    parseElement();
                    return;
                }
                if (tokenExpect2.value.equals("ATTLIST")) {
                    parseAttlist();
                    return;
                }
                if (tokenExpect2.value.equals("ENTITY")) {
                    parseEntity();
                    return;
                } else if (tokenExpect2.value.equals("NOTATION")) {
                    parseNotation();
                    return;
                } else {
                    skipUntil(Scanner.GT);
                    return;
                }
            }
            String uriId2 = this.scanner.getUriId();
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Unexpected token: ");
            stringBuffer3.append(token.type.name);
            stringBuffer3.append("(");
            stringBuffer3.append(token.value);
            stringBuffer3.append(")");
            throw new DTDParseException(uriId2, stringBuffer3.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
    }

    protected void skipUntil(TokenType tokenType) throws IOException {
        Token token = this.scanner.get();
        while (token.type != tokenType) {
            token = this.scanner.get();
        }
    }

    protected Token expect(TokenType tokenType) throws IOException {
        Token token = this.scanner.get();
        if (token.type == tokenType) {
            return token;
        }
        if (token.value == null) {
            String uriId = this.scanner.getUriId();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Expected ");
            stringBuffer.append(tokenType.name);
            stringBuffer.append(" instead of ");
            stringBuffer.append(token.type.name);
            throw new DTDParseException(uriId, stringBuffer.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        String uriId2 = this.scanner.getUriId();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Expected ");
        stringBuffer2.append(tokenType.name);
        stringBuffer2.append(" instead of ");
        stringBuffer2.append(token.type.name);
        stringBuffer2.append("(");
        stringBuffer2.append(token.value);
        stringBuffer2.append(")");
        throw new DTDParseException(uriId2, stringBuffer2.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
    }

    protected void parseElement() throws IOException {
        Token tokenExpect = expect(Scanner.IDENTIFIER);
        DTDElement dTDElement = (DTDElement) this.dtd.elements.get(tokenExpect.value);
        if (dTDElement == null) {
            dTDElement = new DTDElement(tokenExpect.value);
            this.dtd.elements.put(dTDElement.name, dTDElement);
        } else if (dTDElement.content != null) {
            String uriId = this.scanner.getUriId();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Found second definition of element: ");
            stringBuffer.append(tokenExpect.value);
            throw new DTDParseException(uriId, stringBuffer.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        this.dtd.items.addElement(dTDElement);
        parseContentSpec(this.scanner, dTDElement);
        expect(Scanner.GT);
    }

    protected void parseContentSpec(Scanner scanner, DTDElement dTDElement) throws IOException {
        Token token = scanner.get();
        TokenType tokenType = token.type;
        TokenType tokenType2 = Scanner.IDENTIFIER;
        if (tokenType == tokenType2) {
            if (token.value.equals("EMPTY")) {
                dTDElement.content = new DTDEmpty();
                return;
            }
            if (token.value.equals(ThreadConfined.ANY)) {
                dTDElement.content = new DTDAny();
                return;
            }
            String uriId = scanner.getUriId();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid token in entity content spec ");
            stringBuffer.append(token.value);
            throw new DTDParseException(uriId, stringBuffer.toString(), scanner.getLineNumber(), scanner.getColumn());
        }
        TokenType tokenType3 = Scanner.LPAREN;
        if (tokenType == tokenType3) {
            Token tokenPeek = scanner.peek();
            TokenType tokenType4 = tokenPeek.type;
            if (tokenType4 != tokenType2) {
                if (tokenType4 == tokenType3) {
                    parseChildren(dTDElement);
                }
            } else if (tokenPeek.value.equals("#PCDATA")) {
                parseMixed(dTDElement);
            } else {
                parseChildren(dTDElement);
            }
        }
    }

    protected void parseMixed(DTDElement dTDElement) throws IOException {
        DTDMixed dTDMixed = new DTDMixed();
        dTDMixed.add(new DTDPCData());
        this.scanner.get();
        dTDElement.content = dTDMixed;
        boolean z = true;
        while (true) {
            Token token = this.scanner.get();
            TokenType tokenType = token.type;
            if (tokenType == Scanner.RPAREN) {
                Token tokenPeek = this.scanner.peek();
                if (tokenPeek.type == Scanner.ASTERISK) {
                    this.scanner.get();
                    dTDMixed.cardinal = DTDCardinal.ZEROMANY;
                    return;
                } else {
                    if (!z) {
                        String uriId = this.scanner.getUriId();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Invalid token in Mixed content type, '*' required after (#PCDATA|xx ...): ");
                        stringBuffer.append(tokenPeek.type.name);
                        throw new DTDParseException(uriId, stringBuffer.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
                    }
                    dTDMixed.cardinal = DTDCardinal.NONE;
                    return;
                }
            }
            if (tokenType == Scanner.PIPE) {
                dTDMixed.add(new DTDName(this.scanner.get().value));
                z = false;
            } else {
                String uriId2 = this.scanner.getUriId();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid token in Mixed content type: ");
                stringBuffer2.append(token.type.name);
                throw new DTDParseException(uriId2, stringBuffer2.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
        }
    }

    protected void parseChildren(DTDElement dTDElement) throws IOException {
        DTDContainer choiceSequence = parseChoiceSequence();
        Token tokenPeek = this.scanner.peek();
        choiceSequence.cardinal = parseCardinality();
        TokenType tokenType = tokenPeek.type;
        if (tokenType == Scanner.QUES) {
            choiceSequence.cardinal = DTDCardinal.OPTIONAL;
        } else if (tokenType == Scanner.ASTERISK) {
            choiceSequence.cardinal = DTDCardinal.ZEROMANY;
        } else if (tokenType == Scanner.PLUS) {
            choiceSequence.cardinal = DTDCardinal.ONEMANY;
        } else {
            choiceSequence.cardinal = DTDCardinal.NONE;
        }
        dTDElement.content = choiceSequence;
    }

    protected DTDContainer parseChoiceSequence() throws IOException {
        DTDContainer dTDSequence;
        TokenType tokenType = null;
        DTDContainer dTDSequence2 = null;
        while (true) {
            DTDItem cp = parseCP();
            Token token = this.scanner.get();
            TokenType tokenType2 = token.type;
            TokenType tokenType3 = Scanner.PIPE;
            if (tokenType2 != tokenType3 && tokenType2 != Scanner.COMMA) {
                if (tokenType2 == Scanner.RPAREN) {
                    if (dTDSequence2 == null) {
                        dTDSequence2 = new DTDSequence();
                    }
                    dTDSequence2.add(cp);
                    return dTDSequence2;
                }
                String uriId = this.scanner.getUriId();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Found invalid token in sequence: ");
                stringBuffer.append(token.type.name);
                throw new DTDParseException(uriId, stringBuffer.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            if (tokenType != null && tokenType != tokenType2) {
                throw new DTDParseException(this.scanner.getUriId(), "Can't mix separators in a choice/sequence", this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            if (dTDSequence2 == null) {
                if (tokenType2 == tokenType3) {
                    dTDSequence = new DTDChoice();
                } else {
                    dTDSequence = new DTDSequence();
                }
                dTDSequence2 = dTDSequence;
            }
            dTDSequence2.add(cp);
            tokenType = tokenType2;
        }
    }

    protected DTDItem parseCP() throws IOException {
        DTDItem choiceSequence;
        Token token = this.scanner.get();
        TokenType tokenType = token.type;
        if (tokenType == Scanner.IDENTIFIER) {
            choiceSequence = new DTDName(token.value);
        } else if (tokenType == Scanner.LPAREN) {
            choiceSequence = parseChoiceSequence();
        } else {
            String uriId = this.scanner.getUriId();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Found invalid token in sequence: ");
            stringBuffer.append(token.type.name);
            throw new DTDParseException(uriId, stringBuffer.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        choiceSequence.cardinal = parseCardinality();
        return choiceSequence;
    }

    protected DTDCardinal parseCardinality() throws IOException {
        TokenType tokenType = this.scanner.peek().type;
        if (tokenType == Scanner.QUES) {
            this.scanner.get();
            return DTDCardinal.OPTIONAL;
        }
        if (tokenType == Scanner.ASTERISK) {
            this.scanner.get();
            return DTDCardinal.ZEROMANY;
        }
        if (tokenType == Scanner.PLUS) {
            this.scanner.get();
            return DTDCardinal.ONEMANY;
        }
        return DTDCardinal.NONE;
    }

    protected void parseAttlist() throws IOException {
        Token tokenExpect = expect(Scanner.IDENTIFIER);
        DTDElement dTDElement = (DTDElement) this.dtd.elements.get(tokenExpect.value);
        DTDAttlist dTDAttlist = new DTDAttlist(tokenExpect.value);
        this.dtd.items.addElement(dTDAttlist);
        if (dTDElement == null) {
            dTDElement = new DTDElement(tokenExpect.value);
            this.dtd.elements.put(tokenExpect.value, dTDElement);
        }
        Token tokenPeek = this.scanner.peek();
        while (true) {
            TokenType tokenType = tokenPeek.type;
            TokenType tokenType2 = Scanner.GT;
            if (tokenType != tokenType2) {
                parseAttdef(this.scanner, dTDElement, dTDAttlist);
                tokenPeek = this.scanner.peek();
            } else {
                expect(tokenType2);
                return;
            }
        }
    }

    protected void parseAttdef(Scanner scanner, DTDElement dTDElement, DTDAttlist dTDAttlist) throws IOException {
        TokenType tokenType = Scanner.IDENTIFIER;
        Token tokenExpect = expect(tokenType);
        DTDAttribute dTDAttribute = new DTDAttribute(tokenExpect.value);
        dTDAttlist.attributes.addElement(dTDAttribute);
        dTDElement.attributes.put(tokenExpect.value, dTDAttribute);
        Token token = scanner.get();
        TokenType tokenType2 = token.type;
        if (tokenType2 == tokenType) {
            if (token.value.equals("NOTATION")) {
                dTDAttribute.type = parseNotationList();
            } else {
                dTDAttribute.type = token.value;
            }
        } else if (tokenType2 == Scanner.LPAREN) {
            dTDAttribute.type = parseEnumeration();
        }
        Token tokenPeek = scanner.peek();
        TokenType tokenType3 = tokenPeek.type;
        if (tokenType3 == tokenType) {
            scanner.get();
            if (tokenPeek.value.equals("#FIXED")) {
                dTDAttribute.decl = DTDDecl.FIXED;
                dTDAttribute.defaultValue = scanner.get().value;
                return;
            } else {
                if (tokenPeek.value.equals("#REQUIRED")) {
                    dTDAttribute.decl = DTDDecl.REQUIRED;
                    return;
                }
                if (tokenPeek.value.equals("#IMPLIED")) {
                    dTDAttribute.decl = DTDDecl.IMPLIED;
                    return;
                }
                String uriId = scanner.getUriId();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid token in attribute declaration: ");
                stringBuffer.append(tokenPeek.value);
                throw new DTDParseException(uriId, stringBuffer.toString(), scanner.getLineNumber(), scanner.getColumn());
            }
        }
        if (tokenType3 == Scanner.STRING) {
            scanner.get();
            dTDAttribute.decl = DTDDecl.VALUE;
            dTDAttribute.defaultValue = tokenPeek.value;
        }
    }

    protected DTDNotationList parseNotationList() throws IOException {
        DTDNotationList dTDNotationList = new DTDNotationList();
        Token token = this.scanner.get();
        if (token.type != Scanner.LPAREN) {
            String uriId = this.scanner.getUriId();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid token in notation: ");
            stringBuffer.append(token.type.name);
            throw new DTDParseException(uriId, stringBuffer.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        while (true) {
            Token token2 = this.scanner.get();
            if (token2.type != Scanner.IDENTIFIER) {
                String uriId2 = this.scanner.getUriId();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid token in notation: ");
                stringBuffer2.append(token2.type.name);
                throw new DTDParseException(uriId2, stringBuffer2.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            dTDNotationList.add(token2.value);
            Token tokenPeek = this.scanner.peek();
            TokenType tokenType = tokenPeek.type;
            if (tokenType == Scanner.RPAREN) {
                this.scanner.get();
                return dTDNotationList;
            }
            if (tokenType != Scanner.PIPE) {
                String uriId3 = this.scanner.getUriId();
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Invalid token in notation: ");
                stringBuffer3.append(tokenPeek.type.name);
                throw new DTDParseException(uriId3, stringBuffer3.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            this.scanner.get();
        }
    }

    protected DTDEnumeration parseEnumeration() throws IOException {
        DTDEnumeration dTDEnumeration = new DTDEnumeration();
        while (true) {
            Token token = this.scanner.get();
            TokenType tokenType = token.type;
            if (tokenType != Scanner.IDENTIFIER && tokenType != Scanner.NMTOKEN) {
                String uriId = this.scanner.getUriId();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid token in enumeration: ");
                stringBuffer.append(token.type.name);
                throw new DTDParseException(uriId, stringBuffer.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            dTDEnumeration.add(token.value);
            Token tokenPeek = this.scanner.peek();
            TokenType tokenType2 = tokenPeek.type;
            if (tokenType2 == Scanner.RPAREN) {
                this.scanner.get();
                return dTDEnumeration;
            }
            if (tokenType2 != Scanner.PIPE) {
                String uriId2 = this.scanner.getUriId();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid token in enumeration: ");
                stringBuffer2.append(tokenPeek.type.name);
                throw new DTDParseException(uriId2, stringBuffer2.toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            this.scanner.get();
        }
    }

    protected void parseEntity() throws IOException {
        boolean z;
        DTDEntity dTDEntity;
        String str;
        Token tokenExpect = this.scanner.get();
        TokenType tokenType = tokenExpect.type;
        boolean z2 = false;
        if (tokenType == Scanner.PERCENT) {
            tokenExpect = expect(Scanner.IDENTIFIER);
            z = true;
        } else {
            if (tokenType != Scanner.IDENTIFIER) {
                throw new DTDParseException(this.scanner.getUriId(), "Invalid entity declaration", this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            z = false;
        }
        if (((DTDEntity) this.dtd.entities.get(tokenExpect.value)) == null) {
            dTDEntity = new DTDEntity(tokenExpect.value, this.defaultLocation);
            this.dtd.entities.put(dTDEntity.name, dTDEntity);
        } else {
            dTDEntity = new DTDEntity(tokenExpect.value, this.defaultLocation);
            z2 = true;
        }
        this.dtd.items.addElement(dTDEntity);
        dTDEntity.isParsed = z;
        parseEntityDef(dTDEntity);
        if (!dTDEntity.isParsed || (str = dTDEntity.value) == null || z2) {
            return;
        }
        this.scanner.addEntity(dTDEntity.name, str);
    }

    protected void parseEntityDef(DTDEntity dTDEntity) throws IOException {
        Token token = this.scanner.get();
        TokenType tokenType = token.type;
        TokenType tokenType2 = Scanner.STRING;
        if (tokenType == tokenType2) {
            if (dTDEntity.value == null) {
                dTDEntity.value = token.value;
            }
        } else {
            TokenType tokenType3 = Scanner.IDENTIFIER;
            if (tokenType == tokenType3) {
                if (token.value.equals("SYSTEM")) {
                    DTDSystem dTDSystem = new DTDSystem();
                    dTDSystem.system = expect(tokenType2).value;
                    dTDEntity.externalID = dTDSystem;
                } else if (token.value.equals("PUBLIC")) {
                    DTDPublic dTDPublic = new DTDPublic();
                    dTDPublic.pub = expect(tokenType2).value;
                    dTDPublic.system = expect(tokenType2).value;
                    dTDEntity.externalID = dTDPublic;
                } else {
                    throw new DTDParseException(this.scanner.getUriId(), "Invalid External ID specification", this.scanner.getLineNumber(), this.scanner.getColumn());
                }
                if (!dTDEntity.isParsed) {
                    Token tokenPeek = this.scanner.peek();
                    if (tokenPeek.type == tokenType3) {
                        if (!tokenPeek.value.equals("NDATA")) {
                            throw new DTDParseException(this.scanner.getUriId(), "Invalid NData declaration", this.scanner.getLineNumber(), this.scanner.getColumn());
                        }
                        this.scanner.get();
                        dTDEntity.ndata = expect(tokenType3).value;
                    }
                }
            } else {
                throw new DTDParseException(this.scanner.getUriId(), "Invalid entity definition", this.scanner.getLineNumber(), this.scanner.getColumn());
            }
        }
        expect(Scanner.GT);
    }

    protected void parseNotation() throws IOException {
        DTDNotation dTDNotation = new DTDNotation();
        TokenType tokenType = Scanner.IDENTIFIER;
        String str = expect(tokenType).value;
        dTDNotation.name = str;
        this.dtd.notations.put(str, dTDNotation);
        this.dtd.items.addElement(dTDNotation);
        Token tokenExpect = expect(tokenType);
        if (tokenExpect.value.equals("SYSTEM")) {
            DTDSystem dTDSystem = new DTDSystem();
            dTDSystem.system = expect(Scanner.STRING).value;
            dTDNotation.externalID = dTDSystem;
        } else if (tokenExpect.value.equals("PUBLIC")) {
            DTDPublic dTDPublic = new DTDPublic();
            TokenType tokenType2 = Scanner.STRING;
            dTDPublic.pub = expect(tokenType2).value;
            dTDPublic.system = null;
            if (this.scanner.peek().type == tokenType2) {
                dTDPublic.system = this.scanner.get().value;
            }
            dTDNotation.externalID = dTDPublic;
        }
        expect(Scanner.GT);
    }

    @Override // com.wutka.dtd.EntityExpansion
    public DTDEntity expandEntity(String str) {
        return (DTDEntity) this.dtd.entities.get(str);
    }
}
