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

//$(".input-file").change(function(event) {
//
//	if ($(".input-file").val().indexOf(".png") > -1  || $(".input-file").val().indexOf(".jpg") > -1 ) {
//		$(".file-return").css("color", "green");
//		$(".file-return").attr("hidden", false);
//		$(".file-return-error").attr("hidden", true);
//	} else {
//			
//		$(".file-return-error").css("color", "red");
//		$(".file-return-error").attr("hidden", false);
//		$(".file-return").attr("hidden", true);
//	}
//});

$('#companyImage').bind('change', function() {
	var validSizeOrNot;
	if(this.files[0].size > 1000000) {
		validSizeOrNot = false;
	} else {
		validSizeOrNot = true;
	}
	if ($("#companyImage").val().indexOf(".png") > -1  || $("#companyImage").val().indexOf(".jpg") > -1 ) {
		if(validSizeOrNot == true) {
			$(".file-return").css("color", "green");
			$(".file-return").attr("hidden", false);
			$(".file-return-error").attr("hidden", true);
			$(".file-return-size-error").attr("hidden", true);
			$(".text-danger").text('');
		} else {
			$(".file-return-size-error").css("color", "red");
			$(".file-return").attr("hidden", true);
			$(".file-return-error").attr("hidden", true);
			$(".file-return-size-error").attr("hidden", false);
		}
	} else {
			
		$(".file-return-error").css("color", "red");	
		$(".file-return-error").attr("hidden", false);
		$(".file-return").attr("hidden", true);
		$(".file-return-size-error").attr("hidden", true);

	}
});



