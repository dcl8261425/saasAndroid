package com.herotculb.qunhaichat.permission.operation;

import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.group.window.PermissionGetGroupCompanyUserWindow;
import com.herotculb.qunhaichat.permission.LookUpRoleByUserHandler;
import com.herotculb.qunhaichat.permission.LookUpRoleByUserThread;
import com.herotculb.qunhaichat.permission.window.LookUpRoleByUserWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class DeleteRoleToConpanyUserHandler extends Handler {
	Activity context;
	ViewGroup view;
	LoadingDialog dialog;
	SweetAlertDialog dialog2;
	String userId;
	String groupId;
	
	public DeleteRoleToConpanyUserHandler(Activity context,
			LoadingDialog dialog, SweetAlertDialog dialog2, String userId,
			String groupId) {
		super();
		this.context = context;
		this.dialog = dialog;
		this.dialog2 = dialog2;
		this.userId = userId;
		this.groupId = groupId;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		ListView list = (ListView)context.findViewById(R.id.permission_lookup_by_user_list);
		LoadingDialog dialog1 = new LoadingDialog(
				context, "正在获取数据");
		dialog1.show();
		LookUpRoleByUserHandler handler = 
				new LookUpRoleByUserHandler(context, list, dialog1,userId);
		LookUpRoleByUserThread thread = 
				new LookUpRoleByUserThread(context, userId, groupId, handler);
		thread.start();	    		
		dialog2.setTitleText("删除")
        .setContentText(String.valueOf(map.get("info")))
        .setConfirmText("确定")
        .showCancelButton(false)
        .setCancelClickListener(null)
        .setConfirmClickListener(null)
        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);	  
	}
}
