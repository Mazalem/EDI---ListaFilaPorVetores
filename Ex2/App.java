import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int escolha;
        FilaProcessos filaProcessos = new FilaProcessos(3);
        Scanner teclado = new Scanner(System.in);

        do {
            escolha = -1;
            System.out.println("\n" + filaProcessos.tamanho + "/" + filaProcessos.processos.length + " processos na fila");
            System.out.println("1 - Incluir processo na Fila");
            System.out.println("2 - Chamar o primeiro processo da Fila");
            System.out.println("3 - Mostrar todos os processos da Fila");
            System.out.println("4 - Localizar processo na Fila por Id");
            System.out.println("5 - Retirar todos os processos da Fila");
            System.out.println("0 - Sair");
            while (escolha < 0 || escolha > 5) {
                System.out.print("Escolha (0-5): ");
                escolha = teclado.nextInt();
            }

            switch (escolha) {
                case 1:
                    if (filaProcessos.isFull()) {
                        System.err.println("A fila de processos já está cheia!");
                    } else {
                        String titulo;
                        System.out.print("Título do Processo: ");
                        titulo = teclado.next();
                        Processo p = new Processo(titulo);
                        try {
                            filaProcessos.enfileirar(p);
                            System.out.println("\nInserido na Fila com sucesso!");
                        } catch (Exception ex) {
                            System.err.println("Erro: A fila de processos já está cheia -> " + ex.getMessage());
                        }
                    }
                    break;
                case 2:
                    if (filaProcessos.isEmpty()) {
                        System.err.println("Não há processos na fila!");
                    } else {
                        try {
                            Processo aux = filaProcessos.desenfileirar();
                            System.out.println(
                                    "Chamando o processo -> Id: " + aux.getId() + " Titulo: " + aux.getTitulo());
                        } catch (Exception ex) {
                            System.err.println("Erro: A fila de processos está vazia -> " + ex.getMessage());
                        }
                    }
                    break;
                case 3:
                    if (filaProcessos.isEmpty()) {
                        System.err.println("Fila vazia!");
                    } else {
                        System.out.println();
                        for (int i = 0; i < filaProcessos.tamanho; i++) {
                            System.out.print("Id: " + filaProcessos.processos[i].getId());
                            System.out.println(" | Titulo: " + filaProcessos.processos[i].getTitulo());
                        }
                    }
                    break;
                case 4:
                    if (filaProcessos.isEmpty()) {
                        System.err.println("Fila vazia!");
                    } else {
                        int id;
                        System.out.print("Id do processo: ");
                        id = teclado.nextInt();
                        if (filaProcessos.verificaExistencia(id)) {
                            System.out.print("Id: " + filaProcessos.processos[id].getId());
                            System.out.println(" | Titulo: " + filaProcessos.processos[id].getTitulo());
                        } else {
                            System.err.println("O Id informado não corresponde a um processo em Fila.");
                        }
                    }
                    break;
                case 5:
                    if (filaProcessos.isEmpty()) {
                        System.err.println("Fila vazia!");
                    } else {
                        int confirmacao;
                        System.out.print("Tem certeza? (Digite 1 para confirmar): ");
                        confirmacao = teclado.nextInt();
                        if (confirmacao == 1) {
                            filaProcessos = new FilaProcessos(filaProcessos.processos.length);
                        }
                    }
                    break;
            }

        } while (escolha != 0);
        teclado.close();
    }
}
