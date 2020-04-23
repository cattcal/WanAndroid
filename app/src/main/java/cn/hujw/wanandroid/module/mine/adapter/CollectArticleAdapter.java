package cn.hujw.wanandroid.module.mine.adapter;

import android.text.Html;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.mine.mvp.modle.CollectArticleModel;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description:
 * @email: hujw_android@163.com
 */
public class CollectArticleAdapter extends BaseQuickAdapter<CollectArticleModel.DatasBean, BaseViewHolder> {


    public CollectArticleAdapter(@Nullable List<CollectArticleModel.DatasBean> data) {
        super(R.layout.item_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CollectArticleModel.DatasBean item) {
        helper.setText(R.id.item_tv_share_user, item.getAuthor())
                .setText(R.id.item_tv_nice_share_date, item.getNiceDate())
                .setText(R.id.item_tv_title, Html.fromHtml(item.getTitle()))
                .addOnClickListener(R.id.item_cb_collect)
                .setImageResource(R.id.item_cb_collect, R.drawable.ico_collect);

    }


}
