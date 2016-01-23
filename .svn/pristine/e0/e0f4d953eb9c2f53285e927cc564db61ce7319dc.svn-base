package com.herotculb.qunhaichat.group.window;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.group.GetGroupCompanyUserHandler;
import com.herotculb.qunhaichat.group.GetGroupCompanyUserThread;
import com.herotculb.qunhaichat.homeactiviti.group.GroupManager;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 上层组用户列表
 * @author lkx
 *
 */
public class PermissionInsertGetGroupCompanyUserWindow extends Activity {
	private BootstrapButton query;
	private BootstrapButton cancle;
	private XListView list;	
	private BootstrapEditText groupName;
	private BootstrapEditText name;
	private BootstrapEditText groupId;
	String classes;
	String groupIdStr;
	int layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.permission_insert_company_group_window);
		query =(BootstrapButton)findViewById(R.id.permission_insert_company_group_name_query);
		cancle =(BootstrapButton)findViewById(R.id.permission_insert_company_group_cancle);
		groupName = (BootstrapEditText)findViewById(R.id.permission_insert_company_group_gname);
		groupId = (BootstrapEditText)findViewById(R.id.permission_insert_company_group_id);
		list = (XListView)findViewById(R.id.permission_insert_company_group_list);
		layout = R.layout.permission_insert_company_group_list;
		Bundle bundle = getIntent().getExtras();
		groupIdStr = bundle.getString("groupId").toString();
		classes = bundle.getString("classes");
		groupId.setText(groupIdStr);
		
		list.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) 
						PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) 
						PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog2 = new LoadingDialog(
						PermissionInsertGetGroupCompanyUserWindow.this, "正在获取数据");
				dialog2.show();
				GetGroupCompanyUserHandler handler = 
						new GetGroupCompanyUserHandler(PermissionInsertGetGroupCompanyUserWindow.this, list, dialog2, classes,groupIdStr,layout);
				GetGroupCompanyUserThread thread = 
						new GetGroupCompanyUserThread(PermissionInsertGetGroupCompanyUserWindow.this,String.valueOf(nowpagenum),"10",namestr, handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) 
						PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) 
						PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog2 = new LoadingDialog(
						PermissionInsertGetGroupCompanyUserWindow.this, "正在获取数据");
				dialog2.show();
				GetGroupCompanyUserHandler handler = 
						new GetGroupCompanyUserHandler(PermissionInsertGetGroupCompanyUserWindow.this, list, dialog2, classes,groupIdStr,layout);
				GetGroupCompanyUserThread thread = 
						new GetGroupCompanyUserThread(PermissionInsertGetGroupCompanyUserWindow.this,String.valueOf(nowpagenum+1),"10",namestr, handler);
				thread.start();
			}
		});
		LoadingDialog dialog2 = new LoadingDialog(
				PermissionInsertGetGroupCompanyUserWindow.this, "正在获取数据");
		dialog2.show();
		GetGroupCompanyUserHandler handler = 
				new GetGroupCompanyUserHandler(PermissionInsertGetGroupCompanyUserWindow.this, list, dialog2, classes,groupIdStr,layout);
		GetGroupCompanyUserThread thread = 
				new GetGroupCompanyUserThread(PermissionInsertGetGroupCompanyUserWindow.this,"1","10","", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) 
				PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 查询
				BootstrapEditText nowpage=(BootstrapEditText) 
						PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) 
						PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_name);
				String namestr=nameedit.getText().toString();
				nowpage.setText("1");
				LoadingDialog dialog = new LoadingDialog(PermissionInsertGetGroupCompanyUserWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) 
						PermissionInsertGetGroupCompanyUserWindow.this.findViewById(R.id.permission_insert_company_group_list);
				GetGroupCompanyUserHandler handler = 
						new GetGroupCompanyUserHandler(PermissionInsertGetGroupCompanyUserWindow.this, list, dialog, classes,groupIdStr,R.layout.permission_insert_company_group_list);
				GetGroupCompanyUserThread thread = 
						new GetGroupCompanyUserThread(PermissionInsertGetGroupCompanyUserWindow.this,"1","10",namestr, handler);
				thread.start();
			}
		});
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 取消
				PermissionInsertGetGroupCompanyUserWindow.this.finish();
			}
		});
		
	}
	
}
