package com.herotculb.qunhaichat.weixin.gailan.huifushezhi.item;

import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.weixin.gailan.window.AutoResendSetItemWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class AutoResendHandlerAddItem extends Handler{
	Activity context;
	LoadingDialog dialog;
	
	public AutoResendHandlerAddItem(Activity context2,
			LoadingDialog dialog) {
		super();
		this.context = context2;
		this.dialog = dialog;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			Intent i = new Intent(context, AutoResendSetItemWindow.class);  
	        Bundle b2 = new Bundle();
	        i.putExtras(b2);
	        context.setResult(context.RESULT_OK, i);  
	        context.finish();  
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
