package com.android.betterway.settingactivity.presenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;

/**
 * @author Jackdow
 * @version 1.0
 *          BetterWay
 */

public interface SettingPresenter {
    /**
     * 在api19前的处理方法
     * @param data 传入的数据
     * @return 图片路径
     */
    String handleImageBeforeKitKat(Intent data);
    /**
     * api19及之后的处理方法
     * @param data 传入的数据
     * @return 图片路径
     */
    @TargetApi(19)
    String handleImageOnKitKat(Intent data);
    /**
     * 获得图片的存储路径
     * @param uri 返回的uri
     * @param selection 类型
     * @return 图片路径
     */
    String getImagePath(Uri uri, String selection);

    String getStringData(String key);

    void putStringData(String key, String data);
}
