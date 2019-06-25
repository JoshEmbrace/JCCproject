<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="nav">
				<ul class="nav-container">
					<li>
						<a href="#Mynote"><i class="material-icons md-36">description</i><span>My note</span></a>
					</li>
					<li>
						<a href="#Curriculum"><i class="material-icons md-36">date_range</i><span>Curriculum</span></a>
					</li>
					<li>
						<a href="#Homework"><i class="material-icons md-36">dvr</i><span>Homework</span></a>
					</li>					
					<li>
						<a href="#Homework"><i class="material-icons md-36">dvr</i><span>saf</span></a>
					</li>
					
					<li class="dropdown-menu">
						<a href="#Notice"><i class="material-icons md-36">apps</i><span>Notice</span><i
								class="material-icons md-36">expand_more</i></a>
						<ul class="dropdown-container">
							<li><a href="">Notice</a></li>
							<li><a href="">Freeboard</a></li>
						</ul>
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