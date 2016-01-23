package com.herotculb.qunhaichat.homeactiviti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MyLocationData;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.hr.qiandao.MeetingHandler;
import com.herotculb.qunhaichat.hr.qiandao.MeetingThread;
import com.herotculb.qunhaichat.location.LocationService;
import com.herotculb.qunhaichat.location.MeetingTest;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 签到
 * @author Administrator
 *
 */
public class QiandaoButtonOnclick {
	BootstrapButton  but;
	BaiduMap map;
	public QiandaoButtonOnclick(BootstrapButton  but,final Activity home,BaiduMap map){
		this.but=but;
		this.map=map;
		this.but.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                new SweetAlertDialog(home, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("签到")
                .setContentText("您确定在当前位置进行签到？")
                .setCancelText("取消")
                .setConfirmText("确定")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        // reuse previous dialog instance, keep widget user state, reset them if you need
                        sDialog.setTitleText("签到取消")
                                .setContentText("您的签到已经取消")
                                .setConfirmText("确定")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(new OnSweetClickListener() {
									
									@Override
									public void onClick(SweetAlertDialog sweetAlertDialog) {
										// TODO Auto-generated method stub
										
										  Intent i = new Intent(home,HomeActivity.class);
										  MeetingTest test=new MeetingTest(home);
											test.start();
					                        home.setResult(home.RESULT_OK, i);
					                        home.finish();
					                        
					                       
									}
								})
                                .changeAlertType(SweetAlertDialog.ERROR_TYPE);
                      
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                    	LoadingDialog dialog = new LoadingDialog(home, "正在获取数据");
        				dialog.show();
                    	MyLocationData locData = QiandaoButtonOnclick.this.map.getLocationData();
                    	Handler handler = new MeetingHandler(sDialog,home,dialog);
                    	MeetingThread thread = new MeetingThread(
                				handler,home,locData.longitude+"",locData.latitude+"");
                		thread.start();
                    }
                })
                .show();
			}
		});
	}
}
