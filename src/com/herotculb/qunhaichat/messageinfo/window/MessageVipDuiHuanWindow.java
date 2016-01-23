package com.herotculb.qunhaichat.messageinfo.window;

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
import com.herotculb.qunhaichat.homeactiviti.messageinfo.VipSendManager;
import com.herotculb.qunhaichat.weixin.getvip.WeixinGetDuiHuanListHandler;
import com.herotculb.qunhaichat.weixin.getvip.WeixinGetDuiHuanListThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MessageVipDuiHuanWindow extends Activity {
	private BootstrapButton cancle;
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.message_vip_send_duihuan_window);
		cancle =(BootstrapButton)findViewById(R.id.message_vip_send_duihuan_cancle);
		list = (ListView)findViewById(R.id.message_vip_send_duihuan_list);
		int layout = R.layout.message_vip_send_duihuan_list;
		
		LoadingDialog dialog = new LoadingDialog(
				MessageVipDuiHuanWindow.this, "正在获取数据");
		dialog.show();
		WeixinGetDuiHuanListHandler handler =
				new WeixinGetDuiHuanListHandler(MessageVipDuiHuanWindow.this, list, dialog,layout);
		WeixinGetDuiHuanListThread thread = 
				new WeixinGetDuiHuanListThread(MessageVipDuiHuanWindow.this, handler);
		thread.start();		
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消
				MessageVipDuiHuanWindow.this.finish();
			}
		});
		
	}
	
	//弹出框返回的内容在这里接受
//	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
//	        super.onActivityResult(requestCode, resultCode, data); 
//	        //取出字符串  
//	        if(data==null){
//	        	return ;
//	        }
//	        Bundle bundle = data.getExtras();	        
//	        if(bundle==null){
//	        	return ;
//	        }
//	        String type=(String) bundle.get("type");
//	        Log.e("vipduihuan--", type);
//	        if(type.equals("message_vip_send_select")){
//	        	BootstrapButton select = (BootstrapButton)
//	        			MessageVipDuiHuanWindow.this.findViewById(R.id.message_vip_send_duihuan_select);
//	        }
//	 }
	
}
