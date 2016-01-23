package com.herotculb.qunhaichat.print;

import android.app.Activity;
import android.os.Handler;
import android.view.View;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class PrintHandler extends Handler {
	Activity context;
	LoadingDialog dialog;
	public PrintHandler(Activity context,LoadingDialog dialog) {
		super();
		this.context = context;
		this.dialog=dialog;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		dialog.hide();
		dialog.dismiss();
	}
	
}
