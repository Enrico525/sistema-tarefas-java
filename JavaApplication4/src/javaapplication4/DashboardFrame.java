package javaapplication4;

import javax.swing.*;

public class DashboardFrame extends JFrame {
 private Usuario usuario;
    DefaultListModel<Tarefa> model = new DefaultListModel<>();

    public DashboardFrame(Usuario usuario) {
        setTitle("Dashboard - " + usuario.getNome());
        setSize(400, 300);
        setLayout(null);

        JList<Tarefa> lista = new JList<>(model);
        lista.setBounds(20, 20, 200, 200);
        add(lista);

        JButton btnNova = new JButton("Nova");
        btnNova.setBounds(250, 20, 100, 30);
        add(btnNova);

        JButton btnConcluir = new JButton("Concluir");
        btnConcluir.setBounds(250, 60, 100, 30);
        add(btnConcluir);

        btnNova.addActionListener(e -> new NovaTarefaFrame(usuario, model));

        btnConcluir.addActionListener(e -> {
            Tarefa t = lista.getSelectedValue();
            if (t != null) {
                t.setStatus("Concluída");
                lista.repaint();
            }
        });

        setVisible(true);
        for (Tarefa t : Tarefa.listar(usuario.getId())) {
    model.addElement(t);
}
    }
}