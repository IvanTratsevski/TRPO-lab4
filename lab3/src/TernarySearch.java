public class TernarySearch {

    static double Func(double x) {
        return x*x-5*x+4;
    }
    static double Search(double l, double r, double eps) {
        double m1, m2;
        while (r - l > eps) {
            m1 = (2*l+r)/3;
            m2 = (l+2*r)/3;
            if (Func(m1) > Func(m2))
                l = m1;
            else
                r = m2;
        }
        return (r + l)/2;
    }
}
