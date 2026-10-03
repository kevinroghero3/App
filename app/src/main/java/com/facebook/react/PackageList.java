package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import cl.json.RNSharePackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.a11yorder.A11yOrderPackage;
import com.alpha0010.fs.FileAccessPackage;
import com.captureprotection.CaptureProtectionPackage;
import com.emeraldsanto.encryptedstorage.RNEncryptedStoragePackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.guhungry.rnphotomanipulator.RNPhotoManipulatorPackage;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerPackage;
import com.henninghall.date_picker.DatePickerPackage;
import com.horcrux.svg.SvgPackage;
import com.ibits.react_native_in_app_review.AppReviewPackage;
import com.imagepicker.ImagePickerPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.lugg.RNCConfig.RNCConfigPackage;
import com.mrousavy.camera.react.CameraPackage;
import com.mycicero.reactnativekeykeeper.ReactNativeKeyKeeperPackage;
import com.nfcblocker.NfcBlockerPackage;
import com.proyecto26.inappbrowser.RNInAppBrowserPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.reactnativebarcodecreator.BarcodeCreatorPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.cameraroll.CameraRollPackage;
import com.reactnativecommunity.clipboard.ClipboardPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.picker.RNCPickerPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativekeyboardcontroller.KeyboardControllerPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.rnappauth.RNAppAuthPackage;
import com.rnmaps.maps.MapsPackage;
import com.shopify.reactnative.skia.RNSkiaPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.transistorsoft.rnbackgroundfetch.RNBackgroundFetchPackage;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocation;
import com.worklets.WorkletsCorePackage;
import com.zoontek.rnbootsplash.RNBootSplashPackage;
import com.zoontek.rnlocalize.RNLocalizePackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingPackage;
import io.invertase.firebase.perf.ReactNativeFirebasePerfPackage;
import io.invertase.notifee.NotifeePackage;
import io.sentry.react.RNSentryPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.capslock.RNDeviceBrightness.RNDeviceBrightness;
import org.wonday.pdf.RNPDFPackage;

/* JADX INFO: loaded from: classes.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new RNDeviceBrightness(), new ReactNativeKeyKeeperPackage(), new NfcBlockerPackage(), new NotifeePackage(), new CameraRollPackage(), new ClipboardPackage(), new NetInfoPackage(), new ReactNativeFirebaseAnalyticsPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseMessagingPackage(), new ReactNativeFirebasePerfPackage(), new RNCPickerPackage(), new RNSentryPackage(), new RNSkiaPackage(), new A11yOrderPackage(), new AndroidLocationEnablerPackage(), new RNAppAuthPackage(), new RNBackgroundFetchPackage(), new RNBackgroundGeolocation(), new BarcodeCreatorPackage(), new ReactNativeBlobUtilPackage(), new RNBootSplashPackage(), new CaptureProtectionPackage(), new RNCConfigPackage(), new DatePickerPackage(), new RNDeviceInfo(), new RNEncryptedStoragePackage(), new FBSDKPackage(), new FileAccessPackage(), new RNGestureHandlerPackage(), new PickerPackage(), new ImagePickerPackage(), new AppReviewPackage(), new RNInAppBrowserPackage(), new KeyboardControllerPackage(), new LinearGradientPackage(), new RNLocalizePackage(), new MapsPackage(), new PagerViewPackage(), new RNPDFPackage(), new RNPermissionsPackage(), new RNPhotoManipulatorPackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSharePackage(), new SvgPackage(), new CameraPackage(), new RNCWebViewPackage(), new WorkletsCorePackage(), new AsyncStoragePackage()));
    }
}
