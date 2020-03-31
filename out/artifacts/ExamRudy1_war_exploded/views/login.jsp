<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container" id="login">
    <div class="modal" class="exampleModalCenter" style="display:block;margin: auto !important;">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <form action="login" method="post" style="width:100%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Login IllicoBoy</h5>
                    </div>
                    <div class="modal-body">
                        <img src="<%=request.getContextPath()+"/img/menu.png"%>" width="256" style="display:block;margin: auto;" />
                        <p class="bg-danger text-white">${errorMessage}</p>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" placeholder="Votre Email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="password" placeholder="Mot de passe">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-illico btn-block" value="Connexion">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="../templates/footer.jsp"%>