package com.herotculb.qunhaichat.employee.interactive.window;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.VideoView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.CreateChanceWindow;
import com.herotculb.qunhaichat.crm.querychance.window.CustomerLevelWindow;
import com.herotculb.qunhaichat.employee.interactive.EmployeeInteractiveSendHandler;
import com.herotculb.qunhaichat.employee.interactive.EmployeeInteractiveSendThread;
import com.herotculb.qunhaichat.employee.meeting.GetMeetingSetInfoWindow;
import com.herotculb.qunhaichat.homeactiviti.employee.MeetingManager;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 互动空间的window
 * @author lkx
 *
 */
public class EmployeeInteractiveResendWindow extends Activity{
	private BootstrapButton enter;
	BootstrapEditText start;
	BootstrapEditText end;
	String groupId;
	int layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_interactive_resend_window);	
		BootstrapButton imageSpace =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_image_space);
		imageSpace.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 个人图片空间
				Intent i = new Intent(EmployeeInteractiveResendWindow.this, GetListWindow.class);  
				Bundle b = new Bundle();
				b.putString("type", "img");
				i.putExtras(b);  
				EmployeeInteractiveResendWindow.this.startActivityForResult(i, 0);
				EmployeeInteractiveResendWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		BootstrapButton imageAddress =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_image_address);
		BootstrapButton imageUpload =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_image_upload);
		imageAddress.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 图片地址
				Intent i = new Intent(EmployeeInteractiveResendWindow.this, EmployeeAddressWindow.class);  
				Bundle b = new Bundle();
				b.putString("type", "img");
				i.putExtras(b);  
				EmployeeInteractiveResendWindow.this.startActivityForResult(i, 0);
				EmployeeInteractiveResendWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		imageUpload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 图片上传
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
		        intent.setType("image/*");  
		        intent.putExtra("crop", true);  
		        intent.putExtra("return-data", true);  
		        startActivityForResult(intent, 2);
			}
		});
		BootstrapButton fileSpace =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_file_space);
		fileSpace.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 个人文件空间
				Intent i = new Intent(EmployeeInteractiveResendWindow.this, GetListWindow.class);  
				Bundle b = new Bundle();
				b.putString("type", "file");
				i.putExtras(b);  
				EmployeeInteractiveResendWindow.this.startActivityForResult(i, 0);
				EmployeeInteractiveResendWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		BootstrapButton fileAddress =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_file_address);
		BootstrapButton fileUpload =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_file_upload);
		fileAddress.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 文件地址
				Intent i = new Intent(EmployeeInteractiveResendWindow.this, EmployeeAddressWindow.class);  
				Bundle b = new Bundle();
				b.putString("type", "file");
				i.putExtras(b);  
				EmployeeInteractiveResendWindow.this.startActivityForResult(i, 0);
				EmployeeInteractiveResendWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		fileUpload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 文件上传
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
		        intent.setType("file/*");  
		        intent.putExtra("crop", true);  
		        intent.putExtra("return-data", true);  
		        startActivityForResult(intent, 3);
			}
		});
		BootstrapButton videoSpace =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_video_space);
		videoSpace.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 个人视频空间
				Intent i = new Intent(EmployeeInteractiveResendWindow.this, GetListWindow.class);  
				Bundle b = new Bundle();
				b.putString("type", "video");
				i.putExtras(b);  
				EmployeeInteractiveResendWindow.this.startActivityForResult(i, 0);
				EmployeeInteractiveResendWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		BootstrapButton videoAddress =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_video_address);
		BootstrapButton videoUpload =(BootstrapButton) 
				EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_video_upload);
		videoAddress.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 视频地址
				Intent i = new Intent(EmployeeInteractiveResendWindow.this, EmployeeAddressWindow.class);  
				Bundle b = new Bundle();
				b.putString("type", "video"); 
				i.putExtras(b);  
				EmployeeInteractiveResendWindow.this.startActivityForResult(i, 0);
				EmployeeInteractiveResendWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		videoUpload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 视频上传
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
		        intent.setType("video/*");  
		        intent.putExtra("crop", true);  
		        intent.putExtra("return-data", true);  
		        startActivityForResult(intent, 4);
			}
		});
		BootstrapButton cancle=(BootstrapButton) EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_resend_cancle);
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消查询
				EmployeeInteractiveResendWindow.this.finish();
			}
		});
		enter =(BootstrapButton) EmployeeInteractiveResendWindow.this.findViewById(R.id.employee_interactive_resend_enter);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 保存
				LoadingDialog dialog = new 
						LoadingDialog(EmployeeInteractiveResendWindow.this, "正在保存数据");
				dialog.show();
				EmployeeInteractiveSendHandler handler = 
						new EmployeeInteractiveSendHandler(EmployeeInteractiveResendWindow.this, dialog);
				EmployeeInteractiveSendThread thread = 
						new EmployeeInteractiveSendThread(EmployeeInteractiveResendWindow.this, groupId, handler);
				thread.start();
			}
		});
	}
	
	//弹出框返回的内容在这里接受
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data);
	      //取出字符串  
	        ImageView img = (ImageView)findViewById(R.id.employee_interactive_img);
	        if (requestCode == 2) {
	        	try{
		        	Uri uri = data.getData();
		        	img.setImageURI(uri);
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
	        }
	        TextView file = (TextView)findViewById(R.id.employee_interactive_file);
	        if(requestCode == 3){
	        	try{
		        	Uri uri = data.getData();
		        	file.setText(uri+"");
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
	        }
	        VideoView video = (VideoView)findViewById(R.id.employee_interactive_video);
	        if(requestCode == 4){
	        	try{
		        	Uri uri = data.getData();
		        	video.setVideoPath(uri+"");
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
	        }
	        if(data==null){
	        	return ;
	        }
	        Bundle bundle = data.getExtras();	        
	        if(bundle==null){
	        	return ;
	        }
	        String type=(String) bundle.get("type");
	        if(type.equals("img")){
	        	String imgStr = bundle.getString("image");
	        	Uri imgUri = Uri.parse(imgStr);
	        	img.setImageURI(imgUri);
	        }
	 }
}
