package com.herotculb.qunhaichat.weixin.gailan;

import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.weixin.gailan.window.GaiLanMenuUpdateWindowActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinMenuManagerEditHandler extends Handler {
	LoadingDialog sDialog;
	GaiLanMenuUpdateWindowActivity context;
	public WeixinMenuManagerEditHandler(LoadingDialog dialog2, GaiLanMenuUpdateWindowActivity context) {
		super();
		this.sDialog = dialog2;
		this.context = context;
	}
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		sDialog.hide();
		sDialog.dismiss();
		if((Boolean) map.get("success")){
			Intent i = new Intent(context, HomeActivity.class);  
	        Bundle b = new Bundle();
	        b.putString("type", "weixin_menu_update");
	        i.putExtras(b);
	        context.setResult(context.RESULT_OK, i);  
	        context.finish();  
		}else{
			 new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
             .setTitleText("出错了")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定").show();
		}
	}
}
