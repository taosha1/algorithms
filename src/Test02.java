public class Test02 {

    //单例模式，饿汉式，线程安全
    public static class Demo1 {
        private static Demo1 demo1 = new Demo1();

        private Demo1() {

        }

        public static Demo1 getInstance() {
            return demo1;
        }
    }

    //单例模式，懒汉式，线程不安全
    public static class Demo2 {
        private static Demo2 demo2;

        private Demo2() {

        }

        public static Demo2 getInstance() {
            if (demo2 == null) {
                demo2 = new Demo2();
            }
            return demo2;
        }
    }

    // 静态内部类，使用双重校验锁，线程安全
    public static class Demo3 {
        private volatile static Demo3 demo3;

        private Demo3() {

        }

        public static Demo3 getInstance() {
            if (demo3 == null) {
                synchronized (Demo3.class) {
                    if (demo3 == null) {
                        demo3 = new Demo3();
                    }
                }
            }
            return demo3;
        }
    }

    //单例模式，饿汉式，变种，线程安全
    public static class Demo4 {
        private static Demo4 demo4;

        static {
            demo4 = new Demo4();
        }

        private Demo4() {

        }

        public static Demo4 getInstance() {
            return demo4;
        }
    }

    //单例模式，懒汉式，使用静态内部类，线程安全
    public static class Demo5 {
        private static class SingletonHolder {
            private static Demo5 demo5 = new Demo5();
        }

        private Demo5() {

        }

        public static Demo5 getInstance() {
            return SingletonHolder.demo5;
        }
    }

    // 静态内部类，使用枚举方式，线程安全
    public enum Demo6 {
        INSTANCE;

        public void method() {

        }
    }

    public static void main(String[] args) {
        System.out.println(Demo6.INSTANCE==Demo6.INSTANCE);
        System.out.println(Demo2.demo2 == Demo2.getInstance());
    }


}
