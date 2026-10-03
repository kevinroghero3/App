package it.aep_italia.vts.sdk.core;

import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerInfoDTO;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetOperatorsOutput;
import it.aep_italia.vts.sdk.dto.utils.VtsUserDataDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsWellKnownStrings;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
final class c {
    private VtsSdk a;
    private final boolean b;

    c(VtsSdk vtsSdk, boolean z) {
        this.a = vtsSdk;
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Throwable a(CountDownLatch countDownLatch) throws Exception {
        try {
            try {
                VtsLog.i("initializeAsync() - Starting Synchronize Thread...", new Object[0]);
                a();
                countDownLatch.countDown();
                VtsLog.i("initializeAsync() - Synchronize Thread successfully terminated", new Object[0]);
                return null;
            } catch (Exception e) {
                VtsLog.e(e, "initializeAsync() Synchronize Thread: received an exception. ErrMessage='%s'", e.getLocalizedMessage());
                countDownLatch.countDown();
                VtsLog.i("initializeAsync() - Synchronize Thread successfully terminated", new Object[0]);
                return e;
            }
        } catch (Throwable th) {
            countDownLatch.countDown();
            VtsLog.i("initializeAsync() - Synchronize Thread successfully terminated", new Object[0]);
            throw th;
        }
    }

    private void a(e eVar, VtsConnection vtsConnection) {
        boolean z = false;
        if (eVar.c(VtsWellKnownStrings.FILE_OPERATOR_LIST)) {
            VtsLog.i("SynchronizeOperatorsList() - Operators list already present int local wallet. Skipping download...", new Object[0]);
            return;
        }
        try {
            VtsLog.i("SynchronizeOperatorsList() - Downloading operators list from VTSS...", new Object[0]);
            GetOperatorsOutput getOperatorsOutputA = vtsConnection.a(0);
            if (getOperatorsOutputA == null) {
                VtsLog.e("SynchronizeOperatorsList() - Failed: Received null operator list from VTSS.", new Object[0]);
                return;
            }
            VtsLog.i("SynchronizeOperatorsList() - Operators list successfully downloaded. Saving list to wallet...", new Object[0]);
            try {
                eVar.l();
                try {
                    eVar.a(VtsWellKnownStrings.FILE_OPERATOR_LIST, getOperatorsOutputA);
                    eVar.b();
                    VtsLog.i("SynchronizeOperatorsList() - Operators list successfully saved to wallet.", new Object[0]);
                } catch (Exception e) {
                    e = e;
                    z = true;
                    if (z) {
                        eVar.a();
                    }
                    VtsLog.e(e, "SynchronizeOperatorsList() Received an exception saving operators list to wallet. ErrMessage='%s'", e.getLocalizedMessage());
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            VtsLog.e(e3, "SynchronizeOperatorsList() Received an exception downloading operator list from VTSS. ErrMessage='%s'", e3.getLocalizedMessage());
        }
    }

    private void b(e eVar, VtsConnection vtsConnection) {
        VtsLog.i("SynchronizeSdkAndUserData() - Downloading SDK configuration and VTS user data from VTSS...", new Object[0]);
        if (!this.b) {
            VtsLog.d("SynchronizeSdkAndUserData() - Calling 'setClientInfo()' on VTSS...", new Object[0]);
            try {
                vtsConnection.a((VtsUserDataDTO) null, (byte[]) null);
            } catch (Exception e) {
                VtsLog.e(e, "SynchronizeSdkAndUserData() Received an exception saving user info to VTSS. ErrMessage='%s'", e.getLocalizedMessage());
                return;
            }
        }
        VtsLog.d("SynchronizeSdkAndUserData() - Calling 'getServerInfo()' on VTSS...", new Object[0]);
        try {
            boolean z = !this.b;
            VtsServerInfoDTO vtsServerInfoDTOA = vtsConnection.a(z, z, true);
            try {
                VtsLog.i("SynchronizeSdkAndUserData() - Saving SDK configuration and VTS user data...", new Object[0]);
                eVar.l();
                try {
                    VtsServerInfoDTO vtsServerInfoDTOE = eVar.e();
                    if (vtsServerInfoDTOA.getDeviceStatistics() != null) {
                        VtsLog.d("SynchronizeSdkAndUserData() - Updating device statistics...", new Object[0]);
                        vtsServerInfoDTOE.setDeviceStatistics(vtsServerInfoDTOA.getDeviceStatistics());
                    }
                    if (vtsServerInfoDTOA.getSdkParameters() != null) {
                        VtsLog.d("SynchronizeSdkAndUserData() - Updating SDK parameters...", new Object[0]);
                        vtsServerInfoDTOE.setSdkParameters(vtsServerInfoDTOA.getSdkParameters());
                    }
                    eVar.a(VtsWellKnownStrings.FILE_SERVER_INFO, vtsServerInfoDTOE);
                    if (vtsServerInfoDTOA.getUserData() != null) {
                        VtsLog.d("SynchronizeSdkAndUserData() - Updating user data...", new Object[0]);
                        this.a.setUserData(vtsServerInfoDTOA.getUserData().toUserDataDTO(), false);
                    }
                    if (vtsServerInfoDTOA.getUserPhoto() != null) {
                        VtsLog.d("SynchronizeSdkAndUserData() - Updating user photo...", new Object[0]);
                        this.a.setUserPhoto(vtsServerInfoDTOA.getUserPhoto(), false);
                    }
                    eVar.b();
                    VtsLog.i("SynchronizeSdkAndUserData() - Checking if the user image has changed...", new Object[0]);
                    try {
                        int i = Integer.parseInt(vtsConnection.getUserImageInfo().getPhotoImageSize());
                        if (i > 0) {
                            byte[] userPhoto = this.a.getUserPhoto();
                            if (userPhoto.length != i) {
                                VtsLog.d("SynchronizeSdkAndUserData() - User photo has changed. Downloading new image... LocalSize=%d, VTSSize=%d", Integer.valueOf(userPhoto.length), Integer.valueOf(i));
                                try {
                                    VtsLog.d("SynchronizeSdkAndUserData() - Calling 'downloadUserImage()' on VTSS...", new Object[0]);
                                    vtsConnection.downloadUserImage();
                                    VtsLog.i("SynchronizeSdkAndUserData() - User image successfully updated. LocalSize=%d, VTSSize=%d", Integer.valueOf(userPhoto.length), Integer.valueOf(i));
                                } catch (Exception e2) {
                                    VtsLog.e(e2, "SynchronizeSdkAndUserData() Received an exception updating user image. ErrMessage='%s'", e2.getLocalizedMessage());
                                }
                            } else {
                                VtsLog.i("SynchronizeSdkAndUserData() - User photo has NOT changed. Skipping download. LocalSize=%d, VTSSize=%d", Integer.valueOf(userPhoto.length), Integer.valueOf(i));
                            }
                        } else {
                            VtsLog.d("SynchronizeSdkAndUserData() - No user photo available in VTS database. ImageSize=%d", Integer.valueOf(i));
                        }
                        VtsLog.i("SynchronizeSdkAndUserData() - SDK configuration and user data successfully updated.", new Object[0]);
                    } catch (Exception e3) {
                        VtsLog.e(e3, "SynchronizeSdkAndUserData() Received an exception getting user image size. ErrMessage='%s'", e3.getLocalizedMessage());
                    }
                } catch (Exception e4) {
                    eVar.a();
                    VtsLog.e(e4, "SynchronizeSdkAndUserData() Transaction failed. Cannot update SDK configuration and VTS user data. ErrMessage='%s'", e4.getLocalizedMessage());
                }
            } catch (Exception e5) {
                VtsLog.e(e5, "SynchronizeSdkAndUserData() Received an unexpected exception. ErrMessage='%s'", e5.getLocalizedMessage());
            }
        } catch (Exception e6) {
            VtsLog.e(e6, "SynchronizeSdkAndUserData() Received an exception retrieving server info. ErrMessage='%s'", e6.getLocalizedMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a() throws VtsException {
        Object[] objArr;
        int i = 0;
        i = 0;
        i = 0;
        i = 0;
        VtsLog.i("initialize() Starting Synchronize...", new Object[0]);
        e eVarD = this.a.d();
        VtsConnection vtsConnectionE = null;
        try {
            try {
                VtsLog.i("initialize() Connecting to VTSS...", new Object[0]);
                vtsConnectionE = this.a.e();
                VtsLog.i("initialize() Synchronizing Sdk Configuration and Vts User data...", new Object[0]);
                b(eVarD, vtsConnectionE);
                VtsLog.i("initialize() Synchronizing Vts Operators list...", new Object[0]);
                a(eVarD, vtsConnectionE);
                VtsLog.i("initialize() Synchronize completed successfully.", new Object[0]);
                if (vtsConnectionE != null) {
                    Object[] objArr2 = new Object[0];
                    VtsLog.i("initialize() Closing connection to VTSS...", objArr2);
                    objArr = objArr2;
                    try {
                        vtsConnectionE.closeConnection();
                        i = objArr;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                VtsLog.e(e, "initialize() Synchronize FAILED. ErrMessage='%s'", e.getLocalizedMessage());
                if (vtsConnectionE != null) {
                    Object[] objArr3 = new Object[0];
                    VtsLog.i("initialize() Closing connection to VTSS...", objArr3);
                    objArr = objArr3;
                }
            }
        } catch (Throwable th) {
            if (vtsConnectionE != null) {
                VtsLog.i("initialize() Closing connection to VTSS...", new Object[i]);
                try {
                    vtsConnectionE.closeConnection();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public void b() throws VtsException {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: it.aep_italia.vts.sdk.core.c$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(countDownLatch);
            }
        });
        executorServiceNewSingleThreadExecutor.shutdown();
        try {
            if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
                VtsLog.e("initializeAsync() - Synchronize not finished within timeout (%d seconds). Interrupting synchronize...", 30);
                futureSubmit.cancel(true);
            } else {
                VtsLog.i("initializeAsync() - Synchronize Thread completed within timeout.", new Object[0]);
                Throwable th = (Throwable) futureSubmit.get();
                if (th != null) {
                    throw new VtsException(VtsError.COULD_NOT_INITIALIZE_SDK, th);
                }
            }
        } catch (InterruptedException e) {
            VtsLog.e(e, "initializeAsync() Received an exception while waiting thread to finish. ErrMessage='%s'", e.getLocalizedMessage());
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            throw new VtsException(VtsError.COULD_NOT_INITIALIZE_SDK, e2.getCause());
        }
    }
}
