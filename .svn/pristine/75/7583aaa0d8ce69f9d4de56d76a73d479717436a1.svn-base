package com.herotculb.qunhaichat.homeactiviti.goods.query;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.homeactiviti.util.window.goodselect.ErWeiMaQueryGoodsWindow;
import com.herotculb.qunhaichat.homeactiviti.weixin.goods.WeiXinGoodsAddWindow;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;



public class GoodsQuery {
	public HomeActivity home;
	public LinearLayout linearLayout;
	int layout;
	public GoodsQuery(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		//仓库信息
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.good_query_layout, null)
				.findViewById(R.id.good_query_layout_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		XListView view=(XListView) home.findViewById(R.id.queryGoods_list);
		layout = R.layout.good_query_list_item;
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				BootstrapEditText pinyin=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_pinyin);
				BootstrapEditText nowpage=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(GoodsQuery.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) GoodsQuery.this.home.findViewById(R.id.queryGoods_list);
				QueryGoodsHandler handler=new QueryGoodsHandler(GoodsQuery.this.home,dialog,view,layout);
				QueryGoodsThread thread=new QueryGoodsThread(GoodsQuery.this.home,handler,namestr,pinyin.getText().toString(),String.valueOf(nowpagenum),"10");
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO Auto-generated method stub
				BootstrapEditText pinyin=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_pinyin);
				BootstrapEditText nowpage=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				Log.e("-------------------", nowpagenum+"");
				nowpagenum=nowpagenum+1;
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(GoodsQuery.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) GoodsQuery.this.home.findViewById(R.id.queryGoods_list);
				QueryGoodsHandler handler=new QueryGoodsHandler(GoodsQuery.this.home,dialog,view,layout);
				QueryGoodsThread thread=new QueryGoodsThread(GoodsQuery.this.home,handler,namestr,pinyin.getText().toString(),String.valueOf(nowpagenum),"10");
				thread.start();
			}
		});
		BootstrapButton erweima=(BootstrapButton)GoodsQuery.this.home.findViewById(R.id.query_goods_query_erweima);
		erweima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(GoodsQuery.this.home, ErWeiMaQueryGoodsWindow.class);  
				Bundle b = new Bundle();  
				b.putString("class", "com.herotculb.qunhaichat.HomeActivity");
				b.putString("type", "goodsquery");
                i.putExtras(b);  
                GoodsQuery.this.home.startActivityForResult(i, 0);  
                GoodsQuery.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		BootstrapButton queryEnter=(BootstrapButton)GoodsQuery.this.home.findViewById(R.id.query_goods_query_enter);
		queryEnter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BootstrapEditText nowpage=(BootstrapEditText)GoodsQuery.this.home.findViewById(R.id.query_goods_nowpage);
				BootstrapEditText pinyin=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_pinyin);
				BootstrapEditText nameedit=(BootstrapEditText) GoodsQuery.this.home.findViewById(R.id.query_goods_name);
				String namestr=nameedit.getText().toString();
				nowpage.setText("1");
				LoadingDialog dialog = new LoadingDialog(GoodsQuery.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) GoodsQuery.this.home.findViewById(R.id.queryGoods_list);
				QueryGoodsHandler handler=new QueryGoodsHandler(GoodsQuery.this.home,dialog,view,layout);
				QueryGoodsThread thread=new QueryGoodsThread(GoodsQuery.this.home,handler,namestr,pinyin.getText().toString(),"1","10");
				thread.start();
			}
		});
	}
		
}
