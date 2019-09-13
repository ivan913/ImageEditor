package editor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Image {
    private Pixel[][] matrix;
    private int width;
    private int height;

    public Image(Pixel[][] image){
        matrix = image;
        height = matrix.length;
        width = matrix[0].length;
    }

    public Image(Image image){
        matrix = image.getMatrix();
        width = image.getWidth();
        height = image.getHeight();
    }

    public Image(int rows, int columns){
        matrix = new Pixel[rows][columns];
        this.width = columns ;
        this.height = rows;
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

    public String toString(){
        StringBuilder writer = new StringBuilder();

        for (int row = 0; row < this.height; row += 1){
            for (int column = 0; column < this.width; column += 1){
                writer.append(" ");
                writer.append(matrix[row][column].getRed());
                writer.append(" ");
                writer.append(matrix[row][column].getGreen());
                writer.append(" ");
                writer.append(matrix[row][column].getBlue());
            }
            writer.append("\n");
        }

        return writer.toString();
    }
}
