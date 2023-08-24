package com.hhu.smartdetection;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mMessage,mTitle,mRight,mLeft;
    private String sMessage,sTitle,sLeft,sRight;
    private View.OnClickListener rightListener, leftListener;

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public void setsMessage(String sMessage) {
        if (mMessage == null)
            this.sMessage = sMessage;
        else
            this.mMessage.setText(sMessage);
    }

    public void setsLeft(String sLeft,View.OnClickListener listener) {
        this.sLeft = sLeft;
        this.leftListener = listener;
    }

    public void setsLeft(String sLeft) {
        this.sLeft = sLeft;
        if (mLeft != null)
            this.mLeft.setText(sLeft);
    }

    public String getsLeft(){
        return this.sLeft;
    }

    public void setsRight(String sRight,View.OnClickListener listener) {
        this.sRight = sRight;
        this.rightListener = listener;
    }

    public void setsRight(String sRight) {
        this.sRight = sRight;
        if (mRight != null)
            this.mRight.setText(sRight);
    }

    public String getsRight(){
        return this.sRight;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 去除dialog自带标题
        setContentView(R.layout.layout_custom_dialog);

        // 设置背景色为透明
        // getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // setCancelable(false);

        //自定义Dialog宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) ((size.x)*0.9);        //设置为屏幕的0.7倍宽度
        p.height = (int) (size.y * 0.7); // 设置为屏幕的0.7倍高度
        getWindow().setAttributes(p);

        mTitle = findViewById(R.id.title);
        mMessage = findViewById(R.id.message);
        mLeft = findViewById(R.id.leftButton);
        mRight = findViewById(R.id.rightButton);

        if (!TextUtils.isEmpty(sTitle)) {
            mTitle.setText(sTitle);
        }
        if (!TextUtils.isEmpty(sMessage)) {
            mMessage.setText(sMessage);
        }
        if (!TextUtils.isEmpty(sLeft)) {
            mLeft.setText(sLeft);
        }
        if (!TextUtils.isEmpty(sRight)) {
            mRight.setText(sRight);
        }

        mLeft.setOnClickListener(this);
        mRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.leftButton:
                if(leftListener != null){
                    leftListener.onClick(view);
                }
                break;
            case R.id.rightButton:
                if(rightListener != null){
                    rightListener.onClick(view);
                }
                break;
        }
    }

}