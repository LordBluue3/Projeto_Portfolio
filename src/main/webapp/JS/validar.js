function validate(){
    var email = document.querySelector("#email");
    var senha = document.querySelector("#senha");

    if(email.value === "" || senha.value === ""){
     alert("Preencha todos os campos");
     return false;
    }else{
        document.forms["login"].submit();
    }

}
