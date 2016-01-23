package com.herotculb.qunhaichat.homeactiviti.goods.query.chart;

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
import android.webkit.WebView;

public class ChartGoodsHandler  extends Handler{
	ChartGoods context;
	LoadingDialog dialog;
	JavaScriptMake js;
	int type;
	public ChartGoodsHandler(ChartGoods context2,
			LoadingDialog dialog,JavaScriptMake js,int type) {
		super();
		this.context = context2;
		this.dialog = dialog;
		this.js=js;
		this.type=type;
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
			js.query_Date( (String) map.get("json"),type);
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
