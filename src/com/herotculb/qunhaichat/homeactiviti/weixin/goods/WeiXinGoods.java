package com.herotculb.qunhaichat.homeactiviti.weixin.goods;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeiXinGoods {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public WeiXinGoods(HomeActivity home,LinearLayout linearLayout){
		this.home=home;
		this.linearLayout=linearLayout;
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.weixin_goods_layout, null)
				.findViewById(R.id.weixin_goods_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapButton up=(BootstrapButton) home.findViewById(R.id.weixin_goods_up_list);
		BootstrapButton down=(BootstrapButton) home.findViewById(R.id.weixin_goods_down_list);
		BootstrapButton add=(BootstrapButton) home.findViewById(R.id.weixin_goods_add_list);
		
		ListView list=(ListView) home.findViewById(R.id.weixin_goods_list);
		up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BootstrapEditText isb=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_isb);
				isb.setText("true");
				BootstrapEditText nowpage=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_name);
				nameedit.setVisibility(View.VISIBLE);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum+1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(WeiXinGoods.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_list);
				WeiXinGoodsHandler handler=new WeiXinGoodsHandler(WeiXinGoods.this.home,dialog,view,"true");
				WeiXinGoodsThread thread=new WeiXinGoodsThread(WeiXinGoods.this.home,handler,"true",namestr,String.valueOf(nowpagenum),"10");
				thread.start();
			}
		});
		down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BootstrapEditText isb=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_isb);
				isb.setText("false");
				BootstrapEditText nowpage=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_name);
				nameedit.setVisibility(View.VISIBLE);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum+1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(WeiXinGoods.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_list);
				WeiXinGoodsHandler handler=new WeiXinGoodsHandler(WeiXinGoods.this.home,dialog,view,"false");
				WeiXinGoodsThread thread=new WeiXinGoodsThread(WeiXinGoods.this.home,handler,"false",namestr,String.valueOf(nowpagenum),"10");
				thread.start();
			}
		});
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(WeiXinGoods.this.home, WeiXinGoodsAddWindow.class);  
				Bundle b = new Bundle();  
				
                i.putExtras(b);  
                WeiXinGoods.this.home.startActivityForResult(i, 0);  
                WeiXinGoods.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		XListView view=(XListView) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_list);
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				BootstrapEditText isb=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_isb);
				BootstrapEditText nowpage=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(WeiXinGoods.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_list);
				WeiXinGoodsHandler handler=new WeiXinGoodsHandler(WeiXinGoods.this.home,dialog,view,"true");
				WeiXinGoodsThread thread=new WeiXinGoodsThread(WeiXinGoods.this.home,handler,isb.getText().toString(),namestr,String.valueOf(nowpagenum),"10");
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO Auto-generated method stub
				BootstrapEditText isb=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_isb);
				BootstrapEditText nowpage=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				Log.e("-------------------", nowpagenum+"");
				nowpagenum=nowpagenum+1;
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(WeiXinGoods.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) WeiXinGoods.this.home.findViewById(R.id.weixin_goods_list);
				WeiXinGoodsHandler handler=new WeiXinGoodsHandler(WeiXinGoods.this.home,dialog,view,"true");
				WeiXinGoodsThread thread=new WeiXinGoodsThread(WeiXinGoods.this.home,handler,isb.getText().toString(),namestr,String.valueOf(nowpagenum),"10");
				thread.start();
			}
		});
	}
}
