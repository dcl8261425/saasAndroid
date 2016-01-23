package com.herotculb.qunhaichat.weixin.gailan.wenzhang;

import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class DeleteWenZhangHandler extends Handler{
	Activity context;
	LoadingDialog dialog;
	SweetAlertDialog sDialog;
	public DeleteWenZhangHandler(Activity context2,
			LoadingDialog dialog,SweetAlertDialog sDialog) {
		super();
		this.context = context2;
		this.dialog = dialog;
		this.sDialog=sDialog;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			BootstrapButton b0=(BootstrapButton) context.findViewById(R.id.weixin_gailan_wenzhangManager_name_query);
			b0.performClick();
			sDialog
			 .setTitleText("成功")
            .setContentText((String) map.get("info"))
            .setConfirmText("确定")
            .showCancelButton(false)
            .setCancelClickListener(null)
            .setConfirmClickListener(null).show();
		}else{
			sDialog
			 .setTitleText("失败")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null).show();
		}
	}
}
