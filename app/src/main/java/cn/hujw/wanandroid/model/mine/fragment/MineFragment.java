package cn.hujw.wanandroid.model.mine.fragment;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyLazyFragment;
import cn.hujw.wanandroid.ui.activity.HomeActivity;
import cn.hujw.wanandroid.widget.XCollapsingToolbarLayout;


/**
 * @author: hujw
 * @date: 2019/8/11
 * @description: 项目界面跳转示例
 * @email: hujw_android@163.com
 */
public class MineFragment extends MyLazyFragment<HomeActivity> implements XCollapsingToolbarLayout.OnScrimsListener {


    @BindView(R.id.abl_mine_bar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.ctl_mine_bar)
    XCollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.t_mine_title)
    Toolbar mToolbar;
    @BindView(R.id.iv_avatar_small)
    ImageView mAvatarSmallView;

    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        // 给这个ToolBar设置顶部内边距，才能和TitleBar进行对齐
        ImmersionBar.setTitleBar(getAttachActivity(), mToolbar);
        //设置渐变监听
        mCollapsingToolbarLayout.setOnScrimsListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected boolean statusBarDarkFont() {
        return mCollapsingToolbarLayout.isScrimsShown();
    }


    @Override
    public void onScrimsStateChange(XCollapsingToolbarLayout layout, boolean shown) {
        if (shown) {
            mAvatarSmallView.setVisibility(View.VISIBLE);
        } else {
            mAvatarSmallView.setVisibility(View.GONE);
        }
    }
}
