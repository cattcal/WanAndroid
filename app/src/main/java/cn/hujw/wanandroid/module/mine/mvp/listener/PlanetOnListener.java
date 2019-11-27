package cn.hujw.wanandroid.module.mine.mvp.listener;


import cn.hujw.wanandroid.module.mine.mvp.modle.PlanetModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public interface PlanetOnListener {
    void onPlanetSucceed(PlanetModel data);

    void onPlanetFail(String msg);

}
