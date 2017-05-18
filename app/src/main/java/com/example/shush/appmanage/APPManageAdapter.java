package com.example.shush.appmanage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shush on 2017/5/18.
 */

public class APPManageAdapter extends BaseAdapter {
    List<AppInfo> appInfoLists = new ArrayList<>();
    Context mContext;

    public APPManageAdapter(Context context, List<AppInfo> appInfos) {
        mContext = context;
        appInfoLists = appInfos;
    }

    @Override
    public int getCount() {
        return appInfoLists.size();
    }

    @Override
    public Object getItem(int position) {
        return appInfoLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        View view = null;
        if (convertView == null) {
            //利用布局加载器从Context获取View (item布局)
           view = LayoutInflater.from(mContext).inflate(R.layout.item, null);
           viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        AppInfo appinfo = (AppInfo) getItem(position);
        viewHolder.mImIcon.setImageDrawable(appinfo.getDrIcon() );
        viewHolder.mTvAppName.setText(appinfo.getStrApkName());
        viewHolder.mTvAppPackge.setText(appinfo.getStrPkgName());
        return view;
    }

    public class ViewHolder {
        ImageView mImIcon = null;
        TextView mTvAppName = null;
        TextView mTvAppPackge = null;

        public ViewHolder(View view) {
            mImIcon = (ImageView) view.findViewById(R.id.im_icon);
            mTvAppName = (TextView) view.findViewById(R.id.tv_appname);
            mTvAppPackge = (TextView) view.findViewById(R.id.tv_apppackge);
        }
    }
}
