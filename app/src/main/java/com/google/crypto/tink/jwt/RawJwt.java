package com.google.crypto.tink.jwt;

import com.google.crypto.tink.jwt.internal.JsonUtil;
import com.google.crypto.tink.jwt.internal.JwtNames;
import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final JsonObject payload;
    private final Optional<String> typeHeader;

    private RawJwt(Builder builder) {
        if (!builder.payload.has("exp") && !builder.withoutExpiration) {
            throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
        }
        if (builder.payload.has("exp") && builder.withoutExpiration) {
            throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
        }
        this.typeHeader = builder.typeHeader;
        this.payload = builder.payload.deepCopy();
    }

    private RawJwt(Optional<String> optional, String str) throws JwtInvalidException {
        this.typeHeader = optional;
        this.payload = JsonUtil.parseJson(str);
        validateStringClaim("iss");
        validateStringClaim("sub");
        validateStringClaim("jti");
        validateTimestampClaim("exp");
        validateTimestampClaim(JwtNames.CLAIM_NOT_BEFORE);
        validateTimestampClaim("iat");
        validateAudienceClaim();
    }

    private void validateStringClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString()) {
                return;
            }
            throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a string.");
        }
    }

    private void validateTimestampClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a number.");
            }
            double asDouble = this.payload.get(str).getAsJsonPrimitive().getAsDouble();
            if (asDouble > 2.53402300799E11d || asDouble < 0.0d) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " has an invalid timestamp");
            }
        }
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.payload.has("aud")) {
            if (!(this.payload.get("aud").isJsonPrimitive() && this.payload.get("aud").getAsJsonPrimitive().isString()) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    static RawJwt fromJsonPayload(Optional<String> optional, String str) throws JwtInvalidException {
        return new RawJwt(optional, str);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private final JsonObject payload;
        private Optional<String> typeHeader;
        private boolean withoutExpiration;

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.payload = new JsonObject();
        }

        public Builder setTypeHeader(String str) {
            this.typeHeader = Optional.of(str);
            return this;
        }

        public Builder setIssuer(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add("iss", new JsonPrimitive(str));
            return this;
        }

        public Builder setSubject(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add("sub", new JsonPrimitive(str));
            return this;
        }

        public Builder setAudience(String str) {
            if (this.payload.has("aud") && this.payload.get("aud").isJsonArray()) {
                throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
            }
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            this.payload.add("aud", new JsonPrimitive(str));
            return this;
        }

        public Builder setAudiences(List<String> list) {
            if (this.payload.has("aud") && !this.payload.get("aud").isJsonArray()) {
                throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
            }
            if (list.isEmpty()) {
                throw new IllegalArgumentException("audiences must not be empty");
            }
            JsonArray jsonArray = new JsonArray();
            for (String str : list) {
                if (!JsonUtil.isValidString(str)) {
                    throw new IllegalArgumentException("invalid string");
                }
                jsonArray.add(str);
            }
            this.payload.add("aud", jsonArray);
            return this;
        }

        public Builder addAudience(String str) {
            JsonArray jsonArray;
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            if (this.payload.has("aud")) {
                JsonElement jsonElement = this.payload.get("aud");
                if (!jsonElement.isJsonArray()) {
                    throw new IllegalArgumentException("addAudience can't be used together with setAudience");
                }
                jsonArray = jsonElement.getAsJsonArray();
            } else {
                jsonArray = new JsonArray();
            }
            jsonArray.add(str);
            this.payload.add("aud", jsonArray);
            return this;
        }

        public Builder setJwtId(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add("jti", new JsonPrimitive(str));
            return this;
        }

        private void setTimestampClaim(String str, Instant instant) {
            long epochSecond = instant.getEpochSecond();
            if (epochSecond > RawJwt.MAX_TIMESTAMP_VALUE || epochSecond < 0) {
                throw new IllegalArgumentException("timestamp of claim " + str + " is out of range");
            }
            this.payload.add(str, new JsonPrimitive(Long.valueOf(epochSecond)));
        }

        public Builder setExpiration(Instant instant) {
            setTimestampClaim("exp", instant);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }

        public Builder setNotBefore(Instant instant) {
            setTimestampClaim(JwtNames.CLAIM_NOT_BEFORE, instant);
            return this;
        }

        public Builder setIssuedAt(Instant instant) {
            setTimestampClaim("iat", instant);
            return this;
        }

        public Builder addBooleanClaim(String str, boolean z) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Boolean.valueOf(z)));
            return this;
        }

        public Builder addNumberClaim(String str, long j) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Long.valueOf(j)));
            return this;
        }

        public Builder addNumberClaim(String str, double d) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Double.valueOf(d)));
            return this;
        }

        public Builder addStringClaim(String str, String str2) {
            if (!JsonUtil.isValidString(str2)) {
                throw new IllegalArgumentException();
            }
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(str2));
            return this;
        }

        public Builder addNullClaim(String str) {
            JwtNames.validate(str);
            this.payload.add(str, JsonNull.INSTANCE);
            return this;
        }

        public Builder addJsonObjectClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJson(str2));
            return this;
        }

        public Builder addJsonArrayClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJsonArray(str2));
            return this;
        }

        public RawJwt build() {
            return new RawJwt(this);
        }
    }

    public String getJsonPayload() {
        return this.payload.toString();
    }

    public boolean hasBooleanClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean();
    }

    public Boolean getBooleanClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isBoolean()) {
            throw new JwtInvalidException("claim " + str + " is not a boolean");
        }
        return Boolean.valueOf(this.payload.get(str).getAsBoolean());
    }

    public boolean hasNumberClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber();
    }

    public Double getNumberClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + str + " is not a number");
        }
        return Double.valueOf(this.payload.get(str).getAsDouble());
    }

    public boolean hasStringClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString();
    }

    public String getStringClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        return getStringClaimInternal(str);
    }

    private String getStringClaimInternal(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isString()) {
            throw new JwtInvalidException("claim " + str + " is not a string");
        }
        return this.payload.get(str).getAsString();
    }

    public boolean isNullClaim(String str) {
        JwtNames.validate(str);
        try {
            return JsonNull.INSTANCE.equals(this.payload.get(str));
        } catch (JsonParseException unused) {
            return false;
        }
    }

    public boolean hasJsonObjectClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonObject();
    }

    public String getJsonObjectClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonObject()) {
            throw new JwtInvalidException("claim " + str + " is not a JSON object");
        }
        return this.payload.get(str).getAsJsonObject().toString();
    }

    public boolean hasJsonArrayClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonArray();
    }

    public String getJsonArrayClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonArray()) {
            throw new JwtInvalidException("claim " + str + " is not a JSON array");
        }
        return this.payload.get(str).getAsJsonArray().toString();
    }

    public boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    public String getTypeHeader() throws JwtInvalidException {
        if (!this.typeHeader.isPresent()) {
            throw new JwtInvalidException("type header is not set");
        }
        return this.typeHeader.get();
    }

    public boolean hasIssuer() {
        return this.payload.has("iss");
    }

    public String getIssuer() throws JwtInvalidException {
        return getStringClaimInternal("iss");
    }

    public boolean hasSubject() {
        return this.payload.has("sub");
    }

    public String getSubject() throws JwtInvalidException {
        return getStringClaimInternal("sub");
    }

    public boolean hasJwtId() {
        return this.payload.has("jti");
    }

    public String getJwtId() throws JwtInvalidException {
        return getStringClaimInternal("jti");
    }

    public boolean hasAudiences() {
        return this.payload.has("aud");
    }

    public List<String> getAudiences() throws JwtInvalidException {
        if (!hasAudiences()) {
            throw new JwtInvalidException("claim aud does not exist");
        }
        JsonElement jsonElement = this.payload.get("aud");
        if (jsonElement.isJsonPrimitive()) {
            if (!jsonElement.getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", jsonElement));
            }
            return Collections.unmodifiableList(Arrays.asList(jsonElement.getAsString()));
        }
        if (!jsonElement.isJsonArray()) {
            throw new JwtInvalidException("claim aud is not a string or a JSON array");
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        ArrayList arrayList = new ArrayList(asJsonArray.size());
        for (int i = 0; i < asJsonArray.size(); i++) {
            if (!asJsonArray.get(i).isJsonPrimitive() || !asJsonArray.get(i).getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", asJsonArray.get(i)));
            }
            arrayList.add(asJsonArray.get(i).getAsString());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Instant getInstant(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp");
        }
        try {
            return Instant.ofEpochMilli((long) (this.payload.get(str).getAsJsonPrimitive().getAsDouble() * 1000.0d));
        } catch (NumberFormatException e) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp: " + e);
        }
    }

    public boolean hasExpiration() {
        return this.payload.has("exp");
    }

    public Instant getExpiration() throws JwtInvalidException {
        return getInstant("exp");
    }

    public boolean hasNotBefore() {
        return this.payload.has(JwtNames.CLAIM_NOT_BEFORE);
    }

    public Instant getNotBefore() throws JwtInvalidException {
        return getInstant(JwtNames.CLAIM_NOT_BEFORE);
    }

    public boolean hasIssuedAt() {
        return this.payload.has("iat");
    }

    public Instant getIssuedAt() throws JwtInvalidException {
        return getInstant("iat");
    }

    public Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        for (String str : this.payload.keySet()) {
            if (!JwtNames.isRegisteredName(str)) {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public String toString() {
        JsonObject jsonObject = new JsonObject();
        if (this.typeHeader.isPresent()) {
            jsonObject.add("typ", new JsonPrimitive(this.typeHeader.get()));
        }
        return jsonObject + "." + this.payload;
    }
}
