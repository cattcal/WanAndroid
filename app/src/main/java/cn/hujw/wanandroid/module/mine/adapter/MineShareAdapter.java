package cn.hujw.wanandroid.module.mine.adapter;

import android.content.Context;
import android.text.Html;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;
import cn.hujw.wanandroid.module.mine.mvp.modle.MineShareModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class MineShareAdapter extends MyRecyclerViewAdapter<MineShareModel.ShareArticlesBean.DatasBean> {

    public MineShareAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }


    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.item_tv_share_user)
        AppCompatTextView mShareUserView;
        @BindView(R.id.item_tv_nice_share_date)
        AppCompatTextView mNiceShareDateView;
        @BindView(R.id.item_tv_title)
        AppCompatTextView mTitleView;

        @BindView(R.id.item_tv_chapter_name)
        AppCompatTextView mChapterView;


        public ViewHolder() {
            super(R.layout.item_article);
        }

        @Override
        public void onBindView(int position) {
            mShareUserView.setText(!getItem(position).getShareUser().equals("") ? getItem(position).getShareUser() : getItem(position).getAuthor());
            mNiceShareDateView.setText(getItem(position).getNiceShareDate());
            mTitleView.setText(Html.fromHtml(getItem(position).getTitle()));
            mChapterView.setText(getItem(position).getChapterName());
        }
    }
}
