package cn.hujw.wanandroid.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.image.ImageLoader;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.ui.mvp.model.FuliModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/3 0003
 */
public class FuliAdapter extends BaseQuickAdapter<FuliModel.ResultsBean, BaseViewHolder> {

    public FuliAdapter(@Nullable List<FuliModel.ResultsBean> data) {
        super(R.layout.item_fuli, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, FuliModel.ResultsBean item) {
        ImageLoader.with(mContext).load(item.getUrl()).into(helper.itemView.findViewById(R.id.item_iv_fuli));
    }
}
