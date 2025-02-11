## Introduction

```
Hello, World!
```

## Assignment 1

### Reasons for using Object-Oriented Programming

There are multiple reasons for using OOP over functional programming,
most of which are related to making development easier.

OOP makes encapsulation easier by pairing data and code, allowing for strictly defined 
contracts and enforced relationships between different parts of the application.
By limiting the amount of interactions between different part of the code, 
testing and validation become easier as code can be less coupled and have more sanity checks in points where different systems interact.

Another reason for preferring OOP is the way it allows for modelling real life objects to code (this is also why OOP is often extensively used in games),
In relation to this project, that would be like giving Pokemon their own `Pokemon` class.


### What is a class vs object

Where classes are "templates" for data structures, containing data structure definitions and code, objects are the actual instances of these templates.
These objects contain the (non-static) data the class describes, this data can be read and written to by different scopes depending on the access modifiers of the relevant fields.

In many OOP languages (but not all), it is also possible to retrieve or check what class an object is an instance of at runtime.

For example, in kotlin this can be accomplished with:

```kotlin
val obj: Any = "Hello, World!"

// Get the kotlin class of 'obj' (KClass<out String>).
val clazz = obj::class

// Get the java class of 'obj' (String).
val javaClazz = obj::class.java

// Check the type of 'obj'.
if(obj !is String) println("obj is not a string!")
```