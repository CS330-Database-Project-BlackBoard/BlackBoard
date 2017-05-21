$("#generate-password").click(function(){

    var chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOP1234567890";
    var pass = "";
    for (var x = 0; x < 8; x++) {
        var i = Math.floor(Math.random() * chars.length);
        pass += chars.charAt(i);
    }
	$("#password").val(pass);
});


$('#search-course-code').keypress(function (e) {
	if(e.which == 13){
		var searchData = $('#search-course-code').val();
		console.log(searchData);
		$.post("search/course", {"course-code": searchData},
			function(result){
				console.log(result);
				for(key in result){
					$('#search-course-name').val(result[key]);
					$('#search-course-code').val(key);

					break;
				}
			});

	}
	
});





$('#search-lecturer').keypress(function (e) {
	
	if(e.which == 13){
		var searchData = $('#search-lecturer').val();
		console.log(searchData);
		$.post("search/lecturer", {"lecturer": searchData},
			function(result){
				console.log(result);
				for(key in result){
					$('#search-lecturer-email').val(key)
					$('#search-lecturer').val(result[key])
					break;
				}
			});
	}

});


$("#delete-course").click(function(e){
	if (!confirm('Are you sure to delete course from student course list?')) {
	    e.preventDefault();
	}
});


$("#save-course").click(function(){
	$("#new-course").submit();
})