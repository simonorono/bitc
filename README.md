# Module bitc

[![](https://jitpack.io/v/simonorono/bitc.svg)](https://jitpack.io/#simonorono/bitc)

**bitc** is a collection of containers for bits (boolean values).

The library consists in two classes: `BitArray` and `BitMatrix`. More about
them can be found in [the docs](https://bitc.mcbodev.com).

### Installation

#### 1. Use the Jitpack Maven repository

Maven:
    
```xml
<repositories>
   <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
   </repository>
</repositories>
```
    
 Gradle (Kotlin):
 
 ```kotlin
 repositories {
     maven {
         url = uri("https://jitpack.io")
     }
 }
 ```

#### 2. Add the dependency

 Maven:
 
 ```xml
 <dependency>
     <groupId>com.github.simonorono</groupId>
     <artifactId>bitc</artifactId>
     <version>1.2.0</version>
 </dependency>
 ```
 
 Gradle (Kotlin):
 
 ```kotlin
 dependencies {
     implementation("com.github.simonorono:bitc:1.2.0")
 }
 ```