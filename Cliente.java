package cadastrocliente;

class Cliente {

    private long CPF;
    private String nome;
    private String sobrenome;
    private int CEP;
    private int telefone;

    public Cliente(long CPF, String nome, String sobrenome, int CEP, int telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CEP = CEP;
        this.telefone = telefone;

    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
