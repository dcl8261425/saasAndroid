package com.herotculb.qunhaichat.activity.register;

import java.util.List;

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
import com.herotculb.qunhaichat.dto.Hangye;

public class GetHangyeAdapter extends BaseAdapter {
	private GetHangyeWindow  context;
	private List<Hangye> list;
	
	public GetHangyeAdapter(GetHangyeWindow context, List<Hangye> list) {
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
		final Hangye dto = (Hangye) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.activity_get_hangye_list, null);
		if(gridLayout.findViewById(R.id.get_hangye_name)!=null){
			TextView id  = (TextView) gridLayout.findViewById(R.id.get_hangye_id);
			TextView name  = (TextView) gridLayout.findViewById(R.id.get_hangye_name);
			id.setText(dto.getId()+"");
			name.setText(dto.getHangyeName());
			
			BootstrapButton check =(BootstrapButton) gridLayout.findViewById(R.id.get_hangye_check);
			check.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 选中
					Intent i = new Intent(context,SignRegisterActivity.class);
					Bundle b = new Bundle();
					b.putString("type", "check_hangye");
					b.putString("id", dto.getId()+"");
					b.putString("hangyeName", dto.getHangyeName());
					i.putExtras(b);
					context.setResult(context.RESULT_OK, i);
					context.finish();
				}
			});
		}
		return gridLayout;
	}

}
