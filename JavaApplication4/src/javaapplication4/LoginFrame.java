package javaapplication4;

import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 20, 80, 25);
        add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 20, 150, 25);
        add(txtEmail);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 60, 80, 25);
        add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 60, 150, 25);
        add(txtSenha);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBounds(100, 100, 100, 25);
        add(btnLogin);

        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.setBounds(100, 130, 100, 25);
        add(btnCadastro);

        btnLogin.addActionListener(e -> {
            Usuario u = Usuario.autenticar(txtEmail.getText(), new String(txtSenha.getPassword()));
            if (u != null) {
                dispose();
                new DashboardFrame(u);
            } else {
                JOptionPane.showMessageDialog(null, "Login inválido!");
            }
        });

        btnCadastro.addActionListener(e -> {
            dispose();
            new CadastroFrame();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}