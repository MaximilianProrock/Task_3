package vsu.goncharenko;

import vsu.goncharenko.matrix.Matrix4x4;
import vsu.goncharenko.vectors.Vector4f;

public class Main {

    public static void main(String[] args) {
        Matrix4x4 a = new Matrix4x4(
                new Vector4f(1, 2, 3, 4),
                new Vector4f(2, 8, 6, 7),
                new Vector4f(8, 3, 6, 5),
                new Vector4f(8, 6, 9, 1));
        Matrix4x4 b = new Matrix4x4(
                new Vector4f(1, 5, 9, 4),
                new Vector4f(2, 0, 8, 7),
                new Vector4f(9, 7, 6, 5),
                new Vector4f(6, 6, 5, 1));

        System.out.println(a);
        System.out.println(b);

        Matrix4x4 res = Matrix4x4.multiplication(a, b);

        System.out.println(res);
    }
}
