# LambdaTestAutomation

Read ME. Date: 06/30/2022

Git Repository: https://github.com/mezhpotato/LambdaTestAutomation


Installation Instruction:


Pre-requisites:
- JDK version used: 11.0.15.1. Installation link: https://www.oracle.com/ph/java/technologies/javase/jdk11-archive-downloads.html
- IDE to be used is Maven-ready. (e.g. Eclipse. Installation link for Windows: https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2022-06/R/eclipse-inst-jre-win64.exe)
- Chrome browser version used: 103
- Chromedriver version used: 103
- 1 script would require existing Google account to be setup. (See below for details)
- 1 script would require to setup GitHub account on the script. (See below for details)


IMPORTANT Notes:
- Project is setup in this directory: C:\Workspace
- Selenium-Java jar version used: 3.14.0
- Tests are divided on several test files (java class)

Script Notes:

FOR ValidGoogleLoginTest.java 
- Script will automatically close all instances of Chrome browser. Please be advise and save anything before running the script.
- For the script to work existing google profile must be used and already be setup in your chrome browser.
- Google account to be used must have been already registered with the the website.
- This is a workaround implemented to by-pass the Google Secured login feature.

FOR ValidGitHubLoginTest.java 
- User needs to setup own GitHub credentials in the script to avoid the device verification.

Execution:
1. Clone the repository
(Note: steps are done using eclipse)
2. Import the project file in IDE
3. Open test in this package: LambdaTestAutomation\src\tests
4. Run scripts as Java (Right click on file > Run as Java Application
