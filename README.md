# DesignPatternsExample
Applying design patterns in the case of a simple ERP console application written in Java.

# Specification
"ConsoleERP" application is used for creating, processing and PDF exporting offers and invoices.
Application is also used for managing products and services that are used for creating offers and invoices.

# Arhitecture
There are four main parts of the application:<br>
1. Database: used for storing documents, products and services. <b>Singleton pattern</b> is applied in this section.<br>
2. Model: implements classes that represent documents, products and services, and classes
responsible for their creation. In this section 5 paterns are applied: <b>Composite, Builder, Adapter,
Template method and Decorator patern</b>.<br>
3. Util: implements classes responsible for managing document status, tax, pdf generation... This section implements <b>State and Observer patern</b>.<br>
4. Client(package main): represents front end part of the application implemented console way. 

# Important note
This application is created with purpose of learning software design patterns and is not suitable for real world business case consumption.

# Documentation
In-depth documentation is placed in the root of the respository: documentation.pdf. Documentation is written is Serbian language, because
it was created as a part of a student project at the Faculty of Organizational Sciences.