﻿<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container">
    <div class="card-body">
        <div class="card-title">
            <h4>Liste des utilisateurs</h4>
        </div>
        <div class="card-text">
            <table id="members" class="table-striped table-hover table-bordered">
                <thead>
                    <tr id="trMember">
                        <td>
                            Nom d'utilisateur
                        </td>
                        <td colspan="2">
                            Adresse E-Mail
                        </td>
                        <td>
                            Action
                        </td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${members}" var="member">
                    <tr>
                        <td>${member.nom}</td>
                        <td colspan="2">${member.email}</td>
                        <td class="text-center">
                            <c:if test = "${member.email != user_email}">
                                <a href="del-member?UseID=${member.id}">
                                    <img width="20" src="<%=request.getContextPath()%>/img/delete.png" alt="Supprimer" title="Supprimer" />
                                </a>
                            </c:if>
                            <c:if test = "${member.email == user_email}">
                                <img width="20" src="<%=request.getContextPath()%>/img/no_delete.png" alt="Supprimer" title="Impossible de supprimer votre compte" />
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td>
                            <form action="add-member" method="post" autocomplete="off">
                                <input type="text" class="form-control" name="AddUseName" placeholder="Pseudo" value="" required>

                        </td>
                        <td>
                            <input type="email" class="form-control" autocomplete="off" name="UseEmail" placeholder="Adresse E-Mail" value="" required>
                        </td>
                        <td>
                            <input type="password" class="form-control" autocomplete="off" name="UsePassword" placeholder="Mot de passe" value="" required>
                        </td>
                        <td>
                                <input type="image" name="" width="20" src="/ExamRudy1_war_exploded/img/add.png" alt="Ajouter" title="Ajouter">
                            </form>
                        </td>
                    </tr>
                </tfoot>
            </table>

        </div>
    </div>
</div>

<%@include file="../templates/footer.jsp"%>