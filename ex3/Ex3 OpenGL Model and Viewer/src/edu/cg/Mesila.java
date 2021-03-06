package edu.cg;

import Jama.Matrix;
import edu.cg.algebra.Point;

import java.util.ArrayList;
import java.util.List;

public class Mesila {
    Spline spline;
    double length;

    public double getLength() {
        return length;
    }

    public Mesila() {
        spline = null;
        length = 0;
    }

    public Mesila(Spline spline) {
        this.spline = spline;
        this.length = spline.calcLength();
    }

    public LocationOnMesila locationOnMesila(double t) {
        return new LocationOnMesila(spline.point(t), spline.tangent(t), spline.normal(t));
    }


    public static CyclicList<Mesila> getMesilot(CyclicList<Point> points) {
        CyclicList<PolynomialFunc> xPolynomials = polynomialFuncs(points, 1);
        CyclicList<PolynomialFunc> yPolynomials = polynomialFuncs(points, 2);
        CyclicList<PolynomialFunc> zPolynomials = polynomialFuncs(points, 3);

        CyclicList<Mesila> mesilot = new CyclicList<>();
        for (int i = 0; i < points.size(); i++) {
            Spline s = new Spline(xPolynomials.get(i), yPolynomials.get(i), zPolynomials.get(i));
            Mesila m = new Mesila(s);
            mesilot.add(m);
        }

        return mesilot;
    }

    // component of point is x (1), y (2), z(3)
    public static CyclicList<PolynomialFunc> polynomialFuncs(CyclicList<Point> points, int component) {
        int size = points.size();
        List<Constraint> constraints = new ArrayList<>(4 * size);

        for (int i = 0; i < size; i++) {
            Point point = points.get(i);
            double p = 0;
            switch (component) {
                case 1:
                    p = point.x;
                    break;
                case 2:
                    p = point.y;
                    break;
                case 3:
                    p = point.z;
                    break;
            }
            constraints.addAll(Constraint.getConstraints(p, i, size));
        }

        double[] polynomialFuncs = solveEquation(constraints);
        CyclicList<PolynomialFunc> cyclicPolynomials = new CyclicList<PolynomialFunc>();
        for (int i = 0; i < polynomialFuncs.length; i += 4) {
            int j = i;
            PolynomialFunc p = new PolynomialFunc(polynomialFuncs[j++],
                    polynomialFuncs[j++],
                    polynomialFuncs[j++],
                    polynomialFuncs[j++]);
            cyclicPolynomials.add(p);
        }

        return cyclicPolynomials;
    }


    // solving equation A*x=b
    private static double[] solveEquation(List<Constraint> constraints) {
        int size = constraints.size();
        double[][] A = new double[size][0];
        double[] b = new double[size];

        for (int i = 0; i < size; ++i) {
            Constraint constraint = constraints.get(i);
            A[i] = constraint.Ai();
            b[i] = constraint.b();
        }

        Matrix matrixA = new Matrix(A);
        Matrix vectorB = new Matrix(b, size);
        Matrix sol = matrixA.solve(vectorB);

        double[] ans = new double[size];
        for (int j = 0; j < size; ++j) {
            ans[j] = (float) sol.get(j, 0);
        }

        return ans;
    }
}