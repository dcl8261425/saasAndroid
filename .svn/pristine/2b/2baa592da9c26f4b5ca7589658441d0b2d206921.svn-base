package com.herotculb.qunhaichat.weixin.operationgame.window;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.operationgame.item.AddGuaGuaKaHandlerItem;
import com.herotculb.qunhaichat.weixin.operationgame.item.AddGuaGuaKaThreadItem;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GameAddAwardsToGuaGuaKaQueryWindow extends Activity {
	private BootstrapEditText idedit;
	private ListView list;
	private BootstrapButton enter;
	private BootstrapButton cancle;
	private String type;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.weixin_game_add_guaguaka_query_window);
		list=(ListView) findViewById(R.id.weixin_add_guaguaka_query_list);
		idedit=(BootstrapEditText) findViewById(R.id.weixin_add_guaguaka_query_id);
		enter=(BootstrapButton) findViewById(R.id.weixin_add_guaguaka_content_enter);
		cancle=(BootstrapButton) findViewById(R.id.weixin_add_guaguaka_content_cancel);
		Bundle bundle = getIntent().getExtras();
		type = bundle.getString("type");
//		long id = bundle.getLong("id");
//		idedit.setText(String.valueOf(id));
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				GameAddAwardsToGuaGuaKaQueryWindow.this.finish();
			}
		});
		LoadingDialog dialog = new LoadingDialog(GameAddAwardsToGuaGuaKaQueryWindow.this, "正在获取数据");
		dialog.show();
		AddGuaGuaKaHandlerItem handler = 
				new AddGuaGuaKaHandlerItem(GameAddAwardsToGuaGuaKaQueryWindow.this, list, dialog,type);
		AddGuaGuaKaThreadItem thread = 
				new AddGuaGuaKaThreadItem(GameAddAwardsToGuaGuaKaQueryWindow.this, handler);
		thread.start();
	}	
}
