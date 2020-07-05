package com.ara.netty.eco.application

import io.netty.channel.EventLoopGroup

data class EventGroups(
        val parent: EventLoopGroup,
        val child: EventLoopGroup
)