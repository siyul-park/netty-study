package com.ara.netty.eco.application

import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import kotlin.reflect.KClass

data class OptionEntry<T : Any>(
        val option: ChannelOption<T>,
        val value: T,
        val clazz: KClass<T>
)