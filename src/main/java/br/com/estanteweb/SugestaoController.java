package br.com.estanteweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class SugestaoController {

    @Autowired
    private SugestaoRepository repositorio;

    public SugestaoController() {
    }

    public SugestaoController(SugestaoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/sugestoes/nova")
    public String novaSugestao() {
        return "sugestao-nova";
    }

    @PostMapping("/sugestoes")
    public String salvarSugestao(
            @RequestParam String nomeCliente,
            @RequestParam String livroSugerido,
            Model model) {

        if (nomeCliente == null || nomeCliente.isBlank()
                || livroSugerido == null || livroSugerido.isBlank()) {

            model.addAttribute("erro", "Preencha seu nome e o livro sugerido.");
            model.addAttribute("nomeCliente", nomeCliente);
            model.addAttribute("livroSugerido", livroSugerido);

            return "sugestao-nova";
        }

        Sugestao sugestao = new Sugestao();
        sugestao.setNomeCliente(nomeCliente);
        sugestao.setLivroSugerido(livroSugerido);

        repositorio.salvar(sugestao);

        return "redirect:/sugestoes?enviada=true";
    }

    @GetMapping("/sugestoes")
    public String listarSugestoes(
            @RequestParam(required = false) Boolean enviada,
            Model model) {

        model.addAttribute("sugestoes", repositorio.listarTodas());
        model.addAttribute("enviada", enviada);

        return "sugestoes";
    }

    @GetMapping("/sugestoes/{id}/editar")
    public String editarSugestao(@PathVariable Long id, Model model) {
        Sugestao sugestao = repositorio.buscarPorId(id);
        if (sugestao == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("sugestao", sugestao);
        return "sugestao-editar";
    }

    @PostMapping({"/sugestoes/{id}", "/sugestoes/{id}/editar"})
    public String salvarEdicaoSugestao(
            @PathVariable Long id,
            @RequestParam(required = false) String nomeCliente,
            @RequestParam(required = false) String livroSugerido,
            Model model) {

        Sugestao existente = repositorio.buscarPorId(id);
        if (existente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (nomeCliente == null || nomeCliente.isBlank()
                || livroSugerido == null || livroSugerido.isBlank()) {

            Sugestao sugestao = new Sugestao();
            sugestao.setId(id);
            sugestao.setNomeCliente(nomeCliente);
            sugestao.setLivroSugerido(livroSugerido);

            model.addAttribute("erro", "Preencha seu nome e o livro sugerido.");
            model.addAttribute("sugestao", sugestao);

            return "sugestao-editar";
        }

        Sugestao sugestao = new Sugestao();
        sugestao.setId(id);
        sugestao.setNomeCliente(nomeCliente);
        sugestao.setLivroSugerido(livroSugerido);

        repositorio.atualizar(sugestao);

        return "redirect:/sugestoes";
    }

    @GetMapping("/sugestoes/{id}/excluir")
    public String confirmarExclusaoSugestao(@PathVariable Long id, Model model) {
        Sugestao sugestao = repositorio.buscarPorId(id);
        if (sugestao == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("sugestao", sugestao);
        return "sugestao-excluir";
    }

    @PostMapping("/sugestoes/{id}/excluir")
    public String excluirSugestao(@PathVariable Long id) {
        Sugestao sugestao = repositorio.buscarPorId(id);
        if (sugestao == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repositorio.excluir(id);
        return "redirect:/sugestoes";
    }

}
