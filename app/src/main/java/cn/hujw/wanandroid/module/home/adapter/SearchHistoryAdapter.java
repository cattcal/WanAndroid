package cn.hujw.wanandroid.module.home.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.utils.DarkThemeUtils;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/2 0002
 */
public class SearchHistoryAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private Context mContext;

    public SearchHistoryAdapter(Context context, @Nullable List<String> data) {
        super(R.layout.item_system_children, data);

        this.mContext = context;

    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.item_tv_children_name, item).setBackgroundRes(R.id.item_tv_children_name, DarkThemeUtils.isDarkTheme(mContext) ? R.drawable.selector_button_night :
                R.drawable.selector_button);
    }
}
