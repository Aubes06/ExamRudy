<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <main class="row justify-content-center">
        <div class="col-6">
            <h4>Liste des trucs a faire</h4>
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>Descritptions</th>
                    <th>Categories</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${members}" var="member">
                    <tr>
                        <td>${members.nom}</td>
                        <td>${members.email}</td>
                        <td class="text-center">
                            <a href="supTodo?todo=${members.nom}&categorie=${members.email}">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-info btn-block">
                <i class="fa-plus"></i>
                Nouvelle note
            </a>
        </div>
    </main>

</div>



<%@include file="../templates/footer.jsp"%>