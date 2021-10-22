package vsu.goncharenko.matrix;

import vsu.goncharenko.vectors.Vector3f;

public class Matrix3x3 {

    private Vector3f column1;
    private Vector3f column2;
    private Vector3f column3;

    public Matrix3x3(Vector3f column1, Vector3f column2, Vector3f column3) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
    }

    public Matrix3x3() {
        Vector3f vector0 = new Vector3f(0, 0, 0);
        this.column1 = vector0;
        this.column2 = vector0;
        this.column3 = vector0;
    }

    public void unitMatrix() {
        this.column1 = new Vector3f(1, 0, 0);
        this.column2 = new Vector3f(0, 1, 0);
        this.column3 = new Vector3f(0, 0, 1);
    }

    public static Matrix3x3 addition(final Matrix3x3 a, final Matrix3x3 b) {
        return new Matrix3x3(
                Vector3f.adding(a.column1, b.column1),
                Vector3f.adding(a.column2, b.column2),
                Vector3f.adding(a.column3, b.column3)
        );
    }

    public void addition(final Matrix3x3 b) {
         column1.adding(b.column1);
         column2.adding(b.column2);
         column3.adding(b.column3);
    }



    public static Matrix3x3 subtraction(final Matrix3x3 a, final Matrix3x3 b) {
        return new Matrix3x3(
                Vector3f.subtraction(a.column1, b.column1),
                Vector3f.subtraction(a.column2, b.column2),
                Vector3f.subtraction(a.column3, b.column3));
    }

    public void subtraction(final Matrix3x3 b) {
        column1.subtraction(b.column1);
        column2.subtraction(b.column2);
        column3.subtraction(b.column3);
    }

    private static Vector3f vectorForMultiplication(final Vector3f matrixRow, final Matrix3x3 a) {
        return new Vector3f(
                Vector3f.scalarProduct(matrixRow, new Vector3f(a.column1.getX(), a.column2.getX(), a.column3.getX())),
                Vector3f.scalarProduct(matrixRow, new Vector3f(a.column1.getY(), a.column2.getY(), a.column3.getY())),
                Vector3f.scalarProduct(matrixRow, new Vector3f(a.column1.getZ(), a.column2.getZ(), a.column3.getZ()))
        );
    }


    public static Matrix3x3 multiplication(final Matrix3x3 a, final Matrix3x3 b) {
        Vector3f newColumn1 = vectorForMultiplication(b.column1, a);
        Vector3f newColumn2 = vectorForMultiplication(b.column2, a);
        Vector3f newColumn3 = vectorForMultiplication(b.column3, a);

        return new Matrix3x3(newColumn1, newColumn2, newColumn3);

    }


    public void multiplication(final Matrix3x3 b) {
        Matrix3x3 a = new Matrix3x3(column1, column2, column3);
        Vector3f newColumn1 = vectorForMultiplication(b.column1, a);
        Vector3f newColumn2 = vectorForMultiplication(b.column2, a);
        Vector3f newColumn3 = vectorForMultiplication(b.column3, a);

        column1 = newColumn1;
        column2 = newColumn2;
        column3 = newColumn3;

    }

    public static Matrix3x3 transposition(final Matrix3x3 matrix) {
        Vector3f newColumn1 = new Vector3f(matrix.column1.getX(),matrix.column2.getX(), matrix.column3.getX());
        Vector3f newColumn2 = new Vector3f(matrix.column1.getY(),matrix.column2.getY(), matrix.column3.getY());
        Vector3f newColumn3 = new Vector3f(matrix.column1.getZ(),matrix.column2.getZ(), matrix.column3.getZ());
        return new Matrix3x3(newColumn1, newColumn2, newColumn3);
    }

    public void transposition() {
        Vector3f newColumn1 = new Vector3f(column1.getX(), column2.getX(), column3.getX());
        Vector3f newColumn2 = new Vector3f(column1.getY(), column2.getY(), column3.getY());
        Vector3f newColumn3 = new Vector3f(column1.getZ(), column2.getZ(), column3.getZ());

        column1 = newColumn1;
        column2 = newColumn2;
        column3 = newColumn3;
    }


    public double determinant() {
        double determinant = 0;
        determinant += column1.getX() * (column2.getY() * column3.getZ() - column2.getZ() * column3.getY());
        determinant += -column1.getY() * (column2.getX() * column3.getZ() - column2.getZ() * column3.getX());
        determinant += column1.getZ() * (column2.getX() * column3.getY() - column2.getY() * column3.getX());
        return determinant;
    }

    @Override
    public String toString() {
        return "" +
                column1.getX() + " " + column2.getX() + " " + column3.getX() + "\n" +
                column1.getY() + " " + column2.getY() + " " + column3.getY() + "\n" +
                column1.getZ() + " " + column2.getZ() + " " + column3.getZ() + "\n";
    }
}
