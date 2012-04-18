Example from "Getting Started with Apache Servicemix" webinar
========================================================

To run this example project build the project and deploy to ServiceMix  
according to the steps below. 

Setup
==============================

- Install Eclipse 3.6.2
    - Download distribution from http://www.eclipse.org. 
    - Unzip the downloaded Eclipse distribution to a location on your hard disk 
    that you find suitable.

- Install Apache Maven 3+
    - Download distribution from http://maven.apache.org. 
    - Unzip the downloaded Maven distribution to a location on your hard disk
    that you find suitable.
    - configure this location as the environment variable MAVEN_HOME
    - add MAVEN_HOME/bin to your PATH environment variable

- Install Fuse IDE for Camel
    - Follow the instructions at: 
      http://fusesource.com/docs/ide/2.0/install_guide/front.html

- Install Fuse ESB / ServiceMix 4.4.1-fuse-00-08
  - Download from http://fusesource.com/downloads/ and extract

Build & Run
==============================

1) Build this project so bundles are deployed into your local maven repo

<project home> $ mvn clean install

2) Start ServiceMix

<ServiceMix home> $ bin/servicemix

3) Add this projects features.xml config to ServiceMix from the ServiceMix
   Console (makes it easier to install bundles with all required dependencies)

karaf@root> features:addUrl mvn:org.fusesource.examples/rider-auto-common/4.0-SNAPSHOT/xml/features

4) Install the project.

karaf@root> features:install rider-auto-osgi

5) To test the file processing, there are existing files in the
   rider-auto-common module.

<project home> $ cp rider-auto-common/src/data/message1.xml <ServiceMix Home>/target/placeorder

   To see what happened look at the ServiceMix log file, either from the console

karaf@root> log:display

   or from the command line

<ServiceMix home> $ tail -f data/log/servicemix.log

6) To test the WS, use your favorite WS tool (e.g. SoapUI) against the following
   WSDL hosted by the rider-auto-ws bundle.
   * http://localhost:8182/cxf/order?wsdl

Getting Help
============================

If you hit any problems please let the FuseSource team know on the forums
  http://fusesource.com/forums/forum.jspa?forumID=2
