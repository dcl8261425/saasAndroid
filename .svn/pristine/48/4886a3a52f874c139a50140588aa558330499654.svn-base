package com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.window;

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
import com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.handler.HuoDongHandler;
import com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.thread.HuodongThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class HuoDongWindow extends Activity {
	BootstrapEditText numEdit;
	BootstrapButton enter;
	BootstrapButton close;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_duihuan_layout_huodong);
		numEdit=(BootstrapEditText) findViewById(R.id.weixin_duihuan_layout_huodong_num);
		enter=(BootstrapButton) findViewById(R.id.weixin_duihuan_layout_huodong_enter);
		close=(BootstrapButton) findViewById(R.id.weixin_duihuan_layout_huodong_close);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String num=numEdit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(HuoDongWindow.this, "正在获取数据");
				dialog.show();
				HuoDongHandler jifen=new HuoDongHandler(dialog, HuoDongWindow.this);
				HuodongThread thread=new HuodongThread(HuoDongWindow.this, jifen, num);
				thread.start();
			}
		});
close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent( HuoDongWindow.this, HomeActivity.class);  
		        Bundle b = new Bundle();
		        b.putString("type", "cancel");
		        i.putExtras(b);
		        HuoDongWindow.this.setResult( HuoDongWindow.this.RESULT_OK, i);  
		        HuoDongWindow.this.finish();  	
			}
		});
	}
	
}
