package com.herotculb.qunhaichat.crm.querychance;

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
import com.herotculb.qunhaichat.crm.notes.window.SelectedLinkManWindow;
import com.herotculb.qunhaichat.dto.LinkManListDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class QueryLinkManAdapter extends BaseAdapter {
	private Activity  context;
	private List<LinkManListDto> list;
	int layout;
	
	public QueryLinkManAdapter(Activity context, List<LinkManListDto> list,
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
		final LinkManListDto dto = (LinkManListDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				layout, null);
		if(gridLayout.findViewById(R.id.crm_linkman_name)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.crm_linkman_name);
			TextView text1 = (TextView) gridLayout.findViewById(R.id.crm_linkman_tel);
			TextView text2 = (TextView) gridLayout.findViewById(R.id.crm_linkman_sex);
			TextView text3 = (TextView) gridLayout.findViewById(R.id.crm_linkman_position);
			BootstrapButton update =(BootstrapButton) gridLayout.findViewById(R.id.crm_linkman_update);
			BootstrapButton delete =(BootstrapButton) gridLayout.findViewById(R.id.crm_linkman_delete);
			BootstrapButton check =(BootstrapButton) gridLayout.findViewById(R.id.crm_linkman_check);
			text.setText("姓名："+dto.getLinkManName());
			text1.setText("联系人电话："+dto.getLinkManPhone());
			text2.setText("联系人性别："+dto.getLinkManSex());
			text3.setText("联系人职位："+dto.getLinkManJob());
			update.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 修改
					LoadingDialog dialog = new LoadingDialog(context, "正在获取数据");
					dialog.show();
					GetLinkmanByIdHandler handler = 
							new GetLinkmanByIdHandler(context, dialog, "update");
					GetLinkmanByIdThread thread = 
							new GetLinkmanByIdThread(context, dto.getId()+"", handler);
					thread.start();
				}
			});
			check.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 查看
					LoadingDialog dialog = new LoadingDialog(context, "正在获取数据");
					dialog.show();
					GetLinkmanByIdHandler handler = 
							new GetLinkmanByIdHandler(context, dialog, "check");
					GetLinkmanByIdThread thread = 
							new GetLinkmanByIdThread(context, dto.getId()+"", handler);
					thread.start();
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
	        				DeleteLinkManHandler handler = 
	        						new DeleteLinkManHandler(context, dialog, sDialog);
	        				DeleteLinkManThread thread = 
	        						new DeleteLinkManThread(context, String.valueOf(dto.getId()), handler);
	        				thread.start();
	                    }
	                })
	                .show();
				}
			});
		}else{
			TextView text  = (TextView) gridLayout.findViewById(R.id.crm_grab_linkman_name);
			TextView text1 = (TextView) gridLayout.findViewById(R.id.crm_grab_linkman_sex);
			text.setText(dto.getLinkManName());
			text1.setText(dto.getLinkManSex());
			BootstrapButton check =(BootstrapButton) gridLayout.findViewById(R.id.crm_grab_linkman_check);
			check.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 选中
					Intent i = new Intent(context, SelectedLinkManWindow.class);  
			        Bundle b2 = new Bundle();
			        b2.putString("type", "grab_linkman");
			        b2.putString("linkManName", dto.getLinkManName());
			        b2.putString("linkManId", dto.getId()+"");
			        i.putExtras(b2);
			        context.setResult(context.RESULT_OK, i);
			        context.finish();  
				}
			});
		}
		return gridLayout;
	}

}
