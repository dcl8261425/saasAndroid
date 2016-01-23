package com.herotculb.qunhaichat.weixin.gailan.window;

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
import com.herotculb.qunhaichat.dto.WeiXinReSendDto;
import com.herotculb.qunhaichat.weixin.gailan.huifuziyuanku.AutoResendAddHandler;
import com.herotculb.qunhaichat.weixin.gailan.huifuziyuanku.AutoResendAddThread;
import com.herotculb.qunhaichat.weixin.gailan.huifuziyuanku.AutoResendUpdateHandler;
import com.herotculb.qunhaichat.weixin.gailan.huifuziyuanku.AutoResendUpdateThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class ImageTextResourceWindow extends Activity {
	private BootstrapButton enter;
	private BootstrapButton cencal;
	private BootstrapEditText name;
	private BootstrapEditText title;
	private BootstrapEditText idedit;
	private BootstrapEditText markr;
	private BootstrapEditText imageLink;
	private BootstrapEditText link;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_gailan_autoresoure_image_text_window);
		enter=(BootstrapButton) findViewById(R.id.weixin_gailan_autoresoure_imagetext_content_enter);
		cencal=(BootstrapButton) findViewById(R.id.weixin_gailan_autoresoure_imagetext_content_cancel);
		name=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_imagetext_name);
		title=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_imagetext_title);
		idedit=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_imagetext_id);
		markr=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_imagetext_marks);
		imageLink=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_imagetext_imageLink);
		link=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_imagetext_link);
		Bundle bundle = getIntent().getExtras();
		Object idstr = bundle.get("id");
		Object namestr = bundle.get("name");
		Object contentstr =  bundle.get("description");
		Object titlestr = bundle.get("title");
		Object picUrl = bundle.get("picUrl");
		Object url =  bundle.get("url");
		if(idstr!=null&&!idstr.equals("")){
			name.setText((String)namestr);
			idedit.setText((String)idstr);
			markr.setText((String)contentstr);
			title.setText((String)titlestr);
			markr.setText((String)contentstr);
			imageLink.setText((String)picUrl);
			link.setText((String)url);
enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LoadingDialog dialog2 = new LoadingDialog(
							ImageTextResourceWindow.this, "正在获取数据");
					dialog2.show();
					AutoResendUpdateHandler handler = new AutoResendUpdateHandler(ImageTextResourceWindow.this,WeiXinReSendDto.IMAGE_TEXT,dialog2);
					AutoResendUpdateThread thread = new AutoResendUpdateThread(ImageTextResourceWindow.this , handler, WeiXinReSendDto.IMAGE_TEXT);
					thread.start();
				}
			});
		}else{
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LoadingDialog dialog2 = new LoadingDialog(
							ImageTextResourceWindow.this, "正在获取数据");
					dialog2.show();
					AutoResendAddHandler handler = new AutoResendAddHandler(ImageTextResourceWindow.this,WeiXinReSendDto.IMAGE_TEXT,dialog2);
					AutoResendAddThread thread = new AutoResendAddThread(ImageTextResourceWindow.this , handler, WeiXinReSendDto.IMAGE_TEXT);
					thread.start();
				}
			});
		}
	
		cencal.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent( ImageTextResourceWindow.this, HomeActivity.class);  
		        Bundle b = new Bundle();
		        b.putString("type", "cancel");
		        i.putExtras(b);
		        ImageTextResourceWindow.this.setResult( ImageTextResourceWindow.this.RESULT_OK, i);  
		        ImageTextResourceWindow.this.finish();  			
			}
		});
	}
}
