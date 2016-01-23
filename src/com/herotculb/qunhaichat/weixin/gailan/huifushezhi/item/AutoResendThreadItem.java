package com.herotculb.qunhaichat.weixin.gailan.huifushezhi.item;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.herotculb.qunhaichat.dto.WeiXinReSendDto;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AutoResendThreadItem extends Thread {
	private Context context;
	private int type;
	private Handler handler;

	public AutoResendThreadItem(Context context, int type, Handler handler) {
		super();
		this.context = context;
		this.type = type;
		this.handler = handler;
	}

	@Override
	public void run() {
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=null;
		
		switch (type) {
		case WeiXinReSendDto.TEXT:
			//文本
			list=qnpAPi.getText();
			break;
		case WeiXinReSendDto.IMAGE:
			//图片
			list=qnpAPi.getImage();
			break;
		case WeiXinReSendDto.IMAGE_TEXT:
			//图文
			list=qnpAPi.getImageText();
			break;
		case WeiXinReSendDto.MUSIC:
			//音乐
			list=qnpAPi.getMusic();
			break;
		case WeiXinReSendDto.VIDEO:
			//视频
			list=qnpAPi.getVideo();
			break;
		case WeiXinReSendDto.VOICE:
			//语音
			list=qnpAPi.getVoice();
			break;
		default:
			break;
		}
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
}
