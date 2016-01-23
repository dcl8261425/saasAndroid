package com.herotculb.qunhaichat.weixin.operationvip.window;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinAddVipListHandler;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinAddVipListThread;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinUpdateVipListHandler;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinUpdateVipListThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 会员操作-创建新等级
 * @author lkx
 *
 */
public class VipCreateClassWindowActivity extends Activity {
	private BootstrapButton enter;
	private BootstrapButton calcel;
	private BootstrapEditText id;
	private BootstrapEditText name;
	private BootstrapEditText score;
	private BootstrapEditText marks;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_vip_create_class_window);
		enter =(BootstrapButton)findViewById(R.id.weixin_create_class_content_enter);
		calcel = (BootstrapButton)findViewById(R.id.weixin_create_class_content_cancel);
		id=(BootstrapEditText) findViewById(R.id.weixin_create_class_id);
		name=(BootstrapEditText) findViewById(R.id.weixin_create_class_name);
		score=(BootstrapEditText) findViewById(R.id.weixin_create_class_score);
		marks=(BootstrapEditText) findViewById(R.id.weixin_create_class_marks);
		Bundle bundle = getIntent().getExtras();
		Object idstr = (Object) bundle.get("id");
		Object namestr = (Object) bundle.get("name");
		Object scorestr = (Object) bundle.get("score");
		Object marksstr = (Object) bundle.get("marks");
		if(idstr!=null&&!idstr.equals("")){
			id.setText((String)idstr);
			name.setText((String)namestr);
			score.setText((String)scorestr);
			marks.setText((String)marksstr);
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Log.e("window--", "createclass");
					LoadingDialog dialog2 = new LoadingDialog(
							VipCreateClassWindowActivity.this, "正在获取数据");
					dialog2.show();
					WeixinUpdateVipListHandler handler = new WeixinUpdateVipListHandler(VipCreateClassWindowActivity.this, dialog2);
					WeixinUpdateVipListThread thread = new WeixinUpdateVipListThread(VipCreateClassWindowActivity.this, handler);
					thread.start();
				}
			});
		}else{
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					LoadingDialog dialog2 = new LoadingDialog(
							VipCreateClassWindowActivity.this, "正在获取数据");
					dialog2.show();
					WeixinAddVipListHandler handler = new WeixinAddVipListHandler(VipCreateClassWindowActivity.this, dialog2);
					WeixinAddVipListThread thread = new WeixinAddVipListThread(VipCreateClassWindowActivity.this, handler);
					thread.start();
				}
			});
		}
		
		calcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				VipCreateClassWindowActivity.this.finish();
			}
		});
	}
}
