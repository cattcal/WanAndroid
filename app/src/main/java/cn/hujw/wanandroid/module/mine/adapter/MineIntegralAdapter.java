package cn.hujw.wanandroid.module.mine.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;
import cn.hujw.wanandroid.utils.TimeUtils;
import cn.hujw.wanandroid.module.mine.mvp.modle.MineIntegralModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class MineIntegralAdapter extends MyRecyclerViewAdapter<MineIntegralModel.DatasBean> {

    public MineIntegralAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }


    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.tv_item_integral_desc)
        AppCompatTextView mDescView;
        @BindView(R.id.tv_item_integral)
        AppCompatTextView mIntegral;
        @BindView(R.id.tv_item_integral_date)
        AppCompatTextView mDateView;


        public ViewHolder() {
            super(R.layout.item_integral);
        }

        @Override
        public void onBindView(int position) {
            mDescView.setText(getItem(position).getReason());
            mDateView.setText(TimeUtils.millis2String(getItem(position).getDate()));
            mIntegral.setText("+ " + getItem(position).getCoinCount());
        }
    }
}
