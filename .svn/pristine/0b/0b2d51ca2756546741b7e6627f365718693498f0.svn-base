package com.herotculb.qunhaichat.employee.meeting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.CreateChanceWindow;
import com.herotculb.qunhaichat.crm.querychance.QueryLinkManHandler;
import com.herotculb.qunhaichat.crm.querychance.QueryLinkManThread;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceLinkManHandler;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceLinkManThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 签到状态的window
 * @author lkx
 *
 */
public class EmployeChangeStuteWindow extends Activity {
	private TextView stute1;
	private TextView stute2;
	private TextView stute3;
	private TextView stute4;
	private TextView stute5;
	
	String stute1Str;
	String stute2Str;
	String stute3Str;
	String stute4Str;
	String stute5Str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_change_stute_window);		
		stute1 = (TextView)findViewById(R.id.employee_stute1);
		stute2 = (TextView)findViewById(R.id.employee_stute2);
		stute3 = (TextView)findViewById(R.id.employee_stute3);
		stute4 = (TextView)findViewById(R.id.employee_stute4);
		stute5 = (TextView)findViewById(R.id.employee_stute5);
		
		stute1Str = stute1.getText().toString();
		stute2Str = stute2.getText().toString();
		stute3Str = stute3.getText().toString();
		stute4Str = stute4.getText().toString();
		stute5Str = stute5.getText().toString();
		
		stute1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeChangeStuteWindow.this,HomeActivity.class);
				Bundle b = new Bundle();
				b.putString("type", "employee_stute1");
				b.putString("stute1Str", stute1Str);
				b.putString("stute1", "1");
				i.putExtras(b);
				EmployeChangeStuteWindow.this.setResult(EmployeChangeStuteWindow.RESULT_OK, i);
				EmployeChangeStuteWindow.this.finish();
			}
		});
		stute2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeChangeStuteWindow.this,HomeActivity.class);
				Bundle b = new Bundle();
				b.putString("type", "employee_stute2");
				b.putString("stute2Str", stute2Str);
				b.putString("stute2", "2");
				i.putExtras(b);
				EmployeChangeStuteWindow.this.setResult(EmployeChangeStuteWindow.RESULT_OK, i);
				EmployeChangeStuteWindow.this.finish();
			}
		});
		stute3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeChangeStuteWindow.this,HomeActivity.class);
				Bundle b = new Bundle();
				b.putString("type", "employee_stute3");
				b.putString("stute3Str", stute3Str);
				b.putString("stute3", "3");
				i.putExtras(b);
				EmployeChangeStuteWindow.this.setResult(EmployeChangeStuteWindow.RESULT_OK, i);
				EmployeChangeStuteWindow.this.finish();
			}
		});
		stute4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeChangeStuteWindow.this,HomeActivity.class);
				Bundle b = new Bundle();
				b.putString("type", "employee_stute4");
				b.putString("stute4Str", stute4Str);
				b.putString("stute4", "4");
				i.putExtras(b);
				EmployeChangeStuteWindow.this.setResult(EmployeChangeStuteWindow.RESULT_OK, i);
				EmployeChangeStuteWindow.this.finish();
			}
		});
		stute5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeChangeStuteWindow.this,HomeActivity.class);
				Bundle b = new Bundle();
				b.putString("type", "employee_stute5");
				b.putString("stute5Str", stute5Str);
				b.putString("stute5", "5");
				i.putExtras(b);
				EmployeChangeStuteWindow.this.setResult(EmployeChangeStuteWindow.RESULT_OK, i);
				EmployeChangeStuteWindow.this.finish();
			}
		});
	}
	
}
