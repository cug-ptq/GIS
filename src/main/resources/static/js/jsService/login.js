$("#login-btn").click(function (){
    let LoginEmail = document.getElementById("LoginEmail").value;
    let LoginPassword = document.getElementById("LoginPassword").value;
    $.ajax({
        type:"post",
        url:"/login/auth",
        data:{"LoginEmail":LoginEmail,"LoginPassword":LoginPassword},
        success:function (msg) {
            if(msg.code!=1){
                $("#msgLogin").text(msg.map.error);
            }
            else {
                window.location.href="index";
            }
        }
    });
});

$("#signUp-btn").click(function (){
    let signUpUsername = document.getElementById("signUpUsername").value;
    let signUpEmail = document.getElementById("signUpEmail").value;
    let signUpPassword = document.getElementById("signUpPassword").value;
    console.log("su");
    $.ajax({
        type:"post",
        url:"/login/signUp",
        data:{"signUpUsername":signUpUsername,
            "signUpEmail":signUpEmail,
            "signUpPassword":signUpPassword},
        success:function (msg) {
            if(msg.code!=1){
                $("#msgSignUp").text(msg.map.error);
            }
            else {
                window.location.href="index";
            }
        }
    });
});