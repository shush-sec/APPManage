package com.example.shush.appmanage;

import android.graphics.drawable.Drawable;

/**
 * Created by shush on 2017/5/18.
 */

public class AppInfo {
    String strApkName;      //应用程序名
    String strPkgName ;     //包名
    Drawable    drIcon;     //图标
    int         nApkSize;   //程序大小

    public void setStrApkName(String strApkName) {
        this.strApkName = strApkName;
    }

    public void setStrPkgName(String strPkgName) {
        this.strPkgName = strPkgName;
    }

    public void setDrIcon(Drawable drIcon) {
        this.drIcon = drIcon;
    }

    public void setnApkSize(int nApkSize) {
        this.nApkSize = nApkSize;
    }

    public String getStrApkName() {

        return strApkName;
    }

    public String getStrPkgName() {
        return strPkgName;
    }

    public Drawable getDrIcon() {
        return drIcon;
    }

    public int getnApkSize() {
        return nApkSize;
    }
}
