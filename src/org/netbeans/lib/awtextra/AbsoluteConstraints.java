package org.netbeans.lib.awtextra;

public class AbsoluteConstraints {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public AbsoluteConstraints(int x, int y) {
        this(x, y, -1, -1);
    }

    public AbsoluteConstraints(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
