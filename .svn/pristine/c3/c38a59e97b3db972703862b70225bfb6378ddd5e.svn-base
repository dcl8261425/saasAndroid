package com.herotculb.qunhaichat.weixin.gailan.huifushezhi.autoset.item;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.WeiXinAutoReSendItemDTO;
import com.herotculb.qunhaichat.weixin.gailan.window.AutoResendSetItemWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class autoResendadapter extends BaseAdapter{
	private AutoResendSetItemWindow  context;
	private List<WeiXinAutoReSendItemDTO> list;
	public autoResendadapter(AutoResendSetItemWindow context,List<WeiXinAutoReSendItemDTO> list){
		this.context=context;
		this.list=list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final WeiXinAutoReSendItemDTO dto=(WeiXinAutoReSendItemDTO) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.weixin_gailan_autoresoure_item_list_item_window, null);
		TextView text=(TextView) gridLayout.findViewById(R.id.weixin_gailan_autoresoure_item_list_item_text);
		BootstrapButton but=(BootstrapButton) gridLayout.findViewById(R.id.weixin_gailan_autoresoure_item_list_item_delete);
		text.setText(dto.getName());
		but.setOnClickListener(new OnClickListener() {
			
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
	        				AutoResendItemDeleteHandler handler=new AutoResendItemDeleteHandler(context,dialog,sDialog);
	        				AutoResendItemDeleteThread thread=new AutoResendItemDeleteThread(context, dto.getId(), handler);
	        				thread.start();
	                    }
	                })
	                .show();
				
			}
		});
		return gridLayout;
	}

}
