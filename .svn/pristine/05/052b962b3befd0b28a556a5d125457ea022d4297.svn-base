package com.herotculb.qunhaichat.homeactiviti;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.location.LocationListenner;
import com.herotculb.qunhaichat.location.MeetingTest;

public class QiandaoWindow extends Activity{
	public LocationClient mLocClient;
	public LocationMode mCurrentMode;
	public BitmapDescriptor mCurrentMarker;
	public MapView mMapView;
	public BaiduMap mBaiduMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.qindao_layout);
		BootstrapButton but = (BootstrapButton) findViewById(R.id.enter_qiandao);
		
		// 地图初始化
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);
		// 定位初始化
		mLocClient = new LocationClient(this);
		 SharedPreferences preferences = getSharedPreferences("usermessage", Activity.MODE_PRIVATE);
		    String userName = preferences.getString("username", "");
		    String passWord =preferences.getString("password", "");
		mLocClient.registerLocationListener(new LocationListenner(userName, passWord, mBaiduMap,this));
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(5000);
		mLocClient.setLocOption(option);
		mLocClient.start();
		QiandaoButtonOnclick onclick=new QiandaoButtonOnclick(but, QiandaoWindow.this,mBaiduMap);
	}
	
	@Override
	protected void onDestroy() {
		
		// 退出时销毁定位
		mLocClient.stop();
		// 关闭定位图层
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;
		 MeetingTest test=new MeetingTest(this);
			test.start();
		super.onDestroy();
	}
}
