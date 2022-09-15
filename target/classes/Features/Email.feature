Feature: Email Page Validation


@Testing1
  Scenario:  Verify the Email Page
    Given user is on the HomePage of the temp email site
    And user Generate temporary email and copy the same using copy button.
		When Go to your Gmail and send an email on this temporary email.
	  And Go back to the site https://temp-mail.org/en/
		And Click to the newly received mail.
		Then Verify the Subject and Body of email 
		And Take a screenshot of the Email.
    #Then Close the browser
