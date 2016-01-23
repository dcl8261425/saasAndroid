package com.herotculb.qunhaichat.homeactiviti.weixin.mapset;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

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
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.location.LocationListenner;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MapSet {
	public HomeActivity home;
	public LinearLayout linearLayout;
	// 定位相关
		LocationClient mLocClient;
		private LocationMode mCurrentMode;
		BitmapDescriptor mCurrentMarker;
		MapView mMapView;
		BaiduMap mBaiduMap;
		// UI相关
		OnCheckedChangeListener radioButtonListener;
		BootstrapButton requestLocButton;
		BootstrapButton lookAllView;
	public MapSet(final HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		SDKInitializer.initialize(home.getApplicationContext());
		RelativeLayout gridLayout = (RelativeLayout) home.inflater.inflate(
				R.layout.weixin_mapset_layout, null).findViewById(
				R.id.weixin_mapset_layout_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		// 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext

		requestLocButton = (BootstrapButton) home.findViewById(R.id.setNewLoacating);
		lookAllView = (BootstrapButton) home.findViewById(R.id.lookAllLocating);
		mCurrentMode = LocationMode.NORMAL;
		OnClickListener btnClickListener = new OnClickListener() {
			public void onClick(View v) {
				
				MyLocationData locData = mBaiduMap.getLocationData();
				LoadingDialog dialog = new LoadingDialog(home, "正在获取数据");
				dialog.show();
				MapSetHandler handler=new MapSetHandler(home, dialog);
				MapSetTread tread=new MapSetTread(home, handler,String.valueOf(locData.longitude), String.valueOf(locData.latitude));
				tread.start();
			}
		};
		requestLocButton.setOnClickListener(btnClickListener);
		OnClickListener btnClickListener2 = new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MapSet.this.home, LoactionListActivity.class);  
				Bundle b = new Bundle();  
                i.putExtras(b);  
                MapSet.this.home.startActivityForResult(i, 0);  
                MapSet.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				
			}
		};
		lookAllView.setOnClickListener(btnClickListener2);
		// 地图初始化
		mMapView = (MapView) home.findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);
		// 定位初始化
		mLocClient = new LocationClient(home);
		SharedPreferences preferences = home.getSharedPreferences("usermessage", Activity.MODE_PRIVATE);
	    String userName = preferences.getString("username", "");
	    String passWord =preferences.getString("password", "");
		mLocClient.registerLocationListener(new LocationListenner(userName, passWord, mBaiduMap,home));
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(5000);
		mLocClient.setLocOption(option);
		mLocClient.start();
	}

	

	

}
