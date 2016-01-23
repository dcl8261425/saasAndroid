package com.herotculb.qunhaichat.goods.source;

import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GoodsGetSourceHandler extends Handler {
	HomeActivity context;
	LoadingDialog dialog;
	View viewp;
	
	public GoodsGetSourceHandler(HomeActivity context, LoadingDialog dialog) {
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
		BootstrapEditText nowpage=(BootstrapEditText) context.findViewById(R.id.goods_source_nowpage);
		if(b){
			Intent i = new Intent(context, HomeActivity.class);  
	        Bundle b2 = new Bundle();
	        i.putExtras(b2);
	        context.setResult(context.RESULT_OK, i);  
	        context.finish();
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
