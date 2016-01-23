package com.herotculb.qunhaichat.employee.interactive;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.employee.EmployeeUseLoginWindow;
import com.herotculb.qunhaichat.goods.store.window.GoodsAddStoreHouseWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class DeleteKongJianHandler extends Handler {
	Activity context;
	ViewGroup view;
	LoadingDialog dialog;
	
	public DeleteKongJianHandler(Activity context, LoadingDialog dialog) {
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
//			new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
//            .setTitleText("修改成功！")
//            .setContentText((String)map.get("info"))
//            .show();
//	        context.finish(); 
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
}
