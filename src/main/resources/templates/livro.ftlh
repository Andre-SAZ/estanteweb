<#include "cabecalho.ftlh">

<h1>${livro.titulo}</h1>

<p><strong>Autor:</strong> ${livro.autor}</p>
<p><strong>Ano:</strong> ${livro.ano?c}</p>
<p><strong>Preço:</strong> R$ ${livro.preco?c}</p>

<#if outrosDoAutor?? && (outrosDoAutor?size > 0)>
    <h2>Outros títulos de ${livro.autor}</h2>
    <ul>
        <#list outrosDoAutor as outro>
            <li>
                <a href="/livros/${outro.id?c}">${outro.titulo}</a> (${outro.ano?c}) - R$ ${outro.preco?c}
            </li>
        </#list>
    </ul>
</#if>

<p><a href="/livros/html">Voltar para o acervo</a></p>

</body>
</html>

