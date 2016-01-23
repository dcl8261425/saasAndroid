package com.herotculb.qunhaichat.employee.interactive;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.KongJianDto;
import com.herotculb.qunhaichat.dto.StoreHouseDto;
import com.herotculb.qunhaichat.employee.interactive.adapter.GetHuDongKongJianAdapter;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetHuDongKongJianHandler extends Handler {
	Activity context;
	XListView view;
	LoadingDialog dialog;
	View viewp;
	
	public GetHuDongKongJianHandler(Activity context, XListView view,
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
			List<KongJianDto> weiXinList = (List<KongJianDto>) map.get("data");
			GetHuDongKongJianAdapter adapter 
					= new GetHuDongKongJianAdapter(context, weiXinList);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
