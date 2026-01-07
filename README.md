# Inject'em all Kata

The purpose of this exercise is to dispel the magic of DI frameworks and grow understanding of Dependency Injection (DI) as a concept.

## Important note: Please, do not use it as a good design example! The application is extremely over-engineered to demonstrate DI concepts!

### Why does it matter?
Interfaces used as Seams between components allow us to implement Inversion of Control.
IoC, in turn, enables control over the direction of dependencies between components of different importance and abstraction level.
But since we are using interface dependencies, we need a way to provide an interface implementer to the components.
That is where DI helps us! DI is a set of principles and patterns that allow us to resolve the dependency graph by instantiating appropriate interface implementers and managing their lifecycle.

If you are still here, here is your **task**: construct the applications from the components. Sounds easy, doesn't it?

## Description
The "injectemall" package contains an application for creating product orders for customers. 
The "order.core.scenarios" package contains two use cases representing the functionality of the application: 
creating orders for trusted customers and suspicious customers, 
for whom additional checks must be performed. 
The entry points (APIs) are "order.cli.OrderCli" and "order.rest.OrderRest", implementing the "Application" interface.

_Note:
Static instance counters and the "Application.test()" method are necessary solely for testing purposes._

The application is fully written, and to run it, it is only necessary to build the components. 
**Modifications are required only for the "order.ui.cli.OrderCli" and "order.ui.rest.OrderRest" classes, 
which participate in managing the components' lifecycle. 
No other components in the "injectemall" package can be changed or extended!**

Assume that the applications will be migrated to another DI library soon, 
so we don't want to couple it with a specific library.

#### Dev artifacts:
- Use create-order-request.http as HTTP request example
- Use tarkovsky-order.json as CLI payload in the command 'trusted tarkovsky-order.json'

### Section 1: Pure DI (without frameworks or IoC containers)
**Again, you are not allowed to change application code (except Application instances) to implement DI!**

Implement common.ApplicationFactory interface to follow the rules below. Run tests to check correctness.
1. Construct dependency graph for OrderRest Application. Dependency scopes are:
- singleton: WriteOrderDatabase, MessageBroker, ProductCatalog, PretentiousFilmmakersList, OrderRest
- transient (new instance each time requested): OrderIdGenerator
- eagerly initialized pool of n instances: ReadOrderDatabase (parameterize with 5 instances)
- per request: OrderRepository, usecases and endpoints

2. Do the same for OrderCli. Run both REST and CLI applications in the same JVM runtime. Modify scopes:
- per graph singletons: MessageBroker, ProductCatalog, PretentiousFilmmakersList, REST and ClI interfaces
- global (shared between both applications) eagerly initialized pool of n instances: ReadOrderDatabase (parameterize with 5 instances)
- global (shared between both applications) singleton: WriteOrderDatabase

### Section 2: DI with Spring
3. Let's learn how to make a framework a detail, loosely coupled with the application classes. Use Spring DI and IoC functionality to implement the same scope configuration.
- Using BeanFactory API
- Using ApplicationContext

### Section 3: Improve Application
4. Despite your great work, the app is still far from perfect (maybe not even working properly?). 
Perform an analysis and suggest possible improvements. Tips below.
<details>
What do you think about error handling strategy? Test suite? Architecture?
</details>

5. You can now fix any classes from injectemall to improve it.
