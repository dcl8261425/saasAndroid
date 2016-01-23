package com.herotculb.qunhaichat.weixin.approval.adapter;

import java.util.List;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.VipImageMessageDto;
/**
 * 奖品库设置 Adapter
 * @author lkx
 *
 */
public class GetImageAdapter extends BaseAdapter {
	private HomeActivity  context;
	private List<VipImageMessageDto> list;
	
	public GetImageAdapter(HomeActivity context, List<VipImageMessageDto> list) {
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
		final VipImageMessageDto dto = (VipImageMessageDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.weixin_image_list, null);
		TextView text  = (TextView) gridLayout.findViewById(R.id.weixin_image_title);
		ImageView text1 = (ImageView) gridLayout.findViewById(R.id.weixin_image_link);
		TextView message = (TextView) gridLayout.findViewById(R.id.weixin_image_message);
		BootstrapButton pass =(BootstrapButton) gridLayout.findViewById(R.id.weixin_image_pass);
		BootstrapButton nopass =(BootstrapButton) gridLayout.findViewById(R.id.weixin_image_nopass);
		text.setText("标题："+dto.getTitle());
		Uri uri = Uri.parse(dto.getImageLink());
		text1.setImageURI(uri);
		message.setText(""+dto.getMessage());
		pass.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 通过
				
			}
		});
		nopass.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 不通过
				
			}
		});
		return gridLayout;
	}

}
