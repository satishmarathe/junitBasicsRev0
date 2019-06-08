# sample with Junit5 and Mockito
Sample application with basics about .

# Example 1
This is an example of mocking a stand alone method 
Take a look at 'MyControllerTest' which is a Junit5 example.
This is an example of how we can test a standalone method / class.
So this sets the groundwork on how to do a simple Junit !

# Example 2
This is an example of mocking Dependant class using Mockito 
Take a look at MyOrderServiceImplTest
This is slightly more involved where we have a service class calling a DAO.
The DAO does the database interaction.

This is a typical scenario in layered web applications :
web >> service >> dao 

So here the Junit sample is exhibiting two important aspects:
1 shows how the DAP implementation is mocked.
  keep note of the fact that we are testing the service class method
  which is why we have to mock the dao behavior
  This is a very critical aspect which when understood will be useful !
  
2 shows how we can use Mockito to Mock

---------------------------------------------------------------------------------------------
# Questions 

#1 How does spring boot start - can you call the rest service ?
a

---------------------------------------------------------------------------------------------
# TODOS
#1 To introduce Logging 

#2 To introduce Code coverage 

#3 Remove 'new' operator using Spring 
a

---------------------------------------------------------------------------------------------
# LEARNINGS

#1 assertThrows 
We learnt how to simulate an exception and to test with this annotation 

#2 Functional Interface : Executable
We learnt that this needs to be provided as a second parameter in the assertion 'assertThrows'




 
