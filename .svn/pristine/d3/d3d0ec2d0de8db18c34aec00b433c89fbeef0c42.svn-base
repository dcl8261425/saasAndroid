package com.herotculb.qunhaichat.homeactiviti.employee;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.employee.meeting.GetCustomerMeetingInfoHandler;
import com.herotculb.qunhaichat.employee.meeting.GetCustomerMeetingInfoThread;
import com.herotculb.qunhaichat.employee.performance.GetPerformanceHandler;
import com.herotculb.qunhaichat.employee.performance.GetPerformanceThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class PerformanceManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	String startDate;
	String endDate;
	int layout;
	
	public PerformanceManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//签到管理
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.employee_performance_layout, null)
				.findViewById(R.id.employee_performance_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		LoadingDialog dialog = new LoadingDialog(PerformanceManager.this.home, "正在获取数据");
		dialog.show();
		XListView view=(XListView) PerformanceManager.this.home.findViewById(R.id.employee_performance_list);
		layout = R.layout.employee_performance_list;
		view.setPullLoadEnable(true);
		BootstrapEditText startedit=(BootstrapEditText) PerformanceManager.this.home.findViewById(R.id.employee_performance_start_date);
		BootstrapEditText endedit=(BootstrapEditText) PerformanceManager.this.home.findViewById(R.id.employee_performance_end_date);
		startDate = startedit.getText().toString();
		endDate = endedit.getText().toString();
		if(startDate==null || startDate.equals("")){
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		        
	        //获取前月的第一天
	        Calendar   cal_1=Calendar.getInstance();//获取当前日期 
//	        cal_1.add(Calendar.MONTH, -1);
	        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	        startDate = format.format(cal_1.getTime());
		}
		startedit.setText(startDate);
		if(endDate==null || endDate.equals("")){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			
			Calendar   cal_1=Calendar.getInstance();//获取当前日期 
			endDate = format.format(cal_1.getTime());
		}
		endedit.setText(endDate);
		Log.e("startDate--", startDate+"--"+endDate);
		GetPerformanceHandler handler = 
				new GetPerformanceHandler(PerformanceManager.this.home, view, dialog);
		GetPerformanceThread thread = 
				new GetPerformanceThread(PerformanceManager.this.home, startDate, endDate, handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) PerformanceManager.this.home.findViewById(R.id.employee_performance_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按电话号查询
				BootstrapEditText startedit=(BootstrapEditText) PerformanceManager.this.home.findViewById(R.id.employee_performance_start_date);
				BootstrapEditText endedit=(BootstrapEditText) PerformanceManager.this.home.findViewById(R.id.employee_performance_end_date);
				String startDate=startedit.getText().toString();
				String endDate=endedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(PerformanceManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) PerformanceManager.this.home.findViewById(R.id.employee_performance_list);
				GetPerformanceHandler handler = 
						new GetPerformanceHandler(PerformanceManager.this.home, view, dialog);
				GetPerformanceThread thread = 
						new GetPerformanceThread(PerformanceManager.this.home, startDate, endDate, handler);
				thread.start();
			}
		});
		BootstrapButton dateBtn=(BootstrapButton) PerformanceManager.this.home.findViewById(R.id.employee_performance_start_datebtn);
		dateBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 选择日期
				
			}
		});
		BootstrapButton edateBtn=(BootstrapButton) PerformanceManager.this.home.findViewById(R.id.employee_performance_end_datebtn);
		edateBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 选择日期
				
			}
		});
	}
	
}
