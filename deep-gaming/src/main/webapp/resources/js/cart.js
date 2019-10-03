/**
 * 
 */

function addCartItem(idProduct) {
	$.ajax({
		method : 'POST',
		url : "/deep-gaming/cart-rest/addItem/" + idProduct,
		success : function(data) {
			alert("Product added successfully to the cart");
			if(data == 0) {
				location.reload();
			}

		},
		error : function() {
			alert("Error");
		}
	});
}

function deleteCartItem(idCartItem) {
	var result = confirm("Are you sure ?");
	if (result) {

		$.ajax({
			method : 'DELETE',
			url : "/deep-gaming/cart-rest/deleteItem/" + idCartItem,
			success : function() {
				$('#row' + idCartItem).css('background', 'tomato');
				$('#row' + idCartItem).fadeOut(1000, function() {
					$(this).remove();
				});
			},
			error: function() {
				alert("Error");
			}
		});
	}
}

function deleteAllCartItems() {
	var result = confirm("Are you sure ?");
	if (result) {
		$.ajax({
			method : 'DELETE',
			url : "/deep-gaming/cart-rest/deleteCart",
			success : function() {
				$(".itemRows").css('background', 'tomato');
				$(".itemRows").fadeOut(1000, function() {
					$(this).remove();
				});
				$("#clearAll").remove();
				$("#reserve").remove();
			},
			error: function() {
				alert("Error");
			}
		});
	}
}

function reserve() {
	var result = confirm("Are you sure ?");
	if(result) {
		$.ajax({
			method : "PUT",
			url : "/deep-gaming/cart-rest/reserve",
			success : function() {
				alert("Success");
			    window.location.href = "/deep-gaming/";

			},
			error: function() {
				alert("Error");
			}
		});
	}
}

function confirmPurchase(idCart) {
	var result = confirm("Are you sure ?");
	if(result) {
		$.ajax({
			method: "PUT",
			url: "/deep-gaming/cart-rest/confirmPurchase/" + idCart,
			success: function() {
				$(".table" + idCart).css("background", "green");
				$(".table" + idCart).fadeOut(1000, function() {
					$(this).remove();
				});
			},
			error: function() {
				alert("Error");
			}
		});
	}
}

function cancelReservation(idCart) {
	var result = confirm("Are you sure ? ");
	if(result) {
		$.ajax({
			method: "DELETE",
			url: "/deep-gaming/cart-rest/cancelReservation/" + idCart,
			success: function() {
				$(".table" + idCart).css("background", "tomato");
				$(".table" + idCart).fadeOut(1000, function() {
					$(this).remove();
				});
			},
			error: function() {
				alert("Error");
			}
		});
	}
}
