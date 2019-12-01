package cn.hujw.wanandroid.module.mine.mvp.contract;

import cn.hujw.wanandroid.module.mine.mvp.modle.PlanetModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class PlanetContract {

    public interface View extends IMvpView {

        void getPlanetSuccess(PlanetModel data);

        void getPlanetError(String msg);
    }

    public interface Presenter {

        void getPlanet(int num);
    }
}
