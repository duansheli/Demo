test1
--ssl配置方式
--客户端服务端 等待关闭消息通过同步方式，实现主线程阻塞，保证主线程不会退出
--客户端通过监听器循环发送消息
--服务器端的处理链channelRead方法中通过ctx.fireChannelRead传递到下一个处理链
--两种ChannelHandler
----处理输入数据的StringDecoder为 ChannelInboundHandlerAdapter 
----处理输出数据的StringEncoder为 ChannelOutboundHandlerAdapter

test2
--客户端收到消息后会向服务端发送消息
--处理链内不同方法的触发顺序
--服务端3个处理链之间的执行顺序
--不同的处理链中对应的ctx对象不同

SimpleChannelInboundHandler有何不同
新建该对象时，需声明泛型，如果为ReferenceCounted的子类比如ByteBuf.当数据在handle中处理之后
会自动调用ByteBuf.release方法释放消息内的数据，
不过new SimpleChannelInboundHandler(false)则可以取消自动release


test3
--发送对象接收对象(解决粘包)
--自定义的Decoder中如何解决了粘包问题，以及ByteBuf的使用

+-----------------------------------+
| ！！！ 粘包拆包问题复现                      |
|                                   |
| c1发送消息给 s1 消息为【女人如果没有了男人就恐慌了】     |
| s1会出现三种处理方案                       |
| 1. print[女人如果没有了男人就恐慌了]           |
| 2. print[女人如果没有了] print[男人就恐慌了]   |
| 3. print[女人如果没有了男人] print[就恐慌了]   |
|                                   |
|                                   +----------------------------+
| 通常三个解决方案                                                       |
| 1.消息定长，例如每个报文的大小为固定长度200字节，如果不够，空位补空格。                         |
| 2.在包尾增加回车换行符进行分割，例如FTP协议。                                      |
| 3.将消息分为消息头和消息体，消息头中包含消息长度的字段，通常设计思路为消息头的第一个字段使用int32来表示消息的总长度  |
|                                                                |
| 对应的                                                            |
| 1. 此处每次发送的消息长度为10                                              |
| send[女人如果没有了000] send[男人就恐慌了0000]                              |
| 2. 以换行分割消息                                                     |
| send[女人如果没有了\r\n男人就恐慌了]                                        |
| 3. 以消息头和消息体方式                                                  |
| send[07]send[女人如果没有了]                                          |
| send[06]send[男人就恐慌了]                                           |
|                                                                |
+----------------------------------------------------------------+

test4
--对接口生成动态代理
--消费者调用代理时，将调用信息通过网络发送到服务方，同时等待返回消息
--服务方读取调用信息后, 执行对应的方法 然后将运行结果通过网络返回
--消费者读取消息运行结束

test5
--修改了test4 所有请求只使用一个客户端进行消息的发送

test6
--服务端: 在3秒内没有写或读的操作时，触发超时， 若连续2次关闭该连接
--客户端: 每隔4s发送一次消息到服务端 ，当失去连接时进行重连

心跳监测
IdleStateHandler
以ChannelInboundHandlerAdapter举例
当服务器读取数据时，会触发read方法，进行处理逻辑，
之后read调用会调用ctx.fireChannelRead(msg)方法，然后就进入了下一个ChannelInboundHandlerAdapter

IdleStateHandler 通过一个任务线程进行检查超时时间
同理当 IdleStateHandler 计数比如超过5秒服务器还没有写操作时，
则触发channelIdle方法触发ctx.fireUserEventTriggered(evt) 
然后传递到一个ChannelInboundHandler中的userEventTriggered

用户需要在自定义的ChannelInboundHandlerAdapter重写userEventTriggered进行逻辑处理


