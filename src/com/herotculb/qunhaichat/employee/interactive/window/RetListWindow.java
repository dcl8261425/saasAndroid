package com.herotculb.qunhaichat.employee.interactive.window;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyZoneRetDto;
import com.herotculb.qunhaichat.employee.interactive.adapter.RetListAdapter;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
/**
 * 根据角色选权限
 * @author lkx
 *
 */
public class RetListWindow extends Activity {
	private BootstrapButton speak;
	private BootstrapButton cancle;
	private ListView list;	
	private BootstrapEditText groupId;
	String type;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_ret_list_window);
		speak =(BootstrapButton)findViewById(R.id.employee_ret_list_speak);
		cancle =(BootstrapButton)findViewById(R.id.employee_ret_list_cancle);
		XListView view=(XListView) RetListWindow.this.findViewById(R.id.employee_ret_list);
		view.setPullLoadEnable(true);
		
		Bundle b = getIntent().getExtras();
//		Log.e("retList--", b.getString("retList"));
		List<ConpanyZoneRetDto> retList = new ArrayList<ConpanyZoneRetDto>();
		RetListAdapter adapter 
							= new RetListAdapter(RetListWindow.this, retList);
							view.setAdapter(adapter);
		
		speak.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 我要发言
				
			}
		});
		
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 取消
				RetListWindow.this.finish();
			}
		});
		
	}
	
}
