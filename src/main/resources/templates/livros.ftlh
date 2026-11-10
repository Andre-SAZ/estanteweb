<#include "cabecalho.ftlh">

<h1>Lista de Livros</h1>

<#if livros?size == 0>

    <p>Nenhum livro no acervo no momento.</p>

<#else>

    <ul>
        <#list livros as livro>
            <li>
                <a href="/livros/${livro.id?c}">${livro.titulo}</a> - ${livro.autor} - R$ ${livro.preco?c}
            </li>
        </#list>
    </ul>

</#if>

</body>
</html>
