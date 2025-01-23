import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        int numero = -1;
        Scanner teclado = new Scanner(System.in);
        do{
            numero = teclado.nextInt();
            if(numero != 0) {
                try{
                    FilaCartas filaCartas = new FilaCartas(numero);
                    for(int i = 1; i <= numero; i++) {
                        filaCartas.enfileirar(i);
                    }
                    System.out.print("Discarted cards: ");
                    while (filaCartas.tamanho != 1) {
                        if(filaCartas.tamanho == 2) {
                            System.out.print(filaCartas.desenfileirar() + " ");
                        }else {
                            System.out.print(filaCartas.desenfileirar() + ", ");
                        }
                        filaCartas.enfileirar(filaCartas.desenfileirar());
                    }
                    System.out.println("\nRemaining cards: " + filaCartas.desenfileirar() + "\n");
                }catch(Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }while(numero != 0);
        teclado.close();
    }
}
