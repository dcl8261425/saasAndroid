package com.herotculb.qunhaichat.location;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 上传当前地理位置
 * 
 * @author Administrator
 * 
 */
public class LocationUpTread extends Thread {
	String username;
	String password;
	String longitude;
	String latitude;
	Activity content;
	public LocationUpTread(String username, String password, String longitude,
			String latitude,Activity content) {
		this.username = username;
		this.password = password;
		this.longitude = longitude;
		this.latitude = latitude;
		this.content=content;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		if (longitude.equals("4.9E-324") || latitude.equals("4.9E-324")) {
			return;
		}
		QNPermissionApiImpl qnp = new QNPermissionApiImpl(username, password);
		List<Map<String, Object>> list = qnp.meeting("略", "test", "0", "0");
		Map<String, Object> map = list.iterator().next();
		if ((Boolean) map.get("success")) {
			if (Boolean.parseBoolean((String) map.get("isup"))) {
				// 未签过到
				content.stopService(new Intent(content,LocationService.class));
			} else {
				qnp.locationUp(longitude, latitude);
			}
		} else {
			content.stopService(new Intent(content,LocationService.class));
		}

	}

}
