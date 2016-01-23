package com.herotculb.qunhaichat.weixin.getvip.adopter;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ScoreDuihuanDto;
import com.herotculb.qunhaichat.messageinfo.window.MessageVipDuiHuanWindow;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinDelDuiHuanHandler;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinDelDuiHuanThread;
import com.herotculb.qunhaichat.weixin.operationvip.window.VipCreateDuiHuanWindowActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGetDuiHuanAdapter extends BaseAdapter {
	private Activity  context;
	private List<ScoreDuihuanDto> list;
	int layout;
	
	public WeixinGetDuiHuanAdapter(Activity context, List<ScoreDuihuanDto> list,
			int layout) {
		super();
		this.context = context;
		this.list = list;
		this.layout = layout;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		final ScoreDuihuanDto dto = (ScoreDuihuanDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				layout, null);
		if(gridLayout.findViewById(R.id.scoreName)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.scoreName);
			TextView text1 = (TextView) gridLayout.findViewById(R.id.score);
			BootstrapButton update =(BootstrapButton) gridLayout.findViewById(R.id.weixin_dui_huan_update);
			BootstrapButton del =(BootstrapButton) gridLayout.findViewById(R.id.weixin_dui_huan_del);
			update.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent(context, VipCreateDuiHuanWindowActivity.class);  
					Bundle b = new Bundle();  
					b.putString("id", String.valueOf(dto.getId()));
					b.putString("name", dto.getName());
					b.putString("image", dto.getImage());
					b.putString("content", dto.getContent());
					b.putString("score", String.valueOf(dto.getScore()));
					b.putString("num", String.valueOf(dto.getNum()));
	                i.putExtras(b);  
	                context.startActivityForResult(i,0);
	                context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			del.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
	                .setTitleText("删除")
	                .setContentText("您确定删除此信息？")
	                .setCancelText("取消")
	                .setConfirmText("确定")
	                .showCancelButton(true)
	                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
	                    @Override
	                    public void onClick(SweetAlertDialog sDialog) {
	                        // reuse previous dialog instance, keep widget user state, reset them if you need
	                        sDialog.setTitleText("取消删除")
	                                .setContentText("您的删除已经取消")
	                                .setConfirmText("确定")
	                                .showCancelButton(false)
	                                .setCancelClickListener(null)
	                                .setConfirmClickListener(null)
	                                .changeAlertType(SweetAlertDialog.ERROR_TYPE);
	                    }
	                })
	                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
	                    @Override
	                    public void onClick(SweetAlertDialog sDialog) {
	                    	LoadingDialog dialog = new LoadingDialog(context, "正在获取数据");
							dialog.show();
							WeixinDelDuiHuanHandler handler = new WeixinDelDuiHuanHandler(context, dialog,sDialog);
							WeixinDelDuiHuanThread thread = new WeixinDelDuiHuanThread(context,dto.getId(), handler);
							thread.start();
	                    }
	                })
	                .show();
				}
			});
			text.setText("物名："+dto.getName());
			text1.setText("积分："+dto.getScore());
		}else if(gridLayout.findViewById(R.id.message_vip_send_duihuan_scoreName)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.message_vip_send_duihuan_scoreName);
			BootstrapButton select =(BootstrapButton) gridLayout.findViewById(R.id.message_vip_send_duihuan_select);
			select.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 选中
					Intent i = new Intent(context, HomeActivity.class);  
			        Bundle b = new Bundle();
			        b.putString("type", "message_vip_send_select");
			        b.putString("id", String.valueOf(dto.getId()));
			        b.putString("name", dto.getName());
			        i.putExtras(b);
			        context.setResult(context.RESULT_OK,i );
			        context.finish();
				}
			});
			text.setText(dto.getName());
		}
		
		return gridLayout;
	}

}
