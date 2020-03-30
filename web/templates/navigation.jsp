﻿<header>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-warning bg-warning " style="min-height: 8vh;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="home">IllicoResto</a>

                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active"><a class="nav-link" href="home">Accueil <span class="sr-only">(current)</span></a></li>
                </ul>

                <c:if test = "${name != null}">
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2 col-7 mr-1" type="search" placeholder="Rechercher" aria-label="Rechercher">
                        <button class="btn btn-outline-success my-2 my-sm-0 mr-1" type="submit">Rechercher</button>
                    </form>

                    <a class="btn btn-outline-danger my-2 my-sm-0" href="login">${name}</a>
                </c:if>
            </div>
        </nav>
    </div>
</header>