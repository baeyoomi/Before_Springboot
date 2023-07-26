$(function(){
	var borderData = $('#mainBoard');
	$.ajax({
		url:'data/data.xml',
		dataType: 'xml',
		success: function(xml){
			var people = $(xml);
			
			people.find('person').each(function(){
				var person = $(this);
				var textNo = person.find('no').text();
				var textManager = person.find('manager').text();
				var textTitle = person.find('title').text();
				var textDate = person.find('date').text();
				var textName = person.find('name').text();
				var textPush = person.find('push').text();
				var textViews = person.find('views').text();
				var total = $('.boardContent');
				var no = $('.contentData').text(textNo);
				var manager = $('.contentData').text(textManager);
				var title = $('.contentData').text(textTitle);
				var date = $('.contentData').text(textDate);
				var name = $('.contentData').text(textName);
				var push = $('.contentData').text(textPush);
				var views = $('.contentData').text(textViews);
				total.append(no);
				total.append(manager);
				total.append(title);
				total.append(date);
				total.append(name);
				total.append(push);
				total.append(views);
				borderData.append(total);
			});
		}/* success */
	}); /* $.ajax */
});

