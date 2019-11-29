package cn.hujw.wanandroid.module.home.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public class ArticleAdapter extends BaseQuickAdapter<ArticleModel.DatasBean, BaseViewHolder> {



    public ArticleAdapter(@Nullable List<ArticleModel.DatasBean> data) {
        super(R.layout.item_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ArticleModel.DatasBean item) {

        helper.setText(R.id.item_tv_share_user, !item.getShareUser().equals("") ? item.getShareUser() : item.getAuthor())
                .setText(R.id.item_tv_nice_share_date, item.getNiceShareDate())
                .setText(R.id.item_tv_title, item.getTitle())
                .setText(R.id.item_tv_chapter_name, item.getSuperChapterName() + "·" + item.getChapterName())
                .addOnClickListener(R.id.item_cb_collect);

        if (item.isCollect()) {
            helper.setChecked(R.id.item_cb_collect, true);
        } else {
            helper.setChecked(R.id.item_cb_collect, false);
        }
    }




}
