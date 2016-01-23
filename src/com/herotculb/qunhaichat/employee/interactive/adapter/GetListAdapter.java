package com.herotculb.qunhaichat.employee.interactive.adapter;

import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ImageList;
import com.herotculb.qunhaichat.dto.KongJianDto;

public class GetListAdapter extends BaseAdapter {
	private Activity  context;
	private List<ImageList> list;
	
	public GetListAdapter(Activity context, List<ImageList> list) {
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
		final ImageList dto = (ImageList) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.employee_get_list, null);
		if(gridLayout.findViewById(R.id.get_list_url)!=null){
			ImageView url = (ImageView)gridLayout.findViewById(R.id.get_list_url);
			TextView fileName  = (TextView) gridLayout.findViewById(R.id.get_list_filename);
			TextView fileSize  = (TextView) gridLayout.findViewById(R.id.get_list_filesize);
			Uri link = Uri.parse(dto.getLinkaddress());
			url.setImageURI(link);
			fileName.setText(dto.getFileName());
			fileSize.setText(dto.getFilesize()+"");
		}
		return gridLayout;
	}

}
