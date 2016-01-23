package com.herotculb.qunhaichat.messageinfo.window;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.weixin.getvip.WeixinGetVipHandler;
import com.herotculb.qunhaichat.weixin.getvip.WeixinGetVipThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MessageVipWindow extends Activity {
	private BootstrapButton cancle;
	private ListView list;
	int layout;
	String marks;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.message_vip_window);
		cancle =(BootstrapButton)findViewById(R.id.message_game_vip_name_cancle);
		
		Bundle bundle = getIntent().getExtras();
		marks = bundle.getString("marks");
//		
		LoadingDialog dialog = new LoadingDialog(
				MessageVipWindow.this, "正在获取数据");
		dialog.show();
		XListView view=(XListView) MessageVipWindow.this.findViewById(R.id.message_game_vip_list);
		layout = R.layout.message_vip_list;
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) MessageVipWindow.this.findViewById(R.id.message_game_vip_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) MessageVipWindow.this.findViewById(R.id.message_game_vip_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(MessageVipWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) MessageVipWindow.this.findViewById(R.id.message_game_vip_list);
				WeixinGetVipHandler vipHandler = new WeixinGetVipHandler(
						MessageVipWindow.this, view, dialog,layout,marks);
				WeixinGetVipThread vipThread = new WeixinGetVipThread(
						MessageVipWindow.this, String.valueOf(nowpagenum), "10", namestr, vipHandler);
				vipThread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) 
						MessageVipWindow.this.findViewById(R.id.message_game_vip_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) MessageVipWindow.this.findViewById(R.id.message_game_vip_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=0;
				if(nowpage.getText().toString().equals("")){
					nowpagenum = 1;
				}else{
					nowpagenum=Integer.parseInt(nowpage.getText().toString());
				}
				nowpage.setText(String.valueOf(nowpagenum + 1));
				LoadingDialog dialog = new LoadingDialog(MessageVipWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) MessageVipWindow.this.findViewById(R.id.message_game_vip_list);
				WeixinGetVipHandler vipHandler = new WeixinGetVipHandler(
						
						MessageVipWindow.this, view, dialog,layout,marks);
				WeixinGetVipThread vipThread = new WeixinGetVipThread(
						MessageVipWindow.this, String.valueOf(nowpagenum+1), "10", namestr, vipHandler);
				vipThread.start();
			}
		});
		
		WeixinGetVipHandler vipHandler = new WeixinGetVipHandler(
				MessageVipWindow.this, view, dialog,layout,marks);
		WeixinGetVipThread vipThread = new WeixinGetVipThread(
				MessageVipWindow.this, "1", "10", "", vipHandler);
		vipThread.start();
		BootstrapButton query=(BootstrapButton) MessageVipWindow.this.findViewById(R.id.message_game_vip_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按电话号查询
				BootstrapEditText nowpage=(BootstrapEditText) MessageVipWindow.this.findViewById(R.id.message_game_vip_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) MessageVipWindow.this.findViewById(R.id.message_game_vip_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(MessageVipWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) MessageVipWindow.this.findViewById(R.id.message_game_vip_list);
				WeixinGetVipHandler handler=new WeixinGetVipHandler(MessageVipWindow.this,view,dialog,layout,marks);
				WeixinGetVipThread thread=new WeixinGetVipThread(MessageVipWindow.this,"1","10",namestr,handler);
				thread.start();
			}
		});
		
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消
				MessageVipWindow.this.finish();
			}
		});
		
	}
	
	//弹出框返回的内容在这里接受
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data); 
	        Log.e("phone--", "true");
	        //取出字符串  
	        if(data==null){
	        	return ;
	        }
	        Bundle bundle = data.getExtras();	        
	        if(bundle==null){
	        	return ;
	        }
	        String type=(String) bundle.get("type");
	        if(type.equals("phone_chk")){
	        	String phone = bundle.getString("phone");
	        	Log.e("phone--", phone);
	        }
	        
	 }
	
}
