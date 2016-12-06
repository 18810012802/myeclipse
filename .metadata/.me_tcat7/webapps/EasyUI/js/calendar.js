$(function(){
	$('#box').calendar({
		width:300,
		border:false,
		//firstDay:1,
		weeks:['s','M','T','W','T','F','S'],
		//months:['jan',]
		year:2015,
		//month:6,
		//current:new Date(2015,7,1),
		formatter:function(date){
			return '#'+date.getDate();
		},
		/*styler:function(date){
			if(date.getDate() == 1){
				return 'background-color:#ccc';
			}
			if(date.getDay() == 1){
				return 'background-color:#ccc';
			}
		},
		validator:function(date){
			if(date.getDay() == 1){
				return true;
			}else{
				return false;
			}
		
		},*/
		onSelect:function(date){
			alert(date);
		},
		onChange:function(newDate,oldDate){
			alert(newDate+','+oldDate);
		},
		
		
	});
	//$('#box').calendar('moveTo',new Date(2015,8,1));
	

});