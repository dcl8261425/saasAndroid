package com.herotculb.qunhaichat.goods.store.window;

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
import com.herotculb.qunhaichat.group.GetUserInGroupHandler;
import com.herotculb.qunhaichat.group.GetUserInGroupThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 选择组
 * @author lkx
 *
 */
public class GetUserInGroupWindow extends Activity {
	private BootstrapButton query;
	private BootstrapButton exit;
	private ListView list;	
	private BootstrapEditText groupName;
	private Class clazz;
	int layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.user_in_group_window);
		query =(BootstrapButton)findViewById(R.id.user_in_group_name_query);
		exit =(BootstrapButton)findViewById(R.id.user_in_group_name_exit);
		groupName = (BootstrapEditText)findViewById(R.id.user_in_group_name);
		list = (ListView)findViewById(R.id.user_in_group_list);
		layout = R.layout.user_in_group_list;
		Bundle bundle = getIntent().getExtras();
		String classes = bundle.getString("classes");
		try {
			Class clazz1 = Class.forName(classes);
			clazz = clazz1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 查询项目
				Log.e("handler--", "ingroupwindow");
			}
		});
		
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 退出查询
				GetUserInGroupWindow.this.finish();
			}
		});
		
		LoadingDialog dialog2 = new LoadingDialog(
				GetUserInGroupWindow.this, "正在获取数据");
		dialog2.show();
		GetUserInGroupHandler handler = 
				new GetUserInGroupHandler(GetUserInGroupWindow.this, list, dialog2, classes, "false",layout);
		GetUserInGroupThread thread = 
				new GetUserInGroupThread(GetUserInGroupWindow.this, handler);
		thread.start();
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
		        if(type.equals("select_username")){
		        	String userId = bundle.getString("userId");
		        	String userName = bundle.getString("userName");
		        	if(userName!=""){
		        		Intent i = new Intent(GetUserInGroupWindow.this, clazz);  
						Bundle b = new Bundle(); 
						b.putString("type", "select_username_group");
						b.putString("userId", userId);
						b.putString("userName", userName);
						i.putExtras(b);  
						GetUserInGroupWindow.this.setResult(GetUserInGroupWindow.this.RESULT_OK, i);
						GetUserInGroupWindow.this.finish();
		        	}
		        }
		 }
	
}
