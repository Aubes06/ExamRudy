<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<c:set var = "catID" scope = "session" value = ""/>

<div class="container mt-3 mb-5">
<h4>Rercherche de plats</h4>

<div class="accordion" id="search_dishes">

<c:forEach items="${dishes_categories}" var="dishe">

    <c:if test = "${catID != ''}"><c:if test = "${catID != dishe.categoryId}">
        </table>
        </div>
        </div>
    </c:if></c:if>

    <c:if test = "${catID != dishe.categoryId}">
        <c:set var = "catID" scope = "session" value = "${dishe.categoryId}"/>

        <div class="card">
        <div class="card-header" id="category${dishe.categoryId}">
            <span class="categoryTitle mb-0" data-toggle="collapse" style="cursor:pointer;" id="categoryTitle${dishe.categoryId}" data-target="#collapseCat${dishe.categoryId}" aria-expanded="false" aria-controls="collapseCat${dishe.categoryId}" >${dishe.category}</span>
        </div>
        <div id="collapseCat${dishe.categoryId}" class="collapse show" aria-labelledby="category${dishe.categoryId}" data-parent="#search_dishes">
        <table id="search_and_dishes">
    </c:if>

    <c:if test = "${dishe.label != null}">
        <tr>
            <td>
                <img style="width: 150px;border:1px solid orange;border-radius: 0.5em;" src="<%=request.getContextPath()%>/img/dishes/${dishe.id}.jpg" class="card-img-top" alt="${dishe.label}">
            </td>
            <td>
                <span class="dishes_title">${dishe.label}</span><hr id="HrAccordion">
                    ${dishe.description}
            </td>
            <td>
                    ${dishe.price} &euro;
            </td>
        </tr>

    </c:if>
</c:forEach>

</table>
<c:if test = "${catID == ''}">
    <div class="alert alert-danger" role="alert">
        Aucun résultat trouvé pour : ${search}
    </div>
</c:if>
</div>
</div>


</div>
</div>


 <%@include file="../templates/footer.jsp"%>
