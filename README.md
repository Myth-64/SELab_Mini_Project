# Program committee

## System Components:

1. User Authentication and Authorization:
    -Use a secure authentication mechanism (e.g., username/password authentication)      for program committee members to log in.
   - Implement role-based access control to ensure that only authorized members can          access the review interface.
   - If the login failed, give an error message saying “invalid”.

2. Dashboard:
   - Create a dashboard for program committee members upon login.
   - Display a summary of submitted papers, including their titles, authors, and statuses          (e.g., pending, reviewed).

3. Paper Review Interface
   - Provide a user-friendly interface to view details of each paper.
   - Display information such as paper title, abstract, authors, and other relevant data.

4. Assigning reviewers
    - Assign at least 3 reviewers to a paper.
    - A button nearby shows whether it is reviewed or not.

5. Notification System
    - After assigning reviewers, notification is send to all the reviewers displaying all the information needed such as information  about updates, discussions, and important deadlines.
    - Implement a rating or scoring system if necessary.
    - Include fields for strengths, weaknesses, and suggestions for improvement.

6. Decision Making:
   - Make decisions on whether to accept, reject, or request revisions for each paper based on the reviews submitted.
