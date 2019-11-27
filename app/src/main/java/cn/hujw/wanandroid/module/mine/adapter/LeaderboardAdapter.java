package cn.hujw.wanandroid.module.mine.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;
import cn.hujw.wanandroid.module.mine.mvp.modle.LeaderboardModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class LeaderboardAdapter extends MyRecyclerViewAdapter<LeaderboardModel.DatasBean> {

    public LeaderboardAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }


    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.iv_item_rank)
        AppCompatImageView mRankImgView;
        @BindView(R.id.tv_item_rank)
        AppCompatTextView mRankView;
        @BindView(R.id.tv_item_name)
        AppCompatTextView mNameView;
        @BindView(R.id.tv_item_integral)
        AppCompatTextView mIntegralView;

        public ViewHolder() {
            super(R.layout.item_leaderboard);
        }

        @Override
        public void onBindView(int position) {

            String rank = getItem(position).getRank() + "";


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
            mNameView.setText(getItem(position).getUsername() + "");
            mIntegralView.setText(getItem(position).getCoinCount() + "");

        }
    }
}
