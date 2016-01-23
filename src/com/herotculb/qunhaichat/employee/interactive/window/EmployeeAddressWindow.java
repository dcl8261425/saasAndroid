package com.herotculb.qunhaichat.employee.interactive.window;

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
import com.herotculb.qunhaichat.weixin.addgame.WeixinAddAwardsHandler;
import com.herotculb.qunhaichat.weixin.addgame.WeixinAddAwardsThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class EmployeeAddressWindow extends Activity {
	private BootstrapButton enter;
	private BootstrapButton calcel;
	private BootstrapEditText id;
	private BootstrapEditText content;  //名字
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_address_window);
		enter =(BootstrapButton)findViewById(R.id.employee_address_content_enter);
		calcel = (BootstrapButton)findViewById(R.id.employee_address_content_cancel);
		id=(BootstrapEditText) findViewById(R.id.employee_address_id);
		content=(BootstrapEditText) findViewById(R.id.employee_address_content);
		
		Bundle bundle = getIntent().getExtras();
		String type = bundle.getString("bundle");
		if(type.equals("img")){
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 把地址返回去
					Intent i = new Intent(EmployeeAddressWindow.this, EmployeeInteractiveSendWindow.class);  
					Bundle b = new Bundle();
					b.putString("type", "img");
					b.putString("image", content.getText().toString());
					i.putExtras(b);  
					EmployeeAddressWindow.this.setResult(EmployeeAddressWindow.this.RESULT_OK, i);
					EmployeeAddressWindow.this.finish();
				}
			});
		}
		if(type.equals("file")){
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 把地址返回去
					Intent i = new Intent(EmployeeAddressWindow.this, EmployeeInteractiveSendWindow.class);  
					Bundle b = new Bundle();
					b.putString("type", "file");
					b.putString("file", content.getText().toString());
					i.putExtras(b);  
					EmployeeAddressWindow.this.setResult(EmployeeAddressWindow.this.RESULT_OK, i);
					EmployeeAddressWindow.this.finish();
				}
			});
		}
		if(type.equals("video")){
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 把地址返回去
					Intent i = new Intent(EmployeeAddressWindow.this, EmployeeInteractiveSendWindow.class);  
					Bundle b = new Bundle();
					b.putString("type", "video");
					b.putString("video", content.getText().toString());
					i.putExtras(b);  
					EmployeeAddressWindow.this.setResult(EmployeeAddressWindow.this.RESULT_OK, i);
					EmployeeAddressWindow.this.finish();
				}
			});
		}
		
		calcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				EmployeeAddressWindow.this.finish();
			}
		});
	}
}
