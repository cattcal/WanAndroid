package cn.hujw.wanandroid.module.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.mine.adapter.MineIntegralAdapter;
import cn.hujw.wanandroid.module.mine.mvp.contract.MineIntegralContract;
import cn.hujw.wanandroid.module.mine.mvp.modle.MineIntegralModel;
import cn.hujw.wanandroid.module.mine.mvp.presenter.MineIntegralPresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class MineIntegralActivity extends MvpActivity implements MineIntegralContract.View {

    @MvpInject
    MineIntegralPresenter mPresenter;

    @BindView(R.id.tv_mine_points)
    AppCompatTextView mPointsView;

    @BindView(R.id.stl_mine_integral)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_mine_integral)
    RecyclerView mRecyclerView;

    private MineIntegralAdapter mAdapter;

    private int mCurrentPage;


    private String points;

    public static void start(Context context, String points) {
        if (points == null || "".equals(points)) {
            return;
        }
        Intent intent = new Intent(context, MineIntegralActivity.class);
        intent.putExtra("points", points);
        context.startActivity(intent);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_integral;
    }

    @Override
    protected void initView() {
        points = getIntent().getStringExtra("points");
        mPointsView.setText(points);

        mAdapter=new MineIntegralAdapter(getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);


        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadData();
                refreshLayout.finishRefresh();
            }
        });

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mCurrentPage++;
                mPresenter.getMineIntegral(mCurrentPage);
                refreshLayout.finishLoadMore();
            }
        });

    }

    @Override
    protected void initData() {
        loadData();
    }


    private void loadData() {
        mAdapter.clearData();
        mCurrentPage=1;
        mPresenter.getMineIntegral(mCurrentPage);
    }


    @OnClick(R.id.tv_points_rule)
    public void onClick() {
        WebActivity.start(getContext(),"https://www.wanandroid.com/blog/show/2653");
    }

    @Override
    public void getMineIntegralSuccess(MineIntegralModel data) {
        if (data.getTotal()!=0){
            mAdapter.addData(data.getDatas());
        }else{
            onEmpty();
        }
    }

    @Override
    public void getMineIntegralError(String msg) {
        onError();
    }
}
