package com.herotculb.qunhaichat.homeactiviti.crm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.CreateChanceWindow;
import com.herotculb.qunhaichat.group.window.CreateGroupWindow;
import com.herotculb.qunhaichat.homeactiviti.group.GroupManager;

public class CrmManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public CrmManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//客户管理
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.crm_chance_gailan_layout, null)
				.findViewById(R.id.crm_chance_gailan_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapButton create = (BootstrapButton)
				CrmManager.this.home.findViewById(R.id.crm_chance_gailan_create);
		BootstrapButton widget = (BootstrapButton)
				CrmManager.this.home.findViewById(R.id.crm_chance_gailan_widget);
		create.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 添加新机会
				Intent i = new Intent(CrmManager.this.home, CreateChanceWindow.class);  
				Bundle b = new Bundle();  
                i.putExtras(b);  
                CrmManager.this.home.startActivityForResult(i,0);
                CrmManager.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		widget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 概览小窗口添加
				
			}
		});
	}
	
}
