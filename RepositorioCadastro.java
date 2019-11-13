package cadastrocliente;

class RepositorioCadastro {

    private Cliente[] clientes;
    private int indice;

    public RepositorioCadastro(int tamanho) {
        clientes = new Cliente[tamanho];
        indice = 0;
    }

    private int procurarIndice(long CPF) {
        int i = 0;
        boolean achou;
        for (achou = false; !achou && i < indice;) {
            if (clientes[i].getCPF() == CPF) {
                achou = true;
            } else {
                i++;
            }
        }
        if (!achou) {
            i = -1;
        }
        return i;
    }

    public Cliente procurar(long CPF) {
        Cliente c = null;
        int i = procurarIndice(CPF);
        if (i == -1) {
            return null;
        } else {
            c = clientes[i];
            return c;
        }
    }

    public boolean inserir(Cliente c) {
        if (indice < clientes.length) {
            if (c != null) {
                if (procurar(c.getCPF()) == null) {
                    clientes[indice] = c;
                    indice = indice + 1;
                    return true;
                } else {
                    throw new IllegalArgumentException("Cliente já cadastrado");
                }
            } else {
                throw new NullPointerException("Cliente inválido");
            }
        } else {
            return false;
        }
    }

    public boolean atualizar(Cliente c) {
        int i = procurarIndice(c.getCPF());
        if (i != -1) {
            clientes[i] = c;
            return true;
        } else {
            return false;
        }
    }

    public boolean remover(long CPF) {
        int i = procurarIndice(CPF);
        if (i != -1) {
            indice = indice - 1;
            clientes[i] = clientes[indice];
            clientes[indice] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean existe(long CPF) {
        int i = procurarIndice(CPF);
        return i != -1;
    }
}
