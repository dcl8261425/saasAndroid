package com.herotculb.qunhaichat.homeactiviti.weixin.duihuan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.window.ErWeiMaWindow;
import com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.window.HuoDongWindow;
import com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.window.JiFenWindow;

public class Duihuan {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public Duihuan(HomeActivity home,LinearLayout linearLayout){
		this.home=home;
		this.linearLayout=linearLayout;
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.weixin_duihuan_layout, null)
				.findViewById(R.id.weixin_duihuan_layout_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapButton jifen=(BootstrapButton)home.findViewById(R.id.weixin_duihuan_layout_jifen);
		BootstrapButton huodong=(BootstrapButton)home.findViewById(R.id.weixin_duihuan_layout_huodong);
		BootstrapButton erweima=(BootstrapButton)home.findViewById(R.id.weixin_duihuan_layout_erweima);
		jifen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Duihuan.this.home, JiFenWindow.class);  
				Bundle b = new Bundle();  
                i.putExtras(b);  
                Duihuan.this.home.startActivityForResult(i, 0);  
                Duihuan.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		huodong.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Duihuan.this.home, HuoDongWindow.class);  
				Bundle b = new Bundle();  
                i.putExtras(b);  
                Duihuan.this.home.startActivityForResult(i, 0);  
                Duihuan.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		erweima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Duihuan.this.home, ErWeiMaWindow.class);  
				Bundle b = new Bundle();  
                i.putExtras(b);  
                Duihuan.this.home.startActivityForResult(i, 0);  
                Duihuan.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
	}
}
