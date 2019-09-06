package editor;

import java.io.File;

public class Image {
    Pixel[][] matrix;
    int width;
    int height;

    public Image(Pixel[][] image){
        matrix = image;
        width = matrix.length;
        height = matrix[0].length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
