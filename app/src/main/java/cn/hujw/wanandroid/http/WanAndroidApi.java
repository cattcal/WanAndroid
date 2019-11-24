package cn.hujw.wanandroid.http;

import com.allen.library.bean.BaseData;

import java.util.List;

import cn.hujw.wanandroid.ui.mvp.model.ArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.BannerModel;
import cn.hujw.wanandroid.ui.mvp.model.HotModel;
import cn.hujw.wanandroid.ui.mvp.model.NavigationModel;
import cn.hujw.wanandroid.ui.mvp.model.ProjectArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.ProjectTabModel;
import cn.hujw.wanandroid.ui.mvp.model.SearchArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.WeChatArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.WeChatTabModel;
import cn.hujw.wanandroid.ui.mvp.model.SystemArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.SystemModel;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/9/23 0023
 */
public interface WanAndroidApi {
    /**
     * 获取banner数据
     */
    @GET("banner/json")
    Observable<BaseData<List<BannerModel>>> getBanner();

    /**
     * 首页文章列表
     */
    @GET("article/list/{num}/json")
    Observable<BaseData<ArticleModel>> getArticle(@Path("num") int num);

    /**
     * 体系
     **/
    @GET("tree/json")
    Observable<BaseData<List<SystemModel>>> getSystem();

    /**
     * 知识体系下的文章
     */
    @GET("article/list/{num}/json")
    Observable<BaseData<SystemArticleModel>> getSystemArticle(@Path("num") int num, @Query("cid") String cid);

    /**
     * 获取公众号
     */
    @GET("wxarticle/chapters/json")
    Observable<BaseData<List<WeChatTabModel>>> getPublicTab();

    /**
     * 获取公共好下的文章
     */
    @GET("wxarticle/list/{id}/{num}/json")
    Observable<BaseData<WeChatArticleModel>> getWeChatArticle(@Path("id") int id, @Path("num") int num);

    /**
     * 获取项目分类
     */
    @GET("project/tree/json")
    Observable<BaseData<List<ProjectTabModel>>> getProjectTab();

    /**
     * 项目列表数据
     */
    @GET("project/list/{num}/json")
    Observable<BaseData<ProjectArticleModel>> getProjectArticle(@Path("num") int num, @Query("cid") String cid);

    /**
     * 导航
     */
    @GET("navi/json")
    Observable<BaseData<List<NavigationModel>>> getNavigation();

    @GET("/hotkey/json")
    Observable<BaseData<List<HotModel>>> getHot();

    @FormUrlEncoded
    @POST("article/query/{num}/json")
    Observable<BaseData<SearchArticleModel>> getSearchArticle(@Path("num") int num, @Field("k") String search);

}
