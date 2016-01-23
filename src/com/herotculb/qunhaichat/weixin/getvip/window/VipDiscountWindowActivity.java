package com.herotculb.qunhaichat.weixin.getvip.window;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.getvip.WeixinGetVipXinxiHandler;
import com.herotculb.qunhaichat.weixin.getvip.WeixinGetVipXinxiThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 会员操作-优惠
 * @author lkx
 *
 */
public class VipDiscountWindowActivity extends Activity {
	private BootstrapButton enter;
//	private TextView name;
//	private TextView marks;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_vip_discount_window);
		enter =(BootstrapButton)findViewById(R.id.weixin_discount_content_enter);
//		name = (TextView)findViewById(R.id.weixin_class_name);
//		marks = (TextView)findViewById(R.id.weixin_class_marks);
		Bundle bundle = getIntent().getExtras();
		
		Object idStr = (Object) bundle.get("id");
		Object marksStr = (Object) bundle.get("marks");
		LoadingDialog dialog = new LoadingDialog(VipDiscountWindowActivity.this, "正在获取数据");
		dialog.show();
		WeixinGetVipXinxiHandler handler = 
				new WeixinGetVipXinxiHandler(VipDiscountWindowActivity.this, dialog);
		WeixinGetVipXinxiThread thread = 
				new WeixinGetVipXinxiThread(VipDiscountWindowActivity.this, idStr.toString(), handler);
		thread.start();
		enter.setVisibility(View.VISIBLE);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				VipDiscountWindowActivity.this.finish();
			}
		});
//		name.setText(nameStr.toString());
//		marks.setText(marksStr.toString());
	}
	
}
