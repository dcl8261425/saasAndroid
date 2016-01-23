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
/**
 * 添加修改文本资源  弹出框
 * @author Administrator
 *
 */
public class TextResourceWindow extends Activity {
	
	private BootstrapButton enter;
	private BootstrapButton cencal;
	private BootstrapEditText name;
	private BootstrapEditText content;
	private BootstrapEditText idedit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_gailan_autoresoure_text_window);
		enter=(BootstrapButton) findViewById(R.id.weixin_gailan_autoresoure_text_content_enter);
		cencal=(BootstrapButton) findViewById(R.id.weixin_gailan_autoresoure_text_content_cancel);
		name=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_text_name);
		content=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_text_content);
		idedit=(BootstrapEditText) findViewById(R.id.weixin_gailan_autoresoure_text_id);
		Bundle bundle = getIntent().getExtras();
		Object idstr = bundle.get("id");
		Object namestr = bundle.get("name");
		Object contentstr =  bundle.get("content");
		if(idstr!=null&&!idstr.equals("")){
			name.setText((String)namestr);
			idedit.setText((String)idstr);
			content.setText((String)contentstr);
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LoadingDialog dialog2 = new LoadingDialog(
							TextResourceWindow.this, "正在获取数据");
					dialog2.show();
					AutoResendUpdateHandler handler = new AutoResendUpdateHandler(TextResourceWindow.this,WeiXinReSendDto.TEXT,dialog2);
					AutoResendUpdateThread thread = new AutoResendUpdateThread(TextResourceWindow.this , handler, WeiXinReSendDto.TEXT);
					thread.start();
				}
			});
		}else{
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LoadingDialog dialog2 = new LoadingDialog(
							TextResourceWindow.this, "正在获取数据");
					dialog2.show();
					AutoResendAddHandler handler = new AutoResendAddHandler(TextResourceWindow.this,WeiXinReSendDto.TEXT,dialog2);
					AutoResendAddThread thread = new AutoResendAddThread(TextResourceWindow.this , handler, WeiXinReSendDto.TEXT);
					thread.start();
				}
			});
		}
		
		cencal.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent( TextResourceWindow.this, HomeActivity.class);  
		        Bundle b = new Bundle();
		        b.putString("type", "cancel");
		        i.putExtras(b);
		        TextResourceWindow.this.setResult( TextResourceWindow.this.RESULT_OK, i);  
		        TextResourceWindow.this.finish();  
				
			}
		});
	}
}
