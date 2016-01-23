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
public class CustomerLevelWindow extends Activity {
	private TextView level1;
	private TextView level2;
	private TextView level3;
	private TextView level4;
	String level1Str;
	String level2Str;
	String level3Str;
	String level4Str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.crm_customer_level_window);		
		level1 = (TextView)findViewById(R.id.customer_level1);
		level2 = (TextView)findViewById(R.id.customer_level2);
		level3 = (TextView)findViewById(R.id.customer_level3);
		level4 = (TextView)findViewById(R.id.customer_level4);
		
		level1Str = level1.getText().toString();
		level2Str = level2.getText().toString();
		level3Str = level3.getText().toString();
		level4Str = level4.getText().toString();
		
		level1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(CustomerLevelWindow.this,CreateChanceWindow.class);
				Bundle b = new Bundle();
				b.putString("type", "customer_level1");
				b.putString("level1Str", level1Str);
				b.putString("level1", "1");
				i.putExtras(b);
				CustomerLevelWindow.this.setResult(CustomerLevelWindow.RESULT_OK, i);
				CustomerLevelWindow.this.finish();
			}
		});
		level2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 返回
				Intent i = new Intent(CustomerLevelWindow.this,CreateChanceWindow.class);
				Bundle b = new Bundle();
				b.putString("type", "customer_level2");
				b.putString("level2Str", level2Str);
				b.putString("level2", "2");
				i.putExtras(b);
				CustomerLevelWindow.this.setResult(CustomerLevelWindow.RESULT_OK, i);
				CustomerLevelWindow.this.finish();
			}
		});
	level3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO 返回
			Intent i = new Intent(CustomerLevelWindow.this,CreateChanceWindow.class);
			Bundle b = new Bundle();
			b.putString("type", "customer_level3");
			b.putString("level3Str", level3Str);
			b.putString("level3", "3");
			i.putExtras(b);
			CustomerLevelWindow.this.setResult(CustomerLevelWindow.RESULT_OK, i);
			CustomerLevelWindow.this.finish();
		}
	});
	level4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO 返回
			Intent i = new Intent(CustomerLevelWindow.this,CreateChanceWindow.class);
			Bundle b = new Bundle();
			b.putString("type", "customer_level4");
			b.putString("level4Str", level4Str);
			b.putString("level4", "4");
			i.putExtras(b);
			CustomerLevelWindow.this.setResult(CustomerLevelWindow.RESULT_OK, i);
			CustomerLevelWindow.this.finish();
		}
	});
	}
	
}
