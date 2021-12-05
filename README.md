### 开发中...

TODO:

- [x] 将每个线程的日志分开输出,便于在同时进行多个构建任务时,查看对应日志
   - ~~目前想到可以使用org.slf4j.Maker以构建历史ID作为Maker进行标记,在cn.arros.server.log.LogForward中通过Maker判读日志到底要发到哪儿~~
   - ~~仅仅只是靠名字猜想,并未查看Maker的真实功能~~
   - 使用MDC实现
- [x] 项目部署成功后，向server发送心跳，接收到心跳后将该服务展示在前端
- [ ] 将每次构建产生的日志存储为文件放在arros/build下
