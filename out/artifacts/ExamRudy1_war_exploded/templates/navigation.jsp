<header>
    <nav class="navbar navbar-expand navbar-warning bg-warning">
        <a class="navbar-brand" href="home" style="color:black;" title="IllicoResto"><img src="img/logo.png" height="25" alt="Logo de IllicoResto" class="no-margin"> IllicoResto</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <c:if test = "${name != null}">
            <div class="collapse navbar-collapse" id="navbarsExample02">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home" style="color:black;">La carte <span class="sr-only">(current)</span></a>
                    </li>
                </ul>

                <p class="marge">
                    <form class="form-inline my-2 my-md-0" style="margin-right: 0.5em;" method="get" action="home" >
                        <input class="form-control" type="search" name="search" placeholder="Rechercher" aria-label="Rechercher" required>
                        <button class="btn" type="submit">
                            <img src="img/search.png" width="25" height="25" alt="" class="no-margin">
                        </button>
                    </form>

                    <b>${name}</b>
                    <a class="btn" href="member">
                        <img src="img/user_setting.png" width="25" height="25" alt="Gestion d'utilisateur" title="Gestion d'utilisateur" class="no-margin">
                    </a>
                    <a class="btn" href="login">
                        <img src="img/logout.png" width="25" height="25" alt="Déconnexion" title="Déconnexion" class="no-margin">
                    </a>
                </p>


            </div>
        </c:if>
    </nav>
</header>

<main role="main" class="container">