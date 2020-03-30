<div class="container">
    <header>
        <nav class="navbar navbar-expand-lg navbar-warning bg-warning " style="min-height: 8vh;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="home">IllicoResto</a>

                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active"><a class="nav-link" href="home">Accueil <span class="sr-only">(current)</span></a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Nos catégories</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="category">Toutes nos categories</a>
                            <div class="dropdown-divider"></div>
                            <c:forEach items="${categories}" var="category">
                                <a class="dropdown-item" href="category?id=${category.id}" title="${category.nbPlat} plat(s) dans cette categorie">${category.label}</a>
                            </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Nos plats</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="dishe">Toutes nos plats</a>
                            <div class="dropdown-divider"></div>
                            <c:forEach items="${dishes}" var="dishe">
                                <a class="dropdown-item" href="dishe?id=${dishe.id}" title="${dishe.description}">${dishe.label}</a>
                            </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="todo">Todo <span class="sr-only">(current)</span></a></li>
                </ul>

                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2 col-7 mr-1" type="search" placeholder="Rechercher" aria-label="Rechercher">
                    <button class="btn btn-outline-success my-2 my-sm-0 mr-1" type="submit">Rechercher</button>
                </form>
                <a class="btn btn-outline-danger my-2 my-sm-0" href="login">NAME &times;</a>
            </div>
        </nav>
    </header>
</div>