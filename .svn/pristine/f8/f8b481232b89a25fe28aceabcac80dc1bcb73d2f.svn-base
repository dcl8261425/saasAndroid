package com.herotculb.qunhaichat.messageinfo;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.homeactiviti.messageinfo.MessageSetManager;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class SetBooleanHandler extends Handler {
	Activity context;
	ViewGroup view;
	LoadingDialog dialog;
	MessageSetManager msm;
	
	public SetBooleanHandler(Activity context, LoadingDialog dialog,
			MessageSetManager msm) {
		super();
		this.context = context;
		this.dialog = dialog;
		this.msm = msm;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE).setTitleText("开启/关闭")
            .setContentText(String.valueOf(map.get("info")))
            .setConfirmText("确定")
            .showCancelButton(false)
            .setCancelClickListener(null)
            .setConfirmClickListener(null).show();
			LoadingDialog dialog = new LoadingDialog(msm.home, "正在获取数据");
			dialog.show();
			GetMessageSetHandler handler = new 
					GetMessageSetHandler(msm.home, dialog,msm);
			GetMessageSetThread thread = new 
					GetMessageSetThread(msm.home, handler);
			thread.start();
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE).setTitleText("创建新奖品")
            .setContentText(String.valueOf(map.get("info")))
            .setConfirmText("确定")
            .showCancelButton(false)
            .setCancelClickListener(null)
            .setConfirmClickListener(null)
            .changeAlertType(SweetAlertDialog.ERROR_TYPE);
		}
	}
}
