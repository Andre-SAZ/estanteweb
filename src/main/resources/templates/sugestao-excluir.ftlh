<#include "cabecalho.ftlh">

<h1>Remover Sugestão</h1>

<p>Tem certeza de que deseja remover a sugestão feita por <strong>${sugestao.nomeCliente}</strong> para o livro <strong>${sugestao.livroSugerido}</strong>?</p>

<form method="post" action="/sugestoes/${sugestao.id?c}/excluir">
    <button type="submit">Confirmar Remoção</button>
    <a href="/sugestoes">Desistir</a>
</form>

</body>
</html>
