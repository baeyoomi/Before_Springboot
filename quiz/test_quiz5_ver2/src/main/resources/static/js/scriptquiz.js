$(function(){
 	$('.table').hide();
	$('.quizList>h3').click()
 	$('.quizList>h3').each(function(){
		$(this).click(function(){
			$('.table').stop(true, true).slideDown();
			$('.quizList>h3').removeClass('quizOn');
			$('.quizList>h3').eq(1).addClass('quizUp');
		});
	});
	$('.quizList>h3.quizUp').click(function(){
		$('.table').stop(false, false).slideUp();
	});

	
});

