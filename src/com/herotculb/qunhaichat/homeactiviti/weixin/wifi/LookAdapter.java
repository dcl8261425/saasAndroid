package com.herotculb.qunhaichat.homeactiviti.weixin.wifi;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.DeviceDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class LookAdapter extends BaseAdapter{
	private Activity  context;
	private List<DeviceDto> list;
	private String wifiid;
	public LookAdapter(Activity context,List<DeviceDto> list,String wifiid){
		this.context=context;
		this.list=list;
		this.wifiid=wifiid;
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
		final DeviceDto dto=(DeviceDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.weixin_wifi_look_layout_item, null);
		TextView name=(TextView)gridLayout.findViewById(R.id.weixin_wifi_look_layout_item_vipname);
		TextView max=(TextView)gridLayout.findViewById(R.id.weixin_wifi_look_layout_item_mac);
		BootstrapButton boot=(BootstrapButton)gridLayout.findViewById(R.id.weixin_wifi_look_layout_item_open);
		name.setText(dto.getLinkmainName());
		max.setText(dto.getMac());
		if(dto.isNoLogin()){
			boot.setText("开启");
		}else{
			
			boot.setText("关闭");
		}
		boot.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LoadingDialog dialog = new LoadingDialog(context,
						"正在获取数据");
				dialog.show();
				OpenDivceHandler handler=new OpenDivceHandler(context, dialog,wifiid);
				OpenDivceWifiThread thread=new OpenDivceWifiThread(context, handler, dto.getId()+"");
				thread.start();
			}
		});
		return gridLayout;
	}
	
}
