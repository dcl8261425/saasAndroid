package com.herotculb.qunhaichat.employee.interactive.window;

import android.app.Activity;
import android.content.Intent;
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
import com.herotculb.qunhaichat.employee.interactive.GetListHandler;
import com.herotculb.qunhaichat.employee.interactive.GetListThread;
import com.herotculb.qunhaichat.goods.source.window.GoodsQuerySourceLinkManWindow;
import com.herotculb.qunhaichat.homeactiviti.employee.MeetingManager;
import com.herotculb.qunhaichat.permission.LookUpPermissionByRoleHandler;
import com.herotculb.qunhaichat.permission.LookUpPermissionByRoleThread;
import com.herotculb.qunhaichat.permission.LookUpRoleAllHandler;
import com.herotculb.qunhaichat.permission.LookUpRoleAllThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 根据角色选权限
 * @author lkx
 *
 */
public class GetListWindow extends Activity {
	private BootstrapButton upload;
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
		setContentView(R.layout.employee_get_list_window);
		upload =(BootstrapButton)findViewById(R.id.employee_get_list_upload);
		cancle =(BootstrapButton)findViewById(R.id.employee_get_list_cancle);
		XListView view=(XListView) GetListWindow.this.findViewById(R.id.employee_get_list);
		view.setPullLoadEnable(true);
		
		LoadingDialog dialog = new LoadingDialog(
				GetListWindow.this, "正在获取数据");
		dialog.show();
		
		Bundle b = getIntent().getExtras();
		type = b.getString("type");
		
		view.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) 
						GetListWindow.this.findViewById(R.id.employee_get_list_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(GetListWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) GetListWindow.this.findViewById(R.id.employee_get_list);
				if(type.equals("img")){
					GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
					GetListThread thread = new GetListThread(GetListWindow.this, "img", 
							String.valueOf(nowpagenum), "10", handler);
					thread.start();
				}else if(type.equals("file")){
					GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
					GetListThread thread = new GetListThread(GetListWindow.this, "file", 
							String.valueOf(nowpagenum), "10", handler);
					thread.start();
				}else{
					GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
					GetListThread thread = new GetListThread(GetListWindow.this, "video", 
							String.valueOf(nowpagenum), "10", handler);
					thread.start();
				}
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) 
						GetListWindow.this.findViewById(R.id.employee_get_list_nowpage);
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog = new LoadingDialog(GetListWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) GetListWindow.this.findViewById(R.id.employee_get_list);
				if(type.equals("img")){
					GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
					GetListThread thread = new GetListThread(GetListWindow.this, "img", 
							String.valueOf(nowpagenum+1), "10", handler);
					thread.start();
				}else if(type.equals("file")){
					GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
					GetListThread thread = new GetListThread(GetListWindow.this, "file", 
							String.valueOf(nowpagenum+1), "10", handler);
					thread.start();
				}else{
					GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
					GetListThread thread = new GetListThread(GetListWindow.this, "video", 
							String.valueOf(nowpagenum+1), "10", handler);
					thread.start();
				}
			}
		});
		
		if(type.equals("img")){
			GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
			GetListThread thread = new GetListThread(GetListWindow.this, "img", "1", "10", handler);
			thread.start();
		}else if(type.equals("file")){
			GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
			GetListThread thread = new GetListThread(GetListWindow.this, "file", "1", "10", handler);
			thread.start();
		}else{
			GetListHandler handler = new GetListHandler(GetListWindow.this, view, dialog);
			GetListThread thread = new GetListThread(GetListWindow.this, "video", "1", "10", handler);
			thread.start();
		}
		
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 取消
				GetListWindow.this.finish();
			}
		});
		
	}
	
}
