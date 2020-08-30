# **模块管理：**

    lsr-cloud-admin         项目监控中心
    lsr-cloud-bom           依赖版本控制
    lsr-cloud-common        公共模块
    lsr-cloud-gateway       网关路由
    lsr-cloud-consumer      消费者模块
    lsr-cloud-provider01    服务提供者01
    lsr-cloud-provider02    服务提供者02
### **新建idea自带的HttpClient文件**
### 新增一个账户:

    POST http://localhost:8001/account/add
    Content-Type: application/json
    
    {
      "id": "5",
      "name": "lishirui",
      "password": "123123123",
      "balance": "1000.0",
      "createtime": "2020-07-20 03:45:18"
    }
### 分页按排序查询账户数据:
    
    GET http://localhost:8001/account/getAll/pageNum/2/pageSize/2/orderBy/id,desc


### 通过负载LoadBalanced访问:

    GET http://localhost:9001/consumer/getById/id/1

### 获取注册中心服务列表:
    
    GET http://localhost:9001/consumer/getServer

### 网关路由：

    GET http://localhost:7001/pro/account/getAll/pageNum/2/pageSize/2/orderBy/id,desc
    #网管路由到节点，节点本身也是可以使用负载的
    GET http://localhost:7001/sm/consumer/getById/id/1
    
### 监控中心：
    
    账号：admin
    密码：lishirui