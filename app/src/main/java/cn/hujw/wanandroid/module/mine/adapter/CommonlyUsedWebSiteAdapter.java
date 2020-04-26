package cn.hujw.wanandroid.module.mine.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.mine.mvp.modle.CommonlyUsedWebSiteModel;
import cn.hujw.wanandroid.utils.DarkThemeUtils;

public class CommonlyUsedWebSiteAdapter extends BaseQuickAdapter<CommonlyUsedWebSiteModel, BaseViewHolder> {

    private Context mContext;

    public CommonlyUsedWebSiteAdapter(Context context,@Nullable List<CommonlyUsedWebSiteModel> data) {
        super(R.layout.item_system_children, data);
        this.mContext = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CommonlyUsedWebSiteModel item) {
        helper.setText(R.id.item_tv_children_name, item.getName()).setBackgroundRes(R.id.item_tv_children_name, DarkThemeUtils.isDarkTheme(mContext) ? R.drawable.selector_button_night :
                R.drawable.selector_button);
    }
}
