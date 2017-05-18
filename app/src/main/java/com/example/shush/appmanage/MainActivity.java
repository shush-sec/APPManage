package com.example.shush.appmanage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //点击显示所有应用按钮，跳转到AllAPKActivity
    public void onClickToAll(View view) {
        intent = new Intent(this, AllAPKActivity.class);
        startActivity(intent);
    }
    //点击显示所有应用按钮，跳转到SystemAPKActivity
    public void onClickToSystem(View view) {
        intent = new Intent(this, SystemAPKActivity.class);
        startActivity(intent);
    }
    //点击显示所有应用按钮，跳转到ThirdAPKActivity
    public void onClickToThird(View view) {
        intent = new Intent(this, ThirdAPKActivity.class);
        startActivity(intent);
    }
}
