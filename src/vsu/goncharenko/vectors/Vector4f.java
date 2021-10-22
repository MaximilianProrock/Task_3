package vsu.goncharenko.vectors;

public class Vector4f {
    private float x;
    private float y;
    private float z;
    private float t;

    public Vector4f(float x, float y, float z, float t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }

    public static Vector4f adding(final Vector4f a, final Vector4f b) {
        return new Vector4f(a.x + b.x, a.y + b.y, a.z + b.z, a.t + b.t);
    }

    public void adding(final Vector4f b) {
        this.x += b.x;
        this.y += b.y;
        this.z += b.z;
        this.t += b.t;
    }



    public static Vector4f subtraction(final Vector4f a, final Vector4f b) {
        return new Vector4f(a.x - b.x, a.y - b.y, a.z - b.z, a.t - b.t);
    }

    public void subtraction(Vector4f b) {
        this.x -= b.x;
        this.y -= b.y;
        this.z -= b.z;
        this.t -= b.t;
    }



    public static Vector4f multiplication(final Vector4f a, final float scalar) {
        return new Vector4f(a.x * scalar, a.y * scalar, a.z * scalar, a.t * scalar);
    }

    public void multiplication(final float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.t *= scalar;
    }



    public static Vector4f division(final Vector4f a, final float scalar) {
        return new Vector4f(a.x / scalar, a.y / scalar, a.z / scalar, a.t / scalar);
    }

    public void division(final float scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
        this.t /= scalar;
    }



    public double vectorLength() {
        return  Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.t * this.t);
    }



    public static Vector4f normalization(final Vector4f vector4f){
        float length = (float) vector4f.vectorLength();
        return new Vector4f(vector4f.x / length, vector4f.y / length, vector4f.z / length, vector4f.t / length);
    }

    public void normalization(){
        float length = (float) vectorLength();
        this.x /= length;
        this.y /= length;
        this.z /= length;
        this.t /= length;
    }



    public static float scalarProduct(final Vector4f a, final Vector4f b) {
        return a.x * b.x + a.y * b.y + a.z * b.z + a.t * b.t;
    }

    public float scalarProduct(final Vector4f b) {
        return this.x * b.x + this.y * b.y + this.z * b.z + this.t * b.t;
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

    public float getT() {
        return t;
    }

    public void setT(float t) {
        this.t = t;
    }

}
