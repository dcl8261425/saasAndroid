package com.herotculb.qunhaichat.group;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyGroupDto;
import com.herotculb.qunhaichat.group.operation.DeleteGroupHandler;
import com.herotculb.qunhaichat.group.operation.DeleteGroupThread;
import com.herotculb.qunhaichat.group.window.CreateGroupWindow;
import com.herotculb.qunhaichat.group.window.PermissionGetGroupCompanyUserWindow;
import com.herotculb.qunhaichat.homeactiviti.group.GroupManager;
import com.herotculb.qunhaichat.permission.window.LookUpRoleAllWindow;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetAllGroupAdapter extends BaseAdapter {
	private Activity  context;
	private List<ConpanyGroupDto> list;
	private int layout;
	LayoutInflater inflater;
	LinearLayout gridLayout;
	GroupManager gm;
	public GetAllGroupAdapter(Activity context, List<ConpanyGroupDto> list,
			int layout,GroupManager gm) {
		super();
		this.context = context;
		this.list = list;
		this.layout = layout;
		this.gm=gm;
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
		final ConpanyGroupDto dto = (ConpanyGroupDto) getItem(position);
		inflater = LayoutInflater.from(context);
		gridLayout = (TableLayout) inflater.inflate(
				layout, null);
			TextView text  = (TextView) gridLayout.findViewById(R.id.get_all_group_name);
			TextView text1  = (TextView) gridLayout.findViewById(R.id.get_all_group_truename);
			TextView text2  = (TextView) gridLayout.findViewById(R.id.get_all_group_usernum);
			TextView text3  = (TextView) gridLayout.findViewById(R.id.get_all_group_marks);
			BootstrapButton roleManager =(BootstrapButton) gridLayout.findViewById(R.id.get_all_group_role_manager);
			BootstrapButton userManager =(BootstrapButton) gridLayout.findViewById(R.id.get_all_group_user_manager);
			BootstrapButton leaf =(BootstrapButton) gridLayout.findViewById(R.id.get_all_group_leaf);
			BootstrapButton update =(BootstrapButton) gridLayout.findViewById(R.id.get_all_group_update);
			BootstrapButton delete =(BootstrapButton) gridLayout.findViewById(R.id.get_all_group_delete);
			text.setText("组名："+dto.getGroupName());
			text1.setText("创建者："+dto.getCreateConpanyGroupUserTrueName());
			text2.setText("成员数："+String.valueOf(dto.getUserNum()));
			text3.setText("备注："+dto.getGroupMarks());
			roleManager.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 管理角色及角色权限
					Intent i = new Intent(context, LookUpRoleAllWindow.class);  
					Bundle b = new Bundle(); 
					b.putString("classes", "com.herotculb.qunhaichat.HomeActivity");
					b.putString("groupName", dto.getGroupName());
					b.putString("groupId", String.valueOf(dto.getId()));
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			userManager.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 组员管理
					Intent i = new Intent(context, PermissionGetGroupCompanyUserWindow.class);  
					Bundle b = new Bundle(); 
					b.putString("classes", "com.herotculb.qunhaichat.HomeActivity");
					b.putString("groupName", dto.getGroupName());
					b.putString("groupId", String.valueOf(dto.getId()));
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			leaf.setOnClickListener(new OnClickListener() {
				// TODO 查询显示子组
				XListView list;
				@Override
				public void onClick(View v) {
					gm.groupId=String.valueOf(dto.getId());
					LoadingDialog dialog = new LoadingDialog(GetAllGroupAdapter.this.context, "正在获取数据");
					dialog.show();
					XListView view=(XListView) GetAllGroupAdapter.this.context.findViewById(R.id.get_all_group_list);
					GetAllGroupHandler handler = 
							new GetAllGroupHandler(GetAllGroupAdapter.this.context, view, dialog,layout,gm);
					GetAllGroupThread thread = 
							new GetAllGroupThread(GetAllGroupAdapter.this.context, "1", "10", String.valueOf(dto.getId()), "", handler);
					thread.start();
				}
			});
			update.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 修改
					Intent i = new Intent(context, CreateGroupWindow.class);  
					Bundle b = new Bundle(); 
					b.putString("id", dto.getId()+"");
					b.putString("name", dto.getGroupName());
					b.putString("marks", dto.getGroupMarks());
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
							DeleteGroupHandler handler = 
									new DeleteGroupHandler(context, dialog,sDialog);
							DeleteGroupThread thread = 
									new DeleteGroupThread(context, String.valueOf(dto.getId()), handler);
							thread.start();
	                    }
	                })
	                .show();
				}
			});
		
		return gridLayout;
	}

}
