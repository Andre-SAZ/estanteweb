<#include "cabecalho.ftlh">

<h1>Editar Livro</h1>

<#if erro??>
    <p style="color: red;">${erro}</p>
</#if>

<form method="post" action="/livros/${livro.id?c}">

    <label for="titulo">Título:</label><br>
    <input type="text"
           id="titulo"
           name="titulo"
           value="${livro.titulo!}"><br><br>

    <label for="autor">Autor:</label><br>
    <input type="text"
           id="autor"
           name="autor"
           value="${livro.autor!}"><br><br>

    <label for="ano">Ano:</label><br>
    <input type="number"
           id="ano"
           name="ano"
           value="${(livro.ano?c)!}"><br><br>

    <label for="preco">Preço:</label><br>
    <input type="number"
           step="0.01"
           id="preco"
           name="preco"
           value="${(livro.preco?c)!}"><br><br>

    <button type="submit">Salvar Alterações</button>
    <a href="/livros/${livro.id?c}">Cancelar</a>

</form>

</body>
</html>
