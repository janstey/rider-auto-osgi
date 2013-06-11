NOTE: If you need the example from the "Getting Started with Apache Servicemix" 
webinar, please use the code from the rider-auto-osgi-smx-4.4.1-fuse-00-08 tag instead.

Example from "Enterprise Integration with Apache Camel and ServiceMix" talk
========================================================

To run this example project build the project and deploy to Apache ServiceMix according to the steps below. 

Setup
==============================

- Install Fuse IDE 7.2
    - Download and unpack distribution from http://fusesource.com/products/fuse-ide/ 

- Install Apache Maven 3+
    - Download distribution from http://maven.apache.org. 
    - Unzip the downloaded Maven distribution to a location on your hard disk
    that you find suitable.
    - configure this location as the environment variable MAVEN_HOME
    - add MAVEN_HOME/bin to your PATH environment variable

- Install Apache ServiceMix 4.5.1
  - Download from http://servicemix.apache.org and install

Build & Run
==============================

1) Build this project so bundles are deployed into your local maven repo

<project home> $ mvn clean install

2) Start ServiceMix

<ESB home> $ bin/servicemix

3) Add this project's features.xml config to ServiceMix from the 
   console (makes it easier to install bundles with all required dependencies)

karaf@root> features:addUrl mvn:org.fusesource.examples/rider-auto-common/5.0-SNAPSHOT/xml/features

4) Install the project.

karaf@root> features:install rider-auto-osgi

5) To test the file processing, there are existing files in the
   rider-auto-common module.

<project home> $ cp rider-auto-common/src/data/message1.xml <ESB Home>/target/placeorder

   To see what happened look at the ESB log file, either from the console

FuseESB:karaf@root> log:display

   or from the command line

<ESB home> $ tail -f data/log/servicemix.log

6) To test the WS, use your favorite WS tool (e.g. SoapUI) against the following
   WSDL hosted by the rider-auto-ws bundle.
   * http://localhost:8182/cxf/order?wsdl

