package editor;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ImageEditor {

    public static void main(String args[]){
        File input = new File(args[0]);
        String output = args[1];
        String command = args[2];

        Image image = readFile(input);

        if(command.equals("invert")){
            image = invert(image);
        }

        if(command.equals("grayscale")){
            image = grayscale(image);
        }

        if(command.equals("emboss")){
            image = emboss(image);
        }

        writeFile(image, output);
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

            for(int row = 0; row < height; row += 1){
                for(int column = 0; column < width; column += 1){
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

    static void writeFile(Image image, String output){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            writer.write("P3 " + image.getWidth() + " " + image.getHeight() + " 255");
            writer.newLine();
            writer.append(image.toString());
            writer.close();
        }
        catch(IOException e){
            System.out.println("File write failed.");
            System.out.println(e.toString());
        }
    }

    static Image invert(Image image){
        int rows = image.getHeight();
        int columns = image.getWidth();
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
        int rows = image.getHeight();
        int columns = image.getWidth();
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

    static Image emboss(Image image){
        Pixel edgeVal = new Pixel(128,128,128);
        Image returnImage = new Image(image.getWidth(), image.getHeight());
        for (int i = 0; i < image.getWidth(); i += 1){ // look at this later
            returnImage.setPixelAt(0, i, edgeVal);
        }
        for(int i = 0; i < image.getHeight(); i += 1){ // may have switched them
            returnImage.setPixelAt(i, 0, edgeVal);
        }

        for(int row = 1; row < image.getHeight(); row += 1){
            for(int column = 1; column < image.getWidth(); row += 1) {
                Pixel pixel = new Pixel(image.getPixelAt(row, column));
                Pixel otherPixel = image.getPixelAt(row - 1, column - 1);
                int redDiff = pixel.getRed() - otherPixel.getRed();
                int greenDiff = pixel.getGreen() - otherPixel.getGreen();
                int blueDiff = pixel.getBlue() - otherPixel.getBlue();

                int largestDiff;

                if ((Math.abs(redDiff) > Math.abs(greenDiff)) && (Math.abs(redDiff) > Math.abs(blueDiff))) {
                    largestDiff = redDiff;
                }
                else if ((Math.abs(greenDiff) > Math.abs(redDiff)) && (Math.abs(greenDiff) > Math.abs(blueDiff))){
                    largestDiff = greenDiff;
                }
                else{
                    largestDiff = blueDiff;
                }

                int value = 128 + largestDiff;

                if(value < 0) value = 0;
                else if(value > 255) value = 255;

                returnImage.setPixelAt(row, column, pixel);
            }
        }

        return null;
    }



}
