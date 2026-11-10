<#include "cabecalho.ftlh">

<h1>Sugestões de Leitura</h1>

<#if sugestoes?size == 0>

    <p>Nenhuma sugestão cadastrada.</p>

<#else>

    <ul>
        <#list sugestoes as sugestao>
            <li>
                ${sugestao.nomeCliente} sugeriu
                <strong>${sugestao.livroSugerido}</strong>
                - <a href="/sugestoes/${sugestao.id?c}/editar">Editar</a>
                - <a href="/sugestoes/${sugestao.id?c}/excluir">Remover</a>
            </li>
        </#list>
    </ul>

</#if>

<#if enviada?? && enviada>
    <p>Sugestão enviada com sucesso!</p>
</#if>

</body>
</html>