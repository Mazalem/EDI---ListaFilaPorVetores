public class FilaSenhas {
    public int QDT_MAX = 3;
    public int inicio = 0, fim = 0, tamanho = 0, senhasRestantes = QDT_MAX;
    public String[] filaSenhas = new String[QDT_MAX];

    public void darSenha(String nome) throws Exception {
        if(todasDistribuidas()) {
            throw new Exception("Todas as senhas já foram distribuídas.");
        }
        filaSenhas[fim++] = nome;
        tamanho++;
        senhasRestantes--;
    }

    public String chamarAtendimento() throws Exception {
        if(isEmpty() || todasAtendidos()) {
            throw new Exception("Não há ninguém para chamar.");
        }
        String aux = filaSenhas[inicio];
        filaSenhas[inicio++] = null;
        tamanho--;
        return aux;
    }

    public boolean todasAtendidos() {
        return inicio == QDT_MAX;
    }

    public boolean todasDistribuidas() {
        return senhasRestantes == 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}