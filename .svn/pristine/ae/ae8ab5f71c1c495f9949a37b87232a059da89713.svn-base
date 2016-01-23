package com.herotculb.qunhaichat.permission.window;

import android.app.Activity;
import android.content.Intent;
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
import com.herotculb.qunhaichat.group.window.CreateGroupWindow;
import com.herotculb.qunhaichat.homeactiviti.group.GroupManager;
import com.herotculb.qunhaichat.permission.LookUpRoleAllHandler;
import com.herotculb.qunhaichat.permission.LookUpRoleAllThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 选择组成员
 * @author lkx
 *
 */
public class LookUpRoleAllWindow extends Activity {
	private BootstrapButton query;
	private BootstrapButton add;
	private BootstrapButton cancle;
	private ListView list;	
	private BootstrapEditText groupName;
	private BootstrapEditText name;
	private BootstrapEditText groupId;
	String classes;
	String groupIdStr;
	String userId;
	int layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.permission_lookup_role_window);
		query =(BootstrapButton)findViewById(R.id.permission_lookup_role_name_query);
		add =(BootstrapButton)findViewById(R.id.permission_lookup_role_name_add);
		cancle =(BootstrapButton)findViewById(R.id.permission_lookup_role_cancle);
		groupName = (BootstrapEditText)findViewById(R.id.permission_lookup_role_gname);
		groupId = (BootstrapEditText)findViewById(R.id.permission_lookup_role_id);
		list = (ListView)findViewById(R.id.permission_lookup_role_list);
		layout = R.layout.permission_lookup_role_list;
		Bundle bundle = getIntent().getExtras();
		String groupNameStr = bundle.getString("groupName").toString();
		groupIdStr = bundle.getString("groupId").toString();
		userId = bundle.getString("userId");
		classes = bundle.getString("classes");
		groupName.setText(groupNameStr);
		groupId.setText(groupIdStr);
		
		LoadingDialog dialog2 = new LoadingDialog(
				LookUpRoleAllWindow.this, "正在获取数据");
		dialog2.show();
		LookUpRoleAllHandler handler = 
				new LookUpRoleAllHandler(LookUpRoleAllWindow.this, list, dialog2,userId,groupIdStr,layout);
		LookUpRoleAllThread thread = 
				new LookUpRoleAllThread(LookUpRoleAllWindow.this, groupIdStr, "", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) 
				LookUpRoleAllWindow.this.findViewById(R.id.permission_lookup_role_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 查询
				BootstrapEditText nameedit=(BootstrapEditText) 
						LookUpRoleAllWindow.this.findViewById(R.id.permission_lookup_role_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(LookUpRoleAllWindow.this, "正在获取数据");
				dialog.show();
				ListView view=(ListView) 
						LookUpRoleAllWindow.this.findViewById(R.id.permission_lookup_role_list);
				LookUpRoleAllHandler handler = 
						new LookUpRoleAllHandler(LookUpRoleAllWindow.this, list, dialog,userId,groupIdStr,layout);
				LookUpRoleAllThread thread = 
						new LookUpRoleAllThread(LookUpRoleAllWindow.this, groupIdStr, namestr, handler);
				thread.start();
			}
		});
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 添加角色
				Intent i = new Intent(LookUpRoleAllWindow.this, AddRoleWindow.class);  
				Bundle b = new Bundle();
				b.putString("groupId", groupIdStr);
                i.putExtras(b);  
                LookUpRoleAllWindow.this.startActivityForResult(i,0);
                LookUpRoleAllWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 取消
				LookUpRoleAllWindow.this.finish();
			}
		});
		
	}
	
	//弹出框返回的内容在这里接受
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data); 
	        //取出字符串  
	        if(data==null){
	        	return ;
	        }
	        Bundle bundle = data.getExtras();	        
	        if(bundle==null){
	        	return ;
	        }
	        String type=(String) bundle.get("type");
	        if(type.equals("add_role")){
	        	BootstrapButton b=(BootstrapButton) 
	    				LookUpRoleAllWindow.this.findViewById(R.id.permission_lookup_role_name_query);
	    		b.performClick();
	        }
	 }
	
}
