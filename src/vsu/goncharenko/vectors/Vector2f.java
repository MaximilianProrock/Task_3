package vsu.goncharenko.vectors;

public class Vector2f {
    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public static Vector2f adding(final Vector2f a, final Vector2f b) {
        return new Vector2f(a.x + b.x, a.y + b.y);
    }

    public void adding(final Vector2f b) {
        this.x += b.x;
        this.y += b.y;
    }



    public static Vector2f subtraction(final Vector2f a, final Vector2f b) {
        return new Vector2f(a.x - b.x, a.y - b.y);
    }

    public void subtraction(final Vector2f b) {
        this.x -= b.x;
        this.y -= b.y;
    }



    public static Vector2f multiplication(final Vector2f a, final float scalar) {
        return new Vector2f(a.x * scalar, a.y * scalar);
    }

    public void multiplication(final float scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }



    public static Vector2f division(final Vector2f a, final float scalar) {
        return new Vector2f(a.x / scalar, a.y / scalar);
    }

    public void division(final float scalar) {
        this.x /= scalar;
        this.y /= scalar;
    }



    public double vectorLength() {
        return  Math.sqrt(this.x * this.x + this.y * this.y);
    }



    public static Vector2f normalization(final Vector2f vector2f){
        float length = (float) vector2f.vectorLength();
        return new Vector2f(vector2f.x / length, vector2f.y / length);
    }

    public void normalization(){
        float length = (float) vectorLength();
        this.x /= length;
        this.y /= length;
    }



    public static float scalarProduct(final Vector2f a, final Vector2f b) {
        return a.x * b.x + a.y * b.y;
    }


    public  float scalarProduct(final Vector2f b) {
        return this.x * b.x + this.y * b.y;
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
}
