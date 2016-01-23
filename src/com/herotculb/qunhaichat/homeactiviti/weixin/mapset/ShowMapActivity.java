package com.herotculb.qunhaichat.homeactiviti.weixin.mapset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;

public class ShowMapActivity extends Activity{
	MapView mMapView;
	private Marker mMarkerA;
	BaiduMap mBaiduMap;
	BitmapDescriptor bdA = BitmapDescriptorFactory
			.fromResource(R.drawable.icon_marka);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_mapset_all_layout_show);
		BootstrapButton button=(BootstrapButton)findViewById(R.id.setMap_show_back);
		mMapView = (MapView) findViewById(R.id.bmapView_show);
		mBaiduMap = mMapView.getMap();
		Intent i = getIntent();
		Bundle b=i.getExtras();
		String x=b.getString("x");
		String y=b.getString("y");
		Log.e("danxiang", "getLatitude "+y+" getLongitude"+x+"");
		LatLng llA = new LatLng(Double.parseDouble(y),Double.parseDouble(x));
		OverlayOptions ooA = new MarkerOptions().position(llA).icon(bdA)
				.zIndex(9).draggable(true);
		mMarkerA = (Marker) (mBaiduMap.addOverlay(ooA));
		MyLocationData locData = new MyLocationData.Builder().latitude(Double.parseDouble(y)).longitude(Double.parseDouble(x)).build();
		mBaiduMap.setMyLocationData(locData);
		LatLng ll = new LatLng(Double.parseDouble(y),
				Double.parseDouble(x));
		MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
		mBaiduMap.animateMapStatus(u);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ShowMapActivity.this,
						LoactionListActivity.class);
				Bundle b = new Bundle();
				b.putString("type", "cancel");
				i.putExtras(b);
				ShowMapActivity.this.setResult(RESULT_OK, i);
				ShowMapActivity.this.finish();
			}
		});
	}
}
