package vsu.goncharenko.vectors;

public class Vector3f {


    private float x;
    private float y;
    private float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3f adding(final Vector3f a, final Vector3f b) {
        return new Vector3f(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public void adding(final Vector3f b) {
        this.x += b.x;
        this.y += b.y;
        this.z += b.z;
    }



    public static Vector3f subtraction(final Vector3f a, final Vector3f b) {
        return new Vector3f(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    public void subtraction(final Vector3f b) {
        this.x -= b.x;
        this.y -= b.y;
        this.z -= b.z;
    }



    public static Vector3f multiplication(final Vector3f a, final float scalar) {
        return new Vector3f(a.x * scalar, a.y * scalar, a.z * scalar);
    }

    public void multiplication(final float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }



    public static Vector3f division(final Vector3f a, final float scalar) {
        return new Vector3f(a.x / scalar, a.y / scalar, a.z / scalar);
    }

    public void division(final float scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
    }



    public double vectorLength() {
        return  Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }



    public static Vector3f normalization(final Vector3f vector3f){
        float length = (float) vector3f.vectorLength();
        return new Vector3f(vector3f.x / length, vector3f.y / length, vector3f.z / length);
    }

    public void normalization(){
        float length = (float) vectorLength();
        this.x /= length;
        this.y /= length;
        this.z /= length;
    }



    public static float scalarProduct(final Vector3f a, final Vector3f b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public float scalarProduct(Vector3f b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }


    public static Vector3f vectorProduct(final Vector3f a, final Vector3f b) {
        return new Vector3f(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }

    public Vector3f vectorProduct(final Vector3f b) {
        return new Vector3f(this.y * b.z - this.z * b.y, this.z * b.x - this.x * b.z, this.x * b.y - this.y * b.x);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
