package com.grn.literx;

/**
 * <描述>
 *
 * @author lilw
 * @date: 2017/2/22
 * @version: v1.0
 */
public abstract class Subscriber<T> {
    public abstract void onNext(T t);
}
