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
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyGroupDto;
import com.herotculb.qunhaichat.goods.store.window.GetUserInGroupWindow;
import com.herotculb.qunhaichat.homeactiviti.group.GroupManager;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetAllGroupHandler extends Handler {
	Activity context;
	XListView view;
	LoadingDialog dialog;
	int layout;
	View viewp;
	GroupManager gm;
	public GetAllGroupHandler(Activity context, XListView view,
			LoadingDialog dialog, int layout,GroupManager gm) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.layout = layout;
		this.gm=gm;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		view.stopRefresh();
		view.stopLoadMore();
		view.setRefreshTime("刚刚");		
//		BootstrapEditText nowpage=(BootstrapEditText) context.findViewById(R.id.get_all_group_nowpage);
		if(b){
			List<ConpanyGroupDto> weiXinList = (List<ConpanyGroupDto>) map.get("data");
			GetAllGroupAdapter adapter = new GetAllGroupAdapter(context, weiXinList,layout,gm);
			view.setAdapter(adapter);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
