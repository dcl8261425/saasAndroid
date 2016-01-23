package com.herotculb.qunhaichat.homeactiviti.employee;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.employee.manager.QueryCustomerHandler;
import com.herotculb.qunhaichat.employee.manager.QueryCustomerThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class QueryCustomerManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	int layout;
	
	public QueryCustomerManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//仓库信息
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.employee_query_customer_window, null)
				.findViewById(R.id.employee_query_customer_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		LoadingDialog dialog = new LoadingDialog(QueryCustomerManager.this.home, "正在获取数据");
		dialog.show();
		XListView view=(XListView) QueryCustomerManager.this.home.findViewById(R.id.employee_query_customer_list);
		layout = R.layout.employee_query_customer_list;
		view.setPullLoadEnable(true);
		QueryCustomerHandler handler =  
				new QueryCustomerHandler(QueryCustomerManager.this.home, view, dialog, layout);
		QueryCustomerThread thread = 
				new QueryCustomerThread(QueryCustomerManager.this.home, "1", "10", "", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) QueryCustomerManager.this.home.findViewById(R.id.employee_query_customer_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按电话号查询
				BootstrapEditText nameedit=(BootstrapEditText) QueryCustomerManager.this.home.findViewById(R.id.employee_query_customer_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(QueryCustomerManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryCustomerManager.this.home.findViewById(R.id.employee_query_customer_list);
				QueryCustomerHandler handler =  
						new QueryCustomerHandler(QueryCustomerManager.this.home, view, dialog, layout);
				QueryCustomerThread thread = 
						new QueryCustomerThread(QueryCustomerManager.this.home, "1", "10", namestr, handler);
				thread.start();
			}
		});
	}
	
}
