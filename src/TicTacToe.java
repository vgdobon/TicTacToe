public class TicTacToe {

    char [][] tablero = new char[3][3];
    char player1='X';
    char player2='O';

    public TicTacToe(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j]='-';
            }
        }

    }

    public void draw(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void jugarPlayer(int indiceI,int indiceJ,int player){
        if(tablero[indiceI][indiceJ]=='-'){
            if(player==1){
                tablero[indiceI][indiceJ]=player1;
            }else{
                tablero[indiceI][indiceJ]=player2;
            }
        }else{
            System.out.println("Esa celda ya estaba seleccionada. Pierdes turno");
        }



    }

    public boolean check(){
        int conteoPlayer1=0;
        int conteoPlayer2=0;

        //buscador de horizontales iguales
        for (int i = 0; i < tablero.length; i++) {
            conteoPlayer1=0;
            conteoPlayer2=0;
            for (int j = 0; j < tablero[i].length ; j++) {

                if(tablero[i][j]=='X'){
                    conteoPlayer1++;
                }
                if(tablero[i][j]=='O'){
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
        conteoPlayer1=0;
        conteoPlayer2=0;

        //buscador de verticales
        for (int i = 0; i < tablero.length; i++) {
            conteoPlayer1=0;
            conteoPlayer2=0;
            for (int j = 0; j < tablero.length ; j++) {

                if(tablero[j][i]=='X'){
                    conteoPlayer1++;
                }
                if(tablero[j][i]=='O'){
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
        conteoPlayer1=0;
        conteoPlayer2=0;

        //buscador de diagonales

        //Diagonal \

        for (int i = 0; i < tablero.length; i++) {
            if(tablero[i][i]=='X'){
                conteoPlayer1++;
            }
            if(tablero[i][i]=='O'){
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

        //Diagonal /

        conteoPlayer1=0;
        conteoPlayer2=0;

        for (int i = tablero.length-1; i >=0 ; i--) {
            if(tablero[i][tablero.length-1-i]=='X'){
                conteoPlayer1++;
            }
            if(tablero[i][tablero.length-1-i]=='O'){
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

    public void winner(int ganador){
        if(ganador==1){
            System.out.println("Ha ganado el jugador 1");
        }
        if (ganador==2){
            System.out.println("Ha ganado el jugador 2");
        }
    }
}
