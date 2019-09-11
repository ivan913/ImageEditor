package editor;

public class Pixel {
    private int red, green, blue;

    public Pixel(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Pixel(Pixel pixel){
        this.red = pixel.getRed();
        this.green = pixel.getGreen();
        this.blue = pixel.getBlue();
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public Pixel invert(){
        return new Pixel(255-red, 255-green, 255-blue);
    }

    public Pixel grayscale(){
        int average = (red + green + blue) / 3;
        return new Pixel(average,average,average);
    }
}
