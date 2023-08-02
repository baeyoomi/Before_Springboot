$(function(){
 	$('.table').hide();
	$('.boardDown').css('display','block');
	$('.boardDown').on('click',function(){
		$('.table').stop(true, true).slideDown();
		$('.boardDown').css('display','none');
		$('.boardUp').css('display','block');
	});
	$('.boardUp').on('click',function(){
		$('.table').stop(false, false).slideUp();
		$('.boardUp').css('display','none');
		$('.boardDown').css('display','block');
	});	
	
});

