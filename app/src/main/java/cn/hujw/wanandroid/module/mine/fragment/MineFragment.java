package cn.hujw.wanandroid.module.mine.fragment;

import android.util.Log;
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

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hujw.image.ImageLoader;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyApplication;
import cn.hujw.wanandroid.eventbus.RefreshBus;
import cn.hujw.wanandroid.helper.UserInfoManager;
import cn.hujw.wanandroid.module.login.activity.LoginActivity;
import cn.hujw.wanandroid.module.login.mvp.model.UserLoginModel;
import cn.hujw.wanandroid.module.mine.activity.CollectActivity;
import cn.hujw.wanandroid.module.mine.activity.CommonlyUsedWebSiteActivity;
import cn.hujw.wanandroid.module.mine.activity.FuliActivity;
import cn.hujw.wanandroid.module.mine.activity.LeaderboardActivity;
import cn.hujw.wanandroid.module.mine.activity.MineIntegralActivity;
import cn.hujw.wanandroid.module.mine.activity.MineShareActivity;
import cn.hujw.wanandroid.module.mine.activity.PlanetActivity;
import cn.hujw.wanandroid.module.mine.activity.SettingActivity;
import cn.hujw.wanandroid.module.mine.mvp.contract.MineContract;
import cn.hujw.wanandroid.module.mine.mvp.modle.UserInfoModel;
import cn.hujw.wanandroid.module.mine.mvp.presenter.MinePresenter;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.ui.activity.PhotoActivity;
import cn.hujw.wanandroid.utils.SPUtils;
import cn.hujw.wanandroid.utils.UserManager;
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
    private UserInfoModel data;


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


        if (UserManager.getInstance().isLogin()) {

            String avatar = SPUtils.getInstance().get("user_avatar", "");
            if (avatar != "") {
                ImageLoader.with(this).load(avatar).into(mAvatarSmallView);
                ImageLoader.with(this).load(avatar).into(mAvatarBigView);
            } else {
                ImageLoader.with(this).load(R.drawable.ico_avatar_default).into(mAvatarSmallView);
                ImageLoader.with(this).load(R.drawable.ico_avatar_default).into(mAvatarBigView);
            }
            data = UserInfoManager.getInstance().getUserInfo();

            if (data != null) {
                mNameView.setText(data.getUsername() + "");
                mUserIdView.setText("用户ID：" + data.getUserId());
                mLevelView.setText("等级\n" + data.getLevel());
                mTotalPointsView.setText("我的积分\n" + data.getCoinCount());
                mCurrentRankingView.setText("当前排名\n" + data.getRank());
            } else {
                mPresenter.getUserInfo();
            }

        } else {
            ImageLoader.with(this).load(R.drawable.ico_avatar_default).into(mAvatarSmallView);
            ImageLoader.with(this).load(R.drawable.ico_avatar_default).into(mAvatarBigView);
            mNameView.setText("去登录");
            mUserIdView.setText("用户ID：暂无数据");
            mLevelView.setText("等级\n暂无数据");
            mTotalPointsView.setText("总积分\n暂无数据");
            mCurrentRankingView.setText("当前排名\n暂无数据");

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


    @OnClick({R.id.iv_avatar_small,
            R.id.iv_mine_setting,
            R.id.tv_mine_name,
            R.id.tv_total_points,
            R.id.tv_current_ranking,
            R.id.iv_avatar_big,
            R.id.sb_mine_collect,
            R.id.sb_mine_share,
            R.id.sb_mine_planet,
            R.id.sb_mine_website,
            R.id.sb_mine_fuli})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_name:

                if (UserManager.getInstance().doIfLogin(getAttachActivity())) {
                }
            case R.id.iv_avatar_big:
                if (UserManager.getInstance().doIfLogin(getAttachActivity())) {
                    //选择头像
                    chooseAvatar();
                }
                break;
            case R.id.iv_mine_setting:
                startActivity(SettingActivity.class);
                break;
            case R.id.iv_avatar_small:
                if (UserManager.getInstance().doIfLogin(getAttachActivity())) {
                    startActivity(LoginActivity.class);
                }

                break;
            case R.id.tv_total_points:
                if (UserManager.getInstance().doIfLogin(getAttachActivity())) {
                    MineIntegralActivity.start(getContext(), data.getCoinCount() + "");
                }
                break;
            case R.id.tv_current_ranking:
                if (UserManager.getInstance().doIfLogin(getAttachActivity())) {
                    LeaderboardActivity.start(getContext(), data.getRank() + "", data.getUsername() + "", data.getCoinCount() + "");
                }
                break;

            case R.id.sb_mine_collect:
                startActivity(CollectActivity.class);
                break;
            case R.id.sb_mine_share:
                if (UserManager.getInstance().doIfLogin(getAttachActivity())) {
                    startActivity(MineShareActivity.class);
                }
                break;
            case R.id.sb_mine_planet:
                startActivity(PlanetActivity.class);
                break;
            case R.id.sb_mine_website:
                startActivity(CommonlyUsedWebSiteActivity.class);
                break;

            case R.id.sb_mine_fuli:
                startActivity(FuliActivity.class);
                break;
        }
    }

    /**
     * 选择头像
     */
    private void chooseAvatar() {
        PhotoActivity.start(getAttachActivity(), new PhotoActivity.OnPhotoSelectListener() {
            @Override
            public void onSelect(List<String> data) {

                SPUtils.getInstance().save("user_avatar", data.get(0));

                ImageLoader.with(getAttachActivity())
                        .load(data.get(0))
                        .into(mAvatarSmallView);
                ImageLoader.with(getAttachActivity())
                        .load(data.get(0))
                        .into(mAvatarBigView);
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @Override
    public void getUserInfoSuccess(UserInfoModel data) {
        this.data = data;
        mNameView.setText(data.getUsername() + "");
        mUserIdView.setText("用户ID：" + data.getUserId());
        mLevelView.setText("等级\n" + data.getLevel());
        mTotalPointsView.setText("我的积分\n" + data.getCoinCount());
        mCurrentRankingView.setText("当前排名\n" + data.getRank());

        UserInfoManager.getInstance().setUserInfo(data);

    }

    @Override
    public void getUserInfoError(String msg) {
        toast(msg);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refresh(RefreshBus refreshBus) {
        initData();
    }
}
