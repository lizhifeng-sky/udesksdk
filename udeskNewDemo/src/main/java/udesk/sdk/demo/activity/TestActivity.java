package udesk.sdk.demo.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.UUID;

import cn.udesk.PreferenceHelper;
import udesk.sdk.demo.R;

public class TestActivity extends Activity {
    private TextView init;
    private TextView startTarget;
    private UdeskHelper helper;
    //替换成你们注册生成的域名
    private String UDESK_DOMAIN = "qtools.udesk.cn";
    //替换成你们生成应用产生的appid
    private String AppId = "98c0e8fdbc9615b2";
    // 替换成你们在后台生成的密钥
    private String UDESK_SECRETKEY = "e82edb1444fc35d37f70b5137d87aa1e";
    private String sdkToken = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        init = findViewById(R.id.init);
        startTarget = findViewById(R.id.startTarget);
        sdkToken = PreferenceHelper.readString(getApplicationContext(), "init_base_name", "sdktoken");
        if (TextUtils.isEmpty(sdkToken)) {
            sdkToken = UUID.randomUUID().toString();
        }
        helper = new UdeskHelper();
        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.init(TestActivity.this, UDESK_DOMAIN, UDESK_SECRETKEY, AppId, sdkToken);
            }
        });

        startTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.startTarget(TestActivity.this, "95278");
            }
        });
    }
}
