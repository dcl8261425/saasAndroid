package com.herotculb.qunhaichat.weixin.addgame;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeixinAddDaZhuanPan3Thread extends Thread {
	private Activity context;
	private String id;	
	private Handler handler;
	
	public WeixinAddDaZhuanPan3Thread(Activity context, String id,
			Handler handler) {
		super();
		this.context = context;
		this.id = id;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		TextView text1 = (TextView)context.findViewById(R.id.game_dazhuanpan_content3);
		TextView text2 = (TextView)context.findViewById(R.id.game_dazhuanpan_start_date3);
		TextView text3 = (TextView)context.findViewById(R.id.game_dazhuanpan_end_date3);
		TextView text4 = (TextView)context.findViewById(R.id.game_dazhuanpan_num3);
		String text = text1.getText().toString();
		String startDate = text2.getText().toString();
		String endDate = text3.getText().toString();
		String num = text4.getText().toString();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.addDazhuanpan3(text, startDate, endDate, id, num);
		Map<String,Object> map=list.iterator().next();
		//获取数据成功
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
