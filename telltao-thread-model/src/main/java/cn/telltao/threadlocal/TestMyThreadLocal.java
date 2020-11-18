package cn.telltao.threadlocal;

/**
 * Created By LiuTao
 * 第一种实现的测试
 * @Date 2020/11/17 17:33
 */
public class TestMyThreadLocal {

    static MyThreadLocal<Long> v = new MyThreadLocal<Long>() {
        @Override
        protected Long initialValues() {
            return Thread.currentThread().getId();
        }
    };

    public static void main(String [] args) {
        for(int i = 0; i<100; i++) {
            new Thread(()->{
               System.out.println(v.get());
            }).start();
        }
    }


}
