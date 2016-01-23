package com.herotculb.qunhaichat.weixin.operationgame;

import java.util.Map;

import android.os.Handler;
import android.view.ViewGroup;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinUpdateGameDaZhuanPanHandler extends Handler {
	HomeActivity context;
	ViewGroup view;
	LoadingDialog dialog;
	
	public WeixinUpdateGameDaZhuanPanHandler(HomeActivity context, LoadingDialog dialog) {
		super();
		this.context = context;
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
			BootstrapButton b0=(BootstrapButton) context.findViewById(R.id.weixin_game_dazhuanpan);
			b0.performClick();
			new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE).setTitleText("开启/关闭")
            .setContentText(String.valueOf(map.get("info")))
            .setConfirmText("确定")
            .showCancelButton(false)
            .setCancelClickListener(null)
            .setConfirmClickListener(null).show();
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE).setTitleText("创建新奖品")
            .setContentText(String.valueOf(map.get("info")))
            .setConfirmText("确定")
            .showCancelButton(false)
            .setCancelClickListener(null)
            .setConfirmClickListener(null)
            .changeAlertType(SweetAlertDialog.ERROR_TYPE);
		}
	}
}
