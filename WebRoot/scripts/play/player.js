function Player(Path,id){
	  $("#"+id).html(' <embed src="/wps/scripts/play/player.swf?mp3='+Path+'"'
		      + ' name="main"'
		      + ' width="346"'
		      + ' height="32"'
		      + ' quality="high"'
		      + ' align="middle"'
		      + ' swLiveConnect="true"'
		      + ' allowFullScreen="true"'
		      + ' allowScriptAccess="always"'
		      + ' type="application/x-shockwave-flash"'
		      + ' pluginspage="http://www.macromedia.com/go/getflashplayer"'
		      + ' />'
);
}

function getflash(){
	return window.document.main;
}
function keyDone(aevent) {
	if(!aevent) 
	aevent=window.event;
if(aevent.keyCode==119 ){//F8
		getflash().playControl(999);
	}else if(aevent.keyCode==120 ){//F9
		getflash().playControl(998);
	}
}
function playControl(num){alert(num);}