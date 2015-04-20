//Globals
var calendars = new Array();
var updateEvery = 100; //milliseconds
var widthFrac = 1.00;
var heightFrac = 1.00;
var minWidth = 600;
var minHeight = 600;
var maxWidth = 800;
var maxHeight = 800;
var minWidthToHeightRatio = 0.8;
var numDays = 5;
var classToDayWidthRatio = (10.0/10.0);
var dayHeightRatio = (4.0/5.0);
var daysArray = ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"];
var colorsArray = ["#4285f4","#bbdefb","#7986cb","#89bdff","#00bbd3","#accbff","#5899db","#3d61ff","#00e0ff","#f06292","#4585f2","#c0c0c0","#008000","#0000ff","#ff0000","#051153","#8000ff","#ffa500","#ff6666","#b0e0e6"];
var earliestStart = 8;
var latestEnd = 18;
var fontSize = 2;
var fontBase = 100;
var backgroundColor = "#EEEEEE";
var divName = "";
var calendarCourseArray = new Array();
if(localStorage.getItem("majorClassesSelected") != "null") calendarCourseArray = JSON.parse(localStorage.getItem("majorClassesSelected"));
var canvas = null;
var ctx;

window.setInterval(function(){ drawLoop(); }, updateEvery);

function drawLoop() {
	if(canvas!=null){
		updateCanvas();
	}
}

function addCalendarClass(toAdd){
	if(toAdd['Number'] == undefined){
		alert("Number is undefined in addCalendarClass");
		return false;
	}
	if(calendarCourseArrayContains(toAdd['ClassID'])){
		alert("Already added that course");
		return false;
	}
	var overlapCourse = checkOverlap(toAdd);
	if(overlapCourse != -1){
		var overlapName = overlapCourse['department']+overlapCourse['num'];
		alert("Selected course overlaps with:\n\n"+overlapName+"\n\nPlease uncheck that course first");
		return false;
	}

	var toPush = new Object;
	toPush['start'] = toAdd['StartTime'];
	toPush['end'] = toAdd['EndTime'];
	toPush['name'] = 'none';
	toPush['department'] = toAdd['Department'];
	toPush['num'] = toAdd['Number'];
	toPush['days'] = toAdd['Days'];
	toPush['classID'] = toAdd['Department']+toAdd['Number']+toAdd['StartTime']+toAdd['EndTime'];
	calendarCourseArray.push(toPush);
	return true;
}

function createCalendarUnderDiv(_divName){
	divName = _divName;
	canvas = document.createElement("canvas");
	document.getElementById(divName).appendChild(canvas);
}

function deleteCalendar(){
	canvas.parentNode.removeChild(canvas);
}

function updateCanvas(){
	var ctx = canvas.getContext("2d");
	var currWidth = document.getElementById(divName).offsetWidth*widthFrac;
	var currHeight = document.getElementById(divName).offsetHeight*heightFrac;

	if(currWidth < minWidth) currWidth = minWidth;
	else if(currWidth > maxWidth) currWidth = maxWidth;

	if(currHeight < minHeight) currHeight = minHeight;
	else if(currHeight > maxHeight) currHeight = maxHeight;

	if(currWidth/currHeight < minWidthToHeightRatio){
		canvas.width = currWidth;
		canvas.height = currWidth/minWidthToHeightRatio;
	}
	else {
		canvas.width = currWidth;
		canvas.height = currHeight;
	}
	//canvas.width = 800;
	//canvas.height = 800;
	ctx.clearRect(0,0,canvas.width,canvas.height);
	ctx.fillStyle = backgroundColor;
	ctx.fillRect(0,0,canvas.width,canvas.height);
	drawSchedule();
}

function drawSchedule(){
	var ctx = canvas.getContext("2d");
	var dayWidth = canvas.width/(numDays+2);
	var dayGap = dayWidth/(numDays+1);
	var timeGap = canvas.width-dayWidth*numDays-dayGap*(numDays+1);
	var dayVertGap = canvas.height*(1-dayHeightRatio)/2;
	var classWidth = dayWidth*classToDayWidthRatio;
	var currX = timeGap;
	var currY = dayVertGap;
	var dayLen = canvas.height*dayHeightRatio;
	var hourSpacing = dayLen/(latestEnd-earliestStart);
	ctx.fillStyle = "#000000";
	ctx.font = "bold "+getFont();
	ctx.textAlign="right";
	ctx.textBaseline = "middle";

	//Drawing time of day
	for(var i = earliestStart; i <= latestEnd; ++i){
		var time = i;
		var amPm = "pm  ";
		if(time > 12) time -= 12;
		else if(time < 12) amPm = "am  ";

		ctx.fillText(time.toString()+":00 "+amPm,currX,(i-earliestStart)*hourSpacing+currY);
	}

	ctx.fillStyle = "#000000";
	ctx.font = "bold "+getFont();
	ctx.textAlign="center";
	ctx.textBaseline = "bottom";

	//Drawing day boxes
	for(var i = 0; i < numDays; ++i){
		ctx.rect(currX,currY,dayWidth,canvas.height*dayHeightRatio);
		ctx.stroke();
		ctx.fillText(daysArray[i],currX+dayWidth/2,currY)
		currX += dayWidth+dayGap;
	}

	//Drawing courses
	for(var i = 0; i < calendarCourseArray.length; ++i){
		var courseDep = calendarCourseArray[i].department;
		var courseNum = calendarCourseArray[i].num;
		var courseStart = calendarCourseArray[i].start;
		var courseEnd = calendarCourseArray[i].end;
		var courseDays = calendarCourseArray[i].days;
		var startHeight = dayVertGap+interpTime(courseStart)*dayLen;
		var endHeight = dayVertGap+interpTime(courseEnd)*dayLen;

		if(courseDays != "TBA"){
			for(var j = 0; j < courseDays.length; ++j){
				var startWidth = timeGap;
				if(courseDays[j] == 'M') startWidth;
				else if(courseDays[j] == 'T') startWidth += 1*(dayWidth+dayGap);
				else if(courseDays[j] == 'W') startWidth += 2*(dayWidth+dayGap);
				else if(courseDays[j] == 'R') startWidth += 3*(dayWidth+dayGap);
				else if(courseDays[j] == 'F') startWidth += 4*(dayWidth+dayGap);
				else if(courseDays[j] == 'S') startWidth += 5*(dayWidth+dayGap);
				else if(courseDays[j] == 'U') startWidth += 6*(dayWidth+dayGap);
				startWidth += (dayWidth-classWidth)/2;
				ctx.fillStyle = colorsArray[i];
				ctx.fillRect(startWidth,startHeight,classWidth,endHeight-startHeight);

				ctx.font = getFont();
				ctx.fillStyle = "#000000";
				ctx.textAlign = "center";
				ctx.textBaseline = "middle";
				ctx.fillText(courseDep+" "+courseNum,startWidth+classWidth/2,(startHeight+endHeight)/2)
			}
		}
	}
}

function interpTime(time){
	if(time == "00:00:00") return -1;
	var splitTime = time.split(":");
	var decimalHour = Number(splitTime[0]);
	if(decimalHour < earliestStart) decimalHour = decimalHour+12;
	var decimalTime = decimalHour+Number(splitTime[1])/60;
	var interpFrac = (decimalTime-earliestStart)/(latestEnd-earliestStart);
	return interpFrac;
}

function toggleDays(){
	if(numDays == 5) numDays = 7;
	else if(numDays == 7) numDays = 5;
}

function getFont() {
    var ratio = fontSize / fontBase;   // calc ratio
    var size = canvas.width * ratio;   // get font size based on current width
    return (size|0) + 'px Arial'; // set font
}

function calendarCourseArrayContains(classID){
	var foundDuplicate = false;
	var i = 0;
	while(!foundDuplicate && i < calendarCourseArray.length){
		var course = calendarCourseArray[i];
		if(course['classID'] == classID) foundDuplicate = true;
		++i;
	}
	return foundDuplicate;
}

function removeCalendarClass(classID){
	var found = false;
	var i = 0;
	while(!found && i < calendarCourseArray.length){
		var course = calendarCourseArray[i];
		//alert('comparing '+classID+' against '+course['classID']);
		if(course['classID'] == classID) found = true;
		else ++i;
	}
	if(i < calendarCourseArray.length) calendarCourseArray.splice(i,1);
}

function checkOverlap(course){
	var foundOverlap = false;
	var i = 0;
	var newStart = interpTime(course['StartTime']);
	var newEnd = interpTime(course['EndTime']);
	var newDays = course['Days'];
	while(!foundOverlap && i < calendarCourseArray.length){
		var currentCourse = calendarCourseArray[i];
		var start = interpTime(currentCourse['start']);
		var end = interpTime(currentCourse['end']);
		var days = currentCourse['days'];
		if(checkDayOverlap(newDays,days)){
			if(start == -1 || end == -1) ++i;
			else if((start >= newStart && start <= newEnd) || (end >= newStart && end <= newEnd)) foundOverlap = true;
			else ++i;
		}
		else ++i;
	}

	if(foundOverlap) return calendarCourseArray[i];
	else return -1;
}

function checkDayOverlap(days1,days2){
	var foundOverlap = false;
	var i = 0;
	while(!foundOverlap && i < days1.length){
		if(days2.indexOf(days1[i]) != -1) foundOverlap = true;
		else ++i;
	}
	return foundOverlap;
}

function getCalendarFromName(calendarName){
	var found = false;
	var i = 0;
	while(!found && i < calendars.length){
		if(calendars['Name'] == calendarName) fund = true;
		else ++i;
	}
	
	if(found) return calendars[i];
	else return -1;
}
