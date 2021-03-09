public class CorRGB {
    private int red;
    private int green;
    private int blue;
    private double luminosidade;
    
    public CorRGB(int red, int green, int blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        if(red >= 0 && red <=255)
            this.red = red;
        else{
            System.out.println("Error! Valor Incorreto, " + red + " não está dentro do conjunto numérico."); 
            System.exit(0);
        }
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        if(green >= 0 && green <= 255)
            this.green = green;
        else{
            System.out.println("Error! Valor Incorreto, " + green + " não está dentro do conjunto numérico."); 
            System.exit(0);
        }
        
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        if(blue >= 0 && blue <=255)
            this.blue = blue;
        else{
            System.out.println("Error! Valor Incorreto, " + blue + " não está dentro do conjunto numérico."); 
            System.exit(0);
        }
    }

    public double getLuminosidade(){
        return luminosidade = (this.getRed() * 0.3 + this.getGreen() * 0.59 + this.getBlue() * 0.11) / 255;  
    }

    public void statlus(){
        System.out.println("Red: " + this.getRed() + " Green: " + this.getGreen() + " Blue: " +this.getBlue() + " Luminosidade: " + this.getLuminosidade());
    }

}    
