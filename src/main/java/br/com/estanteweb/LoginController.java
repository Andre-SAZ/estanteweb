package br.com.estanteweb;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String entrar(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String senha,
            HttpSession session,
            Model model) {

        Usuario usuario = (email != null && !email.isBlank()) ? usuarioRepository.buscarPorEmail(email) : null;

        if (usuario == null || senha == null || !usuario.getSenha().equals(senha)) {
            model.addAttribute("erro", "E-mail ou senha inválidos.");
            model.addAttribute("email", email);
            return "login";
        }

        session.setAttribute("usuarioLogado", usuario);
        return "redirect:/livros/html";
    }

    @PostMapping("/logout")
    public String sair(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
