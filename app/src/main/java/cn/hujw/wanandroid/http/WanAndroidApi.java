package cn.hujw.wanandroid.http;

import com.allen.library.bean.BaseData;

import java.util.List;

import cn.hujw.wanandroid.model.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.model.home.mvp.modle.BannerModel;
import cn.hujw.wanandroid.model.home.mvp.modle.HotModel;
import cn.hujw.wanandroid.model.home.mvp.modle.NavigationModel;
import cn.hujw.wanandroid.model.login.mvp.model.UserInfoModel;
import cn.hujw.wanandroid.model.project.mvp.modle.ProjectArticleModel;
import cn.hujw.wanandroid.model.project.mvp.modle.ProjectTabModel;
import cn.hujw.wanandroid.model.home.mvp.modle.SearchArticleModel;
import cn.hujw.wanandroid.model.wechat.mvp.modle.WeChatArticleModel;
import cn.hujw.wanandroid.model.wechat.mvp.modle.WeChatTabModel;
import cn.hujw.wanandroid.model.system.mvp.modle.SystemArticleModel;
import cn.hujw.wanandroid.model.system.mvp.modle.SystemModel;
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

    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseData<UserInfoModel>> userLogin(@Field("username") String username, @Field("password") String password);

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
