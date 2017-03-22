package com.grn.literx;

/**
 * <描述>
 *
 * @author lilw
 * @date: 2017/2/22
 * @version: v1.0
 */
public class Test {
    public static void main(String[] arg){
//        Obserable.create(new OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                subscriber.onNext(2);
//            }
//        }).map(new Fun1<Integer, String>() {
//            @Override
//            public String call(Integer integer) {
//                return integer+" t1";
//            }
//        }).map(new Fun1<String, String>() {
//            @Override
//            public String call(String s) {
//                return s+" t2";
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onNext(String st) {
//                System.out.println(st);
//            }
//        });
        Obserable.create(new OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);

            }
        }).flatMap(new Fun1<Integer, Obserable<String>>() {
            @Override
            public Obserable<String> call(Integer integer) {
                return Obserable.just("flatMap" + integer, "flatMap" + 7);
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }
}
