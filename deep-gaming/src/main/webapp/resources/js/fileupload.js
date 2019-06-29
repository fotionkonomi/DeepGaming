document.querySelector("html").classList.add('js');
var fileInput = document.querySelector(".input-file"), button = document
		.querySelector(".input-file-trigger"), the_return = document
		.querySelector(".file-return");

// button.addEventListener("keydown", function(event) {
// if (event.keyCode == 13 || event.keyCode == 32) {
// fileInput.focus();
// }
// });

$(".input-file-trigger").keydown(function(event) {
	if (event.keyCode == 13 || event.keyCode == 32) {
		$(".input-file").focus();
	}
});

$(".input-file-trigger").click(function(event) {
	$(".input-file").focus();
	return false;
});

$(".input-file")
		.change(
				function(event) {
					if ($(".input-file").val().indexOf(".png") > -1) {

						$(".file-return").html("Image uploaded successfully");
					} else {
						var text = "<spring:message code='al.edu.fti.gaming.validator.image' />";
						$(".file-return")
								.html("");
						$(".file-return")
						.append(text);
						$(".file-return").css("color", "red");
					}
				});
