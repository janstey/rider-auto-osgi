Example from "Getting started with Fuse ESB Enterprise" webinar
========================================================

To run this example project build the project and deploy to Fuse ESB 
according to the steps below. 

Setup
==============================

- Install Apache Maven 3+
    - Download distribution from http://maven.apache.org. 
    - Unzip the downloaded Maven distribution to a location on your hard disk
    that you find suitable.
    - configure this location as the environment variable MAVEN_HOME
    - add MAVEN_HOME/bin to your PATH environment variable

- Install Fuse IDE 7.1.60
    - Download from http://www.redhat.com/fusesource/downloads

- Install Fuse ESB Enterprise 7.1.0.fuse-047
  - Download from http://www.redhat.com/fusesource/downloads

Build & Run
==============================

1) Build this project so bundles are deployed into your local maven repo

<project home> $ mvn clean install

2) Start Fuse ESB

<ESB home> $ bin/fuseesb

3) Set up the containers used in this project by sourcing the install script:

FuseESB:karaf@root> shell:source mvn:org.fusesource.examples/rider-auto-common/4.0-SNAPSHOT/karaf/installer

Alternatively you can open up the file and execute each command yourself.

4) To test the file processing, there are existing files in the
   rider-auto-common module.

<project home> $ cp rider-auto-common/src/data/message1.xml <ESB Home>/instances/rider-auto-frontend/target/incomingOrders/
<project home> $ cp rider-auto-common/src/data/message2.csv <ESB Home>/instances/rider-auto-frontend/target/incomingOrders/

   To see what happened look at the ESB log file, either from the console

FuseESB:karaf@root> container-connect rider-auto-backend log:display

   or from the command line

<ESB home> $ tail -f instances/rider-auto-backend/data/log/fuseesb.log

5) To test the WS, use your favorite WS tool (e.g. SoapUI) against the following
   WSDL hosted by the rider-auto-frontend container.
   * http://localhost:9191/cxf/order?wsdl

Getting Help
============================

If you hit any problems please let the FuseSource team know on the forums
  http://fusesource.com/forums/forum.jspa?forumID=15
