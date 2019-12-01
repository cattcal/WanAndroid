package cn.hujw.wanandroid.module.home.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.module.home.mvp.modle.HotModel;
import cn.hujw.wanandroid.module.home.mvp.modle.SearchArticleModel;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class SearchContract {

    public interface View extends IMvpView {

        void getHotSuccess(List<HotModel> data);

        void getHotError(String msg);



        void getSearchArticleSuccess(SearchArticleModel data);

        void getSearchArticleError(String msg);

    }

    public interface Presenter {

        void getHot();

        void getSearchArticle(int num,String search);


    }
}
