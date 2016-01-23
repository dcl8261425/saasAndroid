package com.herotculb.qunhaichat.employee.interactive.adapter;

import java.util.List;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyZoneRetDto;
import com.herotculb.qunhaichat.dto.ImageList;

public class RetListAdapter extends BaseAdapter {
	private Activity  context;
	private List<ConpanyZoneRetDto> list;
	
	public RetListAdapter(Activity context, List<ConpanyZoneRetDto> list) {
		super();
		this.context = context;
		this.list = list;
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
		final ConpanyZoneRetDto dto = (ConpanyZoneRetDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.employee_ret_list, null);
		if(gridLayout.findViewById(R.id.ret_list_create_user)!=null){
			TextView createUser = (TextView)gridLayout.findViewById(R.id.ret_list_create_user);
			TextView content  = (TextView) gridLayout.findViewById(R.id.ret_list_content);
			TextView createDate  = (TextView) gridLayout.findViewById(R.id.ret_list_create_date);
			createUser.setText(dto.getCreateUserName());
			content.setText(dto.getContent());
			
		}
		return gridLayout;
	}

}
