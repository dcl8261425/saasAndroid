package com.herotculb.qunhaichat.homeactiviti.goods.query.goodinfo;

import java.util.Calendar;
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
import com.herotculb.qunhaichat.dto.GoodsLogDto;
import com.herotculb.qunhaichat.homeactiviti.goods.query.chart.ChartGoods;
import com.herotculb.qunhaichat.homeactiviti.goods.query.updateprice.UpdateGoodsPrice;
import com.herotculb.qunhaichat.util.DateUtil;

public class GoodsInfoAdapter extends BaseAdapter{
	private Activity  context;
	private List<GoodsLogDto> list;
	public GoodsInfoAdapter(Activity context,List<GoodsLogDto> list){
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
		final GoodsLogDto dto=(GoodsLogDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.good_info_item, null);
		TextView active=(TextView) gridLayout.findViewById(R.id.good_query_item_active);
		TextView content=(TextView) gridLayout.findViewById(R.id.good_query_item_content);
		TextView date=(TextView) gridLayout.findViewById(R.id.good_query_item_date);
		TextView man=(TextView) gridLayout.findViewById(R.id.good_query_item_man);
		active.setText("行为:"+(dto.getAction()==1?"添加货物":dto.getAction()==2?"减少货物":dto.getAction()==3?"修改价格":""));
		content.setText("内容:"+(dto.getAction()==1?"以"+dto.getGoodsinPrice()+"元,进货价添加了"+dto.getGoodsNum()+"个"+dto.getGoodsSourceName()+"厂家货物，存进了"+dto.getGoodsToStorehouseName()+"库房.":dto.getAction()==2?"以"+dto.getGoodsinPrice()+"元,销售价销售了"+dto.getSalesNum()+"个"+dto.getGoodsSourceName()+"厂家货物，从"+dto.getGoodsToStorehouseName()+"库房出货.":dto.getAction()==3?"修改价格为"+dto.getPrice()+"元":""));
	    Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(Long.parseLong(dto.getStartdate()));
	    c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		date.setText("时间:"+DateUtil.formatDateYYYY_MM_DD(c.getTime()));
		man.setText("创建人:"+dto.getCreateManName());
		return gridLayout;
	}

}
