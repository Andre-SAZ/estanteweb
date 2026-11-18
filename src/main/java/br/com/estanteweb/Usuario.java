package br.com.estanteweb;

import java.util.Map;

public class Usuario {

    private long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public static Usuario deMap(Map<String, Object> linha) {
        Usuario usuario = new Usuario();
        if (linha.get("id") != null) {
            usuario.setId(((Number) linha.get("id")).longValue());
        }
        if (linha.get("nome") != null) {
            usuario.setNome((String) linha.get("nome"));
        }
        if (linha.get("email") != null) {
            usuario.setEmail((String) linha.get("email"));
        }
        if (linha.get("senha") != null) {
            usuario.setSenha((String) linha.get("senha"));
        }
        return usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

