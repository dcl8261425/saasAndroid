package com.herotculb.qunhaichat.homeactiviti.goods.query.goodinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.homeactiviti.goods.query.GoodsQuery;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GoodsInfo extends Activity{
	private String id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.good_info);
		BootstrapButton button=(BootstrapButton)findViewById(R.id.good_info_back);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(GoodsInfo.this, HomeActivity.class);  
		        Bundle b2 = new Bundle();
		        b2.putString("type", "cancel");
		        i.putExtras(b2);
		        setResult(RESULT_OK, i);  
		        finish();
			}
		});
		XListView view=(XListView)findViewById(R.id.good_info_list);
		view.setPullLoadEnable(true);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		id = b.getString("id");
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				BootstrapEditText nowpage=(BootstrapEditText) findViewById(R.id.good_info_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(GoodsInfo.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView)findViewById(R.id.good_info_list);
				GoodsInfoHandler handler=new GoodsInfoHandler(GoodsInfo.this,dialog,view);
				GoodsInfoThread thread=new GoodsInfoThread(GoodsInfo.this,handler,GoodsInfo.this.id,String.valueOf(nowpagenum),"10");
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO Auto-generated method stub
				BootstrapEditText nowpage=(BootstrapEditText) findViewById(R.id.good_info_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpagenum=nowpagenum+1;
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(GoodsInfo.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) findViewById(R.id.good_info_list);
				GoodsInfoHandler handler=new GoodsInfoHandler(GoodsInfo.this,dialog,view);
				GoodsInfoThread thread=new GoodsInfoThread(GoodsInfo.this,handler,GoodsInfo.this.id,String.valueOf(nowpagenum),"10");
				thread.start();
			}
		});
		LoadingDialog dialog = new LoadingDialog(GoodsInfo.this, "正在获取数据");
		dialog.show();
		GoodsInfoHandler handler=new GoodsInfoHandler(GoodsInfo.this,dialog,view);
		GoodsInfoThread thread=new GoodsInfoThread(GoodsInfo.this,handler,GoodsInfo.this.id,"1","10");
		thread.start();
		BootstrapEditText nowpage=(BootstrapEditText)findViewById(R.id.good_info_nowpage);
		nowpage.setText("1");
	}
}
