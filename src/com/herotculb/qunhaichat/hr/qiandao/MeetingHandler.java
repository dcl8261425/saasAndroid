package com.herotculb.qunhaichat.hr.qiandao;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.location.MeetingTest;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MeetingHandler extends Handler{

	SweetAlertDialog sDialog;
	Activity context;
	LoadingDialog dialog;
	public MeetingHandler(SweetAlertDialog sDialog,Activity context,LoadingDialog dialog){
		this.context=context;
		this.sDialog=sDialog;
		this.dialog=dialog;
	}
	@Override 
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		dialog.hide();
		dialog.dismiss();
		boolean issuccess = (Boolean) map.get("success");
		
		if (issuccess) {
			sDialog.setTitleText("签到成功")
	        .setContentText((String)map.get("info"))
	        .setConfirmText("确定")
	        .showCancelButton(false)
	        .setCancelClickListener(null)
	        .setConfirmClickListener(new OnSweetClickListener() {
				
				@Override
				public void onClick(SweetAlertDialog sweetAlertDialog) {
					// TODO Auto-generated method stub
					
					 Intent i = new Intent(context,HomeActivity.class);
					  MeetingTest test=new MeetingTest(context);
						test.start();
					 context.setResult(context.RESULT_OK, i);
					 context.finish();
				}
			})
	        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
		}else{

			sDialog.setTitleText("签到失败")
	        .setContentText((String)map.get("info"))
	       
	        .setConfirmText("确定")
	        .showCancelButton(false)
	        .setCancelClickListener(null)
	        .setConfirmClickListener(new OnSweetClickListener() {
				
				@Override
				public void onClick(SweetAlertDialog sweetAlertDialog) {
					// TODO Auto-generated method stub
					 Intent i = new Intent(context,HomeActivity.class);
					  MeetingTest test=new MeetingTest(context);
						test.start();
					 context.setResult(context.RESULT_OK,i);
					 context.finish();
				}
			})
	        .changeAlertType(SweetAlertDialog.ERROR_TYPE);
		}
	}
	
}
