package com.grn.literx;

/**
 * <描述>
 *
 * @author lilw
 * @date: 2017/2/22
 * @version: v1.0
 */
public class OperatorMap<R,T> implements Operator<R,T> {
    Fun1<? super T,? extends R>fun1;
    public OperatorMap(Fun1<? super T,? extends R>fun1){
        this.fun1=fun1;
    }
    @Override
    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        return new MapSubscriber<T,R>(fun1,subscriber);
    }
    private static class MapSubscriber<T,R>extends Subscriber<T>{
        Fun1<? super T,? extends R>transformer;
        Subscriber<? super R> acturl;
        public MapSubscriber(Fun1<? super T,? extends R>fun1, Subscriber<? super R> acturl){
            this.transformer=fun1;
            this.acturl=acturl;
        }
        @Override
        public void onNext(T t) {
            R r=transformer.call(t);
            acturl.onNext(r);
        }
    }

}
