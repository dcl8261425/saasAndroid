package com.herotculb.qunhaichat.weixin.gailan.huifuziyuanku;

import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class AutoResendUpdateHandler extends Handler {
	Activity context;
	ListView view;
	LoadingDialog dialog;
	int type;
	
	
	public AutoResendUpdateHandler(Activity context,int type, 
			LoadingDialog dialog) {
		super();
		this.context = context;
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
			Intent i = new Intent(context, HomeActivity.class);  
	        Bundle b2 = new Bundle();
	        b2.putString("type", "weixin_gailan_AutoResendAddHandler");
	        b2.putInt("weixin_gailan_AutoResendAddHandlertype", type);
	        i.putExtras(b2);
	        context.setResult(context.RESULT_OK, i);  
	        context.finish();  
			
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE).setTitleText("修改")
             .setContentText(String.valueOf(map.get("info")))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null)
             .changeAlertType(SweetAlertDialog.ERROR_TYPE);
		}
	}
}
