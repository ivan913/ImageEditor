package editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImageEditor {


    public static void main(String args[]){
        File input = new File(args[0]);
        File output = new File(args[1]);
        String command = args[2];

        Image image = readFile(input);

        if(command.equals("invert")){
            image = invert(image);
        }

        if(command.equals("grayscale")){
            image = grayscale(image);
        }
    }

    static Image readFile(File input){
        try{
            Scanner scanner = new Scanner(input);
            scanner.next(); //expect P3

            int width, height;

            width = scanner.nextInt();
            height = scanner.nextInt();

            scanner.nextInt(); //expect 255

            Pixel[][] matrix = new Pixel[width][height];

            for(int row = 0; row < width; row += 1){
                for(int column = 0; column < height; column += 1){
                    int red = scanner.nextInt();
                    int green = scanner.nextInt();
                    int blue = scanner.nextInt();
                    matrix[row][column] = new Pixel(red, green, blue);
                }
            }

            return new Image(matrix);
        }catch(FileNotFoundException e){
            System.out.println("File not Found");
            return null;
        }
    }

    static void writeFile(Image image){

    }

    static Image invert(Image image){
        int rows = image.getWidth();
        int columns = image.getHeight();
        Image returnImage = new Image(rows, columns);

        for (int r = 0; r < rows; r += 1){
            for(int c = 0; c < columns; c += 1){
                Pixel p = image.getPixelAt(r,c);
                p = p.invert();
                returnImage.setPixelAt(r,c,p);
            }
        }
        return returnImage;
    }

    static Image grayscale(Image image){
        int rows = image.getWidth();
        int columns = image.getHeight();
        Image returnImage = new Image(rows, columns);

        for (int r = 0; r < rows; r += 1){
            for(int c = 0; c < columns; c += 1){
                Pixel p = image.getPixelAt(r,c);
                p = p.grayscale();
                returnImage.setPixelAt(r,c,p);
            }
        }
        return returnImage;
    }



}
