package com.herotculb.qunhaichat.homeactiviti.goods.query.gooddata;

import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.GoodsTableDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GoodsDataHandler  extends Handler{
	Activity context;
	LoadingDialog dialog;
	public GoodsDataHandler(Activity context2,
			LoadingDialog dialog) {
		super();
		this.context = context2;
		this.dialog = dialog;
	}
	@SuppressLint("ResourceAsColor")
	@Override
	public void handleMessage(android.os.Message msg) {
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		Boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			GoodsTableDto dto=(GoodsTableDto) map.get("obj");
			TextView inzongjia=(TextView)context.findViewById(R.id.good_query_item_jinhuozongjia);
			TextView outzongjia=(TextView)context.findViewById(R.id.good_query_item_xiaoshouzongjia);
			TextView jinhuojiage=(TextView)context.findViewById(R.id.good_query_item_jinhuojiage);
			TextView xiaoshouzongliang=(TextView)context.findViewById(R.id.good_query_item_xiaoshouzongliang);
			inzongjia.setText("进货总价:"+dto.getTotalInPrice());
			outzongjia.setText("销售总价:"+dto.getTotalPrice());
			jinhuojiage.setText("进货价格:"+dto.getInPrice());
			xiaoshouzongliang.setText("销售总量:"+dto.getSalesNum());
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
