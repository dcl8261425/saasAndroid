package com.herotculb.qunhaichat.weixin.getvip.window;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinAddPriceUserHandler;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinAddPriceUserThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 会员操作
 * @author lkx
 *
 */
public class VipUpdateWindowActivity extends Activity {
	private BootstrapButton enter;
	private BootstrapButton calcel;
	private BootstrapEditText id;
	private BootstrapEditText money;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_vip_add_money_window);
		enter =(BootstrapButton)findViewById(R.id.weixin_add_money_content_enter);
		calcel = (BootstrapButton)findViewById(R.id.weixin_add_money_content_cancel);
		id = (BootstrapEditText)findViewById(R.id.weixin_add_money_id);
		money = (BootstrapEditText)findViewById(R.id.weixin_add_money_name);
		Bundle bundle = getIntent().getExtras();
		Object idstr = (Object) bundle.get("id");
		Object moneystr = (Object) bundle.get("money");
		enter.setVisibility(View.VISIBLE);
		calcel.setVisibility(View.VISIBLE);
		if(idstr!=null&&!idstr.equals("")){
			id.setText(idstr.toString());
		}
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				LoadingDialog dialog2 = new LoadingDialog(
						VipUpdateWindowActivity.this, "正在获取数据");
				dialog2.show();
				WeixinAddPriceUserHandler addPriceHandler = new WeixinAddPriceUserHandler(VipUpdateWindowActivity.this, dialog2);
				WeixinAddPriceUserThread addPriceThread = new WeixinAddPriceUserThread(VipUpdateWindowActivity.this, addPriceHandler);
				addPriceThread.start();
			}
		});
		calcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				VipUpdateWindowActivity.this.finish();
			}
		});
	}
	
}
