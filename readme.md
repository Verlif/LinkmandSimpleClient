# LinkmandClient

[LinkmandServer](https://github.com/Verlif/LinkmandServer) 对应的一个简单命令行客户端。

## 使用

1. 下载`Release`下的jar包
2. 通过java指令运行
    ```shell
   java -jar LinkmandCmdClient.jar
    ```
   
## 配置

在初次启动时，会在同级目录下生成`config.json`配置文件。

```json
{
  "ip" : "127.0.0.1",
  "port" : 16508,
  "name" : "Verlif"
}
```

| 配置参数名 | 参数类型 | 参数作用    |
|:-----:|:----:|:--------|
|  ip   | 字符串  | 服务端IP   |
| port  |  数字  | 服务端对应端口 |
| name  | 字符串  | 客户端名称   |