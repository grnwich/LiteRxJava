package com.grn.literx;

/**
 * <描述>
 *
 * @author lilw
 * @date: 2017/2/22
 * @version: v1.0
 */
public interface Operator<R,T>extends Fun1<Subscriber<? super R>,Subscriber<? super T>> {
}
