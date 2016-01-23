package com.herotculb.qunhaichat.homeactiviti.weixin.wifi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WiXinWiFi {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public WiXinWiFi(HomeActivity home,LinearLayout linearLayout){
		this.home=home;
		this.linearLayout=linearLayout;
		Log.e("---------------------", "weixin1");
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.weixin_wifi_layout, null)
				.findViewById(R.id.weixin_wifi_layout_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		ListView list=(ListView) home.findViewById(R.id.weixin_wifi_layout_list);
		LoadingDialog dialog = new LoadingDialog(home, "正在获取数据");
		dialog.show();
		WeiXinWiFiHandler handler=new WeiXinWiFiHandler(home, dialog,list);
		WeiXinWifiThread thread=new WeiXinWifiThread(home, handler);
		thread.start();
		BootstrapButton buton=(BootstrapButton) home.findViewById(R.id.weixin_wifi_layout_addNewWifi);
		buton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(WiXinWiFi.this.home, AddWeixinWifiWindow.class);
				Bundle b = new Bundle();  
                i.putExtras(b);  
                WiXinWiFi.this.home.startActivityForResult(i, 0);
                WiXinWiFi.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
	}
}
