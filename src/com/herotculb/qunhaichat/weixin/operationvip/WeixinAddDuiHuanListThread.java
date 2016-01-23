package com.herotculb.qunhaichat.weixin.operationvip;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeixinAddDuiHuanListThread extends Thread {
	private Activity context;
	private Handler handler;
	
	public WeixinAddDuiHuanListThread(Activity context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText idtext =(BootstrapEditText) context.findViewById(R.id.weixin_create_duihuan_id);
		BootstrapEditText markstext =(BootstrapEditText) context.findViewById(R.id.weixin_create_duihuan_marks);
		BootstrapEditText scoretext =(BootstrapEditText) context.findViewById(R.id.weixin_create_duihuan_score);
		BootstrapEditText nametext =(BootstrapEditText) context.findViewById(R.id.weixin_create_duihuan_name);
		BootstrapEditText imagetext =(BootstrapEditText) context.findViewById(R.id.weixin_create_duihuan_image);
		BootstrapEditText numtext =(BootstrapEditText) context.findViewById(R.id.weixin_create_duihuan_num);
		
		String marks = markstext.getText().toString();
		String score = scoretext.getText().toString();
		String name = nametext.getText().toString();
		String image = imagetext.getText().toString();
		String num = numtext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addScoreDuiHuanList(marks, score, name, image, num);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
