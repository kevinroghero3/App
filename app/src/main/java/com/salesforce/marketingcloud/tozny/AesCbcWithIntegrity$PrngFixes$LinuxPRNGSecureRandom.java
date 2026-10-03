package com.salesforce.marketingcloud.tozny;

import android.util.Log;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

/* JADX INFO: loaded from: classes6.dex */
public class AesCbcWithIntegrity$PrngFixes$LinuxPRNGSecureRandom extends SecureRandomSpi {
    private static final File URANDOM_FILE = new File("/dev/urandom");
    private static final Object sLock = new Object();
    private static DataInputStream sUrandomIn;
    private static OutputStream sUrandomOut;
    private boolean mSeeded;

    private DataInputStream getUrandomInputStream() {
        DataInputStream dataInputStream;
        synchronized (sLock) {
            if (sUrandomIn == null) {
                try {
                    sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
                } catch (IOException e) {
                    throw new SecurityException("Failed to open " + URANDOM_FILE + " for reading", e);
                }
            }
            dataInputStream = sUrandomIn;
        }
        return dataInputStream;
    }

    private OutputStream getUrandomOutputStream() {
        OutputStream outputStream;
        synchronized (sLock) {
            if (sUrandomOut == null) {
                sUrandomOut = new FileOutputStream(URANDOM_FILE);
            }
            outputStream = sUrandomOut;
        }
        return outputStream;
    }

    @Override // java.security.SecureRandomSpi
    public byte[] engineGenerateSeed(int i) {
        byte[] bArr = new byte[i];
        engineNextBytes(bArr);
        return bArr;
    }

    @Override // java.security.SecureRandomSpi
    public void engineNextBytes(byte[] bArr) {
        DataInputStream urandomInputStream;
        if (!this.mSeeded) {
            engineSetSeed(a.b());
        }
        try {
            synchronized (sLock) {
                urandomInputStream = getUrandomInputStream();
            }
            synchronized (urandomInputStream) {
                urandomInputStream.readFully(bArr);
            }
        } catch (IOException e) {
            throw new SecurityException("Failed to read from " + URANDOM_FILE, e);
        }
    }

    @Override // java.security.SecureRandomSpi
    public void engineSetSeed(byte[] bArr) {
        OutputStream urandomOutputStream;
        try {
            try {
                synchronized (sLock) {
                    urandomOutputStream = getUrandomOutputStream();
                }
                urandomOutputStream.write(bArr);
                urandomOutputStream.flush();
            } catch (IOException unused) {
                Log.w(a.class.getSimpleName(), "Failed to mix seed into " + URANDOM_FILE);
            }
            this.mSeeded = true;
        } catch (Throwable th) {
            this.mSeeded = true;
            throw th;
        }
    }
}
