# MavenCucumber

Selenium web browser tests in Java for amazon.com using using Selenium, Cucumber, and Maven.

This project uses selenium tests in Java to:
  1. Navigate to amazon.com in the Chrome web driver.
  2. Search "Nikon" in the search bar.
  3. Sort the product list from "Price: High to Low".
  4. Select the second product on the resulting page.
  5. Check whether the product topic contains the text “Nikon D3X” with an assert.

Project is executed in macos with a Silicon Chip (M1) PC and in Chrome version 113.0.5672.127.

# Requirements
  1. Java Development Kit (JDK)
  2. Maven
  3. Chrome webdriver needs to be downloaded according to your operating system.
  4. You need to enable assertions.

# Steps to execute the project
  1. Clone the git repository on your PC.
  2. Check your chrome version. The executable chromedriver in this repo is only for macos with Silicon Chip (M1) and for Chrome version 113.
  3. If your Chrome version or/and operating system differs from above specs, you need to download the Chrome web driver from https://chromedriver.chromium.org/downloads and replace the "chromedriver" file in the cloned project.
  4. If your operating system is windows:
        Open the project in your favorite IDE and edit the path to chromedriver. Change it from "./chromedriver" to "./chromedriver.exe" in the "AmazonSearchSteps" class.
  6. Open a terminal in the cloned project directory and build the project using the command "mvn clean install"
  7. Execute the test using "mvn clean test"
  8. You can edit the feature file to change the webpage, search term, and checking string.

<img width="759" alt="image" src="https://github.com/Kalpana19950117/MavenCucumber/assets/63944272/10ca1359-11a1-46cf-8560-0130844acd0d">

  
