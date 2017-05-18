package com.example.shush.appmanage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shush on 2017/5/18.
 */

public class GetAppsinfo {
    public static final int FILTER_ALL_APP = 0;
    public static final int FILTER_SYSTEM_APP = 1;
    public static final int FILTER_THIRD_APP = 2; // 第三方应用程序
    private Context mContext = null;
    private PackageManager mPackageManager = null;
    private List<AppInfo> mAppsInfoList = new ArrayList<>();

    public GetAppsinfo(Context context) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
    }

    public List<AppInfo> filterApp(int filter) {
        List<ApplicationInfo> applicationInfos =
                mPackageManager.getInstalledApplications(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        mAppsInfoList.clear();

        switch (filter) {
            case FILTER_ALL_APP:
                for (ApplicationInfo applicationInfo : applicationInfos) {
                    getApkInfo(applicationInfo);
                }
                break;
            case FILTER_SYSTEM_APP:
                for (ApplicationInfo applicationInfo : applicationInfos) {
                    if (applicationInfo.flags == ApplicationInfo.FLAG_SYSTEM)
                        getApkInfo(applicationInfo);
                }
                break;
            case FILTER_THIRD_APP:
                for (ApplicationInfo applicationInfo : applicationInfos) {
                    if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0)
                        getApkInfo(applicationInfo);
                    else if((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0)
                        getApkInfo(applicationInfo);
                }
                break;
        }
        return mAppsInfoList;
    }

    private void getApkInfo(ApplicationInfo app) {
        AppInfo appInfo = new AppInfo();
        String appName = app.loadLabel(mPackageManager).toString();   // 获取应用名称
        String packageName = app.packageName; // // 包名
        Drawable drIcon = app.loadIcon(mPackageManager); // 图标

        appInfo.setStrApkName(appName);
        appInfo.setStrPkgName(packageName);
        appInfo.setDrIcon(drIcon);

        mAppsInfoList.add(appInfo);
    }

    private void unInstall(String strPkgName) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + strPkgName));
        mContext.startActivity(intent);

    }
}
