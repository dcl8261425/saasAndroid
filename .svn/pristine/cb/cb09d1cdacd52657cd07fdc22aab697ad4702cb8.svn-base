package com.herotculb.qunhaichat.crm.notes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
public class NotesLinkWindow extends Activity {
	private XListView list;
	private BootstrapButton create;
	private String marks;
	private String notesId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.crm_notes_link_window);		
		Bundle b = getIntent().getExtras();
		marks = b.getString("marks");
		Log.e("bundle--", b+"");
		BootstrapButton button =(BootstrapButton) NotesLinkWindow.this.findViewById(R.id.crm_notes_link_name);
		button.setText(marks);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 显示开发记录详细
				
			}
		});
		BootstrapButton cancle=(BootstrapButton) NotesLinkWindow.this.findViewById(R.id.crm_notes_link_name_cancle);
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消
				NotesLinkWindow.this.finish();
			}
		});
		
	}
	
}
