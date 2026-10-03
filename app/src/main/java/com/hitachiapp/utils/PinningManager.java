package com.hitachiapp.utils;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.hitachiapp.MainActivity;
import com.hitachiapp.exceptions.ErrorCodes;
import com.hitachiapp.exceptions.MyCiceroException;

/* JADX INFO: loaded from: classes3.dex */
public class PinningManager {
    public static void init(MainActivity mainActivity) {
        try {
            OkHttpClientProvider.setOkHttpClientFactory(new OkHttpCustomClientFactory());
        } catch (Throwable unused) {
            showErrorDialog(new MyCiceroException(ErrorCodes.PINNING_INIT_ERROR), mainActivity);
        }
    }

    public static void showErrorDialog(final MyCiceroException myCiceroException, final MainActivity mainActivity) {
        new AlertDialog.Builder(mainActivity).setTitle("Error").setMessage("App will be terminated due to a certificate issue.\n(Error Code: " + myCiceroException.errorCode.code + ")").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.hitachiapp.utils.PinningManager.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                mainActivity.finish();
                System.exit(myCiceroException.errorCode.code);
            }
        }).setCancelable(false).create().show();
    }
}
