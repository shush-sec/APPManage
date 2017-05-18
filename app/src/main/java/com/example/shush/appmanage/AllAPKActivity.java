package com.example.shush.appmanage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllAPKActivity extends AppCompatActivity {

    private List<AppInfo> mAppsInfoList = new ArrayList<AppInfo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_apk);

        final GetAppsinfo getAppsinfo = new GetAppsinfo(this);
        mAppsInfoList =  getAppsinfo.filterApp(0);

        APPManageAdapter adapter = new APPManageAdapter(this,mAppsInfoList);
        ListView listView = (ListView) findViewById(R.id.list_all_apk);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                getAppsinfo.unInstall(mAppsInfoList.get(position).getStrPkgName());
                return true;
            }
        });
    }
}
