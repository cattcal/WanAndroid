package cn.hujw.wanandroid.module.system.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.module.system.activity.SystemArticleActivity;
import cn.hujw.wanandroid.module.system.adapter.SystemAdapter;
import cn.hujw.wanandroid.module.system.mvp.contract.SystemContract;
import cn.hujw.wanandroid.module.system.mvp.modle.SystemModel;
import cn.hujw.wanandroid.module.system.mvp.presenter.SystemPresenter;

/**
 * @author: hujw
 * @date: 2019/8/11
 * @description: 体系页面
 * @email: hujw_android@163.com
 */
public class SystemFragment extends MvpLazyFragment implements SystemContract.View, SystemAdapter.OnItemClick {

    @MvpInject
    SystemPresenter mPresenter;

    @BindView(R.id.rv_system)
    RecyclerView mRecyclerView;

    private SystemAdapter mAdapter;


    public static SystemFragment newInstance() {
        return new SystemFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_system;
    }

    @Override
    protected void initView() {
        mAdapter = new SystemAdapter(getContext());
        mAdapter.setmOnItemClick(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    protected void initData() {
        onLoading();
        loadData();
    }

    private void loadData() {

        mPresenter.getSystem();
    }


    @Override
    public void getSystemSuccess(List<SystemModel> data) {
        if (data != null || data.size() > 0) {
            onComplete();
            mAdapter.setData(data);
            mAdapter.notifyDataSetChanged();
        } else {
            onEmpty();
        }
    }

    @Override
    public void getSystemError(String msg) {
        onError();
    }


    @Override
    public void onItemClick(View view, int position, int tag) {

        SystemModel systemModel = mAdapter.getData().get(position);
        SystemModel.ChildrenBean childrenBean = systemModel.getChildren().get(tag);
        SystemArticleActivity.start(getContext(),
                childrenBean.getId() + "",
                systemModel.getName()+" — "+childrenBean.getName());

    }
}
