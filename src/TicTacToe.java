public class TicTacToe {

    private char [][] tablero = new char[3][3];
    private char player1='X';
    private char player2='O';
    private String nombrePlayer1="";
    private String nombrePlayer2="";
    int conteoPlayer1=0;
    int conteoPlayer2=0;

    public TicTacToe(String namePlayer1, String namePlayer2){
        for (int i = 0; i < getTablero().length; i++) {
            for (int j = 0; j < getTablero().length; j++) {
                getTablero()[i][j]='-';
            }
        }

        this.setNombrePlayer1(namePlayer1);
        this.setNombrePlayer2(namePlayer2);

    }

    public void draw(){
        for (int i = 0; i < getTablero().length; i++) {
            for (int j = 0; j < getTablero()[i].length; j++) {
                System.out.print(getTablero()[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void jugarPlayer(int indiceI,int indiceJ,int player){
        if(getTablero()[indiceI][indiceJ]=='-'){
            if(player==1){
                getTablero()[indiceI][indiceJ]= getPlayer1();
            }else{
                getTablero()[indiceI][indiceJ]= getPlayer2();
            }
        }else{
            System.out.println("Esa celda ya estaba seleccionada. Pierdes turno");
        }



    }

    public boolean check(){

        if(!completado()){
            if(horizontal()||vertical()||diagonalAscendente()||diagonalDescendente()){
                return true;
            }else{
                return false;
            }
        }else{
            end();
            return true;
        }


    }

    public boolean horizontal(){

        //buscador de horizontales iguales
        for (int i = 0; i < getTablero().length; i++) {
            conteoPlayer1=0;
            conteoPlayer2=0;
            for (int j = 0; j < getTablero()[i].length ; j++) {

                if(getTablero()[i][j]=='X'){
                    conteoPlayer1++;
                }
                if(getTablero()[i][j]=='O'){
                    conteoPlayer2++;
                }
            }
            if (conteoPlayer1>2){
                winner(1);
                return true;
            }

            if(conteoPlayer2>2){
                winner(2);
                return true;
            }

        }



        return false;
    }

    public boolean vertical(){

        //buscador de verticales
        for (int i = 0; i < getTablero().length; i++) {
            conteoPlayer1=0;
            conteoPlayer2=0;
            for (int j = 0; j < getTablero().length; j++) {

                if (getTablero()[j][i] == 'X') {
                    conteoPlayer1++;
                }
                if (getTablero()[j][i] == 'O') {
                    conteoPlayer2++;
                }
            }
            if (conteoPlayer1>2){
                winner(1);
                return true;
            }

            if(conteoPlayer2>2){
                winner(2);
                return true;
            }
        }



        return false;

    }

    public boolean diagonalDescendente(){

        //buscador de diagonales

        //Diagonal \

        conteoPlayer1=0;
        conteoPlayer2=0;

        for (int i = 0; i < getTablero().length; i++) {
            if(getTablero()[i][i]=='X'){
                conteoPlayer1++;
            }
            if(getTablero()[i][i]=='O'){
                conteoPlayer2++;
            }

        }
        if (conteoPlayer1>2){
            winner(1);
            return true;
        }

        if(conteoPlayer2>2){
            winner(2);
            return true;
        }
        return false;
    }

    public boolean diagonalAscendente(){
        //Diagonal /
        conteoPlayer1=0;
        conteoPlayer2=0;

        for (int i = getTablero().length-1; i >=0 ; i--) {
            if(getTablero()[i][getTablero().length-1-i]=='X'){
                conteoPlayer1++;
            }
            if(getTablero()[i][getTablero().length-1-i]=='O'){
                conteoPlayer2++;
            }
        }
        if (conteoPlayer1>2){
            winner(1);
            return true;
        }

        if(conteoPlayer2>2){
            winner(2);
            return true;
        }

        return false;
    }

    public boolean completado(){
        int conteoVacias=0;
        for (int i = 0; i < getTablero().length; i++) {
            for (int j = 0; j < getTablero().length; j++) {
                if (getTablero()[i][j]=='-'){
                    conteoVacias++;
                }
            }
        }
        if(conteoVacias==0){
            return true;
        }else{
            return false;
        }
    }

    public void winner(int ganador){
        if(ganador==1){
            System.out.println("Ha ganado : " + getNombrePlayer1());
        }
        if (ganador==2){
            System.out.println("Ha ganado : " + getNombrePlayer2());
        }
    }

    public void end(){
        System.out.println("El juego ha terminado en empate");
    }

    public void reset(){
        for (int i = 0; i < getTablero().length; i++) {
            for (int j = 0; j < getTablero().length; j++) {
                getTablero()[i][j]='-';
            }
        }
    }
    //GETTER AND SETTER

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public char getPlayer1() {
        return player1;
    }

    public void setPlayer1(char player1) {
        this.player1 = player1;
    }

    public char getPlayer2() {
        return player2;
    }

    public void setPlayer2(char player2) {
        this.player2 = player2;
    }

    public String getNombrePlayer1() {
        return nombrePlayer1;
    }

    public void setNombrePlayer1(String nombrePlayer1) {
        this.nombrePlayer1 = nombrePlayer1;
    }

    public String getNombrePlayer2() {
        return nombrePlayer2;
    }

    public void setNombrePlayer2(String nombrePlayer2) {
        this.nombrePlayer2 = nombrePlayer2;
    }
}