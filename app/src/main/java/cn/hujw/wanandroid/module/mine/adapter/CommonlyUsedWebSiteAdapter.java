package cn.hujw.wanandroid.module.mine.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.mine.mvp.modle.CommonlyUsedWebSiteModel;

public class CommonlyUsedWebSiteAdapter extends BaseQuickAdapter<CommonlyUsedWebSiteModel, BaseViewHolder> {
    public CommonlyUsedWebSiteAdapter( @Nullable List<CommonlyUsedWebSiteModel> data) {
        super(R.layout.item_system_children, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CommonlyUsedWebSiteModel item) {
        helper.setText(R.id.item_tv_children_name,item.getName());
    }
}
