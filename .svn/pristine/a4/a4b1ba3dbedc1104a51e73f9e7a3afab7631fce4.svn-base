package com.herotculb.qunhaichat.crm.notes;

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
import com.herotculb.qunhaichat.crm.AddLinkManHandler;
import com.herotculb.qunhaichat.crm.AddLinkManThread;
import com.herotculb.qunhaichat.crm.notes.window.CrmGoodsSourceWindow;
import com.herotculb.qunhaichat.crm.notes.window.CrmGoodsWindow;
import com.herotculb.qunhaichat.crm.notes.window.CrmStoreHouseWindow;
import com.herotculb.qunhaichat.crm.notes.window.CrmUserInGroupWindow;
import com.herotculb.qunhaichat.crm.notes.window.SelectedLinkManWindow;
import com.herotculb.qunhaichat.crm.notes.window.SelectedToMyChanceWindow;
import com.herotculb.qunhaichat.crm.querychance.window.AddLinkManWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class AddNotesItemWindow extends Activity {
	private BootstrapButton enter;
	private BootstrapButton cancle;
	private BootstrapButton linkman;
	private BootstrapButton employee;
	private BootstrapButton develop;
	private BootstrapButton source;
	private BootstrapButton store;
	private BootstrapButton goods;
	
	private BootstrapEditText id;
	private BootstrapEditText title;
	private BootstrapEditText marks;
	
	private String type;
	private String chanceId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.crm_add_notes_item_window);
		enter = (BootstrapButton)findViewById(
				R.id.add_notes_item_content_enter);
		cancle = (BootstrapButton)findViewById(
				R.id.add_notes_item_content_cancel);
		linkman = (BootstrapButton)findViewById(
				R.id.add_notes_item_linkman);
		employee = (BootstrapButton)findViewById(
				R.id.add_notes_item_employee);
		develop = (BootstrapButton)findViewById(
				R.id.add_notes_item_develop);
		source = (BootstrapButton)findViewById(
				R.id.add_notes_item_source);
		store = (BootstrapButton)findViewById(
				R.id.add_notes_item_store);
		goods = (BootstrapButton)findViewById(
				R.id.add_notes_item_goods);
		
		id = (BootstrapEditText)findViewById(R.id.add_notes_item_id);
		title = (BootstrapEditText)findViewById(R.id.add_notes_item_title);
		marks = (BootstrapEditText)findViewById(R.id.add_notes_item_marks);
		Bundle bundle = getIntent().getExtras();
		chanceId = bundle.getString("chanceId");
		linkman.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 添加联系人
				Intent i = new Intent(AddNotesItemWindow.this,SelectedLinkManWindow.class);
				Bundle b = new Bundle();
				i.putExtras(b);
				AddNotesItemWindow.this.startActivityForResult(i, 0);
				AddNotesItemWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		employee.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 添加员工
				Intent i = new Intent(AddNotesItemWindow.this,CrmUserInGroupWindow.class);
				Bundle b = new Bundle();
				b.putString("classes", "com.herotculb.qunhaichat.crm.notes.AddNotesItemWindow");
				i.putExtras(b);
				AddNotesItemWindow.this.startActivityForResult(i, 0);
				AddNotesItemWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		develop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 添加开发信息
				Intent i = new Intent(AddNotesItemWindow.this,SelectedToMyChanceWindow.class);
				Bundle b = new Bundle();
				b.putString("classes", "com.herotculb.qunhaichat.crm.notes.AddNotesItemWindow");
				i.putExtras(b);
				AddNotesItemWindow.this.startActivityForResult(i, 0);
				AddNotesItemWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		source.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 添加供应商
				Intent i = new Intent(AddNotesItemWindow.this,CrmGoodsSourceWindow.class);
				Bundle b = new Bundle();
				b.putString("classes", "com.herotculb.qunhaichat.crm.notes.AddNotesItemWindow");
				i.putExtras(b);
				AddNotesItemWindow.this.startActivityForResult(i, 0);
				AddNotesItemWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		store.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 添加仓库
				Intent i = new Intent(AddNotesItemWindow.this,CrmStoreHouseWindow.class);
				Bundle b = new Bundle();
				b.putString("classes", "com.herotculb.qunhaichat.crm.notes.AddNotesItemWindow");
				i.putExtras(b);
				AddNotesItemWindow.this.startActivityForResult(i, 0);
				AddNotesItemWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		goods.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 添加商品
				Intent i = new Intent(AddNotesItemWindow.this,CrmGoodsWindow.class);
				Bundle b = new Bundle();
				b.putString("classes", "com.herotculb.qunhaichat.crm.notes.AddNotesItemWindow");
				i.putExtras(b);
				AddNotesItemWindow.this.startActivityForResult(i, 0);
				AddNotesItemWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 确认添加
				LoadingDialog dialog = new LoadingDialog(AddNotesItemWindow.this,"正在保存数据！");
				dialog.show();
				Bundle b = getIntent().getExtras();
				AddNotesItemHandler handler = 
						new AddNotesItemHandler(AddNotesItemWindow.this, dialog);
				AddNotesItemThread thread = 
						new AddNotesItemThread(AddNotesItemWindow.this, chanceId,
								b.getString("notesId"), "略", "略", handler);
				thread.start();
			}
		});
		
		
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消
				AddNotesItemWindow.this.finish();
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
	        BootstrapEditText id = 
	        		(BootstrapEditText)findViewById(R.id.add_notes_item_id);
	        BootstrapEditText marks = 
	        		(BootstrapEditText)findViewById(R.id.add_notes_item_marks);
	        if(type.equals("selected_linkman")){
	        	id.setText(bundle.getString("linkManId"));
	        	marks.setText(bundle.getString("linkManName"));
	        }else if(type.equals("select_username_group")){
	        	id.setText(bundle.getString("userId"));
	        	marks.setText(bundle.getString("userName"));
	        }else if(type.equals("selected_goods_source")){
	        	id.setText(bundle.getString("goodsSourceId"));
	        	marks.setText(bundle.getString("goodsSourceName"));
	        }else if(type.equals("selected_store")){
	        	id.setText(bundle.getString("storeId"));
	        	marks.setText(bundle.getString("storeName"));
	        }else if(type.equals("selected_goods")){
	        	id.setText(bundle.getString("goodsId"));
	        	marks.setText(bundle.getString("goodsName"));
	        }else if(type.equals("selected_notes")){
	        	id.setText(bundle.getString("notesId"));
	        	marks.setText(bundle.getString("notesName")+"的开发记录。");
	        }
	 }
	
}
