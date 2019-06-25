window.addEventListener("load", function(){

var notice = document.querySelector("#notice");
var testPaper = document.querySelector("#test-paper");
var txt = testPaper.querySelector("input[type=text]");
var btn = testPaper.querySelector("input[type=button]");
var tbody = notice.querySelector("tbody");

btn.onclick = function(){
    var page = 1;
    if(txt.value != null && txt.value !="")
        page= txt.value;

    //데이터 요청하기
    var request = new XMLHttpRequest();
    request.open("GET","/semi-JCC/notice/list-ajax?p="+page,false);
    request.send();

    var notices = JSON.parse(request.responseText);
    var template = notice.querySelector(".notice-template");

    //var tr = tbody.children[0];//첫번째 tr
    //var tr = tbody.firstElementChild;
    //var tr = tbody.querySelector("tr:first-child");
    tbody.innerHTML ="";
    
    for(var i=0; i<notices.length; i++)
    {
        //var cloneTr = tr.cloneNode(true);
        var cloneTr = document.importNode(template.content,true);
        var idEl = cloneTr.querySelector(".num");
        var titleEl = cloneTr.querySelector(".title a");
        var writerEl = cloneTr.querySelector(".writer");
        var dateEl = cloneTr.querySelector(".date");
        var hitEl = cloneTr.querySelector(".hit");

        idEl.innerText = notices[i].id;
        titleEl.innerText = notices[i].title;
        writerEl.innerText = notices[i].writerId;
        dateEl.innerText = notices[i].regDate;
        hitEl.innerText = notices[i].hit;


        tbody.append(cloneTr);
    }
}
});