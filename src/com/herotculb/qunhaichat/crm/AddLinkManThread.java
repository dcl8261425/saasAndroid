package com.herotculb.qunhaichat.crm;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.querychance.window.AddLinkManWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AddLinkManThread extends Thread {
	private AddLinkManWindow context;
	private String chanceId;
	private Handler handler;
	
	public AddLinkManThread(AddLinkManWindow context, String chanceId,
			Handler handler) {
		super();
		this.context = context;
		this.chanceId = chanceId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText nametext =(BootstrapEditText) context.findViewById(R.id.chance_add_linkman_name);
		BootstrapEditText phonetext =(BootstrapEditText) context.findViewById(R.id.chance_add_linkman_phone);
		BootstrapEditText positiontext =(BootstrapEditText) context.findViewById(R.id.chance_add_linkman_position);
		BootstrapEditText sextext =(BootstrapEditText) context.findViewById(R.id.chance_add_linkman_sex);
		BootstrapEditText birthdaytext =(BootstrapEditText) context.findViewById(R.id.chance_add_linkman_birthday);
		BootstrapEditText marktext =(BootstrapEditText) context.findViewById(R.id.chance_add_linkman_mark);
		
		String linkManName = nametext.getText().toString();
		String linkManSex = sextext.getText().toString();
		String linkManPhone = phonetext.getText().toString();
		String linkManJob = positiontext.getText().toString();
		String linkManMark = marktext.getText().toString();
		String linkManBirthday = birthdaytext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addLinkMan(chanceId, linkManName,
				linkManSex, linkManPhone, linkManJob, linkManMark, linkManBirthday);
		
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
