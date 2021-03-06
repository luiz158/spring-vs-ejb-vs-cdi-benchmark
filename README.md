## The simple JMH-based benchmark of the Spring MVC vs EJB vs CDI RESTful web-service implementations

A very popular delusion in the Java world is **Spring Framework** provides better performance than good old **Enterprise Java Beans**. The
best approach to compare technologies is just to get a benchmark. This repository contains three implementations of the same simple
RESTful web-service based on **Spring MVC**, **EJB** and **CDI**, respectively. The service design is the following: resource providers are injected 
into a "service" class and the "service" is injected into a controller. This is the usual design of an enterprise application: data-access 
objects are injected into services and the services are injected into facades or controllers. Different technologies are used for *Dependency Injection* 
as well as *RESTfulization*.
 

The service just returns a string built by some letters and current time concatination:

![Services return the following result](http://3.bp.blogspot.com/-5NXBEd4m07g/VnxUv0OGZgI/AAAAAAAADsU/_RQ_tKKbPT4/s1600/service-result.png)

**[JMH](http://openjdk.java.net/projects/code-tools/jmh/ "OpenJDK JMH Tool")** is a Java harness for building, running, and analysing 
nano/micro/milli/macro benchmarks written in Java and other languages targetting the JVM.

The benchmark code contained by the [file](rest-benchmark/src/main/java/psamolysov/demo/restws/benchmark/RestImplementationsBenchmark.java).

### Benchmark running

```
# java -jar rest-benchmark/target/rest-benchmarks.jar ".*Benchmark" -f 4 -wi 20 -i 20 -t 4 -si true -gc true
```

Where:

- `-f [int]` - How many times to forks a single benchmark.
- `-wi <int>` - Number of warmup iterations to do.
- `-i <int>` - Number of measurement iterations to do.
- `-si [bool]` - Synchronize iterations?
- `-t <int>` - Number of worker threads to run with.
- `-gc [bool]` - Should JMH force GC between iterations?


Allowed parameters:

- `server` - application server's host, `localhost` is default value.
- `port` - application server's port.
- `path` - path for the resource. Every path is relative to the `/api/` catalog.
- `implementation` - technology used for the RESTful service implementation. The passed values are just substituted
   in the `rest-ws-{implementation}` template for web-applications context-roots.

Example:

```
# java -jar rest-benchmark/target/rest-benchmarks.jar ".*Benchmark" -f 4 -wi 20 -i 20 -t 4 -si true -gc true
-p port=14633 -p implementation=ejb,cdi
```

### Results

#### WebSphere Application Server 8.5.5.4 for z/OS

<table cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="center" width="297"><img alt="Mainframe logo" src="http://4.bp.blogspot.com/-8WUs5saIO-I/VnxFsBBW_uI/AAAAAAAADrw/-E7etF9nE2I/s1600/zBC12-small.jpg"/></td>
      <td valign="top">IBM Mainframe <a href="http://www-03.ibm.com/systems/z/hardware/zenterprise/zbc12.html" title="IBM zEnterprise Business Class 12">
            zBC 12</a>: 2 General CP + 1 zIIP, 32 GB RAM, z/OS 2.1, IBM J9 VM R26 SR7 based on Oracle 7u55-b13</td>
    </tr>
  </tbody>
</table>

Operations per second, the picture is clickable:

![Mainframe results][zBC results]

[zBC 12]: http://www-03.ibm.com/systems/z/hardware/zenterprise/zbc12.html "IBM zEnterprise Business Class 12"
[zBC logo]: http://4.bp.blogspot.com/-8WUs5saIO-I/VnxFsBBW_uI/AAAAAAAADrw/-E7etF9nE2I/s1600/zBC12-small.jpg
[zBC results]: http://2.bp.blogspot.com/-ryRzfMVDKmo/VnxoeXOg1NI/AAAAAAAADtA/RegeKkyIa0E/s1600/zBC12-result-t-4.png

#### WebSphere Application Server 8.5.5.8 Network Deployment

<table cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="center"><img alt="Lenovo logo" src="http://2.bp.blogspot.com/-7-XGK0t7LhM/VnxFsFMk7LI/AAAAAAAADrs/2f6vegROCYA/s1600/Lenovo-small.jpg"/></td>
      <td valign="top">Lenovo ThinkPad T440: 2 Intel i5-4300U @ 1.90 GHz, 8 GB RAM, Windows 7 x64, IBM J9 VM R27 SR3 based 
        on Oracle 7u85-b15</td>
    </tr>
  </tbody>
</table>

Operations per second, the picture is clickable:

![Lenovo results][Lenovo results]

[Lenovo logo]: http://2.bp.blogspot.com/-7-XGK0t7LhM/VnxFsFMk7LI/AAAAAAAADrs/2f6vegROCYA/s1600/Lenovo-small.jpg
[Lenovo results]: http://1.bp.blogspot.com/-4BGmfKNkp0Y/VnxaqTERt1I/AAAAAAAADso/QnmLXysuIPw/s1600/Lenovo-result-t-4.png

Which result have you gone? Please, share it with me: <samolisov@gmail.com>
