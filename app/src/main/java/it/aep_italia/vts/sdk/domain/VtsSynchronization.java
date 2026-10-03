package it.aep_italia.vts.sdk.domain;

import it.aep_italia.vts.sdk.core.VtsLog;
import it.aep_italia.vts.sdk.dto.domain.VtsSynchronizationDTO;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSynchronization {
    private Status a;
    private Date b;
    private Date c;
    private String d;

    public enum Status {
        IN_PROGRESS,
        SUCCESS,
        ERROR
    }

    public VtsSynchronization(Status status, Date date, Date date2, String str) {
        this.a = status;
        this.b = date;
        this.c = date2;
        this.d = str;
    }

    public static VtsSynchronization fromDto(VtsSynchronizationDTO vtsSynchronizationDTO) {
        if (vtsSynchronizationDTO == null) {
            return null;
        }
        try {
            return new VtsSynchronization(Status.valueOf(vtsSynchronizationDTO.getStatus()), DateUtils.fromISO8601(vtsSynchronizationDTO.getStartDate()), DateUtils.fromISO8601(vtsSynchronizationDTO.getEndDate()), SerializationUtils.fromBase64String(vtsSynchronizationDTO.getErrorMessage()));
        } catch (Exception e) {
            VtsLog.e(e, "Cannot read synchronization data", new Object[0]);
            return null;
        }
    }

    public Date getEndDate() {
        return this.c;
    }

    public String getErrorMessage() {
        return this.d;
    }

    public Date getStartDate() {
        return this.b;
    }

    public Status getStatus() {
        return this.a;
    }
}
