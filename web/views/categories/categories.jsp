<%@include file="../../templates/header.jsp"%>
<%@include file="../../templates/navigation.jsp"%>

<div class="container">
    <div class="alert alert-warning" role="alert">
        Voici la listes de toutes nos catégories
    </div>

    <table class="table">
        <thead class="thead-warning">
        <tr>
            <th scope="col">Nom de la catégorie</th>
            <th scope="col">Nombre de plat</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <th scope="row"><a href="category?id=${category.id}">${category.label}</a></th>
                <td>${category.nbPlat}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../../templates/footer.jsp"%>
