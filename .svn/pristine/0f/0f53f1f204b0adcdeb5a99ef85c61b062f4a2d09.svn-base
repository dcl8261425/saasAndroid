package com.herotculb.qunhaichat.weixin.getgame;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.GamesAwardsListDto;
import com.herotculb.qunhaichat.weixin.getgame.adapter.WeixinGetGuaGuaKaAdapter;
import com.herotculb.qunhaichat.weixin.operationgame.WeixinSetGuaGuaKaJiLvHandler;
import com.herotculb.qunhaichat.weixin.operationgame.WeixinSetGuaGuaKaJiLvThread;
import com.herotculb.qunhaichat.weixin.operationgame.WeixinSetGuaGuaKaNumHandler;
import com.herotculb.qunhaichat.weixin.operationgame.WeixinSetGuaGuaKaNumThread;
import com.herotculb.qunhaichat.weixin.operationgame.WeixinUpdateGameGuaGuaKaHandler;
import com.herotculb.qunhaichat.weixin.operationgame.WeixinUpdateGameGuaGuaKaThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGetGuaGuaKaHandler extends Handler {
	HomeActivity context;
	ListView view;
	LoadingDialog dialog;
	View viewp;
	String useStr,scoreStr;
	public WeixinGetGuaGuaKaHandler(HomeActivity context, ListView view,
			LoadingDialog dialog, View viewp) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.viewp = viewp;
	}
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		if(b){
			BootstrapEditText jilv = (BootstrapEditText)
					context.findViewById(R.id.game_guaguaka_jilv_edit);
			BootstrapEditText num = (BootstrapEditText)
					context.findViewById(R.id.game_guaguaka_num_edit);
			BootstrapButton use = (BootstrapButton)
					context.findViewById(R.id.game_guaguaka_open_button);
			BootstrapButton score = (BootstrapButton)
					context.findViewById(R.id.game_guaguaka_open_score_button);
			BootstrapEditText scoreNum = (BootstrapEditText)
					context.findViewById(R.id.game_guaguaka_score_edit);
			jilv.setText(map.get("jilv").toString());
			num.setText(map.get("num").toString());
			scoreNum.setText(map.get("scoreNum").toString());
			if((Boolean)map.get("use")){
				use.setText("开启");
			}else{
				use.setText("关闭");
			}
			if((Boolean)map.get("score")){
				score.setText("开启");
			}else{
				score.setText("关闭");
			}
			useStr = map.get("use").toString();
			scoreStr = map.get("score").toString();
			use.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 是否开启
					String type = "use";
					LoadingDialog dialog2 = new LoadingDialog(
							context, "正在获取数据");
					dialog2.show();
					WeixinUpdateGameGuaGuaKaHandler handler = 
							new WeixinUpdateGameGuaGuaKaHandler(context, dialog2);
					WeixinUpdateGameGuaGuaKaThread thread = 
							new WeixinUpdateGameGuaGuaKaThread(context, useStr,type, handler);
					thread.start();
				}
			});
			score.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 是否使用积分
					String type = "score";
					LoadingDialog dialog2 = new LoadingDialog(
							context, "正在获取数据");
					dialog2.show();
					WeixinUpdateGameGuaGuaKaHandler handler = 
							new WeixinUpdateGameGuaGuaKaHandler(context, dialog2);
					WeixinUpdateGameGuaGuaKaThread thread = 
							new WeixinUpdateGameGuaGuaKaThread(context,scoreStr, type, handler);
					thread.start();
				}
			});
			
			BootstrapButton jilvButton = (BootstrapButton)
					context.findViewById(R.id.game_guaguaka_jilv_button);
			BootstrapButton numButton = (BootstrapButton)
					context.findViewById(R.id.game_guaguaka_num_button);
			BootstrapButton scoreButton = (BootstrapButton)
					context.findViewById(R.id.game_guaguaka_score_button);
			jilvButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 设置大转盘几率
					String type = "jilv";
					LoadingDialog dialog2 = new LoadingDialog(
							context, "正在获取数据");
					dialog2.show();
					WeixinSetGuaGuaKaJiLvHandler handler = 
							new WeixinSetGuaGuaKaJiLvHandler(context, dialog2);
					WeixinSetGuaGuaKaJiLvThread thread = 
							new WeixinSetGuaGuaKaJiLvThread(context, type,handler);
					thread.start();
				}
			});
			numButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 设置次数
					LoadingDialog dialog2 = new LoadingDialog(
							context, "正在获取数据");
					dialog2.show();
					WeixinSetGuaGuaKaNumHandler handler = 
							new WeixinSetGuaGuaKaNumHandler(context, dialog2);
					WeixinSetGuaGuaKaNumThread thread = 
							new WeixinSetGuaGuaKaNumThread(context, handler);
					thread.start();
				}
			});
			scoreButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 设置积分
					String type = "score";
					LoadingDialog dialog2 = new LoadingDialog(
							context, "正在获取数据");
					dialog2.show();
					WeixinSetGuaGuaKaJiLvHandler handler = 
							new WeixinSetGuaGuaKaJiLvHandler(context, dialog2);
					WeixinSetGuaGuaKaJiLvThread thread = 
							new WeixinSetGuaGuaKaJiLvThread(context,  type,handler);
					thread.start();
				}
			});
			
			List<GamesAwardsListDto> weiXinList = (List<GamesAwardsListDto>) map
					.get("data");
			WeixinGetGuaGuaKaAdapter adapter = new WeixinGetGuaGuaKaAdapter(context, weiXinList);
			view.setAdapter(adapter);
			HomeActivity.setListViewHeightBasedOnChildren(view);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
					.setTitleText("出错了！")
					.setContentText((String) map.get("info")).show();
		}
	}
}
