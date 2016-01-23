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
import android.widget.TableLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.notes.window.CrmGroupCompanyUserWindow;
import com.herotculb.qunhaichat.dto.ConpanyGroupDto;
import com.herotculb.qunhaichat.goods.store.window.GetGroupCompanyUserWindow;

public class GetUserInGroupAdapter extends BaseAdapter {
	private Activity  context;
	private List<ConpanyGroupDto> list;
	private String classes;
	private String isGroup;
	int layout;
	
	public GetUserInGroupAdapter(Activity context, List<ConpanyGroupDto> list,
			String classes, String isGroup, int layout) {
		super();
		this.context = context;
		this.list = list;
		this.classes = classes;
		this.isGroup = isGroup;
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
		final ConpanyGroupDto dto = (ConpanyGroupDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				layout, null);
		if(gridLayout.findViewById(R.id.group_name)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.group_name);
			BootstrapButton groupButton =(BootstrapButton) gridLayout.findViewById(R.id.user_in_group_list_button);
			BootstrapButton search =(BootstrapButton) gridLayout.findViewById(R.id.user_in_group_list_search);
			text.setText(dto.getGroupName());
			if(isGroup.equals("false")){
				groupButton.setVisibility(View.GONE);
				search.setVisibility(View.VISIBLE);
			}
			groupButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 选中组   备用方法-不选成员时使用。
					
				}
			});
			search.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 查看成员
					Intent i = new Intent(context, GetGroupCompanyUserWindow.class);  
					Bundle b = new Bundle(); 
					b.putString("classes", "com.herotculb.qunhaichat.goods.store.window.GetUserInGroupWindow");
					b.putString("groupName", dto.getGroupName());
					b.putString("groupId", String.valueOf(dto.getId()));
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
		}else{
			TextView text  = (TextView) gridLayout.findViewById(R.id.crm_group_name);
			BootstrapButton groupButton =(BootstrapButton) gridLayout.findViewById(R.id.crm_user_in_group_list_button);
			BootstrapButton search =(BootstrapButton) gridLayout.findViewById(R.id.crm_user_in_group_list_search);
			text.setText(dto.getGroupName());
			if(isGroup.equals("false")){
				groupButton.setVisibility(View.GONE);
				search.setVisibility(View.VISIBLE);
			}
			text.setText(dto.getGroupName());
			search.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 查看成员
					Intent i = new Intent(context, CrmGroupCompanyUserWindow.class);  
					Bundle b = new Bundle(); 
					b.putString("classes", "com.herotculb.qunhaichat.crm.notes.window.CrmUserInGroupWindow");
					b.putString("groupName", dto.getGroupName());
					b.putString("groupId", String.valueOf(dto.getId()));
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
		}
		return gridLayout;
	}

}
