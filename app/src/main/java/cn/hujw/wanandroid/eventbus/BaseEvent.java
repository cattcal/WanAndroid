package cn.hujw.wanandroid.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public abstract class BaseEvent {

    public void post(){
        EventBus.getDefault().post(this);
    }

}
