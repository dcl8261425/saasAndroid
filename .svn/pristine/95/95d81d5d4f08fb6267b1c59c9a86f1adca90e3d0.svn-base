package com.herotculb.qunhaichat.permission.window;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.permission.LookUpPermissionByRoleHandler;
import com.herotculb.qunhaichat.permission.LookUpPermissionByRoleThread;
import com.herotculb.qunhaichat.permission.LookUpRoleAllHandler;
import com.herotculb.qunhaichat.permission.LookUpRoleAllThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 根据角色选权限
 * @author lkx
 *
 */
public class LookUpPermissionByRoleWindow extends Activity {
	private BootstrapButton query;
	private BootstrapButton add;
	private BootstrapButton cancle;
	private ListView list;	
	private BootstrapEditText groupName;
	private BootstrapEditText name;
	private BootstrapEditText groupId;
	String classes;
	String groupIdStr;
	String roleIdStr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.permission_lookup_by_role_window);
		query =(BootstrapButton)findViewById(R.id.permission_lookup_by_role_name_query);
		add =(BootstrapButton)findViewById(R.id.permission_lookup_by_role_name_add);
		cancle =(BootstrapButton)findViewById(R.id.permission_lookup_by_role_cancle);
		groupName = (BootstrapEditText)findViewById(R.id.permission_lookup_by_role_gname);
		groupId = (BootstrapEditText)findViewById(R.id.permission_lookup_by_role_id);
		list = (ListView)findViewById(R.id.permission_lookup_by_role_list);
		Bundle bundle = getIntent().getExtras();
		groupIdStr = bundle.getString("groupId").toString();
		roleIdStr = bundle.getString("roleId");
		groupId.setText(groupIdStr);
		
		LoadingDialog dialog2 = new LoadingDialog(
				LookUpPermissionByRoleWindow.this, "正在获取数据");
		dialog2.show();
		LookUpPermissionByRoleHandler handler = 
				new LookUpPermissionByRoleHandler(LookUpPermissionByRoleWindow.this, list, dialog2,roleIdStr);
		LookUpPermissionByRoleThread thread = 
				new LookUpPermissionByRoleThread(LookUpPermissionByRoleWindow.this, "",groupIdStr, roleIdStr, handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) 
				LookUpPermissionByRoleWindow.this.findViewById(R.id.permission_lookup_by_role_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 查询
				BootstrapEditText nameedit=(BootstrapEditText) 
						LookUpPermissionByRoleWindow.this.findViewById(R.id.permission_lookup_by_role_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(LookUpPermissionByRoleWindow.this, "正在获取数据");
				dialog.show();
				ListView view=(ListView) 
						LookUpPermissionByRoleWindow.this.findViewById(R.id.permission_lookup_by_role_list);
				LookUpPermissionByRoleHandler handler = 
						new LookUpPermissionByRoleHandler(LookUpPermissionByRoleWindow.this, list, dialog,roleIdStr);
				LookUpPermissionByRoleThread thread = 
						new LookUpPermissionByRoleThread(LookUpPermissionByRoleWindow.this, namestr,groupIdStr, roleIdStr, handler);
				thread.start();
			}
		});
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 添加权限
				Intent i = new Intent(LookUpPermissionByRoleWindow.this, LookUpPermissionMainWindow.class);  
				Bundle b = new Bundle();
				b.putString("groupId", groupIdStr);
				b.putString("roleId", roleIdStr);				
                i.putExtras(b);  
                LookUpPermissionByRoleWindow.this.startActivityForResult(i,0);
                LookUpPermissionByRoleWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 取消
				LookUpPermissionByRoleWindow.this.finish();
			}
		});
		
	}
	
	//弹出框返回的内容在这里接受
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data); 
	        //取出字符串  
	        Log.e("add_permission_to_role--", "success");
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
	    				LookUpPermissionByRoleWindow.this.findViewById(R.id.permission_lookup_by_role_name_query);
	    		b.performClick();
	        }
	 }
	
}
