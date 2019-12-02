package cn.hujw.wanandroid.module.project.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.hujw.image.ImageLoader;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class ProjectArticleAdapter extends BaseQuickAdapter<ProjectArticleModel.DatasBean, BaseViewHolder> {



    public ProjectArticleAdapter( @Nullable List<ProjectArticleModel.DatasBean> data) {
        super(R.layout.item_pic_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ProjectArticleModel.DatasBean item) {
        helper.setText(R.id.item_tv_share_user, !item.getShareUser().equals("") ? item.getShareUser() : item.getAuthor())
                .setText(R.id.item_tv_nice_share_date, item.getNiceShareDate())
                .setText(R.id.item_tv_title, item.getTitle())
                .setText(R.id.item_tv_desc, "\t\t\t\t"+item.getDesc())
                .setText(R.id.item_tv_chapter_name, item.getSuperChapterName() + "·" + item.getChapterName())
                .addOnClickListener(R.id.item_cb_collect)
                .setChecked(R.id.item_cb_collect, item.isCollect());
        ImageLoader.with(mContext).load(item.getEnvelopePic()).into(helper.itemView.findViewById(R.id.item_iv_pic));
    }

}
