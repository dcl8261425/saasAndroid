package com.herotculb.qunhaichat.employee;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.querychance.window.AddLinkmanSexWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 进货商信息操作-添加新供货商联系人
 * @author lkx
 *
 */
public class AddCustomerWindow extends Activity {
	private BootstrapButton enter;
	private BootstrapButton calcel;
	private BootstrapButton useLoginBtn;
	private BootstrapButton sexBtn;	
	private BootstrapButton imageBtn;	
	private BootstrapButton idimageBtn;	
	
	private BootstrapEditText id;
	private BootstrapEditText username;
	private BootstrapEditText password;
	private BootstrapEditText name;
	private BootstrapEditText phone;
	private BootstrapEditText email;
	private BootstrapEditText useLogin;
	private BootstrapEditText idnum;
	private BootstrapEditText sex;
	private BootstrapEditText stute;
	private BootstrapEditText address;
	private BootstrapEditText price;
	private BootstrapEditText marks;
	private BootstrapEditText image;
	private BootstrapEditText idimage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_add_customer_window);
		enter =(BootstrapButton)findViewById(R.id.customer_content_enter);
		calcel = (BootstrapButton)findViewById(R.id.customer_content_cancel);
		useLoginBtn = (BootstrapButton)findViewById(R.id.customer_useLogin_select);
		sexBtn = (BootstrapButton)findViewById(R.id.customer_sex_select);
		imageBtn = (BootstrapButton)findViewById(R.id.customer_image_select);
		idimageBtn = (BootstrapButton)findViewById(R.id.customer_idimage_select);
		
		id = (BootstrapEditText)findViewById(R.id.customer_id);
		username = (BootstrapEditText)findViewById(R.id.customer_username);
		password = (BootstrapEditText)findViewById(R.id.customer_password);
		name = (BootstrapEditText)findViewById(R.id.customer_name);
		phone = (BootstrapEditText)findViewById(R.id.customer_phone);
		email = (BootstrapEditText)findViewById(R.id.customer_email);
		useLogin = (BootstrapEditText)findViewById(R.id.customer_useLogin);
//		idnum = (BootstrapEditText)findViewById(R.id.customer_idnum);
		sex = (BootstrapEditText)findViewById(R.id.customer_sex);
		stute = (BootstrapEditText)findViewById(R.id.customer_stute);
		address = (BootstrapEditText)findViewById(R.id.customer_address);
		price = (BootstrapEditText)findViewById(R.id.customer_price);
		marks = (BootstrapEditText)findViewById(R.id.customer_marks);
		image = (BootstrapEditText)findViewById(R.id.customer_image);
		idimage = (BootstrapEditText)findViewById(R.id.customer_idimage);
		Bundle bundle = getIntent().getExtras();
		Object idstr = (Object) bundle.get("id");
		Object usernamestr = (Object) bundle.get("username");
		Object passwordstr = (Object) bundle.get("password");
		Object namestr = (Object) bundle.get("name");
		Object phonestr = (Object) bundle.get("phone");
		Object emailstr = (Object) bundle.get("email");
		Object useLoginstr = (Object) bundle.get("useLogin");
		Object idnumstr = (Object) bundle.get("idnum");
		Object sexstr = (Object) bundle.get("sex");
		Object stutestr = (Object) bundle.get("stute");
		Object addressstr = (Object) bundle.get("address");
		Object pricestr = (Object) bundle.get("price");
		Object marksstr = (Object) bundle.get("marks");
		Object imagestr = (Object) bundle.get("image");
		Object idimagestr = (Object) bundle.get("idimage");
		if(idstr!=null&&!idstr.equals("")){
			id.setText(idstr.toString());
			username.setText(usernamestr.toString());
			password.setText(passwordstr.toString());
			name.setText(namestr.toString());
			phone.setText(phonestr.toString());
			email.setText(emailstr.toString());
			useLogin.setText(useLoginstr.toString());
//			idnum.setText(idnumstr.toString());
			sex.setText(sexstr.toString());
			stute.setText(stutestr.toString());
			address.setText(addressstr.toString());
			price.setText(pricestr.toString());
			marks.setText(marksstr.toString());
			image.setText(imagestr.toString());
			idimage.setText(idimagestr.toString());
		}else{
			enter.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 添加员工
					LoadingDialog dialog2 = new LoadingDialog(
							AddCustomerWindow.this, "正在获取数据");
					dialog2.show();
					AddCustomerHandler handler = 
							new AddCustomerHandler(AddCustomerWindow.this, dialog2);
					AddCustomerThread thread = 
							new AddCustomerThread(AddCustomerWindow.this, handler);
					thread.start();
				}
			});
		}
		useLoginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 是否可用选择
				Intent i = new Intent(AddCustomerWindow.this,EmployeeUseLoginWindow.class);
				Bundle b = new Bundle();
				b.putString("classes", "com.herotculb.qunhaichat.employee.AddCustomerWindow");
				i.putExtras(b);
				AddCustomerWindow.this.startActivityForResult(i, 0);
				AddCustomerWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		sexBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 性别选择
				Intent i = new Intent(AddCustomerWindow.this,AddLinkmanSexWindow.class);
				Bundle b = new Bundle();
				b.putString("classes", "com.herotculb.qunhaichat.employee.AddCustomerWindow");
				i.putExtras(b);
				AddCustomerWindow.this.startActivityForResult(i, 0);
				AddCustomerWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		image.setVisibility(View.GONE);
		imageBtn.setVisibility(View.GONE);
		imageBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 选择员工照片
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
		        intent.setType("image/*");  
		        intent.putExtra("crop", true);  
		        intent.putExtra("return-data", true);  
		        startActivityForResult(intent, 2);
			}
		});
		idimage.setVisibility(View.GONE);
		idimageBtn.setVisibility(View.GONE);
		idimageBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 选择身份证照片
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
		        intent.setType("image/*");  
		        intent.putExtra("crop", true);  
		        intent.putExtra("return-data", true);  
		        startActivityForResult(intent, 3);
			}
		});
		calcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				AddCustomerWindow.this.finish();
			}
		});
	}
	
	//弹出框返回的内容在这里接受
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data); 
	        ImageView image = (ImageView)findViewById(R.id.customer_img);
        	image.setVisibility(View.GONE);
	        if (requestCode == 2) {  
	              Uri uri = data.getData();  
	              System.out.println(uri.getPath());  
	              
	              ContentResolver cr = this.getContentResolver();  
	                
	              try {
					Bitmap bmp = BitmapFactory.decodeStream(cr.openInputStream(uri));
					image.setImageBitmap(bmp);
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
//	              try {  
////				       bmp = BitmapFactory.decodeStream(cr.openInputStream(uri));  
////				           MCShareLaunchShareHelper.shareContentWithBitmap("测试分享本地图片", bmp, "your share url", "", AddCustomerWindow.this);  
//				   } catch (FileNotFoundException e) {  
//				       // TODO Auto-generated catch block  
//				       e.printStackTrace();  
//				   }  
		     
		       }
	        if(requestCode == 3){
	        	Uri uri = data.getData();  
	              System.out.println(uri.getPath());  
	              
	              ContentResolver cr = this.getContentResolver();  
	                
	              try {
					Log.e("shenfenzhengurl--", ""+cr.openInputStream(uri));
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	        }
	        //取出字符串  
	        if(data==null){
	        	return ;
	        }
	        Bundle bundle = data.getExtras();	        
	        if(bundle==null){
	        	return ;
	        }
	        String type=(String) bundle.get("type");
	        
	        BootstrapEditText sex = (BootstrapEditText)findViewById(R.id.customer_sex);
        	if(type.equals("add_linkman_sex1")){
	        	sex.setText(bundle.getString("sex1Str"));
	        }
        	if(type.equals("add_linkman_sex2")){
        		sex.setText(bundle.getString("sex2Str"));
        	}
        	BootstrapEditText useLogin = (BootstrapEditText)findViewById(R.id.customer_useLogin);
        	if(type.equals("add_linkman_useLogin1")){
        		useLogin.setText(bundle.getString("useLogin1Str"));
	        }
        	if(type.equals("add_linkman_useLogin2")){
        		useLogin.setText(bundle.getString("useLogin2Str"));
        	}
        	
	 }
	
}
