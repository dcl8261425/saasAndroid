package com.herotculb.qunhaichat.crm.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 查看开发记录的window
 * @author lkx
 *
 */
public class QueryNotesItemWindow extends Activity {
	private XListView list;
	private BootstrapButton create;
	private String chanceId;
	private String notesId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.crm_query_notes_item_window);		
		LoadingDialog dialog = new LoadingDialog(QueryNotesItemWindow.this, "正在获取数据");
		dialog.show();
		Bundle b = getIntent().getExtras();
		chanceId = b.getString("chanceId");
		notesId = b.getString("notesId");
		list=(XListView) findViewById(R.id.crm_query_notes_item_list);
		list.setPullLoadEnable(true);
		QueryNotesItemHandler handler = 
				new QueryNotesItemHandler(QueryNotesItemWindow.this, list, dialog);
		QueryNotesItemThread thread = 
				new QueryNotesItemThread(QueryNotesItemWindow.this, "1", "10", chanceId,notesId , handler);
		thread.start();
		BootstrapButton cancle=(BootstrapButton) QueryNotesItemWindow.this.findViewById(R.id.crm_query_notes_item_name_cancle);
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消
				QueryNotesItemWindow.this.finish();
			}
		});
		
	}
	
}
