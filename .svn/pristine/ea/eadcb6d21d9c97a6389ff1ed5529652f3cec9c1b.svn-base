package com.herotculb.qunhaichat.activity.register;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.EditText;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 用于注册时的线程，包含handler 和主线程进行通讯
 * @author Administrator
 *
 */
public class SignRegisterThread extends Thread{
	Handler handler;
	String province;
	String city;
	String district;
	Activity context;
	
	public SignRegisterThread(Handler handler, String province, String city,
			String district, Activity context) {
		super();
		this.handler = handler;
		this.province = province;
		this.city = city;
		this.district = district;
		this.context = context;
	}

	public void run(){
		super.run();
		Looper.prepare();
		
		EditText conpanyNameText = (EditText)context.findViewById(R.id.register_conpany_name); // 公司名称
		EditText softAdminNameText  = (EditText)context.findViewById(R.id.register_soft_admin_name); 
		EditText softAdminPhoneText= (EditText)context.findViewById(R.id.register_soft_admin_phone);
		EditText conpanyTypeIdText= (EditText)context.findViewById(R.id.register_conpany_type_id);
		EditText conpanyTypeText= (EditText)context.findViewById(R.id.register_conpany_type);
		EditText conpanyAdminEmailText= (EditText)context.findViewById(R.id.register_conpany_admin_email);
		EditText conpanyPinYinText= (EditText)context.findViewById(R.id.register_conpany_pin_yin);
		
		String conpanyName = conpanyNameText.getText().toString(); // 公司名称
		String softAdminName = softAdminNameText.getText().toString(); 
		String softAdminPhone = softAdminPhoneText.getText().toString();
		String conpanyTypeId = conpanyTypeIdText.getText().toString(); 
		String conpanyType = conpanyTypeText.getText().toString(); 
		String conpanyAdminEmail = conpanyAdminEmailText.getText().toString();
		String conpanyPinYin = conpanyPinYinText.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.createConpany(province, city,
				district, conpanyName, softAdminName, softAdminPhone,
				conpanyType, conpanyTypeId, conpanyAdminEmail, conpanyPinYin);
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		String info=(String) map.get("info");
		if(b){
			
		}else{
			//登录失败
			Message sendmsg = Message.obtain();  
            sendmsg.obj = list;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg);  
		}
	}
}
