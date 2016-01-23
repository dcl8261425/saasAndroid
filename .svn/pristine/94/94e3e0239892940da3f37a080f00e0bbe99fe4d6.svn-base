package com.herotculb.qunhaichat.group;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.herotculb.qunhaichat.dto.ConpanyUserDto;
import com.herotculb.qunhaichat.group.operation.DeleteCompanyUserFromGroupHandler;
import com.herotculb.qunhaichat.group.operation.DeleteCompanyUserFromGroupThread;
import com.herotculb.qunhaichat.group.operation.DeleteGroupHandler;
import com.herotculb.qunhaichat.group.operation.DeleteGroupThread;
import com.herotculb.qunhaichat.group.operation.InsertCompanyUserToGroupHandler;
import com.herotculb.qunhaichat.group.operation.InsertCompanyUserToGroupThread;
import com.herotculb.qunhaichat.permission.window.LookUpRoleByUserWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetGroupCompanyUserAdapter extends BaseAdapter {
	private Activity  context;
	private List<ConpanyUserDto> list;
	private String classes;
	private String groupId;
	private Class clazz;
	private int layout;
	
	public GetGroupCompanyUserAdapter(Activity context,
			List<ConpanyUserDto> list, String classes, String groupId,
			 int layout) {
		super();
		this.context = context;
		this.list = list;
		this.classes = classes;
		this.groupId = groupId;
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
		final ConpanyUserDto dto = (ConpanyUserDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				layout, null);
		if(gridLayout.findViewById(R.id.user_name)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.user_name);
			TextView text1  = (TextView) gridLayout.findViewById(R.id.user_phone);
			BootstrapButton userButton =(BootstrapButton) gridLayout.findViewById(R.id.user_company_group_list_button);
			text.setText("真实名："+dto.getTrueName());
			text1.setText("联系电话："+dto.getPhone());
			try {
				Class clazz1 = Class.forName(classes);
				clazz = clazz1;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			userButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 选中组
					Intent i = new Intent(context, clazz);  
					Bundle b = new Bundle(); 
					b.putString("type", "select_username");
					b.putString("userName", dto.getTrueName());
					b.putString("userId", String.valueOf(dto.getId()));
					i.putExtras(b);  
					context.setResult(context.RESULT_OK, i);
					context.finish();
				}
			});
		}else if(gridLayout.findViewById(R.id.permission_name)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.permission_name);
			TextView text1  = (TextView) gridLayout.findViewById(R.id.permission_truename);
			TextView text2  = (TextView) gridLayout.findViewById(R.id.permission_address);
			TextView text3  = (TextView) gridLayout.findViewById(R.id.permission_phone);
			text.setText("用户账号："+dto.getUsername());
			text1.setText("真实名："+dto.getTrueName());
			text2.setText("通讯地址："+dto.getAddress());
			text3.setText("联系电话："+dto.getPhone());
			BootstrapButton delete =(BootstrapButton) gridLayout.findViewById(R.id.permission_delete);
			BootstrapButton roleManager =(BootstrapButton) gridLayout.findViewById(R.id.permission_role_manager);
			delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 删除
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
							DeleteCompanyUserFromGroupHandler handler = 
									new DeleteCompanyUserFromGroupHandler(context, dialog, sDialog);
							DeleteCompanyUserFromGroupThread thread = 
									new DeleteCompanyUserFromGroupThread(context, String.valueOf(dto.getId()), groupId, handler);
							thread.start();
	                    }
	                })
	                .show();
				}
			});
			roleManager.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 角色管理
					Intent i = new Intent(context, LookUpRoleByUserWindow.class);  
					Bundle b = new Bundle(); 					
					b.putString("groupId", groupId);
					b.putString("userId", String.valueOf(dto.getId()));
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
//					context.finish();
				}
			});
			
		}else if(gridLayout.findViewById(R.id.permission_insert_name)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.permission_insert_name);
			TextView text1  = (TextView) gridLayout.findViewById(R.id.permission_insert_truename);
			TextView text2  = (TextView) gridLayout.findViewById(R.id.permission_insert_address);
			TextView text3  = (TextView) gridLayout.findViewById(R.id.permission_insert_phone);
			text.setText("用户账号："+dto.getUsername());
			text1.setText("真实名："+dto.getTrueName());
			text2.setText("通讯地址："+dto.getAddress());
			text3.setText("联系电话："+dto.getPhone());
			BootstrapButton add =(BootstrapButton) gridLayout.findViewById(R.id.permission_insert_add);
			add.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 添加用户
					groupId = "2";
					LoadingDialog dialog = new LoadingDialog(context, "正在获取数据！");
					dialog.show();
					InsertCompanyUserToGroupHandler handler = 
							new InsertCompanyUserToGroupHandler(context, dialog);
					InsertCompanyUserToGroupThread thread = 
							new InsertCompanyUserToGroupThread(context, String.valueOf(dto.getId()), groupId, handler);
					thread.start();
				}
			});
		}
		
		return gridLayout;
	}

}
