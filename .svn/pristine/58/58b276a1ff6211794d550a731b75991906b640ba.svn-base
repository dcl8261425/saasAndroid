package com.herotculb.qunhaichat.homeactiviti.goods.orderquery;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.InOrderDto;
import com.herotculb.qunhaichat.dto.OrdersDto;
import com.herotculb.qunhaichat.dto.OrdersItemDto;
import com.herotculb.qunhaichat.homeactiviti.goods.ingoods.InGoods;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class DeleteOrderItemHandler  extends Handler{
	Activity context;
	LoadingDialog dialog;
	boolean isInOrder;
	String type;
	public DeleteOrderItemHandler(Activity context2,
			LoadingDialog dialog,boolean isInOrder) {
		super();
		this.context = context2;
		this.dialog = dialog;
		this.isInOrder=isInOrder;
		this.type=type;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			BootstrapButton b2 = (BootstrapButton)context.findViewById(R.id.query_order_query_enter);
        	b2.performClick();
        	 new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
			 .setTitleText("成功")
             .setContentText((String) map.get("info"))
             .setConfirmText("确定")
             .showCancelButton(false)
             .setCancelClickListener(null)
             .setConfirmClickListener(null).show();
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
