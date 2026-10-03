package com.reactnativebarcodecreator;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReactContext;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeView extends AppCompatImageView {
    int background;
    String content;
    ReactContext context;
    int foregroundColor;
    BarcodeFormat format;
    int height;
    int width;

    public static int dpToPx(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public void setWidth(int i) {
        this.width = dpToPx(i);
        updateQRCodeView();
    }

    public void setHeight(int i) {
        this.height = dpToPx(i);
        updateQRCodeView();
    }

    public void setFormat(BarcodeFormat barcodeFormat) {
        this.format = barcodeFormat;
        updateQRCodeView();
    }

    public void setContent(String str) {
        this.content = str;
        updateQRCodeView();
    }

    private int handleColor(String str) throws Exception {
        if (!str.startsWith("#") || (str.length() != 4 && str.length() != 7 && str.length() != 9)) {
            throw new Exception("Color not supported");
        }
        if (str.length() == 4) {
            str = (str + str.substring(1, 4)) + "FF";
        } else if (str.length() == 7) {
            str = str + "FF";
        }
        long j = Long.parseLong(str.replaceFirst("#", ""), 16);
        return Color.argb((int) (j & 255), (int) ((j >> 24) & 255), (int) ((j >> 16) & 255), (int) ((j >> 8) & 255));
    }

    public void setForegroundColor(String str) {
        if (str.isEmpty()) {
            return;
        }
        try {
            this.foregroundColor = handleColor(str);
            updateQRCodeView();
        } catch (Exception e) {
            Utils.showException(this.context, e);
            e.printStackTrace();
        }
    }

    public void setBackgroundColor(String str) {
        if (str.isEmpty()) {
            return;
        }
        try {
            this.background = handleColor(str);
            updateQRCodeView();
        } catch (Exception e) {
            Utils.showException(this.context, e);
            e.printStackTrace();
        }
    }

    public void updateQRCodeView() {
        if (this.content.isEmpty()) {
            return;
        }
        try {
            setImageBitmap(new BarcodeEncoder().createBitmap(new MultiFormatWriter().encode(this.content, this.format, this.width, this.height), this.background, this.foregroundColor));
        } catch (Exception e) {
            Utils.showException(this.context, e);
            e.printStackTrace();
        }
    }

    public BarcodeView(ReactContext reactContext) {
        super(reactContext);
        this.width = 100;
        this.height = 100;
        this.content = "";
        this.foregroundColor = 0;
        this.background = ViewCompat.MEASURED_SIZE_MASK;
        this.format = BarcodeFormat.QR_CODE;
        this.context = reactContext;
    }
}
