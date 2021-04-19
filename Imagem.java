public class Imagem {
    public static final String PRETA = ("#000000");
    public static final String BRANCA = ("#FFFFFF");
    public static final String RED = ("#FF0000");
    public static final String GREEN = ("#00FF00");
    public static final String BLUE = ("#0000FF");

    private CorRGB[][] nos;

    public Imagem(int x, int y){
        this.nos = new CorRGB[x][y];
        this.criarImagem(x);
    }

    private void criarImagem(int x){
    
        for(int a = 0; a < x; a++){
            for(int b = 0; b < this.nos[0].length; b++){
                this.nos[a][b] = new CorRGB(255,255,255);
            } 
        }
    }

    public void modificarPixel(int x, int y, CorRGB cor){
        this.nos[x][y] = new CorRGB(cor);
    }

    public void modificarPixel(int x, int y, int red, int green, int blue){
        this.nos[x][y] = new CorRGB(red,green,blue);
    }

    public CorRGB get(int x, int y){
        return this.nos[x][y];   
    }

    public void imagemCinza(){
        for(int a = 0; a < this.nos.length; a++){
            for(int b = 0; b < this.nos[0].length; b++){
                if(this.nos[a][b].getHexa() != BRANCA){
                    this.nos[a][b].setCinza();
                }
            }
        }
    }

    public boolean equals(Imagem nos){

        if(this.getAltura() != nos.getAltura() || this.getLargura() != nos.getLargura())
            return false;
        
        for(int a = 0; a < this.nos.length; a++){
            for(int b = 0; b < this.nos[0].length; b++){
                if(this.nos[a][b].equals(nos.get(a, b))){
                    
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public void status(){

        for(int a = 0; a < this.nos.length; a++){
            for(int b = 0; b < this.nos[0].length; b++){
                System.out.println("Posição: " + a + " " + b + " = " + this.nos[a][b].getHexa());
            }  
        }
    }

    public void rotacionarMatrizHorario() {
        int largura = getAltura();
        int altura = getLargura();
        CorRGB[][] ret = new CorRGB[altura][largura];

        for (int i=0; i<altura; i++) {
            for (int j=0; j<largura; j++) {
                ret[i][j] = this.nos[largura - j - 1][i];
            }
         }

        if(altura == largura){
            for (int i=0; i<altura; i++) {
                for (int j=0; j<largura; j++) {
                    this.nos[i][j] = ret[i][j];
                }
            }
        }else{
            this.nos = new CorRGB[ret.length][ret[0].length];
                for (int i=0; i<altura; i++) {
                    for (int j=0; j<largura; j++) {
                        this.nos[i][j] = ret[i][j];
                }
            }
        }     
    }

    private int getLargura(){
        int largura = this.nos[0].length;

        return largura;
    }

    private int getAltura(){
        int altura = this.nos.length;
        
        return altura;
    }

    public boolean fragmento(Imagem i){
        for(int x = 0; x < 4; x++){
            if(this.fragmentoImagem(i) == true)
                return true;
            i.rotacionarMatrizHorario();
        }
        return false;
    }

    private void alocar(Imagem i,int auxA, int auxB){

        for(int x = 0, a = auxA; x < i.getAltura() && a < this.getAltura(); x++, a++){
            for(int y = 0, b = auxB; y < i.getLargura() && b < this.getLargura(); y++, b++){
                this.modificarPixel(x, y, i.get(a, b));
                
            }
        }
    }

    private boolean fragmentoImagem(Imagem i){
        
        Imagem aux = new Imagem(i.getAltura(),i.getLargura());
        for(int x = 0; x < this.getAltura(); x++){
            for(int y = 0; y < this.getLargura(); y++){
                aux.alocar(this, x, y);
                if(aux.equals(i))
                    return true;
            }
        }

        return false;
    }
}
