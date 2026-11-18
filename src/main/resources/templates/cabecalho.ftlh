<nav>
    <a href="/livros/html">Livros</a> |
    <#if usuarioLogado??>
        <a href="/livros/novo">Novo Livro</a> |
    </#if>
    <a href="/sugestoes">Sugestões</a> |
    <a href="/sugestoes/nova">Nova Sugestão</a> |
    <a href="/contato">Contato</a> |
    <#if usuarioLogado??>
        <span>Olá, ${usuarioLogado.nome}</span>
        <form method="post" action="/logout" style="display:inline; margin-left: 5px;">
            <button type="submit">Sair</button>
        </form>
    <#else>
        <a href="/login">Entrar</a>
    </#if>
</nav>
<hr>
