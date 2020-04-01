<header>
        <nav class="navbar navbar-expand-lg navbar-warning bg-warning ">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="container">

                <a class="navbar-brand" href="home">IllicoResto</a>

                <c:if test = "${name != null}">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active"><a class="nav-link" href="home">La carte <span class="sr-only">(current)</span></a></li>
                    </ul>

                    <form class="form-inline my-2 my-lg-0" action="home">
                        <input class="form-control mr-sm-2 col-7 mr-1" type="search" name="search" placeholder="Rechercher" aria-label="Rechercher" required>
                        <button class="btn" type="submit">
                            <img src="https://cdn0.iconfinder.com/data/icons/it-hardware/100/search-512.png" width="25" height="25" alt="">
                        </button>
                    </form>
                    <p class="marge mt-3">
                        Bonjour <b style='color:dodgerblue;'>${name}</b> !
                        <a class="btn" href="member">
                            <img src="https://www.icone-png.com/png/43/42695.png" width="25" height="25" alt="">
                        </a>
                        <a class="btn" href="login">
                            <img src="https://image.flaticon.com/icons/png/512/56/56805.png" width="25" height="25" alt="">
                        </a>
                    </p>
                </c:if>

            </div>
        </nav>

</header>
<main>