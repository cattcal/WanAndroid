package cn.hujw.wanandroid.model.home.mvp.modle;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.model.home.mvp.listener.SearchOnListener;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class SearchArticleModel extends MvpModel<SearchOnListener> {


    /**
     * curPage : 1
     * datas : [{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10294,"link":"https://www.jianshu.com/p/54747753be0c","niceDate":"2019-11-15","niceShareDate":"2019-11-15","origin":"","prefix":"","projectLink":"","publishTime":1573781017000,"selfVisible":0,"shareDate":1573781017000,"shareUser":"745612618","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android <em class='highlight'>面试<\/em>准备进行曲（Android 基础知识）v1.1","type":0,"userId":8822,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10293,"link":"https://www.jianshu.com/p/7bb8a2d9a5f5","niceDate":"2019-11-15","niceShareDate":"2019-11-15","origin":"","prefix":"","projectLink":"","publishTime":1573780992000,"selfVisible":0,"shareDate":1573780992000,"shareUser":"745612618","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android <em class='highlight'>面试<\/em>准备进行曲(网络基础篇） v1.1","type":0,"userId":8822,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10292,"link":"https://www.jianshu.com/p/745e4015a918","niceDate":"2019-11-15","niceShareDate":"2019-11-15","origin":"","prefix":"","projectLink":"","publishTime":1573780964000,"selfVisible":0,"shareDate":1573780964000,"shareUser":"745612618","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android <em class='highlight'>面试<\/em>准备进行曲(Java基础篇） v1.2","type":0,"userId":8822,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10220,"link":"https://www.jianshu.com/p/fb46395f4551","niceDate":"2019-11-12","niceShareDate":"2019-11-12","origin":"","prefix":"","projectLink":"","publishTime":1573543588000,"selfVisible":0,"shareDate":1573543588000,"shareUser":"未扬帆的小船","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"<em class='highlight'>面试<\/em> - handle之看Looper详谈ThreadLocal(3)","type":0,"userId":2113,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10207,"link":"https://www.jianshu.com/p/6e66fd5fe792","niceDate":"2019-11-11","niceShareDate":"2019-11-11","origin":"","prefix":"","projectLink":"","publishTime":1573458517000,"selfVisible":0,"shareDate":1573458517000,"shareUser":"未扬帆的小船","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"<em class='highlight'>面试<\/em> - handle之详谈Message(2)","type":0,"userId":2113,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10189,"link":"https://www.jianshu.com/p/b3a95747ee91","niceDate":"2019-11-10","niceShareDate":"2019-11-10","origin":"","prefix":"","projectLink":"","publishTime":1573348334000,"selfVisible":0,"shareDate":1573348334000,"shareUser":"he-hongdan","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android<em class='highlight'>面试<\/em>官装逼失败之：Activity的启动模式 - 简书","type":0,"userId":32593,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10186,"link":"https://www.jianshu.com/p/679e40dd2d0c","niceDate":"2019-11-09","niceShareDate":"2019-11-09","origin":"","prefix":"","projectLink":"","publishTime":1573313898000,"selfVisible":0,"shareDate":1573313898000,"shareUser":"未扬帆的小船","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"<em class='highlight'>面试<\/em> - handle使用及原理(1)","type":0,"userId":2113,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10127,"link":"https://www.jianshu.com/p/a2ee832300f6?utm_source=desktop&amp;utm_medium=timeline","niceDate":"2019-11-07","niceShareDate":"2019-11-07","origin":"","prefix":"","projectLink":"","publishTime":1573063621000,"selfVisible":0,"shareDate":1573061672000,"shareUser":"鸿洋","superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"Android <em class='highlight'>面试<\/em>100题","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10093,"link":"https://juejin.im/post/5dbeda27e51d452a161e00c8","niceDate":"2019-11-05","niceShareDate":"2019-11-05","origin":"","prefix":"","projectLink":"","publishTime":1572914004000,"selfVisible":0,"shareDate":1572914004000,"shareUser":"于慢慢家的吴蜀黍","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"<em class='highlight'>面试<\/em>官：简历上最好不要写Glide，不是问源码那么简单","type":0,"userId":1260,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10045,"link":"https://juejin.im/post/5dbeda27e51d452a161e00c8#heading-21","niceDate":"2019-11-03","niceShareDate":"2019-11-03","origin":"","prefix":"","projectLink":"","publishTime":1572796216000,"selfVisible":0,"shareDate":1572792987000,"shareUser":"蓝师傅","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"<em class='highlight'>面试<\/em>官：简历上最好不要写Glide，不是问源码那么简单 ","type":0,"userId":1871,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10021,"link":"https://juejin.im/post/5db92860e51d4529ee588406","niceDate":"2019-10-31","niceShareDate":"2019-10-31","origin":"","prefix":"","projectLink":"","publishTime":1572533952000,"selfVisible":0,"shareDate":1572533509000,"shareUser":"鸿洋","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"<em class='highlight'>面试<\/em>官：&quot;准备用HashMap存1w条数据，构造时传10000还会触发扩容吗？&quot;","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10069,"link":"https://mp.weixin.qq.com/s/-GpqUPu30QnpAduB5liJzQ","niceDate":"2019-10-31","niceShareDate":"2019-11-04","origin":"","prefix":"","projectLink":"","publishTime":1572451200000,"selfVisible":0,"shareDate":1572831731000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"Android<em class='highlight'>面试<\/em>题：bindService获取代理是同步还是异步","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"承香墨影","chapterId":411,"chapterName":"承香墨影","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10063,"link":"https://mp.weixin.qq.com/s/T7e6SmO-VAN6i2XWCBNS7w","niceDate":"2019-10-29","niceShareDate":"2019-11-04","origin":"","prefix":"","projectLink":"","publishTime":1572278400000,"selfVisible":0,"shareDate":1572831544000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/411/1"}],"title":"<em class='highlight'>面试<\/em>官：&rdquo;准备用HashMap存1w条数据，构造时传10000会触发扩容吗？&ldquo;","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9954,"link":"https://juejin.im/post/5db24ead6fb9a020433f58a8","niceDate":"2019-10-26","niceShareDate":"2019-10-26","origin":"","prefix":"","projectLink":"","publishTime":1572084978000,"selfVisible":0,"shareDate":1572084978000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" 一道Java<em class='highlight'>面试<\/em>题引发的思考 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9923,"link":"https://mp.weixin.qq.com/s/N3vp91usxclib1NuGEuPgA","niceDate":"2019-10-21","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571587200000,"selfVisible":0,"shareDate":1572007835000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"<em class='highlight'>面试<\/em>官：今日头条启动很快，你觉得可能是做了哪些优化？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9837,"link":"https://juejin.im/post/5daad18e5188256b6c386292","niceDate":"2019-10-20","niceShareDate":"2019-10-20","origin":"","prefix":"","projectLink":"","publishTime":1571532221000,"selfVisible":0,"shareDate":1571532221000,"shareUser":"AprilEyon","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" <em class='highlight'>面试<\/em>必备：高频算法题汇总「图文解析 + 教学视频 + 范例代码」之 字符串处理+动态规划 合集！","type":0,"userId":3559,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9741,"link":"https://juejin.im/post/5da7ca2e5188255814057fc3","niceDate":"2019-10-18","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571329950000,"selfVisible":0,"shareDate":1571311643000,"shareUser":"_yuanhao","superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"<em class='highlight'>面试<\/em>必备：高频算法题汇总「图文解析 + 教学视频 + 范例代码」之 二叉搜索树 + 双指针 + 贪心 汇总","type":0,"userId":32103,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9735,"link":"https://juejin.im/post/5d837cd1e51d4561cb5ddf66","niceDate":"2019-10-17","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571274367000,"selfVisible":0,"shareDate":1571274367000,"shareUser":"于慢慢家的吴蜀黍","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"<em class='highlight'>面试<\/em>官又来了：你的app卡顿过吗？","type":0,"userId":1260,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9730,"link":"https://www.jianshu.com/p/ffb1cc684507?utm_source=desktop&amp;utm_medium=timeline","niceDate":"2019-10-16","niceShareDate":"2019-10-16","origin":"","prefix":"","projectLink":"","publishTime":1571236303000,"selfVisible":0,"shareDate":1571236130000,"shareUser":"鸿洋","superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"Android <em class='highlight'>面试<\/em>经验 - 大厂 OPPO 面","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9759,"link":"https://mp.weixin.qq.com/s/lq2vrbtNujtq8SDu7e6VVA","niceDate":"2019-10-16","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571155200000,"selfVisible":0,"shareDate":1571315041000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"一位求职者总结的<em class='highlight'>面试<\/em>小攻略","type":0,"userId":-1,"visible":1,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 11
     * size : 20
     * total : 208
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;


    public void getSearchArticle(int num,String search) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getSearchArticle(num,search)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<SearchArticleModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onSearchArticleFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(SearchArticleModel data) {
                        getListener().onSearchArticleSucceed(data);
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
         * apkLink :
         * audit : 1
         * author :
         * chapterId : 494
         * chapterName : 广场
         * collect : false
         * courseId : 13
         * desc :
         * envelopePic :
         * fresh : false
         * id : 10294
         * link : https://www.jianshu.com/p/54747753be0c
         * niceDate : 2019-11-15
         * niceShareDate : 2019-11-15
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1573781017000
         * selfVisible : 0
         * shareDate : 1573781017000
         * shareUser : 745612618
         * superChapterId : 494
         * superChapterName : 广场Tab
         * tags : []
         * title : Android <em class='highlight'>面试</em>准备进行曲（Android 基础知识）v1.1
         * type : 0
         * userId : 8822
         * visible : 0
         * zan : 0
         */

        private String apkLink;
        private int audit;
        private String author;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String niceShareDate;
        private String origin;
        private String prefix;
        private String projectLink;
        private long publishTime;
        private int selfVisible;
        private long shareDate;
        private String shareUser;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<?> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public int getAudit() {
            return audit;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getNiceShareDate() {
            return niceShareDate;
        }

        public void setNiceShareDate(String niceShareDate) {
            this.niceShareDate = niceShareDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSelfVisible() {
            return selfVisible;
        }

        public void setSelfVisible(int selfVisible) {
            this.selfVisible = selfVisible;
        }

        public long getShareDate() {
            return shareDate;
        }

        public void setShareDate(long shareDate) {
            this.shareDate = shareDate;
        }

        public String getShareUser() {
            return shareUser;
        }

        public void setShareUser(String shareUser) {
            this.shareUser = shareUser;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }
    }
}
