package com.herotculb.qunhaichat.weixin.operationvip.window;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinAddDuiHuanListHandler;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinAddDuiHuanListThread;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinUpdateDuiHuanHandler;
import com.herotculb.qunhaichat.weixin.operationvip.WeixinUpdateDuiHuanThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 会员操作-创建新兑换物
 * @author lkx
 *
 */
public class VipCreateDuiHuanWindowActivity extends Activity {
	private BootstrapButton enter;
	private BootstrapButton calcel;
	private BootstrapEditText id;
	private BootstrapEditText name;
	private BootstrapEditText image;
	private BootstrapEditText score;
	private BootstrapEditText marks;
	private BootstrapEditText num;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_vip_create_duihuan_window);
		enter =(BootstrapButton)findViewById(R.id.weixin_create_duihuan_content_enter);
		calcel = (BootstrapButton)findViewById(R.id.weixin_create_duihuan_content_cancel);
		id=(BootstrapEditText) findViewById(R.id.weixin_create_duihuan_id);
		name=(BootstrapEditText) findViewById(R.id.weixin_create_duihuan_name);
		image=(BootstrapEditText) findViewById(R.id.weixin_create_duihuan_image);
		score=(BootstrapEditText) findViewById(R.id.weixin_create_duihuan_score);
		marks = (BootstrapEditText) findViewById(R.id.weixin_create_duihuan_marks);
		num = (BootstrapEditText) findViewById(R.id.weixin_create_duihuan_num);
		Bundle bundle = getIntent().getExtras();
		Object idstr = (Object) bundle.get("id");
		Object namestr = (Object) bundle.get("name");
		Object imagestr = (Object) bundle.get("image");
		Object scorestr = (Object) bundle.get("score");
		Object marksstr = (Object) bundle.get("content");
		Object numstr = (Object) bundle.get("num");
		if(idstr!=null&&!idstr.equals("")){
			id.setText((String)idstr);
			name.setText((String)namestr);
			image.setText((String)imagestr);
			score.setText((String)scorestr);
			marks.setText((String)marksstr);
			num.setText((String)numstr);
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					LoadingDialog dialog2 = new LoadingDialog(
							VipCreateDuiHuanWindowActivity.this, "正在获取数据");
					dialog2.show();
					WeixinUpdateDuiHuanHandler handler = 
							new WeixinUpdateDuiHuanHandler(VipCreateDuiHuanWindowActivity.this, dialog2);
					WeixinUpdateDuiHuanThread thread = 
							new WeixinUpdateDuiHuanThread(VipCreateDuiHuanWindowActivity.this, handler);
					thread.start();
				}
			});
		}else{
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					LoadingDialog dialog2 = new LoadingDialog(
							VipCreateDuiHuanWindowActivity.this, "正在获取数据");
					dialog2.show();
					WeixinAddDuiHuanListHandler handler = 
							new WeixinAddDuiHuanListHandler(VipCreateDuiHuanWindowActivity.this, dialog2);
					WeixinAddDuiHuanListThread thread = 
							new WeixinAddDuiHuanListThread(VipCreateDuiHuanWindowActivity.this, handler);
					thread.start();
				}
			});
		}
		
		calcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				VipCreateDuiHuanWindowActivity.this.finish();
			}
		});
	}
}
