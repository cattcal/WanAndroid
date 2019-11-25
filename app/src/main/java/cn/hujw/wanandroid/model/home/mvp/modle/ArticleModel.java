package cn.hujw.wanandroid.model.home.mvp.modle;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.model.home.mvp.listener.HomeOnListener;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public final class ArticleModel extends MvpModel<HomeOnListener> {


    /**
     * curPage : 1
     * datas : [{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10398,"link":"https://juejin.im/post/5d6bce24f265da03db0790d1","niceDate":"4小时前","niceShareDate":"4小时前","origin":"","prefix":"","projectLink":"","publishTime":1574222765000,"selfVisible":0,"shareDate":1574222749000,"shareUser":"zhangpan","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"打造一个丝滑般自动轮播无限循环Android库","type":0,"userId":27880,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10397,"link":"https://juejin.im/post/5d74d3faf265da03b5747015","niceDate":"4小时前","niceShareDate":"4小时前","origin":"","prefix":"","projectLink":"","publishTime":1574222573000,"selfVisible":0,"shareDate":1574222573000,"shareUser":"zhangpan","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"BannerViewPager源码解析","type":0,"userId":27880,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":505,"chapterName":"LeakCanary","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10381,"link":"https://juejin.im/post/5a9d46d2f265da237d0280a3","niceDate":"15小时前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574180460000,"selfVisible":0,"shareDate":1574139942000,"shareUser":"秉心说","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"LeakCanary 源码解析","type":0,"userId":22057,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10379,"link":"https://juejin.im/post/5c73388c518825629e062232","niceDate":"15小时前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574180400000,"selfVisible":0,"shareDate":1574126292000,"shareUser":"灰丨色","superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"Android性能优化：手把手教你如何让App更快、更稳、更省","type":0,"userId":28694,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10388,"link":"https://github.com/KunMinX/Jetpack-MVVM-Best-Practice","niceDate":"15小时前","niceShareDate":"19小时前","origin":"","prefix":"","projectLink":"","publishTime":1574180380000,"selfVisible":0,"shareDate":1574167493000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"KunMinX/Jetpack-MVVM-Best-Practice: 是 难得一见 的 Jetpack MVVM 最佳实践！","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10383,"link":"https://juejin.im/post/5dd3983c51882530702df6c5","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574149005000,"selfVisible":0,"shareDate":1574149005000,"shareUser":"winlee28","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"还不知道Android Jetpack是什么？你就out了","type":0,"userId":25211,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":182,"chapterName":"JNI编程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10368,"link":"https://juejin.im/post/5dd22ecd5188252a091e9b47","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574095298000,"selfVisible":0,"shareDate":1574094614000,"shareUser":"鸿洋","superChapterId":149,"superChapterName":"JNI","tags":[],"title":"从零开始仿写一个抖音App\u2014\u2014视频编辑SDK开发(一)","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10373,"link":"https://www.jianshu.com/p/7491750f7988?utm_source=desktop&utm_medium=timeline","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574095208000,"selfVisible":0,"shareDate":1574094887000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"Android Jetpack架构组件之Lifecycle入门","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":229,"chapterName":"AOP","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10374,"link":"https://www.jianshu.com/p/c40528c8df17?utm_source=desktop&utm_medium=timeline","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574095199000,"selfVisible":0,"shareDate":1574094893000,"shareUser":"鸿洋","superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"Android开发中的AOP技术","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10366,"link":"https://mp.weixin.qq.com/s/MtFJ-E0jN8O8fTECFxUjBw","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574081296000,"selfVisible":0,"shareDate":1574074429000,"shareUser":"ZYLAB","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"解读 Java 类在 Android ART 中的实现","type":0,"userId":10577,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10365,"link":"https://mp.weixin.qq.com/s/d9lx8iSGRabeuuYYVz-z1Q","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574071117000,"selfVisible":0,"shareDate":1574071117000,"shareUser":"chendroid","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Plaid 开源库学习","type":0,"userId":7075,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10362,"link":"https://juejin.im/post/5dce5b16f265da0ba5279b11","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1574047040000,"selfVisible":0,"shareDate":1574047040000,"shareUser":"LinYT","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 使用 LiveData 实现 EventBus","type":0,"userId":12067,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":74,"chapterName":"反编译","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10335,"link":"https://juejin.im/post/5dcfc3e0e51d453daa0e422d","niceDate":"2天前","niceShareDate":"2019-11-16","origin":"","prefix":"","projectLink":"","publishTime":1574009584000,"selfVisible":0,"shareDate":1573904525000,"shareUser":"鸿洋","superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"因一纸设计稿，我把竞品APP扒得裤衩不剩(中)","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10346,"link":"https://juejin.im/post/5dcff9d3f265da0bd20af0da","niceDate":"2天前","niceShareDate":"2019-11-17","origin":"","prefix":"","projectLink":"","publishTime":1574009568000,"selfVisible":0,"shareDate":1573963389000,"shareUser":"goweii","superChapterId":94,"superChapterName":"自定义控件","tags":[],"title":"高级 UI 成长之路 (一) View 的基础知识你必须知道","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":142,"chapterName":"ConstraintLayout","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10349,"link":"https://juejin.im/post/5cf868f2e51d45775e33f529","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1574009558000,"selfVisible":0,"shareDate":1573991456000,"shareUser":"AprilEyon","superChapterId":179,"superChapterName":"5.+高新技术","tags":[],"title":"ConstraintLayout 约束布局","type":0,"userId":3559,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10353,"link":"https://blog.csdn.net/Greathfs/article/details/102809322","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1574009537000,"selfVisible":0,"shareDate":1573993079000,"shareUser":"Greathfs","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Gradle学习系列(四)-Gradle高级用法实战","type":0,"userId":5325,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10309,"link":"https://juejin.im/user/59759b3e6fb9a06baf2ee47b","niceDate":"2019-11-15","niceShareDate":"2019-11-15","origin":"","prefix":"","projectLink":"","publishTime":1573812739000,"selfVisible":0,"shareDate":1573812739000,"shareUser":"LinYT","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 使用 LiveData 实现 EventBus","type":0,"userId":12067,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10307,"link":"https://juejin.im/post/5dce51edf265da0c0c1fe649","niceDate":"2019-11-15","niceShareDate":"2019-11-15","origin":"","prefix":"","projectLink":"","publishTime":1573804280000,"selfVisible":0,"shareDate":1573804280000,"shareUser":"winlee28","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Flutter混合开发(三)：Android与Flutter之间通信详细指南","type":0,"userId":25211,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":504,"chapterName":"Dokit","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10283,"link":"https://juejin.im/post/5dc3cdfa51882538d22d5948#comment","niceDate":"2019-11-15","niceShareDate":"2019-11-15","origin":"","prefix":"","projectLink":"","publishTime":1573750773000,"selfVisible":0,"shareDate":1573750638000,"shareUser":"鸿洋","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"滴滴DoKit2.0 - 泛前端开发者的百宝箱","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":487,"chapterName":"ViewModel","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10284,"link":"https://www.jianshu.com/p/e8955f525f4c?utm_source=desktop&utm_medium=timeline","niceDate":"2019-11-15","niceShareDate":"2019-11-15","origin":"","prefix":"","projectLink":"","publishTime":1573750710000,"selfVisible":0,"shareDate":1573750700000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"【大揭秘】Android架构组件ViewModel来龙去脉","type":0,"userId":2,"visible":1,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 377
     * size : 20
     * total : 7524
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public void getArticle(int num) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getArticle(num)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<ArticleModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onArticleFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(ArticleModel data) {
                        getListener().onArticleSucceed(data);
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
         * chapterId : 502
         * chapterName : 自助
         * collect : false
         * courseId : 13
         * desc :
         * envelopePic :
         * fresh : true
         * id : 10398
         * link : https://juejin.im/post/5d6bce24f265da03db0790d1
         * niceDate : 4小时前
         * niceShareDate : 4小时前
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1574222765000
         * selfVisible : 0
         * shareDate : 1574222749000
         * shareUser : zhangpan
         * superChapterId : 494
         * superChapterName : 广场Tab
         * tags : []
         * title : 打造一个丝滑般自动轮播无限循环Android库
         * type : 0
         * userId : 27880
         * visible : 1
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
