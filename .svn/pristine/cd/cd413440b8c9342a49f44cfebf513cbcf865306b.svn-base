package com.herotculb.qunhaichat.employee.meeting;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.MeetingDto;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetMeetingSetInfoHandler extends Handler {
	Activity context;
	XListView view;
	LoadingDialog dialog;
	View viewp;
	
	public GetMeetingSetInfoHandler(Activity context, XListView view,
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
		dialog.hide();
		dialog.dismiss();
		if(b){
			List<MeetingDto> weiXinList = (List<MeetingDto>) map.get("data");
			GetMeetingSetInfoAdapter adapter 
					= new GetMeetingSetInfoAdapter(context, weiXinList);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
