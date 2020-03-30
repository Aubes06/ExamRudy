<%@include file="../../templates/header.jsp"%>
<%@include file="../../templates/navigation.jsp"%>

<div class="container">
    <div class="alert alert-warning" role="alert">
        Voici les plats associés à la catégorie : ${category[0].label}.<hr>
        Il y a ${category[0].nbPlat} plat(s) associé(s).
    </div>

    <table class="table">
        <thead class="thead-warning">
        <tr>
            <th scope="col">Nom du plat</th>
            <th scope="col">Prix</th>
            <th scope="col">Description du plat</th>
            <th scope="col">Autre catégorie liée à ce plat</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dishesByCategoryID}" var="disheByCategoryID">
            <tr>
                <th scope="row"><a href="dishe?id=${disheByCategoryID.id}">${disheByCategoryID.label}</a></th>
                <td>${disheByCategoryID.price} &euro;</td>
                <td>${disheByCategoryID.description}</td>
                <td>?</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="container" id="content">
    <hr>
    <div class="row product_list mb-5">
        <c:forEach items="${dishesByCategoryID}" var="disheByCategoryID">
            <div class="card border-warning mb-3">
                <div class="card-header bg-warning border-warning"><a style="color:white;font-weight: bold;" title="Cliquez ici pour accèder à d'autres produits de la même catégorie" href="category?id=${disheByCategoryID.categoryId}">${disheByCategoryID.category}</a></div>
                <div class="card-body text-info">
                    <a href="dishe?id=${disheByCategoryID.id}">
                        <h5 class="card-title">${disheByCategoryID.label}</h5>
                        <p class="card-text" >
                            <img style="width: 220px;" src="<%=request.getContextPath()%>/img/dishes/${disheByCategoryID.id}.jpg" class="card-img-top" alt="${disheByCategoryID.label}">
                        </p>
                    </a>
                </div>
                <div class="card-footer bg-transparent border-warning" style="text-align: center;padding: 0.2em;min-height: 80px;">
                    <div>
                            ${disheByCategoryID.description}
                        <hr/>
                    </div>
                    <span class="btn btn-warning mx-auto col-md-10">${disheByCategoryID.price} &euro;</span>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<%@include file="../../templates/footer.jsp"%>
