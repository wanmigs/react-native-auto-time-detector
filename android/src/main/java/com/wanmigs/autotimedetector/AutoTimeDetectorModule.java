package com.wanmigs.autotimedetector;

import androidx.annotation.NonNull;

import android.provider.Settings;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = AutoTimeDetectorModule.NAME)
public class AutoTimeDetectorModule extends ReactContextBaseJavaModule {
  public static final String NAME = "AutoTimeDetector";
  private ReactApplicationContext mContext;

  public AutoTimeDetectorModule(ReactApplicationContext reactContext) {
    super(reactContext);
    mContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void isAutoTimeZoneEnabled(Promise promise) {
      try {
          promise.resolve(Settings.System.getInt(mContext.getContentResolver(), Settings.System.AUTO_TIME));
      } catch (Settings.SettingNotFoundException e) {
          promise.reject("-1");
      }
  }
}
