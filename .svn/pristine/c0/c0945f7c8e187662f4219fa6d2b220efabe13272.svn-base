package com.herotculb.qunhaichat.weixin.gailan.wenzhang;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.WebPublicMessageDto;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.weixin.gailan.wenzhang.adapter.WenzhangAdapter;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WenZhangHandler extends Handler{
	HomeActivity context;
	XListView view;
	LoadingDialog dialog;
	View viewp;
	
	public WenZhangHandler(HomeActivity context,
			LoadingDialog dialog,XListView view) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		view.stopRefresh();
		view.stopLoadMore();
		view.setRefreshTime("刚刚");
		BootstrapEditText nowpage=(BootstrapEditText) context.findViewById(R.id.weixin_gailan_wenzhangManager_nowpage);
		if(b){
			 List<WebPublicMessageDto> list=(List<WebPublicMessageDto>) map.get("data");
			 WenzhangAdapter adapter1 = new WenzhangAdapter(context,list);
			 view.setAdapter(adapter1);
			 int nowpagenum=Integer.parseInt(nowpage.getText().toString());
			 int pagenum=Integer.parseInt((String)map.get("pagenum"))+1;
			 if(nowpagenum>=pagenum){
				
				 nowpage.setText(String.valueOf(pagenum));
			 }
			 //HomeActivity.setListViewHeightBasedOnChildren(view);
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
