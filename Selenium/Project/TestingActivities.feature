@EndToEndPart1
Feature: TestingActivities.feature
	
	Background: Load Alchemy Jobs page
		Given user Opens a browser
		When user Navigates to "https://alchemy.hguy.co/jobs"
	
	#Goal: Read the title of the website and verify the text
	@Activity1
	Scenario: Verify the website title
		And user Get Page Title
		Then Verify Page title matches with "Alchemy Jobs - Job Board Application"
	
	#Goal: Read the heading of the website and verify the text
	@Activity2
	Scenario: Verify the website heading
		And Get Page Header
		Then verify Page heading matches with "Welcome to Alchemy Jobs"
		
	#Goal: Print the url of the header image to the console
	@Activity3
	Scenario: Get the url of the header image
		And user gets the url of the header image
		Then Print header image url in Console
		
	#Goal: Read the second heading of the website and verify the text
	@Activity4
	Scenario: Verify the website’s second heading
		And user gets the second heading on the page
		Then Verify second heading matches with "Quia quis non"
	
	#Goal: Navigate to the Jobs page on the site.
	@Activity5
	Scenario: Navigate to another page
		And user select the Jobs menu item from the Navigation Bar
		Then Verify Jobs Page title
	
	#Goal: Search for a job and apply for it
	@Activity6
	Scenario: Apply to a job
		And user select the Jobs menu item from the Navigation Bar
		Then user search for a "Banking" job and wait for listings to show
		And user clicks and open any one of the jobs listed
		And user clicks the apply button and print the email to the console
	
	#Goal: Create a new job listing
	@Activity7
	Scenario: Create a new job listing
		And user select the Post a Job menu item from the Navigation Bar
		When user sign in to job listing page
		And user fill up the neccessary details for job listing
		| Test Specialist2 | Pune, India | Internship | FST-Test Analyst |
		And user clicks on the Preview button
		Then user clicks on Submit Listing button
		And user select the Jobs menu item from the Navigation Bar
		And Verify job listing was posted in the job page
		
	
		
		