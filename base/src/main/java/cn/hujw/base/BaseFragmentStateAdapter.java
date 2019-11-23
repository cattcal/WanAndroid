package cn.hujw.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class BaseFragmentStateAdapter<E, F extends Fragment> extends FragmentStatePagerAdapter {

    private final FragmentCreator<E, F> mCreator;

    private List<E> mDataList = null;


    public BaseFragmentStateAdapter(FragmentManager fm, FragmentCreator<E, F> creator) {
        super(fm);
        mCreator = creator;
    }

    public List<E> getDataList() {
        return mDataList;
    }

    public void setDataList(List<E> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mCreator.create(mDataList.get(position), position);
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mCreator.getTitle(mDataList.get(position));
    }

    public interface FragmentCreator<E, F> {
        F create(E data, int pos);

        String getTitle(E data);
    }

}
