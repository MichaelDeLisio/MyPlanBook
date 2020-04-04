#  myPlanBook

## Content
1. Introduction
2. Installation
3. Financial Hub

---

## Introduction

myPlanBook is an Android mobile application that runs on Android API 16 to the latest release as of this application's first release (API 29). The application aims to be its users own virtual personal secretary by helping its users track their engagements and upcoming deadlines using its Calendar feature. Through the app's Financial Hub, users can track their monthly and yearly spending while setting yearly saving goals to help manage their spending. The Health and Fitness feature allows users to measure their body weight, body fat and workout routines. The app also provides a wish list feature.

---

## Installation

https://developer.android.com/studio/run/device

1. Install Android Studio
2. Clone the repository and import in Android Studio
3. On your Android device open the Settings app, select Developer options, and then enable USB debugging.
   - Note: If you do not see Developer options, follow the instructions to [enable developer options](https://developer.android.com/studio/debug/dev-options).
4. When you are set up and plugged in over USB, you can click Run in Android Studio to build and run the app on the device.


---

## Financial Hub



<img align="right" src="https://github.com/UTMCSC301/project-thebrogrammers/blob/master/doc/screenshots/financialHub.png" width="216" height="384">



### Load Transactions

This feature of the **Financial Hub** provides a few features which include: a auto-load feature, a manual load feature, and deletion features. The auto-load feature allows users to upload their banking transactions via a CSV file, provided by their bank. Most banks provide this functionality through their online account services. When you click on "Load CSV File", the user is presented with the Android local file explorer, from where they can import a banking .csv file. After clicking the csv of revelance, the app will report through a popup window either success of the operation or error. You can verify that your transactions were imported properly by navigating to the **Manage Finances** feature.


**Note**: the application expects the format of the csv file as follows: "<dd/mm/yyyy>, \<store name/category> \<debit amount\>, \<credit amount\>, \<credit card number\>). 

Load Transactions also allows users to mannually enter every transaction they wish after clicking on the "Manually Load" button. To commit a transaction to your account, first fill all text fields and the click on a date on the calendar at the top of the screen. Once you've entered all requistory information, click either "Debit" or "Credit" based on the type of transaction, to queue the transaction to be loaded (you can view the queue of transactions at the bottom of the screen). Once you are done queuing all transactions you wish, then click on the "Commit Collection" button. If you make a mistake or don't wish to commit all the queued transactions, then you can click "Clear Collection" to delete all queued transactions without commiting them.

To delete financial data already imported and saved to your account, you can either delete all banking data by clicking the "Delete All" button at the bottom of the screen in the **Load Transactions** main window or delete by a specific month by scrolling to the preferred month and clicking on the "Delete Month" button.

### Set Goals

### Manage Finances

<img align="right" src="https://github.com/UTMCSC301/project-thebrogrammers/blob/master/doc/screenshots/manageFinances1.png" width="216" height="384">

After loading transactions into the account either manually or automatically,
the **Manage Finances** feature graphically displays the transactions in a user friendly way. The first pie chart labeled "Transactions by Category" displays the top 5 transactions by amount over the given year. Clicking on a percentile of the pie chart produces a information box about that transaction category. 

The second pie chart, labeled "Monthly Transactions", charts the amount of transactions made each month as a portion of the pie chart. The bottom charts display debit and credit expenditures for each month as a line graph. The interactive graph responds to zooms and clicks on mapped data points.




