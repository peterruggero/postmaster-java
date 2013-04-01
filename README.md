# Postmaster

Developer Friendly Shipping

Postmaster takes the pain out of sending shipments via UPS, Fedex, and USPS.

Save money before you ship, while you ship, and after you ship.

https://www.postmaster.io/

## Requirements

- [gson](http://code.google.com/p/google-gson/) 2.2.2
- [httpclient](http://hc.apache.org/) 4.2.1
- [commons-lang](http://commons.apache.org/lang/) 3.1
- [commons-codec](http://commons.apache.org/codec/) 1.7
    
## Issues

Please use appropriately tagged github [issues](https://github.com/postmaster/postmaster-api/issues) to request features or report bugs.

## Installation


### Maven

Add this dependency to your `pom.xml`:

    <dependency>
	    <groupId>io.postmaster</groupId>
	    <artifactId>postmaster</artifactId>
	    <version>0.1</version>
    </dependency>
	

Or export to a jar file and include it in your project.
	
### Source

Download the postmaster-java source:

    $ git clone https://github.com/postmaster/postmaster-java

## Quickstart

    TODO - sample project
 
## Usage

See https://www.postmaster.io/docs for tutorials and documentation.


## Testing
    
    You can test particular jUnit test from your IDE or performing Maven test:
	
	$ mvn test
	
## Publishing

[Sonatype OSS repository](https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide).

### Snapshot

    $ mvn clean deploy

### Stage Release

    $ mvn release:clean
    $ mvn release:prepare
    $ mvn release:perform
