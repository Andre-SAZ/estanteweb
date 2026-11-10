package br.com.estanteweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class TesteController {

    @GetMapping("/ola")
    public String teste(Model model) {
        //model.addAttribute("nome", "Gabs");
        model.addAttribute("idade", 1998);
        return "ola";
    }
}

/*
Seja Muito bem vindo(a) FreeMarker template error (DEBUG mode; use RETHROW in production!): The following has evaluated to 
null or missing: ==> nome [in template "ola.ftlh" at line 1, column 31] ---- Tip: If the failing expression is known to 
legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, 
or use <#if myOptionalVar??>when-present<#else>when-missing.
*/