package javaapplication4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;

    // CONSTRUTOR
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    // =========================
    // 🔵 CADASTRAR NO BANCO
    // =========================
    public void salvar() {
        try {
            Connection conn = Conexao.conectar();

            String sql = "INSERT INTO usuarios(nome, email, senha) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário:");
            e.printStackTrace();
        }
    }

    // =========================
    // 🔐 LOGIN / AUTENTICAÇÃO
    // =========================
    public static Usuario autenticar(String email, String senha) {
        try {
            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );

                u.id = rs.getInt("id");

                rs.close();
                ps.close();
                conn.close();

                return u;
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Erro no login:");
            e.printStackTrace();
        }

        return null;
    }

    boolean login(String enricoemailcom, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}