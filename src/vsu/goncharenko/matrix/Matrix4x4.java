package vsu.goncharenko.matrix;

import vsu.goncharenko.vectors.Vector4f;

public class Matrix4x4 {
    private Vector4f column1;
    private Vector4f column2;
    private Vector4f column3;
    private Vector4f column4;

    public Matrix4x4(Vector4f column1, Vector4f column2, Vector4f column3, Vector4f column4) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
    }

    public Matrix4x4() {
        Vector4f vector0 = new Vector4f(0, 0, 0, 0);
        this.column1 = vector0;
        this.column2 = vector0;
        this.column3 = vector0;
        this.column4 = vector0;
    }

    public void unitMatrix() {
        this.column1 = new Vector4f(1, 0, 0, 0);
        this.column2 = new Vector4f(0, 1, 0, 0);
        this.column3 = new Vector4f(0, 0, 1, 0);
        this.column4 = new Vector4f(0, 0, 0, 1);
    }

    public static Matrix4x4 addition(final Matrix4x4 a, final Matrix4x4 b) {
        return new Matrix4x4(
                Vector4f.adding(a.column1, b.column1),
                Vector4f.adding(a.column2, b.column2),
                Vector4f.adding(a.column3, b.column3),
                Vector4f.adding(a.column4, b.column4)
        );
    }

    public void addition(final Matrix4x4 b) {
        column1.adding(b.column1);
        column2.adding(b.column2);
        column3.adding(b.column3);
        column4.adding(b.column4);
    }



    public static Matrix4x4 subtraction(final Matrix4x4 a, final Matrix4x4 b) {
        return new Matrix4x4(
                Vector4f.subtraction(a.column1, b.column1),
                Vector4f.subtraction(a.column2, b.column2),
                Vector4f.subtraction(a.column3, b.column3),
                Vector4f.subtraction(a.column4, b.column4)
        );
    }

    public void subtraction(final Matrix4x4 b) {
        column1.subtraction(b.column1);
        column2.subtraction(b.column2);
        column3.subtraction(b.column3);
        column4.subtraction(b.column4);
    }

    private static Vector4f vectorForMultiplication(final Vector4f columnString, final Matrix4x4 a) {
        return new Vector4f(
                Vector4f.scalarProduct(columnString, new Vector4f(a.column1.getX(), a.column2.getX(), a.column3.getX(), a.column4.getX())),
                Vector4f.scalarProduct(columnString, new Vector4f(a.column1.getY(), a.column2.getY(), a.column3.getY(),a.column4.getY())),
                Vector4f.scalarProduct(columnString, new Vector4f(a.column1.getZ(), a.column2.getZ(), a.column3.getZ(), a.column4.getZ())),
                Vector4f.scalarProduct(columnString, new Vector4f(a.column1.getT(), a.column2.getT(), a.column3.getT(), a.column4.getT()))
        );
    }


    public static Matrix4x4 multiplication(final Matrix4x4 a, final Matrix4x4 b) {
        Vector4f newColumn1 = vectorForMultiplication(b.column1, a);
        Vector4f newColumn2 = vectorForMultiplication(b.column2, a);
        Vector4f newColumn3 = vectorForMultiplication(b.column3, a);
        Vector4f newColumn4 = vectorForMultiplication(b.column4, a);

        return new Matrix4x4(newColumn1, newColumn2, newColumn3, newColumn4);

    }


    public void multiplication(final Matrix4x4 b) {
        Matrix4x4 a = new Matrix4x4(column1, column2, column3, column4);
        Vector4f newColumn1 = vectorForMultiplication(b.column1, a);
        Vector4f newColumn2 = vectorForMultiplication(b.column2, a);
        Vector4f newColumn3 = vectorForMultiplication(b.column3, a);
        Vector4f newColumn4 = vectorForMultiplication(b.column4, a);

        column1 = newColumn1;
        column2 = newColumn2;
        column3 = newColumn3;
        column4 = newColumn4;

    }

    public static Matrix4x4 transposition(final Matrix4x4 matrix) {
        Vector4f newColumn1 = new Vector4f(matrix.column1.getX(),matrix.column2.getX(), matrix.column3.getX(), matrix.column4.getX());
        Vector4f newColumn2 = new Vector4f(matrix.column1.getY(),matrix.column2.getY(), matrix.column3.getY(), matrix.column4.getY());
        Vector4f newColumn3 = new Vector4f(matrix.column1.getZ(),matrix.column2.getZ(), matrix.column3.getZ(), matrix.column4.getZ());
        Vector4f newColumn4 = new Vector4f(matrix.column1.getT(),matrix.column2.getT(), matrix.column3.getT(), matrix.column4.getT());
        return new Matrix4x4(newColumn1, newColumn2, newColumn3, newColumn4);
    }

    public void transposition() {
        Vector4f newColumn1 = new Vector4f(column1.getX(), column2.getX(), column3.getX(), column4.getX());
        Vector4f newColumn2 = new Vector4f(column1.getY(), column2.getY(), column3.getY(), column4.getY());
        Vector4f newColumn3 = new Vector4f(column1.getZ(), column2.getZ(), column3.getZ(), column4.getZ());
        Vector4f newColumn4 = new Vector4f(column1.getT(), column2.getT(), column3.getT(), column4.getT());

        column1 = newColumn1;
        column2 = newColumn2;
        column3 = newColumn3;
        column4 = newColumn4;
    }



    @Override
    public String toString() {
        return "" +
                column1.getX() + " " + column2.getX() + " " + column3.getX() + " " + column4.getX() +"\n" +
                column1.getY() + " " + column2.getY() + " " + column3.getY() + " " + column4.getY() + "\n" +
                column1.getZ() + " " + column2.getZ() + " " + column3.getZ() + " " + column4.getZ() + "\n" +
                column1.getT() + " " + column2.getT() + " " + column3.getT() + " " + column4.getT() + "\n";
    }
}
