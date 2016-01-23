package com.herotculb.qunhaichat.weixin.operationvip;

import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.weixin.operationvip.window.VipCreateClassWindowActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinUpdateVipListHandler extends Handler {
	VipCreateClassWindowActivity context;
	ViewGroup view;
	LoadingDialog dialog;
	
	public WeixinUpdateVipListHandler(VipCreateClassWindowActivity context, LoadingDialog dialog) {
		super();
		this.context = context;
		this.dialog = dialog;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			Log.e("handler--", "type--");
			Intent i = new Intent(context, HomeActivity.class);  
	        Bundle b2 = new Bundle();
	        b2.putString("type", "update_vip_list");
	        i.putExtras(b2);
	        context.setResult(context.RESULT_OK, i);  
	        context.finish();
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
}
