package com.herotculb.qunhaichat.permission;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.RoleDto;
import com.herotculb.qunhaichat.group.window.PermissionGetGroupCompanyUserWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class LookUpRoleByUserHandler extends Handler {
	Activity context;
	ListView view;
	LoadingDialog dialog;
	String userId;
	View viewp;
	
	public LookUpRoleByUserHandler(Activity context, ListView view,
			LoadingDialog dialog, String userId) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.userId = userId;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			List<RoleDto> weiXinList = (List<RoleDto>) map.get("data");
			LookUpRoleByUserAdapter adapter = new LookUpRoleByUserAdapter(context, weiXinList,userId);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
