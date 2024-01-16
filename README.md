# Program Committee: NITCCONF

## 1. Introduction

### 1.1 Purpose

The purpose of this document is to outline the functional and non-functional requirements for the development of a paper conferencing website. The system is designed to facilitate the submission, review, and decision-making process for academic papers.

### 1.2 Scope

This system will provide a secure and user-friendly platform for program committee members to manage the paper submission and review process. Key features include user authentication, a dashboard for committee members, paper review interface, reviewer assignment, notification system, and decision-making capabilities.

## 2. System Overview

### 2.1 System Description

The paper conferencing website is designed to streamline the conference paper submission and review process. It includes modules for user authentication, dashboard creation, paper review, reviewer assignment, notification system, and decision-making.

### 2.2 Key Features

#### 1. User Authentication and Authorization

- Secure username/password authentication for program committee members.
- Role-based access control to restrict unauthorized access to the review interface.
- Display "invalid" error message on failed login attempts.

#### 2. Dashboard

- Upon login, program committee members will have access to a dashboard.
- Display a summary of submitted papers, including titles, authors, and statuses (e.g., pending, reviewed).

#### 3. Paper Review Interface

- User-friendly interface displaying details of each paper.
- Show paper title, abstract, authors, and relevant data.

#### 4. Assigning Reviewers

- Ability to assign at least 3 reviewers to a paper.
- Display a button indicating whether the paper has been reviewed or not.

#### 5. Notification System

- Send notifications to assigned reviewers with updates, discussions, and important deadlines.
- Implement a rating system.
- Include fields for strengths, weaknesses, and suggestions for improvement.

#### 6. Decision Making:

- Allow program committee members to make decisions on papers (accept, reject, or request revisions) based on reviews submitted.

## 3. Functional Requirements

### 3.1 User Authentication and Authorization

#### 1. Secure Authentication

- Use a secure authentication mechanism for program committee members.
- Implement username/password authentication.
- Enable Social Network Authentication.

#### 2. Role-Based Access Control

- Differentiate roles (e.g., admin, reviewer) and grant appropriate access.
- Restrict access to unauthorized members.

#### 3. Login Error Handling

- Display "invalid" error message on failed login attempts.

---
|![Alt text](SELab_flowchart.png)|
|:--:| 
| *Figure 1: User Authentication Process Flowchart* |
---

### 3.2 Dashboard

#### 1. Dashboard Display

- Display a dashboard upon login.
- Include a summary of submitted papers with titles, authors, and statuses.

### 3.3 Paper Review Interface

#### 1. Paper Details

- Provide a user-friendly interface to view details of each paper.
- Display paper title, abstract, authors, and relevant data.

### 3.4 Assigning Reviewers

#### 1. Reviewer Assignment

- Allow the assignment of at least 3 reviewers to a paper.
- Display a button indicating the review status of the paper.

### 3.5 Notification System

#### 1. Reviewer Notifications

- Send notifications to assigned reviewers with updates, discussions, and deadlines.
- Include fields for strengths, weaknesses, and suggestions.

### 3.6 Decision Making

#### 1. Decision Options

- Provide options for program committee members to accept, reject, or request revisions for each paper.
- Base decisions on the reviews submitted.

## 4. Non-functional Requirements

### 4.1 Security

#### 1. Secure Transmission

- Use secure protocols for data transmission.
- Encrypt sensitive user data.

### 4.2 Performance

#### 1. Responsiveness

- Ensure the system is responsive and provides a seamless user experience.

### 4.3 Usability

#### 1. User-Friendly Interface

- Design an intuitive and user-friendly interface for program committee members.

### 4.4 Reliability

#### 1. System Availability

- Ensure high system availability to accommodate users at different times.

## 5. Conclusion
This Software Requirements Specification provides a comprehensive outline of the functional and non-functional requirements for the development of the paper conferencing website. These requirements serve as a foundation for the design, development, and testing phases of the project.
