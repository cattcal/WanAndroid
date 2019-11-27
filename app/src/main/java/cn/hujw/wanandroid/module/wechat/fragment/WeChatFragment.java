package cn.hujw.wanandroid.module.wechat.fragment;

import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.List;

import butterknife.BindView;
import cn.hujw.base.BaseFragmentStateAdapter;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.module.wechat.mvp.contract.WeChatContract;
import cn.hujw.wanandroid.module.wechat.mvp.modle.WeChatTabModel;
import cn.hujw.wanandroid.module.wechat.mvp.presenter.WeChatPresenter;

/**
 * @author: hujw
 * @date: 2019/8/11
 * @description: 公众号页面
 * @email: hujw_android@163.com
 */
public class WeChatFragment extends MvpLazyFragment implements WeChatContract.View {

    @MvpInject
    WeChatPresenter mPresenter;

    @BindView(R.id.stl_wechat)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.vp_wechat)
    ViewPager mViewPager;



    private BaseFragmentStateAdapter<WeChatTabModel, WeChatArticleFragment> mAdapter;
    private List<WeChatTabModel> mData;


    public static WeChatFragment newInstance() {
        return new WeChatFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {
        mAdapter = new BaseFragmentStateAdapter<>(
                getChildFragmentManager(),
                new BaseFragmentStateAdapter.FragmentCreator<WeChatTabModel, WeChatArticleFragment>() {
            @Override
            public WeChatArticleFragment create(WeChatTabModel data, int pos) {
                return WeChatArticleFragment.newInstance(data, pos);
            }

            @Override
            public String getTitle(WeChatTabModel data) {
                return data.getName();
            }
        });
        mViewPager.setAdapter(mAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);

    }

    @Override
    protected void initData() {
        onLoading();
        mPresenter.getWeChatTab();
    }

    @Override
    public void getWeChatTabSuccess(List<WeChatTabModel> data) {
        onComplete();
        this.mData = data;
        mAdapter.setDataList(mData);
        mSlidingTabLayout.notifyDataSetChanged();
    }

    @Override
    public void getWeChatTabError(String msg) {
        onError();
    }
}
