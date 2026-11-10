package br.com.estanteweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LivroRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LivroRepository() {
    }

    public LivroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Salva um novo livro no banco
    public void salvar(Livro livro) {
        String sql = "INSERT INTO livro (titulo, autor, ano, preco) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getPreco());
    }

    // Busca todos os livros no banco
    public List<Livro> listarTodos() {

        String sql = "SELECT * FROM livro";

        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql);

        List<Livro> livros = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livros.add(Livro.deMap(linha));
        }

        return livros;
    }

    // Mantém compatibilidade caso outro ponto chame listarTodas
    public List<Livro> listarTodas() {
        return listarTodos();
    }

    // Conta quantos livros existem no banco
    public int contarLivros() {

        String sql = "SELECT COUNT(*) FROM livro";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    // Busca livros até determinado preço
    public List<Livro> listarAtePreco(double precoMaximo) {

        String sql = "SELECT * FROM livro WHERE preco <= ?";

        List<Map<String, Object>> linhas =
                jdbcTemplate.queryForList(sql, precoMaximo);

        List<Livro> livrosAtePreco = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livrosAtePreco.add(Livro.deMap(linha));
        }

        return livrosAtePreco;
    }

    // Soma o preço de todos os livros (Desafio Missão 4.4)
    public double somarValorAcervo() {

        String sql = "SELECT SUM(preco) FROM livro";

        Double total = jdbcTemplate.queryForObject(sql, Double.class);

        return total != null ? total : 0.0;
    }

    // Alias para manter compatibilidade com implementações existentes
    public double valorTotal() {
        return somarValorAcervo();
    }

    // Missão 1.1: Busca um livro pelo ID
    public Livro buscarPorId(Long id) {

        String sql = "SELECT * FROM livro WHERE id = ?";

        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql, id);

        if (linhas.isEmpty()) {
            return null;
        }

        return Livro.deMap(linhas.get(0));
    }

    // Missão 4.2: Lista livros ordenados por coluna permitida
    public List<Livro> listarOrdenadoPor(String coluna) {

        if (coluna == null || (!coluna.equals("titulo")
                && !coluna.equals("autor")
                && !coluna.equals("ano")
                && !coluna.equals("preco"))) {
            return listarTodos();
        }

        String sql = "SELECT * FROM livro ORDER BY " + coluna;

        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql);

        List<Livro> livros = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livros.add(Livro.deMap(linha));
        }

        return livros;
    }

    // Missão 4.4 (Desafio): Lista outros livros do mesmo autor
    public List<Livro> listarDoMesmoAutor(String autor, Long idAtual) {

        String sql = "SELECT * FROM livro WHERE autor = ? AND id <> ?";

        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(sql, autor, idAtual);

        List<Livro> livros = new ArrayList<>();

        for (Map<String, Object> linha : linhas) {
            livros.add(Livro.deMap(linha));
        }

        return livros;
    }
}
