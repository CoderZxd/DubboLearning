# DubboLearning

| 标签 |	用途 |	解释 |
|--------|--------|--------|
|\<dubbo:service/\>|	服务配置 |	用于暴露一个服务，定义服务的元信息，一个服务可以用多个协议暴露，一个服务也可以注册到多个注册中心 |
|<dubbo:reference/>| 引用配置 |	用于创建一个远程服务代理，一个引用可以指向多个注册中心 |
|<dubbo:protocol/>|	协议配置 |	用于配置提供服务的协议信息，协议由提供方指定，消费方被动接受 |
|<dubbo:application/>|	应用配置 |	用于配置当前应用信息，不管该应用是提供者还是消费者 |
|<dubbo:module/>|	模块配置 |	用于配置当前模块信息，可选 |
|<dubbo:registry/>|	注册中心配置 |	用于配置连接注册中心相关信息 |
|<dubbo:monitor/>|	监控中心配置 |	用于配置连接监控中心相关信息，可选 |
|<dubbo:provider/>|	提供方配置 |	当 ProtocolConfig 和 ServiceConfig 某属性没有配置时，采用此缺省值，可选 |
|<dubbo:consumer/>|	消费方配置 |	当 ReferenceConfig 某属性没有配置时，采用此缺省值，可选 |
|<dubbo:method/>|	方法配置 |	用于 ServiceConfig 和 ReferenceConfig 指定方法级的配置信息 |
|<dubbo:argument/>|	参数配置 |	用于指定方法参数配置 |