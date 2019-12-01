package cn.hujw.wanandroid.module.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.mine.adapter.LeaderboardAdapter;
import cn.hujw.wanandroid.module.mine.mvp.contract.LeaderboardContract;
import cn.hujw.wanandroid.module.mine.mvp.modle.LeaderboardModel;
import cn.hujw.wanandroid.module.mine.mvp.presenter.LeaderboardPresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;

/**
 * 描述：积分排行榜
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class LeaderboardActivity extends MvpActivity implements LeaderboardContract.View {

    @MvpInject
    LeaderboardPresenter mPresenter;


    @BindView(R.id.iv_level)
    AppCompatImageView mRankImgView;
    @BindView(R.id.tv_level)
    AppCompatTextView mRankView;
    @BindView(R.id.tv_name)
    AppCompatTextView mNameView;
    @BindView(R.id.tv_integral)
    AppCompatTextView mIntegralView;

    @BindView(R.id.srl_leaderboard)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_leaderboard)
    RecyclerView mRecyclerView;

    private LeaderboardAdapter mAdapter;

    private int mCurrentPage = 1;

    private String rank;
    private String name;
    private String points;

    public static void start(Context context, String rank, String name, String points) {
        if (points == null || "".equals(points) || rank == null || "".equals(rank) || name == null || "".equals(name)) {
            return;
        }

        Intent intent = new Intent(context, LeaderboardActivity.class);
        intent.putExtra("rank", rank);
        intent.putExtra("name", name);
        intent.putExtra("points", points);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_leaderboard;
    }

    @Override
    protected void initView() {

        rank = getIntent().getStringExtra("rank");
        name = getIntent().getStringExtra("name");
        points = getIntent().getStringExtra("points");

        if (rank.equals("1")) {
            mRankImgView.setImageResource(R.drawable.ico_rank_1);
            mRankView.setTextColor(Color.TRANSPARENT);
        } else if (rank.equals("2")) {
            mRankImgView.setImageResource(R.drawable.ico_rank_2);
            mRankView.setTextColor(Color.TRANSPARENT);
        } else if (rank.equals("3")) {
            mRankImgView.setImageResource(R.drawable.ico_rank_3);
            mRankView.setTextColor(Color.TRANSPARENT);
        } else {
            mRankImgView.setImageResource(R.color.transparent);
            mRankView.setTextColor(ContextCompat.getColor(getContext(), R.color.textColor));
        }

        mRankView.setText(rank);
        mNameView.setText(name);
        mIntegralView.setText(points);


        mAdapter = new LeaderboardAdapter(getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);


        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            loadData();
            refreshLayout.finishRefresh();
        });

        mSmartRefreshLayout.setEnableLoadMore(false);

//        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
//            mCurrentPage++;
//            mPresenter.getLeaderboard(mCurrentPage);
//            refreshLayout.finishLoadMore();
//        });
    }

    @Override
    protected void initData() {
        loadData();
    }

    private void loadData() {
        mAdapter.clearData();
        mCurrentPage = 1;
        mPresenter.getLeaderboard(mCurrentPage);
    }

    @Override
    public void getLeaderboardSuccess(LeaderboardModel data) {
        if (data.getTotal() != 0) {
            mAdapter.addData(data.getDatas());
        } else {
            onEmpty();
        }

    }

    @Override
    public void getLeaderboardError(String msg) {
        onError();
    }
}
