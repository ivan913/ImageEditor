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

        Pixel[][] image = readFile(input);

    }

    static Pixel[][] readFile(File input){
        try{
            Scanner scanner = new Scanner(input);
            scanner.next(); //expect P3

            int width, height;

            width = scanner.nextInt();
            height = scanner.nextInt();

            scanner.nextInt(); //expect 255

            Pixel[][] image = new Pixel[width][height];

            for(int row = 0; row < width; row += 1){
                for(int column = 0; column < height; column += 1){
                    int red = scanner.nextInt();
                    int green = scanner.nextInt();
                    int blue = scanner.nextInt();
                    image[row][column] = new Pixel(red, green, blue);
                }
            }
            return image;
        }catch(FileNotFoundException e){
            System.out.println("File not Found");
            return null;
        }
    }



}
