package Modelo;

public class UsuarioAtual {

    private String useratual;
    private String tipo;

    public UsuarioAtual(String useratual, String tipo) {
        this.useratual = useratual;
        this.tipo = tipo;
    }

    public String getUseratual() {
        return useratual;
    }

    public void setUseratual(String useratual) {
        this.useratual = useratual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
