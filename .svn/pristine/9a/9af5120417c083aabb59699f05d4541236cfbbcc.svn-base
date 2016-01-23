package com.herotculb.qunhaichat.homeactiviti.crm;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.mycustomer.QueryMyCustomerHandler;
import com.herotculb.qunhaichat.crm.mycustomer.QueryMyCustomerThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class QueryMyCustomerManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public QueryMyCustomerManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//分配给我的客户机会
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.crm_query_my_chance_layout, null)
				.findViewById(R.id.crm_query_my_chance_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapEditText nowpage=(BootstrapEditText) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
		nowpage.setText("1");
		LoadingDialog dialog = new LoadingDialog(QueryMyCustomerManager.this.home, "正在获取数据");
		dialog.show();
		BootstrapButton create=(BootstrapButton) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_new);
		create.setVisibility(View.GONE);
		XListView view=(XListView) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_list);
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(QueryMyCustomerManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_list);
				QueryMyCustomerHandler handler = 
						new QueryMyCustomerHandler(QueryMyCustomerManager.this.home, view, dialog);
				QueryMyCustomerThread thread = 
						new QueryMyCustomerThread(QueryMyCustomerManager.this.home, String.valueOf(nowpagenum), "10", namestr, handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog = new LoadingDialog(QueryMyCustomerManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_list);
				QueryMyCustomerHandler handler = 
						new QueryMyCustomerHandler(QueryMyCustomerManager.this.home, view, dialog);
				QueryMyCustomerThread thread = 
						new QueryMyCustomerThread(QueryMyCustomerManager.this.home, String.valueOf(nowpagenum+1), "10", namestr, handler);
				thread.start();
			}
		});
		QueryMyCustomerHandler handler = 
				new QueryMyCustomerHandler(QueryMyCustomerManager.this.home, view, dialog);
		QueryMyCustomerThread thread = 
				new QueryMyCustomerThread(QueryMyCustomerManager.this.home, "1", "10", "", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 按机会名查询
				BootstrapEditText nowpage=(BootstrapEditText) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(QueryMyCustomerManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryMyCustomerManager.this.home.findViewById(R.id.crm_query_my_chance_list);
				QueryMyCustomerHandler handler = 
						new QueryMyCustomerHandler(QueryMyCustomerManager.this.home, view, dialog);
				QueryMyCustomerThread thread = 
						new QueryMyCustomerThread(QueryMyCustomerManager.this.home, "1", "10", namestr, handler);
				thread.start();
			}
		});
	}
	
}
