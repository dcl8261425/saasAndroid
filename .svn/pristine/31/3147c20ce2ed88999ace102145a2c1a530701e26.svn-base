package com.herotculb.qunhaichat.homeactiviti.weixin.order;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.weixin.order.WeixinGetOrderHandler;
import com.herotculb.qunhaichat.weixin.order.WeixinGetOrderThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class OrderManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public OrderManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		//微信订单管理
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.weixin_order_layout, null).findViewById(
				R.id.weixin_order_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapButton weiSong = (BootstrapButton) linearLayout
				.findViewById(R.id.weixin_order_wei_song);
		BootstrapButton song = (BootstrapButton) linearLayout
				.findViewById(R.id.weixin_order_song);
		weiSong.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 查询未送货订单
				BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
				nowpage.setText("1");
				LoadingDialog dialog = new LoadingDialog(OrderManager.this.home,
						"正在获取数据");
				dialog.show();
				TableLayout layout = (TableLayout) OrderManager.this.home
						.findViewById(R.id.weixin_get_order);
				layout.setVisibility(View.VISIBLE);
				XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
				view.setPullLoadEnable(true);
				view.setXListViewListener(new IXListViewListener() {
					
					@Override
					public void onRefresh() {
						// TODO 刷新
						BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
						BootstrapEditText nameedit=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_name);
						String namestr=nameedit.getText().toString();
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						if(nowpagenum<=1){
							nowpagenum=1;
						}else{
							nowpagenum=nowpagenum-1;
						}
						nowpage.setText(String.valueOf(nowpagenum));
						LoadingDialog dialog = new LoadingDialog(OrderManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
						WeixinGetOrderHandler handler = 
								new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "false");
						WeixinGetOrderThread thread = 
								new WeixinGetOrderThread(OrderManager.this.home, "false", String.valueOf(nowpagenum),
										"30", namestr, handler);
						thread.start();
					}
					
					@Override
					public void onLoadMore() {
						// TODO 加载更多
						BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
						BootstrapEditText nameedit=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_name);
						String namestr=nameedit.getText().toString();
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						nowpage.setText(String.valueOf(nowpagenum + 1));
						LoadingDialog dialog = new LoadingDialog(OrderManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
						WeixinGetOrderHandler handler = 
								new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "false");
						WeixinGetOrderThread thread = 
								new WeixinGetOrderThread(OrderManager.this.home, "false", String.valueOf(nowpagenum+1),
										"30", namestr, handler);
						thread.start();
					}
				});
				WeixinGetOrderHandler handler = 
						new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "false");
				WeixinGetOrderThread thread = 
						new WeixinGetOrderThread(OrderManager.this.home, "false", "1",
								"30", "", handler);
				thread.start();
				BootstrapButton query=(BootstrapButton) OrderManager.this.home.findViewById(R.id.weixin_order_name_query);
				query.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO 按订单编号查询
						BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
						nowpage.setText("1");
						BootstrapEditText nameedit=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_name);
						String namestr=nameedit.getText().toString();
						LoadingDialog dialog = new LoadingDialog(OrderManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
						WeixinGetOrderHandler handler = 
								new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "false");
						WeixinGetOrderThread thread = 
								new WeixinGetOrderThread(OrderManager.this.home, "false", "1",
										"30", namestr, handler);
						thread.start();
					}
				});
			}
		});
		song.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 查询已送货订单
				BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
				nowpage.setText("1");
				LoadingDialog dialog = new LoadingDialog(OrderManager.this.home,
						"正在获取数据");
				dialog.show();
				TableLayout layout = (TableLayout) OrderManager.this.home
						.findViewById(R.id.weixin_get_order);
				layout.setVisibility(View.VISIBLE);
				XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
				view.setPullLoadEnable(true);
				view.setXListViewListener(new IXListViewListener() {
					
					@Override
					public void onRefresh() {
						// TODO 刷新
						BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
						BootstrapEditText nameedit=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_name);
						String namestr=nameedit.getText().toString();
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						if(nowpagenum<=1){
							nowpagenum=1;
						}else{
							nowpagenum=nowpagenum-1;
						}
						nowpage.setText(String.valueOf(nowpagenum));
						LoadingDialog dialog = new LoadingDialog(OrderManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
						WeixinGetOrderHandler handler = 
								new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "true");
						WeixinGetOrderThread thread = 
								new WeixinGetOrderThread(OrderManager.this.home, "true", String.valueOf(nowpagenum),
										"30", namestr, handler);
						thread.start();
					}
					
					@Override
					public void onLoadMore() {
						// TODO 加载更多
						BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
						BootstrapEditText nameedit=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_name);
						String namestr=nameedit.getText().toString();
						int nowpagenum=Integer.parseInt(nowpage.getText().toString());
						nowpage.setText(String.valueOf(nowpagenum + 1));
						LoadingDialog dialog = new LoadingDialog(OrderManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
						WeixinGetOrderHandler handler = 
								new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "true");
						WeixinGetOrderThread thread = 
								new WeixinGetOrderThread(OrderManager.this.home, "true", String.valueOf(nowpagenum+1),
										"30", namestr, handler);
						thread.start();
					}
				});
				WeixinGetOrderHandler handler = 
						new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "true");
				WeixinGetOrderThread thread = 
						new WeixinGetOrderThread(OrderManager.this.home, "true", "1",
								"30", "", handler);
				thread.start();
				BootstrapButton query=(BootstrapButton) OrderManager.this.home.findViewById(R.id.weixin_order_name_query);
				query.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO 按订单编号查询
						BootstrapEditText nowpage=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_nowpage);
						nowpage.setText("1");
						BootstrapEditText nameedit=(BootstrapEditText) OrderManager.this.home.findViewById(R.id.weixin_order_name);
						String namestr=nameedit.getText().toString();
						LoadingDialog dialog = new LoadingDialog(OrderManager.this.home, "正在获取数据");
						dialog.show();
						XListView view=(XListView) OrderManager.this.home.findViewById(R.id.weixin_order_list);
						WeixinGetOrderHandler handler = 
								new WeixinGetOrderHandler(OrderManager.this.home, view, dialog, "true");
						WeixinGetOrderThread thread = 
								new WeixinGetOrderThread(OrderManager.this.home, "true", "1",
										"30", namestr, handler);
						thread.start();
					}
				});
			}
		});
		
	}
	
}
