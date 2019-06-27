window.addEventListener("load", function(){

	var freeboard = document.querySelector("#freeboard");
	var testPager = document.querySelector("#test-pager");
	var button1 = testPager.querySelector("input[type=button]");
	var txt = testPager.querySelector("input[type=text]");
	var tbody = freeboard.querySelector("tbody");

	button1.onclick = function(){
		var page = 1;
		if(txt.value != null && txt.value !="")
			page= txt.value;

		//데이터 요청하기
		var request = new XMLHttpRequest();
		request.open("GET","/semi-JCC/teacher/freeboard/list-ajax?p="+page,false);
		request.send();

		var json = JSON.parse(request.responseText);
		console.log(request.responseText);
		var template = freeboard.querySelector(".freeboard-template");

		//var tr = tbody.children[0];//첫번째 tr
		//var tr = tbody.firstElementChild;
		//var tr = tbody.querySelector("tr:first-child");
		tbody.innerHTML ="";

		for(var a = 0; a<json.length; a++) {
			//var cloneTr = tr.cloneNode(true);
			var cloneTr = document.importNode(template.content,true);
			var idEl = cloneTr.querySelector(".num");
			var titleEl = cloneTr.querySelector(".title");
			var writerEl = cloneTr.querySelector(".writer");
			var dateEl = cloneTr.querySelector(".date");

			idEl.innerText = json[a].id;
			titleEl.innerHTML = '<a href="detail?id='+json[a].id+
			'">'+json[a].title+'</a>';
			writerEl.innerText = json[a]["writer_id"];
			dateEl.innerText = json[a]["reg_date"];
			tbody.append(cloneTr);


			tbody.append(cloneTr);
		}
	}
});