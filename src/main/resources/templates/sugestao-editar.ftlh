<#include "cabecalho.ftlh">

<h1>Editar Sugestão</h1>

<#if erro??>
    <p style="color: red;">${erro}</p>
</#if>

<form method="post" action="/sugestoes/${sugestao.id?c}">

    <label for="nomeCliente">Seu nome:</label><br>
    <input type="text"
           id="nomeCliente"
           name="nomeCliente"
           value="${sugestao.nomeCliente!}"><br><br>

    <label for="livroSugerido">Livro sugerido:</label><br>
    <input type="text"
           id="livroSugerido"
           name="livroSugerido"
           value="${sugestao.livroSugerido!}"><br><br>

    <button type="submit">Salvar Alterações</button>
    <a href="/sugestoes">Cancelar</a>

</form>

</body>
</html>
