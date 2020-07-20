import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToe juego = new TicTacToe();
        boolean ganador=false;
        int i=1;

        while(!ganador){
            if(i==1){
                System.out.println("En que fila quieres poner tu ficha. Jugador 1");
                int indiceI=sc.nextInt();
                System.out.println("En que columna quieres poner tu ficha.  Jugador 1");
                int indiceJ=sc.nextInt();
                juego.jugarPlayer(indiceI,indiceJ,1);
                i++;
            }else{
                System.out.println("En que fila quieres poner tu ficha.  Jugador 2");
                int indiceI=sc.nextInt();
                System.out.println("En que columna quieres poner tu ficha. Jugador 2");
                int indiceJ=sc.nextInt();
                juego.jugarPlayer(indiceI,indiceJ,2);
                i--;
            }

            juego.draw();

            if(juego.check()){
                ganador=true;
            }
        }

    }
}
