<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<c:set var = "catID" scope = "session" value = ""/>

<div class="container mt-3 mb-5">
    <div class="accordion" id="categories_dishes">

        <c:forEach items="${dishes_categories}" var="dishe">

            <c:if test = "${catID != ''}"><c:if test = "${catID != dishe.categoryId}">
                <form action="/ExamRudy1_war_exploded/dishe" method="post">
                <tr>
                    <td>
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="dishePicture" name="dishePicture" required>
                            <label class="custom-file-label" for="dishePicture">Photo</label>
                        </div>
                    </td>
                    <td>
                        <input type="text" class="form-control" id="DisLabel" name="DisLabel" placeholder="Nom du plat" value="" required>
                        <hr>
                        <input type="text" class="form-control" id="DisDescription" name="DisDescription" placeholder="Description du plat" value="">
                    </td>
                    <td>
                        <div>
                            <input type="text" class="form-control" id="DisPrice" name="DisPrice" placeholder="Prix" value="" required>
                        </div>
                    </td>
                    <td>
                        <input type="hidden" class="form-control" id="DisCategory" name="DisCategory" value="${dishe.categoryId}" required>
                        <input type="image" name="addDishe" width="32" src="<%=request.getContextPath()%>/img/add.png" alt="Ajouter" title="Ajouter" />
                    </td>
                </tr>
                </form>
                </table>
                </div>
                </div>
            </c:if></c:if>

            <c:if test = "${catID != dishe.categoryId}">
                <c:set var = "catID" scope = "session" value = "${dishe.categoryId}"/>

                <div class="card">
                    <div class="card-header" id="category${dishe.categoryId}">
                        <h2 class="mb-0">
                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseCat${dishe.categoryId}" aria-expanded="false" aria-controls="collapseCat${dishe.categoryId}">
                                ${dishe.category}
                            </button>
                        </h2>
                    </div>
                    <div id="collapseCat${dishe.categoryId}" class="collapse" aria-labelledby="category${dishe.categoryId}" data-parent="#categories_dishes">
                    <table id="categorie_and_dishes">
            </c:if>

            <c:if test = "${dishe.label != null}">
                        <tr>
                            <td>
                                <img style="width: 150px;border:1px solid orange;border-radius: 0.5em;" src="<%=request.getContextPath()%>/img/dishes/${dishe.id}.jpg" class="card-img-top" alt="${dishe.label}">
                            </td>
                            <td>
                                <span class="dishes_title">${dishe.label}</span><hr>
                                    ${dishe.description}
                            </td>
                            <td>
                                ${dishe.price} &euro;
                            </td>
                            <td>
                                <img width="32" src="<%=request.getContextPath()%>/img/edit.png" alt="Modifier" title="Modifier" />
                                <br/>
                                <img width="32" src="<%=request.getContextPath()%>/img/delete.png" alt="Supprimer" title="Supprimer" />
                            </td>
                        </tr>

            </c:if>
        </c:forEach>
                        </table>
                    </div>
                </div>
    </div>
</div>

<%@include file="../templates/footer.jsp"%>
