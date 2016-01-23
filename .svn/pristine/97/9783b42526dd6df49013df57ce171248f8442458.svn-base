package com.herotculb.qunhaichat.crm.querychance.window;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.querychance.QueryLinkManHandler;
import com.herotculb.qunhaichat.crm.querychance.QueryLinkManThread;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceLinkManHandler;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceLinkManThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 查看联系人的window
 * @author lkx
 *
 */
public class QueryLinkManWindow extends Activity {
	private XListView list;
	private BootstrapButton create;
	private String chanceId;
	int layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.crm_query_linkman_window);		
		BootstrapEditText nowpage=(BootstrapEditText) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_nowpage);
		nowpage.setText("1");
		LoadingDialog dialog = new LoadingDialog(QueryLinkManWindow.this, "正在获取数据");
		dialog.show();
		Bundle b = getIntent().getExtras();
		chanceId = b.getString("chanceId");
		list=(XListView) findViewById(R.id.crm_query_linkman_list);
		layout = R.layout.crm_query_linkman_list;
		list.setPullLoadEnable(true);
		list.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(QueryLinkManWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_list);
				QueryLinkManHandler handler = 
						new QueryLinkManHandler(QueryLinkManWindow.this, view, dialog,layout);
				QueryLinkManThread thread = 
						new QueryLinkManThread(QueryLinkManWindow.this, String.valueOf(nowpagenum), "10", namestr, chanceId, handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog = new LoadingDialog(QueryLinkManWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_list);
				QueryLinkManHandler handler = 
						new QueryLinkManHandler(QueryLinkManWindow.this, view, dialog,layout);
				QueryLinkManThread thread = 
						new QueryLinkManThread(QueryLinkManWindow.this, String.valueOf(nowpagenum+1), "10", namestr, chanceId, handler);
				thread.start();
			}
		});
		QueryLinkManHandler handler = 
				new QueryLinkManHandler(QueryLinkManWindow.this, list, dialog,layout);
		QueryLinkManThread thread = 
				new QueryLinkManThread(QueryLinkManWindow.this, "1", "10", "", chanceId, handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按电话号查询
				BootstrapEditText nowpage=(BootstrapEditText) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(QueryLinkManWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_list);
				QueryLinkManHandler handler = 
						new QueryLinkManHandler(QueryLinkManWindow.this, view, dialog,layout);
				QueryLinkManThread thread = 
						new QueryLinkManThread(QueryLinkManWindow.this, "1", "10", namestr, chanceId, handler);
				thread.start();
			}
		});
		BootstrapButton cancle=(BootstrapButton) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_name_cancle);
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消查询
				QueryLinkManWindow.this.finish();
			}
		});
		create =(BootstrapButton) QueryLinkManWindow.this.findViewById(R.id.crm_query_linkman_new);
		create.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 创建新联系人
				Intent i = new Intent(QueryLinkManWindow.this, AddLinkManWindow.class);  
				Bundle b = new Bundle(); 
				b.putString("type", "");
				b.putString("chanceId", chanceId);
                i.putExtras(b);  
                QueryLinkManWindow.this.startActivityForResult(i, 0);
                QueryLinkManWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		
	}
	
	//弹出框返回的内容在这里接受
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data);
	      //取出字符串  
	        if(data==null){
	        	return ;
	        }
	        Bundle bundle = data.getExtras();	        
	        if(bundle==null){
	        	return ;
	        }
	        String type=(String) bundle.get("type");
	        if(type.equals("crm_add_linkman")){
	        	BootstrapButton b = (BootstrapButton)findViewById(R.id.crm_query_linkman_name_query);
	        	b.performClick();
	        }
	 }
}
