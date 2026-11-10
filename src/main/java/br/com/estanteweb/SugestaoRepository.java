package br.com.estanteweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SugestaoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SugestaoRepository() {
    }

    public SugestaoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Salva uma nova sugestão no banco de dados
    public void salvar(Sugestao sugestao) {
        String sql = "INSERT INTO sugestao (nome_cliente, livro_sugerido) VALUES (?, ?)";
        jdbcTemplate.update(sql, sugestao.getNomeCliente(), sugestao.getLivroSugerido());
    }

    // Adiciona sugestão (mantido para compatibilidade se necessário)
    public void adicionar(Sugestao sugestao) {
        salvar(sugestao);
    }

    // Busca todas as sugestões do banco de dados (Desafio Missão 4.4)
    public List<Sugestao> listarTodas() {
        String sql = "SELECT * FROM sugestao";
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql);
        List<Sugestao> sugestoes = new ArrayList<>();
        for (Map<String, Object> linha : linhas) {
            sugestoes.add(Sugestao.deMap(linha));
        }
        return sugestoes;
    }

    // Busca uma sugestão pelo ID
    public Sugestao buscarPorId(Long id) {
        String sql = "SELECT * FROM sugestao WHERE id = ?";
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql, id);
        if (linhas.isEmpty()) {
            return null;
        }
        return Sugestao.deMap(linhas.get(0));
    }

    // Atualiza os dados de uma sugestão existente
    public void atualizar(Sugestao sugestao) {
        String sql = "UPDATE sugestao SET nome_cliente = ?, livro_sugerido = ? WHERE id = ?";
        jdbcTemplate.update(sql, sugestao.getNomeCliente(), sugestao.getLivroSugerido(), sugestao.getId());
    }

    // Remove uma sugestão do banco de dados pelo ID
    public void excluir(Long id) {
        String sql = "DELETE FROM sugestao WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
