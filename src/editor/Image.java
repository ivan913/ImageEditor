package editor;

import java.io.File;

public class Image {
    private Pixel[][] matrix;
    private int width;
    private int height;

    public Image(Pixel[][] image){
        matrix = image;
        width = matrix.length;
        height = matrix[0].length;
    }

    public Image(Image image){
        matrix = image.getMatrix();
        width = image.getWidth();
        height = image.getHeight();
    }

    public Image(int width, int height){
        matrix = new Pixel[width][height];
        this.width = width;
        this.height = height;
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

    public Pixel getPixelAt(int row, int column){
        return matrix[row][column];
    }

    public void setPixelAt(int row, int column, Pixel p){
        matrix[row][column] = p;
    }

    public Pixel[][] getMatrix(){
        return matrix;
    }
}
