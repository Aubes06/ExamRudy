<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<c:set var = "catID" scope = "session" value = ""/>

<div class="container mt-3 mb-5">
    <h4>Carte des plats</h4>
    <div class="accordion" id="categories_dishes">

        <c:forEach items="${dishes_categories}" var="dishe">

            <c:if test = "${catID != ''}"><c:if test = "${catID != dishe.categoryId}">
                <tr>
                    <td>
                        <form action="add-dishe" method="post">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="dishePicture${dishe.categoryId}" name="dishePicture" required>
                            <label class="custom-file-label" for="dishePicture${dishe.categoryId}">Photo</label>
                        </div>
                    </td>
                    <td>
                        <input type="text" class="form-control DisLabel" name="DisLabel" placeholder="Nom du plat" value="" required>
                        <hr>
                        <input type="text" class="form-control DisDescription" name="DisDescription" placeholder="Description du plat" value="">
                    </td>
                    <td>
                        <div style="text-align: right;">
                            <input type="text" class="form-control DisPrice" name="DisPrice" placeholder="Prix" value="" required>
                        </div>
                    </td>
                    <td>
                        <input type="hidden" class="form-control DisCategory" name="DisCategory" value="${catID}" required>
                        <input type="image" name="addDishe" width="32" src="<%=request.getContextPath()%>/img/add.png" alt="Ajouter" title="Ajouter" />
                        </form>
                    </td>
                </tr>
                </table>
                </div>
                </div>
            </c:if></c:if>

            <c:if test = "${catID != dishe.categoryId}">
                <c:set var = "catID" scope = "session" value = "${dishe.categoryId}"/>

                <div class="card">
                    <div class="card-header" id="category${dishe.categoryId}" type="button" data-toggle="collapse" data-target="#collapseCat${dishe.categoryId}" aria-expanded="false" aria-controls="collapseCat${dishe.categoryId}">
                        <span class="categoryTitle mb-0">${dishe.category}</span>
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
                                <a href="del-dishe?DisID=${dishe.id}"><img width="32" src="<%=request.getContextPath()%>/img/delete.png" alt="Supprimer" title="Supprimer" /></a>
                            </td>
                        </tr>

            </c:if>
        </c:forEach>
                    <tr>
                        <td>
                            <form action="add-dishe" method="post">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="dishePicture" name="dishePicture" required>
                                    <label class="custom-file-label" for="dishePicture">Photo</label>
                                </div>
                            </form>
                        </td>
                        <td>
                            <input type="text" class="form-control DisLabel" name="DisLabel" placeholder="Nom du plat" value="" required>
                            <hr>
                            <input type="text" class="form-control DisDescription" name="DisDescription" placeholder="Description du plat" value="">
                        </td>
                        <td>
                            <div style="text-align: right;">
                                <input type="text" class="form-control DisPrice" name="DisPrice" placeholder="Prix" value="" required>
                            </div>
                        </td>
                        <td>
                            <input type="hidden" class="form-control DisCategory" name="DisCategory" value="${catID}" required>
                            <input type="image" name="addDishe" width="32" src="<%=request.getContextPath()%>/img/add.png" alt="Ajouter" title="Ajouter" />
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

<div class="card">
    <div class="card-header" id="addCat" type="button" aria-expanded="true">
        <span class="categoryTitle mb-0">
            <form action="add-category" method="post">
              <div class="form-row">
                <div class="col">
                  <input type="text" class="form-control" name="CatLabel" placeholder="Libelé de la nouvelle catégorie">
                </div>
                <div class="col">
              <input type="image" name="addCat" width="32" src="<%=request.getContextPath()%>/img/add.png" alt="Ajouter" title="Ajouter" />
                </div>
              </div>
            </form>
        </span>
    </div>
</div>

    </div>
</div>

<%@include file="../templates/footer.jsp"%>
