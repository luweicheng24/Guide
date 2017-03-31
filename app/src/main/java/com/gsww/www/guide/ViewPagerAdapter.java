package com.gsww.www.guide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author : luweicheng on 2017/3/30 0030 20:11
 * E-mail ：1769005961@qq.com
 * GitHub : https://github.com/luweicheng24
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> mList;


    /**
     * PagerAdapter构造器
     *
     * @param mList
     * @param mContext
     */
    public ViewPagerAdapter(List<View> mList) {

        this.mList = mList;

    }

    /**
     * 获取填充内容的个数
     *
     * @return
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * 判断该view是否是来自该Project对象
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (view == object) {
            return true;
        }
        return false;
    }


    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    /**
     * 添加view到容器中
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mList.get(position));
        return mList.get(position);
    }

    /**
     * 将该View移除该容器
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }
}
