import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int escolha;
        FilaSenhas fila = new FilaSenhas();
        try (Scanner teclado = new Scanner(System.in)) {
            do {
                System.out.println("\n");
                escolha = -1;
                System.out.println(fila.senhasRestantes + " senhas disponíveis.");
                System.out.println(fila.tamanho + " pessoas na fila.");
                System.out.println("Escolha sua sua opção:");
                System.out.println("1 - Chamar primeiro da Fila");
                System.out.println("2 - Gerar Senha");
                System.out.println("0 - Sair");
                while (escolha < 0 || escolha > 2) {
                    System.out.print("Opção: ");
                    escolha = teclado.nextInt();
                }
                
                switch (escolha) {
                    case 1:
                        System.out.println("\n");
                        if(fila.isEmpty()) {
                            System.out.println("Fila Vazia");
                        } else{
                            try {
                                System.out.println("O primeiro da fila é: " + fila.chamarAtendimento());
                            } catch (Exception ex) {
                                System.err.println("Erro: Fila vazia -> " + ex.getMessage());
                            }
                        }
                        break;
                    case 2:
                        if(fila.todasDistribuidas()) {
                            System.out.println("\n");
                            System.err.println("Todas as senhas já foram distribuídas");
                        }else {
                            System.out.println("\n");
                            String nome;
                            System.out.print("Qual nome vai na senha? ");
                            nome = teclado.next();
                            try {
                                fila.darSenha(nome);
                            } catch (Exception ex) {
                                System.err.println("Erro: Todas as senhas já foram distribuídas -> " + ex.getMessage());
                            }
                        }
                        break;
                }
                
            } while (escolha != 0);
        }
    }
}
