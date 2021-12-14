package ru.mephi.space.database

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

open class Controller {
    protected val db = KMongo.createClient().coroutine.getDatabase("space-mephi")
}