package cn.hujw.wanandroid.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;

/**
 * @author: hujw
 * @date: 2019/8/28
 * @description: 可进行拷贝的副本
 * @email: hujw_android@163.com
 */
public final class CopyAdapter extends MyRecyclerViewAdapter<String> {

    public CopyAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.item_tv_num)
        AppCompatTextView numView;

        ViewHolder() {
            super(R.layout.item_copy);
        }

        @Override
        public void onBindView(int position) {
            numView.setText(getItem(position));
        }
    }
}