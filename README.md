# DesignPatternsExample
Applying design patterns in the case of simple ERP console applications written in Java.

# Specification
"ConsoleERP" application is used for creating and processing offers and invoices in pdf format.
Application is also used for managing products and services that are used for creating offers and invoices.

# Arhitecture
There are four main parts of the application:
1.Database: used for storing documents, products and services. Singleton pattern is applied in this section.
2.Model: implements classes that represent documents, products and services, and classes
responsible for their creation. In this section 5 paterns are applied: Composite, Builder, Adapter,
Template method and Decorator patern.
3.Util: implements classes responsible for managing document status, tax, pdf generation... This section implements State and Observer patern.
4.Client(package main): represents front end part of the application implemented console way. 

# Important note
This application is created with purpose of learning software design patterns and is not suitable for real world business case consumption.