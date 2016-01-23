package com.herotculb.qunhaichat.homeactiviti.crm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.CreateChanceWindow;
import com.herotculb.qunhaichat.crm.allchance.QueryAllChanceHandler;
import com.herotculb.qunhaichat.crm.allchance.QueryAllChanceThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class QueryAllChanceManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	int layout;
	public QueryAllChanceManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//我创建的客户机会
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.crm_query_my_chance_layout, null)
				.findViewById(R.id.crm_query_my_chance_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapEditText nowpage=(BootstrapEditText) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
		nowpage.setText("1");
		LoadingDialog dialog = new LoadingDialog(QueryAllChanceManager.this.home, "正在获取数据");
		dialog.show();
		XListView view=(XListView) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_list);
		layout = R.layout.crm_query_my_chance_list;
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(QueryAllChanceManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_list);
				QueryAllChanceHandler handler = 
						new QueryAllChanceHandler(QueryAllChanceManager.this.home, view, dialog,layout);
				QueryAllChanceThread thread = 
						new QueryAllChanceThread(QueryAllChanceManager.this.home, String.valueOf(nowpagenum), "10", namestr, handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog = new LoadingDialog(QueryAllChanceManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_list);
				QueryAllChanceHandler handler = 
						new QueryAllChanceHandler(QueryAllChanceManager.this.home, view, dialog,layout);
				QueryAllChanceThread thread = 
						new QueryAllChanceThread(QueryAllChanceManager.this.home, String.valueOf(nowpagenum+1), "10", namestr, handler);
				thread.start();
			}
		});
		QueryAllChanceHandler handler = 
				new QueryAllChanceHandler(QueryAllChanceManager.this.home, view, dialog,layout);
		QueryAllChanceThread thread = 
				new QueryAllChanceThread(QueryAllChanceManager.this.home, "1", "10", "", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 按机会名查询
				BootstrapEditText nowpage=(BootstrapEditText) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(QueryAllChanceManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_list);
				QueryAllChanceHandler handler = 
						new QueryAllChanceHandler(QueryAllChanceManager.this.home, view, dialog,layout);
				QueryAllChanceThread thread = 
						new QueryAllChanceThread(QueryAllChanceManager.this.home, "1", "10", namestr, handler);
				thread.start();
			}
		});
		BootstrapButton create=(BootstrapButton) QueryAllChanceManager.this.home.findViewById(R.id.crm_query_my_chance_new);
		create.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 创建新机会
				Intent i = new Intent(QueryAllChanceManager.this.home, CreateChanceWindow.class);  
				Bundle b = new Bundle(); 
				b.putString("type", "");
                i.putExtras(b);  
                QueryAllChanceManager.this.home.startActivityForResult(i,0);
                QueryAllChanceManager.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
	}
	
}
