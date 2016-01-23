package com.herotculb.qunhaichat.permission;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.SoftPermissionDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class LookUpPermissionByRoleHandler extends Handler {
	Activity context;
	ListView view;
	LoadingDialog dialog;
	String roleId;
	View viewp;
	
	public LookUpPermissionByRoleHandler(Activity context, ListView view,
			LoadingDialog dialog, String roleId) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.roleId = roleId;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			List<SoftPermissionDto> weiXinList = (List<SoftPermissionDto>) map.get("data");
			LookUpPermissionByRoleAdapter adapter = new LookUpPermissionByRoleAdapter(context, weiXinList,roleId);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
