
//Dropdown menu for module selection.
function dropDown() {
  document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
	  if (!event.target.matches('.dropbtn')) {
	    var dropdowns = document.getElementsByClassName("dropdown-content");
	    var i;
	    for (i = 0; i < dropdowns.length; i++) {
	      var openDropdown = dropdowns[i];
	      if (openDropdown.classList.contains('show')) {
	        openDropdown.classList.remove('show');
	      }
	    }
	  }
	}

window.onload = function(){
	//document.getElementById("contactGoals").innerHTML = "I changed";
	calculate();
	
}

function validateModuleForm(){
	let moduleNumber = document.getElementById("moduleNumber").value;
	let aboutPages = document.getElementById("aboutPages").value;
	let introductionText = document.getElementById("introductionText").value;
	let videoTime = document.getElementById("video").value;
	let podcastTime = document.getElementById("podcast").value;
	let discussionText = document.getElementById("discussionText").value;
	let discussionVideo = document.getElementById("discussionVideo").value;
	let meetings = document.getElementById("meetings").value;
	let lectureText = document.getElementById("lectureText").value;
	let lectureVideo = document.getElementById("lectureVideo").value;
	let readingArticles = document.getElementById("readingArticles").value;
	let paperbackBook = document.getElementById("paperbackBook").value;
	let academicMonograph = document.getElementById("academicMonograph").value;
	let textbookReadings = document.getElementById("textbookReadings").value;
	let reflectionNarrative = document.getElementById("reflectionNarrative").value;
	let argument = document.getElementById("argument").value;
	let research = document.getElementById("research").value;
	let caseStudy = document.getElementById("caseStudy").value;
	let practiceActivities = document.getElementById("practiceActivities").value;
	let projects = document.getElementById("projects").value;
	let studyHours = document.getElementById("studyHours").value;
	let quizQuestions = document.getElementById("quizQuestions").value;
	let practiceQuestions = document.getElementById("practiceQuestions").value;
	let errors = document.getElementById("errors");

	console.log("Function Called!");
	
	
	if(isNaN(moduleNumber) || moduleNumber < 0 || moduleNumber > 30 || moduleNumber == ""){
		errors.innerHTML = "The Module Number is incorrect."
		return false;
	}
	
	if(aboutPages > 30){
		errors.innerHTML = "The about pages is incorrect."
		alert("about pages incorrect.");
		return false;
		
	}
	if(isNaN(introductionText) || introductionText < 0 || introductionText > 30 || introductionText == ""){
		return false;
	}
	if(isNaN(videoTime) ||videoTime < 0 || videoTime > 30 || videoTime == ""){
		return false;
	}
	if(isNaN(podcastTime) || podcastTime < 0 || podcastTime > 30 || podcastTime == ""){
		return false;
	}
	if(isNaN(discussionText) || discussionText < 0 || discussionText > 30 || discussionText == ""){
		return false;
	}
	if(isNaN(discussionVideo) || discussionVideo < 0 || discussionVideo > 30 || discussionVideo == ""){
		return false;
	}
	if(isNaN(meetings) || meetings < 0 || meetings > 30 || meetings == ""){
		return false;
	}
	if(isNaN(lectureText) || lectureText < 0 || lectureText > 30 || lectureText == ""){
		return false;
	}
	if(isNaN(lectureVideo) || lectureVideo < 0 || lectureVideo > 30 || lectureVideo == ""){
		return false;
	}
	if(isNaN(readingArticles) || readingArticles < 0 || readingArticles > 30 || readingArticles == ""){
		return false;
	}
	if(isNaN(paperbackBook) || paperbackBook < 0 || paperbackBook > 30 || paperbackBook == ""){
		return false;
	}
	if(isNaN(academicMonograph) || academicMonograph < 0 || academicMonograph > 30 || academicMonograph == ""){
		return false;
	}
	if(isNaN(textbookReadings) || textbookReadings < 0 || textbookReadings > 30 || textbookReadings == ""){
		return false;
	}
	if(isNaN(reflectionNarrative) || reflectionNarrative < 0 || reflectionNarrative > 30 || reflectionNarrative == ""){
		return false;
	}
	if(isNaN(argument) || argument < 0 || argument > 30 || argument == ""){
		return false;
	}
	if(isNaN(research) || research < 0 || research > 30 || research == ""){
		return false;
	}
	if(isNaN(caseStudy) || caseStudy < 0 || caseStudy > 30 || caseStudy == ""){
		return false;
	}
	if(isNaN(practiceActivities) || practiceActivities < 0 || practiceActivities > 30 || practiceActivities == ""){
		return false;
	}
	if(isNaN(projects) || projects < 0 || projects > 30 || projects == ""){
		return false;
	}
	if(isNaN(studyHours) || studyHours < 0 || studyHours > 30 || studyHours == ""){
		return false;
	}
	if(isNaN(quizQuestions) || quizQuestions < 0 || quizQuestions > 30 || quizQuestions == ""){
		return false;
	}
	if(isNaN(practiceQuestions) || practiceQuestions < 0 || practiceQuestions > 30 || practiceQuestions == ""){
		return false;
	}
	return false;
}
//Function to calculate the totals for the entire module.
function calculate(){
	let aboutPages = document.getElementById("aboutPages").value;
	let aboutTotal = aboutPages/180/60;
	document.getElementById("aboutTotal").innerHTML = aboutTotal.toFixed(4);
	
	let introductionText = document.getElementById("introductionText").value;
	let introductionTotal = introductionText/180/60;
	document.getElementById("introductionTotal").innerHTML = introductionTotal.toFixed(4);

	let videoTime = document.getElementById("video").value;
	let videoTotal = videoTime * 1.5 / 60;
	document.getElementById("videoTotal").innerHTML = videoTotal.toFixed(4);
	
	let podcastTime = document.getElementById("podcast").value;
	let podcastTotal = podcastTime * 1.5 /60;
	document.getElementById("podcastTotal").innerHTML = podcastTotal.toFixed(4);
	
	let discussionText = document.getElementById("discussionText").value;
	let discussionTextTotal = discussionText / 125;
	document.getElementById("discussionTextTotal").innerHTML = discussionTextTotal.toFixed(4);
	
	let discussionVideo = document.getElementById("discussionVideo").value;
	let discussionVideoTotal = discussionVideo * 1.5 / 60;
	document.getElementById("discussionVideoTotal").innerHTML = discussionVideoTotal.toFixed(4);
	
	let meetings = document.getElementById("meetings").value;
	let meetingsLength = document.getElementById("meetingLength").value;
	let meetingsTotal = meetings * meetingsLength;
	document.getElementById("meetingsTotal").innerHTML = meetingsTotal.toFixed(4);
	
	let lectureText = document.getElementById("lectureText").value;
	let lectureTextTotal = lectureText / 180 / 60;
	document.getElementById("lectureTextTotal").innerHTML = lectureTextTotal.toFixed(4);
	
	let lectureVideo = document.getElementById("lectureVideo").value;
	let lectureVideoTotal = lectureVideo * 1.5 / 60;
	document.getElementById("lectureVideoTotal").innerHTML = lectureVideoTotal.toFixed(4);
	
	let readingArticles = document.getElementById("readingArticles").value;
	let readingArticlesTotal = readingArticles / 180 / 60;
	document.getElementById("readingArticlesTotal").innerHTML = readingArticlesTotal.toFixed(4);
	
	let paperbackBook = document.getElementById("paperbackBook").value;
	let paperbackBookTotal = paperbackBook / 24;
	document.getElementById("paperbackBookTotal").innerHTML = paperbackBookTotal.toFixed(4);
	
	let academicMonograph = document.getElementById("academicMonograph").value;
	let academicMonographTotal = academicMonograph / 18;
	document.getElementById("academicMonographTotal").innerHTML = academicMonographTotal.toFixed(4);
	
	let textbookReadings = document.getElementById("textbookReadings").value;
	let textbookReadingsTotal = textbookReadings / 14;
	document.getElementById("textbookReadingsTotal").innerHTML = textbookReadingsTotal.toFixed(4);
	
	let reflectionNarrative = document.getElementById("reflectionNarrative").value;
	let reflectionNarrativeTotal = reflectionNarrative / 250;
	document.getElementById("reflectionNarrativeTotal").innerHTML = reflectionNarrativeTotal.toFixed(4);
	
	let argument = document.getElementById("argument").value;
	let argumentTotal = argument / 125;
	document.getElementById("argumentTotal").innerHTML = argumentTotal.toFixed(4);
	
	let research = document.getElementById("research").value;
	let researchTotal = research / 62.5;
	document.getElementById("researchTotal").innerHTML = researchTotal.toFixed(4);
	
	let caseStudy = document.getElementById("caseStudy").value;
	let caseStudyTotal = caseStudy / 500;
	document.getElementById("caseStudyTotal").innerHTML = caseStudyTotal.toFixed(4);
	
	let practiceActivities = document.getElementById("practiceActivities").value;
	let practiceActivitiesTotal = practiceActivities * 1;
	document.getElementById("practiceActivitiesTotal").innerHTML = practiceActivitiesTotal.toFixed(4);
	
	let projects = document.getElementById("projects").value;
	let projectsTotal = projects * 1;
	document.getElementById("projectsTotal").innerHTML = projectsTotal.toFixed(4);
	
	let studyHours = document.getElementById("studyHours").value;
	let studyHoursTotal = studyHours * 1;
	document.getElementById("studyHoursTotal").innerHTML = studyHoursTotal.toFixed(4);
	
	let quizQuestions = document.getElementById("quizQuestions").value;
	let quizQuestionsTotal = quizQuestions * 3 /60;
	document.getElementById("quizQuestionsTotal").innerHTML = quizQuestionsTotal.toFixed(4);
	
	let practiceQuestions = document.getElementById("practiceQuestions").value;
	let practiceQuestionsTotal = practiceQuestions * 1.5 / 60;
	document.getElementById("practiceQuestionsTotal").innerHTML = practiceQuestionsTotal.toFixed(4);
	
	//calculates goal totals
	let creditHours = document.getElementById("courseCredits").innerHTML;
	let courseHours = creditHours * 37.5 - 4.5;
	let moduleGoal = courseHours / 12;
	let contactHoursGoal = moduleGoal / 3;
	let independentHoursGoal = contactHoursGoal * 2;
	
	document.getElementById("contactGoals").innerHTML = creditHours + " Hours";
	document.getElementById("independentGoals").innerHTML = independentHoursGoal + " Hours";
	document.getElementById("moduleGoal").innerHTML = moduleGoal + " Hours";
	
	//calculates actual hours
	actualContactHours = aboutTotal + introductionTotal + videoTotal + podcastTotal + discussionTextTotal + discussionVideoTotal + meetingsTotal + lectureTextTotal + lectureVideoTotal;
	document.getElementById("actualContactHours").innerHTML = actualContactHours.toFixed(4);
	actualIndependentHours = readingArticlesTotal + paperbackBookTotal + academicMonographTotal + textbookReadingsTotal + reflectionNarrativeTotal + argumentTotal + researchTotal + caseStudyTotal + practiceActivitiesTotal + projectsTotal + studyHoursTotal + quizQuestionsTotal + practiceQuestionsTotal;
	document.getElementById("actualIndependentHours").innerHTML = actualIndependentHours.toFixed(4);
	actualModuleHours = actualContactHours + actualIndependentHours;
	document.getElementById("actualModuleHours").innerHTML = actualModuleHours.toFixed(4);
	
	contactHoursDifference = contactHoursGoal - actualContactHours;
	independentHoursDifference = independentHoursGoal - actualIndependentHours;
	moduleHoursDifference = moduleGoal - actualModuleHours;
	
	document.getElementById("contactHoursDifference").innerHTML = contactHoursDifference.toFixed(4);
	document.getElementById("independentHoursDifference").innerHTML = independentHoursDifference.toFixed(4);
	document.getElementById("moduleHoursDifference").innerHTML = moduleHoursDifference.toFixed(4);
	
	console.log(Math.abs(contactHoursDifference));
	console.log(contactHoursGoal * .1);
	
	//Red text to show differences are out of range
	if (Math.abs(contactHoursDifference) > (contactHoursGoal * .1)){
		document.getElementById("contactHoursDifference").style.color = "red";
	}
	if (Math.abs(contactHoursDifference) < (contactHoursGoal * .1)){
		document.getElementById("contactHoursDifference").style.color = "black";
	}
	
	if (Math.abs(independentHoursDifference) > (independentHoursGoal * .1)){
		document.getElementById("independentHoursDifference").style.color = "red";
	}
	if (Math.abs(independentHoursDifference) < (independentHoursGoal * .1)){
		document.getElementById("independentHoursDifference").style.color = "black";
	}
	
	if (Math.abs(moduleHoursDifference) > (moduleGoal * .1)){
		document.getElementById("moduleHoursDifference").style.color = "red";
	}
	if (Math.abs(moduleHoursDifference) < (moduleGoal * .1)){
		document.getElementById("moduleHoursDifference").style.color = "black";
	}
}


