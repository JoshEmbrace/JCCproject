<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="nav">
				<ul class="nav-container">
					<li>
						<a href="/semi-JCC/teacher/mynote/list"><i class="material-icons md-36">description</i><span>My note</span></a>
					</li>
					<li>
						<a href="/semi-JCC/teacher/curri/list"><i class="material-icons md-36">date_range</i><span>Curriculum</span></a>
					</li>
					<li>
						<a href="/semi-JCC/teacher/homework/list"><i class="material-icons md-36">library_books</i><span>Homework</span></a>
					</li>					
					<li>
						<a href="/semi-JCC/teacher/freeboard/list"><i class="material-icons md-36">free_breakfast</i><span>Freeboard</span></a>
					</li>
					<li>
						<a href="/semi-JCC/teacher/notice/list"><i class="material-icons md-36">announcement</i><span>Notice</span></a>
					</li>
				</ul>
			</nav>
			<script>
				var dropdown = document.getElementsByClassName(".dropdown-menu");

				for (var i = 0; i < dropdown.length; i++) {
					dropdown[i].addEventListener("click", function () {
						this.classList.toggle("active");
						var dropdownContent = this.nextElementSibling;
						if (dropdownContent.style.display === "block") {
							dropdownContent.style.display = "none";
						} else {
							dropdownContent.style.display = "block";
						}
					});
				}
			</script>