package com.herotculb.qunhaichat.weixin.gailan.huifushezhi.item;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.WeiXinReSendDto;
import com.herotculb.qunhaichat.weixin.gailan.window.AutoResendSetItemQueryWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class AutoResendHandlerItem extends Handler{
	AutoResendSetItemQueryWindow context;
	ListView view;
	LoadingDialog dialog;
	int type;
	
	public AutoResendHandlerItem(AutoResendSetItemQueryWindow autoResendSetItemQueryWindow,int type, ListView view,
			LoadingDialog dialog) {
		super();
		this.context = autoResendSetItemQueryWindow;
		this.view = view;
		this.dialog = dialog;
		this.type=type;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			List<WeiXinReSendDto> list=(List<WeiXinReSendDto>) map.get("data");
			switch (type) {
			case WeiXinReSendDto.TEXT:
				//文本
				AutoResourceItemAdapter adapter = new AutoResourceItemAdapter(context,list);
				 view.setAdapter(adapter);
				break;
			case WeiXinReSendDto.IMAGE:
				//图片
				AutoResourceItemAdapter adapter1 = new AutoResourceItemAdapter(context,list);
				 view.setAdapter(adapter1);
				break;
			case WeiXinReSendDto.IMAGE_TEXT:
				//图文
				AutoResourceItemAdapter adapter2 = new AutoResourceItemAdapter(context,list);
				 view.setAdapter(adapter2);
				break;
			case WeiXinReSendDto.MUSIC:
				//音乐
				AutoResourceItemAdapter adapter3 = new AutoResourceItemAdapter(context,list);
				 view.setAdapter(adapter3);
				break;
			case WeiXinReSendDto.VIDEO:
				//视频
				AutoResourceItemAdapter adapter4 = new AutoResourceItemAdapter(context,list);
				 view.setAdapter(adapter4);
				break;
			case WeiXinReSendDto.VOICE:
				//语音
				AutoResourceItemAdapter adapter5 = new AutoResourceItemAdapter(context,list);
				 view.setAdapter(adapter5);
				break;
			default:
				break;
			}
			
		}else{
			 new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
			 .setTitleText("失败")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null).show();
		}
	}
}
