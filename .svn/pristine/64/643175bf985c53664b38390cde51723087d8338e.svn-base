package com.herotculb.qunhaichat.messageinfo;

import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.MessageSetDto;
import com.herotculb.qunhaichat.homeactiviti.messageinfo.MessageSetManager;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetMessageSetHandler extends Handler {
	Activity context;
	ViewGroup view;
	LoadingDialog dialog;
	MessageSetDto dto;
	MessageSetManager msm;
	String qianMStr;
	BootstrapEditText qianM;
	
	public GetMessageSetHandler(Activity context, LoadingDialog dialog,
			MessageSetManager msm) {
		super();
		this.context = context;
		this.dialog = dialog;
		this.msm = msm;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			TextView addScoreNum = (TextView)
					context.findViewById(R.id.message_get_message_set_addscore_num);
			TextView addPriceNum = (TextView)
					context.findViewById(R.id.message_get_message_set_addprice_num);
			TextView jianScoreNum = (TextView)
					context.findViewById(R.id.message_get_message_set_jianscore_num);
			TextView jianPriceNum = (TextView)
					context.findViewById(R.id.message_get_message_set_jianprice_num);
			TextView orderNum = (TextView)
					context.findViewById(R.id.message_get_message_set_order_num);
			TextView num = (TextView)
					context.findViewById(R.id.message_get_message_set_num);
			BootstrapButton addScore = (BootstrapButton) context.findViewById(R.id.message_get_message_set_addscore);
			BootstrapButton addPrice = (BootstrapButton) context.findViewById(R.id.message_get_message_set_addprice);
			BootstrapButton jianScore = (BootstrapButton) context.findViewById(R.id.message_get_message_set_jianscore);
			BootstrapButton jianPrice = (BootstrapButton) context.findViewById(R.id.message_get_message_set_jianprice);
			BootstrapButton order = (BootstrapButton) context.findViewById(R.id.message_get_message_set_order);
			BootstrapButton qianMing = (BootstrapButton) context.findViewById(R.id.message_get_message_set_qianming_button);
			qianM = (BootstrapEditText)context.findViewById(R.id.message_get_message_set_qianming);
			dto = (MessageSetDto)map.get("obj");
			addScoreNum.setText("已发送"+dto.getAddscoreToVipnum()+"条");
			addPriceNum.setText("已发送"+dto.getAddPriceToVipnum()+"条");
			jianScoreNum.setText("已发送"+dto.getReducesscoreToVipnum()+"条");
			jianPriceNum.setText("已发送"+dto.getReducesPriceToVipnum()+"条");
			orderNum.setText("已发送"+dto.getOrderToUsernum()+"条");
			num.setText("当前剩余短信数量"+dto.getNum()+"条");
			if(dto.isAddscoreToVip()){
				addScore.setText("开启");
			}else {
				addScore.setText("关闭");
			}
			if(dto.isAddPriceToVip()){
				addPrice.setText("开启");
			}else{
				addPrice.setText("关闭");
			}
			if(dto.isReducescoreToVip()){
				jianScore.setText("开启");
			}else{
				jianScore.setText("关闭");
			}
			if(dto.isReducePriceToVip()){
				jianPrice.setText("开启");
			}else{
				jianPrice.setText("关闭");
			}
			if(dto.isOrderToUser()){
				order.setText("开启");
			}else{
				order.setText("关闭");
			}
			addScore.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 添加积分开关
					LoadingDialog dialog = new LoadingDialog(context,"正在保存数据！");
					dialog.show();
					SetBooleanHandler handler = 
							new SetBooleanHandler(context, dialog,msm);
					SetBooleanThread thread = 
							new SetBooleanThread(context,
									String.valueOf(dto.isAddscoreToVip()),"1", handler);
					thread.start();
				}
			});
			addPrice.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 加储值开关
					LoadingDialog dialog = new LoadingDialog(context,"正在保存数据！");
					dialog.show();
					SetBooleanHandler handler = 
							new SetBooleanHandler(context, dialog,msm);
					SetBooleanThread thread = 
							new SetBooleanThread(context,
									String.valueOf(dto.isAddPriceToVip()),"2", handler);
					thread.start();
				}
			});
			jianScore.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 减积分开关
					LoadingDialog dialog = new LoadingDialog(context,"正在保存数据！");
					dialog.show();
					SetBooleanHandler handler = 
							new SetBooleanHandler(context, dialog,msm);
					SetBooleanThread thread = 
							new SetBooleanThread(context,
									String.valueOf(dto.isReducescoreToVip()),"3", handler);
					thread.start();
				}
			});
			jianPrice.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 减储值开发
					LoadingDialog dialog = new LoadingDialog(context,"正在保存数据！");
					dialog.show();
					SetBooleanHandler handler = 
							new SetBooleanHandler(context, dialog,msm);
					SetBooleanThread thread = 
							new SetBooleanThread(context,
									String.valueOf(dto.isReducePriceToVip()),"4", handler);
					thread.start();
				}
			});
			order.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 订单开关
					LoadingDialog dialog = new LoadingDialog(context,"正在保存数据！");
					dialog.show();
					SetBooleanHandler handler = 
							new SetBooleanHandler(context, dialog,msm);
					SetBooleanThread thread = 
							new SetBooleanThread(context,
									String.valueOf(dto.isOrderToUser()),"5", handler);
					thread.start();
				}
			});
			qianMing.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					qianMStr = qianM.getText().toString();
					Log.e("qianMStr--", qianMStr);
					// TODO 短信签名
					LoadingDialog dialog = new LoadingDialog(context,"正在保存数据！");
					dialog.show();
					SetBooleanHandler handler = 
							new SetBooleanHandler(context, dialog,msm);
					SetBooleanThread thread = 
							new SetBooleanThread(context,
									qianMStr,"99", handler);
					thread.start();
				}
			});
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
