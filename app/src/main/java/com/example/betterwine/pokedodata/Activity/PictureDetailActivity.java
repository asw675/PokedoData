package com.example.betterwine.pokedodata.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.betterwine.pokedodata.Fragment.PictureDetailFragment;
import com.example.betterwine.pokedodata.Utils.SingleFragmentActivity;

public class PictureDetailActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        Intent i=getIntent();
        String url=i.getStringExtra("url");
        return PictureDetailFragment.newInstance(url);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }//去除顶部状态栏
        super.onCreate(savedInstanceState);
    }

}
