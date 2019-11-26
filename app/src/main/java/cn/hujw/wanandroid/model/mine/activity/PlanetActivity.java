package cn.hujw.wanandroid.model.mine.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.model.mine.adapter.PlanetAdapter;
import cn.hujw.wanandroid.model.mine.mvp.contract.PlanetContract;
import cn.hujw.wanandroid.model.mine.mvp.modle.PlanetModel;
import cn.hujw.wanandroid.model.mine.mvp.presenter.PlanetPresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class PlanetActivity extends MvpActivity implements PlanetContract.View {

    @MvpInject
    PlanetPresenter mPresenter;

    @BindView(R.id.rv_planet)
    RecyclerView mRecyclerView;
    @BindView(R.id.srl_planet)
    SmartRefreshLayout mSmartRefreshLayout;

    private PlanetAdapter mAdapter;

    private int mCurrentPage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_planet;
    }

    @Override
    protected void initView() {
        mAdapter = new PlanetAdapter(getContext());
        mAdapter.setOnItemClickListener((recyclerView, itemView, position) -> WebActivity.start(getContext(),mAdapter.getData().get(position).getLink()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);


        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            loadData();
            refreshLayout.finishRefresh();
        });

        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mCurrentPage++;
            mPresenter.getPlanet(mCurrentPage);
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    protected void initData() {
        loadData();
    }

    private void loadData() {
        mAdapter.clearData();
        mCurrentPage = 0;
        mPresenter.getPlanet(mCurrentPage);
    }

    @Override
    public void getPlanetSuccess(PlanetModel data) {
        mAdapter.addData(data.getDatas());
    }

    @Override
    public void getPlanetError(String msg) {

    }
}
