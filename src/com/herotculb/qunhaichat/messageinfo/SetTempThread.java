package com.herotculb.qunhaichat.messageinfo;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class SetTempThread extends Thread {
	private Activity context;
	private String methed;
	private String type;	
	private Handler handler;	
	
	public SetTempThread(Activity context, String methed, String type,
			Handler handler) {
		this.context = context;
		this.methed = methed;
		this.type = type;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		String volue = "";
		String phone = "1";
		if(context.findViewById(R.id.message_model_add_score_marks)!=null){
			BootstrapEditText valueText = (BootstrapEditText)
					context.findViewById(R.id.message_model_add_score_marks);
			volue = valueText.getText().toString();
		}else if(context.findViewById(R.id.message_model_add_price_marks)!=null){
			BootstrapEditText valueText = (BootstrapEditText)
					context.findViewById(R.id.message_model_add_price_marks);
			volue = valueText.getText().toString();
		}else if(context.findViewById(R.id.message_model_jian_score_marks)!=null){
			BootstrapEditText valueText = (BootstrapEditText)
					context.findViewById(R.id.message_model_jian_score_marks);
			volue = valueText.getText().toString();
		}else if(context.findViewById(R.id.message_model_jian_price_marks)!=null){
			BootstrapEditText valueText = (BootstrapEditText)
					context.findViewById(R.id.message_model_jian_price_marks);
			volue = valueText.getText().toString();
		}else if(context.findViewById(R.id.message_model_order_marks)!=null){
			BootstrapEditText valueText = (BootstrapEditText)
					context.findViewById(R.id.message_model_order_marks);
			volue = valueText.getText().toString();
			BootstrapEditText phoneText = (BootstrapEditText)
					context.findViewById(R.id.message_model_order_phone);
			phone = phoneText.getText().toString();
		}
		
		if(volue.equals("")){
			volue = "略";
		}
		if(phone.equals("")){
			phone = "略";
		}
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.setTemp(volue, type, methed, phone);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
