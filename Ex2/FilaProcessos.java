public class FilaProcessos {
    public int inicio = 0, fim = 0, tamanho = 0;
    public Processo[] processos;

    public FilaProcessos(int tam) {
        processos = new Processo[tam];
    }

    public void enfileirar(Processo p) throws Exception {
        if (isFull()) {
            throw new Exception("A fila está cheia.");
        }
        p.setId(fim);
        processos[fim++] = p;
        if (fim == processos.length) {
            fim = 0;
        }
        tamanho++;
    }

    public Processo desenfileirar() throws Exception {
        if (isEmpty()) {
            throw new Exception("Não há nenhum processo para desenfileirar.");
        }
        Processo aux = processos[inicio];
        processos[inicio++] = null;
        if (inicio == processos.length) {
            inicio = 0;
        }
        tamanho--;
        return aux;
    }

    public boolean verificaExistencia(int id){
        if(id < 0 || id >= processos.length) {
            return false;
        }
        else{
            Processo aux = processos[id];
            if(aux == null) return false;
            else return true;
        }
    }

    public boolean isFull() {
        return tamanho == processos.length;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
