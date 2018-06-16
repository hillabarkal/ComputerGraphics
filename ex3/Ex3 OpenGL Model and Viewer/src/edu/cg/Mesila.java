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


//    public static CyclicList<Mesila> getMesilot(CyclicList<Point> points) {
//
//    }

    // component of point is x (1), y (2), z(3)
    public static CyclicList<PolynomialFunc> polinomialFuncs(CyclicList<Point> points, int component) {
        int size = points.size();
        List<Constraint> constraints = new ArrayList<>(4 * size);

        for (int i = 0; i < size; i++) {
            Point point = points.get(i);
            double p = 0;
            switch (component) {
                case 1: p = point.x;
                case 2: p = point.y;
                case 3: p = point.z;
            }

            constraints.addAll(Constraint.getConstraints(p,i,size));
        }

        return new CyclicList<PolynomialFunc>(); // TODO: change
    }


    // solving equation A*x=b
    private static float[] solveEquation(List<Constraint> constraints) {
        int size = constraints.size();
        double[][] A = new double[size][0];
        double[] b = new double[size];

        for (int i = 0; i < size; ++i) {
            Constraint constraint = constraints.get(i);
            A[i] = constraint.Ai();
            b[i] = constraint.b();
        }

        Matrix AMat = new Matrix(A);
        Matrix bMat = new Matrix(b, size);
        Matrix sol = AMat.solve(bMat);
        float[] ans = new float[size];

        for (int j = 0; j < size; ++j) {
            ans[j] = (float) sol.get(j, 0);
        }

        return ans;
    }
}