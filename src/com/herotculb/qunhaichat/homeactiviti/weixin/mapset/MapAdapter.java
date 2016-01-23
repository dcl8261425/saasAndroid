package com.herotculb.qunhaichat.homeactiviti.weixin.mapset;

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
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyAddressDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MapAdapter  extends BaseAdapter{
	private Activity  context;
	private List<ConpanyAddressDto> list;
	public MapAdapter(Activity context,List<ConpanyAddressDto> list){
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
		final ConpanyAddressDto dto=(ConpanyAddressDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		LinearLayout gridLayout = (LinearLayout) inflater.inflate(
				R.layout.weixin_mapset_all_layout_item, null);
		BootstrapButton button=(BootstrapButton) gridLayout.findViewById(R.id.mapItem_button);
		BootstrapButton button2=(BootstrapButton) gridLayout.findViewById(R.id.mapItem_delete);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("e", dto.getMap_x());
				Intent i = new Intent(context, ShowMapActivity.class);  
				Bundle b = new Bundle();  
				b.putString("x", dto.getMap_x());
				b.putString("y", dto.getMap_y());
                i.putExtras(b);  
                context.startActivityForResult(i, 0);  
                context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LoadingDialog dialog = new LoadingDialog(context, "正在获取数据");
				dialog.show();
				MapSetDeleteHandler handler=new MapSetDeleteHandler(context, dialog);
				MapSetDeleteTread tread=new MapSetDeleteTread(context, handler,String.valueOf(dto.getId()));
				tread.start();
			}
		});
		return gridLayout;
	}

}
