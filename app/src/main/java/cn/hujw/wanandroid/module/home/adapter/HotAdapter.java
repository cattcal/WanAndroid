package cn.hujw.wanandroid.module.home.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.home.mvp.modle.HotModel;
import cn.hujw.wanandroid.utils.DarkThemeUtils;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class HotAdapter extends BaseQuickAdapter<HotModel, BaseViewHolder> {

    private Context mContext;

    public HotAdapter(Context context, @Nullable List<HotModel> data) {
        super(R.layout.item_system_children, data);

        this.mContext = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HotModel item) {
        helper.setText(R.id.item_tv_children_name, item.getName())
                .setBackgroundRes(R.id.item_tv_children_name, DarkThemeUtils.isDarkTheme(mContext) ? R.drawable.selector_button_night :
                        R.drawable.selector_button);
    }

}
