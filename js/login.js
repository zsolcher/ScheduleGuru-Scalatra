/**
 * Created by zsolcher on 3/19/15.
 */
window.onload = function() {
    $('#btnRegister').on ({
        'click':  function(){
				alert("woo");
                window.location = './register.php';
            }
        }
    );

    $('#btnLogin').on ({
            'click':  function() {
                document.querySelector('#toastSubmit').show();
                var email = document.querySelector('#txtEmail').value;
                var pw = document.querySelector('#txtPassword').value;
                document.querySelector('#toastSubmit').text = "Email: " + email + ", Password: " + pw;

                var resultLogin = login(email,pw);
                if(resultLogin === "0") {
					alert("Wrong logins");
                    $('#loginMessage').innerHTML = "Incorrect login credentials. Please try again.";
                } else {
					alert("Correct logins");
                    window.location.href = "http://dias11.cs.trinity.edu/~rbierman/ScheduleGuru/index.php";
                }
            }
        }
    );

};


