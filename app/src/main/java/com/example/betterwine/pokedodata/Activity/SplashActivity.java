package com.example.betterwine.pokedodata.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.example.betterwine.pokedodata.PermissionsUtils;
import com.example.betterwine.pokedodata.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash)
    ImageView splash;

    private String City;
    public LocationClient mLocationClient = null;
    // 声明一个对于定位的观察者对象
    private MyLocationListener myListener = new MyLocationListener();
    public ArrayList<BDLocation> locations = new ArrayList<BDLocation>();
    //获得定位时间
    private String locationTime;
    //获得经度坐标
    private Double locationLongitude;
    //获得纬度坐标
    private Double locationLatitude;
    //获得详细地址信息
    private String locationAddrStr;
    //获取位置语义化信息，没有的话返回NULL
    private String locationDescribe;
    //回调的百度坐标类，内部封装了如经纬度、半径等属性信息
    private BDLocation mBdLocation;
    String[] permissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        PermissionsUtils.getInstance().chekPermissions(this, permissions, permissionsResult);
        initBaidu();
    }

    PermissionsUtils.IPermissionsResult permissionsResult=new PermissionsUtils.IPermissionsResult() {
        @Override
        public void passPermissons() {

        }

        @Override
        public void forbitPermissons() {

        }
    };

    public void initBaidu() {
        // 定位用声明LocationClient类
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(myListener);
        initLocation();
        mLocationClient.start();
    }
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        // 可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");
        // 可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);
        // 可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);
        // 可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);
        // 可选，默认false,设置是否使用gps
        option.setLocationNotify(true);
        // 可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);
        // 可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);
        // 可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(true);
        // 可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);
        // 可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);
        // 可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        //接受到的定位信息,BDLocation中包含定位的一些信息,例如街道名称/城市/经纬度
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            //将之前声明的一些参数放到这里,方便控件展示时,直接使用即可
            mBdLocation = bdLocation;
            locationTime = bdLocation.getTime();
            locationLongitude = bdLocation.getLongitude();
            locationLatitude = bdLocation.getLatitude();
            locationAddrStr = bdLocation.getAddrStr();
            locationDescribe = bdLocation.getLocationDescribe();
            Log.i("定位信息--------", bdLocation.getCity());

            City=bdLocation.getCity();
            mLocationClient.stop();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i=new Intent(SplashActivity.this,MainActivity.class);
                    i.putExtra("city",City);
                    startActivity(i);
                    finish();
                }
            },2000);


        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
