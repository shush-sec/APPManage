package com.example.shush.appmanage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ThirdAPKActivity extends AppCompatActivity {
    private List<AppInfo> mAppsInfoList = new ArrayList<AppInfo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_apk);

        GetAppsinfo getAppsinfo = new GetAppsinfo(this);
        mAppsInfoList =  getAppsinfo.filterApp(1);

        APPManageAdapter adapter = new APPManageAdapter(this,mAppsInfoList);
        ListView listView = (ListView) findViewById(R.id.list_third_apk);
        listView.setAdapter(adapter);
    }
}
