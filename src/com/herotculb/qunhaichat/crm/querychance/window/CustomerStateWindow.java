package com.herotculb.qunhaichat.crm.querychance.window;

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
 * 查看联系人的window
 * @author lkx
 *
 */
public class CustomerStateWindow extends Activity {
	private TextView state1;
	private TextView state2;
	private TextView state3;
	String state1Str;
	String state2Str;
	String state3Str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.crm_customer_state_window);		
		state1 = (TextView)findViewById(R.id.customer_state1);
		state2 = (TextView)findViewById(R.id.customer_state2);
		state3 = (TextView)findViewById(R.id.customer_state3);
		
		state1Str = state1.getText().toString();
		state2Str = state2.getText().toString();
		state3Str = state3.getText().toString();
		
		state1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(CustomerStateWindow.this,CreateChanceWindow.class);
				Bundle b = new Bundle();
				b.putString("type", "customer_state1");
				b.putString("state1Str", state1Str);
				b.putString("state1", "1");
				i.putExtras(b);
				CustomerStateWindow.this.setResult(CustomerStateWindow.RESULT_OK, i);
				CustomerStateWindow.this.finish();
			}
		});
		state2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(CustomerStateWindow.this,CreateChanceWindow.class);
				Bundle b = new Bundle();
				b.putString("type", "customer_state2");
				b.putString("state2Str", state2Str);
				b.putString("state2", "2");
				i.putExtras(b);
				CustomerStateWindow.this.setResult(CustomerStateWindow.RESULT_OK, i);
				CustomerStateWindow.this.finish();
			}
		});
	state3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO 返回
			Intent i = new Intent(CustomerStateWindow.this,CreateChanceWindow.class);
			Bundle b = new Bundle();
			b.putString("type", "customer_state3");
			b.putString("state3Str", state3Str);
			b.putString("state3", "3");
			i.putExtras(b);
			CustomerStateWindow.this.setResult(CustomerStateWindow.RESULT_OK, i);
			CustomerStateWindow.this.finish();
		}
	});
}
	
}
