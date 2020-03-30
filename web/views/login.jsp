<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <div class="row justify-content-center">
        <div class="col-4">
            <h3 class="p-3 bg-warning text-white text-center">Login IllicoBoy</h3>
            <form action="login" method="post">
                <p class="bg-danger text-white">${errorMessage}</p>
                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="Votre Email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Mot de passe">
                </div>
                <input type="submit" class="btn btn-warning btn-block" value="Connexion">
            </form>
        </div>
    </div>
</div>



<%@include file="../templates/footer.jsp"%>
