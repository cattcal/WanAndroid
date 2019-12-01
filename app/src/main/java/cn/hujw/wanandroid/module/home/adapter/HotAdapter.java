package cn.hujw.wanandroid.module.home.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.home.mvp.modle.HotModel;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class HotAdapter extends BaseQuickAdapter<HotModel, BaseViewHolder> {


    public HotAdapter(@Nullable List<HotModel> data) {
        super(R.layout.item_system_children, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HotModel item) {
        helper.setText(R.id.item_tv_children_name, item.getName());
    }

}
