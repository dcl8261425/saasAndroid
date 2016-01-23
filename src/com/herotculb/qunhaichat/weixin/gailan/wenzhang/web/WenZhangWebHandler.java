package com.herotculb.qunhaichat.weixin.gailan.wenzhang.web;

import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.dto.VoteDTO;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WenZhangWebHandler extends Handler {
	Activity context;
	ListView view;
	LoadingDialog dialog;
	View viewp;

	public WenZhangWebHandler(Activity context, LoadingDialog dialog,
			ListView view) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b = (Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if (b) {
			Object obj2 = map.get("data2");
			if (obj2 != null) {
				VoteDTO voteDto = (VoteDTO) obj2;
				WenzhangWebAdapter adapter = new WenzhangWebAdapter(context,
						voteDto.getVoteItem());
				view.setAdapter(adapter);
				HomeActivity.setListViewHeightBasedOnChildren(view);
			}
		} else {
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
					.setTitleText("失败")
					.setContentText((String) map.get("info"))
					.setConfirmText("确定").showCancelButton(false)
					.setCancelClickListener(null).setConfirmClickListener(null)
					.show();
		}
	}
}
