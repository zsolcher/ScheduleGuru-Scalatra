<?php
if(!sset($_POST['submit'])){
	echo "error, need to submit the form";
}

$contact_name = $_POST['contact_name'];
$contact_email = $_POST['contact_email'];
$contact_message = $_POST['contact_message']; 

//Validation
if(empty($contact_name) || empty($contact_email))
{
	echo "Name and email are mandatory!";
	exit; 
}
	$email_from = 'rbierman@trinity.edu';
	$email_subject = 'New Form Submission'; 
	$email_body = $message; 

	$to = $email_from;
	$headers = "From: $email_from \r\n";
	$headers .="Reply-To: $contact_email \r\rn";

	//send the email
	mail$to, $email_subject, $email_body, $headers); 
?>