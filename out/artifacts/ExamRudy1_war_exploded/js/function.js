function setCatEdit(CatID,InputLabelID) {
    document.getElementById('catID').value=CatID;
    document.getElementById('catName').value=document.getElementById(InputLabelID).innerText;
}

function setDisEdit(DisID,InputLabelID,InputLabelDescription,InputLabelPrice,InputLabelCategory,ImgSrcPicture) {
    document.getElementById('disheID').value=DisID;
    document.getElementById('disheName').value=document.getElementById(InputLabelID).innerText;
    document.getElementById('disheDesc').innerText=document.getElementById(InputLabelDescription).innerText;
    document.getElementById('dishePrice').value=document.getElementById(InputLabelPrice).innerText;
    document.getElementById('dishePictureAdd').src=document.getElementById(ImgSrcPicture).src;
    document.getElementById('disheCategory').value=InputLabelCategory;

}