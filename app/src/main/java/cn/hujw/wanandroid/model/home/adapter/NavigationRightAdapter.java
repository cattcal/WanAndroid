package cn.hujw.wanandroid.model.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

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
public class NavigationRightAdapter extends MyRecyclerViewAdapter<NavigationModel> {

    public NavigationRightAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }


    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.item_tv_name)
        AppCompatTextView mNameView;
        @BindView(R.id.item_rv_navigation_right)
        RecyclerView mRecyclerView;

        private NavigationChildrenAdapter mAdapter;

        public ViewHolder() {
            super(R.layout.item_navigation_right);
        }

        @Override
        public void onBindView(int position) {
            mNameView.setText(getItem(position).getName());

            mAdapter=new NavigationChildrenAdapter(getContext());
            List<NavigationModel.ArticlesBean> mData=new ArrayList<>();
            mData.addAll(getItem(position).getArticles());
            mAdapter.setData(mData);
            mAdapter.setOnItemClickListener((recyclerView, itemView, tag) -> mOnItemClick.onItemClick(itemView, position, tag));

            FlexboxLayoutManager manager  = new FlexboxLayoutManager(getContext(), FlexDirection.ROW, FlexWrap.WRAP);            mRecyclerView.setLayoutManager(manager);
            mRecyclerView.setLayoutManager(manager);
            mRecyclerView.setAdapter(mAdapter);
        }
    }


    private OnItemClick mOnItemClick;

    public void setmOnItemClick(OnItemClick mOnItemClick) {
        this.mOnItemClick = mOnItemClick;
    }

    public interface OnItemClick {
        void onItemClick(View view, int position, int tag);
    }
}
