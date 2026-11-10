<#include "cabecalho.ftlh">

<h1>Lista de Livros</h1>

<#if livros?size == 0>

    <p>Nenhum livro no acervo no momento.</p>

<#else>

    <ul>
        <#list livros as livro>
            <li>
                <a href="/livros/${livro.id?c}">${livro.titulo}</a> - ${livro.autor} - R$ ${livro.preco?c}
                <form method="post" action="/livros/${livro.id?c}/excluir" style="display:inline; margin-left: 10px;" onsubmit="return confirm('Deseja realmente remover o livro: ${livro.titulo?js_string}?');">
                    <button type="submit">Remover</button>
                </form>
            </li>
        </#list>
    </ul>

</#if>

</body>
</html>
