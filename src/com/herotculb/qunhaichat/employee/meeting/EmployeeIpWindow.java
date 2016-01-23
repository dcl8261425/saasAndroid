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
 * 网络IP的window
 * @author lkx
 *
 */
public class EmployeeIpWindow extends Activity {
	private TextView ip1;
	private TextView ip2;
	String ip1Str;
	String ip2Str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_ip_window);		
		ip1 = (TextView)findViewById(R.id.employee_ip1);
		ip2 = (TextView)findViewById(R.id.employee_ip2);
		
		ip1Str = ip1.getText().toString();
		ip2Str = ip2.getText().toString();
		
		ip1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeeIpWindow.this,GetMeetingSetInfoWindow.class);
				Bundle b = new Bundle();
				b.putString("type", "employee_ip1");
				b.putString("ip1Str", ip1Str);
				b.putString("ip1", "true");
				i.putExtras(b);
				EmployeeIpWindow.this.setResult(EmployeeIpWindow.RESULT_OK, i);
				EmployeeIpWindow.this.finish();
			}
		});
		ip2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(EmployeeIpWindow.this,GetMeetingSetInfoWindow.class);
				Bundle b = new Bundle();
				b.putString("type", "employee_ip2");
				b.putString("ip2Str", ip2Str);
				b.putString("ip2", "false");
				i.putExtras(b);
				EmployeeIpWindow.this.setResult(EmployeeIpWindow.RESULT_OK, i);
				EmployeeIpWindow.this.finish();
			}
		});
	}
	
}
