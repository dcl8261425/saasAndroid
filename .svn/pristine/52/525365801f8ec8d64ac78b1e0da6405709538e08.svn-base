package com.zxing.decoding;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.SurfaceHolder.Callback;

import com.google.zxing.Result;
import com.zxing.view.ViewfinderView;

public abstract class ActivityModel extends Activity implements Callback{
	public abstract ViewfinderView getViewfinderView();
	public abstract Handler getHandler();
	public abstract void drawViewfinder();
	public abstract void handleDecode(Result result, Bitmap barcode);
	
}
