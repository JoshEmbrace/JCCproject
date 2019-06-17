window.addEventListener("load", function(){

	var freeboard = document.querySelector("#freeboard");
	var testPager = document.querySelector("#test-pager");
	var button1 = testPager.querySelector("input[type=button]");
	var text = testPager.querySelector("input[type=text]");
	var tbody = freeboard.querySelector("tbody");

	button1.onclick = function(){
//		var page = "1";
//		if(text.value != null && text.value != "")

		var	page = text.value;
		//데이터 요청하기 

		var request = new XMLHttpRequest();
		request.open("GET", "/freeboard/list-ajax?p="+page,false);
		request.send();

		//var json =JSON.parse(request.responseText);
		var json = JSON.parse(request.responseText);
		var tr = tbody.firstElementChild;

		tbody.innerHTML = "";
		for(var a = 0; a<json.length; a++) {
			var cloneTr = tr.cloneNode(true); // 안의 자식들이 복제되서 만들어진다

			var idEl = cloneTr.querySelector(".num");
			var titleEl = cloneTr.querySelector(".title a");
			var writerEl = cloneTr.querySelector(".writer");
			var dateEl = cloneTr.querySelector(".date");
			
			idEl.innerText = json[a].id;
			titleEl.innerText = json[a].title;
			writerEl.innerText = json[a].writer;
			dateEl.innerText = json[a].date;

			tbody.append(cloneTr);

		}
	}

});