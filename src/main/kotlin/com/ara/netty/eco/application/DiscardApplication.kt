package com.ara.netty.eco.application

import com.ara.netty.eco.discard.DiscardServerHandler
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import java.util.concurrent.FutureTask

class DiscardApplication(
        private val components: ApplicationComponents
) : Application {
    override fun listen(port: Int) = FutureTask {
        val (bossGroup, workerGroup) = components.eventGroups

        try {
            val serverBootstrap = ServerBootstrap().apply {
                group(bossGroup, workerGroup)
                channel(components.channelClass.java)
                childHandler(components.childHandler)
                components.options.forEach {
                    option(it.option, it.value)
                }
                childOption(ChannelOption.SO_KEEPALIVE, true)
            }

            val channelFuture = serverBootstrap.bind(port).sync()
            print("port:${port}")
            channelFuture.channel().closeFuture().sync()
        } finally {
            workerGroup.shutdownGracefully()
            bossGroup.shutdownGracefully()
        }
    }
}