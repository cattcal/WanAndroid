package cn.hujw.wanandroid.common;

import org.greenrobot.eventbus.EventBus;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public abstract class MyEvent {

    public void post(){
        EventBus.getDefault().post(this);
    }

}
