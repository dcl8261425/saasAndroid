package com.herotculb.qunhaichat.homeactiviti.goods.query.gooddata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.homeactiviti.goods.query.goodinfo.GoodsInfo;
import com.herotculb.qunhaichat.homeactiviti.goods.query.goodinfo.GoodsInfoHandler;
import com.herotculb.qunhaichat.homeactiviti.goods.query.goodinfo.GoodsInfoThread;
import com.herotculb.qunhaichat.homeactiviti.weixin.goods.WeiXinGoodsAddHandler;
import com.herotculb.qunhaichat.homeactiviti.weixin.goods.WeiXinGoodsAddThread;
import com.herotculb.qunhaichat.homeactiviti.weixin.goods.WeiXinGoodsAddWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GoodsData extends Activity{
	private String id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.good_data);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		id = b.getString("id");
		BootstrapButton button=(BootstrapButton)findViewById(R.id.good_Data_back);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(GoodsData.this, HomeActivity.class);  
		        Bundle b2 = new Bundle();
		        b2.putString("type", "cancel");
		        i.putExtras(b2);
		        setResult(RESULT_OK, i);  
		        finish();
			}
		});
		LoadingDialog dialog = new LoadingDialog(GoodsData.this, "正在获取数据");
		dialog.show();
		GoodsDataHandler handler=new GoodsDataHandler(GoodsData.this,dialog);
		GoodsDataThread thread=new GoodsDataThread(GoodsData.this,handler,id);
		thread.start();
	}
}
