#   Introduce

​	Eshop is an online saling mall system, a microservice based distributed one deployed on kubernetes cluster installed by RKE managed by rancher. 

​	As to business is concerted, Eshop can be brokendown into four subsystems: admin,security,ums(user management subsystem),pms(product management subsystem),sms(sale management subsystem),and oms(order management subsystem).

​	As to techniques are concerted, Eshop is composed of the frontline and backend independently, the frontline is developed by Vue build by node.js using ElementUI runing in Nginx, while the backend is splited into mutiple mircroservices which are developed by Springboot communicated by Dubbo rpc.

# Pre-requisite

1. CentOS 7
2. Kubernetes v1.17.6
3. RKE v1.1.2
4. Rancher v2.4.4

# Archieture

1. Frontline: 
   1. UI: ElementUI
   2. Javasscripts: Vue+Node.js
2. Backend: 
   1. Security: JWT, Spring Security Oauth 2.0
   2. ApplicationServer: Tomcat 9.x
   3. Application Framework: SpringBoot 2.x
   4. RPC Framework: Dubbo  2.x
   5. Cache Server: Redis cluster, 3 groups of master-slave clusters
   6. Database: Mycat clusters with 2 groups of mater-slave clusters
   7. Log Analysis: Filebeate + Elasticsearch + kibana cluster
   8. Monitor: Promethues + Granfana
3. CI/CD
   1. Jenkins
   2. Helm
   3. Harbor

# Usage

