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
import com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.handler.JifenHandler;
import com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.thread.jifenThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class JiFenWindow extends Activity {
	BootstrapEditText numEdit;
	BootstrapButton enter;
	BootstrapButton close;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_duihuan_layout_jifen);
		numEdit=(BootstrapEditText) findViewById(R.id.weixin_duihuan_layout_jifen_num);
		enter=(BootstrapButton) findViewById(R.id.weixin_duihuan_layout_jifen_enter);
		close=(BootstrapButton) findViewById(R.id.weixin_duihuan_layout_jifen_close);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String num=numEdit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(JiFenWindow.this, "正在获取数据");
				dialog.show();
				JifenHandler jifen=new JifenHandler(dialog, JiFenWindow.this);
				jifenThread thread=new jifenThread(JiFenWindow.this, jifen, num);
				thread.start();
			}
		});
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent( JiFenWindow.this, HomeActivity.class);  
		        Bundle b = new Bundle();
		        b.putString("type", "cancel");
		        i.putExtras(b);
		        JiFenWindow.this.setResult( JiFenWindow.this.RESULT_OK, i);  
		        JiFenWindow.this.finish();  	
			}
		});
	}
	
}
