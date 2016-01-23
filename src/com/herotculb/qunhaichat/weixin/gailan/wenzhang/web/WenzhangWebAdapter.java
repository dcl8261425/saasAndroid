package com.herotculb.qunhaichat.weixin.gailan.wenzhang.web;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.VoteItemDTO;

public class WenzhangWebAdapter extends BaseAdapter {
	private Activity  context;
	private List<VoteItemDTO> list;
	public WenzhangWebAdapter(Activity context,List<VoteItemDTO> list){
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
		final VoteItemDTO dto=(VoteItemDTO) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.weixin_gailan_wenzhang_web_item, null);
		TextView text=(TextView) gridLayout.findViewById(R.id.weixin_gailan_wenzhang_web_item_name);
		TextView textnum=(TextView) gridLayout.findViewById(R.id.weixin_gailan_wenzhang_web_item_num);
		text.setText(dto.getName());
		textnum.setText(String.valueOf(dto.getNum()));
		return gridLayout;
	}

}
