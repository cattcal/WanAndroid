package cn.hujw.wanandroid.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPHistoryUtils {


    private static final String HISTORY = "history";

    public static void saveSearchHistory(String inputText) {
        SPUtils instance = SPUtils.getInstance();
        String history = instance.get(HISTORY, "");  //获取之前保存的历史记录
        String[] temHistory = history.split(","); //逗号截取 保存在数组中
        List<String> historyList = new ArrayList<>(Arrays.asList(temHistory)); //将改数组转换成ArrayList
        if (historyList.size() > 0) {
            //1.移除之前重复添加的元素
            for (int i = 0; i < historyList.size(); i++) {
                if (inputText.equals(historyList.get(i))) {
                    historyList.remove(i);
                    break;
                }
            }

            historyList.add(0, inputText); //将新输入的文字添加集合的第0位也就是最前面(2.倒序)

            if (historyList.size() > 8) {
                historyList.remove(historyList.size() - 1); //3.最多保存8条搜索记录 删除最早搜索的那一项
            }
            //逗号拼接
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < historyList.size(); i++) {
                sb.append(historyList.get(i) + ",");
            }
            //保存到sp
            instance.save(HISTORY, sb.toString());
        } else {
            instance.save(HISTORY, inputText + ",");
        }
    }

    public static List<String> getSearchHistory(){
        String history = SPUtils.getInstance().get(HISTORY, "");
        String[] tmpHistory = history.split(","); //split后长度为1有一个空串对象

        List<String> historyList = new ArrayList<String>(Arrays.asList(tmpHistory));
        if (historyList.size() == 1 && historyList.get(0).equals("")) { //如果没有搜索记录，split之后第0位是个空串的情况下
            historyList.clear();  //清空集合，这个很关键
        }
        return historyList;
    }
}
