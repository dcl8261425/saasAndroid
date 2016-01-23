package com.herotculb.qunhaichat.employee.interactive;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.ImageList;
import com.herotculb.qunhaichat.dto.StoreHouseDto;
import com.herotculb.qunhaichat.employee.interactive.adapter.GetListAdapter;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetListHandler extends Handler {
	Activity context;
	XListView view;
	LoadingDialog dialog;
	View viewp;
	
	public GetListHandler(Activity context, XListView view,
			LoadingDialog dialog) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		StoreHouseDto dto = (StoreHouseDto)map.get("obj");
		dialog.hide();
		dialog.dismiss();
		if(b){
			List<ImageList> weiXinList = (List<ImageList>) map.get("data");
			GetListAdapter adapter 
					= new GetListAdapter(context, weiXinList);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
