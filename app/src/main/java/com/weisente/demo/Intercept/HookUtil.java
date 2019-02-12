package com.weisente.demo.Intercept;



import com.weisente.demo.util.HotXposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by wing on 4/18/17.
 */

public class HookUtil implements IXposedHookLoadPackage {
  @Override
  public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam)
      throws Throwable {

    HotXposed.hook(HookerDispatcher.class, loadPackageParam);
  }
}
