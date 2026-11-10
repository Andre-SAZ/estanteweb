<#include "cabecalho.ftlh">

<h1>Remover Livro</h1>

<p>Tem certeza de que deseja remover o seguinte livro do acervo?</p>

<p><strong>Título:</strong> ${livro.titulo}</p>
<p><strong>Autor:</strong> ${livro.autor}</p>
<p><strong>Ano:</strong> ${livro.ano?c}</p>
<p><strong>Preço:</strong> R$ ${livro.preco?c}</p>

<form method="post" action="/livros/${livro.id?c}/excluir">
    <button type="submit">Confirmar Remoção</button>
    <a href="/livros/${livro.id?c}">Desistir</a>
</form>

</body>
</html>
