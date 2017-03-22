package com.grn.literx;

/**
 * <描述>
 *
 * @author lilw
 * @date: 2017/2/22
 * @version: v1.0
 */
public class OperatorMerge<T> implements Operator<T,Obserable<? extends T>> {

    @Override
    public Subscriber<? super Obserable<? extends T>> call(Subscriber<? super T> subscriber) {
        return new MergeSubscriber<T>(subscriber);
    }
    private static class MergeSubscriber<T> extends Subscriber<Obserable<? extends T>>{
        private Subscriber<? super T>acturl;
        public MergeSubscriber(Subscriber<? super T>o){
            this.acturl=o;
        }
        @Override
        public void onNext(Obserable<? extends T> obserable) {
            obserable.subscribe(acturl);
        }
    }
}
