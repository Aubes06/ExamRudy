<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<c:set var = "catID" scope = "session" value = ""/>

<div class="container mt-3">
    <div class="accordion" id="categories_dishes">

        <c:forEach items="${dishes_categories}" var="dishe">

            <c:if test = "${catID != ''}"><c:if test = "${catID != dishe.categoryId}"></table></div></div></c:if></c:if>

            <c:if test = "${catID != dishe.categoryId}">
                <c:set var = "catID" scope = "session" value = "${dishe.categoryId}"/>

                <div class="card">
                    <div class="card-header" id="category${dishe.categoryId}">
                        <h2 class="mb-0">
                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseCat${dishe.categoryId}" aria-expanded="false" aria-controls="collapseCat${dishe.categoryId}">
                                ${dishe.category}
                            </button>
                        </h2>
                    </div>
                    <div id="collapseCat${dishe.categoryId}" class="collapse" aria-labelledby="category${dishe.categoryId}" data-parent="#categories_dishes">
                    <table style="width:100%;">
            </c:if>

            <c:if test = "${dishe.label != null}">
                <!--<div class="card-body">${dishe.label}</div>-->

                        <tr>
                            <td style="width:160px;padding:0.5em;"><img style="width: 150px;border:1px solid orange;border-radius: 0.5em;" src="<%=request.getContextPath()%>/img/dishes/${dishe.id}.jpg" class="card-img-top" alt="${dishe.label}"></td>
                            <td>
                                <span class="dishes_title">${dishe.label}</span><hr>
                                    ${dishe.description}
                            </td>
                            <td style="width:160px;padding:0.5em;">${dishe.price} &euro;</td>
                        </tr>

            </c:if>
        </c:forEach>
                        </table>
                    </div>
                </div>
    </div>
</div>


<%@include file="../templates/footer.jsp"%>
