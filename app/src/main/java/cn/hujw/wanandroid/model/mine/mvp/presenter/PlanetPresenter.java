package cn.hujw.wanandroid.model.mine.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.model.mine.mvp.contract.PlanetContract;
import cn.hujw.wanandroid.model.mine.mvp.listener.PlanetOnListener;
import cn.hujw.wanandroid.model.mine.mvp.modle.PlanetModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class PlanetPresenter extends MvpPresenter<PlanetContract.View> implements PlanetContract.Presenter, PlanetOnListener {

    @MvpInject
    PlanetModel model;

    @Override
    public void getPlanet(int num) {
        model.setListener(this);
        model.getPlanet(num);
    }

    @Override
    public void onPlanetSucceed(PlanetModel data) {
        getView().getPlanetSuccess(data);
    }

    @Override
    public void onPlanetFail(String msg) {
        getView().getPlanetError(msg);
    }
}
