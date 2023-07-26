$(function(){
 	$('.table').hide();
	$('.quizDown').css('display','block');
	$('.quizDown').on('click',function(){
		$('.table').stop(true, true).slideDown();
		$('.quizDown').css('display','none');
		$('.quizUp').css('display','block');
	});
	$('.quizUp').on('click',function(){
		$('.table').stop(false, false).slideUp();
		$('.quizUp').css('display','none');
		$('.quizDown').css('display','block');
	});	
});

