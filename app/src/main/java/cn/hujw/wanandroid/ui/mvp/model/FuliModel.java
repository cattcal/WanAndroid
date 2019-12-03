package cn.hujw.wanandroid.ui.mvp.model;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.CommonObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.ui.mvp.listener.FuliOnListener;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/3 0003
 */
public class FuliModel extends MvpModel<FuliOnListener> {
    /**
     * error : false
     * results : [{"_id":"5ccdbc219d212239df927a93","createdAt":"2019-05-04T16:21:53.523Z","desc":"2019-05-05","publishedAt":"2019-05-04T16:21:59.733Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg","used":true,"who":"lijinshanmx"},{"_id":"5cc43919fc3326376038d233","createdAt":"2019-04-27T19:12:25.536Z","desc":"2019-04-27","publishedAt":"2019-04-27T19:12:51.865Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg","used":true,"who":"lijinshanmx"},{"_id":"5c6a4ae99d212226776d3256","createdAt":"2019-02-18T06:04:25.571Z","desc":"2019-02-18","publishedAt":"2019-04-10T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg","used":true,"who":"lijinshanmx"},{"_id":"5c2dabdb9d21226e068debf9","createdAt":"2019-01-03T06:29:47.895Z","desc":"2019-01-03","publishedAt":"2019-01-03T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg","used":true,"who":"lijinshanmx"},{"_id":"5c25db189d21221e8ada8664","createdAt":"2018-12-28T08:13:12.688Z","desc":"2018-12-28","publishedAt":"2018-12-28T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg","used":true,"who":"lijinshanmx"},{"_id":"5c12216d9d21223f5a2baea2","createdAt":"2018-12-13T09:07:57.2Z","desc":"2018-12-13","publishedAt":"2018-12-13T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bfe1a5b9d2122309624cbb7","createdAt":"2018-11-28T04:32:27.338Z","desc":"2018-11-28","publishedAt":"2018-11-28T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bf22fd69d21223ddba8ca25","createdAt":"2018-11-19T03:36:54.950Z","desc":"2018-11-19","publishedAt":"2018-11-19T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg","used":true,"who":"lijinshanmx"},{"_id":"5be14edb9d21223dd50660f8","createdAt":"2018-11-06T08:20:43.656Z","desc":"2018-11-06","publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bcd71979d21220315c663fc","createdAt":"2018-10-22T06:43:35.440Z","desc":"2018-10-22","publishedAt":"2018-10-22T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bc434ac9d212279160c4c9e","createdAt":"2018-10-15T06:33:16.497Z","desc":"2018-10-15","publishedAt":"2018-10-15T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fw8wzdua6rj30sg0yc7gp.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bbb0de09d21226111b86f1c","createdAt":"2018-10-08T07:57:20.978Z","desc":"2018-10-08","publishedAt":"2018-10-08T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fw0vdlg6xcj30j60mzdk7.jpg","used":true,"who":"lijinshanmx"},{"_id":"5ba206ec9d2122610aba3440","createdAt":"2018-09-19T08:21:00.295Z","desc":"2018-09-19","publishedAt":"2018-09-19T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b9771a29d212206c1b383d0","createdAt":"2018-09-11T07:41:22.491Z","desc":"2018-09-11","publishedAt":"2018-09-11T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fv5n6daacqj30sg10f1dw.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b830bba9d2122031f86ee51","createdAt":"2018-08-27T04:21:14.703Z","desc":"2018-08-27","publishedAt":"2018-08-28T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b7b836c9d212201e982de6e","createdAt":"2018-08-21T11:13:48.989Z","desc":"2018-08-21","publishedAt":"2018-08-21T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b74e9409d21222c52ae4cb4","createdAt":"2018-08-16T11:02:24.289Z","desc":"2018-08-16","publishedAt":"2018-08-16T00:00:00.0Z","source":"api","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fubd0blrbuj30ia0qp0yi.jpg","used":true,"who":"lijinshan"},{"_id":"5b7102749d2122341d563844","createdAt":"2018-08-13T12:00:52.458Z","desc":"2018-08-13","publishedAt":"2018-08-13T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg","used":true,"who":"lijinshan"},{"_id":"5b6bad449d21226f45755582","createdAt":"2018-08-09T10:56:04.962Z","desc":"2018-08-09","publishedAt":"2018-08-09T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b67b7fd9d2122195bdbd806","createdAt":"2018-08-06T10:52:45.809Z","desc":"2018-08-06","publishedAt":"2018-08-06T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","used":true,"who":"lijinshan"},{"_id":"5b63cd4e9d21225e0d3f58c9","createdAt":"2018-08-03T11:34:38.672Z","desc":"2018-08-03","publishedAt":"2018-08-03T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1ftwcw4f4a5j30sg10j1g9.jpg","used":true,"who":"lijinshan"},{"_id":"5b6151509d21225206860f08","createdAt":"2018-08-01T14:21:04.556Z","desc":"2018-08-01","publishedAt":"2018-08-01T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ftu6gl83ewj30k80tites.jpg","used":true,"who":"lijinshan"},{"_id":"5b60356a9d212247776a2e0e","createdAt":"2018-07-31T18:09:46.825Z","desc":"2018-07-31","publishedAt":"2018-07-31T00:00:00.0Z","source":"api","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqgy1ftt7g8ntdyj30j60op7dq.jpg","used":true,"who":"lijinshan"},{"_id":"5b5e93499d21220fc64181a9","createdAt":"2018-07-30T12:25:45.937Z","desc":"2018-07-30","publishedAt":"2018-07-30T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1ftrrvwjqikj30go0rtn2i.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b50107f421aa917a31c0565","createdAt":"2018-07-19T12:15:59.226Z","desc":"2018-07-19","publishedAt":"2018-07-19T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ftf1snjrjuj30se10r1kx.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b4eaae4421aa93aa99bee16","createdAt":"2018-07-18T11:14:55.648Z","desc":"2018-07-18","publishedAt":"2018-07-18T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ftdtot8zd3j30ju0pt137.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b481d01421aa90bba87b9ae","createdAt":"2018-07-13T11:31:13.266Z","desc":"2018-07-13","publishedAt":"2018-07-13T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0073sXn7ly1ft82s05kpaj30j50pjq9v.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b456f5d421aa92fc4eebe48","createdAt":"2018-07-11T10:45:49.246Z","desc":"2018-07-11","publishedAt":"2018-07-11T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ft5q7ys128j30sg10gnk5.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b441f06421aa92fccb520a2","createdAt":"2018-07-10T10:50:46.379Z","desc":"2018-07-10","publishedAt":"2018-07-10T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1ft4kqrmb9bj30sg10fdzq.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b42d1aa421aa92d1cba2918","createdAt":"2018-07-09T11:08:26.162Z","desc":"2018-07-09","publishedAt":"2018-07-09T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1ft3fna1ef9j30s210skgd.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b3ed2d5421aa91cfe803e35","createdAt":"2018-07-06T10:24:21.907Z","desc":"2018-07-06","publishedAt":"2018-07-06T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fszxi9lmmzj30f00jdadv.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b3d883f421aa906e5b3c6f1","createdAt":"2018-07-05T10:53:51.361Z","desc":"2018-07-05","publishedAt":"2018-07-05T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsysqszneoj30hi0pvqb7.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b3ae394421aa906e7db029b","createdAt":"2018-07-03T10:46:44.112Z","desc":"2018-07-03","publishedAt":"2018-07-03T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fswhaqvnobj30sg14hka0.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b398cf8421aa95570db5491","createdAt":"2018-07-02T10:24:56.546Z","desc":"2018-07-02","publishedAt":"2018-07-02T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsvb1xduvaj30u013175p.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b33ccf2421aa95570db5478","createdAt":"2018-06-28T01:44:18.488Z","desc":"2018-06-28","publishedAt":"2018-06-28T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b32807e421aa95570db5471","createdAt":"2018-06-27T02:05:50.227Z","desc":"2018-06-27","publishedAt":"2018-06-27T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsp4iok6o4j30j60optbl.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b31aa33421aa9556d2cc4a7","createdAt":"2018-06-26T10:51:31.60Z","desc":"2018-06-26","publishedAt":"2018-06-26T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsoe3k2gkkj30g50niwla.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b2f8847421aa9556b44c666","createdAt":"2018-06-24T20:02:15.413Z","desc":"2018-06-24","publishedAt":"2018-06-25T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsmis4zbe7j30sg16fq9o.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b0d6ac0421aa97efda86560","createdAt":"2018-05-29T22:59:12.622Z","desc":"2018-06-02","publishedAt":"2018-06-22T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frslruxdr1j30j60ok79c.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b27c7aa421aa923c0fbfda0","createdAt":"2018-06-18T22:54:34.199Z","desc":"2018-06-19","publishedAt":"2018-06-21T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsfq1k9cb5j30sg0y7q61.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b27c7bf421aa923c0fbfda1","createdAt":"2018-06-18T22:54:55.614Z","desc":"2018-06-20","publishedAt":"2018-06-20T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsfq1ykabxj30k00pracv.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b27c7eb421aa923c43fe485","createdAt":"2018-06-18T22:55:39.819Z","desc":"2018-06-22","publishedAt":"2018-06-19T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsfq2pwt72j30qo0yg78u.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b2269a6421aa92a5f2a35f9","createdAt":"2018-06-14T21:12:06.463Z","desc":"2018-06-15","publishedAt":"2018-06-15T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fsb0lh7vl0j30go0ligni.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b1fec10421aa9793930bf99","createdAt":"2018-06-12T23:51:44.815Z","desc":"2018-06-13","publishedAt":"2018-06-14T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs8tym1e8ej30j60ouwhz.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b1fec9f421aa9793930bf9a","createdAt":"2018-06-12T23:54:07.908Z","desc":"2018-06-14","publishedAt":"2018-06-13T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs8u1joq6fj30j60orwin.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b1e8164421aa910a82cf54f","createdAt":"2018-06-11T22:04:20.9Z","desc":"2018-06-12","publishedAt":"2018-06-12T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs7l8ijitfj30jg0shdkc.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b196deb421aa910ab3d6b3d","createdAt":"2018-06-08T01:39:55.555Z","desc":"2018-06-09","publishedAt":"2018-06-11T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs35026dloj30j60ov79x.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b196d0b421aa910ab3d6b3c","createdAt":"2018-06-08T01:36:11.740Z","desc":"2018-06-08","publishedAt":"2018-06-08T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs34w0jx9jj30j60ootcn.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b17fec9421aa9109f56a6bb","createdAt":"2018-06-06T23:33:29.429Z","desc":"2018-06-07","publishedAt":"2018-06-07T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs1vq7vlsoj30k80q2ae5.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b1026a0421aa9029661ae00","createdAt":"2018-06-01T00:45:20.83Z","desc":"2018-06-01","publishedAt":"2018-06-06T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frv032vod8j30k80q6gsz.jpg","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public void getFuli(int count,int page) {
        // 为了省事，这里直接回调成功
        ApiHelper.getGankApi()
                .getFuli(count,page)
                .compose(Transformer.switchSchedulers())
                .subscribe(new CommonObserver<String>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onFuliFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(String fuliModels) {
                        getListener().onFuliSucceed(fuliModels);
                    }
                });
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }


    public static class ResultsBean {
        /**
         * _id : 5ccdbc219d212239df927a93
         * createdAt : 2019-05-04T16:21:53.523Z
         * desc : 2019-05-05
         * publishedAt : 2019-05-04T16:21:59.733Z
         * source : web
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg
         * used : true
         * who : lijinshanmx
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
