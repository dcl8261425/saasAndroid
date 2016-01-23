package com.herotculb.qunhaichat.homeactiviti.goods.query.chart;

import org.apache.commons.logging.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.Toast;

public class JavaScriptMake {
	private WebView view;
	private Activity activity ;
	public JavaScriptMake(WebView view,Activity activity) {
		this.view = view;
		this.activity= activity;
	}

	public void query_Date(String json,int type)
	{
		view.loadUrl("javascript:query_Date('"+json+"','"+type+"')");
	}

	public void alert(String s)
	{
		Toast.makeText(activity,s,Toast.LENGTH_SHORT).show();
	}

	
}
