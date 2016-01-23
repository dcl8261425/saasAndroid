package com.herotculb.qunhaichat.weixin.gailan.wenzhang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.gailan.wenzhang.web.WenZhangWebHandler;
import com.herotculb.qunhaichat.weixin.gailan.wenzhang.web.WenZhangWebThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WebActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("WebActivity---", "onCreate");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.weixin_gailan_wenzhang_web);
			Bundle bundle = getIntent().getExtras();
			String name = bundle.getString("name");
			String link = bundle.getString("link");
			boolean isTP = bundle.getBoolean("isTP");
			long id = bundle.getLong("id");
			long num = bundle.getLong("num");
			String date = bundle.getString("date");
			String html = bundle.getString("html");
			LinearLayout voteLayout= (LinearLayout)findViewById(R.id.weixin_gailan_wenzhang_web_vote_add_lin);
			ListView itemlist= (ListView)findViewById(R.id.weixin_gailan_wenzhang_web_vote_itemList);
			if(isTP){
				voteLayout.setVisibility(View.VISIBLE);
				LoadingDialog dialog2 = new LoadingDialog(
						WebActivity.this, "正在获取数据");
				dialog2.show();
				WenZhangWebHandler handler=new WenZhangWebHandler(WebActivity.this, dialog2, itemlist);
				WenZhangWebThread thread=new WenZhangWebThread(WebActivity.this, id, handler);
				thread.start();
			}else{
				
			}
			WebView web= (WebView)findViewById(R.id.weixin_gailan_wenzhang_web_main);
			BootstrapButton back= (BootstrapButton)findViewById(R.id.weixin_gailan_wenzhang_web_back);
			web.loadUrl(link);
		
	        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
			web.setWebViewClient(new WebViewClient(){
	           @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
	             view.loadUrl(url);
	            return true;
	        }
	       });
			back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(WebActivity.this,
							HomeActivity.class);
					Bundle b = new Bundle();
					b.putString("type", "cancel");
					i.putExtras(b);
					WebActivity.this.setResult(RESULT_OK, i);
					WebActivity.this.finish();
				}
			});
	}
	//弹出框返回的内容在这里接受
		 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
		        super.onActivityResult(requestCode, resultCode, data); 
		        //取出字符串  
		        Log.e("web---", "WebActivity");
		        if(data==null){
		        	return ;
		        }
		        Bundle bundle = data.getExtras();	        
		        if(bundle==null){
		        	return ;
		        }
		        String type=(String) bundle.get("type");
		        TextView startDate1 = (TextView)findViewById(R.id.game_dazhuanpan_start_date1);
		        TextView startDate2 = (TextView)findViewById(R.id.game_dazhuanpan_start_date1);
		        TextView startDate3 = (TextView)findViewById(R.id.game_dazhuanpan_start_date1);
		        Log.e("web---", "startDate1"+startDate1);
		        String startDate;
		        String endDate;
		        String birthday;
		        if(type.equals("startDate")){
		        	startDate = bundle.getString("value");
		        }
		        if(type.equals("endDate")){
		        	endDate = bundle.getString("value");
		        }
		        if(type.equals("birthdayDate")){
		        	birthday = bundle.getString("value");
		        }
		       
		     
		 }
}
