package com.herotculb.qunhaichat.weixin.order;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.WeixinOrderDto;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGetOrderHandler extends Handler {
	HomeActivity context;
	XListView view;
	LoadingDialog dialog;
	String song;
	View viewp;
	
	public WeixinGetOrderHandler(HomeActivity context, XListView view,
			LoadingDialog dialog, String song) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.song = song;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		view.stopRefresh();
		view.stopLoadMore();
		view.setRefreshTime("刚刚");
		BootstrapEditText nowpage=(BootstrapEditText) context.findViewById(R.id.weixin_order_nowpage);
		if(b){
			List<WeixinOrderDto> weiXinList = (List<WeixinOrderDto>) map.get("data");
			WeixinGetOrderAdapter adapter = new WeixinGetOrderAdapter(context, weiXinList,song);
			view.setAdapter(adapter);
			 int nowpagenum=Integer.parseInt(nowpage.getText().toString());
			 int pagenum=Integer.parseInt(map.get("pagenum").toString())+1;
			 if(nowpagenum>=pagenum){
				
				 nowpage.setText(String.valueOf(pagenum));
			 }
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
