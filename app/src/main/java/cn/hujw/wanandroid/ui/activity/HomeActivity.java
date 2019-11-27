package cn.hujw.wanandroid.ui.activity;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import cn.hujw.base.BaseFragmentAdapter;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyLazyFragment;
import cn.hujw.wanandroid.helper.ActivityStackManager;
import cn.hujw.wanandroid.helper.DoubleClickHelper;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.other.KeyboardWatcher;
import cn.hujw.wanandroid.module.project.activity.ProjectFragment;
import cn.hujw.wanandroid.module.system.fragment.SystemFragment;
import cn.hujw.wanandroid.module.home.fragment.HomeFragment;
import cn.hujw.wanandroid.module.wechat.fragment.WeChatFragment;
import cn.hujw.wanandroid.module.mine.fragment.MineFragment;
import cn.hujw.widget.layout.NoScrollViewPager;

/**
 * 描述：主界面
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public class HomeActivity extends MvpActivity implements ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        KeyboardWatcher.SoftKeyboardStateListener {

    @BindView(R.id.vp_home_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.bv_home_navigation)
    BottomNavigationView mBottomNavigationView;

    /**
     * ViewPager 适配器
     */
    private BaseFragmentAdapter<MyLazyFragment> mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mViewPager.addOnPageChangeListener(this);

        // 不使用图标默认变色
        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);

        KeyboardWatcher.with(this).setListener(this);
    }

    @Override
    protected void initData() {
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(SystemFragment.newInstance());
        mPagerAdapter.addFragment(WeChatFragment.newInstance());
        mPagerAdapter.addFragment(ProjectFragment.newInstance());
        mPagerAdapter.addFragment(MineFragment.newInstance());

        mViewPager.setAdapter(mPagerAdapter);

        // 限制页面数量
        mViewPager.setOffscreenPageLimit(mViewPager.getCount());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId(R.id.home_system);
                break;
            case 2:
                mBottomNavigationView.setSelectedItemId(R.id.home_wechat);
                break;
            case 3:
                mBottomNavigationView.setSelectedItemId(R.id.home_project);
                break;
            case 4:
                mBottomNavigationView.setSelectedItemId(R.id.home_me);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSoftKeyboardOpened(int keyboardHeight) {
        mBottomNavigationView.setVisibility(View.GONE);
    }

    @Override
    public void onSoftKeyboardClosed() {
        mBottomNavigationView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                mViewPager.setCurrentItem(0);
                return true;
            case R.id.home_system:
                mViewPager.setCurrentItem(1);
                return true;
            case R.id.home_wechat:
                mViewPager.setCurrentItem(2);
                return true;
            case R.id.home_project:
                mViewPager.setCurrentItem(3);
                return true;
            case R.id.home_me:
                mViewPager.setCurrentItem(4);
                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 回调当前 Fragment 的 onKeyDown 方法
        if (mPagerAdapter.getCurrentFragment().onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (DoubleClickHelper.isOnDoubleClick()) {
            //移动到上一个任务栈，避免侧滑引起的不良反应
            moveTaskToBack(false);
            postDelayed(new Runnable() {

                @Override
                public void run() {
                    // 进行内存优化，销毁掉所有的界面
                    ActivityStackManager.getInstance().finishAllActivities();
                    // 销毁进程（请注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
                    // System.exit(0);
                }
            }, 300);
        } else {
            toast(R.string.home_exit_hint);
        }
    }

    @Override
    protected void onDestroy() {
        mViewPager.removeOnPageChangeListener(this);
        mViewPager.setAdapter(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(null);
        super.onDestroy();
    }
}

