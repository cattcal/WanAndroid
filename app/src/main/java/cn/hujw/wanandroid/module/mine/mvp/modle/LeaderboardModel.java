package cn.hujw.wanandroid.module.mine.mvp.modle;

import cn.hujw.rxhttp.interceptor.Transformer;
import cn.hujw.rxhttp.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.module.mine.mvp.listener.LeaderboardOnListener;
import cn.hujw.wanandroid.mvp.MvpModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class LeaderboardModel extends MvpModel<LeaderboardOnListener> {

    /**
     * curPage : 1
     * datas : [{"coinCount":4133,"level":42,"rank":1,"userId":20382,"username":"g**eii"},{"coinCount":4032,"level":41,"rank":2,"userId":27535,"username":"1**08491840"},{"coinCount":3662,"level":37,"rank":3,"userId":3559,"username":"A**ilEyon"},{"coinCount":3206,"level":33,"rank":4,"userId":1260,"username":"于**家的吴蜀黍"},{"coinCount":2753,"level":28,"rank":5,"userId":1534,"username":"j**gbin"},{"coinCount":2742,"level":28,"rank":6,"userId":9621,"username":"S**24n"},{"coinCount":2675,"level":27,"rank":7,"userId":2,"username":"x**oyang"},{"coinCount":2669,"level":27,"rank":8,"userId":2068,"username":"i**Cola"},{"coinCount":2638,"level":27,"rank":9,"userId":863,"username":"m**qitian"},{"coinCount":2633,"level":27,"rank":10,"userId":833,"username":"w**lwaywang6"},{"coinCount":2596,"level":26,"rank":11,"userId":28694,"username":"c**ng0218"},{"coinCount":2574,"level":26,"rank":12,"userId":15603,"username":"r**eryxx"},{"coinCount":2568,"level":26,"rank":13,"userId":7710,"username":"i**Cola7"},{"coinCount":2563,"level":26,"rank":14,"userId":1871,"username":"l**shifu"},{"coinCount":2552,"level":26,"rank":15,"userId":3753,"username":"S**phenCurry"},{"coinCount":2552,"level":26,"rank":16,"userId":23244,"username":"a**ian"},{"coinCount":2545,"level":26,"rank":17,"userId":7809,"username":"1**23822235"},{"coinCount":2542,"level":26,"rank":18,"userId":1440,"username":"w**.wanandroid.com"},{"coinCount":2541,"level":26,"rank":19,"userId":7541,"username":"l**64301766"},{"coinCount":2527,"level":26,"rank":20,"userId":7590,"username":"陈**啦啦啦"},{"coinCount":2517,"level":26,"rank":21,"userId":10010,"username":"c**01220122"},{"coinCount":2493,"level":25,"rank":22,"userId":27596,"username":"1**5915093@qq.com"},{"coinCount":2487,"level":25,"rank":23,"userId":24177,"username":"l**大白菜"},{"coinCount":2470,"level":25,"rank":24,"userId":6142,"username":"c**huah"},{"coinCount":2469,"level":25,"rank":25,"userId":28454,"username":"c**xzxzc"},{"coinCount":2448,"level":25,"rank":26,"userId":22832,"username":"7**502274@qq.com"},{"coinCount":2427,"level":25,"rank":27,"userId":27602,"username":"l**hehan"},{"coinCount":2411,"level":25,"rank":28,"userId":2199,"username":"M**459"},{"coinCount":2407,"level":25,"rank":29,"userId":25793,"username":"F**_2014"},{"coinCount":2407,"level":25,"rank":30,"userId":14032,"username":"M**eor"}]
     * offset : 0
     * over : false
     * pageCount : 349
     * size : 30
     * total : 10443
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;


    public void getLeaderboard(int num) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getLeaderboard(num)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<LeaderboardModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().ontLeaderboardFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(LeaderboardModel data) {
                        getListener().onLeaderboardSucceed(data);
                    }
                });
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * coinCount : 4133
         * level : 42
         * rank : 1
         * userId : 20382
         * username : g**eii
         */

        private int coinCount;
        private int level;
        private int rank;
        private int userId;
        private String username;

        public int getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(int coinCount) {
            this.coinCount = coinCount;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
