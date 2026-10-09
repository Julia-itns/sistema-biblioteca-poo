public class Revista extends Material{
    private int numero;

    public Revista(String titulo, String autor, int numero) {
        super(titulo, autor);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() + " | Número: " + numero;
    }
}
