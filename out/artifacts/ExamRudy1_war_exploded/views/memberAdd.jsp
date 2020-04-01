<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <main class="row justify-content-center">
        <div class="col-6">
            <h2>Ajout d'une note</h2>
            <form action="memberAdd" method="post">
                <div class="form-group">
                    <input class="form-control" placeholder="new user" type="text" name="user">
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Email" type="email" name="email">
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Ajoute">
            </form>
        </div><!-- fin col-6 -->
    </main>
</div><!-- fin container -->

<%@include file="../templates/footer.jsp"%>
