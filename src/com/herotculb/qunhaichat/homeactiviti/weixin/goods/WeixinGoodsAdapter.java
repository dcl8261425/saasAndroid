package com.herotculb.qunhaichat.homeactiviti.weixin.goods;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.WeiXinGoodsDto;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGoodsAdapter extends BaseAdapter{
	private Activity  context;
	private List<WeiXinGoodsDto> list;
	private String b;
	public WeixinGoodsAdapter(Activity context,List<WeiXinGoodsDto> list,String b){
		this.context=context;
		this.list=list;
		this.b=b;
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
		final WeiXinGoodsDto dto=(WeiXinGoodsDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.weixin_goods_item_layout, null);
		TextView name=(TextView) gridLayout.findViewById(R.id.weixin_goods_item_main_name);
		TextView price=(TextView) gridLayout.findViewById(R.id.weixin_goods_item_main_price);
		TextView inprice=(TextView) gridLayout.findViewById(R.id.weixin_goods_item_main_inprice);
		TextView score=(TextView) gridLayout.findViewById(R.id.weixin_goods_item_main_score);
		TextView model=(TextView) gridLayout.findViewById(R.id.weixin_goods_item_main_model);
		TextView type=(TextView) gridLayout.findViewById(R.id.weixin_goods_item_main_type);
		BootstrapButton enter=(BootstrapButton) gridLayout.findViewById(R.id.weixin_goods_item_main_enter);
		name.setText("名字："+dto.getGoodsName());
		price.setText("售价："+dto.getPrice()+"");
		inprice.setText("进价："+dto.getInPrice()+"");
		score.setText("积分："+dto.getScore()+"");
		model.setText("型号："+dto.getGoodsModel());
		type.setText("类别："+dto.getGoodsType());
		if(Boolean.parseBoolean(b)){
			Log.e("上下架", "下架");
			enter.setText("下架");
		}else{
			Log.e("上下架", "上架");
			enter.setText("上架");
		}
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(dto.isUseShow()){
					//下架
					LoadingDialog dialog = new LoadingDialog(context, "正在获取数据");
					dialog.show();
					XListView view=(XListView) context.findViewById(R.id.weixin_goods_list);
					WeiXinGoodsUpDownHandler handler=new WeiXinGoodsUpDownHandler(context, dialog, view, "true");
					WeiXinGoodsUpDownThread thread=new WeiXinGoodsUpDownThread(context, handler, String.valueOf(dto.getId()), "true");
					thread.start();
				}else{
					//上架
					LoadingDialog dialog = new LoadingDialog(context, "正在获取数据");
					dialog.show();
					XListView view=(XListView) context.findViewById(R.id.weixin_goods_list);
					WeiXinGoodsUpDownHandler handler=new WeiXinGoodsUpDownHandler(context, dialog, view, "false");
					WeiXinGoodsUpDownThread thread=new WeiXinGoodsUpDownThread(context, handler, String.valueOf(dto.getId()), "false");
					thread.start();
				}
			}
		});
		return gridLayout;
	}

}
