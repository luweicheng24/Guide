package com.gsww.www.guide;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {
  private int isFirst = 0;//0 代表第一次 1 代表不是第一次进来
  private Handler handler = new Handler(){
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          if(isFirst == 1){
              startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
          }else {
              startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
          }
          finish();
      }
  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        isFirstLogin();
        handler.sendEmptyMessageDelayed(0,2000);//启动页停留两秒后跳转

}

    private void isFirstLogin(){
       isFirst = getApplication().getSharedPreferences("isFirst",MODE_PRIVATE).getInt("isFirst",0);
    }
}
