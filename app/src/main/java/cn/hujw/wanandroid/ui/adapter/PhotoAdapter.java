package cn.hujw.wanandroid.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import cn.hujw.image.ImageLoader;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyRecyclerViewAdapter;

/**
 * @author: hujw
 * @date: 2019/8/20
 * @description: 图片选择适配器
 * @email: hujw_android@163.com
 */
public final class PhotoAdapter extends MyRecyclerViewAdapter<String> {

    private final List<String> mSelectPhoto;

    public PhotoAdapter(Context context, List<String> data) {
        super(context);
        mSelectPhoto = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.iv_photo_image)
        ImageView mImageView;
        @BindView(R.id.iv_photo_check)
        CheckBox mCheckBox;

        ViewHolder() {
            super(R.layout.item_photo);
        }

        @Override
        public void onBindView(int position) {
            ImageLoader.with(getContext())
                    .load(getItem(position))
                    .into(mImageView);

            mCheckBox.setChecked(mSelectPhoto.contains(getItem(position)));
        }
    }

    @Override
    protected RecyclerView.LayoutManager getDefaultLayoutManager(Context context) {
        return new GridLayoutManager(context, 3);
    }
}