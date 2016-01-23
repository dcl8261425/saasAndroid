package com.herotculb.qunhaichat.weixin.gailan.huifushezhi.item;

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
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.WeiXinReSendDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class AutoResourceItemAdapter extends BaseAdapter {
	private Activity  context;
	private List<WeiXinReSendDto> list;
	public AutoResourceItemAdapter(Activity context,List<WeiXinReSendDto> list){
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
		final WeiXinReSendDto dto=(WeiXinReSendDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.weixin_gailan_autoresoure_add_query_item_layout, null);
		TextView text=(TextView) gridLayout.findViewById(R.id.weixin_gailan_autoresoureitem_layout_name);
		BootstrapButton update=(BootstrapButton) gridLayout.findViewById(R.id.weixin_gailan_autoresoureitem_layout_enter);
		update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BootstrapEditText idedit=(BootstrapEditText) context.findViewById(R.id.weixin_gailan_autoresoure_item_query_id);
				LoadingDialog dialog = new LoadingDialog(context, "正在获取数据");
				dialog.show();
				AutoResendHandlerAddItem handler=new AutoResendHandlerAddItem(context,dialog);
				AutoResendThreadAddItem thread=new AutoResendThreadAddItem(context,Long.parseLong(idedit.getText().toString()),dto.getId(),dto.getName(), handler);
            	thread.start();
			}
		});
		text.setText(dto.getName());
		return gridLayout;
	}

}
