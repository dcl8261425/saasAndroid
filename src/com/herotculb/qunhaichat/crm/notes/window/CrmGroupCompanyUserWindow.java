package com.herotculb.qunhaichat.crm.notes.window;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.group.GetGroupCompanyUserHandler;
import com.herotculb.qunhaichat.group.GetGroupCompanyUserThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 选择组成员
 * @author lkx
 *
 */
public class CrmGroupCompanyUserWindow extends Activity {
	private BootstrapButton query;
	private ListView list;	
	private BootstrapEditText groupName;
	private BootstrapEditText name;
	private BootstrapEditText groupId;
	String classes;
	String groupIdStr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.user_company_group_window);
		query =(BootstrapButton)findViewById(R.id.user_company_group_name_query);
		groupName = (BootstrapEditText)findViewById(R.id.user_company_group_gname);
		groupId = (BootstrapEditText)findViewById(R.id.user_company_group_id);
		list = (ListView)findViewById(R.id.user_company_group_list);
		Bundle bundle = getIntent().getExtras();
		String groupNameStr = bundle.getString("groupName").toString();
		groupIdStr = bundle.getString("groupId").toString();
		classes = bundle.getString("classes");
		groupName.setText(groupNameStr);
		groupId.setText(groupIdStr);
		LoadingDialog dialog2 = new LoadingDialog(
				CrmGroupCompanyUserWindow.this, "正在获取数据");
		dialog2.show();
		GetGroupCompanyUserHandler handler = 
				new GetGroupCompanyUserHandler(CrmGroupCompanyUserWindow.this, list, dialog2, classes,groupIdStr,R.layout.user_company_group_list);
		GetGroupCompanyUserThread thread = 
				new GetGroupCompanyUserThread(CrmGroupCompanyUserWindow.this,"1","50","", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) 
				CrmGroupCompanyUserWindow.this.findViewById(R.id.user_company_group_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按真实姓名查询
				BootstrapEditText nowpage=(BootstrapEditText) 
						CrmGroupCompanyUserWindow.this.findViewById(R.id.user_company_group_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) 
						CrmGroupCompanyUserWindow.this.findViewById(R.id.user_company_group_name);
				String namestr=nameedit.getText().toString();
				nowpage.setText("1");
				LoadingDialog dialog = new LoadingDialog(CrmGroupCompanyUserWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) 
						CrmGroupCompanyUserWindow.this.findViewById(R.id.user_company_group_list);
				GetGroupCompanyUserHandler handler = 
						new GetGroupCompanyUserHandler(CrmGroupCompanyUserWindow.this, list, dialog, classes,groupIdStr,R.layout.user_company_group_list);
				GetGroupCompanyUserThread thread = 
						new GetGroupCompanyUserThread(CrmGroupCompanyUserWindow.this,"1","50",namestr, handler);
				thread.start();
			}
		});
		
	}
	
}
