package ru.mephi.space.models

import org.bson.codecs.pojo.annotations.BsonId

abstract class Model {
    @BsonId
    open var id: String? = null
}