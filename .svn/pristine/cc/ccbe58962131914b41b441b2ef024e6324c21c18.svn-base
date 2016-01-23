package com.herotculb.qunhaichat.crm.notes.window;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.querychance.QueryLinkManHandler;
import com.herotculb.qunhaichat.crm.querychance.QueryLinkManThread;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceHandler;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceLinkManHandler;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceLinkManThread;
import com.herotculb.qunhaichat.goods.source.GoodsQuerySourceThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.view.listview.updown.XListView.IXListViewListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 查看联系人的window
 * @author lkx
 *
 */
public class CrmGoodsSourceLinkManWindow extends Activity {
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
		setContentView(R.layout.crm_goods_source_linkman_window);		
		BootstrapEditText nowpage=(BootstrapEditText) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_nowpage);
		nowpage.setText("1");
		LoadingDialog dialog = new LoadingDialog(CrmGoodsSourceLinkManWindow.this, "正在获取数据");
		dialog.show();
		Bundle b = getIntent().getExtras();
		chanceId = b.getString("chanceId");
		list=(XListView) findViewById(R.id.crm_goods_source_linkman_list);
		layout = R.layout.crm_goods_source_linkman_list;
		list.setPullLoadEnable(true);
		list.setXListViewListener(new IXListViewListener() {
			
			@Override
			public void onRefresh() {
				// TODO 刷新
				BootstrapEditText nowpage=(BootstrapEditText) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				if(nowpagenum<=1){
					nowpagenum=1;
				}else{
					nowpagenum=nowpagenum-1;
				}
				nowpage.setText(String.valueOf(nowpagenum));
				LoadingDialog dialog = new LoadingDialog(CrmGoodsSourceLinkManWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_list);
				GoodsQuerySourceLinkManHandler handler = 
						new GoodsQuerySourceLinkManHandler(CrmGoodsSourceLinkManWindow.this, view, dialog,layout);
				GoodsQuerySourceLinkManThread thread = 
						new GoodsQuerySourceLinkManThread(CrmGoodsSourceLinkManWindow.this, String.valueOf(nowpagenum), "10", namestr, handler);
				thread.start();
			}
			
			@Override
			public void onLoadMore() {
				// TODO 加载更多
				BootstrapEditText nowpage=(BootstrapEditText) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_nowpage);
				BootstrapEditText nameedit=(BootstrapEditText) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_name);
				String namestr=nameedit.getText().toString();
				int nowpagenum=Integer.parseInt(nowpage.getText().toString());
				nowpage.setText(String.valueOf(nowpagenum+1));
				LoadingDialog dialog = new LoadingDialog(CrmGoodsSourceLinkManWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_list);
				GoodsQuerySourceLinkManHandler handler = 
						new GoodsQuerySourceLinkManHandler(CrmGoodsSourceLinkManWindow.this, view, dialog,layout);
				GoodsQuerySourceLinkManThread thread = 
						new GoodsQuerySourceLinkManThread(CrmGoodsSourceLinkManWindow.this, String.valueOf(nowpagenum+1), "10", namestr, handler);
				thread.start();
			}
		});
		GoodsQuerySourceLinkManHandler handler = 
				new GoodsQuerySourceLinkManHandler(CrmGoodsSourceLinkManWindow.this, list, dialog,layout);
		GoodsQuerySourceLinkManThread thread = 
				new GoodsQuerySourceLinkManThread(CrmGoodsSourceLinkManWindow.this, "1", "10", "", handler);
		thread.start();
		BootstrapButton query=(BootstrapButton) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_name_query);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 按电话号查询
				BootstrapEditText nowpage=(BootstrapEditText) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_nowpage);
				nowpage.setText("1");
				BootstrapEditText nameedit=(BootstrapEditText) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_name);
				String namestr=nameedit.getText().toString();
				LoadingDialog dialog = new LoadingDialog(CrmGoodsSourceLinkManWindow.this, "正在获取数据");
				dialog.show();
				XListView view=(XListView) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_list);
				GoodsQuerySourceLinkManHandler handler = 
						new GoodsQuerySourceLinkManHandler(CrmGoodsSourceLinkManWindow.this, view, dialog,layout);
				GoodsQuerySourceLinkManThread thread = 
						new GoodsQuerySourceLinkManThread(CrmGoodsSourceLinkManWindow.this, "1", "10", namestr, handler);
				thread.start();
			}
		});
		BootstrapButton cancle=(BootstrapButton) CrmGoodsSourceLinkManWindow.this.findViewById(R.id.crm_goods_source_linkman_name_cancle);
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消查询
				CrmGoodsSourceLinkManWindow.this.finish();
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
	        if(type.equals("goods_source")){
	        	Intent i = new Intent(CrmGoodsSourceLinkManWindow.this, SelectedLinkManWindow.class);  
		        Bundle b2 = new Bundle();
		        b2.putString("type", "selected_linkman");
		        b2.putString("linkManName", bundle.getString("linkManName"));
		        b2.putString("linkManId", bundle.getString("linkManId"));
		        i.putExtras(b2);
		        CrmGoodsSourceLinkManWindow.this.setResult(CrmGoodsSourceLinkManWindow.this.RESULT_OK, i);
		        CrmGoodsSourceLinkManWindow.this.finish();  
			}
	 }
}
