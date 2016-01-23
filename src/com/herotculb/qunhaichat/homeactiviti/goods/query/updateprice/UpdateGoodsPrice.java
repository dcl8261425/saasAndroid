package com.herotculb.qunhaichat.homeactiviti.goods.query.updateprice;

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
import com.herotculb.qunhaichat.homeactiviti.weixin.goods.WeiXinGoodsAddHandler;
import com.herotculb.qunhaichat.homeactiviti.weixin.goods.WeiXinGoodsAddThread;
import com.herotculb.qunhaichat.homeactiviti.weixin.goods.WeiXinGoodsAddWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class UpdateGoodsPrice extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.good_update_goods_price);
		BootstrapButton cel=(BootstrapButton)findViewById(R.id.good_update_goods_price_cenl);
		BootstrapButton enter=(BootstrapButton)findViewById(R.id.good_update_goods_price_enter);
		TextView idtext=(TextView)findViewById(R.id.good_update_goods_price_good_id);
		TextView oldprice=(TextView)findViewById(R.id.good_update_goods_price_oldPrice);
		BootstrapEditText newprice=(BootstrapEditText)findViewById(R.id.good_update_goods_price_newPrice);
		Intent intent=getIntent();
		Bundle b=intent.getExtras();
		String id=b.getString("id");
		String price=b.getString("price");
		idtext.setText(id);
		oldprice.setText("当前价格:"+price);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView idtext=(TextView)findViewById(R.id.good_update_goods_price_good_id);
				TextView newPrice=(TextView)findViewById(R.id.good_update_goods_price_newPrice);
				LoadingDialog dialog = new LoadingDialog(UpdateGoodsPrice.this, "正在获取数据");
				dialog.show();
				UpdateGoodsPriceHandler handler=new UpdateGoodsPriceHandler(UpdateGoodsPrice.this, dialog);
				UpdateGoodsPriceThread thread=new UpdateGoodsPriceThread(UpdateGoodsPrice.this, handler,idtext.getText().toString(),newPrice.getText().toString());
				thread.start();
			}
		});
		cel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(UpdateGoodsPrice.this, HomeActivity.class);  
		        Bundle b2 = new Bundle();
		        b2.putString("type", "cancel");
		        i.putExtras(b2);
		        setResult(RESULT_OK, i);  
		        finish();
			}
		});
		
	}
}
