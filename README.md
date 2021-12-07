# Rest API

https://en.wikipedia.org/wiki/Representational_state_transfer

Representational state transfer (REST) is a software architectural style that was created to guide the design and development of the architecture for the World Wide Web. REST defines a set of constraints for how the architecture of an Internet-scale distributed hypermedia system, such as the Web, should behave. 

Architectural concept defining style of web APIs.

An API, or application programming interface, is a set of rules that define how applications or devices can connect to and communicate with each other. (https://www.ibm.com/cloud/learn/rest-apis)

At the most basic level, an API is a mechanism that enables an application or service to access a resource within another application or service. The application or service doing the accessing is called the client, and the application or service containing the resource is called the server.

## Rest design principles (design principles)

https://www.ibm.com/cloud/learn/rest-apis
Some APIs, such as SOAP or XML-RPC, impose a strict framework on developers. But REST APIs can be developed using virtually any programming language and support a variety of data formats. The only requirement is that they align to the following six REST design principles - also known as architectural constraints:


1. **Uniform interface** The uniform interface constraint is fundamental to the design of any RESTful system.[1] It simplifies and decouples the architecture, which enables each part to evolve independently. The four constraints for this uniform interface are:
   * Resource identification in requests - Individual resources are identified in requests, for example using URIs in RESTful Web services. The resources themselves are conceptually separate from the representations that are returned to the client. For example, the server could send data from its database as HTML, XML or as JSON—none of which are the server's internal representation.
   * Resource manipulation through representations - When a client holds a representation of a resource, including any metadata attached, it has enough information to modify or delete the resource's state.
   * Self-descriptive messages - Each message includes enough information to describe how to process the message. For example, which parser to invoke can be specified by a media type.[1]
   * Hypermedia as the engine of application state (HATEOAS) - Having accessed an initial URI for the REST application—analogous to a human Web user accessing the home page of a website—a REST client should then be able to use server-provided links dynamically to discover all the available resources it needs. As access proceeds, the server responds with text that includes hyperlinks to other resources that are currently available. There is no need for the client to be hard-coded with information regarding the structure or dynamics of the application.
   * https://restfulapi.net/
2. **Client-server decoupling** In REST API design, client and server applications must be completely independent of each other. The only information the client application should know is the URI of the requested resource; it can't interact with the server application in any other ways. Similarly, a server application shouldn't modify the client application other than passing it to the requested data via HTTP.
3. **Statelessness** REST APIs are stateless, meaning that each request needs to include all the information necessary for processing it. In other words, REST APIs do not require any server-side sessions. Server applications aren’t allowed to store any data related to a client request.
4. **Cacheability** When possible, resources should be cacheable on the client or server side. Server responses also need to contain information about whether caching is allowed for the delivered resource. The goal is to improve performance on the client side, while increasing scalability on the server side.
5. **Layered system architecture** In REST APIs, the calls and responses go through different layers. As a rule of thumb, don’t assume that the client and server applications connect directly to each other. There may be a number of different intermediaries in the communication loop. REST APIs need to be designed so that neither the client nor the server can tell whether it communicates with the end application or an intermediary.
6. **Code on demand (optional)** REST APIs usually send static resources, but in certain cases, responses can also contain executable code (such as Java applets). In these cases, the code should only run on-demand.

## Best practices
https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/#h-name-collections-with-plural-nouns

* Accept and respond with JSON
* Use nouns instead of verbs in endpoint paths
* Name collections with plural nouns
* Nesting resources for hierarchical objects
* Handle errors gracefully and return standard error codes
* Allow filtering, sorting, and pagination
* Maintain Good Security Practices
* Cache data to improve performance
* Versioning APIs


## Swagger
Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON.
Swagger is used together with a set of open-source software tools to design, build, document, and use RESTful web services. 
Swagger includes automated documentation, code generation, and test-case generation.

## HTTP Requests in rest
https://restfulapi.net/http-methods/
### GET
Retrieve resource/resources.
Idempotent.

Examples:

HTTP GET http://www.appdomain.com/users

HTTP GET http://www.appdomain.com/users?size=20&page=5

HTTP GET http://www.appdomain.com/users/123

HTTP GET http://www.appdomain.com/users/123/address

### POST
Create new resource.

Not idempotent, invoking two identical POST requests will result in two different resources containing the same information (except resource ids).

Examples:

HTTP POST http://www.appdomain.com/users

HTTP POST http://www.appdomain.com/users/123/accounts

### PUT
Update an existing resource.

Idempotent.

The difference between the POST and PUT APIs can be observed in request URIs. POST requests are made on resource collections, whereas PUT requests are made on a single resource.

Examples:

HTTP PUT http://www.appdomain.com/users/123

HTTP PUT http://www.appdomain.com/users/123/accounts/456

### DELETE

Delete existing resource.

Some may argue that it makes the DELETE method non-idempotent. It’s a matter of discussion and personal opinion.

Examples:

HTTP DELETE http://www.appdomain.com/users/123

HTTP DELETE http://www.appdomain.com/users/123/accounts/456

### PATCH

To make a partial update on a resource.

https://stackoverflow.com/questions/41390997/why-patch-is-neither-safe-nor-idempotent

So why is PATCH not idempotent compared to PUT? It's because it matters how you apply your changes. If you'd like to change the name property of a resource, you might send something like {"name": "foo"} as a payload and that would indeed be idempotent since executing this request any number of times would yield the same result: The resources name attribute is now "foo".

But PATCH is much more general in how you can change a resource (check [this](https://www.rfc-editor.org/rfc/rfc6902) definition on how to apply a JSON patch). It could also, for example, mean to move the resource and would look something like this: { "op": "move", "from": "/a/b/c", "path": "/a/b/d" }. This operation is obviously not idempotent since calling at a second time would result in an error.

## Long-running requests

From
https://medium.com/geekculture/rest-api-best-practices-decouple-long-running-tasks-from-http-request-processing-9fab2921ace8

## Jax-RS vs Spring MVC
https://stackoverflow.com/questions/42944777/difference-between-jax-rs-and-spring-rest

### JAX-RS
JAX-RS is a specification for implementing REST web services in Java, currently defined by the JSR-370. It is part of the Java EE technologies, currently defined by the JSR 366.

Jersey (shipped with GlassFish and Payara) is the JAX-RS reference implementation, however there are other implementations such as RESTEasy (shipped with JBoss EAP and WildFly) and Apache CXF (shipped with TomEE and WebSphere).

### Spring Framework
The Spring Framework is a full framework that allows you to create Java enterprise applications. The REST capabilities are provided by the Spring MVC module (same module that provides model-view-controller capabilities). It is not a JAX-RS implementation and can be seen as a Spring alternative to the JAX-RS standard.

The Spring ecosystem also provides a wide range of projects for creating enterprise applications, covering persistence, security, integration with social networks, batch processing, etc.
