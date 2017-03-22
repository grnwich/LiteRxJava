package com.grn.literx;

/**
 * <描述>
 *
 * @author lilw
 * @date: 2017/2/22
 * @version: v1.0
 */
public class Obserable<T> {
    private OnSubscribe<T> onSubscribe;
    public Obserable(OnSubscribe<T> onSubscribe){
        this.onSubscribe=onSubscribe;
    }
    public static <T> Obserable<T> create(OnSubscribe<T> onSubscribe){
        return new Obserable<T>(onSubscribe);
    }
    public final void subscribe(Subscriber<? super T> subscriber){
        onSubscribe.call(subscriber);
    }
    public final<R> Obserable<R> map(Fun1<? super T,? extends R>fun1){
        return lift(new OperatorMap<R,T>(fun1));
    }
    public final<R> Obserable<R>lift(final Operator<? extends R,? super T>operator){
        return new Obserable<R>(new OnsubcribeLift<T,R>(onSubscribe,operator));
    }
    public final<R>Obserable<R>flatMap(Fun1<? super T,? extends Obserable<? extends R>> fun1){
        return merge(map(fun1));
    }

    public final<T>Obserable<T>merge(Obserable<? extends Obserable<? extends T>> source){
        return source.lift(new OperatorMerge<T>());
    }


    public static <T> Obserable<T> just(final T t1, final T t2) {
        return from((T[]) new Object[]{t1, t2});
    }

    public static <T> Obserable<T> from(T[] array) {
        return create(new OnSubscribeFromArray<T>(array));
    }
}
