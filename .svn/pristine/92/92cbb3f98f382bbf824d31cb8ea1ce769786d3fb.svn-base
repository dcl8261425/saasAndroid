package com.herotculb.qunhaichat.homeactiviti.goods.orderquery;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.InOrderDto;
import com.herotculb.qunhaichat.dto.OrdersDto;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class QueryOrderHandler extends Handler{
	Activity context;
	LoadingDialog dialog;
	XListView view;
	Class returnclass;
	String type;
	boolean isinOrder;
	public QueryOrderHandler(Activity context2,
			LoadingDialog dialog,XListView view,Class returnclass,String type,boolean isInOrder) {
		super();
		this.context = context2;
		this.dialog = dialog;
		this.view=view;
		this.returnclass=returnclass;
		this.type=type;
		this.isinOrder=isInOrder;
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
		BootstrapEditText nowpage=(BootstrapEditText) context.findViewById(R.id.query_goods_nowpage);
		if(b){
			List list=null;
			if(isinOrder){
			  list=(List<InOrderDto>) map.get("data");
			}else{
				list=(List<OrdersDto>) map.get("data");
			}
			 QueryOrderAdapter adapter1 = new QueryOrderAdapter(context,list,returnclass,type,isinOrder);
			 view.setAdapter(adapter1);
			 int nowpagenum=Integer.parseInt(nowpage.getText().toString());
			 int pagenum=(Integer)map.get("pagenum")+1;
			 if(nowpagenum>=pagenum){
				 nowpage.setText(String.valueOf(pagenum));
			 }
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
