//플러스버튼을 클릭하면 1페이지 중 해당 노트아이디의 글에 포커스된다
//준비물: 플러스버튼, 해당회원의 마이노트리스트페이지?, 해당 노트아이디
//행위: 플러스버튼 온클릭하면 페이지이동, 해당노트포커스

window.addEventListener("load", function(){
    var mynotetables = document.querySelector(".mynote-tables");
    var plusbtn = mynotetables.querySelector(".plus-button");
    //var mynotePage = 마이노트 최신글이라면 1페이지 만약 1페이지만 할거면..상관없는데..?;
    //var mynoteId = 마이노트 아이디 가져와야해;

    plusbtn.onclick = function goMynotelist(){
        alert("플러스버튼테스트");
        location.href="http://localhost:8080/semi-JCC/teacher/mynote/list"
       
    //     function mynoteIdFocus(){
    //         document.getElementById("mynoteId").focus();
    //    }
    //goMynotelist.focus();
    }


});