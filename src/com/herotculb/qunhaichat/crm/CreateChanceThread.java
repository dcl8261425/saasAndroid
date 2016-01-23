package com.herotculb.qunhaichat.crm;

import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.querychance.window.CustomerLevelWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class CreateChanceThread extends Thread {
	private CreateChanceWindow context;
	private Handler handler;
	
	public CreateChanceThread(CreateChanceWindow context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText nametext =(BootstrapEditText) context.findViewById(R.id.create_chance_name);
		BootstrapEditText addresstext =(BootstrapEditText) context.findViewById(R.id.create_chance_address);
		BootstrapEditText typetext =(BootstrapEditText) context.findViewById(R.id.create_chance_category);
		BootstrapEditText leveltext =(BootstrapEditText) context.findViewById(R.id.create_chance_level);
		BootstrapEditText markstext =(BootstrapEditText) context.findViewById(R.id.create_chance_marks);
		BootstrapEditText descriptiontext =(BootstrapEditText) context.findViewById(R.id.create_chance_description);
		BootstrapEditText useridtext =(BootstrapEditText) context.findViewById(R.id.create_chance_userid);
		BootstrapEditText statetext =(BootstrapEditText) context.findViewById(R.id.create_chance_state);
		
		String CustomerName = nametext.getText().toString();
		String CustomerAddress = addresstext.getText().toString();
		String CustomerType = typetext.getText().toString();
		String CustomerLevel = leveltext.getText().toString();
		String CustomerMark = markstext.getText().toString();
		String CreateManMark = descriptiontext.getText().toString();
		String NotesUserId= useridtext.getText().toString();
		String State= statetext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.createChance(CustomerName, CustomerAddress,
				CustomerType, CustomerLevel, CustomerMark, CreateManMark, NotesUserId, State);
		
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
