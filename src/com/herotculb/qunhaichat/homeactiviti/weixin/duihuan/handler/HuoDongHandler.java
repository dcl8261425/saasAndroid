package com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.handler;

import java.util.Map;

import android.content.Context;
import android.os.Handler;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.dto.AwardsDto;
import com.herotculb.qunhaichat.dto.NumLibsDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class HuoDongHandler extends Handler {
	LoadingDialog dialog;
	Context context;
	public HuoDongHandler(LoadingDialog dialog, Context context) {
		super();
		this.dialog = dialog;
		this.context = context;
	}
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b = (Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if (b) {
			NumLibsDto juan=(NumLibsDto) map.get("NumLibs");
			Object obj=map.get("Awards");
			if(obj==null){
				new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
				.setTitleText("成功")
				.setContentText("商品名:"+juan.getContent()+",但该奖品已从奖品库移除。")
				.setConfirmText("确定").showCancelButton(false)
				.setCancelClickListener(null).setConfirmClickListener(null)
				.show();
			}else{
				AwardsDto jiang=(AwardsDto) obj;
				new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
				.setTitleText("成功")
				.setContentText("商品名:"+juan.getContent()+",但该奖品已从奖品库移除。")
				.setConfirmText("确定").showCancelButton(false)
				.setCancelClickListener(null).setConfirmClickListener(null)
				.show();
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
