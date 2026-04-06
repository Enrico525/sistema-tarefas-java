package javaapplication4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private int usuarioId;

    // CONSTRUTOR
    public Tarefa(String titulo, String descricao, String status, int usuarioId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.usuarioId = usuarioId;
    }

    public Tarefa(String text, String text1, Usuario usuario) {}

    // GETTERS E SETTERS
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getStatus() { return status; }
    public int getUsuarioId() { return usuarioId; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setStatus(String status) { this.status = status; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    // =========================
    // SALVAR NO BANCO
    // =========================
    public void salvar() {
        String sql = "INSERT INTO tarefas (titulo, descricao, status, usuario_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, descricao);
            stmt.setString(3, status);
            stmt.setInt(4, usuarioId);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // LISTAR TAREFAS
    // =========================
    public static List<Tarefa> listar(int usuarioId) {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarefas WHERE usuario_id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tarefa t = new Tarefa(titulo.getText(), desc.getText(), usuario);
                t.setId(rs.getInt("id"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescricao(rs.getString("descricao"));
                t.setStatus(rs.getString("status"));
                t.setUsuarioId(rs.getInt("usuario_id"));

                lista.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String toString() {
        return titulo + " - " + status;
    }
}