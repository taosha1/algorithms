public class Test11 {
    /**
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     *
     * @param base     指次
     * @param exponent 幂
     * @return 结果
     */
    public static double power(double base, int exponent) {
        if (exponent == 0.0 && base == 0) {
            throw new RuntimeException("error");
        }
        if (base == 0 && exponent < 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            base = 1 / base;
        }
        double temp = base;
        if (exponent < 0)
            exponent = -exponent;
        for (int i = 1; i < exponent; i++) {
            temp *= base;
        }
        return temp;
    }

    public static double power2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = power2(base,exponent>>1);
        result*=result;
        if ((exponent & 1) == 1) {
            result*=base;
        }
        return result;
    }

        public static void main(String[] args) {
        power2(2,35);
        System.out.println(0.0000000000000000000000001111 == 0);
        System.out.println(0.0000000000000000000000000000 == 0);

        System.out.println(power(2, -25));
        System.out.println(power(2, 5));
        System.out.println(power(2, 0));
        System.out.println(power(0, -12));
        System.out.println(power(0.00000000000000000000000000001, -1));
        System.out.println(power(0.00000000000000000000000000001, 1));
        System.out.println(power(0.00000000000000000000000000001, 0));
        System.out.println(power(0.00000000000000000000000000000, 0));

    }
}
