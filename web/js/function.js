function setCatEdit(CatID,InputLabelID) {
    document.getElementById('catID').value=CatID;
    document.getElementById('catName').value=document.getElementById(InputLabelID).innerText;
}