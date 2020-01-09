
AXS-TAP Deployment
===================

This is a collection of kubernetes yaml files to deploy a TAP service based on
AXS. Eventually this will be helm charts or something more managable. 

Some general description:

thrift-deployment is a spark image that calls `start-thriftserver.sh`. This
spark instance talks to kubernetes to create executor pods. It exposes
thrift-service:10000 for JDBC clients to talk to it, e.g. beeline or the TAP
service. thrift-driver-svc is a headless service for the executor pods to find
the spark driver. The driver pod needs to have a RoleBinding that allows it to
create the executor pods.

tap-deployment uses an image from
https://github.com/dirac-institute/axs-tap-service, which is a lightly modified
version of the CADC TAP server, adding hive-jdbc drivers. This exposes
http://tap-service:8080, which serves as the TAP endpoint (e.g.
http://tap-service:8080/tap/capabilities or http://tap-service:8080/tap/tables)

