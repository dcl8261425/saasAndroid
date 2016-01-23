package com.herotculb.qunhaichat.messageinfo;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class SendVipMessageThread extends Thread {
	private Activity context;
	private String type;	
	private Handler handler;
		
	public SendVipMessageThread(Activity context,  String type,
			Handler handler) {
		super();
		this.context = context;
		this.type = type;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare(); 
		BootstrapEditText numText = null;
		BootstrapEditText valueText = null;
		TextView selectText = null;
		if(context.findViewById(R.id.message_vip_send_duihuan_num)!=null){
			numText = (BootstrapEditText)
					context.findViewById(R.id.message_vip_send_duihuan_num);
			valueText = (BootstrapEditText)
					context.findViewById(R.id.message_vip_send_duihuan_marks);
			selectText = (TextView)
					context.findViewById(R.id.message_vip_send_duihuan_id);
		}else{
			numText = (BootstrapEditText)
					context.findViewById(R.id.message_vip_send_ordinary_num);
			valueText = (BootstrapEditText)
					context.findViewById(R.id.message_vip_send_ordinary_marks);
		}		
		
		String value = valueText.getText().toString();
		String select = "";
		String num = numText.getText().toString();
		
		if(type.equals("2")){
			select = "略";
		}else{
			select = selectText.getText().toString();
		}
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.sendVipMessage(value, select, type, num);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
