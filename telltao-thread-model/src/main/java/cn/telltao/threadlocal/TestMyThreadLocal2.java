package cn.telltao.threadlocal;

/**
 * Created By LiuTao
 * 第二种实现的测试
 * @Date 2020/11/17 17:33
 */
public class TestMyThreadLocal2 {

    static MyThreadLocal2<Long> v = new MyThreadLocal2<Long>() {
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
