package cn.hujw.wanandroid.module.project.fragment;

import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.List;

import butterknife.BindView;
import cn.hujw.base.BaseFragmentStateAdapter;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.module.project.mvp.contract.ProjectContract;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectTabModel;
import cn.hujw.wanandroid.module.project.mvp.presenter.ProjectPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class ProjectFragment extends MvpLazyFragment implements ProjectContract.View {

    @MvpInject
    ProjectPresenter mPresenter;

    @BindView(R.id.stl_project)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.vp_project)
    ViewPager mViewPager;

    private BaseFragmentStateAdapter<ProjectTabModel, ProjectArticleFragment> mAdapter;
    private List<ProjectTabModel> mData;

    public static ProjectFragment newInstance() {
        return new ProjectFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initView() {
        mAdapter = new BaseFragmentStateAdapter<>(
                getChildFragmentManager(),
                new BaseFragmentStateAdapter.FragmentCreator<ProjectTabModel, ProjectArticleFragment>() {
                    @Override
                    public ProjectArticleFragment create(ProjectTabModel data, int pos) {
                        return ProjectArticleFragment.newInstance(data, pos);
                    }

                    @Override
                    public String getTitle(ProjectTabModel data) {
                        return data.getName();
                    }
                });
        mViewPager.setAdapter(mAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    protected void initData() {
        onLoading();
        mPresenter.getProjectTab();
    }

    @Override
    public void getProjectTabSuccess(List<ProjectTabModel> data) {
        onComplete();
        this.mData = data;
        mAdapter.setDataList(mData);
        mSlidingTabLayout.notifyDataSetChanged();
    }

    @Override
    public void getProjectTabError(String msg) {
        onError();
    }
}
