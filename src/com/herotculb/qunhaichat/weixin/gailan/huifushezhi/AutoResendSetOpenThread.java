package com.herotculb.qunhaichat.weixin.gailan.huifushezhi;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.os.Message;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.dto.WeiXinAutoReSendMenuDto;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AutoResendSetOpenThread extends Thread {
	private HomeActivity context;
	private int type;
	private Handler handler;
	private WeiXinAutoReSendMenuDto dto;
	public AutoResendSetOpenThread(HomeActivity context, int type, Handler handler,WeiXinAutoReSendMenuDto dto) {
		super();
		this.context = context;
		this.type = type;
		this.handler = handler;
		this.dto=dto;
	}

	@Override
	public void run() {
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
	
		Map<String,Object> map=null;
		switch (type) {
		case WeiXinAutoReSendMenuDto.TYPE_EVENT:
			List<Map<String, Object>> list=qnpAPi.updateUse(String.valueOf(dto.getId()),String.valueOf(!dto.isUses()));
			map=list.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_IMAGE:
			List<Map<String, Object>> list2=qnpAPi.updateUse(String.valueOf(dto.getId()),String.valueOf(!dto.isUses()));
			map=list2.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_LINK:
			List<Map<String, Object>> list3=qnpAPi.updateUse(String.valueOf(dto.getId()),String.valueOf(!dto.isUses()));
			map=list3.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_LOCATION:
			List<Map<String, Object>> list4=qnpAPi.updateUse(String.valueOf(dto.getId()),String.valueOf(!dto.isUses()));
			map=list4.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_TEXT:
			List<Map<String, Object>> list5=qnpAPi.updateUse(String.valueOf(dto.getId()),String.valueOf(!dto.isUses()));
			map=list5.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_VIDEO:
			List<Map<String, Object>> list6=qnpAPi.updateUse(String.valueOf(dto.getId()),String.valueOf(!dto.isUses()));
			map=list6.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_VOICE:
			List<Map<String, Object>> list7=qnpAPi.updateUse(String.valueOf(dto.getId()),String.valueOf(!dto.isUses()));
			map=list7.iterator().next();
			break;
		default:
			break;
		}
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
}