package com.herotculb.qunhaichat.messageinfo;

import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.LinkManListDto;

public class MessageSendAllHandler extends Handler {
	Activity context;
	View viewp;
		
	public MessageSendAllHandler(Activity context) {
		super();
		this.context = context;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
//		boolean b=(Boolean) map.get("success");
//		if(b){
			
			LinkManListDto dto = (LinkManListDto)map.get("dto");
			int type=(Integer)map.get("type");
			TextView show = (TextView)context.findViewById(R.id.message_show);
			
			switch(type){
				case 1:
					//这里写开始获取一组信息的逻辑
					show.setText("正在初始化数据。");
					break;
			    case 2:
					//这里写开始发送的逻辑 有dto
			    	show.setText("正在向"+dto.getLinkManName()+"发送消息。");
					break;
				case 3:
					//这里写发送失败的逻辑 
					show.setText("发送数据失败。");
					break;
				case 4:
					//这里写发送成功的逻辑
					show.setText("向");
					break;
				case 5:
					//这里写发送完成的逻辑
					show.setText("信息发送完毕。");
					break;
			}
			
			
			
//		}else{
//			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
//            .setTitleText("出错了！")
//            .setContentText((String)map.get("info"))
//            .show();
//		}
	}
	
}
