package com.example.mybookapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.example.mybookapplication.R;
import com.example.mybookapplication.util.HttpUtil;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Log.d(TAG, "onCreate: glideBegin");
        ImageView mImageView = findViewById(R.id.glide_custom_view_target_tag);

        // Glid图片加载框架
        String imgUrl = "https://ssl.gstatic.com/ui/v1/icons/mail/rfr/logo_gmail_lockup_default_1x.png";
        Glide.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(mImageView);

        // async-http-client
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(imgUrl, new FileAsyncHttpResponseHandler(this) {
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
//
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, File file) {
//                Log.d(TAG, "onSuccess: " + file);
//            }
//        });

//        String manufacturer = DeviceUtils.getManufacturer();
//        String model = DeviceUtils.getModel();
//        String sdkVer = DeviceUtils.getSDKVersionName();
//        ToastUtils.showLong(manufacturer + "  " + model + "  " + sdkVer);

//
//        StringUtils.isEmpty("hello world");
//
//        ActivityUtils.finishAllActivities();

        // 自定义header控件


    }
}
