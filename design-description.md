DESIGN DOCUMENT

1. When the app is started, the user is presented with the main menu, which allows  the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

    To realise this requirement, I have created a User class, CurrentJob class and a ComparisonSettings class. Within the User class, the current job is stored as a variable as well as compareSettings. 

    The methods are what the main menu is. I did not define a main menu since that would be our GUI. The methods are enterJobOffer, modifyCurrJob, adjComparisonSettings and compareJobOffers.


2. When choosing to enter current job details, a user will:
    Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:

    Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

The modifyCurrJob will enable the user to enter or modify their current jobs. This uses the CurrentJob class which is the sub class of the Job class. Within the CurrentJob class, the methods save and cancel can save the job details or cancel and exit without saving.


3. When choosing to enter job offers, a user will:
    •	Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
    •	Be able to either save the job offer details or cancel.
    •	Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

The User class consists of the enterJobOffer method which uses the JobOffer class which is the sub class of a Job class. There is a one to many relationship since one user can have multiple job offers. 
The JobOffer class has a save and cancel method to save the job offer details or cancel. The enterJobOffer method enables user to add another job offer. The compareJobOffers method enables user to move to comparing job offers.

4. When adjusting the comparison settings, the user can assign integer weights to:
    •	Yearly salary 
    •	Yearly bonus 
    •	Leave  
    •	Maternity/Paternity Leave 
    •	Life Insurance  
    •	If no weights are assigned, all factors are considered equal.

To realise this requirement, the user class has an adjComparisonSettings method which uses the ComparisonSettings class. It enables the user to set the appropriate setting and the class has a save method to save the desired settings

5. When choosing to compare job offers, a user will:
    •	Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
    •	Select two jobs to compare and trigger the comparison.
    •	Be shown a table comparing the two jobs, displaying, for each job:
    o	Title
    o	Company
    o	Location 
    o	Yearly salary adjusted for cost of living
    o	Yearly bonus adjusted for cost of living
    o	Leave
    o	Maternity/Paternity Leave 
    o	Life Insurance  
    •	Be offered to perform another comparison or go back to the main menu.

To realise this requirement, the User class has a compareJobOffers method which takes in the current job and a selected job offer and uses the CompareResults class. The list of job offers displayed as Title and Company and ranked from best to worse is not shown here as this will be done by the GUI. Similarly, the selection of two jobs to compare and trigger comparison is also handled by the GUI hence not displayed in the UML diagram.

The CompareResults class is where the results are calculated and displayed in the GUI. This class has the option to generate another comparison by having the compareJobOffers method.


6. When ranking jobs, a job’s score is computed as the weighted sum of:
    AYS + AYB + (LT * AYS / 260) + (MPL * AYS / 260) + (LI/100 * AYS)
    •	where:
    AYS = yearly salary adjusted for cost of living
    AYB = yearly bonus adjusted for cost of living
    LT = Leave
    •	MPL = Maternity/Paternity Leave
    •	LI = Life Insurance

    For example, if the weights are 3 for the yearly salary, 2 for Maternity/Paternity Leave and 1 for all other factors, the score would be computed as:
    (3/7 * AYS) + (1/7 * AYB) + (1/7 * LT * AYS / 260) + (2/7 * MPL * AYS / 260) + (1/7* LI/100 * AYS)

The ranking of  the job is stored in the Job class. The job class has a method rankJob which takes in the AYS, AYB, LT, MPL and LI to calculate the rank

7. The user interface must be intuitive and responsive.
This is a GUI requirement

8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
There is only one User class and no communication or saving between devices.
