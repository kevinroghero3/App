package com.transistorsoft.locationmanager.util;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TSTemplate {
    private final String a;

    public TSTemplate(String str) {
        this.a = str;
    }

    private static String a(String str) {
        return "VARIABLE_VALUE";
    }

    public String render(HashMap<String, String> map) throws Exception {
        StringReader stringReader = new StringReader(this.a);
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int i = stringReader.read();
            if (i == -1) {
                break;
            }
            if (i == 60) {
                int i2 = stringReader.read();
                if (i2 == -1) {
                    break;
                }
                if (i2 == 37) {
                    int i3 = stringReader.read();
                    if (i3 == -1) {
                        break;
                    }
                    if (i3 == 61) {
                        String strA = a(stringReader);
                        if (!map.containsKey(strA)) {
                            throw new IllegalArgumentException("Unknown template variable: " + strA);
                        }
                        stringWriter.append((CharSequence) map.get(strA));
                    } else {
                        stringWriter.write(i);
                        stringWriter.write(i2);
                        stringWriter.write(i3);
                    }
                } else {
                    stringWriter.write(i);
                    stringWriter.write(i2);
                }
            } else {
                stringWriter.write(i);
            }
        }
        return stringWriter.toString();
    }

    private static String a(Reader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = reader.read();
            if (i == -1) {
                throw new IllegalStateException("premature EOF.");
            }
            if (i == 37) {
                int i2 = reader.read();
                if (i2 == -1) {
                    throw new IllegalStateException("premature EOF.");
                }
                if (i2 == 62) {
                    return sb.toString().replace(StringUtils.SPACE, "");
                }
                sb.append((char) i2);
            }
            sb.append((char) i);
        }
    }
}
