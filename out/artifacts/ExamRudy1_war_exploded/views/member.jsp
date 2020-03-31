<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <main class="row justify-content-center">
        <div class="col-6">
            <h4>Liste des membres</h4>
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>User Name</th>
                    <th>E-mail</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${members}" var="member">
                    <tr>
                        <td>${member.nom}</td>
                        <td>${member.email}</td>
                        <td class="text-center">
                            <a href="supTodo?todo=${member.nom}&categorie=${member.email}">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="memberAdd" class="btn btn-info btn-block">
                <i class="fa-plus"></i>
                Nouvelle note
            </a>
        </div>
    </main>

</div>



<%@include file="../templates/footer.jsp"%>