package cn.hujw.wanandroid.model.mine.fragment;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.allen.library.cookie.store.SPCookieStore;
import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.eventbus.RefreshBus;
import cn.hujw.wanandroid.model.login.activity.LoginActivity;
import cn.hujw.wanandroid.model.mine.activity.CollectActivity;
import cn.hujw.wanandroid.model.mine.activity.PlanetActivity;
import cn.hujw.wanandroid.model.mine.activity.SettingActivity;
import cn.hujw.wanandroid.model.mine.mvp.contract.MineContract;
import cn.hujw.wanandroid.model.mine.mvp.modle.UserInfoModel;
import cn.hujw.wanandroid.model.mine.mvp.presenter.MinePresenter;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.widget.XCollapsingToolbarLayout;


/**
 * @author: hujw
 * @date: 2019/8/11
 * @description: 项目界面跳转示例
 * @email: hujw_android@163.com
 */
public class MineFragment extends MvpLazyFragment implements XCollapsingToolbarLayout.OnScrimsListener, MineContract.View {

    @MvpInject
    MinePresenter mPresenter;

    private static final String TAG = "MineFragment";

    @BindView(R.id.abl_mine_bar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.ctl_mine_bar)
    XCollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.t_mine_title)
    Toolbar mToolbar;


    @BindView(R.id.iv_avatar_small)
    ImageView mAvatarSmallView;
    @BindView(R.id.iv_mine_setting)
    AppCompatImageView mSettingView;

    @BindView(R.id.iv_avatar_big)
    AppCompatImageView mAvatarBigView;
    @BindView(R.id.tv_mine_name)
    AppCompatTextView mNameView;
    @BindView(R.id.tv_mine_level)
    AppCompatTextView mLevelView;

    @BindView(R.id.tv_user_id)
    AppCompatTextView mUserIdView;
    @BindView(R.id.tv_total_points)
    AppCompatTextView mTotalPointsView;
    @BindView(R.id.tv_current_ranking)
    AppCompatTextView mCurrentRankingView;
    private SPCookieStore cookieStore;


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
        ImmersionBar.setTitleBar(getActivity(), mToolbar);
        //设置渐变监听
        mCollapsingToolbarLayout.setOnScrimsListener(this);
    }

    @Override
    protected void initData() {

        cookieStore = new SPCookieStore(getContext());

        for (int i = 0; i < cookieStore.getAllCookie().size(); i++) {
            log("SPCookieStore " + cookieStore.getAllCookie().get(i) + "");
        }

        if (cookieStore.getAllCookie().size()==0) {
            mNameView.setText("去登录");
            mTotalPointsView.setText("暂无数据");
            mCurrentRankingView.setText("暂无数据");
            mLevelView.setText("暂无数据");
            mUserIdView.setText("用户ID：暂无数据");
        } else {
            mPresenter.getUserInfo();
        }

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


    @OnClick({R.id.iv_avatar_small, R.id.tv_mine_name, R.id.iv_mine_setting, R.id.iv_avatar_big, R.id.sb_mine_integral, R.id.sb_mine_collect, R.id.sb_mine_share, R.id.sb_mine_planet, R.id.sb_mine_website})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_name:
                if (cookieStore.getAllCookie().size()==0) {
                    startActivity(LoginActivity.class);
                }
            case R.id.iv_avatar_big:
                break;
            case R.id.iv_mine_setting:
                startActivity(SettingActivity.class);
                break;
            case R.id.iv_avatar_small:
                break;
            case R.id.sb_mine_integral:
                break;
            case R.id.sb_mine_collect:
                startActivity(CollectActivity.class);
                break;
            case R.id.sb_mine_share:
                break;
            case R.id.sb_mine_planet:
                startActivity(PlanetActivity.class);
                break;
            case R.id.sb_mine_website:
                break;

        }
    }

    @Override
    public void getUserInfoSuccess(UserInfoModel data) {
        mNameView.setText(data.getUsername() + "");
        mLevelView.setText(data.getLevel() + "");
        mUserIdView.setText("用户ID：" + data.getUserId());
        mTotalPointsView.setText(data.getCoinCount() + "");
        mCurrentRankingView.setText(data.getRank() + "");
    }

    @Override
    public void getUserInfoError(String msg) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refresh(RefreshBus refreshBus) {
       initData();
    }
}
