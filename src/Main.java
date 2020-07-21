import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean ganador=false;
        boolean seguirJugando=true;
        int i=1;

        System.out.println("Como se llama el jugador 1");
        String nombreplayer1 = sc.nextLine();

        System.out.println("Como se llama el jugador 2");
        String nombreplayer2 = sc.nextLine();
        TicTacToe juego = new TicTacToe(nombreplayer1,nombreplayer2);


        while(seguirJugando){
            while(!ganador){
                if(i==1){
                    System.out.println("En que fila quieres poner tu ficha "+juego.getNombrePlayer1());
                    int indiceI=sc.nextInt();
                    System.out.println("En que columna quieres poner tu ficha "+juego.getNombrePlayer1());
                    int indiceJ=sc.nextInt();
                    juego.jugarPlayer(indiceI,indiceJ,1);
                    i++;
                }else{
                    System.out.println("En que fila quieres poner tu ficha "+juego.getNombrePlayer2());
                    int indiceI=sc.nextInt();
                    System.out.println("En que columna quieres poner tu ficha "+juego.getNombrePlayer2());
                    int indiceJ=sc.nextInt();
                    juego.jugarPlayer(indiceI,indiceJ,2);
                    i--;
                }

                juego.draw();

                if(juego.check()){
                    ganador=true;
                }
            }

            sc.nextLine();

            System.out.println("¿Quieres seguir jugando?");
            String echarOtraPartida= sc.nextLine().toLowerCase();

            if(echarOtraPartida.equals("no")){
                seguirJugando=false;
            }else{
                ganador=false;
                juego.reset();
            }
        }


    }
}
