package com.herotculb.qunhaichat.weixin.getvip;

import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.TableLayout;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class WeixinGetDuiHuanHandler extends Handler {
	Context context;
	ViewGroup view;
	public WeixinGetDuiHuanHandler(Context context, ViewGroup view) {
		super();
		this.context = context;
		this.view = view;
	}
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		boolean b=(Boolean) map.get("success");
		if(b){
			TableLayout tableLayout=new TableLayout(context);
			tableLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
}
