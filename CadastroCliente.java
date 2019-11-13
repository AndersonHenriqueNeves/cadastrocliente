package cadastrocliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroCliente extends JFrame implements
        ActionListener {

    private RepositorioCadastro rep;
    JLabel L0, L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15;
    JButton b1, b2, b3, b4;
    JTextField tfCPF, tfNome, tfSobrenome, tfCEP, tfTelefone;
    JPanel p1 = new JPanel();

    public static void main(String args[]) {
        JFrame Janela = new CadastroCliente();
        Janela.show();
        WindowListener x = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        Janela.addWindowListener(x);
    }

    public CadastroCliente() {
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setSize(new Dimension(600, 120));
        L0 = new JLabel(" Cadastro Cliente ");
        L0.setFont(new Font("Dimitri", Font.ITALIC + Font.BOLD,30));
        L0.setForeground(new Color(100, 65, 165));
        L9 = new JLabel(" Dados : ");
        L9.setForeground(new Color(100, 65, 165));
        L9.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 30));
        L1 = new JLabel("CPF: ");
        L2 = new JLabel("Nome: ");
        L3 = new JLabel("Sobrenome: ");
        L4 = new JLabel("CEP: ");
        L5 = new JLabel("Telefone: ");
        L6 = new JLabel(" ");
        for (int i = 0; i < 180; i++) {
            L6.setText(L6.getText() + " ");
        }
        L7 = new JLabel(" ");
        for (int i = 0; i < 40; i++) {
            L7.setText(L7.getText() + " ");
        }
        L8 = new JLabel(" ");
        for (int i = 0; i < 200; i++) {
            L8.setText(L8.getText() + " ");
        }
        L10 = new JLabel(" ");
        for (int i = 0; i < 60; i++) {
            L10.setText(L10.getText() + " ");
        }
        L11 = new JLabel(" ");
        for (int i = 0; i < 30; i++) {
            L11.setText(L11.getText() + " ");
        }
        L12 = new JLabel(" ");
        for (int i = 0; i < 30; i++) {
            L12.setText(L12.getText() + " ");
        }
        L13 = new JLabel(" ");
        for (int i = 0; i < 40; i++) {
            L13.setText(L13.getText() + " ");
        }
        L14 = new JLabel(" ");
        for (int i = 0; i < 30; i++) {
            L14.setText(L14.getText() + " ");
        }
        L15 = new JLabel(" ");
        for (int i = 0; i < 60; i++) {
            L15.setText(L15.getText() + " ");
        }
        tfCPF = new JTextField(11);
        tfNome = new JTextField(15);
        tfSobrenome = new JTextField(15);
        tfCEP = new JTextField(8);
        tfTelefone = new JTextField(11);
        b1 = new JButton("Inserir");
        b2 = new JButton("Consultar");
        b3 = new JButton("Alterar");
        b4 = new JButton("Remover");
        b1.setBackground(new Color(100, 65, 165));
        b1.setForeground(Color.white);
        b2.setBackground(new Color(100, 65, 165));
        b2.setForeground(Color.white);
        b3.setBackground(new Color(100, 65, 165));
        b3.setForeground(Color.white);
        b4.setBackground(new Color(100, 65, 165));
        b4.setForeground(Color.white);
        p1.add(L13);
        p1.add(L0);
        p1.add(L10);
        p1.add(L9);
        p1.add(L15);
        p1.add(L1);
        p1.add(tfCPF);
        p1.add(L2);
        p1.add(tfNome);
        p1.add(L11);
        p1.add(L3);
        p1.add(tfSobrenome);
        p1.add(L4);
        p1.add(tfCEP);
        p1.add(L12);
        p1.add(L5);
        p1.add(tfTelefone);
        p1.add(L7);
        p1.add(L8);
        p1.add(L14);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        getContentPane().add(p1);
        setTitle("Cadastro de Cliente");
        setSize(550, 300);
        rep = new RepositorioCadastro(100);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void limpa_campos() {
        tfCPF.setText("");
        tfNome.setText("");
        tfSobrenome.setText("");
        tfCEP.setText("");
        tfTelefone.setText("");

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                long CPF = Long.parseLong(this.tfCPF.getText());
                String nome = tfNome.getText();
                String sobrenome = tfSobrenome.getText();
                int CEP = Integer.parseInt(this.tfCEP.getText());
                int telefone = Integer.parseInt(this.tfTelefone.getText());
                Cliente i = new Cliente(CPF, nome, sobrenome, CEP, telefone);
                if (rep.inserir(i)) {
                    JOptionPane.showMessageDialog(this, "Cliente inserido com sucesso");
                    limpa_campos();
                } else {
                    JOptionPane.showMessageDialog(this, "Repositório cheio");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        if (e.getSource() == b2) {
            try {

                Cliente c = rep.procurar(Long.parseLong(tfCPF.getText()));
                if (c != null) {
                    tfNome.setText(c.getNome());
                    tfSobrenome.setText(c.getSobrenome());
                    tfCEP.setText("" + c.getCEP());
                    tfTelefone.setText("" + c.getTelefone());

                } else {
                    JOptionPane.showMessageDialog(this, "Cliente não localizado");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

        if (e.getSource() == b3) {
            try {
                long CPF = Long.parseLong(this.tfCPF.getText());
                String nome = tfNome.getText();
                String sobrenome = tfSobrenome.getText();
                int CEP = Integer.parseInt(this.tfCEP.getText());
                int telefone = Integer.parseInt(this.tfTelefone.getText());
                Cliente i = new Cliente(CPF, nome, sobrenome, CEP, telefone);
                if (rep.atualizar(i)) {
                    JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso");
                    limpa_campos();
                } else {
                    JOptionPane.showMessageDialog(this, "Cliente não encontrado");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

        if (e.getSource() == b4) {
            if (rep.remover(Long.parseLong(tfCPF.getText()))) {
                JOptionPane.showMessageDialog(this, "Cliente removido com sucesso");
                limpa_campos();
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não localizado");
            }
        }
    }
}
