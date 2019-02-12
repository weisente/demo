package com.weisente.demo.Intercept;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.weisente.demo.base.Constants;
import com.weisente.demo.base.IHookerDispatcher;


import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created  on 2018/3/30.
 */
public class HookerDispatcher implements IHookerDispatcher {
  @Override
  public void dispatch(XC_LoadPackage.LoadPackageParam loadPackageParam) {

      XposedBridge.log("进来了");

    if(!Constants.TARGET_PACKAGE_NAME.equals(loadPackageParam.packageName)){
      return;
    }
    XposedHelpers.findAndHookMethod("com.wingsofts.zoomimageheader.HomeActivity",
        loadPackageParam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
          @Override
          protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            super.beforeHookedMethod(param);
          }

          @Override
          protected void afterHookedMethod(MethodHookParam param)
              throws Throwable {
            super.afterHookedMethod(param);
            Toast.makeText((Context) param.thisObject, "asdasdad", Toast.LENGTH_SHORT).show();
          }
        });
  }
}
