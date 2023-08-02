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
	
	var guideClass = 'mute';                    
	
	$('.guideText').each(function(){
		var guideText = this.defaultValue;
		var element = $(this);
		element.focus(function(){
			if(element.val()===guideText){      
				element.val('');                
				element.removeClass(guideClass);   
			}
		}).blur(function(){                       
			if(element.val()===''){             
				element.val(guideText);         
				element.addClass(guideClass);      
			}
		});
		if(element.val()===guideText){          
			element.addClass(guideClass);
		};
	});
});

