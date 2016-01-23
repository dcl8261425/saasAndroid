package com.herotculb.qunhaichat.homeactiviti.goods.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.goods.store.GoodsQueryStoreHouseHandler;
import com.herotculb.qunhaichat.goods.store.GoodsQueryStoreHouseThread;
import com.herotculb.qunhaichat.goods.store.window.GoodsAddStoreHouseWindow;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class StoreManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	int layout;
	
	public StoreManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//仓库信息
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.goods_store_house_layout, null)
				.findViewById(R.id.goods_store_house_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapEditText nowpage=(BootstrapEditText) StoreManager.this.home.findViewById(R.id.goods_store_house_nowpage);
		nowpage.setText("1");
		LoadingDialog dialog = new LoadingDialog(StoreManager.this.home, "正在获取数据");
		dialog.show();
		XListView view=(XListView) StoreManager.this.home.findViewById(R.id.goods_store_house_list);
		layout = R.layout.goods_store_house_list;
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) StoreManager.this.home.findViewById(R.id.goods_store_house_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) StoreManager.this.home.findViewById(R.id.goods_store_house_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(StoreManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) StoreManager.this.home.findViewById(R.id.goods_store_house_list);
				GoodsQueryStoreHouseHandler handler = 
						new GoodsQueryStoreHouseHandler(StoreManager.this.home, view, dialog,layout);
				GoodsQueryStoreHouseThread thread = 
						new GoodsQueryStoreHouseThread(StoreManager.this.home, String.valueOf(nowpagenum), "10", namestr, handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) StoreManager.this.home.findViewById(R.id.goods_store_house_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) StoreManager.this.home.findViewById(R.id.goods_store_house_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog = new LoadingDialog(StoreManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) StoreManager.this.home.findViewById(R.id.goods_store_house_list);
				GoodsQueryStoreHouseHandler handler = 
						new GoodsQueryStoreHouseHandler(StoreManager.this.home, view, dialog,layout);
				GoodsQueryStoreHouseThread thread = 
						new GoodsQueryStoreHouseThread(StoreManager.this.home, String.valueOf(nowpagenum+1), "10", namestr, handler);
				thread.start();
			}
		});
		GoodsQueryStoreHouseHandler handler = 
				new GoodsQueryStoreHouseHandler(StoreManager.this.home, view, dialog,layout);
		GoodsQueryStoreHouseThread thread = 
				new GoodsQueryStoreHouseThread(StoreManager.this.home, "1", "10", "", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) StoreManager.this.home.findViewById(R.id.goods_store_house_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按电话号查询
				BootstrapEditText nowpage=(BootstrapEditText) StoreManager.this.home.findViewById(R.id.goods_store_house_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) StoreManager.this.home.findViewById(R.id.goods_store_house_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(StoreManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) StoreManager.this.home.findViewById(R.id.goods_store_house_list);
				GoodsQueryStoreHouseHandler handler=new GoodsQueryStoreHouseHandler(StoreManager.this.home,view,dialog,layout);
				GoodsQueryStoreHouseThread thread=new GoodsQueryStoreHouseThread(StoreManager.this.home,"1","10",namestr,handler);
				thread.start();
			}
		});
		BootstrapButton enter=(BootstrapButton) StoreManager.this.home.findViewById(R.id.goods_create_store_house);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 创建新仓库
				Intent i = new Intent(StoreManager.this.home, GoodsAddStoreHouseWindow.class);  
				Bundle b = new Bundle();  
                i.putExtras(b);  
                StoreManager.this.home.startActivityForResult(i,0);
                StoreManager.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
	}
	
}
