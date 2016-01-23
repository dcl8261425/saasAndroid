package com.herotculb.qunhaichat.homeactiviti.employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.employee.interactive.GetHuDongKongJianHandler;
import com.herotculb.qunhaichat.employee.interactive.GetHuDongKongJianThread;
import com.herotculb.qunhaichat.employee.interactive.window.EmployeeInteractiveSendWindow;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetHuDongKongJianManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	String groupId;
	public GetHuDongKongJianManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		//微信订单管理
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.employee_interactive_layout, null).findViewById(
				R.id.employee_interactive_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapButton lime = (BootstrapButton) linearLayout
				.findViewById(R.id.employee_interactive_lime);
		BootstrapButton business = (BootstrapButton) linearLayout
				.findViewById(R.id.employee_interactive_business);
		BootstrapButton send = (BootstrapButton) linearLayout
				.findViewById(R.id.employee_interactive_send);
		lime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 青柠网络科技
				BootstrapEditText nowpage=(BootstrapEditText) 
						GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_nowpage);
				nowpage.setText("1");
				LoadingDialog dialog = new LoadingDialog(GetHuDongKongJianManager.this.home,
						"正在获取数据");
				dialog.show();
				groupId = "1";
				XListView view=(XListView) 
						GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_list);
				view.setPullLoadEnable(true);
				view.setXListViewListener(new IXListViewListener() {
					
					@Override
					public void onRefresh() {
						// TODO 刷新
						BootstrapEditText nowpage=(BootstrapEditText) 
								GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_nowpage);
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						if(nowpagenum<=1){
							nowpagenum=1;
						}else{
							nowpagenum=nowpagenum-1;
						}
						nowpage.setText(String.valueOf(nowpagenum));
						LoadingDialog dialog = new LoadingDialog(GetHuDongKongJianManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) 
								GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_list);
						GetHuDongKongJianHandler handler = 
								new GetHuDongKongJianHandler(GetHuDongKongJianManager.this.home, view, dialog);
						GetHuDongKongJianThread thread = 
								new GetHuDongKongJianThread(GetHuDongKongJianManager.this.home, groupId,
										String.valueOf(nowpagenum), "10", handler);
						thread.start();
					}
					
					@Override
					public void onLoadMore() {
						// TODO 加载更多
						BootstrapEditText nowpage=(BootstrapEditText) 
								GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_nowpage);
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						nowpage.setText(String.valueOf(nowpagenum + 1));
						LoadingDialog dialog = new LoadingDialog(GetHuDongKongJianManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) 
								GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_list);
						GetHuDongKongJianHandler handler = 
								new GetHuDongKongJianHandler(GetHuDongKongJianManager.this.home, view, dialog);
						GetHuDongKongJianThread thread = 
								new GetHuDongKongJianThread(GetHuDongKongJianManager.this.home, groupId,
										String.valueOf(nowpagenum+1), "10", handler);
						thread.start();
					}
				});
				GetHuDongKongJianHandler handler = 
						new GetHuDongKongJianHandler(GetHuDongKongJianManager.this.home, view, dialog);
				GetHuDongKongJianThread thread = 
						new GetHuDongKongJianThread(GetHuDongKongJianManager.this.home, groupId,
								"1", "10", handler);
				thread.start();
			}
		});
		business.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 业务部
				BootstrapEditText nowpage=(BootstrapEditText) GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_nowpage);
				nowpage.setText("1");
				LoadingDialog dialog = new LoadingDialog(GetHuDongKongJianManager.this.home,
						"正在获取数据");
				dialog.show();
				groupId = "2";
				XListView view=(XListView) GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_list);
				view.setPullLoadEnable(true);
				view.setXListViewListener(new IXListViewListener() {
					
					@Override
					public void onRefresh() {
						// TODO 刷新
						BootstrapEditText nowpage=(BootstrapEditText) GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_nowpage);
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						if(nowpagenum<=1){
							nowpagenum=1;
						}else{
							nowpagenum=nowpagenum-1;
						}
						nowpage.setText(String.valueOf(nowpagenum));
						LoadingDialog dialog = new LoadingDialog(GetHuDongKongJianManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_list);
						GetHuDongKongJianHandler handler = 
								new GetHuDongKongJianHandler(GetHuDongKongJianManager.this.home, view, dialog);
						GetHuDongKongJianThread thread = 
								new GetHuDongKongJianThread(GetHuDongKongJianManager.this.home, groupId,
										String.valueOf(nowpagenum), "10", handler);
						thread.start();
					}
					
					@Override
					public void onLoadMore() {
						// TODO 加载更多
						BootstrapEditText nowpage=(BootstrapEditText) GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_nowpage);
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						nowpage.setText(String.valueOf(nowpagenum + 1));
						LoadingDialog dialog = new LoadingDialog(GetHuDongKongJianManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) GetHuDongKongJianManager.this.home.findViewById(R.id.employee_interactive_list);
						GetHuDongKongJianHandler handler = 
								new GetHuDongKongJianHandler(GetHuDongKongJianManager.this.home, view, dialog);
						GetHuDongKongJianThread thread = 
								new GetHuDongKongJianThread(GetHuDongKongJianManager.this.home, groupId,
										String.valueOf(nowpagenum+1), "10", handler);
						thread.start();
					}
				});
				GetHuDongKongJianHandler handler = 
						new GetHuDongKongJianHandler(GetHuDongKongJianManager.this.home, view, dialog);
				GetHuDongKongJianThread thread = 
						new GetHuDongKongJianThread(GetHuDongKongJianManager.this.home, groupId,
								"1", "10", handler);
				thread.start();
			}
		});
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 发布新评论
				Intent i = new Intent(GetHuDongKongJianManager.this.home, EmployeeInteractiveSendWindow.class);  
				Bundle b = new Bundle();
				b.putString("groupId", groupId);
				i.putExtras(b);  
				GetHuDongKongJianManager.this.home.startActivityForResult(i, 0);
				GetHuDongKongJianManager.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		
	}
	
}
