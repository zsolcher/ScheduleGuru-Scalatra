<html>
    <section>
        <div class="page" id="pageUploadTranscript">
            <textarea id="textAreaTranscript" rows="40" cols="40"
                      placeholder="Paste your transcript here..."></textarea>
            <button id="btnSubmitTranscript">Submit</button>

            <div id="tableContainer" class="tableContainer">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable">
                    <thead class="fixedHeader">
                    <tr>
                        <th>Course Section</th>
                        <th>Course Title</th>
                        <th>Credits</th>
                        <th>Term</th>
                    </tr>
                    </thead>
                    <tbody class="scrollContent">
                    <tr>
                        <td>a</td>
                        <td>b</td>
                        <td>c</td>
                        <td>d</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
	
    <section>
        <div class="page" id="pagePreferences">
            <div class="preferenceArea">
                <label for="selectMajor">Choose your major: </label>
                <select id="selectMajor" onchange="majorOnChangeResponse();">
                    <option selected>Undecided</option>
                    <option>Anthropology</option>
                    <option>Art</option>
                    <option>Art History</option>
                    <option>Biology</option>
                    <option>Biochemistry *</option>
                    <option>Biochemistry & Molecular Biology *</option>
                    <option>Business Administration</option>
                    <option>Chemistry</option>
                    <option>Applied Chemistry</option>
                    <option>Chemistry with High School Teaching Certification</option>
                    <option>Chinese Studies</option>
                    <option>Ancient Mediterranean Studies</option>
                    <option>Classical Languages *</option>
                    <option>Communication **</option>
                    <option>Computer Science</option>
                    <option>Computing as a Second Major</option>
                    <option>Economics</option>
                    <option>Engineering Science *</option>
                    <option>English</option>
                    <option>Environmental Studies</option>
                    <option>French</option>
                    <option>Geosciences</option>
                    <option>German Studies</option>
                    <option>Greek</option>
                    <option>History</option>
                    <option>Human Communication</option>
                    <option>International Studies</option>
                    <option>Latin</option>
                    <option>Mathematics</option>
                    <option>Mathematical Finance</option>
                    <option>Music</option>
                    <option>Neuroscience *</option>
                    <option>Philosophy</option>
                    <option>Physics</option>
                    <option>Political Science</option>
                    <option>Psychology</option>
                    <option>Religion</option>
                    <option>Russian</option>
                    <option>Sociology</option>
                    <option>Spanish</option>
                    <option>Theatre</option>
                    <option>Urban Studies</option>
                </select>
                <br><br>
            
                <label for="radioGroupStart">What time do you want the earliest class to start? </label>
						<br>                
                <input type="radio" name="radioStart" value="No Preference" onchange="preferedStartOnChange(this);" checked="true">No Preference</input>
                <input type="radio" name="radioStart" value="08:30:00" onchange="preferedStartOnChange(this);">8:30</input>
                <input type="radio" name="radioStart" value="09:30:00" onchange="preferedStartOnChange(this);">9:30</input>
                <input type="radio" name="radioStart" value="10:30:00" onchange="preferedStartOnChange(this);">10:30</input>
                <input type="radio" name="radioStart" value="11:30:00" onchange="preferedStartOnChange(this);">11:30</input>
                <input type="radio" name="radioStart" value="12:30:00" onchange="preferedStartOnChange(this);">12:30</input>
                <br><br>
                <label for="radioGroupStart">What time do you want the latest class to end? </label>
                <br>
                <input type="radio" name="radioEnd" value="No Preference" checked="true" onchange="preferedEndOnChange(this);">No Preference</input>
                <input type="radio" name="radioEnd" value="11:20:00" onchange="preferedEndOnChange(this);">11:20</input>
                <input type="radio" name="radioEnd" value="12:20:00" onchange="preferedEndOnChange(this);">12:20</input>
                <input type="radio" name="radioEnd" value="13:20:00" onchange="preferedEndOnChange(this);">1:20</input>
                <input type="radio" name="radioEnd" value="14:20:00" onchange="preferedEndOnChange(this);">2:20</input>
                <input type="radio" name="radioEnd" value="15:55:00" onchange="preferedEndOnChange(this);">3:55</input>
            	<br><br>
                <label for="divDaysAvailable">Which days do you want to have class? </label>
                	<br>
                	<input type="checkbox" name="days" value="M" checked="true" onchange="preferedDaysOnChange(this);">Monday</input>
                	<input type="checkbox" name="days" value="T" checked="true" onchange="preferedDaysOnChange(this);">Tuesday</input>
                	<input type="checkbox" name="days" value="W" checked="true" onchange="preferedDaysOnChange(this);">Wednesday</input>
                	<input type="checkbox" name="days" value="R" checked="true" onchange="preferedDaysOnChange(this);">Thursday</input>
                	<input type="checkbox" name="days" value="F" checked="true" onchange="preferedDaysOnChange(this);">Friday</input>

                <br>
                </div>
        </div>
    </section>
    <section>
        <div  id="majorClassOptions">
        </div>
    </section>
    <section>
        	<p>These are the Common Curriculum classes that fit within your time preferences and do not conflict with a class you are taking for your major. Please select all you would like to take. There is an additional step where you may select non-Common Curriculum classes if you so wish.
			</p><b><u>Understanding Cultural Heritage</u></b>
        	 <ul id="cc">
   	     	 
        	 </ul>
    </section>
    <section>
        <div class="page" id="finalize">
            
        </div>
    </section>


<script src="js/buildScheduleArea.js"></script>
<script src="js/buildClassTable.js"></script>
</html>
