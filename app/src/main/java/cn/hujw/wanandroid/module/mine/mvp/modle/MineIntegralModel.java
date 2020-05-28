package cn.hujw.wanandroid.module.mine.mvp.modle;

import cn.hujw.rxhttp.interceptor.Transformer;
import cn.hujw.rxhttp.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.module.mine.mvp.listener.MineIntegralOnListener;
import cn.hujw.wanandroid.mvp.MvpModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class MineIntegralModel extends MvpModel<MineIntegralOnListener> {


    /**
     * curPage : 1
     * datas : [{"coinCount":12,"date":1574807482000,"desc":"2019-11-27 06:31:22 签到 , 积分：10 + 2","id":102161,"reason":"签到","type":1,"userId":20690,"userName":"huxiaoniu"},{"coinCount":10,"date":1574771812000,"desc":"2019-11-26 20:36:52 分享文章 , 积分：10 + 0","id":102059,"reason":"分享文章","type":3,"userId":20690,"userName":"huxiaoniu"},{"coinCount":11,"date":1574730603000,"desc":"2019-11-26 09:10:03 签到 , 积分：10 + 1","id":101527,"reason":"签到","type":1,"userId":20690,"userName":"huxiaoniu"},{"coinCount":10,"date":1574666319000,"desc":"2019-11-25 15:18:39 签到 , 积分：10 + 0","id":101102,"reason":"签到","type":1,"userId":20690,"userName":"huxiaoniu"}]
     * offset : 0
     * over : true
     * pageCount : 1
     * size : 20
     * total : 4
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public void getMineIntegral(int num) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getMineIntegral(num)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<MineIntegralModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().ontMineIntegralFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(MineIntegralModel data) {
                        getListener().onMineIntegralSucceed(data);
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
         * coinCount : 12
         * date : 1574807482000
         * desc : 2019-11-27 06:31:22 签到 , 积分：10 + 2
         * id : 102161
         * reason : 签到
         * type : 1
         * userId : 20690
         * userName : huxiaoniu
         */

        private int coinCount;
        private long date;
        private String desc;
        private int id;
        private String reason;
        private int type;
        private int userId;
        private String userName;

        public int getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(int coinCount) {
            this.coinCount = coinCount;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
