package com.herotculb.qunhaichat.weixin.gailan.huifushezhi;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.herotculb.qunhaichat.dto.WeiXinAutoReSendMenuDto;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AutoResendSetAddThread extends Thread {
	private Context context;
	private int type;
	private Handler handler;
	private WeiXinAutoReSendMenuDto dto;
	public AutoResendSetAddThread(Context context, int type, Handler handler,WeiXinAutoReSendMenuDto dto) {
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
			List<Map<String, Object>> list=qnpAPi.addAutoReSend_Event(dto.getName(), dto.getContent(), dto.getWeixin_events());
			map=list.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_IMAGE:
			List<Map<String, Object>> list2=qnpAPi.addAutoReSend_Image(dto.getName(), dto.getContent());
			map=list2.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_LINK:
			List<Map<String, Object>> list3=qnpAPi.addAutoReSend_Link(dto.getName(), dto.getContent());
			map=list3.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_LOCATION:
			List<Map<String, Object>> list4=qnpAPi.addAutoReSend_Location(dto.getName(), dto.getContent());
			map=list4.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_TEXT:
			List<Map<String, Object>> list5=qnpAPi.addAutoReSend_Text(dto.getName(), dto.getContent());
			map=list5.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_VIDEO:
			List<Map<String, Object>> list6=qnpAPi.addAutoReSend_Video(dto.getName(), dto.getContent());
			map=list6.iterator().next();
			break;
		case WeiXinAutoReSendMenuDto.TYPE_VOICE:
			List<Map<String, Object>> list7=qnpAPi.addAutoReSend_Voice(dto.getName(), dto.getContent());
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