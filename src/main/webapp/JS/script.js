/* animações do input */
function clickInput0(){
    document.getElementById("usuario").style = "border: 2px solid #101DBC;";
}
function clickInput(){
    document.getElementById("email").style = "border: 2px solid #101DBC;";
}
function clickInput2(){
    document.getElementById("senha").style = "border: 2px solid #101DBC;";
}
function clickInput3(){
    document.getElementById("senha2").style = "border: 2px solid #101DBC;";
}

/* animações botão Logar */
document.querySelector("button").style = "width: 80%;padding: 15px 32px;color: white;font-weight: bold; border: none; display: inline-block;font-size: 16px;border-radius: 10px;cursor: pointer; background-image: linear-gradient(to left, #101DBC, #2374FC, #2CA1E6); color: white;";

function clickButton(){
 document.querySelector("button").style = "width: 80%;padding: 15px 32px;color: white;font-weight: bold; border: none; display: inline-block;font-size: 16px;border-radius: 10px;cursor: pointer; background-color: #2374FC; color: white;";
}
function unClickButton(){
    document.querySelector("button").style = "width: 80%;padding: 15px 32px;color: white;font-weight: bold; border: none; display: inline-block;font-size: 16px;border-radius: 10px;cursor: pointer; background-image: linear-gradient(to left, #101DBC, #2374FC, #2CA1E6); color: white;";
}
function mouseEnterMouse(){
    document.querySelector("button").style = "width: 80%;padding: 15px 32px;color: white;font-weight: bold; border: none; display: inline-block;font-size: 16px;border-radius: 10px;cursor: pointer; background-image: linear-gradient(to left, #101DBC, #2374FC, #2CA1E6); color: black;";
}
function mouseLeaveMouse(){
    document.querySelector("button").style = "width: 80%;padding: 15px 32px;color: white;font-weight: bold; border: none; display: inline-block;font-size: 16px;border-radius: 10px;cursor: pointer; background-image: linear-gradient(to left, #101DBC, #2374FC, #2CA1E6); color: white;";
}