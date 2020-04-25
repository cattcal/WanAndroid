package cn.hujw.wanandroid.module.home.adapter;

import android.text.Html;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.home.mvp.modle.SearchArticleModel;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class SearchArticleAdapter extends BaseQuickAdapter<SearchArticleModel.DatasBean, BaseViewHolder> {


    public SearchArticleAdapter(@Nullable List<SearchArticleModel.DatasBean> data) {
        super(R.layout.item_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SearchArticleModel.DatasBean item) {
        helper.setText(R.id.item_tv_share_user, !item.getShareUser().equals("") ? item.getShareUser() : item.getAuthor())
                .setText(R.id.item_tv_nice_share_date, item.getNiceShareDate())
                .setText(R.id.item_tv_title, Html.fromHtml(item.getTitle()))
                .addOnClickListener(R.id.item_cb_collect)
                .setImageResource(R.id.item_cb_collect, item.isCollect() ? R.drawable.ico_collect : R.drawable.ico_collect_normal);
    }

}
