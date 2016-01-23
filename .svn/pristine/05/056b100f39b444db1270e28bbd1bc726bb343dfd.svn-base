package com.herotculb.qunhaichat.homeactiviti.weixin.wifi;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.VWiFiDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeiXinWiFiHandler extends Handler{
	Activity context;
	LoadingDialog dialog;
	ListView view;
	public WeiXinWiFiHandler(Activity context2,
			LoadingDialog dialog,ListView view) {
		super();
		this.context = context2;
		this.dialog = dialog;
		this.view=view;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			 List<VWiFiDto> list=(List<VWiFiDto>) map.get("data");
			 WeiXinWifiAdapter adapter1 = new WeiXinWifiAdapter(context,list);
			 view.setAdapter(adapter1);
			
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
