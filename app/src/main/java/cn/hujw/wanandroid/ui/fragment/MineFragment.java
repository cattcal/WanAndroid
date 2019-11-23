package cn.hujw.wanandroid.ui.fragment;

import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyLazyFragment;
import cn.hujw.wanandroid.ui.activity.HomeActivity;

/**
 * @author: hujw
 * @date: 2019/8/11
 * @description: 项目界面跳转示例
 * @email: hujw_android@163.com
 */
public class MineFragment extends MyLazyFragment<HomeActivity> {


    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


}
