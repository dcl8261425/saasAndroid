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
import com.herotculb.qunhaichat.employee.meeting.GetCustomerMeetingInfoHandler;
import com.herotculb.qunhaichat.employee.meeting.GetCustomerMeetingInfoThread;
import com.herotculb.qunhaichat.employee.meeting.GetMeetingSetInfoWindow;
import com.herotculb.qunhaichat.homeactiviti.weixin.game.GameManager;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.DateActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MeetingManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	int layout;
	
	public MeetingManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//签到管理
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.employee_meeting_layout, null)
				.findViewById(R.id.employee_meeting_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		LoadingDialog dialog = new LoadingDialog(MeetingManager.this.home, "正在获取数据");
		dialog.show();
		XListView view=(XListView) MeetingManager.this.home.findViewById(R.id.employee_meeting_list);
		layout = R.layout.employee_meeting_list;
		view.setPullLoadEnable(true);
		GetCustomerMeetingInfoHandler handler = 
				new GetCustomerMeetingInfoHandler(MeetingManager.this.home,view, dialog);
		GetCustomerMeetingInfoThread thread = 
				new GetCustomerMeetingInfoThread(MeetingManager.this.home,"", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) MeetingManager.this.home.findViewById(R.id.employee_meeting_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按电话号查询
				BootstrapEditText nameedit=(BootstrapEditText) MeetingManager.this.home.findViewById(R.id.employee_meeting_date);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(MeetingManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) MeetingManager.this.home.findViewById(R.id.employee_meeting_list);
				GetCustomerMeetingInfoHandler handler = 
						new GetCustomerMeetingInfoHandler(MeetingManager.this.home,view, dialog);
				GetCustomerMeetingInfoThread thread = 
						new GetCustomerMeetingInfoThread(MeetingManager.this.home,namestr, handler);
				thread.start();
			}
		});
		BootstrapButton dateBtn=(BootstrapButton) MeetingManager.this.home.findViewById(R.id.employee_meeting_datebtn);
		dateBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 选择日期
				Intent i = new Intent(MeetingManager.this.home, DateActivity.class);  
				Bundle b = new Bundle();
				b.putString("type", "employee_meeting_date");
				i.putExtras(b); 
				MeetingManager.this.home.startActivityForResult(i, 0);
			}
		});
		BootstrapButton setBtn=(BootstrapButton) MeetingManager.this.home.findViewById(R.id.employee_meeting_set);
		setBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 签到设置
				Intent i = new Intent(MeetingManager.this.home, GetMeetingSetInfoWindow.class);  
				Bundle b = new Bundle();
				i.putExtras(b);  
				MeetingManager.this.home.startActivityForResult(i, 0);
				MeetingManager.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
	}
	
}
