package cn.hujw.wanandroid.module.project.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class ProjectArticleAdapter extends BaseQuickAdapter<ProjectArticleModel.DatasBean, BaseViewHolder> {


    public ProjectArticleAdapter(@Nullable List<ProjectArticleModel.DatasBean> data) {
        super(R.layout.item_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ProjectArticleModel.DatasBean item) {
        helper.setText(R.id.item_tv_share_user, !item.getShareUser().equals("") ? item.getShareUser() : item.getAuthor())
                .setText(R.id.item_tv_nice_share_date, item.getNiceShareDate())
                .setText(R.id.item_tv_title, item.getTitle())
                .addOnClickListener(R.id.item_cb_collect)
                .setChecked(R.id.item_cb_collect, item.isCollect());
    }

}
