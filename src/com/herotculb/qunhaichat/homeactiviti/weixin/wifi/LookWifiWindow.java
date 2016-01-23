package com.herotculb.qunhaichat.homeactiviti.weixin.wifi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class LookWifiWindow extends Activity{
	private String id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_wifi_look_layout);
		Intent intent=getIntent();
		Bundle b=intent.getExtras();
		String id=b.getString("id");
		this.id=id;
		BootstrapButton diceclose=(BootstrapButton) findViewById(R.id.weixin_wifi_look_layout_item_back);
		diceclose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LookWifiWindow.this, HomeActivity.class);  
		        Bundle b2 = new Bundle();
		        b2.putString("type", "cancel");
		        i.putExtras(b2);
		        setResult(RESULT_OK, i);  
		        finish();
			}
		});
		BootstrapEditText nowpage=(BootstrapEditText) findViewById(R.id.weixin_wifi_look_nowpage);
		nowpage.setText("1");
		LoadingDialog dialog = new LoadingDialog(LookWifiWindow.this,
				"正在获取数据");
		dialog.show();
		XListView view=(XListView) findViewById(R.id.weixin_wifi_look_list);
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) findViewById(R.id.weixin_wifi_look_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(LookWifiWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) LookWifiWindow.this.findViewById(R.id.weixin_wifi_look_list);
				LookWifiHandler handler = 
						new LookWifiHandler(LookWifiWindow.this, dialog,view,LookWifiWindow.this.id);
				LookWifiThread thread = 
						new LookWifiThread(LookWifiWindow.this,LookWifiWindow.this.id, String.valueOf(nowpagenum),
								"30", handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) findViewById(R.id.weixin_wifi_look_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum + 1));
				LoadingDialog dialog = new LoadingDialog(LookWifiWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) LookWifiWindow.this.findViewById(R.id.weixin_wifi_look_list);
				LookWifiHandler handler = 
						new LookWifiHandler(LookWifiWindow.this, dialog, view,LookWifiWindow.this.id);
				LookWifiThread thread = 
						new LookWifiThread(LookWifiWindow.this,LookWifiWindow.this.id, String.valueOf(nowpagenum+1),
								"30", handler);
				thread.start();
			}
		});
		LookWifiHandler handler = 
				new LookWifiHandler(LookWifiWindow.this, dialog, view,id);
		LookWifiThread thread = 
				new LookWifiThread(LookWifiWindow.this,id, "1",
						"30", handler);
		thread.start();
	}
}
