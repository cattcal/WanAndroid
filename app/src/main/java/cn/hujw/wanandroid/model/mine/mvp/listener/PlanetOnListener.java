package cn.hujw.wanandroid.model.mine.mvp.listener;


import java.util.List;

import cn.hujw.wanandroid.model.mine.mvp.modle.PlanetModel;

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
