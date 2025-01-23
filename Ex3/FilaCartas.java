public class FilaCartas {
    public int inicio = 0;
    public int fim = 0;
    public int tamanho = 0;
    public Integer[] fila;

    public FilaCartas(int tamanho) throws Exception {
        if(tamanho <= 0 || tamanho > 50) {
            throw new Exception("Tamanho inválido.");
        }
        fila = new Integer[tamanho];
    }

    public void enfileirar(int carta) throws Exception {
        if(isFull()) {
            throw new Exception("Fila cheia.");
        }
        fila[fim++] = carta;
        if(fim == fila.length) {
            fim = 0;
        }
        tamanho++;
    }

    public int desenfileirar() throws Exception {
        if(isEmpty()) {
            throw new Exception("Fila vazia");
        }
        int apoio = fila[inicio];
        fila[inicio++] = null;
        if(inicio == fila.length) {
            inicio = 0;
        }
        tamanho--;
        return apoio;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

}
