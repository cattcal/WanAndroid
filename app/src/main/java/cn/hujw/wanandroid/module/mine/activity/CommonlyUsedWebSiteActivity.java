package cn.hujw.wanandroid.module.mine.activity;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.hujw.titlebar.library.TitleBar;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.mine.adapter.CommonlyUsedWebSiteAdapter;
import cn.hujw.wanandroid.module.mine.mvp.contract.CommonlyUsedWebSiteContract;
import cn.hujw.wanandroid.module.mine.mvp.modle.CommonlyUsedWebSiteModel;
import cn.hujw.wanandroid.module.mine.mvp.presenter.CommonlyUsedWebSitePresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;

/**
 * 常用网站
 */
public class CommonlyUsedWebSiteActivity extends MvpActivity implements CommonlyUsedWebSiteContract.View {

    @MvpInject
    CommonlyUsedWebSitePresenter mPresenter;
    @BindView(R.id.tb_commonly_used_web_site)
    TitleBar mTitle;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private List<CommonlyUsedWebSiteModel> mData = new ArrayList<>();

    private CommonlyUsedWebSiteAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commonly_used_web_site;
    }

    @Override
    protected void initView() {
        mAdapter = new CommonlyUsedWebSiteAdapter(mData);
        FlexboxLayoutManager manager = new FlexboxLayoutManager(getContext(), FlexDirection.ROW, FlexWrap.WRAP);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener((adapter, view, position) -> WebActivity.start(getContext(), mAdapter.getData().get(position).getLink()));
    }

    @Override
    protected void initData() {
        mPresenter.getCommonlyUsedWebSite();
    }

    @Override
    public void getCommonlyUsedWebSiteSuccess(List<CommonlyUsedWebSiteModel> data) {
        this.mData = data;
        mAdapter.addData(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCommonlyUsedWebSiteError(String msg) {

    }
}
