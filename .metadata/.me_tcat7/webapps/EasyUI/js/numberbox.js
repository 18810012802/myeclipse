$(function(){
	$('#ss').numberbox({
		//value:555,
		max:500,
		min:5,
		precision:2,
		decimalSeparator:'.',
		groupSeparator:',',
		prefix:'$',
		//suffix:'&',
		/*filter:function(e){
			//return false;
		},*/
		formatter:function(value){
			return '111,'+value;
		},
		//value也变了
		/*parser:function(s){
			return '111,'+s;
		},*/
		onChange:function(newValue,oldValue){
			
		},
		
	
	});
	/*$(document).keyup(function(){
		$('#ss').numberbox('fix');
		
	})*/
});