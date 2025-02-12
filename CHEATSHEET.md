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

## Assignment 2

### What is composition, and why do we use it?

Composition is a relationship between objects where one object is "composed" of multiple other objects.
This is used to model situations where one thing contains another, 
such as a house containing multiple rooms, and those rooms containing different furniture.

Composition is different from inheritance, having an object "contain" something instead of "being" something, 
this way complex relationships between objects can be defined.


### How to use composition

Composition can be used by adding fields to a class, in kotlin this is done like this:

```kotlin
class Person(val name: String, val age: Number)
```

In this case, the `Person` class is composed of two fields, a name (`String`) and an age (`Number`).

It is also possible to have more complex relationships this way, such as a person having multiple pets, and those pets having multiple owners:

```kotlin
class Pet(val name: String, val owner: ArrayList<Person>)
class Person(val name: String, val age: Number, val pets: ArrayList<Pet>)
```

## Assignment 3

Inheritance is the concept of a class "inheriting" fields and methods from another class. This way a class can be defined as "being" something else.

Another reason to use inheritance is to share behaviours across multiple classes, while still having differences in the implementation of some of the functions.

A common example of this, is how both a `Cat` and a `Dog` are an `Animal`, and share certain behaviours, in kotlin this could be:

```kotlin
abstract class Animal {
    fun eat() {
        makeSound()
        println("Eating...")
    }
    abstract fun makeSound()
}
class Cat {
    override fun makeSound() {
        println("Meow!")
    }
}
class Dog {
    override fun makeSound() {
        println("Woof!")
    }
}
```

In kotlin, it is also possible to inherit properties, and declare them as abstract for implementation by a subclass.

```kotlin
abstract class Pokemon {
    abstract val strength: Element
}
class Charmander : Pokemon() {
    override val strength: Element
        get() = Element.FIRE
}
```