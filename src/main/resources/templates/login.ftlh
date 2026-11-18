<#include "cabecalho.ftlh">

<h1>Login</h1>

<#if erro??>
    <p style="color: red;">${erro}</p>
</#if>

<form method="post" action="/login">

    <label for="email">E-mail:</label><br>
    <input type="email"
           id="email"
           name="email"
           value="${email!}"><br><br>

    <label for="senha">Senha:</label><br>
    <input type="password"
           id="senha"
           name="senha"><br><br>

    <button type="submit">Entrar</button>

</form>

</body>
</html>
