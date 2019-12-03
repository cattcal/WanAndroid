package cn.hujw.wanandroid.http;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/3 0003
 */
public interface GankApi {

    @GET("api/data/福利/{count}/{page}")
    Observable<String> getFuli(@Path("count")int count,@Path("page")int page);
}
