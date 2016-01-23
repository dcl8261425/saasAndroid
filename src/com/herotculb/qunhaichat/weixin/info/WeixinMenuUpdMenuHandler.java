package com.herotculb.qunhaichat.weixin.info;

import java.util.Map;

import android.content.Context;
import android.os.Handler;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinMenuUpdMenuHandler extends Handler {
	LoadingDialog dialog;
	Context context;
	public WeixinMenuUpdMenuHandler(LoadingDialog dialog, Context context) {
		super();
		this.dialog = dialog;
		this.context = context;
	}
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		if(b){
			 new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
			 .setTitleText("更新成功")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null).show();
		}else{
			 new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
			 .setTitleText("更新失败")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null).show();
		}
	}
}
