function setCatEdit(CatID,InputLabelID) {
    document.getElementById('catID').value=CatID;
    document.getElementById('catName').value=document.getElementById(InputLabelID).innerHTML;
}

function setDisEdit(DisID,InputLabelID,InputLabelDescription,InputLabelPrice,InputLabelCategory,ImgSrcPicture) {
    document.getElementById('disheID').value=DisID;
    document.getElementById('disheName').value=document.getElementById(InputLabelID).innerHTML;
    document.getElementById('disheDesc').innerHTML=document.getElementById(InputLabelDescription).innerHTML;
    document.getElementById('dishePrice').value=document.getElementById(InputLabelPrice).innerHTML;
    document.getElementById('dishePictureAdd').src=document.getElementById(ImgSrcPicture).src;
    document.getElementById('disheCategory').value=InputLabelCategory;
}

$('document').ready(function () {
    $("#changePicture").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#dishePictureAdd').attr('src', e.target.result);
            }
            reader.readAsDataURL(this.files[0]);
        }
    });
});