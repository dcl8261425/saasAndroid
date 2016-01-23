package com.herotculb.qunhaichat.goods.operationstore;

import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GoodsDeleteStoreHouseHandler extends Handler {
	Activity context;
	ViewGroup view;
	LoadingDialog dialog;
	SweetAlertDialog dialog2;
	
	public GoodsDeleteStoreHouseHandler(Activity context,
			LoadingDialog dialog, SweetAlertDialog dialog2) {
		super();
		this.context = context;
		this.dialog = dialog;
		this.dialog2 = dialog2;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		BootstrapButton b0 = (BootstrapButton)context.findViewById(R.id.goods_store_house_name_query);
    	b0.performClick();
    	dialog2.setTitleText("删除")
        .setContentText(String.valueOf(map.get("info")))
        .setConfirmText("确定")
        .showCancelButton(false)
        .setCancelClickListener(null)
        .setConfirmClickListener(null)
        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
	}
}
