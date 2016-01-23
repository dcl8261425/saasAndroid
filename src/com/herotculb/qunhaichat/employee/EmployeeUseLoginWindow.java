package com.herotculb.qunhaichat.employee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.CreateChanceWindow;
/**
 * 查看联系人的window
 * @author lkx
 *
 */
public class EmployeeUseLoginWindow extends Activity {
	private TextView useLogin1;
	private TextView useLogin2;
	private Class clazz;
	
	String useLogin1Str;
	String useLogin2Str;
	String classes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_use_login_window);
		Bundle bundle = getIntent().getExtras();
		classes = bundle.getString("classes");
		try {
			Class clazz1 = clazz.forName(classes);
			clazz = clazz1;
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		useLogin1 = (TextView)findViewById(R.id.employee_useLogin1);
		useLogin2 = (TextView)findViewById(R.id.employee_useLogin2);
		
		useLogin1Str = useLogin1.getText().toString();
		useLogin2Str = useLogin2.getText().toString();
		
		useLogin1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeeUseLoginWindow.this,clazz);
				Bundle b = new Bundle();
				b.putString("type", "add_linkman_useLogin1");
				b.putString("useLogin1Str", useLogin1Str);
				i.putExtras(b);
				EmployeeUseLoginWindow.this.setResult(EmployeeUseLoginWindow.RESULT_OK, i);
				EmployeeUseLoginWindow.this.finish();
			}
		});
		useLogin2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeeUseLoginWindow.this,clazz);
				Bundle b = new Bundle();
				b.putString("type", "add_linkman_useLogin2");
				b.putString("useLogin2Str", useLogin2Str);
				i.putExtras(b);
				EmployeeUseLoginWindow.this.setResult(EmployeeUseLoginWindow.RESULT_OK, i);
				EmployeeUseLoginWindow.this.finish();
			}
		});
	}
	
}
