package com.herotculb.qunhaichat.messageinfo;

import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.MessageSetDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class SetTempHandler extends Handler {
	Activity context;
	ViewGroup view;
	LoadingDialog dialog;
	
	public SetTempHandler(Activity context, LoadingDialog dialog) {
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
		if(b){
			MessageSetDto dto = (MessageSetDto)map.get("obj");
			if(context.findViewById(R.id.message_model_add_score_text)!=null){
				TextView text = (TextView)context
						.findViewById(R.id.message_model_add_score_text);
				text.setText("模板说明 ：在平台所有给用户添加积分的时候都将发送此信息到用户手机,不得超过240个字，"
						+ "每条短信60个字,请勿使用【】这样的字符，使用后，系统自动替换[]\n"
						+ "参数说明：\n@NOW_SCORE,当前积分\n@ADD_SCORE,添加积分"
						+ "\n@ADD_BEFORE_SCORE,添加积分之前所剩余积分\n"
						+ "@ADD_AFTER_SCORE,添加积分后\n@VIP_NAME,会员名\n@VIP_PHONE,会员电话");
				BootstrapEditText marks = (BootstrapEditText)context
						.findViewById(R.id.message_model_add_score_marks);
				marks.setText(dto.getAddscoreToVipContent());
			}else if(context.findViewById(R.id.message_model_add_price_text)!=null){
				TextView text = (TextView)context
						.findViewById(R.id.message_model_add_price_text);
				text.setText("模板说明 ： 在平台所有给用户添加储值的时候都将发送此信息到用户手机,"
						+ "不得超过240个字，每条短信60个字,请勿使用【】这样的字符，"
						+ "使用后，系统自动替换[]\n参数说明：\n"
						+ "@NOW_PRICE,当前余额\n@ADD_PRICE,添加余额\n"
						+ "@ADD_BEFORE_PRICE ,添加余额之前所剩余余额\n"
						+ "@ADD_AFTER_PRICE,添加余额后\n@VIP_NAME,会员名\n@VIP_PHONE,会员电话");
				BootstrapEditText marks = (BootstrapEditText)context
						.findViewById(R.id.message_model_add_price_marks);
				marks.setText(dto.getAddPriceToVipContent());
			}else if(context.findViewById(R.id.message_model_jian_score_text)!=null){
				TextView text = (TextView)context
						.findViewById(R.id.message_model_jian_score_text);
				text.setText("模板说明 ： 在平台所有给用户减少积分的时候都将发送此信息到用户手机,"
						+ "不得超过240个字，每条短信60个字,请勿使用【】这样的字符，"
						+ "使用后，系统自动替换[]\n参数说明：\n"
						+ "@NOW_SCORE,当前积分\n@REDUCE_SCORE,减少积分\n"
						+ "@REDUCE_BEFORE_SCORE,减少积分之前所剩余积分\n"
						+ "@REDUCE_AFTER_SCORE,减少积分后\n@VIP_NAME,会员名\n@VIP_PHONE,会员电话");
				BootstrapEditText marks = (BootstrapEditText)context
						.findViewById(R.id.message_model_jian_score_marks);
				marks.setText(dto.getReducesscoreToVipContent());
			}else if(context.findViewById(R.id.message_model_jian_price_text)!=null){
				TextView text = (TextView)context
						.findViewById(R.id.message_model_jian_price_text);
				text.setText("模板说明 ： 在平台所有给用户添加储值的时候都将发送此信息到用户手机,"
						+ "不得超过240个字，每条短信60个字,请勿使用【】这样的字符，"
						+ "使用后，系统自动替换[]\n参数说明：\n@NOW_PRICE,当前余额\n"
						+ "@REDUCE_PRICE,减少余额\n@REDUCE_BEFORE_PRICE ,减少余额之前所剩余余额\n"
						+ "@REDUCE_AFTER_PRICE,减少余额后\n@VIP_NAME,会员名\n@VIP_PHONE,会员电话");
				BootstrapEditText marks = (BootstrapEditText)context
						.findViewById(R.id.message_model_jian_price_marks);
				marks.setText(dto.getReducesPriceToVipContent());
			}else if(context.findViewById(R.id.message_model_order_text)!=null){
				TextView text = (TextView)context
						.findViewById(R.id.message_model_order_text);
				text.setText("模板说明 ： 在平台所有给用户添加积分的时候都将发送此信息到用户手机,"
						+ "不得超过240个字，每条短信60个字,请勿使用【】这样的字符，"
						+ "使用后，系统自动替换[]\n参数说明：\n@CONTENT_ORDER_NAME,订单编号\n"
						+ "@CONTENT_ORDER_DATE,订单时间\n@CONTENT_ORDER_ITEM_LIST ,订单列表\n"
						+ "@VIP_NAME,会员名\n@VIP_PHONE,会员电话\nps:还要设置接收人手机号");
				BootstrapEditText marks = (BootstrapEditText)context
						.findViewById(R.id.message_model_order_marks);
				marks.setText(dto.getOrderToUserContent());
				BootstrapEditText phone = (BootstrapEditText)context
						.findViewById(R.id.message_model_order_phone);
				phone.setText(dto.getOrderToUserPhone());
			}
			
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE).setTitleText("创建新奖品")
            .setContentText(String.valueOf(map.get("info")))
            .setConfirmText("确定")
            .showCancelButton(false)
            .setCancelClickListener(null)
            .setConfirmClickListener(null)
            .changeAlertType(SweetAlertDialog.ERROR_TYPE);
		}
	}
}
