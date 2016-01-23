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

public class LookOrderItemHandler  extends Handler{
	HomeActivity context;
	LoadingDialog dialog;
	boolean isInOrder;
	String type;
	public LookOrderItemHandler(HomeActivity context2,
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
			List<OrdersItemDto> list=(List<OrdersItemDto>) map.get("data");
			
			ScrollView scroll;
			TableLayout datascroll;
			if(isInOrder){
	    		 scroll=(ScrollView)context.findViewById(R.id.good_ingoods_list);
	     		datascroll=(TableLayout)context.findViewById(R.id.good_ingoods_data_list);
	     		InOrderDto obj=(InOrderDto) map.get("obj");
	     		TextView idtext=(TextView) context.findViewById(R.id.orderId);
	     		idtext.setText(obj.getId()+"");
	     		if(obj.getState()==0){
	    			 //未入库
	     			context.isruku=false;
	     			BootstrapButton save=(BootstrapButton)context.findViewById(R.id.good_ingoods_main_save);
					BootstrapButton ruke=(BootstrapButton)context.findViewById(R.id.good_ingoods_main_ruku);
					save.setVisibility(View.VISIBLE);
					ruke.setVisibility(View.VISIBLE);
	     			TableRow manager=(TableRow)context.findViewById(R.id.good_order_manager);
	        		 manager.setVisibility(View.VISIBLE);
	    		 }else{
	    			 //已入库
	    			 context.isruku=true;
	    			 TableRow manager=(TableRow)context.findViewById(R.id.good_order_manager);
	        		 manager.setVisibility(View.VISIBLE);
	    			 BootstrapButton save=(BootstrapButton)context.findViewById(R.id.good_ingoods_main_save);
						BootstrapButton ruke=(BootstrapButton)context.findViewById(R.id.good_ingoods_main_ruku);
						save.setVisibility(View.GONE);
						ruke.setVisibility(View.GONE);
	    		 }
			}else{
				scroll=(ScrollView)context.findViewById(R.id.good_outgoods_list);
	    		  datascroll=(TableLayout)context.findViewById(R.id.good_outgoods_data_list);
	    		  OrdersDto obj=(OrdersDto) map.get("obj");
		    		  TextView idtext=(TextView) context.findViewById(R.id.orderId);
			     		idtext.setText(obj.getId()+"");
	    		 if(obj.getState()==0){
	    			 //未入库
	    			 context.isruku=false;
	    			 BootstrapButton save=(BootstrapButton)context.findViewById(R.id.good_outgoods_main_save);
						BootstrapButton ruke=(BootstrapButton)context.findViewById(R.id.good_outgoods_main_ruku);
	    			 TableRow manager=(TableRow)context.findViewById(R.id.good_order_manager);
	        		 manager.setVisibility(View.VISIBLE);
	        		 save.setVisibility(View.VISIBLE);
					ruke.setVisibility(View.VISIBLE);
					BootstrapButton prin=(BootstrapButton)context.findViewById(R.id.good_outgoods_main_print);
					prin.setVisibility(View.VISIBLE);
	    		 }else{
	    			 //已入库
	    			 context.isruku=true;
	    			 TableRow manager=(TableRow)context.findViewById(R.id.good_order_manager);
	        		 manager.setVisibility(View.VISIBLE);
	    			BootstrapButton save=(BootstrapButton)context.findViewById(R.id.good_outgoods_main_save);
					BootstrapButton ruke=(BootstrapButton)context.findViewById(R.id.good_outgoods_main_ruku);
					save.setVisibility(View.GONE);
					ruke.setVisibility(View.GONE);
					BootstrapButton prin=(BootstrapButton)context.findViewById(R.id.good_outgoods_main_print);
					prin.setVisibility(View.GONE);
	    		 }
	    		 TextView scoreNum=(TextView) context.findViewById(R.id.good_ingoods_scoreNum);
	      		scoreNum.setText("");
			}
     		
    		 datascroll.setVisibility(View.VISIBLE);
    		 scroll.setVisibility(View.GONE);
			 context.goodstabledtoList=list;
			 context.showOrderList(datascroll, context.goodstabledtoList, context);
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
