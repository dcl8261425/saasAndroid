package com.herotculb.qunhaichat.goods.operationsource;

import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.goods.source.window.GoodsAddSourceLinkManWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GoodsAddSourceLinkManHandler extends Handler {
	GoodsAddSourceLinkManWindow context;
	ViewGroup view;
	LoadingDialog dialog;
	
	public GoodsAddSourceLinkManHandler(GoodsAddSourceLinkManWindow context, LoadingDialog dialog) {
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
			Intent i = new Intent(context, HomeActivity.class);  
	        Bundle b2 = new Bundle();
	        b2.putString("type", "add_source_linkman");
	        i.putExtras(b2);
	        context.setResult(context.RESULT_OK, i);
	        context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
	        context.finish();  
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
}
