package com.herotculb.qunhaichat.permission.window;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.goods.operationstore.GoodsAddStoreHouseHandler;
import com.herotculb.qunhaichat.goods.operationstore.GoodsAddStoreHouseThread;
import com.herotculb.qunhaichat.goods.operationstore.GoodsUpdateStoreHouseHandler;
import com.herotculb.qunhaichat.goods.operationstore.GoodsUpdateStoreHouseThread;
import com.herotculb.qunhaichat.group.operation.CreateGroupHandler;
import com.herotculb.qunhaichat.group.operation.CreateGroupThread;
import com.herotculb.qunhaichat.permission.operation.AddRoleHandler;
import com.herotculb.qunhaichat.permission.operation.AddRoleThread;
import com.herotculb.qunhaichat.weixin.getvip.window.VipUpdateWindowActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 添加角色
 * @author lkx
 *
 */
public class AddRoleWindow extends Activity {
	private BootstrapButton enter;
	private BootstrapButton calcel;
		
	private BootstrapEditText id;
	private BootstrapEditText name;
	private BootstrapEditText marks;
	private String groupId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.permission_add_role_window);
		enter =(BootstrapButton)findViewById(R.id.permission_role_content_enter);
		calcel = (BootstrapButton)findViewById(R.id.permission_role_content_cancel);
		id = (BootstrapEditText)findViewById(R.id.permission_role_id);
		name = (BootstrapEditText)findViewById(R.id.permission_role_name);
		marks = (BootstrapEditText)findViewById(R.id.permission_role_marks);
		Bundle bundle = getIntent().getExtras();
		Object idstr = (Object) bundle.get("id");
		Object namestr = (Object) bundle.get("name");
		Object marksstr = (Object) bundle.get("marks");
		groupId = bundle.getString("groupId");
		if(idstr!=null&&!idstr.equals("")){
			id.setText(idstr.toString());
			name.setText(namestr.toString());
			marks.setText(marksstr.toString());
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					LoadingDialog dialog2 = new LoadingDialog(
							AddRoleWindow.this, "正在获取数据");
					dialog2.show();
//					CreateGroupHandler handler = 
//							new CreateGroupHandler(CreateGroupWindow.this, dialog2);
//					CreateGroupThread thread = 
//							new CreateGroupThread(CreateGroupWindow.this, handler);
//					thread.start();
				}
			});
		}else{
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					LoadingDialog dialog2 = new LoadingDialog(
							AddRoleWindow.this, "正在获取数据");
					dialog2.show();
					AddRoleHandler handler = 
							new AddRoleHandler(AddRoleWindow.this, dialog2);
					AddRoleThread thread = 
							new AddRoleThread(AddRoleWindow.this,groupId, handler);
					thread.start();
				}
			});
		}
		
		calcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				AddRoleWindow.this.finish();
			}
		});
		
	}
	
}
