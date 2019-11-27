package cn.hujw.wanandroid.http;

import com.allen.library.bean.BaseData;

import java.util.List;

import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.module.home.mvp.modle.BannerModel;
import cn.hujw.wanandroid.module.home.mvp.modle.HotModel;
import cn.hujw.wanandroid.module.home.mvp.modle.NavigationModel;
import cn.hujw.wanandroid.module.login.mvp.model.UserLoginModel;
import cn.hujw.wanandroid.module.login.mvp.model.UserRegisterModel;
import cn.hujw.wanandroid.module.mine.mvp.modle.CollectArticleModel;
import cn.hujw.wanandroid.module.mine.mvp.modle.MineIntegralModel;
import cn.hujw.wanandroid.module.mine.mvp.modle.LeaderboardModel;
import cn.hujw.wanandroid.module.mine.mvp.modle.PlanetModel;
import cn.hujw.wanandroid.module.mine.mvp.modle.UserInfoModel;
import cn.hujw.wanandroid.module.mine.mvp.modle.UserLogoutModel;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectArticleModel;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectTabModel;
import cn.hujw.wanandroid.module.home.mvp.modle.SearchArticleModel;
import cn.hujw.wanandroid.module.wechat.mvp.modle.WeChatArticleModel;
import cn.hujw.wanandroid.module.wechat.mvp.modle.WeChatTabModel;
import cn.hujw.wanandroid.module.system.mvp.modle.SystemArticleModel;
import cn.hujw.wanandroid.module.system.mvp.modle.SystemModel;
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
     * 用户登录
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseData<UserLoginModel>> userLogin(@Field("username") String username, @Field("password") String password);

    /**
     * 用户注册
     */
    @FormUrlEncoded
    @POST("user/register")
    Observable<BaseData<UserRegisterModel>> userRegister(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);


    /**
     * 退出
     */
    @GET("user/logout/json")
    Observable<BaseData<UserLogoutModel>> userLogout();

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

    /**
     * 热门搜索
     *
     * @return
     */
    @GET("/hotkey/json")
    Observable<BaseData<List<HotModel>>> getHot();

    /**
     * 搜索文章
     */
    @FormUrlEncoded
    @POST("article/query/{num}/json")
    Observable<BaseData<SearchArticleModel>> getSearchArticle(@Path("num") int num, @Field("k") String search);

    /**
     * 广场即玩转星球
     */
    @GET("user_article/list/{num}/json")
    Observable<BaseData<PlanetModel>> getPlanet(@Path("num") int num);


    /**
     * 积分排行榜
     */
    @GET("coin/rank/{num}/json")
    Observable<BaseData<LeaderboardModel>> getLeaderboard(@Path("num") int num);

    /**
     * 获取个人信息
     */
    @GET("lg/coin/userinfo/json")
    Observable<BaseData<UserInfoModel>> getUserInfo();

    /**
     * 收藏文章列表
     */
    @GET("lg/collect/list/{num}/json")
    Observable<BaseData<CollectArticleModel>> getCollectArticle(@Path("num") int num);

    @GET("/lg/coin/list/{num}/json")
    Observable<BaseData<MineIntegralModel>> getMineIntegral(@Path("num") int num);
}
