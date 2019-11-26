package cn.hujw.wanandroid.model.mine.mvp.modle;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.model.mine.mvp.listener.PlanetOnListener;
import cn.hujw.wanandroid.mvp.MvpModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class PlanetModel extends MvpModel<PlanetOnListener> {


    /**
     * curPage : 1
     * datas : [{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10496,"link":"https://juejin.im/post/5ddccb9b51882573511783e3","niceDate":"17分钟前","niceShareDate":"17分钟前","origin":"","prefix":"","projectLink":"","publishTime":1574754006000,"selfVisible":0,"shareDate":1574754006000,"shareUser":"张风捷特烈","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"[- 壹 FFmpeg4.2.1 -] CLion 集成 、Xcode 集成、 Android集成","type":0,"userId":31634,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10495,"link":"https://www.wanandroid.com/wenda/show/10482","niceDate":"4小时前","niceShareDate":"4小时前","origin":"","prefix":"","projectLink":"","publishTime":1574740272000,"selfVisible":0,"shareDate":1574740272000,"shareUser":"whchen617","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"每日一问 | Activity启动流程中，大部分都是用Binder通讯，为啥跟Zygote通信的时候要用socket呢？-玩Android - wanandroid.com","type":0,"userId":33666,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10494,"link":"https://juejin.im/post/5a0107816fb9a0452b48a205","niceDate":"4小时前","niceShareDate":"4小时前","origin":"","prefix":"","projectLink":"","publishTime":1574737859000,"selfVisible":0,"shareDate":1574737859000,"shareUser":"灰丨色","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"V - Layout：淘宝、天猫都在用的Android UI框架 完全解析","type":0,"userId":28694,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10493,"link":"https://juejin.im/post/5dd78fffe51d45236665e6a5","niceDate":"6小时前","niceShareDate":"6小时前","origin":"","prefix":"","projectLink":"","publishTime":1574733064000,"selfVisible":0,"shareDate":1574733064000,"shareUser":"chs2018","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Gradle之Project，Task","type":0,"userId":9180,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10492,"link":"https://blog.csdn.net/Greathfs/article/details/102637709","niceDate":"6小时前","niceShareDate":"6小时前","origin":"","prefix":"","projectLink":"","publishTime":1574731107000,"selfVisible":0,"shareDate":1574731107000,"shareUser":"Greathfs","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"浅析Android-Handler消息机制","type":0,"userId":5325,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10490,"link":"https://www.jianshu.com/p/620da99902a9","niceDate":"6小时前","niceShareDate":"6小时前","origin":"","prefix":"","projectLink":"","publishTime":1574730947000,"selfVisible":0,"shareDate":1574730947000,"shareUser":"深红骑士","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"还不懂热修复的原理？看完这篇后带你手把手写代码","type":0,"userId":29303,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10488,"link":"https://juejin.im/post/5ddb7780518825731e6c8397","niceDate":"7小时前","niceShareDate":"7小时前","origin":"","prefix":"","projectLink":"","publishTime":1574728671000,"selfVisible":0,"shareDate":1574728671000,"shareUser":"于慢慢家的吴蜀黍","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 升级适配爬坑历程","type":0,"userId":1260,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10487,"link":"https://juejin.im/entry/5ddb7af7e51d452329319f90","niceDate":"7小时前","niceShareDate":"7小时前","origin":"","prefix":"","projectLink":"","publishTime":1574728665000,"selfVisible":0,"shareDate":1574728665000,"shareUser":"goweii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 升级适配爬坑历程","type":0,"userId":20382,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10485,"link":"https://juejin.im/post/5ddb6b0de51d4523307fca86","niceDate":"7小时前","niceShareDate":"7小时前","origin":"","prefix":"","projectLink":"","publishTime":1574728361000,"selfVisible":0,"shareDate":1574728361000,"shareUser":"AprilEyon","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Application初始化过程","type":0,"userId":3559,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10345,"link":"http://weishu.me/2016/01/12/binder-index-for-newer/","niceDate":"15小时前","niceShareDate":"2019-11-17","origin":"","prefix":"","projectLink":"","publishTime":1574699553000,"selfVisible":0,"shareDate":1573948704000,"shareUser":"残页","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Binder 学习指南","type":0,"userId":12467,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10356,"link":"http://weishu.me/2015/12/21/android-studio-debug-tips-you-may-not-know/","niceDate":"15小时前","niceShareDate":"2019-11-18","origin":"","prefix":"","projectLink":"","publishTime":1574699547000,"selfVisible":0,"shareDate":1574037723000,"shareUser":"残页","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android Studio你不知道的调试技巧","type":0,"userId":12467,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10484,"link":"https://www.jianshu.com/p/60ac9e073308","niceDate":"15小时前","niceShareDate":"15小时前","origin":"","prefix":"","projectLink":"","publishTime":1574699122000,"selfVisible":0,"shareDate":1574699122000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"APP中如何更好的使用弹窗？ ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10483,"link":"https://juejin.im/post/5ddb2b5b51882573461819e0","niceDate":"15小时前","niceShareDate":"15小时前","origin":"","prefix":"","projectLink":"","publishTime":1574698915000,"selfVisible":0,"shareDate":1574698915000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" Android10填坑适配指南，实际经验代码，拒绝翻译 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":10478,"link":"https://mp.weixin.qq.com/s/mGv_SO5ivqEmHJX9bojT0A","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574647550000,"selfVisible":0,"shareDate":1574647550000,"shareUser":"jingbin","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"趣头条大佬带你飞：实现阿里无抖动换肤","type":0,"userId":1534,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10477,"link":"https://juejin.im/post/5acac7375188255c93239124","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574645568000,"selfVisible":0,"shareDate":1574645568000,"shareUser":"灰丨色","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android：Retrofit 2.0 使用攻略（含实例讲解）","type":0,"userId":28694,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10474,"link":"https://blog.csdn.net/carson_ho/article/details/103231986","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574643582000,"selfVisible":0,"shareDate":1574643582000,"shareUser":"AprilEyon","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Java虚拟机：静态分派 & 动态分派原理","type":0,"userId":3559,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10473,"link":"https://juejin.im/entry/5dda5c3df265da7dcc7e593e","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574642823000,"selfVisible":0,"shareDate":1574642823000,"shareUser":"goweii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"View的滑动实现方式","type":0,"userId":20382,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10472,"link":"https://www.jianshu.com/p/86d00bbdaf60","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574642502000,"selfVisible":0,"shareDate":1574642502000,"shareUser":"于慢慢家的吴蜀黍","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 之 Choreographer 详细分析","type":0,"userId":1260,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10452,"link":"https://juejin.im/post/5dd766e1e51d45233c7e857f#heading-13","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574589519000,"selfVisible":0,"shareDate":1574589519000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" 聊一聊关于Glide在面试中的那些事 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10451,"link":"https://www.jianshu.com/p/1dd77e56cc3c?utm_source=desktop&utm_medium=timeline","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1574589375000,"selfVisible":0,"shareDate":1574589375000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android中Https请求如何防止中间人攻击和Charles抓包原理 ","type":0,"userId":2,"visible":0,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 30
     * size : 20
     * total : 599
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;


    public void getPlanet(int num) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getPlanet(num)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<PlanetModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onPlanetFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(PlanetModel data) {
                        getListener().onPlanetSucceed(data);
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
         * fresh : true
         * id : 10496
         * link : https://juejin.im/post/5ddccb9b51882573511783e3
         * niceDate : 17分钟前
         * niceShareDate : 17分钟前
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1574754006000
         * selfVisible : 0
         * shareDate : 1574754006000
         * shareUser : 张风捷特烈
         * superChapterId : 494
         * superChapterName : 广场Tab
         * tags : []
         * title : [- 壹 FFmpeg4.2.1 -] CLion 集成 、Xcode 集成、 Android集成
         * type : 0
         * userId : 31634
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
