

public class CorRGB {
    private int red;
    private int green;
    private int blue;
    
    public CorRGB(int red, int green, int blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public CorRGB(CorRGB cor){
        this.setRed(cor.getRed());
        this.setGreen(cor.getGreen());
        this.setBlue(cor.getBlue());
    }

    public CorRGB(){
        this.setRed(0);
        this.setGreen(0);
        this.setBlue(0);
    }

    public int getRed() {
        return red;
    }

    private void setRed(int red) {
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

    private void setGreen(int green) {
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

    private void setBlue(int blue) {
        if(blue >= 0 && blue <=255)
            this.blue = blue;
        else{
            System.out.println("Error! Valor Incorreto, " + blue + " não está dentro do conjunto numérico."); 
            System.exit(0);
        }
    }

    public double getLuminosidade(){
        return (this.getRed() * 0.3 + this.getGreen() * 0.59 + this.getBlue() * 0.11);  
    }

    public CorRGB getRGB(){
        return new CorRGB(this.getRed(), this.getGreen(), this.getBlue());
    }

    public String getHexa(){
        String hex = String.format("#%02X%02X%02X", this.getRed(), this.getGreen(), this.getBlue());

        return hex;
    }

    public boolean equals(CorRGB cor){

        if(this.getRed() == cor.getRed() && 
                this.getGreen() == cor.getGreen() &&
                    this.getBlue() == cor.getBlue())
            return true;

        return false;
    }

    public void clarear(double num){
        
        double aux = num / 100;
        
        int auxRed = (int) (this.getRed() * aux);
        int auxGreen = (int) (this.getGreen() * aux);
        int auxBlue = (int) (this.getBlue() * aux);

        this.setRed(this.getRed() - Math.round(auxRed));
        this.setGreen(this.getGreen() - Math.round(auxGreen));
        this.setBlue(this.getBlue() - Math.round(auxBlue));
    }

    public void escurecer(double num){
        
        double aux = num / 100;
        System.out.println(aux);

        int auxRed = (int) (this.getRed() * aux);
        int auxGreen = (int) (this.getGreen() * aux);
        int auxBlue = (int) (this.getBlue() * aux);

        this.setRed(this.getRed() + Math.round(auxRed));
        this.setGreen(this.getGreen() + Math.round(auxGreen));
        this.setBlue(this.getBlue() + Math.round(auxBlue));
    }

    public CorRGB novoIgual(){
        return new CorRGB(this);
    }

    public void status(){
        System.out.println("Red: " + this.getRed() + " Green: " + this.getGreen() + " Blue: " +this.getBlue() + " Luminosidade: " + this.getLuminosidade());
    }


}    
