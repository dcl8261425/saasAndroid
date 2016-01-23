package com.herotculb.qunhaichat.weixin.gailan.window;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.gailan.WeixinMenuManagerAddHandler;
import com.herotculb.qunhaichat.weixin.gailan.WeixinMenuManagerAddThread;
import com.herotculb.qunhaichat.weixin.gailan.WeixinMenuManagerEditHandler;
import com.herotculb.qunhaichat.weixin.gailan.WeixinMenuManagerEditThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GaiLanMenuUpdateWindowActivity extends Activity {
	private BootstrapButton enters;
	private BootstrapButton cancel;
	private BootstrapEditText name;
	private BootstrapEditText url;
	private BootstrapEditText key;
	private BootstrapEditText ids;
	private BootstrapEditText pid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.windowlayout_weixin_gailan_menu_update);

		enters = (BootstrapButton) findViewById(R.id.weixin_gailan_menu_update_enters);
		cancel = (BootstrapButton) findViewById(R.id.weixin_gailan_menu_update_cancel);
		name = (BootstrapEditText) findViewById(R.id.weixin_gailan_menu_update_name);
		url = (BootstrapEditText) findViewById(R.id.weixin_gailan_menu_update_url);
		key = (BootstrapEditText) findViewById(R.id.weixin_gailan_menu_update_key);
		ids = (BootstrapEditText) findViewById(R.id.weixin_gailan_menu_update_id);
		pid = (BootstrapEditText) findViewById(R.id.weixin_gailan_menu_update_pid);
		Bundle bundle = getIntent().getExtras();

		Object idstr = (Object) bundle.get("id");
		Object pidstr = (Object) bundle.get("pid");
		String namestr = (String) bundle.get("name");
		String keystr = (String) bundle.get("key");
		String urlstr = (String) bundle.get("url");
		Log.e("log-value", "0-"+namestr+" 1-"+urlstr+" 2-"+keystr+" 3-"+pidstr+" 4-"+idstr);
		if (urlstr == null || urlstr.equals("null")) {
			urlstr = "略";
		}
		if (keystr == null || keystr.equals("null")) {
			keystr = "略";
		}
		if (idstr == null) {
			idstr = "-1";
		}
		if (pidstr == null) {
			pidstr = "-1";
		}
		name.setText(namestr);
		ids.setText((String) idstr);
		pid.setText((String) pidstr);
		key.setText(keystr);
		url.setText(urlstr);
		// 添加与修改
		enters.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String namestr = name.getText().toString();
				String urlstr = url.getText().toString();
				String keystr = key.getText().toString();
				String pidstr = pid.getText().toString();
				String idstr = ids.getText().toString();
				if(namestr.equals("")){
					namestr="略";
				}
				if(urlstr.equals("")){
					urlstr="略";
				}
				if(keystr.equals("")){
					keystr="略";	
				}
				
				LoadingDialog dialog2 = new LoadingDialog(
						GaiLanMenuUpdateWindowActivity.this, "正在获取数据");
				dialog2.show();
				if(!pidstr.equals("-1")){
					WeixinMenuManagerAddHandler handler = new WeixinMenuManagerAddHandler(
							dialog2, GaiLanMenuUpdateWindowActivity.this);
					WeixinMenuManagerAddThread thread = new WeixinMenuManagerAddThread(
							GaiLanMenuUpdateWindowActivity.this, pidstr, namestr,
							urlstr, keystr, handler);
					thread.start();
				}else{
					WeixinMenuManagerEditHandler handler = new WeixinMenuManagerEditHandler(
							dialog2, GaiLanMenuUpdateWindowActivity.this);
					WeixinMenuManagerEditThread thread = new WeixinMenuManagerEditThread(
							GaiLanMenuUpdateWindowActivity.this, idstr, namestr,
							urlstr, keystr, handler);
					thread.start();
				}

			}
		});
		// 和前面一样，只是用到了返回式Activity的基本方法，虽然这里已经是个Dialog了，但却和普通Activity无异

		cancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(GaiLanMenuUpdateWindowActivity.this,
						HomeActivity.class);
				Bundle b = new Bundle();
				b.putString("type", "cancel");
				i.putExtras(b);
				GaiLanMenuUpdateWindowActivity.this.setResult(RESULT_OK, i);
				GaiLanMenuUpdateWindowActivity.this.finish();
			}
		});
	}
}
