﻿<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<c:set var = "catID" scope = "session" value = ""/>

<div class="container">
    <br>
    <h4>Carte des plats</h4>
    <div class="accordion" id="categories_dishes">

        <c:forEach items="${dishes_categories}" var="dishe">

            <c:if test = "${catID != ''}"><c:if test = "${catID != dishe.categoryId}">
                <tr>
                    <td>
                        <form action="add-dishe" method="post" enctype="multipart/form-data">
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
                    <div class="card-header" id="category${dishe.categoryId}">
                        <span class="categoryTitle mb-0" data-toggle="collapse" style="cursor:pointer;" id="categoryTitle${dishe.categoryId}" data-target="#collapseCat${dishe.categoryId}" aria-expanded="false" aria-controls="collapseCat${dishe.categoryId}" >${dishe.category}</span>
                        <img width="32" style="float:right;cursor:pointer;"src="<%=request.getContextPath()%>/img/delete.png" alt="Supprimer" title="Supprimer" data-toggle="modal" data-target="#modalCatDel" onclick="document.getElementById('CatDelCatID').href='del-category?CatID=${dishe.categoryId}';"/>
                        <img width="32" style="float:right;cursor:pointer;margin-right:10px;" src="<%=request.getContextPath()%>/img/edit.png" alt="Modifier" title="Modifier" data-toggle="modal" data-target="#modalCatEdit" onclick="setCatEdit('${dishe.categoryId}','categoryTitle${dishe.categoryId}');"/>
                    </div>
                    <div id="collapseCat${dishe.categoryId}" class="collapse" aria-labelledby="category${dishe.categoryId}" data-parent="#categories_dishes">
                    <table id="categorie_and_dishes">
            </c:if>

            <c:if test = "${dishe.label != null}">
                        <tr>
                            <td>
                                <img id="dishImg${dishe.id}" style="width: 150px;border:1px solid orange;border-radius: 0.5em;" src="<%=request.getContextPath()%>/img/dishes/${dishe.id}.jpg" class="card-img-top" alt="${dishe.label}">
                            </td>
                            <td>
                                <span class="dishes_title" id="dishLabel${dishe.id}">${dishe.label}</span><hr>
                                <span id="dishDescription${dishe.id}">${dishe.description}</span>
                            </td>
                            <td>
                                <span id="dishPrice${dishe.id}">${dishe.price}</span> &euro;
                            </td>
                            <td>
                                <img width="32" src="<%=request.getContextPath()%>/img/edit.png" alt="Modifier" title="Modifier" data-toggle="modal" data-target="#modalDishEdit" style="cursor:pointer;" onclick="setDisEdit('${dishe.id}','dishLabel${dishe.id}','dishDescription${dishe.id}','dishPrice${dishe.id}','${dishe.categoryId}','dishImg${dishe.id}');" />
                                <br/>
                                <img width="32" src="<%=request.getContextPath()%>/img/delete.png" alt="Supprimer" title="Supprimer" data-toggle="modal" data-target="#modalDishDel" style="cursor:pointer;" onclick="document.getElementById('CatDelDishID').href='del-dishe?DisID=${dishe.id}';"/>
                            </td>
                        </tr>

            </c:if>
        </c:forEach>
                    <tr>
                        <td>
                            <form action="add-dishe" method="post" enctype="multipart/form-data">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="dishePicture" name="dishePicture" required>
                                    <label class="custom-file-label" for="dishePicture">Photo</label>
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

<div class="card">
    <div class="card-header" id="addCat" type="button" aria-expanded="true">
        <span class="categoryTitle mb-0">
            <form action="add-category" method="post">
              <div class="form-row">
                <div class="col">
                  <input type="text" class="form-control test" name="CatLabel" placeholder="Libellé de la nouvelle catégorie">
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
<br>


<div class="modal fade" id="modalCatEdit" tabindex="-1" role="dialog" aria-labelledby="modalCatEdit" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalCatEdit2">Éditer le nom de la catégorie</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="edit-category">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="catName" class="col-form-label">Nouveau nom de catégorie :</label>
                        <input type="text" name="CatName" class="form-control" id="catName">
                        <input type="hidden" name="CatID" id="catID">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    <input type="submit" class="btn btn-primary" value="Sauvegarder">
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="modalCatDel" tabindex="-1" role="dialog" aria-labelledby="modalCatDel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalCatDel2">Suppression de la catégorie</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="del-category">
                <div class="modal-body">
                    <div class="form-group">
                        <p>Voulez-vous vraiment supprimer la catégorie ?</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <a style="float:right;" class="btn btn-success" href="" id="CatDelCatID">Oui</a>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Non</button>
                </div>
            </form>
        </div>
    </div>
</div>

<c:set var = "catID" scope = "session" value = ""/>
<div class="modal fade" id="modalDishEdit" tabindex="-1" role="dialog" aria-labelledby="modalDishEdit" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalDishEdit2">Éditer les détails du plat</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="edit-dishe">
                <div class="modal-body">
                    <img id="dishePictureAdd" src="" style="display:block;margin: auto; width: 300px;border:1px solid orange;border-radius: 0.5em;" />
                    <div class="form-group">
                        <label for="disheName" class="col-form-label">Nouveau nom du plat :</label>
                        <input type="text" name="DisheName" class="form-control" id="disheName" value="">

                        <label for="disheDesc" class="col-form-label">Nouvelle description du plat :</label>
                        <textarea class="form-control" id="disheDesc" name="DisheDesc" rows="3"></textarea>

                        <label for="dishePrice" class="col-form-label">Nouveau prix du plat :</label>
                        <input type="text" name="DishePrice" class="form-control" id="dishePrice" value="">

                        <label for="disheCategory" class="col-form-label">Nouvelle catégorie du plat :</label>
                        <select class="form-control" id="disheCategory" name="DisheCategory">
                            <c:forEach items="${dishes_categories}" var="category">
                                <c:if test = "${catID != category.categoryId}">
                                    <c:set var = "catID" scope = "session" value = "${category.categoryId}"/>
                                    <option value="${category.categoryId}">${category.category}</option>
                                </c:if>
                            </c:forEach>
                        </select>

                        <input type="hidden" name="DisheID" id="disheID">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    <input type="submit" class="btn btn-primary" value="Sauvegarder">
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="modalDishDel" tabindex="-1" role="dialog" aria-labelledby="modalDishDel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalDishDel2">Suppression du plat</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="del-dishe">
                <div class="modal-body">
                    <div class="form-group">
                        <p>Voulez-vous vraiment supprimer le plat ?</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <a style="float:right;" class="btn btn-success" href="" id="CatDelDishID">Oui</a>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Non</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="../templates/footer.jsp"%>
