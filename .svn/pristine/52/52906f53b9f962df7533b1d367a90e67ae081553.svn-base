package com.herotculb.qunhaichat.homeactiviti.goods.query.chart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.EditTextWithDate;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class ChartGoods extends Activity {
	private String id;
	private JavaScriptMake js;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.good_chart);
		WebView webview = (WebView) findViewById(R.id.goodChart);
		webview.getSettings().setDefaultTextEncodingName("UTF-8");
		// 开启JavaScript支持
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setCacheMode(0);
		js = new JavaScriptMake(webview, this);
		webview.addJavascriptInterface(new JavaScriptMake(webview, this),"jschart");
		String url = "file:///android_asset/html/goodschart/chart.html";
		webview.loadUrl(url);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		id = b.getString("id");
		BootstrapButton xiaoshou = (BootstrapButton) findViewById(R.id.good_chart_xiaoshou);
		BootstrapButton jinhuo = (BootstrapButton) findViewById(R.id.good_chart_jinhuo);
		BootstrapButton jiage = (BootstrapButton) findViewById(R.id.good_chart_jiage);
		BootstrapButton kucun = (BootstrapButton) findViewById(R.id.good_chart_kucun);
		BootstrapButton close = (BootstrapButton) findViewById(R.id.good_chart_close);
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChartGoods.this, HomeActivity.class);  
		        Bundle b2 = new Bundle();
		        b2.putString("type", "cancel");
		        i.putExtras(b2);
		        setResult(RESULT_OK, i);  
		        finish();
			}
		});
		xiaoshou.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditTextWithDate satrtDate = (EditTextWithDate) findViewById(R.id.good_chart_startDate);
				EditTextWithDate endDate = (EditTextWithDate) findViewById(R.id.good_chart_endDate);
				LoadingDialog dialog = new LoadingDialog(ChartGoods.this,
						"正在获取数据");
				dialog.show();
				ChartGoodsHandler handler = new ChartGoodsHandler(
						ChartGoods.this, dialog, ChartGoods.this.js,
						ChartGoodsThread.TYPE_SALER);
				ChartGoodsThread thread = new ChartGoodsThread(ChartGoods.this,
						handler, ChartGoodsThread.TYPE_SALER,
						ChartGoods.this.id, satrtDate.getText().toString(), endDate.getText().toString());
				thread.start();
			}
		});
		jinhuo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditTextWithDate satrtDate = (EditTextWithDate) findViewById(R.id.good_chart_startDate);
				EditTextWithDate endDate = (EditTextWithDate) findViewById(R.id.good_chart_endDate);
				LoadingDialog dialog = new LoadingDialog(ChartGoods.this,
						"正在获取数据");
				dialog.show();
				ChartGoodsHandler handler = new ChartGoodsHandler(
						ChartGoods.this, dialog, ChartGoods.this.js,
						ChartGoodsThread.TYPE_INGOOD);
				ChartGoodsThread thread = new ChartGoodsThread(ChartGoods.this,
						handler, ChartGoodsThread.TYPE_INGOOD,
						ChartGoods.this.id, satrtDate.getText().toString(), endDate.getText().toString());
				thread.start();
			}
		});
		jiage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditTextWithDate satrtDate = (EditTextWithDate) findViewById(R.id.good_chart_startDate);
				EditTextWithDate endDate = (EditTextWithDate) findViewById(R.id.good_chart_endDate);
				LoadingDialog dialog = new LoadingDialog(ChartGoods.this,
						"正在获取数据");
				dialog.show();
				ChartGoodsHandler handler = new ChartGoodsHandler(
						ChartGoods.this, dialog, ChartGoods.this.js,
						ChartGoodsThread.TYPE_PRICE);
				ChartGoodsThread thread = new ChartGoodsThread(ChartGoods.this,
						handler, ChartGoodsThread.TYPE_PRICE,
						ChartGoods.this.id,  satrtDate.getText().toString(), endDate.getText().toString());
				thread.start();
			}
		});
		kucun.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditTextWithDate satrtDate = (EditTextWithDate) findViewById(R.id.good_chart_startDate);
				EditTextWithDate endDate = (EditTextWithDate) findViewById(R.id.good_chart_endDate);
				LoadingDialog dialog = new LoadingDialog(ChartGoods.this,
						"正在获取数据");
				dialog.show();
				ChartGoodsHandler handler = new ChartGoodsHandler(
						ChartGoods.this, dialog, ChartGoods.this.js,
						ChartGoodsThread.TYPE_NUM);
				ChartGoodsThread thread = new ChartGoodsThread(ChartGoods.this,
						handler, ChartGoodsThread.TYPE_NUM,
						ChartGoods.this.id,  satrtDate.getText().toString(), endDate.getText().toString());
				thread.start();
			}
		});

	}
	
}
