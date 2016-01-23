package com.herotculb.qunhaichat.activity;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 用于登录时的线程，包含handler 和主线程进行通讯
 * @author Administrator
 *
 */
public class SignInActivityLoginThread extends Thread{
	Handler uihandler;
	String username;
	String password;
	Context content;
	public SignInActivityLoginThread(Handler handler,String username,String password,Context content){
		uihandler=handler;
		this.username=username;
		this.password=password;
		this.content=content;
	}
	public void run(){
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(content);
		List<Map<String, Object>> list=qnpAPi.loginAjax(username, password);
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		String info=(String) map.get("info");
		if(b){
			
			Intent mainIntent = new Intent().setClass(content, HomeActivity.class);
			content.startActivity(mainIntent);
			SharedPreferences mySharedPreferences= content.getSharedPreferences("usermessage", 
					Activity.MODE_PRIVATE); 
			SharedPreferences.Editor editor = mySharedPreferences.edit(); 
			editor.putString("username", username); 
			editor.putString("password", password); 
			editor.commit();
		}else{
			//登录失败
			Message sendmsg = Message.obtain();  
            sendmsg.obj = list;   //利用Message.obj把子线程的handle传递给主线程。  
            uihandler.sendMessage(sendmsg);  
              
			
		}
	}
}
