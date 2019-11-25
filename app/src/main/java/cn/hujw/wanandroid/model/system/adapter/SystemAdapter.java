package cn.hujw.wanandroid.model.system.adapter;

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
import cn.hujw.wanandroid.model.system.mvp.modle.SystemModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public final class SystemAdapter extends MyRecyclerViewAdapter<SystemModel> {


    public SystemAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.item_tv_name)
        AppCompatTextView mShareUserView;
        @BindView(R.id.item_rv_children)
        RecyclerView mRecyclerView;

        private SystemChildrenAdapter mAdapter;
        private List<SystemModel.ChildrenBean> mData = new ArrayList<>();

        public ViewHolder() {
            super(R.layout.item_system);
        }

        @Override
        public void onBindView(int position) {
            mShareUserView.setText(getItem(position).getName());
            if (mAdapter!=null){
                mAdapter.clearData();
            }
            mData.addAll(getItem(position).getChildren());
            mAdapter = new SystemChildrenAdapter(getContext());
            mAdapter.setData(mData);
            mAdapter.setOnItemClickListener((recyclerView, itemView, tag) -> mOnItemClick.onItemClick(itemView, position, tag));
            FlexboxLayoutManager manager  = new FlexboxLayoutManager(getContext(), FlexDirection.ROW, FlexWrap.WRAP);            mRecyclerView.setLayoutManager(manager);
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
