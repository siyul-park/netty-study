package com.ara.netty.eco.application

import com.ara.netty.eco.discard.DiscardServerHandler
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

interface Application {
    fun listen(port: Int): Future<ChannelFuture>
}