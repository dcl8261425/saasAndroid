package com.herotculb.qunhaichat.homeactiviti.goods.query.updateprice;

import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.LoadingDialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class UpdateGoodsPriceHandler  extends Handler{
	Activity context;
	LoadingDialog dialog;
	public UpdateGoodsPriceHandler(Activity context2,
			LoadingDialog dialog) {
		super();
		this.context = context2;
		this.dialog = dialog;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		BootstrapEditText nowpage=(BootstrapEditText) context.findViewById(R.id.weixin_goods_nowpage);
		if(b){
			Intent i = new Intent(context,HomeActivity.class);
			Bundle bun = new Bundle();
			bun.putString("info", (String) map.get("info"));
			bun.putString("type","good_update_price");
			i.putExtras(bun);
			context.setResult(context.RESULT_OK, i);
			context.finish();
		}else{
			 new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
			 .setTitleText("失败")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null).show();
		}
	}
}
