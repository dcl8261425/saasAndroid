package com.herotculb.qunhaichat.homeactiviti.weixin.wifi;

import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class OpenDivceHandler extends Handler{
	Activity context;
	LoadingDialog dialog;
	String wifiid;
	public OpenDivceHandler(Activity context2,
			LoadingDialog dialog,String wifiid) {
		super();
		this.context = context2;
		this.dialog = dialog;
		this.wifiid=wifiid;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			 new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
			 .setTitleText("成功")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null).show();
			 XListView view=(XListView) context.findViewById(R.id.weixin_wifi_look_list);
				LookWifiHandler handler = 
						new LookWifiHandler(context, dialog, view,wifiid);
				LookWifiThread thread = 
						new LookWifiThread(context,wifiid, "1",
								"30", handler);
				thread.start();
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
