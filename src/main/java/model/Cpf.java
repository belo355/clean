package model;

public class Cpf {

    private String numero;

    public Cpf(String numero) {
        if(numero == null || numero.length() < 12 || !numero.matches("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$")){
            throw new IllegalArgumentException("CPF informado é invalido");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
