package javaapplication4;

import javax.swing.*;

public class NovaTarefaFrame extends JFrame {

    public NovaTarefaFrame(Usuario usuario, DefaultListModel<Tarefa> model) {
        setTitle("Nova Tarefa");
        setSize(300, 200);
        setLayout(null);

        JTextField titulo = new JTextField();
        titulo.setBounds(100, 20, 150, 25);
        add(new JLabel("Título:")).setBounds(20,20,80,25);
        add(titulo);

        JTextField desc = new JTextField();
        desc.setBounds(100, 60, 150, 25);
        add(new JLabel("Descrição:")).setBounds(20,60,80,25);
        add(desc);

        JButton salvar = new JButton("Salvar");
        salvar.setBounds(100, 100, 100, 30);
        add(salvar);

        salvar.addActionListener(e -> {
            Tarefa t = new Tarefa(titulo.getText(), desc.getText(), usuario);
            model.addElement(t);
            dispose();
        });

        setVisible(true);
        
    }
}