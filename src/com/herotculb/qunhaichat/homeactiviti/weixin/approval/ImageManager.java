package com.herotculb.qunhaichat.homeactiviti.weixin.approval;

import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.homeactiviti.employee.GetHuDongKongJianManager;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.weixin.approval.GetImageHandler;
import com.herotculb.qunhaichat.weixin.approval.GetImageThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class ImageManager {
	public HomeActivity home;
	public LinearLayout linearLayout;

	public ImageManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;

		// 活动与游戏管理
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.weixin_image_layout, null)
				.findViewById(R.id.weixin_image_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		LoadingDialog dialog = new LoadingDialog(ImageManager.this.home,
				"正在获取数据");
		dialog.show();
		XListView view=(XListView) 
				ImageManager.this.home.findViewById(R.id.weixin_image_list);
		view.setPullLoadEnable(true);
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) 
						ImageManager.this.home.findViewById(R.id.weixin_image_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(ImageManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) 
						ImageManager.this.home.findViewById(R.id.weixin_image_list);
				GetImageHandler handler = new GetImageHandler(ImageManager.this.home, view, dialog);
				GetImageThread thread = new GetImageThread(ImageManager.this.home,
						String.valueOf(nowpagenum), "10", null, handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) 
						ImageManager.this.home.findViewById(R.id.weixin_image_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog = new LoadingDialog(ImageManager.this.home, "正在获取数据");
				dialog.show();
				XListView view=(XListView) 
						ImageManager.this.home.findViewById(R.id.weixin_image_list);
				GetImageHandler handler = new GetImageHandler(ImageManager.this.home, view, dialog);
				GetImageThread thread = new GetImageThread(ImageManager.this.home,
						String.valueOf(nowpagenum+1), "10", null, handler);
				thread.start();
			}
		});
		GetImageHandler handler = new GetImageHandler(ImageManager.this.home, view, dialog);
		GetImageThread thread = new GetImageThread(ImageManager.this.home,
				"1", "10", null, handler);
		thread.start();
	}
	
}
