package com.herotculb.qunhaichat.location;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;
/**
签到检测类
 * @author Administrator
 *
 */
public class MeetingTest extends Thread{
	Activity content;
	Handler uihandler;
	public MeetingTest(Activity content){
		this.content=content;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(content);
		List<Map<String, Object>> list=qnpAPi.meeting("略", "test","0","0");
		Map<String,Object> map=list.iterator().next();
		if((Boolean)map.get("success")){
			 Log.e("============", "run");
			if(Boolean.parseBoolean((String)map.get("isup"))){
				//未签过到
				content.stopService(new Intent(content,LocationService.class));
			}else{
				Log.e("============", "已经开启");
				content.startService(new Intent(content,LocationService.class));
				//已经签过到了
				
			}
		}else{
			Log.e("============", "要关闭");
			//已经签到和签退,或未设置时间
			content.stopService(new Intent(content,LocationService.class));
		}
	}

}
