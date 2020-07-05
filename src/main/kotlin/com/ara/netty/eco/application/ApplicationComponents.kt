
package com.ara.netty.eco.application

import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelOption
import io.netty.channel.ServerChannel
import kotlin.reflect.KClass

interface ApplicationComponents {
    val eventGroups: EventGroups
    val channelClass: KClass<out ServerChannel>
    val childHandler: ChannelHandler

    val options: Collection<OptionEntry<*>>
    val childOptions: Collection<OptionEntry<out Any>>
}