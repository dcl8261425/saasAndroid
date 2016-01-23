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
import com.herotculb.qunhaichat.weixin.operationvip.WeixinJianScoreUserHandler;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinJianScoreUserThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 会员操作-减积分
 * @author lkx
 *
 */
public class VipJianScoreWindowActivity extends Activity {
	private BootstrapButton enter;
	private BootstrapButton calcel;
	private BootstrapEditText id;
	private BootstrapEditText score;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_vip_jian_score_window);
		enter =(BootstrapButton)findViewById(R.id.weixin_jian_score_content_enter);
		calcel = (BootstrapButton)findViewById(R.id.weixin_jian_score_content_cancel);
		id = (BootstrapEditText)findViewById(R.id.weixin_jian_score_id);
		Bundle bundle = getIntent().getExtras();
		Object idstr = (Object) bundle.get("id");
		Object scorestr = (Object) bundle.get("score");
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
						VipJianScoreWindowActivity.this, "正在获取数据");
				dialog2.show();
				WeixinJianScoreUserHandler handler = new WeixinJianScoreUserHandler(VipJianScoreWindowActivity.this, dialog2);
				WeixinJianScoreUserThread thread = new WeixinJianScoreUserThread(VipJianScoreWindowActivity.this, handler);
				thread.start();
			}
		});
		calcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				VipJianScoreWindowActivity.this.finish();
			}
		});
	}
	
}
