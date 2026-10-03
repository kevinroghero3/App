package it.aep_italia.vts.sdk.utils;

import android.util.Base64;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.RegistryMatcher;
import org.simpleframework.xml.transform.Transform;

/* JADX INFO: loaded from: classes6.dex */
public class SerializationUtils {
    private static final DateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S z");
    private static Serializer b;

    class a extends AnnotationStrategy {
        a() {
        }

        @Override // org.simpleframework.xml.convert.AnnotationStrategy, org.simpleframework.xml.strategy.Strategy
        public boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap, Map map) throws Exception {
            boolean zWrite = super.write(type, obj, nodeMap, map);
            nodeMap.remove("class");
            return zWrite;
        }
    }

    static class b implements Transform<Date> {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // org.simpleframework.xml.transform.Transform
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String write(Date date) throws Exception {
            if (date == null) {
                return null;
            }
            return DateUtils.toISO8601(date);
        }

        @Override // org.simpleframework.xml.transform.Transform
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Date read(String str) throws Exception {
            if (StringUtils.isBlank(str)) {
                return null;
            }
            Date dateFromISO8601 = DateUtils.fromISO8601(str);
            if (dateFromISO8601 != null) {
                return dateFromISO8601;
            }
            try {
                return SerializationUtils.a.parse(str);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static <T> T deserializeFromXml(String str, Class<T> cls) {
        if (str == null || cls == null) {
            return null;
        }
        try {
            return (T) getXmlSerializer().read((Class) cls, str, false);
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_XML, e);
        }
    }

    public static <T> T deserializeFromXml(String str, T t) {
        if (str == null || t == null) {
            return null;
        }
        try {
            return (T) getXmlSerializer().read((Object) t, str, false);
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_XML, e);
        }
    }

    public static <T> T deserializeFromXml(byte[] bArr, Class<T> cls) {
        if (bArr == null || cls == null) {
            return null;
        }
        return (T) deserializeFromXml(new String(bArr, Charset.forName(CharEncoding.UTF_8)), (Class) cls);
    }

    public static <T> T deserializeFromXml(byte[] bArr, T t) {
        if (bArr == null || t == null) {
            return null;
        }
        return (T) deserializeFromXml(new String(bArr, Charset.forName(CharEncoding.UTF_8)), t);
    }

    public static <T> T deserializeFromXmlBase64(String str, Class<T> cls) {
        if (str == null || cls == null) {
            return null;
        }
        try {
            return (T) deserializeFromXml(fromBase64(str), (Class) cls);
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_XML, e);
        }
    }

    public static <T> T deserializeFromXmlBase64(byte[] bArr, Class<T> cls) {
        if (bArr == null || cls == null) {
            return null;
        }
        return (T) deserializeFromXmlBase64(new String(bArr, Charset.forName(CharEncoding.UTF_8)), cls);
    }

    public static byte[] fromBase64(String str) throws VtsException {
        if (str == null) {
            return null;
        }
        return fromBase64(str.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] fromBase64(byte[] bArr) throws VtsException {
        if (bArr == null) {
            return null;
        }
        try {
            return Base64.decode(bArr, 2);
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_DECODE_BASE64, e);
        }
    }

    public static String fromBase64String(String str) throws VtsException {
        byte[] bArrFromBase64 = fromBase64(str);
        if (bArrFromBase64 == null) {
            return null;
        }
        return new String(bArrFromBase64, StandardCharsets.UTF_8);
    }

    public static String fromBase64String(byte[] bArr) throws VtsException {
        byte[] bArrFromBase64 = fromBase64(bArr);
        if (bArrFromBase64 == null) {
            return null;
        }
        return new String(bArrFromBase64, StandardCharsets.UTF_8);
    }

    public static Serializer getXmlSerializer() {
        if (b == null) {
            RegistryMatcher registryMatcher = new RegistryMatcher();
            registryMatcher.bind(Date.class, new b(null));
            b = new Persister(new a(), registryMatcher, new Format(0));
        }
        return b;
    }

    public static String serializeToXml(Object obj) throws VtsException {
        if (obj == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            getXmlSerializer().write(obj, byteArrayOutputStream);
            byteArrayOutputStream.close();
            return new String(byteArrayOutputStream.toByteArray(), Charset.forName(CharEncoding.UTF_8));
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_XML, e);
        }
    }

    public static String serializeToXmlBase64(Object obj) {
        if (obj == null) {
            return null;
        }
        return toBase64String(serializeToXmlBytes(obj));
    }

    public static byte[] serializeToXmlBytes(Object obj) throws VtsException {
        if (obj == null) {
            return null;
        }
        return serializeToXml(obj).getBytes(Charset.forName(CharEncoding.UTF_8));
    }

    public static byte[] toBase64(String str) throws VtsException {
        if (str == null) {
            return null;
        }
        return toBase64(str.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] toBase64(byte[] bArr) throws VtsException {
        if (bArr == null) {
            return null;
        }
        try {
            return Base64.encode(bArr, 2);
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_ENCODE_BASE64, e);
        }
    }

    public static String toBase64String(String str) throws VtsException {
        byte[] base64 = toBase64(str);
        if (base64 == null) {
            return null;
        }
        return new String(base64, StandardCharsets.UTF_8);
    }

    public static String toBase64String(byte[] bArr) throws VtsException {
        byte[] base64 = toBase64(bArr);
        if (base64 == null) {
            return null;
        }
        return new String(base64, StandardCharsets.UTF_8);
    }
}
