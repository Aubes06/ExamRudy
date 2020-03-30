﻿<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <div class="container row justify-content-center" style="height:92vh !important;position:absolute !important; top:8vh !important;">
        <div class="col-4">
            <h3 class="p-3 bg-illico text-black text-center">Login IllicoBoy</h3>
            <form action="login" method="post">
                <p class="bg-danger text-white">${errorMessage}</p>
                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="Votre Email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Mot de passe">
                </div>
                <input type="submit" class="btn btn-illico btn-block" value="Connexion">
            </form>
        </div>
    </div>
</div>

<%@include file="../templates/footer.jsp"%>