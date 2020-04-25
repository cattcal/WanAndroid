package cn.hujw.wanandroid.module.system.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;
import cn.hujw.wanandroid.module.system.mvp.modle.SystemModel;
import cn.hujw.wanandroid.utils.DarkThemeUtils;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public final class SystemChildrenAdapter extends MyRecyclerViewAdapter<SystemModel.ChildrenBean> {


    public SystemChildrenAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }


    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.item_tv_children_name)
        AppCompatTextView mNameView;

        public ViewHolder() {
            super(R.layout.item_system_children);
        }

        @Override
        public void onBindView(int position) {

            if (DarkThemeUtils.isDarkTheme(getContext())) {
                mNameView.setBackground(getResources().getDrawable(R.drawable.selector_button_night));
                mNameView.setTextColor(getResources().getColor(R.color.white75));
            }else{
                mNameView.setBackground(getResources().getDrawable(R.drawable.selector_button));
                mNameView.setTextColor(getResources().getColor(R.color.white75));
            }
            mNameView.setText(getItem(position).getName());
        }
    }
}
