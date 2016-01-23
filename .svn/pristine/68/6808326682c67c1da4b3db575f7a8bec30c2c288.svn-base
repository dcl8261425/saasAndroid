package com.herotculb.qunhaichat.permission;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.RoleDto;
import com.herotculb.qunhaichat.permission.window.LookUpRoleAllWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class LookUpRoleAllHandler extends Handler {
	Activity context;
	ListView view;
	LoadingDialog dialog;
	String userId;
	String groupId;
	int layout;
	View viewp;
	
	public LookUpRoleAllHandler(Activity context, ListView view,
			LoadingDialog dialog, String userId, String groupId, int layout) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.userId = userId;
		this.groupId = groupId;
		this.layout = layout;
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
			LookUpRoleAllAdapter adapter = new LookUpRoleAllAdapter(context, weiXinList,userId,groupId,layout);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
