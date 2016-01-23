package com.herotculb.qunhaichat.group;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyUserDto;
import com.herotculb.qunhaichat.goods.store.window.GetGroupCompanyUserWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetGroupCompanyUserHandler extends Handler {
	Activity context;
	ListView view;
	LoadingDialog dialog;
	String classes;
	String groupId;
//	String userId;
	View viewp;
	int layout;
	
	public GetGroupCompanyUserHandler(Activity context, ListView view,
			LoadingDialog dialog, String classes, String groupId,
			 int layout) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.classes = classes;
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
		BootstrapEditText nowpage = null;
		if(context.findViewById(R.id.goods_store_house_nowpage)!=null){
			nowpage=(BootstrapEditText) context.findViewById(R.id.goods_store_house_nowpage);
		}else if(context.findViewById(R.id.get_all_group_nowpage)!=null){
			nowpage=(BootstrapEditText) context.findViewById(R.id.get_all_group_nowpage);
		}else if(context.findViewById(R.id.permission_insert_company_group_nowpage)!=null){
			nowpage=(BootstrapEditText) context.findViewById(R.id.permission_insert_company_group_nowpage);
		}else if(context.findViewById(R.id.get_all_group_sub_nowpage)!=null){
			nowpage=(BootstrapEditText) context.findViewById(R.id.get_all_group_sub_nowpage);
		}
		if(b){
			List<ConpanyUserDto> weiXinList = (List<ConpanyUserDto>) map.get("data");
			GetGroupCompanyUserAdapter adapter = new GetGroupCompanyUserAdapter(context, weiXinList,classes,groupId,layout);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
