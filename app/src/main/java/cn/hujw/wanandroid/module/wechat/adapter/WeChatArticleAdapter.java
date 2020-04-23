package cn.hujw.wanandroid.module.wechat.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.wechat.mvp.modle.WeChatArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class WeChatArticleAdapter extends BaseQuickAdapter<WeChatArticleModel.DatasBean, BaseViewHolder> {


    public WeChatArticleAdapter(@Nullable List<WeChatArticleModel.DatasBean> data) {
        super(R.layout.item_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, WeChatArticleModel.DatasBean item) {
        helper.setText(R.id.item_tv_share_user, !item.getShareUser().equals("") ? item.getShareUser() : item.getAuthor())
                .setText(R.id.item_tv_nice_share_date, item.getNiceShareDate())
                .setText(R.id.item_tv_title, item.getTitle())
                .setText(R.id.item_tv_chapter_name, item.getSuperChapterName() + "·" + item.getChapterName())
                .addOnClickListener(R.id.item_cb_collect)
                .setImageResource(R.id.item_cb_collect, item.isCollect() ? R.drawable.ico_collect : R.drawable.ico_collect_normal);
    }

}
