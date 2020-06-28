#   Introduce

​	Eshop is an online saling mall system, a microservice based distributed one deployed on kubernetes cluster installed by RKE managed by rancher. 

​	As to business is concerted, Eshop can be brokendown into four microservices: admin, security, ums(user management microservice), pms(product management microservice), sms(sale management microservice), and oms(order management microservice).

​	As to techniques are concerted, Eshop is composed of the frontline and backend independently, the frontline is developed by Vue build by node.js using ElementUI runing in Nginx, while the backend is splited into mutiple mircroservices which are developed by Springboot communicated by Dubbo rpc.

# Pre-requisite

1. CentOS 7
2. Kubernetes v1.17.6
3. RKE v1.1.2
4. Rancher v2.4.4

## Architecture

## Technologies

| Techniques        | Description                        | Official sites                                               |
| ----------------- | ---------------------------------- | ------------------------------------------------------------ |
| Vue               | Frontline Framework                | [https://vuejs.org/](https://vuejs.org/)                     |
| Vue-router        | Router Framework                   | [https://router.vuejs.org/](https://router.vuejs.org/)       |
| Vuex              | Global states management Framework | [https://vuex.vuejs.org/](https://vuex.vuejs.org/)           |
| Element           | UI Framework                       | [https://element.eleme.io/](https://element.eleme.io/)       |
| Axios             | Frontline Http Framework           | [https://github.com/axios/axios](https://github.com/axios/axios) |
| v-charts          | Graphics Framework ased on Echarts | [https://v-charts.js.org/](https://v-charts.js.org/)         |
| Js-cookie         | Cookie Management Tool             | [https://github.com/js-cookie/js-cookie](https://github.com/js-cookie/js-cookie) |
| nprogress         | Progress Control Component         | [https://github.com/rstacruz/nprogress](https://github.com/rstacruz/nprogress) |
| vue-element-admin | Project Skeleton Reference         | [https://github.com/PanJiaChen/vue-element-admin](https://github.com/PanJiaChen/vue-element-admin) |

## Project Layout

```lua
src -- source codes
├── api -- axios network request definition
├── assets -- static image files
├── components -- common components
├── icons -- svg vector image files
├── router -- vue-router setting 
├── store -- vuex states management
├── styles -- global css styles
├── utils -- tool libaries
└── views -- flontline views
    ├── home -- home
    ├── layout -- common views loaded framework 
    ├── login -- login view
    ├── oms -- order module views
    ├── pms -- product module views
    └── sms -- sale module views
```

## Install

- Download and install node: [https://nodejs.org/dist/v12.14.0/node-v12.14.0-x64.msi](https://nodejs.org/dist/v12.14.0/node-v12.14.0-x64.msi);
- Install local backend environment for this frontline-backend project;
- Set BASE_API=http://localhost:8080 in the setting file of config/dev.env.js ;
- Create a project by IDEA and import source mall-frontline into the project and compile this project;
- Execute this command: "npm install" in IDEA terminal and then download the related node dependencies;
- Execute command  "npm run dev" in IDEA terminal;
- Address http://localhost:8090 to access backend management system;
- `Caution`：if npm command could not be run,please append C:\Users\\[your loging username]\AppData\Roaming\npm to the system variable - path;

## Backend

1. Security: JWT, Spring Security Oauth 2.0
2. ApplicationServer: Tomcat 9.x
3. Application Framework: SpringBoot 2.x
4. RPC Framework: Dubbo  2.x
5. Cache Server: Redis cluster, 3 groups of master-slave clusters
6. Database: Mycat clusters with 2 groups of mater-slave clusters
7. Log Analysis: Filebeate + Elasticsearch + kibana cluster
8. Monitor: Promethues + Granfana

1. CI/CD
   1. Jenkins
   2. Helm
   3. Harbor

# Usage

mall采用现阶主流技术实现，涵盖了一般项目中几乎所有使用的技术。

| 技术             | 版本    | 说明                |
| ---------------- | ------- | ------------------- |
| Spring Boot      | 2.1.3   | 容器+MVC框架        |
| Spring Security  | 5.1.4   | 认证和授权框架      |
| MyBatis          | 3.4.6   | ORM框架             |
| MyBatisGenerator | 1.3.3   | 数据层代码生成      |
| PageHelper       | 5.1.8   | MyBatis物理分页插件 |
| Swagger-UI       | 2.7.0   | 文档生产工具        |
| Elasticsearch    | 6.2.2   | 搜索引擎            |
| RabbitMq         | 3.7.14  | 消息队列            |
| Redis            | 3.2     | 分布式缓存          |
| MongoDb          | 3.2     | NoSql数据库         |
| Docker           | 18.09.0 | 应用容器引擎        |
| Druid            | 1.1.10  | 数据库连接池        |
| OSS              | 2.5.0   | 对象存储            |
| JWT              | 0.9.0   | JWT登录支持         |
| Lombok           | 1.18.6  | 简化对象封装工具    |







