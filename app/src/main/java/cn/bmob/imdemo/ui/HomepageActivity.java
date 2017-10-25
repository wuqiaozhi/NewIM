package cn.bmob.imdemo.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toolbar;

import cn.bmob.imdemo.R;
import cn.bmob.imdemo.base.BaseActivity;
import cn.bmob.imdemo.base.ParentWithNaviActivity;

/**
 * Created by Keqin Chen on 2017/10/2.
 */

public class HomepageActivity extends ParentWithNaviActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //initNaviView();

    }

    @Override
    protected String title() {
        return "个人主页";
    }
}
