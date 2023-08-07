$(function(){
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


/*    $(function() {
      // 페이징 버튼에 이벤트를 등록합니다.
      $(".pagination a").on("click", function() {
        // 현재 페이지 번호를 가져옵니다.
        var page = $(this).text();

        // 페이지를 요청합니다.
        $.ajax({
          url: "/boards?page=" + page,
          success: function(data) {
            // 데이터를 화면에 표시합니다.
            $(".board-list ul").html(data);
          },
          error: function() {
            alert("An error occurred.");
          }
        });
      });
    });*/

});

