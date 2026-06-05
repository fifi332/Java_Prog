public class Oficina {
    private String nome;
    private String direccion;
    private String localidade;
    private String provincia;

    public Oficina(String nome, String direccion, String localidade, String provincia) {
        this.nome = nome;
        this.direccion = direccion;
        this.localidade = localidade;
        this.provincia = provincia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Oficina {nome='" + nome + "', direccion='" + direccion + "', localidade='" + localidade + "', provincia='" + provincia + "'}";
    }
}