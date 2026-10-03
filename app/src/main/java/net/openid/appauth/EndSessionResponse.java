package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class EndSessionResponse extends AuthorizationManagementResponse {
    public static final String EXTRA_RESPONSE = "net.openid.appauth.EndSessionResponse";
    static final String KEY_REQUEST = "request";
    static final String KEY_STATE = "state";
    public final EndSessionRequest request;
    public final String state;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Builder {
        private EndSessionRequest mRequest;
        private String mState;

        public Builder(@NonNull EndSessionRequest endSessionRequest) {
            setRequest(endSessionRequest);
        }

        Builder fromUri(@NonNull Uri uri) {
            setState(uri.getQueryParameter("state"));
            return this;
        }

        public Builder setRequest(@NonNull EndSessionRequest endSessionRequest) {
            this.mRequest = (EndSessionRequest) Preconditions.checkNotNull(endSessionRequest, "request cannot be null");
            return this;
        }

        public Builder setState(@Nullable String str) {
            this.mState = Preconditions.checkNullOrNotEmpty(str, "state must not be empty");
            return this;
        }

        public EndSessionResponse build() {
            return new EndSessionResponse(this.mRequest, this.mState);
        }
    }

    private EndSessionResponse(@NonNull EndSessionRequest endSessionRequest, @Nullable String str) {
        this.request = endSessionRequest;
        this.state = str;
    }

    @Override // net.openid.appauth.AuthorizationManagementResponse
    public String getState() {
        return this.state;
    }

    @Override // net.openid.appauth.AuthorizationManagementResponse
    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, "request", this.request.jsonSerialize());
        JsonUtil.putIfNotNull(jSONObject, "state", this.state);
        return jSONObject;
    }

    public static EndSessionResponse jsonDeserialize(@NonNull JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("request")) {
            throw new IllegalArgumentException("authorization request not provided and not found in JSON");
        }
        return new EndSessionResponse(EndSessionRequest.jsonDeserialize(jSONObject.getJSONObject("request")), JsonUtil.getStringIfDefined(jSONObject, "state"));
    }

    public static EndSessionResponse jsonDeserialize(@NonNull String str) throws JSONException {
        return jsonDeserialize(new JSONObject(str));
    }

    @Override // net.openid.appauth.AuthorizationManagementResponse
    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESPONSE, jsonSerializeString());
        return intent;
    }

    public static EndSessionResponse fromIntent(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent, "dataIntent must not be null");
        if (!intent.hasExtra(EXTRA_RESPONSE)) {
            return null;
        }
        try {
            return jsonDeserialize(intent.getStringExtra(EXTRA_RESPONSE));
        } catch (JSONException e) {
            throw new IllegalArgumentException("Intent contains malformed auth response", e);
        }
    }

    static boolean containsEndSessionResponse(@NonNull Intent intent) {
        return intent.hasExtra(EXTRA_RESPONSE);
    }
}
