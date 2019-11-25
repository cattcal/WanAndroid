package cn.hujw.wanandroid.model.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;
import cn.hujw.wanandroid.model.home.mvp.modle.NavigationModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class NavigationTabAdapter extends MyRecyclerViewAdapter<NavigationModel> {

    private int selectPosition;

    public NavigationTabAdapter(Context context) {
        super(context);
    }

    public void setSelectPosition(int position) {
        selectPosition = position;
        notifyDataSetChanged();//更新view，否则点击背景不换
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.item_ll_tab)
        LinearLayout mTabLayout;
        @BindView(R.id.item_tv_tab)
        AppCompatTextView mTabView;
        @BindView(R.id.item_tv_name)
        AppCompatTextView mNameView;

        public ViewHolder() {
            super(R.layout.item_navigation_tab);
        }

        @Override
        public void onBindView(int position) {
            mNameView.setText(getItem(position).getName());

            if (position == selectPosition) {
                mTabLayout.setBackgroundColor(Color.WHITE);
                mTabView.setVisibility(View.VISIBLE);
            } else {
                mTabLayout.setBackgroundColor(Color.TRANSPARENT);
                mTabView.setVisibility(View.INVISIBLE);
            }
        }
    }
}
