package com.herotculb.qunhaichat.homeactiviti.weixin.modelset;

import android.widget.LinearLayout;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;

public class ModelSet {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public ModelSet(HomeActivity home,LinearLayout linearLayout){
		this.home=home;
		this.linearLayout=linearLayout;
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.weixin_modelset_layout, null)
				.findViewById(R.id.weixin_modelset_layout_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
	}
}
