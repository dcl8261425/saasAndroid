package com.herotculb.qunhaichat.weixin.gailan.wenzhang.adapter;

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
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.WebPublicMessageDto;
import com.herotculb.qunhaichat.weixin.gailan.wenzhang.DeleteWenZhangHandler;
import com.herotculb.qunhaichat.weixin.gailan.wenzhang.DeleteWenZhangSetThread;
import com.herotculb.qunhaichat.weixin.gailan.wenzhang.WebActivity;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WenzhangAdapter extends BaseAdapter {
	private Activity  context;
	private List<WebPublicMessageDto> list;
	public WenzhangAdapter(Activity context,List<WebPublicMessageDto> list){
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
		final WebPublicMessageDto dto=(WebPublicMessageDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.weixin_gailan_wenzhang_item, null);
		TextView text=(TextView) gridLayout.findViewById(R.id.weixin_gailan_wenzhang_item_name);
		TextView text2=(TextView) gridLayout.findViewById(R.id.weixin_gailan_wenzhang_item_num);
		BootstrapButton delete=(BootstrapButton) gridLayout.findViewById(R.id.weixin_gailan_wenzhang_item_delete);
		BootstrapButton look=(BootstrapButton) gridLayout.findViewById(R.id.weixin_gailan_wenzhang_item_look);
		look.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(context, WebActivity.class);  
				Bundle b = new Bundle();
				b.putString("name", dto.getName());
				b.putString("link", dto.getLinkaddress());
				b.putBoolean("isTP", dto.isVote());
				b.putLong("num", dto.getLooknum());
				b.putLong("id", dto.getId());
				b.putString("date",dto.getStartdate());
				b.putString("html", dto.getContent());
                i.putExtras(b); 
                context.startActivityForResult(i, 0);  
                context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		delete.setOnClickListener(new OnClickListener() {
			
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
						DeleteWenZhangHandler handler=new DeleteWenZhangHandler(context,dialog,sDialog);
						DeleteWenZhangSetThread thread=new DeleteWenZhangSetThread(context,String.valueOf(dto.getId()), handler);
                    	thread.start();
                    }
                })
                .show();
			}
		});
		
		text.setText(dto.getName());
		text2.setText(dto.getLooknum()+"");
		return gridLayout;
	}

}
