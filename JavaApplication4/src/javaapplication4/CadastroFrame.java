package javaapplication4;

import javax.swing.*;

public class CadastroFrame extends JFrame {

    public CadastroFrame() {
        setTitle("Cadastro");
        setSize(300, 250);
        setLayout(null);

        JTextField nome = new JTextField();
        nome.setBounds(100, 20, 150, 25);
        add(new JLabel("Nome:")).setBounds(20,20,80,25);
        add(nome);

        JTextField email = new JTextField();
        email.setBounds(100, 60, 150, 25);
        add(new JLabel("Email:")).setBounds(20,60,80,25);
        add(email);

        JPasswordField senha = new JPasswordField();
        senha.setBounds(100, 100, 150, 25);
        add(new JLabel("Senha:")).setBounds(20,100,80,25);
        add(senha);

        JButton btn = new JButton("Cadastrar");
        btn.setBounds(100, 140, 120, 30);
        add(btn);

        btn.addActionListener(e -> {
           Usuario u = new Usuario(nome.getText(), email.getText(), new String(senha.getPassword()));
u.salvar();
            JOptionPane.showMessageDialog(null, "Cadastrado!");
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }
}