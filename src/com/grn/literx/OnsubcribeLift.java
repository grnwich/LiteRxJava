package com.grn.literx;

/**
 * <描述>
 *
 * @author lilw
 * @date: 2017/2/22
 * @version: v1.0
 */
public class OnsubcribeLift<T,R> implements OnSubscribe<R> {
    private Operator<? extends R,? super T>operator;
    private OnSubscribe<T>onSubscribe;
    public OnsubcribeLift(OnSubscribe<T>onSubscribe,Operator<? extends R,? super T>operator){
        this.operator=operator;
        this.onSubscribe=onSubscribe;
    }
    @Override
    public void call(Subscriber<? super R> subscriber) {
        System.out.println("........OnsubcribeLift.............>");
        Subscriber<? super T> sb=operator.call(subscriber);
        onSubscribe.call(sb);
    }
}
