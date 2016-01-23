package com.herotculb.qunhaichat.weixin.getgame;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.dto.AwardsDto;
import com.herotculb.qunhaichat.weixin.getgame.adapter.WeixinGetAwardsAdapter;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGetAwardsHandler extends Handler {
	HomeActivity context;
	ListView view;
	LoadingDialog dialog;
	View viewp;
	public WeixinGetAwardsHandler(HomeActivity context, ListView view,
			LoadingDialog dialog, View viewp) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.viewp = viewp;
	}
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		if(b){
			List<AwardsDto> weiXinList = (List<AwardsDto>) map
					.get("data");
			WeixinGetAwardsAdapter adapter = new WeixinGetAwardsAdapter(context, weiXinList);
			view.setAdapter(adapter);
			HomeActivity.setListViewHeightBasedOnChildren(view);
		}else{			
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
					.setTitleText("出错了！")
					.setContentText((String) map.get("info")).show();
		}
	}
}
