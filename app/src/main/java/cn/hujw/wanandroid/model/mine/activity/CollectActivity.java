package cn.hujw.wanandroid.model.mine.activity;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpActivity;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description:
 * @email: hujw_android@163.com
 */
public class CollectActivity extends MvpActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.sb_collect_article, R.id.sb_collect_website, R.id.sb_read_later})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sb_collect_article:
                startActivity(CollectArticleActivity.class);
                break;
            case R.id.sb_collect_website:
                break;
            case R.id.sb_read_later:
                break;
        }
    }
}
